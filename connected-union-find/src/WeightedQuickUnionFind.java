
import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class WeightedQuickUnionFind {
	
	public WeightedQuickUnionFind( int N )
	{
		count_ = N;
		id_ = new int[ N ];
		sz_ = new int[ N ];
		
		for( int i = 0; i < N; ++i )
		{
			id_[ i ] = i;
		}
		
		Arrays.fill( sz_, 1 );
	}
	
	public int count()
	{
		return count_;
	}
	
	public boolean connected( int p, int q )
	{
		return find( p ) == find( q );
	}
	
	public int find( int p )
	{
		while( p != id_[ p ] )			
		{
			p = id_[ p ];
		}
		
		return p;
	}
	
	public void union( int p, int q )
	{
		int i = find( p );
		int j = find( q );
		
		if ( i == j )
		{
			return;
		}
		
		if ( sz_[ i ] < sz_[ j ] )
		{
			id_[ i ] = j;
			sz_[ j ] += sz_[ i ];
		}
		else
		{
			id_[ j ] = i;
			sz_[ i ] += sz_[ j ];
		}
		
		--count_;
	}
	
	public static void main(String[] args) 
	{		
		int N = StdIn.readInt();
		
		WeightedQuickUnionFind uf = new WeightedQuickUnionFind( N );
		
		while( !StdIn.isEmpty() )
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			
			if ( uf.connected( p, q ) )
			{
				continue;
			}
			
			uf.union( p, q );
			StdOut.print( p + " " + q );
		}
		
		StdOut.println( uf.count() + " components" );
	}
	
	private int[] id_;
	private int[] sz_;
	private int count_;	
}