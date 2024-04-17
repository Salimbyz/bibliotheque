package fr.univtours.polytech.bibliotheque.servlet;

import java.io.IOException;

import fr.univtours.polytech.bibliotheque.business.UserBusiness;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {

    @Inject
    private UserBusiness userBusiness;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("connection.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
    
        // Vérifier l'authentification de l'utilisateur
        boolean isAuthenticated = userBusiness.authenticate(username, password);
    
        if (isAuthenticated) {
            response.sendRedirect("index.html");
        } else {
            // Si l'authentification échoue, afficher un message d'erreur sur PAGE1 et rester sur la même page
            request.setAttribute("error", "Le nom d'utilisateur ou le mot de passe saisi n'est pas valide.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("connection.jsp");
            dispatcher.forward(request, response);
        }
    }
}


