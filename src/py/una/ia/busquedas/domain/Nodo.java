package py.una.ia.busquedas.domain;

import java.util.List;

/**
 *
 * @author juan corrales
 */
public class Nodo implements Comparable<Nodo>{
    private int nombre;
    private Nodo padre;
    private List<Nodo> hijos;
    private double h;
    private Integer costo;

    public Nodo(int nombre, double h, List<Nodo> hijos) {
        this.nombre = nombre;
        this.h = h;
        this.hijos = hijos;
    }

    @Override
    public int compareTo(Nodo o) {
        return this.costo.compareTo(o.getCosto());
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public List<Nodo> getHijos() {
        return hijos;
    }

    public void setHijos(List<Nodo> hijos) {
        this.hijos = hijos;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
   
    
}
