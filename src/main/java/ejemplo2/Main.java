/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

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
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        
        Curso obj = new Curso();
        obj.setTitulo("");
        obj.setDisponible(Boolean.TRUE);
        obj.setNumeroSillas(1);
        obj.setProfesor(null);
        
        Profesor profesor = new Profesor("", "p");
        obj.setProfesor(profesor);
        
        Set<ConstraintViolation<Curso>> violations = validator.validate(obj, Default.class);
        if(violations.size()>0){
            System.out.println("se encontraron errores");
            for(ConstraintViolation<Curso> violation : violations){
                System.out.println(violation.getMessage()+ "---template:"+violation.getMessageTemplate()+"---invalid value:"+violation.getInvalidValue());
            }
        }
        
        vf.close();
    }
}
