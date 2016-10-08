package com.tencent.av.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;

public class ClassLoaderUtil
{
  private static volatile DexClassLoader jdField_a_of_type_DalvikSystemDexClassLoader;
  private static final String jdField_a_of_type_JavaLangString = "ClassLoaderUtil";
  
  public ClassLoaderUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static DexClassLoader a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = a(BaseApplicationImpl.getContext(), "libqav_utils.so");
      }
      return a;
    }
    finally {}
  }
  
  public static DexClassLoader a(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    File localFile;
    do
    {
      return null;
      paramString = a(paramContext, paramString);
      localFile = paramContext.getDir("temp", 0);
    } while (TextUtils.isEmpty(paramString));
    try
    {
      paramContext = new DexClassLoader(paramString, localFile.getAbsolutePath(), null, paramContext.getClassLoader());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClassLoaderUtil", 2, "", paramContext);
        }
        paramContext = null;
      }
    }
  }
  
  public static Object a(DexClassLoader paramDexClassLoader, Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString)) && (paramObject != null)) {
      try
      {
        paramDexClassLoader = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
        paramDexClassLoader.setAccessible(true);
        paramDexClassLoader = paramDexClassLoader.invoke(paramObject, paramArrayOfObject);
        return paramDexClassLoader;
      }
      catch (Exception paramDexClassLoader)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClassLoaderUtil", 2, "", paramDexClassLoader);
        }
      }
    }
    return null;
  }
  
  public static Object a(DexClassLoader paramDexClassLoader, String paramString)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString))) {
      try
      {
        paramDexClassLoader = paramDexClassLoader.loadClass(paramString).newInstance();
        return paramDexClassLoader;
      }
      catch (Exception paramDexClassLoader)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClassLoaderUtil", 2, "", paramDexClassLoader);
        }
      }
    }
    return null;
  }
  
  public static Object a(DexClassLoader paramDexClassLoader, String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    if ((paramDexClassLoader != null) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1))) {
      try
      {
        paramString1 = paramDexClassLoader.loadClass(paramString1);
        paramDexClassLoader = paramString1.newInstance();
        paramString1 = paramString1.getMethod(paramString2, paramArrayOfClass);
        paramString1.setAccessible(true);
        paramDexClassLoader = paramString1.invoke(paramDexClassLoader, paramArrayOfObject);
        return paramDexClassLoader;
      }
      catch (Exception paramDexClassLoader)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClassLoaderUtil", 2, "", paramDexClassLoader);
        }
      }
    }
    return null;
  }
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 115	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   12: aload_0
    //   13: invokevirtual 120	android/content/Context:getFilesDir	()Ljava/io/File;
    //   16: invokevirtual 123	java/io/File:getParent	()Ljava/lang/String;
    //   19: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc -127
    //   24: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 5
    //   36: aload_0
    //   37: invokevirtual 120	android/content/Context:getFilesDir	()Ljava/io/File;
    //   40: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   43: astore_0
    //   44: new 115	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   51: aload_0
    //   52: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: getstatic 135	java/io/File:separator	Ljava/lang/String;
    //   58: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_1
    //   62: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore_2
    //   69: new 57	java/io/File
    //   72: dup
    //   73: aload_2
    //   74: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   77: astore_0
    //   78: aload_0
    //   79: invokevirtual 141	java/io/File:exists	()Z
    //   82: ifeq +8 -> 90
    //   85: aload_0
    //   86: invokevirtual 144	java/io/File:delete	()Z
    //   89: pop
    //   90: new 146	java/io/BufferedInputStream
    //   93: dup
    //   94: new 148	java/io/FileInputStream
    //   97: dup
    //   98: new 57	java/io/File
    //   101: dup
    //   102: aload 5
    //   104: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   107: invokespecial 151	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   110: invokespecial 154	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   113: astore_1
    //   114: aload_0
    //   115: invokevirtual 157	java/io/File:createNewFile	()Z
    //   118: pop
    //   119: new 159	java/io/BufferedOutputStream
    //   122: dup
    //   123: new 161	java/io/FileOutputStream
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 162	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   131: invokespecial 165	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   134: astore_0
    //   135: sipush 1024
    //   138: newarray <illegal type>
    //   140: astore_3
    //   141: aload_1
    //   142: aload_3
    //   143: iconst_0
    //   144: aload_3
    //   145: arraylength
    //   146: invokevirtual 169	java/io/BufferedInputStream:read	([BII)I
    //   149: istore 6
    //   151: iload 6
    //   153: iconst_m1
    //   154: if_icmpeq +60 -> 214
    //   157: aload_0
    //   158: aload_3
    //   159: iconst_0
    //   160: iload 6
    //   162: invokevirtual 173	java/io/BufferedOutputStream:write	([BII)V
    //   165: goto -24 -> 141
    //   168: astore 4
    //   170: aload_0
    //   171: astore_3
    //   172: aload_1
    //   173: astore_0
    //   174: aload 4
    //   176: astore_1
    //   177: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   180: ifeq +12 -> 192
    //   183: ldc 9
    //   185: iconst_2
    //   186: ldc 76
    //   188: aload_1
    //   189: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   192: aload_0
    //   193: ifnull +7 -> 200
    //   196: aload_0
    //   197: invokevirtual 176	java/io/BufferedInputStream:close	()V
    //   200: aload_2
    //   201: astore_1
    //   202: aload_3
    //   203: ifnull +9 -> 212
    //   206: aload_3
    //   207: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   210: aload_2
    //   211: astore_1
    //   212: aload_1
    //   213: areturn
    //   214: aload_1
    //   215: ifnull +7 -> 222
    //   218: aload_1
    //   219: invokevirtual 176	java/io/BufferedInputStream:close	()V
    //   222: aload_2
    //   223: astore_1
    //   224: aload_0
    //   225: ifnull -13 -> 212
    //   228: aload_0
    //   229: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   232: aload_2
    //   233: areturn
    //   234: astore_0
    //   235: aload_2
    //   236: astore_1
    //   237: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq -28 -> 212
    //   243: ldc 9
    //   245: iconst_2
    //   246: ldc 76
    //   248: aload_0
    //   249: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   252: aload_2
    //   253: areturn
    //   254: astore_1
    //   255: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq -36 -> 222
    //   261: ldc 9
    //   263: iconst_2
    //   264: ldc 76
    //   266: aload_1
    //   267: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   270: goto -48 -> 222
    //   273: astore_0
    //   274: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   277: ifeq -77 -> 200
    //   280: ldc 9
    //   282: iconst_2
    //   283: ldc 76
    //   285: aload_0
    //   286: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   289: goto -89 -> 200
    //   292: astore_0
    //   293: aload_2
    //   294: astore_1
    //   295: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq -86 -> 212
    //   301: ldc 9
    //   303: iconst_2
    //   304: ldc 76
    //   306: aload_0
    //   307: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   310: aload_2
    //   311: areturn
    //   312: astore_0
    //   313: aconst_null
    //   314: astore_1
    //   315: aload 4
    //   317: astore_3
    //   318: aload_1
    //   319: ifnull +7 -> 326
    //   322: aload_1
    //   323: invokevirtual 176	java/io/BufferedInputStream:close	()V
    //   326: aload_3
    //   327: ifnull +7 -> 334
    //   330: aload_3
    //   331: invokevirtual 177	java/io/BufferedOutputStream:close	()V
    //   334: aload_0
    //   335: athrow
    //   336: astore_1
    //   337: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq -14 -> 326
    //   343: ldc 9
    //   345: iconst_2
    //   346: ldc 76
    //   348: aload_1
    //   349: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   352: goto -26 -> 326
    //   355: astore_1
    //   356: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq -25 -> 334
    //   362: ldc 9
    //   364: iconst_2
    //   365: ldc 76
    //   367: aload_1
    //   368: invokestatic 80	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   371: goto -37 -> 334
    //   374: astore_0
    //   375: aload 4
    //   377: astore_3
    //   378: goto -60 -> 318
    //   381: astore_2
    //   382: aload_0
    //   383: astore_3
    //   384: aload_2
    //   385: astore_0
    //   386: goto -68 -> 318
    //   389: astore_2
    //   390: aload_0
    //   391: astore_1
    //   392: aload_2
    //   393: astore_0
    //   394: goto -76 -> 318
    //   397: astore_1
    //   398: aconst_null
    //   399: astore_0
    //   400: aconst_null
    //   401: astore_2
    //   402: goto -225 -> 177
    //   405: astore_1
    //   406: aconst_null
    //   407: astore_0
    //   408: goto -231 -> 177
    //   411: astore 4
    //   413: aload_1
    //   414: astore_0
    //   415: aload 4
    //   417: astore_1
    //   418: goto -241 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	paramContext	Context
    //   0	421	1	paramString	String
    //   68	243	2	str1	String
    //   381	4	2	localObject1	Object
    //   389	4	2	localObject2	Object
    //   401	1	2	localObject3	Object
    //   4	380	3	localObject4	Object
    //   1	1	4	localObject5	Object
    //   168	208	4	localException1	Exception
    //   411	5	4	localException2	Exception
    //   34	69	5	str2	String
    //   149	12	6	i	int
    // Exception table:
    //   from	to	target	type
    //   135	141	168	java/lang/Exception
    //   141	151	168	java/lang/Exception
    //   157	165	168	java/lang/Exception
    //   228	232	234	java/io/IOException
    //   218	222	254	java/io/IOException
    //   196	200	273	java/io/IOException
    //   206	210	292	java/io/IOException
    //   5	69	312	finally
    //   69	90	312	finally
    //   90	114	312	finally
    //   322	326	336	java/io/IOException
    //   330	334	355	java/io/IOException
    //   114	135	374	finally
    //   135	141	381	finally
    //   141	151	381	finally
    //   157	165	381	finally
    //   177	192	389	finally
    //   5	69	397	java/lang/Exception
    //   69	90	405	java/lang/Exception
    //   90	114	405	java/lang/Exception
    //   114	135	411	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\utils\ClassLoaderUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */