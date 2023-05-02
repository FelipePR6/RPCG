package creation.of.pilgrim.rpcg.domain.ficha;

import creation.of.pilgrim.rpcg.domain.atributo.AtributoRepository;
import creation.of.pilgrim.rpcg.domain.decisoes.DadosDecisoesTalentosFichaAtualizacao;
import creation.of.pilgrim.rpcg.domain.decisoes.OpcoesDecisoes;
import creation.of.pilgrim.rpcg.domain.decisoes.OpcoesDecisoesRepository;
import creation.of.pilgrim.rpcg.domain.ficha.atributosFicha.AtributosFicha;
import creation.of.pilgrim.rpcg.domain.ficha.atributosFicha.AtributosFichaId;
import creation.of.pilgrim.rpcg.domain.ficha.atributosFicha.AtributosFichaRepository;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFicha;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFichaId;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFichaRepository;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosCriandoFicha;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosFichaAtualizacao;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.decisoes.DecisoesTalentosFicha;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.decisoes.DecisoesTalentosFichaRepository;
import creation.of.pilgrim.rpcg.domain.ficha.validacoes.ValidadorDeDecisoesFicha;
import creation.of.pilgrim.rpcg.domain.talento.TalentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConstrutorDeFicha {
    @Autowired
    private FichaRepository fichaRepository;
    @Autowired
    private AtributoRepository atributoRepository;
    @Autowired
    private AtributosFichaRepository atributosFichaRepository;
    @Autowired
    private TalentoRepository talentoRepository;
    @Autowired
    private TalentosFichaRepository talentosFichaRepository;
    @Autowired
    private OpcoesDecisoesRepository opcoesDecisoesRepository;
    @Autowired
    private DecisoesTalentosFichaRepository decisoesTalentosFichaRepository;
    @Autowired
    private List<ValidadorDeDecisoesFicha> validadorDeDecisoesFicha;

    public FichaInformacoesBasicas criarNovaFicha(DadosCriandoFicha dados) {

        FichaInformacoesBasicas ficha = new FichaInformacoesBasicas(dados);
        List<AtributosFicha> atributosFicha = AtributosFicha.getAtritubutosIniciais(ficha, atributoRepository);

        ficha.setAtributosFichas(atributosFicha);
        fichaRepository.save(ficha);
        atributoRepository.saveAll((Iterable) atributosFicha);

        return ficha;
    }


    public FichaInformacoesBasicas atualizarFicha(DadosFichaAtualizacao dados) {
        var ficha = fichaRepository.getReferenceById(dados.id());
        ficha.atualizar(dados);

        atualizandoListaAtributos(dados, ficha);

        atualizandoListaTalentosFicha(dados, ficha);
        fichaRepository.flush();
        return ficha;
    }

    private void atualizandoListaAtributos(DadosFichaAtualizacao dados, FichaInformacoesBasicas ficha) {
        if (dados.atributosFicha() == null)
            return;

        var atributosFicha = dados.atributosFicha().stream().map(a -> atributosFichaRepository.getReferenceById
                        (new AtributosFichaId(ficha.getId(), atributoRepository.findByNome(a.atributo()).getId()))
                .atualizar(a.pontos())).toList();
    }

    public List<TalentosFicha> atualizandoListaTalentosFicha(DadosFichaAtualizacao dados, FichaInformacoesBasicas ficha) {
        if (dados.talentosFicha() == null)
            return null;

        var novosTalentosFicha = dados.talentosFicha().stream().map(t ->
                pegarOuCriarTalentosFicha(ficha, t.talentoId(), t.pontos(), t.decisoes())
        ).toList();

        talentosFichaRepository.flush();

        var talentosASeremDeletados = new ArrayList<>(ficha.getTalentosFicha()).stream()
                .filter(t -> !novosTalentosFicha.contains(t)).toList();

        ficha.getTalentosFicha().removeAll(talentosASeremDeletados);

        validadorDeDecisoesFicha.forEach(v-> v.validar(novosTalentosFicha));

        decisoesTalentosFichaRepository.flush();
        talentosFichaRepository.flush();

        return novosTalentosFicha;
    }

    public TalentosFicha pegarOuCriarTalentosFicha(FichaInformacoesBasicas ficha, Long talentoId, Byte pontos,
                                                   List<DadosDecisoesTalentosFichaAtualizacao> decisoes) {
        var talentoFichaId = new TalentosFichaId(ficha.getId(), talentoId);

        if (talentosFichaRepository.existsById(talentoFichaId)) {
            TalentosFicha talentoFicha = talentosFichaRepository.getReferenceById(talentoFichaId);
            List<DecisoesTalentosFicha> decisoesTalentosFichas = new ArrayList<>();
            if(decisoes != null){
                decisoesTalentosFichas = decisoes.stream().map(
                        t -> new DecisoesTalentosFicha(talentoFicha, opcoesDecisoesRepository.getReferenceById(t.id()))).toList();
            }
            talentoFicha.atualizar(pontos, decisoesTalentosFichas);
        }

        var talentoFicha = new TalentosFicha(ficha, talentoRepository.getReferenceById(talentoId), pontos);

        if(decisoes != null){
            talentoFicha.getDecisoesTalentosFichas().addAll(decisoes.stream().map(
                    t->new DecisoesTalentosFicha(talentoFicha, opcoesDecisoesRepository.getReferenceById(t.id()))).toList());
        }

        talentosFichaRepository.save(talentoFicha);
        decisoesTalentosFichaRepository.saveAll(talentoFicha.getDecisoesTalentosFichas());

        return talentoFicha;
    }

    public void deletarFicha(Long id) {
        if (fichaRepository.existsById(id))
            fichaRepository.deleteById(id);
    }
}
