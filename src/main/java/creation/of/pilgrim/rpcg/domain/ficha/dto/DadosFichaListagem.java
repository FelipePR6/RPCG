package creation.of.pilgrim.rpcg.domain.ficha.dto;

import creation.of.pilgrim.rpcg.domain.ficha.FichaInformacoesBasicas;

public record DadosFichaListagem(String nome, Byte nivel, String nomeJogador) {

    public DadosFichaListagem(FichaInformacoesBasicas ficha){
        this(ficha.getNome(), ficha.getNivel(), ficha.getNomeJogador());
    }

}
