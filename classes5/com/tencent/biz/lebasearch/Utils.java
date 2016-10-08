package com.tencent.biz.lebasearch;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import hka;
import hkb;
import hkc;

public class Utils
{
  public static final int a = 1;
  public static final int b = 2;
  
  public Utils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static QQCustomDialog a(Context paramContext, TroopMemberApiClient paramTroopMemberApiClient, BusinessObserver paramBusinessObserver, int paramInt, long paramLong, String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramContext, 230);
    paramBusinessObserver = new hka(paramInt, paramBusinessObserver, paramContext, paramTroopMemberApiClient, paramLong);
    paramTroopMemberApiClient = new TextView(paramContext);
    paramTroopMemberApiClient.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramTroopMemberApiClient.setTextSize(14.0F);
    paramTroopMemberApiClient.setTextColor(paramContext.getResources().getColor(2131427355));
    paramTroopMemberApiClient.setGravity(1);
    paramTroopMemberApiClient.setPadding((int)DisplayUtils.a(paramContext, 15.0F), (int)DisplayUtils.a(paramContext, 30.0F), (int)DisplayUtils.a(paramContext, 15.0F), (int)DisplayUtils.a(paramContext, 15.0F));
    if (paramInt == 1)
    {
      localQQCustomDialog.setNegativeButton(2131365011, paramBusinessObserver);
      localQQCustomDialog.setPositiveButton(2131365009, paramBusinessObserver);
      if (paramString2 != null) {}
      for (;;)
      {
        paramTroopMemberApiClient.setText(paramString2);
        localQQCustomDialog.addView(paramTroopMemberApiClient);
        return localQQCustomDialog;
        paramString2 = paramContext.getResources().getString(2131365008, new Object[] { paramString1 });
      }
    }
    if (paramString2 != null) {}
    for (;;)
    {
      localQQCustomDialog.setNegativeButton(2131365016, paramBusinessObserver);
      localQQCustomDialog.setPositiveButton(2131365015, paramBusinessObserver);
      break;
      paramString2 = paramContext.getString(2131365014, new Object[] { paramString1 });
    }
  }
  
  public static QQCustomDialog a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, long paramLong, String paramString1, String paramString2, Handler paramHandler)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramContext, 230);
    paramHandler = new hkc(paramInt, paramHandler, paramQQAppInterface, paramLong);
    paramQQAppInterface = new TextView(paramContext);
    paramQQAppInterface.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    paramQQAppInterface.setTextSize(14.0F);
    paramQQAppInterface.setTextColor(paramContext.getResources().getColor(2131427355));
    paramQQAppInterface.setPadding((int)DisplayUtils.a(paramContext, 15.0F), (int)DisplayUtils.a(paramContext, 30.0F), (int)DisplayUtils.a(paramContext, 15.0F), (int)DisplayUtils.a(paramContext, 15.0F));
    if (paramInt == 1)
    {
      localQQCustomDialog.setNegativeButton(2131365011, paramHandler);
      localQQCustomDialog.setPositiveButton(2131365009, paramHandler);
      if (paramString2 != null) {}
      for (;;)
      {
        paramQQAppInterface.setText(paramString2);
        localQQCustomDialog.addView(paramQQAppInterface);
        return localQQCustomDialog;
        paramString2 = paramContext.getResources().getString(2131365008, new Object[] { paramString1 });
      }
    }
    if (paramString2 != null) {}
    for (;;)
    {
      localQQCustomDialog.setNegativeButton(2131365016, paramHandler);
      localQQCustomDialog.setPositiveButton(2131365015, paramHandler);
      break;
      paramString2 = paramContext.getString(2131365014, new Object[] { paramString1 });
    }
  }
  
  public static void a(Context paramContext, TroopMemberApiClient paramTroopMemberApiClient, BusinessObserver paramBusinessObserver, long paramLong, boolean paramBoolean)
  {
    paramContext = new Handler(paramContext.getMainLooper());
    Bundle localBundle = new Bundle();
    localBundle.putLong("uiResId", paramLong);
    localBundle.putBoolean("isChecked", paramBoolean);
    paramContext.post(new hkb(paramTroopMemberApiClient, localBundle, paramBusinessObserver));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\lebasearch\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */