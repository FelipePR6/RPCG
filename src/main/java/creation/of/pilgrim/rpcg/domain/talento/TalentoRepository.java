package creation.of.pilgrim.rpcg.domain.talento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TalentoRepository extends JpaRepository<Talento, Long> {

    Talento findByNome(String nome);

}
