import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;

public class wje
  implements Runnable
{
  public wje(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SwiftBrowserTBSHandler.a(this.a, MsfSdkUtils.insertMtype("Web", SwiftBrowserTBSHandler.a(this.a)), 0);
    synchronized (SwiftBrowserTBSHandler.a(this.a))
    {
      SwiftBrowserTBSHandler.a(this.a, Boolean.valueOf(true));
      SwiftBrowserTBSHandler.a(this.a).notifyAll();
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wje.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */