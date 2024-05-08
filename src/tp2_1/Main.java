package tp2_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;


public class Main {

    public static void main(String[] args) {

/*
        GrafoDirigido<String> graph = new GrafoDirigido<>();

        // Add vertices
        graph.agregarVertice(0);
        graph.agregarVertice(1);
        graph.agregarVertice(2);
        graph.agregarVertice(3);

        // Add arcs
        graph.agregarArco(0, 1, "A");
        graph.agregarArco(0, 2, "B");
        graph.agregarArco(1, 3, "C");
        graph.agregarArco(2, 3, "D");

        // Check vertices and arcs count
        System.out.println("Number of vertices: " + graph.cantidadVertices());
        System.out.println("Number of arcs: " + graph.cantidadArcos() + "\n");

        // Check vertices and adyacents
        Iterator<Integer> verticesIterator = graph.obtenerVertices();
        while (verticesIterator.hasNext()) {
            int vertex = verticesIterator.next();
            System.out.println("Vertex " + vertex + " adyacents:");
            Iterator<Integer> adyacentsIterator = graph.obtenerAdyacentes(vertex);
            while (adyacentsIterator.hasNext()) {
                System.out.print(" " + adyacentsIterator.next());
            }
            System.out.println();
        }
        System.out.println();

        // Check arcs
        Iterator<Arco<String>> arcosIterator = graph.obtenerArcos();
        while (arcosIterator.hasNext()) {
            Arco<String> arc = arcosIterator.next();
            System.out.println("Arc from vertex " + arc.getVerticeOrigen() + " to vertex " + arc.getVerticeDestino() + " with label " + arc.getInfo());
        }
        System.out.println();

        // Check arc existence
        System.out.println("Arc from vertex 0 to vertex 1 exists: " + graph.existeArco(0, 1));
        System.out.println("Arc from vertex 1 to vertex 0 exists: " + graph.existeArco(1, 0) + "\n");

        // Remove an arc
        graph.borrarArco(0, 1);

        // Check arc existence after removal
        System.out.println("Arc from vertex 0 to vertex 1 exists: " + graph.existeArco(0, 1));
        System.out.println("Arc from vertex 1 to vertex 0 exists: " + graph.existeArco(1, 0) + "\n");

        // Remove a vertex
        graph.borrarVertice(1);

        // Check vertices and arcs count after removal
        System.out.println("Number of vertices after removal: " + graph.cantidadVertices());
        System.out.println("Number of arcs after removal: " + graph.cantidadArcos());

        GrafoNoDirigido<String> graph2 = new GrafoNoDirigido<>();

        // Add vertices
        graph2.agregarVertice(0);
        graph2.agregarVertice(1);
        graph2.agregarVertice(2);
        graph2.agregarVertice(3);

        // Add edges
        graph2.agregarArco(0, 1, "A");
        graph2.agregarArco(0, 2, "B");
        graph2.agregarArco(1, 3, "C");
        graph2.agregarArco(2, 3, "D");

        // Check vertices and adyacents
        Iterator<Integer> verticesIterator2 = graph2.obtenerVertices();
        while (verticesIterator2.hasNext()) {
            int vertex = verticesIterator2.next();
            System.out.println("Vertex " + vertex + " adyacents:");
            Iterator<Integer> adyacentsIterator = graph2.obtenerAdyacentes(vertex);
            while (adyacentsIterator.hasNext()) {
                System.out.print(" " + adyacentsIterator.next());
            }
            System.out.println();
        }
        System.out.println();

        // Check edges
        Iterator<Arco<String>> edgesIterator = graph2.obtenerArcos();
        while (edgesIterator.hasNext()) {
            Arco<String> edge = edgesIterator.next();
            System.out.println("Edge from vertex " + edge.getVerticeOrigen() + " to vertex " + edge.getVerticeDestino() + " with label " + edge.getInfo());
        }
        System.out.println();

        // Check edge existence
        System.out.println("Edge from vertex 0 to vertex 1 exists: " + graph2.existeArco(0, 1));
        System.out.println("Edge from vertex 1 to vertex 0 exists: " + graph2.existeArco(1, 0) + "\n");

        // Remove an edge
        graph2.borrarArco(0, 1);

        // Check edge existence after removal
        System.out.println("Edge from vertex 0 to vertex 1 exists: " + graph2.existeArco(0, 1));
        System.out.println("Edge from vertex 1 to vertex 0 exists: " + graph2.existeArco(1, 0) + "\n");

        // Remove a vertex
        graph2.borrarVertice(1);

        // Check vertices and edges count after removal
        System.out.println("Number of vertices after removal: " + graph2.cantidadVertices());
        System.out.println("Number of edges after removal: " + graph2.cantidadArcos());


        GrafoDirigido grafo = new GrafoDirigido<>();

        grafo.agregarVertice(19);
        grafo.agregarVertice(4);
        grafo.agregarVertice(11);
        grafo.agregarVertice(25);
        grafo.agregarVertice(44);
        grafo.agregarVertice(7);
        grafo.agregarVertice(0);
        grafo.agregarVertice(94);

        grafo.agregarArco(19, 4, "");
        grafo.agregarArco(19, 44, "");
        grafo.agregarArco(19, 25, "");
        grafo.agregarArco(4, 11, "");
        grafo.agregarArco(4, 44, "");
        grafo.agregarArco(11, 19, "");
        grafo.agregarArco(44, 11, "");
        grafo.agregarArco(25, 44, "");
        grafo.agregarArco(25, 7, "");
        grafo.agregarArco(7, 44, "");
        grafo.agregarArco(0, 25, "");
        grafo.agregarArco(0, 7, "");
        grafo.agregarArco(0, 94, "");
        grafo.agregarArco(94, 44, "");

        // Realizar un recorrido DFS en el grafo
        DFS dfs = new DFS(grafo);
        dfs.recorridoDFS();

        dfs.imprimirTiempos();
*/

        // Crear un grafo dirigido
        GrafoDirigido<Integer> grafo = new GrafoDirigido<>();
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarArco(1, 2, 0); // Agregar arcos para formar un ciclo
        grafo.agregarArco(2, 3, 0);
        grafo.agregarArco(3, 4, 0);
        grafo.agregarArco(4, 1, 0);

        // Crear un objeto CicloEnGrafoDirigido y encontrar un ciclo en el grafo
        CicloDirigido detectorCiclo = new CicloDirigido(grafo);
        List<Integer> ciclo = detectorCiclo.encontrarCiclo();

        // Imprimir el ciclo encontrado
        if (ciclo != null) {
            System.out.println("Se encontró un ciclo en el grafo:");
            for (Integer vertice : ciclo) {
                System.out.print(vertice + " ");
            }
            System.out.println();
        } else {
            System.out.println("No se encontró ningún ciclo en el grafo.");
        }




    }

}
