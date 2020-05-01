/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import Model.Model;
import java.util.List;
import Model.Objecte;

/**
 *
 * @author GERARD CAPILLA BAEZA
 */
@Named(value = "controlador")
@SessionScoped
public class Controlador implements Serializable {

     @Inject
    Model model;
    
    /**
     * Creates a new instance of Controlador
     */
    public Controlador() {
    }
    
    @PostConstruct
    void init() {
        llistaObjectes = model.getLlistaObjectes();
    }
    private String Nombre;
    private double Peso;
    private List<Objecte> llistaObjectes;
    private List<Objecte> llistaObjectesSeleccionats;

    public void setLlistaObjectesSeleccionats(List<Objecte> llistaObjectesSeleccionats) {
        this.llistaObjectesSeleccionats = llistaObjectesSeleccionats;
    }

    public List<Objecte> getLlistaObjectesSeleccionats() {
        return llistaObjectesSeleccionats;
    }

    public List<Objecte> getLlistaObjectes() {
        return llistaObjectes;
    }

    public void setLlistaObjectes(List<Objecte> llistaObjectes) {
        this.llistaObjectes = llistaObjectes;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public double getPeso() {
        return Peso;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }
    public String afegirObjecte() {
        Objecte objecte = new Objecte(Nombre, Peso);
        model.getLlistaObjectes().add(objecte);
    return "index";
 }
    public String eliminarObjectes() {
        model.getLlistaObjectes().removeAll(llistaObjectesSeleccionats);
    return "index";
    }
}
