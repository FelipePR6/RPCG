package creation.of.pilgrim.rpcg.domain.talento;

import creation.of.pilgrim.rpcg.domain.atributo.Atributo;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFicha;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "talentos")
@Entity(name = "Talento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Talento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "atributo_id")
    private Atributo atributo;

    @OneToMany(mappedBy = "talento")
    private List<NivelTalento> niveisTalento;

    @OneToMany(
            mappedBy = "talento",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TalentosFicha> talentosFicha;

}
