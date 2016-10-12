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
    /**
     * Este método es el constructor.
     * @param data es la información importante.
     */
    public NodeD(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
