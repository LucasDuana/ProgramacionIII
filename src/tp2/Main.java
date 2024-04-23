package tp2;

public class Main {
    public static void main(String [] args){
        System.out.println("NASHE");
    }

    public static boolean isOrdered(int[] array,int n){
        //Caso base, llego a la posicion inicial del arreglo
        if(n<=1){
            return true;
        }

        //Compruebo si el ultimo elemento es menor al anterior,se rompe
        if(array[n]< array[n-1])
            return false;

        //Llamo recursivamente para seguir comprobando
        return isOrdered(array,n-1);
    }
}
