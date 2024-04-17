package fr.univtours.polytech.bibliotheque.dao;

import java.util.List;

import fr.univtours.polytech.bibliotheque.model.UserBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UserDAOImplJPA implements UserDAO {

    @PersistenceContext(unitName = "bibliotheque")
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<UserBean> getUserList() {
        Query requete = em.createNativeQuery("select * from USER", UserBean.class);
        return requete.getResultList();
    }

    @Override
    public void updateUser(UserBean note) {
    }

    @Override
    public void insertUser(UserBean user) {
        em.persist(user);
    }

    @Override
    public String getPassword(String username) {
        Query query = em.createNativeQuery("SELECT password FROM USER WHERE login = :login");
        query.setParameter("login", username);
        try {
            return (String) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}