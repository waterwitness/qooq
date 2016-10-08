package ct;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class bt
{
  private static final Comparator<ScanResult> d = new Comparator() {};
  CopyOnWriteArrayList<ScanResult> a;
  long b;
  long c;
  
  bt()
  {
    this.a = new CopyOnWriteArrayList();
    this.b = 0L;
  }
  
  bt(List<ScanResult> paramList, long paramLong1, long paramLong2)
  {
    this.a = new CopyOnWriteArrayList(paramList);
    this.a = a(this.a);
    this.b = paramLong1;
    this.c = paramLong2;
  }
  
  private static CopyOnWriteArrayList<ScanResult> a(CopyOnWriteArrayList<ScanResult> paramCopyOnWriteArrayList)
  {
    try
    {
      Object localObject = new ArrayList(paramCopyOnWriteArrayList);
      Collections.sort((List)localObject, d);
      localObject = new CopyOnWriteArrayList((Collection)localObject);
      return (CopyOnWriteArrayList<ScanResult>)localObject;
    }
    catch (Exception localException)
    {
      return paramCopyOnWriteArrayList;
    }
    catch (Error localError) {}
    return paramCopyOnWriteArrayList;
  }
  
  public final void a(List<ScanResult> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    this.a = a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ct\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */