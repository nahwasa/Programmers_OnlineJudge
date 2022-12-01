/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= Math.sqrt(n); i++)
            answer += n%i==0?(n/i==Math.sqrt(n)?1:2):0;
        return answer;
    }
}
