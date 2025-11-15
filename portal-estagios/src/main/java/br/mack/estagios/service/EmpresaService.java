package br.mack.estagios.service;

import br.mack.estagios.dao.EmpresaDAO;
import br.mack.estagios.model.Empresa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaDAO dao;

    public EmpresaService(EmpresaDAO dao) {
        this.dao = dao;
    }

    public List<Empresa> listar() {
        return (List<Empresa>) (List<?>) dao.findAll();
    }

    public Empresa criar(Empresa empresa) {
        return dao.save(empresa);
    }

    public Empresa atualizar(Long id, Empresa nova) {
        return dao.findById(id)
                .map(e -> {
                    e.setNome(nova.getNome());
                    e.setCnpj(nova.getCnpj());
                    e.setEmail(nova.getEmail());
                    e.setTelefone(nova.getTelefone());
                    e.setEndereco(nova.getEndereco());
                    e.setAreas(nova.getAreas());
                    return dao.save(e);
                })
                .orElse(null);
    }

    public void deletar(Long id) {
        dao.deleteById(id);
    }
}