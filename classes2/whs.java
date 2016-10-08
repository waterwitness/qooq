import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public final class whs
  implements ThreadExcutor.IThreadListener
{
  long a;
  
  public whs()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = 0L;
  }
  
  public void a() {}
  
  public void b()
  {
    this.a = System.currentTimeMillis();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SwiftBrowserCookieMonster", 2, "Web_qqbrowser_pre_get_key, cost=" + (System.currentTimeMillis() - this.a));
    }
    this.a = 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */