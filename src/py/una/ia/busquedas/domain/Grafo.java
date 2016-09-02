
package py.una.ia.busquedas.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan
 */
public class Grafo {
    private final int [][] ciudades;
    private final int n;
    private final int e;
    private final int min;
    private final int max;
    private final int origen;
    private final int destino;
    private final double[] h;
    private List<Integer> visitados = new ArrayList<>();
    private List<Integer> arbol = new ArrayList<>();
    public static final int NO_HAY_RUTA = 0;
    private int heuristicas = 0;
    private int alAzar = 0;
    
    /**
     * 
     * @param n cantidad de ciudades
     * @param e porcentaje de aristas a eliminar
     * @param min distancia minima entre dos ciudades
     * @param max distancia maxima entre dos ciudades
     * @param origen
     * @param destino
     */
    public Grafo(int n, int e, int min, int max, int origen, int destino){
        this.ciudades = new int[n][n];
        this.n = n;
        this.e = e;
        this.min = min;
        this.max = max;
        this.origen = origen;
        this.destino = destino;
        this.h = new double[n];
        generarMatrizVacia();
        generarGrafoConexo(min, max);
        h[destino] = 0;
        crearHeuristica(min, destino);
        engordarGrafo(min, max, e);
    }

    private void generarMatrizVacia() {
        for(int fila=0; fila < n; fila++){
            for(int columna = 0; columna < n; columna++){
                ciudades[fila][columna] = NO_HAY_RUTA;
            }
        }
    }
    /**
     * cuantas aristas necesito para crear un grafo conexo?
     * n-1, para 1 nodo no necesito ninguna arista, para dos
     * necesito 1 arista, para tres nodos necesito 2...
     * @param min
     * @param max 
     */
    private void generarGrafoConexo(int min, int max) {
        int nodo = Util.randInt(0, n-1);//un nodo
        int otroNodo = sortearNodo(nodo);//otro nodo XD
        List<Integer> conectados = new ArrayList<>();
        //creo n-1 aristas
        for(int i=1; i < n; i++){
            //genero aleatoriamente la distancia
            ciudades[nodo][otroNodo] = Util.randInt(min, max);
            ciudades[otroNodo][nodo] = ciudades[nodo][otroNodo];
            registrarNodosConectados(nodo, otroNodo, conectados);
            nodo = getNodoDesconectado(conectados);
            otroNodo = getNodoConectado(conectados);
        }
    }
    
    private int sortearNodo(int otroNodo){
        int nodo;
        do{
            nodo = Util.randInt(0, n-1);
        }while(nodo == otroNodo);
        
        return nodo;
    }
    
    private void registrarNodosConectados(int nodo, int otroNodo, List<Integer> conectados){
        if(!conectados.contains(nodo)){
                conectados.add(nodo);
        }
        if(!conectados.contains(otroNodo)){
            conectados.add(otroNodo);
        }
    }
    
    private int getNodoDesconectado(List<Integer> conectados) {
        List<Integer> desconectados = new ArrayList<>();
        for(int i=0; i < n; i++){
            if(!conectados.contains(i)){
                desconectados.add(i);
            }
        }
        if(desconectados.isEmpty()){
            //ocurre cuando ya no hay desconectados
            return -1;
        }
        return desconectados.get(Util.randInt(0, desconectados.size()-1));
    }
    
    private int getNodoConectado(List<Integer> conectados) {
        return conectados.get(Util.randInt(0, conectados.size()-1));
    }
    
    private void crearHeuristica(int min, int destino) {
        visitados.add(destino);
        arbol.add(destino);
        int padre;
        while(arbol.size() > 0){
            padre = arbol.remove(0);
            for(int hijo=0; hijo< n; hijo++){
                if(ciudades[padre][hijo] != NO_HAY_RUTA){
                    if(!visitados.contains(hijo)){
                        visitados.add(hijo);
                        arbol.add(hijo);
                        h[hijo] = h[padre] + ((float)Util.randInt(80, 100)/100*min);
                        heuristicas++;
                    }
                }
            }
        }
        System.out.println("Heuristicas: "+heuristicas);
    }
    
    /**
     * Un Grafo completo tiene n(n-1)/2
     */
    private void engordarGrafo(int min, int max, int e){
        int fila;
        int columna;
        int totalAristas = n*(n-1)/2;
        int actualAristas = n-1;//el grafo conexo debe tener minimo n-1 aristas
        int cuantas = totalAristas - actualAristas - (int)(((float)totalAristas)/100*e);
        int index;
        List<List<Integer>> aristaVacias = new ArrayList<>();
        //crear la mayor cantidad posible de aristas totalmente al azar
        System.out.println("Creando aristas (fila y columna al azar) ...");
        for(int i=0; i < cuantas*100; i++){
            fila = Util.randInt(0, n-1);
            columna = Util.randInt(0, n-1);
            if(ciudades[fila][columna] != NO_HAY_RUTA){
                ciudades[fila][columna] = Util.randInt(min, max);
                ciudades[columna][fila] = ciudades[fila][columna];
                alAzar++;
            }
        }
        System.out.println("Creadas: "+alAzar);
        //crear una lista de todas las aristas vacias, solo triangular superior
        
        System.out.println("Creando lista de aristas vacias...");
        for(int i=0; i < n; i++){
            for(int j=i+1; j < n; j++){
                List<Integer> arista = new ArrayList<>();
                if(ciudades[i][j] == NO_HAY_RUTA){
                    arista.add(i);
                    arista.add(j);
                    aristaVacias.add(arista);
                }
                
            }
        }
        System.out.println("Creando aristas ("+cuantas+") ...");
        //crear aristas
        for(int i=0; i < cuantas; i++){
            index = Util.randInt(0, aristaVacias.size()-1);
            fila = aristaVacias.get(index).get(0);
            columna = aristaVacias.get(index).get(1);
            ciudades[fila][columna] = Util.randInt(min, max);
            ciudades[columna][fila] = ciudades[fila][columna];
            aristaVacias.remove(index);
        }
    }
    
    public int getN() {
        return n;
    }

    public int getE() {
        return e;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int[][] getCiudades() {
        return ciudades;
    }
    
    public int getOrigen() {
        return origen;
    }
    
    public int getDestino() {
        return destino;
    }
    
    public double[] getH(){
        return this.h;
    }
    
}
