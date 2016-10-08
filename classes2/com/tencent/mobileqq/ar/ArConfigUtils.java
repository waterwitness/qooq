package com.tencent.mobileqq.ar;

import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.InflaterInputStream;

public class ArConfigUtils
{
  private static final float jdField_a_of_type_Float = 1.572864E7F;
  public static final int a = 88585;
  public static final String a = "ArConfig_Utils";
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat;
  public static final String b = "ar_file_config";
  public static final String c = "ar_effect_config";
  public static final String d = "olympic_ar_config";
  public static final String e = "olympic_ar_pre_download";
  public static final String f = "olympic_ar_download";
  public static final String g = "ar_client_download_times";
  public static final String h = "ar_client_download_report";
  public static final String i = "olympic_ar_native_so_report";
  
  public ArConfigUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a(String paramString)
  {
    if (a == null)
    {
      a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      a.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l1 = -1L;
    try
    {
      long l2 = a.parse(paramString).getTime();
      l1 = l2;
    }
    catch (ParseException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ArConfig_Utils", 2, "", paramString);
    }
    return l1;
    return -1L;
  }
  
  public static String a()
  {
    if (a()) {
      return AppConstants.bj;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ArConfig_Utils", 2, "no_sdcard");
    }
    float f1 = FileUtils.a();
    if ((f1 < 1.572864E7F) && (QLog.isColorLevel())) {
      QLog.i("ArConfig_Utils", 2, "inner memory avail may not enough : " + f1);
    }
    return BaseApplicationImpl.a.getFilesDir().getAbsolutePath() + File.separator;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 12
    //   10: iconst_2
    //   11: new 121	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   18: ldc -100
    //   20: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 158	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 160	java/util/zip/ZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 163	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 167	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   48: astore 5
    //   50: sipush 8192
    //   53: newarray <illegal type>
    //   55: astore 6
    //   57: aload 5
    //   59: invokeinterface 172 1 0
    //   64: ifeq +317 -> 381
    //   67: aload 5
    //   69: invokeinterface 176 1 0
    //   74: checkcast 178	java/util/zip/ZipEntry
    //   77: astore_3
    //   78: aload_3
    //   79: invokevirtual 181	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   82: astore_0
    //   83: aload_0
    //   84: ifnull +362 -> 446
    //   87: aload_0
    //   88: ldc -73
    //   90: invokevirtual 189	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   93: ifeq +6 -> 99
    //   96: goto -39 -> 57
    //   99: new 121	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   106: aload_1
    //   107: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: getstatic 151	java/io/File:separator	Ljava/lang/String;
    //   113: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: astore_0
    //   124: aload_3
    //   125: invokevirtual 192	java/util/zip/ZipEntry:isDirectory	()Z
    //   128: ifeq +27 -> 155
    //   131: new 145	java/io/File
    //   134: dup
    //   135: aload_0
    //   136: invokespecial 193	java/io/File:<init>	(Ljava/lang/String;)V
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 196	java/io/File:exists	()Z
    //   144: ifne +305 -> 449
    //   147: aload_0
    //   148: invokevirtual 199	java/io/File:mkdir	()Z
    //   151: pop
    //   152: goto +297 -> 449
    //   155: aload_0
    //   156: getstatic 151	java/io/File:separator	Ljava/lang/String;
    //   159: invokevirtual 203	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   162: istore 9
    //   164: aload_0
    //   165: iconst_0
    //   166: iload 9
    //   168: invokevirtual 207	java/lang/String:substring	(II)Ljava/lang/String;
    //   171: astore 7
    //   173: aload_0
    //   174: iload 9
    //   176: iconst_1
    //   177: iadd
    //   178: invokevirtual 210	java/lang/String:substring	(I)Ljava/lang/String;
    //   181: ldc -44
    //   183: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   186: ifeq +6 -> 192
    //   189: goto -132 -> 57
    //   192: new 145	java/io/File
    //   195: dup
    //   196: aload 7
    //   198: invokespecial 193	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 7
    //   203: aload 7
    //   205: invokevirtual 196	java/io/File:exists	()Z
    //   208: ifne +9 -> 217
    //   211: aload 7
    //   213: invokevirtual 199	java/io/File:mkdir	()Z
    //   216: pop
    //   217: new 145	java/io/File
    //   220: dup
    //   221: new 121	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   228: aload_0
    //   229: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc -38
    //   234: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokespecial 193	java/io/File:<init>	(Ljava/lang/String;)V
    //   243: astore 7
    //   245: new 145	java/io/File
    //   248: dup
    //   249: aload_0
    //   250: invokespecial 193	java/io/File:<init>	(Ljava/lang/String;)V
    //   253: astore 8
    //   255: aload 7
    //   257: invokevirtual 196	java/io/File:exists	()Z
    //   260: ifeq +9 -> 269
    //   263: aload 7
    //   265: invokevirtual 221	java/io/File:delete	()Z
    //   268: pop
    //   269: new 223	java/io/FileOutputStream
    //   272: dup
    //   273: aload 7
    //   275: invokespecial 226	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   278: astore_0
    //   279: aload 4
    //   281: aload_3
    //   282: invokevirtual 230	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   285: astore_3
    //   286: aload_3
    //   287: aload 6
    //   289: iconst_0
    //   290: aload 6
    //   292: arraylength
    //   293: invokevirtual 236	java/io/InputStream:read	([BII)I
    //   296: istore 9
    //   298: iload 9
    //   300: iconst_m1
    //   301: if_icmpeq +42 -> 343
    //   304: aload_0
    //   305: aload 6
    //   307: iconst_0
    //   308: iload 9
    //   310: invokevirtual 240	java/io/FileOutputStream:write	([BII)V
    //   313: goto -27 -> 286
    //   316: astore 4
    //   318: aload_3
    //   319: astore_1
    //   320: aload_0
    //   321: astore_2
    //   322: aload 4
    //   324: astore_0
    //   325: aload_2
    //   326: ifnull +7 -> 333
    //   329: aload_2
    //   330: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   333: aload_1
    //   334: ifnull +7 -> 341
    //   337: aload_1
    //   338: invokevirtual 244	java/io/InputStream:close	()V
    //   341: aload_0
    //   342: athrow
    //   343: aload_0
    //   344: invokevirtual 247	java/io/FileOutputStream:flush	()V
    //   347: aload_0
    //   348: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   351: aload_3
    //   352: invokevirtual 244	java/io/InputStream:close	()V
    //   355: aload 7
    //   357: aload 8
    //   359: invokestatic 250	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   362: ifne +87 -> 449
    //   365: aload 7
    //   367: aload 8
    //   369: invokestatic 253	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)V
    //   372: goto +77 -> 449
    //   375: astore_0
    //   376: aconst_null
    //   377: astore_1
    //   378: goto -53 -> 325
    //   381: iconst_0
    //   382: ifeq +11 -> 393
    //   385: new 255	java/lang/NullPointerException
    //   388: dup
    //   389: invokespecial 256	java/lang/NullPointerException:<init>	()V
    //   392: athrow
    //   393: iconst_0
    //   394: ifeq +11 -> 405
    //   397: new 255	java/lang/NullPointerException
    //   400: dup
    //   401: invokespecial 256	java/lang/NullPointerException:<init>	()V
    //   404: athrow
    //   405: return
    //   406: astore_0
    //   407: aload_0
    //   408: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   411: goto -18 -> 393
    //   414: astore_0
    //   415: aload_0
    //   416: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   419: return
    //   420: astore_2
    //   421: aload_2
    //   422: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   425: goto -92 -> 333
    //   428: astore_1
    //   429: aload_1
    //   430: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   433: goto -92 -> 341
    //   436: astore_3
    //   437: aconst_null
    //   438: astore_1
    //   439: aload_0
    //   440: astore_2
    //   441: aload_3
    //   442: astore_0
    //   443: goto -118 -> 325
    //   446: goto -389 -> 57
    //   449: goto -392 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	paramString1	String
    //   0	452	1	paramString2	String
    //   1	329	2	str1	String
    //   420	2	2	localIOException	java.io.IOException
    //   440	1	2	str2	String
    //   77	275	3	localObject1	Object
    //   436	6	3	localObject2	Object
    //   41	239	4	localZipFile	java.util.zip.ZipFile
    //   316	7	4	localObject3	Object
    //   48	20	5	localEnumeration	java.util.Enumeration
    //   55	251	6	arrayOfByte	byte[]
    //   171	195	7	localObject4	Object
    //   253	115	8	localFile	File
    //   162	147	9	j	int
    // Exception table:
    //   from	to	target	type
    //   286	298	316	finally
    //   304	313	316	finally
    //   343	355	316	finally
    //   33	57	375	finally
    //   57	83	375	finally
    //   87	96	375	finally
    //   99	152	375	finally
    //   155	189	375	finally
    //   192	217	375	finally
    //   217	269	375	finally
    //   269	279	375	finally
    //   355	372	375	finally
    //   385	393	406	java/io/IOException
    //   397	405	414	java/io/IOException
    //   329	333	420	java/io/IOException
    //   337	341	428	java/io/IOException
    //   279	286	436	finally
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString, "ar_client_download_report", paramBoolean, 0L, 0L, localHashMap, null);
  }
  
