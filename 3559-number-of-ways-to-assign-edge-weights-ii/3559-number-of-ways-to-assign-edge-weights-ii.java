import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        // Build graph
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int LOG = (int) (Math.log(n) / Math.log(2)) + 1;

        int[][] parent = new int[LOG][n + 1];
        int[] depth = new int[n + 1];

        // DFS using stack
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{1, 0}); // node, parent

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int node = curr[0];
            int par = curr[1];

            parent[0][node] = par;

            for (int nei : graph[node]) {
                if (nei != par) {
                    depth[nei] = depth[node] + 1;
                    stack.push(new int[]{nei, node});
                }
            }
        }

        // Build binary lifting table
        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                parent[j][i] = parent[j - 1][parent[j - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int ancestor = lca(u, v, parent, depth, LOG);

            // Path length (number of edges)
            int k = depth[u] + depth[v] - 2 * depth[ancestor];

            if (k == 0) {
                ans[i] = 0;
            } else {
                ans[i] = modPow(2, k - 1, MOD);
            }
        }

        return ans;
    }

    private int lca(int u, int v, int[][] parent, int[] depth, int LOG) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        // Bring u to same depth as v
        int diff = depth[u] - depth[v];
        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = parent[j][u];
            }
        }

        if (u == v) return u;

        // Lift both together
        for (int j = LOG - 1; j >= 0; j--) {
            if (parent[j][u] != parent[j][v]) {
                u = parent[j][u];
                v = parent[j][v];
            }
        }

        return parent[0][u];
    }

    private int modPow(int base, int exp, int mod) {
        long result = 1;
        long b = base;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * b) % mod;
            }

            b = (b * b) % mod;
            exp >>= 1;
        }

        return (int) result;
    }
}