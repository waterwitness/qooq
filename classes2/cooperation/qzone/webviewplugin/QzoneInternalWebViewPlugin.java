package cooperation.qzone.webviewplugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.util.Map;
import org.json.JSONObject;
import yrk;

public abstract class QzoneInternalWebViewPlugin
{
  public WebViewPlugin a;
  
  public QzoneInternalWebViewPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Object a(String paramString, long paramLong)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(Intent paramIntent, byte paramByte, int paramInt) {}
  
  public void a(WebViewPlugin paramWebViewPlugin)
  {
    this.a = paramWebViewPlugin;
  }
  
  public void a(String paramString, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((this.a != null) && (this.a.mRuntime != null)) {}
    for (CustomWebView localCustomWebView = this.a.mRuntime.a();; localCustomWebView = null)
    {
      if (localCustomWebView != null) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("event", paramString);
          localJSONObject.put("data", paramJSONObject1);
          localJSONObject.put("options", paramJSONObject2);
          paramString = "jsbridge://event/dispatchEvent?p=" + Uri.encode(localJSONObject.toString());
          if (Looper.myLooper() == Looper.getMainLooper())
          {
            localCustomWebView.loadUrl(paramString);
            return;
          }
          localCustomWebView.post(new yrk(this, localCustomWebView, paramString));
          return;
        }
        catch (Exception paramString) {}
      }
      return;
    }
  }
  
  public abstract boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs);
  
  public boolean a(String paramString, long paramLong, Map paramMap)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneInternalWebViewPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */