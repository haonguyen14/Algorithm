public class AdjacencyMatrix {
	public int[][] matrix;


	public AdjacencyMatrix(int size, int initValue) {
		this.matrix = new int[size][size];
		for(int i = 0 ; i < size; i++)
			for(int j = 0; j < size; j++)
				this.matrix[i][j] = initValue;
	}


	public String toString() {
		String ret = "";

		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++)
				ret += (matrix[i][j] + "\t");
			ret += "\n";
		}

		return ret;
	}
}
