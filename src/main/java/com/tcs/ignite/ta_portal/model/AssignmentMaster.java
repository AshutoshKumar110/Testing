/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.ta_portal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ignite054
 */
@Entity
@Table(name = "assignment_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssignmentMaster.findAll", query = "SELECT a FROM AssignmentMaster a")
    , @NamedQuery(name = "AssignmentMaster.findByAssignmentId", query = "SELECT a FROM AssignmentMaster a WHERE a.assignmentId = :assignmentId")
    , @NamedQuery(name = "AssignmentMaster.findByExpiryDate", query = "SELECT a FROM AssignmentMaster a WHERE a.expiryDate = :expiryDate")})
public class AssignmentMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "assignment_id")
    private Integer assignmentId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "assignment_name")
    private String assignmentName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Lob
    @Size(max = 65535)
    @Column(name = "attachment")
    private String attachment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiry_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignmentId")
    private List<AssignmentSubmission> assignmentSubmissionList;

    public AssignmentMaster() {
    }

    public AssignmentMaster(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public AssignmentMaster(Integer assignmentId, String assignmentName, String description, Date expiryDate) {
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.description = description;
        this.expiryDate = expiryDate;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @XmlTransient
    public List<AssignmentSubmission> getAssignmentSubmissionList() {
        return assignmentSubmissionList;
    }

    public void setAssignmentSubmissionList(List<AssignmentSubmission> assignmentSubmissionList) {
        this.assignmentSubmissionList = assignmentSubmissionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assignmentId != null ? assignmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssignmentMaster)) {
            return false;
        }
        AssignmentMaster other = (AssignmentMaster) object;
        if ((this.assignmentId == null && other.assignmentId != null) || (this.assignmentId != null && !this.assignmentId.equals(other.assignmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.ta_portal.model.AssignmentMaster[ assignmentId=" + assignmentId + " ]";
    }
    
}
