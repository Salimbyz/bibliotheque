package fr.univtours.polytech.bibliotheque.business;

import java.util.List;
import fr.univtours.polytech.bibliotheque.model.ArticleBean;
import fr.univtours.polytech.bibliotheque.model.CartItem;

public interface CartBusiness {
    void addItem(ArticleBean article, int quantity);

    void removeItem(ArticleBean article, int quantity);

    List<CartItem> getCartItems();

    void clearCart();
}
