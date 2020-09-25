public class Driver{
	public static void main(String [] args){
		Graph g = new Graph();
		g.addVertex(1);
		g.addVertex(2);
		g.addEdge(1,2);
		print(g);
	}

	public static <T> void print(T str){
		System.out.print(str);
	}
	public static <T> void println(T str){
		System.out.println(str);
	}
}