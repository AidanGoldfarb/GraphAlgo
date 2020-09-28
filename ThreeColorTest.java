import java.util.*;
public class ThreeColorTest{
	private Graph g;
	private HashSet<Integer> visited;
	public ThreeColorTest(Graph g){
		this.g = g;
		visited = new HashSet<Integer>();
	}

	public boolean test(){
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			if(cur.size() > 1){
				Node cur_node = cur.peek();
				if(!visited.contains(cur_node.value)){
					explore(cur_node, 0);
				}
			}
		}
		return true;
	}

	public void explore(Node n, int c){
		visited.add(n.value);
	}
}