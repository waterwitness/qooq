import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.circle.IGroupObserver;
import java.util.Iterator;
import java.util.LinkedList;

class pvd
  implements Runnable
{
  pvd(pvc parampvc)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((CircleManager.a(this.a.a, false) != 0) && (this.a.a.b != null))
    {
      Iterator localIterator = this.a.a.b.iterator();
      while (localIterator.hasNext()) {
        ((IGroupObserver)localIterator.next()).a(false, 2);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pvd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */