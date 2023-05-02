package creation.of.pilgrim.rpcg.domain.ficha.talentosFicha;

import creation.of.pilgrim.rpcg.domain.ficha.FichaInformacoesBasicas;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.decisoes.DecisoesTalentosFicha;
import creation.of.pilgrim.rpcg.domain.talento.Talento;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "talentos_ficha")
@Entity(name = "TalentosFicha")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "talentosFichaId")
public class TalentosFicha {

    @EmbeddedId
    private TalentosFichaId talentosFichaId;

    @ManyToOne
    @MapsId("fichaId")
    @JoinColumn(name = "fichas_informacoes_basicas_id")
    private FichaInformacoesBasicas ficha;

    @ManyToOne
    @MapsId("talentoId")
    @JoinColumn(name = "talento_id")
    private Talento talento;

    @OneToMany(mappedBy = "talentosFicha",
            cascade = CascadeType.ALL,
             orphanRemoval = true
    )
    @Setter
    private List<DecisoesTalentosFicha> decisoesTalentosFichas;

    private Byte pontos;

    public TalentosFicha(FichaInformacoesBasicas ficha, Talento talento, Byte pontos){

        this.ficha = ficha;
        this.talento = talento;
        talentosFichaId = new TalentosFichaId(ficha.getId(), talento.getId());
        this.pontos = pontos;
        decisoesTalentosFichas = new ArrayList<>();
    }

    public TalentosFicha atualizar(Byte pontos, List<DecisoesTalentosFicha> decisoesTalentosFichas) {
        this.pontos = pontos;
        this.decisoesTalentosFichas.clear();
        removerDecisoesPassadas(decisoesTalentosFichas);
        return this;
    }

    public void removerDecisoesPassadas(List<DecisoesTalentosFicha> novasDecisoesTalentosFichas){
        var decisoesASeremDeletados = new ArrayList<>(decisoesTalentosFichas).stream()
                .filter(d -> !novasDecisoesTalentosFichas.contains(d)).toList();

        this.decisoesTalentosFichas.removeAll(decisoesASeremDeletados);
    }
}
