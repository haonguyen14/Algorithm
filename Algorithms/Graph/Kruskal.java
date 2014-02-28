import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.LinkedList;


/**
 *
 */

public class Kruskal {
	private static class Edge {
		public int v1;
		public int v2;

		public int weight;

		public Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		public String toString() {
			return v1 + ", " + v2 + ", " + weight;
		}
	}


	private static class EdgeComparator implements Comparator<Edge> {
		public int compare(Edge e1, Edge e2) {
			return e1.weight - e2.weight;
		}

		public boolean equals(Object obj) {
			return true;
		}
	}
	

	public static AdjacencyMatrix MSTKruskal(AdjacencyMatrix graph) {
		AdjacencyMatrix mst = new AdjacencyMatrix(graph.matrix.length, Integer.MAX_VALUE);

		DisjointSet<Integer> dSet = new DisjointSet<Integer>();

		/* Initialize Disjoint Sets */
		for(int i = 0; i < graph.matrix.length; i++)
			dSet.insert(i);

		/* Create A Priority Queue */
		PriorityQueue<Edge> heap = new PriorityQueue<Edge>(50, new EdgeComparator());
		for(int i = 0; i < graph.matrix.length; i++) {
			for(int j = 0; j < graph.matrix[i].length; j++) {
				heap.add(new Edge(i, j, graph.matrix[i][j]));
			}
		}


		for(Edge e = heap.poll(); e != null; e = heap.poll()) {
			if(dSet.find(e.v1) != dSet.find(e.v2)) {
				dSet.union(e.v1, e.v2);
				System.out.println("Edge: " + e + "\nSet: " + dSet + "\n\n");
				mst.matrix[e.v1][e.v2] = e.weight;
			}
		}

		return mst;
	}
}
