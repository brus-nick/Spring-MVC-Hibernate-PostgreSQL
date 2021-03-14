package com.project.model;

import javax.persistence.*;

@Entity
@Table(name = "vacancies", schema="public")
public class Vacancie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacancie_id")
    private int id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Column(name = "type", length = 20, nullable = false)
    private String type;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
