package br.com.alura.forum_hub.domain.curso;

public record DadosDetalhamentoCurso (Long id, String nome, Categoria categoria){

    public DadosDetalhamentoCurso(Curso curso){
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
