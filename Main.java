package day02;


import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    private final static int[][] next = {{-1,0},{0,-1},{1,0},{0,1}};
    private static int N, K, A, B, C;
    private static int[][] map;
    private static int vis[][][];
    private final static int INF = 0x3f3f3f3f;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        K = input.nextInt();
        A = input.nextInt();
        B = input.nextInt();
        C = input.nextInt();

        map = new int[N+1][N+1];
        vis = new int[N+1][N+1][11];
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++) {
                map[i][j] = input.nextInt();
                for(int k = 0; k <= 10; k++) {
                    vis[i][j][k] = INF;
                }
            }
        System.out.println(bfs());
    }
    private static int bfs() {
        Queue<Node> queue = new Queue<>();
        int cnt = INF;
        Node node = new Node(1,1,K,0);
        vis[1][1][K] = 0;
        queue.enqueue(node);
        while(!queue.isEmpty()) {
            Node temp = queue.dequeue();
            for(int i = 0; i < 4; i++) {
                int tx = temp.getX() + next[i][0];
                int ty = temp.getY() + next[i][1];
                int step = temp.getStep() - 1;
                int cost = temp.getCost() + ((i < 2)?B:0);
                if(tx <= 0 || ty <= 0 || tx > N || ty > N) continue;
                if(tx == N && ty == N) {
                    cnt = Math.min(cnt, cost);
                    continue;
                }
                if(map[tx][ty] == 1) {
                    step = K;
                    cost += A;
                    if(vis[tx][ty][step] > cost) {
                        vis[tx][ty][step] = cost;
                        queue.enqueue(new Node(tx,ty,step,cost));
                    }
                    continue;
                }
                if(step <= 0) {
                    step = K;
                    cost += A + C;
                    if(vis[tx][ty][step] > cost) {
                        vis[tx][ty][step] = cost;
                        queue.enqueue(new Node(tx,ty,step,cost));
                    }
                }

            }
            //System.out.println("cnt = " + cnt);
        }
        return cnt;
    }
}

