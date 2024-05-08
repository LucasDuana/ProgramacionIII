package tp2_1;

import java.util.*;

public class GrafoDirigido<T> implements Grafo<T>{

    private Map<Integer, ArrayList<Arco<T>>> vertices;

    public GrafoDirigido() {
        this.vertices=new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        //check if the vertex exists
        if(!vertices.containsKey(verticeId)){
            vertices.put(verticeId,new ArrayList<>());
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if(vertices.containsKey(verticeId)){
            vertices.remove(verticeId);
            for(ArrayList<Arco<T>> arcos: vertices.values()){
                arcos.removeIf(arco -> arco.getVerticeOrigen() == verticeId || arco.getVerticeDestino() == verticeId);
            }
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if(vertices.containsKey(verticeId1) && vertices.containsKey(verticeId2)){
            Arco<T> arco= new Arco<>(verticeId1,verticeId2,etiqueta);
            vertices.get(verticeId1).add(arco);
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if(vertices.containsKey(verticeId1)){
            vertices.get(verticeId1).removeIf(arco-> arco.getVerticeDestino() == verticeId2);
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return vertices.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        if(vertices.containsKey(verticeId1)){
            for(Arco<T> arco : vertices.get(verticeId1)){
                if(arco.getVerticeDestino() == verticeId2)
                    return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if(vertices.containsKey(verticeId1)){
            for(Arco<T> arco:vertices.get(verticeId1)){
                if (arco.getVerticeDestino()==verticeId2)
                    return arco;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return vertices.size();
    }

    @Override
    public int cantidadArcos() {
        int count=0;
        for(ArrayList<Arco<T>> arcos: vertices.values()){
            count += arcos.size();
        }

        return count;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if(vertices.containsKey(verticeId)){
            List<Integer> adyacentes = new ArrayList<>();
            for(Arco<T> arco: vertices.get(verticeId)){ //for each por cada arco en la lista de adyacencia
                adyacentes.add(arco.getVerticeDestino());
            }
            return adyacentes.iterator(); //iterador de una lista deintegers
        }
        return Collections.emptyIterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        List<Arco<T>> arcos = new ArrayList<>();
        for(ArrayList<Arco<T>> arcsList : vertices.values()){
            arcos.addAll(arcsList);
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if(vertices.containsKey(verticeId)){
            return vertices.get(verticeId).iterator();
        }
        return Collections.emptyIterator();
    }
}
