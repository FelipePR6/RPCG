package creation.of.pilgrim.rpcg.domain.manobra;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "manobras")
@Entity(name = "Manobra")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Manobra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private GeneroDeManobras generoDeManobra;

    private String descricao;

    private String urlImagem;

}
