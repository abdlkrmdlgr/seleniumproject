package com.dlgr.yoksis.model;

import com.dlgr.yoksis.dto.AnnounceDTO;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by abdlkrmdlgr
 * E-mail:abdulkerimdulger@comu.edu.tr
 * Created Date: 7.10.2016
 */
@Entity
@Table(name = "announce")
public class Announce {

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
    private University university;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Column
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Column
    public String getAlesPoint() {
        return alesPoint;
    }

    public void setAlesPoint(String alesPoint) {
        this.alesPoint = alesPoint;
    }

    @Column
    public String getYdsPoint() {
        return ydsPoint;
    }

    public void setYdsPoint(String ydsPoint) {
        this.ydsPoint = ydsPoint;
    }

    @Column
    public Date getApplicationStartDate() {
        return applicationStartDate;
    }

    public void setApplicationStartDate(Date applicationStartDate) {
        this.applicationStartDate = applicationStartDate;
    }

    @Column
    public Date getApplicationEndDate() {
        return applicationEndDate;
    }

    public void setApplicationEndDate(Date applicationEndDate) {
        this.applicationEndDate = applicationEndDate;
    }

    @Column
    public Date getPreEvaluationDate() {
        return preEvaluationDate;
    }

    public void setPreEvaluationDate(Date preEvaluationDate) {
        this.preEvaluationDate = preEvaluationDate;
    }

    @Column
    public Date getScoreAnnouncedDate() {
        return scoreAnnouncedDate;
    }

    public void setScoreAnnouncedDate(Date scoreAnnounced) {
        this.scoreAnnouncedDate = scoreAnnounced;
    }

    @Column
    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    @Column
    public String getApplicationType() {
        return applicationType;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    @Column
    public String getApplicationLocation() {
        return applicationLocation;
    }

    public void setApplicationLocation(String applicationLocation) {
        this.applicationLocation = applicationLocation;
    }

    @Column
    public String getAnnouncedLocation() {
        return announcedLocation;
    }

    public void setAnnouncedLocation(String announcedLocation) {
        this.announcedLocation = announcedLocation;
    }

    @Column
    public String getSpecialConditions() {
        return specialConditions;
    }

    public void setSpecialConditions(String specialConditions) {
        this.specialConditions = specialConditions;
    }

    @Column
    public String getGeneralConditions() {
        return generalConditions;
    }

    public void setGeneralConditions(String generalConditions) {
        this.generalConditions = generalConditions;
    }

    @Column
    public String getTitleConditions() {
        return titleConditions;
    }

    public void setTitleConditions(String titleConditions) {
        this.titleConditions = titleConditions;
    }

    @Column
    public String getRequiredDocument() {
        return requiredDocument;
    }

    public void setRequiredDocument(String requiredDocument) {
        this.requiredDocument = requiredDocument;
    }

    @Column
    public String getExemption() {
        return exemption;
    }

    public void setExemption(String exemption) {
        this.exemption = exemption;
    }

    @ManyToOne(optional = false)
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public AnnounceDTO toDTO() {

        return new AnnounceDTO(id, number, location, title, count, degree, alesPoint, ydsPoint, applicationStartDate,
                applicationEndDate, preEvaluationDate, scoreAnnouncedDate, examDate, applicationType,
                applicationLocation, announcedLocation, specialConditions, generalConditions, titleConditions,
                requiredDocument, exemption, university.toDTO());
    }
}


