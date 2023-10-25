import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DiameterOfTree {
    static int V;
    static ArrayList[] graph;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        graph = new ArrayList[V + 1];
        for(int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            graph[order] =  new ArrayList<>();
            int input = Integer.parseInt(st.nextToken());
            while(input != -1) {
                Edge edge = new Edge(input, Integer.parseInt(st.nextToken()));
                graph[order].add(edge);
                input = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[V + 1];
        distance = new int[V + 1];
        BFS(1);

        int farFromFirstValue = 1;
        for(int i = 1; i < V + 1; i++) {
            if(distance[farFromFirstValue] < distance[i])
                farFromFirstValue = i;
        }

        Arrays.fill(visited, false);
        Arrays.fill(distance, 0);
        BFS(farFromFirstValue);

        int maxValue = 1;
        for(int i = 1; i < V + 1; i++) {
            if(distance[maxValue] < distance[i])
                maxValue = i;
        }

        System.out.println(distance[maxValue]);
    }
    public static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        visited[num] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            ArrayList<Edge> edgeList = graph[now];
            for(Edge edge : edgeList) {
                if(!visited[edge.node]) {
                    visited[edge.node] = true;
                    queue.add(edge.node);
                    distance[edge.node] = distance[now] + edge.cost;
                }
            }
        }
    }
}
class Edge{
    int node;
    int cost;
    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}