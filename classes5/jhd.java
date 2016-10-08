import com.tencent.biz.webviewplugin.KeyInfo;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class jhd
  implements ThreadExcutor.IThreadListener
{
  public jhd(KeyInfo paramKeyInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void b()
  {
    this.a.b = System.currentTimeMillis();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("KeyInfo", 2, "preGetDomainInfo, cost=" + (System.currentTimeMillis() - this.a.b));
    }
    this.a.b = 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */