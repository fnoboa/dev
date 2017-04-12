package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.util.ForwardView;
import br.com.caelum.livraria.util.RedirectView;

@ManagedBean
@ViewScoped
public class AutorBean {

	private Autor autor = new Autor();
	
	private Integer autorId;
	
	public Integer getAutorId() {
	    return autorId;
	}

	public void setAutorId(Integer autorId) {
	    this.autorId = autorId;
	}
	
	public void carregarAutorPelaId() {
		this.autor = new DAO<Autor>(Autor.class).buscaPorId(autorId);
	}

	public Autor getAutor() {
		return autor;
	}
	
	public List<Autor> getAutores() {
        return new DAO<Autor>(Autor.class).listaTodos();
    }

	public RedirectView gravar1() {
		System.out.println("Gravando autor " + this.autor.getNome());

		new DAO<Autor>(Autor.class).adiciona(this.autor);
		
		this.autor = new Autor();
		
		//return "livro?faces-redirect=true";
		return new RedirectView("livro");		
		
	}
	
	public ForwardView gravar() {
		System.out.println("Gravando autor " + this.autor.getNome());

        if (this.autor.getId() == null) {
            new DAO<Autor>(Autor.class).adiciona(this.autor);
            this.autor = new Autor();
        } else {
            new DAO<Autor>(Autor.class).atualiza(this.autor);
        }

        return new ForwardView("livro");
	}
	
	public void remover(Autor autor) {
		System.out.println("Removendo autor " + autor.getNome());		
		this.autor.remove(autor); //removendo da lista		
	}
	
	public void carregar(Autor autor) {
	    System.out.println("Carregando autor " + autor.getNome());
	    this.autor = autor;
	}
}
