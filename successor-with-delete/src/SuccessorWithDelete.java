import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class SuccessorWithDelete 
{
	
	public SuccessorWithDelete( int N )
	{
		count_ = N;
		id_ = new int[ N + 1 ];
		sz_ = new int[ N + 1 ];
		max_element_ = new int[ N + 1 ];
		
		for( int i = 0; i < N + 1; ++i )
		{
			id_[ i ] = i;
			max_element_[ i ] = i;
		}
		
		Arrays.fill( sz_, 1 );
	}
	
	public void remove( int p )
	{
		union( p, p + 1 );
	}
	
	public int successor( int x )
	{
		x = root( x );
		int success = max_element_[ x ] != max_element_.length - 1 ? max_element_[ x ] : -1;
		
		return success;
	}
	
	private int count()
	{
		return count_;
	}
	
	private boolean connected( int p, int q )
	{
		return root( p ) == root( q );
	}
	
	private int root( int p )
	{
		while( p != id_[ p ] )			
		{
			p = id_[ p ];
		}
		
		return p;
	}
	
	public void union( int p, int q )
	{
		int i = root( p );
		int j = root( q );
		
		int max_i = max_element_[ i ];
		int max_j = max_element_[ j ];
		
		if ( i == j )
		{
			return;
		}
		
		if ( sz_[ i ] < sz_[ j ] )
		{
			id_[ i ] = j;
			sz_[ j ] += sz_[ i ];
			max_element_[ j ] = Math.max( max_i, max_j );
		}
		else
		{
			id_[ j ] = i;
			sz_[ i ] += sz_[ j ];
			max_element_[ i ] = Math.max( max_i, max_j );
		}
		
		--count_;
	}
	
	public static void main(String[] args) 
	{		
		int N = 10;
		
		SuccessorWithDelete successor = new SuccessorWithDelete( N );
		
		successor.remove( 2 );
        StdOut.println( successor.successor( 2 ) == 3 );
        
        successor.remove( 3 );
        StdOut.println( successor.successor(2) == 4 );
        StdOut.println( successor.successor(8) == 8 );
        
        successor.remove( 8 );
        StdOut.println( successor.successor(8) == 9 );
        
        successor.remove( 9 );
        StdOut.println( successor.successor(8) == -1 );
        successor.remove( 5 );
        successor.remove( 4 );
        
        StdOut.println( successor.successor(3) == 6 );
	}
	
	private int[] id_;
	private int[] sz_;
	private int count_;
	private int[] max_element_;
}