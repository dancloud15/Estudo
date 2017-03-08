package br.com.nakabar.DB;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CategoriaDAO extends DAO {
	
	public void salvar (Categoria cat){
		EntityManager em = getEntitymanager().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(cat);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}
	public Categoria getById (int idcat){
		EntityManager em = getEntitymanager().createEntityManager();
		return em.find(Categoria.class, idcat);
	}
	
	public void update (Categoria cat){
		EntityManager em = getEntitymanager().createEntityManager();
		try {
			em.getTransaction().begin();
			Categoria c =em.find(Categoria.class, cat.getId());
			c.setNome(cat.getNome());
			em.persist(c);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();

	}
	public void delete(Categoria cat){
		EntityManager em = getEntitymanager().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Categoria c = em.find(Categoria.class, cat.getId());
			em.remove(c);
			em.getTransaction().commit();
			
		} finally {
		em.close();
		}
	}
	public List<Categoria> exibir(){
		EntityManager em = getEntitymanager().createEntityManager();
		
		try {
			Query q = em.createQuery("select object (c) from Categoria as c");
			return q.getResultList();
		} finally {
			em.close();
		}
		
		
	}

}
