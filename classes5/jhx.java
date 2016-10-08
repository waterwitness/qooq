import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.webviewplugin.QzoneWebViewOfflinePlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.WebSoCgiState;

public class jhx
  extends Handler
{
  public jhx(QzoneWebViewOfflinePlugin paramQzoneWebViewOfflinePlugin, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof WebSoCgiService.WebSoCgiState)) {}
    while (paramMessage.what != 204) {
      return;
    }
    this.a.a((WebSoCgiService.WebSoCgiState)paramMessage.obj);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jhx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */