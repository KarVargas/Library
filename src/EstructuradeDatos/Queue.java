/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructuradeDatos;

/**
 *
 * @author CarlosManuel
 * @param <T>
 */
public class Queue <T>{
    //Atributes
    private Node first;
    private Node last;
    private Node moving;
    private int size;
    
    //Constructor
    public Queue (){
        this.first = null;
        this.last = null;
        this.moving = null;
        this.size = 0;
    }
    
    public Queue (T data){
        insertLast(data);
    }
    
    //Métodos
    public void insertLast(T data){
        Node <T> node = new Node(data);
        if (isEmpty()){
            this.first = node;
            this.last = node;
        }else{
            node.setNext(last);
            last=node;
        }
        ++this.size;
    }
    
    public T deleteFirst(){
        Node temp;
        if (!isEmpty()){
            if (size==1){
                temp=this.first;
                this.first = this.last = null;
                size=0;
            }else{
                temp=last;
                while(temp.getNext()!=first){
                    temp=temp.getNext();
                }
                first = temp;
                temp = first.getNext();
                first.setNext(null);
                --size;
            }
           return (T) temp.getData();
        }
        return null;
    }
    
    public void setEmpty(){
        this.first = null;
        this.last = null;
        this.size=0;
    }
    
    public boolean isEmpty(){
        return first == null;
    }

    public int getSize() {
        return size;
    }    
}
