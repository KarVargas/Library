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
public class queueList <T> {
    //Attributes
    private Node first;
    private Node last;
    private int size;

    //Constructor
    public queueList() {
        this.first = first;
        this.last = last;
        this.size = 0;
    }
    public queueList(T data) {
        insertLast(data);
    }
    //Getters
    public Object getFirst() {
        return this.first.getData();
    }
    public Node getLast() {
        return this.last;
    }
    public int getSize() {
        return this.size;
    }
    //Setters
    public void setFirst(Node first) {
        this.first = first;
    }
    public void setLast(Node last) {
        this.last = last;
    }
    public void setSize(int size) {
        this.size = size;
    }
    //Methods
    public void insertLast(T data) {
        Node node = new Node(data);
        if(isEmpty()) {
            this.first = node;
            this.last = node;
        } else {
            node.setNext(last);
            last = node;
        } ++this.size;
    }
    public void deleteFirst(){
        Node t;
        if (!isEmpty()){
           t = last;
           while (t.getNext()!=first) {
               t = t.getNext(); //t = t.next;
           }
           t.setNext(null);
           first = t;
           --this.size;
        } else {
            System.out.print("La lista está vacía");
        }
    }
    public boolean isEmpty(){
        return this.first == null;
    }
    public void setEmpty(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    
}
