package creation.of.pilgrim.rpcg.domain.talento;

import creation.of.pilgrim.rpcg.domain.decisoes.TipoDeDecisoes;
import creation.of.pilgrim.rpcg.domain.decisoes.TipoDecisao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "nivel_talento")
@Entity(name = "NivelTalento")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class NivelTalento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Byte nivel;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "tipo_de_decisao")
    private TipoDecisao tipoDecisao;

    @ManyToOne
    @JoinColumn(name = "talento_id")
    private Talento talento;

    public TipoDeDecisoes getTipoDeDecisao(){
        if(tipoDecisao == null)
            return null;

        return tipoDecisao.getTipoDeDecisao();
    }

}
