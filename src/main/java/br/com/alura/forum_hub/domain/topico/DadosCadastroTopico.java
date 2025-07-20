package br.com.alura.forum_hub.domain.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DadosCadastroTopico(
        @NotNull
        Long idAutor,

        @NotNull
        Long idCurso,

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem
) {}
