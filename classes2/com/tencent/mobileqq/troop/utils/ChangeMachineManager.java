package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import vog;

public class ChangeMachineManager
  implements Manager
{
  public static final String a = ".troop.change_machine";
  public static final String b = "http://innovate.qq.com/GetNewMachine";
  public static final String c = "13";
  QQAppInterface a;
  
  public ChangeMachineManager(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = paramQQAppInterface;
  }
  
  private void b()
  {
    RecentUserProxy localRecentUserProxy = this.a.a().a();
    Object localObject = localRecentUserProxy.b(AppConstants.bc, 7440);
    if (localObject == null)
    {
      localObject = new RecentUser();
      ((RecentUser)localObject).uin = AppConstants.bc;
      ((RecentUser)localObject).type = 7440;
      ((RecentUser)localObject).lastmsgtime = (System.currentTimeMillis() / 1000L);
      ((RecentUser)localObject).displayName = BaseApplicationImpl.getContext().getResources().getString(2131365318);
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("isRead", false);
        ((RecentUser)localObject).msg = localJSONObject.toString();
        ((RecentUser)localObject).msgData = localJSONObject.toString().getBytes();
        ((RecentUser)localObject).msgType = 1;
        localRecentUserProxy.a((RecentUser)localObject);
        localObject = this.a.a(Conversation.class);
        if (localObject != null) {
          ((MqqHandler)localObject).sendEmptyMessage(1009);
        }
        ReportController.b(this.a, "dc00899", "huanjibao", "", "feeds", "view", 0, 0, this.a.a(), "", "", "");
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  private void c()
  {
    RecentUserProxy localRecentUserProxy = this.a.a().a();
    RecentUser localRecentUser = localRecentUserProxy.b(AppConstants.bc, 7440);
    if (localRecentUser == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isRead", true);
      localRecentUser.msg = localJSONObject.toString();
      localRecentUserProxy.a(localRecentUser);
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
  
  public void a()
  {
    try
    {
      String str1 = UserAction.getQIMEI();
      if (str1 == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      String str2;
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e(".troop.change_machine", 2, "get QIMI error");
        }
        str2 = null;
      }
      HashMap localHashMap = new HashMap();
      Bundle localBundle = new Bundle();
      localBundle.putString("qimei", str2);
      localBundle.putString("id", "13");
      localHashMap.put("BUNDLE", localBundle);
      localHashMap.put("CONTEXT", this.a.a().getApplicationContext());
      new HttpWebCgiAsyncTask2("http://innovate.qq.com/GetNewMachine", "GET", new vog(this), 10001, null).a(localHashMap);
    }
  }
  
  public void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "http://qzs.qq.com/open/yyb/switch_phone/html/qq_cooperation.html");
    paramContext.startActivity(localIntent);
    c();
    ReportController.b(this.a, "dc00899", "huanjibao", "", "feeds", "click", 0, 0, this.a.a(), "", "", "");
  }
  
  public void a(String paramString)
  {
    int i = 1;
    try
    {
      int j = new JSONObject(paramString).optInt("showMode");
      if (j == -2) {}
      while (i != 0)
      {
        a();
        ReportController.b(this.a, "dc00899", "huanjibao", "", "new_mobile", "request", 0, 0, this.a.a(), "", "", "");
        return;
        if (j >= 0)
        {
          boolean bool = this.a.a().endsWith(String.valueOf(j));
          if (bool) {}
        }
        else
        {
          i = 0;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDestroy() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\ChangeMachineManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */