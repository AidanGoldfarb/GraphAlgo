import java.util.*;
public class Dijkstra{
	Graph g;
	Node source;

	public Dijkstra(Graph g, Node source){
		this.g = g;
		this.source = source;
	}

	public int [] sortestPaths(){
		int [] D = new int [g.V];
		PriorityQueue<Node> pQ = new PriorityQueue<Node>();
		for(int i = 0; i<g.V; i++){//for all v in V
			Node v = g.vertice_list.get(i);
			if(v==source){//if v=s: D[v] = 0
				D[v.value-1] = 0;
			}
			else{//else: D[v] = infinity
				D[v.value-1] = Integer.MAX_VALUE-5000;
			}
			v.distance = D[v.value-1];
			pQ.add(v);//Queue.insert(v,D[v])
		}
		//println(Arrays.toString(D));
		while(pQ.size()!=0){//while Q not empty
			Node v = pQ.poll();//v <- Queue.extractMIN()
			LinkedList<Node> neighbors = g.adj_list.get(v.value-1);
			ListIterator li = neighbors.listIterator(1);
			while(li.hasNext()){//for u=all out neighbors of v
				Node u = (Node)li.next();
				D[u.value-1] = Math.min(D[u.value-1], D[v.value-1] + edgeLength(v,u));//D[u] = min{D[u],D[v]+l(v,u)}
				if(pQ.remove(v)){//Queue.updateKEY(u,D[u])
					v.distance = D[u.value-1];
					pQ.add(v);
				}
			}
		}


		return D;
	}

	public int edgeLength(Node u, Node v){
		//find length between u and v
		//LinkedList<Node> neighbors = g.adj_list.get(u.value);
		for(int i = 0; i<g.E; i++){
			Pair p = g.edge_list.get(i);
			if(p.x == u.value && p.y == v.value){
				//println("WEIGHT: " + p.weight);
				return p.weight;
			}
		}
		return -1;
	}

	public static <T> void print(T str){
		System.out.print(str);
	}
	public static <T> void println(T str){
		System.out.println(str);
	}

}