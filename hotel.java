import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        HashMap<Integer, Integer> inAndOut = new HashMap<>();
        int number = 1000;//HashMap으로 만들어 버려서 급히 추가함
        
        for(String[] book : book_time) {
            int in = Integer.parseInt(book[0].replace(":", "") + number++);
            int out = Integer.parseInt(book[1].replace(":", ""));
            
            inAndOut.put(in, out);
        }
        
        List<Integer> keySet = new ArrayList<>(inAndOut.keySet());
        Collections.sort(keySet);
        
        List<Integer> rooms = new ArrayList<>();
        for(int key : keySet) {
            if(rooms.isEmpty()) {//첫번째 예약 처리
                rooms.add(inAndOut.get(key));
                continue;
            }
            Collections.sort(rooms);//일찍 비는 방부터 확인
            int roomSelected = -1;
            for(int room : rooms) {
                if(room % 100 >= 50 ? room + 50 <= key / 10000 : room + 10 <= key / 10000) {//종료 10분 후
                    roomSelected = room;
                    break;
                }
            }
            if(roomSelected == -1) {//해당하는 방이 존재하지 않음
                rooms.add(inAndOut.get(key));
                continue;
            }
            else
                rooms.set(rooms.indexOf(roomSelected), inAndOut.get(key));//퇴실시간으로 업데이트
        }
        
        int answer = rooms.size();
        return answer;
    }
}