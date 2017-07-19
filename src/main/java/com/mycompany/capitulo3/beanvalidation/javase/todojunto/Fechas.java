/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.capitulo3.beanvalidation.javase.todojunto;

import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 *
 * @author cesar
 */
public class Fechas {

    @Future
    @NotNull
    private Date fechaPosterior;
    @Past
    @NotNull
    private Date fechaAnterior;
    
    

    public Fechas(Date fechaPosterior, Date fechaAnterior) {
        this.fechaPosterior = fechaPosterior;
        this.fechaAnterior = fechaAnterior;
    }

    public Date getFechaPosterior() {
        return fechaPosterior;
    }

    public void setFechaPosterior(Date fechaPosterior) {
        this.fechaPosterior = fechaPosterior;
    }

    public Date getFechaAnterior() {
        return fechaAnterior;
    }

    public void setFechaAnterior(Date fechaAnterior) {
        this.fechaAnterior = fechaAnterior;
    }

}
