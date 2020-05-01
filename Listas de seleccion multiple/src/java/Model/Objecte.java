/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author GERARD CAPILLA BAEZA
 */
public class Objecte {
    private String Nombre;
    private double Peso;

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

    public Objecte(String Nombre, double Peso) {
        this.Nombre = Nombre;
        this.Peso = Peso;
    }
    
    
}
