import java.util.*;
public class GraphReverser{
	Graph g;

	public GraphReverser(Graph g){
		this.g = g;
	}

	public Graph reverse(){
		Graph gr = new Graph();
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			Node u = cur.peek();
			gr.addVertex(u.value);
		}
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			Node u = cur.peek();
			ListIterator li = cur.listIterator(1);
			while(li.hasNext()){
				Node v = (Node)li.next();
				//edge u-v
				gr.addDirectedEdge(v.value,u.value);
			}
		}
		return gr;
	}

	public <T> void print(T str){
		System.out.print(str);
	}
	public <T> void println(T str){
		System.out.println(str);
	}
}