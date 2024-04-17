package fr.univtours.polytech.bibliotheque.dao;

import java.util.List;

import fr.univtours.polytech.bibliotheque.model.ArticleBean;
import jakarta.ejb.Stateless;

@Stateless
public class ArticleDAOImplJPA implements ArticleDAO {

    @Override
    public List<ArticleBean> getArticleList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getArticleList'");
    }

    @Override
    public void insertArticle(ArticleBean article) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertArticle'");
    }

    @Override
    public void updateArticle(ArticleBean article) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateArticle'");
    }

}
