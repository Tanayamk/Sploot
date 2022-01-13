/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.splootproject.validation;

import com.mycompany.splootproject.pojo.Biz;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author User
 */
public class BizValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Biz.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
    } 
}

