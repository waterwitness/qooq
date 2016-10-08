import android.content.Context;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.TbsLogClient;
import mqq.os.MqqHandler;

public class pun
  extends TbsLogClient
{
  public pun(BrowserAppInterface paramBrowserAppInterface, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.e(paramString1, 2, paramString2);
    }
  }
  
  public void i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(paramString1, 2, paramString2);
    }
  }
  
  public void showLog(String paramString)
  {
    if (this.a.c == -1) {
      this.a.c = 0;
    }
    if (this.a.c == 1) {
      this.a.a(BrowserAppInterface.class).post(new puq(this.a, paramString));
    }
  }
  
  public void w(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(paramString1, 2, paramString2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\pun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */