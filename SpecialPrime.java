import java.io.*;

public class SpecialPrime {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //자릿수
        DFS(2, 1); // 일의 자리 소수인 2, 3, 5, 7 DFS 실행
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    static void DFS(int num, int leng) {
        if(leng == N) {
            if(isPrime(num))
                System.out.println(num);
            return;
        }
        for(int i = 1; i < 10; i += 2) {
            if(isPrime(num * 10 + i))
                DFS(num * 10 + i, leng + 1);
        }
    }

    static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++)
            if(num % i == 0)
                return false;
        return true;
    }

}
