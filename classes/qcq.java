import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class qcq
  implements Runnable
{
  public qcq(PhoneContactManagerImp paramPhoneContactManagerImp)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    EntityTransaction localEntityTransaction = PhoneContactManagerImp.a(this.a).a();
    localEntityTransaction.a();
    try
    {
      Iterator localIterator = PhoneContactManagerImp.a(this.a).values().iterator();
      while (localIterator.hasNext())
      {
        PhoneContact localPhoneContact = (PhoneContact)localIterator.next();
        if (localPhoneContact.isNewRecommend)
        {
          localPhoneContact.isNewRecommend = false;
          localPhoneContact.highLightTimeStamp = System.currentTimeMillis();
          PhoneContactManagerImp.a(this.a).a(localPhoneContact);
        }
      }
    }
    finally
    {
      localEntityTransaction.b();
    }
    localEntityTransaction.b();
    PhoneContactManagerImp.b(this.a, false);
    ThreadManager.b().postDelayed(PhoneContactManagerImp.b(this.a), 180000L);
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact.Manager", 2, "clear recommend badge.");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qcq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */