package com.tencent.biz.webviewplugin;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.utils.Md5Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class GetKeyPlugin
  extends WebViewPlugin
{
  public static final String a = "Cookie";
  public static final String c = "async_cookie=1";
  protected final int a;
  private long jdField_a_of_type_Long;
  protected AuthorizeConfig a;
  protected Thread a;
  HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  protected final int b;
  protected String b;
  protected final int c;
  protected final int d;
  
  public GetKeyPlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.b = 1;
    this.c = 2;
    this.d = 3;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.mPluginNameSpace = "Cookie";
  }
  
  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("");
    paramString = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      return localStringBuffer.toString();
    }
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      localStringBuffer.append((String)paramString.next());
    }
    return localStringBuffer.toString();
  }
  
  private void a()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = this.jdField_a_of_type_JavaUtilHashMap.entrySet();
    if (this.jdField_a_of_type_JavaUtilHashMap.size() == 0) {}
    StringBuilder localStringBuilder;
    for (int i = 16;; i = this.jdField_a_of_type_JavaUtilHashMap.size() * 256)
    {
      localStringBuilder = new StringBuilder(i);
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (ArrayList)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          localObject2 = (String[])((ArrayList)localObject2).toArray(new String[((ArrayList)localObject2).size()]);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("set cookies: ").append(str).append(", value: ").append(Util.c(Arrays.toString((Object[])localObject2), new String[0])).append("\n");
          }
          localHashMap.put(str, localObject2);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, localStringBuilder.toString());
    }
    if (localHashMap.size() > 0) {
      CookieManager.getInstance().setCookies(localHashMap);
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  private void a(String paramString1, CookieManager paramCookieManager, String paramString2)
  {
    if ((paramCookieManager == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      do
      {
        return;
      } while (!paramString1.equalsIgnoreCase("https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756"));
      a(paramString1, String.format("dvid1=%s; PATH=/; DOMAIN=.%s; Secure; HttpOnly;", new Object[] { HexUtil.a(NetConnInfoCenter.GUID), paramString2 }));
      paramCookieManager = DeviceInfoUtil.a();
      if (!TextUtils.isEmpty(paramCookieManager)) {
        a(paramString1, String.format("dvid5=%s; PATH=/; DOMAIN=.%s; Secure; HttpOnly;", new Object[] { paramCookieManager, paramString2 }));
      }
      paramCookieManager = DeviceInfoUtil.b();
      if (!TextUtils.isEmpty(paramCookieManager)) {
        a(paramString1, String.format("dvid4=%s; PATH=/; DOMAIN=.%s; Secure; HttpOnly;", new Object[] { Md5Utils.getMD5(paramCookieManager), paramString2 }));
      }
      paramCookieManager = DeviceInfoUtil.c(BaseApplication.getContext());
      if (!TextUtils.isEmpty(paramCookieManager)) {
        a(paramString1, String.format("dvid2=%s; PATH=/; DOMAIN=.%s; Secure; HttpOnly;", new Object[] { Md5Utils.getMD5(paramCookieManager), paramString2 }));
      }
      paramCookieManager = DeviceInfoUtil.b(BaseApplication.getContext());
    } while (TextUtils.isEmpty(paramCookieManager));
    a(paramString1, String.format("dvid3=%s; PATH=/; DOMAIN=.%s; Secure; HttpOnly;", new Object[] { Md5Utils.getMD5(paramCookieManager), paramString2 }));
  }
  
  private boolean a()
  {
    boolean bool = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean("ptlogin_flag" + this.mRuntime.a().getAccount(), false);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "mPtloginFlag: " + bool);
    }
    return bool;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    ArrayList localArrayList2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    localArrayList1.add(paramString2);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, localArrayList1);
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 32L) {}
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "handleJsRequest, url=" + Util.b(paramString1, new String[0]));
    }
    if ((!"Cookie".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      return false;
    }
    for (;;)
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if (paramJsBridgeListener.has("callback"))
        {
          paramJsBridgeListener = paramJsBridgeListener.getString("callback");
          if (this.jdField_a_of_type_Boolean)
          {
            paramString1 = "true";
            callJs(paramJsBridgeListener, new String[] { paramString1 });
            if (QLog.isColorLevel()) {
              QLog.d(this.TAG, 4, "on JS query async cookie setting status:" + this.jdField_a_of_type_Boolean);
            }
            return true;
          }
        }
        else
        {
          paramJsBridgeListener = "";
          continue;
        }
        paramString1 = "false";
      }
      catch (JSONException paramJsBridgeListener)
      {
        QLog.e(this.TAG, 2, "on JS query async cookie setting status exception:" + paramJsBridgeListener.getMessage());
        return false;
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.e(this.TAG, 2, "on JS query async cookie setting status exception:" + paramJsBridgeListener.getMessage());
        return false;
      }
    }
  }
  
  public void onCreate()
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_JavaLangThread != null) && (this.jdField_a_of_type_JavaLangThread.isAlive())) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
  }
  
  protected void onPostPluginAsyncTask()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "async set cookie done, cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\GetKeyPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */