package fr.univtours.polytech.bibliotheque.servlet;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.bibliotheque.business.ArticleBusiness;
import fr.univtours.polytech.bibliotheque.model.ArticleBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/articles")
public class ArticleServlet extends HttpServlet {
    
    @Inject
    private ArticleBusiness business;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // Récupérer la liste des résultats
       List<ArticleBean> ArticleList = business.getArticleList();
       // Ajouter la liste des résultats à la requête
       request.setAttribute("ARTICLE_LIST", ArticleList);

       request.getRequestDispatcher("/articles.jsp").forward(request,response);
    }

    

}