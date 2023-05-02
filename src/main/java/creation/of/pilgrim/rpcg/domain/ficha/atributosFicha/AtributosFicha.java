package creation.of.pilgrim.rpcg.domain.ficha.atributosFicha;

import creation.of.pilgrim.rpcg.domain.atributo.Atributo;
import creation.of.pilgrim.rpcg.domain.atributo.AtributoRepository;
import creation.of.pilgrim.rpcg.domain.ficha.FichaInformacoesBasicas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "atributos_ficha")
@Entity(name = "AtributosFicha")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "atributosFichaId")
public class AtributosFicha {

    @EmbeddedId
    private AtributosFichaId atributosFichaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("fichaId")
    @JoinColumn(name = "fichas_informacoes_basicas_id")
    private FichaInformacoesBasicas ficha;

    @ManyToOne
    @MapsId("atributoId")
    @JoinColumn(name = "atributo_id")
    private Atributo atributo;

    private Byte pontos;

    public AtributosFicha(FichaInformacoesBasicas ficha, Atributo atributo, Byte pontos){

        this.ficha = ficha;
        this.atributo = atributo;
        atributosFichaId = new AtributosFichaId(ficha.getId(), atributo.getId());
        this.pontos = pontos;
    }

    public AtributosFicha atualizar(Byte pontos){
        this.pontos = pontos;
        return this;
    }

    public static List<AtributosFicha> getAtritubutosIniciais(FichaInformacoesBasicas ficha, AtributoRepository atributoRepository){
        List<AtributosFicha> atributosFicha = new ArrayList<AtributosFicha>(6);
        atributosFicha.add(new AtributosFicha(ficha, atributoRepository.getReferenceById(1l), (byte) 2));
        atributosFicha.add(new AtributosFicha(ficha, atributoRepository.getReferenceById(2l), (byte) 2));
        atributosFicha.add(new AtributosFicha(ficha, atributoRepository.getReferenceById(3l), (byte) 2));
        atributosFicha.add(new AtributosFicha(ficha, atributoRepository.getReferenceById(4l), (byte) 2));
        atributosFicha.add(new AtributosFicha(ficha, atributoRepository.getReferenceById(5l), (byte) 2));
        atributosFicha.add(new AtributosFicha(ficha, atributoRepository.getReferenceById(6l), (byte) 0));
        return atributosFicha;
    }

}
