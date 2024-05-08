package tp2_1;

public class Vertice {
    private int info;
    private int tiempoD;
    private int tiempoF;
    private String color;

    public Vertice(int info) {
        this.info = info;
        this.tiempoD=0;
        this.color= "blanco";
    }

    public int getInfo() {
        return info;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setVertice(int info) {
        this.info = info;
    }

    public int getTiempoD() {
        return tiempoD;
    }

    public void setTiempoD(int tiempoD) {
        this.tiempoD = tiempoD;
    }

    public int getTiempoF() {
        return tiempoF;
    }

    public void setTiempoF(int tiempoF) {
        this.tiempoF = tiempoF;
    }

    @Override
    public String toString() {
        return "Vertice{" +
                "info=" + info +
                ", tiempoD=" + tiempoD +
                ", tiempoF=" + tiempoF +
                ", color='" + color + '\'' +
                '}';
    }
}
