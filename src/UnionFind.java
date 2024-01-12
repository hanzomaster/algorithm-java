import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionFind {
    private final int[] p;
    private final int[] r;

    /**
     * Constructor for UnionFind
     *
     * @param n the number of elements in the set
     */
    public UnionFind(int n) {
        p = new int[n];
        r = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
    }

    /**
     * Find the root of the set containing i
     *
     * @param i the element to find
     * @return the root of the set containing i
     */
    public int find(int i) {
        int parent = p[i];
        if (i == parent) return i;

        // Path compression
        return p[i] = find(parent);
    }

    public void union(int x, int y) {
        int r0 = find(x);
        int r1 = find(y);

        if (r0 == r1) {
            return;
        }

        if (r[r0] > r[r1]) {
            p[r1] = r0;
        } else if (r[r1] > r[r0]) {
            p[r0] = r1;
        } else {
            p[r1] = r0;
            // Increment rank
            r[r0]++;
        }
    }

    /**
     * Count the number of disjoint sets
     *
     * @return the number of disjoint sets
     */
    public int count() {
        List<Integer> parents = new ArrayList<>();
        for (int i = 0; i < p.length; i++) {
            int parent = find(i);
            if (!parents.contains(parent)) {
                parents.add(parent);
            }
        }
        return parents.size();
    }

    @Override
    public String toString() {
        return "p" + Arrays.toString(p) + "\nr" + Arrays.toString(r) + "\n";
    }
}
