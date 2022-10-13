import java.util.ArrayList;
import java.util.HashMap;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    HashMap<Long, Long> hm = new HashMap<>();

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            long cur = room_number[i];
            long selectedRoom = cur;
            ArrayList<Long> candidate = new ArrayList<>();
            while (hm.containsKey(selectedRoom)) {
                candidate.add(selectedRoom);
                selectedRoom = hm.get(selectedRoom);
            }
            candidate.add(selectedRoom);
            answer[i] = selectedRoom;
            for (long candi : candidate)
                hm.put(candi, selectedRoom+1);
        }
        return answer;
    }
}
