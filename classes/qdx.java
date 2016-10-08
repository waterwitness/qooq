import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.MobileQQService;
import mqq.manager.Manager;

public class qdx
  implements Runnable
{
  public qdx(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.a.c();
    int i = 0;
    while (i < QQAppInterface.a(this.a).length)
    {
      Manager localManager = QQAppInterface.a(this.a)[i];
      if (localManager != null) {
        localManager.onDestroy();
      }
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qdx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */