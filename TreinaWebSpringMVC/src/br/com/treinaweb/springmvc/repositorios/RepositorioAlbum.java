package br.com.treinaweb.springmvc.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.treinaweb.springmvc.dominios.Album;

public interface RepositorioAlbum extends JpaRepository<Album, Long> {
	
	@Query("SELECT a FROM Album a WHERE a.nome LIKE %:nome%")
	List<Album> findByNome(@Param("nome") String nome);

}
