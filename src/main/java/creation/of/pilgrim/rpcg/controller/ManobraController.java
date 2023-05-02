package creation.of.pilgrim.rpcg.controller;

import creation.of.pilgrim.rpcg.domain.manobra.ManobraRepository;
import creation.of.pilgrim.rpcg.domain.manobra.DadosDetalhamentoManobra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/manobras")
public class ManobraController {

    @Autowired
    private ManobraRepository manobraRepository;

    @GetMapping
    public ResponseEntity<Collection<DadosDetalhamentoManobra>> listar(){

        var caminhos = manobraRepository.findAll().stream().map(DadosDetalhamentoManobra::new).toList();

        return ResponseEntity.ok(caminhos);
    }

}
