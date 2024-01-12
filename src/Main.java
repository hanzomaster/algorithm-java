public class Main {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(8);
        uf.union(1, 2);
        uf.union(3, 2);
        System.out.println(uf);
    }
}
