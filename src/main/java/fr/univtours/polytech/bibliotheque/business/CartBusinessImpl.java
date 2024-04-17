package fr.univtours.polytech.bibliotheque.business;

import java.util.ArrayList;
import java.util.List;
import fr.univtours.polytech.bibliotheque.model.ArticleBean;
import fr.univtours.polytech.bibliotheque.model.CartItem;

public class CartBusinessImpl implements CartBusiness {
    private List<CartItem> cartItems;

    public CartBusinessImpl() {
        this.cartItems = new ArrayList<>();
    }

    @Override
    public void addItem(ArticleBean article, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getArticle().getId().equals(article.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(article, quantity));
    }

    @Override
    public void removeItem(ArticleBean article, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getArticle().getId().equals(article.getId())) {
                int newQuantity = item.getQuantity() - quantity;
                if (newQuantity <= 0) {
                    cartItems.remove(item);
                } else {
                    item.setQuantity(newQuantity);
                }
                return;
            }
        }
    }

    @Override
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public void clearCart() {
        cartItems.clear();
    }
}
