package br.com.fiap.gerenciamentodeTrafego.Dto;

import br.com.fiap.gerenciamentodeTrafego.model.Semaforo;
import oracle.sql.DATE;
import oracle.sql.Datum;

import java.util.Date;

import static java.util.Calendar.DATE;

public record SemaforoExibeDto(

        Long id,
        String localizacao,
        Date dataUltimoReparo,
        String estadoFisico

) {
    public SemaforoExibeDto(Semaforo semaforo) {
        this(semaforo.getId(), semaforo.getLocalizacao(), semaforo.getDataUltimoReparo(), semaforo.getEstadoFisico());

    }


}