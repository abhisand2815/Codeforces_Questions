import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
 
public class Main {
    static final long INF = 1_000_000_000_000_000_000L;
    static int n, q, x, x2;
    static long[] d;
    static long[] s;
    static long[] tree; // Flattened 1D representation: tree[node * 25 + u * 5 + v]
 
    static void multiplyFlat(int offsetA, int offsetB, int offsetC) {
        for (int i = 0; i < x; i++) {
            int rowA = offsetA + i * x;
            int rowC = offsetC + i * x;
            for (int j = 0; j < x; j++) {
                long minVal = INF;
                for (int k = 0; k < x; k++) {
                    long val = tree[rowA + k] + tree[offsetB + k * x + j];
                    if (val < minVal) {
                        minVal = val;
                    }
                }
                tree[rowC + j] = minVal;
            }
        }
    }
 
    static void getMatrix(int idx, int offset) {
        long d_val = d[idx];
        long s_val = s[idx];
 
        for (int u = 0; u < x; u++) {
            int row = offset + u * x;
            for (int v = 0; v < x; v++) {
                tree[row + v] = INF;
            }
 
            // Option 1: Skip platform completely
            if (d_val + u + 1 <= x) {
                int v = (int) (d_val + u);
                tree[row + v] = 0;
            }
 
            // Option 2: Land on platform
            for (int v = 0; v < x; v++) {
                long qPos = d_val - 1 - v;
                if (qPos >= 0) {
                    long maxP = Math.min((long) (x - 1 - u), qPos);
                    if (maxP >= 0) {
                        long jumps = (qPos - maxP + x - 1) / x;
                        long cost = jumps * s_val;
                        if (cost < tree[row + v]) {
                            tree[row + v] = cost;
                        }
                    }
                }
            }
        }
    }
 
    static void build(int node, int l, int r) {
        if (l == r) {
            getMatrix(l, node * x2);
            return;
        }
        int mid = (l + r) >> 1;
        int lc = node << 1;
        int rc = lc | 1;
        build(lc, l, mid);
        build(rc, mid + 1, r);
        multiplyFlat(lc * x2, rc * x2, node * x2);
    }
 
    static void update(int node, int l, int r, int idx) {
        if (l == r) {
            getMatrix(l, node * x2);
            return;
        }
        int mid = (l + r) >> 1;
        int lc = node << 1;
        int rc = lc | 1;
        if (idx <= mid) {
            update(lc, l, mid, idx);
        } else {
            update(rc, mid + 1, r, idx);
        }
        multiplyFlat(lc * x2, rc * x2, node * x2);
    }
 
    // Static buffer to avoid allocation during queries
    static long[] tempMul = new long[25];
 
    static void queryTree(int node, int l, int r, int ql, int qr, long[] res) {
        if (ql <= l && r <= qr) {
            int offsetB = node * x2;
            for (int i = 0; i < x; i++) {
                int rowA = i * x;
                for (int j = 0; j < x; j++) {
                    long minVal = INF;
                    for (int k = 0; k < x; k++) {
                        long val = res[rowA + k] + tree[offsetB + k * x + j];
                        if (val < minVal) {
                            minVal = val;
                        }
                    }
                    tempMul[rowA + j] = minVal;
                }
            }
            System.arraycopy(tempMul, 0, res, 0, x2);
            return;
        }
        int mid = (l + r) >> 1;
        if (ql <= mid) {
            queryTree(node << 1, l, mid, ql, qr, res);
        }
        if (qr > mid) {
            queryTree((node << 1) | 1, mid + 1, r, ql, qr, res);
        }
    }
 
    public static void main(String[] args) throws Exception {
        FastIO io = new FastIO();
        PrintWriter out = new PrintWriter(System.out);
 
        n = io.nextInt();
        q = io.nextInt();
        x = io.nextInt();
        x2 = x * x;
 
        d = new long[n + 1];
        s = new long[n + 1];
        for (int i = 1; i <= n; i++) d[i] = io.nextLong();
        for (int i = 1; i <= n; i++) s[i] = io.nextLong();
 
        tree = new long[(4 * n + 5) * x2];
        build(1, 1, n);
 
        long[] midMat = new long[25];
        long[] V = new long[5];
        long[] nextV = new long[5];
 
        while (q-- > 0) {
            byte type = io.nextNonSpace();
            if (type == '1') {
                int i = io.nextInt();
                long v = io.nextLong();
                d[i] = v;
                update(1, 1, n, i);
            } else if (type == '2') {
                int i = io.nextInt();
                long y = io.nextLong();
                s[i] = y;
                update(1, 1, n, i);
            } else {
                int l = io.nextInt();
                int r = io.nextInt();
 
                if (l == r) {
                    long jumps = (d[l] - 1 + x - 1) / x;
                    out.println(jumps * s[l]);
                    continue;
                }
 
                Arrays.fill(V, INF);
                if (d[l] <= x) {
                    V[(int) d[l] - 1] = 0;
                }
                for (int v = 0; v < x; v++) {
                    long qPos = d[l] - 1 - v;
                    if (qPos >= 0) {
                        long jumps = (qPos + x - 1) / x;
                        V[v] = Math.min(V[v], jumps * s[l]);
                    }
                }
 
                if (l + 1 <= r - 1) {
                    Arrays.fill(midMat, INF);
                    for (int i = 0; i < x; i++) {
                        midMat[i * x + i] = 0; // Identity matrix
                    }
                    queryTree(1, 1, n, l + 1, r - 1, midMat);
 
                    Arrays.fill(nextV, INF);
                    for (int j = 0; j < x; j++) {
                        for (int i = 0; i < x; i++) {
                            long val = V[i] + midMat[i * x + j];
                            if (val < nextV[j]) {
                                nextV[j] = val;
                            }
                        }
                    }
                    System.arraycopy(nextV, 0, V, 0, x);
                }
 
                long ans = INF;
                for (int u = 0; u < x; u++) {
                    if (V[u] >= INF) continue;
                    long qPos = d[r] - 1;
                    long maxP = Math.min((long) (x - 1 - u), qPos);
                    if (maxP >= 0) {
                        long jumps = (qPos - maxP + x - 1) / x;
                        ans = Math.min(ans, V[u] + jumps * s[r]);
                    }
                }
 
                out.println(ans);
            }
        }
 
        out.flush();
    }
 
    static class FastIO {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
 
        private int readByte() throws Exception {
            if (ptr >= len) {
                ptr = 0;
                len = in.read(buffer);
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
 
        byte nextNonSpace() throws Exception {
            int b = readByte();
            while (b != -1 && b <= ' ') b = readByte();
            return (byte) b;
        }
 
        int nextInt() throws Exception {
            int b = readByte();
            while (b != -1 && b <= ' ') b = readByte();
            int res = 0;
            while (b >= '0' && b <= '9') {
                res = res * 10 + (b - '0');
                b = readByte();
            }
            return res;
        }
 
        long nextLong() throws Exception {
            int b = readByte();
            while (b != -1 && b <= ' ') b = readByte();
            long res = 0;
            while (b >= '0' && b <= '9') {
                res = res * 10 + (b - '0');
                b = readByte();
            }
            return res;
        }
    }
}