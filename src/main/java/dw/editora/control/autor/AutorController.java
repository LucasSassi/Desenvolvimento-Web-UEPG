package br.edu.uepg.editora.controller;

import br.edu.uepg.editora.entity.Artigo;
import br.edu.uepg.editora.entity.Autor;
import br.edu.uepg.editora.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody Autor autor) {
        Autor novoAutor = autorService.salvar(autor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAutor);
    }

    @GetMapping
    public ResponseEntity<List<Autor>> listarAutores() {
        List<Autor> autores = autorService.buscarTodos();
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
        return autorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/artigos")
    public ResponseEntity<List<Artigo>> listarArtigosDoAutor(@PathVariable Long id) {
        return autorService.buscarPorId(id)
                .map(autor -> ResponseEntity.ok(autor.getArtigos()))
                .orElse(ResponseEntity.notFound().build());
    }
}