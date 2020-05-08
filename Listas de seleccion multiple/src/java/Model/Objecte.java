/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Guillem
 */
public class Objecte implements Comparable<Objecte> {
    private String nom;
    private int pes;

    public String getNom() {
        return nom;
    }

    public int getPes() {
        return pes;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPes(int pes) {
        this.pes = pes;
    }

    public Objecte(String nom, int pes) {
        this.nom = nom;
        this.pes = pes;
    }  

    @Override
    public int compareTo(Objecte obj) {
        return this.pes -obj.pes;
    }
    
}
