// JOHN CYRUS M. YLEAÑA

import java.util.*;

public class AdjacencyMatrixConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        int[][] adjacencyMatrix = new int[vertices][vertices];

        System.out.println("Enter the edges (format: u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacencyMatrix[u][v] = 1; // For an undirected graph, set both adjacencyMatrix[u][v] and adjacencyMatrix[v][u] to 1
            adjacencyMatrix[v][u] = 1;
        }

        System.out.println("Adjacency matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
