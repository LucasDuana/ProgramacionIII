package tp2_1;

import java.util.*;

public class DFS {

    private GrafoDirigido<Integer> grafito;
    private int tiempo;
    private Map<Integer,Vertice> vertices;


    public DFS(GrafoDirigido<Integer> grafito) {
        this.grafito = grafito;
        this.tiempo=0;
        this.vertices=new LinkedHashMap<>();

        Iterator<Integer> it = this.grafito.obtenerVertices();
        while(it.hasNext()){
            int data= it.next();
            vertices.put(data,new Vertice(data));
        }


    }


    public void recorridoDFS(){
        for(Vertice v : vertices.values()){
            if (v.getColor().equals("blanco")){
                this.dfs_visita(v);
            }
        }
    }

    public Map<Integer, Vertice> getVertices() {
        return vertices;
    }

    public void dfs_visita(Vertice v){
        v.setColor("amarillo");
        this.tiempo++;
        v.setTiempoD(tiempo);
        Iterator<Integer> it=this.grafito.obtenerAdyacentes(v.getInfo());
        while(it.hasNext()){
            int info=it.next();
            Vertice adyacente = vertices.get(info);
            if(adyacente.getColor() == "blanco"){
                dfs_visita(adyacente);
            }
        }
        this.tiempo++;
        v.setTiempoF(this.tiempo);
        v.setColor("negro");
    }

    public void imprimirTiempos() {
        System.out.println("Tiempo de descubrimiento y finalización de cada vértice:");
        for (Vertice v : vertices.values()) {
            System.out.println("Vértice " + v.getInfo() + ": D[" + v.getTiempoD() + "], F[" + v.getTiempoF() + "]");
        }
    }

}
