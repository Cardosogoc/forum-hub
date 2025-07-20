package br.com.alura.forum_hub.domain.curso;

public record DadosListagemCurso (Long id, String nome) {

    public DadosListagemCurso(Curso curso){
        this(curso.getId(), curso.getNome());
    }
}
