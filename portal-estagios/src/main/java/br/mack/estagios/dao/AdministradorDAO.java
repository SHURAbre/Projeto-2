package br.mack.estagios.dao;
import org.springframework.data.repository.CrudRepository;
import br.mack.estagios.model.Administrador;

public interface AdministradorDAO extends CrudRepository<Administrador, Long> {}