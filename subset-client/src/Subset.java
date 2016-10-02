import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Subset 
{
	// unit testing
	public static void main( String[] args )
	{
		RandomizedQueue< String > deque_int = new RandomizedQueue< String >();
		
		int count = Integer.parseInt( args[ 0 ] );
		
		while ( !StdIn.isEmpty() )
		{
			deque_int.enqueue( StdIn.readString() );
		}
		
		while ( count-- > 0 )
		{
			try
			{
				StdOut.println( deque_int.dequeue() );
			}
			catch( java.util.NoSuchElementException e)
			{
				break;
			}
			
		}
	}
}
