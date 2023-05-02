package creation.of.pilgrim.rpcg.domain.ficha;

import creation.of.pilgrim.rpcg.domain.atributo.Atributo;
import creation.of.pilgrim.rpcg.domain.atributo.AtributoRepository;
import creation.of.pilgrim.rpcg.domain.ficha.atributosFicha.AtributosFicha;
import creation.of.pilgrim.rpcg.domain.ficha.atributosFicha.AtributosFichaId;
import creation.of.pilgrim.rpcg.domain.ficha.atributosFicha.AtributosFichaRepository;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFicha;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFichaId;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFichaRepository;
import creation.of.pilgrim.rpcg.domain.ficha.dto.*;
import creation.of.pilgrim.rpcg.domain.talento.Talento;
import creation.of.pilgrim.rpcg.domain.talento.TalentoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConstrutorDeFichaTest {

    @MockBean
    private FichaRepository fichaRepository;

    @MockBean
    private AtributosFichaRepository atributosFichaRepository;

    @MockBean
    private AtributoRepository atributoRepository;

    @MockBean
    private TalentoRepository talentoRepository;

    @MockBean
    private TalentosFichaRepository talentosFichaRepository;

    @Autowired
    private ConstrutorDeFicha construtorDeFicha;

    @Test
    @DisplayName("Atualiza ficha mudando valores de atributos")
    @WithMockUser
    void atualizarFichaCenario1() {

        //Criação de variaveis
        var dadosDeCriacaoDeFicha = new DadosCriandoFicha("Felyan", Raca.HYLIAN,"Felipe");
        var fichaAntiga = new FichaInformacoesBasicas(dadosDeCriacaoDeFicha);
        fichaAntiga.setAtributosFichas(criaAtributosFichaLevelMinimo(fichaAntiga));
        var atributosAtulizados = criaAtributosFichaLevel5(fichaAntiga);

        var dadosAtualizacao = new DadosFichaAtualizacao(1l, "Farofa", null, null,
                (byte) 5,null,null,null, (byte) 3, null, (byte) 5,
                atributosAtulizados.stream().map(DadosAtributoFicha::new).toList(), null);

        var ficha = new FichaInformacoesBasicas(dadosDeCriacaoDeFicha);
        ficha.atualizar(dadosAtualizacao);
        ficha.setAtributosFichas(atributosAtulizados);

        //Configurando eventos e chamando ação
        when(fichaRepository.getReferenceById(any())).thenReturn(fichaAntiga);

        when(atributoRepository.findByNome(anyString())).then(
                (Answer<Atributo>) invocationOnMock -> atributosAtulizados.stream()
                        .filter(a -> a.getAtributo().getNome() == invocationOnMock.getArgument(0))
                        .findFirst().get().getAtributo()
        );

        when(atributosFichaRepository.getReferenceById(any())).then(
                (Answer<AtributosFicha>) invocationOnMock -> atributosAtulizados.stream()
                        .filter(a ->  a.getAtributosFichaId().equals((AtributosFichaId) invocationOnMock.getArgument(0)))
                        .findFirst().get()
        );

        var fichaAtualizado = construtorDeFicha.atualizarFicha(dadosAtualizacao);

        //Checando todas as variaveis
        assertThat(fichaAtualizado).isEqualTo(ficha);
        assertThat(fichaAtualizado.getNome()).isEqualTo(ficha.getNome());
        assertThat(fichaAtualizado.getRaca()).isEqualTo(ficha.getRaca());
        assertThat(fichaAtualizado.getNomeJogador()).isEqualTo(ficha.getNomeJogador());
        assertThat(fichaAtualizado.getNivel()).isEqualTo(ficha.getNivel());
        assertThat(fichaAtualizado.getManaTemporario()).isEqualTo(ficha.getManaTemporario());
        assertThat(fichaAtualizado.getVidaTemporario()).isEqualTo(ficha.getVidaTemporario());
        assertThat(fichaAtualizado.getAtributosFichas()).isEqualTo(ficha.getAtributosFichas());
    }

    @Test
    @DisplayName("Cria talentos que ainda não estão na ficha e remove os que não são mais atualizados")
    @WithMockUser
    void atualizandoTalentosCenario1() {

        //Criação de variaveis
        var dadosDeCriacaoDeFicha = new DadosCriandoFicha("Felyan", Raca.HYLIAN,"Felipe");
        var fichaAntiga = new FichaInformacoesBasicas(dadosDeCriacaoDeFicha);
        fichaAntiga.setAtributosFichas(criaAtributosFichaLevelMinimo(fichaAntiga));
        fichaAntiga.setTalentosFicha(criaTalentosFichaAntiga(fichaAntiga));

        var talentosAtulizados = criaTalentosFichaNova(fichaAntiga);

        var dadosAtualizacao = new DadosFichaAtualizacao(1l, "Farofa", null, null,
                (byte) 5,null,null,null, (byte) 3, null, (byte) 5,
                null, talentosAtulizados.stream().map(DadosTalentoFichaAtualizacao::new).toList());

        var ficha = new FichaInformacoesBasicas(dadosDeCriacaoDeFicha);
        ficha.atualizar(dadosAtualizacao);
        ficha.setTalentosFicha(talentosAtulizados);

        //Configurando eventos e chamando ação
        when(fichaRepository.getReferenceById(any())).thenReturn(fichaAntiga);

        when(talentoRepository.getReferenceById(anyLong())).then(
                (Answer<Talento>) invocationOnMock -> talentosAtulizados.stream()
                        .filter(t -> t.getTalento().getId().equals((Long) invocationOnMock.getArgument(0)))
                        .findFirst().get().getTalento()
        );

        when(talentosFichaRepository.existsById(any())).then(
                (Answer<Boolean>) invocationOnMock -> talentosAtulizados.stream()
                        .filter(t -> t.getTalentosFichaId().equals((TalentosFichaId) invocationOnMock.getArgument(0)))
                        .toList().isEmpty()
        );

        when(talentosFichaRepository.getReferenceById(any())).then(
                (Answer<TalentosFicha>) invocationOnMock -> talentosAtulizados.stream()
                        .filter(t -> t.getTalentosFichaId().equals((TalentosFichaId) invocationOnMock.getArgument(0)))
                        .findFirst().get()
        );

        when(talentosFichaRepository.save(any())).thenReturn(null);

        var talentosRetornado = construtorDeFicha.atualizandoListaTalentosFicha(dadosAtualizacao, fichaAntiga);

        //Checando todas as variaveis
        assertThat(ficha.getTalentosFicha()).containsAll(fichaAntiga.getTalentosFicha());
        assertThat(talentosRetornado).isEqualTo(ficha.getTalentosFicha());
    }

    private List<AtributosFicha> criaAtributosFichaLevel5(FichaInformacoesBasicas ficha){
        List<AtributosFicha> atributosFicha = new ArrayList<>();
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(1l, "Força"), (byte) 5));
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(2l, "Destreza"), (byte) 5));
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(3l, "Inteligência"), (byte) 5));
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(4l, "Percepção"), (byte) 5));
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(5l, "Força de Vontade"), (byte) 5));
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(6l, "Magia"), (byte) 5));

        return atributosFicha;
    }

    private List<AtributosFicha> criaAtributosFichaLevelMinimo(FichaInformacoesBasicas ficha){
        List<AtributosFicha> atributosFicha = new ArrayList<>();
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(1l, "Força"), (byte) 2));
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(2l, "Dextreza"), (byte) 2));
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(3l, "Inteligencia"), (byte) 2));
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(4l, "Percepção"), (byte) 2));
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(5l, "Força de Vontade"), (byte) 2));
        atributosFicha.add(new AtributosFicha(ficha, new Atributo(6l, "Magia"), (byte) 0));

        return atributosFicha;
    }

    private List<TalentosFicha> criaTalentosFichaAntiga(FichaInformacoesBasicas ficha){
        List<TalentosFicha> atributosFicha = new ArrayList<>();
        atributosFicha.add(new TalentosFicha(ficha, new Talento(1l, "Atletismo",null, null, null), (byte) 1, null));
        atributosFicha.add(new TalentosFicha(ficha, new Talento(2l, "Mobilidade",null, null, null), (byte) 1, null));


        return atributosFicha;
    }

    private List<TalentosFicha> criaTalentosFichaNova(FichaInformacoesBasicas ficha){
        List<TalentosFicha> atributosFicha = new ArrayList<>();
        atributosFicha.add(new TalentosFicha(ficha, new Talento(1l, "Atletismo",null, null, null), (byte) 1, null));
        atributosFicha.add(new TalentosFicha(ficha, new Talento(10l, "Furtividade",null, null, null), (byte) 2, null));
        atributosFicha.add(new TalentosFicha(ficha, new Talento(11l, "Arcano",null, null, null), (byte) 2, null));
        atributosFicha.add(new TalentosFicha(ficha, new Talento(15l, "Sobrevivência",null, null, null), (byte) 1, null));
        atributosFicha.add(new TalentosFicha(ficha, new Talento(16l, "Percepção",null, null, null), (byte) 3, null));

        return atributosFicha;
    }
}