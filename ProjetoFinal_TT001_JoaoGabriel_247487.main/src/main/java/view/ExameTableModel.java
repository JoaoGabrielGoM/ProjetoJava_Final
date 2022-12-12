/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.ExameDAO;
import model.Exame;

/**
 *
 * @author joaom
 */
public class ExameTableModel extends GenericTableModel{
    
     public ExameTableModel (List vDados){
        super (vDados, new String[]{"resultados_exame"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
 Exame exame = (Exame) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return exame.getResultados_exame();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Exame exame = (Exame) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                exame.setResultados_exame((String)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
        
        ExameDAO.getInstance().update(exame);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    
    
}
