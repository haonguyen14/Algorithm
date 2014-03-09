import java.util.Stack;
import java.util.ArrayList;


public class TopologicalSort {
	/**
	 *
	 */
	public static int[] sort(AdjacencyList graph) {
		int[] ret = new int[graph.list.length];
		int curr = 0;

		// Construct a list of no-incoming nodes
		Stack<Integer> tempNodes = new Stack<Integer>();
		for(int i = 0; i < graph.list.length; i++) {
			if(graph.list[i].inward == 0) {
				tempNodes.push(i);
			}
		}

		while(!tempNodes.empty() && curr < ret.length) {
			int node = tempNodes.pop();

			ret[curr++] = node;
			ArrayList<Integer> adjacentNodes = graph.remove(node);
			for(int i = 0; i < adjacentNodes.size(); i++)
				if(graph.list[adjacentNodes.get(i)].inward == 0)
					tempNodes.push(adjacentNodes.get(i));
		}

		if(tempNodes.empty() && curr < ret.length)
			return null;

		return ret;
	}
}
