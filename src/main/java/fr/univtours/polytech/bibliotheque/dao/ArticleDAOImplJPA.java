package fr.univtours.polytech.bibliotheque.dao;

import java.util.List;

import fr.univtours.polytech.bibliotheque.model.ArticleBean;
import fr.univtours.polytech.bibliotheque.model.UserBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ArticleDAOImplJPA implements ArticleDAO {

   // L'objet EntityManager qui va permettre d'effectuer les requêtes en BDD.
   @PersistenceContext(unitName = "bibliotheque")
   private EntityManager em;

   @SuppressWarnings("unchecked") 
   @Override
   public List<ArticleBean> getArticleList() {
       // Exemple de requête HQL (ou JPAQL).
       Query requete = em.createNativeQuery("select * from ARTICLE", UserBean.class);
       return requete.getResultList();
   }

   @Override
   public void updateArticle(ArticleBean article) {
       // TODO Auto-generated method stub
   }

   @Override
   public void insertArticle(ArticleBean article) {
       // Insertion d'un enregistrement en BDD.
       em.persist(article);
   }
}