
package py.una.ia.busquedas.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juan
 */
public class Grafo {
    private int [][] ciudades;
    private int n;
    private int e;
    private int min;
    private int max;
    public static final int NO_HAY_RUTA = 0;
    
    /**
     * 
     * @param n cantidad de ciudades
     * @param e porcentaje de aristas a eliminar
     * @param min distancia minima entre dos ciudades
     * @param max distancia maxima entre dos ciudades
     */
    public Grafo(int n, int e, int min, int max){
        this.ciudades = new int[n][n];
        this.n = n;
        this.e = e;
        this.min = min;
        this.max = max;
        generarMatrizVacia();
        generarGrafoConexo(min, max);
        engordarGrafo(min, max, e);
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
    
    /**
     * Un Grafo completo tiene n(n-1)/2
     */
    private void engordarGrafo(int min, int max, int e){
        boolean valido;
        int fila;
        int columna;
        if(e > 70){
            e = 70;
        }
        int totalAristas = n*(n-1)/2;
        int actualAristas = n-1;//el grafo conexo debe tener minimo n-1 aristas
        int cuantas = totalAristas - actualAristas - (int)(((float)totalAristas)/100*e);//(int)(((float)n*n)/100*e);
        for(int i=0; i < cuantas; i++){
            valido = false;
            while(!valido){
                fila = Util.randInt(min, max);
                columna = Util.randInt(min, max);
                if(ciudades[fila][columna] == NO_HAY_RUTA && fila != columna){
                    ciudades[fila][columna] = Util.randInt(min, max);
                    ciudades[columna][fila] = ciudades[fila][columna];
                    valido = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Grafo g = new Grafo(10, 60, 1, 9);
        int count = 0;
        System.out.println("hola!!");
        for(int fila=0; fila < g.getN(); fila++){
            for(int columna = 0; columna < g.getN(); columna++){
                System.out.print(g.getCiudades()[fila][columna]+" ");
                if(g.getCiudades()[fila][columna] == Grafo.NO_HAY_RUTA){
                    count = count + 1;
                }
            }
            System.out.println();
        }
        System.out.println(count);
    }

}
