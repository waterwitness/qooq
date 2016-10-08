package ct;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class co
  extends cn
{
  public static final co a = new co(Collections.emptyList(), 0L);
  public final List<ScanResult> b;
  private final long c;
  
  public co(List<ScanResult> paramList, long paramLong)
  {
    this.c = paramLong;
    this.b = new ArrayList(paramList);
  }
  
  public final boolean a(long paramLong1, long paramLong2)
  {
    return paramLong1 - this.c < paramLong2;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */