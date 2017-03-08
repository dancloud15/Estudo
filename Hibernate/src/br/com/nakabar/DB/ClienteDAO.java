package br.com.nakabar.DB;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public class ClienteDAO extends DAO {

	public void salvar(Cliente cliente) {
		EntityManager em = getEntitymanager().createEntityManager();

		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	public List<Cliente> exibir() {
		EntityManager em = getEntitymanager().createEntityManager();

		try {
			Query q = em.createQuery("select object (c) from Cliente as c");
			return q.getResultList();
		} finally {
			em.close();
		}

	}

	// Utilizando criteria ao inves de Query
	public List<Cliente> exibir_by_nome(String nome) {
		EntityManager em = getEntitymanager().createEntityManager();
		try {
			Criteria criteria = getSession().createCriteria(Cliente.class);
			// criteria.add(Restrictions.eq("nome", "Igor"));
			// criteria.add(Restrictions.like("sobrenome", "%N%"));
			// criteria.add(Restrictions.gt("id", 2));
			// gt > maior que
			// ge >=
			// lt <
			// le <=

			// Criando Criterions
			// Criterion cr1 = Restrictions.like("sobrenome", "%N%");
			// Criterion cr2 = Restrictions.like("nome", "%A%");

			// comparando duas expressoes
			// LogicalExpression exp = Restrictions.or(cr1, cr2);

			// mostra o resultado
			// criteria.add(exp);
			criteria.add(Restrictions.like("nome", "%"+ nome +"%"));

			return criteria.list();

		} finally {
			em.close();
		}

	}

	public Cliente getById(int idCliente) {
		EntityManager em = getEntitymanager().createEntityManager();
		return em.find(Cliente.class, idCliente);
	}

	public void update(Cliente cliente) {
		EntityManager em = getEntitymanager().createEntityManager();

		try {
			em.getTransaction().begin();
			Cliente c = em.find(Cliente.class, cliente.getId());
			c.setNome(cliente.getNome());
			c.setSobrenome(cliente.getSobrenome());
			c.setCat(cliente.getCat());
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		em.close();

	}

	public void delete(Cliente cliente) {
		EntityManager em = getEntitymanager().createEntityManager();

		try {
			em.getTransaction().begin();
			Cliente c = em.find(Cliente.class, cliente.getId());
			em.remove(c);
			em.getTransaction().commit();

		} finally {
			em.close();
		}
	}

}
