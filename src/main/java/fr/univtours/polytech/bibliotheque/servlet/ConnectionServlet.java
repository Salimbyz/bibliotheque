package fr.univtours.polytech.bibliotheque.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Afficher la page de connexion (PAGE1.jsp)
        RequestDispatcher dispatcher = request.getRequestDispatcher("connection.jsp");
        dispatcher.forward(request, response);
}
