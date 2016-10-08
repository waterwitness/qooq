import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import java.util.Iterator;
import java.util.LinkedList;

public class pvf
  implements Runnable
{
  public pvf(CircleManager paramCircleManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.b != null)
    {
      Iterator localIterator = this.a.b.iterator();
      while (localIterator.hasNext()) {
        ((IGroupObserver)localIterator.next()).a(true, 3);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */