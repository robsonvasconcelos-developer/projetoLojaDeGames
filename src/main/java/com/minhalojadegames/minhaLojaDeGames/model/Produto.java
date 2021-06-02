package com.minhalojadegames.minhaLojaDeGames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private long id;
	
	private String descricao;
	@OneToMany(mappedBy = "console", cascade = CascadeType.ALL )  
	@JsonIgnoreProperties("console") 
	private List<Categoria> categoria;
	
	
	//Getters e Setters e selecionar Todos=
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Categoria> getCategoria() {
		return categoria;
	}
	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	

	
	
	
	
	
	
	
	
	
	
	

}
