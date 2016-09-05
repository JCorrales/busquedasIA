
package py.una.ia.busquedas.algoritmos;

import java.util.List;
import java.util.PriorityQueue;
import py.una.ia.busquedas.domain.Grafo;
import py.una.ia.busquedas.domain.Nodo;
import py.una.ia.busquedas.domain.NodoHeuristico;

/**
 *
 * @author juan corrales
 */
public class Avaro {
    private final Grafo grafo;
    private final int origen;
    private final int destino;
    private final double[] h;
    private Nodo solucion;
    private Long tiempo;
    private Long profundidad = 0L;
    private Long profundidadMaxima = 0L;
    private Long start;
    private Long maxTime;
    private final PriorityQueue<Nodo> arbol = new PriorityQueue<>();
    
    public Avaro(Grafo grafo, Long maxTime){
        this.grafo = grafo;
        this.origen = grafo.getOrigen();
        this.destino = grafo.getDestino();
        this.h = grafo.getH();
        this.maxTime = maxTime;
    }
    
    public Nodo getSolucion(){
        return this.solucion;
    }
    
    public Long getTiempo() {
        return tiempo;
    }

    public void setTiempo(Long tiempo) {
        this.tiempo = tiempo;
    }
    
    public void buscar(){
        start = System.currentTimeMillis();
        Nodo nodoOrigen = new NodoHeuristico(this.grafo.getOrigen(), null, this.grafo);
        arbol.add(nodoOrigen);
        busquedaAvara();
        Long end = System.currentTimeMillis();
        this.tiempo = end -start;
    }
    
    /**
     * Busca en profunidad, evita generar estados repetidos
     */
    private void busquedaAvara(){
        Nodo padre;
        while(true){
            padre = arbol.poll();
            if(padre.getNombre() == destino){
                solucion = padre;
                return;
            }
            
            if(!hayTiempo()){
                return;
            }
            
            List<Nodo> hijos = padre.expandir();
            for(int i=0; i< hijos.size(); i++){
                arbol.add(hijos.get(i));
            }
        }
    }

    public Long getProfundidadMaxima() {
        return profundidadMaxima;
    }
    
    private boolean hayTiempo(){
        return (System.currentTimeMillis() - this.start < this.maxTime);
    }
    
}

