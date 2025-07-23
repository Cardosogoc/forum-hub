package br.com.alura.forum_hub.domain.resposta;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record DadosCadastroResposta(

        @NotBlank
        String mensagem,

        @NotNull
        LocalDateTime dataCriacao,

        @NotNull
        Long idAutor,

        @NotNull
        Long idTopico

) {}
