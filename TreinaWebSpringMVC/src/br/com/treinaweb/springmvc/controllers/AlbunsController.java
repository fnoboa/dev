package br.com.treinaweb.springmvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.treinaweb.springmvc.dominios.Album;
import br.com.treinaweb.springmvc.repositorios.RepositorioAlbum;

@Controller
@RequestMapping("/albuns")
public class AlbunsController {
	
	@Autowired
	private RepositorioAlbum repositorio;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Album> albuns = repositorio.findAll();
		model.addAttribute("albuns", albuns);
		return "album.listar.tiles";
	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.GET)
	public String adicionar(Model model) {
		model.addAttribute("album", new Album());
		//return "albuns/adicionar"; JSTL
		return "album.adicionar.tiles";
	}
	
	@RequestMapping(value = "/adicionar", method = RequestMethod.POST)
	public String adicionar(@ModelAttribute("album") @Valid Album novoAlbum, BindingResult result, Model model) {
		if (result.hasErrors()) {
			//return "albuns/adicionar"; JSTL
			return "album.adicionar.tiles";
		}
		
		//model.addAttribute("album", novoAlbum);
		repositorio.save(novoAlbum);
		
		//return "albuns/exibir"; JSTL
		//return "album.exibir.tiles";
		return "redirect:/albuns/listar";
	}
	
	@RequestMapping(value = "/alterar/{id}", method = RequestMethod.GET)
	public String alterar(@PathVariable("id") Long id, Model model) {
		Album albumASerAlterado = repositorio.findOne(id);
		model.addAttribute("album", albumASerAlterado);
		return "album.alterar.tiles";
	}
	
	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public String alterar(@ModelAttribute("album") @Valid Album album, BindingResult result) {
		if (result.hasErrors()) {			
			return "album.alterar.tiles";
		}				
		repositorio.save(album);		
		return "redirect:/albuns/listar";
	}
	
	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.GET)
	public String excluir(@PathVariable("id") Long id) {
		repositorio.delete(id);
		return "redirect:/albuns/listar";
	}
	
	@RequestMapping(value = "/porNome", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Album> pesquisarPorNome (@RequestParam(name = "nome", defaultValue = "") String nomeAlbum) {
		return repositorio.findByNome(nomeAlbum);	
	}
	

}
