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
@Table(name = "pet")
public class Pet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "petid")
    private long petid;
    
    @Column(name = "petname", columnDefinition = "varchar(30)")
    @NotNull
    @NotEmpty(message = "Please enter your Petname.")
    private String petname;
    
    @Column(name = "aboutpet", columnDefinition = "varchar(200)")
    private String aboutpet;

    @Column(name = "owneremail", columnDefinition = "varchar(80)")
    @NotNull
    @NotEmpty(message = "Please enter owner's email addresss.")
    private String owneremail;
    
    @Column(name = "breed", columnDefinition = "varchar(30)")
    @NotNull
    @NotEmpty(message = "Please enter Pet Breed.")
    private String breed;
    
    @Column(name = "medicalstatus", columnDefinition = "varchar(100)")
    @NotNull
    @NotEmpty(message = "Please enter Pet's medical status.")
    private String medicalstatus;
    
    @Column(name = "servicesavailed", columnDefinition = "varchar(100)")
    @NotNull
    @NotEmpty(message = "Please enter Pet Care service availed from Sploot .")
    private String servicesavailed;
    
    @Column(name = "photo1", columnDefinition = "varchar(255)")
    private String photo1;
    
    @Column(name = "photo2", columnDefinition = "varchar(255)")
    private String photo2;
    

    public Pet() {
    }

    public long getPetid() {
        return petid;
    }

    public void setPetid(long petid) {
        this.petid = petid;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }
 public String getAboutpet() {
        return aboutpet;
    }

    public void setAboutpet(String aboutpet) {
        this.aboutpet = aboutpet;
    }
    public String getOwneremail() {
        return owneremail;
    }

    public void setOwneremail(String owneremail) {
        this.owneremail = owneremail;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getMedicalstatus() {
        return medicalstatus;
    }

    public void setMedicalstatus(String medicalstatus) {
        this.medicalstatus = medicalstatus;
    }

    public String getServicesavailed() {
        return servicesavailed;
    }

    public void setServicesavailed(String servicesavailed) {
        this.servicesavailed = servicesavailed;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

   
}