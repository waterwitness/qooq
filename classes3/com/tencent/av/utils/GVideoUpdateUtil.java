package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.AboutActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import hax;
import hay;
import haz;
import hba;
import java.util.HashMap;
import java.util.Map;

public class GVideoUpdateUtil
{
  static final int jdField_a_of_type_Int = 2134;
  static final String jdField_a_of_type_JavaLangString = "GVideoUpdateUtil";
  public static Map a;
  static final String b = "";
  static final String c = "android";
  static final String d = "http://tiantian.qq.com/cgi-bin/love/qunversion?type=%s&groupcode=%s&version=%d";
  
  public GVideoUpdateUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, AboutActivity.class));
  }
  
  static void a(Context paramContext, Bundle paramBundle1, String paramString1, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback, String paramString2)
  {
    if (paramBundle1 != null)
    {
      paramBundle1.putString("version", "6.5.5");
      paramBundle1.putString("platform", "android");
      paramBundle1.putString("mType", "qb_troop_bar");
      paramBundle1.putString("Referer", "");
      localHashMap = new HashMap();
      localHashMap.put("BUNDLE", paramBundle1);
      localHashMap.put("CONTEXT", paramContext.getApplicationContext());
      new HttpWebCgiAsyncTask2(paramString1, paramString2, paramCallback, paramInt, paramBundle2).execute(new HashMap[] { localHashMap });
    }
    while (!QLog.isColorLevel())
    {
      HashMap localHashMap;
      return;
    }
    QLog.w("GVideoUpdateUtil", 2, "httpGet skey is null!!!!!!!!!!!!!!!");
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, GVideoUpdateUtil.OnGVideoUpdateListener paramOnGVideoUpdateListener)
  {
    if ((paramInt != 2) || (paramString == null))
    {
      paramOnGVideoUpdateListener.a(paramContext, paramString);
      return;
    }
    if (a == null) {
      a = new HashMap();
    }
    for (;;)
    {
      QQProgressDialog localQQProgressDialog = new QQProgressDialog(paramContext);
      localQQProgressDialog.b(2131363956);
      localQQProgressDialog.show();
      try
      {
        paramInt = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
        localObject = new Bundle();
        ((Bundle)localObject).putString("type", "android");
        ((Bundle)localObject).putString("groupcode", paramString);
        ((Bundle)localObject).putInt("version", paramInt);
        paramOnGVideoUpdateListener = new hax(localQQProgressDialog, paramContext, paramString, paramOnGVideoUpdateListener);
        a(paramContext, (Bundle)localObject, String.format("http://tiantian.qq.com/cgi-bin/love/qunversion?type=%s&groupcode=%s&version=%d", new Object[] { "android", paramString, Integer.valueOf(paramInt) }), 2134, (Bundle)localObject, paramOnGVideoUpdateListener, "get");
        return;
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e("GVideoUpdateUtil", QLog.getUIN_REPORTLOG_LEVEL(), "Get versionCode exception!!!", localException);
        paramOnGVideoUpdateListener.a(paramContext, paramString);
      }
      localObject = (hba)a.get(paramString);
      if ((localObject != null) && (System.currentTimeMillis() - ((hba)localObject).jdField_a_of_type_Long < 300000L))
      {
        if ((((hba)localObject).jdField_a_of_type_Boolean) && (((hba)localObject).jdField_a_of_type_JavaLangString != null) && (((hba)localObject).b != null))
        {
          a(paramContext, ((hba)localObject).jdField_a_of_type_JavaLangString, ((hba)localObject).b, paramString, paramOnGVideoUpdateListener);
          return;
        }
        if (!((hba)localObject).jdField_a_of_type_Boolean)
        {
          paramOnGVideoUpdateListener.a(paramContext, paramString);
          return;
        }
        a.remove(paramString);
      }
    }
  }
  
  public static void a(Context paramContext, String paramString, GVideoUpdateUtil.OnGVideoUpdateListener paramOnGVideoUpdateListener)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramOnGVideoUpdateListener.a(paramContext, null);
      return;
    }
    if (!paramString.startsWith("http://qun.qq.com/rich/?"))
    {
      paramOnGVideoUpdateListener.a(paramContext, null);
      return;
    }
    paramString = (String)URLUtil.a(paramString).get("roomid");
    if (paramString == null)
    {
      paramOnGVideoUpdateListener.a(paramContext, null);
      return;
    }
    a(paramContext, paramString, 2, paramOnGVideoUpdateListener);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, GVideoUpdateUtil.OnGVideoUpdateListener paramOnGVideoUpdateListener)
  {
    DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131363954, 2131363955, new hay(paramContext), new haz(paramOnGVideoUpdateListener, paramContext, paramString3)).show();
  }
  
  public static void b(Context paramContext, String paramString, GVideoUpdateUtil.OnGVideoUpdateListener paramOnGVideoUpdateListener)
  {
    paramOnGVideoUpdateListener.a(paramContext, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\GVideoUpdateUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */