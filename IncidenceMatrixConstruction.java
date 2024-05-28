// JOHN CYRUS M. YLEAÑA

import java.util.*;

public class IncidenceMatrixConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();

        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        int[][] incidenceMatrix = new int[vertices][edges];

        System.out.println("Enter the edges (format: u v):");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            incidenceMatrix[u][i] = 1;
            incidenceMatrix[v][i] = 1;
        }

        System.out.println("Incidence matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < edges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
