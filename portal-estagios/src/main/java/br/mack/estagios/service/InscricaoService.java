package br.mack.estagios.service;

import br.mack.estagios.dao.InscricaoDAO;
import br.mack.estagios.model.Inscricao;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class InscricaoService {

    private final InscricaoDAO dao;

    public InscricaoService(InscricaoDAO dao) {
        this.dao = dao;
    }

    public List<Inscricao> listar() {
        return (List<Inscricao>) dao.findAll();
    }

    public Inscricao inscrever(Inscricao i) {
        i.setDataInscricao(new Date());
        i.setStatus(0); // pendente
        return dao.save(i);
    }

    public Inscricao atualizarStatus(Long id, int status) {
        return dao.findById(id)
                .map(i -> {
                    i.setStatus(status);
                    return dao.save(i);
                })
                .orElse(null);
    }

    public void deletar(Long id) {
        dao.deleteById(id);
    }
}