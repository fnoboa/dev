package com.project.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.project.dao.DAO;
import com.project.dao.UsuarioDao;
import com.project.model.Usuario;

@Named
@ViewScoped
public class LoginBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public String efetuaLogin() {
		System.out.println("User login "
				+ this.usuario.getUser());

		FacesContext context = FacesContext.getCurrentInstance();
		boolean existe = new UsuarioDao().existe(this.usuario);
		if (existe) {
			context.getExternalContext().getSessionMap()
					.put("usuarioLogado", this.usuario);
			return "creditcard?faces-redirect=true";
		}

		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("User not found!!!"));

		return "login?faces-redirect=true";
	}
	
	public String newLogin() {
		
		System.out.println("New user login "
				+ this.usuario.getUser());
		
		FacesContext context = FacesContext.getCurrentInstance();		
		context.getExternalContext().getSessionMap()
		.put("usuarioLogado", this.usuario);
		return "newlogin?faces-redirect=true";
		
	}
			
	public String addUser() {
		System.out.println("Adding User " + this.usuario.getUser());

		if (this.usuario.getId() == null) {
			new DAO<Usuario>(Usuario.class).adiciona(this.usuario);
		} 

		this.usuario = new Usuario();

		return "creditcard?faces-redirect=true";
	}
	

	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}
}
