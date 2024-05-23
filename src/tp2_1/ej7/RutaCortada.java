package tp2_1.ej7;

import tp2_1.GrafoDirigido;

import java.util.*;

public class RutaCortada {

    private GrafoDirigido<Integer> grafo;
    Set<Integer> visitados;
    List<Integer> recorrido;
    List<List<Integer>> recorridos;


    public RutaCortada(GrafoDirigido<Integer> grafo){
        this.grafo=grafo;
        this.visitados=new HashSet<>();
        this.recorridos=new ArrayList<>();
        this.recorrido=new ArrayList<>();
    }

    public void ruta(Integer origen,Integer destino,Integer ruta1,Integer ruta2){
        rutaRecorrido(origen,destino,ruta1,ruta2);
        System.out.println(recorridos);
    }

    private void rutaRecorrido(Integer actual,Integer destino,Integer ruta1,Integer ruta2){
        recorrido.add(actual);
        visitados.add(actual);
        if(actual == destino){
            recorridos.add(new ArrayList<>(recorrido));
        }else{
            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
            while(adyacentes.hasNext()){
                Integer adyacente=adyacentes.next();
                if(actual.equals(ruta1)){
                    if(!visitados.contains(adyacente) && !adyacente.equals(ruta2))
                        rutaRecorrido(adyacente,destino,ruta1,ruta2);
                }else
                    if(actual.equals(ruta2)){
                        if(!visitados.contains(adyacente) && !adyacente.equals(ruta1))
                            rutaRecorrido(adyacente,destino,ruta1,ruta2);
                    }
                    else{
                        if(!visitados.contains(adyacente)){
                            rutaRecorrido(adyacente,destino,ruta1,ruta2);
                        }
                    }
            }
        }
        visitados.remove(actual);
        recorrido.remove(actual);
    }

}
