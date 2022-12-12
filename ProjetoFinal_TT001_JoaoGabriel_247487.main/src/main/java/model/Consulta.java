/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author j247487
 */
public class Consulta {
    private int id_consul;
    private int data_consul;
    private int hor_consul;
    private String sint_consul;
    private int num_sess_consul;

    public Consulta(int id_consul, int data_consul, int hor_consul, String sint_consul, int num_sess_consul) {
        this.id_consul = id_consul;
        this.data_consul = data_consul;
        this.hor_consul = hor_consul;
        this.sint_consul = sint_consul;
        this.num_sess_consul = num_sess_consul;
    }

    public int getId_consul() {
        return id_consul;
    }

    public int getData_consul() {
        return data_consul;
    }

    public void setData_consul(int data_consul) {
        this.data_consul = data_consul;
    }

    public int getHor_consul() {
        return hor_consul;
    }

    public void setHor_consul(int hor_consul) {
        this.hor_consul = hor_consul;
    }

    public String getSint_consul() {
        return sint_consul;
    }

    public void setSint_consul(String sint_consul) {
        this.sint_consul = sint_consul;
    }

    public int getNum_sess_consul() {
        return num_sess_consul;
    }

    public void setNum_sess_consul(int num_sess_consul) {
        this.num_sess_consul = num_sess_consul;
    }
    
    
};
