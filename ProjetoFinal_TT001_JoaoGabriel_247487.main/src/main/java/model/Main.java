/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/* -------------- MAIN TESTE -------------- */

import java.util.List;

/**
 *
 * @author j247487
 */
public class Main {
    public static void main(String[] args) {
        
        //print teste cliente (com erros?)
        
        /*
        
        Cliente c1 = new Cliente(1,"AAAAAAA",1234,"CASA DO CAIXA PREGO");
        
        ClienteDAO.getInstance().create("AAAAAAA",1234,"CASA DO CAIXA PREGO");
        
        //Cliente c1 = ClienteDAO.getInstance().retriveById(1);
        
        System.out.println(c1);

        */
        
        //print teste animal
        
        Animal a1 = new Animal(2,"auau",13,"cachorro","cacjp");
        AnimalDAO.getInstance().create("auau",13,"cachorro","cacjp");
        System.out.println(a1);
    }
}
