import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

public class whl
  implements ThreadExcutor.IThreadListener
{
  public whl(WebViewPlugin paramWebViewPlugin)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a() {}
  
  public void b() {}
  
  public void c()
  {
    this.a.onPostPluginAsyncTask();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\whl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */