package br.com.dnasystem.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.dnasystem.VO.ContasPagar;


public class ContasPagarDAO extends DAO{
	
	public void Salvar(ContasPagar contas_pagar) {
		EntityManager em = getEntitymanager().createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(contas_pagar);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	public ContasPagar Get(int idcontas_pagar) {
		EntityManager em = getEntitymanager().createEntityManager();
		return em.find(ContasPagar.class, idcontas_pagar);
	}

	public void Update(ContasPagar contas_pagar) {
		EntityManager em = getEntitymanager().createEntityManager();

		try {
			em.getTransaction().begin();
			ContasPagar cp = em.find(ContasPagar.class, contas_pagar.getId());
			cp.setDescricao(contas_pagar.getDescricao());
			cp.setData_vencimento(contas_pagar.getData_vencimento());
			cp.setValor(contas_pagar.getValor());
			cp.setFornecedor(contas_pagar.getFornecedor());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	public void Delete(ContasPagar contas_pagar) {
		EntityManager em = getEntitymanager().createEntityManager();

		try {
			em.getTransaction().begin();
			ContasPagar cp = em.find(ContasPagar.class, contas_pagar.getId());
			em.remove(cp);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	public List<ContasPagar> GetAll() {
		EntityManager em = getEntitymanager().createEntityManager();
		List<ContasPagar> lista = null;
		try {
			Query q = em.createQuery("SELECT object(cp) from ContasPagar as cp");
			lista = q.getResultList();
		} catch (Exception e) {
			em.close();
		}
		return lista;

	}

}
