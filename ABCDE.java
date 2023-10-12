import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABCDE {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 엣지 개수
        graph = new ArrayList<>();
        for(int i = 0; i < N; i++)
            graph.add(i, new ArrayList<>());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());
            graph.get(input1).add(input2);
            graph.get(input2).add(input1);
        }
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            DFS(i, 1);
        }
        System.out.print(0);
    }

    public static void DFS(int num, int depth) {
        if(depth >= 5) {
            System.out.print(1);
            System.exit(0);
        }
        visited[num] = true;
        depth++;
        for(int i : graph.get(num))
            if(!visited[i]) {
                DFS(i, depth);
                visited[i] = false; // 탐색 결과 종료조건에 해당되지 않을 때 visited를 false로 설정해주어야 한다!
            }
    }
}
