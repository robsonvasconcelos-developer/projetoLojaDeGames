// CAMADA de REPOSITORY

package com.minhalojadegames.minhaLojaDeGames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.minhalojadegames.minhaLojaDeGames.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List<Categoria> findAllByGameContainingIgnoreCase (String game);


	
	
	
	
	
	
	

}
