package br.mack.estagios.controller;

import br.mack.estagios.dao.AdministradorDAO;
import br.mack.estagios.model.Administrador;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {

    private final AdministradorDAO dao;

    public AdministradorController(AdministradorDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public Iterable<Administrador> listar() {
        return dao.findAll();
    }

    @PostMapping
    public Administrador criar(@RequestBody Administrador adm) {
        return dao.save(adm);
    }
}