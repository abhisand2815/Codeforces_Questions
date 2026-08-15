import java.io.*;
import java.util.*;
 
public class Main {
    static BufferedReader br;
    static PrintWriter pw;
    static List<Integer>[] g;
 
    static String query(List<Integer> a) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("? ").append(a.size());
        for (int v : a) sb.append(' ').append(v + 1);
        pw.println(sb.toString());
        pw.flush();
        return br.readLine().trim();
    }
 
    // Returns the subset of b adjacent to independent set a.
    // Requires: a is independent, b has no internal edges.
    static List<Integer> work(List<Integer> a, List<Integer> b) throws IOException {
        List<Integer> r = new ArrayList<>();
        if (a.isEmpty() || b.isEmpty()) return r;
        List<Integer> s = new ArrayList<>(a.size() + b.size());
        s.addAll(a);
        s.addAll(b);
        String t = query(s);
        for (int i = 0; i < b.size(); i++) {
            if (t.charAt(i + a.size()) == '0') r.add(b.get(i));
        }
        return r;
    }
 
    // Finds ALL edges between independent set a and b (every b has >=1 neighbor in a).
    static void find(List<Integer> a, List<Integer> b) throws IOException {
        if (a.isEmpty() || b.isEmpty()) return;
        if (a.size() == 1) {
            int u = a.get(0);
            for (int v : b) {
                g[v].add(u);
                g[u].add(v);
            }
            return;
        }
        int m = a.size() / 2;
        List<Integer> a1 = new ArrayList<>(a.subList(0, m));
        List<Integer> a2 = new ArrayList<>(a.subList(m, a.size()));
        List<Integer> p1 = work(a1, b);
        Set<Integer> vis = new HashSet<>(p1);
        List<Integer> nb = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        for (int v : b) {
            if (vis.contains(v)) nb.add(v);
            else p2.add(v);
        }
        find(a1, p1);
        p2.addAll(work(a2, nb));
        find(a2, p2);
    }
 
    // Finds all edges of the induced forest on vertex set a.
    static void dfs(List<Integer> a) throws IOException {
        if (a.size() <= 1) return;
        String t = query(a);
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (t.charAt(i) == '0') p2.add(a.get(i));
            else p1.add(a.get(i));
        }
        dfs(p2);
 
        int n = g.length;
        int[] col = new int[n];
        Arrays.fill(col, -1);
        List<List<Integer>> b = new ArrayList<>();
        b.add(new ArrayList<>());
        b.add(new ArrayList<>());
        for (int w : p2) {
            if (col[w] == -1) {
                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.add(w);
                col[w] = 0;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    b.get(col[u]).add(u);
                    for (int v : g[u]) {
                        if (col[v] == -1) {
                            col[v] = col[u] ^ 1;
                            q.add(v);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            find(b.get(i), work(b.get(i), p1));
        }
    }
 
    static void solve() throws IOException {
        int n = Integer.parseInt(br.readLine().trim());
        g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
 
        List<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) a.add(i);
        dfs(a);
 
        pw.println("!");
        for (int u = 0; u < n; u++) {
            for (int v : g[u]) {
                if (v > u) pw.println((u + 1) + " " + (v + 1));
            }
        }
        pw.flush();
    }
 
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) solve();
        pw.flush();
    }
}