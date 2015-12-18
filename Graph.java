import edu.princeton.cs.algs4.*;

public class Graph {
    private static class Point {
        private double x, y;
        private Bag<Point> adj;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
           this.adj = new Bag<Point>();
        }

        public void addEdge(Point v) {
            adj.add(v);
        }

        public Iterable<Point> adj() {
            return adj;
        }

        public void drawItself() {
            StdDraw.filledCircle(x, y, 0.5);
        }

        public void drawTo(Point v) {
            StdDraw.line(x, y, v.x, v.y);
        }
    }

    final static private int XMAX = 100, YMAX = 100;
    private Point[] points;
    int V;

    public Graph(int V, int E) {
        this.V = V;
        points = new Point[V];

        for (int i = 0; i < V; i++)
            points[i] = new Point(StdRandom.uniform(0.0, XMAX), StdRandom.uniform(0.0, YMAX));

        for (int i = 0; i < E; i++) 
            points[StdRandom.uniform(V)].addEdge(points[StdRandom.uniform(V)]);
    }

    public void draw() {
        StdDraw.setXscale(0, XMAX);
        StdDraw.setYscale(0, YMAX);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(0.0005);

        for (int i = 0; i < V; i++) {
            points[i].drawItself();
            for (Point v: points[i].adj()) {
                v.drawItself();
                points[i].drawTo(v);
            }
        }
    }

    public static void main(String[] args) {
        int V = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);
        Graph g = new Graph(V, E);
        g.draw();
    }
}
