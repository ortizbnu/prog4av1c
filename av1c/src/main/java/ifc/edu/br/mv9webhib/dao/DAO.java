package ifc.edu.br.mv9webhib.dao;

import ifc.edu.br.mv9webhib.model.Cargo;
import ifc.edu.br.mv9webhib.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

public class DAO {
    
    EntityManagerFactory emf;
    EntityManager em;

    public DAO() {
        emf = Persistence.createEntityManagerFactory("meuPU");
        em = emf.createEntityManager();
    }
    
    public void inserirPessoa(Pessoa p) {
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(p);
        tx.commit();
    }
    
    public List consultarPessoas() {
        List pessoas = em.createQuery("from Pessoa", Pessoa.class).getResultList();
        return pessoas;
    }
    
    public void inserirCargo(Cargo c) {
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        em.persist(c);
        tx.commit();
    }
    
    public List consultarCargos() {
        List cargos = em.createQuery("from Cargo", Cargo.class).getResultList();
        return cargos;
    }
    
    public Cargo consultarCargo(Long id) {
        Query q = em.createQuery("from Cargo where id = :id", Cargo.class);
        q.setParameter("id", id);
        return (Cargo) q.getSingleResult();
    }
    
}
