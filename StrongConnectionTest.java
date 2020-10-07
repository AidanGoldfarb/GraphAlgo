public class StrongConnectionTest{
	Graph g;

	public StrongConnectionTest(Graph g){
		this.g = g;
	}

	public boolean test(){
		//1 mark all as not visited
		//2 explore a single vertex
		//3 check all explored
		//3 reverse g
		//4 repeat 1 and 2 on g reversed
		ConnectionTest ct = new ConnectionTest(g);
		if(!ct.isConnected()){
			return false;
		}
		GraphReverser gr = new GraphReverser(g);
		Graph grev = gr.reverse();
		ConnectionTest ctr = new ConnectionTest(grev);
		return ctr.isConnected();
	}

	// public void explore(Node n){
	// 	n.visited = true;
	// 	LinkedList<Node> bucket = getBucket(n.value);
	// 	if(bucket == null) return;

	// 	ListIterator li = bucket.listIterator(1);
	// 	while(li.hasNext()){
	// 		Node v = (Node)li.next();
	// 		if(v.color == 1){
	// 			v.parent = n;
	// 			explore(v);
	// 		}
	// 	}
	// }
}