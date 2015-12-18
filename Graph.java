import edu.princeton.cs.algs4.*;

public class Graph {
    public static void main(String[] args) {

        int N = 1000;
        int XMAX = 100, YMAX = 100;

        int[] x = new int[N], y = new int[N];
        
        for (int i = 0; i < N; i++) {
            x[i] = StdRandom.uniform(0, XMAX);
            y[i] = StdRandom.uniform(0, YMAX);
        }

        StdDraw.setXscale(0, XMAX);
        StdDraw.setYscale(0, YMAX);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.0005);

        for (int i = 0; i < N; i++) {
            StdDraw.filledCircle(x[i], y[i], 0.5);

            if (StdRandom.bernoulli(0.8) && i != 0) {
                int nx = StdRandom.uniform(i);
                //StdDraw.line(x[i], y[i], x[nx], y[nx]);
                StdDraw.line(x[i], y[i], x[0], y[0]);
            }
            //StdDraw.show(500);
        }
    }
}
