package com.mycompany.splootproject;

import com.mycompany.splootproject.dao.BizDAO;
import com.mycompany.splootproject.dao.UserDAO;
import com.mycompany.splootproject.dao.PetDAO;
import com.mycompany.splootproject.pojo.Biz;
import com.mycompany.splootproject.pojo.User;
import com.mycompany.splootproject.pojo.Pet;
import com.mycompany.splootproject.validation.BizValidator;
import com.mycompany.splootproject.validation.PetValidator;
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
import javax.validation.Valid;
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
public class SplootController {
    @Autowired
    UserValidator uservalidator;
    
    @Autowired
    PetValidator petvalidator;
    
    @Autowired
    BizValidator bizvalidator;
    
    //----------------------------------------------------------------------
    //Section 1 : Below are pet owner related activities.htm mapping URLs
    //-------------------------------------------------
    @GetMapping("/petprofile.htm")
    public String petProfile(ModelMap model, Pet pet) {

        model.addAttribute("pet", pet);
        return "petprofile";
    }
    @GetMapping("/editpetprofile.htm")
    public String editpetProfile(ModelMap model, Pet pet) { 
        model.addAttribute("pet", pet);
        return "petprofile";
    }     
    
    @PostMapping("/registerpet.htm")
    public String saveUserPost(@ModelAttribute("pet") Pet pet, BindingResult result, SessionStatus status, PetDAO petdao, HttpServletRequest req) {
            String view = null;
        if (result.hasErrors())
            view = "petprofile";
        else {
            User  currentuser=(User)req.getSession().getAttribute("currentuser");
            pet.setOwneremail(currentuser.getEmail());
            petdao.createPet(pet);
            status.setComplete();
            view = "home";
        }
        return view;
    }
    @PostMapping("/savepeteditform.htm")
    public String saveEditProfile(@ModelAttribute("pet") Pet pet, BindingResult result, SessionStatus status, PetDAO petdao, HttpServletRequest req) {
        System.out.println("saveEditProfile : "+pet.getPetid()+":"+pet.getPetname()+":"+pet.getBreed());
        String view = null;
        if (result.hasErrors())
            view = "editpetform";
        else {
            
            petdao.updatePet(pet);
            status.setComplete();
            view = "home";
        }
        return view;
    }
    
    @GetMapping("/viewpetprofiles.htm")
    public String viewpetProfilesGet(ModelMap model,PetDAO petdao, HttpServletRequest req) {
        User  currentuser=(User)req.getSession().getAttribute("currentuser"); //extracxted the User from the "currentuser" tagged attribute of Session
        List<Pet> petlist = petdao.getPets(currentuser);
        model.addAttribute("petlist", petlist);
        return "viewpetprofiles";//jsp to list the pets and allow edit and delete of each
    }
    
    @RequestMapping(value="/editpet.htm", method = RequestMethod.GET)
    public String editPet(ModelMap model, HttpServletRequest request,PetDAO petdao ) {
            String id = request.getParameter("id");//extract the is from request
            Pet pet=petdao.getPetById(Integer.parseInt(id));    //convert it to integer and send this integer to petdao to extract the pet using 'getPetById' method
        model.addAttribute("pet",pet);  //set this pet to model attribute
        return "editpetform"; //send to user through this jsp
    }
     @RequestMapping(value="/deletepet.htm", method = RequestMethod.GET)
    public String deletePet(ModelMap model, HttpServletRequest request,PetDAO petdao ) {
            String id = request.getParameter("id");
            Pet pet=petdao.getPetById(Integer.parseInt(id)); 
        if(pet!=null)
        { System.out.println("deletePet : "+pet.getPetid()+":"+pet.getPetname()+":"+pet.getBreed());
          petdao.deletePet(pet);}
        return "home";
    }
    
    //----------------------------------------------------------------------------------
    //Section 2: Below are User related activities (like login etc).htm mapping URLs
    //-------------------------------------------------------------------
    @GetMapping("/loginsignup.htm")
    public String saveUserGet(ModelMap model, User user) {
        model.addAttribute("user", user);
        return "loginsignup";
    }
    @GetMapping("/logout.htm")
    public String logoutUser(HttpServletRequest req) {
        req.getSession().invalidate();
        return "index";
    }
    
