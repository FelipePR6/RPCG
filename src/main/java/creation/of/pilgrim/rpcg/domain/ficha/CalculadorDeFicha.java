package creation.of.pilgrim.rpcg.domain.ficha;

import creation.of.pilgrim.rpcg.domain.atributo.AtributosEsteriotipos;
import creation.of.pilgrim.rpcg.domain.atributo.TipoDeAtributo;
import creation.of.pilgrim.rpcg.domain.ficha.atributosFicha.AtributosFicha;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFicha;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosFichaCompleto;
import lombok.Getter;

import java.util.Objects;

public class CalculadorDeFicha {

    @Getter
    private FichaInformacoesBasicas ficha;

    public CalculadorDeFicha(FichaInformacoesBasicas ficha){
            this.ficha = ficha;
    }

    public DadosFichaCompleto getDadosFichaCompleto(){
        return new DadosFichaCompleto(this);
    }

    private Byte getAtributoById(Long atributoId) {
        var atributoOpcional = ficha.getAtributosFichas().stream()
                .filter(t -> Objects.equals(atributoId, t.getAtributo().getId())).findAny();

        if(atributoOpcional.isEmpty())
            return 0;

        return atributoOpcional.get().getPontos();
    }

    private Byte getSomarAtributosDoTipo(TipoDeAtributo tipoDeAtributo) {
        var somaDosAtributos = ficha.getAtributosFichas().stream()
                .filter(t -> tipoDeAtributo == t.getAtributo().getCor()).mapToInt(AtributosFicha::getPontos).sum();

        return (byte) somaDosAtributos;
    }

    private Byte getBonusPorTalento(Long talentoId, TipoDeAtributo tipoDeAtributo, int somaPorLevelDoAtributo) {
        byte bonusDeTalento = (byte) (talentoAlcancouONivel(talentoId, 1) ?
                (getSomarAtributosDoTipo(tipoDeAtributo)) /2: 0);

        if(bonusDeTalento > 8) bonusDeTalento = 8;

        bonusDeTalento += talentoAlcancouONivel(talentoId, 2) ? somaPorLevelDoAtributo : 0;
        bonusDeTalento += talentoAlcancouONivel(talentoId, 3) ? somaPorLevelDoAtributo : 0;

        return bonusDeTalento;
    }

    private boolean talentoAlcancouONivel(Long talentoId, int nivel) {
        var talentoOpcional = ficha.getTalentosFicha().stream()
                .filter(t -> Objects.equals(talentoId, t.getTalento().getId())).findFirst();

        if(talentoOpcional.isEmpty())
            return false;

        return talentoOpcional.get().getPontos() >= nivel;
    }

    public Byte getNumeroMaximoDeTalentosNoAtributo(Long atributoId){
        int numeroMaximoDeTalentos = (getAtributoById(atributoId) - 1) /2;
        return (byte) numeroMaximoDeTalentos;
    }

    public Byte getNumeroDeTalentosAdquiridosNoAtributo(Long atributoId){
        return (byte) ficha.getTalentosFicha().stream()
                .filter(t -> t.getTalento().getAtributo().getId().equals(atributoId)).count();
    }

    public Byte getPontosDisponiveis(){
        return (byte) (30 + (ficha.getNivel() * 2));
    }

    public Byte getPontosGastos(){
        int pontosGastos = ficha.getAtributosFichas().stream().mapToInt(AtributosFicha::getPontos).sum()
                + ficha.getTalentosFicha().stream().mapToInt(TalentosFicha::getPontos).sum();

        return (byte) pontosGastos;
    }

    public Byte getMovimento() {
        int movimento = ficha.getRaca().getDeslocamento();

        for(int i = 0; i < 4; i++){
            movimento += talentoAlcancouONivel(2L, i)? 1 : 0;
        }

        return (byte) movimento;
    }

    public Byte getManaMaximo() {
        byte bonusDeTalento = getBonusPorTalento(29L, TipoDeAtributo.VERDE, 0);
        return (byte) (getAtributoById(AtributosEsteriotipos.MAGIA.id) * 2 + bonusDeTalento) ;
    }

    public Byte getVidaMaximo() {
        int bonusDeTalento = getBonusPorTalento(5L, TipoDeAtributo.VERMELHO, 4);

        return (byte) ((ficha.getNivel() * 2) + getAtributoById(AtributosEsteriotipos.FORCA.id) + getAtributoById(AtributosEsteriotipos.FORCA_DE_VONTADE.id) + bonusDeTalento);
    }

    public Byte getIniciativa(){
        int bonusDeTalento = getBonusPorTalento(17L, TipoDeAtributo.AZUL, 2);

        return (byte) (getAtributoById(AtributosEsteriotipos.PERCEPCAO.id) + getAtributoById(AtributosEsteriotipos.FORCA_DE_VONTADE.id) + bonusDeTalento);
    }

    public Byte getDanoCorpoACorpo() {
        return (byte) (getAtributoById(AtributosEsteriotipos.FORCA.id) / 4);
    }

    public Byte getDanoLongoAlcance() {
        return (byte) (getAtributoById(AtributosEsteriotipos.PERCEPCAO.id) / 4);
    }

    public Byte getIp() {
        return (byte) (getAtributoById(AtributosEsteriotipos.DESTREZA.id) + (getIniciativa()/2) );
    }


}
