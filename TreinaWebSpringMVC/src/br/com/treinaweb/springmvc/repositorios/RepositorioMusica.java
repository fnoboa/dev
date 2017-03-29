package br.com.treinaweb.springmvc.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.treinaweb.springmvc.dominios.Musica;

public interface RepositorioMusica extends JpaRepository<Musica, Long> {
	
	@Query("SELECT m FROM Musica m WHERE m.nome LIKE %:nome%")
	List<Musica> findByNome(@Param("nome") String nome);

}