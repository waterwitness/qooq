import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;

public class xsz
{
  public static final int a = 1;
  private static ArrayList a = new ArrayList(5);
  public static final int b = 2;
  private static final int g = 5;
  public int c;
  public int d;
  public int e;
  public int f;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static xsz a()
  {
    synchronized (a)
    {
      if (a.size() > 0)
      {
        localxsz = (xsz)a.remove(0);
        localxsz.b();
        return localxsz;
      }
      xsz localxsz = new xsz();
      return localxsz;
    }
  }
  
  public static xsz a(int paramInt)
  {
    return a(2, paramInt, 0, 0);
  }
  
  public static xsz a(int paramInt1, int paramInt2)
  {
    return a(1, paramInt1, paramInt2, 0);
  }
  
  public static xsz a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    xsz localxsz = a();
    localxsz.f = paramInt1;
    localxsz.c = paramInt2;
    localxsz.d = paramInt3;
    localxsz.e = paramInt4;
    return localxsz;
  }
  
  public static xsz a(long paramLong)
  {
    if (paramLong == 4294967295L) {
      return null;
    }
    xsz localxsz = a();
    localxsz.c = ExpandableListView.c(paramLong);
    if (ExpandableListView.b(paramLong) == 1)
    {
      localxsz.f = 1;
      localxsz.d = ExpandableListView.d(paramLong);
      return localxsz;
    }
    localxsz.f = 2;
    return localxsz;
  }
  
  private void b()
  {
    this.c = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
  }
  
  public long a()
  {
    if (this.f == 1) {
      return ExpandableListView.b(this.c, this.d);
    }
    return ExpandableListView.c(this.c);
  }
  
  public void a()
  {
    synchronized (a)
    {
      if (a.size() < 5) {
        a.add(this);
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xsz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */