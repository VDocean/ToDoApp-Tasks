/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoApp;

import controler.ProjectController;
import controler.TaskController;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Projects;
import model.Tasks;
import util.ConnectionFactory;
public class TodoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Connection c=ConnectionFactory.getConnection();// coloca a conexao aberta na variavel tipo connection
         ConnectionFactory.closeConnection(c); //fecha a conexao de c
         
         ProjectController projectController= new ProjectController();
         Projects project=new Projects();
         Date hoje= new Date();
         project.setName("teste");
         project.setDescription("Start by Caphgemini");
         project.setCreateAt(hoje);
         project.setUpdateAt(hoje);
         projectController.save(project);
         
         //project.setName("Novo nome");
         //projectController.Update(project);
         //List<Projects> projects= projectController.getAll(1);
         
         //System.out.println("A lista total de projetos eh "+projects.size());
         
         //TaskController taskController=new TaskController();
         //Tasks task=new Tasks();
         //task.setIdproject(1);
         //task.setName("teste");
         //task.setDescription("capgemini");
         //task.setCompleted(true);
         //task.setNotes("dkjskfjd");
         //task.setDeadline(1993/05/05);
        // task.setCreateAt(createAt);
        // task.setUpdateAt(updateAt);
        
        
         
         
        // project.setDescription("Start by Caphgemini");
         //taskController.Save(task);
    }
    
}
