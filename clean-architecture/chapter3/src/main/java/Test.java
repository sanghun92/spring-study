import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        new Test().solution("100-200*300-500+20");
//        "-100*-220"

//        System.out.println(new Test().solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
    }

    public int solution(int[][] board) {
        int answer = 0;
        Node node = bfs(board, new int[]{ 0, 0});
        if(node != null) {
            while(node.previous == null) {
                System.out.println(node.row + ", " + node.col);
                node = node.previous;
            }
        }

        return answer;
    }

    private Node bfs(int[][] board, int[] start) {
        int totalRow = board.length;
        int totalCol = board[0].length;
        boolean[][] visited = new boolean[totalRow][totalCol];

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(new Node(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        // (0) 0 1 2 3 4
        // (1) 0 1 2 3 4
        // (2) 0 1 2 3 4
        // up, right, down, left

        int[] rowOffeset = { -1, 0, 1, 0 };
        int[] colOffeset = { 0, 1, 0, -1 };

        while(!nodes.isEmpty()) {
            Node node = nodes.poll();
            if(node.row == totalRow - 1 && node.col == totalCol - 1) {
                return node;
            }

            for(int i=0; i < 4; i++) {
                int nextRow = node.row + rowOffeset[i];
                int nextCol = node.col + colOffeset[i];

                if(nextRow < 0 || nextRow >= totalRow || nextCol < 0 || nextCol >= totalCol) {
                    continue;
                }

                if(visited[nextRow][nextCol] || board[nextRow][nextCol] == 1) {
                    continue;
                }

                visited[nextRow][nextCol] = true;
                nodes.offer(node.next(nextRow, nextCol));
            }
        }

        return null;
    }

    public static class Node {
        private int move;
        private int row;
        private int corner;
        private int col;
        private Node previous;
        private Node next;

        public Node(int row, int col) {
            this.move = 0;
            this.corner = 0;
            this.row = row;
            this.col = col;
        }

        public Node next(int row, int col) {
            Node node = new Node(row, col);
            node.move = this.move + 1;
            node.previous = this;
            this.next = node;

            return node;
        }
    }
}
