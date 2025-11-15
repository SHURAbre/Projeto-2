package br.mack.estagios.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Estudante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String curso;
    private String email;
    private String telefone;

    @ManyToMany
    private List<AreaInteresse> interesses;

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; } public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; } public void setCpf(String cpf) { this.cpf = cpf; }
    public String getCurso() { return curso; } public void setCurso(String curso) { this.curso = curso; }
    public String getEmail() { return email; } public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; } public void setTelefone(String telefone) { this.telefone = telefone; }
    public List<AreaInteresse> getInteresses() { return interesses; } public void setInteresses(List<AreaInteresse> interesses) { this.interesses = interesses; }
}