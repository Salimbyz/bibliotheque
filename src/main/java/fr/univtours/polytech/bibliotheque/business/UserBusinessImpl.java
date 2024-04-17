package fr.univtours.polytech.bibliotheque.business;

import fr.univtours.polytech.bibliotheque.dao.UserDAO;
import fr.univtours.polytech.bibliotheque.model.UserBean;

public class UserBusinessImpl {
    private UserDAO userDAO;

    public UserBusinessImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean authenticate(String username, String password) {
        UserBean user = userDAO.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

}
