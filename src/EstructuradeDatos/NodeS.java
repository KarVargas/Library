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
public class NodeS <T> {
    //Attributes
    private T data;
    private NodeS next;
    
    //Constructor
    public NodeS (T data) {
        this.data = data;
        this.next = null;
    }   
    public void setData (T data) {
        this.data = data;
    }    
    public T getData() {
        return this.data;
    }
    public NodeS getNext() {
        return next;
    }
    public void setNext(NodeS n) {
        this.next = n;
    }
}
