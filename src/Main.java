public class Main {
    public static void main(String[] args) {
        int[][] isConnected = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        findCircleNum(isConnected);
    }

    // https://leetcode.com/problems/number-of-provinces/
    public static int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, visited, isConnected, n);
            }
        }
        return provinces;
    }

    private static void dfs(int i, boolean[] visited, int[][] isConnected, int isConnectedLength) {
        visited[i] = true;
        for (int j = 0; j < isConnectedLength; j++)
            if (j != i && !visited[j] && isConnected[i][j] == 1) dfs(j, visited, isConnected, isConnectedLength);
    }
}
