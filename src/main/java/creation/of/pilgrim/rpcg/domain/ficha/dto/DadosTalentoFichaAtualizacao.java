package creation.of.pilgrim.rpcg.domain.ficha.dto;

import creation.of.pilgrim.rpcg.domain.decisoes.DadosDecisoesTalentosFichaAtualizacao;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFicha;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DadosTalentoFichaAtualizacao(@NotNull Long talentoId, Byte pontos, List<DadosDecisoesTalentosFichaAtualizacao> decisoes) {

    public DadosTalentoFichaAtualizacao(TalentosFicha talentosFicha){
        this(talentosFicha.getTalento().getId(), talentosFicha.getPontos(),
                talentosFicha.getDecisoesTalentosFichas().stream().map(DadosDecisoesTalentosFichaAtualizacao::new).toList());
    }

}
