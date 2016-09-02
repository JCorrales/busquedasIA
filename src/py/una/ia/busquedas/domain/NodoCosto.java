/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.ia.busquedas.domain;

/**
 *
 * @author juan
 */
public class NodoCosto extends Nodo{

    public NodoCosto(int nombre, Nodo padre, Grafo grafo) {
        super(nombre, padre, grafo);
    }

    @Override
    public int compareTo(Nodo o) {
        return getCosto().compareTo(o.getCosto());
    }

    @Override
    public Nodo getNewInstance(int nombre, Nodo padre, Grafo grafo) {
        return new NodoCosto(nombre, padre, grafo);
    }

}
