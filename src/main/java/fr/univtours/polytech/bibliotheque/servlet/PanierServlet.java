package fr.univtours.polytech.bibliotheque.servlet;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.bibliotheque.business.CartBusiness;
import fr.univtours.polytech.bibliotheque.business.CartBusinessImpl;
import fr.univtours.polytech.bibliotheque.model.CartItem;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/panier")
public class PanierServlet extends HttpServlet {

    private CartBusiness cartBusiness;

    @Override
    public void init() throws ServletException {
        this.cartBusiness = new CartBusinessImpl(); // Vous pouvez injecter cette dépendance si vous utilisez un conteneur d'inversion de contrôle comme CDI
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CartItem> cartItems = cartBusiness.getCartItems();
        request.setAttribute("cartItems", cartItems);
        
        // Ajoutez la variable 'item' au request
        request.setAttribute("item", new CartItem()); // Remplacez new CartItem() par l'objet réel que vous souhaitez passer au JSP

        RequestDispatcher dispatcher = request.getRequestDispatcher("panier.jsp");
        dispatcher.forward(request, response);
    }
}
