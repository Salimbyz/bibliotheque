package fr.univtours.polytech.bibliotheque.dao;

import java.util.List;

import fr.univtours.polytech.bibliotheque.model.ArticleBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ArticleDAOImplJPA implements ArticleDAO {

    @PersistenceContext(unitName = "bibliotheque")
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<ArticleBean> getArticleList() {
        Query requete = em.createNativeQuery("select * from ARTICLE", ArticleBean.class);
        return requete.getResultList();
    }

    @Override
    public ArticleBean getArticleById(int id) {
        return em.find(ArticleBean.class, id);
    }

    @Override
    public void updateArticle(ArticleBean article) {
    }

    @Override
    public void insertArticle(ArticleBean article) {
        em.persist(article);
    }
}