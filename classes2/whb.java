import android.os.SystemClock;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.qphone.base.util.QLog;

public class whb
  implements Runnable
{
  public whb(AbsWebView paramAbsWebView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l1 = SystemClock.uptimeMillis();
    if (this.a.a == null)
    {
      AbsWebView.a(this.a);
      if (QLog.isColorLevel())
      {
        long l2 = SystemClock.uptimeMillis();
        QLog.d("AbsWebView", 2, "initPluginEngine cost= " + (l2 - l1));
      }
    }
    Thread.yield();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */