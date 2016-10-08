package com.tencent.mobileqq.webview.webso;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import wjy;
import wns_proxy.EnumHttpMethod;
import wns_proxy.HttpReq;
import wns_proxy.HttpRsp;

public class WebSoCgiService
  implements BusinessObserver
{
  public static final int a = 1101;
  private static volatile WebSoCgiService jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "WebSoCgiService";
  LruCache jdField_a_of_type_AndroidSupportV4UtilLruCache = new wjy(this, 16);
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static WebSoCgiService a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService == null) {
        jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService = new WebSoCgiService();
      }
      return jdField_a_of_type_ComTencentMobileqqWebviewWebsoWebSoCgiService;
    }
  }
  
  private void a(Handler paramHandler, WebSoCgiService.WebSoCgiState paramWebSoCgiState)
  {
    Message localMessage = paramHandler.obtainMessage(204);
    localMessage.obj = paramWebSoCgiState;
    paramHandler.sendMessage(localMessage);
  }
  
  private void a(WebSoCgiService.WebSoCgiState paramWebSoCgiState)
  {
    Handler localHandler;
    if ((paramWebSoCgiState != null) && (paramWebSoCgiState.jdField_a_of_type_JavaLangRefWeakReference != null) && (paramWebSoCgiState.jdField_a_of_type_JavaLangRefWeakReference.get() != null))
    {
      localHandler = (Handler)paramWebSoCgiState.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localHandler != null) {}
    }
    else
    {
      return;
    }
    a(localHandler, paramWebSoCgiState);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString("url");
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return;
      WebSoCgiService.WebSoCgiState localWebSoCgiState = (WebSoCgiService.WebSoCgiState)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(str);
      localWebSoCgiState.jdField_a_of_type_Int = 2;
      localWebSoCgiState.jdField_c_of_type_Int = 0;
      a(paramBoolean, paramBundle, localWebSoCgiState);
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(str);
    } while (!QLog.isColorLevel());
    QLog.d("WebSoCgiService", 2, "onGetHttpData succed(" + paramBoolean + "), url:" + str);
  }
  
  private void a(boolean paramBoolean, Bundle paramBundle, WebSoCgiService.WebSoCgiState paramWebSoCgiState)
  {
    if (!paramBoolean)
    {
      if (paramBundle == null)
      {
        i = 10002;
        paramWebSoCgiState.jdField_c_of_type_Int = i;
        if (paramBundle != null) {
          break label51;
        }
      }
      label51:
      for (paramBundle = "rsp is null";; paramBundle = paramBundle.getString("rsp_message"))
      {
        paramWebSoCgiState.e = paramBundle;
        a(paramWebSoCgiState);
        return;
        i = paramBundle.getInt("rsp_code", 10002);
        break;
      }
    }
    Object localObject1 = (HttpRsp)paramBundle.getSerializable("rsp_data");
    paramBundle = null;
    if (localObject1 != null) {
      paramBundle = new HttpResponsePackage((HttpRsp)localObject1);
    }
    if (localObject1 == null)
    {
      paramWebSoCgiState.jdField_c_of_type_Int = 10002;
      paramWebSoCgiState.e = "rsp is null";
      a(paramWebSoCgiState);
      return;
    }
    localObject1 = ((HttpRsp)localObject1).rspinfo;
    int i = ((String)localObject1).indexOf("\r\n\r\n");
    paramBundle = paramBundle.E;
    localObject1 = ((String)localObject1).substring(0, i - 1).split("\r\n");
    int j = localObject1.length;
    if (j >= 1)
    {
      Object localObject2 = localObject1[0].split(" ");
      if (localObject2.length >= 2) {}
      try
      {
        paramWebSoCgiState.jdField_b_of_type_Int = Integer.valueOf(localObject2[1].trim()).intValue();
        localObject2 = new JSONObject();
        i = 1;
        if (i < j)
        {
          arrayOfString = localObject1[i].split(":");
          if (arrayOfString.length <= 1) {}
        }
      }
      catch (Exception localException)
      {
        try
        {
          for (;;)
          {
            String[] arrayOfString;
            ((JSONObject)localObject2).put(arrayOfString[0].trim(), arrayOfString[1].trim());
            i += 1;
          }
          localException = localException;
          localException.printStackTrace();
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        paramWebSoCgiState.jdField_b_of_type_JavaLangString = localException.toString();
      }
    }
    paramWebSoCgiState.jdField_c_of_type_Int = 0;
    paramWebSoCgiState.jdField_c_of_type_JavaLangString = paramBundle;
    a(paramWebSoCgiState);
  }
  
  public boolean a(WebSoCgiService.CgiReqInfo paramCgiReqInfo, Handler paramHandler)
  {
    if ((paramCgiReqInfo == null) || (TextUtils.isEmpty(paramCgiReqInfo.jdField_a_of_type_JavaLangString))) {}
    while (!NetworkUtil.h(BaseApplicationImpl.getContext())) {
      return false;
    }
    WebSoCgiService.WebSoCgiState localWebSoCgiState = (WebSoCgiService.WebSoCgiState)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramCgiReqInfo.jdField_a_of_type_JavaLangString);
    localWebSoCgiState.jdField_a_of_type_JavaLangString = paramCgiReqInfo.jdField_a_of_type_JavaLangString;
    localWebSoCgiState.jdField_a_of_type_Boolean = paramCgiReqInfo.jdField_a_of_type_Boolean;
    localWebSoCgiState.jdField_a_of_type_Int = 1;
    localWebSoCgiState.d = paramCgiReqInfo.f;
    localWebSoCgiState.jdField_a_of_type_JavaLangObject = paramCgiReqInfo.jdField_a_of_type_JavaLangObject;
    long l = BaseApplicationImpl.a().a().getLongAccountUin();
    String str2 = QUA.a();
    String str1 = WebSoUtils.a();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("method", paramCgiReqInfo.jdField_b_of_type_JavaLangString.toUpperCase());
      localJSONObject.put("entity_body", paramCgiReqInfo.d);
      localJSONObject.put("if_None_Match", "");
      localJSONObject.put("accept_diff", "false");
      localJSONObject.put("content_type", paramCgiReqInfo.e);
      localJSONObject.put("uri", paramCgiReqInfo.jdField_a_of_type_JavaLangString);
      if (paramCgiReqInfo.jdField_b_of_type_JavaLangString.equalsIgnoreCase("GET"))
      {
        if (!TextUtils.isEmpty(paramCgiReqInfo.d))
        {
          if (!paramCgiReqInfo.jdField_a_of_type_JavaLangString.contains("?")) {
            break label509;
          }
          localJSONObject.put("uri", paramCgiReqInfo.jdField_a_of_type_JavaLangString + "&" + paramCgiReqInfo.d);
        }
        for (;;)
        {
          Object localObject = "";
          SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.a(paramCgiReqInfo.jdField_a_of_type_JavaLangString);
          if (localSwiftBrowserCookieMonster != null) {
            localObject = localSwiftBrowserCookieMonster.a();
          }
          localJSONObject.put("cookie", (String)localObject + "; qua=" + str2 + "; ");
          localJSONObject.put("no_Chunked", "true");
          localJSONObject.put("accept_Encoding", "identity");
          localObject = new HttpRequestPackage(str1, localJSONObject);
          ((HttpRequestPackage)localObject).addHeader(paramCgiReqInfo.jdField_c_of_type_JavaLangString);
          localObject = new HttpReq(EnumHttpMethod.convert("e" + ((HttpRequestPackage)localObject).method).value(), ((HttpRequestPackage)localObject).getHeaderString(), ((HttpRequestPackage)localObject).getBodyString(), ((HttpRequestPackage)localObject).host);
          localWebSoCgiState.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramHandler);
          paramHandler = new NewIntent(BaseApplicationImpl.getContext(), WebSoServlet.class);
          WebSoServlet.a(paramHandler, l, paramCgiReqInfo.jdField_a_of_type_JavaLangString, (HttpReq)localObject, "", paramCgiReqInfo.jdField_a_of_type_Int, 1101, WebSoCgiService.class);
          if (!this.jdField_a_of_type_Boolean)
          {
            BaseApplicationImpl.a().a().registObserver(this);
            this.jdField_a_of_type_Boolean = true;
          }
          BaseApplicationImpl.a().a().startServlet(paramHandler);
          return true;
          label509:
          localJSONObject.put("uri", paramCgiReqInfo.jdField_a_of_type_JavaLangString + "?" + paramCgiReqInfo.d);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        if (!TextUtils.isEmpty(paramCgiReqInfo.d)) {
          localJSONObject.put("content_length", paramCgiReqInfo.d.length());
        }
      }
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 1101) {
      a(paramBoolean, paramBundle);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\webview\webso\WebSoCgiService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */