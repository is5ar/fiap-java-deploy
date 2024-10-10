package br.com.fiap.gerenciamentodeTrafego;


import br.com.fiap.gerenciamentodeTrafego.dao.SemaforoDao;
import br.com.fiap.gerenciamentodeTrafego.model.EmpresaTerceira;
import br.com.fiap.gerenciamentodeTrafego.model.Semaforo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemaforoService {

    @Autowired
    private SemaforoDao semaforoDao;

    private EntityManager em;

    public SemaforoService(SemaforoDao semaforoDao) {
        this.semaforoDao = semaforoDao;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gerenciamento");
        em = emf.createEntityManager();
    }

    public List<Semaforo> getAllSemaforos() {
        return semaforoDao.findAll();
    }

    public Semaforo getSemaforoById(Long id) {
        return (Semaforo) semaforoDao.findById(id).orElse(null);
    }

    public Semaforo createSemaforo(Semaforo semaforo) {
        beginTransation();
        Semaforo savedSemaforo = semaforoDao.save(semaforo);
        commitTransation();
        return savedSemaforo;
    }

    public Semaforo updateSemaforo(Semaforo semaforo) {
        beginTransation();
        Semaforo updatedSemaforo = semaforoDao.save(semaforo);
        commitTransation();
        return updatedSemaforo;
    }

    public void deleteSemaforo(Long id) {
        beginTransation();
        semaforoDao.deleteById(id);
        commitTransation();
    }

    public void ajustarTempoCicloVerde(Long id, int novoTempo) {
        beginTransation();
        Semaforo semaforo = (Semaforo) semaforoDao.findById(id).orElse(null);
        if (semaforo != null) {
            semaforo.setTempoCicloVerde(novoTempo);
            semaforoDao.save(semaforo);
        }
        commitTransation();
    }

    public void ajustarTempoCicloVermelho(Long id, int novoTempo) {
        beginTransation();
        Semaforo semaforo = (Semaforo) semaforoDao.findById(id).orElse(null);
        if (semaforo != null) {
            semaforo.setTempoCicloVermelho(novoTempo);
            semaforoDao.save(semaforo);
        }
        commitTransation();
    }

    private void beginTransation() {
        em.getTransaction().begin();
    }

    private void commitTransation() {
        em.getTransaction().commit();
    }
    @Service
    public static class EmpresaTerceiraService {

        @Autowired
        private EmpresaTerceiraRepository empresaTerceiraRepository;

        public EmpresaTerceira saveEmpresaTerceira(EmpresaTerceira empresaTerceira) {
            return empresaTerceiraRepository.save(empresaTerceira);
        }

        public List<EmpresaTerceira> getAllEmpresasTerceiras() {
            return empresaTerceiraRepository.findAll();
        }

        public EmpresaTerceira getEmpresaTerceiraById(Integer id) {
            Optional<EmpresaTerceira> empresaTerceira = empresaTerceiraRepository.findById(id);
            return empresaTerceira.orElse(null);
        }

        public void deleteEmpresaTerceira(Integer id) {
            empresaTerceiraRepository.deleteById(id);
        }
    }
}