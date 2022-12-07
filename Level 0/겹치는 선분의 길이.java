/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int solution(int[][] lines) {
        int[] arr = new int[201];
        int answer = 0;
        for (int[] line : lines) {
            int a = line[0] + 100;
            int b = line[1] + 100;
            while (a<=b) {
                if (++arr[a++] == 2) answer++;
            }
        }
        return answer;
    }
}
