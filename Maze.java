import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Maze {
    static int N;
    static int M;
    static int[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] lineArry = line.split("");
            for(int j = 0; j < M; j++) {
                input[i][j] = Integer.parseInt(lineArry[j]);
            }
        }

        BFS(0, 0);
        System.out.println(input[N-1][M-1]);
    }
    public static void BFS(int row, int column) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, column});

        boolean[][] visited = new boolean[N][M];
        visited[row][column] = true;

        int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] search = {now[0] + move[i][0], now[1] + move[i][1]};
                if(search[0] > -1 && search[0] < N && search[1] > -1 && search[1] < M) {
                    if (input[search[0]][search[1]] != 0 && !visited[search[0]][search[1]]) {
                        visited[search[0]][search[1]] = true;
                        input[search[0]][search[1]] = input[now[0]][now[1]] + 1;
                        queue.add(search);
                    }
                }
            }
        }
    }
}
