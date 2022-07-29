/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author barbara
 */
public class Tasks {
    private int id;
    private int idproject;
    private String name;
    private String description;
    private boolean completed;
    private String notes;
    private Date deadline;
    private Date createAt;
    private Date updateAt;

    public Tasks(int id, int idproject, String name, String description, boolean completed, String notes, Date deadline, Date createAt, Date updateAt) {
        this.id = id;
        this.idproject = idproject;
        this.name = name;
        this.description = description;
        this.completed = completed;
        this.notes = notes;
        this.deadline = deadline;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
    
    public Tasks(){ // obs uma classe pode ter mais de um metodo construtor contanto que tenha parametros diversos
       this.createAt=new Date();// portanto quando chamar esse metodo sem parametro significa que estou criando
       //uma nova tarefa com uma data de criacao no momento que crio o onjeto
       this.deadline = new Date();
       this.updateAt=new Date();
       

    
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdproject() {
        return idproject;
    }

    public void setIdproject(int idproject) {
        this.idproject = idproject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "Tasks{" + "id=" + id + ", idproject=" + idproject + ", name=" + name + ", description=" + description + ", completed=" + completed + ", notes=" + notes + ", deadline=" + deadline + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
    
    
}
