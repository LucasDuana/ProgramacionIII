package tp2_1.ej7;

import tp2_1.GrafoDirigido;

public class Main {

    public static void main(String [ ] args){
        GrafoDirigido<Integer> grafito=new GrafoDirigido<>();

        grafito.agregarVertice(1);
        grafito.agregarVertice(2);
        grafito.agregarVertice(3);
        grafito.agregarVertice(4);
        grafito.agregarVertice(5);

        grafito.agregarArco(1,2,0);
        grafito.agregarArco(2,3,0);
        grafito.agregarArco(2,4,0);
        grafito.agregarArco(4,3,0);
        grafito.agregarArco(4,5,0);
        grafito.agregarArco(3,5,0);



        RutaCortada ruta=new RutaCortada(grafito);



        ruta.ruta(1,5,4,3);


    }


}
