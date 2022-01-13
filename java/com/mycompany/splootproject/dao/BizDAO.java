/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.splootproject.dao;

import static com.mycompany.splootproject.dao.DAO.close;
import static com.mycompany.splootproject.dao.DAO.getSession;
import com.mycompany.splootproject.pojo.Biz;
import com.mycompany.splootproject.pojo.User;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author User
 */
public class BizDAO extends DAO {
    public void createBiz(Biz biz) {
        try {
        begin();
        getSession().save(biz);
        commit();
        } catch(Exception e) {
            rollback();
        }
        
        System.out.println("Biz Saved in the DB");
       // close();
    }
    
    public Biz getBiz(int bizid) {
        return getSession().get(Biz.class, bizid);
    }
    
    public void deleteBiz(Biz biz) {
        begin();
        getSession().delete(biz);
        commit();
       
    }
    
    public void updateBiz(Biz biz) {
        begin();
       
       System.out.println(biz.getBizid()+":"+biz.getBizname()+":"+biz.getBtype());
        getSession().update(biz);
        commit();
        close();
    }
        public List<Biz> getBizs(User owner)
     {
            begin();
            Query query = getSession().createNativeQuery("SELECT * FROM biz WHERE owneremail = ?;",Biz.class);
            query.setParameter(1, owner.getEmail());
            List<Biz> bizList = (List<Biz>) query.getResultList();
                      
            commit();
           
           return bizList;
        } 
        
        public Biz getBizById(int id)
        {   begin();
            Query query = getSession().createNativeQuery("SELECT * FROM biz WHERE bizid = ?;",Biz.class);
            query.setParameter(1, id);
            List<Biz> bizList = (List<Biz>) query.getResultList();
          
                Biz biz = bizList.iterator().next();
          
            return biz;
        }

     public List<Biz> getBizByCity(String city)
     {
            begin();
           
            Query query = getSession().createNativeQuery("SELECT * FROM biz WHERE city = ?;",Biz.class);
            query.setParameter(1, city);
            List<Biz> bizList = (List<Biz>) query.getResultList();
                     
            commit();
           
           return bizList;
        } 
          public Biz getBizByNameEmail(String bname, String oemail)
     {
            begin();
           
            Query query = getSession().createNativeQuery("SELECT * FROM biz WHERE bizname = ? AND owneremail = ?;",Biz.class);
            query.setParameter(1, bname);
            query.setParameter(2, oemail);
            List<Biz> bizList = (List<Biz>) query.getResultList();
            Biz tmp=null;
            if(bizList.size()>0)
             tmp = (Biz)bizList.iterator().next();
            return tmp;
            
        } 
}