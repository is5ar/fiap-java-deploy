package br.com.fiap.gerenciamentodeTrafego;

import br.com.fiap.gerenciamentodeTrafego.model.EmpresaTerceira;
import br.com.fiap.gerenciamentodeTrafego.dao.EmpresaTerceiraDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaTerceiraService {

    @Autowired
    private EmpresaTerceiraDao empresaTerceiraDao;

    private EntityManager em;

    public EmpresaTerceiraService(EmpresaTerceiraDao empresaTerceiraDao) {
        this.empresaTerceiraDao = empresaTerceiraDao;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gerenciamento");
        em = emf.createEntityManager();
    }

    public List<EmpresaTerceira> getAllEmpresasTerceiras() {
        return empresaTerceiraDao.findAll();
    }

    public EmpresaTerceira getEmpresaTerceiraById(Long id) {
        return empresaTerceiraDao.findById(id).orElse(null);
    }

    public EmpresaTerceira createEmpresaTerceira(EmpresaTerceira empresaTerceira) {
        beginTransation();
        EmpresaTerceira savedEmpresaTerceira = empresaTerceiraDao.save(empresaTerceira);
        commitTransation();
        return savedEmpresaTerceira;
    }

    public EmpresaTerceira updateEmpresaTerceira(EmpresaTerceira empresaTerceira) {
        beginTransation();
        EmpresaTerceira updatedEmpresaTerceira = empresaTerceiraDao.save(empresaTerceira);
        commitTransation();
        return updatedEmpresaTerceira;
    }

    public void deleteEmpresaTerceira(Long id) {
        beginTransation();
        empresaTerceiraDao.deleteById(id);
        commitTransation();
    }

    private void beginTransation() {
        em.getTransaction().begin();
    }

    private void commitTransation() {
        em.getTransaction().commit();
    }
}