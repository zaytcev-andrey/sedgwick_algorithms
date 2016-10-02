import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> 
{
	private Item[] queueItems;
	private int headIdx;
	private int tailIdx;
	
	// construct an empty queue
	public RandomizedQueue()
	{
		headIdx = tailIdx = 0;
		int initial_capacity = 1;
		queueItems = (Item[])new Object[initial_capacity];
	}
	
	private void resize( int capacity )
	{
		Item[] newItems = (Item[])new Object[capacity];
		
		final int curr_size = size();
		System.arraycopy( queueItems, headIdx, newItems, 0, curr_size );
		
		queueItems = null;
		queueItems = newItems;
		headIdx = 0;
		tailIdx = headIdx + curr_size;
	}
	
	private int GetRandomIdx( int begin, int end )
	{ 
		final double randOffset = Math.random() * (end - begin);
		final int offset = (int)randOffset;
		return begin + offset;
	}
	
	private void swap(Item[] a, int lhs, int rhs)
	{
		Item tmp = a[lhs];
		a[lhs] = a[rhs];
		a[rhs] = tmp;
	}
		
	private class RandomArrayIterator implements Iterator<Item>
    {        
        private Item[] arr;
		private int currentIdx = 0;
        private int itemsSize;
        
        RandomArrayIterator()
        {
        	itemsSize = size();
        	arr = (Item[])new Object[itemsSize];
        	System.arraycopy(queueItems, headIdx, arr, 0, itemsSize);
        }
		
		public boolean hasNext()
        {  
        	return currentIdx < itemsSize;  
        }
        
        public void remove()     
        {  
        	throw new java.lang.UnsupportedOperationException();
        }
        
        public Item next()
        {
            if ( hasNext() )
            {
            	int nextIdx = GetRandomIdx(currentIdx, itemsSize - 1);
            	if (nextIdx != currentIdx)
            	{
            		swap(arr, currentIdx, nextIdx);
            	}
            	
            	Item removed = arr[currentIdx];
            	arr[currentIdx++] = null;;
            	return removed;
            }
        	
            arr = null;
            throw new java.util.NoSuchElementException();
        }
    }
	
	// is the queue empty?
	public boolean isEmpty()
	{
		return size() == 0;
	}
	   
	// return the number of items on the queue
	public int size()
	{
		return tailIdx - headIdx;
	}
	
	// add the item
	public void enqueue(Item item)
	{
		if (tailIdx == queueItems.length)
		{
			resize( size() * 2 );
		}
		
		queueItems[tailIdx++] = item;
	}
	
	// remove and return a random item
	public Item dequeue()
	{
		if (size() == queueItems.length / 4)
		{
			resize(size() * 2);
		}
		
		if (isEmpty())
		{
			throw new java.util.NoSuchElementException();
		}
		
		final int idx = GetRandomIdx(headIdx, tailIdx - 1);
		Item removed = queueItems[idx];		
		swap(queueItems, headIdx, idx);
		queueItems[headIdx++] = null;
		
		return removed;
	}
	
	// return (but do not remove) a random item
	public Item sample()
	{
		final int idx = GetRandomIdx(headIdx, tailIdx - 1);
		return queueItems[idx];
	}
	   
	// return an iterator over items in order from front to end
	public Iterator<Item> iterator()
	{
		return new RandomArrayIterator();
	}
	   
	// unit testing
	public static void main(String[] args)
	{
		RandomizedQueue<Integer> dequeInt = new RandomizedQueue<Integer>();
		
		dequeInt.enqueue(1);
		dequeInt.enqueue(2);
		dequeInt.enqueue(3);
		dequeInt.enqueue(4);
		dequeInt.enqueue(5);
		dequeInt.enqueue(6);
		dequeInt.enqueue(7);
		dequeInt.enqueue(8);
		dequeInt.enqueue(9);
		dequeInt.enqueue(10);
		dequeInt.enqueue(11);
		
		for(int item : dequeInt)
		{
			StdOut.println( item );
		}
		
		while(true)
		{
			try
			{
				StdOut.println(dequeInt.dequeue());
			}
			catch(java.util.NoSuchElementException e)
			{
				break;
			}
			
		}
	}
}
