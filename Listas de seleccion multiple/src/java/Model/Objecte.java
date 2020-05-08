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
public class Objecte implements Comparable<Objecte> {
    private String Nombre;
    private int Peso;

    public String getNombre() {
        return Nombre;
    }

    public int getPeso() {
        return Peso;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPeso(int Peso) {
        this.Peso = Peso;
    }

    public Objecte(String Nombre, int Peso) {
        this.Nombre = Nombre;
        this.Peso = Peso;
    }  

    @Override
    public int compareTo(Objecte o) {
        return this.Peso -o.Peso;
    }
    
}
