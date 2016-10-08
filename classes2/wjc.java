import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;

public class wjc
  extends BroadcastReceiver
{
  public wjc(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserTBSHandler", 2, "onReceive qb download report");
    }
    paramContext = SwiftBrowserTBSHandler.a(this.a).getWebView();
    if ((paramContext != null) && (!SwiftBrowserTBSHandler.a(this.a).isFinishing()) && (!SwiftBrowserTBSHandler.a(this.a).i))
    {
      paramContext = paramContext.getX5WebViewExtension();
      if (paramContext != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserTBSHandler", 2, "report qb download");
        }
        paramContext.invokeMiscMethod("HitQBAppDownloadCounts", new Bundle());
      }
      abortBroadcast();
    }
    if (SwiftBrowserTBSHandler.a(this.a) != null)
    {
      SwiftBrowserTBSHandler.a(this.a).unregisterReceiver(SwiftBrowserTBSHandler.a(this.a));
      SwiftBrowserTBSHandler.a(this.a, null);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wjc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */