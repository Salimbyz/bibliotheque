package fr.univtours.polytech.bibliotheque.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Afficher la page de connexion
        RequestDispatcher dispatcher = request.getRequestDispatcher("connection.jsp");
        dispatcher.forward(request, response);
    }
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Récupérer les valeurs saisies dans le formulaire
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Vérifier l'authentification de l'utilisateur
    UserService userService = new UserService();
    boolean isAuthenticated = userService.authenticate(username, password);

    if (isAuthenticated) {
        // Rediriger vers la page listant les articles (PAGE2) si l'authentification est réussie
        response.sendRedirect("index.html");
    } else {
        // Si l'authentification échoue, afficher un message d'erreur sur PAGE1 et rester sur la même page
        request.setAttribute("error", "Le nom d'utilisateur ou le mot de passe saisi n'est pas valide.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("PAGE1.jsp");
        dispatcher.forward(request, response);
    }
}
