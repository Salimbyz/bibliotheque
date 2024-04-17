package fr.univtours.polytech.bibliotheque.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.univtours.polytech.bibliotheque.model.ArticleBean;
import jakarta.ejb.Stateless;

@Stateless
public class ArticleDAOImplJPA implements ArticleDAO {

    @Override
    public List<ArticleBean> getArticleList() {
        Statement st = null;
        ResultSet rs = null;
        Connection connection = null;
        List<ArticleBean> articleList = null;

        try {
            // Lecture de la table NOTE :
            final String sql = "SELECT ID, NAME, PRICE, NBRESTANT from boutique.ARTICLE;";
            connection = ConnectionDB.createConnection();
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            articleList = mapResultSetToList(rs);
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
        return articleList;
    }

    @Override
    public void insertArticle(ArticleBean article) {
        // On utilisera ici des PreparedStatement plutôt que des Statement pour des
        // raisons de sécurité.
        PreparedStatement st = null;
        Connection connection = null;

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
        articleBean.setNbRestant(rs.getInt("NBRESTANT")));
        // On ajoute ce bean à la liste des résultats.
        articleList.add(articleBean);
    }
    return articleList;
}
}