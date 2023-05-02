package creation.of.pilgrim.rpcg.domain.atributo;

import creation.of.pilgrim.rpcg.domain.talento.Talento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "atributos")
@Entity(name = "Atributo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Atributo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private String iconeImagem;

    @Enumerated(EnumType.STRING)
    private TipoDeAtributo cor;

    @OneToMany(mappedBy = "atributo")
    private List<Talento> talentos;

    public Atributo(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }

}
