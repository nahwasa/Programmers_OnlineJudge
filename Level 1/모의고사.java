/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    private static final int[][] ARR = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
    };
    public int[] solution(int[] answers) {
        int[] cnt = new int[3];
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i] == ARR[j][i%ARR[j].length])
                    cnt[j]++;
            }
        }
        int max = 0;
        int maxCnt = 0;
        for (int i = 0; i < 3; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
                maxCnt = 1;
            } else if (max == cnt[i]) {
                maxCnt++;
            }
        }
        int idx = 0;
        int[] answer = new int[maxCnt];
        for (int i = 0; i < 3; i++) {
            if (cnt[i] == max) {
                answer[idx++] = i+1;
            }
        }

        return answer;
    }
}
