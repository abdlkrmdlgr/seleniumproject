package com.dlgr.yoksis.dto;

/**
 * Created by dlgr on 29.10.2016.
 */
public class UniversityDTO {

    private Long id;
    private String logo;
    private String name;

    public UniversityDTO(String logo, String name) {
        this.logo = logo;
        this.name = name;
    }

    public UniversityDTO(Long id, String logo, String name) {
        this.id = id;
        this.logo = logo;
        this.name = name;
    }

    public UniversityDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
