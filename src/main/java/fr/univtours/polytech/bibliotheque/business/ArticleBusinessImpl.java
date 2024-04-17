package fr.univtours.polytech.bibliotheque.business;

import java.util.List;

import fr.univtours.polytech.bibliotheque.dao.ArticleDAO;
import fr.univtours.polytech.bibliotheque.model.ArticleBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class ArticleBusinessImpl implements ArticleBusiness {

    @Inject
    private ArticleDAO articleDao;

    @Override
    public List<ArticleBean> getArticleList() {
        List<ArticleBean> articles = articleDao.getArticleList();
        return articles;
    }

    @Override
    public ArticleBean getArticleById(int id) {
        return articleDao.getArticleById(id);
    }
}
