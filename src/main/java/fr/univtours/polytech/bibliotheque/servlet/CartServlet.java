package fr.univtours.polytech.bibliotheque.servlet;

import java.io.IOException;

import fr.univtours.polytech.bibliotheque.business.ArticleBusiness;
import fr.univtours.polytech.bibliotheque.business.CartBusiness;
import fr.univtours.polytech.bibliotheque.model.ArticleBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private CartBusiness cartBusiness;

    @Inject
    private ArticleBusiness articleBusiness;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String articleId = request.getParameter("id");

        if (action != null && articleId != null) {
            ArticleBean article = articleBusiness.getArticleById(Integer.parseInt(articleId));
            if (article != null) {
                if ("add".equals(action)) {
                    cartBusiness.addItem(article, 1);
                } else if ("remove".equals(action)) {
                    cartBusiness.removeItem(article, 1);
                }
            }
        } else if ("displayCart".equals(action)) {
            response.sendRedirect(request.getContextPath() + "/display-cart");
            return;
        }

        response.sendRedirect(request.getContextPath() + "/articles");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
