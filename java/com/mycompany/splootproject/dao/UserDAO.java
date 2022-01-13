package com.mycompany.splootproject.dao;

import com.mycompany.splootproject.pojo.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserDAO extends DAO {
    public void createUser(User user) {
        try {
        begin();
        getSession().save(user);
        commit();
        } catch(Exception e) {
            rollback();
        }
        
        System.out.println("User Saved in the DB");
    }
    
    public User getUser(int userid) {
        return getSession().get(User.class, userid);
    }
    public User getUserByEmail(String email) {
        Query query = getSession().createNativeQuery("SELECT * FROM user WHERE email = ?;",User.class);
        query.setParameter(1, email);
        List<User> userList = (List<User>) query.getResultList();
        if(userList.size()>0) return userList.iterator().next();
        return null;
    }
    public void deleteUser(User user) {
        begin();
        getSession().delete(user);
        commit();
    }
    
    public void updateUser(User user) {
        begin();
        getSession().update(user);
        commit();
    }
        public boolean authUser(User user)
     {
        
            Query query = getSession().createNativeQuery("SELECT * FROM user WHERE email = ?;",User.class);
            query.setParameter(1, user.getEmail());
            List<User> userList = (List<User>) query.getResultList();
            if(userList.size()>0)
            {User tmp = userList.iterator().next();
            System.out.println(tmp.getEmail());
            
         
            return (user.getPass().equals(tmp.getPass())&&user.getUtype().equals(tmp.getUtype()));
            } return false;
           
        } 
       
}