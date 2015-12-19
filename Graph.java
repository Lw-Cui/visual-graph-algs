import edu.princeton.cs.algs4.*;
import java.awt.*;

public class Graph {
    private static class Point {
        private int index;
        private double x, y;
        private Bag<Point> adj;

        public Point(double x, double y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
           this.adj = new Bag<Point>();
        }

        public int index() {
            return index;
        }

        public void addEdge(Point v) {
            adj.add(v);
        }

        public Iterable<Point> adj() {
            return adj;
        }

        public void drawItself(Color color, double radius) {
            StdDraw.setPenColor(color);
            StdDraw.filledCircle(x, y, radius);
        }

        public void drawTo(Point v, Color color, double radius) {
            StdDraw.setPenColor(color);
            StdDraw.setPenRadius(radius);
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
            points[i] = new Point(StdRandom.uniform(0.0, XMAX), StdRandom.uniform(0.0, YMAX), i);

        for (int i = 0; i < E; i++) 
            points[StdRandom.uniform(V)].addEdge(points[StdRandom.uniform(V)]);
    }

    public void draw() {
        StdDraw.setXscale(0, XMAX);
        StdDraw.setYscale(0, YMAX);
        StdDraw.setPenRadius(0.0005);

        for (int i = 0; i < V; i++) {
            points[i].drawItself(StdDraw.RED, 0.5);
            for (Point v: points[i].adj()) {
                v.drawItself(StdDraw.RED, 0.5);
                points[i].drawTo(v, StdDraw.RED, 0.0005);
            }
        }
    }

    private boolean[] marked;

    public void depthFirstSearch() {
        StdDraw.setPenRadius(0.005);

        marked = new boolean[V];
        for (int i = 0; i < V; i++)
            marked[i] = false;

        Color color = StdDraw.BLUE;
        for (int i = 0; i < V; i++) {
            dfs(points[i], color);
            color = color.darker().darker();
        }
    }

    private void dfs(Point u, Color color) {
        if (!marked[u.index()]) {
            marked[u.index()] = true;
            u.drawItself(color, 0.7);
            for (Point v: u.adj())
                if (!marked[v.index()]) {
                    u.drawTo(v, color, 0.003);
                    //StdDraw.show(300);
                    dfs(v, color);
                }
        }
    }

    public static void main(String[] args) {
        int V = Integer.parseInt(args[0]);
        int E = Integer.parseInt(args[1]);
        Graph g = new Graph(V, E);
        g.draw();
        g.depthFirstSearch();
    }
}
