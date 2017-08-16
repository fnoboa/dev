package com.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import com.project.model.Card;

public class DAO<T> {

	private final Class<T> classe;

	public DAO(Class<T> classe) {
		this.classe = classe;
	}

	public void adiciona(T t) {

		// consegue a entity manager
		EntityManager em = new JPAUtil().getEntityManager();

		// abre transacao
		em.getTransaction().begin();

		// persiste o objeto
		em.persist(t);

		// commita a transacao
		em.getTransaction().commit();

		// fecha a entity manager
		em.close();
	}

	public void remove(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.remove(em.merge(t));

		em.getTransaction().commit();
		em.close();
	}

	public void atualiza(T t) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.merge(t);

		em.getTransaction().commit();
		em.close();
	}

	public List<T> listaTodos() {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).getResultList();

		em.close();
		return lista;
	}
	
	/*
	 * public String searchCard(String user, Long cardNumber) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		String resultado;
		TypedQuery<Card> query = em.createQuery(
				  " select name from Card c "
				+ " where c.user = :pUser and c.number = :pNumber", Card.class);
		
		query.setParameter("pUser", user);
		query.setParameter("pNumber", cardNumber);
		System.out.println("01");
		try {
			resultado =  (String)query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		}
		System.out.println("02");
		em.close();		
		
		return resultado;
	}
	 */
	public String listaCard(String user, Long cardNumber) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<T> query = (TypedQuery<T>) em.createQuery(" select name from Card c "
				+ " where c.user = :pUser and c.number = :pNumber");
		query.setParameter("pUser", user);
		query.setParameter("pNumber", cardNumber);
		String resultado =  (String)query.getSingleResult();
		em.close();

		return resultado;
	}
	

	public T buscaPorId(Integer id) {
		EntityManager em = new JPAUtil().getEntityManager();
		T instancia = em.find(classe, id);
		em.close();
		return instancia;
	}	
	
	public int contaTodos() {
		EntityManager em = new JPAUtil().getEntityManager();
		long result = (Long) em.createQuery("select count(n) from livro n")
				.getSingleResult();
		em.close();

		return (int) result;
	}

	public List<T> listaTodosPaginada(int firstResult, int maxResults) {
		EntityManager em = new JPAUtil().getEntityManager();
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
		query.select(query.from(classe));

		List<T> lista = em.createQuery(query).setFirstResult(firstResult)
				.setMaxResults(maxResults).getResultList();

		em.close();
		return lista;
	}

}
