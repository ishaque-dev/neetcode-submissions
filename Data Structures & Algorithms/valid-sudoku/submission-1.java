class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        Set<Character>[] rowSet = new HashSet[N];
        Set<Character>[] columnSet = new HashSet[N];
        Set<Character>[] boxSet = new HashSet[N];
        for (int i = 0; i < N; i++) {
            rowSet[i] = new HashSet<>();
            columnSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                char ch = board[row][column];
                if (ch == '.') {
                    continue;
                }
                if (rowSet[row].contains(ch)) {
                    return false;
                }
                rowSet[row].add(ch);
                if (columnSet[column].contains(ch)) {
                    return false;
                }
                columnSet[column].add(ch);
                int boxIndex = (row / 3) * 3 + (column / 3);
                if (boxSet[boxIndex].contains(ch)) {
                    return false;
                }
                boxSet[boxIndex].add(ch);

            }
        }
        return true;
    }
}
