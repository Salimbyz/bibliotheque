package fr.univtours.polytech.bibliotheque.business;

import fr.univtours.polytech.bibliotheque.dao.UserDAO;
import fr.univtours.polytech.bibliotheque.model.UserBean;

public class UserBusinessImpl implements UserBusiness{
    private UserDAO userDAO;

    public UserBusinessImpl() {
    }

    public UserBusinessImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean authenticate(String name, String password) {
        UserBean user = userDAO.findByUsername(name);
        return user != null && user.getPassword().equals(password);
    }

}
