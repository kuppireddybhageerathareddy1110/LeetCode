from typing import List
from collections import defaultdict
import math

class Solution:
    def assignEdgeWeights(self, edges: List[List[int]], queries: List[List[int]]) -> List[int]:
        MOD = 10**9 + 7
        n = len(edges) + 1

        # Build graph
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)

        LOG = math.ceil(math.log2(n)) + 1

        # Binary lifting tables
        parent = [[0] * (n + 1) for _ in range(LOG)]
        depth = [0] * (n + 1)

        # DFS to compute depth and immediate parent
        stack = [(1, 0)]
        while stack:
            node, par = stack.pop()
            parent[0][node] = par

            for nei in graph[node]:
                if nei != par:
                    depth[nei] = depth[node] + 1
                    stack.append((nei, node))

        # Build binary lifting table
        for j in range(1, LOG):
            for i in range(1, n + 1):
                parent[j][i] = parent[j - 1][parent[j - 1][i]]

        # LCA function
        def lca(u, v):
            if depth[u] < depth[v]:
                u, v = v, u

            # Lift u to same depth
            diff = depth[u] - depth[v]
            for j in range(LOG):
                if diff & (1 << j):
                    u = parent[j][u]

            if u == v:
                return u

            # Lift both together
            for j in range(LOG - 1, -1, -1):
                if parent[j][u] != parent[j][v]:
                    u = parent[j][u]
                    v = parent[j][v]

            return parent[0][u]

        ans = []

        for u, v in queries:
            ancestor = lca(u, v)

            # Number of edges in path
            k = depth[u] + depth[v] - 2 * depth[ancestor]

            if k == 0:
                ans.append(0)
            else:
                ans.append(pow(2, k - 1, MOD))

        return ans