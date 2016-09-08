
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
		
	}
	
	public void union( int p, int q )
	{
		
	}
	
	public static void main(String[] args) 
	{		
		int N = StdIn.readInt();
		
		WeightedQuickUnionFind uf = new WeightedQuickUnionFind( 1 );
		
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