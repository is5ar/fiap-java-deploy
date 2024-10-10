package br.com.fiap.gerenciamentodeTrafego.dao;

import br.com.fiap.gerenciamentodeTrafego.model.Semaforo;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class SemaforoDao {

    private EntityManager em;

    public SemaforoDao(EntityManager em) {
    }

    public void SermaforoDao(EntityManager em) {
        this.em = em;
    }

    public  void atualizarStatus (Semaforo semaforo){
        em.merge(semaforo);
    }
    public  void salvar (Semaforo semaforo){
        em.merge(semaforo);
    }


    public List<Semaforo> findAll() {
        return null;
    }

    public Optional<Object> findById(Long id) {
        return null;
    }

    public Semaforo save(Semaforo semaforo) {
    }

    public void deleteById(Long id) {
    }
}
