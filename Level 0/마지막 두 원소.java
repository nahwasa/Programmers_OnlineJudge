/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
import java.util.Arrays;

class Solution {
    int[] numList;

    public int[] solution(int[] num_list) {
        numList = num_list;
        int[] answer = Arrays.copyOf(numList, numList.length+1);
        answer[num_list.length] = lv(1)>lv(2)?lv(1)-lv(2):lv(1)*2;
        return answer;
    }

    private int lv(int last) {
        return numList[numList.length-last];
    }
}
