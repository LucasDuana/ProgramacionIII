package tp2_1;

import java.util.*;

public class GrafoNoDirigido<T> implements Grafo<T> {

    private Map<Integer, ArrayList<Arco<T>>> vertices;

    public GrafoNoDirigido() {
        this.vertices = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if(!vertices.containsKey(verticeId)){
            vertices.put(verticeId,new ArrayList<>());
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        if(vertices.containsKey(verticeId)){
            vertices.remove(verticeId);
            for(ArrayList<Arco<T>> arcos: vertices.values()){
                arcos.removeIf(arco -> arco.getVerticeOrigen()== verticeId || arco.getVerticeDestino()==verticeId);
            }
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        if((vertices.containsKey(verticeId1)) && (vertices.containsKey(verticeId2))){
            Arco<T> arco1 = new Arco<>(verticeId1,verticeId2,etiqueta);
            Arco<T> arco2 = new Arco<>(verticeId2,verticeId1,etiqueta);
            vertices.get(verticeId1).add(arco1);
            vertices.get(verticeId2).add(arco2);
        }
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        if (vertices.containsKey(verticeId1)) {
            Iterator<Arco<T>> iterator = vertices.get(verticeId1).iterator();
            while (iterator.hasNext()) {
                Arco<T> arco = iterator.next();
                if (arco.getVerticeDestino() == verticeId2 && vertices.containsKey(arco.getVerticeDestino())) {
                    iterator.remove();
                    vertices.get(arco.getVerticeDestino()).removeIf(a -> a.getVerticeDestino() == verticeId1);
                    break;
                }
            }
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
                if(arco.getVerticeDestino()==verticeId2)
                    return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        if(vertices.containsKey(verticeId1)) {
            for (Arco<T> arco : vertices.get(verticeId1)) {
                if (arco.getVerticeDestino() == verticeId2) {
                    return arco;
                }
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
        int cant=0;
        for (ArrayList<Arco<T>> arcos: vertices.values()){
            cant+=arcos.size();
        }
        return cant/2;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return vertices.keySet().iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        if(vertices.containsKey(verticeId)){
            List<Integer> adyacentes = new ArrayList<>();
            for(Arco<T> arco: vertices.get(verticeId)){
                adyacentes.add(arco.getVerticeDestino());
            }
            return adyacentes.iterator();
        }
        return Collections.emptyIterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        List<Arco<T>> arcos=new ArrayList<>();
        for(ArrayList<Arco<T>> arcosList : vertices.values()){
            arcos.addAll(arcosList);
        }
        return arcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        if(vertices.containsKey(verticeId)){
            List<Arco<T>> arcos = new ArrayList<>();
            for(Arco<T> arco:vertices.get(verticeId)){
                arcos.add(arco);
                arcos.add(new Arco<>(arco.getVerticeDestino(),arco.getVerticeOrigen(),arco.getInfo()));
            }
            return arcos.iterator();
        }
        return Collections.emptyIterator();
    }
}
