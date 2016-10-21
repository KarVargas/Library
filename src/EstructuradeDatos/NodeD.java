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
public class NodeD <T> {
    //Attibutes
    T data;
    NodeD next;
    NodeD prev;
    //Methods
    //Constructor
    /**
     * Este método es el constructor.
     * @param data es la información importante.
     */
    public NodeD(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public NodeD(){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public T getData(){
        return this.data;
    }
    public NodeD getNext() {
        return next;
    }
    public NodeD getPrev() {
        return prev;
    }
    public void setData(T d){
        this.data = d;
    }
    public void setNext(NodeD next) {
        this.next = next;
    }
    public void setPrev(NodeD prev) {
        this.prev = prev;
    }
}
