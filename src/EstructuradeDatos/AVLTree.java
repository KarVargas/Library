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
public class AVLTree {
    //Attributes
    //Raíz
    private AVLNode root;
    //Constructor
    public AVLTree(){
        this.root=null;
    }
    //Buscar un nodo
    public AVLNode fetch(int d, AVLNode r){
        if(root==null){//No hay nodos.
            return null;
        } else if(root.data == d){ //Si el dato que buscamos esta en la raíz.
            return root;
        } else if(root.data < d){ //Si el dato es mayor a raíz.
            return fetch(d, r.right); //Lo buscamos por la derecha.
        } else {
            return fetch(d, r.left); //Lo buscamos por la izquierda.
        }
    }
    //Obtener factor de balance
    public int getBF(AVLNode node) {
        if(node == null) {
            return -1;
        } else {
            return node.bf;
        }
    }
    //Rotación simple a la izquierda.
    public AVLNode leftRotation (AVLNode r) {
        //Declaramos un auxiliar
        AVLNode t = r.left;
        r.left = t.right;
        t.right = r;
        r.bf = calcBF(r);
        t.bf = calcBF(t);
        //r.bf = Math.max(getBF(r.left), getBF(r.right))+1;
        //t.bf = Math.max(getBF(t.left), getBF(r.right))+1;
        return t;
    }
    public int calcBF(AVLNode node) {
        return Math.max(getBF(node.left), getBF(node.right))+1;
    }
    //Rotación simple a la derecha
    public AVLNode rightRotation (AVLNode r) {
        //Declaramos un auxiliar
        AVLNode t = r.right;
        r.right = t.left;
        t.left = r;
        r.bf = calcBF(r);
        t.bf = calcBF(t);
        //r.bf = Math.max(getBF(r.left), getBF(r.right))+1;
        //t.bf = Math.max(getBF(t.left), getBF(r.right))+1;
        return t;
    }
    //Rotación doble a la derecha.
    public AVLNode dRightRotation(AVLNode r) {
        AVLNode t;
        r.left = rightRotation(r.left);
        t = leftRotation(r);
        return t;
    }
    //Rotación doble a la izquierda.
    public AVLNode dLeftRotation(AVLNode r) {
        AVLNode t;
        r.right = leftRotation(r.right);
        t = rightRotation(r);
        return t;
    }
    //Insertar nodo AVL
    public AVLNode insert (AVLNode n, AVLNode sr){ //sr= second root
        AVLNode newDad = sr;
        if(n.data < sr.data){
            if (sr.left == null) {
                sr.left = n;
            } else {
                sr.left = insert(n, sr.left);
                if((getBF(sr.left)-getBF(sr.right)) == 2){
                    if(n.data < sr.left.data){
                        newDad = leftRotation(sr);
                    } else {
                        newDad = dLeftRotation(sr);
                    }
                }
            }
        } else if (n.data > sr.data){
            if(sr.right == null){
                sr.right = n;
            } else {
                sr.right = insert(n,sr.right);
                if((getBF(sr.right)-getBF(sr.left)) == 2) {
                    if(n.data > sr.right.data){
                        newDad = rightRotation(sr);
                    } else {
                        newDad = dRightRotation(sr);
                    }
                }
            }
        } else {
            System.out.println("El nodo está ducplicado");
        }
        //Actualizar
        if (sr.left==null && sr.right!=null){
            sr.bf = sr.right.bf+1;
        } else if (sr.right == null && sr.left!=null){
            sr.bf = sr.left.bf+1;
        }
        return sr;
    }
}
