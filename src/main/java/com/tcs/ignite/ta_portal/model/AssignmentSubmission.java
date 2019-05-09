/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.ta_portal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ignite054
 */
@Entity
@Table(name = "assignment_submission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssignmentSubmission.findAll", query = "SELECT a FROM AssignmentSubmission a")
    , @NamedQuery(name = "AssignmentSubmission.findBySubmissionId", query = "SELECT a FROM AssignmentSubmission a WHERE a.submissionId = :submissionId")
    , @NamedQuery(name = "AssignmentSubmission.findBySubmittedOn", query = "SELECT a FROM AssignmentSubmission a WHERE a.submittedOn = :submittedOn")})
public class AssignmentSubmission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "submission_id")
    private Integer submissionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "submitted_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submittedOn;
    @Lob
    @Size(max = 65535)
    @Column(name = "attachment")
    private String attachment;
    @JoinColumn(name = "assignment_id", referencedColumnName = "assignment_id")
    @ManyToOne(optional = false)
    private AssignmentMaster assignmentId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserDetails userId;

    public AssignmentSubmission() {
    }

    public AssignmentSubmission(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public AssignmentSubmission(Integer submissionId, Date submittedOn) {
        this.submissionId = submissionId;
        this.submittedOn = submittedOn;
    }

    public Integer getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }

    public Date getSubmittedOn() {
        return submittedOn;
    }

    public void setSubmittedOn(Date submittedOn) {
        this.submittedOn = submittedOn;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public AssignmentMaster getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(AssignmentMaster assignmentId) {
        this.assignmentId = assignmentId;
    }

    public UserDetails getUserId() {
        return userId;
    }

    public void setUserId(UserDetails userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (submissionId != null ? submissionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssignmentSubmission)) {
            return false;
        }
        AssignmentSubmission other = (AssignmentSubmission) object;
        if ((this.submissionId == null && other.submissionId != null) || (this.submissionId != null && !this.submissionId.equals(other.submissionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.ta_portal.model.AssignmentSubmission[ submissionId=" + submissionId + " ]";
    }
    
}
