package creation.of.pilgrim.rpcg.controller;

import creation.of.pilgrim.rpcg.domain.ficha.CalculadorDeFicha;
import creation.of.pilgrim.rpcg.domain.ficha.ConstrutorDeFicha;
import creation.of.pilgrim.rpcg.domain.ficha.FichaInformacoesBasicas;
import creation.of.pilgrim.rpcg.domain.ficha.Raca;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosCriandoFicha;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosFichaAtualizacao;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosFichaCompleto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class FichaControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<DadosCriandoFicha> dadosCriandoFichaJson;

    @Autowired
    private JacksonTester<DadosFichaCompleto> dadosFichaCompletoJson;

    @Autowired
    private JacksonTester<DadosFichaAtualizacao> dadosFichaAtualizacaoJson;

    @MockBean
    private ConstrutorDeFicha construtorDeFicha;

    @Test
    @DisplayName("Cria nova ficha de jogador")
    @WithMockUser
    void criarNovaFichaCenario1() throws Exception{

        //Criação das variveis
        var dadosCriandoFicha = new DadosCriandoFicha("Raulyan", Raca.HYLIAN, "Raul Rocha");

        var ficha = new FichaInformacoesBasicas(dadosCriandoFicha);

        var jsonEspertado = dadosFichaCompletoJson.write(new CalculadorDeFicha(ficha).getDadosFichaCompleto()).getJson();

        //Simulação da requisição
        when(construtorDeFicha.criarNovaFicha(any())).thenReturn(ficha);

        var response = mvc.perform(post("/ficha").contentType(MediaType.APPLICATION_JSON)
                .content(dadosCriandoFichaJson.write(dadosCriandoFicha).getJson())).andReturn().getResponse();

        //Assert
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEspertado);
    }

    @Test
    @DisplayName("Atualiza ficha do jogador")
    @WithMockUser
    void atualizarFichaCenario1() throws Exception{

        //Criação das variveis
        var dadosFichaAtualizacao = new DadosFichaAtualizacao(1l, null, null, "Pamela"
                , (byte) 5, null, null, null, null, null
                , null, null, null);

        var ficha = new FichaInformacoesBasicas(new DadosCriandoFicha("Raulyan", Raca.HYLIAN, "Raul Rocha"));
        ficha.atualizar(dadosFichaAtualizacao);

        var jsonEspertado = dadosFichaCompletoJson.write(new CalculadorDeFicha(ficha).getDadosFichaCompleto()).getJson();

        //Simulação da requisição
        when(construtorDeFicha.atualizarFicha(any())).thenReturn(ficha);

        var response = mvc.perform(put("/ficha").contentType(MediaType.APPLICATION_JSON)
                .content(dadosFichaAtualizacaoJson.write(dadosFichaAtualizacao).getJson())).andReturn().getResponse();

        //Assert
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEspertado);
    }

}