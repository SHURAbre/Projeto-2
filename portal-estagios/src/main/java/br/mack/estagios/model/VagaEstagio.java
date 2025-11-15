package br.mack.estagios.model;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class VagaEstagio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String localizacao;
    private String modalidade;
    private String cargaHoraria;
    private String requisitos;
    private boolean encerrada = false;

    @ManyToMany
    private List<AreaInteresse> areas;

    @ManyToOne
    private Empresa empresa;

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; } public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; } public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getLocalizacao() { return localizacao; } public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
    public String getModalidade() { return modalidade; } public void setModalidade(String modalidade) { this.modalidade = modalidade; }
    public String getCargaHoraria() { return cargaHoraria; } public void setCargaHoraria(String cargaHoraria) { this.cargaHoraria = cargaHoraria; }
    public String getRequisitos() { return requisitos; } public void setRequisitos(String requisitos) { this.requisitos = requisitos; }
    public boolean isEncerrada() { return encerrada; } public void setEncerrada(boolean encerrada) { this.encerrada = encerrada; }
    public List<AreaInteresse> getAreas() { return areas; } public void setAreas(List<AreaInteresse> areas) { this.areas = areas; }
    public Empresa getEmpresa() { return empresa; } public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
}