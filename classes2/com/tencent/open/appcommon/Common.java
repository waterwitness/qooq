package com.tencent.open.appcommon;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.js.AsyncMethodMap;
import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Common
{
  protected static final String A = "/mnt/sdcard-ext";
  public static final String B = "sd://";
  public static final String C = "file:///";
  public static final String D = "file:///android_asset" + File.separator + "Page/system";
  public static final String E = "applist.db";
  public static final int a = 2;
  public static final String n = "Common";
  public static final String o = "qzoneappcenter";
  public static final String p = ".AppCenterWebBuffer_QQ";
  public static final String q = "qapp_social_apps.html";
  public static final String r = "qapp_center_index.htm";
  public static final String s = "qapp_center_detail.htm";
  public static final String t = "system_old_";
  public static final String u = "tmp";
  public static final String v = "user";
  public static final String w = "resource.zip";
  public static final String x = "resource.diff";
  public static final String y = "resource_merged.zip";
  public static final String z = "Page/system";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getInt("appTabVersionCode", -1);
  }
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(f());
    return localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
  }
  
  /* Error */
  public static long a(java.io.InputStream paramInputStream, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 81	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 138	java/io/File:exists	()Z
    //   13: ifne +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 141	java/io/File:mkdir	()Z
    //   20: pop
    //   21: new 81	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: aload_2
    //   27: invokespecial 144	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: astore_3
    //   31: new 146	java/io/FileOutputStream
    //   34: dup
    //   35: aload_3
    //   36: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore_2
    //   40: aload_2
    //   41: astore_1
    //   42: sipush 4096
    //   45: newarray <illegal type>
    //   47: astore 4
    //   49: aload_2
    //   50: astore_1
    //   51: aload_0
    //   52: aload 4
    //   54: invokevirtual 155	java/io/InputStream:read	([B)I
    //   57: istore 5
    //   59: iconst_m1
    //   60: iload 5
    //   62: if_icmpeq +33 -> 95
    //   65: aload_2
    //   66: astore_1
    //   67: aload_2
    //   68: aload 4
    //   70: iconst_0
    //   71: iload 5
    //   73: invokevirtual 159	java/io/FileOutputStream:write	([BII)V
    //   76: goto -27 -> 49
    //   79: astore_0
    //   80: aload_2
    //   81: astore_1
    //   82: aload_0
    //   83: athrow
    //   84: astore_0
    //   85: aload_1
    //   86: ifnull +7 -> 93
    //   89: aload_1
    //   90: invokevirtual 162	java/io/FileOutputStream:close	()V
    //   93: aload_0
    //   94: athrow
    //   95: aload_2
    //   96: astore_1
    //   97: aload_2
    //   98: invokevirtual 165	java/io/FileOutputStream:flush	()V
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 162	java/io/FileOutputStream:close	()V
    //   109: aload_3
    //   110: invokevirtual 168	java/io/File:length	()J
    //   113: lreturn
    //   114: astore_0
    //   115: goto -6 -> 109
    //   118: astore_1
    //   119: goto -26 -> 93
    //   122: astore_0
    //   123: aconst_null
    //   124: astore_1
    //   125: goto -40 -> 85
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_1
    //   131: goto -49 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramInputStream	java.io.InputStream
    //   0	134	1	paramString1	String
    //   0	134	2	paramString2	String
    //   30	80	3	localFile	File
    //   47	22	4	arrayOfByte	byte[]
    //   57	15	5	i	int
    // Exception table:
    //   from	to	target	type
    //   42	49	79	java/lang/Exception
    //   51	59	79	java/lang/Exception
    //   67	76	79	java/lang/Exception
    //   97	101	79	java/lang/Exception
    //   42	49	84	finally
    //   51	59	84	finally
    //   67	76	84	finally
    //   82	84	84	finally
    //   97	101	84	finally
    //   105	109	114	java/lang/Exception
    //   89	93	118	java/lang/Exception
    //   31	40	122	finally
    //   31	40	128	java/lang/Exception
  }
  
  public static File a()
  {
    Object localObject;
    if (Environment.getExternalStorageState().equals("mounted")) {
      localObject = Environment.getExternalStorageDirectory();
    }
    File localFile;
    do
    {
      return (File)localObject;
      localFile = new File("/mnt/sdcard-ext");
      localObject = localFile;
    } while (localFile.isDirectory());
    return null;
  }
  
  public static String a(WebView paramWebView, HashMap paramHashMap, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray1 = new JSONArray();
    label701:
    for (;;)
    {
      try
      {
        localJSONObject.put("r", "-1");
        localJSONObject.put("data", localJSONArray1);
        JSONArray localJSONArray2 = new JSONArray(URLDecoder.decode(paramString, "UTF-8"));
        int i = 0;
        String str1;
        String str2;
        Object localObject;
        if (i < localJSONArray2.length())
        {
          paramWebView = localJSONArray2.optJSONObject(i);
          if (paramWebView == null) {
            break label701;
          }
          paramString = paramWebView.optString("ns");
          str1 = paramWebView.optString("method");
          str2 = paramWebView.optString("guid");
          paramWebView = paramWebView.optString("args");
          localObject = new ArrayList();
        }
        int j;
        Method[] arrayOfMethod;
        int k;
        i += 1;
      }
      catch (UnsupportedEncodingException paramWebView)
      {
        try
        {
          paramWebView = new JSONArray(paramWebView);
          j = 0;
          if (j < paramWebView.length())
          {
            ((List)localObject).add(paramWebView.getString(j));
            j += 1;
          }
          else
          {
            paramWebView = (Class)AsyncMethodMap.jdField_a_of_type_JavaUtilHashMap.get(paramString);
            if (AsyncMethodMap.jdField_a_of_type_JavaUtilArrayList.contains(str1)) {
              ((List)localObject).add(str2);
            }
            if (paramWebView != null)
            {
              arrayOfMethod = paramWebView.getMethods();
              k = arrayOfMethod.length;
              j = 0;
              if (j < k)
              {
                paramWebView = arrayOfMethod[j];
                if ((paramWebView.getName().equals(str1)) && (paramWebView.getParameterTypes().length == ((List)localObject).size()))
                {
                  if (paramWebView == null) {
                    break label701;
                  }
                  paramString = paramHashMap.get(paramString);
                  try
                  {
                    LogUtility.c("Common", "callBatch <call> class : " + paramString.getClass().getName() + " , method : " + str1 + "\n" + " , args : " + localObject.toString());
                    if (((List)localObject).size() != 0) {
                      continue;
                    }
                    paramString = paramWebView.invoke(paramString, new Object[0]);
                    paramWebView = paramWebView.getReturnType();
                    if ((paramWebView == Void.TYPE) || (paramWebView == Void.class) || (paramString == null)) {
                      break label701;
                    }
                    if (!(paramString instanceof String)) {
                      continue;
                    }
                    ((String)paramString).replace("\\", "\\\\").replace("'", "\\'");
                    paramWebView = (String)paramString;
                    paramString = new JSONObject();
                    localObject = new JSONArray();
                    paramString.put("guid", str2);
                    paramString.put("r", 0);
                    paramString.put("data", paramWebView);
                    ((JSONArray)localObject).put("interface." + str1);
                    ((JSONArray)localObject).put(paramString);
                    localJSONArray1.put(localObject);
                  }
                  catch (Exception paramWebView)
                  {
                    LogUtility.c("Common", "callBatch error", paramWebView);
                  }
                  paramWebView = paramWebView;
                  LogUtility.b("Common", "callBatch decode params format err", paramWebView);
                  return localJSONObject.toString();
                }
              }
            }
          }
        }
        catch (Exception paramWebView)
        {
          LogUtility.e("Common", "callBatch args error : " + paramWebView.toString());
        }
      }
      catch (JSONException paramWebView)
      {
        LogUtility.b("Common", "callBatch request params format err", paramWebView);
        continue;
        j += 1;
        continue;
        paramString = paramWebView.invoke(paramString, ((List)localObject).toArray());
        continue;
        if (((paramString instanceof Number)) || ((paramString instanceof Long)) || ((paramString instanceof Integer)) || ((paramString instanceof Double)) || ((paramString instanceof Float)))
        {
          paramWebView = paramString.toString();
        }
        else if ((paramString instanceof Boolean))
        {
          paramWebView = paramString.toString();
          continue;
          localJSONObject.put("r", 0);
          localJSONObject.put("data", localJSONArray1);
          LogUtility.c("Common", "Response<callBatch> syncCallBatch result : " + localJSONObject);
        }
        else
        {
          paramWebView = "";
          continue;
          paramWebView = null;
        }
      }
    }
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 381	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 382	java/lang/StringBuffer:<init>	()V
    //   7: astore_3
    //   8: new 81	java/io/File
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: aload_1
    //   18: invokevirtual 138	java/io/File:exists	()Z
    //   21: ifne +33 -> 54
    //   24: ldc_w 384
    //   27: new 70	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 386
    //   37: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 302	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: ldc_w 377
    //   53: areturn
    //   54: new 388	java/io/InputStreamReader
    //   57: dup
    //   58: new 390	java/io/FileInputStream
    //   61: dup
    //   62: aload_1
    //   63: invokespecial 391	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   66: invokespecial 394	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: aload_1
    //   73: invokevirtual 398	java/io/Reader:read	()I
    //   76: istore 4
    //   78: iload 4
    //   80: iconst_m1
    //   81: if_icmpeq +60 -> 141
    //   84: iload 4
    //   86: i2c
    //   87: bipush 13
    //   89: if_icmpeq -19 -> 70
    //   92: iload 4
    //   94: i2c
    //   95: bipush 10
    //   97: if_icmpeq -27 -> 70
    //   100: iload 4
    //   102: i2c
    //   103: bipush 9
    //   105: if_icmpeq -35 -> 70
    //   108: aload_1
    //   109: astore_0
    //   110: aload_3
    //   111: iload 4
    //   113: i2c
    //   114: invokevirtual 401	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   117: pop
    //   118: goto -48 -> 70
    //   121: astore_2
    //   122: aload_1
    //   123: astore_0
    //   124: aload_2
    //   125: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 405	java/io/Reader:close	()V
    //   136: aload_3
    //   137: invokevirtual 406	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   140: areturn
    //   141: aload_1
    //   142: astore_0
    //   143: aload_1
    //   144: invokevirtual 405	java/io/Reader:close	()V
    //   147: iconst_0
    //   148: ifeq -12 -> 136
    //   151: new 408	java/lang/NullPointerException
    //   154: dup
    //   155: invokespecial 409	java/lang/NullPointerException:<init>	()V
    //   158: athrow
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual 410	java/io/IOException:printStackTrace	()V
    //   164: goto -28 -> 136
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 410	java/io/IOException:printStackTrace	()V
    //   172: goto -36 -> 136
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_0
    //   178: aload_0
    //   179: ifnull +7 -> 186
    //   182: aload_0
    //   183: invokevirtual 405	java/io/Reader:close	()V
    //   186: aload_1
    //   187: athrow
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 410	java/io/IOException:printStackTrace	()V
    //   193: goto -7 -> 186
    //   196: astore_1
    //   197: goto -19 -> 178
    //   200: astore_2
    //   201: aconst_null
    //   202: astore_1
    //   203: goto -81 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramString	String
    //   16	128	1	localObject1	Object
    //   175	12	1	localObject2	Object
    //   196	1	1	localObject3	Object
    //   202	1	1	localObject4	Object
    //   121	4	2	localException1	Exception
    //   200	1	2	localException2	Exception
    //   7	130	3	localStringBuffer	StringBuffer
    //   76	36	4	i	int
    // Exception table:
    //   from	to	target	type
    //   72	78	121	java/lang/Exception
    //   110	118	121	java/lang/Exception
    //   143	147	121	java/lang/Exception
    //   151	159	159	java/io/IOException
    //   132	136	167	java/io/IOException
    //   54	70	175	finally
    //   182	186	188	java/io/IOException
    //   72	78	196	finally
    //   110	118	196	finally
    //   124	128	196	finally
    //   143	147	196	finally
    //   54	70	200	java/lang/Exception
  }
  
  public static String a(Map paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)paramMap.get(str1);
      if (i != 0)
      {
        localStringBuilder.append(str1 + "=" + URLEncoder.encode(str2, "utf-8"));
        i = 0;
      }
      for (;;)
      {
        break;
        if (str2 != null) {
          localStringBuilder.append("&" + str1 + "=" + URLEncoder.encode(str2, "utf-8"));
        } else {
          localStringBuilder.append("&" + str1 + "=");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      Object localObject;
      if (!paramString.startsWith("?"))
      {
        localObject = paramString;
        if (!paramString.startsWith("&")) {}
      }
      else
      {
        localObject = paramString.substring(1);
      }
      paramString = ((String)localObject).split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramString[i].split("=");
        if (localObject.length > 1)
        {
          String str = URLDecoder.decode(localObject[1]);
          localHashMap.put(localObject[0], str);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static void a()
  {
    try
    {
      LogUtility.b("Common", "<initSystemFolder> begin to init system file... ");
      File localFile = new File(e());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      a(true);
      return;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putInt("appTabVersionCode", paramInt);
    localEditor.commit();
  }
  
  public static void a(long paramLong1, long paramLong2)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putLong("remaxage", paramLong1);
    localEditor.putLong("relasttime", paramLong2);
    localEditor.commit();
  }
  
  public static void a(String paramString)
  {
    LogUtility.c("Common", "setResourceMD5=" + paramString);
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putString("relastmd5", paramString);
    localEditor.commit();
  }
  
  /* Error */
  public static void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 513	java/util/concurrent/Executors:newSingleThreadScheduledExecutor	()Ljava/util/concurrent/ScheduledExecutorService;
    //   6: astore_1
    //   7: new 515	wsq
    //   10: dup
    //   11: invokespecial 516	wsq:<init>	()V
    //   14: astore_2
    //   15: iload_0
    //   16: ifeq +23 -> 39
    //   19: ldc2_w 517
    //   22: lstore_3
    //   23: aload_1
    //   24: aload_2
    //   25: lload_3
    //   26: getstatic 524	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   29: invokeinterface 530 5 0
    //   34: pop
    //   35: ldc 2
    //   37: monitorexit
    //   38: return
    //   39: lconst_0
    //   40: lstore_3
    //   41: goto -18 -> 23
    //   44: astore_1
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	paramBoolean	boolean
    //   6	18	1	localScheduledExecutorService	java.util.concurrent.ScheduledExecutorService
    //   44	5	1	localObject	Object
    //   14	11	2	localwsq	wsq
    //   22	19	3	l	long
    // Exception table:
    //   from	to	target	type
    //   3	15	44	finally
    //   23	35	44	finally
  }
  
  public static boolean a()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    while (new File("/mnt/sdcard-ext").isDirectory()) {
      return true;
    }
    return false;
  }
  
  public static long[] a()
  {
    SharedPreferences localSharedPreferences = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0);
    return new long[] { localSharedPreferences.getLong("remaxage", 0L), localSharedPreferences.getLong("relasttime", 0L) };
  }
  
  public static String[] a(String paramString)
  {
    String str2;
    String str1;
    if (paramString.toLowerCase().startsWith("sd://"))
    {
      str2 = paramString.substring("sd://".length());
      int i = str2.indexOf("?");
      if (i != -1)
      {
        str1 = str2.substring(0, i);
        paramString = str2.substring(i + 1);
        if (new File(i() + File.separator + str1).exists())
        {
          str2 = "file:///" + i() + File.separator + str1;
          str1 = paramString;
        }
      }
    }
    for (;;)
    {
      paramString = str1;
      if (!TextUtils.isEmpty(str1)) {
        paramString = "&" + str1;
      }
      LogUtility.c("Common", "url params= " + str2 + " " + paramString);
      return new String[] { str2, paramString };
      str2 = "file:///android_asset/Page/system/" + str1;
      str1 = paramString;
      continue;
      paramString = "";
      str1 = str2;
      break;
      str1 = "";
      str2 = paramString;
    }
  }
  
  public static void b(String paramString)
  {
    LogUtility.c("Common", "setLastResourceZipMd5=" + paramString);
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putString("lastresourcezipmd5", paramString);
    localEditor.commit();
  }
  
  public static void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putBoolean("appstoreclearcache", paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getBoolean("appstoreclearcache", false);
  }
  
  public static void c(String paramString)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
    localEditor.putString("appstoreagentversion", paramString);
    localEditor.commit();
  }
  
  public static void d(String paramString)
  {
    try
    {
      SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).edit();
      localEditor.putString("sdhtmldir", paramString);
      localEditor.commit();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String e()
  {
    return f() + File.separator + ".AppCenterWebBuffer_QQ";
  }
  
  public static String f()
  {
    String str = ".";
    if (Environment.getExternalStorageState().equals("mounted")) {
      str = Environment.getExternalStorageDirectory().getAbsolutePath();
    }
    while (!new File("/mnt/sdcard-ext").isDirectory()) {
      return str;
    }
    return "/mnt/sdcard-ext";
  }
  
  public static String g()
  {
    return i() + File.separator + "qapp_social_apps.html";
  }
  
  public static String h()
  {
    return i() + File.separator + "qapp_center_index.htm";
  }
  
  public static String i()
  {
    String str = t();
    LogUtility.b("Common", "<getSDResDir> getSDResDir=" + str);
    if (TextUtils.isEmpty(str)) {
      return "";
    }
    return e() + File.separator + str;
  }
  
  public static String j()
  {
    return e() + File.separator + "tmp";
  }
  
  public static String k()
  {
    return e() + File.separator + "system_old_";
  }
  
  public static String l()
  {
    return e() + File.separator + "user";
  }
  
  public static String m()
  {
    return e() + File.separator + "resource.zip";
  }
  
  public static String n()
  {
    return e() + File.separator + "resource.diff";
  }
  
  public static String o()
  {
    return e() + File.separator + "resource_merged.zip";
  }
  
  public static String p()
  {
    return "file:///android_asset" + File.separator + "Page/system";
  }
  
  public static String q()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("relastmd5", "");
  }
  
  public static String r()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("lastresourcezipmd5", "");
  }
  
  public static String s()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("appstoreagentversion", "");
  }
  
  public static String t()
  {
    return CommonDataAdapter.a().a().getSharedPreferences("qzoneappcenter", 0).getString("sdhtmldir", "");
  }
  
  public static String u()
  {
    int i = Process.myPid();
    try
    {
      Object localObject = CommonDataAdapter.a().a();
      if (localObject != null)
      {
        localObject = ((ActivityManager)((Context)localObject).getSystemService("activity")).getRunningAppProcesses().iterator();
        while (((Iterator)localObject).hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          if (localRunningAppProcessInfo.pid == i)
          {
            localObject = localRunningAppProcessInfo.processName;
            return (String)localObject;
          }
        }
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("Common", "exception happened!");
      return "";
    }
    return "";
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\appcommon\Common.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */