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
    T data; //Declaramos una variable "data" de cualquier tipo por ser generica.
    NodeL next; //Declaramos una variable "next" de tipo nodeClass, mismo nombre de la clase.
    
    //Methods
    /**
     * Método es el constructor de la clase con sus respectivas variables.
     * @param data es de tipo generico y contiene la información importante.
     */
    public NodeL(T data){
        this.data = data; //Inicializamos en que data es igual a data.
        this.next = null; //Inicializamos en que next es igual a null o vacío.
    }
}
