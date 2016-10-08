package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardSdkShareOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.TroopBarShareActivity;
import com.tencent.qphone.base.util.QLog;

public class TroopBarShareUtils
{
  public static final String a = "troopbar_share";
  public static final String b = "share_app_id";
  public static final String c = "share_app_name";
  public static final String d = "Grp_share";
  public static final String e = "to_tribe";
  public static final String f = "share_ask";
  public static final String g = "share_suc";
  public static final String h = "suc_app";
  public static final String i = "suc_tribe";
  
  public TroopBarShareUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a()
  {
    return "http://buluo.qq.com/mobile/index.html?_wv=5123&_bid=128";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return "http://buluo.qq.com/mobile/detail.html?_wv=5123&_bid=128#bid=" + paramString1 + "&pid=" + paramString2;
  }
  
  public static void a(Activity paramActivity, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopbar_share", 2, "notifySDKCanceled:" + paramLong);
    }
    ForwardSdkShareOption.a(paramActivity, false, "shareToTroopBar", paramLong);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    paramString4 = a(paramString3, paramString4);
    Intent localIntent = new Intent(paramContext, TroopBarShareActivity.class);
    localIntent.putExtra("pkg_name", paramString1);
    localIntent.putExtra("share_app_name", paramString2);
    localIntent.putExtra("share_app_id", paramLong);
    localIntent.putExtra("url", paramString4);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("bid", paramString3);
    paramContext.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("troopbar_share", 2, "openTopicDetail:" + paramString2 + ", " + paramLong + ", " + paramString4);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_share", "", "to_tribe", paramString1, 0, 0, paramString2, "1", null, null);
  }
  
  public static void b(Activity paramActivity, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("troopbar_share", 2, "notifySDKCompleted:" + paramLong);
    }
    ForwardSdkShareOption.a(paramActivity, true, "shareToTroopBar", paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\TroopBarShareUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */