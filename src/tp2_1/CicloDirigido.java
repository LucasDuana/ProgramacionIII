package tp2_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CicloDirigido {

    private GrafoDirigido<Integer> grafo;
    private ArrayList<Integer> visitados;
    private ArrayList<Integer> ciclo;

    public CicloDirigido(GrafoDirigido<Integer> grafo) {
        this.grafo = grafo;
        this.visitados=new ArrayList<>();
        this.ciclo=new ArrayList<>();
    }

    public List<Integer> encontrarCiclo() {
        Iterator<Integer> iteradorVertices = grafo.obtenerVertices();
        while (iteradorVertices.hasNext()) {
            Integer verticeId = iteradorVertices.next();
            if (!visitados.contains(verticeId)) {
                if (dfs(verticeId,new ArrayList<>())) {
                    return ciclo; // Devolver el ciclo encontrado
                }
            }
        }
        return null; // No se encontró ningún ciclo
    }

    private boolean dfs(Integer verticeId, List<Integer> caminoActual) {
        visitados.add(verticeId);
        caminoActual.add(verticeId);

        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeId);
        while (adyacentes.hasNext()) {
            Integer adyacenteId = adyacentes.next();
            if (!visitados.contains(adyacenteId)) {
                if (dfs(adyacenteId, caminoActual)) {
                    return true;
                }
            } else if (caminoActual.contains(adyacenteId)) {
                ciclo.addAll(caminoActual.subList(caminoActual.indexOf(adyacenteId), caminoActual.size()));
                ciclo.add(adyacenteId); // Agregar el vértice actual al ciclo
                return true;
            }
        }

        caminoActual.remove(verticeId);
        return false;
    }


}
