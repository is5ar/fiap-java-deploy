package br.com.fiap.gerenciamentodeTrafego.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexao {

    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Semaforo");

    public static EntityManager getEntityManeger (){
        return EMF.createEntityManager();
    }
}