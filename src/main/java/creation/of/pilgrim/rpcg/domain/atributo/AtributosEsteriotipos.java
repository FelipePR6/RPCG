package creation.of.pilgrim.rpcg.domain.atributo;

public enum AtributosEsteriotipos {
    FORCA(1l),
    DESTREZA(2l),
    INTELIGENCIA(3l),
    PERCEPCAO(4l),
    FORCA_DE_VONTADE(5l),
    MAGIA(6l);

    public Long id;

    AtributosEsteriotipos(Long i) {
        id = i;
    }
}
