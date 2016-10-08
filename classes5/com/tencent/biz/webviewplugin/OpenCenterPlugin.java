package com.tencent.biz.webviewplugin;

import android.app.Activity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.JsWebViewPlugin;
import com.tencent.mobileqq.webview.swift.MultiNameSpacePluginCompact;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.adapter.OpenAppClient;
import com.tencent.open.appcommon.js.BaseInterface;
import com.tencent.open.appcommon.js.BaseJsCallBack;
import com.tencent.open.appcommon.js.DownloadInterface;
import com.tencent.open.appcommon.js.HttpInterface;
import com.tencent.open.export.js.VipDownloadInterface;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OpenCenterPlugin
  extends JsWebViewPlugin
  implements MultiNameSpacePluginCompact
{
  private static final String jdField_a_of_type_JavaLangString = "opencenter";
  private Map jdField_a_of_type_JavaUtilMap;
  
  public OpenCenterPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void a()
  {
    this.a = new HashMap();
    Object localObject = this.mRuntime.a();
    BaseJsCallBack localBaseJsCallBack = new BaseJsCallBack((Activity)localObject);
    VipDownloadInterface localVipDownloadInterface = new VipDownloadInterface((Activity)localObject, this.mRuntime.a());
    HttpInterface localHttpInterface = new HttpInterface((Activity)localObject, this.mRuntime.a());
    com.tencent.open.appcommon.js.AppInterface localAppInterface = new com.tencent.open.appcommon.js.AppInterface((Activity)localObject, this.mRuntime.a());
    localObject = new DownloadInterface((Activity)localObject, this.mRuntime.a());
    this.a.put(localBaseJsCallBack.getInterfaceName(), localBaseJsCallBack);
    this.a.put(localVipDownloadInterface.getInterfaceName(), localVipDownloadInterface);
    this.a.put(localHttpInterface.getInterfaceName(), localHttpInterface);
    this.a.put(localAppInterface.getInterfaceName(), localAppInterface);
    this.a.put(((BaseInterface)localObject).getInterfaceName(), localObject);
  }
  
  protected String a()
  {
    return "opencenter";
  }
  
  protected Method a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = (BaseInterface)this.a.get(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.getClass().getDeclaredMethods();
      int j = paramString1.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = paramString1[i];
        if ((localMethod.getName().equals(paramString2)) && (localMethod.getParameterTypes().length == paramInt)) {
          return localMethod;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public String[] getMultiNameSpace()
  {
    return new String[] { "opencenter", "qqZoneAppList", "q_download", "qzone_http", "qzone_app", "q_download" };
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934593L) {
      OpenAppClient.a(this.mRuntime.a());
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    Method[] arrayOfMethod = null;
    paramString1 = null;
    if (this.a == null) {
      a();
    }
    BaseInterface localBaseInterface = (BaseInterface)this.a.get(paramString2);
    paramString2 = arrayOfMethod;
    int i;
    if (localBaseInterface != null)
    {
      arrayOfMethod = localBaseInterface.getClass().getDeclaredMethods();
      int j = arrayOfMethod.length;
      i = 0;
      paramString2 = paramString1;
      if (i < j)
      {
        paramString2 = arrayOfMethod[i];
        if ((!paramString2.getName().equals(paramString3)) || (paramString2.getParameterTypes().length != paramVarArgs.length)) {
          break label184;
        }
        paramString1 = paramString2;
      }
    }
    label184:
    for (;;)
    {
      i += 1;
      break;
      if (paramString2 != null) {
        try
        {
          if (paramVarArgs.length == 0) {}
          for (paramString1 = paramString2.invoke(localBaseInterface, new Object[0]);; paramString1 = paramString2.invoke(localBaseInterface, paramVarArgs))
          {
            paramString2 = paramString2.getReturnType();
            if ((paramString2 != Void.TYPE) && (paramString2 != Void.class)) {
              break;
            }
            if (paramJsBridgeListener == null) {
              break label187;
            }
            paramJsBridgeListener.a(null);
            break label187;
          }
          if (paramJsBridgeListener == null) {
            break label187;
          }
          paramJsBridgeListener.a(paramString1);
        }
        catch (Exception paramJsBridgeListener) {}
      }
      return false;
    }
    label187:
    return true;
  }
  
  public void onAppRuntimeReady(com.tencent.common.app.AppInterface paramAppInterface) {}
  
  protected void onCreate() {}
  
  protected void onDestroy()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext()) {
        try
        {
          ((BaseInterface)((Map.Entry)localIterator.next()).getValue()).destroy();
        }
        catch (Exception localException) {}
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\OpenCenterPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */