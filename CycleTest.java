import java.util.*;
public class CycleTest{
	private Graph g;
	private HashMap<Integer, Integer> status; //node_val -> STATUS
														//  STATUS: 0 = UNVISITED, 1 = RED, 2 = BLUE

	public CycleTest(Graph g){
		this.g = g;
		status = new HashMap<Integer,Integer>();
	}

	public void test(){
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			status.put(cur.peek().value, 0);
		}

		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			if(cur.size() > 1){
				Node cur_node = cur.peek();
				if(status.get(cur_node.value) == 0){
					explore(cur_node);
				}
			}
		}
		println("No cycle found");
	}

	public void explore(Node v){
		status.put(v.value, 1);
		LinkedList<Node> neighbors = getBucket(v.value);
		ListIterator li = neighbors.listIterator(1);
		while(li.hasNext()){
			Node u = (Node)li.next();
			if( (status.get(u.value) == 1) && (u.value == v.parent.value) ){
				println("Cycle found\nDone");
				System.exit(0);
			}
			else if( status.get(u.value) == 0){
				u.parent = v;
				explore(u);
			}
		}
		status.put(v.value, 2);
	}

	public LinkedList<Node> getBucket(int val){
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			if(cur.peek().value == val){
				return cur;
			}
		}
		return null;
	}

	public <T> void print(T str){
		System.out.print(str);
	}
	public <T> void println(T str){
		System.out.println(str);
	}
}