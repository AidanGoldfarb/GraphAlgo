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
		setWhite();
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			Node cur_node = cur.peek();
			if(cur_node.color == 1){
				explore(cur_node);
			}
		}
	}


	public void explore(Node n){
		setGray(n);
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
		//n.setColor(3);
		setBlack(n);
	}

	public void setGray(Node n){
		n.setColor(2);
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			ListIterator li = cur.listIterator(1);
			while(li.hasNext()){
				Node temp = (Node)li.next();
				if(temp.value == n.value){
					temp.setColor(2);
				}
			}
		}
	}

	public void setBlack(Node n){
		n.setColor(3);
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			ListIterator li = cur.listIterator(1);
			while(li.hasNext()){
				Node temp = (Node)li.next();
				if(temp.value == n.value){
					temp.setColor(3);
				}
			}
		}
	}

	public void setWhite(){
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			ListIterator li = cur.listIterator(0);
			while(li.hasNext()){
				Node temp = (Node)li.next();
				temp.setColor(1);
			}
		}
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