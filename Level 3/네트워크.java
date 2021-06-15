import java.util.Arrays;

class Solution {
    int[][] computers;
    int[] parents;

    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        int h = parents[a] < parents[b] ? a : b;
        int l = parents[a] < parents[b] ? b : a;
        parents[h] += parents[l];
        parents[l] = h;
    }

    private void unionAllComputers() {
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                if (i == j || computers[i][j] == 0) continue;
                union(i, j);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        this.computers = computers;
        parents = new int[n];
        Arrays.fill(parents, -1);
        unionAllComputers();

        int cnt = 0;
        for (int i = 0; i < n; i++)
            if (parents[i] < 0)
                cnt++;

        return cnt;
    }
}
