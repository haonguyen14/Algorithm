import java.util.ArrayList;


public class AdjacencyList {
	public static class Node {
		public ArrayList<Integer> adjacentNodes;
		public int inward;	// inward degree


		public Node() {
			inward = 0;
			adjacentNodes = new ArrayList<Integer>();
		}
	}


	public Node[] list;

	public AdjacencyList(int nodes) {
		this.list = new Node[nodes];
		for(int i = 0; i < nodes; i++)
			this.list[i] = new Node();
	}


	public void insert(int n1, int n2) {
		// n1 -> n2
		this.list[n1].adjacentNodes.add(n2);
		this.list[n2].inward++;
	}


	public ArrayList<Integer> remove(int n) {
		for(int i = 0; i < this.list[n].adjacentNodes.size(); i++)
			this.list[this.list[n].adjacentNodes.get(i)].inward--;

		return this.list[n].adjacentNodes;
	}
}
