package com.tencent.mobileqq.webview.swift;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.reflect.Method;

@Deprecated
public abstract class JsWebViewPlugin
  extends WebViewPlugin
{
  public JsWebViewPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.mPluginNameSpace = a();
  }
  
  protected abstract String a();
  
  protected Method a(String paramString1, String paramString2, int paramInt)
  {
    if (!a().equals(paramString1)) {}
    for (;;)
    {
      return null;
      paramString1 = getClass().getDeclaredMethods();
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
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    paramString2 = a(paramString2, paramString3, paramVarArgs.length);
    if (paramString2 != null) {}
    try
    {
      if (paramVarArgs.length == 0) {}
      for (paramString1 = paramString2.invoke(this, new Object[0]);; paramString1 = paramString2.invoke(this, paramVarArgs))
      {
        paramString2 = paramString2.getReturnType();
        if ((paramString2 != Void.TYPE) && (paramString2 != Void.class)) {
          break label97;
        }
        if (paramJsBridgeListener == null) {
          break label128;
        }
        if (!paramJsBridgeListener.a) {
          break;
        }
        callJs4OpenApi(paramJsBridgeListener, 0, JsBridgeListener.a(0, null, null));
        break label128;
      }
      paramJsBridgeListener.a(null);
      break label128;
      label97:
      if (paramJsBridgeListener != null) {
        if (paramJsBridgeListener.a) {
          callJs4OpenApi(paramJsBridgeListener, 0, JsBridgeListener.a(0, paramString1, null));
        } else {
          paramJsBridgeListener.a(paramString1);
        }
      }
      label128:
      bool = true;
      return bool;
    }
    catch (Exception paramJsBridgeListener) {}
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\swift\JsWebViewPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */