package br.mack.estagios.service;

import br.mack.estagios.dao.VagaEstagioDAO;
import br.mack.estagios.model.VagaEstagio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaEstagioService {

    private final VagaEstagioDAO dao;

    public VagaEstagioService(VagaEstagioDAO dao) {
        this.dao = dao;
    }

    public List<VagaEstagio> listar() {
        return (List<VagaEstagio>) (List<?>) dao.findAll();
    }

    public VagaEstagio criar(VagaEstagio v) {
        v.setEncerrada(false);
        return dao.save(v);
    }

    public VagaEstagio atualizar(Long id, VagaEstagio nova) {
        return dao.findById(id)
                .map(v -> {
                    v.setTitulo(nova.getTitulo());
                    v.setDescricao(nova.getDescricao());
                    v.setLocalizacao(nova.getLocalizacao());
                    v.setModalidade(nova.getModalidade());
                    v.setCargaHoraria(nova.getCargaHoraria());
                    v.setRequisitos(nova.getRequisitos());
                    v.setAreas(nova.getAreas());
                    v.setEmpresa(nova.getEmpresa());
                    return dao.save(v);
                })
                .orElse(null);
    }

    public VagaEstagio encerrar(Long id) {
        return dao.findById(id)
                .map(v -> {
                    v.setEncerrada(true);
                    return dao.save(v);
                })
                .orElse(null);
    }

    public void deletar(Long id) {
        dao.deleteById(id);
    }
}