import java.io.*;

public class Test {
	public static void main(String[] args) {
		String file = args[0];
		AdjacencyList graph = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			graph = new AdjacencyList(Integer.parseInt(br.readLine()));

			String line;
			while ((line = br.readLine()) != null) {
				String[] strs = line.split(",");
				System.out.println(strs[0] + " " + strs[1]);
				graph.insert(Integer.parseInt(strs[0]) - 1, Integer.parseInt(strs[1]) - 1);
			}

			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		int[] order = TopologicalSort.sort(graph);
		for(int i = 0; i < order.length; i++)
			System.out.print(order[i] + " ");
		System.out.println();
	}
}
