import java.io.*;
import java.util.*;

public class DFSAndBFS{

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 엣지 개수
        int start = Integer.parseInt(st.nextToken()); // 시작점
        graph = new ArrayList<>();
        for(int i = 0; i < N + 1; i++)
            graph.add(i, new ArrayList<>());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());
            graph.get(input1).add(input2); // 양방향
            graph.get(input2).add(input1);
        }
        for(ArrayList list : graph) // 정렬 필요
            if(!list.isEmpty())
                list.sort(new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return (int) o1 - (int) o2;
                    }
                });
        visited = new boolean[N + 1];
        DFS(start);
        System.out.println();
        Arrays.fill(visited, false);
        queue = new LinkedList<>();
        BFS(start);
    }
    public static void DFS(int num) {
        visited[num] = true;
        System.out.print(num + " ");
        for(int i : graph.get(num))
            if(!visited[i])
                DFS(i);
    }
    public static void BFS(int num) {
        queue.add(num);
        visited[num] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for(int i : graph.get(now))
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
        }
    }
}