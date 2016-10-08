package com.tencent.mobileqq.activity.aio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.CGILoader;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URLEncoder;
import java.util.HashMap;
import ncd;

public class AIOOpenWebMonitor
{
  public static final String A = "AIOWebPreloadhit";
  public static final String B = "hit_count";
  public static final String C = "preload_count";
  private static String D = "";
  public static final int a = 1;
  private static ArrayMap jdField_a_of_type_AndroidSupportV4UtilArrayMap;
  public static final String a = "from";
  private static HashMap jdField_a_of_type_JavaUtilHashMap;
  public static final int b = 1;
  public static final String b = "aio_preload_qweb_cout";
  public static final int c = 2;
  public static final String c = "aio_preload_qweb_last";
  public static final int d = 1;
  public static final String d = "aio_open_web";
  public static final int e = 2;
  public static final String e = "aio_hit_count";
  public static final int f = 3;
  public static final String f = "from_aio";
  public static final int g = 1;
  public static final String g = "from_aio_time";
  public static final int h = 2;
  public static final String h = "from_aio_opt";
  public static final int i = 1;
  public static final String i = "AIOWeb";
  public static final int j = 2;
  public static final String j = "first_open";
  public static final int k = -1;
  public static final String k = "from";
  public static final int l = 1;
  public static final String l = "use_optimization";
  public static final int m = 2;
  public static final String m = "has_pp";
  public static final int n = 1;
  public static final String n = "ps_state";
  public static final int o = 2;
  public static final String o = "network_type";
  private static int p = 0;
  public static final String p = "use_x5";
  private static int q = -1;
  public static final String q = "click_to_activity";
  public static final String r = "activity_to_webview";
  public static final String s = "safe_check";
  public static final String t = "short_link";
  public static final String u = "wb_c";
  public static final String v = "web_finish";
  public static final String w = "host";
  public static final String x = "open_finished";
  public static final String y = "has_safecheck";
  public static final String z = "has_short_link";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a()
  {
    if (Build.VERSION.SDK_INT > 10)
    {
      SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4);
      int i1 = localSharedPreferences.getInt("aio_preload_qweb_cout", 0);
      localSharedPreferences.edit().putInt("aio_preload_qweb_cout", i1 + 1).commit();
    }
  }
  
  public static void a(Intent paramIntent)
  {
    int i1 = 1;
    p += 1;
    if (paramIntent == null) {
      break label14;
    }
    label14:
    while (!paramIntent.getBooleanExtra("aio_open_web", false)) {
      return;
    }
    long l1 = paramIntent.getLongExtra("from_aio_time", -1L);
    label63:
    label90:
    int i2;
    label107:
    String str;
    if ((jdField_a_of_type_JavaUtilHashMap == null) || (jdField_a_of_type_JavaUtilHashMap.size() > 25))
    {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      if ((jdField_a_of_type_AndroidSupportV4UtilArrayMap != null) && (jdField_a_of_type_AndroidSupportV4UtilArrayMap.size() <= 25)) {
        break label434;
      }
      jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
      if ((p != 1) || (WebProcessReceiver.a != 1)) {
        break label443;
      }
      i2 = 1;
      q = 1;
      jdField_a_of_type_JavaUtilHashMap.put("from", paramIntent.getIntExtra("from_aio", 1) + "");
      jdField_a_of_type_JavaUtilHashMap.put("use_optimization", paramIntent.getIntExtra("from_aio_opt", 2) + "");
      HashMap localHashMap = jdField_a_of_type_JavaUtilHashMap;
      if (p != 1) {
        break label449;
      }
      str = "1";
      label193:
      localHashMap.put("first_open", str);
      jdField_a_of_type_JavaUtilHashMap.put("network_type", HttpUtil.a() + "");
      localHashMap = jdField_a_of_type_JavaUtilHashMap;
      if (WebProcessReceiver.a != 1) {
        break label455;
      }
      str = "1";
      label245:
      localHashMap.put("has_pp", str);
      if (WebProcessReceiver.a != 1) {
        break label461;
      }
    }
    for (;;)
    {
      jdField_a_of_type_JavaUtilHashMap.put("ps_state", i1 + "");
      b(paramIntent, "click_to_activity", SystemClock.uptimeMillis() - l1 + "");
      jdField_a_of_type_JavaUtilHashMap.put("open_finished", "2");
      jdField_a_of_type_AndroidSupportV4UtilArrayMap.put("web_finish", Long.valueOf(l1));
      a(paramIntent, "click_to_activity", "activity_to_webview");
      paramIntent.removeExtra("from_aio");
      paramIntent.removeExtra("from_aio_time");
      paramIntent.removeExtra("from_aio_opt");
      if ((Build.VERSION.SDK_INT <= 10) || (i2 == 0)) {
        break;
      }
      paramIntent = BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4);
      i1 = paramIntent.getInt("aio_hit_count", 0);
      paramIntent.edit().putInt("aio_hit_count", i1 + 1).commit();
      return;
      jdField_a_of_type_JavaUtilHashMap.clear();
      break label63;
      label434:
      jdField_a_of_type_AndroidSupportV4UtilArrayMap.clear();
      break label90;
      label443:
      i2 = 0;
      break label107;
      label449:
      str = "2";
      break label193;
      label455:
      str = "2";
      break label245;
      label461:
      if ((SwiftBrowserStatistics.l) || (p > 1)) {
        i1 = 2;
      } else {
        i1 = 3;
      }
    }
  }
  
  public static void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent.putExtra("aio_open_web", true);
    paramIntent.putExtra("from_aio_opt", paramInt2);
    paramIntent.putExtra("from_aio", paramInt1);
    paramIntent.putExtra("from_aio_time", SystemClock.uptimeMillis());
  }
  
  public static void a(Intent paramIntent, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      break label4;
    }
    label4:
    while (SystemClock.uptimeMillis() % 10L != 1L) {
      return;
    }
    int i2 = CGILoader.a(paramMessageRecord.istroop);
    if (WebAccelerator.a) {}
    for (int i1 = 1;; i1 = 2)
    {
      a(paramIntent, i2, i1);
      paramIntent = paramMessageRecord.frienduin;
      long l1 = paramMessageRecord.msgUid;
      i1 = paramMessageRecord.istroop;
      if (TextUtils.isEmpty(paramIntent)) {
        break;
      }
      ThreadManager.a(new ncd(paramQQAppInterface, i1, paramIntent, l1), 2, null, false);
      return;
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {}
    while ((q != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false)) || ((!paramString.startsWith("http:")) && (!paramString.startsWith("https:")))) {
      return;
    }
    a(paramIntent, "activity_to_webview", null);
    c(paramIntent, paramString);
    e(paramIntent, paramString);
    a(paramIntent, null, "wb_c");
  }
  
  public static void a(Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramIntent == null) {}
    long l1;
    do
    {
      do
      {
        return;
      } while ((q != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false)));
      l1 = SystemClock.uptimeMillis();
      if (paramString1 != null)
      {
        paramIntent = (Long)jdField_a_of_type_AndroidSupportV4UtilArrayMap.remove(paramString1);
        if (paramIntent != null) {
          jdField_a_of_type_JavaUtilHashMap.put(paramString1, l1 - paramIntent.longValue() + "");
        }
      }
    } while (paramString2 == null);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramString2, Long.valueOf(l1));
  }
  
  public static void b(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while ((q != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false)));
      a(paramIntent, "wb_c", null);
      a(paramIntent, "web_finish", null);
    } while (q != 1);
    q = 2;
    jdField_a_of_type_JavaUtilHashMap.put("open_finished", "1");
  }
  
  public static void b(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {}
    while ((q != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false))) {
      return;
    }
    d(paramIntent, paramString);
    f(paramIntent, paramString);
  }
  
  public static void b(Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramIntent == null) {}
    while ((q != 1) || (!paramIntent.getBooleanExtra("aio_open_web", false))) {
      return;
    }
    jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public static void c(Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        return;
      } while ((!paramIntent.getBooleanExtra("aio_open_web", false)) || (jdField_a_of_type_JavaUtilHashMap == null));
      str = (String)jdField_a_of_type_JavaUtilHashMap.get("open_finished");
    } while ((str == null) || (!str.equals("2")));
    a(paramIntent, "web_finish", null);
  }
  
  private static void c(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (paramString == null)) {}
    while ((!paramString.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      return;
    }
    D = paramString;
    a(paramIntent, null, "safe_check");
  }
  
  public static void d(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      do
      {
        return;
      } while (!paramIntent.getBooleanExtra("aio_open_web", false));
      paramIntent.removeExtra("aio_open_web");
    } while ((jdField_a_of_type_JavaUtilHashMap == null) || (TextUtils.isEmpty((CharSequence)jdField_a_of_type_JavaUtilHashMap.get("from"))));
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get("safe_check");
    paramIntent = (String)jdField_a_of_type_JavaUtilHashMap.get("short_link");
    try
    {
      l1 = Long.parseLong(str);
    }
    catch (Exception localException)
    {
      try
      {
        for (;;)
        {
          l2 = Long.parseLong(paramIntent);
          if (l1 != 0L) {
            break;
          }
          jdField_a_of_type_JavaUtilHashMap.put("has_safecheck", "2");
          if (l2 != 0L) {
            break label244;
          }
          jdField_a_of_type_JavaUtilHashMap.put("has_short_link", "2");
          StatisticCollector.a(BaseApplication.getContext()).a(null, "AIOWeb", false, 0L, 0L, jdField_a_of_type_JavaUtilHashMap, "", false);
          q = -1;
          if (Build.VERSION.SDK_INT > 10)
          {
            paramIntent = BaseApplicationImpl.a().getSharedPreferences("web_process_preload_file", 4);
            l1 = paramIntent.getLong("aio_preload_qweb_last", 0L);
            l2 = System.currentTimeMillis();
            if (l1 != 0L) {
              break label258;
            }
            paramIntent.edit().putLong("aio_preload_qweb_last", l2).commit();
          }
          jdField_a_of_type_JavaUtilHashMap.clear();
          jdField_a_of_type_AndroidSupportV4UtilArrayMap.clear();
          return;
          localException = localException;
          l1 = 0L;
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          long l1;
          long l2 = 0L;
          continue;
          jdField_a_of_type_JavaUtilHashMap.put("has_safecheck", "1");
          continue;
          label244:
          jdField_a_of_type_JavaUtilHashMap.put("has_short_link", "1");
          continue;
          label258:
          if (l2 - l1 > 86400000L)
          {
            int i1 = paramIntent.getInt("aio_preload_qweb_cout", 0);
            int i2 = paramIntent.getInt("aio_hit_count", 0);
            HashMap localHashMap = new HashMap();
            localHashMap.put("hit_count", i2 + "");
            localHashMap.put("preload_count", i1 + "");
            StatisticCollector.a(BaseApplication.getContext()).a(null, "AIOWebPreloadhit", false, 0L, 0L, localHashMap, "", false);
            paramIntent.edit().putInt("aio_preload_qweb_cout", 0).putLong("aio_preload_qweb_last", l2).putInt("aio_hit_count", 0).commit();
          }
        }
      }
    }
  }
  
  private static void d(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (paramString == null)) {
      return;
    }
    if ((D != null) && (D.contains(URLEncoder.encode(paramString)))) {
      a(paramIntent, "safe_check", null);
    }
    D = "";
  }
  
  private static void e(Intent paramIntent, String paramString)
  {
    if (paramString == null) {}
    while (!WebAccelerator.c(paramString)) {
      return;
    }
    a(paramIntent, null, "short_link");
  }
  
  private static void f(Intent paramIntent, String paramString)
  {
    if (paramString == null) {}
    while ((!paramString.startsWith("http:")) && (!paramString.startsWith("https:"))) {
      return;
    }
    a(paramIntent, "short_link", null);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\AIOOpenWebMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */