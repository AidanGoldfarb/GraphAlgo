import java.util.*;
public class Driver{
	public static void main(String [] args){
		
		Graph ug1 = makeGraphOne();
		Graph ug2 = makeGraphTwo();
		Graph ug3 = makeGraphThree();
		Graph ug4 = makeGraphFour();
		Graph ug5 = makeGraphFive();
		Graph dg1 = makeGraphSix();
		Graph dg2 = makeGraphSeven();
		Graph dg3 = makeGraphEight();
		Graph dg4 = makeGraphNine();
		Graph dg5 = makeGraphTen();
		Graph test = ug2;
		print(test);

		//depth_first_search(test);
		
		//is_graph_connected(test);

		//is_graph_two_colorable(test);

		//is_graph_acyclic(test);

		//println(toplogical_sort(test));

		//println(reverse(test));

		//is_graph_strongly_connected(test);

		//println(Arrays.toString(DijkstraShortestPaths(test)));

		println(all_cycles(test));
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
		Graph Three
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


	public static Graph makeGraphFour(){
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
		g.addEdge(1,4);

		g.addEdge(2,3);
		g.addEdge(2,4);
		g.addEdge(2,5);

		g.addEdge(3,4);
		g.addEdge(3,5);
		/*
		*/
		return g;
	}

	public static Graph makeGraphFive(){
		Graph g = new Graph();
		/*
		*/
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		/*
		*/
		g.addEdge(1,4);
		g.addEdge(2,3);
		/*
		*/
		return g;
	}

	/*
		Graph Six
	    {1}<----------{2}
	     | 	           ^
	     |             |
	     |             |
	     |             |
	     |             |
	     |             |
	     v             |
	    {3}---------->{4}
		
		*/
	public static Graph makeGraphSix(){
		Graph g = new Graph();
		/*
		*/
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		/*
		*/
		g.addDirectedEdge(1,3);
		g.addDirectedEdge(3,4);
		g.addDirectedEdge(4,2);
		g.addDirectedEdge(2,1);
		
		return g;
	}

	/*
		Graph Seven
	    {1}           {2}
	     |             ^
	     |             |
	     |             |
	     |             |
	     |             |
	     |             |
	     v             |
	    {3}---------->{4}
		
		*/
	public static Graph makeGraphSeven(){
		Graph g = new Graph();
		/*
		*/
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		/*
		*/
		g.addDirectedEdge(1,3);
		g.addDirectedEdge(3,4);
		g.addDirectedEdge(4,2);
		
		return g;
	}

	/*
		Graph Eight
	    Example from class (Course prereq)
		
		*/
	public static Graph makeGraphEight(){
		Graph g = new Graph();
		/*
		*/
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		g.addVertex(5);
		g.addVertex(6);
		g.addVertex(7);
		g.addVertex(8);
		/*
		*/
		g.addDirectedEdge(1,3);
		g.addDirectedEdge(1,4);
		g.addDirectedEdge(1,5);
		g.addDirectedEdge(2,3);
		g.addDirectedEdge(3,4);
		g.addDirectedEdge(4,5);
		g.addDirectedEdge(4,6);
		g.addDirectedEdge(6,7);
		g.addDirectedEdge(6,8);
		
		return g;
	}

		/*
		Graph Nine
	   4 nodes strongly connected
		
		*/
	public static Graph makeGraphNine(){
		Graph g = new Graph();
		/*
		*/
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		/*
		*/
		g.addDirectedEdge(1,2);
		g.addDirectedEdge(1,3);
		g.addDirectedEdge(1,4);

		g.addDirectedEdge(2,1);
		g.addDirectedEdge(2,3);
		g.addDirectedEdge(2,4);

		g.addDirectedEdge(3,1);
		g.addDirectedEdge(3,2);
		g.addDirectedEdge(3,4);

		g.addDirectedEdge(4,1);
		g.addDirectedEdge(4,2);
		g.addDirectedEdge(4,3);
		
		return g;
	}

	/*
		Graph Ten
	   4 nodes strongly connected with weights
		
		*/
	public static Graph makeGraphTen(){
		Graph g = new Graph();
		/*
		*/
		g.addVertex(1);
		g.addVertex(2);
		g.addVertex(3);
		g.addVertex(4);
		/*
		*/
		g.addDirectedWeightedEdge(1,2,1);
		g.addDirectedWeightedEdge(1,3,2);
		g.addDirectedWeightedEdge(1,4,3);

		g.addDirectedWeightedEdge(2,1,4);
		g.addDirectedWeightedEdge(2,3,5);
		g.addDirectedWeightedEdge(2,4,6);

		g.addDirectedWeightedEdge(3,1,7);
		g.addDirectedWeightedEdge(3,2,8);
		g.addDirectedWeightedEdge(3,4,9);

		g.addDirectedWeightedEdge(4,1,10);
		g.addDirectedWeightedEdge(4,2,11);
		g.addDirectedWeightedEdge(4,3,12);
		
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

	public static void is_graph_acyclic(Graph g){
		CycleTest ct = new CycleTest(g);
		println("Running Cycle Test...");
		ct.test();
		println("Done\n");
	}

	public static ArrayList<Node> toplogical_sort(Graph g){
		TopologicalSort ts = new TopologicalSort(g);
		println("Topologically sorting g...");
		ArrayList<Node> res = ts.sort();
		println("Done");
		return res;
	}

	public static Graph reverse(Graph g){
		GraphReverser gr = new GraphReverser(g);
		println("Reversing g...");
		Graph grev = gr.reverse();
		println("Done");
		return grev;
	}

	public static void is_graph_strongly_connected(Graph g){
		StrongConnectionTest sct = new StrongConnectionTest(g);
		println(sct.test());
	}

	public static int [] dijkstraShortestPaths(Graph g){
		Node source = g.vertice_list.get(0);
		println("SOURCE: " + source);
		Dijkstra d = new Dijkstra(g,source);
		return d.sortestPaths();
	}

	public static ArrayList<ArrayList<Pair>> all_cycles(Graph g){
		CyclePrinter cp = new CyclePrinter(g);
		cp.test();
		return cp.list;
	}

	public static <T> void print(T str){
		System.out.print(str);
	}
	public static <T> void println(T str){
		System.out.println(str);
	}
}