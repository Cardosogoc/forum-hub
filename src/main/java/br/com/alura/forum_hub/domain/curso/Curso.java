package br.com.alura.forum_hub.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "curso")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso (DadosCadastroCurso dados){
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoCurso dados) {
        if (dados.nome() != null){
            this.nome = dados.nome();
        }

        if (dados.categoria() != null){
            this.categoria = dados.categoria();
        }
    }
}
