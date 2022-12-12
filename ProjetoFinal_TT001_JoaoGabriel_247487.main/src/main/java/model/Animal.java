/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author j247487
 */
public class Animal {
    private int id_anim;
    private String nome_anim;
    private int idade_anim;
    private String espc_anim;
    private String raca_anim;

    
    
    public Animal(int id_anim, String nome_anim, int idade_anim, String espc_anim, String raca_anim) {
        this.id_anim = id_anim;
        this.nome_anim = nome_anim;
        this.idade_anim = idade_anim;
        this.espc_anim = espc_anim;
        this.raca_anim = raca_anim;
    }

    //getters e setters
    
    public int getId_anim() {
        return id_anim;
    }

    public String getNome_anim() {
        return nome_anim;
    }

    public void setNome_anim(String nome_anim) {
        this.nome_anim = nome_anim;
    }

    public int getIdade_anim() {
        return idade_anim;
    }

    public void setIdade_anim(int idade_anim) {
        this.idade_anim = idade_anim;
    }

    public String getEspc_anim() {
        return espc_anim;
    }

    public void setEspc_anim(String espc_anim) {
        this.espc_anim = espc_anim;
    }

    public String getRaca_anim() {
        return raca_anim;
    }

    public void setRaca_anim(String raca_anim) {
        this.raca_anim = raca_anim;
    }
    
    //retorna printa toda vez que chamar o toString da classe
    @Override
    public String toString() {
    return "Animal{" +
      "name='" + this.nome_anim + '}';
  }
    
}
