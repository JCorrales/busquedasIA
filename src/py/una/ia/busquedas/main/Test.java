/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.una.ia.busquedas.main;

import py.una.ia.busquedas.algoritmos.Aestrella;
import py.una.ia.busquedas.algoritmos.Avaro;
import py.una.ia.busquedas.algoritmos.CostoUniforme;
import py.una.ia.busquedas.domain.Grafo;
import py.una.ia.busquedas.domain.Nodo;

/**
 *
 * @author juan
 */
public class Test {
    
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        Grafo g = new Grafo(10, 50, 1, 3, 0, 4);
        int count = 0;
        for(int fila=0; fila < g.getN(); fila++){
            for(int columna = 0; columna < g.getN(); columna++){
                System.out.print(g.getCiudades()[fila][columna]+" ");
                if(g.getCiudades()[fila][columna] != Grafo.NO_HAY_RUTA){
                    count = count + 1;
                }
            }
            System.out.println();
        }
        System.out.println("Aristas: "+count/2);
        double mayorH = Integer.MIN_VALUE;
        double menorH = Integer.MAX_VALUE;
        for(int i=0; i<g.getH().length; i++){
            if(g.getH()[i]> mayorH){
                mayorH = g.getH()[i];
            }
            if(g.getH()[i]< menorH){
                menorH = g.getH()[i];
            }
        }
        System.out.println("h mayor: "+mayorH);
        System.out.println("h menor: "+menorH);
        Long end = System.currentTimeMillis();
        System.out.println("Tiempo en generar grafo: "+(end-start));
        System.out.println("************** Probando costo uniforme ****************");
        CostoUniforme costo = new CostoUniforme(g);
        costo.buscar();
        System.out.println("Expandidos: "+Nodo.getExpandidos());
        System.out.println("Tiempo: "+costo.getTiempo());
        System.out.println("Costo: "+costo.getSolucion().getCosto());
        Nodo camino = costo.getSolucion();
        System.out.println("--camino--");
        do{
            System.out.println(camino.getNombre()+" h: "+camino.getH()+ " costo: "+camino.getCosto()+" f: "+camino.getF());
            camino = camino.getPadre();
        }while(camino != null);
        
        
        System.out.println("************** Probando avaro ****************");
        Nodo.resetExpandidos();
        Avaro avaro = new Avaro(g, 10000L);
        avaro.buscar();
        System.out.println("Expandidos: "+Nodo.getExpandidos());
        System.out.println("Tiempo: "+avaro.getTiempo());
        System.out.println("Profundidad: "+avaro.getProfundidadMaxima());
        System.out.println("Costo: "+avaro.getSolucion().getCosto());
        Nodo camino2 = avaro.getSolucion();
        System.out.println("--camino--");
        do{
            System.out.println(camino2.getNombre()+" h: "+camino2.getH()+ " costo: "+camino2.getCosto()+" f: "+camino2.getF());
            camino2 = camino2.getPadre();
        }while(camino2 != null);
        
        System.out.println("************** Probando A* ****************");
        Nodo.resetExpandidos();
        Aestrella estrella = new Aestrella(g, 10000L);
        estrella.buscar();
        System.out.println("Expandidos: "+Nodo.getExpandidos());
        System.out.println("Tiempo: "+estrella.getTiempo());
        System.out.println("Profundidad: "+estrella.getProfundidadMaxima());
        System.out.println("Costo: "+estrella.getSolucion().getCosto());
        Nodo camino3 = estrella.getSolucion();
        System.out.println("--camino--");
        do{
            System.out.println(camino3.getNombre()+" h: "+camino3.getH()+ " costo: "+camino3.getCosto()+" f: "+camino3.getF());
            camino3 = camino3.getPadre();
        }while(camino3 != null);
        
    }
    
}
