
package py.una.ia.busquedas.algoritmos;

import java.util.List;
import java.util.PriorityQueue;
import py.una.ia.busquedas.domain.Grafo;
import py.una.ia.busquedas.domain.Nodo;
import py.una.ia.busquedas.domain.NodoCosto;

/**
 *
 * @author juan
 */
public class CostoUniforme {
    private final PriorityQueue<Nodo> arbol = new PriorityQueue<>();
    private final Grafo grafo;
    private final int origen;
    private final int destino;
    private Nodo solucion;
    private Long tiempo;
    
    public CostoUniforme(Grafo grafo){
        this.grafo = grafo;
        this.origen = grafo.getOrigen();
        this.destino = grafo.getDestino();
        NodoCosto nodoOrigen = new NodoCosto(grafo.getOrigen(), null, grafo);
        this.arbol.add(nodoOrigen);
    }
    
    public Nodo getSolucion(){
        return this.solucion;
    }
    
    public void buscar(){
        Long start = System.currentTimeMillis();
        Long end;
        Nodo padre;
        while(true){
            padre = arbol.poll();
            if(padre.getNombre() == destino){
                solucion = padre;
                end = System.currentTimeMillis();
                this.tiempo = end - start;
                return;
            }
            
            List<Nodo> hijos = padre.expandir();
            for(int i=0; i< hijos.size(); i++){
                arbol.add(hijos.get(i));
            }
        }
    }

    public Long getTiempo() {
        return tiempo;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
    }
    
}
