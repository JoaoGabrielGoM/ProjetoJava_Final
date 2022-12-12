/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Animal;
import model.AnimalDAO;

/**
 *
 * @author joaom
 */
public class AnimalTableModel extends GenericTableModel {
    
    public AnimalTableModel (List vDados){
        super (vDados, new String[]{"nome_anim","idade_anim","espc_anim","raca_anim"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0:
                return String.class;
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
        Animal animal = (Animal) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return animal.getNome_anim();
            case 1:
                return animal.getIdade_anim();
            case 2:
                return animal.getEspc_anim();
            case 3:
                return animal.getRaca_anim();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
     @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        Animal animal = (Animal) vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                animal.setNome_anim((String)aValue);
                break;
            case 1:
                animal.setIdade_anim((Integer)aValue);
                break;
            case 2:
                animal.setEspc_anim((String)aValue);
                break;
            case 3:
                animal.setRaca_anim((String)aValue);
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");

        }
        
        AnimalDAO.getInstance().update(animal);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    
}
