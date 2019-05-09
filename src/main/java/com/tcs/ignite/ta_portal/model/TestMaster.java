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
@Table(name = "test_master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestMaster.findAll", query = "SELECT t FROM TestMaster t")
    , @NamedQuery(name = "TestMaster.findByTestId", query = "SELECT t FROM TestMaster t WHERE t.testId = :testId")
    , @NamedQuery(name = "TestMaster.findByTestName", query = "SELECT t FROM TestMaster t WHERE t.testName = :testName")})
public class TestMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "test_id")
    private Integer testId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "test_name")
    private String testName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testId")
    private List<TestScore> testScoreList;

    public TestMaster() {
    }

    public TestMaster(Integer testId) {
        this.testId = testId;
    }

    public TestMaster(Integer testId, String testName) {
        this.testId = testId;
        this.testName = testName;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
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
        hash += (testId != null ? testId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestMaster)) {
            return false;
        }
        TestMaster other = (TestMaster) object;
        if ((this.testId == null && other.testId != null) || (this.testId != null && !this.testId.equals(other.testId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.ta_portal.model.TestMaster[ testId=" + testId + " ]";
    }
    
}
