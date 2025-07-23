package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.domain.resposta.DadosCadastroResposta;
import br.com.alura.forum_hub.domain.resposta.Resposta;
import br.com.alura.forum_hub.domain.resposta.RespostaRepository;
import br.com.alura.forum_hub.domain.topico.TopicoRepository;
import br.com.alura.forum_hub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topico/{id}/respostas")
public class RespostaController {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity responder(@PathVariable Long id, @RequestBody @Valid DadosCadastroResposta dados, UriComponentsBuilder uriBuilder) {
        var autor = usuarioRepository.getReferenceById(dados.idAutor());
        var topico = topicoRepository.getReferenceById(id);

        var resposta = new Resposta(null, dados.dataCriacao(), dados.mensagem(), false, autor, topico);
        respostaRepository.save(resposta);

        var uri = uriBuilder.path("/topico/{id}/respostas/{respostaId}").buildAndExpand(id, resposta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}




