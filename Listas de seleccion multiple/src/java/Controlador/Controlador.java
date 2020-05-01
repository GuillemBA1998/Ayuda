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
import java.util.Arrays;

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
        ordenado = false;
        llistaObjectes = model.getLlistaObjectes();
    }
    private String Nombre;
    private double Peso;
    private List<Objecte> llistaObjectes;
    private List<Objecte> llistaObjectesSeleccionats;
    private boolean ordenado;

    public boolean isOrdenado() {
        return ordenado;
    }

    public void setOrdenado(boolean ordeando) {
        this.ordenado = ordeando;
    }
    

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
    public String Ordenar(){
        System.out.println(ordenado);
        if(ordenado){
            List<Objecte> Temp = llistaObjectes;
            Objecte pequeño;
            Objecte aux;
            Objecte[] temporal = new Objecte[llistaObjectes.size()];
            int j = llistaObjectes.size();
            for (int i = 0; i < j; i++) {
                pequeño = llistaObjectes.get(i);
                aux = pequeño;
                for (int k = 0; k < j ; k++) {
                    if(aux.getPeso() > llistaObjectes.get(k).getPeso()){
                        aux = llistaObjectes.get(k);
                    }
                    if(k==j-1){
                        if(pequeño.getPeso() > aux.getPeso())
                            temporal[j] = aux;
                        else
                            temporal[j] = pequeño;
                    }
                }
            }
            Temp.addAll(Arrays.asList(temporal));
            model.getLlistaObjectes().removeAll(llistaObjectes);
            model.getLlistaObjectes().addAll(Temp);
        }
        return "index";
    }
    
}









