/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        char last = words[0].charAt(words[0].length()-1);
        HashSet<String> hs = new HashSet<>();
        hs.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i].charAt(0) != last || hs.contains(words[i])) {
                answer[0] = i%n+1;
                answer[1] = i/n+1;
                break;
            }
            last = words[i].charAt(words[i].length()-1);
            hs.add(words[i]);
        }

        return answer;
    }
}
