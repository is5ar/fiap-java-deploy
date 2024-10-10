package model;

import jakarta.persistence.*;
import oracle.sql.DATE;

import java.util.Date;

@Entity
@Table(name = "tbl_Semaforo")
public class Semaforo {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="SEQ_SEMAFORO"
    )
    @SequenceGenerator(
            name = "SEQ_SEMAFORO",
            sequenceName = "SEQ_SEMAFORO",
            allocationSize = 1
    )
    private Long id;
    private String localizacao;

    @Column(name = "data_ultimo_reparo")
    private Date dataUltimoReparo;
    private String estadoFisico;

    //Getter e Setter Id
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Getter e Setter Localização do Semaforo
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    //Getter e Setter Data da ultima Manutenção
    public DATE getDataUltimoReparo(DATE dataUltimoReparo) {
        return dataUltimoReparo;
    }

    public void setDataUltimoReparo(Date dataUltimoReparo) {
        this.dataUltimoReparo = dataUltimoReparo;
    }

    //Geter e Setter Estado da Estrutura Fisica
    public String getEstadoFisico(){
        return estadoFisico;
    }

    public void setEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
    }
}
