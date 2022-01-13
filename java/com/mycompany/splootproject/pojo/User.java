package com.mycompany.splootproject.pojo;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "userid")
    private long userid;
    
    @Column(name = "email", columnDefinition = "varchar(80)")
    @NotNull
    //@NotEmpty(message = "Please enter your email addresss.")
    private String email;
    
    @Column(name = "pass", columnDefinition = "varchar(30)")
    @NotNull
    //@NotEmpty(message = "Please enter your password .")
    private String pass;
    
    @Column(name = "utype", columnDefinition = "varchar(2) default 'po'")
    @NotNull
    private String utype;
    
    @Column(name = "city", columnDefinition = "varchar(30)")
    @NotNull
    //@NotEmpty(message = "Please enter your city .")
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    

    public User() {
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

   
}