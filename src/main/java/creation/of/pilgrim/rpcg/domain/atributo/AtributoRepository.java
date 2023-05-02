package creation.of.pilgrim.rpcg.domain.atributo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtributoRepository extends JpaRepository<Atributo, Long> {

    Atributo findByNome(String nome);

}
