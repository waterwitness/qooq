import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;

class jiv
  implements Runnable
{
  jiv(jiu paramjiu)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.a.mRuntime != null) && (this.a.a.mRuntime.a() != null)) {}
    try
    {
      this.a.a.a(this.a.a.mRuntime.a());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("WebSoPlugin", 1, "asynJudgmentDynamicCover, useSoftwareMode err, ExceptionMsg = " + localThrowable.getMessage());
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jiv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */