package fr.bricomarche.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="fournisseur")
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="fournisseur")
	private Set<Commande> commandes;
	
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

	public String toString() {
		return "Nom -> " + name;
	}
}
