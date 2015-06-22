import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Wee on 2015/5/10.
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 For example,
 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X

 [解题思路]
 刚拿到这个题，首先得想法就是BFS。对于每一个O，扫描其相邻节点，然后标示之，如果一个联通区域中有任何一个O在边界上，
 则保留之，否则清除该联通域。
 小数据可以过，但是大数据提示Memory Limit Exceeded，代码中唯一用到的就是visited这个map，所以，系统期望的方法应该是不需要辅助空间的。

 转换一下思路，真的需要开辟一个map在存储访问信息吗？其实这个可以省掉的，既然已经知道连通区域必须至少一个元素是在四边，那么一开始直接从四边开始扫描就好了，所以无法connect到得元素都是应该被清除的。所以，算法如下：
 1. 从四条边上的O元素开始BFS，所有相连的O都赋个新值，比如‘Y’
 2. 扫描整个数组，所有现存的O元素全部置为X，所有Y元素置为O

 这个思路是从边缘向内部找连通的‘O’的，所以DFS时，就没必要在判断边缘上的字母了，因此DFS中，i 和 j 的条件为：i > 1, i < row - 2; j > 1, j < col - 2。（为什么？如果是 i = 1 时，那么 dfs(board, i - 1,
 j) 就是判断 [0, j] 了，而而边缘上的字母会被遍历判断的，这样就重复判断了，会导致栈溢出）。

 DFS递归太深，容易栈溢出，这个代码可谓险过，最好还是用BFS。

 Flood Fill方法的运用
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        //DFS检查了几遍没发现哪里错了
        int row = board.length;
        int col = board[0].length;
     if (row<3||col<3)return;

        //遍历上层col
        for (int i = 0; i <col ; i++) {
            if (board[0][i]=='O'){
                board[0][i]='Y';
                floodfill(0,i,board);
                //遍历下面
                if (board[row - 1][i] == 'O')
                    board[row - 1][i]='Y';
                floodfill((row - 1), i,board);
            }
        //遍历左边
            for (int j = 0; j <row ; j++) {
                if (board[j][0]=='O'){
                    board[j][0]='Y';
                  floodfill(j,0,board);
         //遍历右边
                if (board[j][col-1]=='O'){
                    board[j][col-1]='Y';
                    floodfill(j,col-1,board);
                }
                }
            }

            //扫描整个数组
            for (int j = 0; j <row ; j++) {
                for (int k = 0; k <col ; k++) {
                    if (board[j][k]=='O'){
                        board[j][k]='X';
                    } else if (board[j][k]=='Y'){
                        board[j][k]='O';
                    }
                }
            }

        }
    }

    private void floodfill(int i, int j,char[][] board) {//DFS把边界的O替换成Y flood fill
        int row = board.length;
        int col = board[0].length;

        // up
        if (i > 1 && board[i - 1][j] == 'O') {
            board[i - 1][j] = 'Y';
            floodfill(i - 1, j, board);
        }
            // below
            if (i < row - 2 && board[i + 1][j] == 'O') {
                board[i + 1][j] = 'Y';
                floodfill(i + 1, j, board);
            }
            // left
            if (j > 1 && board[i][j - 1] == 'O') {
                board[i][j - 1] = 'Y';
                floodfill(i, j - 1, board);
            }
            // right
            if (j < col - 2 && board[i][j + 1] == 'O') {
                board[i][j + 1] = 'Y';
                floodfill( i, j + 1,board);
            }
        }

    public void solve2(char[][] board) {
        //AC DFS
        int row = board.length;
        if (row < 3) return;
        int col = board[0].length;
        if (col < 3) return;

        // first column and last column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '#';
                dfs(board, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                board[i][col - 1] = '#';
                dfs(board, i, col - 1);
            }
        }

        // first row and last row
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '#';
                dfs(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                board[row - 1][j] = '#';
                dfs(board, row - 1, j);
            }
        }

        // change 'O' to 'X', restore '#' to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;

        // up
        if (i > 1 && board[i - 1][j] == 'O') {
            board[i - 1][j] = '#';
            dfs(board, i - 1, j);
        }
        // below
        if (i < row - 2 && board[i + 1][j] == 'O') {
            board[i + 1][j] = '#';
            dfs(board, i + 1, j);
        }
        // left
        if (j > 1 && board[i][j - 1] == 'O') {
            board[i][j - 1] = '#';
            dfs(board, i, j - 1);
        }
        // right
        if (j < col - 2 && board[i][j + 1] == 'O') {
            board[i][j + 1] = '#';
            dfs(board, i, j + 1);
        }
    }

    char[][] board;
    int row;
    int col;
    Queue<Integer> queue = new LinkedList<Integer>();

    public void solve3(char[][] board) {
        //BFS AC
        this.board = board;
        row = board.length;
        if (row < 3) return;
        col = board[0].length;//board可能不存在所以先判断row
        if (col < 3) return;

        // traverse first column and last column
        for (int i = 0; i < row; i++) {
            bfs(i, 0);
            bfs(i, col - 1);
        }

        // traverse first row and last row
        for (int j = 0; j < col; j++) {
            bfs(0, j);
            bfs(row - 1, j);
        }

        // change 'O' to 'X', restore '#' to 'O'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(int i, int j) {
        fill(i, j);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int x = pos / col;
            int y = pos % col;

            fill(x - 1, y);
            fill(x + 1, y);
            fill(x, y - 1);
            fill(x, y + 1);
        }
    }

    public void fill(int i, int j) {
        if (i < 0 || j < 0 || i > row - 1 || j > col - 1) return;
        if (board[i][j] != 'O') return;
        queue.offer(i * col + j);
        board[i][j] = '#';
    }
}
