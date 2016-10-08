package st;

import android.os.SystemClock;

class o
{
  final int i;
  final long j;
  final long k;
  
  o(int paramInt)
  {
    this(paramInt, System.currentTimeMillis(), SystemClock.elapsedRealtime());
  }
  
  private o(int paramInt, long paramLong1, long paramLong2)
  {
    this.i = paramInt;
    this.j = paramLong1;
    this.k = paramLong2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\st\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */