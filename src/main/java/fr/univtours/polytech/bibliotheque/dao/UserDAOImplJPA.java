package fr.univtours.polytech.bibliotheque.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import fr.univtours.polytech.bibliotheque.model.UserBean;
import jakarta.ejb.Stateless;

@Stateless
public class UserDAOImplJPA implements UserDAO {

    @Override
    public List<UserBean> getUserList() {

        Statement st = null;
        ResultSet rs = null;
        Connection connection = null;
        List<UserBean> userList = null;

        try {
            // Lecture de la table NOTE :
            final String sql = "SELECT login, name, password from boutique.USER;";
            connection = ConnectionDB.createConnection();
            st = connection.createStatement();
            rs = st.executeQuery(sql);
            userList = mapResultSetToList(rs);
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
        }
    }

        @Override
        public void updateUser(UserBean user){
    
        }
    
        private final List<UserBean> mapResultSetToList(final ResultSet rs) throws SQLException {
            List<UserBean> userList = new ArrayList<UserBean>();
            while (rs.next()) {
                // Pour chaque ligne de la table,
                // on instancie un nouveau NoteBean.
                final UserBean userBean = new UserBean();
                userBean.setLogin(rs.getString("login")); // Il faut indiquer le nom du champ en BDD, ici, 'ID_NOTE'.
                userBean.setName(rs.getString("name "));
                userBean.setPassword(rs.getString("password"));
                // On ajoute ce bean à la liste des résultats.
                userList.add(userBean);
            }
            return userList;
        }
}
