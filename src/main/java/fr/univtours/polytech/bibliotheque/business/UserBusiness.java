package fr.univtours.polytech.bibliotheque.business;

public interface UserBusiness {
    boolean authenticate(String username, String password);
}

