package br.com.dnasystem.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dnasystem.VO.ContasPagar;
import br.com.dnasystem.VO.Fornecedor;

public class FornecedorDAO extends DAO {

	public void Salvar(Fornecedor fornecedor) {
		EntityManager em = getEntitymanager().createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(fornecedor);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	public Fornecedor Get(int idFornecedor) {
		EntityManager em = getEntitymanager().createEntityManager();
		return em.find(Fornecedor.class, idFornecedor);
	}

	public void Update(Fornecedor fornecedor) {
		EntityManager em = getEntitymanager().createEntityManager();

		try {
			em.getTransaction().begin();
			Fornecedor f = em.find(Fornecedor.class, fornecedor.getId());
			f.setNome(fornecedor.getNome());
			f.setTelefone(fornecedor.getTelefone());
			f.setEndereco(fornecedor.getEndereco());
			f.setObs(fornecedor.getObs());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	public void Delete(Fornecedor fornecedor) {
		EntityManager em = getEntitymanager().createEntityManager();

		try {
			em.getTransaction().begin();
			Fornecedor f = em.find(Fornecedor.class, fornecedor.getId());
			em.remove(f);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	public List<Fornecedor> GetAll() {
		EntityManager em = getEntitymanager().createEntityManager();
		List<Fornecedor> lista = null;
		try {
			Query q = em.createQuery("SELECT object(f) from Fornecedor as f");
			lista = q.getResultList();
		} catch (Exception e) {
			em.close();
		}
		return lista;

	}
}