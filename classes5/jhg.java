import com.tencent.biz.webviewplugin.KeyInfo;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class jhg
  implements ThreadExcutor.IThreadListener
{
  public jhg(KeyInfo paramKeyInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void b()
  {
    this.a.a = System.currentTimeMillis();
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("KeyInfo", 2, "Web_qqbrowser_pre_get_key, cost=" + (System.currentTimeMillis() - this.a.a));
    }
    this.a.a = 0L;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */