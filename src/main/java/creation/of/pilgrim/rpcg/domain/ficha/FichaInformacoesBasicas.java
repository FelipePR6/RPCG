package creation.of.pilgrim.rpcg.domain.ficha;

import creation.of.pilgrim.rpcg.domain.ficha.atributosFicha.AtributosFicha;
import creation.of.pilgrim.rpcg.domain.ficha.talentosFicha.TalentosFicha;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosCriandoFicha;
import creation.of.pilgrim.rpcg.domain.ficha.dto.DadosFichaAtualizacao;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "fichas_informacoes_basicas")
@Entity(name = "FichaInformacoesBasicas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class FichaInformacoesBasicas {

    //Sentidos aguçados, sobrevivencia, fluxo de mana
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Raca raca;

    private String nomeJogador;

    private Byte nivel;

    private Integer experiencia;

    private Byte tokens;

    private Byte manaAtual;

    private Byte manaTemporario;

    private Byte vidaAtual;

    private Byte vidaTemporario;


    @OneToMany(mappedBy = "ficha",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Setter
    private List<AtributosFicha> atributosFichas;

    @OneToMany(mappedBy = "ficha",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Setter
    private List<TalentosFicha> talentosFicha;


    public FichaInformacoesBasicas(DadosCriandoFicha dados) {
        this.nome = dados.nome();
        this.raca = dados.raca();
        this.nomeJogador = dados.nomeJogador();
        this.nivel = 1;
        this.experiencia = 0;
        this.tokens = 0;
        this.manaAtual = 0;
        this.manaTemporario = 0;
        this.vidaAtual = 0;
        this.vidaTemporario = 0;
        this.atributosFichas = new ArrayList<>();
        this.talentosFicha = new ArrayList<>();
    }

    public void atualizar(DadosFichaAtualizacao dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();
        if (dados.raca() != null)
            this.raca = dados.raca();
        if (dados.nomeJogador() != null)
            this.nomeJogador = dados.nomeJogador();
        if (dados.nivel() != null)
            this.nivel = dados.nivel();
        if (dados.experiencia() != null)
            this.experiencia = dados.experiencia();
        if (dados.tokens() != null)
            this.tokens = dados.tokens();
        if (dados.manaAtual() != null)
            this.manaAtual = dados.manaAtual();
        if (dados.manaTemporario() != null)
            this.manaTemporario = dados.manaTemporario();
        if (dados.vidaAtual() != null)
            this.vidaAtual = dados.vidaAtual();
        if (dados.vidaTemporario() != null)
            this.vidaTemporario = dados.vidaTemporario();
    }

}
