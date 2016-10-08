import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class wjl
  implements Runnable
{
  public wjl(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      SwiftBrowserTBSHandler localSwiftBrowserTBSHandler = (SwiftBrowserTBSHandler)this.a.a.a().a(16);
      if (localSwiftBrowserTBSHandler != null) {
        localSwiftBrowserTBSHandler.c();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */