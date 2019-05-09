/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.ta_portal.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ignite054
 */
@Entity
@Table(name = "user_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDetails.findAll", query = "SELECT u FROM UserDetails u")
    , @NamedQuery(name = "UserDetails.findByUserId", query = "SELECT u FROM UserDetails u WHERE u.userId = :userId")
    , @NamedQuery(name = "UserDetails.findByUserName", query = "SELECT u FROM UserDetails u WHERE u.userName = :userName")
    , @NamedQuery(name = "UserDetails.findByFirstName", query = "SELECT u FROM UserDetails u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "UserDetails.findByIsActive", query = "SELECT u FROM UserDetails u WHERE u.isActive = :isActive")
    , @NamedQuery(name = "UserDetails.findByBatch", query = "SELECT u FROM UserDetails u WHERE u.batch = :batch")
    , @NamedQuery(name = "UserDetails.findByTaName", query = "SELECT u FROM UserDetails u WHERE u.taName = :taName")})
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "batch")
    private String batch;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ta_name")
    private String taName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<AssignmentSubmission> assignmentSubmissionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<TestScore> testScoreList;

    public UserDetails() {
    }

    public UserDetails(Integer userId) {
        this.userId = userId;
    }

    public UserDetails(Integer userId, String userName, String firstName, boolean isActive, String batch, String taName) {
        this.userId = userId;
        this.userName = userName;
        this.firstName = firstName;
        this.isActive = isActive;
        this.batch = batch;
        this.taName = taName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getTaName() {
        return taName;
    }

    public void setTaName(String taName) {
        this.taName = taName;
    }

    @XmlTransient
    public List<AssignmentSubmission> getAssignmentSubmissionList() {
        return assignmentSubmissionList;
    }

    public void setAssignmentSubmissionList(List<AssignmentSubmission> assignmentSubmissionList) {
        this.assignmentSubmissionList = assignmentSubmissionList;
    }

    @XmlTransient
    public List<TestScore> getTestScoreList() {
        return testScoreList;
    }

    public void setTestScoreList(List<TestScore> testScoreList) {
        this.testScoreList = testScoreList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDetails)) {
            return false;
        }
        UserDetails other = (UserDetails) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.ta_portal.model.UserDetails[ userId=" + userId + " ]";
    }
    
}
