package py.una.ia.busquedas.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan corrales
 */
public abstract class Nodo implements Comparable<Nodo> {

    private final int nombre;
    private Nodo padre;
    private List<Nodo> hijos;
    private final Double h;
    private Integer costo = 0;
    private final Grafo grafo;
    private static int expandidos = 0;

    public Nodo(int nombre, Nodo padre, Grafo grafo) {
        this.nombre = nombre;
        this.h = grafo.getH()[nombre];
        this.grafo = grafo;
        if (padre != null) {
            this.costo = padre.getCosto() + grafo.getCiudades()[padre.getNombre()][this.nombre];
            this.padre = padre;
        }
    }

    public int getNombre() {
        return nombre;
    }

    public Nodo getPadre() {
        return padre;
    }

    public Double getH() {
        return h;
    }

    public Integer getCosto() {
        return costo;
    }
    
    public void setCosto(Integer costo){
        this.costo = costo;
    }

    public static int getExpandidos() {
        return expandidos;
    }
    
    public static void resetExpandidos(){
        expandidos = 0;
    }
    
    public Double getF(){
        return (double)costo + this.h;
    }
    /**
     * Exapandir el nodo generando sus hijos teniendo cuidado
     * de no generar hijos ya visitados en niveles superiores
     * @return lista de hijos 
     */
    public List<Nodo> expandir() {
        //hago una copia de las ciudades alcanzables desde este nodo
        int[] ciudades = grafo.getCiudades()[nombre].clone();
        //antes de expandir eliminar hijos ya visitados
        Nodo visitado = this;
        do {
            ciudades[visitado.getNombre()] = Grafo.NO_HAY_RUTA;
            visitado = visitado.getPadre();
        } while (visitado != null);
        //crear lista de hijos(solo si un hijo no fue visitado)
        this.hijos = new ArrayList<>();
        for (int hijo = 0; hijo < ciudades.length; hijo++) {
            if (ciudades[hijo] != Grafo.NO_HAY_RUTA) {
                expandidos += 1;
                this.hijos.add(getNewInstance(hijo, this, grafo));
            }
        }
        return this.hijos;
    }
    
    public abstract Nodo getNewInstance(int nombre, Nodo padre, Grafo grafo);
}
