package creation.of.pilgrim.rpcg.domain.talento;

import creation.of.pilgrim.rpcg.domain.decisoes.TipoDeDecisoes;

public record DadosNivelDetalhando(Byte nivel, String descricao, TipoDeDecisoes tipoDeDecisoes) {

    public DadosNivelDetalhando(NivelTalento nivelTalento){
        this(nivelTalento.getNivel(), nivelTalento.getDescricao(), nivelTalento.getTipoDeDecisao());

    }

}
