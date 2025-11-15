package br.mack.estagios.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.mack.estagios.dao.EmpresaDAO;
import br.mack.estagios.model.Empresa;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired private EmpresaDAO dao;
    @GetMapping public Iterable<Empresa> all(){ return dao.findAll(); }
    @PostMapping public Empresa create(@RequestBody Empresa e){ return dao.save(e); }
    @GetMapping("/{id}") public Empresa get(@PathVariable Long id){ return dao.findById(id).orElse(null); }
    @PutMapping("/{id}") public Empresa update(@PathVariable Long id, @RequestBody Empresa e){ e.setId(id); return dao.save(e);}
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ dao.deleteById(id); }
}