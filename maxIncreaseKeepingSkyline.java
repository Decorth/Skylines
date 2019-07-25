/*
* 2 dimensional array
* need nested for loop to traverse
* Need to find the two arrays that the skyline are viewed from each dimension
*
* viewed from top or bottom: [n, j, k, l]
* viewed from left or right: [x, y, z, m]
*
* [[b, b, b, b]
    [b, b, b, b]
    [b, b, b, b]
    [b, b, b, b]]
* the array elements to check for top or bottom: max([0][0], [1][0], [2][0], [3][0])
* and max([0][1], [1][1], [2][1] etc) etc
* [i][j]
*
* for i until n (n is amount of columns and rows)
*   for j until n
*     if [i][j] > max1
*        then max1 = [i][j]
*   toporbottom[i] = max1;
*
*
* the array elements to check for left to right: max([0][0],[0][1] etc) and max([1][0], [1][1])
*/

public int maxIncreaseKeepingSkyline(int[][] grid) {
    int n = grid.length;
    int[] topbottom = new int[n];
    int[] leftright = new int[n];
    int i, j;
    int count = 0;

    // first get the skylines
    for (i = 0; i < n; i++){
      for (j = 0; j < n; j++){
        topbottom[i] = Math.max(topbottom[i], grid[i][j]);
        leftright[i] = Math.max(leftright[j], grid[i][j]);
      }
    }
    // We now have the skylines

    for (i = 0; i < n; i++){
      for (j = 0; j < n; j++){
        count += Math.min(topbottom[i], leftright[i]) - grid[i][j];
        }
    }
    return count;
}
