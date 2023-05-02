package creation.of.pilgrim.rpcg.domain.ficha.dto;

import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.decisoes.DecisoesTalentosFicha;

public record DadosDecioesTalentosFicha(String decisao) {

    DadosDecioesTalentosFicha(DecisoesTalentosFicha decisoesTalentosFicha){
        this(decisoesTalentosFicha.getOpcoesDecisoes().getDecisaoTexto());
    }

}
