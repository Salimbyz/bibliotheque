package fr.univtours.polytech.bibliotheque.dao;
<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
=======

import java.util.List;

>>>>>>> 06bad009e12253de3b87ab91f2b8849a4af0aa7e
import fr.univtours.polytech.bibliotheque.model.UserBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class UserDAOImplJPA implements UserDAO {

<<<<<<< HEAD
    @Override
    public List<UserBean> getUserList() {

        Statement st = null;
        ResultSet rs = null;
        Connection connection = null;
        List<UserBean> userList = null;
=======
   // L'objet EntityManager qui va permettre d'effectuer les requêtes en BDD.
   @PersistenceContext(unitName = "bibliotheque")
   private EntityManager em;
>>>>>>> 06bad009e12253de3b87ab91f2b8849a4af0aa7e

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

   @Override
    public String findByUsername(String username) {
        Query query = em.createNativeQuery("SELECT password FROM USER WHERE login = :login");
        query.setParameter("login", username);
        try {
            return (String) query.getSingleResult();
        } catch (Exception e) {
<<<<<<< HEAD
            // S'il y a eu un problème, on le fait remonter.
            throw new RuntimeException(e);
        } finally {
            try {
                // Dans tous les cas, on ferme tout ce qui doit l'être.
                st.close();
                connection.close();
            } catch (Exception e) {
                // S'il y a eu un problème, on le fait remonter.
                throw new RuntimeException(e);
            }
        }
        return userList;
    }

    @Override
    public void insertUser(UserBean user) {

        // On utilisera ici des PreparedStatement plutôt que des Statement pour des
        // raisons de sécurité.
        PreparedStatement st = null;
        Connection connection = null;

        try {
            connection = ConnectionDB.createConnection();
            final String sqlInsert = "INSERT INTO USER (login, name, password) values (?, ?, ?);";
            st = connection.prepareStatement(sqlInsert);
            st.setString(1, user.getLogin());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            st.executeUpdate();
        } catch (Exception e) {
            // S'il y a eu un problème, on le fait remonter.
            throw new RuntimeException(e);
        } finally {
            try {
                // Dans tous les cas, on ferme tout ce qui doit l'être.
                st.close();
                connection.close();
            } catch (Exception e) {
                // S'il y a eu un problème, on le fait remonter.
                throw new RuntimeException(e);
            }
=======
            return null; // Gérer l'exception ou renvoyer null si aucun utilisateur n'est trouvé
>>>>>>> 06bad009e12253de3b87ab91f2b8849a4af0aa7e
        }
    }
}
