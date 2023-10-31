import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MeetingRoom {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine()); // 회의의 개수
        List<Meeting> meetingList = new ArrayList<>();
        Meeting meeting;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            meetingList.add(meeting);
        }
        int count = 0;
        int endTime;
        meetingList.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end == o2.end)
                    return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });
        endTime = meetingList.get(0).end;
        count++;
        for(int i = 1; i < meetingList.size(); i++) {
            if(meetingList.get(i).start >= endTime) {
                endTime = meetingList.get(i).end;
                count++;
            }
        }
        System.out.println(count);
    }
}
class Meeting {
    int start;
    int end;
    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}