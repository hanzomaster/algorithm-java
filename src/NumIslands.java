public class NumIslands {
    int x;
    int y;
    char[][] g;

    public int numIslands(char[][] grid) {
        // prevent copy during recursion
        g = grid;

        int numIslands = 0;

        y = g.length;
        if (y == 0) return 0;
        x = g[0].length;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (g[i][j] == '1') {
                    dfs(i, j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1') return;
        // visited
        g[i][j] = '0';
        // check all the adjacent sites
        dfs(i + 1, j);
        dfs(i, j + 1);
        dfs(i - 1, j);
        dfs(i, j - 1);
    }
}
