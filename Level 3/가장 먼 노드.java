import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Solution {
    public int solution(int n, int[][] edge) {
        int[] v = new int[n+1]; //0;not yet visited, <0;distance

        // make adjacent list
        List[] adj = new List[n+1];
        for (int i = 1; i <= n; i++)    adj[i] = new ArrayList<Integer>();
        for (int[] tmp : edge) { adj[tmp[0]].add(tmp[1]);   adj[tmp[1]].add(tmp[0]); }

        // solve
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        v[1] = 1;
        int maxCnt = 0;
        int maxNum = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (v[cur] > maxNum)    { maxCnt = 0; maxNum = v[cur]; }
            if (v[cur] == maxNum)   maxCnt++;
            List<Integer> curAdj = adj[cur];
            for (int i = 0; i < curAdj.size(); i++) {
                int next = curAdj.get(i);
                if (v[next] != 0) continue;
                v[next] = v[cur] + 1;
                q.add(next);
            }
        }
        return maxCnt;
    }
}
