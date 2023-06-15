/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    private static final int INF = 1000001;

    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int idx = 0;

        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];

            int result = INF;
            for (int i = s; i <= e; i++) {
                if (arr[i] <= k || arr[i] >= result) continue;

                result = arr[i];
            }

            answer[idx++] = result == INF ? -1 : result;
        }

        return answer;
    }
}
