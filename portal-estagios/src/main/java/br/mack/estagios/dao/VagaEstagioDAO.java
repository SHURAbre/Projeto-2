package br.mack.estagios.dao;

import org.springframework.data.repository.CrudRepository;
import br.mack.estagios.model.VagaEstagio;
import java.util.List;

public interface VagaEstagioDAO extends CrudRepository<VagaEstagio, Long> {

    List<VagaEstagio> findByEncerradaFalse();

    List<VagaEstagio> findByEncerradaTrue();
}