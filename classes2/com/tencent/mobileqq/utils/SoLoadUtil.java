package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SoLoadUtil
{
  private static final int jdField_a_of_type_Int = 5;
  public static final String a = "/txlib/";
  private static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
  private static Set jdField_a_of_type_JavaUtilSet;
  public static final String b = "DecodeSo";
  public static final String c = "DecodeSoEx";
  private static final String d = "SoLoadUtil";
  private static final String e = "so_load_sp";
  private static final String f = "so_sp";
  private static final String g = "key_so_crc";
  private static final String h = "key_so_version_";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaUtilSet = new HashSet();
    jdField_a_of_type_JavaUtilSet.add("libamrnb.so");
    jdField_a_of_type_JavaUtilSet.add("libcodecsilk.so");
    jdField_a_of_type_JavaUtilSet.add("libSync_mq.so");
  }
  
  private static native int Decode(AssetManager paramAssetManager, String paramString1, String paramString2, String paramString3, String paramString4);
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 | paramInt2;
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: astore 4
    //   6: aload_0
    //   7: ifnonnull +8 -> 15
    //   10: invokestatic 85	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   13: astore 4
    //   15: new 87	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 92	java/io/File:exists	()Z
    //   28: ifne +8 -> 36
    //   31: aload_0
    //   32: invokevirtual 95	java/io/File:mkdir	()Z
    //   35: pop
    //   36: iconst_0
    //   37: istore 8
    //   39: iconst_0
    //   40: istore 9
    //   42: new 97	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   49: aload 4
    //   51: invokevirtual 104	android/content/Context:getFilesDir	()Ljava/io/File;
    //   54: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc 114
    //   62: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_0
    //   69: new 97	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   76: aload_2
    //   77: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokestatic 123	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   83: invokevirtual 126	java/lang/Thread:getName	()Ljava/lang/String;
    //   86: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 5
    //   94: aload 4
    //   96: invokevirtual 130	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   99: astore 6
    //   101: getstatic 135	android/os/Build$VERSION:SDK_INT	I
    //   104: istore 10
    //   106: iload 10
    //   108: bipush 9
    //   110: if_icmpge +385 -> 495
    //   113: new 137	java/io/BufferedInputStream
    //   116: dup
    //   117: aload 6
    //   119: aload_2
    //   120: invokevirtual 143	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   123: invokespecial 146	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   126: astore_2
    //   127: new 148	java/io/BufferedOutputStream
    //   130: dup
    //   131: new 150	java/io/FileOutputStream
    //   134: dup
    //   135: new 87	java/io/File
    //   138: dup
    //   139: new 97	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   146: aload_0
    //   147: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 5
    //   152: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   161: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: invokespecial 156	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   167: astore 6
    //   169: aload_2
    //   170: ifnull +235 -> 405
    //   173: aload 6
    //   175: ifnull +230 -> 405
    //   178: sipush 4096
    //   181: newarray <illegal type>
    //   183: astore 7
    //   185: aload_2
    //   186: aload 7
    //   188: invokevirtual 160	java/io/BufferedInputStream:read	([B)I
    //   191: istore 8
    //   193: iload 8
    //   195: iconst_m1
    //   196: if_icmpeq +186 -> 382
    //   199: aload 6
    //   201: aload 7
    //   203: iconst_0
    //   204: iload 8
    //   206: invokevirtual 164	java/io/BufferedOutputStream:write	([BII)V
    //   209: goto -24 -> 185
    //   212: astore_2
    //   213: aload_2
    //   214: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   217: bipush 8
    //   219: istore 9
    //   221: iload 9
    //   223: ifne +247 -> 470
    //   226: aload 4
    //   228: ldc 18
    //   230: iconst_0
    //   231: iconst_0
    //   232: iconst_0
    //   233: invokestatic 170	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;IZZ)Z
    //   236: pop
    //   237: iconst_0
    //   238: istore 10
    //   240: iload 9
    //   242: istore 8
    //   244: iload 10
    //   246: iconst_1
    //   247: if_icmpgt +37 -> 284
    //   250: aconst_null
    //   251: new 97	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   258: aload_0
    //   259: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: aload 5
    //   264: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: aload_1
    //   271: ldc -84
    //   273: aload_3
    //   274: invokestatic 174	com/tencent/mobileqq/utils/SoLoadUtil:Decode	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   277: istore 8
    //   279: iload 8
    //   281: ifne +131 -> 412
    //   284: getstatic 135	android/os/Build$VERSION:SDK_INT	I
    //   287: bipush 9
    //   289: if_icmpge +42 -> 331
    //   292: new 87	java/io/File
    //   295: dup
    //   296: new 97	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   303: aload_0
    //   304: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 5
    //   309: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   318: astore_0
    //   319: aload_0
    //   320: invokevirtual 92	java/io/File:exists	()Z
    //   323: ifeq +8 -> 331
    //   326: aload_0
    //   327: invokevirtual 177	java/io/File:delete	()Z
    //   330: pop
    //   331: iload 8
    //   333: ifeq +268 -> 601
    //   336: iload 8
    //   338: istore 9
    //   340: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   343: ifeq +33 -> 376
    //   346: ldc 21
    //   348: iconst_2
    //   349: new 97	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   356: ldc -72
    //   358: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: iload 8
    //   363: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: iload 8
    //   374: istore 9
    //   376: ldc 2
    //   378: monitorexit
    //   379: iload 9
    //   381: ireturn
    //   382: aload 6
    //   384: invokevirtual 193	java/io/BufferedOutputStream:flush	()V
    //   387: aload_2
    //   388: invokevirtual 196	java/io/BufferedInputStream:close	()V
    //   391: aload 6
    //   393: invokevirtual 197	java/io/BufferedOutputStream:close	()V
    //   396: goto -175 -> 221
    //   399: astore_0
    //   400: ldc 2
    //   402: monitorexit
    //   403: aload_0
    //   404: athrow
    //   405: bipush 8
    //   407: istore 9
    //   409: goto -188 -> 221
    //   412: iload 10
    //   414: iconst_1
    //   415: iadd
    //   416: istore 10
    //   418: goto -174 -> 244
    //   421: astore_1
    //   422: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +182 -> 607
    //   428: ldc 21
    //   430: iconst_2
    //   431: new 97	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   438: ldc -57
    //   440: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload_1
    //   444: invokevirtual 200	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   447: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: ldc -54
    //   452: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokestatic 204	com/tencent/mobileqq/utils/SoLoadUtil:a	()Ljava/lang/String;
    //   458: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: goto +140 -> 607
    //   470: iload 9
    //   472: istore 8
    //   474: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   477: ifeq -193 -> 284
    //   480: ldc 21
    //   482: iconst_2
    //   483: ldc -50
    //   485: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: iload 9
    //   490: istore 8
    //   492: goto -208 -> 284
    //   495: aload 4
    //   497: ldc 15
    //   499: iconst_0
    //   500: iconst_0
    //   501: iconst_0
    //   502: invokestatic 170	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;IZZ)Z
    //   505: pop
    //   506: iconst_0
    //   507: istore 10
    //   509: iload 10
    //   511: iconst_1
    //   512: if_icmpgt -228 -> 284
    //   515: aload 6
    //   517: aload_2
    //   518: aload_1
    //   519: ldc -84
    //   521: aload_3
    //   522: invokestatic 174	com/tencent/mobileqq/utils/SoLoadUtil:Decode	(Landroid/content/res/AssetManager;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   525: istore 9
    //   527: iload 9
    //   529: istore 8
    //   531: iload 9
    //   533: ifeq -249 -> 284
    //   536: iload 10
    //   538: iconst_1
    //   539: iadd
    //   540: istore 10
    //   542: iload 9
    //   544: istore 8
    //   546: goto -37 -> 509
    //   549: astore_1
    //   550: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   553: ifeq +42 -> 595
    //   556: ldc 21
    //   558: iconst_2
    //   559: new 97	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   566: ldc -57
    //   568: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: aload_1
    //   572: invokevirtual 200	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   575: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: ldc -54
    //   580: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: invokestatic 204	com/tencent/mobileqq/utils/SoLoadUtil:a	()Ljava/lang/String;
    //   586: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: iconst_2
    //   596: istore 8
    //   598: goto -314 -> 284
    //   601: iconst_0
    //   602: istore 9
    //   604: goto -228 -> 376
    //   607: iconst_2
    //   608: istore 8
    //   610: goto -326 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	paramContext	Context
    //   0	613	1	paramString1	String
    //   0	613	2	paramString2	String
    //   0	613	3	paramString3	String
    //   4	492	4	localObject1	Object
    //   92	216	5	str	String
    //   99	417	6	localObject2	Object
    //   183	19	7	arrayOfByte	byte[]
    //   37	572	8	i	int
    //   40	563	9	j	int
    //   104	437	10	k	int
    // Exception table:
    //   from	to	target	type
    //   113	169	212	java/io/IOException
    //   178	185	212	java/io/IOException
    //   185	193	212	java/io/IOException
    //   199	209	212	java/io/IOException
    //   382	396	212	java/io/IOException
    //   10	15	399	finally
    //   15	36	399	finally
    //   42	106	399	finally
    //   113	169	399	finally
    //   178	185	399	finally
    //   185	193	399	finally
    //   199	209	399	finally
    //   213	217	399	finally
    //   226	237	399	finally
    //   250	279	399	finally
    //   284	331	399	finally
    //   340	372	399	finally
    //   382	396	399	finally
    //   422	467	399	finally
    //   474	488	399	finally
    //   495	506	399	finally
    //   515	527	399	finally
    //   550	595	399	finally
    //   226	237	421	java/lang/UnsatisfiedLinkError
    //   250	279	421	java/lang/UnsatisfiedLinkError
    //   495	506	549	java/lang/UnsatisfiedLinkError
    //   515	527	549	java/lang/UnsatisfiedLinkError
  }
  
  /* Error */
  private static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 211	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: aload_0
    //   12: ldc -43
    //   14: invokevirtual 219	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +11 -> 28
    //   20: ldc -43
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: ifnull +18 -> 47
    //   32: aload_0
    //   33: ldc -35
    //   35: invokevirtual 219	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +9 -> 47
    //   41: ldc -33
    //   43: astore_0
    //   44: goto -21 -> 23
    //   47: ldc -84
    //   49: astore_0
    //   50: goto -27 -> 23
    //   53: astore_0
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_0
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	44	0	str	String
    //   53	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	53	finally
    //   11	20	53	finally
    //   32	41	53	finally
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  private static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "lib/armeabi/";
    }
    return "lib/" + a() + "/";
  }
  
  private static final HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("osVersion", Build.VERSION.RELEASE);
    localHashMap.put("deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
    localHashMap.put("time", jdField_a_of_type_JavaTextSimpleDateFormat.format(new Date(System.currentTimeMillis())));
    localHashMap.put("libName", paramString);
    return localHashMap;
  }
  
  private static final void a(HashMap paramHashMap)
  {
    StatisticCollector.a(BaseApplication.getContext()).a("", "loadSo", false, 0L, 0L, paramHashMap, "");
  }
  
  private static final void a(HashMap paramHashMap, int paramInt, String paramString, long paramLong)
  {
    paramHashMap.put("message", paramString);
    paramHashMap.put("costTime", paramLong + "");
    StatisticCollector.a(paramHashMap, paramInt);
    a(paramHashMap);
  }
  
  /* Error */
  @Deprecated
  private static boolean a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 12
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_0
    //   10: istore 10
    //   12: new 97	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   19: ldc -30
    //   21: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc -28
    //   30: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 5
    //   38: new 97	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   45: aload_0
    //   46: invokevirtual 104	android/content/Context:getFilesDir	()Ljava/io/File;
    //   49: invokevirtual 318	java/io/File:getParent	()Ljava/lang/String;
    //   52: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: ldc 10
    //   57: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore 7
    //   65: new 97	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   72: aload 7
    //   74: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload 5
    //   79: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: astore 6
    //   87: aload_0
    //   88: ldc 24
    //   90: iconst_0
    //   91: invokevirtual 322	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   94: astore 4
    //   96: iload 12
    //   98: istore 11
    //   100: aload 4
    //   102: aload 5
    //   104: iconst_m1
    //   105: invokeinterface 328 3 0
    //   110: iload_2
    //   111: if_icmpne +11 -> 122
    //   114: aload 6
    //   116: invokestatic 331	java/lang/System:load	(Ljava/lang/String;)V
    //   119: iconst_1
    //   120: istore 11
    //   122: iload 11
    //   124: istore 13
    //   126: iload 11
    //   128: ifne +699 -> 827
    //   131: aconst_null
    //   132: astore_3
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_0
    //   136: invokevirtual 130	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   139: aload 5
    //   141: invokevirtual 143	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   144: astore_0
    //   145: aload_0
    //   146: astore_1
    //   147: aload_0
    //   148: astore_3
    //   149: new 87	java/io/File
    //   152: dup
    //   153: aload 7
    //   155: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   158: astore 7
    //   160: aload_0
    //   161: astore_1
    //   162: aload_0
    //   163: astore_3
    //   164: aload 7
    //   166: invokevirtual 92	java/io/File:exists	()Z
    //   169: ifne +19 -> 188
    //   172: aload_0
    //   173: astore_1
    //   174: iload 11
    //   176: istore 12
    //   178: aload_0
    //   179: astore_3
    //   180: aload 7
    //   182: invokevirtual 95	java/io/File:mkdir	()Z
    //   185: ifeq +580 -> 765
    //   188: aload_0
    //   189: astore_1
    //   190: aload_0
    //   191: astore_3
    //   192: new 87	java/io/File
    //   195: dup
    //   196: aload 6
    //   198: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 7
    //   203: iconst_0
    //   204: istore 8
    //   206: iconst_0
    //   207: istore 10
    //   209: aload_0
    //   210: astore_1
    //   211: new 150	java/io/FileOutputStream
    //   214: dup
    //   215: aload 7
    //   217: invokespecial 153	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   220: astore_3
    //   221: aload_0
    //   222: aload_3
    //   223: invokestatic 336	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   226: pop2
    //   227: iconst_1
    //   228: istore 10
    //   230: iload 10
    //   232: istore 9
    //   234: aload_3
    //   235: ifnull +13 -> 248
    //   238: aload_0
    //   239: astore_1
    //   240: aload_3
    //   241: invokevirtual 339	java/io/OutputStream:close	()V
    //   244: iload 10
    //   246: istore 9
    //   248: iload 9
    //   250: ifne +482 -> 732
    //   253: aload_0
    //   254: astore_1
    //   255: getstatic 48	com/tencent/mobileqq/utils/SoLoadUtil:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   258: aload 5
    //   260: invokeinterface 341 2 0
    //   265: istore 12
    //   267: iload 12
    //   269: ifeq +463 -> 732
    //   272: iload 8
    //   274: iconst_5
    //   275: if_icmpge +457 -> 732
    //   278: iload 8
    //   280: iconst_1
    //   281: iadd
    //   282: istore 8
    //   284: goto -78 -> 206
    //   287: astore_1
    //   288: iload 12
    //   290: istore 11
    //   292: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq -173 -> 122
    //   298: ldc 21
    //   300: iconst_2
    //   301: aload_1
    //   302: invokestatic 345	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   305: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: iload 12
    //   310: istore 11
    //   312: goto -190 -> 122
    //   315: astore_3
    //   316: aload_0
    //   317: astore_1
    //   318: aload_3
    //   319: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   322: iload 10
    //   324: istore 9
    //   326: goto -78 -> 248
    //   329: astore 4
    //   331: aload_0
    //   332: astore_1
    //   333: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +71 -> 407
    //   339: aload_0
    //   340: astore_1
    //   341: new 97	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   348: astore_3
    //   349: aload_0
    //   350: astore_1
    //   351: aload_3
    //   352: aload 5
    //   354: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: ldc_w 347
    //   360: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: new 87	java/io/File
    //   366: dup
    //   367: aload 6
    //   369: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   372: invokevirtual 92	java/io/File:exists	()Z
    //   375: invokevirtual 350	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   378: ldc_w 352
    //   381: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload 4
    //   386: invokevirtual 355	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   389: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: pop
    //   393: aload_0
    //   394: astore_1
    //   395: ldc 21
    //   397: iconst_2
    //   398: aload_3
    //   399: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: aload 4
    //   404: invokestatic 358	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   407: iload 8
    //   409: istore 9
    //   411: iload 11
    //   413: istore 13
    //   415: aload_0
    //   416: ifnull +411 -> 827
    //   419: aload_0
    //   420: invokevirtual 361	java/io/InputStream:close	()V
    //   423: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +45 -> 471
    //   429: ldc 21
    //   431: iconst_2
    //   432: new 97	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   439: aload 5
    //   441: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc_w 363
    //   447: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_2
    //   451: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   454: ldc_w 365
    //   457: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: iload 11
    //   462: invokevirtual 350	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   465: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: invokestatic 286	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   474: invokestatic 291	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   477: astore_0
    //   478: new 236	java/util/HashMap
    //   481: dup
    //   482: invokespecial 237	java/util/HashMap:<init>	()V
    //   485: astore_1
    //   486: aload_1
    //   487: ldc_w 367
    //   490: iload 11
    //   492: invokestatic 370	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   495: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   498: pop
    //   499: aload_1
    //   500: ldc_w 282
    //   503: aload 5
    //   505: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   508: pop
    //   509: aload_1
    //   510: ldc -6
    //   512: getstatic 253	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   515: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   518: pop
    //   519: aload_1
    //   520: ldc -1
    //   522: new 97	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   529: getstatic 258	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   532: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: ldc_w 260
    //   538: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: getstatic 263	android/os/Build:MODEL	Ljava/lang/String;
    //   544: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   553: pop
    //   554: aload_1
    //   555: ldc_w 265
    //   558: getstatic 69	com/tencent/mobileqq/utils/SoLoadUtil:jdField_a_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   561: new 267	java/util/Date
    //   564: dup
    //   565: invokestatic 273	java/lang/System:currentTimeMillis	()J
    //   568: invokespecial 276	java/util/Date:<init>	(J)V
    //   571: invokevirtual 280	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   574: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   577: pop
    //   578: iload 11
    //   580: ifne +60 -> 640
    //   583: new 87	java/io/File
    //   586: dup
    //   587: aload 6
    //   589: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   592: astore_3
    //   593: aload_3
    //   594: ifnull +46 -> 640
    //   597: aload_1
    //   598: ldc_w 372
    //   601: aload_3
    //   602: invokevirtual 92	java/io/File:exists	()Z
    //   605: invokestatic 370	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   608: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   611: pop
    //   612: aload_1
    //   613: ldc_w 374
    //   616: aload_3
    //   617: invokevirtual 377	java/io/File:length	()J
    //   620: invokestatic 380	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   623: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   626: pop
    //   627: aload_1
    //   628: ldc_w 382
    //   631: iload 8
    //   633: invokestatic 385	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   636: invokevirtual 248	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   639: pop
    //   640: aload_0
    //   641: ldc -12
    //   643: ldc 21
    //   645: iload 11
    //   647: lconst_0
    //   648: lconst_0
    //   649: aload_1
    //   650: ldc -12
    //   652: invokevirtual 296	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   655: iload 11
    //   657: ireturn
    //   658: astore_1
    //   659: iload 10
    //   661: istore 9
    //   663: aload_3
    //   664: ifnull -416 -> 248
    //   667: aload_0
    //   668: astore_1
    //   669: aload_3
    //   670: invokevirtual 339	java/io/OutputStream:close	()V
    //   673: iload 10
    //   675: istore 9
    //   677: goto -429 -> 248
    //   680: astore_3
    //   681: aload_0
    //   682: astore_1
    //   683: aload_3
    //   684: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   687: iload 10
    //   689: istore 9
    //   691: goto -443 -> 248
    //   694: astore_0
    //   695: aload_1
    //   696: ifnull +7 -> 703
    //   699: aload_1
    //   700: invokevirtual 361	java/io/InputStream:close	()V
    //   703: aload_0
    //   704: athrow
    //   705: astore 4
    //   707: aload_3
    //   708: ifnull +9 -> 717
    //   711: aload_0
    //   712: astore_1
    //   713: aload_3
    //   714: invokevirtual 339	java/io/OutputStream:close	()V
    //   717: aload_0
    //   718: astore_1
    //   719: aload 4
    //   721: athrow
    //   722: astore_3
    //   723: aload_0
    //   724: astore_1
    //   725: aload_3
    //   726: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   729: goto -12 -> 717
    //   732: aload_0
    //   733: astore_1
    //   734: aload 4
    //   736: invokeinterface 389 1 0
    //   741: aload 5
    //   743: iload_2
    //   744: invokeinterface 395 3 0
    //   749: invokeinterface 398 1 0
    //   754: pop
    //   755: aload_0
    //   756: astore_1
    //   757: aload 6
    //   759: invokestatic 331	java/lang/System:load	(Ljava/lang/String;)V
    //   762: iconst_1
    //   763: istore 12
    //   765: iload 8
    //   767: istore 9
    //   769: iload 12
    //   771: istore 13
    //   773: aload_0
    //   774: ifnull +53 -> 827
    //   777: aload_0
    //   778: invokevirtual 361	java/io/InputStream:close	()V
    //   781: iload 12
    //   783: istore 11
    //   785: goto -362 -> 423
    //   788: astore_0
    //   789: aload_0
    //   790: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   793: iload 12
    //   795: istore 11
    //   797: goto -374 -> 423
    //   800: astore_0
    //   801: aload_0
    //   802: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   805: goto -382 -> 423
    //   808: astore_1
    //   809: aload_1
    //   810: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   813: goto -110 -> 703
    //   816: astore 4
    //   818: iload 10
    //   820: istore 8
    //   822: aload_3
    //   823: astore_0
    //   824: goto -493 -> 331
    //   827: iload 9
    //   829: istore 8
    //   831: iload 13
    //   833: istore 11
    //   835: goto -412 -> 423
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	838	0	paramContext	Context
    //   0	838	1	paramString	String
    //   0	838	2	paramInt	int
    //   132	109	3	localObject1	Object
    //   315	4	3	localIOException1	java.io.IOException
    //   348	322	3	localObject2	Object
    //   680	34	3	localIOException2	java.io.IOException
    //   722	101	3	localIOException3	java.io.IOException
    //   94	7	4	localSharedPreferences	android.content.SharedPreferences
    //   329	74	4	localThrowable1	Throwable
    //   705	30	4	localObject3	Object
    //   816	1	4	localThrowable2	Throwable
    //   36	706	5	str1	String
    //   85	673	6	str2	String
    //   63	153	7	localObject4	Object
    //   4	826	8	i	int
    //   7	821	9	j	int
    //   10	809	10	k	int
    //   98	736	11	bool1	boolean
    //   1	793	12	bool2	boolean
    //   124	708	13	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   114	119	287	java/lang/Throwable
    //   240	244	315	java/io/IOException
    //   211	221	329	java/lang/Throwable
    //   240	244	329	java/lang/Throwable
    //   255	267	329	java/lang/Throwable
    //   318	322	329	java/lang/Throwable
    //   669	673	329	java/lang/Throwable
    //   683	687	329	java/lang/Throwable
    //   713	717	329	java/lang/Throwable
    //   719	722	329	java/lang/Throwable
    //   725	729	329	java/lang/Throwable
    //   734	755	329	java/lang/Throwable
    //   757	762	329	java/lang/Throwable
    //   221	227	658	java/lang/Exception
    //   669	673	680	java/io/IOException
    //   135	145	694	finally
    //   149	160	694	finally
    //   164	172	694	finally
    //   180	188	694	finally
    //   192	203	694	finally
    //   211	221	694	finally
    //   240	244	694	finally
    //   255	267	694	finally
    //   318	322	694	finally
    //   333	339	694	finally
    //   341	349	694	finally
    //   351	393	694	finally
    //   395	407	694	finally
    //   669	673	694	finally
    //   683	687	694	finally
    //   713	717	694	finally
    //   719	722	694	finally
    //   725	729	694	finally
    //   734	755	694	finally
    //   757	762	694	finally
    //   221	227	705	finally
    //   713	717	722	java/io/IOException
    //   777	781	788	java/io/IOException
    //   419	423	800	java/io/IOException
    //   699	703	808	java/io/IOException
    //   135	145	816	java/lang/Throwable
    //   149	160	816	java/lang/Throwable
    //   164	172	816	java/lang/Throwable
    //   180	188	816	java/lang/Throwable
    //   192	203	816	java/lang/Throwable
  }
  
  public static boolean a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramContext, paramString, paramInt, paramBoolean, true);
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +29 -> 35
    //   9: ldc 21
    //   11: iconst_2
    //   12: new 97	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 404
    //   22: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: invokestatic 409	android/os/SystemClock:uptimeMillis	()J
    //   38: lstore 25
    //   40: aload_1
    //   41: invokestatic 411	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/util/HashMap;
    //   44: astore 14
    //   46: iconst_0
    //   47: istore 27
    //   49: aload_0
    //   50: astore 9
    //   52: aload_0
    //   53: ifnonnull +8 -> 61
    //   56: invokestatic 85	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   59: astore 9
    //   61: new 97	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   68: aload 9
    //   70: invokevirtual 104	android/content/Context:getFilesDir	()Ljava/io/File;
    //   73: invokevirtual 318	java/io/File:getParent	()Ljava/lang/String;
    //   76: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 10
    //   81: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 18
    //   89: new 97	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   96: aload 9
    //   98: invokevirtual 104	android/content/Context:getFilesDir	()Ljava/io/File;
    //   101: invokevirtual 318	java/io/File:getParent	()Ljava/lang/String;
    //   104: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: ldc_w 413
    //   110: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: astore_0
    //   117: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +12 -> 132
    //   123: ldc 21
    //   125: iconst_2
    //   126: ldc_w 415
    //   129: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: iload_3
    //   133: ifeq +1694 -> 1827
    //   136: new 87	java/io/File
    //   139: dup
    //   140: new 97	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   147: aload_0
    //   148: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_1
    //   152: invokestatic 417	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   164: astore_0
    //   165: aload_0
    //   166: invokevirtual 92	java/io/File:exists	()Z
    //   169: istore_3
    //   170: iload_3
    //   171: ifeq +609 -> 780
    //   174: aload_0
    //   175: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   178: invokestatic 331	java/lang/System:load	(Ljava/lang/String;)V
    //   181: iconst_1
    //   182: istore_3
    //   183: aload 14
    //   185: iconst_0
    //   186: ldc -12
    //   188: invokestatic 409	android/os/SystemClock:uptimeMillis	()J
    //   191: lload 25
    //   193: lsub
    //   194: invokestatic 419	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   197: iload_3
    //   198: istore 4
    //   200: ldc 2
    //   202: monitorexit
    //   203: iload 4
    //   205: ireturn
    //   206: astore_0
    //   207: iload 27
    //   209: istore_3
    //   210: new 97	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   217: ldc -12
    //   219: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc_w 421
    //   225: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: invokestatic 345	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   232: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: astore 5
    //   240: iconst_0
    //   241: iconst_2
    //   242: invokestatic 423	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   245: istore_2
    //   246: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +1589 -> 1838
    //   252: ldc 21
    //   254: iconst_2
    //   255: aload 5
    //   257: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: goto +1578 -> 1838
    //   263: new 87	java/io/File
    //   266: dup
    //   267: new 97	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   274: aload 18
    //   276: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload_1
    //   280: invokestatic 417	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   283: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   292: astore 15
    //   294: ldc_w 425
    //   297: invokestatic 430	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   300: invokevirtual 434	java/lang/Integer:intValue	()I
    //   303: istore 19
    //   305: new 97	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   312: ldc 33
    //   314: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_1
    //   318: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: astore_0
    //   325: new 97	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   332: ldc 30
    //   334: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_1
    //   338: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: astore 16
    //   346: aload 9
    //   348: ldc 27
    //   350: iconst_0
    //   351: invokevirtual 322	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   354: astore 17
    //   356: aload 17
    //   358: aload_0
    //   359: iconst_m1
    //   360: invokeinterface 328 3 0
    //   365: istore 20
    //   367: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   370: ifeq +51 -> 421
    //   373: ldc 21
    //   375: iconst_2
    //   376: new 97	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   383: ldc_w 436
    //   386: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_1
    //   390: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc_w 438
    //   396: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: iload 20
    //   401: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   404: ldc_w 440
    //   407: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: iload 19
    //   412: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   415: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: iload 20
    //   423: iload 19
    //   425: if_icmpeq +42 -> 467
    //   428: aload 15
    //   430: invokevirtual 92	java/io/File:exists	()Z
    //   433: ifeq +9 -> 442
    //   436: aload 15
    //   438: invokevirtual 177	java/io/File:delete	()Z
    //   441: pop
    //   442: iload 19
    //   444: ifne +382 -> 826
    //   447: aload 17
    //   449: invokeinterface 389 1 0
    //   454: aload_0
    //   455: iconst_m1
    //   456: invokeinterface 395 3 0
    //   461: invokeinterface 398 1 0
    //   466: pop
    //   467: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   470: ifeq +30 -> 500
    //   473: ldc 21
    //   475: iconst_2
    //   476: new 97	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 442
    //   486: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload 4
    //   491: invokevirtual 350	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   494: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: iload_2
    //   501: istore 19
    //   503: aload 5
    //   505: astore_0
    //   506: aload 15
    //   508: invokevirtual 92	java/io/File:exists	()Z
    //   511: ifne +1348 -> 1859
    //   514: iload 4
    //   516: ifeq +366 -> 882
    //   519: aload 9
    //   521: aload 18
    //   523: ldc_w 444
    //   526: aload_1
    //   527: invokestatic 417	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   530: invokestatic 446	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   533: istore 19
    //   535: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq +30 -> 568
    //   541: ldc 21
    //   543: iconst_2
    //   544: new 97	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 448
    //   554: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: iload 19
    //   559: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   562: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: iload 19
    //   570: ifeq +280 -> 850
    //   573: aload 15
    //   575: invokevirtual 177	java/io/File:delete	()Z
    //   578: pop
    //   579: new 97	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   586: aload 5
    //   588: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: ldc_w 450
    //   594: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: astore_0
    //   601: iload_2
    //   602: bipush 8
    //   604: invokestatic 423	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   607: istore 19
    //   609: iload 19
    //   611: istore_2
    //   612: aload_0
    //   613: astore 5
    //   615: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +1223 -> 1841
    //   621: ldc 21
    //   623: iconst_2
    //   624: aload_0
    //   625: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: iload 19
    //   630: istore_2
    //   631: aload_0
    //   632: astore 5
    //   634: goto +1207 -> 1841
    //   637: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   640: ifeq +12 -> 652
    //   643: ldc 21
    //   645: iconst_2
    //   646: ldc_w 452
    //   649: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   652: aload 15
    //   654: invokevirtual 92	java/io/File:exists	()Z
    //   657: istore 4
    //   659: iload 4
    //   661: ifeq +1138 -> 1799
    //   664: aload 15
    //   666: invokevirtual 108	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   669: invokestatic 331	java/lang/System:load	(Ljava/lang/String;)V
    //   672: iconst_1
    //   673: istore_3
    //   674: iload_2
    //   675: istore 19
    //   677: aload_0
    //   678: astore 5
    //   680: iload_3
    //   681: ifne +1056 -> 1737
    //   684: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   687: ifeq +12 -> 699
    //   690: ldc 21
    //   692: iconst_2
    //   693: ldc_w 454
    //   696: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   699: aload_1
    //   700: invokestatic 457	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   703: iconst_1
    //   704: istore_3
    //   705: invokestatic 409	android/os/SystemClock:uptimeMillis	()J
    //   708: lload 25
    //   710: lsub
    //   711: lstore 21
    //   713: aload 14
    //   715: iload_2
    //   716: aload_0
    //   717: lload 21
    //   719: invokestatic 419	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/util/HashMap;ILjava/lang/String;J)V
    //   722: iload_3
    //   723: istore 4
    //   725: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   728: ifeq -528 -> 200
    //   731: ldc 21
    //   733: iconst_2
    //   734: new 97	java/lang/StringBuilder
    //   737: dup
    //   738: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   741: ldc_w 459
    //   744: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: aload_1
    //   748: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: ldc_w 461
    //   754: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: lload 21
    //   759: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   762: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   768: iload_3
    //   769: istore 4
    //   771: goto -571 -> 200
    //   774: astore_0
    //   775: ldc 2
    //   777: monitorexit
    //   778: aload_0
    //   779: athrow
    //   780: new 97	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   787: ldc -12
    //   789: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: ldc_w 463
    //   795: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: astore 5
    //   803: iconst_0
    //   804: iconst_4
    //   805: invokestatic 423	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   808: istore_2
    //   809: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   812: ifeq +1035 -> 1847
    //   815: ldc 21
    //   817: iconst_2
    //   818: aload 5
    //   820: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   823: goto +1024 -> 1847
    //   826: aload 17
    //   828: invokeinterface 389 1 0
    //   833: aload_0
    //   834: iload 19
    //   836: invokeinterface 395 3 0
    //   841: invokeinterface 398 1 0
    //   846: pop
    //   847: goto -380 -> 467
    //   850: aload 15
    //   852: invokestatic 469	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   855: lstore 21
    //   857: aload 17
    //   859: invokeinterface 389 1 0
    //   864: aload 16
    //   866: lload 21
    //   868: invokeinterface 473 4 0
    //   873: invokeinterface 398 1 0
    //   878: pop
    //   879: goto +962 -> 1841
    //   882: aconst_null
    //   883: astore 11
    //   885: aconst_null
    //   886: astore 10
    //   888: aconst_null
    //   889: astore 12
    //   891: aconst_null
    //   892: astore_0
    //   893: aload_0
    //   894: astore 8
    //   896: aload 12
    //   898: astore 6
    //   900: aload 11
    //   902: astore 7
    //   904: new 87	java/io/File
    //   907: dup
    //   908: aload 18
    //   910: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   913: astore 13
    //   915: aload_0
    //   916: astore 8
    //   918: aload 12
    //   920: astore 6
    //   922: aload 11
    //   924: astore 7
    //   926: aload 13
    //   928: invokevirtual 92	java/io/File:exists	()Z
    //   931: ifne +26 -> 957
    //   934: aload_0
    //   935: astore 8
    //   937: aload 12
    //   939: astore 6
    //   941: aload 11
    //   943: astore 7
    //   945: aload 13
    //   947: invokevirtual 95	java/io/File:mkdir	()Z
    //   950: istore 4
    //   952: iload 4
    //   954: ifeq +860 -> 1814
    //   957: aload_0
    //   958: astore 8
    //   960: aload 12
    //   962: astore 6
    //   964: aload 11
    //   966: astore 7
    //   968: aload 9
    //   970: invokevirtual 130	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   973: new 97	java/lang/StringBuilder
    //   976: dup
    //   977: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   980: iconst_0
    //   981: invokestatic 475	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   984: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: aload_1
    //   988: invokestatic 417	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   991: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokevirtual 143	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1000: astore 13
    //   1002: aload 13
    //   1004: astore_0
    //   1005: aload_0
    //   1006: astore 8
    //   1008: aload_0
    //   1009: astore 6
    //   1011: aload 11
    //   1013: astore 7
    //   1015: new 150	java/io/FileOutputStream
    //   1018: dup
    //   1019: new 97	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1026: aload 18
    //   1028: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: aload_1
    //   1032: invokestatic 417	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1035: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1041: invokespecial 476	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   1044: astore 9
    //   1046: aload_0
    //   1047: aload 9
    //   1049: invokestatic 336	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   1052: lstore 23
    //   1054: aload 9
    //   1056: ifnull +8 -> 1064
    //   1059: aload 9
    //   1061: invokevirtual 339	java/io/OutputStream:close	()V
    //   1064: iload_2
    //   1065: istore 20
    //   1067: aload 5
    //   1069: astore 6
    //   1071: lload 23
    //   1073: lstore 21
    //   1075: aload_0
    //   1076: ifnull +18 -> 1094
    //   1079: aload_0
    //   1080: invokevirtual 361	java/io/InputStream:close	()V
    //   1083: lload 23
    //   1085: lstore 21
    //   1087: aload 5
    //   1089: astore 6
    //   1091: iload_2
    //   1092: istore 20
    //   1094: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1097: ifeq +12 -> 1109
    //   1100: ldc 21
    //   1102: iconst_2
    //   1103: ldc_w 478
    //   1106: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1109: iload 20
    //   1111: istore 19
    //   1113: aload 6
    //   1115: astore_0
    //   1116: aload 15
    //   1118: invokevirtual 92	java/io/File:exists	()Z
    //   1121: ifeq +738 -> 1859
    //   1124: lload 21
    //   1126: aload 15
    //   1128: invokevirtual 377	java/io/File:length	()J
    //   1131: lcmp
    //   1132: ifeq +276 -> 1408
    //   1135: aload 15
    //   1137: invokevirtual 177	java/io/File:delete	()Z
    //   1140: pop
    //   1141: new 97	java/lang/StringBuilder
    //   1144: dup
    //   1145: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1148: aload 6
    //   1150: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: ldc_w 450
    //   1156: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: astore 5
    //   1164: iload 20
    //   1166: bipush 8
    //   1168: invokestatic 423	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1171: istore_2
    //   1172: iload_2
    //   1173: istore 19
    //   1175: aload 5
    //   1177: astore_0
    //   1178: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1181: ifeq +678 -> 1859
    //   1184: ldc 21
    //   1186: iconst_2
    //   1187: aload 5
    //   1189: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1192: aload 5
    //   1194: astore_0
    //   1195: goto -558 -> 637
    //   1198: astore 6
    //   1200: aload_0
    //   1201: astore 8
    //   1203: aload 12
    //   1205: astore 6
    //   1207: aload 11
    //   1209: astore 7
    //   1211: aload 9
    //   1213: invokevirtual 130	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   1216: new 97	java/lang/StringBuilder
    //   1219: dup
    //   1220: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1223: iconst_1
    //   1224: invokestatic 475	com/tencent/mobileqq/utils/SoLoadUtil:a	(Z)Ljava/lang/String;
    //   1227: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: aload_1
    //   1231: invokestatic 417	com/tencent/mobileqq/utils/SoLoadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1234: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1240: invokevirtual 143	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1243: astore_0
    //   1244: goto -239 -> 1005
    //   1247: astore 6
    //   1249: aload 10
    //   1251: astore 9
    //   1253: aload 8
    //   1255: astore_0
    //   1256: aload 6
    //   1258: astore 8
    //   1260: aload_0
    //   1261: astore 6
    //   1263: aload 9
    //   1265: astore 7
    //   1267: new 97	java/lang/StringBuilder
    //   1270: dup
    //   1271: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1274: aload 5
    //   1276: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1279: ldc_w 480
    //   1282: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: aload 8
    //   1287: invokestatic 345	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1290: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1293: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: astore 5
    //   1298: aload_0
    //   1299: astore 6
    //   1301: aload 9
    //   1303: astore 7
    //   1305: iload_2
    //   1306: bipush 16
    //   1308: invokestatic 423	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1311: istore 20
    //   1313: aload_0
    //   1314: astore 6
    //   1316: aload 9
    //   1318: astore 7
    //   1320: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1323: ifeq +18 -> 1341
    //   1326: aload_0
    //   1327: astore 6
    //   1329: aload 9
    //   1331: astore 7
    //   1333: ldc 21
    //   1335: iconst_2
    //   1336: aload 5
    //   1338: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1341: aload 9
    //   1343: ifnull +8 -> 1351
    //   1346: aload 9
    //   1348: invokevirtual 339	java/io/OutputStream:close	()V
    //   1351: aload_0
    //   1352: ifnull +450 -> 1802
    //   1355: aload_0
    //   1356: invokevirtual 361	java/io/InputStream:close	()V
    //   1359: ldc2_w 481
    //   1362: lstore 21
    //   1364: aload 5
    //   1366: astore 6
    //   1368: goto -274 -> 1094
    //   1371: astore_0
    //   1372: ldc2_w 481
    //   1375: lstore 21
    //   1377: aload 5
    //   1379: astore 6
    //   1381: goto -287 -> 1094
    //   1384: astore_1
    //   1385: aload 6
    //   1387: astore_0
    //   1388: aload 7
    //   1390: ifnull +8 -> 1398
    //   1393: aload 7
    //   1395: invokevirtual 339	java/io/OutputStream:close	()V
    //   1398: aload_0
    //   1399: ifnull +7 -> 1406
    //   1402: aload_0
    //   1403: invokevirtual 361	java/io/InputStream:close	()V
    //   1406: aload_1
    //   1407: athrow
    //   1408: aload 15
    //   1410: invokestatic 469	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1413: lstore 21
    //   1415: aload 17
    //   1417: invokeinterface 389 1 0
    //   1422: aload 16
    //   1424: lload 21
    //   1426: invokeinterface 473 4 0
    //   1431: invokeinterface 398 1 0
    //   1436: pop
    //   1437: iload 20
    //   1439: istore 19
    //   1441: aload 6
    //   1443: astore_0
    //   1444: goto +415 -> 1859
    //   1447: astore 5
    //   1449: aload 15
    //   1451: invokestatic 469	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   1454: lstore 21
    //   1456: aload 17
    //   1458: aload 16
    //   1460: ldc2_w 481
    //   1463: invokeinterface 486 4 0
    //   1468: lstore 23
    //   1470: lload 21
    //   1472: ldc2_w 481
    //   1475: lcmp
    //   1476: ifeq +120 -> 1596
    //   1479: lload 21
    //   1481: lload 23
    //   1483: lcmp
    //   1484: ifeq +112 -> 1596
    //   1487: aload 15
    //   1489: invokevirtual 177	java/io/File:delete	()Z
    //   1492: pop
    //   1493: new 97	java/lang/StringBuilder
    //   1496: dup
    //   1497: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1500: aload_0
    //   1501: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1504: ldc_w 488
    //   1507: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1510: lload 21
    //   1512: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1515: ldc_w 490
    //   1518: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1521: lload 23
    //   1523: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1526: ldc_w 492
    //   1529: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1532: aload 15
    //   1534: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1537: ldc_w 497
    //   1540: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1543: aload 5
    //   1545: invokestatic 345	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1548: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1554: astore 5
    //   1556: iload_2
    //   1557: sipush 128
    //   1560: invokestatic 423	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1563: istore 19
    //   1565: iload 19
    //   1567: istore_2
    //   1568: aload 5
    //   1570: astore_0
    //   1571: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1574: ifeq +291 -> 1865
    //   1577: ldc 21
    //   1579: iconst_2
    //   1580: aload 5
    //   1582: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1585: iconst_0
    //   1586: istore_3
    //   1587: aload 5
    //   1589: astore_0
    //   1590: iload 19
    //   1592: istore_2
    //   1593: goto -919 -> 674
    //   1596: new 97	java/lang/StringBuilder
    //   1599: dup
    //   1600: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1603: aload_0
    //   1604: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: ldc_w 499
    //   1610: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1613: aload 15
    //   1615: invokevirtual 495	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1618: ldc_w 497
    //   1621: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: aload 5
    //   1626: invokestatic 345	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1629: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1635: astore 5
    //   1637: iload_2
    //   1638: bipush 32
    //   1640: invokestatic 423	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1643: istore 19
    //   1645: iload 19
    //   1647: istore_2
    //   1648: aload 5
    //   1650: astore_0
    //   1651: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1654: ifeq +211 -> 1865
    //   1657: ldc 21
    //   1659: iconst_2
    //   1660: aload 5
    //   1662: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1665: iload 19
    //   1667: istore_2
    //   1668: aload 5
    //   1670: astore_0
    //   1671: goto +194 -> 1865
    //   1674: astore 5
    //   1676: new 97	java/lang/StringBuilder
    //   1679: dup
    //   1680: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1683: aload_0
    //   1684: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1687: ldc_w 501
    //   1690: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1693: aload 5
    //   1695: invokestatic 345	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1698: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1701: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1704: astore_0
    //   1705: iload_2
    //   1706: bipush 64
    //   1708: invokestatic 423	com/tencent/mobileqq/utils/SoLoadUtil:a	(II)I
    //   1711: istore_2
    //   1712: iload_2
    //   1713: istore 19
    //   1715: aload_0
    //   1716: astore 5
    //   1718: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1721: ifeq +16 -> 1737
    //   1724: ldc 21
    //   1726: iconst_2
    //   1727: aload_0
    //   1728: invokestatic 190	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1731: aload_0
    //   1732: astore 5
    //   1734: iload_2
    //   1735: istore 19
    //   1737: iload 19
    //   1739: istore_2
    //   1740: aload 5
    //   1742: astore_0
    //   1743: goto -1038 -> 705
    //   1746: astore 6
    //   1748: goto -684 -> 1064
    //   1751: astore_0
    //   1752: iload_2
    //   1753: istore 20
    //   1755: aload 5
    //   1757: astore 6
    //   1759: lload 23
    //   1761: lstore 21
    //   1763: goto -669 -> 1094
    //   1766: astore 6
    //   1768: goto -417 -> 1351
    //   1771: astore 5
    //   1773: goto -375 -> 1398
    //   1776: astore_0
    //   1777: goto -371 -> 1406
    //   1780: astore_1
    //   1781: aload 9
    //   1783: astore 7
    //   1785: goto -397 -> 1388
    //   1788: astore 8
    //   1790: goto -530 -> 1260
    //   1793: astore_0
    //   1794: iconst_1
    //   1795: istore_3
    //   1796: goto -1586 -> 210
    //   1799: goto -1125 -> 674
    //   1802: ldc2_w 481
    //   1805: lstore 21
    //   1807: aload 5
    //   1809: astore 6
    //   1811: goto -717 -> 1094
    //   1814: aconst_null
    //   1815: astore 9
    //   1817: aconst_null
    //   1818: astore_0
    //   1819: ldc2_w 481
    //   1822: lstore 23
    //   1824: goto -770 -> 1054
    //   1827: iconst_0
    //   1828: istore_2
    //   1829: iconst_0
    //   1830: istore_3
    //   1831: ldc -12
    //   1833: astore 5
    //   1835: goto -1572 -> 263
    //   1838: goto -1575 -> 263
    //   1841: aload 5
    //   1843: astore_0
    //   1844: goto -1207 -> 637
    //   1847: iconst_0
    //   1848: istore_3
    //   1849: goto -1586 -> 263
    //   1852: astore_0
    //   1853: iconst_0
    //   1854: istore 19
    //   1856: goto -1551 -> 305
    //   1859: iload 19
    //   1861: istore_2
    //   1862: goto -1225 -> 637
    //   1865: iconst_0
    //   1866: istore_3
    //   1867: goto -1193 -> 674
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1870	0	paramContext	Context
    //   0	1870	1	paramString	String
    //   0	1870	2	paramInt	int
    //   0	1870	3	paramBoolean1	boolean
    //   0	1870	4	paramBoolean2	boolean
    //   238	1140	5	localObject1	Object
    //   1447	97	5	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   1554	115	5	str1	String
    //   1674	20	5	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    //   1716	40	5	localContext1	Context
    //   1771	37	5	localIOException1	java.io.IOException
    //   1833	9	5	str2	String
    //   898	251	6	localObject2	Object
    //   1198	1	6	localException	Exception
    //   1205	1	6	localObject3	Object
    //   1247	10	6	localIOException2	java.io.IOException
    //   1261	181	6	localObject4	Object
    //   1746	1	6	localIOException3	java.io.IOException
    //   1757	1	6	localContext2	Context
    //   1766	1	6	localIOException4	java.io.IOException
    //   1809	1	6	localIOException5	java.io.IOException
    //   902	882	7	localObject5	Object
    //   894	392	8	localObject6	Object
    //   1788	1	8	localIOException6	java.io.IOException
    //   50	1766	9	localObject7	Object
    //   886	364	10	localObject8	Object
    //   883	325	11	localObject9	Object
    //   889	315	12	localObject10	Object
    //   913	90	13	localObject11	Object
    //   44	670	14	localHashMap	HashMap
    //   292	1322	15	localFile	java.io.File
    //   344	1115	16	str3	String
    //   354	1103	17	localSharedPreferences	android.content.SharedPreferences
    //   87	940	18	str4	String
    //   303	1557	19	i	int
    //   365	1389	20	j	int
    //   711	1095	21	l1	long
    //   1052	771	23	l2	long
    //   38	671	25	l3	long
    //   47	161	27	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   174	181	206	java/lang/UnsatisfiedLinkError
    //   3	35	774	finally
    //   35	46	774	finally
    //   56	61	774	finally
    //   61	132	774	finally
    //   136	170	774	finally
    //   174	181	774	finally
    //   183	197	774	finally
    //   210	260	774	finally
    //   263	294	774	finally
    //   294	305	774	finally
    //   305	421	774	finally
    //   428	442	774	finally
    //   447	467	774	finally
    //   467	500	774	finally
    //   506	514	774	finally
    //   519	568	774	finally
    //   573	609	774	finally
    //   615	628	774	finally
    //   637	652	774	finally
    //   652	659	774	finally
    //   664	672	774	finally
    //   684	699	774	finally
    //   699	703	774	finally
    //   705	722	774	finally
    //   725	768	774	finally
    //   780	823	774	finally
    //   826	847	774	finally
    //   850	879	774	finally
    //   1059	1064	774	finally
    //   1079	1083	774	finally
    //   1094	1109	774	finally
    //   1116	1172	774	finally
    //   1178	1192	774	finally
    //   1346	1351	774	finally
    //   1355	1359	774	finally
    //   1393	1398	774	finally
    //   1402	1406	774	finally
    //   1406	1408	774	finally
    //   1408	1437	774	finally
    //   1449	1470	774	finally
    //   1487	1565	774	finally
    //   1571	1585	774	finally
    //   1596	1645	774	finally
    //   1651	1665	774	finally
    //   1676	1712	774	finally
    //   1718	1731	774	finally
    //   968	1002	1198	java/lang/Exception
    //   904	915	1247	java/io/IOException
    //   926	934	1247	java/io/IOException
    //   945	952	1247	java/io/IOException
    //   968	1002	1247	java/io/IOException
    //   1015	1046	1247	java/io/IOException
    //   1211	1244	1247	java/io/IOException
    //   1355	1359	1371	java/io/IOException
    //   904	915	1384	finally
    //   926	934	1384	finally
    //   945	952	1384	finally
    //   968	1002	1384	finally
    //   1015	1046	1384	finally
    //   1211	1244	1384	finally
    //   1267	1298	1384	finally
    //   1305	1313	1384	finally
    //   1320	1326	1384	finally
    //   1333	1341	1384	finally
    //   664	672	1447	java/lang/UnsatisfiedLinkError
    //   699	703	1674	java/lang/UnsatisfiedLinkError
    //   1059	1064	1746	java/io/IOException
    //   1079	1083	1751	java/io/IOException
    //   1346	1351	1766	java/io/IOException
    //   1393	1398	1771	java/io/IOException
    //   1402	1406	1776	java/io/IOException
    //   1046	1054	1780	finally
    //   1046	1054	1788	java/io/IOException
    //   183	197	1793	java/lang/UnsatisfiedLinkError
    //   294	305	1852	java/lang/NumberFormatException
  }
  
  private static boolean a(String paramString)
  {
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\SoLoadUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */