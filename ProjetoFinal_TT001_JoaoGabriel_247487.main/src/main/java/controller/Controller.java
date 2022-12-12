/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.text.ParseException;
import java.util.List;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;
import model.Exame;
import model.ExameDAO;
import model.Funcionario;
import model.FuncionarioDAO;
import view.AnimalTableModel;
import view.ClienteTableModel;
import view.ConsultaTableModel;
import view.ExameTableModel;
import view.FuncionarioTableModel;
import view.GenericTableModel;

/**
 *
 * @author joaom
 */
public class Controller {

    private static Cliente clienteSelecionado = null;
    private static Animal animalSelecionado = null;
    private static Exame exameSelecionado = null;
    private static Consulta consultaSelecionado = null;
    private static Funcionario funcionarioSelecionado = null;
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;
    private static JTextField exameSelecionadoTextField = null;
    private static JTextField consultaSelecionadoTextField = null;
    private static JTextField funcionarioSelecionadoTextField = null;

    public static void setTextFields (JTextField NomeCli_TextField, JTextField animal){
        clienteSelecionadoTextField = NomeCli_TextField;
        animalSelecionadoTextField = animal;
    }
    
    public static void setTableModel(JTable table, GenericTableModel tableModel){
        table.setModel(tableModel);
    }

    public static void setSelected(Object selected) {
        if (selected instanceof Cliente){
            clienteSelecionado = (Cliente)selected;
            clienteSelecionadoTextField.setText(clienteSelecionado.getNome_cli());
        } else if (selected instanceof Animal){
            animalSelecionado = (Animal)selected;
            animalSelecionadoTextField.setText(animalSelecionado.getNome_anim());

        }
    }
    
    //deletar
    
    public static void apagaCliente(Cliente cliente) {
        ClienteDAO.getInstance().delete(cliente);
    }
    
    public static void apagaAnimal(Animal animal) {
        AnimalDAO.getInstance().delete(animal);
    }
    
    public static void apagaConsulta(Consulta consulta) {
        ConsultaDAO.getInstance().delete(consulta);
    }
    
    public static void apagaExame(Exame exame) {
        ExameDAO.getInstance().delete(exame);
    }
  
    public static void apagaFuncionario(Funcionario funcionario) {
        FuncionarioDAO.getInstance().delete(funcionario);
    }
 
    
    //selecionar
    
    public static Cliente getClienteSelecionado() {
            return clienteSelecionado;
        }
        
        public static Animal getAnimalSelecionado() {
            return animalSelecionado;
        }
        
        public static Funcionario getFuncionarioSelecionado() {
            return funcionarioSelecionado;
        }
        
        public static Exame getExameSelecionado() {
            return exameSelecionado;
        }
        
        public static Consulta getConsultaSelecionado() {
            return consultaSelecionado;
        }
    
    //Busca por nome
    
    public static void atualizaClientesNomeSimilar(JTable table, String nomeParecido){
        
        if (table.getModel() instanceof ClienteTableModel){
            ((GenericTableModel)table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveBySimilarName(nomeParecido));
        }
        
    }
    
    public static void atualizaFuncionariosNomeSimilar(JTable table, String nomeParecido){
        
        if (table.getModel() instanceof ClienteTableModel){
            ((GenericTableModel)table.getModel()).addListOfItems(FuncionarioDAO.getInstance().retrieveBySimilarName(nomeParecido));
        }
        
    }
    
    public static void atualizaAnimaisNomeSimilar(JTable table, String nomeParecido){
        
        if (table.getModel() instanceof ClienteTableModel){
            ((GenericTableModel)table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveBySimilarName(nomeParecido));
        }
        
    }
    
     public static void jRadioButtonClientesSelecionado(JTable table) {
            setTableModel(table, new ClienteTableModel(ClienteDAO.getInstance().retrieveAll()));
        }
    
    //retrieves all
   
    public static void jRadioButtonFuncionarioSelecionado(JTable table) {
        setTableModel(table, new FuncionarioTableModel(FuncionarioDAO.getInstance().retrieveAll()));
    }
    
    public static void jRadioButtonExameSelecionado(JTable table) {
        setTableModel(table, new ExameTableModel(ExameDAO.getInstance().retrieveAll()));
    }
    
    public static void jRadioButtonConsultasSelecionado(JTable table) {
        setTableModel(table, new ConsultaTableModel(ConsultaDAO.getInstance().retrieveAll()));
    }
    
    public static void jRadioButtonAnimaisSelecionado(JTable table) {
        setTableModel(table, new AnimalTableModel(AnimalDAO.getInstance().retrieveAll()));
    }
    
    // Função genérica para o funcionamento do botão NOVO (das entidades)
        public static boolean adicionarEntidade(JTable table) throws ParseException {
            if (table.getModel() instanceof ClienteTableModel) {
                ((GenericTableModel)table.getModel()).addItem(Controller.adicionaCliente("","",""));
                return true;
            }
            else if (table.getModel() instanceof AnimalTableModel) {
                ((GenericTableModel)table.getModel()).addItem(adicionaAnimal("", 0, "", ""));
                return true;
            }
            /*
            else if (table.getModel() instanceof ExameTableModel) {
                ((GenericTableModel)table.getModel()).addItem(adicionaExame("", 0));
                return true;
            }
            */
            else if (table.getModel() instanceof FuncionarioTableModel) {
                ((GenericTableModel)table.getModel()).addItem(adicionaFuncionario(0, "", 0, ""));
                return true;
            }
                return false;
        }
    
    //Cadastro
    
    public static Cliente adicionaCliente(String nome_cli, String tel_cli, String end_cli){
        return ClienteDAO.getInstance().create(nome_cli, tel_cli, end_cli);
    }
    
    public static Animal adicionaAnimal(String nome_anim, int idade_anim, String espc_anim, String raca_anim) {
        return AnimalDAO.getInstance().create(nome_anim, idade_anim, espc_anim, raca_anim);
    }
        
    public static Funcionario adicionaFuncionario(int rg_func, String nome_func, int tel_func, String end_func) {
        return FuncionarioDAO.getInstance().create(rg_func, nome_func, tel_func, end_func);
    }
    
    public static Exame adicionaExame(String nome, int id_consulta) {
        return ExameDAO.getInstance().create(nome);
    }
    
    public static Consulta adicionaConsulta(int data_consul, int hor_consul, String sint_consul, int num_sess_consul) {
        return ConsultaDAO.getInstance().create(data_consul, hor_consul, sint_consul, num_sess_consul);
    }
}
