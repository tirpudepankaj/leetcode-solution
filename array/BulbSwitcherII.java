public class BulbSwitcherII
{
  public int flip(int n, int presses) {
    int val = n >= 3 ? 3 : n;

     if(presses == 0) return 1;

     else if( presses == 1 )  return val == 1 ? 2 : val == 2 ? 3 : 4;

     else if( presses == 2 )  return val == 1 ? 2 : val == 2 ? 4 : 7;

     return val == 1 ? 2 : val == 2 ? 4 : 8;
  }
}
