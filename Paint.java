class Paint {
    public int solution(int n, int m, int[] section) {
        int cnt = 0;
        int painted = 0;
        for(int i = 0; i < section.length; i++) {
            if(section[i] < painted)
                continue;
            cnt++;
            painted = section[i] + m;
        }
        return cnt;
    }
}