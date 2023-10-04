import java.io.*;
import java.util.StringTokenizer;

public class MergeSort {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int N = Integer.parseInt(br.readLine()); //숫자 개수
        int[] input = new int[N]; //입력받은 배열

        for(int i = 0; i < N; i++)
            input[i] = Integer.parseInt(br.readLine());

        mergeSort(input);

        for(int i : input)
            bw.write(i + "\n");
        bw.flush();
        bw.close();
    }

    static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }
    static void mergeSort(int[] input, int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(input, arr, start, middle);
            mergeSort(input, arr, middle + 1, end);
            merge(input, arr, start, middle, end);
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
            else
                arr[index++] = tmp[indexRight++];
        }
        if(indexLeft > middle)
            while(indexRight <= end)
                arr[index++] = tmp[indexRight++];
        else
            while(indexLeft <= middle)
                arr[index++] = tmp[indexLeft++];
    }

}