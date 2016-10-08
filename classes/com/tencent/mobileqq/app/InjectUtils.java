package com.tencent.mobileqq.app;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import pzg;

public class InjectUtils
{
  public static final String a = "Success";
  public static boolean a = false;
  private static final String[] a;
  public static final String b = "classes4.jar";
  private static boolean jdField_b_of_type_Boolean = false;
  private static final String[] jdField_b_of_type_ArrayOfJavaLangString;
  static final String jdField_c_of_type_JavaLangString = "com.tencent.mobileqq.hotpatch.NotVerifyClass";
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  private static final String jdField_d_of_type_JavaLangString = "DexLoadOat";
  private static final String[] jdField_d_of_type_ArrayOfJavaLangString;
  private static String e;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "exlibs.1.jar", "exlibs.2.jar", "exlibs.4.jar", "exlibs.5.jar" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "Foo", "Foo2", "Foo4", "Foo5" };
    c = new String[] { "classes2.dex", "classes3.dex", "classes5.dex", "classes6.dex" };
    d = new String[] { "classes2.jar", "classes3.jar", "classes5.jar", "classes6.jar" };
  }
  
  public static float a()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getAvailableBlocks() / 1024.0F;
      int i = ((StatFs)localObject).getBlockSize();
      return i * f;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = 0L;
    byte[] arrayOfByte = new byte[' '];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      l += i;
    }
    return l;
  }
  
  /* Error */
  public static String a(Application paramApplication, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: ldc 8
    //   8: astore_3
    //   9: aload_3
    //   10: astore_2
    //   11: getstatic 120	android/os/Build$VERSION:SDK_INT	I
    //   14: bipush 21
    //   16: if_icmplt +17 -> 33
    //   19: aload_0
    //   20: invokevirtual 126	android/app/Application:getClassLoader	()Ljava/lang/ClassLoader;
    //   23: astore_2
    //   24: aload_2
    //   25: ldc 17
    //   27: invokevirtual 132	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   30: pop
    //   31: aload_3
    //   32: astore_2
    //   33: getstatic 120	android/os/Build$VERSION:SDK_INT	I
    //   36: bipush 21
    //   38: if_icmplt +14 -> 52
    //   41: aload_2
    //   42: astore_3
    //   43: ldc 8
    //   45: aload_2
    //   46: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   49: ifne +167 -> 216
    //   52: aload_1
    //   53: invokevirtual 141	android/content/Context:getFilesDir	()Ljava/io/File;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +194 -> 252
    //   61: aload_3
    //   62: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   65: astore_3
    //   66: new 80	java/io/File
    //   69: dup
    //   70: aload_3
    //   71: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 4
    //   76: aload 4
    //   78: invokevirtual 149	java/io/File:exists	()Z
    //   81: ifne +9 -> 90
    //   84: aload 4
    //   86: invokevirtual 152	java/io/File:mkdirs	()Z
    //   89: pop
    //   90: new 80	java/io/File
    //   93: dup
    //   94: aload_3
    //   95: ldc 14
    //   97: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: astore_3
    //   101: aload_3
    //   102: invokevirtual 149	java/io/File:exists	()Z
    //   105: ifne +345 -> 450
    //   108: aload_3
    //   109: invokevirtual 158	java/io/File:createNewFile	()Z
    //   112: pop
    //   113: aload_1
    //   114: invokevirtual 162	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   117: ldc 14
    //   119: invokevirtual 168	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 171	java/io/InputStream:available	()I
    //   127: newarray <illegal type>
    //   129: astore 7
    //   131: aload_1
    //   132: aload 7
    //   134: invokevirtual 174	java/io/InputStream:read	([B)I
    //   137: pop
    //   138: new 176	java/io/FileOutputStream
    //   141: dup
    //   142: aload_3
    //   143: invokespecial 179	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   146: astore 4
    //   148: aload 4
    //   150: aload 7
    //   152: invokevirtual 182	java/io/FileOutputStream:write	([B)V
    //   155: aload_1
    //   156: ifnull +7 -> 163
    //   159: aload_1
    //   160: invokevirtual 185	java/io/InputStream:close	()V
    //   163: aload_2
    //   164: astore 5
    //   166: aload_3
    //   167: astore_1
    //   168: aload 4
    //   170: ifnull +13 -> 183
    //   173: aload 4
    //   175: invokevirtual 186	java/io/FileOutputStream:close	()V
    //   178: aload_3
    //   179: astore_1
    //   180: aload_2
    //   181: astore 5
    //   183: aload_1
    //   184: ifnull +167 -> 351
    //   187: aload_1
    //   188: invokevirtual 149	java/io/File:exists	()Z
    //   191: ifeq +160 -> 351
    //   194: ldc 8
    //   196: aload 5
    //   198: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifeq +150 -> 351
    //   204: aload_0
    //   205: aload_1
    //   206: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   209: ldc 17
    //   211: iconst_1
    //   212: invokestatic 191	com/tencent/mobileqq/app/SystemClassLoaderInjector:a	(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   215: astore_3
    //   216: aload_3
    //   217: areturn
    //   218: astore_2
    //   219: new 193	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   226: ldc -60
    //   228: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: aload_2
    //   232: invokevirtual 203	java/lang/Throwable:toString	()Ljava/lang/String;
    //   235: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: astore_2
    //   242: ldc 20
    //   244: iconst_1
    //   245: aload_2
    //   246: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: goto -216 -> 33
    //   252: ldc -45
    //   254: astore_3
    //   255: goto -189 -> 66
    //   258: astore_3
    //   259: aconst_null
    //   260: astore_2
    //   261: aconst_null
    //   262: astore_1
    //   263: aload 6
    //   265: astore 4
    //   267: new 193	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   274: ldc -43
    //   276: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload_3
    //   280: invokevirtual 203	java/lang/Throwable:toString	()Ljava/lang/String;
    //   283: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: astore 5
    //   291: ldc 20
    //   293: iconst_1
    //   294: aload 5
    //   296: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   299: aload_2
    //   300: ifnull +7 -> 307
    //   303: aload_2
    //   304: invokevirtual 185	java/io/InputStream:close	()V
    //   307: aload 4
    //   309: ifnull +138 -> 447
    //   312: aload 4
    //   314: invokevirtual 186	java/io/FileOutputStream:close	()V
    //   317: goto -134 -> 183
    //   320: astore_2
    //   321: goto -138 -> 183
    //   324: astore_0
    //   325: aconst_null
    //   326: astore_2
    //   327: aload 5
    //   329: astore 4
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokevirtual 185	java/io/InputStream:close	()V
    //   339: aload 4
    //   341: ifnull +8 -> 349
    //   344: aload 4
    //   346: invokevirtual 186	java/io/FileOutputStream:close	()V
    //   349: aload_0
    //   350: athrow
    //   351: ldc -41
    //   353: areturn
    //   354: astore_1
    //   355: goto -192 -> 163
    //   358: astore_1
    //   359: aload_2
    //   360: astore 5
    //   362: aload_3
    //   363: astore_1
    //   364: goto -181 -> 183
    //   367: astore_2
    //   368: goto -61 -> 307
    //   371: astore_1
    //   372: goto -33 -> 339
    //   375: astore_1
    //   376: goto -27 -> 349
    //   379: astore_0
    //   380: aload 5
    //   382: astore 4
    //   384: aload_1
    //   385: astore_2
    //   386: goto -55 -> 331
    //   389: astore_0
    //   390: aload_1
    //   391: astore_2
    //   392: goto -61 -> 331
    //   395: astore_0
    //   396: goto -65 -> 331
    //   399: astore 4
    //   401: aconst_null
    //   402: astore_2
    //   403: aload_3
    //   404: astore_1
    //   405: aload 4
    //   407: astore_3
    //   408: aload 6
    //   410: astore 4
    //   412: goto -145 -> 267
    //   415: astore_2
    //   416: aload_3
    //   417: astore 5
    //   419: aload_2
    //   420: astore_3
    //   421: aload 6
    //   423: astore 4
    //   425: aload_1
    //   426: astore_2
    //   427: aload 5
    //   429: astore_1
    //   430: goto -163 -> 267
    //   433: astore_2
    //   434: aload_3
    //   435: astore 5
    //   437: aload_2
    //   438: astore_3
    //   439: aload_1
    //   440: astore_2
    //   441: aload 5
    //   443: astore_1
    //   444: goto -177 -> 267
    //   447: goto -264 -> 183
    //   450: aconst_null
    //   451: astore 4
    //   453: aconst_null
    //   454: astore_1
    //   455: goto -300 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	paramApplication	Application
    //   0	458	1	paramContext	Context
    //   10	171	2	localObject1	Object
    //   218	14	2	localThrowable1	Throwable
    //   241	63	2	str	String
    //   320	1	2	localException1	Exception
    //   326	34	2	localObject2	Object
    //   367	1	2	localException2	Exception
    //   385	18	2	localContext1	Context
    //   415	5	2	localThrowable2	Throwable
    //   426	1	2	localContext2	Context
    //   433	5	2	localThrowable3	Throwable
    //   440	1	2	localContext3	Context
    //   8	247	3	localObject3	Object
    //   258	146	3	localThrowable4	Throwable
    //   407	32	3	localObject4	Object
    //   74	309	4	localObject5	Object
    //   399	7	4	localThrowable5	Throwable
    //   410	42	4	localObject6	Object
    //   1	441	5	localObject7	Object
    //   4	418	6	localObject8	Object
    //   129	22	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	31	218	java/lang/Throwable
    //   52	57	258	java/lang/Throwable
    //   61	66	258	java/lang/Throwable
    //   66	90	258	java/lang/Throwable
    //   90	101	258	java/lang/Throwable
    //   312	317	320	java/lang/Exception
    //   52	57	324	finally
    //   61	66	324	finally
    //   66	90	324	finally
    //   90	101	324	finally
    //   101	123	324	finally
    //   159	163	354	java/lang/Exception
    //   173	178	358	java/lang/Exception
    //   303	307	367	java/lang/Exception
    //   335	339	371	java/lang/Exception
    //   344	349	375	java/lang/Exception
    //   123	148	379	finally
    //   148	155	389	finally
    //   267	299	395	finally
    //   101	123	399	java/lang/Throwable
    //   123	148	415	java/lang/Throwable
    //   148	155	433	java/lang/Throwable
  }
  
  /* Error */
  private static String a(Application paramApplication, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: invokevirtual 219	android/app/Application:getFilesDir	()Ljava/io/File;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +74 -> 85
    //   14: aload_2
    //   15: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: astore_2
    //   19: new 80	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: aload_1
    //   25: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore 5
    //   30: ldc 8
    //   32: ldc 8
    //   34: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +199 -> 236
    //   40: aload_0
    //   41: invokevirtual 220	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   44: aload_1
    //   45: invokevirtual 168	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   48: astore_0
    //   49: new 176	java/io/FileOutputStream
    //   52: dup
    //   53: aload 5
    //   55: iconst_0
    //   56: invokespecial 223	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   59: astore_1
    //   60: aload_0
    //   61: aload_1
    //   62: invokestatic 225	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   65: pop2
    //   66: aload_0
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 185	java/io/InputStream:close	()V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 226	java/io/OutputStream:close	()V
    //   82: ldc 8
    //   84: areturn
    //   85: ldc -45
    //   87: astore_2
    //   88: goto -69 -> 19
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_3
    //   95: astore_2
    //   96: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +30 -> 129
    //   102: ldc -25
    //   104: iconst_2
    //   105: new 193	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   112: aload 5
    //   114: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: ldc -20
    //   119: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_0
    //   126: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 185	java/io/InputStream:close	()V
    //   137: aload_1
    //   138: ifnull -56 -> 82
    //   141: aload_1
    //   142: invokevirtual 226	java/io/OutputStream:close	()V
    //   145: ldc 8
    //   147: areturn
    //   148: astore_0
    //   149: ldc 8
    //   151: areturn
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_1
    //   155: aload 4
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 185	java/io/InputStream:close	()V
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 226	java/io/OutputStream:close	()V
    //   174: aload_0
    //   175: athrow
    //   176: astore_0
    //   177: goto -103 -> 74
    //   180: astore_0
    //   181: ldc 8
    //   183: areturn
    //   184: astore_0
    //   185: goto -48 -> 137
    //   188: astore_2
    //   189: goto -23 -> 166
    //   192: astore_1
    //   193: goto -19 -> 174
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_0
    //   200: astore_2
    //   201: aload_3
    //   202: astore_0
    //   203: goto -45 -> 158
    //   206: astore_3
    //   207: aload_0
    //   208: astore_2
    //   209: aload_3
    //   210: astore_0
    //   211: goto -53 -> 158
    //   214: astore_0
    //   215: goto -57 -> 158
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_1
    //   221: aload_0
    //   222: astore_2
    //   223: aload_3
    //   224: astore_0
    //   225: goto -129 -> 96
    //   228: astore_3
    //   229: aload_0
    //   230: astore_2
    //   231: aload_3
    //   232: astore_0
    //   233: goto -137 -> 96
    //   236: aconst_null
    //   237: astore_1
    //   238: aconst_null
    //   239: astore_0
    //   240: goto -174 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramApplication	Application
    //   0	243	1	paramString	String
    //   9	154	2	localObject1	Object
    //   188	1	2	localIOException	java.io.IOException
    //   200	31	2	localApplication	Application
    //   4	91	3	localObject2	Object
    //   196	6	3	localObject3	Object
    //   206	4	3	localObject4	Object
    //   218	6	3	localThrowable1	Throwable
    //   228	4	3	localThrowable2	Throwable
    //   1	155	4	localObject5	Object
    //   28	85	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   30	49	91	java/lang/Throwable
    //   141	145	148	java/io/IOException
    //   30	49	152	finally
    //   70	74	176	java/io/IOException
    //   78	82	180	java/io/IOException
    //   133	137	184	java/io/IOException
    //   162	166	188	java/io/IOException
    //   170	174	192	java/io/IOException
    //   49	60	196	finally
    //   60	66	206	finally
    //   96	129	214	finally
    //   49	60	218	java/lang/Throwable
    //   60	66	228	java/lang/Throwable
  }
  
  /* Error */
  private static String a(Application paramApplication, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 80	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokevirtual 219	android/app/Application:getFilesDir	()Ljava/io/File;
    //   13: aload_2
    //   14: invokespecial 243	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore 5
    //   19: ldc 8
    //   21: ldc 8
    //   23: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +193 -> 219
    //   29: aload_0
    //   30: invokevirtual 220	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   33: aload_1
    //   34: invokevirtual 168	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: astore_0
    //   38: new 176	java/io/FileOutputStream
    //   41: dup
    //   42: aload 5
    //   44: iconst_0
    //   45: invokespecial 223	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   48: astore_1
    //   49: aload_0
    //   50: aload_1
    //   51: invokestatic 225	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   54: pop2
    //   55: aload_0
    //   56: ifnull +7 -> 63
    //   59: aload_0
    //   60: invokevirtual 185	java/io/InputStream:close	()V
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 226	java/io/OutputStream:close	()V
    //   71: ldc 8
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_3
    //   78: astore_2
    //   79: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +30 -> 112
    //   85: ldc -25
    //   87: iconst_2
    //   88: new 193	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   95: aload 5
    //   97: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: ldc -20
    //   102: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: aload_0
    //   109: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 185	java/io/InputStream:close	()V
    //   120: aload_1
    //   121: ifnull -50 -> 71
    //   124: aload_1
    //   125: invokevirtual 226	java/io/OutputStream:close	()V
    //   128: ldc 8
    //   130: areturn
    //   131: astore_0
    //   132: ldc 8
    //   134: areturn
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_1
    //   138: aload 4
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 185	java/io/InputStream:close	()V
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 226	java/io/OutputStream:close	()V
    //   157: aload_0
    //   158: athrow
    //   159: astore_0
    //   160: goto -97 -> 63
    //   163: astore_0
    //   164: ldc 8
    //   166: areturn
    //   167: astore_0
    //   168: goto -48 -> 120
    //   171: astore_2
    //   172: goto -23 -> 149
    //   175: astore_1
    //   176: goto -19 -> 157
    //   179: astore_3
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_0
    //   183: astore_2
    //   184: aload_3
    //   185: astore_0
    //   186: goto -45 -> 141
    //   189: astore_3
    //   190: aload_0
    //   191: astore_2
    //   192: aload_3
    //   193: astore_0
    //   194: goto -53 -> 141
    //   197: astore_0
    //   198: goto -57 -> 141
    //   201: astore_3
    //   202: aconst_null
    //   203: astore_1
    //   204: aload_0
    //   205: astore_2
    //   206: aload_3
    //   207: astore_0
    //   208: goto -129 -> 79
    //   211: astore_3
    //   212: aload_0
    //   213: astore_2
    //   214: aload_3
    //   215: astore_0
    //   216: goto -137 -> 79
    //   219: aconst_null
    //   220: astore_1
    //   221: aconst_null
    //   222: astore_0
    //   223: goto -168 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramApplication	Application
    //   0	226	1	paramString1	String
    //   0	226	2	paramString2	String
    //   4	74	3	localObject1	Object
    //   179	6	3	localObject2	Object
    //   189	4	3	localObject3	Object
    //   201	6	3	localThrowable1	Throwable
    //   211	4	3	localThrowable2	Throwable
    //   1	138	4	localObject4	Object
    //   17	79	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   19	38	74	java/lang/Throwable
    //   124	128	131	java/io/IOException
    //   19	38	135	finally
    //   59	63	159	java/io/IOException
    //   67	71	163	java/io/IOException
    //   116	120	167	java/io/IOException
    //   145	149	171	java/io/IOException
    //   153	157	175	java/io/IOException
    //   38	49	179	finally
    //   49	55	189	finally
    //   79	112	197	finally
    //   38	49	201	java/lang/Throwable
    //   49	55	211	java/lang/Throwable
  }
  
  public static String a(Application paramApplication, boolean paramBoolean)
  {
    boolean bool1 = true;
    Object localObject1 = "Success";
    int i = 0;
    for (;;)
    {
      Object localObject2 = localObject1;
      try
      {
        String str3;
        String str2;
        String str1;
        File localFile;
        if (i < jdField_a_of_type_ArrayOfJavaLangString.length)
        {
          str3 = jdField_a_of_type_ArrayOfJavaLangString[i];
          str2 = jdField_b_of_type_ArrayOfJavaLangString[i];
          str1 = str3 + ".MD5";
          localFile = new File(paramApplication.getFilesDir(), str3);
          boolean bool2 = SoLoadCore.isLibExtracted(paramApplication.getApplicationContext(), str3, str1);
          if (bool2) {
            break label119;
          }
        }
        label119:
        for (int j = 1;; j = 0)
        {
          localObject2 = localObject1;
          if (j == 0) {
            break label135;
          }
          if (!paramBoolean) {
            break;
          }
          localObject2 = null;
          return (String)localObject2;
        }
        localObject2 = b(paramApplication, str3, str1);
        label135:
        localObject1 = localObject2;
        if ("Success".equals(localObject2)) {
          localObject1 = SystemClassLoaderInjector.a(paramApplication, localFile.getAbsolutePath(), str2, true);
        }
        QLog.e("DexLoad", 1, (String)localObject1);
        if (!"Success".equals(localObject1))
        {
          a(paramApplication, "", (String)localObject1);
          float f = a();
          if ((f > 0.0F) && (f < 250.0F)) {}
          for (paramBoolean = bool1;; paramBoolean = false)
          {
            jdField_a_of_type_Boolean = paramBoolean;
            try
            {
              new File(paramApplication.getFilesDir(), str1).delete();
              localObject2 = localObject1;
            }
            catch (Exception paramApplication)
            {
              localObject2 = localObject1;
            }
            break;
          }
        }
        i += 1;
      }
      finally {}
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      byte[] arrayOfByte = "9u23fh$jkf^%43hj".getBytes();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1).append("|");
      localStringBuilder.append(Build.DEVICE).append("|");
      localStringBuilder.append(Build.MANUFACTURER).append("|");
      localStringBuilder.append(Build.MODEL).append("|");
      localStringBuilder.append(Build.VERSION.SDK_INT).append("|");
      paramString1 = a();
      localStringBuilder.append(paramString1[0]).append("|").append(paramString1[1]).append("|");
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        localStringBuilder.append(paramContext.getDeviceId()).append("|");
      }
      localStringBuilder.append(paramString2).append("|");
      ThreadManager.a(new pzg(arrayOfByte, localStringBuilder.toString()), 8, null, false);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean a()
  {
    if (e == null)
    {
      e = System.getProperty("java.vm.version");
      if ((e == null) || (!e.startsWith("2"))) {
        break label43;
      }
    }
    label43:
    for (boolean bool = true;; bool = false)
    {
      jdField_b_of_type_Boolean = bool;
      return jdField_b_of_type_Boolean;
    }
  }
  
  /* Error */
  private static boolean a(Application paramApplication, Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: aload_3
    //   5: invokestatic 345	com/tencent/commonsdk/soload/SoLoadCore:getExistFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnonnull +37 -> 49
    //   15: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +29 -> 47
    //   21: ldc 20
    //   23: iconst_2
    //   24: new 193	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   31: aload_3
    //   32: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc_w 347
    //   38: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: iconst_0
    //   48: ireturn
    //   49: aload_0
    //   50: invokevirtual 220	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   53: aload_2
    //   54: invokevirtual 168	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   57: astore_0
    //   58: new 349	java/io/FileInputStream
    //   61: dup
    //   62: aload 5
    //   64: invokespecial 350	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: astore_3
    //   68: aload_0
    //   69: aload_3
    //   70: invokestatic 354	com/tencent/commonsdk/soload/SoLoadCore:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   73: istore 6
    //   75: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +35 -> 113
    //   81: ldc 20
    //   83: iconst_2
    //   84: new 193	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   91: aload 5
    //   93: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: ldc_w 356
    //   99: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload 6
    //   104: invokevirtual 359	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   107: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 185	java/io/InputStream:close	()V
    //   121: aload_3
    //   122: ifnull +7 -> 129
    //   125: aload_3
    //   126: invokevirtual 185	java/io/InputStream:close	()V
    //   129: iload 6
    //   131: ireturn
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_0
    //   135: aload 4
    //   137: astore_1
    //   138: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +31 -> 172
    //   144: ldc 20
    //   146: iconst_2
    //   147: new 193	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   154: aload 5
    //   156: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: ldc_w 361
    //   162: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: aload_2
    //   169: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: aload_2
    //   173: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 185	java/io/InputStream:close	()V
    //   184: aload_0
    //   185: ifnull -138 -> 47
    //   188: aload_0
    //   189: invokevirtual 185	java/io/InputStream:close	()V
    //   192: iconst_0
    //   193: ireturn
    //   194: astore_0
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: aconst_null
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_0
    //   202: aload_0
    //   203: ifnull +7 -> 210
    //   206: aload_0
    //   207: invokevirtual 185	java/io/InputStream:close	()V
    //   210: aload_2
    //   211: ifnull +7 -> 218
    //   214: aload_2
    //   215: invokevirtual 185	java/io/InputStream:close	()V
    //   218: aload_1
    //   219: athrow
    //   220: astore_0
    //   221: goto -100 -> 121
    //   224: astore_0
    //   225: goto -96 -> 129
    //   228: astore_1
    //   229: goto -45 -> 184
    //   232: astore_0
    //   233: goto -23 -> 210
    //   236: astore_0
    //   237: goto -19 -> 218
    //   240: astore_1
    //   241: aconst_null
    //   242: astore_2
    //   243: goto -41 -> 202
    //   246: astore_1
    //   247: aload_3
    //   248: astore_2
    //   249: goto -47 -> 202
    //   252: astore_2
    //   253: aload_1
    //   254: astore_3
    //   255: aload_2
    //   256: astore_1
    //   257: aload_0
    //   258: astore_2
    //   259: aload_3
    //   260: astore_0
    //   261: goto -59 -> 202
    //   264: astore_2
    //   265: aconst_null
    //   266: astore_3
    //   267: aload_0
    //   268: astore_1
    //   269: aload_3
    //   270: astore_0
    //   271: goto -133 -> 138
    //   274: astore_2
    //   275: aload_0
    //   276: astore_1
    //   277: aload_3
    //   278: astore_0
    //   279: goto -141 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramApplication	Application
    //   0	282	1	paramContext	Context
    //   0	282	2	paramString1	String
    //   0	282	3	paramString2	String
    //   1	135	4	localObject	Object
    //   8	147	5	localFile	File
    //   73	57	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   49	58	132	java/io/IOException
    //   188	192	194	java/io/IOException
    //   49	58	197	finally
    //   117	121	220	java/io/IOException
    //   125	129	224	java/io/IOException
    //   180	184	228	java/io/IOException
    //   206	210	232	java/io/IOException
    //   214	218	236	java/io/IOException
    //   58	68	240	finally
    //   68	113	246	finally
    //   138	172	252	finally
    //   172	176	252	finally
    //   58	68	264	java/io/IOException
    //   68	113	274	java/io/IOException
  }
  
  public static long[] a()
  {
    long l2 = 0L;
    try
    {
      localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      i = localStatFs.getBlockSize();
      l3 = i;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        StatFs localStatFs;
        int i;
        label43:
        l1 = 0L;
        long l3 = 0L;
      }
    }
    try
    {
      i = localStatFs.getBlockCount();
      l1 = i;
    }
    catch (Throwable localThrowable2)
    {
      l1 = 0L;
      break label43;
    }
    try
    {
      i = localStatFs.getAvailableBlocks();
      l2 = i;
    }
    catch (Throwable localThrowable3)
    {
      break label43;
    }
    return new long[] { l2 * l3, l1 * l3 };
  }
  
  /* Error */
  private static String b(Application paramApplication, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc 8
    //   8: astore 6
    //   10: new 80	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokevirtual 219	android/app/Application:getFilesDir	()Ljava/io/File;
    //   18: aload_1
    //   19: invokespecial 243	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: astore_3
    //   23: new 80	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 219	android/app/Application:getFilesDir	()Ljava/io/File;
    //   31: aload_2
    //   32: invokespecial 243	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore 9
    //   37: aload_0
    //   38: invokevirtual 220	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   41: aload_1
    //   42: invokevirtual 168	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore_1
    //   46: new 176	java/io/FileOutputStream
    //   49: dup
    //   50: aload_3
    //   51: iconst_0
    //   52: invokespecial 223	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   55: astore_3
    //   56: aload_3
    //   57: astore 5
    //   59: aload_1
    //   60: astore 4
    //   62: aload_1
    //   63: aload_3
    //   64: invokestatic 225	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   67: pop2
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 185	java/io/InputStream:close	()V
    //   76: aload 6
    //   78: astore 4
    //   80: aload_3
    //   81: ifnull +11 -> 92
    //   84: aload_3
    //   85: invokevirtual 226	java/io/OutputStream:close	()V
    //   88: aload 6
    //   90: astore 4
    //   92: ldc 8
    //   94: aload 4
    //   96: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +380 -> 479
    //   102: aload_0
    //   103: invokevirtual 220	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   106: aload_2
    //   107: invokevirtual 168	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   110: astore_0
    //   111: new 176	java/io/FileOutputStream
    //   114: dup
    //   115: aload 9
    //   117: iconst_0
    //   118: invokespecial 223	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   121: astore_1
    //   122: aload_0
    //   123: aload_1
    //   124: invokestatic 225	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   127: pop2
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 185	java/io/InputStream:close	()V
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 226	java/io/OutputStream:close	()V
    //   144: aload 4
    //   146: areturn
    //   147: astore 6
    //   149: aconst_null
    //   150: astore_3
    //   151: aconst_null
    //   152: astore_1
    //   153: aload_3
    //   154: astore 5
    //   156: aload_1
    //   157: astore 4
    //   159: aload 6
    //   161: invokevirtual 368	java/lang/Throwable:printStackTrace	()V
    //   164: aload_3
    //   165: astore 5
    //   167: aload_1
    //   168: astore 4
    //   170: aload 9
    //   172: invokevirtual 273	java/io/File:delete	()Z
    //   175: pop
    //   176: aload_3
    //   177: astore 5
    //   179: aload_1
    //   180: astore 4
    //   182: new 193	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 370
    //   192: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 6
    //   197: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   200: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore 6
    //   208: aload 6
    //   210: astore 5
    //   212: aload_1
    //   213: ifnull +7 -> 220
    //   216: aload_1
    //   217: invokevirtual 185	java/io/InputStream:close	()V
    //   220: aload 5
    //   222: astore 4
    //   224: aload_3
    //   225: ifnull -133 -> 92
    //   228: aload_3
    //   229: invokevirtual 226	java/io/OutputStream:close	()V
    //   232: aload 5
    //   234: astore 4
    //   236: goto -144 -> 92
    //   239: astore_1
    //   240: aload 5
    //   242: astore 4
    //   244: goto -152 -> 92
    //   247: astore_0
    //   248: aconst_null
    //   249: astore 5
    //   251: aconst_null
    //   252: astore_1
    //   253: aload_1
    //   254: ifnull +7 -> 261
    //   257: aload_1
    //   258: invokevirtual 185	java/io/InputStream:close	()V
    //   261: aload 5
    //   263: ifnull +8 -> 271
    //   266: aload 5
    //   268: invokevirtual 226	java/io/OutputStream:close	()V
    //   271: aload_0
    //   272: athrow
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_1
    //   276: aload 7
    //   278: astore_2
    //   279: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +30 -> 312
    //   285: ldc -25
    //   287: iconst_2
    //   288: new 193	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   295: aload 9
    //   297: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   300: ldc -20
    //   302: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: aload_0
    //   309: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: aload_1
    //   313: ifnull +7 -> 320
    //   316: aload_1
    //   317: invokevirtual 185	java/io/InputStream:close	()V
    //   320: aload_2
    //   321: ifnull -177 -> 144
    //   324: aload_2
    //   325: invokevirtual 226	java/io/OutputStream:close	()V
    //   328: aload 4
    //   330: areturn
    //   331: astore_0
    //   332: aload 4
    //   334: areturn
    //   335: astore_0
    //   336: aconst_null
    //   337: astore_1
    //   338: aload 8
    //   340: astore_2
    //   341: aload_1
    //   342: ifnull +7 -> 349
    //   345: aload_1
    //   346: invokevirtual 185	java/io/InputStream:close	()V
    //   349: aload_2
    //   350: ifnull +7 -> 357
    //   353: aload_2
    //   354: invokevirtual 226	java/io/OutputStream:close	()V
    //   357: aload_0
    //   358: athrow
    //   359: astore_1
    //   360: goto -284 -> 76
    //   363: astore_1
    //   364: aload 6
    //   366: astore 4
    //   368: goto -276 -> 92
    //   371: astore_1
    //   372: goto -152 -> 220
    //   375: astore_1
    //   376: goto -115 -> 261
    //   379: astore_1
    //   380: goto -109 -> 271
    //   383: astore_0
    //   384: goto -248 -> 136
    //   387: astore_0
    //   388: aload 4
    //   390: areturn
    //   391: astore_0
    //   392: goto -72 -> 320
    //   395: astore_1
    //   396: goto -47 -> 349
    //   399: astore_1
    //   400: goto -43 -> 357
    //   403: astore_2
    //   404: aload_0
    //   405: astore_1
    //   406: aload_2
    //   407: astore_0
    //   408: aload 8
    //   410: astore_2
    //   411: goto -70 -> 341
    //   414: astore_2
    //   415: aload_0
    //   416: astore_3
    //   417: aload_2
    //   418: astore_0
    //   419: aload_1
    //   420: astore_2
    //   421: aload_3
    //   422: astore_1
    //   423: goto -82 -> 341
    //   426: astore_0
    //   427: goto -86 -> 341
    //   430: astore_2
    //   431: aload_0
    //   432: astore_1
    //   433: aload_2
    //   434: astore_0
    //   435: aload 7
    //   437: astore_2
    //   438: goto -159 -> 279
    //   441: astore_2
    //   442: aload_0
    //   443: astore_3
    //   444: aload_2
    //   445: astore_0
    //   446: aload_1
    //   447: astore_2
    //   448: aload_3
    //   449: astore_1
    //   450: goto -171 -> 279
    //   453: astore_0
    //   454: aconst_null
    //   455: astore 5
    //   457: goto -204 -> 253
    //   460: astore_0
    //   461: aload 4
    //   463: astore_1
    //   464: goto -211 -> 253
    //   467: astore 6
    //   469: aconst_null
    //   470: astore_3
    //   471: goto -318 -> 153
    //   474: astore 6
    //   476: goto -323 -> 153
    //   479: aconst_null
    //   480: astore_1
    //   481: aconst_null
    //   482: astore_0
    //   483: goto -355 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	paramApplication	Application
    //   0	486	1	paramString1	String
    //   0	486	2	paramString2	String
    //   22	449	3	localObject1	Object
    //   60	402	4	localObject2	Object
    //   57	399	5	localObject3	Object
    //   8	81	6	str1	String
    //   147	49	6	localThrowable1	Throwable
    //   206	159	6	str2	String
    //   467	1	6	localThrowable2	Throwable
    //   474	1	6	localThrowable3	Throwable
    //   4	432	7	localObject4	Object
    //   1	408	8	localObject5	Object
    //   35	261	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   37	46	147	java/lang/Throwable
    //   228	232	239	java/io/IOException
    //   37	46	247	finally
    //   92	111	273	java/lang/Throwable
    //   324	328	331	java/io/IOException
    //   92	111	335	finally
    //   72	76	359	java/io/IOException
    //   84	88	363	java/io/IOException
    //   216	220	371	java/io/IOException
    //   257	261	375	java/io/IOException
    //   266	271	379	java/io/IOException
    //   132	136	383	java/io/IOException
    //   140	144	387	java/io/IOException
    //   316	320	391	java/io/IOException
    //   345	349	395	java/io/IOException
    //   353	357	399	java/io/IOException
    //   111	122	403	finally
    //   122	128	414	finally
    //   279	312	426	finally
    //   111	122	430	java/lang/Throwable
    //   122	128	441	java/lang/Throwable
    //   46	56	453	finally
    //   62	68	460	finally
    //   159	164	460	finally
    //   170	176	460	finally
    //   182	208	460	finally
    //   46	56	467	java/lang/Throwable
    //   62	68	474	java/lang/Throwable
  }
  
  /* Error */
  public static String b(Application paramApplication, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 229	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +53 -> 59
    //   9: new 193	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 378
    //   19: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: astore_3
    //   23: invokestatic 380	com/tencent/mobileqq/app/InjectUtils:a	()Z
    //   26: ifeq +52 -> 78
    //   29: ldc_w 382
    //   32: astore_2
    //   33: ldc 20
    //   35: iconst_2
    //   36: aload_3
    //   37: aload_2
    //   38: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 384
    //   44: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: getstatic 120	android/os/Build$VERSION:SDK_INT	I
    //   50: invokevirtual 295	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 387	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: getstatic 120	android/os/Build$VERSION:SDK_INT	I
    //   62: bipush 21
    //   64: if_icmplt +21 -> 85
    //   67: aload_0
    //   68: iload_1
    //   69: invokestatic 389	com/tencent/mobileqq/app/InjectUtils:c	(Landroid/app/Application;Z)Ljava/lang/String;
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: areturn
    //   78: ldc_w 391
    //   81: astore_2
    //   82: goto -49 -> 33
    //   85: aload_0
    //   86: iload_1
    //   87: invokestatic 393	com/tencent/mobileqq/app/InjectUtils:d	(Landroid/app/Application;Z)Ljava/lang/String;
    //   90: astore_0
    //   91: goto -18 -> 73
    //   94: astore_0
    //   95: ldc 20
    //   97: iconst_1
    //   98: ldc_w 262
    //   101: aload_0
    //   102: invokestatic 239	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: aconst_null
    //   106: astore_0
    //   107: goto -34 -> 73
    //   110: astore_0
    //   111: ldc 2
    //   113: monitorexit
    //   114: aload_0
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramApplication	Application
    //   0	116	1	paramBoolean	boolean
    //   32	50	2	str	String
    //   22	15	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   59	73	94	java/lang/Throwable
    //   85	91	94	java/lang/Throwable
    //   3	29	110	finally
    //   33	59	110	finally
    //   59	73	110	finally
    //   85	91	110	finally
    //   95	105	110	finally
  }
  
  /* Error */
  public static String c(Application paramApplication, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 8
    //   5: astore_3
    //   6: iconst_0
    //   7: istore 5
    //   9: aload_3
    //   10: astore_2
    //   11: iload 5
    //   13: getstatic 55	com/tencent/mobileqq/app/InjectUtils:c	[Ljava/lang/String;
    //   16: arraylength
    //   17: if_icmpge +156 -> 173
    //   20: new 193	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   27: getstatic 55	com/tencent/mobileqq/app/InjectUtils:c	[Ljava/lang/String;
    //   30: iload 5
    //   32: aaload
    //   33: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc -10
    //   38: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore_2
    //   45: new 193	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   52: getstatic 55	com/tencent/mobileqq/app/InjectUtils:c	[Ljava/lang/String;
    //   55: iload 5
    //   57: aaload
    //   58: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 395
    //   64: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 4
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 250	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   77: aload_2
    //   78: aload 4
    //   80: invokestatic 397	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/app/Application;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   83: istore 7
    //   85: iload 7
    //   87: ifne +22 -> 109
    //   90: iconst_1
    //   91: istore 6
    //   93: iload 6
    //   95: ifeq +28 -> 123
    //   98: iload_1
    //   99: ifeq +16 -> 115
    //   102: aconst_null
    //   103: astore_3
    //   104: ldc 2
    //   106: monitorexit
    //   107: aload_3
    //   108: areturn
    //   109: iconst_0
    //   110: istore 6
    //   112: goto -19 -> 93
    //   115: aload_0
    //   116: aload_2
    //   117: aload 4
    //   119: invokestatic 399	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   122: pop
    //   123: aload_0
    //   124: invokevirtual 126	android/app/Application:getClassLoader	()Ljava/lang/ClassLoader;
    //   127: astore_2
    //   128: aload_2
    //   129: getstatic 45	com/tencent/mobileqq/app/InjectUtils:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   132: iload 5
    //   134: aaload
    //   135: invokevirtual 132	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   138: pop
    //   139: iload 5
    //   141: iconst_1
    //   142: iadd
    //   143: istore 5
    //   145: goto -136 -> 9
    //   148: astore_2
    //   149: new 193	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 401
    //   159: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_2
    //   163: invokestatic 376	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   166: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: astore_2
    //   173: ldc 20
    //   175: iconst_1
    //   176: aload_2
    //   177: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_2
    //   181: astore_3
    //   182: ldc 8
    //   184: aload_2
    //   185: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   188: ifne -84 -> 104
    //   191: aload_0
    //   192: iload_1
    //   193: invokestatic 393	com/tencent/mobileqq/app/InjectUtils:d	(Landroid/app/Application;Z)Ljava/lang/String;
    //   196: astore_3
    //   197: goto -93 -> 104
    //   200: astore_0
    //   201: ldc 2
    //   203: monitorexit
    //   204: aload_0
    //   205: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramApplication	Application
    //   0	206	1	paramBoolean	boolean
    //   10	119	2	localObject1	Object
    //   148	15	2	localThrowable	Throwable
    //   172	13	2	str1	String
    //   5	192	3	localObject2	Object
    //   70	48	4	str2	String
    //   7	137	5	i	int
    //   91	20	6	j	int
    //   83	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   128	139	148	java/lang/Throwable
    //   11	85	200	finally
    //   115	123	200	finally
    //   123	128	200	finally
    //   128	139	200	finally
    //   149	173	200	finally
    //   173	180	200	finally
    //   182	197	200	finally
  }
  
  /* Error */
  public static String d(Application paramApplication, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_1
    //   4: istore 11
    //   6: ldc 2
    //   8: monitorenter
    //   9: ldc 8
    //   11: astore_3
    //   12: iconst_0
    //   13: istore 9
    //   15: iload 9
    //   17: getstatic 55	com/tencent/mobileqq/app/InjectUtils:c	[Ljava/lang/String;
    //   20: arraylength
    //   21: if_icmpge +299 -> 320
    //   24: getstatic 55	com/tencent/mobileqq/app/InjectUtils:c	[Ljava/lang/String;
    //   27: iload 9
    //   29: aaload
    //   30: astore 8
    //   32: getstatic 45	com/tencent/mobileqq/app/InjectUtils:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   35: iload 9
    //   37: aaload
    //   38: astore 7
    //   40: new 193	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   47: getstatic 55	com/tencent/mobileqq/app/InjectUtils:c	[Ljava/lang/String;
    //   50: iload 9
    //   52: aaload
    //   53: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc -10
    //   58: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore 6
    //   66: aload_0
    //   67: invokevirtual 250	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   70: getstatic 65	com/tencent/mobileqq/app/InjectUtils:d	[Ljava/lang/String;
    //   73: iload 9
    //   75: aaload
    //   76: aload 6
    //   78: invokestatic 256	com/tencent/commonsdk/soload/SoLoadCore:isLibExtracted	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   81: istore 12
    //   83: iload 12
    //   85: ifne +26 -> 111
    //   88: iconst_1
    //   89: istore 10
    //   91: aload_3
    //   92: astore 4
    //   94: iload 10
    //   96: ifeq +36 -> 132
    //   99: iload_1
    //   100: ifeq +17 -> 117
    //   103: aload 5
    //   105: astore_0
    //   106: ldc 2
    //   108: monitorexit
    //   109: aload_0
    //   110: areturn
    //   111: iconst_0
    //   112: istore 10
    //   114: goto -23 -> 91
    //   117: aload_0
    //   118: invokevirtual 250	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   121: aload 8
    //   123: invokestatic 405	com/tencent/commonsdk/soload/SoLoadCore:releaseDexFromApk	(Landroid/content/Context;Ljava/lang/String;)Z
    //   126: ifne +146 -> 272
    //   129: aconst_null
    //   130: astore 4
    //   132: aload 4
    //   134: astore_3
    //   135: ldc 8
    //   137: aload 4
    //   139: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   142: ifeq +42 -> 184
    //   145: aload_0
    //   146: invokevirtual 219	android/app/Application:getFilesDir	()Ljava/io/File;
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +132 -> 283
    //   154: aload_3
    //   155: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   158: astore_3
    //   159: aload_0
    //   160: new 80	java/io/File
    //   163: dup
    //   164: aload_3
    //   165: getstatic 65	com/tencent/mobileqq/app/InjectUtils:d	[Ljava/lang/String;
    //   168: iload 9
    //   170: aaload
    //   171: invokespecial 155	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: invokevirtual 144	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   177: aload 7
    //   179: iconst_1
    //   180: invokestatic 191	com/tencent/mobileqq/app/SystemClassLoaderInjector:a	(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   183: astore_3
    //   184: ldc 20
    //   186: iconst_1
    //   187: aload_3
    //   188: invokestatic 260	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: ldc 8
    //   193: aload_3
    //   194: invokevirtual 136	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   197: ifne +103 -> 300
    //   200: aload_0
    //   201: ldc_w 262
    //   204: aload_3
    //   205: invokestatic 265	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   208: invokestatic 267	com/tencent/mobileqq/app/InjectUtils:a	()F
    //   211: fstore_2
    //   212: fload_2
    //   213: fconst_0
    //   214: fcmpl
    //   215: ifle +74 -> 289
    //   218: fload_2
    //   219: ldc_w 268
    //   222: fcmpg
    //   223: ifge +66 -> 289
    //   226: iload 11
    //   228: istore_1
    //   229: iload_1
    //   230: putstatic 270	com/tencent/mobileqq/app/InjectUtils:jdField_a_of_type_Boolean	Z
    //   233: new 80	java/io/File
    //   236: dup
    //   237: aload_0
    //   238: invokevirtual 219	android/app/Application:getFilesDir	()Ljava/io/File;
    //   241: aload 6
    //   243: invokespecial 243	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   246: invokevirtual 273	java/io/File:delete	()Z
    //   249: pop
    //   250: new 80	java/io/File
    //   253: dup
    //   254: aload_0
    //   255: invokevirtual 219	android/app/Application:getFilesDir	()Ljava/io/File;
    //   258: aload 6
    //   260: invokespecial 243	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   263: invokevirtual 273	java/io/File:delete	()Z
    //   266: pop
    //   267: aload_3
    //   268: astore_0
    //   269: goto -163 -> 106
    //   272: aload_0
    //   273: aload 6
    //   275: invokestatic 407	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/app/Application;Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 4
    //   280: goto -148 -> 132
    //   283: ldc -45
    //   285: astore_3
    //   286: goto -127 -> 159
    //   289: iconst_0
    //   290: istore_1
    //   291: goto -62 -> 229
    //   294: astore_0
    //   295: aload_3
    //   296: astore_0
    //   297: goto -191 -> 106
    //   300: iload 9
    //   302: iconst_1
    //   303: iadd
    //   304: istore 9
    //   306: goto -291 -> 15
    //   309: astore_0
    //   310: ldc 2
    //   312: monitorexit
    //   313: aload_0
    //   314: athrow
    //   315: astore 4
    //   317: goto -67 -> 250
    //   320: aload_3
    //   321: astore_0
    //   322: goto -216 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramApplication	Application
    //   0	325	1	paramBoolean	boolean
    //   211	8	2	f	float
    //   11	310	3	localObject1	Object
    //   92	187	4	localObject2	Object
    //   315	1	4	localException	Exception
    //   1	103	5	localObject3	Object
    //   64	210	6	str1	String
    //   38	140	7	str2	String
    //   30	92	8	str3	String
    //   13	292	9	i	int
    //   89	24	10	j	int
    //   4	223	11	bool1	boolean
    //   81	3	12	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   250	267	294	java/lang/Exception
    //   15	83	309	finally
    //   117	129	309	finally
    //   135	150	309	finally
    //   154	159	309	finally
    //   159	184	309	finally
    //   184	212	309	finally
    //   229	233	309	finally
    //   233	250	309	finally
    //   250	267	309	finally
    //   272	280	309	finally
    //   233	250	315	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\InjectUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */