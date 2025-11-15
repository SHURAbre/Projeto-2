package br.mack.estagios.service;

import br.mack.estagios.dao.EmpresaDAO;
import br.mack.estagios.dao.EstudanteDAO;
import br.mack.estagios.dao.VagaEstagioDAO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

    private final EmpresaDAO empresaDAO;
    private final EstudanteDAO estudanteDAO;
    private final VagaEstagioDAO vagaDAO;

    public DashboardService(EmpresaDAO empresaDAO, EstudanteDAO estudanteDAO, VagaEstagioDAO vagaDAO) {
        this.empresaDAO = empresaDAO;
        this.estudanteDAO = estudanteDAO;
        this.vagaDAO = vagaDAO;
    }

    public Map<String, Object> dados() {

        long abertas = vagaDAO.findByEncerradaFalse().size();
        long encerradas = vagaDAO.findByEncerradaTrue().size();

        Map<String, Object> map = new HashMap<>();
        map.put("empresas", empresaDAO.count());
        map.put("estudantes", estudanteDAO.count());
        map.put("vagasAbertas", abertas);
        map.put("vagasEncerradas", encerradas);

        return map;
    }
}