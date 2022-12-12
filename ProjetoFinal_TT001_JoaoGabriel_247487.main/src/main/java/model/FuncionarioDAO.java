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
public class FuncionarioDAO extends DAO{
    private static FuncionarioDAO instance;
    
    private FuncionarioDAO(){
        getConnection();
        createTable();
    }
    
    // Singleton
    public static FuncionarioDAO getInstance() {
        return (instance==null?(instance = new FuncionarioDAO()):instance);
    }

// CRUD    
    public Funcionario create(int rg_func, String nome_func, int tel_func, String end_func) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO cliente (rg_func, nome_func, tel_func, end_func) VALUES (?,?,?,?)");
            stmt.setInt(1, rg_func);
            stmt.setString(2, nome_func);
            stmt.setInt(3, tel_func);
            stmt.setString(4, end_func);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("funcionario","id_func"));
    }
    
    // Uma pequena gambiarra, depois explico...
    public boolean isLastEmpty(){
        Funcionario lastFuncionario = this.retrieveById(lastId("funcionario","id_func"));
        if (lastFuncionario != null) {
            return lastFuncionario.getNome_func().isBlank();
        }
        return false;
    }

    private Funcionario buildObject(ResultSet rs) {
        Funcionario funcionario = null;
        try {
            funcionario = new Funcionario(rs.getInt("id_func"), rs.getInt("rg_func"), rs.getString("nome_func"), rs.getInt("tel_func"), rs.getString("end_func"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return funcionario;
    }
    
    // Generic Retriever
    public List retrieve(String query) {
        List<Funcionario> funcionarios = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                funcionarios.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return funcionarios;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM funcionario");
    }
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM funcionario WHERE id_func = " + lastId("funcionario","id_func"));
    }

    // RetrieveById
    public Funcionario retrieveById(int id_func) {
        List<Funcionario> funcionarios = this.retrieve("SELECT * FROM funcionario WHERE id_func = " + id_func);
        return (funcionarios.isEmpty()?null:funcionarios.get(0));
    }

    // RetrieveBySimilarName
    public List retrieveBySimilarName(String nome_func) {
        return this.retrieve("SELECT * FROM funcionario WHERE nome_func LIKE '%" + nome_func + "%'");
    }

// Updade
    public void update(Funcionario funcionario) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE funcionario SET rg_func=?, nome_func=?, tel_func=?, end_func=? WHERE id_func=?");
            stmt.setInt(1, funcionario.getRg_func());
            stmt.setString(2, funcionario.getNome_func());
            stmt.setInt(3, funcionario.getTel_func());
            stmt.setString(4, funcionario.getEnd_func());
            stmt.setInt(5, funcionario.getId_func());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
        // Delete   
    public void delete(Funcionario funcionario) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM funcionario WHERE id_func = ?");
            stmt.setInt(1, funcionario.getId_func());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }    
        
}
