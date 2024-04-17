package fr.univtours.polytech.bibliotheque.servlet;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.bibliotheque.business.CartBusiness;
import fr.univtours.polytech.bibliotheque.model.CartItem;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/display-cart")
public class DisplayCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    private CartBusiness cartBusiness;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CartItem> cartItems = cartBusiness.getCartItems();
        request.setAttribute("cartItems", cartItems);

        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }
}
