import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ConnectedComponents {
    static int N;
    static int M;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수

        graph = new ArrayList<>(); // 그래프 인접 리스트(0부터 N-1까지)
        for(int i = 0; i < N; i++)
            graph.add(i, new ArrayList<>());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            add(graph, x - 1, y - 1); // 1부터 N까지의 정점 => 0부터 N-1까지
        }
        visited = new boolean[N]; // 방문 기록 저장 배열(0부터 N-1까지)
        int cnt = 0; // 연결 요소 개수

        for(int i = 0; i < N; i++) {
            if(visited[i])
                continue;
            cnt++;
            DFS(i);
        }
        System.out.print(cnt);
    }

    static void DFS(int now) {
        visited[now] = true;
        for(Integer i : graph.get(now))
            if(!visited[i])
                DFS(i);
    }

    static void add(ArrayList<ArrayList<Integer>> graph, int x, int y) { // 양방향 연결
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
}
