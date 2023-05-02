package creation.of.pilgrim.rpcg.domain.ficha;

public enum  Raca {
    HYLIAN{
        @Override
        public Byte getDeslocamento() {
            return 5;
        }
    };

    public abstract Byte getDeslocamento();
}
