package br.mack.estagios.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.mack.estagios.dao.EstudanteDAO;
import br.mack.estagios.model.Estudante;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {
    @Autowired private EstudanteDAO dao;
    @GetMapping public Iterable<Estudante> all(){ return dao.findAll(); }
    @PostMapping public Estudante create(@RequestBody Estudante e){ return dao.save(e); }
    @GetMapping("/{id}") public Estudante get(@PathVariable Long id){ return dao.findById(id).orElse(null); }
    @PutMapping("/{id}") public Estudante update(@PathVariable Long id, @RequestBody Estudante e){ e.setId(id); return dao.save(e);}
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ dao.deleteById(id); }
}