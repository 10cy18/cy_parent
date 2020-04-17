package com.cy.qa.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author: cy
 * @Date: 2019/2/15 14:41
 */
@Entity
@Table(name="tb_pl")
public class Pl implements Serializable {
    @Id
    private String problemid;
    @Id
    private String lableid;

    public String getLableid() {
        return lableid;
    }
    public void setLableid(String lableid) {
        this.lableid = lableid;
    }
    public String getProblemid() {
        return problemid;
    }
    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }
}
