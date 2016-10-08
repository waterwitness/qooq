import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftWebViewHttpBridge;
import com.tencent.qphone.base.util.QLog;

public class wjm
  implements Runnable
{
  public wjm(SwiftWebViewHttpBridge paramSwiftWebViewHttpBridge)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    switch (this.a.f)
    {
    case 2: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("SwiftWebViewHttpBridge", 2, "unsupported mode: " + this.a.f);
      }
      break;
    }
    for (;;)
    {
      this.a.a = (System.currentTimeMillis() - l);
      SwiftWebViewHttpBridge.c(this.a);
      return;
      SwiftWebViewHttpBridge.a(this.a);
      continue;
      SwiftWebViewHttpBridge.b(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */