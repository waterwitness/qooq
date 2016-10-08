package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.SparseArray;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import jgy;
import org.json.JSONException;
import org.json.JSONObject;

public class HbEventPlugin
  extends WebViewPlugin
{
  private static int jdField_a_of_type_Int = 1;
  public static final String a = "PortalManager.HbEventPlugin";
  public static final String b = "redEnvelope";
  public static final String c = "switcher";
  public static final String d = "openSwitcher";
  public static final String e = "querySwitcher";
  public static final String f = "share";
  public static final String g = "queryState";
  public static final String h = "getConfig";
  public static final String i = "requestPack";
  public static final String j = "queryPackList";
  public static final String k = "getRankingList";
  public static final String l = "getHead";
  public static final String m = "getJumpBtnState";
  public static final String n = "getNick";
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public HbEventPlugin()
  {
    this.mPluginNameSpace = "redEnvelope";
  }
  
  private static int a()
  {
    int i1 = jdField_a_of_type_Int;
    jdField_a_of_type_Int = i1 + 1;
    return i1;
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString1 = new Intent(paramString1);
    paramString1.putExtra("portal_type_key", paramInt1);
    paramString1.putExtra("portal_agrs", paramString2);
    paramString1.putExtra("bc_seq", paramInt2);
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().sendBroadcast(paramString1, "com.tencent.msg.permission.pushnotify");
    }
  }
  
  int a(String paramString)
  {
    if ("getRankingList".endsWith(paramString)) {
      return 1008;
    }
    if ("getHead".endsWith(paramString)) {
      return 1009;
    }
    if ("getJumpBtnState".endsWith(paramString)) {
      return 1010;
    }
    if ("getNick".endsWith(paramString)) {
      return 1011;
    }
    return -1;
  }
  
  jgy a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(12);
    }
    Object localObject = new jgy(this, null);
    ((jgy)localObject).jdField_a_of_type_Int = paramInt;
    localObject = new WeakReference(localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
    return (jgy)((WeakReference)localObject).get();
  }
  
  void a(BroadcastReceiver paramBroadcastReceiver, String paramString)
  {
    paramString = new IntentFilter(paramString);
    if (this.mRuntime.a() != null) {
      this.mRuntime.a().registerReceiver(paramBroadcastReceiver, paramString, "com.tencent.msg.permission.pushnotify", null);
    }
  }
  
  public void a(String paramString, String... paramVarArgs)
  {
    callJs(paramString, paramVarArgs);
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      return false;
    }
    Object localObject = (WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localObject == null) {
      return false;
    }
    localObject = (jgy)((WeakReference)localObject).get();
    if (localObject == null) {
      return false;
    }
    try
    {
      this.mRuntime.a().unregisterReceiver((BroadcastReceiver)localObject);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
      }
    }
  }
  
  jgy b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      return null;
    }
    WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localWeakReference == null) {
      return null;
    }
    return (jgy)localWeakReference.get();
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager.HbEventPlugin", 2, "handleJsRequest: " + paramString3 + "," + paramVarArgs);
    }
    boolean bool1 = bool2;
    int i1;
    if ("redEnvelope".endsWith(paramString2)) {
      if ((!"getRankingList".endsWith(paramString3)) && (!"getHead".endsWith(paramString3)) && (!"getJumpBtnState".endsWith(paramString3)))
      {
        bool1 = bool2;
        if (!"getNick".endsWith(paramString3)) {}
      }
      else
      {
        i1 = a();
        paramJsBridgeListener = a(i1);
        a(paramJsBridgeListener, "com.tencent.portal.resp.action");
        if (paramVarArgs == null) {}
      }
    }
    try
    {
      if (paramVarArgs.length > 0)
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener.jdField_a_of_type_JavaLangString = paramString1.getString("callback");
        paramJsBridgeListener.b = paramString1.getJSONObject("params").toString();
      }
      a("com.tencent.portal.req.action", a(paramString3), i1, paramJsBridgeListener.b);
      bool1 = true;
      return bool1;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.size() > 0))
    {
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        jgy localjgy = (jgy)((WeakReference)this.jdField_a_of_type_AndroidUtilSparseArray.get(i1)).get();
        if (localjgy != null) {
          a(localjgy.jdField_a_of_type_Int);
        }
        i1 += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\HbEventPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */