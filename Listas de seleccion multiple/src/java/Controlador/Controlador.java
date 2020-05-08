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
import java.util.Collections;

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
        if(!ordenado)
            llistaObjectes = model.getLlistaObjectes();
    }
    private String Nombre;
    private int Peso;
    private List<Objecte> llistaObjectes;
    private List<Objecte> llistaObjectesSeleccionats;
    private boolean ordenado;

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPeso(int Peso) {
        this.Peso = Peso;
    }

    public void setLlistaObjectes(List<Objecte> llistaObjectes) {
        this.llistaObjectes = llistaObjectes;
    }

    public void setLlistaObjectesSeleccionats(List<Objecte> llistaObjectesSeleccionats) {
        this.llistaObjectesSeleccionats = llistaObjectesSeleccionats;
    }

    public void setOrdenado(boolean ordenado) {
        this.ordenado = ordenado;
    }

    public boolean isOrdenado() {
        return ordenado;
    }

    public List<Objecte> getLlistaObjectesSeleccionats() {
        return llistaObjectesSeleccionats;
    }

    public List<Objecte> getLlistaObjectes() {
        return llistaObjectes;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public int getPeso() {
        return Peso;
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

    /**
     *Ordena las lista de objetos 
     * @return
     */
    public String ordenar(){
        Collections.sort(llistaObjectes);
        return "index";
    }
}









