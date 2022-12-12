/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaom
 */
public class ConsultaDAO extends DAO {
    private static ConsultaDAO instance;
    
    private ConsultaDAO(){
        getConnection();
        createTable();
    }
    
    public static ConsultaDAO getInstance(){
        return (instance==null?(instance = new ConsultaDAO()):instance);
    }
    
    // CRUD    
    public Consulta create(int data_consul, int hor_consul, String sint_consul, int num_sess_consul ) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consulta (data_consul, hor_consul, sint_consul, num_sess_consul) VALUES (?,?,?,?)");
            stmt.setInt(1, data_consul);
            stmt.setInt(2, hor_consul);
            stmt.setString(3, sint_consul);
            stmt.setInt(4, num_sess_consul);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("consulta","id_consul"));
    }
    
    // Uma pequena gambiarra, depois explico...
    public boolean isLastEmpty(){
        Consulta lastConsulta = this.retrieveById(lastId("cliente","id"));
        if (lastConsulta != null) {
            return lastConsulta.getSint_consul().isBlank();
        }
        return false;
    }

    private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        try {
            consulta = new Consulta(rs.getInt("id_consul"), rs.getInt("data_consul"), rs.getInt("hor_consul"), rs.getString("sint_consul"), rs.getInt("num_sess_consul"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consulta;
    }
    
    // Generic Retriever
    public List retrieve(String query) {
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consultas;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM consulta");
    }
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM consulta WHERE id_consul = " + lastId("consulta","id_consul"));
    }

    // RetrieveById
    public Consulta retrieveById(int id_consul) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta WHERE id_consul = " + id_consul);
        return (consultas.isEmpty()?null:consultas.get(0));
    }
    
    // Updade
    public void update(Consulta consulta) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET data_consul=?, hor_consul=?, sint_consul=?, num_sess_consul=? WHERE id_consul=?");
            stmt.setInt(1, consulta.getData_consul());
            stmt.setInt(2, consulta.getHor_consul());
            stmt.setString(3, consulta.getSint_consul());
            stmt.setInt(4, consulta.getNum_sess_consul());
            stmt.setInt(5, consulta.getId_consul());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
        // Delete   
    public void delete(Consulta consulta) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM consulta WHERE id_consul = ?");
            stmt.setInt(1, consulta.getId_consul());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
