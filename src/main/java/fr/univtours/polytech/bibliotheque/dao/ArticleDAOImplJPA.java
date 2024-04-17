package fr.univtours.polytech.bibliotheque.dao;
<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
=======

>>>>>>> 06bad009e12253de3b87ab91f2b8849a4af0aa7e
import java.util.List;

import fr.univtours.polytech.bibliotheque.model.ArticleBean;
import fr.univtours.polytech.bibliotheque.model.UserBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ArticleDAOImplJPA implements ArticleDAO {

   // L'objet EntityManager qui va permettre d'effectuer les requêtes en BDD.
   @PersistenceContext(unitName = "bibliotheque")
   private EntityManager em;

   @SuppressWarnings("unchecked") 
   @Override
   public List<ArticleBean> getArticleList() {
       // Exemple de requête HQL (ou JPAQL).
       Query requete = em.createNativeQuery("select * from ARTICLE", UserBean.class);
       return requete.getResultList();
   }

   @Override
   public void updateArticle(ArticleBean article) {
       // TODO Auto-generated method stub
   }

<<<<<<< HEAD
        try {
            connection = ConnectionDB.createConnection();
            final String sqlInsert = "INSERT INTO ARTICLE (ID, NAME, PRICE, NBRESTANT) values (?, ?, ?, ?);";
            st = connection.prepareStatement(sqlInsert);
            st.setInt(1, article.getId());
            st.setString(2, article.getName());
            st.setFloat(3,article.getPrice());
            st.setInt(4,article.getNbRestant());
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
        }
    }

    @Override
    public void updateArticle(ArticleBean article){

    }

    private final List<ArticleBean> mapResultSetToList(final ResultSet rs) throws SQLException {
        List<ArticleBean> articleList = new ArrayList<ArticleBean>();
        while (rs.next()) {
            // Pour chaque ligne de la table,
            // on instancie un nouveau NoteBean.
            final ArticleBean articleBean = new ArticleBean();
            articleBean.setId(rs.getInt("ID")); // Il faut indiquer le nom du champ en BDD, ici, 'ID_NOTE'.
            articleBean.setName(rs.getString("NAME"));
            articleBean.setPrice(rs.getFloat("PRIX"));
            articleBean.setNbRestant(rs.getInt("NBRESTANT"));
            // On ajoute ce bean à la liste des résultats.
            articleList.add(articleBean);
        }
        return articleList;
    }
}

=======
   @Override
   public void insertArticle(ArticleBean article) {
       // Insertion d'un enregistrement en BDD.
       em.persist(article);
   }
}
>>>>>>> 06bad009e12253de3b87ab91f2b8849a4af0aa7e
