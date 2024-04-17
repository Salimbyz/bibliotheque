package fr.univtours.polytech.bibliotheque.dao;

import java.util.List;

import fr.univtours.polytech.bibliotheque.model.ArticleBean;

public interface ArticleDAO {
    public List<ArticleBean> getArticleList();

    public ArticleBean getArticleById(int id);

    public void insertArticle(ArticleBean article);

    public void updateArticle(ArticleBean article);
}
