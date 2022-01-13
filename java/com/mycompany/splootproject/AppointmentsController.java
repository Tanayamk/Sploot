package com.mycompany.splootproject;

import com.mycompany.splootproject.validation.AppointmentsValidator;

import com.mycompany.splootproject.dao.UserDAO;
import com.mycompany.splootproject.dao.BizDAO;
import com.mycompany.splootproject.dao.AppointmentsDAO;
import com.mycompany.splootproject.dao.PetDAO;
import com.mycompany.splootproject.pojo.Appointments;
import com.mycompany.splootproject.pojo.User;
import com.mycompany.splootproject.pojo.Biz;
import com.mycompany.splootproject.pojo.Pet;
import com.mycompany.splootproject.validation.BizValidator;
import com.mycompany.splootproject.validation.UserValidator;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;



@Controller
public class AppointmentsController {
    
    //Below are validator injections
    @Autowired
    UserValidator uservalidator;
    
    @Autowired
    BizValidator bizvalidator;
    
    @Autowired
    AppointmentsValidator appointmentsvalidator;
    //----------------------------------------------------
    //Section 1 : Appointment mapping for pet owner
    
    
    //Book Appointment : Step1
    //Serves: Pet Owner
    //Purpose: List Service Provider in Pet Owner's City
    //From->To: home.jsp->appointmentsprofile.jsp
    @GetMapping("/appointmentsprofile.htm") 
    public String appointmentsProfile(ModelMap model, Appointments appointment, BizDAO bizdao, PetDAO petdao, UserDAO userdao, HttpServletRequest req) {
        User  currentuser=(User)req.getSession().getAttribute("currentuser"); //get the current per owner's email
        String city= userdao.getUserByEmail(currentuser.getEmail()).getCity(); //get the current City
        List<Biz> bizlistbycity=bizdao.getBizByCity(city); //using the business DAO, extract the list of services providers in the City
        req.setAttribute("bizlistbycity",bizlistbycity); //add this list to request scope, so that it can be available on the next view page, to display it
        return "appointmentsprofile"; //the generated view
    }

    
    @RequestMapping(value="/registerappointment.htm", method = RequestMethod.GET)
    public String saveAppointments(ModelMap model, HttpServletRequest request,BizDAO bizdao, PetDAO petdao, Appointments appointment) {
            String id = request.getParameter("id"); //For the selected business id

                                                    //below we are putting the data into a appointment model
           
            Biz goforbiz=bizdao.getBizById(Integer.parseInt(id));  
            User  currentuser=(User)request.getSession().getAttribute("currentuser");
             appointment.setBizemail(goforbiz.getOwneremail());
             appointment.setBizname(goforbiz.getBizname());
             appointment.setCity(goforbiz.getCity());
             appointment.setCustemail(currentuser.getEmail());
             appointment.setAtype(goforbiz.getBtype());
           
              List<Pet> petlist=petdao.getPetList(currentuser.getEmail());
               request.setAttribute("petlist", petlist);
               
                long millis=System.currentTimeMillis();  
        java.sql.Date reqdate=new java.sql.Date(millis);
        appointment.setReqdate(reqdate);
        appointment.setAppointdate(reqdate);
        appointment.setClosingstatus("open");
        System.out.println("in controller"+appointment.getReqdate());
        
        model.addAttribute("appointment",appointment);
        return "appointmentregistrationform";
    }
    
    @PostMapping("/saveregisterappointment.htm")
    public String saveAppointmentPost(@ModelAttribute("appointment") Appointments appointment, BindingResult result, SessionStatus status, AppointmentsDAO appointmentsdao, HttpServletRequest req) {
            String view = null;
            System.out.println("in controller save"+appointment.getReqdate());
            appointmentsdao.createAppointment(appointment);
            status.setComplete();
            req.setAttribute("appointmentid",appointment.getAppointid());
            view = "appointmentregistrationreceipt";
      
        return view;
    }
    @PostMapping("/savereviewform.htm")
    public String saveEditProfile(@ModelAttribute("appointment") Appointments appointment, BindingResult result, SessionStatus status, AppointmentsDAO appointmentsdao, HttpServletRequest req) {
     
        String view = null;
        if (result.hasErrors())
            view = "submitreviewform";
        else {
            
            appointmentsdao.updateAppointments(appointment);
            status.setComplete();
            view = "home";
        }
        return view;
    }
    
    @GetMapping("/viewappointmentsprofiles.htm")//to view already booked appointments
    public String viewAppointmentsProfilesGet(ModelMap model,AppointmentsDAO appointmentsdao, HttpServletRequest req) {
        User  currentuser=(User)req.getSession().getAttribute("currentuser");
        List<Appointments> appointmentslist = appointmentsdao.getOpenAppointmentsByCust(currentuser);
        model.addAttribute("appointmentslist", appointmentslist);
        return "viewappointmentprofiles";//to view already booked appointments that are not yet closed
    }
    @GetMapping("/viewclosedappointmentsprofiles.htm")//to view closed appointments
    public String viewClosedAppointmentsProfilesGet(ModelMap model,AppointmentsDAO appointmentsdao, HttpServletRequest req) {
        User  currentuser=(User)req.getSession().getAttribute("currentuser");
        List<Appointments> appointmentslist = appointmentsdao.getClosedAppointmentsByCust(currentuser);
        model.addAttribute("appointmentslist", appointmentslist);
        return "viewclosedappointmentprofiles";//to view already closed appointments to write review
    }
    
