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
public class doubleList <T> {
    //Attributes
    NodeD first;
    NodeD last;
    
    //Methods
    /**
     * Este método inserta un nodo al inicio de la lista.
     * @param data es de tipo generica y contiene la información importante.
     */
    public void insertFirst(T data){
        NodeD node = new NodeD(data); //Creamos nuestro nodo
        if(isEmpty()){ //Si la lista está vacía
            this.first = node; //Se crea un nodo, dando así que first sea igual a nodo, ya que solo existe uno.
            this.last = node; //Se crea un nodo, dando así que last sea igual a nodo, ya que solo existe uno.
        } else { //Si la lista tiene elementos
            node.next = first; //El apuntador "SIGUIENTE" del nuevo nodo, apunta al primer nodo de la lista.
            first.prev = node; //El apuntador "ANTERIOR" del primer nodo de la lista, apunta al nuevo nodo.
            first = node; //El apuntador first (que es atributo de la lista) apunta al nuevo nodo, es decir, que el nuevo nodo será first (el primero).
        }
    }
    /**
     * Este método inserta un nodo al final de la lista.
     * @param data es de tipo generica y contiene la información importante.
     */
    public void insertLast(T data){
        NodeD node = new NodeD(data); //Creamos nuestro nodo
        if(isEmpty()){ //Si la lista está vacía
            this.first = node; //Se crea un nodo, dando así que first sea igual a nodo, ya que solo existe uno.
            this.last = node; //Se crea un nodo, dando así que last sea igual a nodo, ya que solo existe uno.
        } else { //Si la lista tiene elementos
            node.prev = last; //El apuntador "ANTERIOR" del nuevo nodo, apunta al último nodo de la lista.
            last.next = node; //El apuntador "SIGUIENTE" del último nodo de la lista, apunta al nuevo nodo.
            last = node; //El apuntador last (que es atributo de la lista) apunta al nuevo nodo, es decir, que el nuevo nodo será last (el último).
        }
    }
    /**
     * Este método verifica si la lista está vacía.
     * @return null en first y last en el caso que estuvieran vacías.
     */
    private boolean isEmpty(){
        return first == null && last == null;
    }
    /**
     * Este método busca un nodo en toda la lista.
     * @param data es de tipo generica y contiene la información importante.
     * @return dependiendo ya que si regresa null significa que la lista está vacía o que el nodo no se encuentra dentro de la lista, o regresa el nodo en el caso de que si lo encuentre.
     */
    public NodeD searchNode(T data){
        NodeD t; //Declaro un nodo temporal.
        if (isEmpty()){ //Si está vacío retorna falso.
            System.out.println("La lista está vacía."); //Imprime comentario.
            return null;
        } else { //Si contiene elementos.
            t = first; //Colocamos auxiliar al inicio de la lista.
            while (t.data != data && t != last){ //Mientras que no encuentre el dato o no llegue al final de la lista, recorre la lista.
                t = t.next; //Recorre la lista, dando valor del apuntador para avanzar.
            } 
            if (t.data == data) { //Si el valor del nodo es igual a la información que se esta buscando.
                System.out.println("El nodo solicitado si se encuentra dentro de la lista."); //Imprime comentario.
                return t;
            } else { //Si el valor del nodo es diferente a la información que se esta buscando.
                System.out.println("El nodo no se encuentra dentro de la lista."); //Imprime comentario.
                return null;
            }
            /*if(t.data==data){return t;} //lo encontro y regresa el nodo
            else {return null;} //Llego al final y no lo encontro*/
        }
    }
    /**
     * Este método elimina un nodo independientemente de su posición.
     * @param data es de tipo generica y contiene la información importante.
     * @return depende ya que si regresa false significa que el nodo no se encuentra dentro de la lista, y si regresa true quiere decir que si se encuentra más aparte elimina el nodo.
     */
    public boolean eNode(T data){
        NodeD t = searchNode(data);
        if (t == null) { //Si el nodo no existe.
            System.out.println("No se encontró el nodo."); //Imprime comentario.
            return false;
        } else { //Si el nodo existe.
            if (t == first) { //Si el nodo se encuentra en la primera posición.
                deleteFirst(); //Se usará el método para eliminar el primer nodo.
            } else if (t == last) { //Si el nodo se encuentra en la última posición.
                deleteLast(); //Se usará el método para eliminar el último nodo.
            } else { //Si el nodo no se encuentra ni al principio ni al final, pero esta dentro de la lista.
                t.prev.next = t.next; //El nodo "ANTERIOR-SIGUIENTE" apuntará al nodo "SIGUIENTE".
                t.next.prev = t.prev; //El nodo "SIGUIENTE-ANTERIOR" apuntará al nodo "ANTERIOR".
            } return true;
        }
    }
    /**
     * Este método elimina el nodo que se encuentra al principio de la lista.
     */
    public void deleteFirst(){
        //Movemos al apuntador first al siguiente nodo y el previo de este lo ponemos null
        first = first.next; //Inicializamos first con el apuntador "SIGUIENTE" de first, para que así first pase a su apuntador y olvide el nodo en el que se encontraba.
        first.prev = null;
    }
    /**
     * Este método elimina el nodo que se encuentra al final de la lista.
     */
    public void deleteLast(){
        //Movemos al apuntador last al nodo anterior y el next de este ultimo lo ponemos a null
        last = last.prev; //Inicializamos last con el apuntador "ANTERIOR" de last, para que así last pase a su apuntador y olvide el nodo en el que se encontraba.
        last.next = null;
    }
    /**
     * Este método muestra la lista completa con nodos en el caso de tener, por el contrario, te arroja un comentario diciendote que la lista está vacía.
     */
    public void showList(){
        if (!isEmpty()){ //Si la lista no está vacía.
            NodeD t; //Declaramos nodo temporal.
            t = (NodeD) first; //Donde nodo será igual a first (al inicio).
            System.out.print("☠<=>"); //Imprime comentario.
            while(t != null){ //Mientras el nodo sea diferente a null, recorrera la lista. Una vez sea null, se sale del ciclo.
                System.out.print("[|"+t.data+"|]<=>"); //Imprime comentario, mientras imprime la información del nodo.
                t = t.next; //El nodo será igual a su apuntador "SIGUIENTE", para así recorrer toda la lista.
            } //Fin del ciclo.
            System.out.println("☠"); //Imprime comentario.
        } else { //En caso de que la lista este vacía.
            System.out.println("La lista está vacía"); //Imprime comentario.
        } //Fin de la condición.
    }
    /**
     * Este método muestra la lista completa con nodos en el caso de tener pero es de fin a inicio, es decir, lo contrario del método showList, por el contrario, te arroja un comentario diciendote que la lista está vacía.
     */
    public void showListRever(){
        if (!isEmpty()){ //Si la lista no está vacía.
            NodeD t; //Declaramos nodo temporal.
            t = (NodeD) last; //Donde nodo será igual a last (al final).
            System.out.print("☠<=>"); //Imprime comentario.
            while(t != null){ //Mientras el nodo sea diferente a null, recorrera la lista. Una vez sea null, se sale del ciclo.
                System.out.print("[|"+t.data+"|]<=>"); //Imprime comentario, mientras imprime la información del nodo.
                t = t.prev; //El nodo será igual a su apuntador "ANTERIOR", para así recorrer toda la lista.
            }
            System.out.println("☠"); //Imprime comentario.
        } else { //En caso de que la lista este vacía.
            System.out.println("La lista está vacía"); //Imprime comentario.
        } //Fin de la condición.
    }
    /*
    public boolean deleteNode(T data){
        NodeD t;
        if (isEmpty()){ //Si está vac+io returna falso.
            return false;
        } else { //Si contiene elementos.
            t = first; //Colocamos auxiliar al inicio de la lista.
            while (t.data != data && t != last){ //Mientras que no encuentre el dato o no llegue al final de la lista, recorre la lista.
                t = t.next; //Recorre la lista.
            }
            /*if(t == null){return false;} // No lo encontro
            else {
            t.next.prev=t.prev;
            t.prev.next=t.next;
            return true;} */
            /*if (t.data==data) {
                t.next.prev=t.prev;
                t.prev.next=t.next;
                return true;}
            else {return false;}/
            return t.data==data; //Si lo encuentra regresa true
        }
    }*/
}
