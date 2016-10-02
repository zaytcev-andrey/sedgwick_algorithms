import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> 
{
	private class Node
	{
	   Item item;
	   Node next;
	   Node prev;
	}
	
	private Node first;
	private Node last;
	private int itemsCount;
		
	private class ListIterator implements Iterator<Item>
    {
        private Node current = first;
        
        public boolean hasNext()
        {  
        	return current != null;  
        }
        
        public void remove()     
        {  
        	throw new java.lang.UnsupportedOperationException();
        }
        
        public Item next()
        {
            Item item = current.item;
            current   = current.next; 
            return item;
        }
    }
	
	// construct an empty deque   
	public Deque()
	{
		first = null;
		last = null;
		itemsCount = 0;
	}
	
	// is the deque empty?
	public boolean isEmpty()
	{
		return itemsCount == 0;
	}
	   
	// return the number of items on the deque
	public int size()
	{
		return itemsCount;
	}
	
	// add the item to the front
	public void addFirst(Item item)
	{      
		if (item == null)
		{
			throw new java.lang.NullPointerException();
		}
		
		Node newFirst = new Node();
		newFirst.item = item;
		newFirst.next = first;
		newFirst.prev = null;
		
		if (!isEmpty())
		{
			first.prev = newFirst;
		}
		
		first = newFirst;
		
		if (isEmpty())
		{
			last = first;
		}
		
		++itemsCount;
	}
	   
	// add the item to the end
	public void addLast(Item item)
	{
		if (item == null)
		{
			throw new java.lang.NullPointerException();
		}
		
		Node newLast = new Node();
		newLast.item = item;
		newLast.prev = last;
		
		if (!isEmpty())
		{
			last.next = newLast;
		}
		
		last = newLast;
		
		if (isEmpty())
		{
			first = last;
		}
		
		++itemsCount;
	}
	
	// remove and return the item from the front
	public Item removeFirst()
	{
		if (isEmpty())
		{
			throw new java.util.NoSuchElementException();
		}
		
		Item removedItem = first.item;
		Node removedNode = first;
		if ( itemsCount > 1 )
		{
			first = removedNode.next;
			first.prev = null;
		}
		else
		{
			first = null;
		}
		
		removedNode = null;		
		--itemsCount;
		
		if (itemsCount <= 1)
		{
			last = first;
		}
		
		return removedItem;
	}
	   
	// remove and return the item from the end
	public Item removeLast()
	{
		if (isEmpty())
		{
			throw new java.util.NoSuchElementException();
		}
		
		Item removedItem = last.item;
		Node removedNode = last;
		
		if ( itemsCount > 1 )
		{
			last = removedNode.prev;
			last.next = null;
		}
		else
		{
			last = null;
		}
		
		removedNode = null;
		--itemsCount;
		
		if (itemsCount <= 1)
		{
			first = last;
		}
		
		return removedItem;
	}
	   
	// return an iterator over items in order from front to end
	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}
	   
	// unit testing
	public static void main(String[] args)
	{
		Deque<Integer> dequeInt = new Deque<Integer>();
		
		dequeInt.addFirst(0);
		dequeInt.removeFirst();
		StdOut.println(dequeInt.isEmpty() == true);
		
		dequeInt.addFirst(0);
		dequeInt.removeLast();
		StdOut.println(dequeInt.isEmpty() == true);
		
		dequeInt.addLast(0);
		dequeInt.removeFirst();
		StdOut.println(dequeInt.isEmpty() == true);
		
		dequeInt.addLast(0);
		dequeInt.removeLast();
		StdOut.println(dequeInt.isEmpty() == true);
		
		dequeInt.addFirst(1);
		dequeInt.addLast(2);
		dequeInt.addFirst(3);
		dequeInt.addLast(4);
		dequeInt.addLast(5);
		dequeInt.removeLast();
		dequeInt.removeLast();
		
		for(int item : dequeInt)
		{
			StdOut.println(item);
		}
	}
}
