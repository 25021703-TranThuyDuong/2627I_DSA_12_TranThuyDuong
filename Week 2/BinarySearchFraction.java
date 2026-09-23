public class BinarySearchFraction {

    static boolean lessThan(double target, double x) {
        return target < x;
    }

    static void findFraction(double target, int N) {

        double lo = 0.0;
        double hi = 1.0;

        int questions = (int) Math.ceil(2 * Math.log(N) / Math.log(2)) + 1;

        for (int i = 0; i < questions; i++) {

            double mid = (lo + hi) / 2.0;

            if (lessThan(target, mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        // Tìm phân số duy nhất p/q nằm trong khoảng [lo, hi]
        for (int q = 1; q < N; q++) {

            int p = (int) Math.round(target * q);

            if (p > 0 && p < q) {

                double fraction = (double) p / q;

                if (fraction >= lo && fraction <= hi) {
                    System.out.println("Fraction = " + p + "/" + q);
                    System.out.println("Questions = " + questions);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {

        int N = 100;

        double target = 37.0 / 73.0;

        findFraction(target, N);
    }
}