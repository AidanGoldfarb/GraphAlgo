import java.util.*;
public class ConnectionTest{
	Graph g;
	public ConnectionTest(Graph g){
		this.g = g;
	}

	/*
		1 = WHITE
		2 = GRAY
		3 = BLACK
	*/
	public boolean isConnected(){
		setWhite();
		LinkedList<Node> first = g.adj_list.get(0);
		Node first_node = first.peek();

		explore(first_node);

		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			if(cur.size() == 1) return false;
			ListIterator li = cur.listIterator(1);
			while(li.hasNext()){
				Node temp = (Node)li.next();
				if(temp.color == 2){
					return false;
				}
			}
		}
		return true;
	}


	public void explore(Node n){
		setGray(n);
		LinkedList<Node> bucket = getBucket(n.value);
		if(bucket == null) return;

		ListIterator li = bucket.listIterator(1);
		while(li.hasNext()){
			Node v = (Node)li.next();
			int color = v.color;
			if(color == 1){
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
		println("returning null");
		return null;
	}

	public <T> void print(T str){
		System.out.print(str);
	}
	public <T> void println(T str){
		System.out.println(str);
	}
}