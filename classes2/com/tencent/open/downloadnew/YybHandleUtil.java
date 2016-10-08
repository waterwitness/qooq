package com.tencent.open.downloadnew;

import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import java.io.File;
import java.text.DecimalFormat;
import mqq.os.MqqHandler;
import wxp;

public class YybHandleUtil
{
  public static final long a = 710020706L;
  public static String a = "YybHandleUtil";
  public static String b = "APK/MobileAssistant_main.apk";
  public static String c = "yyb.apk";
  public static final String d = "1101070898";
  public static final String e = "5848";
  public static final String f = "http://a.app.qq.com/o/myapp-down?g_f=991310";
  public static final String g = "http://a.app.qq.com/o/myapp-down?g_f=1001647";
  public static final String h = "com.tencent.android.qqdownloader";
  public static final String i = "ANDROIDQQ.MYAPP.YYBDOWNLOAD";
  public static final String j = "应用宝";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    float f2 = paramInt;
    paramInt = 0;
    float f1;
    String str2;
    String str1;
    if (f2 / 1048576.0F > 1.0F)
    {
      f1 = f2 / 1048576.0F;
      paramInt = 2;
      str2 = new DecimalFormat("#.#").format(f1);
      if (paramInt != 2) {
        break label92;
      }
      str1 = "MB";
    }
    for (;;)
    {
      return str2 + str1;
      f1 = f2;
      if (f2 / 1024.0F <= 1.0F) {
        break;
      }
      f1 = f2 / 1024.0F;
      paramInt = 1;
      break;
      label92:
      if (paramInt == 1) {
        str1 = "KB";
      } else {
        str1 = "B";
      }
    }
  }
  
  public static void a()
  {
    LogUtility.c(a, "---deleteYYBApkPackage--");
    ThreadManager.b().post(new wxp());
  }
  
  public static boolean a()
  {
    String str = CommonDataAdapter.a().a().getFilesDir().getAbsolutePath() + File.separator + c;
    return AppUtil.a(CommonDataAdapter.a().a(), str);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\downloadnew\YybHandleUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */