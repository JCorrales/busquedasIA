
package py.una.ia.busquedas.domain;

/**
 *
 * @author juan
 */
public class NodoF extends Nodo{

    public NodoF(int nombre, Nodo padre, Grafo grafo) {
        super(nombre, padre, grafo);
    }

    @Override
    public Nodo getNewInstance(int nombre, Nodo padre, Grafo grafo) {
        return new NodoF(nombre, padre, grafo);
    }

    @Override
    public int compareTo(Nodo o) {
        return getF().compareTo(o.getF());
    }
    
}
