package fr.univtours.polytech.bibliotheque.dao;

import java.util.List;

import fr.univtours.polytech.bibliotheque.model.UserBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UserDAOImplJPA implements UserDAO {

   // L'objet EntityManager qui va permettre d'effectuer les requêtes en BDD.
   @PersistenceContext(unitName = "bibliotheque")
   private EntityManager em;

   @SuppressWarnings("unchecked") 
   @Override
   public List<UserBean> getUserList() {
       // Exemple de requête HQL (ou JPAQL).
       Query requete = em.createNativeQuery("select * from USER", UserBean.class);
       return requete.getResultList();
   }

   @Override
   public void updateUser(UserBean note) {
       // TODO Auto-generated method stub
   }

   @Override
   public void insertUser(UserBean user) {
       // Insertion d'un enregistrement en BDD.
       em.persist(user);
   }
}
