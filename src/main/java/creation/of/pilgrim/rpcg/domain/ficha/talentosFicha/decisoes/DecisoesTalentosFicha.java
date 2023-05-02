package creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.decisoes;

import creation.of.pilgrim.rpcg.domain.decisoes.OpcoesDecisoes;
import creation.of.pilgrim.rpcg.domain.decisoes.TipoDecisao;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFicha;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "decisoes_talentos_ficha")
@Entity(name = "DecisoesTalentosFicha")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "decisoesTalentosId")
public class DecisoesTalentosFicha {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    Long id;

    @EmbeddedId
    private DecisoesTalentosId decisoesTalentosId;

    @ManyToOne
    @MapsId("talentosFichaId")
    @JoinColumns({
            @JoinColumn(name = "fichas_informacoes_basicas_id"),
            @JoinColumn(name = "talento_id")
    })
    TalentosFicha talentosFicha;

    @ManyToOne
    @MapsId("opcoesDecisoesId")
    @JoinColumn(name = "opcoes_decisoes_id")
    OpcoesDecisoes opcoesDecisoes;

    public DecisoesTalentosFicha(TalentosFicha talentosFicha, OpcoesDecisoes opcoesDecisoes){
        this.decisoesTalentosId = new DecisoesTalentosId(talentosFicha.getTalentosFichaId(), opcoesDecisoes.getId());
        this.talentosFicha = talentosFicha;
        this.opcoesDecisoes = opcoesDecisoes;
    }
}
