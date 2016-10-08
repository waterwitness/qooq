import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;

public final class xrk
  implements Runnable
{
  public xrk()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if (!BadgeUtilImpl.isEnabled(BaseApplicationImpl.a)) {
        BadgeUtilImpl.disableBadge(BaseApplicationImpl.a);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BadgeUtils", 2, "disableBadge mobileqq", localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xrk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */