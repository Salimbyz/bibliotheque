package fr.univtours.polytech.bibliotheque.dao;

import java.util.List;

import fr.univtours.polytech.bibliotheque.model.UserBean;
import jakarta.ejb.Stateless;

@Stateless
public class UserDAOImplJPA implements UserDAO {

    @Override
    public List<UserBean> getUserList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserList'");
    }

    @Override
    public void insertUser(UserBean user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertUser'");
    }

    @Override
    public void updateUser(UserBean user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

}
