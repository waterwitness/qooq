import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
import java.util.Iterator;
import java.util.LinkedList;

public class qbw
  implements Runnable
{
  public qbw(PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized (PhoneContactManagerImp.a(this.a))
    {
      try
      {
        Iterator localIterator = PhoneContactManagerImp.a(this.a).iterator();
        while (localIterator.hasNext()) {
          ((PhoneContactManager.IPhoneContactListener)localIterator.next()).b(this.a.a);
        }
        localObject = finally;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */