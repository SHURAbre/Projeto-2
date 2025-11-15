package br.mack.estagios.model;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Inscricao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataInscricao = new Date();
    private int status = 0;

    @ManyToOne
    private VagaEstagio vaga;

    @ManyToOne
    private Estudante estudante;

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public Date getDataInscricao() { return dataInscricao; } public void setDataInscricao(Date dataInscricao) { this.dataInscricao = dataInscricao; }
    public int getStatus() { return status; } public void setStatus(int status) { this.status = status; }
    public VagaEstagio getVaga() { return vaga; } public void setVaga(VagaEstagio vaga) { this.vaga = vaga; }
    public Estudante getEstudante() { return estudante; } public void setEstudante(Estudante estudante) { this.estudante = estudante; }
}