package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sxq;

public class EventApiPlugin
  extends WebViewPlugin
{
  public static final String a = "com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT";
  static final String b = "broadcast";
  static final String c = "unique";
  public static final String d = "event";
  public static final String e = "data";
  static final String f = "domains";
  static final String g = "source";
  static final String h = "echo";
  static final String i = "url";
  static final String j = "options";
  public static final String k = "com.tencent.msg.permission.pushnotify";
  private static final String m = "EventApiPlugin";
  BroadcastReceiver a;
  private String l;
  
  public EventApiPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.l = "";
    this.a = new sxq(this);
    this.mPluginNameSpace = "event";
  }
  
  private ComponentName a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("/");
      if ((paramString != null) && (paramString.length == 2)) {
        return new ComponentName(paramString[0], paramString[1]);
      }
    }
    return null;
  }
  
  private Intent a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      paramJSONObject = null;
    }
    Intent localIntent;
    Object localObject;
    do
    {
      do
      {
        return paramJSONObject;
        localIntent = new Intent();
        localObject = paramJSONObject.optString("action", "");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localIntent.setAction((String)localObject);
        }
        localObject = paramJSONObject.optString("category", "");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localIntent.addCategory((String)localObject);
        }
        localObject = paramJSONObject.optString("componentName", "");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          localIntent.setComponent(a((String)localObject));
        }
        localObject = paramJSONObject.getJSONObject("intentExtras");
        paramJSONObject = localIntent;
      } while (localObject == null);
      localObject = a((JSONObject)localObject);
      paramJSONObject = localIntent;
    } while (localObject == null);
    localIntent.putExtras((Bundle)localObject);
    return localIntent;
  }
  
  private Bundle a(JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    if (localIterator != null)
    {
      Bundle localBundle = new Bundle();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str)) {
          localBundle.putCharSequence(str, paramJSONObject.getString(str));
        }
      }
      return localBundle;
    }
    return null;
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.l)) {
      return this.l;
    }
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null) {}
    for (this.l = (String.valueOf(System.currentTimeMillis()) + String.valueOf(localActivity.hashCode()));; this.l = (String.valueOf(System.currentTimeMillis()) + String.valueOf((int)(Math.random() * 1000000.0D)))) {
      return this.l;
    }
  }
  
  private void a(String paramString)
  {
    if ((!Build.MANUFACTURER.contains("Xiaomi")) || (TextUtils.isEmpty(paramString))) {}
    label190:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.e("EventApiPlugin", 2, "handleMiUIInstallIntercepterEvent,finger print:" + Build.FINGERPRINT + ",config:" + paramString);
          }
          try
          {
            paramString = a(new JSONObject(paramString));
            if ((paramString == null) || (this.mRuntime == null)) {
              break label190;
            }
            Activity localActivity = this.mRuntime.a();
            if (localActivity != null)
            {
              localActivity.startActivity(paramString);
              return;
            }
          }
          catch (JSONException paramString)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("EventApiPlugin", 2, "error:" + paramString.toString());
              return;
              if (QLog.isColorLevel())
              {
                QLog.d("EventApiPlugin", 2, "activity is null.");
                return;
              }
            }
          }
          catch (Exception paramString) {}
        }
      } while (!QLog.isColorLevel());
      QLog.d("EventApiPlugin", 2, "error:" + paramString.toString());
      return;
    } while (!QLog.isColorLevel());
    QLog.d("EventApiPlugin", 2, "intent or runtime is null");
  }
  
  public static void a(String paramString1, JSONObject paramJSONObject, ArrayList paramArrayList, String paramString2)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    localIntent.putExtra("event", paramString1);
    if (paramJSONObject != null) {
      localIntent.putExtra("data", paramJSONObject.toString());
    }
    localIntent.putStringArrayListExtra("domains", paramArrayList);
    paramString1 = new JSONObject();
    try
    {
      paramString1.put("url", paramString2);
      localIntent.putExtra("source", paramString1.toString());
      BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;) {}
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934606L)
    {
      paramString = new JSONObject();
      if (paramMap != null) {}
      try
      {
        paramString.put("x", (Integer)paramMap.get("X"));
        paramString.put("y", (Integer)paramMap.get("Y"));
        dispatchJsEvent("qbrowserTitleBarClick", paramString, null);
        return true;
      }
      catch (ClassCastException localClassCastException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EventApiPlugin", 2, "ClassCastException, " + paramMap.get("X") + ", " + paramMap.get("Y"));
          }
          localClassCastException.printStackTrace();
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("EventApiPlugin", 2, "JSONException, " + paramMap.get("X") + ", " + paramMap.get("Y"));
          }
          localJSONException.printStackTrace();
        }
      }
    }
    if (paramLong == 8589934607L)
    {
      dispatchJsEvent("qbrowserOptionsButtonClick", null, null);
      return true;
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("event".equals(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EventApiPlugin", 2, "method=" + paramString3);
      }
      if ((!"dispatchEvent".equals(paramString3)) || (paramVarArgs.length != 1)) {}
    }
    for (;;)
    {
      int n;
      try
      {
        paramString3 = this.mRuntime.a();
        if (paramString3 == null) {
          return true;
        }
        paramString2 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString2.optString("event");
        if (TextUtils.isEmpty(paramJsBridgeListener))
        {
          if (!QLog.isColorLevel()) {
            break label471;
          }
          QLog.w("EventApiPlugin", 2, "param event is requested");
          break label471;
        }
        paramString1 = paramString2.optJSONObject("data");
        paramVarArgs = paramString2.optJSONObject("options");
        int i2 = 1;
        boolean bool1 = true;
        paramString2 = new ArrayList();
        paramString3 = paramString3.getUrl();
        if (paramVarArgs != null)
        {
          boolean bool2 = paramVarArgs.optBoolean("echo", true);
          boolean bool3 = paramVarArgs.optBoolean("broadcast", true);
          paramVarArgs = paramVarArgs.optJSONArray("domains");
          bool1 = bool3;
          i2 = bool2;
          if (paramVarArgs != null)
          {
            n = 0;
            int i1 = paramVarArgs.length();
            bool1 = bool3;
            i2 = bool2;
            if (n < i1)
            {
              String str = paramVarArgs.optString(n);
              if (TextUtils.isEmpty(str)) {
                break label473;
              }
              paramString2.add(str);
              break label473;
            }
          }
        }
        paramVarArgs = new JSONObject();
        paramVarArgs.put("url", paramString3);
        if ((paramString2.size() == 0) && (paramString3 != null))
        {
          paramString3 = Uri.parse(paramString3);
          if (paramString3.isHierarchical()) {
            paramString2.add(paramString3.getHost());
          }
        }
        paramString3 = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        paramString3.putExtra("broadcast", bool1);
        paramString3.putExtra("unique", a());
        paramString3.putExtra("event", paramJsBridgeListener);
        if (paramString1 != null) {
          paramString3.putExtra("data", paramString1.toString());
        }
        paramString3.putStringArrayListExtra("domains", paramString2);
        paramString3.putExtra("source", paramVarArgs.toString());
        BaseApplicationImpl.getContext().sendBroadcast(paramString3, "com.tencent.msg.permission.pushnotify");
        if (i2 != 0) {
          dispatchJsEvent(paramJsBridgeListener, paramString1, paramVarArgs);
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        continue;
      }
      return true;
      if ("miuiInstallInterceptor".equals(paramString3))
      {
        if ((paramVarArgs.length < 1) && (QLog.isColorLevel()))
        {
          QLog.e("EventApiPlugin", 2, "no arguments.");
          return true;
        }
        a(paramVarArgs[0]);
        return true;
        return false;
        label471:
        return true;
        label473:
        n += 1;
      }
    }
  }
  
  public void onActivityReady()
  {
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null) {}
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      localActivity.registerReceiver(this.a, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("EventApiPlugin", 2, "error:" + localException.toString());
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Activity localActivity = this.mRuntime.a();
    if (localActivity != null) {
      localActivity.unregisterReceiver(this.a);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\jsp\EventApiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */