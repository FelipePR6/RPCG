package creation.of.pilgrim.rpcg.domain.ficha.dto;

import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFicha;

import java.util.List;

public record DadosTalentoFicha(Long talentoId, String talento, Byte pontos, List<DadosDecioesTalentosFicha> decisoesTalentosFichas) {

    public DadosTalentoFicha(TalentosFicha talentosFicha){
        this(talentosFicha.getTalento().getId(), talentosFicha.getTalento().getNome(), talentosFicha.getPontos(),
                talentosFicha.getDecisoesTalentosFichas().stream().map(DadosDecioesTalentosFicha::new).toList());
    }

}
