import java.util.*;
public class CyclePrinter{
	private Graph g;
	private HashMap<Integer, Integer> status; //node_val -> STATUS
														//  STATUS: 0 = UNVISITED, 1 = RED, 2 = BLUE
	ArrayList<ArrayList<Pair>> list;

	public CyclePrinter(Graph g){
		this.g = g;
		status = new HashMap<Integer,Integer>();
		list = new ArrayList<ArrayList<Pair>>();
	}

	public void test(){
		ArrayList<Pair> c = new ArrayList<Pair>();
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			status.put(cur.peek().value, 0);
		}

		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			if(cur.size() > 1){
				Node cur_node = cur.peek();
				if(status.get(cur_node.value) == 0){
					explore(cur_node,c);
				}
			}
		}
		println("No cycle found");
	}
	public void explore(Node v, ArrayList<Pair> cur){
		status.put(v.value, 1);
		LinkedList<Node> neighbors = getBucket(v.value);
		ListIterator li = neighbors.listIterator(1);
		while(li.hasNext()){
			Node u = (Node)li.next(); //v->u
			Pair cur_edge = new Pair(v.value,u.value);
			Pair ncur_edge = new Pair(u.value,v.value);
			if(check(ncur_edge,cur)){
				cur.add(cur_edge);
			}
			if( (status.get(u.value) == 1) && (u.value != v.parent.value) ){
				list.add(cur);
				cur = new ArrayList<Pair>();
				println("Cycle found\nDone");
				//System.exit(0);
			}
			else if( status.get(u.value) == 0){
				u.parent = v;
				explore(u, cur);
			}
		}
		status.put(v.value, 2);
	}

	public boolean check(Pair p, ArrayList<Pair> l){
		for(int i = 0; i<l.size(); i++){
			Pair cur = l.get(i);
			if(p.x == cur.x && p.y == cur.y){
				return false;
			}
		}
		return true;
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