public class Node implements Comparable<Node>{
	int value;
	int color;
	Node parent;
	boolean visited;
	int distance;

	public Node(int v){
		this.value = v;
		this.color = -1;
		this.visited = false;
		this.distance = 0;
		//parent = new Node(-1);
	}

	public void setColor(int c){
		color = c;
	}

	@Override
	public String toString(){
		return value+"";
	}

	@Override
	public int compareTo(Node other) {
    	return Integer.compare(this.value, other.value);
	}
}