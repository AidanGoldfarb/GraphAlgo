public class Driver{
	public static void main(String [] args){
		Graph g = new Graph();
		/*
		*/
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		/*
		*/
		g.addEdge(1,2);
		g.addEdge(1,3);
		g.addEdge(1,5);

		g.addEdge(2,4);
		g.addEdge(2,5);

		g.addEdge(3,4);
		g.addEdge(3,5);

		g.addEdge(4,5);
		/*
		*/

		print(g);

		depth_first_search(g);
		
		is_graph_connected(g);

		/*
		Graph g
	    {1}-----------{2}
	     | \         / |
	     |  \       /  |
	     |   \     /   |
	     |     {5}     |
	     |   /     \   |
	     |  /       \  |
	     | /         \ |
	    {3}-----------{4}
		
		*/
	}

	public static void is_graph_connected(Graph g){
		ConnectionTest ct = new ConnectionTest(g);
		println("Testing if g is connected...");
		println(ct.isConnected());
		println("Done");
	}

	public static void depth_first_search(Graph g){
		DFS dfs = new DFS(g);
		println("Running DFS of g...");
		dfs.search();
		println("Done\n");

	}

	public static <T> void print(T str){
		System.out.print(str);
	}
	public static <T> void println(T str){
		System.out.println(str);
	}
}