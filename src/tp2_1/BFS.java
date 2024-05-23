package tp2_1;

import java.util.*;

public class BFS {/*

    public static List<Integer> bfs(GrafoDirigido<?> grafo,int nodoInicial){
        List<Integer> recorrido = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();

        cola.offer(nodoInicial); //agrega a la fila
        visitados.add(nodoInicial); //agrega a visitados

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            recorrido.add(actual);

            Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(actual);
            while (adyacentes.hasNext()) {
                int adyacente = adyacentes.next();
                if (!visitados.contains(adyacente)) { //chequea que no haya sido visitado
                    cola.offer(adyacente);
                    visitados.add(adyacente);
                }
            }
        }

        return recorrido;
    }
*/

    public static List<Integer> bfs(GrafoDirigido<?> grafo,int nodoInicial){
        Set<Integer> visitados = new HashSet<>();
        List<Integer> recorrido = new ArrayList<>();
        Queue<Integer> cola = new LinkedList<>();

        cola.offer(nodoInicial);
        visitados.add(nodoInicial);

        while (!cola.isEmpty()){
            int actual=cola.poll();
            recorrido.add(actual);

            Iterator<Integer> adyacentes=grafo.obtenerAdyacentes(actual);
            while(adyacentes.hasNext()){
                Integer adyacente=adyacentes.next();
                if(!visitados.contains(adyacente)){
                    visitados.add(adyacente);
                    cola.offer(adyacente);
                }
            }

        }

        return recorrido;
    }



}
