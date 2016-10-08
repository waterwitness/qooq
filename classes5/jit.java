import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jit
  extends Handler
{
  public jit(WebSoPlugin paramWebSoPlugin, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      paramMessage = (Bundle)paramMessage.obj;
      WebSoPlugin.a(this.a, paramMessage);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */