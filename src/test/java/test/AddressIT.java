/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.capitulo3.beanvalidation.javase.todojunto.Address;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author cesar
 */
public class AddressIT {
    
    public AddressIT() {
    }
    
    @Test
    public void shouldRaiseConstraintViolationCauseInvalidZipCode(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Address address = new Address("street1", "ciudad1", "codigoestado", "Dummyzip", "USA");
        Set<ConstraintViolation<Address>> violations = validator.validate(address, Default.class);
        for(ConstraintViolation<Address> violation : violations){
            System.out.println(violation.getMessage() + "----template:"+violation.getMessageTemplate() + "---invalid value:"+violation.getInvalidValue());
        }
        
        assertEquals(1,violations.size());
        
        factory.close();
    }
    
}
