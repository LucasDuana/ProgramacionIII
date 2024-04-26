package tp2;

public class Main {
    public static void main(String [] args){
        /*int numeroDecimal = 26; // Ejemplo de número decimal
        String binario = decimalToBinary(numeroDecimal);
        System.out.println("El número " + numeroDecimal + " en notación binaria es: " + binario);

        int[] arreglo = {-3, -1, 0, 2, 4, 6, 10}; // Ejemplo de un arreglo ordenado
        boolean finded = samePosition(arreglo, 0, arreglo.length - 1);

        if(finded) {
            System.out.println("Se encontró al menos un elemento igual a su posición en el arreglo.");
        } else {
            System.out.println("No se encontró ningún elemento igual a su posición en el arreglo.");
        }*/

        // TODO Auto-generated method stub
        int arr[]= {2,9,8,3,6,4,10,7};
        int[] so=mergesort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.print(so[i]+" ");


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

    public static int binarySearch(int[] array,int start,int end,int element){
        //base case, not found
        if(start>end){
            return -1;
        }
        int middle = (start+end)/2;
        if(array[middle]==element)
            return middle;
        else if(array[middle]>element) //if the element in the array is greater we search from the left
            return binarySearch(array,start,middle-1,element);
        else return binarySearch(array,middle+1,end,element);//else from the right
    }

    // Método recursivo para convertir un número decimal a binario
    public static String decimalToBinary(int decimal) {
        // Caso base: si el número es 0, su representación binaria también es 0
        if (decimal == 0) {
            return "0";
        }
        // Caso base: si el número es 1, su representación binaria también es 1
        if (decimal == 1) {
            return "1";
        }
        // Recursivamente dividimos el número por 2 y concatenamos el resultado
        // con el residuo (que será el bit menos significativo)
        return decimalToBinary(decimal / 2) + decimal % 2;
    }

    // Método recursivo para generar los primeros N términos de la secuencia de Fibonacci
    public static void fibonacci(int n, int a, int b) {
        // Caso base: si n es igual a 0, no hay términos que mostrar
        if (n == 0) {
            return;
        }
        // Imprimir el término actual de la secuencia
        System.out.print(a + " ");
        // Llamada recursiva para generar el siguiente término de la secuencia
        fibonacci(n - 1, b, a + b);
    }

    public static boolean samePosition(int[] arr,int start , int end){
        if(start>end){
            return false;
        }
        int middle = (start+end)/2;

        if(arr[middle]==middle){
            return true;
        }else if(arr[middle]>middle)
                return samePosition(arr,start,middle-1);
        else return (samePosition(arr,middle+1,end));
    }

    public static void selectionSort(int[] arr){
        int size = arr.length;
        for (int i=0;i<size-1;i++){
            int minIndex=i;
            for(int j=i+1;j<size;j++){
                if(arr[j]<arr[minIndex])
                    minIndex=j;
            }
            //Change the values
            int temp= arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
    }

    public static void bubbleSort(int [] arr){
        int n = arr.length;
        int temp=0;
        for(int i=0;i<n;i++){
            for(int p=1;p<(n-i);p++){
                if(arr[p-1]>arr[p]){
                    temp=arr[p];
                    arr[p]=arr[p-1];
                    arr[p-1]=temp;
                }
            }
        }
    }

    public static int[] mergesort(int[] arr,int lo,int hi) {

        if(lo==hi) {
            int[] ba=new int[1];
            ba[0]=arr[lo];
            return ba;
        }

        int mid=(lo+hi)/2;
        int arr1[]=mergesort(arr,lo,mid);
        int arr2[]=mergesort(arr,mid+1,hi);
        return merge(arr1,arr2);
    }

    public static int[] merge(int[] arr1,int[] arr2) {
        int i=0,j=0,k=0;
        int n=arr1.length;
        int m=arr2.length;
        int[] arr3=new int[m+n];
        while(i<n && j<m) {
            if(arr1[i]<arr2[j]) {
                arr3[k]=arr1[i];
                i++;
            }
            else {
                arr3[k]=arr2[j];
                j++;
            }
            k++;
        }

        while(i<n) {
            arr3[k]=arr1[i];
            i++;
            k++;
        }

        while(j<m) {
            arr3[k]=arr2[j];
            j++;
            k++;
        }

        return arr3;

    }

    // Método para realizar el particionado del arreglo
    public static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (arr[j] < pivote) {
                i++;
                // Intercambiar arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiar arr[i+1] y arr[fin] (pivote)
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1;
    }

    // Método recursivo para realizar el ordenamiento Quicksort
    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            // Obtener el índice del pivote
            int indicePivote = particion(arr, inicio, fin);

            // Ordenar los elementos antes y después del pivote
            quickSort(arr, inicio, indicePivote - 1);
            quickSort(arr, indicePivote + 1, fin);
        }
    }



}
