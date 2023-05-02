package creation.of.pilgrim.rpcg.domain.ficha.dto;

import creation.of.pilgrim.rpcg.domain.ficha.Raca;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosFichaAtualizacao(
        @NotNull
        Long id,
        String nome,
        Raca raca,
        String nomeJogador,
        Byte nivel,
        Integer experiencia,
        Byte tokens,
        Byte manaAtual,
        Byte manaTemporario,
        Byte vidaAtual,
        Byte vidaTemporario,
        List<DadosAtributoFicha> atributosFicha,
        List<DadosTalentoFichaAtualizacao> talentosFicha
) {
}
