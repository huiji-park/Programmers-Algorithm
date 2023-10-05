import java.io.*;
import java.util.StringTokenizer;

public class MergeSort2 {
    static long result = 0; //int형이 아닌 long형으로 선언해야 한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine()); //숫자 개수
        int[] input = new int[N]; //입력받은 배열
        int[] tmp = new int[N]; //임시배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(st.nextToken());

        mergeSort(input, tmp, 0, N - 1);

        System.out.print(result);
    }

    static void mergeSort(int[] input, int[] tmp, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(input, tmp, start, middle);
            mergeSort(input, tmp, middle + 1, end);
            merge(input, tmp, start, middle, end);
        }
    }
    static void merge(int[] arr, int[] tmp, int start, int middle, int end) {
        for(int i = start; i <= end; i++)
            tmp[i] = arr[i];

        int indexLeft = start;
        int indexRight = middle + 1;
        int index = start;

        while(indexLeft <= middle && indexRight <= end) {
            if(tmp[indexLeft] < tmp[indexRight])
                arr[index++] = tmp[indexLeft++];
            else {
                arr[index++] = tmp[indexRight++];
                result += middle - indexLeft + 1;
            }
        }
        if(indexLeft > middle)
            while(indexRight <= end)
                arr[index++] = tmp[indexRight++];
        else
            while(indexLeft <= middle)
                arr[index++] = tmp[indexLeft++];
    }

}