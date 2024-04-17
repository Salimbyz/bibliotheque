package fr.univtours.polytech.bibliotheque.dao;

import java.util.List;

import fr.univtours.polytech.bibliotheque.model.UserBean;

public interface UserDAO {
    public List<UserBean> getUserList();

    public void insertUser(UserBean user);
    
    public void updateUser(UserBean user);

    String findByUsername(String username);
}
