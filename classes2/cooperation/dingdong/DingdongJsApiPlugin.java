package cooperation.dingdong;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.dingdong.data.OfficeCenterSharedPref;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yan;
import yao;
import yap;
import yaq;
import yar;
import yas;

public class DingdongJsApiPlugin
  extends WebViewPlugin
{
  private static final byte jdField_a_of_type_Byte = 1;
  private static final int jdField_a_of_type_Int = 10;
  private static final ArrayMap jdField_a_of_type_AndroidSupportV4UtilArrayMap;
  public static final String a = "param_dingdong_appId";
  private static final HashMap jdField_a_of_type_JavaUtilHashMap;
  private static final byte b = 2;
  public static final String b = "param_from_dingdong_office";
  private static final byte c = 3;
  public static final String c = "dingdong_param_open_id_result";
  private static final String e = "DingdongJsApiPlugin";
  private static final String f = "callback";
  private static final String g = "appId";
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  public String d = "QQOfficeOpen";
  private String h;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    jdField_a_of_type_JavaUtilHashMap.put("selectContact", Integer.valueOf(0));
    jdField_a_of_type_JavaUtilHashMap.put("selectGroupDiscuss", Integer.valueOf(1));
    jdField_a_of_type_JavaUtilHashMap.put("externAction", Integer.valueOf(2));
    jdField_a_of_type_JavaUtilHashMap.put("getNetworkInfo", Integer.valueOf(3));
    jdField_a_of_type_JavaUtilHashMap.put("getVersion", Integer.valueOf(4));
    jdField_a_of_type_JavaUtilHashMap.put("checkApp", Integer.valueOf(5));
    jdField_a_of_type_JavaUtilHashMap.put("checkCurrentUser", Integer.valueOf(6));
  }
  
  private TroopMemberApiClient a()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
    return this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  }
  
  private JSONArray a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      JSONArray localJSONArray = new JSONArray();
      ArrayList localArrayList1 = new ArrayList(paramJSONArray.length());
      ArrayList localArrayList2 = new ArrayList(paramJSONArray.length());
      int i = 0;
      if (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {
          switch (localJSONObject.optInt("id", -1))
          {
          default: 
            String str = localJSONObject.optString("title", null);
            if ((str != null) && (str.length() <= 10) && (!localArrayList2.contains(str)))
            {
              localJSONArray.put(localJSONObject);
              localArrayList2.add(str);
            }
            break;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (!localArrayList1.contains(Integer.valueOf(1)))
          {
            localJSONArray.put(localJSONObject);
            localArrayList1.add(Integer.valueOf(1));
          }
        }
      }
      return localJSONArray;
    }
    return null;
  }
  
  private yas a(long paramLong)
  {
    Object localObject1 = OfficeCenterSharedPref.a().a("officecenter_apps_list_txt", "");
    if (((String)localObject1).length() == 0) {
      QLog.e("DingdongJsApiPlugin", 1, "failed to get apps list.");
    }
    for (;;)
    {
      return null;
      try
      {
        Object localObject2 = new JSONObject((String)localObject1);
        Object localObject3 = ((JSONObject)localObject2).keys();
        while (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next().toString();
          if ("appInfo".equals(localObject1))
          {
            Object localObject4 = ((JSONObject)localObject2).getJSONArray((String)localObject1);
            int i = 0;
            int j = ((JSONArray)localObject4).length();
            while (i < j)
            {
              localObject1 = ((JSONArray)localObject4).getJSONObject(i);
              if (paramLong == ((JSONObject)localObject1).optLong("id"))
              {
                localObject2 = new yas(null);
                ((yas)localObject2).jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("name");
                localObject3 = ((JSONObject)localObject1).optString("icon");
                localObject4 = OfficeCenterSharedPref.a().a("officecenter_res_base_url", "");
                if ((((String)localObject4).length() > 0) && (((String)localObject3).length() > 0)) {
                  ((yas)localObject2).b = ((String)localObject4 + (String)localObject3);
                }
                ((yas)localObject2).c = ((JSONObject)localObject1).optString("home_url");
                ((yas)localObject2).d = ((JSONObject)localObject1).optString("summary");
                return (yas)localObject2;
              }
              i += 1;
            }
          }
        }
        return null;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", "1.0.0");
      a(localJSONObject, 4);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(long paramLong)
  {
    String str = this.mRuntime.a().getUrl();
    if (str != null)
    {
      yas localyas = a(paramLong);
      if (localyas != null)
      {
        Object localObject = "http://office.connect.qq.com/myoffice/static/pages/check_url.html?appid=" + paramLong;
        str = (String)localObject + "&_url=" + StringUtil.g(str);
        str = str + "&_wv=1027";
        str = str + "&_webviewtype=2";
        localObject = new Intent(this.mRuntime.a(), ForwardRecentActivity.class);
        ((Intent)localObject).putExtra("key_flag_from_plugin", true);
        ((Intent)localObject).putExtra("pluginName", "web_share");
        ((Intent)localObject).putExtra("forward_type", 1001);
        ((Intent)localObject).putExtra("struct_share_key_content_action", "web");
        ((Intent)localObject).putExtra("req_type", 1);
        ((Intent)localObject).putExtra("k_back", true);
        ((Intent)localObject).putExtra("desc", localyas.d);
        ((Intent)localObject).putExtra("detail_url", str);
        ((Intent)localObject).putExtra("image_url_remote", localyas.b);
        ((Intent)localObject).putExtra("stuctmsg_bytes", StructMsgFactory.a(((Intent)localObject).getExtras()).getBytes());
        startActivityForResult((Intent)localObject, (byte)3);
        ReportController.b(null, "CliOper", "", "", "DingdongClickReport", "0X800653B", 0, 1, 0, "", "", "" + paramLong, "");
      }
    }
    else
    {
      return;
    }
    QQToast.a(this.mRuntime.a(), 1, "分享失败", 2000).b(this.mRuntime.a().getResources().getDimensionPixelSize(2131492908));
  }
  
  private void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    Object localObject = null;
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      a(false, paramString1, paramInt, (View.OnClickListener)localObject, paramString2);
      return;
      paramString1 = "分享";
      paramInt = 4;
      localObject = new yao(this, paramString2, paramLong);
    }
  }
  
  private void a(long paramLong, JSONArray paramJSONArray, String paramString)
  {
    ActionSheet localActionSheet = ActionSheet.a(this.mRuntime.a());
    int i = 0;
    if (i < paramJSONArray.length())
    {
      Object localObject = paramJSONArray.optJSONObject(i);
      if (localObject != null) {
        switch (((JSONObject)localObject).optInt("id"))
        {
        }
      }
      for (localObject = ((JSONObject)localObject).optString("title", "");; localObject = "分享")
      {
        localActionSheet.c((CharSequence)localObject);
        i += 1;
        break;
      }
    }
    localActionSheet.d("取消");
    if (paramString != null) {
      localActionSheet.a(new yap(this, localActionSheet, paramString));
    }
    localActionSheet.a(new yaq(this, localActionSheet, paramJSONArray, paramLong));
    localActionSheet.show();
  }
  
  private void a(long paramLong, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.optString("openId", null);
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        Bundle localBundle = new Bundle(4);
        localBundle.putInt("KeyMsg", 1);
        localBundle.putString("KeyOpenId", paramJSONObject);
        localBundle.putLong("KeyAppId", paramLong);
        localBundle.putInt("KeyReq", a().a(new yan(this)));
        a().a(47, localBundle);
      }
    }
    else
    {
      return;
    }
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("result", 0);
      a(paramJSONObject, 6);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void a(Intent paramIntent, int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    JSONObject localJSONObject;
    if (paramInt == -1)
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("dingdong_param_open_id_result");
      localJSONObject = new JSONObject();
      if ((paramIntent == null) || (paramIntent.isEmpty())) {
        break label140;
      }
      localObject1 = new JSONArray();
      Iterator localIterator = paramIntent.iterator();
      for (paramIntent = (Intent)localObject2; localIterator.hasNext(); paramIntent = paramIntent.d)
      {
        paramIntent = (DingdongJsApiPlugin.OpenIdData)localIterator.next();
        ((JSONArray)localObject1).put(paramIntent.jdField_a_of_type_JavaLangString);
      }
      paramInt = 1;
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("result", paramInt);
        if (paramIntent != null) {
          localJSONObject.put("secret", paramIntent);
        }
        if (localObject1 != null) {
          localJSONObject.put("contacts", localObject1);
        }
      }
      catch (JSONException paramIntent)
      {
        label140:
        QLog.e("DingdongJsApiPlugin", 1, "DingdongJsApiPlugin parse json error:" + paramIntent.toString());
        continue;
      }
      a(localJSONObject, 0);
      return;
      paramInt = -1;
      localObject2 = null;
      paramIntent = (Intent)localObject1;
      localObject1 = localObject2;
    }
  }
  
  private void a(JSONObject paramJSONObject, int paramInt)
  {
    String str = (String)jdField_a_of_type_AndroidSupportV4UtilArrayMap.remove(Integer.valueOf(paramInt));
    if (!TextUtils.isEmpty(str)) {
      callJs(str, new String[] { paramJSONObject.toString() });
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, int paramInt, View.OnClickListener paramOnClickListener, String paramString2)
  {
    Object localObject = this.mRuntime.a();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof AbsBaseWebViewActivity));
      localObject = (AbsBaseWebViewActivity)localObject;
      ((AbsBaseWebViewActivity)localObject).a(paramString2, paramString1, null, paramBoolean, paramInt, 0, null, paramOnClickListener);
    } while ((paramOnClickListener == null) || (paramInt != 0));
    ((AbsBaseWebViewActivity)localObject).rightViewText.setOnClickListener(paramOnClickListener);
  }
  
  private boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3)
  {
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString2))
    {
      int i = ((Integer)jdField_a_of_type_JavaUtilHashMap.get(paramString2)).intValue();
      long l = paramJSONObject.optLong("appId", -1L);
      if (paramString3 != null) {
        jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(Integer.valueOf(i), paramString3);
      }
      switch (i)
      {
      default: 
        return false;
      case 0: 
        c(l);
        return true;
      case 1: 
        b(l);
        return true;
      case 3: 
        b();
        return true;
      case 2: 
        b(l, paramJSONObject);
        return true;
      case 4: 
        a();
        return true;
      case 5: 
        return true;
      }
      a(l, paramJSONObject);
      return true;
    }
    return false;
  }
  
  private void b()
  {
    i = 1;
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    JSONObject localJSONObject = new JSONObject();
    if (localNetworkInfo != null) {}
    try
    {
      if ((!localNetworkInfo.isAvailable()) || (!localNetworkInfo.isConnected())) {
        break label188;
      }
      localJSONObject.put("enable", 1);
      switch (localNetworkInfo.getType())
      {
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        i = 5;
        continue;
        i = 2;
        continue;
        i = 4;
        continue;
        i = 3;
      }
    }
    localJSONObject.put("type", i);
    for (;;)
    {
      a(localJSONObject, 3);
      return;
      switch (((TelephonyManager)this.mRuntime.a().getSystemService("phone")).getNetworkType())
      {
      case 4: 
        label188:
        localJSONObject.put("enable", 0);
        localJSONObject.put("type", 5);
      }
    }
  }
  
  private void b(long paramLong)
  {
    Intent localIntent = new Intent(this.mRuntime.a(), TroopActivity.class);
    localIntent.putExtra("key_tab_mode", 1);
    localIntent.putExtra("param_dingdong_appId", paramLong);
    localIntent.putExtra("param_from_dingdong_office", true);
    startActivityForResult(localIntent, (byte)2);
    ReportController.b(null, "CliOper", "", "", "DingdongClickReport", "0X800653D", 0, 1, 0, "", "", "" + paramLong, "");
  }
  
  private void b(long paramLong, JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("action");
    int i;
    if (localJSONArray != null)
    {
      if (localJSONArray.length() <= 0) {
        break label142;
      }
      localJSONArray = a(localJSONArray);
      i = localJSONArray.length();
      if (i != 1) {
        break label113;
      }
      paramJSONObject = localJSONArray.optJSONObject(0);
      switch (paramJSONObject.optInt("id", -1))
      {
      default: 
        a(paramLong, -1, paramJSONObject.optString("title", ""), paramJSONObject.optString("callback", null));
      }
    }
    label113:
    while (i <= 1)
    {
      return;
      a(paramLong, 1, null, paramJSONObject.optString("callback", null));
      return;
    }
    a(false, "更多", 0, new yar(this, paramLong, localJSONArray, paramJSONObject), null);
    return;
    label142:
    a(true, null, 0, null, null);
  }
  
  private void b(Intent paramIntent, int paramInt)
  {
    Object localObject = null;
    DingdongJsApiPlugin.OpenIdData localOpenIdData = null;
    JSONObject localJSONObject;
    String str;
    int i;
    if (paramInt == -1)
    {
      paramIntent = paramIntent.getParcelableArrayListExtra("dingdong_param_open_id_result");
      localJSONObject = new JSONObject();
      if ((paramIntent == null) || (paramIntent.isEmpty())) {
        break label243;
      }
      Iterator localIterator = paramIntent.iterator();
      paramInt = -1;
      localObject = null;
      str = null;
      paramIntent = localOpenIdData;
      if (localIterator.hasNext())
      {
        localOpenIdData = (DingdongJsApiPlugin.OpenIdData)localIterator.next();
        switch (localOpenIdData.jdField_a_of_type_Int)
        {
        }
        for (;;)
        {
          break;
          str = localOpenIdData.b;
          localObject = localOpenIdData.jdField_a_of_type_JavaLangString;
          paramIntent = localOpenIdData.d;
          paramInt = 2;
          continue;
          str = localOpenIdData.c;
          localObject = localOpenIdData.jdField_a_of_type_JavaLangString;
          paramIntent = localOpenIdData.d;
          paramInt = 3;
        }
      }
      int j = 1;
      i = paramInt;
      paramInt = j;
    }
    for (;;)
    {
      try
      {
        localJSONObject.put("result", paramInt);
        if (paramIntent != null) {
          localJSONObject.put("secret", paramIntent);
        }
        if (-1 != i) {
          localJSONObject.put("flag", i);
        }
        if (str != null) {
          localJSONObject.put("groupDiscussCode", str);
        }
        if (localObject != null) {
          localJSONObject.put("openId", localObject);
        }
      }
      catch (JSONException paramIntent)
      {
        label243:
        QLog.e("DingdongJsApiPlugin", 1, "DingdongJsApiPlugin parse json error:" + paramIntent.toString());
        continue;
      }
      a(localJSONObject, 1);
      return;
      i = -1;
      localOpenIdData = null;
      str = null;
      paramInt = -1;
      paramIntent = (Intent)localObject;
      localObject = localOpenIdData;
    }
  }
  
  private void c(long paramLong)
  {
    Intent localIntent = new Intent(this.mRuntime.a(), SelectMemberActivity.class);
    localIntent.putExtra("param_type", 9998);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_enable_all_select", true);
    localIntent.putExtra("param_overload_tips_include_default_count", true);
    localIntent.putExtra("param_max", 10);
    localIntent.putExtra("param_donot_need_circle", true);
    localIntent.putExtra("param_donot_need_contacts", true);
    localIntent.putExtra("param_dingdong_appId", paramLong);
    startActivityForResult(localIntent, (byte)1);
    ReportController.b(null, "CliOper", "", "", "DingdongClickReport", "0X800653C", 0, 1, 0, "", "", "" + paramLong, "");
  }
  
  private void c(Intent paramIntent, int paramInt)
  {
    if (paramInt == -1) {
      QQToast.a(this.mRuntime.a(), 2, "已分享", 2000).b(this.mRuntime.a().getResources().getDimensionPixelSize(2131492908));
    }
    if (this.h != null)
    {
      paramIntent = new JSONObject();
      if (paramInt != -1) {
        break label98;
      }
      paramInt = 0;
    }
    try
    {
      for (;;)
      {
        paramIntent.put("retCode", paramInt);
        callJs(this.h, new String[] { paramIntent.toString() });
        this.h = null;
        return;
        label98:
        paramInt = 1;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  protected boolean a(String paramString1, String paramString2, String... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramVarArgs != null)
    {
      bool1 = bool2;
      if (1 > paramVarArgs.length) {}
    }
    try
    {
      paramVarArgs = new JSONObject(paramVarArgs[0]);
      bool1 = a(paramString1, paramString2, paramVarArgs, paramVarArgs.optString("callback", null));
      return bool1;
    }
    catch (JSONException paramVarArgs)
    {
      QLog.e("DingdongJsApiPlugin", 1, "dispatchJsRequest url[" + paramString1 + "],method[" + paramString2 + "] error -> " + paramVarArgs.toString());
    }
    return false;
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("QQOfficeOpen".equals(paramString2)) {
      return a(paramString1, paramString3, paramVarArgs);
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    switch (paramByte)
    {
    default: 
      super.onActivityResult(paramIntent, paramByte, paramInt);
      return;
    case 1: 
      a(paramIntent, paramInt);
      return;
    case 2: 
      b(paramIntent, paramInt);
      return;
    }
    c(paramIntent, paramInt);
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(48, new Bundle(0));
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    }
    super.onDestroy();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\dingdong\DingdongJsApiPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */