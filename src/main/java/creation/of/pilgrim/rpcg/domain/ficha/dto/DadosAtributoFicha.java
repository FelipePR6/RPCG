package creation.of.pilgrim.rpcg.domain.ficha.dto;

import creation.of.pilgrim.rpcg.domain.ficha.atributosFicha.AtributosFicha;

public record DadosAtributoFicha(String atributo, Byte pontos, Byte talentosAdquiridos, Byte talentosMaximos) {

    public DadosAtributoFicha(AtributosFicha atributosFicha, Byte talentosAdquiridos, Byte talentosMaximos){
        this(atributosFicha.getAtributo().getNome(), atributosFicha.getPontos(), talentosAdquiridos, talentosMaximos);
    }

    public DadosAtributoFicha(AtributosFicha atributosFicha){
        this(atributosFicha.getAtributo().getNome(), atributosFicha.getPontos(), null, null);
    }
}
