package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class VipFunctionJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BusinessName = "QQVIPFunction";
  private static final int MAX_REDIRECT = 5;
  public static final String Method_openPreview = "reportToClientTo644";
  public static final String Method_report643 = "reportToClientTo643";
  public static final String Tag = "QQVIPFunctionJsPlugin";
  private volatile String mCurrentURL;
  private Set mUrlFilter;
  private volatile String mUserAgent;
  
  public VipFunctionJsPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = "QQVIPFunction";
  }
  
  private void reportToClientTo643(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("tag", paramString1);
    localBundle.putString("mainAction", paramString2);
    localBundle.putString("toUin", paramString3);
    localBundle.putString("subAction", paramString4);
    localBundle.putString("actionName", paramString5);
    localBundle.putInt("fromeType", paramInt1);
    localBundle.putInt("result", paramInt2);
    localBundle.putStringArray("reserves", paramArrayOfString);
    sendRemoteReq(DataFactory.a("QQVIPFunctionReport643", "callback", this.mOnRemoteResp.key, localBundle), false, false);
  }
  
  private void reportToClientTo644(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    VipUtils.a(null, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramArrayOfString);
  }
  
  public void callPJs(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQVIPFunctionJsPlugin", 2, "method:" + paramString1 + ", json:" + paramString2);
    }
    callJs(paramString1, new String[] { paramString2 });
  }
  
  protected boolean excuteEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934593L)
    {
      this.mCurrentURL = paramString;
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        this.mUserAgent = localCustomWebView.getSettings().getUserAgentString();
      }
    }
    return super.excuteEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQVIPFunctionJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    if ((!"QQVIPFunction".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      return false;
    }
    int i;
    try
    {
      i = paramString1.indexOf("=");
      if ((i == -1) || (i + 1 > paramString1.length() - 1)) {
        throw new Exception("Invalid Url Parameters");
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      paramJsBridgeListener.printStackTrace();
    }
    label135:
    label199:
    label217:
    label235:
    label254:
    int j;
    label273:
    label292:
    label311:
    String str1;
    label330:
    String str2;
    for (;;)
    {
      return true;
      localObject = new JSONObject(URLDecoder.decode(paramString1.substring(i + 1), "utf-8"));
      if (!((JSONObject)localObject).has("callback")) {
        break label673;
      }
      ((JSONObject)localObject).getString("callback");
      if (((JSONObject)localObject).has("id")) {
        ((JSONObject)localObject).getInt("id");
      }
      if (((JSONObject)localObject).has("status")) {
        ((JSONObject)localObject).getInt("status");
      }
      if (!"reportToClientTo644".equals(paramString3)) {
        break;
      }
      if (!((JSONObject)localObject).has("businessFlag")) {
        break label676;
      }
      paramJsBridgeListener = ((JSONObject)localObject).getString("businessFlag");
      if (!((JSONObject)localObject).has("actionType")) {
        break label682;
      }
      paramString1 = ((JSONObject)localObject).getString("actionType");
      if (!((JSONObject)localObject).has("actionName")) {
        break label688;
      }
      paramString2 = ((JSONObject)localObject).getString("actionName");
      if (!((JSONObject)localObject).has("entry")) {
        break label694;
      }
      i = ((JSONObject)localObject).getInt("entry");
      if (!((JSONObject)localObject).has("result")) {
        break label700;
      }
      j = ((JSONObject)localObject).getInt("result");
      if (!((JSONObject)localObject).has("reserves1")) {
        break label706;
      }
      paramString3 = ((JSONObject)localObject).getString("reserves1");
      if (!((JSONObject)localObject).has("reserves2")) {
        break label713;
      }
      paramVarArgs = ((JSONObject)localObject).getString("reserves2");
      if (!((JSONObject)localObject).has("reserves3")) {
        break label720;
      }
      str1 = ((JSONObject)localObject).getString("reserves3");
      if (!((JSONObject)localObject).has("reserves4")) {
        break label727;
      }
      str2 = ((JSONObject)localObject).getString("reserves4");
      label349:
      reportToClientTo644(paramJsBridgeListener, paramString1, paramString2, i, j, new String[] { paramString3, paramVarArgs, str1, str2 });
    }
    label415:
    label433:
    label451:
    label470:
    label489:
    label508:
    label527:
    label546:
    label565:
    String str3;
    if ("reportToClientTo643".equals(paramString3))
    {
      if (!((JSONObject)localObject).has("tag")) {
        break label734;
      }
      paramJsBridgeListener = ((JSONObject)localObject).getString("tag");
      if (!((JSONObject)localObject).has("mainAction")) {
        break label740;
      }
      paramString1 = ((JSONObject)localObject).getString("mainAction");
      if (!((JSONObject)localObject).has("toUin")) {
        break label746;
      }
      paramString2 = ((JSONObject)localObject).getString("toUin");
      if (!((JSONObject)localObject).has("actionType")) {
        break label752;
      }
      paramString3 = ((JSONObject)localObject).getString("actionType");
      if (!((JSONObject)localObject).has("actionName")) {
        break label759;
      }
      paramVarArgs = ((JSONObject)localObject).getString("actionName");
      if (!((JSONObject)localObject).has("entry")) {
        break label766;
      }
      i = ((JSONObject)localObject).getInt("entry");
      if (!((JSONObject)localObject).has("result")) {
        break label772;
      }
      j = ((JSONObject)localObject).getInt("result");
      if (!((JSONObject)localObject).has("reserves1")) {
        break label778;
      }
      str1 = ((JSONObject)localObject).getString("reserves1");
      if (!((JSONObject)localObject).has("reserves2")) {
        break label785;
      }
      str2 = ((JSONObject)localObject).getString("reserves2");
      if (!((JSONObject)localObject).has("reserves3")) {
        break label792;
      }
      str3 = ((JSONObject)localObject).getString("reserves3");
      label584:
      if (!((JSONObject)localObject).has("reserves4")) {
        break label799;
      }
    }
    label673:
    label676:
    label682:
    label688:
    label694:
    label700:
    label706:
    label713:
    label720:
    label727:
    label734:
    label740:
    label746:
    label752:
    label759:
    label766:
    label772:
    label778:
    label785:
    label792:
    label799:
    for (Object localObject = ((JSONObject)localObject).getString("reserves4");; localObject = "")
    {
      reportToClientTo643(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs, i, j, new String[] { str1, str2, str3, localObject });
      break;
      throw new Exception("No Such Method:" + paramString3);
      break label135;
      paramJsBridgeListener = "";
      break label199;
      paramString1 = "";
      break label217;
      paramString2 = "";
      break label235;
      i = -1;
      break label254;
      j = -1;
      break label273;
      paramString3 = "";
      break label292;
      paramVarArgs = "";
      break label311;
      str1 = "";
      break label330;
      str2 = "";
      break label349;
      paramJsBridgeListener = "CliOper";
      break label415;
      paramString1 = "";
      break label433;
      paramString2 = "";
      break label451;
      paramString3 = "";
      break label470;
      paramVarArgs = "";
      break label489;
      i = -1;
      break label508;
      j = -1;
      break label527;
      str1 = "";
      break label546;
      str2 = "";
      break label565;
      str3 = "";
      break label584;
    }
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (paramCustomWebView != null) {
      this.mUserAgent = paramCustomWebView.getSettings().getUserAgentString();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\vaswebviewplugin\VipFunctionJsPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */