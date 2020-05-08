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
import java.util.LinkedList;

/**
 *
 * @author Guillem 
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
    private String nom;
    private int pes;
    private List<Objecte> llistaObjectes;
    private List<Objecte> llistaSortida = new LinkedList<>();
    private List<Objecte> llistaSeleccionats;
    private boolean ordenarObj;

    public void setLlistaSortida(List<Objecte> llistaSortida) {
        this.llistaSortida = llistaSortida;
    }

    public List<Objecte> getLlistaSortida() {
        return llistaSortida;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPes(int pes) {
        this.pes = pes;
    }

    public void setLlistaObjectes(List<Objecte> llistaObjectes) {
        this.llistaObjectes = llistaObjectes;
    }

    public void setLlistaSeleccionats(List<Objecte> llistaSeleccionats) {
        this.llistaSeleccionats = llistaSeleccionats;
    }

    public void setOrdenarObj(boolean ordenarObj) {
        this.ordenarObj = ordenarObj;
    }

    public boolean isOrdenarObj() {
        return ordenarObj;
    }

    public List<Objecte> getLlistaSeleccionats() {
        return llistaSeleccionats;
    }

    public List<Objecte> getLlistaObjectes() {
        return llistaObjectes;
    }
    
    public String getNom() {
        return nom;
    }

    public int getPes() {
        return pes;
    }
    public String afegirObjecte() {
        Objecte objecte = new Objecte(nom, pes);
        model.getLlistaObjectes().add(objecte);
        ordenar();
        return "index";
    }
    public String eliminarObjectes() {
        model.getLlistaObjectes().removeAll(llistaSeleccionats);
        ordenar();
        return "index";
    }

    /**
     *Ordena les llistes 
     * @return
     */
    public String ordenar(){
        llistaSortida.clear();
        llistaSortida.addAll(model.getLlistaObjectes());
        if(ordenarObj){
            Collections.sort(llistaSortida);
        }        
        return "index";
    }
}









