/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.splootproject.dao;

import static com.mycompany.splootproject.dao.DAO.close;
import static com.mycompany.splootproject.dao.DAO.getSession;
import com.mycompany.splootproject.pojo.Appointments;
import com.mycompany.splootproject.pojo.Biz;
import com.mycompany.splootproject.pojo.User;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author User
 */
public class AppointmentsDAO extends DAO {
    public void createAppointment(Appointments appointment) {
        try {
        begin();
        getSession().save(appointment);
          commit();
        } catch(Exception e) {
            rollback();
        }
      
    }
    
    
    public void updateAppointments(Appointments appointment) {
        begin();
        getSession().saveOrUpdate(appointment);
        commit();
        close();
    }
        public List<Appointments> getAppointmentsByCust(User cust)
        {  
            String custemail = cust.getEmail();
            Query query = getSession().createNativeQuery("SELECT * FROM appointments WHERE custemail = ?;",Appointments.class);
            query.setParameter(1, custemail);
            List<Appointments> appointmentList = (List<Appointments>) query.getResultList();
            return appointmentList;
        }
        public List<Appointments> getClosedAppointmentsByCust(User cust)
        {  
            String custemail = cust.getEmail();
            Query query = getSession().createNativeQuery("SELECT * FROM appointments WHERE custemail = ? AND closingstatus != 'open' ;",Appointments.class);
            query.setParameter(1, custemail);
            List<Appointments> appointmentList = (List<Appointments>) query.getResultList();
            return appointmentList;
        }
        public List<Appointments> getOpenAppointmentsByCust(User cust)
        {  
            String custemail = cust.getEmail();
            Query query = getSession().createNativeQuery("SELECT * FROM appointments WHERE custemail = ? AND closingstatus = 'open';",Appointments.class);
            query.setParameter(1, custemail);
            List<Appointments> appointmentList = (List<Appointments>) query.getResultList();
            return appointmentList;
        }
public List<Appointments> getAppointmentsByBiz(Biz biz)
        {  
        String bizemail = biz.getOwneremail();
            Query query = getSession().createNativeQuery("SELECT * FROM appointments WHERE bizemail = ?;",Appointments.class);
            query.setParameter(1, bizemail);
            List<Appointments> appointmentList = (List<Appointments>) query.getResultList();
          
            return appointmentList;
        }
public List<Appointments> getAppointmentsByBizOwner(String bizowneremail)
        { 
            Query query = getSession().createNativeQuery("SELECT * FROM appointments WHERE bizemail = ?;",Appointments.class);
            query.setParameter(1, bizowneremail);
            List<Appointments> appointmentList = (List<Appointments>) query.getResultList();
        
            return appointmentList;
        }
public List<Appointments> getOpenAppointmentsByBizOwner(String bizowneremail)
        {   
            Query query = getSession().createNativeQuery("SELECT * FROM appointments WHERE bizemail = ? AND closingstatus = 'open';",Appointments.class);
            query.setParameter(1, bizowneremail);
            List<Appointments> appointmentList = (List<Appointments>) query.getResultList();
          
            return appointmentList;
        }
public List<Appointments> getClosedAppointmentsByBizOwner(String bizowneremail)
        {   
            Query query = getSession().createNativeQuery("SELECT * FROM appointments WHERE bizemail = ? AND closingstatus != 'open';",Appointments.class);
            query.setParameter(1, bizowneremail);
            List<Appointments> appointmentList = (List<Appointments>) query.getResultList();
          
            return appointmentList;
        }

    public Appointments getAppointmentById(int appointid) {
        begin();
         Query query = getSession().createNativeQuery("SELECT * FROM appointments WHERE appointid = ?;",Appointments.class);
            query.setParameter(1, appointid);
            Appointments appointment=null;
            List<Appointments> appointmentList = (List<Appointments>) query.getResultList();
            if(appointmentList.size()>0)
            {
                appointment = appointmentList.iterator().next();}
            return appointment;
            
    }
        
    public Appointments getAppointments(int appointid) {
        return getSession().get(Appointments.class, appointid);
    }
}