  public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBoolean1)
    {
      bool1 = bool2;
      if (paramBoolean2) {
        bool1 = true;
      }
    }
    HashMap localHashMap = new HashMap();
    if (paramBoolean1)
    {
      str = "1";
      localHashMap.put("ar_feature", str);
      if (!paramBoolean2) {
        break label132;
      }
      str = "1";
      label57:
      localHashMap.put("ar_model", str);
      if (!bool1) {
        break label139;
      }
      str = "1";
      label76:
      localHashMap.put("ar_all_resource", str);
      if (!bool1) {
        break label146;
      }
    }
    label132:
    label139:
    label146:
    for (String str = "1";; str = "0")
    {
      localHashMap.put("param_FailCode", str);
      StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString, "olympic_ar_pre_download", bool1, 0L, 0L, localHashMap, null);
      return;
      str = "0";
      break;
      str = "0";
      break label57;
      str = "0";
      break label76;
    }
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = Environment.getExternalStorageState().equals("mounted");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte['Ā'];
      for (;;)
      {
        int j = paramArrayOfByte.read(arrayOfByte);
        if (-1 == j) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, j);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return null;
    }
    return paramArrayOfByte;
  }
  
  public static void b(String paramString, boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString, "olympic_ar_config", paramBoolean, 0L, 0L, localHashMap, null);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ArConfigUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */