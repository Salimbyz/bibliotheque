package fr.univtours.polytech.bibliotheque.business;

import java.util.List;

import fr.univtours.polytech.bibliotheque.dao.ArticleDAO;
import fr.univtours.polytech.bibliotheque.model.ArticleBean;
import jakarta.inject.Inject;

public class ArticleBusinessImpl {
    
    @Inject
    private ArticleDAO articleDao;

    public List<ArticleBean> getArticleList(){
        List<ArticleBean> articles = articleDao.getArticleList();
        return articles;
    }
}
