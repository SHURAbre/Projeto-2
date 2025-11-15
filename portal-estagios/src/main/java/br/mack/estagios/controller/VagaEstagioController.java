package br.mack.estagios.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.mack.estagios.dao.VagaEstagioDAO;
import br.mack.estagios.model.VagaEstagio;
import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaEstagioController {
    @Autowired private VagaEstagioDAO dao;
    @GetMapping public Iterable<VagaEstagio> all(){ return dao.findAll(); }
    @GetMapping("/abertas") public List<VagaEstagio> abertas(){ return dao.findByEncerradaFalse(); }
    @PostMapping public VagaEstagio create(@RequestBody VagaEstagio v){ return dao.save(v); }
    @PutMapping("/{id}") public VagaEstagio update(@PathVariable Long id, @RequestBody VagaEstagio v){ v.setId(id); return dao.save(v);}
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ dao.deleteById(id); }
    @PutMapping("/{id}/encerrar") public VagaEstagio encerrar(@PathVariable Long id){ var opt = dao.findById(id); if(opt.isPresent()){ VagaEstagio v=opt.get(); v.setEncerrada(true); return dao.save(v);} return null;}
}