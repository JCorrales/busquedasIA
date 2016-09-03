
package py.una.ia.busquedas.algoritmos;

import java.util.Collections;
import java.util.List;
import py.una.ia.busquedas.domain.Grafo;
import py.una.ia.busquedas.domain.Nodo;
import py.una.ia.busquedas.domain.NodoF;

/**
 *
 * @author juan corrales
 */
public class Aestrella {
    private final Grafo grafo;
    private final int origen;
    private final int destino;
    private final double[] h;
    private Nodo solucion;
    private Long tiempo;
    private Long profundidad = 0L;
    private Long profundidadMaxima = 0L;
    private boolean stop;
    private Long start;
    private Long maxTime;
    
    public Aestrella(Grafo grafo, Long maxTime){
        this.grafo = grafo;
        this.origen = grafo.getOrigen();
        this.destino = grafo.getDestino();
        this.h = grafo.getH();
        Nodo lejos = new NodoF(origen, null, grafo);
        lejos.setCosto(Integer.MAX_VALUE);
        this.solucion = lejos;
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
        Nodo nodoOrigen = new NodoF(this.grafo.getOrigen(), null, this.grafo);
        busquedaAestrella(nodoOrigen);
        Long end = System.currentTimeMillis();
        this.tiempo = end -start;
    }
    
    /**
     * Busca en profunidad, evita generar estados repetidos
     */
    private void busquedaAestrella(Nodo padre){
        checkTime();
        List<Nodo> hijos = padre.expandir();
        Collections.sort(hijos);
        System.out.println("+++++++++++++++++++");
        for (int i=0; i< hijos.size(); i++) {
            System.out.print(hijos.get(i).getF()+" ");
        }
        System.out.println("opa");
        
        for(int i=0; i< hijos.size(); i++){
            if(stop){
                return;
            }
            if(hijos.get(i).getNombre() == destino){
                solucion = hijos.get(i);
                this.stop = true;
            }else{
                profundidad += 1L;
                busquedaAestrella(hijos.get(i));
                if(profundidad > profundidadMaxima){
                    profundidadMaxima = profundidad;
                }
                profundidad = 0L;
            }  
        }        
    }

    public Long getProfundidadMaxima() {
        return profundidadMaxima;
    }
    
    private void checkTime(){
        if(System.currentTimeMillis() - this.start > this.maxTime){
            this.stop = true;
        }
    }
    
}


