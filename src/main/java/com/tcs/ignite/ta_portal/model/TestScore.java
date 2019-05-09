/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tcs.ignite.ta_portal.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ignite054
 */
@Entity
@Table(name = "test_score")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestScore.findAll", query = "SELECT t FROM TestScore t")
    , @NamedQuery(name = "TestScore.findById", query = "SELECT t FROM TestScore t WHERE t.id = :id")
    , @NamedQuery(name = "TestScore.findByScore", query = "SELECT t FROM TestScore t WHERE t.score = :score")})
public class TestScore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "score")
    private Long score;
    @JoinColumn(name = "test_id", referencedColumnName = "test_id")
    @ManyToOne(optional = false)
    private TestMaster testId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_name")
    @ManyToOne(optional = false)
    private UserDetails userId;

    public TestScore() {
    }

    public TestScore(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public TestMaster getTestId() {
        return testId;
    }

    public void setTestId(TestMaster testId) {
        this.testId = testId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestScore)) {
            return false;
        }
        TestScore other = (TestScore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tcs.ignite.ta_portal.model.TestScore[ id=" + id + " ]";
    }
    
}
