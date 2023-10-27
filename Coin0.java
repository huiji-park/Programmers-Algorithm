import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Coin0 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken()); // 동전의 종류
        int K = Integer.parseInt(st.nextToken()); // 목표 가격
        int[] coins = new int[N];
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        while(K > 0) {
            for(int i = N - 1; i >= 0; i--) {
                if(K < coins[i])
                    continue;
                cnt += K / coins[i];
                K %= coins[i];
            }
        }
        System.out.println(cnt);
    }
}