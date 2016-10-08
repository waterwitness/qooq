import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;

public class mci
  implements Runnable
{
  public mci(QQBrowserActivity paramQQBrowserActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SwiftBrowserTBSHandler localSwiftBrowserTBSHandler = (SwiftBrowserTBSHandler)this.a.a.a(16);
    if (localSwiftBrowserTBSHandler != null) {
      localSwiftBrowserTBSHandler.b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */