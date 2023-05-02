package creation.of.pilgrim.rpcg;

import creation.of.pilgrim.rpcg.domain.talento.DadosTalentoDetalhando;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class RpcgApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpcgApplication.class, args);
	}

}
