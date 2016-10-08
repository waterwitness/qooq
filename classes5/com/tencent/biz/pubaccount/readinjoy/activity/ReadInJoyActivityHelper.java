package com.tencent.biz.pubaccount.readinjoy.activity;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.reactnative.activity.ReadInjoyBaseRNActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsNewActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.Serializable;
import java.util.List;
import mqq.app.AppRuntime;

public class ReadInJoyActivityHelper
{
  public static String a = "http://kandian.qq.com/mqq/html/settingInterest.html?_wv=1025&_bid=2378";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Intent a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {}
    for (paramContext = new Intent(paramContext, ReadInJoyFeedsActivity.class);; paramContext = new Intent(paramContext, SubscriptFeedsNewActivity.class))
    {
      if (paramInt1 != -1) {
        paramContext.putExtra("readinjoy_show_tab", paramInt1);
      }
      if (paramInt2 != -1) {
        paramContext.putExtra("tab_tab_index", paramInt2);
      }
      return paramContext;
    }
  }
  
  public static void a(Context paramContext)
  {
    if (!SharedPreUtils.e(paramContext, ((QQAppInterface)BaseApplicationImpl.a().a()).f()))
    {
      paramContext.startActivity(new Intent(paramContext, ReadInjoyBaseRNActivity.class));
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", a);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", paramInt1);
    localIntent.putExtra("channel_name", paramString);
    localIntent.putExtra("channel_type", paramInt2);
    localIntent.putExtra("is_channel_activity", true);
    if (paramInt2 == 3) {
      ReportController.b(null, "CliOper", "", "", "0X80069B2", "0X80069B2", 0, 0, Long.toString(paramInt3), "", "", "");
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, List paramList, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyFeedsActivity.class);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIntent.putExtra("subscription_all_article_id", (Serializable)paramList);
      QLog.i("ReadInJoyActivityHelper", 1, paramList.toString());
    }
    if (paramLong != -1L) {
      localIntent.putExtra("subscription_click_article_id", paramLong);
    }
    if (paramInt == 1) {
      localIntent.putExtra("from_search", true);
    }
    for (;;)
    {
      localIntent.putExtra("launch_from", paramInt);
      paramContext.startActivity(localIntent);
      ((KandianMergeManager)BaseApplicationImpl.a().a().getManager(161)).d();
      return;
      localIntent.putExtra("from_search", false);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyFeedsActivity.class);
    localIntent.putExtra("readinjoy_show_tab", 0);
    if (paramInt2 != -1) {
      localIntent.putExtra("tab_tab_index", paramInt2);
    }
    if (ReadInJoyHelper.e(paramQQAppInterface))
    {
      paramContext.startActivity(new Intent(paramContext, ReadInJoySettingActivity.class));
      if (paramInt2 == 0) {
        ((KandianMergeManager)paramQQAppInterface.getManager(161)).d();
      }
      return;
    }
    if (paramInt1 == 1) {
      localIntent.putExtra("from_search", true);
    }
    for (;;)
    {
      localIntent.putExtra("launch_from", paramInt1);
      paramContext.startActivity(localIntent);
      break;
      localIntent.putExtra("from_search", false);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\readinjoy\activity\ReadInJoyActivityHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */