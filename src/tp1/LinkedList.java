package tp1;

import com.sun.source.tree.LiteralTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {

    Node<T> first;
    int size;

    public LinkedList(T info) {
        this.first=new Node<>(info);
    }

    public LinkedList() {
    }

    public void insertFront(T info){
        Node<T> element = new Node<>(info);
        element.setNext(this.first);
        this.first = element;
        size++;
    }

    public void add(T info){
        Node<T> current=this.first;
        while(current.getNext()!=null){
            current=current.getNext();
        }
        current.setNext(new Node<T>(info));
        size++;
    }

    public T extractFront(){
        T info = this.first.getInfo();
        this.first=this.first.getNext();
        size--;
        return info;
    }

    public boolean isEmpty(){
        return this.first==null;
    }

    public int getindex(T info){
        if (this.first!=null){
            int index = 0;
            Node<T> cursor= this.first;
            while((cursor!=null) && (!cursor.getInfo().equals(info))){
                index++;
                cursor=cursor.getNext();
            }
            if(cursor!=null)
                return index;
            else
                return -1;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.getInfo());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public void delete(int pos) {
        if (pos >= 0 && pos < size) { // Verificar si la posición es válida
            if (pos == 0) { // Si se quiere eliminar el primer elemento
                this.first = this.first.getNext();
            } else {
                int p = 0;
                Node<T> current = this.first;
                while (p != pos - 1) { // Avanzar hasta el nodo anterior al que se desea eliminar
                    current = current.getNext();
                    p++;
                }
                // Enlazar el nodo anterior directamente con el siguiente nodo después del que se va a eliminar
                current.setNext(current.getNext().getNext());
            }
            size--; // Reducir el tamaño de la lista después de eliminar el nodo
        } else {
            System.out.println("Posición inválida para eliminar");
        }
    }


    public void printWithIterator(){
        Iterator<T> iterator= new LinkedListIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()+ " ->");
        }
    }



    public Iterator<T> iterator(){
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current;

        public LinkedListIterator(){
            current=first;
        }

        @Override
        public boolean hasNext(){
            return current!=null;
        }
        @Override
        public T next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T info = current.getInfo();
            current=current.getNext();
            return info;
        }


    }




}
