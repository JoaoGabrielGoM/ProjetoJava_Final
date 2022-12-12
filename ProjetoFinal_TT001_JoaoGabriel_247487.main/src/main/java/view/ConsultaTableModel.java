/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.ConsultaDAO;
import model.Consulta;

/**
 *
 * @author joaom
 */
public class ConsultaTableModel extends GenericTableModel {
    
    public ConsultaTableModel (List vDados){
        super (vDados, new String[]{"data_consul","hor_consul","sint_consul","num_sess_consul"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    
   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return consulta.getData_consul();
            case 1:
                return consulta.getHor_consul();
            case 2:
                return consulta.getSint_consul();
            case 3:
                return consulta.getNum_sess_consul();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
            }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Consulta consulta = (Consulta) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                consulta.setData_consul((Integer)aValue);
                break;
            case 1:
                consulta.setHor_consul((Integer)aValue);
                break;
            case 2:
                consulta.setSint_consul((String)aValue);
                break;
            case 3:
                consulta.setNum_sess_consul((Integer)aValue);
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
        
        ConsultaDAO.getInstance().update(consulta);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    
}
