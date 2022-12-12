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
 * @author j247487
 */
public class AnimalDAO extends DAO {
    private static AnimalDAO instance;
    
    private AnimalDAO() {
        getConnection();
        createTable();
    }
    
    public static AnimalDAO getInstance() {
        return (instance==null?(instance = new AnimalDAO()):instance);
    }
    
//CRUD
    public Animal create(String nome_anim, int idade_anim, String espc_anim, String raca_anim){
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO animal (nome_anim, idade_anim, espc_anim, raca_anim) VALUES (?,?,?,?)");
            stmt.setString(1, nome_anim);
            stmt.setInt(2, idade_anim);
            stmt.setString(3, espc_anim);
            stmt.setString(4, raca_anim);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("animal","id_anim"));
    }
    
     public boolean isLastEmpty(){
        Animal lastAnimal = this.retrieveById(lastId("animal","id_anim"));
        if (lastAnimal != null) {
            return lastAnimal.getNome_anim().isBlank();
        }
        return false;
    }
     
    private Animal buildObject(ResultSet rs) {
        Animal animal = null;
        try {
            animal = new Animal(rs.getInt("id_anim"), rs.getString("nome_anim"), rs.getInt("idade_anim"), rs.getString("espc_anim"), rs.getString("raca_anim"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animal;
    }
    
    // Generic Retriever
    public List retrieve(String query) {
        List<Animal> animais = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                animais.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return animais;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM animal");
    }
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM animal WHERE id_anim = " + lastId("animal","id_anim"));
    }

    // RetrieveById
    public Animal retrieveById(int id_anim) {
        List<Animal> animais = this.retrieve("SELECT * FROM animal WHERE id_anim = " + id_anim);
        return (animais.isEmpty()?null:animais.get(0));
    }

    // RetrieveBySimilarName
    public List retrieveBySimilarName(String nome_anim) {
        return this.retrieve("SELECT * FROM animal WHERE nome_anim LIKE '%" + nome_anim + "%'");
    }

// Updade
    public void update(Animal animal) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE animal SET nome_anim=?, idade_anim=?, espc_anim=?, raca_anim=? WHERE id_anim=?");
            stmt.setString(1, animal.getNome_anim());
            stmt.setInt(2, animal.getIdade_anim());
            stmt.setString(3, animal.getEspc_anim());
            stmt.setString(4, animal.getRaca_anim());
            stmt.setInt(5, animal.getId_anim());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
        // Delete   
    public void delete(Animal animal) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM animal WHERE id_anim = ?");
            stmt.setInt(1, animal.getId_anim());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }    
    
}
