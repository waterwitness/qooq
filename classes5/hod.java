import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class hod
  implements Runnable
{
  public hod(CustomWebView paramCustomWebView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(CustomWebView.c, 2, "webview real destroy now");
    }
    CustomWebView.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */