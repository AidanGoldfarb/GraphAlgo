import java.util.*;
public class Graph{
	int V;
	int E;
	ArrayList<Integer> vertice_list;
	ArrayList<Pair> edge_list;
	ArrayList<LinkedList<Integer>> adj_list;

	public Graph(){
		V = 0;
		E = 0;
		vertice_list = new ArrayList<Integer>();
		edge_list = new ArrayList<Pair>();
		adj_list = new ArrayList<LinkedList<Integer>>();
	}

	//not safe atm
	public void addVertex(int n){
		V++;
		vertice_list.add(n);

		LinkedList<Integer> element = new LinkedList<Integer>();
		element.add(n);
		adj_list.add(element);
	}

	//edge x <-> y
	public void addEdge(int x, int y){
		E++;
		Pair edge = new Pair(x,y);
		edge_list.add(edge);
		int x_index = -1;
		int y_index = -1;
		for(int i = 0; i<adj_list.size(); i++){
			LinkedList<Integer> element = adj_list.get(i);
			if(x == element.peek()){
				x_index = i;
			}
			if(y == element.peek()){
				y_index = i;
			}
			if(x_index != -1 && y_index != -1) break;
		}
		if(x_index == -1 || y_index == -1) return;

		adj_list.get(x_index).add(y);
		adj_list.get(y_index).add(x);
	}

	@Override
	public String toString(){
		return "Vertices: " + vertice_list + "\nEdges: " + edge_list + "\nAdj_List: " + adj_list_string();
	}

	public String adj_list_string(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<adj_list.size(); i++){
			LinkedList<Integer> cur = adj_list.get(i);
			sb.append("[" + cur.peek() + "] -> ");
			ListIterator li = cur.listIterator(1);
			while(li.hasNext()){
				sb.append(li.next() + ",");
			}
			sb.append("\n\t  ");
		}
		sb.append("\n");
		return sb.toString();
	}
}