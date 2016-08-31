package py.una.ia.busquedas.domain;

import java.util.List;

/**
 *
 * @author juan corrlaes
 */
public class Nodo {
    int nombre;
    Nodo padre;
    List<Nodo> hijos;

    public Nodo(Nodo padre, List<Nodo> hijos) {
        this.padre = padre;
        this.hijos = hijos;
    }
    
}
