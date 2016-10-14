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
public class NodeC <T> {
    //Attributes
    NodeC next;
    T data;
    
    //Methods
    //Constructor con dato
    /**
     * 
     * @param data 
     */
    public NodeC(T data) {
        this.data = data;
        this.next = null;
    }
    
    //Contructor nulo
    /**
     * 
     */
    public NodeC(){
        this.data = data;
        this.next = null;
    }
    
    //Getters and Setters
    public T getData(){
        return this.data;
    }
    
    public void setData(T d){
        this.data = d;
    }
}
