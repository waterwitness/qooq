package cooperation.qqreader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.PluginStatisticsCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.VipUtils;
import java.io.File;

public class QRUtility
{
  public static final int a = 0;
  public static String a = "{\"id\":\"220628\",\"title\":\"天才魔音师\",\"author\":\"紫漠蝶\",\"downloadURL\":\"\",\"coverURL\":\"http://wfqqreader.3g.qq.com/cover/628/220628/b_220628.jpg\",\"contentUrl\":\"http://allreader.3g.qq.com/readonline\",\"is_real_url\": 0,\"type\":0,\"version\":417,\"chapterId\":-1,\"chapterTitle\": \"第1章 诡异事件\", \"drm\":0, \"finished\": 1, \"fileFormat\":\"txt\", \"sourceurl\":\"\"}";
  public static final int b = 1;
  public static final String b = "QR_SETTING";
  public static final int c = 2;
  public static final String c = "QR_USERPREF58";
  public static final String d = "QR_USERPREF_NET";
  public static final String e = "QR_USERPREF_FROM_NET";
  public static final String f = "QR_USERPREF_CHANGE";
  public static final String g = "QR_BOOKADDED";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getInt("QR_USERPREF58", -1);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    int j = 0;
    int i = j;
    int k;
    if (paramQQAppInterface != null)
    {
      k = VipUtils.a(paramQQAppInterface, paramString);
      if ((k & 0x4) == 0) {
        break label26;
      }
      i = 2;
    }
    label26:
    do
    {
      return i;
      i = j;
    } while ((k & 0x2) == 0);
    return 1;
  }
  
  public static String a(Context paramContext)
  {
    return b(paramContext) + "pluginBooks";
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, paramActivity, 2, "inter2");
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("QR_SETTING", 0).edit();
    paramContext.putInt("QR_USERPREF58", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("QR_SETTING", 0).edit();
    paramContext.putInt("QR_USERPREF58", paramInt);
    paramContext.putBoolean("QR_USERPREF_FROM_NET", paramBoolean);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("QR_SETTING", 0).edit().putBoolean("QR_BOOKADDED", paramBoolean).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString)
  {
    String str = "qqreaderplugin.apk";
    Intent localIntent = new Intent();
    localIntent.putExtra("account", paramQQAppInterface.a());
    localIntent.putExtra("load_from_third_app", true);
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
    if (0 == 0)
    {
      localIntent.setClassName(paramActivity, "cooperation.qqreader.QRBridgeActivity");
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("qq_share_book_type", paramInt);
      paramQQAppInterface.putString("book_info", paramString);
      localIntent.putExtras(paramQQAppInterface);
      paramActivity.startActivity(localIntent);
      return;
    }
    paramString = str;
    if (!TextUtils.isEmpty("qqreaderplugin.apk")) {
      paramString = "qqreaderplugin.apk".substring(0, "qqreaderplugin.apk".indexOf("."));
    }
    PluginStatisticsCollector.a(paramActivity, paramQQAppInterface.a(), paramString, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, boolean paramBoolean)
  {
    String str = "qqreaderplugin.apk";
    Intent localIntent = new Intent();
    localIntent.putExtra("account", paramQQAppInterface.a());
    localIntent.putExtra("load_from_third_app", true);
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("clsUploader", "com.tencent.mobileqq.statistics.PluginStatisticsCollector");
    if (0 == 0)
    {
      localIntent.setClassName(paramActivity, "cooperation.qqreader.QRBridgeActivity");
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putBoolean("qq_adv", true);
      localIntent.putExtras(paramQQAppInterface);
      paramActivity.startActivity(localIntent);
      return;
    }
    if (!TextUtils.isEmpty("qqreaderplugin.apk")) {
      str = "qqreaderplugin.apk".substring(0, "qqreaderplugin.apk".indexOf("."));
    }
    PluginStatisticsCollector.a(paramActivity, paramQQAppInterface.a(), str, null);
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getBoolean("QR_USERPREF_FROM_NET", false);
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (paramAppInterface != null)
    {
      paramAppInterface = (PublicAccountDataManager)paramAppInterface.getManager(55);
      if (paramAppInterface != null) {
        return paramAppInterface.b("1805987832") != null;
      }
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    if (Utils.b()) {
      return Environment.getExternalStorageDirectory().getPath() + "/Tencent/ReaderZone/";
    }
    return paramContext.getFilesDir().getAbsolutePath() + File.separator;
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("QR_SETTING", 0).edit();
    paramContext.putInt("QR_USERPREF58", paramInt);
    paramContext.commit();
  }
  
  public static boolean b(Context paramContext)
  {
    return paramContext.getSharedPreferences("QR_SETTING", 0).getBoolean("QR_BOOKADDED", false);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqreader\QRUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */