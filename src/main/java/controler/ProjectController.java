
package controler;
// primeiro fazer os metodos de acao do usuario

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Projects;
import util.ConnectionFactory;



public class ProjectController {
    
    public void save(Projects project){
         String sql="INSERT INTO projects(name, description, createAt, updateAt) VALUES (?, ?, ?, ?)";
         //String sql="INSERT INTO projects(name, description) VALUES (?, ?)";
          Connection connection=null; // prepara a variavel que estabelece a conexao
          PreparedStatement statement=null;
          
          try{
             connection = ConnectionFactory.getConnection();// estabelece a conexao
             statement= connection.prepareStatement(sql);// prepara o comando
        
             
             statement.setString(1,project.getName());
             statement.setString(2,project.getDescription());
             statement.setDate(3,new Date(project.getCreateAt().getTime()));
             statement.setDate(4,new Date(project.getUpdateAt().getTime()));
             statement.execute();
             
              
          }catch(Exception ex){
              throw new RuntimeException("Erro ao salvar a tarefa "+ ex.getMessage(),ex);
          }
          finally{
              ConnectionFactory.closeConnection(connection,statement);
             
          }
          
          
    }
    
    public void Update(Projects project){
        
        String sql= "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
            
            Connection connection=null;
            PreparedStatement statement=null;
            
                 
            try{
                //estabelecendo a conexao com o banco de dados
                connection = ConnectionFactory.getConnection();// estabelece a conexao
                
                // preparando a query(consulta)
                statement= connection.prepareStatement(sql);// prepara o comando
                
                // setando os valores do statement
       
                statement.setString(1,project.getName());
                statement.setString(2,project.getDescription());
                statement.setDate(3, new java.sql.Date(project.getCreateAt().getTime()));
                statement.setDate(4, new java.sql.Date(project.getUpdateAt().getTime()));
                statement.setInt(5, project.getId());
                
                //executando a query
                statement.execute();// executa o comando sql com todas as informacoes setadas acima;
                
                
            }catch(Exception ex){
                
            throw new RuntimeException("Erro ao atualizar a tarefa"+ ex.getMessage(),ex);
            
            }finally{
              ConnectionFactory.closeConnection(connection,statement); // fecha a conexao e o statement
              // aqui eu uso o metodo close connection que tem como parametro tambem o statement
            }
    
    }
    
    public void removeById(int projectId){
        String sql ="REMOVE FROM projects WHERE ID= ?";
            Connection connection=null;
            PreparedStatement statement=null;
            
            try{
                connection=ConnectionFactory.getConnection();
                statement=connection.prepareStatement(sql); // prepara o comando sql a ser executado no banco de dados
                statement.setInt(1, projectId);// aqui eh passado o numero do id que ira substituir o pondo de interrogacao o
                // ponto de interrogacao no comando sql acima
                statement.execute();
            }catch(Exception ex){
                throw new RuntimeException("Erro ao deletar a tarefa"+ex.getMessage(),ex);
            
            }finally{//sempre vai ser executado
                ConnectionFactory.closeConnection(connection,statement);// fecha a conexao conn aberta
            }
    
    }
    
    public List<Projects> getAll(){
        //String sql="SELECT * FROM projects WHERE id= ? ";
          String sql="SELECT * FROM projects ";

            
            Connection connection=null;
            PreparedStatement statement=null;
            ResultSet resultSet=null;// retorna o resultado dos valores selecionados na tabela
            
            // lista de tarefas que sera devolvida quando a chamada do metodo acontecer
            List<Projects> projects= new ArrayList<Projects>();
            
            try{
               connection=ConnectionFactory.getConnection();
                statement=connection.prepareStatement(sql); // prepara o comando sql a ser executado no banco de dados
                //statement.setInt(1,idproject);
                resultSet=statement.executeQuery();
                
                while(resultSet.next()){
                
                    Projects project=new Projects();
                    project.setId(resultSet.getInt("id"));
                    project.setName(resultSet.getString("name"));
                    project.setDescription(resultSet.getString("description"));
                    project.setCreateAt(resultSet.getDate("createAt"));
                    project.setUpdateAt(resultSet.getDate("updateAt"));
                    projects.add(project);
                }
                
                
            }catch(Exception ex){
              throw new RuntimeException("Erro ao selecionar a tarefa "+ex.getMessage(),ex);
            
            }finally{//sempre vai ser executado
                ConnectionFactory.closeConnection(connection,statement,resultSet);// fecha a conexao, o statement, o resultSet
            }
            
    
    
             return projects;
    }
    
    
}
