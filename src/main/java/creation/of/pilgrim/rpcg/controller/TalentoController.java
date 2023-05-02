package creation.of.pilgrim.rpcg.controller;

import creation.of.pilgrim.rpcg.domain.talento.DadosTalentoDetalhando;
import creation.of.pilgrim.rpcg.domain.talento.TalentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/talentos")
public class TalentoController {


    @Autowired
    private TalentoRepository talentoRepository;

    @GetMapping
    public ResponseEntity<Collection<DadosTalentoDetalhando>> listar(){

        List<DadosTalentoDetalhando> talentos = talentoRepository.findAll().stream().map(DadosTalentoDetalhando:: new).toList();

        return ResponseEntity.ok(talentos);
    }

}
