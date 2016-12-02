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
public class BinaryTree {
    //Attributes
    NodeTree root;
    int height;
    int elements;
    //Methods
    //Contructor
    public BinaryTree () {
        this.root = null;
        this.height = -1;
        this.elements = 0;
    }
    public BinaryTree (int data) {
        this.root = new NodeTree(data);
    }
    public BinaryTree (NodeTree root){
        this.root = root;
    }
    public NodeTree getRoot() {
        return this.root;
    }
    public int getHeight() {
        return this.height;
    }
    public int getElements() {
        return this.elements;
    }
    public void setRoot(NodeTree root) {
        this.root = root;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setElements(int elements) {
        this.elements = elements;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public boolean isEmpty(NodeTree root){
        return root.left == null && root.right == null;
    }
    NodeTree node = new NodeTree();
    public void insert(int data){
        //NodeTree node = new NodeTree(data);
        node = new NodeTree(data);
        if(isEmpty()) {
            root = node;
            this.elements++;
        } else {
            this.insert(node, this.root);
            this.elements++;
        }
    }
    public void insert(NodeTree node, NodeTree root){
        if(node.data == root.data) {
            System.out.println("El número ya fue introducido");
        } else if(node.data < root.data) {
            if(root.left == null) {
                root.left = node;
            } else {
                insert(node, root.left);
            }
        } else {
            if(root.right == null){
                root.right = node;
            } else {
                insert(node, root.right);
            }
        }
        this.elements++;
    }
    //EMPIEZA EL RECORRIDO EN PREORDEN
    public void PreOrden() {
        aPreorden(root);
    }
    private void aPreorden(NodeTree node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " ");     //mostrar datos del nodo
        aPreorden(node.left);   //recorre subarbol izquierdo
        aPreorden(node.right);     //recorre subarbol derecho
    }
    //EMPEZAR RECORRIDO INORDEN
    public void InOrden() {
        aInorden(root);
    }
    private void aInorden(NodeTree node) {
        if(node == null) {
            return;
        }
        aInorden(node.left);
        System.out.print(node.data + " ");
        aInorden(node.right);
    }
    //EMPEZAR RECORRIDO PORORDEN
    public void PosOrden(){
        aPosorden(root);        
    }
    private void aPosorden(NodeTree node) {
        if(node == null) {
            return;
        }
        aPosorden(node.left);
        aPosorden(node.right);
        System.out.print(node.data + " ");
    }
    boolean hijoIzq = true;
    NodeTree dad;
    public NodeTree search(int data){//Metodo para buscar nodo
        if(!isEmpty()){//Se verifica si esta vacio el arbol
            NodeTree t;//Se declaran los nodos
            t = dad = root;//Se igualan los nodos a la raiz
            while(t.data != data){//Si el dato que esta en auxiliar es diferente
                //al dato pedido
                dad = t;//Se iguala padre a auxiliar
                if(t.data > data){//Si el dato del auxiliar es mayor que el dato
                    //pedido
                    t = t.left;//Se recorre el auxiliar a la izquierda
                    hijoIzq = true;
                } else {
                    t = t.right;//Auxiliar sera igual a lo que se encuentra a la derecha
                    //del mismo
                    hijoIzq = false;//hijoIzquierdo se volvera falso
                }
                if(t == null){
                    return null;
                }
            }
            return t;
        } System.out.println("no esta");
        return null;
    }
    public void delete (int data){
        if(search(data) == null){ //Si no se encontro el dato
            System.out.println("El nodo que busca no existe dentro del arbol");
        } else { //Si se encontro el dato
            NodeTree t = search(data); //Se crea un auxiliar 
            if(t.right == null && t.left == null){ //Si no tiene "hijos"
                t = null; //Simplemente se borra
           } else { //Si tiene "hijos"
                if(t.right != null && t.left != null){ //Si tiene dos "hijos"
                    t = t.right; //El de la derecha se pasa al "centro"
                    t.right = null; //Se borra el nodo de la derecha
                } else { //Si solo tiene un "hijo"
                    if(t.right != null){ //Si el "hijo" esta a la derecha
                        t = t.right; //El de la derecha se pasa al centro
                        t.right = null;
                    } else { 
                        if(t.left != null){ //Si el "hijo" esta a la izquierda
                            t = t.left;
                            t.left = null;
                        }
                    }
                }
            }
        }
        this.elements --; // el numero de elementos disminuye en 1
    }
    public boolean delete0(int data){
        if(!this.isEmpty()){//Se verifica si el arbol esta vacio o no
            NodeTree t = search(data);
            //Caso 1
            if(isEmpty(t)){//Verificar si es hoja
                if(root == t){
                    root = null;
                } else if (hijoIzq){
                    dad.left = null;
                } else {
                    dad.right = null;
                }
            } else if(t.left == null){ //Caso 2 Se va por la derecha
                    if(t == root){
                        root = t.right;
                    } else if(hijoIzq){
                        dad.left = t.right;//Lo que esta a la izquierda del apuntador padre
                    //Sera igual a lo que se encuentra a la derecha del apuntador auxiliar
                    } else {
                        dad.right = t.left;//Lo que esta a la derecha del apuntador padre
                    //Sera igual a lo que se encuentra a la izquierda del apuntador auxiliar
                    }
            } else {//Se va por la izquierda
                if(t == root){//Se verifica si auxiliar es igual a raiz
                    root = t.left;//Se iguala raiz al apuntador auxiliar a la izquierda
                } else if(hijoIzq){//Si se cumple la condicion de hijoIzquierdo
                    dad.right = t.right;//Lo que esta a la derecha del apuntador padre
                    //Sera igual a lo que se encuentra a la derecha del apuntador auxiliar
                } else {//En caso contrario
                    dad.left = t.right;//Lo que esta a la izquierda del apuntador padre
                        //Sera igual a lo que se encuentra a la derecha del apuntador auxiliar
                }
            }
            //Caso 3 dos hijos
        }
        return true;
    }
    public boolean delete1(int data) {
        NodeTree t = search(data);
        NodeTree dad = root;
        if(t == null){
            System.out.println("No se encontró el nodo."); //Imprime comentario.
            return false;
        } else {
            boolean nD;
            if(t.right == null){
                nD = false;
            } else{
                nD = true;
            }
            boolean nI;
            if(t.left == null){
                nI = false;
            } else {
                nI = true;
            }
            if(isEmpty(t)){
                return removeNodoCaso1(t);
            }
            /*if (!nD && !nI) {
                return removeNodoCaso1(t);
            }*/
            if (nD && !nI) {
                //return removeNodoCaso2(node);
            }
            if (!nD && nI) {
                //return removeNodoCaso2(node);
            }
            if (nD && nI) {
                //return removeNodoCaso3(node);
            }
            return false;
        }
    }
    private boolean removeNodoCaso1(NodeTree node) {
        NodeTree hI = node.left;
        NodeTree hD = node.right;
        if (hI == node) {
            node.left = null;
            return true;
        }
        if (hD == node) {
            node.right = null;
            return true;
        } return false;
    }/*
    private boolean removeNodoCaso2( Nodo nodo ) {
        Nodo hijoIzquierdo = nodo.getPadre().getHojaIzquierda();
        Nodo hijoDerecho = nodo.getPadre().getHojaDerecha();
        Nodo hijoActual = nodo.getHojaIzquierda() != null ? nodo.getHojaIzquierda() : nodo.getHojaDerecha();
        if ( hijoIzquierdo == nodo ) {
            nodo.getPadre().setHojaIzquierda( hijoActual );
            hijoActual.setPadre(nodo.getPadre());
            nodo.setHojaDerecha(null);
            nodo.setHojaIzquierda(null);
            return true;
        }
        if ( hijoDerecho == nodo) {
            nodo.getPadre().setHojaDerecha( hijoActual );
            hijoActual.setPadre(nodo.getPadre());
            nodo.setHojaDerecha(null);
            nodo.setHojaIzquierda(null);
            return true;
        }
        return false;
    }
    private boolean removeNodoCaso3( Nodo nodo ) {
        Nodo nodoMasALaIzquierda = recorrerIzquierda( nodo.getHojaDerecha() );
        if ( nodoMasALaIzquierda != null ) {
            nodo.setValor( nodoMasALaIzquierda.getValor() );
            removeNodo( nodoMasALaIzquierda );
            return true;
        }
        return false;
    }
    private Nodo recorrerIzquierda(Nodo nodo) {
        if (nodo.getHojaIzquierda() != null) {
            return recorrerIzquierda( nodo.getHojaIzquierda() );
        }
        return nodo;
    }
    public boolean removeNodo(NodeTree nodo) {
        boolean tieneNodoDerecha = nodo.getHojaDerecha() != null ? true : false;
        boolean tieneNodoIzquierda = nodo.getHojaIzquierda() != null ? true : false;
        if (!tieneNodoDerecha && !tieneNodoIzquierda) {
            return removeNodoCaso1( nodo );
        }
        if ( tieneNodoDerecha && !tieneNodoIzquierda ) {
            return removeNodoCaso2( nodo );
        }
        if ( !tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso2( nodo );
        }
        if ( tieneNodoDerecha && tieneNodoIzquierda ) {
            return removeNodoCaso3( nodo );
        }
        return false;
    }*/
    /*public NodeTree search1(int data){
        NodeTree t = null;
        if (!isEmpty()) {
            if (data == root.data) {
                return this.root;
            } else {
                if (data < root.data) {
                    //t = root.left.search(data);
                    t = root.left;
                } else {
                    //t = root.right.search(data);
                    t = root.right;
                }
            }
        }
        return t;
    }*/
    /*public void insert2(int data, NodeTree root){
        NodeTree node = new NodeTree(data);
        if(isEmpty(root)) { //Si está vacio.
            root = node;
            this.height++;
        } else {//Si no esta vacio.
            if(root.data <= node.data) { //Si el nodo es mayor que raíz.
                if(root.left == null) { //Si no tiene elementos a la izq. Caso Base
                    root.left = node;
                } else {
                    insert2(data, root.left);
                }
            } else{
                if(root.right == null) { //Caso Base
                    root.right = node;
                } else {
                    insert2(data, root.right);
                }
            }
        }
        this.elements++;
    }*/
    /*public void insert3(NodeTree node, NodeTree root){
        if(isEmpty()){
            root = node;
            this.height++;
        } else {
            if(node.data <= root.data){
                //if(node.getData() <= root.getData()){
                insert3(node, root.getLeft());
            } else {
                insert3(node, root.getRight());
            }
        }
    }*/
}
