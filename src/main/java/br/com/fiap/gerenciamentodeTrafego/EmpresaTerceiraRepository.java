package br.com.fiap.gerenciamentodeTrafego;

import br.com.fiap.gerenciamentodeTrafego.model.EmpresaTerceira;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaTerceiraRepository extends JpaRepository <EmpresaTerceira, Integer> {
    EmpresaTerceira save(EmpresaTerceira empresaTerceira);

    Optional<EmpresaTerceira> findById(Integer id);

    void deleteById(Integer id);

    List<EmpresaTerceira> findAll();
}