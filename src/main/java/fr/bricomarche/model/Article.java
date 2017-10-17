package fr.bricomarche.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="article")
public class Article {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="REF")
	private String ref;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PRIX")
	private double prix;
	
	@ManyToOne
	@JoinColumn(name="ID_FNR")
	private Fournisseur fournisseur;
	
	@ManyToMany(mappedBy="articles")
	private Set<Commande> commandes;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRef() {
		return ref;
	}
	
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public String toString() {
		return "REF -> " + ref + " | NOM -> " + name + " | Prix -> " + prix;
	}
}
