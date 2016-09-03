
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
        System.out.println("visitados: "+visitados.size());
        System.out.println("heuristicas: "+heuristicas);
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
    
    private void crearHeuristica(int min, int padre){
        visitados.add(padre);
        for(int hijo=0; hijo < n; hijo++){
            if(ciudades[padre][hijo] != NO_HAY_RUTA){
                if(!visitados.contains(hijo)){
                    h[hijo] = h[padre] + ((float)Util.randInt(80, 100)/100*min);
                    System.out.println("padre:"+padre+": "+h[padre]+"hijo: "+hijo+": "+h[hijo]);
                    heuristicas++;
                    crearHeuristica(min, hijo);
                }
            }
        }
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
        List<Arista> aristaVacias = new ArrayList<>();
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
                Arista arista = new Arista();
                if(ciudades[i][j] == NO_HAY_RUTA){
                    arista.setFila(i);
                    arista.setColumnna(j);
                    aristaVacias.add(arista);
                }
            }
        }
        System.out.println("Creando aristas ("+cuantas+") ...");
        //crear aristas
        if(cuantas <= 250000){
            sobreVacias(aristaVacias, cuantas);
        }else{
            sobreSubListas(aristaVacias, cuantas);
        }
        System.out.println("Hecho");
    }
    
    private void sobreVacias(List<Arista> aristaVacias, int cuantas) {
        int fila;
        int columna;
        int index;
        for(int i=0; i < cuantas; i++){
            
            index = Util.randInt(0, aristaVacias.size()-1);
            fila = aristaVacias.get(index).getFila();
            columna = aristaVacias.get(index).getColumnna();
            ciudades[fila][columna] = Util.randInt(min, max);
            ciudades[columna][fila] = ciudades[fila][columna];
            aristaVacias.remove(index);
        }
    }
    
    private void sobreSubListas(List<Arista> aristaVacias, int cuantas) {
        int fila;
        int columna;
        int index;
        int subSize = 1000;
        int creadas = 0;
        int[] sizes;
        Arista arista = null;
        List<List<Arista>> hiperMatriz = new ArrayList<>();
        for(int i=0; i < aristaVacias.size();i += subSize){
            hiperMatriz.add(aristaVacias.subList(i, i+subSize >= aristaVacias.size() ? aristaVacias.size() : i+subSize));
        }
        sizes = new int[hiperMatriz.size()];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = subSize;
        }
        for(int i=0; i < cuantas; i++){
            index = Util.randInt(0, hiperMatriz.size()-1);
            List<Arista> sub = hiperMatriz.get(index);
            try{
                arista = sub.get(Util.randInt(0, sizes[i]-1));
                sizes[i]--;
                fila = arista.getFila();
                columna = arista.getColumnna();
                ciudades[fila][columna] = Util.randInt(min, max);
                ciudades[columna][fila] = ciudades[fila][columna];
            }catch(Exception ex){
                
            }
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
