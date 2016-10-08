import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import org.json.JSONObject;

public class jis
  extends Handler
{
  public jis(WebSoPlugin paramWebSoPlugin, Looper paramLooper)
  {
    super(paramLooper);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject;
    int i;
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      paramMessage = (Bundle)paramMessage.obj;
      localObject = paramMessage.getString("url");
      if ((paramMessage.getInt("req_state", 0) == 2) && (!TextUtils.isEmpty(WebSoPlugin.a(this.a))) && (!TextUtils.isEmpty(WebSoPlugin.b(this.a))) && (WebSoPlugin.b(this.a).equals(localObject)))
      {
        i = paramMessage.getInt("result_code");
        localObject = new JSONObject();
        if (i != 0) {
          break label158;
        }
      }
    }
    try
    {
      ((JSONObject)localObject).put("code", 0);
      for (;;)
      {
        this.a.callJs(WebSoPlugin.a(this.a) + "(" + ((JSONObject)localObject).toString() + ");");
        return;
        label158:
        ((JSONObject)localObject).put("code", i);
        ((JSONObject)localObject).put("msg", paramMessage.getString("error_message"));
      }
    }
    catch (Exception paramMessage)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */