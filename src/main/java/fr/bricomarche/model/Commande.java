package fr.bricomarche.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="REF")
	private String ref;
	
	@Column(name="DATE")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="DELAI")
	private int delai;
	
	@ManyToOne
	@JoinColumn(name="ID_FNR")
	private Fournisseur fournisseur;
	
	@ManyToMany
	@JoinTable(name="compo",
			joinColumns=
				@JoinColumn(name="ID_COM", referencedColumnName="ID"),
			inverseJoinColumns=
				@JoinColumn(name="ID_ART", referencedColumnName="ID"))
	private Set<Article> articles;
	
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getDelai() {
		return delai;
	}
	
	public void setDelai(int delai) {
		this.delai = delai;
	}
	
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
}
