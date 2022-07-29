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
public class Task {
    
    private int id;
    private int idproject;
    private String name;
    private String description;
    private String notes;
    private Date deadline;
    private Date createAt;
    private Date updateAt;

    public Task(int id, int idproject, String name, String description, String notes, Date deadline, Date createAt, Date updateAt) {
        this.id = id;
        this.idproject = idproject;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.deadline = deadline;
        this.createAt = createAt;
        this.updateAt = updateAt;
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
        return "Task{" + "id=" + id + ", idproject=" + idproject + ", name=" + name + ", description=" + description + ", notes=" + notes + ", deadline=" + deadline + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
    
    
    
}
