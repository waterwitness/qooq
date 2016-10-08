import android.os.IBinder.DeathRecipient;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ria
  implements IBinder.DeathRecipient
{
  ria(rhz paramrhz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void binderDied()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("MessengerService$IncomingHandler", 2, "-->binder died");
      MessengerService.a((MessengerService)rhz.a(this.a).get());
      MessengerService.b((MessengerService)rhz.a(this.a).get());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ria.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */