package com.mycompany.splootproject.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;



@Entity
@Table(name = "biz")
public class Biz implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "bizid")
    private long bizid;
    
    @Column(name = "bizname", columnDefinition = "varchar(30)")
    @NotNull
    @NotEmpty(message = "Please enter your Business name.")
    private String bizname;
    
    @Column(name = "aboutbiz", columnDefinition = "varchar(200)")
    private String aboutbiz;
    
    @Column(name = "owneremail", columnDefinition = "varchar(80)")
    @NotNull
    @NotEmpty(message = "Please enter your business owner's email.")
    private String owneremail;
    
    @Column(name = "btype", columnDefinition = "varchar(2)")
    @NotNull
    @NotEmpty(message = "Please enter your business type.")
    private String btype;
    
    @Column(name = "city", columnDefinition = "varchar(30)")
    @NotNull
    @NotEmpty(message = "Please enter your business City.")
    private String city;
    
    @Column(name = "rating", columnDefinition = "int")
    private int rating;
    
    @Column(name = "profilephoto1", columnDefinition = "varchar(200)")
    private String profilephoto1;
    @Column(name = "profilephoto2", columnDefinition = "varchar(200)")
    private String profilephoto2;

    public String getAboutbiz() {
        return aboutbiz;
    }

    public void setAboutbiz(String aboutbiz) {
        this.aboutbiz = aboutbiz;
    }
    public String getProfilephoto1() {
        return profilephoto1;
    }

    public void setProfilephoto1(String profilephoto1) {
        this.profilephoto1 = profilephoto1;
    }

    public String getProfilephoto2() {
        return profilephoto2;
    }

    public void setProfilephoto2(String profilephoto2) {
        this.profilephoto2 = profilephoto2;
    }
    
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    

    public Biz() {
    }

    public long getBizid() {
        return bizid;
    }

    public void setBizid(long bizid) {
        this.bizid = bizid;
    }

    public String getBizname() {
        return bizname;
    }

    public void setBizname(String bizname) {
        this.bizname = bizname;
    }

    public String getOwneremail() {
        return owneremail;
    }

    public void setOwneremail(String owneremail) {
        this.owneremail = owneremail;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

   
}