package com.tencent.mobileqq.mtt;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MttBrowerWrapper
{
  public MttBrowerWrapper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("normal", true);
    try
    {
      paramContext.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      QQToast.a(paramContext, "未找其他浏览器。", 0).b(paramContext.getResources().getDimensionPixelSize(2131492908));
    }
  }
  
  public static void a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, MessageRecord paramMessageRecord)
  {
    if (QRUtils.b(paramString))
    {
      paramMessageRecord = new Intent(paramContext, JoinDiscussionActivity.class);
      int i = paramString.indexOf("dc/ft?k=");
      if (i > 0) {
        paramMessageRecord.putExtra("innerSig", paramString.substring("dc/ft?k=".length() + i));
      }
      for (;;)
      {
        paramContext.startActivity(paramMessageRecord);
        return;
        paramMessageRecord.putExtra("innerSig", paramString);
      }
    }
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", paramBoolean4);
    localIntent.putExtra("key_isReadModeEnabled", paramBoolean1);
    localIntent.putExtra("uin", ((QQAppInterface)((BaseActivity)paramContext).getAppRuntime()).getAccount());
    localIntent.putExtra("useDefBackText", paramBoolean3);
    localIntent.putExtra("injectrecommend", paramBoolean2);
    if (paramMessageRecord != null)
    {
      localIntent.putExtra("curtype", paramMessageRecord.istroop);
      localIntent.putExtra("friendUin", paramMessageRecord.frienduin);
      if (paramMessageRecord.istroop != 0) {
        break label277;
      }
      localIntent.putExtra("articalChannelId", 2);
    }
    for (;;)
    {
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("fromAio", true);
      PublicAccountUtil.a(paramMessageRecord, localIntent, paramString);
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if ((localAppRuntime instanceof QQAppInterface)) {
        AIOOpenWebMonitor.a(localIntent, (QQAppInterface)localAppRuntime, paramMessageRecord);
      }
      WebAccelerator.a(paramContext, localIntent, paramString);
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString, "", "", "");
      return;
      label277:
      if (paramMessageRecord.istroop == 1) {
        localIntent.putExtra("articalChannelId", 3);
      } else if (paramMessageRecord.istroop == 3000) {
        localIntent.putExtra("articalChannelId", 4);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\mtt\MttBrowerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */