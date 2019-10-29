package com.monster.learn;

//99.42%
public class CountBattleships {
    public int countBattleships(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int ret = 0;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                if (board[i][j] == 'X') {
                    ret++;
                    for (int k = i+1; k < m; k++) {
                        if (board[k][j] == 'X') {
                            visited[k][j] = true;
                        } else {
                            break;
                        }
                    }
                    for (int k = j+1; k < n; k++) {
                        if (board[i][k] == 'X') {
                            visited[i][k] = true;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }
}