package fr.univtours.polytech.bibliotheque.business;

import fr.univtours.polytech.bibliotheque.dao.UserDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class UserBusinessImpl implements UserBusiness {

    @Inject
    private UserDAO userDAO;

    @Override
    public boolean authenticate(String name, String password) {
        String storedPassword = userDAO.getPassword(name);
        return storedPassword != null && storedPassword.equals(password);
    }
}
