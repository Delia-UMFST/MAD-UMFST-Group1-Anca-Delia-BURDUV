public class Main {
    public static void main(String[] args) {
        boolean[] prim = new boolean[101];

        for (int p = 2; p * p <= 100; ++p) {
            if (!prim[p]) {
                for (int i = p * 2; i <= 100; i += p)
                    prim[i] = true;
            }
        }
        for (int p = 2; p <= 98; p++) {
            if (!prim[p] && !prim[p + 2])
                System.out.println("(" + p + ", " + (p + 2) + ")");
        }
    }
}