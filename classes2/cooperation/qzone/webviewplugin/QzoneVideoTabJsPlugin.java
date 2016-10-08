package cooperation.qzone.webviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.remote.logic.WebEventListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yrw;
import yrx;
import yry;

public class QzoneVideoTabJsPlugin
  extends QzoneInternalWebViewPlugin
  implements WebEventListener
{
  public static final String a = "Qzone";
  private String b;
  private String c;
  
  public QzoneVideoTabJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = QzoneVideoTabJsPlugin.class.getSimpleName();
  }
  
  private void a(String paramString)
  {
    try
    {
      QLog.i(this.b, 1, "getLocalProxyUrl. json=" + paramString);
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getJSONArray("playList");
      localObject = ((JSONObject)localObject).getString("callback");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.c = ((String)localObject);
      }
      localObject = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        ((ArrayList)localObject).add(paramString.getJSONObject(i).getString("url"));
        localArrayList.add(paramString.getJSONObject(i).getString("vid"));
        i += 1;
      }
      if (((ArrayList)localObject).size() > 0) {
        this.a.mRuntime.a().a(QzoneVideoTabJsPlugin.class).post(new yrw(this, (ArrayList)localObject, localArrayList));
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void b()
  {
    this.a.mRuntime.a().a(QzoneVideoTabJsPlugin.class).post(new yry(this));
  }
  
  private void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getJSONArray("state");
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        localArrayList1.add(localJSONObject.getString("url"));
        localArrayList2.add(localJSONObject.getString("state"));
        i += 1;
      }
      if (localArrayList1.size() > 0) {
        this.a.mRuntime.a().a(QzoneVideoTabJsPlugin.class).post(new yrx(this, localArrayList1, localArrayList2));
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a()
  {
    RemoteHandleManager.a().b(this);
    super.a();
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!paramString2.equals("Qzone")) || (this.a == null) || (this.a.mRuntime == null)) {
      return false;
    }
    if (("videoProxyGetLocalProxyURL".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      RemoteHandleManager.a().a(this);
      a(paramVarArgs[0]);
      return true;
    }
    if (("videoProxySetPlayState".equals(paramString3)) && (paramVarArgs != null) && (paramVarArgs.length >= 1))
    {
      RemoteHandleManager.a().a(this);
      b(paramVarArgs[0]);
      return true;
    }
    if ("videoProxyStopAll".equals(paramString3))
    {
      RemoteHandleManager.a().a(this);
      b();
      return true;
    }
    return false;
  }
  
  public void onWebEvent(String paramString, Bundle paramBundle)
  {
    if ((paramBundle == null) || (!paramBundle.containsKey("data"))) {}
    do
    {
      do
      {
        return;
        paramBundle = paramBundle.getBundle("data");
        if (paramBundle == null)
        {
          QLog.e(this.b, 1, "call js function,bundle is empty");
          return;
        }
      } while (!"cmd.videoGetLocalProxyUrl".equals(paramString));
      paramString = paramBundle.getStringArrayList("param.videoLocalUrls");
      ArrayList localArrayList = paramBundle.getStringArrayList("param.videoId");
      paramBundle = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      if ((paramString != null) && (localArrayList != null)) {}
      try
      {
        if (paramString.size() == localArrayList.size())
        {
          int i = 0;
          while (i < paramString.size())
          {
            String str = (String)paramString.get(i);
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("vid", localArrayList.get(i));
            localJSONObject.put("url", str);
            localJSONArray.put(localJSONObject);
            i += 1;
          }
        }
        paramBundle.put("proxyList", localJSONArray);
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          QLog.w(this.b, 2, "getLocalProxyUrl result is invalid.", paramString);
        }
      }
      QLog.i(this.b, 1, "getLocalProxyUrl result=" + paramBundle);
    } while (TextUtils.isEmpty(this.c));
    this.a.callJs(this.c, new String[] { paramBundle.toString() });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\webviewplugin\QzoneVideoTabJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */