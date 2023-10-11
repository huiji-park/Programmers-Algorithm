class NumExp {
    public int solution(int n) {
        int cnt = 0;
        int sum = 1;
        int indexLeft = 1;
        int indexRight = 1;

        while(indexLeft <= n && indexRight <= n) {
            if(sum < n)
                sum += ++indexRight;
            else if(sum > n)
                sum -= indexLeft++;
            else {
                cnt++;
                sum += ++indexRight;
                sum -= indexLeft++;
            }
        }
        return cnt;
    }
}