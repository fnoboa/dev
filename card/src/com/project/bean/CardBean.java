package com.project.bean;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


import com.project.dao.DAO;
import com.project.dao.UsuarioDao;
import com.project.model.Card;
import com.project.model.Usuario;


@Named
@ViewScoped 
public class CardBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Card card = new Card();
	
	private List<Card> cards;
	
	private Usuario user = new Usuario();

	public Usuario getUsuario() {
		return user;
	}

	public List<Card> getCards() {
		DAO<Card> dao = new DAO<Card>(Card.class);
		if (this.cards == null) {
			this.cards = dao.listaTodos();
		}
		return cards;
	}
	
	public Card getCard() {
		return card;
	}
		
	public void loadCardById() {
		this.card = new DAO<Card>(Card.class).buscaPorId(this.card.getId());
	}	
			
	public void gravar() {
		System.out.println("Adding credit card from Client: " + this.card.getName());
		
		DAO<Card> dao = new DAO<Card>(Card.class);
		if (this.card.getId() == null) {
			dao.adiciona(this.card);
			this.cards = dao.listaTodos();
		} else {
			dao.atualiza(this.card);
		}

		this.card = new Card();
	}


	public void carregar(Card creditcard) {
		System.out.println("Loading card");
		this.card = creditcard;
	}

	public String formSearchCard() {
		System.out.println("Call the form to search card");
		return "searchcard?faces-redirect=true";
	}
	
	public void remover(Card card) {
		System.out.println("Removing Card");
		DAO<Card> dao = new DAO<Card>(Card.class);
		dao.remove(card);
		this.cards = dao.listaTodos();
	}
	
	public String search() {
         
	    System.out.println("Card number: " + this.card.getNumber());		 
		System.out.println("User login " + this.card.getUser());		
		
		FacesContext context = FacesContext.getCurrentInstance();
		String searchinfo = null;
		
		DAO<Card> dao = new DAO<Card>(Card.class);
		
		try {
		
			searchinfo = dao.listaCard(card.getUser(), card.getNumber());
		} catch (Exception e){
			System.out.println("Card not found");
		}
		
		if (searchinfo != null) {
			System.out.println("Found card"+searchinfo);
			
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Card Found!!!"));
			
			context.getExternalContext().getSessionMap()
					.put("userInfo", searchinfo);
			return "searchcard?faces-redirect=true";
		}
		
		System.out.println("Card not found"+searchinfo);

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Card not found!!!"));

		return "searchcard?faces-redirect=true";
	}
	
}
