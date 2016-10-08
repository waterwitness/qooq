package com.tencent.mobileqq.troop.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopAssistantFeedsActivity;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import vnm;

public class TroopAssistantFeedsJsHandler
  extends WebViewPlugin
{
  public static final byte a = 101;
  public static final String a = "TroopAssistantFeedsJsHandler";
  public static final String b = "http://qqweb.qq.com/m/qunfeeds/index.html?_wv=1031&_bid=200";
  public static final String c = "troopAssistantFeeds";
  protected static final String d = "openGroupCard";
  protected static final String e = "openGroupMemCard";
  protected static final String f = "openGroupAIO";
  protected static final String g = "openGroupFileDetail";
  protected static final String h = "openGroupPhotoDetail";
  protected static final String i = "openVideo";
  protected static final String j = "openGroupFeedsDetail";
  protected RelativeLayout a;
  protected TroopMemberApiClient a;
  protected VideoPlayLogic a;
  protected AtomicBoolean a;
  
  public TroopAssistantFeedsJsHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.mPluginNameSpace = "troopAssistantFeeds";
  }
  
  protected void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopFeeds:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("url");
      localObject = ((JSONObject)localObject).getString("title");
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      Activity localActivity = this.mRuntime.a();
      Intent localIntent = new Intent(localActivity, TroopAssistantFeedsActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("webStyle", "noBottomBar");
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("isShowAd", false);
      localIntent.putExtra("title", (String)localObject);
      localActivity.startActivity(localIntent);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopFeeds:" + paramString.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideoInner:" + paramString1 + ", " + paramString2);
    }
    Activity localActivity;
    if (this.mRuntime != null)
    {
      localActivity = this.mRuntime.a();
      if (localActivity != null) {
        break label60;
      }
    }
    label60:
    while ((localActivity == null) || (!(localActivity instanceof TroopAssistantFeedsActivity))) {
      return;
    }
    ((TroopAssistantFeedsActivity)localActivity).a(paramString1, paramString2, this.mRuntime.a().a());
  }
  
  protected void b(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideo:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("guin");
      String str = ((JSONObject)localObject).getString("gcode");
      localObject = ((JSONObject)localObject).getString("videourl");
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str)))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true))
        {
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a((String)localObject, new vnm(this, (String)localObject, str));
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideo:" + paramString.toString());
      }
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideoInBrowserActivity:" + paramString);
      }
      Activity localActivity = this.mRuntime.a();
      paramString = paramString.trim();
      String str = this.mRuntime.a().a();
      Intent localIntent = new Intent(localActivity, QQBrowserDelegationActivity.class);
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      if (paramString.indexOf("?") > 0) {}
      for (paramString = "";; paramString = "?")
      {
        paramString = localStringBuilder.append(paramString).append("&from=androidqq");
        localIntent.putExtra("param_force_internal_browser", true);
        localIntent.putExtra("injectrecommend", false);
        localIntent.putExtra("key_isReadModeEnabled", true);
        localIntent.putExtra("url", paramString.toString().trim());
        localIntent.putExtra("uin", str);
        localIntent.putExtra("friendUin", "");
        localActivity.startActivity(localIntent);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openVideoInBrowserActivity:" + paramString.toString());
      }
    }
  }
  
  protected void d(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopCard:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("guin");
      localObject = ((JSONObject)localObject).getString("gcode");
      if (!TextUtils.isEmpty(paramString))
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        Activity localActivity = this.mRuntime.a();
        Intent localIntent = new Intent(localActivity, ChatSettingForTroop.class);
        localIntent.putExtra("troop_code", paramString);
        localIntent.putExtra("troop_uin", (String)localObject);
        localIntent.putExtra("troop_info_from", 6);
        localIntent.putExtra("vistor_type", 2);
        localActivity.startActivity(localIntent);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopCard:" + paramString.toString());
      }
    }
  }
  
  protected void e(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopMemberCard:" + paramString);
      }
      Object localObject1 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject1).getString("guin");
      String str = ((JSONObject)localObject1).getString("gcode");
      localObject1 = ((JSONObject)localObject1).getString("muin");
      Object localObject2 = this.mRuntime.a().a();
      if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        localObject2 = this.mRuntime.a();
        Intent localIntent = new Intent((Context)localObject2, TroopMemberCardActivity.class);
        localIntent.putExtra("troopUin", str);
        localIntent.putExtra("troopCode", paramString);
        localIntent.putExtra("memberUin", (String)localObject1);
        localIntent.putExtra("fromFlag", 3);
        ((Activity)localObject2).startActivity(localIntent);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopMemberCard:" + paramString.toString());
      }
    }
  }
  
  protected void f(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopAIO:" + paramString);
      }
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).getString("guin");
      String str = ((JSONObject)localObject).getString("gcode");
      localObject = ((JSONObject)localObject).getString("gname");
      if (!TextUtils.isEmpty(paramString))
      {
        if (TextUtils.isEmpty(str)) {
          return;
        }
        Activity localActivity = this.mRuntime.a();
        Intent localIntent = AIOUtils.a(new Intent(localActivity, SplashActivity.class), null);
        localIntent.putExtra("uin", str);
        localIntent.putExtra("troop_uin", paramString);
        localIntent.putExtra("uintype", 1);
        localIntent.putExtra("uinname", (String)localObject);
        localActivity.startActivity(localIntent);
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openTroopAIO:" + paramString.toString());
      }
    }
  }
  
  protected void g(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openFile:" + paramString);
      }
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).getString("uuid");
      try
      {
        l1 = ((JSONObject)localObject2).getLong("fileSize");
        l2 = ((JSONObject)localObject2).getLong("gcode");
        String str1 = ((JSONObject)localObject2).getString("fileName");
        String str2 = ((JSONObject)localObject2).getString("url");
        int k = ((JSONObject)localObject2).getInt("bisID");
        Object localObject1 = ((JSONObject)localObject2).optString("senderUin");
        long l3 = ((JSONObject)localObject2).optLong("lastTime");
        localObject2 = this.mRuntime.a();
        Intent localIntent = new Intent((Context)localObject2, TroopFileDetailBrowserActivity.class);
        localIntent.putExtra("from_webview", true);
        localIntent.putExtra("bisId", k);
        localIntent.putExtra("sender_uin", (String)localObject1);
        localIntent.putExtra("last_time", l3);
        localObject1 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject1).d(4);
        ((ForwardFileInfo)localObject1).b(10006);
        ((ForwardFileInfo)localObject1).d(str1);
        ((ForwardFileInfo)localObject1).d(l1);
        ((ForwardFileInfo)localObject1).a(l2);
        ((ForwardFileInfo)localObject1).b(paramString);
        ((ForwardFileInfo)localObject1).e(str2);
        localIntent.putExtra("fileinfo", (Parcelable)localObject1);
        ((Activity)localObject2).startActivity(localIntent);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAssistantFeedsJsHandler", 2, "openFile:" + localException.toString());
          }
          long l1 = 0L;
          long l2 = 0L;
        }
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openFile:" + paramString.toString());
      }
    }
  }
  
  protected void h(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openQZoneAlbumDetail:" + paramString);
      }
      paramString = new JSONObject(paramString).getString("url");
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      AppInterface localAppInterface = this.mRuntime.a();
      Activity localActivity = this.mRuntime.a();
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.a = localAppInterface.a();
      localUserInfo.b = "";
      QZoneHelper.c(localActivity, localUserInfo, paramString, "mqqChat.QzoneCard", -1);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistantFeedsJsHandler", 2, "openQZoneAlbumDetail:" + paramString.toString());
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("troopAssistantFeeds".equals(paramString2))
    {
      if (("openGroupCard".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        d(paramVarArgs[0]);
        return true;
      }
      if (("openGroupMemCard".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        e(paramVarArgs[0]);
        return true;
      }
      if (("openGroupAIO".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        f(paramVarArgs[0]);
        return true;
      }
      if (("openGroupFileDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        g(paramVarArgs[0]);
        return true;
      }
      if (("openGroupPhotoDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        h(paramVarArgs[0]);
        return true;
      }
      if (("openVideo".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        b(paramVarArgs[0]);
        return true;
      }
      if (("openGroupFeedsDetail".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        a(paramVarArgs[0]);
        return true;
      }
    }
    return false;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    try
    {
      if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    catch (Exception localException)
    {
      localException = localException;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    finally
    {
      localObject = finally;
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\jsp\TroopAssistantFeedsJsHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */