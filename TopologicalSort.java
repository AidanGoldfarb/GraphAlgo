import java.util.*;
public class TopologicalSort{
	Graph g;
	public TopologicalSort(Graph g){
		this.g = g;
	}

	public ArrayList<Node> sort(){
		ArrayList<Node> res = new ArrayList<Node>();
		while(g.V > 0){
			Node v = findIndegreeZero();//find node with indegree 0
			res.add(v);//add to list
			g.remove(v);//remove node from graph
		}
		return res;
	}

	public Node findIndegreeZero(){
		HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			map.put(cur.peek().value, false);
		}

		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			ListIterator li = cur.listIterator(1);
			while(li.hasNext()){
				Node v = (Node)li.next();
				map.put(v.value, true);
			}
		}
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			if((Boolean)pair.getValue() == false){
				return new Node((Integer)pair.getKey());
			}
			it.remove();
		}
		println("returing null");
		return null;
	}

	public static <T> void print(T str){
		System.out.print(str);
	}
	public static <T> void println(T str){
		System.out.println(str);
	}
}