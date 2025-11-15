package br.mack.estagios.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.mack.estagios.dao.AreaInteresseDAO;
import br.mack.estagios.model.AreaInteresse;

@RestController
@RequestMapping("/areas")
public class AreaInteresseController {
    @Autowired private AreaInteresseDAO dao;
    @GetMapping public Iterable<AreaInteresse> all(){ return dao.findAll(); }
    @PostMapping public AreaInteresse create(@RequestBody AreaInteresse a){ return dao.save(a); }
    @GetMapping("/{id}") public AreaInteresse get(@PathVariable Long id){ return dao.findById(id).orElse(null); }
    @PutMapping("/{id}") public AreaInteresse update(@PathVariable Long id, @RequestBody AreaInteresse a){ a.setId(id); return dao.save(a);}
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ dao.deleteById(id); }
}