package creation.of.pilgrim.rpcg.domain.manobra;

public record DadosDetalhamentoManobra(GeneroDeManobras generoDeManobra, String nome, String descricao) {

    public DadosDetalhamentoManobra(Manobra manobra){
        this(manobra.getGeneroDeManobra(), manobra.getNome(), manobra.getDescricao());
    }

}
