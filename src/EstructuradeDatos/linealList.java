/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuradeDatos;

/**
 *
 * @author CarlosManuel
 */
public class linealList <T> {
    //Attributes
    private Node first; //Declaramos una variable privada "first" de tipo nodeClass, mismo nombre de la clase principal.
    private Node last; //Declaramos una variable privada "last" de tipo nodeClass, mismo nombre de la clase principal.
    //Métodos
    //Getters
    public Node getFirst() {
        return first;
    }
    public Node getLast() {
        return last;
    }
    //Setters
    public void setFirst(Node first) {
        this.first = first;
    }
    public void setLast(Node last) {
        this.last = last;
    }
    /**
     * Método para insertar un nodo al inicio de la lista.
     * @param n es de tipo generica y contiene la información importante que desea insertar.
     */
    public void insertFirst(T n){
        Node node = new Node(n); //Creamos nuestro nodo
        //node.setData(n);
        if(isEmpty()){ //Condicional para checar, Si la lista está vacía.
            setFirst(node); 
                //first = node; //Inicializamos first con el nodo.
            setLast(node); 
                //last = node; //Inicializamos last con el nodo.
        } else { //Si la lista no está vacía.
            node.setNext(first); 
                //node.next = first; //Inicializamos el apuntador del nodo con first, ya que es el nuevo nodo de lo cual tiene que apuntar al primer nodo.
            setFirst(node);
                //first = node; //Inicializamos first con el nuevo nodo
        } //Fin de la condicional.
    }
    /**
     * Método para insertar un nodo al final de la lista.
     * @param n es de tipo generica y contiene la información importante que desea insertar.
     */
    public void insertLast(T n){
        Node node = new Node(n); //Creamos nuestro nodo
        //node.setData(n);
        if(isEmpty()){ //Condicional para checar, Si la lista está vacía.
            setFirst(node);
                //first = node; //Inicializamos first con el nodo.
            setLast(node);
                //last = node; //Inicializamos last con el nodo.
        } else { //Si la lista no está vacía.
            getLast().setNext(node);
                //last.setNext(node); 
                //last.next = node; //Inicializamos prev con last.
            setLast(node); 
                //last = node; //Inicializamos el apuntador de last con el nuevo nodo.
            /*NodeL prev; //Declaramos una variable "prev" de tipo nodeClass, mismo nombre de la clase principal.
            prev = last; //Inicializamos prev con last.
            prev.next = last = node; //Inicializamos el apuntador de prev con last y con el nuevo nodo.
            
            /*last.next = null;
            node.next = (nodeClass) last;
            first = (T) node;
            last = (T) node.next;
            node.next = null;
            last = node;
            last = (T) node.next;
            last = (T) node;*/
        }
    }
    /**
     * Método para eliminar el primer nodo.
     */
    public void deleteFirst(){
         setFirst(first.getNext());
            //first = first.getNext();
            //first = first.next; //Inicializamos first con el apuntador de first, para que así first pase a su apuntador y olvide el nodo en el que se encontraba.
    }
    /**
     * Método para eliminar el ultimo nodo.
     */
    public void deletel(){
        Node node = first; //Declaramos una variable "node" de tipo nodeClass, mismo nombre de la clase principal. Inicializamos node con first.
        Node prev = null; //Declaramos una variable "prev" de tipo nodeClass, mismo nombre de la clase principal. Inicializamos prev a null.
        while(node.next != null) { //Ciclo para verificar el apuntador de node es diferente de null.
            prev = node; //De ser asi el siguiente puntero es igual a node
            node = node.next;//Mientras que node es igua a node.next, de esta forma se va
            //verificando si lo que sigue del ultimo nodo es igual a null, se elimina
        }
        setLast(prev);
            //last = prev;
        prev.setNext(null);
            //prev.next = null;
    }
    
    public void deleteLast(){
        Node t = first;
        while (t.getNext().getNext() != null) {
            //while(t.next.next!=null){
            t = t.getNext();
                //t = t.next;
        }
        setLast(t);
            //last = t;
        getLast().setNext(null);
            //last.setNext(null); 
            //last.next=null;
        /*t.setNext(null);
        last=t;*/
    }
    /**
     * 
     * @return 
     */
    private boolean isEmpty(){
        return first == null;
    }
    /**
     * 
     */
    public void showList(){
        if (!isEmpty()){
            Node t;
            t = first;
            System.out.print("->");
            while (t != null) {
                System.out.print("["+t.getData()+"|]->");
                    //System.out.print("["+t.data+"|]->");
                t = t.getNext();
                    //t=t.next;
            }
            System.out.println("☠");
        } else {
            System.out.println("La lista está vacía");
        }
    }
    /**
     * 
     * @param data
     * @return 
     */
    public boolean eNode(T data){
        if (isEmpty()){ //Si está vacío retorna falso.
            System.out.println("La lista está vacía.");
            return false;
        } else { //Si contiene elementos.
            Node t, t2;
            t = first; //Colocamos auxiliar al inicio de la lista.
            t2 = null;
            if(getFirst().getData().equals(data)){
                //(first.getData().equals(data)){
                deleteFirst();
                return true;
            } else if(getLast().getData().equals(data)){
                //(last.getData().equals(data)){
                deleteLast();
                return true;
            } else {
                while (t.getNext() != null && t.getNext().getData() != data && !data.equals(t.getNext().getData())/*!data.equals(t.data) && t != null && t.data != data*/) { //Mientras que no encuentre el dato o no llegue al final de la lista, recorre la lista.
                    //t2 = t;
                    t = t.getNext(); 
                        //t = t.next; //Recorre la lista.
                }
                if (t.getNext()!=null && t.getNext().getData().equals(data)) {
                    t.setNext(t.getNext().getNext());
                    return true;
                }
                System.out.println("No se encontró en la lista.");
                return false;
                //if (t == null) { return false; } // No lo encontro
                /*if(t == first){
                first = first.next;
                return true;}*/
                /*else {
                    //t2.next=t.next;
                    return false;
                }*/
            }
        }
    }
}
