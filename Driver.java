public class Driver{
	public static void main(String [] args){
		
		Graph g1 = makeGraphOne();
		Graph g2 = makeGraphTwo();
		Graph g3 = makeGraphThree();
		Graph test = g1;
		print(test);

		//depth_first_search(test);
		
		//is_graph_connected(test);

		is_graph_two_colorable(test);
	}


		/*
		Graph One
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
	public static Graph makeGraphOne(){
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
		return g;
	}

	/*
		Graph Two
	    {1}-----------{2}
	     | 	           |
	     |             |
	     |             |
	     |     {5}     |
	     |             |
	     |             |
	     |             |
	    {3}-----------{4}
		
		*/
	public static Graph makeGraphTwo(){
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

		g.addEdge(2,4);

		g.addEdge(3,4);
		/*
		*/
		return g;
	}

	/*
		Graph Two
	    {1}-----------{2}
	     | 	           |
	     |             |
	     |             |
	     |             |
	     |             |
	     |             |
	     |             |
	    {3}-----------{4}
		
		*/
	public static Graph makeGraphThree(){
		Graph g = new Graph();
		/*
		*/
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		/*
		*/
		g.addEdge(1,2);
		g.addEdge(1,3);

		g.addEdge(2,4);

		g.addEdge(3,4);
		/*
		*/
		return g;
	}

	public static void is_graph_two_colorable(Graph g){
		TwoColorTest tct = new TwoColorTest(g);
		println("Testing whether g is two colorable...\n");
		tct.test();
		println("\nTrue");
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