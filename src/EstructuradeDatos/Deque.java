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
public class Deque <T>{    
    //Attributes
    private NodeD first;
    private NodeD last;
    private int size;
    
    //Constructor
    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }    
    /**
     * Este método inserta un nodo al inicio de la lista.
     * @param data es de tipo genérico y contiene la información importante.
     */
    public void insertFirst(T data){        
        NodeD node = new NodeD (data); //Creamos nuestro nodo.
        if (isEmpty()) { //SI la lista esta vacía.
            this.first = node;
            this.last = node;
            ++size;
        } else { //Si la lista tiene elementos.
            node.setNext(first); //El apuntador "SIGUIENTE" del nuevo nodo, apunta al primer nodo de la lista.
            first.setPrev(node); //El apuntador "ANTERIOR" del primer nodo de la lista apunta al nuevo nodo.
            first = node; //El apuntador first (que es atributo de la lista) es igual al nodo creado.
            ++size;
        } 
    }
    
    /**
     * Metodo en donde insertaremos un nodo en la ultima posición.
     * @param data 
     */
    public void insertLast(T data){        
        NodeD node = new NodeD (data); //Creamos nuestro nodo.
        
        if (isEmpty()) { //SI la lista esta vacía.
            this.first = node;
            this.last = node;
            ++size;
        } else { //Si la lista tiene elementos.
            node.setPrev(last); //El apuntador "ANTERIOR" del nuevo nodo, apunta al ultimo nodo de la lista.
            last.setNext(node); //El apuntador "SIGUIENTE" del ultimo nodo de la lista apunta al nuevo nodo.
            last = node; //El apuntador last (que es atributo de la lista) es igual al nodo creado.
            ++size;
        } 
    }
    /**
     * Método para mostrar la lista.
     */
    public void showList () {
        if (!isEmpty()) { //Si la lista no está vacía.
            NodeD t; //Declaramos nodo temporal.
            t = first; //Donde nodo será igual a first (al inicio).
            System.out.print("☠<=>"); //Imprime comentario.
            while(t != null){ //Mientras el nodo sea diferente a null, recorrera la lista. Una vez sea null, se sale del ciclo.
                System.out.print("[|" + t.getData() + "|]<=>");
                    //System.out.print("[|"+t.data+"|]<=>"); //Imprime comentario, mientras imprime la información del nodo.
                t = t.getNext();
                    //t = t.next; //El nodo será igual a su apuntador "SIGUIENTE", para así recorrer toda la lista.
            } //Fin del ciclo.
            System.out.println("☠"); //Imprime comentario.
        } else { //En caso de que la lista este vacía.
            System.out.println("La lista está vacía"); //Imprime comentario.
        } //Fin de la condición.
    }    
    public void eNodeFirst(){        
        first = first.getNext(); //Movemos al apuntador first al siguiente nodo y el previo de este lo ponemos el null.
        first.setPrev(null);
            //first.prev = null;
        --size; //Se le resta size en 1 ya que quitamos un nodo de la lista.
    }    
    public void eNodeLast(){                
        last = last.getPrev();
            //last = last.prev; //Movemos al apuntador last al nodo anteriory el next de este ultimo.
        last.setNext(null);
        --size; //Se le resta size en 1 ya que quitamos un nodo de la lista.
    }    
    public Object getFirst() {
        return first.getData();
    }    
    public Object getLast(){
        return last.getData();
    }    
    public boolean isEmpty(){
        return first == null && last == null && size == 0;
    }    
    public void eList(){
        first = null;
        last = null;
        size = 0;
    }    
    public int getSize(){
        return size;
    }
    public void setFirst(NodeD first) {
        this.first = first;
    }
    public void setLast(NodeD last) {
        this.last = last;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
