package creation.of.pilgrim.rpcg.domain.decisoes;

import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.decisoes.DecisoesTalentosFicha;
import jakarta.validation.constraints.NotNull;

public record DadosDecisoesTalentosFichaAtualizacao (@NotNull Long id){

    public DadosDecisoesTalentosFichaAtualizacao(DecisoesTalentosFicha dadosTalentoFicha){
        this(dadosTalentoFicha.getOpcoesDecisoes().getId());
    }

}
