package br.mack.estagios.dao;
import org.springframework.data.repository.CrudRepository;
import br.mack.estagios.model.Empresa;

public interface EmpresaDAO extends CrudRepository<Empresa, Long> {}