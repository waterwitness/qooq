import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;

public final class ygf
  implements Runnable
{
  public ygf()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    synchronized ()
    {
      if (QLog.isColorLevel()) {
        QLog.i("qqfav", 2, "notify(sPluginInstalled) qqfav.apk");
      }
      QfavHelper.a().notifyAll();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ygf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */