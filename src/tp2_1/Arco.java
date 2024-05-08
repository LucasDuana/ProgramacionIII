package tp2_1;

public class Arco<T>{

    private int verticeOrigen;
    private int verticeDestino;
    private T info;

    public Arco(int verticeOrigen, int verticeDestino, T info) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.info = info;
    }

    public int getVerticeOrigen() {
        return verticeOrigen;
    }

    public int getVerticeDestino() {
        return verticeDestino;
    }

    public T getInfo() {
        return info;
    }

}
