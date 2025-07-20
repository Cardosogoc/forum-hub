package br.com.alura.forum_hub.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id, String titulo, LocalDateTime dataCriacao) {

    public DadosListagemTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getDataCriacao());
    }
}
