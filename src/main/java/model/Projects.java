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
public class Projects {
    private int id;
    private String name;
    private String description;
    private Date createAt;
    private Date updateAt;

    public Projects(int id, String name, String description, Date createAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Projects() {
        this.createAt=new Date();
        this.updateAt=new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        //return "Projects{" + "id=" + id + ", name=" + name + ", description=" + description + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
       return name;
    }
    
    
    
}
