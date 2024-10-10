package br.com.fiap.gerenciamentodeTrafego.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_EmpresaTerceira")
public class EmpresaTerceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emp_terceira")
    private Integer idEmpTerceira;

    @Column(name = "tp_servico", nullable = false)
    private String tipoServico;

    @Column(name = "nm_empresa", length = 40, nullable = false)
    private String nomeEmpresa;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "resp_tec")
    private String responsavelTecnico;

    @Column(name = "contato", length = 11)
    private String contato;

    @Column(name = "email_abre_chamado", length = 255, nullable = false)
    private String emailAbreChamado;

    // Getters and Setters

    public Integer getIdEmpTerceira() {
        return idEmpTerceira;
    }

    public void setIdEmpTerceira(Integer idEmpTerceira) {
        this.idEmpTerceira = idEmpTerceira;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getResponsavelTecnico() {
        return responsavelTecnico;
    }

    public void setResponsavelTecnico(String responsavelTecnico) {
        this.responsavelTecnico = responsavelTecnico;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmailAbreChamado() {
        return emailAbreChamado;
    }

    public void setEmailAbreChamado(String emailAbreChamado) {
        this.emailAbreChamado = emailAbreChamado;
    }
}