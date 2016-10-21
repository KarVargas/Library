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
public class stackList <T> {
    //Attribures
    private Node top;
    private int size;
    
    //Methods
    //Constructor
    public stackList() {
        this.top = null;
        this.size = 0;
    }
    //Getters
    /**
     * 
     * @return stack's top
     */
    public Node getTop(){
        return this.top;
    }
    /**
     * 
     * @return stack's size
     */
    public int getSize(){
        return this.size;
    }
    //Setters
    public void setTop(Node top) {
        this.top = top;
    }
    public void setSize(int size) {
        this.size = size;
    }    
    public boolean isEmpty(){
        return this.top == null;
    }
    /**
     * Introduce un nuevo elemento a la pila.
     * @param data node's info
     */
    public void push (T data) {
        Node node = new Node (data);
        if (isEmpty()) { //Si la pila está vacía.
            setTop(node);
                //top = node;
        } else { //Si la pila no está vacía.
            node.setNext(top);
            setTop(node);
                //top = node;
        } ++size;
    }
    /**
     * Elimina un elemento de la pila.
     */
    public void pop() {
        if (!isEmpty()) {
            setTop(top.getNext());
                //top = top.getNext();
            --size;
        } else { 
            System.out.println("La pila está vacía");
        }
    }
    /**
     * Vacía los elementos de la pila.
     */
    public void empty(){
        setTop(null);
            //top = null;
        setSize(0);
            //size = 0;
    }
    
    public void showStack() {
        if (!isEmpty()){
            Node t = top;
            do {
                System.out.println(t.getData());
                System.out.println("|");
                System.out.println("V");
                t = t.getNext();
            } while(t != null);
            System.out.println("☠");
        }
    }
}
