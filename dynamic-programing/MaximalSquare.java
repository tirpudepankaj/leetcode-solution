public class MaximalSquare
{
  public int maximalSquare(int [][]mat)
  {
    int rows = mat.length;
    int cols = rows > 0 ? mat[0].length : 0;

    int [][]dp = new int[rows + 1][cols + 1];

    int ans = 0;
  
    for(int row = 1; row <= rows; row++ )
    {
      for(int col = 1; col <= cols; col++)
      {
        if(mat[row-1][col-1] == 1)
        {
          dp[row][col] = 1 + Math.min(dp[row-1][col-1], Math.min(dp[row-1][col], dp[row][col-1]));
          ans = Math.max(ans, dp[row][col]);
        } 
      }
    }

    return ans * ans;
  }
}
