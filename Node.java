public class Node{
	int value;
	int color;
	Node parent;

	public Node(int v){
		value = v;
		color = -1;
		//parent = new Node(-1);
	}

	public void setColor(int c){
		color = c;
	}

	@Override
	public String toString(){
		return value+"";
	}
}