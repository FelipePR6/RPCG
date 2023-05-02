package creation.of.pilgrim.rpcg.domain.ficha.atributosFicha;

import creation.of.pilgrim.rpcg.domain.ficha.FichaInformacoesBasicas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtributosFichaRepository extends JpaRepository<AtributosFicha, AtributosFichaId> {

    List<AtributosFicha> deleteByFicha(FichaInformacoesBasicas ficha);

}
