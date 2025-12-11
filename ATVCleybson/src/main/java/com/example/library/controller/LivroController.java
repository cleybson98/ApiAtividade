package com.example.library.controller;

import com.example.library.model.Livro;
import com.example.library.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
    private final LivroRepository repo;
    public LivroController(LivroRepository repo){ this.repo = repo; }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro l){
        Livro saved = repo.save(l);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping
    public List<Livro> all(){ return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> one(@PathVariable Long id){
        return repo.findById(id).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro d){
        return repo.findById(id).map(l->{
            l.setTitulo(d.getTitulo());
            l.setAutor(d.getAutor());
            l.setIsbn(d.getIsbn());
            l.setAnoPublicacao(d.getAnoPublicacao());
            l.setDisponivel(d.isDisponivel());
            Livro updated = repo.save(l);
            return ResponseEntity.ok(updated);
        }).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return repo.findById(id).map(l->{
            repo.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElseGet(()->ResponseEntity.notFound().build());
    }
}
