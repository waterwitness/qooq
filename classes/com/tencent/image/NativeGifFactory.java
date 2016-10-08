package com.tencent.image;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class NativeGifFactory
{
  static final String TAG = NativeGifFactory.class.getSimpleName();
  static boolean isX86 = false;
  static boolean isYunOS = false;
  
  static
  {
    String str = getKernelVersion();
    if ((TextUtils.isEmpty(str)) || (str.contains("x86")) || (str.contains("X86"))) {
      isX86 = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isX86:" + isX86);
    }
    str = getSystemProperties(URLDrawable.mApplicationContext, "ro.yunos.version");
    if ((!TextUtils.isEmpty(str)) && (str.length() > 1)) {
      isYunOS = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "isYunOS:" + isYunOS);
    }
  }
  
  /* Error */
  public static String getKernelVersion()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_3
    //   10: aconst_null
    //   11: astore 6
    //   13: aconst_null
    //   14: astore_1
    //   15: aconst_null
    //   16: astore 7
    //   18: new 94	java/io/ByteArrayOutputStream
    //   21: dup
    //   22: invokespecial 95	java/io/ByteArrayOutputStream:<init>	()V
    //   25: astore_0
    //   26: new 97	java/io/FileInputStream
    //   29: dup
    //   30: ldc 99
    //   32: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: sipush 4096
    //   39: newarray <illegal type>
    //   41: astore_2
    //   42: aload_1
    //   43: aload_2
    //   44: iconst_0
    //   45: sipush 4096
    //   48: invokevirtual 106	java/io/FileInputStream:read	([BII)I
    //   51: istore 8
    //   53: iload 8
    //   55: ifle +62 -> 117
    //   58: aload_0
    //   59: aload_2
    //   60: iconst_0
    //   61: iload 8
    //   63: invokevirtual 110	java/io/ByteArrayOutputStream:write	([BII)V
    //   66: goto -24 -> 42
    //   69: astore 4
    //   71: aload_1
    //   72: astore_3
    //   73: aload_0
    //   74: astore_1
    //   75: aload_3
    //   76: astore_2
    //   77: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +18 -> 98
    //   83: aload_0
    //   84: astore_1
    //   85: aload_3
    //   86: astore_2
    //   87: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   90: iconst_2
    //   91: ldc 112
    //   93: aload 4
    //   95: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_0
    //   99: ifnull +7 -> 106
    //   102: aload_0
    //   103: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   106: aload_3
    //   107: ifnull +7 -> 114
    //   110: aload_3
    //   111: invokevirtual 120	java/io/FileInputStream:close	()V
    //   114: ldc 122
    //   116: areturn
    //   117: aload_0
    //   118: ldc 124
    //   120: invokevirtual 127	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: astore_2
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 120	java/io/FileInputStream:close	()V
    //   140: aload_2
    //   141: areturn
    //   142: astore_0
    //   143: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +13 -> 159
    //   149: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   152: iconst_2
    //   153: ldc 112
    //   155: aload_0
    //   156: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   159: aload_2
    //   160: areturn
    //   161: astore_0
    //   162: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq -51 -> 114
    //   168: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   171: iconst_2
    //   172: ldc 112
    //   174: aload_0
    //   175: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   178: ldc 122
    //   180: areturn
    //   181: astore_0
    //   182: aload 4
    //   184: astore_1
    //   185: aload 6
    //   187: astore_0
    //   188: aload_0
    //   189: ifnull +7 -> 196
    //   192: aload_0
    //   193: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   196: aload_1
    //   197: ifnull -83 -> 114
    //   200: aload_1
    //   201: invokevirtual 120	java/io/FileInputStream:close	()V
    //   204: ldc 122
    //   206: areturn
    //   207: astore_0
    //   208: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq -97 -> 114
    //   214: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   217: iconst_2
    //   218: ldc 112
    //   220: aload_0
    //   221: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   224: ldc 122
    //   226: areturn
    //   227: astore_0
    //   228: aload_1
    //   229: ifnull +7 -> 236
    //   232: aload_1
    //   233: invokevirtual 119	java/io/ByteArrayOutputStream:close	()V
    //   236: aload_2
    //   237: ifnull +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 120	java/io/FileInputStream:close	()V
    //   244: aload_0
    //   245: athrow
    //   246: astore_1
    //   247: invokestatic 47	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   250: ifeq -6 -> 244
    //   253: getstatic 19	com/tencent/image/NativeGifFactory:TAG	Ljava/lang/String;
    //   256: iconst_2
    //   257: ldc 112
    //   259: aload_1
    //   260: invokestatic 116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   263: goto -19 -> 244
    //   266: astore_3
    //   267: aload_0
    //   268: astore_1
    //   269: aload 5
    //   271: astore_2
    //   272: aload_3
    //   273: astore_0
    //   274: goto -46 -> 228
    //   277: astore_3
    //   278: aload_1
    //   279: astore_2
    //   280: aload_0
    //   281: astore_1
    //   282: aload_3
    //   283: astore_0
    //   284: goto -56 -> 228
    //   287: astore_1
    //   288: aload 4
    //   290: astore_1
    //   291: goto -103 -> 188
    //   294: astore_2
    //   295: goto -107 -> 188
    //   298: astore 4
    //   300: aload 7
    //   302: astore_0
    //   303: goto -230 -> 73
    //   306: astore 4
    //   308: goto -235 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   25	104	0	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   142	14	0	localIOException1	IOException
    //   161	14	0	localIOException2	IOException
    //   181	1	0	localOutOfMemoryError1	OutOfMemoryError
    //   187	6	0	localObject1	Object
    //   207	14	0	localIOException3	IOException
    //   227	41	0	localObject2	Object
    //   273	30	0	localObject3	Object
    //   14	219	1	localObject4	Object
    //   246	14	1	localIOException4	IOException
    //   268	14	1	localObject5	Object
    //   287	1	1	localOutOfMemoryError2	OutOfMemoryError
    //   290	1	1	localIOException5	IOException
    //   4	276	2	localObject6	Object
    //   294	1	2	localOutOfMemoryError3	OutOfMemoryError
    //   9	102	3	localObject7	Object
    //   266	7	3	localObject8	Object
    //   277	6	3	localObject9	Object
    //   1	1	4	localObject10	Object
    //   69	220	4	localIOException6	IOException
    //   298	1	4	localIOException7	IOException
    //   306	1	4	localIOException8	IOException
    //   6	264	5	localObject11	Object
    //   11	175	6	localObject12	Object
    //   16	285	7	localObject13	Object
    //   51	11	8	i	int
    // Exception table:
    //   from	to	target	type
    //   36	42	69	java/io/IOException
    //   42	53	69	java/io/IOException
    //   58	66	69	java/io/IOException
    //   117	124	69	java/io/IOException
    //   128	132	142	java/io/IOException
    //   136	140	142	java/io/IOException
    //   102	106	161	java/io/IOException
    //   110	114	161	java/io/IOException
    //   18	26	181	java/lang/OutOfMemoryError
    //   192	196	207	java/io/IOException
    //   200	204	207	java/io/IOException
    //   18	26	227	finally
    //   77	83	227	finally
    //   87	98	227	finally
    //   232	236	246	java/io/IOException
    //   240	244	246	java/io/IOException
    //   26	36	266	finally
    //   36	42	277	finally
    //   42	53	277	finally
    //   58	66	277	finally
    //   117	124	277	finally
    //   26	36	287	java/lang/OutOfMemoryError
    //   36	42	294	java/lang/OutOfMemoryError
    //   42	53	294	java/lang/OutOfMemoryError
    //   58	66	294	java/lang/OutOfMemoryError
    //   117	124	294	java/lang/OutOfMemoryError
    //   18	26	298	java/io/IOException
    //   26	36	306	java/io/IOException
  }
  
  public static AbstractGifImage getNativeGifObject(File paramFile, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getNativeGifObject(File file, boolean cacheFirstFrame)");
    }
    Object localObject1 = null;
    label77:
    File localFile;
    try
    {
      if (isUseNewGif()) {
        localObject2 = new NativeGifIndex8(paramFile, paramBoolean);
      }
    }
    catch (IOException localIOException2)
    {
      do
      {
        Object localObject2;
        paramFile = (File)localObject1;
        localObject1 = localIOException2;
        localFile = paramFile;
      } while (!QLog.isColorLevel());
      QLog.e(TAG, 2, "getNativeGifObject exception. msg:" + ((IOException)localObject1).getMessage());
      return paramFile;
    }
    try
    {
      if (((NativeGifIndex8)localObject2).mFrameNumber != 64535) {
        return localObject2;
      }
      paramFile = new NativeGifImage(paramFile, paramBoolean);
      localObject2 = paramFile;
      return (AbstractGifImage)localObject2;
    }
    catch (IOException localIOException1)
    {
      paramFile = localFile;
      break label77;
    }
    paramFile = new NativeGifImage(paramFile, paramBoolean);
    return paramFile;
    return localFile;
  }
  
  public static AbstractGifImage getNativeGifObject(File paramFile, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "getNativeGifObject(File file, boolean cacheFirstFrame, boolean isEmosmFile, int maxWidth, int maxHeight, float roundCorner)");
    }
    if (paramFloat == 0.0F) {}
    do
    {
      try
      {
        if (isUseNewGif())
        {
          localNativeGifIndex8 = new NativeGifIndex8(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
          localObject1 = localNativeGifIndex8;
        }
      }
      catch (IOException localIOException2)
      {
        NativeGifIndex8 localNativeGifIndex8;
        paramFile = null;
      }
      try
      {
        if (((NativeGifIndex8)localNativeGifIndex8).mFrameNumber == 64535) {
          localObject1 = new NativeGifImage(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
        }
        return (AbstractGifImage)localObject1;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          paramFile = localIOException2;
          Object localObject2 = localIOException1;
        }
      }
      paramFile = new NativeGifImage(paramFile, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramFloat);
      return paramFile;
      Object localObject1 = paramFile;
    } while (!QLog.isColorLevel());
    QLog.e(TAG, 2, "getNativeGifObject exception. msg:" + localIOException2.getMessage());
    return paramFile;
  }
  
  public static String getSystemProperties(Context paramContext, String paramString)
    throws IllegalArgumentException
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      return "";
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static boolean isUseNewGif()
  {
    Object localObject = Build.MANUFACTURER;
    String str = Build.MODEL;
    boolean bool2;
    if (((Build.VERSION.SDK_INT == 10) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("samsung"))) || ((!TextUtils.isEmpty(str)) && ((str.contains("m1")) || (str.contains("meizu_m1")) || (str.contains("N1")))) || (str.contains("HYF9300")) || ((!TextUtils.isEmpty((CharSequence)localObject)) && ((((String)localObject).contains("alps")) || (((String)localObject).contains("Nokia")) || (((String)localObject).toLowerCase().contains("asus"))))) {
      bool2 = false;
    }
    boolean bool1;
    do
    {
      return bool2;
      if ((isX86) || (isYunOS)) {
        return false;
      }
      localObject = URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4);
      bool1 = false;
      if (localObject != null) {
        bool1 = ((SharedPreferences)localObject).getBoolean("use_new_gif_so", false);
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d(TAG, 2, "use_new_gif_so:" + bool1);
    return bool1;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\image\NativeGifFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */