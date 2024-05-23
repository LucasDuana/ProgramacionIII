package tp1;

import java.util.ArrayList;

public class Main {

    public static void main(String [] args){

        LinkedList<Integer> list=new LinkedList<>(4);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(5);


        System.out.println(list.toString());

        list.delete(1);

        System.out.println(list.toString());








    }


}
