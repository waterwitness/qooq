package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import jhh;
import org.json.JSONException;
import org.json.JSONObject;

public class NewerGuidePlugin
  extends WebViewPlugin
{
  public static final byte a = 1;
  public static final String a = "newerguide";
  public static final byte b = 2;
  public static final String b = "getRecommendedList";
  public static final byte c = 3;
  public static final String c = "jumpCard";
  public static final byte d = 4;
  public static final String d = "addFriend";
  public static final byte e = 5;
  public static final String e = "joinTroop";
  public static final byte f = 6;
  public static final String f = "followPublicAccount";
  public static final byte g = 7;
  public static final String g = "sayHi";
  public static final byte h = 8;
  public static final String h = "skipGuide";
  public static final String i = "respRecommend";
  public static final String j = "respCard";
  public static final String k = "respFriend";
  public static final String l = "respTroop";
  public static final String m = "respFollow";
  public static final String n = "respSayHi";
  public static final String o = "key_action";
  public static final String p = "op_result";
  public static final String q = "result";
  public static final String r = "uin";
  public static final String s = "name";
  public static final String t = "wantCount";
  public static final String u = "from_newer_guide";
  public static final String v = "has_operation";
  private Client.onRemoteRespObserver a;
  
  public NewerGuidePlugin()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new jhh(this);
    this.mPluginNameSpace = "newerguide";
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i1 = Integer.parseInt(paramJSONObject.getString("type"));
    Object localObject = null;
    if (i1 != 5)
    {
      paramJSONObject = paramJSONObject.getString("uin");
      localObject = paramJSONObject;
      if (TextUtils.isEmpty(paramJSONObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "handleJumpCard no uin");
        }
        return;
      }
    }
    switch (i1)
    {
    default: 
      return;
    case 1: 
      paramJSONObject = new ProfileActivity.AllInOne((String)localObject, 34);
      paramJSONObject.g = 100;
      localObject = new Intent(this.mRuntime.a(), FriendProfileCardActivity.class);
      ((Intent)localObject).putExtra("AllInOne", paramJSONObject);
      ((Intent)localObject).putExtra("from_newer_guide", true);
      startActivityForResult((Intent)localObject, (byte)1);
      return;
    case 2: 
      paramJSONObject = new Intent(this.mRuntime.a(), AccountDetailActivity.class);
      paramJSONObject.putExtra("uin", (String)localObject);
      paramJSONObject.putExtra("from_newer_guide", true);
      this.mRuntime.a().overridePendingTransition(2130968590, 2130968591);
      startActivityForResult(paramJSONObject, (byte)i1);
      return;
    case 3: 
      paramJSONObject = TroopInfoActivity.a(String.valueOf(localObject), 22);
      localObject = new Intent(this.mRuntime.a(), ChatSettingForTroop.class);
      ((Intent)localObject).putExtras(paramJSONObject);
      ((Intent)localObject).putExtra("from_newer_guide", true);
      ((Intent)localObject).putExtra("vistor_type", 2);
      startActivityForResult((Intent)localObject, (byte)3);
      return;
    case 4: 
      long l1 = Long.parseLong((String)localObject);
      paramJSONObject = new ProfileActivity.AllInOne("0", 41);
      paramJSONObject.g = 100;
      localObject = new Intent(this.mRuntime.a(), NearbyPeopleProfileActivity.class);
      ((Intent)localObject).putExtra("param_mode", 3);
      ((Intent)localObject).putExtra("AllInOne", paramJSONObject);
      ((Intent)localObject).putExtra("param_tiny_id", l1);
      ((Intent)localObject).putExtra("from_newer_guide", true);
      startActivityForResult((Intent)localObject, (byte)i1);
      return;
    }
    paramJSONObject = new ProfileActivity.AllInOne(this.mRuntime.a().a(), 0);
    paramJSONObject.h = this.mRuntime.a().b();
    paramJSONObject.g = 100;
    localObject = new Intent(this.mRuntime.a(), FriendProfileCardActivity.class);
    ((Intent)localObject).putExtra("AllInOne", paramJSONObject);
    ((Intent)localObject).putExtra("from_newer_guide", true);
    this.mRuntime.a().startActivity((Intent)localObject);
  }
  
  public void callJs(String paramString, String... paramVarArgs)
  {
    if (QLog.isDevelopLevel())
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (paramVarArgs != null)
      {
        localObject1 = localObject2;
        if (paramVarArgs.length > 0)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramVarArgs[0])) {
            localObject1 = paramVarArgs[0];
          }
        }
      }
      QLog.d(this.TAG, 4, "callJs : " + paramString + " args: " + (String)localObject1);
    }
    super.callJs(paramString, paramVarArgs);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = false;
    if ("newerguide".endsWith(paramString2))
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "handleJsRequest: " + paramString2 + " " + paramString3 + "," + paramVarArgs[0]);
        }
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        if (paramString3.equals("getRecommendedList"))
        {
          int i1 = Integer.parseInt(paramJsBridgeListener.getString("wantCount"));
          paramJsBridgeListener = new Bundle();
          paramJsBridgeListener.putString("key_action", "getRecommendedList");
          paramJsBridgeListener.putInt("wantCount", i1);
          paramJsBridgeListener = DataFactory.a("ipc_newer_guide", null, this.a.key, paramJsBridgeListener);
          WebIPCOperator.a().a(paramJsBridgeListener);
        }
        else if (paramString3.equals("skipGuide"))
        {
          paramJsBridgeListener = new Intent(this.mRuntime.a(), SplashActivity.class);
          paramJsBridgeListener.putExtra("main_tab_id", 1);
          paramJsBridgeListener.setFlags(603979776);
          this.mRuntime.a().startActivity(paramJsBridgeListener);
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(this.TAG, 2, "handleJsRequest error", paramJsBridgeListener);
          break label532;
          if (paramString3.equals("addFriend"))
          {
            paramString1 = paramJsBridgeListener.getString("uin");
            paramJsBridgeListener = paramJsBridgeListener.getString("name");
            paramJsBridgeListener = AddFriendLogicActivity.a(this.mRuntime.a(), 2, paramString1, null, 3006, 0, paramJsBridgeListener, null, null, null, null);
            paramJsBridgeListener.putExtra("from_newer_guide", true);
            startActivityForResult(paramJsBridgeListener, (byte)7);
          }
          else if (paramString3.equals("followPublicAccount"))
          {
            paramJsBridgeListener = paramJsBridgeListener.getString("uin");
            paramString1 = new Bundle();
            paramString1.putString("key_action", "followPublicAccount");
            paramString1.putString("uin", paramJsBridgeListener);
            paramJsBridgeListener = DataFactory.a("ipc_newer_guide", null, this.a.key, paramString1);
            WebIPCOperator.a().a(paramJsBridgeListener);
          }
          else if (paramString3.equals("joinTroop"))
          {
            paramString1 = paramJsBridgeListener.getString("uin");
            paramJsBridgeListener = paramJsBridgeListener.getString("name");
            paramString2 = new Bundle();
            paramString2.putString("key_action", "joinTroop");
            paramString2.putString("uin", paramString1);
            paramString2.putString("name", paramJsBridgeListener);
            paramJsBridgeListener = DataFactory.a("ipc_newer_guide", null, this.a.key, paramString2);
            WebIPCOperator.a().a(paramJsBridgeListener);
          }
          else if (paramString3.equals("sayHi"))
          {
            long l1 = Long.parseLong(paramJsBridgeListener.getString("uin"));
            paramJsBridgeListener = new Bundle();
            paramJsBridgeListener.putString("key_action", "sayHi");
            paramJsBridgeListener.putLong("tinyId", l1);
            paramJsBridgeListener = DataFactory.a("ipc_newer_guide", null, this.a.key, paramJsBridgeListener);
            WebIPCOperator.a().a(paramJsBridgeListener);
          }
          else if (paramString3.equals("jumpCard"))
          {
            a(paramJsBridgeListener);
          }
        }
      }
      label532:
      bool = true;
    }
    return bool;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    int i1 = 0;
    super.onActivityResult(paramIntent, paramByte, paramInt);
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        if ((paramInt != -1) || (paramIntent == null)) {
          break label190;
        }
        paramInt = i1;
        if (paramIntent.getBooleanExtra("has_operation", false)) {
          paramInt = 1;
        }
        paramIntent = paramIntent.getStringExtra("uin");
        localJSONObject.put("result", paramInt);
        localJSONObject.put("uin", paramIntent);
        paramIntent = null;
        switch (paramByte)
        {
        case 1: 
          if (paramIntent == null) {
            break label211;
          }
          callJs(paramIntent, new String[] { localJSONObject.toString() });
          return;
        }
      }
      catch (JSONException paramIntent)
      {
        JSONObject localJSONObject;
        QLog.d(this.TAG, 1, "onActivityResult err" + paramByte, paramIntent);
        return;
      }
      paramIntent = "respCard";
      localJSONObject.put("type", paramByte);
      continue;
      paramIntent = "respTroop";
      continue;
      label190:
      if (QLog.isColorLevel())
      {
        QLog.d(this.TAG, 1, "onActivityResult no result");
        return;
      }
      else
      {
        label211:
        return;
        paramIntent = "respFriend";
        continue;
        paramIntent = "respSayHi";
      }
    }
  }
  
  protected void onCreate()
  {
    WebIPCOperator.a().a(this.a);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    WebIPCOperator.a().b(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\webviewplugin\NewerGuidePlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */