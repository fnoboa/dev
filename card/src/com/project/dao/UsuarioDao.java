package com.project.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import com.project.model.Card;
import com.project.model.Usuario;

public class UsuarioDao {

	public boolean existe(Usuario usuario) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = em.createQuery(
				  " select u from Usuario u "
				+ " where u.user = :pUser and u.senha = :pSenha", Usuario.class);
		
		query.setParameter("pUser", usuario.getUser());
		query.setParameter("pSenha", usuario.getSenha());
		try {
			Usuario resultado =  query.getSingleResult();
		} catch (NoResultException ex) {
			return false;
		}
		
		em.close();
		
		return true;
	}
	

}
