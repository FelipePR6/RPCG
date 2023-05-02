package creation.of.pilgrim.rpcg.domain.ficha.dto;

import creation.of.pilgrim.rpcg.domain.ficha.CalculadorDeFicha;
import creation.of.pilgrim.rpcg.domain.ficha.Raca;

import java.util.List;

public record DadosFichaCompleto(
        Long id,
        String nome,
        Raca raca,
        String nomeJogador,
        Byte nivel,
        Byte pontosDisponiveis,
        Byte pontosGastos,
        Integer experiencia,
        Byte ip,
        Byte iniciativa,
        Byte movimento,
        Byte Tokens,
        Byte manaAtual,
        Byte manaMaximo,
        Byte manaTemporario,
        Byte vidaAtual,
        Byte vidaMaximo,
        Byte vidaTemporario,
        List<DadosAtributoFicha> atributosFicha,
        List<DadosTalentoFicha> talentosFicha,
        Byte danoCorpoACorpo,
        Byte danoADistancia
) {

    public DadosFichaCompleto(CalculadorDeFicha fichaCalculada){
        
        this(fichaCalculada.getFicha().getId(),
                fichaCalculada.getFicha().getNome(),
                fichaCalculada.getFicha().getRaca(),
                fichaCalculada.getFicha().getNomeJogador(),
                fichaCalculada.getFicha().getNivel(),
                fichaCalculada.getPontosDisponiveis(),
                fichaCalculada.getPontosGastos(),
                fichaCalculada.getFicha().getExperiencia(),
                fichaCalculada.getIp(),
                fichaCalculada.getIniciativa(),
                fichaCalculada.getMovimento(),
                fichaCalculada.getFicha().getTokens(),
                fichaCalculada.getFicha().getManaAtual(),
                fichaCalculada.getManaMaximo(),
                fichaCalculada.getFicha().getManaTemporario(),
                fichaCalculada.getFicha().getVidaAtual(),
                fichaCalculada.getVidaMaximo(),
                fichaCalculada.getFicha().getVidaTemporario(),
                fichaCalculada.getFicha().getAtributosFichas().stream()
                        .map(t -> new DadosAtributoFicha(
                                t,
                                fichaCalculada.getNumeroDeTalentosAdquiridosNoAtributo(t.getAtributo().getId()),
                                fichaCalculada.getNumeroMaximoDeTalentosNoAtributo(t.getAtributo().getId()) )).toList(),
                fichaCalculada.getFicha().getTalentosFicha().stream().map(DadosTalentoFicha::new).toList(),
                fichaCalculada.getDanoCorpoACorpo(),
                fichaCalculada.getDanoLongoAlcance());
    }

}
