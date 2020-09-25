import java.util.*;
public class DFS{
	private Graph g;
	public DFS(Graph g){
		this.g = g;
	}


	/*
		1 = WHITE
		2 = GRAY
		3 = BLACK
    */
	public void search(){
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			cur.peek().setColor(1);
		}
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			Node cur_node = cur.peek();
			if(cur_node.color == 1){
				explore(cur_node);
			}
		}
	}


	public void explore(Node n){
		n.setColor(2);
		LinkedList<Node> bucket = getBucket(n.value);
		if(bucket == null) return;

		ListIterator li = bucket.listIterator(1);
		while(li.hasNext()){
			Node v = (Node)li.next();
			if(v.color == 1){
				v.parent = n;
				explore(v);
			}
		}
		n.setColor(3);
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