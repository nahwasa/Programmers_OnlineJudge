import java.util.*;

/**
 * 문제 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
 */
class Node {
    int a, b, gap;
    public Node(int a, int b, int gap) {
        this.a = a;
        this.b = b;
        this.gap = gap;
    }
}

class Solution {
    private int[][] land;
    private int height;
    private int[] parents;

    private int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        int h = a > b ? a : b;
        int l = a > b ? b : a;
        parents[h] += parents[l];
        parents[l] = h;
    }

    private int getGroupIdx(int r, int c) {
        return r * land[0].length + c;
    }

    private int getGap(int i1, int j1, int i2, int j2) {
        return Math.abs(land[i1][j1] - land[i2][j2]);
    }

    public int solution(int[][] land, int height) {
        // init
        this.land = land;
        this.height = height;
        parents = new int[land.length * land[0].length];
        Arrays.fill(parents, -1);

        // grouping
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (i != land.length-1 && getGap(i,j,i+1,j) <= height)  union(getGroupIdx(i, j), getGroupIdx(i+1, j));
                if (j != land[0].length-1 && getGap(i,j,i,j+1) <= height)  union(getGroupIdx(i, j), getGroupIdx(i, j+1));
            }
        }

        // make edge between group
        ArrayList<Node> edge = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                int a = find(getGroupIdx(i, j));

                if (j != land[0].length-1) {
                    int b = find(getGroupIdx(i, j+1));
                    if (a != b)  edge.add(new Node(a, b, getGap(i,j,i,j+1)));
                }
                if (i != land.length-1) {
                    int b = find(getGroupIdx(i+1, j));
                    if (a != b)  edge.add(new Node(a, b, getGap(i,j,i+1,j)));
                }
            }
        }

        // sort edge order by gap asc
        Collections.sort(edge, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.gap - o2.gap;
            }
        });

        // solution using mst (minimum spanning tree)
        int sum = 0;
        for (int i = 0; i < edge.size(); i++) {
            int a = find(edge.get(i).a);
            int b = find(edge.get(i).b);
            if (a == b) continue;

            sum += edge.get(i).gap;
            union(a, b);
        }

        return sum;
    }
}
