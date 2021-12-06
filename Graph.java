// package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Graph1 {

    private LinkedList<Integer> adj[];
    private int v;
    private int[][] dir;

    public Graph1(int v) {
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    // A utility function to delete an edge in an undirected graph.
    static void delEdge(Vector<Integer> adj[], int u, int v)
{
// Traversing through the first vector list and removing the second element from it
for (int i = 0; i < adj[u].size(); i++)
{
if (adj[u].get(i) == v)
{
adj[u].remove(i);
}

}

    public void addVertex(int x) {
        int i;
        int n;
        // increasing the number of vertices
        n++;
        int i;

        // initializing the new elements to 0
        for (i = 0; i < n; ++i) {
            int[][] g;
            g[i][n - 1] = 0;
            g[n - 1][i] = 0;
        }
    }

    private void extracted() {
        int i;
    }

    public void removeVertex(int x) {
        int i;
        extracted();
        int n;
        // checking if the vertex is present
        if (x > n) {
            System.out.println("Vertex not present!");
            return;
        } else {
            int i;
            extracted();

            // removing the vertex
            while (x < n) {

                Object[][] g;
                // shifting the rows to left side
                for (i = 0; i < n; ++i) {
                    g[i][x] = g[i][x + 1];
                }

                // shifting the columns upwards
                for (i = 0; i < n; ++i) {
                    g[x][i] = g[x + 1][i];
                }
                x++;
            }

            // decreasing the number of vertices
            n--;
        }
    }

    static int findDegree(Graph G, int ver) {
        int degree = 0;
        for (int i = 0; i < G.v; i++) {
            if (G.dir[ver][i] == 1)
                degree++;
        }

        // below line is to account for self loop in graph check sum of degrees in graph theorem
        if (G.dir[ver][ver] == 1)
            degree++;
        return degree;
    }

    public int bfs(int source, int destination) {

        boolean vis[] = new boolean[adj.length];
        int parent[] = new int[adj.length];
        Queue<Integer> q = new LinkedList<>();

        q.add(source);
        parent[source] = -1;
        vis[source] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == destination)
                break;

            for (int neighbor : adj[cur]) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    q.add(neighbor);
                    parent[neighbor] = cur;
                }
            }
        }

        int cur = destination;
        int distance = 0;

        while (parent[cur] != -1) {
            System.out.print(cur + " -> ");
            cur = parent[cur];
            distance++;
        }

        return distance;
    }

    private boolean dfsUtil(int source, int destination, boolean vis[]) {
        if (source == destination)
            return true;

        for (int neighbor : adj[source]) {
            if (!vis[neighbor]) {
                vis[neighbor] = true;
                boolean isConnected = dfsUtil(neighbor, destination, vis);
                if (isConnected)
                    return true;
            }
        }

        return false;
    }

    public boolean dfsStack(int source, int destination) {
        boolean vis[] = new boolean[adj.length];
        vis[source] = true;
        Stack<Integer> stack = new Stack<>();

        stack.push(source);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (cur == destination)
                return true;

            for (int neighbor : adj[cur]) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }

    public boolean dfs(int source, int destination) {
        boolean vis[] = new boolean[adj.length];
        vis[source] = true;

        return dfsUtil(source, destination, vis);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices and edges");

        int v = sc.nextInt();
        int e = sc.nextInt();

        Graph1 graph = new Graph1(v);
        System.out.println("Enter " + e + " edges");
        for (int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();

            graph.addEdge(source, destination);
        }

        System.out.println("Enter source and destination");

        int source = sc.nextInt();
        int destination = sc.nextInt();

        int distance = graph.bfs(source, destination);
        System.out.println("min distance is " + distance);

        System.out.println("possible " + graph.dfsStack(source, destination));

        sc.close();
    }
}
