/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.splootproject.validation;

import com.mycompany.splootproject.pojo.Pet;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author ysf
 */
public class PetValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Pet.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
    } 
}
