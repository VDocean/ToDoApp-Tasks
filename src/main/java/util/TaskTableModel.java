/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

//implementa o model da componente Jtable

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.concurrent.Task;
import javax.swing.table.AbstractTableModel;
import model.Tasks;

public class TaskTableModel extends AbstractTableModel{// faco heranca dessa classe para trabalhar o Jtable
    String[] columns={"Nome","Prazo","Descrição","Tarefa Concluída","Editar","Excluir"};// vetor com os nomes das minhas colunas
    List<Tasks> tasks=new ArrayList();
    // metdos abstratos da classe AbstractTableModel, se eu nao adiciono, minha classe fica com erro
    
    @Override
    public int getRowCount() {// contrala a quanitdade de linhas do JTable
        
     return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    
    public String getColumnName(int columnIndex){
        return columns[columnIndex];// retorna o nome da coluna na posicao desejada
    
    }
    @Override
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        if (columnIndex==3){
         return true;
        }
        return false;
    }
    
    @Override
    
    public Class<?> getColumnClass(int columnIndex){
        
        if(tasks.isEmpty()){
         return Object.class;
        }
        return this.getValueAt(0, columnIndex).getClass();// retorna o tipo de dados que estao na coluna especificada
        //se String, Date, int etc
    
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {// retorna o valor de uma linha e coluna dada
        
        switch(columnIndex){
            case 0:
                return tasks.get(rowIndex).getName();
            
            case 1:
                return tasks.get(rowIndex).getDescription();
            case 2:
                
                SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
                return dateformat.format(tasks.get(rowIndex).getDeadline());
                
            case 3:
                return tasks.get(rowIndex).isCompleted();
            case 4:
                return "";
            case 5:
                return "";
               
            default:
                return "dados não encontrados";
                
        }
        
    }
    
    

    public void setValueAt(Object aValue, int rowIndex, int columnIndex ){
        tasks.get(rowIndex).setCompleted((boolean) aValue);// altera o estado de conclusao da tarefa
    
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
    
            
        
    
}
