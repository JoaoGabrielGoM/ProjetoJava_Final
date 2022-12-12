package model;


// DAO Implementation for SQLite.
/**
 * @author Prof. Dr. Plínio Vilela - prvilela@unicamp.br
 * @date 16 de Agosto de 2021
 */
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO {
    public static final String DBURL = "jdbc:sqlite:D:\\testdb.db";
    private static Connection con;
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Connect to SQLite
    public static Connection getConnection() {
        if (con == null) {
            try {
                //Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection(DBURL);
                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        return con;
    }

    protected ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;
        try {
            s = (Statement) con.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return rs;
    }

    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    protected int lastId(String tableName, String primaryKey) {
        Statement s;
        int lastId = -1;
        try {
            s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(" + primaryKey + ") AS id FROM " + tableName);
            if (rs.next()) {
                lastId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return lastId;
    }

    public static void terminar() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    // Create table SQLite
    protected final boolean createTable() {
        try {
            PreparedStatement stmt;
            // Table client:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS cliente( \n"
                    + "id INTEGER PRIMARY KEY, \n"
                    + "nome_cli VARCHAR, \n"
                    + "tel_cli INTEGER, \n"
                    + "end_cli VARCHAR); \n");
            executeUpdate(stmt);
            // Table animal:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS animal( \n"
                    + "id_anim INTEGER PRIMARY KEY, \n"
                    + "nome_anim VARCHAR, \n"
                    + "idade_anim INTEGER, \n"
                    + "espc_anim VARCHAR, \n"
                    + "raca_anim VARCHAR); \n");
            executeUpdate(stmt);
            // Table funcionario:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS funcionario( \n"
                    + "rg_func INTEGER PRIMARY KEY, \n"
                    + "id_func INTEGER, \n"
                    + "nome_func VARCHAR, \n"
                    + "tel_func INTEGER, \n"
                    + "end_func VARCHAR); \n");
            executeUpdate(stmt);        
            // Table exame:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS exame( \n"
                    + "id_exame INTEGER PRIMARY KEY, \n"
                    + "id_anim INTEGER, \n"
                    + "resultador VARCHAR); \n");
            executeUpdate(stmt);
            // Table consulta:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS consulta( \n"
                    + "num_consul INTEGER PRIMARY KEY, \n"
                    + "data_consul INTEGER, \n"
                    + "hor_consul INTEGER, \n"
                    + "sint_consul VARCHAR, \n"
                    + "num_sess_consul INTEGER, \n"
                    + "id_animal INTEGER, \n"
                    + "id_func INTEGER); \n");
            executeUpdate(stmt);            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
