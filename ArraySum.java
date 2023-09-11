import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();//수의 개수 N
        int count = scanner.nextInt();//합을 구해야하는 횟수 M
        long total [] = new long[num + 1];//i번째까지 수의 합
        total[0] = 0;
        
        for(int i = 1; i <= num; i++) {
        	total[i] = total[i - 1] + scanner.nextInt();
        }
        
        for(int i = 0; i < count; i++) {
        	long start = total[scanner.nextInt() - 1];
        	long end = total[scanner.nextInt()];
        	System.out.println(end - start);
        }
        
        scanner.close();
    }
}
