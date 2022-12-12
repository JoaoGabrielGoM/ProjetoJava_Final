/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.FuncionarioDAO;
import model.Funcionario;

/**
 *
 * @author joaom
 */
public class FuncionarioTableModel extends GenericTableModel{
    
    public FuncionarioTableModel (List vDados){
        super (vDados, new String[]{"rg_func","nome_func","tel_func","end_func"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
Funcionario funcionario = (Funcionario) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return funcionario.getRg_func();
            case 1:
                return funcionario.getNome_func();
            case 2:
                return funcionario.getTel_func();
            case 3:
                return funcionario.getEnd_func();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
            }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Funcionario funcionario = (Funcionario) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                funcionario.setRg_func((Integer)aValue);
                break;
            case 1:
                funcionario.setNome_func((String)aValue);
                break;
            case 2:
                funcionario.setTel_func((Integer)aValue);
                break;
            case 3:
                funcionario.setEnd_func((String)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
        
        FuncionarioDAO.getInstance().update(funcionario);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    
    
}
