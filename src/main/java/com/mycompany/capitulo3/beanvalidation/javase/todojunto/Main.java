/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capitulo3.beanvalidation.javase.todojunto;

import java.util.Date;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

/**
 *
 * @author cesar
 */
public class Main {

    public static void main(String[] args) {
//        Weld weld = new Weld();
//        WeldContainer weldContainer = weld.initialize();
//        Customer customer = weldContainer.select(Customer.class).get();
//        System.out.println(customer.getEmail());
//        
//        weld.shutdown();
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

        Date fechapost = new Date(2000,1,1);
        //Date fechapost = new Date(1988, 7, 1);
        Date fechaAnt = new Date(System.currentTimeMillis() - 100);
        Fechas fechas = new Fechas(fechapost, fechaAnt);

        Set<ConstraintViolation<Fechas>> violations = validator.validate(fechas, Default.class);
        if (violations.size() > 0) {

            System.out.println("Se encontraron errores");
            for (ConstraintViolation<Fechas> violation : violations) {
                System.out.println(violation.getMessage() + "---template" + violation.getMessageTemplate());
            }
        }

        vf.close();

    }
}
