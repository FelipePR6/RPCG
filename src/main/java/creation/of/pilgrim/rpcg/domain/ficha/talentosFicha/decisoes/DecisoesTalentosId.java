package creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.decisoes;

import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFichaId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"talentosFichaId", "opcoesDecisoesId"})
public class DecisoesTalentosId implements Serializable {


    @JoinColumns({
            @JoinColumn(name = "fichas_informacoes_basicas_id"),
            @JoinColumn(name = "talento_id")
    })
    private TalentosFichaId talentosFichaId;

    @JoinColumn(name = "opcoes_decisoes_id")
    private Long opcoesDecisoesId;
}
