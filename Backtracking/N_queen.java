// class Solution {

//     List<List<String>> res;

//     public List<List<String>> solveNQueens(int n) {

//         String[][] board = new String[n][n];

//         for (int i = 0; i < n; i++) {

//             Arrays.fill(board[i], ".");
//         }

//         res = new ArrayList<>();

//         int[] left = new int[n];

//         int upperDiagnol[] = new int[2 * n - 1];

//         int lowerDiagnol[] = new int[2 * n - 1];

//         int row = 0;

//         place_Queen(row, left, lowerDiagnol, upperDiagnol, board);

//         return res;
//     }

//     public void place_Queen(int col, int[] left, int[] lowerDiagnol, int[] upperDiagnol, String[][] board) {
//         if (col == left.length) {
//             res.add(construct_result(board));
//             return;
//         }

//         for (int row = 0; row < board.length; row++) {
//             if (placeable(row, col, left, lowerDiagnol, upperDiagnol)) {

//                 board[row][col] = "Q";
//                 left[row] = 1;
//                 lowerDiagnol[row + col] = 1;
//                 upperDiagnol[col - row + left.length - 1] = 1;
//                 place_Queen(col + 1, left, lowerDiagnol, upperDiagnol, board);

//                 board[row][col] = ".";
//                 left[row] = 0;
//                 lowerDiagnol[row + col] = 0;
//                 upperDiagnol[col - row + left.length - 1] = 0;

//             }
//         }

//     }

//     public boolean placeable(int row, int col, int[] left, int[] lowerDiagnol, int[] upperDiagnol) {

//         return (left[row] == 0 && lowerDiagnol[row + col] == 0 && upperDiagnol[left.length - 1 + col - row] == 0) ? true
//                 : false;

//     }

//     public List<String> construct_result(String[][] board) {
//         List<String> list = new ArrayList<>();
//         for (int i = 0; i < board.length; i++) {
//             String current_row = "";
//             for (String ele : board[i]) {
//                 current_row += ele;

//             }
//             list.add(current_row);

//         }

//         return list;
//     }
// }