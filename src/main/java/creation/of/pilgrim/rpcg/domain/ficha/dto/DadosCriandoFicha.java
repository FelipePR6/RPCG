package creation.of.pilgrim.rpcg.domain.ficha.dto;

import creation.of.pilgrim.rpcg.domain.ficha.Raca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosCriandoFicha(
        @NotNull
        @NotBlank
        String nome,
        @NotNull
        Raca raca,
        @NotNull
        @NotBlank
        String nomeJogador
) {
}
