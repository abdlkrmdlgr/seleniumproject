package com.dlgr.yoksis.dto;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by abdlkrmdlgr
 * E-mail:abdulkerimdulger@comu.edu.tr
 * Created Date: 7.10.2016
 */
@Entity
@Table(name = "announce")
public class AnnounceDTO {

    private Long id;
    private String number;
    private String location;
    private String title;
    private String count;
    private String degree;

    private String alesPoint;
    private String ydsPoint;

    private Date applicationStartDate;
    private Date applicationEndDate;
    private Date preEvaluationDate;
    private Date scoreAnnouncedDate;
    private Date examDate;
    private String applicationType;
    private String applicationLocation;
    private String announcedLocation;

    private String specialConditions;
    private String generalConditions;
    private String titleConditions;

    private String requiredDocument;
    private String exemption;
    private UniversityDTO university;

    public AnnounceDTO(Long id, String number, String location, String title, String count,
                       String degree, String alesPoint, String ydsPoint, Date applicationStartDate,
                       Date applicationEndDate, Date preEvaluationDate, Date scoreAnnouncedDate, Date examDate,
                       String applicationType, String applicationLocation, String announcedLocation, String specialConditions,
                       String generalConditions, String titleConditions, String requiredDocument,
                       String exemption, UniversityDTO university) {
        this.id = id;
        this.number = number;
        this.location = location;
        this.title = title;
        this.count = count;
        this.degree = degree;
        this.alesPoint = alesPoint;
        this.ydsPoint = ydsPoint;
        this.applicationStartDate = applicationStartDate;
        this.applicationEndDate = applicationEndDate;
        this.preEvaluationDate = preEvaluationDate;
        this.scoreAnnouncedDate = scoreAnnouncedDate;
        this.examDate = examDate;
        this.applicationType = applicationType;
        this.applicationLocation = applicationLocation;
        this.announcedLocation = announcedLocation;
        this.specialConditions = specialConditions;
        this.generalConditions = generalConditions;
        this.titleConditions = titleConditions;
        this.requiredDocument = requiredDocument;
        this.exemption = exemption;
        this.university = university;
    }

    public AnnounceDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAlesPoint() {
        return alesPoint;
    }

    public void setAlesPoint(String alesPoint) {
        this.alesPoint = alesPoint;
    }

    public String getYdsPoint() {
        return ydsPoint;
    }

    public void setYdsPoint(String ydsPoint) {
        this.ydsPoint = ydsPoint;
    }

    public Date getApplicationStartDate() {
        return applicationStartDate;
    }

    public void setApplicationStartDate(Date applicationStartDate) {
        this.applicationStartDate = applicationStartDate;
    }

    public Date getApplicationEndDate() {
        return applicationEndDate;
    }

    public void setApplicationEndDate(Date applicationEndDate) {
        this.applicationEndDate = applicationEndDate;
    }

    public Date getPreEvaluationDate() {
        return preEvaluationDate;
    }

    public void setPreEvaluationDate(Date preEvaluationDate) {
        this.preEvaluationDate = preEvaluationDate;
    }

    public Date getScoreAnnouncedDate() {
        return scoreAnnouncedDate;
    }

    public void setScoreAnnouncedDate(Date scoreAnnounced) {
        this.scoreAnnouncedDate = scoreAnnounced;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public String getApplicationLocation() {
        return applicationLocation;
    }

    public void setApplicationLocation(String applicationLocation) {
        this.applicationLocation = applicationLocation;
    }

    public String getAnnouncedLocation() {
        return announcedLocation;
    }

    public void setAnnouncedLocation(String announcedLocation) {
        this.announcedLocation = announcedLocation;
    }

    public String getSpecialConditions() {
        return specialConditions;
    }

    public void setSpecialConditions(String specialConditions) {
        this.specialConditions = specialConditions;
    }

    public String getGeneralConditions() {
        return generalConditions;
    }

    public void setGeneralConditions(String generalConditions) {
        this.generalConditions = generalConditions;
    }

    public String getTitleConditions() {
        return titleConditions;
    }

    public void setTitleConditions(String titleConditions) {
        this.titleConditions = titleConditions;
    }

    public String getRequiredDocument() {
        return requiredDocument;
    }

    public void setRequiredDocument(String requiredDocument) {
        this.requiredDocument = requiredDocument;
    }

    public String getExemption() {
        return exemption;
    }

    public void setExemption(String exemption) {
        this.exemption = exemption;
    }

    public UniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDTO university) {
        this.university = university;
    }
}


