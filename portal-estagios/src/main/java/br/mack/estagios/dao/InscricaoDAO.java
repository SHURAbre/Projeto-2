package br.mack.estagios.dao;
import org.springframework.data.repository.CrudRepository;
import br.mack.estagios.model.Inscricao;
import java.util.List;

public interface InscricaoDAO extends CrudRepository<Inscricao, Long> {
    List<Inscricao> findByVagaId(Long vagaId);
    List<Inscricao> findByEstudanteId(Long estudanteId);
}