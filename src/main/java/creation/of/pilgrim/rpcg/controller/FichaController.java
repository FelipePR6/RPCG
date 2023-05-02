package creation.of.pilgrim.rpcg.controller;

import creation.of.pilgrim.rpcg.domain.ficha.CalculadorDeFicha;
import creation.of.pilgrim.rpcg.domain.ficha.ConstrutorDeFicha;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosCriandoFicha;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosFichaAtualizacao;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosFichaCompleto;
import creation.of.pilgrim.rpcg.domain.ficha.FichaRepository;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosFichaListagem;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/ficha")
public class FichaController {

    @Autowired
    private FichaRepository fichaRepository;

    @Autowired
    private ConstrutorDeFicha construtorDeFicha;

    @GetMapping
    public ResponseEntity<Collection<DadosFichaListagem>> listar(){

        List<DadosFichaListagem> fichas = fichaRepository.findAll().stream().map(DadosFichaListagem:: new).toList();

        return ResponseEntity.ok(fichas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosFichaCompleto> abrir(@PathVariable Long id){
        var ficha = fichaRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosFichaCompleto(new CalculadorDeFicha(ficha)));
    }

    @PostMapping
    @Transactional
    public ResponseEntity criarNovaFicha(@RequestBody @Valid DadosCriandoFicha dados, UriComponentsBuilder uriBuilder){

        var ficha = (construtorDeFicha.criarNovaFicha(dados));

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(ficha.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosFichaCompleto(new CalculadorDeFicha(ficha)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarFicha(@RequestBody @Valid DadosFichaAtualizacao dados) {
        var ficha =  construtorDeFicha.atualizarFicha(dados);
        return ResponseEntity.ok(new DadosFichaCompleto(new CalculadorDeFicha(ficha)));
    }

    @DeleteMapping("/{id}")
    @Transactional()
    public ResponseEntity deletarFicha(@PathVariable Long id){
        construtorDeFicha.deletarFicha(id);
        return ResponseEntity.noContent().build();
    }

}
