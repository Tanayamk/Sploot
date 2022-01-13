package com.mycompany.splootproject.dao;

import com.mycompany.splootproject.pojo.Pet;
import com.mycompany.splootproject.pojo.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PetDAO extends DAO {
    public void createPet(Pet pet) {
        try {
        begin();
        getSession().save(pet);
        commit();
        } catch(Exception e) {
            rollback();
        }
        
        System.out.println("Pet Saved in the DB");
        //close();
    }
    
    public Pet getPet(int petid) {
        return getSession().get(Pet.class, petid);
    }
    
    public void deletePet(Pet pet) {
        begin();
        getSession().delete(pet);
        commit();
        //close();
    }
    
    public void updatePet(Pet pet) {
        begin();
       
       System.out.println(pet.getPetid()+":"+pet.getPetname()+":"+pet.getBreed());
        getSession().update(pet);
        commit();
        close();
    }
        public List<Pet> getPets(User owner)
     {
            begin();
         
            Query query = getSession().createNativeQuery("SELECT * FROM pet WHERE owneremail = ?;",Pet.class);
            query.setParameter(1, owner.getEmail());
            List<Pet> petList = (List<Pet>) query.getResultList();
                     
            commit();
         
           return petList;
        } 
         public List<Pet> getPetList(String owneremail )
     {
         
            Query query = getSession().createNativeQuery("SELECT * FROM pet WHERE owneremail = ?;",Pet.class);
            query.setParameter(1, owneremail);
            List<Pet> petList = (List<Pet>) query.getResultList();
          
           return petList;
        }

        
        public Pet getPetById(int id)
        {   begin();
            Query query = getSession().createNativeQuery("SELECT * FROM pet WHERE petid = ?;",Pet.class);
            query.setParameter(1, id);
            List<Pet> petList = (List<Pet>) query.getResultList();
            Pet pet=null;
            if(petList.size()>0)
            pet = petList.iterator().next();
              //System.out.println("getPetById : "+pet.getPetid()+":"+pet.getPetname()+":"+pet.getBreed());
            return pet;
        }
         public Pet getPetByNameandOwneremail(String petname,String owneremail)
        {   begin();
            Query query = getSession().createNativeQuery("SELECT * FROM pet WHERE petname = ? AND owneremail = ?;",Pet.class);
            query.setParameter(1, petname);
            query.setParameter(2, owneremail);
            
            List<Pet> petList = (List<Pet>) query.getResultList();
            Pet pet=null;
            if(petList.size()>0)
            pet = petList.iterator().next();
             // System.out.println("getPetById : "+pet.getPetid()+":"+pet.getPetname()+":"+pet.getBreed());
            return pet;
        }
}