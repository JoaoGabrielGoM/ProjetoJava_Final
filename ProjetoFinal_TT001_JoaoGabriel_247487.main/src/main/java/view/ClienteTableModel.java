package view;

import java.util.List;
import model.Cliente;
import model.ClienteDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joaom
 */
public class ClienteTableModel extends GenericTableModel {
    
    public ClienteTableModel (List vDados){
        super(vDados, new String[]{"nome_cli","tel_cli","end_cli"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    Cliente cliente = (Cliente) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return cliente.getNome_cli();
            case 1:
                return cliente.getTel_cli();
            case 2:
                return cliente.getEnd_cli();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }    
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Cliente client = (Cliente) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                client.setNome_cli((String)aValue);
                break;
            case 1:
                client.setTel_cli((String)aValue);
                break;
            case 2:
                client.setEnd_cli((String)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
        
        ClienteDAO.getInstance().update(client);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    

    
}
