package com.tencent.kingkong;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Common
{
  public static String A = "";
  public static String B = "";
  public static String C = File.separator;
  public static String D = "";
  public static String E = "";
  public static final int a = 1;
  public static Context a;
  public static SharedPreferences.Editor a;
  public static SharedPreferences a;
  public static ReportThread a;
  public static Utils.InterProcessLock a;
  public static final String a = "KingKongCommon";
  public static boolean a = false;
  public static final int b = 2;
  public static final String b = "SHARED_PREFERENCE_KINGKONG_PATCH";
  public static boolean b = false;
  public static final int c = 3;
  public static final String c = "DPC_STATUS";
  public static boolean c = false;
  public static final int d = 4;
  public static final String d = "INITIAL_FAILED";
  public static boolean d = false;
  public static final int e = 5;
  public static final String e = "DO_PATCH";
  public static boolean e = false;
  public static final int f = 6;
  public static final String f = "PATCH_STATUS";
  public static final int g = 7;
  public static final String g = "POINT_LOG";
  public static final int h = 0;
  public static final String h = "POINT_LOG_CRASH_COUNT";
  public static final int i = 1;
  public static final String i = "POINT_LOG_CONTINUOUS_COUNT";
  public static final int j = 2;
  public static final String j = "INITIALIZE_STATUS";
  public static final int k = 3;
  public static final String k = "LAST_UPDATE_TIME";
  public static final int l = 4;
  public static final String l = "UPDATE_STATUS";
  public static final int m = 5;
  public static final String m = "QQUni";
  public static final int n = 0;
  public static final String n = "JUMPER";
  public static final int o = 1;
  public static final String o = "GOTHOOK";
  public static final int p = 2;
  public static final String p = "HOOKPOINT_COUNT";
  public static final int q = 0;
  public static final String q = "FINGERPRINT_LIB_SHA1";
  public static final int r = 1;
  public static final String r = "FINGERPRINT_LIB";
  public static final int s = 2;
  public static final String s = "FINGERPRINT_LIB_COUNT";
  public static final int t = 0;
  public static final String t = "SUBPATCH_INDEX";
  public static final int u = 1;
  public static final String u = "KingkongPatchInterprocess.Lock";
  public static final int v = 2;
  public static final String v = "KingkongUpdateInterprocess.Lock";
  public static final int w = 3;
  public static final String w = "patches";
  public static final String x = "download";
  public static final String y = "kingkong";
  public static String z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    z = "";
  }
  
  public static void EvilReportFromNative(int paramInt, String paramString1, String paramString2)
  {
    Common.Log.a("KingKongCommon", "Evil Report " + paramString1 + ", " + paramString2);
    if (jdField_a_of_type_ComTencentKingkongReportThread != null)
    {
      paramString1 = "&str1=" + paramString1 + "&str2=" + paramString2;
      jdField_a_of_type_ComTencentKingkongReportThread.a(paramInt, 0, 0, paramString1);
    }
  }
  
  public static void NotificationFromNative(int paramInt1, int paramInt2, int paramInt3)
  {
    Common.Log.a("KingKongCommon", "Notification From Native " + paramInt1 + ", " + paramInt2 + ", " + paramInt3);
    if (jdField_a_of_type_ComTencentKingkongReportThread != null) {
      jdField_a_of_type_ComTencentKingkongReportThread.a(paramInt1, paramInt2, paramInt3, "");
    }
  }
  
  /* Error */
  public static void OnLogin(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 177	com/tencent/kingkong/Common:SetContext	(Landroid/content/Context;)V
    //   7: getstatic 179	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   10: astore_0
    //   11: aload_0
    //   12: ifnonnull +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: aload_1
    //   20: invokestatic 183	com/tencent/kingkong/Common:SetQQUni	(Ljava/lang/String;)V
    //   23: getstatic 155	com/tencent/kingkong/Common:jdField_a_of_type_ComTencentKingkongReportThread	Lcom/tencent/kingkong/ReportThread;
    //   26: ifnonnull +19 -> 45
    //   29: new 161	com/tencent/kingkong/ReportThread
    //   32: dup
    //   33: invokespecial 184	com/tencent/kingkong/ReportThread:<init>	()V
    //   36: putstatic 155	com/tencent/kingkong/Common:jdField_a_of_type_ComTencentKingkongReportThread	Lcom/tencent/kingkong/ReportThread;
    //   39: getstatic 155	com/tencent/kingkong/Common:jdField_a_of_type_ComTencentKingkongReportThread	Lcom/tencent/kingkong/ReportThread;
    //   42: invokevirtual 187	com/tencent/kingkong/ReportThread:start	()V
    //   45: new 189	kez
    //   48: dup
    //   49: invokespecial 190	kez:<init>	()V
    //   52: invokevirtual 191	kez:start	()V
    //   55: goto -40 -> 15
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramContext	Context
    //   0	64	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   3	11	58	finally
    //   19	45	58	finally
    //   45	55	58	finally
  }
  
  public static void SetContext(Context paramContext)
  {
    if ((paramContext != null) && (jdField_a_of_type_AndroidContentContext == null))
    {
      jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
      DataReport.a(jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public static void SetDPCStatus(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).edit();
    paramContext.putBoolean("DPC_STATUS", paramBoolean);
    paramContext.commit();
  }
  
  public static void SetQQUni(String paramString)
  {
    DataReport.a(paramString);
  }
  
  /* Error */
  public static void SetSafeStatus(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 229	com/tencent/kingkong/Common:a	()Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifne +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 179	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   18: ifnull -7 -> 11
    //   21: iload_0
    //   22: ifeq -11 -> 11
    //   25: getstatic 231	com/tencent/kingkong/Common:jdField_a_of_type_Boolean	Z
    //   28: ifne -17 -> 11
    //   31: getstatic 233	com/tencent/kingkong/Common:b	Z
    //   34: ifne -23 -> 11
    //   37: iconst_1
    //   38: putstatic 233	com/tencent/kingkong/Common:b	Z
    //   41: invokestatic 235	com/tencent/kingkong/Common:b	()V
    //   44: new 237	kfa
    //   47: dup
    //   48: invokespecial 238	kfa:<init>	()V
    //   51: invokevirtual 239	kfa:start	()V
    //   54: goto -43 -> 11
    //   57: astore_1
    //   58: ldc 2
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	paramBoolean	boolean
    //   57	5	1	localObject	Object
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	57	finally
    //   15	21	57	finally
    //   25	54	57	finally
  }
  
  public static int a()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt("INITIALIZE_STATUS", 0);
  }
  
  public static int a(String paramString, ArrayList paramArrayList)
  {
    int i2 = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("FINGERPRINT_LIB_COUNT", paramString), -1);
    if ((i2 == -1) || (i2 != paramArrayList.size()))
    {
      Common.Log.a("KingKongCommon", "Library count mismatch " + i2 + ", " + paramArrayList.size());
      return -1;
    }
    int i1 = 0;
    while (i1 < i2)
    {
      String str1 = jdField_a_of_type_AndroidContentSharedPreferences.getString(a("FINGERPRINT_LIB", paramString, i1), "");
      if (!((String)paramArrayList.get(i1)).equals(str1))
      {
        Common.Log.a("KingKongCommon", "Library name mismatch " + str1 + ", " + (String)paramArrayList.get(i1));
        return -1;
      }
      String str2 = Utils.c(str1);
      if (TextUtils.isEmpty(str2))
      {
        Common.Log.a("KingKongCommon", "Unable to get file SHA1 " + str1);
        return -1;
      }
      String str3 = jdField_a_of_type_AndroidContentSharedPreferences.getString(a("FINGERPRINT_LIB_SHA1", paramString, i1), "");
      if (!str3.equals(str2))
      {
        Common.Log.a("KingKongCommon", "Library SHA1 mismatch " + str1 + ", " + str3 + ", " + str2);
        return -1;
      }
      i1 += 1;
    }
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("SUBPATCH_INDEX", paramString), -1);
  }
  
  public static String a()
  {
    return A;
  }
  
  public static String a(String paramString)
  {
    return A + C + paramString;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  private static String a(String paramString1, String paramString2, int paramInt)
  {
    return paramString1 + "_" + paramString2 + "_" + paramInt;
  }
  
  public static void a()
  {
    int i1 = b();
    StringBuffer localStringBuffer = new StringBuffer();
    int i2 = d();
    try
    {
      localStringBuffer.append("&str1=").append(URLEncoder.encode(Integer.toString(i1), "UTF-8")).append("&str2=").append(URLEncoder.encode(Integer.toString(i2), "UTF-8"));
      if (jdField_a_of_type_ComTencentKingkongReportThread != null) {
        jdField_a_of_type_ComTencentKingkongReportThread.a(2087, 0, 0, localStringBuffer.toString());
      }
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("INITIALIZE_STATUS", paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    if (jdField_a_of_type_ComTencentKingkongReportThread != null) {}
    try
    {
      jdField_a_of_type_ComTencentKingkongReportThread.a(paramInt, 0, 0, "&str1=" + URLEncoder.encode(paramString1, "UTF-8") + "&str3=" + URLEncoder.encode(paramString2, "UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Common.Log.a("KingKongCommon", "Do patch " + paramInt + ", " + paramString1 + ", " + paramString2 + ", " + paramString3 + ", " + paramString4);
    String str = a("DO_PATCH", paramString1, paramInt);
    if ((!jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(str, false)) && (jdField_a_of_type_ComTencentKingkongReportThread != null)) {}
    try
    {
      jdField_a_of_type_ComTencentKingkongReportThread.a(2081, paramInt, 0, "&str1=" + URLEncoder.encode(paramString1, "UTF-8") + "&str2=" + URLEncoder.encode(paramString2, "UTF-8") + "&str3=" + URLEncoder.encode(paramString3, "UTF-8") + "&v1=" + URLEncoder.encode(paramString4, "UTF-8"));
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean(str, true);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("UPDATE_STATUS", paramString);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static void a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    int i2 = paramArrayList.size();
    if (i2 > 15) {
      return;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        break label94;
      }
      String str1 = (String)paramArrayList.get(i1);
      String str2 = Utils.c(str1);
      if (TextUtils.isEmpty(str2)) {
        break;
      }
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString(a("FINGERPRINT_LIB_SHA1", paramString, i1), str2);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString(a("FINGERPRINT_LIB", paramString, i1), str1);
      i1 += 1;
    }
    label94:
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("FINGERPRINT_LIB_COUNT", paramString), i2);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("SUBPATCH_INDEX", paramString), paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static void a(String paramString, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1.length != paramArrayOfInt2.length) || (paramArrayOfInt1.length > 15) || (paramArrayOfInt1.length != paramInt))
    {
      Common.Log.a("KingKongCommon", "Params count mismatch : " + paramArrayOfInt1.length + ", " + paramArrayOfInt2.length + ", " + paramInt);
      return;
    }
    int i1 = 0;
    while (i1 < paramInt)
    {
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("JUMPER", paramString, i1), paramArrayOfInt1[i1]);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("GOTHOOK", paramString, i1), paramArrayOfInt2[i1]);
      i1 += 1;
    }
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt(a("HOOKPOINT_COUNT", paramString), paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static void a(String paramString, int[] paramArrayOfInt)
  {
    int i1 = 0;
    String str;
    if (jdField_a_of_type_ComTencentKingkongReportThread != null)
    {
      Common.Log.a("KingKongCommon", "Report fingerprint : " + paramString);
      str = "";
      while (i1 < paramArrayOfInt.length)
      {
        str = str + "&v" + (i1 + 1) + "=" + paramArrayOfInt[i1];
        i1 += 1;
      }
    }
    try
    {
      paramString = "" + "&str1=" + URLEncoder.encode(paramString, "UTF-8");
      paramString = paramString + str;
      jdField_a_of_type_ComTencentKingkongReportThread.a(2086, 0, 0, paramString);
      return;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Constant.D += 1;; Constant.D = 0)
    {
      d(Constant.D);
      return;
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 14) {
      return false;
    }
    return Build.CPU_ABI.contains("armeabi");
  }
  
  public static boolean a(String paramString)
  {
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= 13) {
        break;
      }
      String str = a("DO_PATCH", paramString, i1);
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(str);
      i1 += 1;
    }
    while (i2 < 15)
    {
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("FINGERPRINT_LIB", paramString, i2));
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("FINGERPRINT_LIB_SHA1", paramString, i2));
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("GOTHOOK", paramString, i2));
      jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("JUMPER", paramString, i2));
      i2 += 1;
    }
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("FINGERPRINT_LIB_COUNT", paramString));
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("SUBPATCH_INDEX", paramString));
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.remove(a("HOOKPOINT_COUNT", paramString));
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
    return true;
  }
  
  public static int[] a(String paramString)
  {
    int i2 = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("HOOKPOINT_COUNT", paramString), -1);
    if (i2 == -1) {
      return null;
    }
    int[] arrayOfInt = new int[i2];
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        return arrayOfInt;
      }
      arrayOfInt[i1] = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("GOTHOOK", paramString, i1), -1);
      if (arrayOfInt[i1] == -1) {
        break;
      }
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  private static int b()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt("POINT_LOG_CRASH_COUNT", 0);
  }
  
  public static String b()
  {
    return B;
  }
  
  public static String b(String paramString)
  {
    return B + C + paramString;
  }
  
  /* Error */
  public static void b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 382	com/tencent/kingkong/Common:c	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 382	com/tencent/kingkong/Common:c	Z
    //   19: getstatic 179	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   22: ldc 26
    //   24: iconst_0
    //   25: invokevirtual 207	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   28: putstatic 242	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   31: getstatic 242	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   34: invokeinterface 213 1 0
    //   39: putstatic 323	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentSharedPreferences$Editor	Landroid/content/SharedPreferences$Editor;
    //   42: getstatic 179	com/tencent/kingkong/Common:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   45: invokevirtual 386	android/content/Context:getFilesDir	()Ljava/io/File;
    //   48: invokevirtual 389	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   51: putstatic 112	com/tencent/kingkong/Common:z	Ljava/lang/String;
    //   54: new 135	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   61: getstatic 112	com/tencent/kingkong/Common:z	Ljava/lang/String;
    //   64: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: getstatic 123	com/tencent/kingkong/Common:C	Ljava/lang/String;
    //   70: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc 100
    //   75: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: getstatic 123	com/tencent/kingkong/Common:C	Ljava/lang/String;
    //   81: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 97
    //   86: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: putstatic 114	com/tencent/kingkong/Common:A	Ljava/lang/String;
    //   95: new 135	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   102: getstatic 112	com/tencent/kingkong/Common:z	Ljava/lang/String;
    //   105: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 123	com/tencent/kingkong/Common:C	Ljava/lang/String;
    //   111: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 100
    //   116: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 123	com/tencent/kingkong/Common:C	Ljava/lang/String;
    //   122: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 94
    //   127: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: putstatic 116	com/tencent/kingkong/Common:B	Ljava/lang/String;
    //   136: new 135	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   143: getstatic 112	com/tencent/kingkong/Common:z	Ljava/lang/String;
    //   146: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: getstatic 123	com/tencent/kingkong/Common:C	Ljava/lang/String;
    //   152: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 88
    //   157: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: putstatic 125	com/tencent/kingkong/Common:D	Ljava/lang/String;
    //   166: new 135	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   173: getstatic 112	com/tencent/kingkong/Common:z	Ljava/lang/String;
    //   176: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: getstatic 123	com/tencent/kingkong/Common:C	Ljava/lang/String;
    //   182: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 91
    //   187: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: putstatic 127	com/tencent/kingkong/Common:E	Ljava/lang/String;
    //   196: new 391	com/tencent/kingkong/Utils$InterProcessLock
    //   199: dup
    //   200: getstatic 125	com/tencent/kingkong/Common:D	Ljava/lang/String;
    //   203: invokespecial 393	com/tencent/kingkong/Utils$InterProcessLock:<init>	(Ljava/lang/String;)V
    //   206: putstatic 395	com/tencent/kingkong/Common:jdField_a_of_type_ComTencentKingkongUtils$InterProcessLock	Lcom/tencent/kingkong/Utils$InterProcessLock;
    //   209: goto -198 -> 11
    //   212: astore_0
    //   213: ldc 2
    //   215: monitorexit
    //   216: aload_0
    //   217: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   212	5	0	localObject	Object
    //   6	2	1	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	212	finally
    //   15	209	212	finally
  }
  
  private static void b(int paramInt)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("POINT_LOG_CRASH_COUNT", paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Common.Log.a("KingKongCommon", "evil catched " + paramInt + ", " + paramString1 + ", " + paramString2 + ", " + paramString3 + ", " + paramString4);
    if (jdField_a_of_type_ComTencentKingkongReportThread != null) {}
    try
    {
      jdField_a_of_type_ComTencentKingkongReportThread.a(2082, paramInt, 0, "&str1=" + URLEncoder.encode(paramString1, "UTF-8") + "&str2=" + URLEncoder.encode(paramString2, "UTF-8") + "&str3=" + URLEncoder.encode(paramString3, "UTF-8") + "&v1=" + URLEncoder.encode(paramString4, "UTF-8"));
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putBoolean("PATCH_STATUS", paramBoolean);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static int[] b(String paramString)
  {
    int i2 = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("HOOKPOINT_COUNT", paramString), -1);
    if (i2 == -1) {
      return null;
    }
    int[] arrayOfInt = new int[i2];
    int i1 = 0;
    for (;;)
    {
      if (i1 >= i2) {
        return arrayOfInt;
      }
      arrayOfInt[i1] = jdField_a_of_type_AndroidContentSharedPreferences.getInt(a("JUMPER", paramString, i1), -1);
      if (arrayOfInt[i1] == -1) {
        break;
      }
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  private static int c()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt("POINT_LOG_CONTINUOUS_COUNT", 0);
  }
  
  public static String c()
  {
    return D;
  }
  
  private static void c(int paramInt)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("POINT_LOG_CONTINUOUS_COUNT", paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  private static int d()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getInt("POINT_LOG", 0);
  }
  
  public static String d()
  {
    return E;
  }
  
  private static void d(int paramInt)
  {
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("POINT_LOG", paramInt);
    jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public static String e()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getString("UPDATE_STATUS", "");
  }
  
  private static boolean f()
  {
    int i1 = b();
    if (i1 >= 0)
    {
      if (d() == 0) {
        break label46;
      }
      b(i1 + 1);
      i1 = c();
      if (i1 >= 2)
      {
        b(false);
        a();
        return false;
      }
      c(i1 + 1);
    }
    for (;;)
    {
      return true;
      label46:
      c(0);
    }
  }
  
  private static boolean g()
  {
    return jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("PATCH_STATUS", true);
  }
  
  private static boolean h()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\kingkong\Common.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */