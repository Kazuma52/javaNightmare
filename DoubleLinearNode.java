package edu.ser222.m01_03;

/**
 * This program provides an implementation of the Deque interface. Also provides a main that
 * demonstrates it.
 * 
 * @author (Omar McIntosh), Acuna
 * @version (JDK23.0.5)
 */

 public class DoubleLinearNode<Generic> {
    private Generic element;
    public DoubleLinearNode<Generic> next;
    public DoubleLinearNode<Generic> last;
    public DoubleLinearNode<Generic> head;
    public DoubleLinearNode<Generic> tail;
    private int nodeCount;


    public DoubleLinearNode(Generic element) {
        this.element = element;
        this.next = null;
        this.last = null;
        this.nodeCount = 0;
    }

    public DoubleLinearNode() {
        this.element = null;
        this.next = null;
        this.last = null;
        this.nodeCount = 0;
        this.head = this;
        this.tail = this;
    }

    public void pushFront(Generic element) {
        if (this.emptiness())
        {
            this.element = element;
        }
        else {
            DoubleLinearNode<Generic> newNode = new DoubleLinearNode<Generic>(element);
            DoubleLinearNode<Generic> node = this.tail;

            while (node.next != null) {
                node = node.next;
            }
            newNode.last = node;
            node.next = newNode;
            this.head = newNode;
        }


        this.nodeCount++;
    }

    public void pushBack(Generic element) {

        if (this.emptiness())
        {
            this.element = element;
        }
        else {
            DoubleLinearNode<Generic> newNode = new DoubleLinearNode<Generic>(element);
            DoubleLinearNode<Generic> node = this.head;
            while (node.last != null) {
                node = node.last;
            }
            newNode.next = node;
            node.last = newNode;
            this.tail = newNode;
        }
        this.nodeCount++;
    }

    public DoubleLinearNode<Generic> getBack() {
        DoubleLinearNode<Generic> node = this.head;
        while (node.last != null) {
            node = node.last;
        }
        return node;
    }

    public DoubleLinearNode<Generic> getFront() {
        DoubleLinearNode<Generic> node = this.tail;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public Generic derefElement(){
        return this.element;
    }

    public boolean emptiness() {
        return (this.nodeCount < 1);
    }

    public void destroyNode(DoubleLinearNode<Generic> node) {

        if (1 < this.nodeCount) {  

            if (node.next == null) {
                this.head = node.last;
                node.last.next = null;
            }
            if (node.last == null) {
                this.tail = node.next;
                node.next.last = null;
            }

        }

        if (0 < this.nodeCount) {
            this.nodeCount--;
        }
    }

    public int getCount() {
        return this.nodeCount;
    }
}