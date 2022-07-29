/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;



import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.concurrent.Task;
import util.ConnectionFactory;
import model.Tasks;
// esta classe tem por funcao ser uma controladora de acoes na entidade tarefas(tasks) do banco de dados
// portanto ela tem um metodo para cada um das acoes do usuario: salvar, atualizar, deletar e listar as tarefas de um projeto

public class TaskController {
        
        public void Save(Tasks task){
            
            String sql="INSERT INTO tasks (idproject,name, description,completed,notes,deadline,createAt,updateAt"
                    + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";// comando sql que sera executado no banco de dados
            //salvar informacoes nas colunas descritas as informacoes nos pontos de interrogacoes
            Connection connection=null; // prepara a variavel que estabelece a conexao
            PreparedStatement statement= null; // prepara os comandos que serao executados no banco de dados
            
            try{
                connection = ConnectionFactory.getConnection();// estabelece a conexao
                statement= connection.prepareStatement(sql);// prepara o comando
                statement.setInt(1,task.getIdproject());// pega cada um dos valores das colunas da tabela do banco de dados
                // e da um valor para cada um dos pontos de interrogacao.
                statement.setString(2,task.getName());
                statement.setString(3,task.getDescription());
                statement.setBoolean(4,task.isCompleted());
                statement.setString(5, task.getNotes());
                statement.setDate(6, new Date(task.getDeadline().getTime()));
                statement.setDate(7, new Date(task.getCreateAt().getTime()));
                statement.setDate(8, new Date(task.getUpdateAt().getTime()));
                statement.execute();// executa o comando sql com todas as informacoes setadas acima;
                
                
            }catch(Exception ex){
                
            throw new RuntimeException("Erro ao salvar a tarefa"+ ex.getMessage(),ex);
            
            }finally{
              ConnectionFactory.closeConnection(connection,statement); // fecha a conexao e o statement
              // aqui eu uso o metodo close connection que tem como parametro tambem o statement
            }
    }
        
    
        public void update(Tasks task){
            String sql= "UPDATE tasks SET idproject= ?, "
                    + "name= ?, description= ?, completed= ?,"
                    + " notes= ?, deadline= ?, createAt= ?, updateAt= ? WHERE id= ?";
            
            Connection connection=null;
            PreparedStatement statement=null;
            
            try{
                //estabelecendo a conexao com o banco de dados
                connection = ConnectionFactory.getConnection();// estabelece a conexao
                
                // preparando a query(consulta)
                statement= connection.prepareStatement(sql);// prepara o comando
                
                // setando os valores do statement
                statement.setInt(1,task.getIdproject());// pega cada um dos valores das colunas da tabela do banco de dados
                // e da um valor para cada um dos pontos de interrogacao.
                statement.setString(2,task.getName());
                statement.setString(3,task.getDescription());
                statement.setBoolean(4,task.isCompleted());
                statement.setString(5, task.getNotes());
                statement.setDate(6, new Date(task.getDeadline().getTime()));
                statement.setDate(7, new Date(task.getCreateAt().getTime()));
                statement.setDate(8, new Date(task.getUpdateAt().getTime()));
                statement.setInt(9,task.getId());
                
                //executando a query
                statement.execute();// executa o comando sql com todas as informacoes setadas acima;
                
                
            }catch(Exception ex){
                
            throw new RuntimeException("Erro ao atualizar a tarefa"+ ex.getMessage(),ex);
            
            }finally{
              ConnectionFactory.closeConnection(connection,statement); // fecha a conexao e o statement
              // aqui eu uso o metodo close connection que tem como parametro tambem o statement
            }
            
            
        
    }
        public void removeById(int taskId){
            String sql ="DELETE FROM tasks WHERE ID= ?";
            Connection connection=null;
            PreparedStatement statement=null;
            
            try{
                connection=ConnectionFactory.getConnection();
                statement=connection.prepareStatement(sql); // prepara o comando sql a ser executado no banco de dados
                statement.setInt(1, taskId);// aqui eh passado o numero do id que ira substituir o pondo de interrogacao o
                // ponto de interrogacao no comando sql acima
                statement.execute();
            }catch(Exception ex){
                throw new RuntimeException("Erro ao deletar a tarefa"+ex.getMessage(),ex);
            
            }finally{//sempre vai ser executado
                ConnectionFactory.closeConnection(connection,statement);// fecha a conexao conn aberta
            }
            
    }
        public List<Tasks> getAll(int idproject){// devolve uma lista de tarefas
            
            String sql="SELECT * FROM tasks WHERE idproject= ? ";
            
            Connection connection=null;
            PreparedStatement statement=null;
            ResultSet resultSet=null;// retorna o resultado dos valores selecionados na tabela
            
            // lista de tarefas que sera devolvida quando a chamada do metodo acontecer
            List<Tasks> tasks= new ArrayList<Tasks>();
            
            try{
               connection=ConnectionFactory.getConnection();
                statement=connection.prepareStatement(sql); // prepara o comando sql a ser executado no banco de dados
                statement.setInt(1, idproject);
                resultSet=statement.executeQuery();
                
                while(resultSet.next()){
                
                    Tasks task= new Tasks();
                    task.setId(resultSet.getInt("id"));
                    task.setIdproject(resultSet.getInt("idproject"));
                    task.setName(resultSet.getString("name"));
                    task.setDescription(resultSet.getString("description"));
                    task.setCompleted(resultSet.getBoolean("completed"));
                    task.setNotes(resultSet.getString("notes"));
                    task.setDeadline(resultSet.getDate("deadline"));
                    task.setCreateAt(resultSet.getDate("createAt"));
                    task.setUpdateAt(resultSet.getDate("updateAt"));
                    tasks.add(task);
                }
                
                
            }catch(Exception ex){
              throw new RuntimeException("Erro ao selecionar a tarefa"+ex.getMessage(),ex);
            
            }finally{//sempre vai ser executado
                ConnectionFactory.closeConnection(connection,statement,resultSet);// fecha a conexao, o statement, o resultSet
            }
            
            
            
        // devolve a lista de tarefas
            return tasks;
        }

    
}
