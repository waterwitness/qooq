import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;

public class qei
  implements Runnable
{
  public qei(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((!this.a.isLogin()) || (this.a.k)) {}
    for (int i = 0;; i = this.a.g())
    {
      if (QLog.isColorLevel()) {
        QLog.d(QQAppInterface.a, 2, String.format("unread: %d islogin: %s isReleased: %s", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.a.isLogin()), Boolean.valueOf(this.a.k) }));
      }
      BadgeUtils.a(QQAppInterface.k(this.a), i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */