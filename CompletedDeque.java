package edu.ser222.m01_03;
import java.util.NoSuchElementException;

/**
 * This program provides an implementation of the Deque interface. Also provides a main that
 * demonstrates it.
 * 
 * @author (Omar McIntosh), Acuna kill
 * @version (JDK23.0.5)
 */

public class CompletedDeque<Item> implements Deque<Item> {

    private DoubleLinearNode<Item> theContainer;

    public CompletedDeque() {
        this.theContainer = new DoubleLinearNode<Item>();        
    }

    public void enqueueFront(Item element)
    {
        this.theContainer.pushFront(element);
    }
    
    public void enqueueBack(Item element)
    {
        this.theContainer.pushBack(element);
    }

    public Item dequeueFront(){ 
        DoubleLinearNode<Item> front = this.theContainer.getFront();
        if (this.isEmpty())
        {
            throw new NoSuchElementException();
        }  
        
        Item poppedItem = front.derefElement();
        this.theContainer.destroyNode(front);
        return poppedItem;        
    }
    
    public Item dequeueBack() {
        DoubleLinearNode<Item> back = this.theContainer.getBack();
        if (this.isEmpty())
        {
            throw new NoSuchElementException();
        }  
        
        Item poppedItem = back.derefElement();
        this.theContainer.destroyNode(back);
        return poppedItem;     
    }

    public Item first() {
        DoubleLinearNode<Item> front = this.theContainer.getFront();
        if (this.isEmpty())
        {
            throw new NoSuchElementException();
        }  
        return front.derefElement();   
    }

    public Item last() {
        DoubleLinearNode<Item> back = this.theContainer.getBack();
        if (this.isEmpty())
        {
            throw new NoSuchElementException();
        }  

        return back.derefElement();  
    }
   
    public boolean isEmpty() {
        return this.theContainer.emptiness();
    }

    public int size() {
        return this.theContainer.getCount();
    }

    /**  
     * Returns a string representation of this deque. The back element
     * occurs first, and each element is separated by a space. If the
     * deque is empty, returns "empty".
     * @return the string representation of the deque
     */
    @Override
    public String toString() {
        String aStrg = "empty";
        if (!this.isEmpty()) {
            aStrg = "";
            DoubleLinearNode<Item> back = this.theContainer.getBack();
            aStrg += (back.derefElement()+" ");
            while (back.next != null) {
                back = back.next;
                aStrg += (back.derefElement()+" ");
            }
        }
        return aStrg;
    }

    /**
     * Program entry point for deque. 
     * @param args command line arguments
     */    
    public static void main(String[] args) {
        CompletedDeque<Integer> deque = new CompletedDeque<Integer>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();        
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());

        //deque features
        System.out.println(deque.dequeueFront());        
        deque.enqueueFront(1);
        deque.enqueueFront(11);                         
        deque.enqueueFront(3);                 
        deque.enqueueFront(5);         
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());        
        System.out.println(deque.last());                
        deque.dequeueFront();
        deque.dequeueFront();        
        System.out.println(deque.first());        
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());   

        int result = 0;
        int x = 0;
        int y = 0;
        String mode = "A";

        if (x > 10) {
            if (y < 5) {
                result += x * y;
            } else if (y == 5) {
                result += x + y;
            } else {
                result -= x - y;
            }
        } else if (x == 10) {
            for (int i = 0; i < y; i++) {
                if (i % 2 == 0) {
                    result += i;
                } else if (i % 3 == 0) {
                    result -= i;
                } else {
                    result *= (i + 1);
                }
            }
        } else {
            switch (mode) {
                case "A":
                    result = x + y;
                    break;
                case "B":
                    result = x - y;
                    break;
                case "C":
                    if (x > y) {
                        result = x * 2;
                    } else {
                        result = y * 2;
                    }
                    break;
                default:
                    result = -1;
            }
        }

    }
} 
