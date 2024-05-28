// JOHN CYRUS M. YLEAÑA
import java.util.*;

public class BipartiteGraph {
    private int V;
    private List<List<Integer>> adjList;

    public BipartiteGraph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public boolean isBipartite() {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!isBipartiteUtil(i, color))
                    return false;
            }
        }
        return true;
    }

    private boolean isBipartiteUtil(int src, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        color[src] = 1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adjList.get(u)) {
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                } else if (color[v] == color[u])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices in the graph: ");
        int V = scanner.nextInt();
        System.out.print("Enter the number of edges in the graph: ");
        int E = scanner.nextInt();

        BipartiteGraph graph = new BipartiteGraph(V);
        System.out.println("Enter the edges (vertex1 vertex2):");
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        if (graph.isBipartite())
            System.out.println("The graph is bipartite.");
        else
            System.out.println("The graph is not bipartite.");
    }
}
