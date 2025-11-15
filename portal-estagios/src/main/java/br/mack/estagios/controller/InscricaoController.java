package br.mack.estagios.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.mack.estagios.dao.InscricaoDAO;
import br.mack.estagios.model.Inscricao;

@RestController
@RequestMapping("/inscricoes")
public class InscricaoController {
    @Autowired private InscricaoDAO dao;
    @GetMapping public Iterable<Inscricao> all(){ return dao.findAll(); }
    @PostMapping public Inscricao create(@RequestBody Inscricao i){ return dao.save(i); }
    @GetMapping("/{id}") public Inscricao get(@PathVariable Long id){ return dao.findById(id).orElse(null); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ dao.deleteById(id); }
}