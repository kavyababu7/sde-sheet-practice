package sde.sheet.practice.recursion;

import java.util.ArrayList;
import java.util.List;

public class MColoring {
    public static void main(String[] args) {
        int N = 4, M = 3;
        List<Integer>[] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList<>();
        }
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);
        int[] color = new int[N];
        solve(G, M, 0, color);
    }

    private static boolean solve(List<Integer>[] G, int M, int idx, int[] color) {
        if (idx == G.length) {
            return true;
        }
        for (int i = 0; i < M; i++) {
            if (isSafeToPlace(idx, G, color, i)) {
                color[idx] = i;
                if (solve(G, M, idx + 1, color)) {
                    return true;
                } else {
                    color[idx] = 0;
                }
            }
        }
        return false;
    }

    private static boolean isSafeToPlace(int node, List<Integer>[] G, int[] color, int col) {
        for (int it : G[node]) {
            if (color[it] == col) return false;
        }
        return true;
    }
}
