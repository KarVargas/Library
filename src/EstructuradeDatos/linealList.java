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
    private NodeL first; //Declaramos una variable privada "first" de tipo nodeClass, mismo nombre de la clase principal.
    private NodeL last; //Declaramos una variable privada "last" de tipo nodeClass, mismo nombre de la clase principal.
    
    //Métodos
    /**
     * Método para insertar un nodo al inicio de la lista.
     * @param n es de tipo generica y contiene la información importante que desea insertar.
     */
    public void insertFirst(T n){
        NodeL node = new NodeL(n); //Creamos nuestro nodo
        if(isEmpty()){ //Condicional para checar, Si la lista está vacía.
            first = node; //Inicializamos first con el nodo.
            last = node; //Inicializamos last con el nodo.
        } else { //Si la lista no está vacía.
            node.next = first; //Inicializamos el apuntador del nodo con first, ya que es el nuevo nodo de lo cual tiene que apuntar al primer nodo.
            first = node; //Inicializamos first con el nuevo nodo
        } //Fin de la condicional.
    }
    /**
     * Método para insertar un nodo al final de la lista.
     * @param n es de tipo generica y contiene la información importante que desea insertar.
     */
    public void insertLast(T n){
        NodeL node = new NodeL(n); //Creamos nuestro nodo
        if(isEmpty()){ //Condicional para checar, Si la lista está vacía.
            first = node; //Inicializamos first con el nodo.
            last = node; //Inicializamos last con el nodo.
        } else { //Si la lista no está vacía.
            NodeL prev; //Declaramos una variable "prev" de tipo nodeClass, mismo nombre de la clase principal.
            prev = last; //Inicializamos prev con last.
            prev.next = last = node; //Inicializamos el apuntador de prev con last y con el nuevo nodo.
            //last.next = null;
            //node.next = (nodeClass) last;
            //first = (T) node;
            //last = (T) node.next;
            //node.next = null;
            //last = node;
            //last = (T) node.next;
            //last = (T) node;
        }
    }
    /**
     * Método para eliminar el primer nodo.
     */
    public void deleteFirst(){
        first = first.next; //Inicializamos first con el apuntador de first, para que así first pase a su apuntador y olvide el nodo en el que se encontraba.
    }
    /**
     * Método para eliminar el ultimo nodo.
     */
    public void deleteLast(){
        NodeL node = first; //Declaramos una variable "node" de tipo nodeClass, mismo nombre de la clase principal. Inicializamos node con first.
        NodeL prev = null; //Declaramos una variable "prev" de tipo nodeClass, mismo nombre de la clase principal. Inicializamos prev a null.
        while(node.next!=null){ //Ciclo para verificar el apuntador de node es diferente de null.
            prev = node; //De ser asi el siguiente puntero es igual a node
            node = node.next;//Mientras que node es igua a node.next, de esta forma se va
            //verificando si lo que sigue del ultimo nodo es igual a null, se elimina
        }
        last = prev;
        prev.next = null;
    }
    
    public void deletel(){
        NodeL t = first;
        while(t.next.next!=null){
            t=t.next;
        }
        last = t;
        last.next=null;
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
            NodeL t;
            t = (NodeL) first;
            System.out.print("->");
            while(t!=null){
                System.out.print("["+t.data+"|]->");
                t=t.next;
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
        NodeL t, t2;
        if (isEmpty()){ //Si está vacío retorna falso.
            return false;
        } else { //Si contiene elementos.
            t = first; //Colocamos auxiliar al inicio de la lista.
            t2 = null;
            while (!data.equals(t.data) && t != null && t.data != data){ //Mientras que no encuentre el dato o no llegue al final de la lista, recorre la lista.
                t2 = t;
                t = t.next; //Recorre la lista.
            }
            if(t == null){return false;} // No lo encontro
            if(t == first){
                first = first.next;
                return true;
            } else {
                t2.next=t.next;
                return true;
            }
        }
    }
}
