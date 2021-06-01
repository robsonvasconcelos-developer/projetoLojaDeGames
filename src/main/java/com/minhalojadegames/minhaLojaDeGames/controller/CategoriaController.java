package com.minhalojadegames.minhaLojaDeGames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.minhalojadegames.minhaLojaDeGames.model.Categoria;
import com.minhalojadegames.minhaLojaDeGames.repository.CategoriaRepository;





@RestController
@RequestMapping("/categoria")      
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}") // Metodo de pesquisa, Via HTTP para a API.
	public ResponseEntity<Categoria> GetById(@PathVariable long id){ 
		return repository.findById(id) 
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build()); 
	}
	
	// findByDescricaoCategoria ?????????
	@GetMapping("/game/{game}") //Diferente do ID anterior, E gerado um SUB Caminho, para nao gerar conflito!!
	public ResponseEntity<List<Categoria>> GetByGame (@PathVariable String game){
		return ResponseEntity.ok(repository.findAllByGameContainingIgnoreCase(game)); // na URL na hora de pesquisar no Postman, ele Aceita com letra maiuscula ou minuscula!!!
	}
	
	
	@PostMapping       //postCategoria
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
	}
	
	
	@PutMapping          //Anotacao de Atualizacao de DADOS!!
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}	

	
	// Link para testar no POSTMAN = http://localhost:8080/categoria
	
	
}
