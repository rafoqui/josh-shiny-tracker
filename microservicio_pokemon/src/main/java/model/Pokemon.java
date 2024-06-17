package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pokemon")
public class Pokemon {

	@Id
	private int id;
	
	private String name;

	public Pokemon(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Pokemon() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