    @PostMapping("/signup.htm")
    public String saveUserPost(@ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDAO userdao, PetDAO petdao, BizDAO bizdao, HttpServletRequest req) {
        String view = null;
        String errorMessge =null;
       
        if(user.getEmail().isBlank()|| user.getPass().isBlank())
       {errorMessge="Error : Email/Pass is blank"; 
            user.setCity("");user.setEmail("");user.setPass("");
            req.setAttribute("errorMessge", errorMessge);
            view = "loginsignup"; return view;
       }
        if (userdao.getUserByEmail(user.getEmail())!=null) {
            errorMessge="Signup Error : User with this email already exists"; 
            user.setCity("");user.setEmail("");user.setPass("");
            req.setAttribute("errorMessge", errorMessge);
            view = "loginsignup"; return view;}
        
        userdao.createUser(user);
        if (result.hasErrors())
        {view = "loginsignup"; return view;}
        else {      
            status.setComplete();
            req.getSession().setAttribute("currentuser", user);
            String type=user.getUtype();
            view = "home";
        }
        return view;
    }
@PostMapping("/login.htm")
    public String loginUserPost(@ModelAttribute("user") User user, BindingResult result, SessionStatus status, UserDAO userdao, PetDAO petdao, BizDAO bizdao, HttpServletRequest req) {
        String view = null;
        String errorMessge =null;
       if(user.getEmail().isBlank()|| user.getPass().isBlank()) //to validate entries
       {errorMessge="Error : Email/Pass is blank"; 
            user.setCity("");user.setEmail("");user.setPass("");
            req.setAttribute("errorMessge", errorMessge);
            view = "loginsignup"; return view;//go back to loginsignup.jsp with errors
       }
        if (userdao.authUser(user))//authenticate user
        { req.getSession().setAttribute("currentuser", user);//settingup current user for this session untill logged out
        
          status.setComplete();
            view = "home";}
        else {
            errorMessge="Login Error : Wrong email or password"; //if authentication fails
            req.setAttribute("errorMessge", errorMessge);
            user.setEmail("");user.setPass("");
            view = "loginsignup";
        }
        return view;
    }
     @GetMapping("/home.htm")
    public String home(ModelMap model, User user, HttpServletRequest req) {
       //req.getSession().getAttribute("currentuser")
       // model.addAttribute("biz", biz);
        return "home";
    }
    
//---------------------------------------------------------------------------------------
    //Section3 : Below are Biz related activities .htm mapping URLs
    //-------------------------------------------
    
    
     @GetMapping("/bizprofile.htm")
    public String bizProfile(ModelMap model, Biz biz) {

        model.addAttribute("biz", biz);
        return "bizprofile";
    }
    @GetMapping("/editbizprofile.htm")
    public String editbizProfile(ModelMap model, Biz biz) { 
        model.addAttribute("biz", biz);
        return "bizprofile";
    }     
    
    @PostMapping("/registerbiz.htm")
    public String saveBizPost(@ModelAttribute("biz") Biz biz, BindingResult result, SessionStatus status, BizDAO bizdao, HttpServletRequest req) {
            String view = null;
        if (result.hasErrors())
            view = "bizprofile";
        else {
            User  currentuser=(User)req.getSession().getAttribute("currentuser");
            biz.setOwneremail(currentuser.getEmail());
            bizdao.createBiz(biz);
            status.setComplete();
            view = "home";
        }
        return view;
    }
    @PostMapping("/savebizeditform.htm")
    public String saveEditProfile(@ModelAttribute("biz") Biz biz, BindingResult result, SessionStatus status, BizDAO bizdao, HttpServletRequest req) {
        System.out.println("saveEditProfile : "+biz.getBizid()+":"+biz.getBizname()+":"+biz.getBtype());
        String view = null;
        if (result.hasErrors())
            view = "editbizform";
        else {
            
            bizdao.updateBiz(biz);
            status.setComplete();
            view = "home";
        }
        return view;
    }
    
    @GetMapping("/viewbizprofiles.htm")
    public String viewbizProfilesGet(ModelMap model,BizDAO bizdao, HttpServletRequest req) {
        User  currentuser=(User)req.getSession().getAttribute("currentuser");
        List<Biz> bizlist = bizdao.getBizs(currentuser);
        model.addAttribute("bizlist", bizlist);
        return "viewbizprofiles";
    }
    
    @RequestMapping(value="/editbiz.htm", method = RequestMethod.GET)
    public String editBiz(ModelMap model, HttpServletRequest request,BizDAO bizdao ) {
            String id = request.getParameter("id");
            Biz biz=bizdao.getBizById(Integer.parseInt(id));    
            System.out.println("editBiz : "+biz.getBizid()+":"+biz.getBizname()+":"+biz.getBtype());
        model.addAttribute("biz",biz);  
        return "editbizform";
    }
     @RequestMapping(value="/deletebiz.htm", method = RequestMethod.GET)
    public String deleteBiz(ModelMap model, HttpServletRequest request,BizDAO bizdao ) {
            String id = request.getParameter("id");
            Biz biz=bizdao.getBizById(Integer.parseInt(id)); 
        if(biz!=null)
        { System.out.println("deleteBiz : "+biz.getBizid()+":"+biz.getBizname()+":"+biz.getBtype());
          bizdao.deleteBiz(biz);}
        return "home";
    }
    
}

