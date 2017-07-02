import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class UndirectedGraph
{
	public UndirectedGraph( int vertexCount )
	{
		this.vertexCount_ = vertexCount;
		this.edgesCount_ = 0;
		
		CreateAdg();
	}
	
	public UndirectedGraph( In in )
	{
		this.vertexCount_ = in.readInt();		
		this.edgesCount_ = 0;
		
		CreateAdg();
		
		int edges = in.readInt();
		
		for ( int idx = 0; idx < edges; ++idx )
		{
			final int v = in.readInt();
			final int w = in.readInt();
			
			AddEdge( v, w );
		}
	}
	
	public void AddEdge( int v, int w )
	{
		adg_[ v ].add( w );
		adg_[ w ].add( v );
		edgesCount_++;
	}
	
	public Iterable< Integer > Adg( int v )
	{
		return adg_[ v ];
	}
	
	public int VertexCount()
	{
		return vertexCount_;
	}
	
	public int EdgeCount()
	{
		return edgesCount_;
	}
	
	@SuppressWarnings("unchecked")
	private void CreateAdg()
	{				
		adg_ = ( Bag< Integer >[] ) new Bag[ vertexCount_ ];
		
		for ( int v = 0; v < vertexCount_; ++v )
		{
			adg_[ v ] = new Bag< Integer >();
		}
	}
	
	private final int vertexCount_;
	private int edgesCount_;
	private Bag< Integer >[] adg_;
}