package fr.bricomarche.main;

import javax.persistence.*;

import org.jboss.logging.Logger;

import fr.bricomarche.model.Article;

public class TestJpa {
	
	private static final Logger LOG = Logger.getLogger(TestJpa.class);
	private static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("bricomarche");
		
		TestJpa app = new TestJpa();
		app.execute();
		
		entityManagerFactory.close();
	}
	
	public void execute() {
		EntityManager em = entityManagerFactory.createEntityManager();
		
		TypedQuery<Article> articles = em.createQuery("select a from Article a where a.fournisseur.name='Dubois & Fils'", Article.class);
		
		for (Article article : articles.getResultList()) {
			LOG.info("Liste des articles du fournisseur " + article.getFournisseur().getName()+ " :");
			LOG.info(article.toString());
		}
		
		em.close();
	}
	
	public void listeBoulons() {
		EntityManager em = entityManagerFactory.createEntityManager();
		
		TypedQuery<Article> articles = em.createQuery("from Article a where name like :nom", Article.class);
		articles.setParameter("nom", "Boulon%");
		
		for (Article article : articles.getResultList()) {
			if (article.getRef().equals("A01")) {
				article.setName("Perceuse P2");
				em.merge(article);
			}
			LOG.info("Liste des boulons :");
			LOG.info(article.toString());
		}
		
		em.close();
	}

}
