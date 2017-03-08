package br.com.nakabar.DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;

public class DAO {
	
	
	
	private static EntityManagerFactory emf = null;
	
	
	
	public EntityManagerFactory getEntitymanager(){
		if(emf==null){
			emf = Persistence.createEntityManagerFactory("sistema");
		}
		
		return emf;
	}
	
	public DAO(){
		
	}
	
	
	//Criar Sessão para utilizar Criteria do Hibernate
	public Session getSession(){
		Session session = null;
		
		if(getEntitymanager().createEntityManager().getDelegate() instanceof EntityManagerImpl){
			EntityManagerImpl entityManagerImpl = (EntityManagerImpl) getEntitymanager().createEntityManager().getDelegate();
			return entityManagerImpl.getSession();
		}else{
			return (Session) getEntitymanager().createEntityManager().getDelegate();
		}
	}

}
