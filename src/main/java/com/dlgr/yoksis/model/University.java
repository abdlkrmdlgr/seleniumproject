package com.dlgr.yoksis.model;

import com.dlgr.yoksis.dto.UniversityDTO;

import javax.persistence.*;

/**
 * Created by dlgr on 29.10.2016.
 */
@Entity
@Table(name = "university")
public class University {

    private Long id;
    private String logo;
    private String name;

    public University(String logo, String name) {
        this.logo = logo;
        this.name = name;
    }

    public University() {

    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UniversityDTO toDTO() {
        return new UniversityDTO(id, logo, name);
    }
}
