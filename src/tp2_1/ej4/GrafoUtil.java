package tp2_1.ej4;

import tp2_1.Grafo;

import java.util.*;
/*EJERCICIO 4*/
public class GrafoUtil {

    private Grafo<Integer> grafo;
    private int origen,destino;

    public GrafoUtil(Grafo<Integer> grafo, int origen, int destino) {
        this.grafo = grafo;
        this.origen = origen;
        this.destino = destino;


    }

    public List<Integer> caminoLargo(){
        List<List<Integer>> caminos=new ArrayList<>();
        List<Integer> caminoActual=new ArrayList<>();
        Set<Integer> visitados= new HashSet<>();

        int longitudMax=0;
        List<Integer> caminoMasLargo=null;

        dfs(origen,destino,caminos,caminoActual,visitados);

        for(List<Integer> lista:caminos){
            if(longitudMax<lista.size()){
                caminoMasLargo=lista;
                longitudMax=lista.size();
            }
        }
    return caminoMasLargo;

    }

    private void dfs(Integer actual,Integer destino,List<List<Integer>> caminos,List<Integer> caminoActual,Set<Integer> visitados){
        visitados.add(actual);
        caminoActual.add(actual);

        if(actual==destino){
            caminos.add(new ArrayList<>(caminoActual));
        }else{
            Iterator<Integer> it = grafo.obtenerAdyacentes(actual);
            while (it.hasNext()){
                Integer vNuevo = it.next();
                if (!visitados.contains(vNuevo)){
                    dfs(vNuevo,destino,caminos,caminoActual,visitados);
                }
            }

            visitados.remove(actual);
            caminoActual.remove(caminoActual.size()-1);

        }

    }







}
