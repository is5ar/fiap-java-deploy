package br.com.fiap.gerenciamentodeTrafego.dao;

import br.com.fiap.gerenciamentodeTrafego.model.EmpresaTerceira;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmpresaTerceiraDao {

    private final EntityManager entityManager;

    public EmpresaTerceiraDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(EmpresaTerceira empresaTerceira) {
        entityManager.getTransaction().begin();
        entityManager.persist(empresaTerceira);
        entityManager.getTransaction().commit();
    }

    public void atualizar(EmpresaTerceira empresaTerceira) {
        entityManager.getTransaction().begin();
        entityManager.merge(empresaTerceira);
        entityManager.getTransaction().commit();
    }

    public EmpresaTerceira buscarPorId(Integer id) {
        return entityManager.find(EmpresaTerceira.class, id);
    }

    public void remover(EmpresaTerceira empresaTerceira) {
        entityManager.getTransaction().begin();
        if (!entityManager.contains(empresaTerceira)) {
            empresaTerceira = entityManager.merge(empresaTerceira);
        }
        entityManager.remove(empresaTerceira);
        entityManager.getTransaction().commit();
    }

    public List<EmpresaTerceira> listarTodas() {
        TypedQuery<EmpresaTerceira> query = entityManager.createQuery("SELECT e FROM EmpresaTerceira e", EmpresaTerceira.class);
        return query.getResultList();
    }

    public List<EmpresaTerceira> findAll() {
        return null;
    }

    public Optional<EmpresaTerceira> findById(Long id) {
        EmpresaTerceira empresaTerceira = entityManager.find(EmpresaTerceira.class, id);
        return empresaTerceira != null ? Optional.of(empresaTerceira) : Optional.empty();
    }
}
