package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author j247487
 */
public class Cliente {
    //atributos
    
    private int id;
    private String nome_cli;
    private String tel_cli;
    private String end_cli;
    
    //construct
    
     public Cliente(int id, String nome_cli, String tel_cli, String end_cli) {
        this.id = id;
        this.nome_cli = nome_cli;
        this.tel_cli = tel_cli;
        this.end_cli = end_cli;
    }
    
    //get-setters
     
    public int getId() {
        return id;
    }

    public String getNome_cli() {
        return nome_cli;
    }

    public void setNome_cli(String nome_cli) {
        this.nome_cli = nome_cli;
    }

    public String getTel_cli() {
        return tel_cli;
    }

    public void setTel_cli(String tel_cli) {
        this.tel_cli = tel_cli;
    }

    public String getEnd_cli() {
        return end_cli;
    }

    public void setEnd_cli(String end_cli) {
        this.end_cli = end_cli;
    }   
   
}
