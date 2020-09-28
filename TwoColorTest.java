import java.util.*;
public class TwoColorTest{
	private Graph g;
	public TwoColorTest(Graph g){
		this.g = g;
	}

	/*
		0 = COLOR_1
		1 = COLOR_2
	*/
	private HashSet<Integer> visited = new HashSet<Integer>();
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
		//setVisited(n);
		visited.add(n.value);
		setColor(n,c);
		LinkedList<Node> bucket = getBucket(n.value);
		ListIterator li = bucket.listIterator(1);
		while(li.hasNext()){
			Node v = (Node)li.next();
			if(!visited.contains(v.value)){
				v.parent = n;
				explore(v, 1-c);
			}
			else{
				if(v.color == c){
					println("\nNOT COLORABLE");
					System.exit(0);
				}
			}
		}
	}


	public void setColor(Node n, int c){
		n.setColor(c);
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			ListIterator li = cur.listIterator(1);
			while(li.hasNext()){
				Node temp = (Node)li.next();
				if(temp.value == n.value){
					temp.setColor(c);
				}
			}
		}
	}

	public void setVisited(Node n){
		n.visited = true;
		for(int i = 0; i<g.adj_list.size(); i++){
			LinkedList<Node> cur = g.adj_list.get(i);
			ListIterator li = cur.listIterator(1);
			while(li.hasNext()){
				Node temp = (Node)li.next();
				if(temp.value == n.value){
					temp.visited = true;
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