/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author GERARD CAPILLA BAEZA
 */
@Named(value = "model")
@SessionScoped
public class Model implements Serializable {

    /**
     * Creates a new instance of Model
     */
    
    final private List<Objecte> llistaObjectes;
    
    public List<Objecte> getLlistaObjectes() {
        return llistaObjectes;
    }

    
    public Model() {
        llistaObjectes = new LinkedList<>();
    }
    
}
