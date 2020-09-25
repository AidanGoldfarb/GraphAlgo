import java.util.*;
public class Graph{
	int V;
	int E;
	ArrayList<Node> vertice_list;
	ArrayList<Pair> edge_list;
	ArrayList<LinkedList<Node>> adj_list;

	public Graph(){
		V = 0;
		E = 0;
		vertice_list = new ArrayList<Node>();
		edge_list = new ArrayList<Pair>();
		adj_list = new ArrayList<LinkedList<Node>>();
	}

	//not safe atm
	public void addVertex(int nv){
		V++;
		Node n = new Node(nv);
		vertice_list.add(n);

		LinkedList<Node> element = new LinkedList<Node>();
		element.add(n);
		adj_list.add(element);
	}

	//edge x <-> y
	public void addEdge(int xv, int yv){
		Node x = new Node(xv);
		Node y = new Node(yv);
		E++;
		Pair edge = new Pair(xv,yv);
		edge_list.add(edge);
		int x_index = -1;
		int y_index = -1;
		for(int i = 0; i<adj_list.size(); i++){
			LinkedList<Node> element = adj_list.get(i);
			if(xv == element.peek().value){
				x_index = i;
			}
			if(yv == element.peek().value){
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
		return "Vertices: " + vertice_list + " (" +  V + ")" + 
			   "\nEdges: " + edge_list + " (" +  E + ")" +  
			   "\nAdj_List: " + adj_list_string();
	}

	public String adj_list_string(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<adj_list.size(); i++){
			LinkedList<Node> cur = adj_list.get(i);
			sb.append("[" + cur.peek().value + "]  -> ");
			ListIterator li = cur.listIterator(1);
			while(li.hasNext()){
				Node n = (Node)li.next();
				sb.append(n + "(" + n.color + ")" + ",");
			}
			sb.trimToSize();
			sb.deleteCharAt(sb.capacity()-1);
			sb.append("\n\t  ");
		}
		sb.append("\n");
		return sb.toString();
	}

	public static <T> void print(T str){
		System.out.print(str);
	}
	public static <T> void println(T str){
		System.out.println(str);
	}
}