    @RequestMapping(value="/rateandreviewappointment.htm", method = RequestMethod.GET)
    public String rateAndReviewAppointment(ModelMap model, HttpServletRequest request,AppointmentsDAO appointmentsdao ) {
            String id = request.getParameter("id");
            Appointments appointment=appointmentsdao.getAppointmentById(Integer.parseInt(id));    
            
        model.addAttribute("appointment",appointment);  
        return "writereviewform";
    }
    @RequestMapping(value="/submitreview.htm", method = RequestMethod.GET)
    public String submitReview(ModelMap model, HttpServletRequest request,AppointmentsDAO appointmentsdao, BizDAO bizdao ) {
            String id = request.getParameter("id");
            String comments = request.getParameter("review");
            int rating = Integer.parseInt(request.getParameter("rating"));
            Appointments appointment=appointmentsdao.getAppointmentById(Integer.parseInt(id));    
            System.out.println("appoint id : "+appointment.getAppointid());
            appointment.setCustreviews(appointment.getCustreviews()+comments);
            System.out.println("appoint id : "+appointment.getCustreviews());
            appointmentsdao.updateAppointments(appointment);
            
           Biz biz = bizdao.getBizByNameEmail(appointment.getBizname(),appointment.getBizemail());
           if(biz.getRating()>0)
                    biz.setRating( (biz.getRating()+rating)/2);
           biz.setRating(rating);
                   bizdao.updateBiz(biz);
        return "home";
    }

    @RequestMapping(value="/appontmentregistered.htm", method = RequestMethod.POST) //after showing appointment confirmation go to home page
	public String appointments(ModelMap model, HttpServletRequest request) {
             
		return "home";
	} 
    //----------------------------------------------------------------------------------
        //Below - Appointments views and editing for Business Partners
        
       @GetMapping("/viewappointmentsforbp.htm")
       public String viewAppointmentsforbp(ModelMap model,AppointmentsDAO appointmentsdao, HttpServletRequest req) {
        User  currentuser=(User)req.getSession().getAttribute("currentuser");
        List<Appointments> appointmentslist = appointmentsdao.getOpenAppointmentsByBizOwner(currentuser.getEmail());
        model.addAttribute("appointmentslist", appointmentslist);
        return "viewappointmentsforbp";
    }
  
    
            @RequestMapping(value="/submitbpclosurereview.htm", method = RequestMethod.GET)
            public String submitBPClosureReview(ModelMap model, HttpServletRequest request,AppointmentsDAO appointmentsdao, PetDAO petdao ) {
            String id = request.getParameter("id");
           // String comments = request.getParameter("review");
            Appointments appointment=appointmentsdao.getAppointmentById(Integer.parseInt(id));
            Pet pet = petdao.getPetByNameandOwneremail(appointment.getPetname(),appointment.getCustemail());
            System.out.println(pet.getAboutpet());
            //String custname=
            model.addAttribute("appointmentselected", appointment);
            model.addAttribute("appointmentpet",pet);
           // appointment.setClosingstatus(comments);
            //appointmentsdao.updateAppointments(appointment);
        return "processappointmentforbp";
    }
            
    @RequestMapping(value="/processandcloseappointment.htm",method = RequestMethod.GET)
    public String processAndCloseAppointment(ModelMap model,AppointmentsDAO appointmentsdao, HttpServletRequest req) {
            String view = null;
          //  System.out.println("in controller save"+appointment.getReqdate());
          String id = req.getParameter("id");
           // String comments = request.getParameter("review");
            Appointments appointment=appointmentsdao.getAppointmentById(Integer.parseInt(id));
            appointment.setClosingstatus("Closed");
            appointmentsdao.updateAppointments(appointment);
            //status.setComplete();
            req.setAttribute("appointmentid",appointment.getAppointid());
            view = "appointmentclosurereceipt";
      
        return view;
    }
    @RequestMapping(value="/viewcustreviwsforbp.htm",method = RequestMethod.GET)
    public String viewCustomerReviwsOnAppointmentsforbp(ModelMap model,AppointmentsDAO appointmentsdao, HttpServletRequest req) {
            String view = null;
            User  currentuser=(User)req.getSession().getAttribute("currentuser");
            //String bizowneremail=currentuser.getEmail();
          //  System.out.println("in controller save"+appointment.getReqdate());
         // String id = req.getParameter("id");
           // String comments = request.getParameter("review");
            List<Appointments> appointments=appointmentsdao.getAppointmentsByBizOwner(currentuser.getEmail());
            if(appointments.size()>0)
               //appointments.iterator().next();
            //appointmentsdao.updateAppointments(appointment);
            //status.setComplete();
            req.setAttribute("appointmentslistforreviews",appointments);
            view = "viewcustreviwsforbp";
      
        return view;
    }
    
//---------------------------------------------------------------------------------------
}

