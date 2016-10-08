package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText.EmotcationSpan;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarUtils
{
  public static final String A = "";
  protected static final String B = "刚刚";
  protected static final String C = "分钟前";
  protected static final String D = "MM-dd";
  protected static final String E = "HH:mm";
  protected static final String F = "昨天";
  protected static final String G = "前天";
  private static final String H = "&_wv=1031&_bid=128&platform=android&from=native&version=6.5.5";
  public static final int a = 20;
  public static final String a = "TroopBar";
  protected static SimpleDateFormat a;
  public static final HashMap a;
  public static Hashtable a;
  public static final int b = 50;
  public static final String b = "http://buluo.qq.com/cgi-bin/bar/";
  public static final HashMap b = new HashMap();
  public static final int c = -1;
  public static final String c = "http://buluo.qq.com/cgi-bin/bar/page";
  public static final HashMap c = new HashMap();
  protected static final int d = 60000;
  public static final String d = "http://buluo.qq.com/cgi-bin/bar/user/fbar";
  protected static final int e = 86400000;
  public static final String e = "http://buluo.qq.com/cgi-bin/bar/sign";
  protected static final int f = 1440;
  public static final String f = "http://buluo.qq.com/cgi-bin/bar/get_category_post_by_page";
  protected static final int g = 2880;
  public static final String g = "http://buluo.qq.com/cgi-bin/bar/get_best_post_by_page";
  public static final int h = 100000;
  public static final String h = "http://buluo.qq.com/cgi-bin/bar/get_post_by_page";
  public static final int i = 100001;
  public static final String i = "http://buluo.qq.com/cgi-bin/bar/jump?";
  public static final int j = 100003;
  public static final String j = "http://buluo.qq.com/cgi-bin/bar/user/poilist";
  public static final int k = 100004;
  public static final String k = "http://buluo.qq.com/cgi-bin/bar/mybarlist";
  public static final int l = 100012;
  public static final String l = "http://buluo.qq.com/cgi-bin/bar/bar_publish_info";
  public static final int m = -1001;
  public static final String m = "http://upload.buluo.qq.com/cgi-bin/bar/upload/image";
  public static final int n = -1002;
  public static final String n = "http://upload.buluo.qq.com/cgi-bin/bar/upload/meida";
  public static final int o = 0;
  public static final String o = "action";
  public static final int p = 1;
  public static final String p = "info";
  public static final int q = 2;
  public static final String q = "all_bar";
  public static final int r = 3;
  public static final String r = "publish";
  public static final int s = 5;
  public static final String s = "qqweb_index";
  public static final int t = 8;
  public static final String t = "&_wv=1031";
  public static final int u = 9991;
  public static final String u = "target=hot&_wv=1031";
  public static final int v = 9992;
  public static final String v = "extparam";
  public static final int w = 9992;
  public static final String w = "http://buluo.qq.com/cgi-bin/bar/jump?bid=%s";
  public static final String x = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB";
  public static final String y = " ";
  public static final String z = "  ";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat();
    jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static int a(String paramString, char paramChar)
  {
    int i2 = 0;
    if (paramString != null) {
      for (int i1 = 0;; i1 = i3)
      {
        i3 = i1;
        if (i2 >= paramString.length()) {
          break;
        }
        i3 = i1;
        if (paramString.charAt(i2) == paramChar) {
          i3 = i1 + 1;
        }
        i2 += 1;
      }
    }
    int i3 = 0;
    return i3;
  }
  
  public static final Uri a(BaseActivity paramBaseActivity, String paramString, int paramInt)
  {
    if (QavCameraUsage.b(BaseApplicationImpl.getContext())) {}
    do
    {
      return null;
      paramString = new File(paramString);
      if (paramString.exists()) {}
      for (boolean bool = true; (bool) && (paramString.canWrite()); bool = paramString.mkdirs())
      {
        paramString = Uri.fromFile(new File(AppConstants.bo + System.currentTimeMillis() + ".jpg"));
        Intent localIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        localIntent.putExtra("output", paramString);
        localIntent.putExtra("android.intent.extra.videoQuality", 100);
        paramBaseActivity.startActivityForResult(localIntent, paramInt);
        return paramString;
      }
    } while ((paramBaseActivity == null) || (paramBaseActivity.isFinishing()));
    QQToast.a(paramBaseActivity, 2131364811, 1).b(paramBaseActivity.getTitleBarHeight());
    return null;
  }
  
  public static final String a(EditText paramEditText)
  {
    int i2 = 0;
    if (paramEditText == null) {
      return null;
    }
    if ((paramEditText.getEditableText() instanceof QQTextBuilder))
    {
      QQTextBuilder localQQTextBuilder = (QQTextBuilder)paramEditText.getEditableText();
      if (localQQTextBuilder != null)
      {
        int i1 = localQQTextBuilder.length();
        Object localObject1 = new char[i1];
        localQQTextBuilder.getChars(0, i1, (char[])localObject1, 0);
        paramEditText = new StringBuffer();
        paramEditText.append((char[])localObject1);
        localObject1 = (QQText.EmotcationSpan[])localQQTextBuilder.getSpans(0, i1, QQText.EmotcationSpan.class);
        int i3 = 0;
        if (i2 < localObject1.length)
        {
          Object localObject2 = localObject1[i2];
          int i4;
          if (((QQText.EmotcationSpan)localObject2).c == 1)
          {
            i1 = localQQTextBuilder.getSpanStart(localObject2);
            i4 = localQQTextBuilder.getSpanEnd(localObject2);
            localObject2 = com.tencent.mobileqq.text.EmotcationConstants.a[(localObject2.a & 0x7FFFFFFF)];
            paramEditText.replace(i1 + i3, i4 + i3, (String)localObject2);
            i1 = i3 + (((String)localObject2).length() - (i4 - i1));
          }
          for (;;)
          {
            i2 += 1;
            i3 = i1;
            break;
            i1 = i3;
            if (((QQText.EmotcationSpan)localObject2).c == 2)
            {
              i1 = localQQTextBuilder.getSpanStart(localObject2);
              i4 = localQQTextBuilder.getSpanEnd(localObject2);
              localObject2 = ((QQText.EmotcationSpan)localObject2).a();
              paramEditText.replace(i1 + i3, i4 + i3, (String)localObject2);
              i1 = i3 + (((String)localObject2).length() - (i4 - i1));
            }
          }
        }
        return paramEditText.toString();
      }
    }
    return paramEditText.getEditableText().toString();
  }
  
  public static final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    long l2;
    long l1;
    do
    {
      long l5;
      do
      {
        long l4;
        try
        {
          l5 = 1000L * Long.valueOf(paramString).longValue();
          l2 = NetConnInfoCenter.getServerTime();
          l1 = l2;
          if (l2 <= 0L) {
            l1 = (int)MessageCache.a();
          }
          long l6 = l1 * 1000L;
          paramString = Calendar.getInstance();
          Calendar localCalendar = Calendar.getInstance();
          paramString.setTimeInMillis(l5);
          localCalendar.setTimeInMillis(l6);
          l4 = l5 / 86400000L;
          l3 = l5 / 60000L;
          l1 = l5 / 1000L;
          l5 = l6 / 60000L;
          l2 = l6 / 1000L;
          l6 /= 86400000L;
          if (paramString.before(localCalendar))
          {
            l4 = l6 - l4;
            if (l4 > 2L)
            {
              jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("MM-dd");
              return jdField_a_of_type_JavaTextSimpleDateFormat.format(paramString.getTime());
            }
            if (l4 == 2L)
            {
              jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("HH:mm");
              return "前天" + jdField_a_of_type_JavaTextSimpleDateFormat.format(paramString.getTime());
              if (l3 < 60L) {
                return l3 + "分钟前";
              }
              jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("HH:mm");
              return "昨天" + jdField_a_of_type_JavaTextSimpleDateFormat.format(paramString.getTime());
              if (l3 < 60L) {
                return l3 + "分钟前";
              }
              jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("HH:mm");
              return jdField_a_of_type_JavaTextSimpleDateFormat.format(paramString.getTime());
            }
          }
          else
          {
            jdField_a_of_type_JavaTextSimpleDateFormat.applyPattern("MM-dd");
            paramString = jdField_a_of_type_JavaTextSimpleDateFormat.format(paramString.getTime());
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          return "";
        }
        if (l4 != 1L) {
          break;
        }
        l3 = l5 - l3;
      } while (l2 - l1 >= 60L);
      return "刚刚";
      long l3 = l5 - l3;
    } while (l2 - l1 >= 60L);
    return "刚刚";
  }
  
  public static final JSONObject a(String paramString1, Context paramContext, String paramString2, String paramString3, String paramString4, Map paramMap)
  {
    HashMap localHashMap1;
    HashMap localHashMap2;
    if (FileUtil.a(paramString2))
    {
      localHashMap1 = new HashMap();
      localHashMap1.put("Connection", "keep-alive");
      localHashMap1.put("Referer", "http://www.qq.com");
      localHashMap2 = new HashMap();
      localHashMap2.put("file", paramString2);
      if (paramMap != null) {
        break label236;
      }
    }
    label236:
    for (paramContext = new HashMap();; paramContext = paramMap)
    {
      paramContext.put("file", paramString2);
      long l1 = System.currentTimeMillis();
      paramString1 = HttpUtil.a(paramString1, paramString3, paramString4, paramContext, localHashMap2, localHashMap1);
      if (QLog.isColorLevel()) {
        QLog.d("TroopBar", 2, "singleUploadImage t = " + (System.currentTimeMillis() - l1) + ", path = " + paramString2 + ", size = " + FileUtil.a(paramString2));
      }
      if (TextUtils.isEmpty(paramString1)) {
        return null;
      }
      try
      {
        paramString1 = new JSONObject(paramString1);
        if ((paramString1.optInt("retcode", -1) == 0) || (paramString1.optInt("ret", -1) == 0))
        {
          paramString1 = paramString1.getJSONObject("result");
          return paramString1;
        }
      }
      catch (JSONException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, paramString1.getMessage());
        }
      }
      return null;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback, String paramString4)
  {
    if ((paramBundle1 != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramBundle1.putString("version", "6.5.5");
      paramBundle1.putString("platform", "android");
      paramBundle1.putString("mType", "qb_troop_bar");
      paramBundle1.putString("Cookie", "uin=" + paramString1 + ";skey=" + paramString2);
      paramBundle1.putString("Referer", "http://buluo.qq.com");
      paramString1 = new HashMap();
      paramString1.put("BUNDLE", paramBundle1);
      paramString1.put("CONTEXT", paramContext.getApplicationContext());
      new HttpWebCgiAsyncTask(paramString3, paramString4, paramCallback, paramInt, paramBundle2).execute(new HashMap[] { paramString1 });
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TroopBar", 2, "httpGet skey is null!!!!!!!!!!!!!!!");
  }
  
  public static void a(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    a(paramBaseActivity, paramBundle1, paramString, paramInt, paramBundle2, paramCallback, "GET");
  }
  
  protected static void a(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString1, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback, String paramString2)
  {
    AppRuntime localAppRuntime = paramBaseActivity.getAppRuntime();
    String str = localAppRuntime.getAccount();
    a(paramBaseActivity, str, ((TicketManager)localAppRuntime.getManager(2)).getSkey(str), paramBundle1, paramString1, paramInt, paramBundle2, paramCallback, paramString2);
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3)
  {
    a("tribe_hp", paramString1, paramString2, paramString3, "", "");
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a("Grp_tribe", paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString5)) && (paramString1.equals("Grp_tribe")) && (paramString5.equals("sbarindex"))) {
      return;
    }
    ReportController.b(null, "P_CliOper", paramString1, "", paramString2, paramString3, 0, 0, paramString4, paramString5, paramString6, paramString7);
  }
  
  public static byte[] a(Object paramObject)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      paramObject = localByteArrayOutputStream.toByteArray();
      localObjectOutputStream.flush();
      localObjectOutputStream.close();
      localByteArrayOutputStream.close();
      return (byte[])paramObject;
    }
    catch (IOException paramObject)
    {
      ((IOException)paramObject).printStackTrace();
    }
    return null;
  }
  
  public static void b(BaseActivity paramBaseActivity, Bundle paramBundle1, String paramString, int paramInt, Bundle paramBundle2, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    a(paramBaseActivity, paramBundle1, paramString, paramInt, paramBundle2, paramCallback, "POST");
  }
  
  public static final void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "dc00899", "Grp_tribe", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopBarUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */