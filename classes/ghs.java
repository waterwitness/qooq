import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ghs
  implements Runnable
{
  public ghs(AVNotifyCenter paramAVNotifyCenter)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.b == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.b.keySet().iterator();
      long l;
      while (localIterator.hasNext())
      {
        l = ((Long)localIterator.next()).longValue();
        this.a.a(l, 2, this.a.b(l), false);
        this.a.a(2, l, null, 0L);
        this.a.a(21, 2, l, 0L);
        localIterator.remove();
      }
      localIterator = this.a.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        l = ((Long)localIterator.next()).longValue();
        this.a.a(l, 1, this.a.b(l), false);
        this.a.a(l, 10, 21, 0);
        this.a.a(1, l, null, 0L);
        this.a.a(21, 1, l, 0L);
        localIterator.remove();
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ghs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */