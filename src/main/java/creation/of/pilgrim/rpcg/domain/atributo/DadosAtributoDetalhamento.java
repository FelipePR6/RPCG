package creation.of.pilgrim.rpcg.domain.atributo;

public record DadosAtributoDetalhamento(
        Long id,
        String nome,
        TipoDeAtributo tipoDeTalento) {

    public DadosAtributoDetalhamento(Atributo atributo){ this(atributo.getId(), atributo.getNome(), atributo.getCor());}
}
