package br.mack.estagios.service;

import br.mack.estagios.dao.AreaInteresseDAO;
import br.mack.estagios.model.AreaInteresse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaInteresseService {

    private final AreaInteresseDAO dao;

    public AreaInteresseService(AreaInteresseDAO dao) {
        this.dao = dao;
    }

    public List<AreaInteresse> listar() {
        return (List<AreaInteresse>) dao.findAll();
    }

    public AreaInteresse criar(AreaInteresse a) {
        return dao.save(a);
    }

    public AreaInteresse atualizar(Long id, AreaInteresse novo) {
        return dao.findById(id)
                .map(a -> {
                    a.setTitulo(novo.getTitulo());
                    a.setDescricao(novo.getDescricao());
                    return dao.save(a);
                })
                .orElse(null);
    }

    public void deletar(Long id) {
        dao.deleteById(id);
    }
}