/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        HashMap<String, Integer> idToNum = new HashMap<>();
        for (int i = 0; i < n; i++) idToNum.put(id_list[i], i);
        int[] reportCnt = new int[n];
        HashSet<Integer>[] chkDuplicatedReport = new HashSet[n];
        for (int i = 0; i < n; i++) chkDuplicatedReport[i] = new HashSet<>();
        ArrayList<Integer>[] reportNumList = new ArrayList[n];
        for (int i = 0; i < n; i++) reportNumList[i] = new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i]);
            int from = idToNum.get(st.nextToken());
            int to = idToNum.get(st.nextToken());
            if (!chkDuplicatedReport[from].contains(to)) {
                chkDuplicatedReport[from].add(to);
                reportCnt[to]++;
                reportNumList[to].add(from);
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (reportCnt[i] < k) continue;
            for (int from : reportNumList[i]) {
                answer[from]++;
            }
        }

        return answer;
    }
}
