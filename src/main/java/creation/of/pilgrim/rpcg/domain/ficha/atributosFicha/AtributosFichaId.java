package creation.of.pilgrim.rpcg.domain.ficha.atributosFicha;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"fichaId", "atributoId"})
public class AtributosFichaId implements Serializable {

    @Column(name = "fichas_informacoes_basicas_id")
    private Long fichaId;

    @Column(name = "talento_id")
    private Long atributoId;
}
