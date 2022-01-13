/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.splootproject.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author User
 */
@Entity
@Table(name = "appointments")
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "appointid")
    private long appointid;
    
    @Column(name = "atype", columnDefinition = "varchar(2)")
    @NotNull
    @NotEmpty(message = "Please enter your appointment type.")
    private String atype;
    
    @Column(name = "custemail", columnDefinition = "varchar(80)")
    @NotNull
    @NotEmpty(message = "Please enter customer email addresss.")
    private String custemail;
    
    @Column(name = "petname", columnDefinition = "varchar(30)")
    private String petname;
    
    @Column(name = "bizemail", columnDefinition = "varchar(80)")
    @NotNull
    @NotEmpty(message = "Please enter business email addresss.")
    private String bizemail;
    
    @Column(name = "bizname", columnDefinition = "varchar(30)")
    @NotNull
    @NotEmpty(message = "Please enter business name.")
    private String bizname;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="reqdate")
    private Date reqdate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="appointdate")
    private Date appointdate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="closingdate")
    private Date closingdate;
    
    @Column(name = "city", columnDefinition = "varchar(30)")
    @NotNull
    @NotEmpty(message = "Please enter city.")
    private String city;
    
    @Column(name = "closingstatus", columnDefinition = "varchar(100) default 'open'")
    @NotNull
    private String closingstatus;

    @Column(name = "custreviews", columnDefinition = "varchar(100)")
    private String custreviews;
    
    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }
    
    public long getAppointid() {
        return appointid;
    }

    public void setAppointid(long appointid) {
        this.appointid = appointid;
    }

    public String getCustemail() {
        return custemail;
    }

    public void setCustemail(String custemail) {
        this.custemail = custemail;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getBizemail() {
        return bizemail;
    }

    public void setBizemail(String bizemail) {
        this.bizemail = bizemail;
    }

    public String getBizname() {
        return bizname;
    }

    public void setBizname(String bizname) {
        this.bizname = bizname;
    }

    public Date getReqdate() {
        return reqdate;
    }

    public void setReqdate(Date reqdate) {
        this.reqdate = reqdate;
    }

    public Date getAppointdate() {
        return appointdate;
    }

    public void setAppointdate(Date appointdate) {
        this.appointdate = appointdate;
    }

    public Date getClosingdate() {
        return closingdate;
    }

    public void setClosingdate(Date closingdate) {
        this.closingdate = closingdate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClosingstatus() {
        return closingstatus;
    }

    public void setClosingstatus(String closingstatus) {
        this.closingstatus = closingstatus;
    }

    public String getCustreviews() {
        return custreviews;
    }

    public void setCustreviews(String custreviews) {
        this.custreviews = custreviews;
    }


    public Appointments() {
    }

    
}
