/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capitulo3.beanvalidation.javase.todojunto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author cesar
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

    //@Inject @USA
   // private ZipCodeChecker checker;
    private ZipCodeChecker checker = new ZipCodeChecker();
    private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");
    
   @Override
    public void initialize(ZipCode zipCode) {
        
    }

 

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Matcher m = zipPattern.matcher(value);
        if (!m.matches()) {
            return false;
        }
        return checker.isZipCodeValid(value);

    }

   

}
