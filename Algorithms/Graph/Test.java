import java.io.*;

public class Test {
	public static void main(String[] args) {
		/* Create a Graph */
		String path = args[0];
		String line;

		AdjacencyMatrix graph;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			graph = new AdjacencyMatrix(Integer.parseInt(reader.readLine()), Integer.MAX_VALUE);
			while((line = reader.readLine()) != null) {
				String[] elems = line.split(",");
				graph.matrix[Integer.parseInt(elems[0])][Integer.parseInt(elems[1])] = Integer.parseInt(elems[2]);
			}

			reader.close();
			System.out.println(graph + "\n\n");
			System.out.println(Kruskal.MSTKruskal(graph));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

