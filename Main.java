    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices and edges");

        int v = sc.nextInt();
        int e = sc.nextInt();

        Graph graph = new Graph(v);
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
