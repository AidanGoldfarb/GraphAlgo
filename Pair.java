public class Pair implements Comparable<Pair>{
	int x,y,weight;

	public Pair(int x, int y){
		this.x = x;
		this.y = y;
		this.weight = 1;
	}

	public Pair(int x, int y, int weight){
		this.x = x;
		this.y = y;
		this.weight = weight;
	}

	@Override
	public String toString(){
		return "{" + x + "," + y + "}";
	}

	@Override
	public int compareTo(Pair other) {
    	return Integer.compare(this.weight, other.weight);
	}
}