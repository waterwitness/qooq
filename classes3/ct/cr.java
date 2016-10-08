package ct;

import com.tencent.map.geolocation.TencentDistanceAnalysis;

public final class cr
  implements TencentDistanceAnalysis
{
  public double a;
  public int b;
  public int c;
  
  public final double getConfidence()
  {
    return this.a;
  }
  
  public final int getGpsCount()
  {
    return this.b;
  }
  
  public final int getNetworkCount()
  {
    return this.c;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */