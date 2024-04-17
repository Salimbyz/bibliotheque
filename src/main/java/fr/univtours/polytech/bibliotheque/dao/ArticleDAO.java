package fr.univtours.polytech.bibliotheque.dao;

import java.util.List;

import fr.univtours.polytech.bibliotheque.model.ArticleBean;

public interface ArticleDAO {
    public List<ArticleBean> getArticleList();

    public void insertArticle(ArticleBean article);
    
    public void updateArticle(ArticleBean article);
}
