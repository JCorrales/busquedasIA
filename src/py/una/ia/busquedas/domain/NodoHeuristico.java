package py.una.ia.busquedas.domain;

/**
 *
 * @author juan
 */
public class NodoHeuristico extends Nodo{
    
    public NodoHeuristico(int nombre, Nodo padre, Grafo grafo) {
        super(nombre, padre, grafo);
    }

    @Override
    public int compareTo(Nodo o) {
        return getH().compareTo(o.getH());
    }

    @Override
    public Nodo getNewInstance(int nombre, Nodo padre, Grafo grafo) {
        return new NodoHeuristico(nombre, padre, grafo);
    }
    
}
