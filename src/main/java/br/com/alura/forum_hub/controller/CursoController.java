package br.com.alura.forum_hub.controller;

import br.com.alura.forum_hub.domain.curso.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCurso dados, UriComponentsBuilder uriBuilder){
        var curso = new Curso(dados);
        repository.save(curso);

        var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCurso>> listar(@PageableDefault(size = 10)Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemCurso::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity datalhar(@PathVariable Long id){
        var curso = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }

    @PutMapping
    @Transactional
    public ResponseEntity editar(@RequestBody @Valid DadosAtualizacaoCurso dados){
        var curso = repository.getReferenceById(dados.id());
        curso.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        var curso = repository.getReferenceById(id);
        repository.delete(curso);

        return ResponseEntity.noContent().build();
    }


}
