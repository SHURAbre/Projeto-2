package br.mack.estagios.service;

import br.mack.estagios.dao.EstudanteDAO;
import br.mack.estagios.model.Estudante;
import org.springframework.stereotype.Service;

@Service
public class EstudanteService {

    private final EstudanteDAO dao;

    public EstudanteService(EstudanteDAO dao) {
        this.dao = dao;
    }

    public Estudante salvar(Estudante e) {
        return dao.save(e);
    }

    public long count() {
        return dao.count();
    }
}