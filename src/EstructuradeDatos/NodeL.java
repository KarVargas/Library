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
public class NodeL <T> {
    //Attributes
    protected T data; //Declaramos una variable "data" de cualquier tipo por ser generica.
    protected NodeL next; //Declaramos una variable "next" de tipo nodeClass, mismo nombre de la clase.
    
    //Methods
    /**
     * Método es el constructor de la clase con sus respectivas variables.
     * @param data es de tipo generico y contiene la información importante.
     */
    public NodeL(T data){
        this.data = data; //Inicializamos en que data es igual a data.
        this.next = null; //Inicializamos en que next es igual a null o vacío.
    }
    public T getData() {
        return data;
    }
    public NodeL getNext() {
        return next;
    }
    public void setData(T data) {
        this.data = data;
    }
    public void setNext(NodeL next) {
        this.next = next;
    }
}
