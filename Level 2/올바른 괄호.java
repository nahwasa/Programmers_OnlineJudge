/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    boolean solution(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c=='(') cnt++;
            else cnt--;
            if (cnt<0) return false;
        }
        return cnt==0;
    }
}
