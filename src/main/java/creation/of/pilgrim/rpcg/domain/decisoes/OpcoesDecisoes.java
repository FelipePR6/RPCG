package creation.of.pilgrim.rpcg.domain.decisoes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "opcoes_decisoes")
@Entity(name = "OpcoesDecisoes")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class OpcoesDecisoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "tipo_de_decisao_id")
    TipoDecisao tipoDecisao;

    @Column(name = "decisao")
    String decisaoTexto;
}
