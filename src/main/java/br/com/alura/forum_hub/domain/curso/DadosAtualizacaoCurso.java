package br.com.alura.forum_hub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCurso(
        @NotNull
        Long id,
        String nome,
        Categoria categoria) {
}
