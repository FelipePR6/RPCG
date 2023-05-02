package creation.of.pilgrim.rpcg.domain.talento;

import creation.of.pilgrim.rpcg.domain.atributo.DadosAtributoDetalhamento;

import java.util.List;

public record DadosTalentoDetalhando(String nome, DadosAtributoDetalhamento atributo, List<DadosNivelDetalhando> niveis) {

    public DadosTalentoDetalhando(Talento talento){
        this(talento.getNome(), new DadosAtributoDetalhamento(talento.getAtributo()),
                talento.getNiveisTalento().stream().map(DadosNivelDetalhando::new).toList());
    }

}
