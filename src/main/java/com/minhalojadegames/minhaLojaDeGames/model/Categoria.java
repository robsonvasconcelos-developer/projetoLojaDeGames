// CAMADA MODEL Entity
 
// Crie uma model  coloque todos os atributos necessários + get seters+ anotações
// Tabela 1 = Camada de model  com o nome de Categoria com os seus atributos.

package com.minhalojadegames.minhaLojaDeGames.model;

//import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	//Anotacao que Gera o Automaticamente o ID=
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY ) 
private long id; 

@NotNull
@Size(min = 1, max = 200)
private String console; 

@NotNull
@Size(min = 1, max = 255) 
private String game;




//Inserido TODOS os getters and Setter




public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getConsole() {
	return console;
}

public void setConsole(String console) {
	this.console = console;
}

public String getGame() {
	return game;
}

public void setGame(String game) {
	this.game = game;
}




















}
