package com.tencent.mobileqq.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicReporter;
import com.tencent.qphone.base.util.MD5;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import wak;
import wal;

public class FileUtils
{
  public static final long a = 1024L;
  public static Runnable a;
  public static final String a = "FileUtils";
  public static boolean a = false;
  public static final long b = 1048576L;
  public static final String b = "jpg";
  public static final long c = 1073741824L;
  public static final String c = "png";
  public static final String d = "bmp";
  public static final String e = "gif";
  public static final String f = "apng";
  public static final String g = "sharpp";
  public static final String h = "webp";
  public static String i = "unknown_";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangRunnable = new wak();
  }
  
  public static float a()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f1 = ((StatFs)localObject).getAvailableBlocks();
      int j = ((StatFs)localObject).getBlockSize();
      return j * f1;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.isDirectory()) {
      return -1;
    }
    File localFile = new File(paramString2);
    if ((!localFile.exists()) || (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    paramString1 = paramString1.listFiles();
    if (paramString1.length == 0) {
      return -2;
    }
    int j = 0;
    if (j < paramString1.length)
    {
      if (paramString1[j].isDirectory()) {
        a(paramString1[j].getPath() + "/" + paramString1[j], paramString2 + "/" + paramString1[j].getName());
      }
      for (;;)
      {
        j += 1;
        break;
        a(new File(paramString1[j].getPath()), new File(paramString2 + "/" + paramString1[j].getName()));
      }
    }
    return 1;
  }
  
  public static int a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int m = 0;
    paramString1 = new File(paramString1);
    int j;
    if (!paramString1.exists()) {
      j = -1;
    }
    File localFile1;
    int k;
    do
    {
      return j;
      paramString1 = paramString1.listFiles();
      localFile1 = new File(paramString2);
      if (!localFile1.exists()) {
        localFile1.mkdirs();
      }
      k = 0;
      j = m;
    } while (k >= paramString1.length);
    if (paramString1[k].isDirectory()) {
      a(paramString1[k].getPath() + "/", paramString2 + paramString1[k].getName() + "/", paramBoolean);
    }
    for (;;)
    {
      k += 1;
      break;
      localFile1 = new File(paramString1[k].getPath());
      File localFile2 = new File(paramString2 + paramString1[k].getName());
      if ((localFile1 == null) || (localFile2 == null) || (!localFile1.exists())) {
        continue;
      }
      if (!localFile2.exists()) {}
      try
      {
        localFile2.createNewFile();
        a(localFile1, localFile2);
        if (!paramBoolean) {
          continue;
        }
        localFile1.delete();
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  public static long a(File paramFile1, File paramFile2, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 145	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: invokevirtual 152	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   17: astore_0
    //   18: aload 5
    //   20: astore 4
    //   22: new 154	java/io/FileOutputStream
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: invokevirtual 156	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   33: astore_1
    //   34: iload_2
    //   35: i2l
    //   36: lstore 6
    //   38: iload_3
    //   39: i2l
    //   40: lstore 8
    //   42: aload_1
    //   43: astore 4
    //   45: aload_1
    //   46: aload_0
    //   47: lload 6
    //   49: lload 8
    //   51: invokevirtual 162	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   54: lstore 6
    //   56: aload_0
    //   57: ifnull +7 -> 64
    //   60: aload_0
    //   61: invokevirtual 165	java/nio/channels/FileChannel:close	()V
    //   64: aload_1
    //   65: ifnull +89 -> 154
    //   68: aload_1
    //   69: invokevirtual 165	java/nio/channels/FileChannel:close	()V
    //   72: lload 6
    //   74: lreturn
    //   75: astore_0
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_0
    //   79: ifnull +7 -> 86
    //   82: aload_0
    //   83: invokevirtual 165	java/nio/channels/FileChannel:close	()V
    //   86: aload 4
    //   88: ifnull +64 -> 152
    //   91: aload 4
    //   93: invokevirtual 165	java/nio/channels/FileChannel:close	()V
    //   96: lconst_0
    //   97: lreturn
    //   98: astore_0
    //   99: aconst_null
    //   100: astore 4
    //   102: aconst_null
    //   103: astore_1
    //   104: aload 4
    //   106: ifnull +8 -> 114
    //   109: aload 4
    //   111: invokevirtual 165	java/nio/channels/FileChannel:close	()V
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 165	java/nio/channels/FileChannel:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: astore 5
    //   126: aload_0
    //   127: astore 4
    //   129: aconst_null
    //   130: astore_1
    //   131: aload 5
    //   133: astore_0
    //   134: goto -30 -> 104
    //   137: astore 5
    //   139: aload_0
    //   140: astore 4
    //   142: aload 5
    //   144: astore_0
    //   145: goto -41 -> 104
    //   148: astore_1
    //   149: goto -71 -> 78
    //   152: lconst_0
    //   153: lreturn
    //   154: lload 6
    //   156: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramFile1	File
    //   0	157	1	paramFile2	File
    //   0	157	2	paramInt1	int
    //   0	157	3	paramInt2	int
    //   4	137	4	localObject1	Object
    //   1	18	5	localObject2	Object
    //   124	8	5	localObject3	Object
    //   137	6	5	localObject4	Object
    //   36	119	6	l1	long
    //   40	10	8	l2	long
    // Exception table:
    //   from	to	target	type
    //   6	18	75	java/io/FileNotFoundException
    //   6	18	98	finally
    //   22	34	124	finally
    //   45	56	137	finally
    //   22	34	148	java/io/FileNotFoundException
    //   45	56	148	java/io/FileNotFoundException
  }
  
  /* Error */
  public static long a(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 73	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 99	java/io/File:exists	()Z
    //   18: ifeq +40 -> 58
    //   21: new 145	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 169	java/io/FileInputStream:available	()I
    //   34: istore_3
    //   35: iload_3
    //   36: i2l
    //   37: lstore 6
    //   39: lload 6
    //   41: lstore 4
    //   43: aload_0
    //   44: ifnull +11 -> 55
    //   47: aload_0
    //   48: invokevirtual 170	java/io/FileInputStream:close	()V
    //   51: lload 6
    //   53: lstore 4
    //   55: lload 4
    //   57: lreturn
    //   58: iconst_0
    //   59: ifeq -4 -> 55
    //   62: new 172	java/lang/NullPointerException
    //   65: dup
    //   66: invokespecial 173	java/lang/NullPointerException:<init>	()V
    //   69: athrow
    //   70: astore_0
    //   71: lconst_0
    //   72: lreturn
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull -22 -> 55
    //   80: aload_0
    //   81: invokevirtual 170	java/io/FileInputStream:close	()V
    //   84: lconst_0
    //   85: lreturn
    //   86: astore_0
    //   87: lconst_0
    //   88: lreturn
    //   89: astore_0
    //   90: aload_1
    //   91: ifnull +7 -> 98
    //   94: aload_1
    //   95: invokevirtual 170	java/io/FileInputStream:close	()V
    //   98: aload_0
    //   99: athrow
    //   100: astore_0
    //   101: lload 6
    //   103: lreturn
    //   104: astore_1
    //   105: goto -7 -> 98
    //   108: astore_2
    //   109: aload_0
    //   110: astore_1
    //   111: aload_2
    //   112: astore_0
    //   113: goto -23 -> 90
    //   116: astore_1
    //   117: goto -41 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramString	String
    //   4	91	1	localObject1	Object
    //   104	1	1	localIOException	IOException
    //   110	1	1	str	String
    //   116	1	1	localException	Exception
    //   108	4	2	localObject2	Object
    //   34	2	3	j	int
    //   1	55	4	l1	long
    //   37	65	6	l2	long
    // Exception table:
    //   from	to	target	type
    //   62	70	70	java/io/IOException
    //   5	30	73	java/lang/Exception
    //   80	84	86	java/io/IOException
    //   5	30	89	finally
    //   47	51	100	java/io/IOException
    //   94	98	104	java/io/IOException
    //   30	35	108	finally
    //   30	35	116	java/lang/Exception
  }
  
  public static File a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.createNewFile();
      }
    }
    return paramString;
    label50:
    paramString.createNewFile();
    return paramString;
  }
  
  /* Error */
  public static Object a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +8 -> 15
    //   10: aload 4
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: new 186	java/io/ObjectInputStream
    //   18: dup
    //   19: new 188	java/io/BufferedInputStream
    //   22: dup
    //   23: invokestatic 194	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   26: aload_0
    //   27: invokevirtual 200	com/tencent/qphone/base/util/BaseApplication:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   30: invokespecial 203	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   33: invokespecial 204	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: aload_2
    //   40: invokevirtual 208	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   43: astore_3
    //   44: aload_3
    //   45: astore_1
    //   46: aload_1
    //   47: astore_0
    //   48: aload_2
    //   49: ifnull -36 -> 13
    //   52: aload_2
    //   53: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   56: aload_1
    //   57: areturn
    //   58: astore_0
    //   59: aload_1
    //   60: areturn
    //   61: astore_3
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_2
    //   65: astore_1
    //   66: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   69: ifeq +42 -> 111
    //   72: aload_2
    //   73: astore_1
    //   74: ldc 12
    //   76: iconst_2
    //   77: new 108	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   84: ldc -40
    //   86: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc -38
    //   95: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_3
    //   99: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   102: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 222	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload 4
    //   113: astore_0
    //   114: aload_2
    //   115: ifnull -102 -> 13
    //   118: aload_2
    //   119: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: aconst_null
    //   126: areturn
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   138: aload_0
    //   139: athrow
    //   140: astore_1
    //   141: goto -3 -> 138
    //   144: astore_0
    //   145: goto -15 -> 130
    //   148: astore_3
    //   149: goto -85 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramString	String
    //   38	97	1	localObject1	Object
    //   140	1	1	localIOException	IOException
    //   36	83	2	localObjectInputStream	java.io.ObjectInputStream
    //   43	2	3	localObject2	Object
    //   61	38	3	localException1	Exception
    //   148	1	3	localException2	Exception
    //   1	111	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   52	56	58	java/io/IOException
    //   15	37	61	java/lang/Exception
    //   118	122	124	java/io/IOException
    //   15	37	127	finally
    //   134	138	140	java/io/IOException
    //   39	44	144	finally
    //   66	72	144	finally
    //   74	111	144	finally
    //   39	44	148	java/lang/Exception
  }
  
  public static String a(int paramInt, long paramLong)
  {
    String str;
    if (paramLong == 0L) {
      if (paramInt == 0) {
        str = "0.0B";
      }
    }
    do
    {
      return str;
      if (paramInt == 1) {
        return "0.0K";
      }
      str = null;
      DecimalFormat localDecimalFormat = new DecimalFormat("0.0");
      float f1;
      if (paramLong / 1073741824L > 0L)
      {
        f1 = (float)paramLong / 1.07374182E9F;
        str = localDecimalFormat.format(f1);
        if (str.endsWith(".0")) {
          return (int)f1 + "G";
        }
        return str + "G";
      }
      if (paramLong / 1048576L > 0L)
      {
        f1 = (float)paramLong / 1048576.0F;
        str = localDecimalFormat.format(f1);
        if (str.endsWith(".0")) {
          return (int)f1 + "M";
        }
        return str + "M";
      }
      if (paramLong / 1024L > 0L)
      {
        paramInt = (int)(paramLong / 1024L);
        return paramInt + "K";
      }
      if (paramInt == 0) {
        return localDecimalFormat.format(paramLong) + "B";
      }
    } while (paramInt != 1);
    paramInt = (int)(paramLong / 1024L);
    return paramInt + "K";
  }
  
  public static String a(long paramLong)
  {
    return FileSizeFormat.a(paramLong);
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 271	java/io/File:length	()J
    //   10: l2i
    //   11: istore 7
    //   13: new 273	java/io/ByteArrayOutputStream
    //   16: dup
    //   17: iload 7
    //   19: invokespecial 276	java/io/ByteArrayOutputStream:<init>	(I)V
    //   22: astore_1
    //   23: new 145	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_0
    //   32: aload_1
    //   33: astore_3
    //   34: aload_0
    //   35: astore_2
    //   36: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   39: sipush 12288
    //   42: invokevirtual 286	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   45: astore 4
    //   47: iload 6
    //   49: iload 7
    //   51: if_icmpge +57 -> 108
    //   54: aload_1
    //   55: astore_3
    //   56: aload_0
    //   57: astore_2
    //   58: aload_0
    //   59: aload 4
    //   61: invokevirtual 290	java/io/FileInputStream:read	([B)I
    //   64: istore 8
    //   66: aload_1
    //   67: astore_3
    //   68: aload_0
    //   69: astore_2
    //   70: aload_1
    //   71: aload 4
    //   73: iconst_0
    //   74: iload 8
    //   76: invokevirtual 294	java/io/ByteArrayOutputStream:write	([BII)V
    //   79: iload 6
    //   81: iload 8
    //   83: iadd
    //   84: istore 6
    //   86: goto -39 -> 47
    //   89: astore_2
    //   90: aload_1
    //   91: astore_3
    //   92: aload_0
    //   93: astore_2
    //   94: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   97: sipush 4096
    //   100: invokevirtual 286	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   103: astore 4
    //   105: goto -58 -> 47
    //   108: aload_1
    //   109: astore_3
    //   110: aload_0
    //   111: astore_2
    //   112: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   115: aload 4
    //   117: invokevirtual 298	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   120: aload_1
    //   121: astore_3
    //   122: aload_0
    //   123: astore_2
    //   124: aload_1
    //   125: ldc_w 300
    //   128: invokevirtual 303	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore 4
    //   133: aload 4
    //   135: astore_2
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 304	java/io/ByteArrayOutputStream:close	()V
    //   144: aload_2
    //   145: astore_1
    //   146: aload_0
    //   147: ifnull +9 -> 156
    //   150: aload_0
    //   151: invokevirtual 170	java/io/FileInputStream:close	()V
    //   154: aload_2
    //   155: astore_1
    //   156: aload_1
    //   157: areturn
    //   158: astore_0
    //   159: aload_2
    //   160: astore_1
    //   161: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq -8 -> 156
    //   167: ldc 12
    //   169: iconst_2
    //   170: ldc_w 306
    //   173: aload_0
    //   174: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   177: aload_2
    //   178: areturn
    //   179: astore 4
    //   181: aconst_null
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_0
    //   185: aload_1
    //   186: astore_3
    //   187: aload_0
    //   188: astore_2
    //   189: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   192: ifeq +18 -> 210
    //   195: aload_1
    //   196: astore_3
    //   197: aload_0
    //   198: astore_2
    //   199: ldc 12
    //   201: iconst_2
    //   202: ldc_w 306
    //   205: aload 4
    //   207: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload_1
    //   211: ifnull +7 -> 218
    //   214: aload_1
    //   215: invokevirtual 304	java/io/ByteArrayOutputStream:close	()V
    //   218: aload 5
    //   220: astore_1
    //   221: aload_0
    //   222: ifnull -66 -> 156
    //   225: aload_0
    //   226: invokevirtual 170	java/io/FileInputStream:close	()V
    //   229: aconst_null
    //   230: areturn
    //   231: astore_0
    //   232: aload 5
    //   234: astore_1
    //   235: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq -82 -> 156
    //   241: ldc 12
    //   243: iconst_2
    //   244: ldc_w 306
    //   247: aload_0
    //   248: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   251: aconst_null
    //   252: areturn
    //   253: astore_0
    //   254: aconst_null
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_2
    //   258: aload_1
    //   259: ifnull +7 -> 266
    //   262: aload_1
    //   263: invokevirtual 304	java/io/ByteArrayOutputStream:close	()V
    //   266: aload_2
    //   267: ifnull +7 -> 274
    //   270: aload_2
    //   271: invokevirtual 170	java/io/FileInputStream:close	()V
    //   274: aload_0
    //   275: athrow
    //   276: astore_1
    //   277: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq -6 -> 274
    //   283: ldc 12
    //   285: iconst_2
    //   286: ldc_w 306
    //   289: aload_1
    //   290: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   293: goto -19 -> 274
    //   296: astore_0
    //   297: aconst_null
    //   298: astore_2
    //   299: goto -41 -> 258
    //   302: astore_0
    //   303: aload_3
    //   304: astore_1
    //   305: goto -47 -> 258
    //   308: astore 4
    //   310: aconst_null
    //   311: astore_0
    //   312: goto -127 -> 185
    //   315: astore 4
    //   317: goto -132 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramFile	File
    //   22	241	1	localObject1	Object
    //   276	14	1	localIOException	IOException
    //   304	1	1	localObject2	Object
    //   35	35	2	localFile	File
    //   89	1	2	localOutOfMemoryError	OutOfMemoryError
    //   93	206	2	localObject3	Object
    //   33	271	3	localObject4	Object
    //   45	89	4	localObject5	Object
    //   179	27	4	localException1	Exception
    //   308	1	4	localException2	Exception
    //   315	1	4	localException3	Exception
    //   4	229	5	localObject6	Object
    //   1	84	6	j	int
    //   11	41	7	k	int
    //   64	20	8	m	int
    // Exception table:
    //   from	to	target	type
    //   36	47	89	java/lang/OutOfMemoryError
    //   140	144	158	java/io/IOException
    //   150	154	158	java/io/IOException
    //   6	23	179	java/lang/Exception
    //   214	218	231	java/io/IOException
    //   225	229	231	java/io/IOException
    //   6	23	253	finally
    //   262	266	276	java/io/IOException
    //   270	274	276	java/io/IOException
    //   23	32	296	finally
    //   36	47	302	finally
    //   58	66	302	finally
    //   70	79	302	finally
    //   94	105	302	finally
    //   112	120	302	finally
    //   124	133	302	finally
    //   189	195	302	finally
    //   199	210	302	finally
    //   23	32	308	java/lang/Exception
    //   36	47	315	java/lang/Exception
    //   58	66	315	java/lang/Exception
    //   70	79	315	java/lang/Exception
    //   94	105	315	java/lang/Exception
    //   112	120	315	java/lang/Exception
    //   124	133	315	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 145	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: iconst_2
    //   12: newarray <illegal type>
    //   14: astore_0
    //   15: aload_2
    //   16: astore_1
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 290	java/io/FileInputStream:read	([B)I
    //   22: iconst_m1
    //   23: if_icmpeq +134 -> 157
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: invokestatic 313	com/tencent/mobileqq/utils/FileUtils:a	([B)Ljava/lang/String;
    //   32: astore_0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 170	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: ifnull +9 -> 51
    //   45: aload_2
    //   46: invokevirtual 170	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: astore_1
    //   51: aload_1
    //   52: areturn
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_2
    //   56: ldc_w 315
    //   59: astore_0
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: invokevirtual 318	java/io/FileNotFoundException:printStackTrace	()V
    //   66: aload_0
    //   67: astore_1
    //   68: aload_2
    //   69: ifnull -18 -> 51
    //   72: aload_2
    //   73: invokevirtual 170	java/io/FileInputStream:close	()V
    //   76: aload_0
    //   77: areturn
    //   78: astore_1
    //   79: aload_0
    //   80: areturn
    //   81: astore_3
    //   82: aconst_null
    //   83: astore_2
    //   84: ldc_w 315
    //   87: astore_0
    //   88: aload_2
    //   89: astore_1
    //   90: aload_3
    //   91: invokevirtual 319	java/io/IOException:printStackTrace	()V
    //   94: aload_0
    //   95: astore_1
    //   96: aload_2
    //   97: ifnull -46 -> 51
    //   100: aload_2
    //   101: invokevirtual 170	java/io/FileInputStream:close	()V
    //   104: aload_0
    //   105: areturn
    //   106: astore_1
    //   107: aload_0
    //   108: areturn
    //   109: astore_0
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 170	java/io/FileInputStream:close	()V
    //   120: aload_0
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: areturn
    //   125: astore_1
    //   126: goto -6 -> 120
    //   129: astore_0
    //   130: goto -18 -> 112
    //   133: astore_3
    //   134: ldc_w 315
    //   137: astore_0
    //   138: goto -50 -> 88
    //   141: astore_3
    //   142: goto -54 -> 88
    //   145: astore_3
    //   146: ldc_w 315
    //   149: astore_0
    //   150: goto -90 -> 60
    //   153: astore_3
    //   154: goto -94 -> 60
    //   157: ldc_w 315
    //   160: astore_0
    //   161: goto -128 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramString	String
    //   10	58	1	localObject1	Object
    //   78	1	1	localIOException1	IOException
    //   89	7	1	localObject2	Object
    //   106	1	1	localIOException2	IOException
    //   111	6	1	localObject3	Object
    //   122	1	1	localIOException3	IOException
    //   125	1	1	localIOException4	IOException
    //   8	93	2	localFileInputStream	FileInputStream
    //   53	10	3	localFileNotFoundException1	FileNotFoundException
    //   81	10	3	localIOException5	IOException
    //   133	1	3	localIOException6	IOException
    //   141	1	3	localIOException7	IOException
    //   145	1	3	localFileNotFoundException2	FileNotFoundException
    //   153	1	3	localFileNotFoundException3	FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	9	53	java/io/FileNotFoundException
    //   72	76	78	java/io/IOException
    //   0	9	81	java/io/IOException
    //   100	104	106	java/io/IOException
    //   0	9	109	finally
    //   45	49	122	java/io/IOException
    //   116	120	125	java/io/IOException
    //   11	15	129	finally
    //   17	26	129	finally
    //   28	33	129	finally
    //   35	39	129	finally
    //   62	66	129	finally
    //   90	94	129	finally
    //   11	15	133	java/io/IOException
    //   17	26	133	java/io/IOException
    //   28	33	133	java/io/IOException
    //   35	39	141	java/io/IOException
    //   11	15	145	java/io/FileNotFoundException
    //   17	26	145	java/io/FileNotFoundException
    //   28	33	145	java/io/FileNotFoundException
    //   35	39	153	java/io/FileNotFoundException
  }
  
  public static String a(String paramString, long paramLong)
  {
    try
    {
      paramString = new FileInputStream(paramString);
      if (paramString == null) {
        break label81;
      }
      String str = HexUtil.bytes2HexStr(MD5.toMD5Byte(paramString, paramLong));
      paramString = str;
      if (!TextUtils.isEmpty(str)) {
        break label58;
      }
    }
    catch (FileNotFoundException paramString)
    {
      do
      {
        paramString.printStackTrace();
        if (0 == 0) {
          break;
        }
        paramString = HexUtil.bytes2HexStr(MD5.toMD5Byte(null, paramLong));
      } while (TextUtils.isEmpty(paramString));
      label58:
      return paramString;
    }
    finally
    {
      do
      {
        if (0 == 0) {
          break;
        }
      } while (TextUtils.isEmpty(HexUtil.bytes2HexStr(MD5.toMD5Byte(null, paramLong))));
    }
    return null;
    for (;;)
    {
      label81:
      paramString = null;
    }
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 73	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: aload_0
    //   13: ifnull +17 -> 30
    //   16: aload_0
    //   17: invokevirtual 99	java/io/File:exists	()Z
    //   20: ifeq +10 -> 30
    //   23: aload_0
    //   24: invokevirtual 337	java/io/File:isFile	()Z
    //   27: ifne +5 -> 32
    //   30: aconst_null
    //   31: areturn
    //   32: aload_1
    //   33: invokestatic 343	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   36: astore_2
    //   37: new 145	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore_1
    //   46: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   49: sipush 1024
    //   52: invokevirtual 286	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   55: astore_3
    //   56: bipush 16
    //   58: newarray <illegal type>
    //   60: astore_0
    //   61: aload_0
    //   62: dup
    //   63: iconst_0
    //   64: ldc_w 344
    //   67: castore
    //   68: dup
    //   69: iconst_1
    //   70: ldc_w 345
    //   73: castore
    //   74: dup
    //   75: iconst_2
    //   76: ldc_w 346
    //   79: castore
    //   80: dup
    //   81: iconst_3
    //   82: ldc_w 347
    //   85: castore
    //   86: dup
    //   87: iconst_4
    //   88: ldc_w 348
    //   91: castore
    //   92: dup
    //   93: iconst_5
    //   94: ldc_w 349
    //   97: castore
    //   98: dup
    //   99: bipush 6
    //   101: ldc_w 350
    //   104: castore
    //   105: dup
    //   106: bipush 7
    //   108: ldc_w 351
    //   111: castore
    //   112: dup
    //   113: bipush 8
    //   115: ldc_w 352
    //   118: castore
    //   119: dup
    //   120: bipush 9
    //   122: ldc_w 353
    //   125: castore
    //   126: dup
    //   127: bipush 10
    //   129: ldc_w 354
    //   132: castore
    //   133: dup
    //   134: bipush 11
    //   136: ldc_w 355
    //   139: castore
    //   140: dup
    //   141: bipush 12
    //   143: ldc_w 356
    //   146: castore
    //   147: dup
    //   148: bipush 13
    //   150: ldc_w 357
    //   153: castore
    //   154: dup
    //   155: bipush 14
    //   157: ldc_w 358
    //   160: castore
    //   161: dup
    //   162: bipush 15
    //   164: ldc_w 359
    //   167: castore
    //   168: pop
    //   169: aload_1
    //   170: aload_3
    //   171: invokevirtual 290	java/io/FileInputStream:read	([B)I
    //   174: istore 5
    //   176: iload 5
    //   178: ifle +27 -> 205
    //   181: aload_2
    //   182: aload_3
    //   183: iconst_0
    //   184: iload 5
    //   186: invokevirtual 362	java/security/MessageDigest:update	([BII)V
    //   189: goto -20 -> 169
    //   192: astore_0
    //   193: aload_1
    //   194: ifnull +198 -> 392
    //   197: aload_1
    //   198: invokevirtual 170	java/io/FileInputStream:close	()V
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_0
    //   204: areturn
    //   205: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   208: aload_3
    //   209: invokevirtual 298	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   212: aload_2
    //   213: invokevirtual 366	java/security/MessageDigest:digest	()[B
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +12 -> 230
    //   221: aload_2
    //   222: arraylength
    //   223: istore 5
    //   225: iload 5
    //   227: ifne +16 -> 243
    //   230: aload_1
    //   231: ifnull -201 -> 30
    //   234: aload_1
    //   235: invokevirtual 170	java/io/FileInputStream:close	()V
    //   238: aconst_null
    //   239: areturn
    //   240: astore_0
    //   241: aconst_null
    //   242: areturn
    //   243: aload_2
    //   244: arraylength
    //   245: iconst_2
    //   246: imul
    //   247: newarray <illegal type>
    //   249: astore_3
    //   250: iload 4
    //   252: aload_2
    //   253: arraylength
    //   254: if_icmpge +49 -> 303
    //   257: aload_2
    //   258: iload 4
    //   260: baload
    //   261: istore 5
    //   263: aload_3
    //   264: iload 4
    //   266: iconst_2
    //   267: imul
    //   268: iconst_1
    //   269: iadd
    //   270: aload_0
    //   271: iload 5
    //   273: bipush 15
    //   275: iand
    //   276: caload
    //   277: castore
    //   278: aload_3
    //   279: iload 4
    //   281: iconst_2
    //   282: imul
    //   283: aload_0
    //   284: iload 5
    //   286: iconst_4
    //   287: iushr
    //   288: i2b
    //   289: bipush 15
    //   291: iand
    //   292: caload
    //   293: castore
    //   294: iload 4
    //   296: iconst_1
    //   297: iadd
    //   298: istore 4
    //   300: goto -50 -> 250
    //   303: new 241	java/lang/String
    //   306: dup
    //   307: aload_3
    //   308: invokespecial 369	java/lang/String:<init>	([C)V
    //   311: astore_2
    //   312: aload_2
    //   313: astore_0
    //   314: aload_1
    //   315: ifnull -112 -> 203
    //   318: aload_1
    //   319: invokevirtual 170	java/io/FileInputStream:close	()V
    //   322: aload_2
    //   323: astore_0
    //   324: goto -121 -> 203
    //   327: astore_0
    //   328: aload_2
    //   329: astore_0
    //   330: goto -127 -> 203
    //   333: astore_0
    //   334: aconst_null
    //   335: astore_0
    //   336: goto -133 -> 203
    //   339: astore_0
    //   340: aconst_null
    //   341: astore_1
    //   342: aload_1
    //   343: ifnull +49 -> 392
    //   346: aload_1
    //   347: invokevirtual 170	java/io/FileInputStream:close	()V
    //   350: aconst_null
    //   351: astore_0
    //   352: goto -149 -> 203
    //   355: astore_0
    //   356: aconst_null
    //   357: astore_0
    //   358: goto -155 -> 203
    //   361: astore_0
    //   362: aconst_null
    //   363: astore_1
    //   364: aload_1
    //   365: ifnull +7 -> 372
    //   368: aload_1
    //   369: invokevirtual 170	java/io/FileInputStream:close	()V
    //   372: aload_0
    //   373: athrow
    //   374: astore_1
    //   375: goto -3 -> 372
    //   378: astore_0
    //   379: goto -15 -> 364
    //   382: astore_0
    //   383: goto -41 -> 342
    //   386: astore_0
    //   387: aconst_null
    //   388: astore_1
    //   389: goto -196 -> 193
    //   392: aconst_null
    //   393: astore_0
    //   394: goto -191 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	paramString1	String
    //   0	397	1	paramString2	String
    //   36	293	2	localObject1	Object
    //   55	253	3	localObject2	Object
    //   1	298	4	j	int
    //   174	114	5	k	int
    // Exception table:
    //   from	to	target	type
    //   46	169	192	java/io/IOException
    //   169	176	192	java/io/IOException
    //   181	189	192	java/io/IOException
    //   205	217	192	java/io/IOException
    //   221	225	192	java/io/IOException
    //   243	250	192	java/io/IOException
    //   250	257	192	java/io/IOException
    //   303	312	192	java/io/IOException
    //   234	238	240	java/io/IOException
    //   318	322	327	java/io/IOException
    //   197	201	333	java/io/IOException
    //   32	46	339	java/security/NoSuchAlgorithmException
    //   346	350	355	java/io/IOException
    //   32	46	361	finally
    //   368	372	374	java/io/IOException
    //   46	169	378	finally
    //   169	176	378	finally
    //   181	189	378	finally
    //   205	217	378	finally
    //   221	225	378	finally
    //   243	250	378	finally
    //   250	257	378	finally
    //   303	312	378	finally
    //   46	169	382	java/security/NoSuchAlgorithmException
    //   169	176	382	java/security/NoSuchAlgorithmException
    //   181	189	382	java/security/NoSuchAlgorithmException
    //   205	217	382	java/security/NoSuchAlgorithmException
    //   221	225	382	java/security/NoSuchAlgorithmException
    //   243	250	382	java/security/NoSuchAlgorithmException
    //   250	257	382	java/security/NoSuchAlgorithmException
    //   303	312	382	java/security/NoSuchAlgorithmException
    //   32	46	386	java/io/IOException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    String str = "";
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      int j = 0;
      while (j < paramArrayOfByte.length)
      {
        str = str + Integer.toString(paramArrayOfByte[j] & 0xFF);
        j += 1;
      }
      switch (Integer.parseInt(str))
      {
      default: 
        return i + str;
      case 7790: 
        return "exe";
      case 7784: 
        return "midi";
      case 8297: 
        return "rar";
      case 8075: 
        return "zip";
      case 255216: 
        return "jpg";
      case 7173: 
        return "gif";
      case 6677: 
        return "bmp";
      case 13780: 
        return "png";
      }
      return "webp";
    }
    return i + "";
  }
  
  public static ArrayList a(String paramString)
  {
    Object localObject = new File(paramString);
    paramString = new ArrayList();
    localObject = ((File)localObject).listFiles();
    int j = 0;
    for (;;)
    {
      try
      {
        int k = localObject.length;
        if (j < k) {
          if (localObject[j].isDirectory()) {
            paramString.addAll(a(localObject[j].getCanonicalPath()));
          } else {
            paramString.add(localObject[j].getCanonicalPath());
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return paramString;
      j += 1;
    }
  }
  
  /* Error */
  public static void a(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +14 -> 15
    //   4: iload_1
    //   5: ifeq +10 -> 15
    //   8: aload_2
    //   9: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: invokevirtual 411	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   20: iload_1
    //   21: invokevirtual 417	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   24: checkcast 419	com/tencent/theme/SkinnableBitmapDrawable
    //   27: astore_3
    //   28: new 73	java/io/File
    //   31: dup
    //   32: aload_2
    //   33: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: aload_0
    //   38: invokevirtual 99	java/io/File:exists	()Z
    //   41: ifne +16 -> 57
    //   44: aload_0
    //   45: invokevirtual 177	java/io/File:getParentFile	()Ljava/io/File;
    //   48: invokevirtual 102	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: aload_0
    //   53: invokevirtual 137	java/io/File:createNewFile	()Z
    //   56: pop
    //   57: new 154	java/io/FileOutputStream
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   65: astore_0
    //   66: aload_3
    //   67: invokevirtual 423	com/tencent/theme/SkinnableBitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   70: getstatic 429	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   73: bipush 100
    //   75: aload_0
    //   76: invokevirtual 435	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   79: pop
    //   80: aload_0
    //   81: ifnull -66 -> 15
    //   84: aload_0
    //   85: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   88: return
    //   89: astore_0
    //   90: return
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 319	java/io/IOException:printStackTrace	()V
    //   96: goto -39 -> 57
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_0
    //   102: aload_0
    //   103: ifnull -88 -> 15
    //   106: aload_0
    //   107: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   110: return
    //   111: astore_0
    //   112: return
    //   113: astore_0
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: ifnull -102 -> 15
    //   120: aload_0
    //   121: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   124: return
    //   125: astore_0
    //   126: return
    //   127: astore_2
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull +7 -> 138
    //   134: aload_0
    //   135: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   138: aload_2
    //   139: athrow
    //   140: astore_0
    //   141: goto -3 -> 138
    //   144: astore_2
    //   145: goto -15 -> 130
    //   148: astore_2
    //   149: goto -33 -> 116
    //   152: astore_2
    //   153: goto -51 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramContext	Context
    //   0	156	1	paramInt	int
    //   0	156	2	paramString	String
    //   27	40	3	localSkinnableBitmapDrawable	com.tencent.theme.SkinnableBitmapDrawable
    // Exception table:
    //   from	to	target	type
    //   84	88	89	java/io/IOException
    //   52	57	91	java/io/IOException
    //   57	66	99	java/io/IOException
    //   106	110	111	java/io/IOException
    //   57	66	113	java/lang/OutOfMemoryError
    //   120	124	125	java/io/IOException
    //   57	66	127	finally
    //   134	138	140	java/io/IOException
    //   66	80	144	finally
    //   66	80	148	java/lang/OutOfMemoryError
    //   66	80	152	java/io/IOException
  }
  
  /* Error */
  public static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 99	java/io/File:exists	()Z
    //   6: ifeq +8 -> 14
    //   9: aload_1
    //   10: invokevirtual 140	java/io/File:delete	()Z
    //   13: pop
    //   14: new 154	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: astore_1
    //   23: new 145	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore_0
    //   32: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   35: sipush 4096
    //   38: invokevirtual 286	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   41: astore_2
    //   42: aload_0
    //   43: aload_2
    //   44: invokevirtual 290	java/io/FileInputStream:read	([B)I
    //   47: istore_3
    //   48: iload_3
    //   49: iconst_m1
    //   50: if_icmpeq +41 -> 91
    //   53: aload_1
    //   54: aload_2
    //   55: iconst_0
    //   56: iload_3
    //   57: invokevirtual 437	java/io/FileOutputStream:write	([BII)V
    //   60: aload_1
    //   61: invokevirtual 440	java/io/FileOutputStream:flush	()V
    //   64: goto -22 -> 42
    //   67: astore_2
    //   68: aload_0
    //   69: astore_2
    //   70: aload_1
    //   71: astore_0
    //   72: aload_2
    //   73: astore_1
    //   74: aload_0
    //   75: ifnull +7 -> 82
    //   78: aload_0
    //   79: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 170	java/io/FileInputStream:close	()V
    //   90: return
    //   91: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   94: aload_2
    //   95: invokevirtual 298	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   106: aload_0
    //   107: ifnull -17 -> 90
    //   110: aload_0
    //   111: invokevirtual 170	java/io/FileInputStream:close	()V
    //   114: return
    //   115: astore_0
    //   116: return
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_1
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   130: aload_0
    //   131: ifnull -41 -> 90
    //   134: aload_0
    //   135: invokevirtual 170	java/io/FileInputStream:close	()V
    //   138: return
    //   139: astore_0
    //   140: return
    //   141: astore_2
    //   142: aconst_null
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_0
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   154: aload_0
    //   155: ifnull +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 170	java/io/FileInputStream:close	()V
    //   162: aload_2
    //   163: athrow
    //   164: astore_1
    //   165: goto -59 -> 106
    //   168: astore_0
    //   169: goto -87 -> 82
    //   172: astore_0
    //   173: return
    //   174: astore_1
    //   175: goto -45 -> 130
    //   178: astore_1
    //   179: goto -25 -> 154
    //   182: astore_0
    //   183: goto -21 -> 162
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_0
    //   189: goto -43 -> 146
    //   192: astore_2
    //   193: goto -47 -> 146
    //   196: astore_0
    //   197: aconst_null
    //   198: astore_0
    //   199: goto -77 -> 122
    //   202: astore_2
    //   203: goto -81 -> 122
    //   206: astore_0
    //   207: aconst_null
    //   208: astore_0
    //   209: aload_2
    //   210: astore_1
    //   211: goto -137 -> 74
    //   214: astore_0
    //   215: aload_1
    //   216: astore_0
    //   217: aload_2
    //   218: astore_1
    //   219: goto -145 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramFile1	File
    //   0	222	1	paramFile2	File
    //   1	54	2	arrayOfByte	byte[]
    //   67	1	2	localIOException	IOException
    //   69	26	2	localFile	File
    //   141	22	2	localObject1	Object
    //   186	1	2	localObject2	Object
    //   192	1	2	localObject3	Object
    //   202	16	2	localOutOfMemoryError	OutOfMemoryError
    //   47	10	3	j	int
    // Exception table:
    //   from	to	target	type
    //   32	42	67	java/io/IOException
    //   42	48	67	java/io/IOException
    //   53	64	67	java/io/IOException
    //   91	98	67	java/io/IOException
    //   110	114	115	java/io/IOException
    //   2	14	117	java/lang/OutOfMemoryError
    //   14	23	117	java/lang/OutOfMemoryError
    //   134	138	139	java/io/IOException
    //   2	14	141	finally
    //   14	23	141	finally
    //   102	106	164	java/io/IOException
    //   78	82	168	java/io/IOException
    //   86	90	172	java/io/IOException
    //   126	130	174	java/io/IOException
    //   150	154	178	java/io/IOException
    //   158	162	182	java/io/IOException
    //   23	32	186	finally
    //   32	42	192	finally
    //   42	48	192	finally
    //   53	64	192	finally
    //   91	98	192	finally
    //   23	32	196	java/lang/OutOfMemoryError
    //   32	42	202	java/lang/OutOfMemoryError
    //   42	48	202	java/lang/OutOfMemoryError
    //   53	64	202	java/lang/OutOfMemoryError
    //   91	98	202	java/lang/OutOfMemoryError
    //   2	14	206	java/io/IOException
    //   14	23	206	java/io/IOException
    //   23	32	214	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return;
    }
    paramString = new File(paramString);
    File[] arrayOfFile = paramString.listFiles();
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int j = 0;
      if (j < arrayOfFile.length)
      {
        if (arrayOfFile[j].isDirectory()) {
          a(arrayOfFile[j].getAbsolutePath());
        }
        for (;;)
        {
          j += 1;
          break;
          arrayOfFile[j].delete();
        }
      }
    }
    paramString.delete();
  }
  
  /* Error */
  public static void a(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: new 453	java/io/ObjectOutputStream
    //   11: dup
    //   12: new 455	java/io/BufferedOutputStream
    //   15: dup
    //   16: invokestatic 194	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   19: aload_0
    //   20: iconst_0
    //   21: invokevirtual 459	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   24: invokespecial 462	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: invokespecial 463	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore_3
    //   31: aload_3
    //   32: astore_2
    //   33: aload_3
    //   34: aload_1
    //   35: invokevirtual 467	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   38: aload_3
    //   39: astore_2
    //   40: aload_3
    //   41: invokevirtual 468	java/io/ObjectOutputStream:flush	()V
    //   44: aload_3
    //   45: ifnull -38 -> 7
    //   48: aload_3
    //   49: invokevirtual 469	java/io/ObjectOutputStream:close	()V
    //   52: return
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 319	java/io/IOException:printStackTrace	()V
    //   58: return
    //   59: astore 4
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_1
    //   64: astore_2
    //   65: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +44 -> 112
    //   71: aload_1
    //   72: astore_2
    //   73: ldc 12
    //   75: iconst_2
    //   76: new 108	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   83: ldc_w 471
    //   86: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc -38
    //   95: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 4
    //   100: invokevirtual 219	java/lang/Exception:toString	()Ljava/lang/String;
    //   103: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 222	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: aload_1
    //   113: ifnull -106 -> 7
    //   116: aload_1
    //   117: invokevirtual 469	java/io/ObjectOutputStream:close	()V
    //   120: return
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 319	java/io/IOException:printStackTrace	()V
    //   126: return
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 469	java/io/ObjectOutputStream:close	()V
    //   138: aload_0
    //   139: athrow
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 319	java/io/IOException:printStackTrace	()V
    //   145: goto -7 -> 138
    //   148: astore_0
    //   149: goto -19 -> 130
    //   152: astore 4
    //   154: aload_3
    //   155: astore_1
    //   156: goto -93 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   0	159	1	paramObject	Object
    //   32	103	2	localObject	Object
    //   30	125	3	localObjectOutputStream	java.io.ObjectOutputStream
    //   59	40	4	localException1	Exception
    //   152	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   48	52	53	java/io/IOException
    //   8	31	59	java/lang/Exception
    //   116	120	121	java/io/IOException
    //   8	31	127	finally
    //   134	138	140	java/io/IOException
    //   33	38	148	finally
    //   40	44	148	finally
    //   65	71	148	finally
    //   73	112	148	finally
    //   33	38	152	java/lang/Exception
    //   40	44	152	java/lang/Exception
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 14
    //   3: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +39 -> 45
    //   9: ldc 12
    //   11: iconst_2
    //   12: new 108	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 474
    //   22: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 476
    //   32: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   45: new 145	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 310	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   53: astore_0
    //   54: new 188	java/io/BufferedInputStream
    //   57: dup
    //   58: aload_0
    //   59: invokespecial 203	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore_3
    //   63: new 480	java/util/zip/ZipInputStream
    //   66: dup
    //   67: aload_3
    //   68: invokespecial 481	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore 4
    //   73: new 73	java/io/File
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: invokevirtual 102	java/io/File:mkdirs	()Z
    //   84: pop
    //   85: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   88: sipush 8192
    //   91: invokevirtual 286	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   94: astore 10
    //   96: aconst_null
    //   97: astore 5
    //   99: aconst_null
    //   100: astore 7
    //   102: aload 4
    //   104: invokevirtual 485	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   107: astore 6
    //   109: aload 6
    //   111: ifnonnull +86 -> 197
    //   114: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   117: aload 10
    //   119: invokevirtual 298	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   122: invokestatic 491	java/lang/Math:random	()D
    //   125: ldc2_w 492
    //   128: dcmpg
    //   129: ifge +21 -> 150
    //   132: invokestatic 496	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   135: invokestatic 501	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   138: aconst_null
    //   139: ldc_w 503
    //   142: iconst_1
    //   143: lconst_0
    //   144: lconst_0
    //   145: aconst_null
    //   146: aconst_null
    //   147: invokevirtual 506	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   150: aload 4
    //   152: ifnull +8 -> 160
    //   155: aload 4
    //   157: invokevirtual 507	java/util/zip/ZipInputStream:close	()V
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   168: aload_0
    //   169: ifnull +7 -> 176
    //   172: aload_0
    //   173: invokevirtual 170	java/io/FileInputStream:close	()V
    //   176: aload 7
    //   178: ifnull +8 -> 186
    //   181: aload 7
    //   183: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   186: aload 5
    //   188: ifnull +8 -> 196
    //   191: aload 5
    //   193: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   196: return
    //   197: aload 6
    //   199: invokevirtual 512	java/util/zip/ZipEntry:isDirectory	()Z
    //   202: ifne -100 -> 102
    //   205: aload 6
    //   207: invokevirtual 513	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   210: astore 6
    //   212: aload 6
    //   214: ifnull -112 -> 102
    //   217: aload 6
    //   219: ldc_w 515
    //   222: invokevirtual 518	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   225: ifne -123 -> 102
    //   228: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +30 -> 261
    //   234: ldc 12
    //   236: iconst_2
    //   237: new 108	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 520
    //   247: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 6
    //   252: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload 6
    //   263: getstatic 524	java/io/File:separatorChar	C
    //   266: invokevirtual 528	java/lang/String:lastIndexOf	(I)I
    //   269: istore 11
    //   271: iload 11
    //   273: aload 6
    //   275: invokevirtual 445	java/lang/String:length	()I
    //   278: iconst_1
    //   279: isub
    //   280: if_icmpne +144 -> 424
    //   283: new 530	java/lang/IllegalArgumentException
    //   286: dup
    //   287: new 108	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 532
    //   297: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 6
    //   302: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokespecial 533	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   311: athrow
    //   312: astore 8
    //   314: aload_0
    //   315: astore 6
    //   317: aload 5
    //   319: astore_1
    //   320: iconst_0
    //   321: istore 11
    //   323: aload 8
    //   325: astore_0
    //   326: aload_3
    //   327: astore 5
    //   329: aload 7
    //   331: astore_3
    //   332: invokestatic 491	java/lang/Math:random	()D
    //   335: ldc2_w 492
    //   338: dcmpg
    //   339: ifge +32 -> 371
    //   342: invokestatic 496	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   345: invokestatic 501	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   348: astore 7
    //   350: iload 11
    //   352: ifne +442 -> 794
    //   355: iconst_1
    //   356: istore_2
    //   357: aload 7
    //   359: aconst_null
    //   360: ldc_w 503
    //   363: iload_2
    //   364: lconst_0
    //   365: lconst_0
    //   366: aconst_null
    //   367: aconst_null
    //   368: invokevirtual 506	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   371: aload 4
    //   373: ifnull +13 -> 386
    //   376: iload 11
    //   378: ifne +8 -> 386
    //   381: aload 4
    //   383: invokevirtual 507	java/util/zip/ZipInputStream:close	()V
    //   386: aload 5
    //   388: ifnull +8 -> 396
    //   391: aload 5
    //   393: invokevirtual 508	java/io/BufferedInputStream:close	()V
    //   396: aload 6
    //   398: ifnull +8 -> 406
    //   401: aload 6
    //   403: invokevirtual 170	java/io/FileInputStream:close	()V
    //   406: aload_3
    //   407: ifnull +7 -> 414
    //   410: aload_3
    //   411: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   414: aload_1
    //   415: ifnull +7 -> 422
    //   418: aload_1
    //   419: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   422: aload_0
    //   423: athrow
    //   424: iload 11
    //   426: ifgt +222 -> 648
    //   429: iload 11
    //   431: ifge +203 -> 634
    //   434: aload_1
    //   435: astore 8
    //   437: aload 6
    //   439: astore 9
    //   441: iload_2
    //   442: ifeq +32 -> 474
    //   445: aload 6
    //   447: ldc_w 535
    //   450: invokevirtual 537	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   453: istore 11
    //   455: aload 6
    //   457: astore 9
    //   459: iload 11
    //   461: ifle +13 -> 474
    //   464: aload 6
    //   466: iconst_0
    //   467: iload 11
    //   469: invokevirtual 541	java/lang/String:substring	(II)Ljava/lang/String;
    //   472: astore 9
    //   474: new 73	java/io/File
    //   477: dup
    //   478: aload 8
    //   480: aload 9
    //   482: invokespecial 544	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: astore 6
    //   487: aload 6
    //   489: invokevirtual 177	java/io/File:getParentFile	()Ljava/io/File;
    //   492: invokevirtual 99	java/io/File:exists	()Z
    //   495: ifne +12 -> 507
    //   498: aload 6
    //   500: invokevirtual 177	java/io/File:getParentFile	()Ljava/io/File;
    //   503: invokevirtual 102	java/io/File:mkdirs	()Z
    //   506: pop
    //   507: aload 6
    //   509: invokevirtual 99	java/io/File:exists	()Z
    //   512: ifeq +9 -> 521
    //   515: aload 6
    //   517: invokevirtual 140	java/io/File:delete	()Z
    //   520: pop
    //   521: new 154	java/io/FileOutputStream
    //   524: dup
    //   525: aload 6
    //   527: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   530: astore 6
    //   532: new 455	java/io/BufferedOutputStream
    //   535: dup
    //   536: aload 6
    //   538: aload 10
    //   540: arraylength
    //   541: invokespecial 547	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   544: astore 7
    //   546: iconst_0
    //   547: istore 13
    //   549: iload 14
    //   551: istore 11
    //   553: aload 4
    //   555: aload 10
    //   557: iconst_0
    //   558: aload 10
    //   560: arraylength
    //   561: invokevirtual 550	java/util/zip/ZipInputStream:read	([BII)I
    //   564: istore 15
    //   566: iload 15
    //   568: iconst_m1
    //   569: if_icmpeq +187 -> 756
    //   572: iload 13
    //   574: istore 12
    //   576: iload 15
    //   578: ifne +157 -> 735
    //   581: iload 13
    //   583: iconst_1
    //   584: iadd
    //   585: istore 11
    //   587: iload 11
    //   589: istore 12
    //   591: iload 11
    //   593: bipush 10
    //   595: if_icmple +140 -> 735
    //   598: iconst_1
    //   599: istore 11
    //   601: new 132	java/io/IOException
    //   604: dup
    //   605: ldc_w 552
    //   608: invokespecial 553	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   611: athrow
    //   612: astore_1
    //   613: aload_3
    //   614: astore 5
    //   616: aload_0
    //   617: astore 8
    //   619: aload 6
    //   621: astore_3
    //   622: aload_1
    //   623: astore_0
    //   624: aload 7
    //   626: astore_1
    //   627: aload 8
    //   629: astore 6
    //   631: goto -299 -> 332
    //   634: aload 6
    //   636: iconst_1
    //   637: invokevirtual 555	java/lang/String:substring	(I)Ljava/lang/String;
    //   640: astore 6
    //   642: aload_1
    //   643: astore 8
    //   645: goto -208 -> 437
    //   648: aload 6
    //   650: iconst_0
    //   651: iload 11
    //   653: invokevirtual 541	java/lang/String:substring	(II)Ljava/lang/String;
    //   656: astore 8
    //   658: aload 8
    //   660: iconst_0
    //   661: invokevirtual 559	java/lang/String:charAt	(I)C
    //   664: getstatic 524	java/io/File:separatorChar	C
    //   667: if_icmpne +38 -> 705
    //   670: new 108	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   677: aload_1
    //   678: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload 8
    //   683: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: astore 8
    //   691: aload 6
    //   693: iload 11
    //   695: iconst_1
    //   696: iadd
    //   697: invokevirtual 555	java/lang/String:substring	(I)Ljava/lang/String;
    //   700: astore 6
    //   702: goto -265 -> 437
    //   705: new 108	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   712: aload_1
    //   713: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: getstatic 524	java/io/File:separatorChar	C
    //   719: invokevirtual 562	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   722: aload 8
    //   724: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: astore 8
    //   732: goto -41 -> 691
    //   735: iload 14
    //   737: istore 11
    //   739: aload 7
    //   741: aload 10
    //   743: iconst_0
    //   744: iload 15
    //   746: invokevirtual 563	java/io/BufferedOutputStream:write	([BII)V
    //   749: iload 12
    //   751: istore 13
    //   753: goto -204 -> 549
    //   756: iload 14
    //   758: istore 11
    //   760: aload 7
    //   762: invokevirtual 564	java/io/BufferedOutputStream:flush	()V
    //   765: iload 14
    //   767: istore 11
    //   769: aload 7
    //   771: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   774: iload 14
    //   776: istore 11
    //   778: aload 6
    //   780: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   783: aload 7
    //   785: astore 5
    //   787: aload 6
    //   789: astore 7
    //   791: goto -689 -> 102
    //   794: iconst_0
    //   795: istore_2
    //   796: goto -439 -> 357
    //   799: astore_1
    //   800: goto -640 -> 160
    //   803: astore_1
    //   804: goto -636 -> 168
    //   807: astore_0
    //   808: goto -632 -> 176
    //   811: astore_0
    //   812: goto -626 -> 186
    //   815: astore_0
    //   816: return
    //   817: astore 4
    //   819: goto -433 -> 386
    //   822: astore 4
    //   824: goto -428 -> 396
    //   827: astore 4
    //   829: goto -423 -> 406
    //   832: astore_3
    //   833: goto -419 -> 414
    //   836: astore_1
    //   837: goto -415 -> 422
    //   840: astore_0
    //   841: iconst_0
    //   842: istore 11
    //   844: aconst_null
    //   845: astore_1
    //   846: aconst_null
    //   847: astore_3
    //   848: aconst_null
    //   849: astore 4
    //   851: aconst_null
    //   852: astore 5
    //   854: aconst_null
    //   855: astore 6
    //   857: goto -525 -> 332
    //   860: astore_1
    //   861: iconst_0
    //   862: istore 11
    //   864: aconst_null
    //   865: astore 7
    //   867: aconst_null
    //   868: astore_3
    //   869: aconst_null
    //   870: astore 5
    //   872: aload_0
    //   873: astore 6
    //   875: aconst_null
    //   876: astore 4
    //   878: aload_1
    //   879: astore_0
    //   880: aload 7
    //   882: astore_1
    //   883: goto -551 -> 332
    //   886: astore_1
    //   887: iconst_0
    //   888: istore 11
    //   890: aconst_null
    //   891: astore 4
    //   893: aload_3
    //   894: astore 5
    //   896: aload_0
    //   897: astore 6
    //   899: aconst_null
    //   900: astore_3
    //   901: aconst_null
    //   902: astore 7
    //   904: aload_1
    //   905: astore_0
    //   906: aload 4
    //   908: astore_1
    //   909: aload 7
    //   911: astore 4
    //   913: goto -581 -> 332
    //   916: astore_1
    //   917: iconst_0
    //   918: istore 11
    //   920: aload_3
    //   921: astore 5
    //   923: aload_0
    //   924: astore 6
    //   926: aconst_null
    //   927: astore_3
    //   928: aconst_null
    //   929: astore 7
    //   931: aload_1
    //   932: astore_0
    //   933: aload 7
    //   935: astore_1
    //   936: goto -604 -> 332
    //   939: astore 9
    //   941: iconst_0
    //   942: istore 11
    //   944: aload_3
    //   945: astore 7
    //   947: aload_0
    //   948: astore 8
    //   950: aload 6
    //   952: astore_3
    //   953: aload 5
    //   955: astore_1
    //   956: aload 9
    //   958: astore_0
    //   959: aload 7
    //   961: astore 5
    //   963: aload 8
    //   965: astore 6
    //   967: goto -635 -> 332
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	970	0	paramString1	String
    //   0	970	1	paramString2	String
    //   0	970	2	paramBoolean	boolean
    //   62	560	3	localObject1	Object
    //   832	1	3	localIOException1	IOException
    //   847	106	3	localObject2	Object
    //   71	483	4	localZipInputStream	java.util.zip.ZipInputStream
    //   817	1	4	localIOException2	IOException
    //   822	1	4	localIOException3	IOException
    //   827	1	4	localIOException4	IOException
    //   849	63	4	localObject3	Object
    //   97	865	5	localObject4	Object
    //   107	859	6	localObject5	Object
    //   100	860	7	localObject6	Object
    //   312	12	8	localObject7	Object
    //   435	529	8	str	String
    //   439	42	9	localObject8	Object
    //   939	18	9	localObject9	Object
    //   94	648	10	arrayOfByte	byte[]
    //   269	674	11	j	int
    //   574	176	12	k	int
    //   547	205	13	m	int
    //   1	774	14	n	int
    //   564	181	15	i1	int
    // Exception table:
    //   from	to	target	type
    //   102	109	312	finally
    //   114	122	312	finally
    //   197	212	312	finally
    //   217	261	312	finally
    //   261	312	312	finally
    //   445	455	312	finally
    //   464	474	312	finally
    //   474	507	312	finally
    //   507	521	312	finally
    //   521	532	312	finally
    //   634	642	312	finally
    //   648	691	312	finally
    //   691	702	312	finally
    //   705	732	312	finally
    //   553	566	612	finally
    //   601	612	612	finally
    //   739	749	612	finally
    //   760	765	612	finally
    //   769	774	612	finally
    //   778	783	612	finally
    //   155	160	799	java/io/IOException
    //   164	168	803	java/io/IOException
    //   172	176	807	java/io/IOException
    //   181	186	811	java/io/IOException
    //   191	196	815	java/io/IOException
    //   381	386	817	java/io/IOException
    //   391	396	822	java/io/IOException
    //   401	406	827	java/io/IOException
    //   410	414	832	java/io/IOException
    //   418	422	836	java/io/IOException
    //   3	45	840	finally
    //   45	54	840	finally
    //   54	63	860	finally
    //   63	73	886	finally
    //   73	96	916	finally
    //   532	546	939	finally
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        do
        {
          return;
          paramString = new File(paramString);
        } while ((paramString == null) || (!paramString.exists()));
        if (paramString.isFile())
        {
          paramString.delete();
          return;
        }
        arrayOfFile = paramString.listFiles();
      } while (arrayOfFile == null);
      int k = arrayOfFile.length;
      int j = 0;
      while (j < k)
      {
        a(arrayOfFile[j].getAbsolutePath(), paramBoolean);
        j += 1;
      }
    } while (paramBoolean);
    paramString.delete();
  }
  
  /* Error */
  public static void a(String paramString, Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 445	java/lang/String:length	()I
    //   8: ifne +4 -> 12
    //   11: return
    //   12: new 453	java/io/ObjectOutputStream
    //   15: dup
    //   16: new 455	java/io/BufferedOutputStream
    //   19: dup
    //   20: invokestatic 194	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   23: aload_0
    //   24: iconst_0
    //   25: invokevirtual 459	com/tencent/qphone/base/util/BaseApplication:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   28: invokespecial 462	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: invokespecial 463	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore_3
    //   35: aload_3
    //   36: astore_2
    //   37: aload_1
    //   38: arraylength
    //   39: istore 6
    //   41: iconst_0
    //   42: istore 5
    //   44: iload 5
    //   46: iload 6
    //   48: if_icmpge +215 -> 263
    //   51: aload_1
    //   52: iload 5
    //   54: aaload
    //   55: astore 4
    //   57: aload_3
    //   58: astore_2
    //   59: aload 4
    //   61: instanceof 570
    //   64: ifeq +20 -> 84
    //   67: aload_3
    //   68: astore_2
    //   69: aload_3
    //   70: aload 4
    //   72: checkcast 570	java/lang/Boolean
    //   75: invokevirtual 573	java/lang/Boolean:booleanValue	()Z
    //   78: invokevirtual 577	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   81: goto +223 -> 304
    //   84: aload_3
    //   85: astore_2
    //   86: aload 4
    //   88: instanceof 579
    //   91: ifeq +96 -> 187
    //   94: aload_3
    //   95: astore_2
    //   96: aload_3
    //   97: aload 4
    //   99: checkcast 579	java/lang/Byte
    //   102: invokevirtual 583	java/lang/Byte:byteValue	()B
    //   105: invokevirtual 586	java/io/ObjectOutputStream:writeByte	(I)V
    //   108: goto +196 -> 304
    //   111: astore_2
    //   112: aload_3
    //   113: astore_1
    //   114: aload_2
    //   115: astore_3
    //   116: aload_1
    //   117: astore_2
    //   118: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +45 -> 166
    //   124: aload_1
    //   125: astore_2
    //   126: ldc_w 588
    //   129: iconst_2
    //   130: new 108	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 590
    //   140: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc_w 592
    //   150: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_3
    //   154: invokevirtual 595	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_1
    //   167: astore_2
    //   168: aload_3
    //   169: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   172: aload_1
    //   173: ifnull -162 -> 11
    //   176: aload_1
    //   177: invokevirtual 469	java/io/ObjectOutputStream:close	()V
    //   180: return
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 319	java/io/IOException:printStackTrace	()V
    //   186: return
    //   187: aload_3
    //   188: astore_2
    //   189: aload 4
    //   191: instanceof 371
    //   194: ifeq +31 -> 225
    //   197: aload_3
    //   198: astore_2
    //   199: aload_3
    //   200: aload 4
    //   202: checkcast 371	java/lang/Integer
    //   205: invokevirtual 598	java/lang/Integer:intValue	()I
    //   208: invokevirtual 601	java/io/ObjectOutputStream:writeInt	(I)V
    //   211: goto +93 -> 304
    //   214: astore_0
    //   215: aload_2
    //   216: ifnull +7 -> 223
    //   219: aload_2
    //   220: invokevirtual 469	java/io/ObjectOutputStream:close	()V
    //   223: aload_0
    //   224: athrow
    //   225: aload_3
    //   226: astore_2
    //   227: aload 4
    //   229: instanceof 603
    //   232: ifeq +20 -> 252
    //   235: aload_3
    //   236: astore_2
    //   237: aload_3
    //   238: aload 4
    //   240: checkcast 603	java/lang/Long
    //   243: invokevirtual 606	java/lang/Long:longValue	()J
    //   246: invokevirtual 610	java/io/ObjectOutputStream:writeLong	(J)V
    //   249: goto +55 -> 304
    //   252: aload_3
    //   253: astore_2
    //   254: aload_3
    //   255: aload 4
    //   257: invokevirtual 467	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   260: goto +44 -> 304
    //   263: aload_3
    //   264: astore_2
    //   265: aload_3
    //   266: invokevirtual 468	java/io/ObjectOutputStream:flush	()V
    //   269: aload_3
    //   270: ifnull -259 -> 11
    //   273: aload_3
    //   274: invokevirtual 469	java/io/ObjectOutputStream:close	()V
    //   277: return
    //   278: astore_0
    //   279: aload_0
    //   280: invokevirtual 319	java/io/IOException:printStackTrace	()V
    //   283: return
    //   284: astore_1
    //   285: aload_1
    //   286: invokevirtual 319	java/io/IOException:printStackTrace	()V
    //   289: goto -66 -> 223
    //   292: astore_0
    //   293: aconst_null
    //   294: astore_2
    //   295: goto -80 -> 215
    //   298: astore_3
    //   299: aconst_null
    //   300: astore_1
    //   301: goto -185 -> 116
    //   304: iload 5
    //   306: iconst_1
    //   307: iadd
    //   308: istore 5
    //   310: goto -266 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	paramString	String
    //   0	313	1	paramVarArgs	Object[]
    //   36	60	2	localObject1	Object
    //   111	4	2	localException1	Exception
    //   117	178	2	localObject2	Object
    //   34	240	3	localObject3	Object
    //   298	1	3	localException2	Exception
    //   55	201	4	localObject4	Object
    //   42	267	5	j	int
    //   39	10	6	k	int
    // Exception table:
    //   from	to	target	type
    //   37	41	111	java/lang/Exception
    //   59	67	111	java/lang/Exception
    //   69	81	111	java/lang/Exception
    //   86	94	111	java/lang/Exception
    //   96	108	111	java/lang/Exception
    //   189	197	111	java/lang/Exception
    //   199	211	111	java/lang/Exception
    //   227	235	111	java/lang/Exception
    //   237	249	111	java/lang/Exception
    //   254	260	111	java/lang/Exception
    //   265	269	111	java/lang/Exception
    //   176	180	181	java/io/IOException
    //   37	41	214	finally
    //   59	67	214	finally
    //   69	81	214	finally
    //   86	94	214	finally
    //   96	108	214	finally
    //   118	124	214	finally
    //   126	166	214	finally
    //   168	172	214	finally
    //   189	197	214	finally
    //   199	211	214	finally
    //   227	235	214	finally
    //   237	249	214	finally
    //   254	260	214	finally
    //   265	269	214	finally
    //   273	277	278	java/io/IOException
    //   219	223	284	java/io/IOException
    //   12	35	292	finally
    //   12	35	298	java/lang/Exception
  }
  
  public static boolean a()
  {
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile.exists()) && (localFile.canWrite())) {}
    for (int j = 1; (Environment.getExternalStorageState().equals("mounted")) && (j != 0); j = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    File localFile;
    boolean bool2;
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      localFile = new File(AppConstants.bj);
      localFile = new File(localFile, "diskcache");
      if (!localFile.exists()) {
        break label58;
      }
      bool2 = true;
    }
    for (;;)
    {
      return bool2;
      localFile = BaseApplicationImpl.a.getCacheDir();
      break;
      try
      {
        label58:
        bool1 = localFile.mkdirs();
      }
      catch (Exception localException)
      {
        try
        {
          if (!jdField_a_of_type_Boolean) {
            jdField_a_of_type_Boolean = true;
          }
          if ((!bool1) && ((!b()) || (!c()) || (!d()))) {
            ThreadManager.c().post(new wal(paramContext));
          }
          bool2 = bool1;
          if (!paramBoolean) {
            continue;
          }
          if (!bool1)
          {
            bool2 = bool1;
            if (!jdField_a_of_type_Boolean) {
              continue;
            }
          }
          PicReporter.a(bool1);
          bool2 = bool1;
          if (bool1) {
            continue;
          }
          jdField_a_of_type_Boolean = false;
          return bool1;
        }
        finally {}
        localException = localException;
        if ((!b()) || (!c()) || (!d())) {
          ThreadManager.c().post(new wal(paramContext));
        }
        if ((paramBoolean) && (jdField_a_of_type_Boolean))
        {
          PicReporter.a(false);
          jdField_a_of_type_Boolean = false;
          return false;
        }
      }
      finally
      {
        localObject1 = finally;
        boolean bool1 = false;
        if ((!bool1) && ((!b()) || (!c()) || (!d()))) {
          ThreadManager.c().post(new wal(paramContext));
        }
        if ((paramBoolean) && ((bool1) || (jdField_a_of_type_Boolean)))
        {
          PicReporter.a(bool1);
          if (!bool1) {
            jdField_a_of_type_Boolean = false;
          }
        }
        throw ((Throwable)localObject1);
      }
    }
    return false;
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    boolean bool1 = true;
    if (paramFile2.exists()) {
      bool1 = paramFile2.delete();
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramFile1.renameTo(paramFile2);
    }
    return bool2;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramString1.exists()) {}
    for (;;)
    {
      try
      {
        paramString1.createNewFile();
        bool1 = bool2;
      }
      catch (IOException localIOException)
      {
        try
        {
          paramString1.close();
          return bool2;
        }
        catch (IOException paramString1) {}
        localIOException = localIOException;
        bool1 = false;
        continue;
      }
      try
      {
        paramString1 = new FileOutputStream(paramString1, false);
        bool2 = bool1;
      }
      catch (FileNotFoundException paramString1)
      {
        bool2 = false;
        paramString1 = null;
        continue;
      }
      try
      {
        paramString2 = paramString2 + "\r\n";
        bool1 = bool2;
        if (paramString1 != null)
        {
          paramString1.write(paramString2.getBytes());
          bool1 = bool2;
        }
      }
      catch (IOException paramString2)
      {
        bool1 = false;
      }
    }
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool2 = false;
      }
    }
    if (paramString1 != null) {}
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, InputStream paramInputStream)
  {
    return a(paramString1, new StringBuffer(paramString2), paramInputStream);
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    File localFile = new File(paramString1);
    String str = paramString2;
    if (paramString2 != null) {
      str = paramString2.replaceAll("[\\\\/*?<>:\"|]", "");
    }
    paramString1 = new File(paramString1 + str);
    bool1 = true;
    if (!localFile.exists()) {
      bool1 = localFile.mkdirs();
    }
    boolean bool3 = bool1;
    if (localFile.exists())
    {
      bool2 = bool1;
      if (paramString1.exists()) {}
    }
    try
    {
      paramString1.createNewFile();
      bool2 = bool1;
      return false;
    }
    catch (IOException paramString2)
    {
      try
      {
        for (;;)
        {
          paramString1 = new FileOutputStream(paramString1, false);
          try
          {
            paramString2 = paramString3 + "\r\n";
            bool1 = bool2;
            if (paramString1 != null)
            {
              paramString1.write(paramString2.getBytes());
              bool1 = bool2;
            }
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              bool1 = false;
            }
          }
          bool2 = bool1;
          if (paramString1 != null) {}
          try
          {
            paramString1.flush();
            bool2 = bool1;
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              bool2 = false;
            }
          }
          bool3 = bool2;
          if (paramString1 != null) {}
          try
          {
            paramString1.close();
            bool3 = bool2;
            return bool3;
          }
          catch (IOException paramString1) {}
          paramString2 = paramString2;
          bool2 = false;
        }
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          bool2 = false;
          paramString1 = null;
        }
      }
    }
  }
  
  /* Error */
  public static boolean a(String paramString, StringBuffer paramStringBuffer, InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 73	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_1
    //   10: ifnonnull +9 -> 19
    //   13: iconst_0
    //   14: istore 6
    //   16: iload 6
    //   18: ireturn
    //   19: aload_1
    //   20: invokevirtual 700	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   23: ldc_w 696
    //   26: ldc_w 315
    //   29: invokevirtual 699	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_1
    //   33: new 73	java/io/File
    //   36: dup
    //   37: new 108	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   44: aload_0
    //   45: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_1
    //   49: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_0
    //   59: iconst_1
    //   60: istore 5
    //   62: aload_3
    //   63: invokevirtual 99	java/io/File:exists	()Z
    //   66: ifne +20 -> 86
    //   69: aload_3
    //   70: invokevirtual 102	java/io/File:mkdirs	()Z
    //   73: istore 6
    //   75: iload 6
    //   77: istore 5
    //   79: iload 6
    //   81: ifne +5 -> 86
    //   84: iconst_0
    //   85: ireturn
    //   86: iload 5
    //   88: istore 6
    //   90: aload_3
    //   91: invokevirtual 99	java/io/File:exists	()Z
    //   94: ifeq -78 -> 16
    //   97: aload_0
    //   98: invokevirtual 99	java/io/File:exists	()Z
    //   101: ifne +8 -> 109
    //   104: aload_0
    //   105: invokevirtual 137	java/io/File:createNewFile	()Z
    //   108: pop
    //   109: new 154	java/io/FileOutputStream
    //   112: dup
    //   113: aload_0
    //   114: iconst_0
    //   115: invokespecial 679	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   118: astore_0
    //   119: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   122: sipush 4096
    //   125: invokevirtual 286	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   128: astore_1
    //   129: aload_2
    //   130: aload_1
    //   131: invokevirtual 703	java/io/InputStream:read	([B)I
    //   134: istore 4
    //   136: iload 4
    //   138: iconst_m1
    //   139: if_icmpeq +14 -> 153
    //   142: aload_0
    //   143: aload_1
    //   144: iconst_0
    //   145: iload 4
    //   147: invokevirtual 437	java/io/FileOutputStream:write	([BII)V
    //   150: goto -21 -> 129
    //   153: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   156: aload_1
    //   157: invokevirtual 298	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   160: iload 5
    //   162: istore 7
    //   164: aload_0
    //   165: ifnull +11 -> 176
    //   168: aload_0
    //   169: invokevirtual 440	java/io/FileOutputStream:flush	()V
    //   172: iload 5
    //   174: istore 7
    //   176: iload 7
    //   178: istore 6
    //   180: aload_0
    //   181: ifnull -165 -> 16
    //   184: aload_0
    //   185: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   188: iload 7
    //   190: ireturn
    //   191: astore_0
    //   192: iconst_0
    //   193: ireturn
    //   194: astore_1
    //   195: iconst_0
    //   196: istore 7
    //   198: goto -22 -> 176
    //   201: astore_0
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_0
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_0
    //   208: iconst_0
    //   209: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramString	String
    //   0	210	1	paramStringBuffer	StringBuffer
    //   0	210	2	paramInputStream	InputStream
    //   8	83	3	localFile	File
    //   134	12	4	j	int
    //   60	113	5	bool1	boolean
    //   14	165	6	bool2	boolean
    //   162	35	7	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   184	188	191	java/io/IOException
    //   168	172	194	java/io/IOException
    //   119	129	201	java/io/IOException
    //   129	136	201	java/io/IOException
    //   142	150	201	java/io/IOException
    //   153	160	201	java/io/IOException
    //   104	109	204	java/io/IOException
    //   109	119	207	java/io/FileNotFoundException
  }
  
  public static boolean a(String paramString1, StringBuffer paramStringBuffer, String paramString2)
  {
    File localFile2 = new File(paramString1);
    File localFile1 = new File(paramString1 + paramStringBuffer.toString());
    boolean bool = true;
    if (!localFile2.exists()) {
      bool = localFile2.mkdirs();
    }
    if ((localFile2.exists()) && (localFile1.exists()))
    {
      paramStringBuffer.insert(paramStringBuffer.indexOf(paramString2), "(0)");
      for (paramString2 = localFile1; paramString2.exists(); paramString2 = new File(paramString1 + paramStringBuffer))
      {
        int j = paramStringBuffer.lastIndexOf("(") + 1;
        int k = paramStringBuffer.lastIndexOf(")");
        paramStringBuffer.replace(j, k, String.valueOf(Integer.parseInt(paramStringBuffer.substring(j, k)) + 1));
      }
    }
    return bool;
  }
  
  /* Error */
  public static boolean a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iload 9
    //   5: istore 8
    //   7: aload_0
    //   8: ifnull +31 -> 39
    //   11: iload 9
    //   13: istore 8
    //   15: aload_0
    //   16: invokevirtual 445	java/lang/String:length	()I
    //   19: ifeq +20 -> 39
    //   22: iload 9
    //   24: istore 8
    //   26: aload_1
    //   27: ifnull +12 -> 39
    //   30: aload_1
    //   31: arraylength
    //   32: ifne +10 -> 42
    //   35: iload 9
    //   37: istore 8
    //   39: iload 8
    //   41: ireturn
    //   42: aload_0
    //   43: astore_3
    //   44: iload_2
    //   45: ifeq +55 -> 100
    //   48: new 729	java/text/SimpleDateFormat
    //   51: dup
    //   52: ldc_w 731
    //   55: getstatic 737	java/util/Locale:CHINA	Ljava/util/Locale;
    //   58: invokespecial 740	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   61: new 742	java/util/Date
    //   64: dup
    //   65: invokestatic 747	java/lang/System:currentTimeMillis	()J
    //   68: invokespecial 749	java/util/Date:<init>	(J)V
    //   71: invokevirtual 752	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   74: astore_3
    //   75: new 108	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   82: aload_0
    //   83: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc_w 535
    //   89: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_3
    //   93: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore_3
    //   100: new 73	java/io/File
    //   103: dup
    //   104: aload_3
    //   105: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore 6
    //   110: aconst_null
    //   111: astore 5
    //   113: aconst_null
    //   114: astore_3
    //   115: aconst_null
    //   116: astore 4
    //   118: aload_3
    //   119: astore_0
    //   120: aload 6
    //   122: invokevirtual 177	java/io/File:getParentFile	()Ljava/io/File;
    //   125: astore 7
    //   127: aload_3
    //   128: astore_0
    //   129: aload 7
    //   131: invokevirtual 99	java/io/File:exists	()Z
    //   134: ifne +11 -> 145
    //   137: aload_3
    //   138: astore_0
    //   139: aload 7
    //   141: invokevirtual 102	java/io/File:mkdirs	()Z
    //   144: pop
    //   145: aload_3
    //   146: astore_0
    //   147: aload 6
    //   149: invokevirtual 99	java/io/File:exists	()Z
    //   152: ifeq +11 -> 163
    //   155: aload_3
    //   156: astore_0
    //   157: aload 6
    //   159: invokevirtual 140	java/io/File:delete	()Z
    //   162: pop
    //   163: aload_3
    //   164: astore_0
    //   165: new 154	java/io/FileOutputStream
    //   168: dup
    //   169: aload 6
    //   171: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   174: astore_3
    //   175: aload_3
    //   176: aload_1
    //   177: invokevirtual 686	java/io/FileOutputStream:write	([B)V
    //   180: aload_3
    //   181: invokevirtual 440	java/io/FileOutputStream:flush	()V
    //   184: iconst_1
    //   185: istore 8
    //   187: aload_3
    //   188: ifnull -149 -> 39
    //   191: aload_3
    //   192: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   195: iconst_1
    //   196: ireturn
    //   197: astore_0
    //   198: aload_0
    //   199: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   202: iconst_1
    //   203: ireturn
    //   204: astore_3
    //   205: aload 4
    //   207: astore_1
    //   208: aload_1
    //   209: astore_0
    //   210: aload_3
    //   211: invokevirtual 318	java/io/FileNotFoundException:printStackTrace	()V
    //   214: iload 9
    //   216: istore 8
    //   218: aload_1
    //   219: ifnull -180 -> 39
    //   222: aload_1
    //   223: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   226: iconst_0
    //   227: ireturn
    //   228: astore_0
    //   229: aload_0
    //   230: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   233: iconst_0
    //   234: ireturn
    //   235: astore_3
    //   236: aload 5
    //   238: astore_1
    //   239: aload_1
    //   240: astore_0
    //   241: aload_3
    //   242: invokevirtual 319	java/io/IOException:printStackTrace	()V
    //   245: iload 9
    //   247: istore 8
    //   249: aload_1
    //   250: ifnull -211 -> 39
    //   253: aload_1
    //   254: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   257: iconst_0
    //   258: ireturn
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   264: iconst_0
    //   265: ireturn
    //   266: astore_3
    //   267: aload_0
    //   268: astore_1
    //   269: aload_3
    //   270: astore_0
    //   271: aload_1
    //   272: ifnull +7 -> 279
    //   275: aload_1
    //   276: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   279: aload_0
    //   280: athrow
    //   281: astore_1
    //   282: aload_1
    //   283: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   286: goto -7 -> 279
    //   289: astore_0
    //   290: aload_3
    //   291: astore_1
    //   292: goto -21 -> 271
    //   295: astore_0
    //   296: aload_3
    //   297: astore_1
    //   298: aload_0
    //   299: astore_3
    //   300: goto -61 -> 239
    //   303: astore_0
    //   304: aload_3
    //   305: astore_1
    //   306: aload_0
    //   307: astore_3
    //   308: goto -100 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramString	String
    //   0	311	1	paramArrayOfByte	byte[]
    //   0	311	2	paramBoolean	boolean
    //   43	149	3	localObject1	Object
    //   204	7	3	localFileNotFoundException	FileNotFoundException
    //   235	7	3	localIOException	IOException
    //   266	31	3	localObject2	Object
    //   299	9	3	str	String
    //   116	90	4	localObject3	Object
    //   111	126	5	localObject4	Object
    //   108	62	6	localFile1	File
    //   125	15	7	localFile2	File
    //   5	243	8	bool1	boolean
    //   1	245	9	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   191	195	197	java/lang/Exception
    //   120	127	204	java/io/FileNotFoundException
    //   129	137	204	java/io/FileNotFoundException
    //   139	145	204	java/io/FileNotFoundException
    //   147	155	204	java/io/FileNotFoundException
    //   157	163	204	java/io/FileNotFoundException
    //   165	175	204	java/io/FileNotFoundException
    //   222	226	228	java/lang/Exception
    //   120	127	235	java/io/IOException
    //   129	137	235	java/io/IOException
    //   139	145	235	java/io/IOException
    //   147	155	235	java/io/IOException
    //   157	163	235	java/io/IOException
    //   165	175	235	java/io/IOException
    //   253	257	259	java/lang/Exception
    //   120	127	266	finally
    //   129	137	266	finally
    //   139	145	266	finally
    //   147	155	266	finally
    //   157	163	266	finally
    //   165	175	266	finally
    //   210	214	266	finally
    //   241	245	266	finally
    //   275	279	281	java/lang/Exception
    //   175	184	289	finally
    //   175	184	295	java/io/IOException
    //   175	184	303	java/io/FileNotFoundException
  }
  
  /* Error */
  public static boolean a(byte[] paramArrayOfByte, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 73	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 99	java/io/File:exists	()Z
    //   17: ifne +26 -> 43
    //   20: aload_1
    //   21: invokevirtual 177	java/io/File:getParentFile	()Ljava/io/File;
    //   24: invokevirtual 99	java/io/File:exists	()Z
    //   27: ifne +11 -> 38
    //   30: aload_1
    //   31: invokevirtual 177	java/io/File:getParentFile	()Ljava/io/File;
    //   34: invokevirtual 102	java/io/File:mkdirs	()Z
    //   37: pop
    //   38: aload_1
    //   39: invokevirtual 137	java/io/File:createNewFile	()Z
    //   42: pop
    //   43: new 154	java/io/FileOutputStream
    //   46: dup
    //   47: aload_1
    //   48: iconst_0
    //   49: invokespecial 679	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   52: astore_1
    //   53: aload_1
    //   54: aload_0
    //   55: invokevirtual 686	java/io/FileOutputStream:write	([B)V
    //   58: aload_1
    //   59: invokevirtual 440	java/io/FileOutputStream:flush	()V
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   70: iconst_1
    //   71: istore_3
    //   72: iload_3
    //   73: ireturn
    //   74: astore_0
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: ifnull -6 -> 72
    //   81: aload_0
    //   82: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   85: iconst_0
    //   86: ireturn
    //   87: astore_0
    //   88: iconst_0
    //   89: ireturn
    //   90: astore_0
    //   91: aload_2
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   101: aload_0
    //   102: athrow
    //   103: astore_0
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_1
    //   107: goto -6 -> 101
    //   110: astore_0
    //   111: goto -18 -> 93
    //   114: astore_0
    //   115: aload_1
    //   116: astore_0
    //   117: goto -40 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramArrayOfByte	byte[]
    //   0	120	1	paramString	String
    //   3	89	2	localObject	Object
    //   1	72	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   13	38	74	java/io/IOException
    //   38	43	74	java/io/IOException
    //   43	53	74	java/io/IOException
    //   81	85	87	java/io/IOException
    //   13	38	90	finally
    //   38	43	90	finally
    //   43	53	90	finally
    //   66	70	103	java/io/IOException
    //   97	101	106	java/io/IOException
    //   53	62	110	finally
    //   53	62	114	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 99	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 188	java/io/BufferedInputStream
    //   12: dup
    //   13: new 145	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 203	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore_1
    //   25: aload_0
    //   26: invokevirtual 271	java/io/File:length	()J
    //   29: lstore 5
    //   31: lload 5
    //   33: ldc2_w 755
    //   36: lcmp
    //   37: ifgt +10 -> 47
    //   40: lload 5
    //   42: lconst_0
    //   43: lcmp
    //   44: ifgt +53 -> 97
    //   47: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   50: ifeq +30 -> 80
    //   53: ldc 12
    //   55: iconst_2
    //   56: new 108	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 758
    //   66: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: lload 5
    //   71: invokevirtual 761	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   74: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload_1
    //   81: ifnull -74 -> 7
    //   84: aload_1
    //   85: invokevirtual 762	java/io/InputStream:close	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   95: aconst_null
    //   96: areturn
    //   97: lload 5
    //   99: l2i
    //   100: istore_3
    //   101: iload_3
    //   102: newarray <illegal type>
    //   104: astore_2
    //   105: iconst_0
    //   106: istore_3
    //   107: iload_3
    //   108: aload_2
    //   109: arraylength
    //   110: if_icmpge +28 -> 138
    //   113: aload_1
    //   114: aload_2
    //   115: iload_3
    //   116: aload_2
    //   117: arraylength
    //   118: iload_3
    //   119: isub
    //   120: invokevirtual 763	java/io/InputStream:read	([BII)I
    //   123: istore 4
    //   125: iload 4
    //   127: iflt +11 -> 138
    //   130: iload_3
    //   131: iload 4
    //   133: iadd
    //   134: istore_3
    //   135: goto -28 -> 107
    //   138: iload_3
    //   139: aload_2
    //   140: arraylength
    //   141: if_icmpge +35 -> 176
    //   144: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +29 -> 176
    //   150: ldc 12
    //   152: iconst_2
    //   153: new 108	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 765
    //   163: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_0
    //   167: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 762	java/io/InputStream:close	()V
    //   184: aload_2
    //   185: areturn
    //   186: astore_0
    //   187: aload_0
    //   188: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   191: goto -7 -> 184
    //   194: astore_1
    //   195: aconst_null
    //   196: astore_1
    //   197: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +29 -> 229
    //   203: ldc 12
    //   205: iconst_2
    //   206: new 108	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 767
    //   216: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_1
    //   230: ifnull -223 -> 7
    //   233: aload_1
    //   234: invokevirtual 762	java/io/InputStream:close	()V
    //   237: aconst_null
    //   238: areturn
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   244: aconst_null
    //   245: areturn
    //   246: astore_0
    //   247: aconst_null
    //   248: astore_1
    //   249: aload_1
    //   250: ifnull +7 -> 257
    //   253: aload_1
    //   254: invokevirtual 762	java/io/InputStream:close	()V
    //   257: aload_0
    //   258: athrow
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 404	java/lang/Exception:printStackTrace	()V
    //   264: goto -7 -> 257
    //   267: astore_0
    //   268: goto -19 -> 249
    //   271: astore_0
    //   272: goto -23 -> 249
    //   275: astore_2
    //   276: goto -79 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	paramFile	File
    //   24	157	1	localBufferedInputStream	java.io.BufferedInputStream
    //   194	1	1	localIOException1	IOException
    //   196	58	1	localObject	Object
    //   259	2	1	localException	Exception
    //   104	81	2	arrayOfByte	byte[]
    //   275	1	2	localIOException2	IOException
    //   100	42	3	j	int
    //   123	11	4	k	int
    //   29	69	5	l	long
    // Exception table:
    //   from	to	target	type
    //   84	88	90	java/lang/Exception
    //   180	184	186	java/lang/Exception
    //   9	25	194	java/io/IOException
    //   233	237	239	java/lang/Exception
    //   9	25	246	finally
    //   253	257	259	java/lang/Exception
    //   25	31	267	finally
    //   47	80	267	finally
    //   101	105	267	finally
    //   107	125	267	finally
    //   138	176	267	finally
    //   197	229	271	finally
    //   25	31	275	java/io/IOException
    //   47	80	275	java/io/IOException
    //   101	105	275	java/io/IOException
    //   107	125	275	java/io/IOException
    //   138	176	275	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: invokestatic 184	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 73	java/io/File
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 99	java/io/File:exists	()Z
    //   25: ifeq -15 -> 10
    //   28: aload_1
    //   29: invokevirtual 271	java/io/File:length	()J
    //   32: l2i
    //   33: istore 7
    //   35: new 273	java/io/ByteArrayOutputStream
    //   38: dup
    //   39: iload 7
    //   41: invokespecial 276	java/io/ByteArrayOutputStream:<init>	(I)V
    //   44: astore_0
    //   45: new 145	java/io/FileInputStream
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: astore 5
    //   55: iload 7
    //   57: sipush 4096
    //   60: if_icmpge +61 -> 121
    //   63: aload_0
    //   64: astore_2
    //   65: aload 5
    //   67: astore_1
    //   68: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   71: sipush 4096
    //   74: invokevirtual 286	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   77: astore_3
    //   78: iload 6
    //   80: iload 7
    //   82: if_icmpge +76 -> 158
    //   85: aload_0
    //   86: astore_2
    //   87: aload 5
    //   89: astore_1
    //   90: aload 5
    //   92: aload_3
    //   93: invokevirtual 290	java/io/FileInputStream:read	([B)I
    //   96: istore 8
    //   98: aload_0
    //   99: astore_2
    //   100: aload 5
    //   102: astore_1
    //   103: aload_0
    //   104: aload_3
    //   105: iconst_0
    //   106: iload 8
    //   108: invokevirtual 294	java/io/ByteArrayOutputStream:write	([BII)V
    //   111: iload 6
    //   113: iload 8
    //   115: iadd
    //   116: istore 6
    //   118: goto -40 -> 78
    //   121: aload_0
    //   122: astore_2
    //   123: aload 5
    //   125: astore_1
    //   126: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   129: sipush 12288
    //   132: invokevirtual 286	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   135: astore_3
    //   136: goto -58 -> 78
    //   139: astore_1
    //   140: aload_0
    //   141: astore_2
    //   142: aload 5
    //   144: astore_1
    //   145: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   148: sipush 4096
    //   151: invokevirtual 286	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   154: astore_3
    //   155: goto -77 -> 78
    //   158: aload_0
    //   159: astore_2
    //   160: aload 5
    //   162: astore_1
    //   163: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   166: aload_3
    //   167: invokevirtual 298	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   170: aload_0
    //   171: astore_2
    //   172: aload 5
    //   174: astore_1
    //   175: aload_0
    //   176: invokevirtual 771	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   179: astore_3
    //   180: aload_3
    //   181: astore_1
    //   182: aload_0
    //   183: ifnull +7 -> 190
    //   186: aload_0
    //   187: invokevirtual 304	java/io/ByteArrayOutputStream:close	()V
    //   190: aload_1
    //   191: astore_0
    //   192: aload 5
    //   194: ifnull +10 -> 204
    //   197: aload 5
    //   199: invokevirtual 170	java/io/FileInputStream:close	()V
    //   202: aload_1
    //   203: astore_0
    //   204: aload_0
    //   205: areturn
    //   206: astore_2
    //   207: aload_1
    //   208: astore_0
    //   209: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq -8 -> 204
    //   215: ldc 12
    //   217: iconst_2
    //   218: ldc_w 306
    //   221: aload_2
    //   222: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload_1
    //   226: astore_0
    //   227: goto -23 -> 204
    //   230: astore_3
    //   231: aconst_null
    //   232: astore 4
    //   234: aconst_null
    //   235: astore_0
    //   236: aload 4
    //   238: astore_2
    //   239: aload_0
    //   240: astore_1
    //   241: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +18 -> 262
    //   247: aload 4
    //   249: astore_2
    //   250: aload_0
    //   251: astore_1
    //   252: ldc 12
    //   254: iconst_2
    //   255: ldc_w 306
    //   258: aload_3
    //   259: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   262: aload 4
    //   264: ifnull +8 -> 272
    //   267: aload 4
    //   269: invokevirtual 304	java/io/ByteArrayOutputStream:close	()V
    //   272: aload_0
    //   273: ifnull +7 -> 280
    //   276: aload_0
    //   277: invokevirtual 170	java/io/FileInputStream:close	()V
    //   280: aconst_null
    //   281: astore_0
    //   282: goto -78 -> 204
    //   285: astore_0
    //   286: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq +13 -> 302
    //   292: ldc 12
    //   294: iconst_2
    //   295: ldc_w 306
    //   298: aload_0
    //   299: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   302: aconst_null
    //   303: astore_0
    //   304: goto -100 -> 204
    //   307: astore_3
    //   308: aconst_null
    //   309: astore_0
    //   310: aconst_null
    //   311: astore_1
    //   312: aload_0
    //   313: ifnull +7 -> 320
    //   316: aload_0
    //   317: invokevirtual 304	java/io/ByteArrayOutputStream:close	()V
    //   320: aload_1
    //   321: ifnull +7 -> 328
    //   324: aload_1
    //   325: invokevirtual 170	java/io/FileInputStream:close	()V
    //   328: aload_3
    //   329: athrow
    //   330: astore_0
    //   331: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq -6 -> 328
    //   337: ldc 12
    //   339: iconst_2
    //   340: ldc_w 306
    //   343: aload_0
    //   344: invokestatic 309	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   347: goto -19 -> 328
    //   350: astore_3
    //   351: aconst_null
    //   352: astore_1
    //   353: goto -41 -> 312
    //   356: astore_3
    //   357: aload_2
    //   358: astore_0
    //   359: goto -47 -> 312
    //   362: astore_3
    //   363: aconst_null
    //   364: astore_1
    //   365: aload_0
    //   366: astore 4
    //   368: aload_1
    //   369: astore_0
    //   370: goto -134 -> 236
    //   373: astore_3
    //   374: aload_0
    //   375: astore 4
    //   377: aload 5
    //   379: astore_0
    //   380: goto -144 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramString	String
    //   20	106	1	localObject1	Object
    //   139	1	1	localOutOfMemoryError	OutOfMemoryError
    //   144	225	1	localObject2	Object
    //   64	108	2	str1	String
    //   206	16	2	localIOException	IOException
    //   238	120	2	localObject3	Object
    //   77	104	3	arrayOfByte	byte[]
    //   230	29	3	localException1	Exception
    //   307	22	3	localObject4	Object
    //   350	1	3	localObject5	Object
    //   356	1	3	localObject6	Object
    //   362	1	3	localException2	Exception
    //   373	1	3	localException3	Exception
    //   232	144	4	str2	String
    //   53	325	5	localFileInputStream	FileInputStream
    //   1	116	6	j	int
    //   33	50	7	k	int
    //   96	20	8	m	int
    // Exception table:
    //   from	to	target	type
    //   68	78	139	java/lang/OutOfMemoryError
    //   126	136	139	java/lang/OutOfMemoryError
    //   186	190	206	java/io/IOException
    //   197	202	206	java/io/IOException
    //   28	45	230	java/lang/Exception
    //   267	272	285	java/io/IOException
    //   276	280	285	java/io/IOException
    //   28	45	307	finally
    //   316	320	330	java/io/IOException
    //   324	328	330	java/io/IOException
    //   45	55	350	finally
    //   68	78	356	finally
    //   90	98	356	finally
    //   103	111	356	finally
    //   126	136	356	finally
    //   145	155	356	finally
    //   163	170	356	finally
    //   175	180	356	finally
    //   241	247	356	finally
    //   252	262	356	finally
    //   45	55	362	java/lang/Exception
    //   68	78	373	java/lang/Exception
    //   90	98	373	java/lang/Exception
    //   103	111	373	java/lang/Exception
    //   126	136	373	java/lang/Exception
    //   145	155	373	java/lang/Exception
    //   163	170	373	java/lang/Exception
    //   175	180	373	java/lang/Exception
  }
  
  /* Error */
  public static Object[] a(String paramString, Class[] paramArrayOfClass)
  {
    // Byte code:
    //   0: new 186	java/io/ObjectInputStream
    //   3: dup
    //   4: new 188	java/io/BufferedInputStream
    //   7: dup
    //   8: invokestatic 194	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: aload_0
    //   12: invokevirtual 200	com/tencent/qphone/base/util/BaseApplication:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   15: invokespecial 203	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: invokespecial 204	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_3
    //   22: aload_3
    //   23: astore_2
    //   24: aload_1
    //   25: arraylength
    //   26: anewarray 4	java/lang/Object
    //   29: astore 4
    //   31: iconst_0
    //   32: istore 5
    //   34: aload_3
    //   35: astore_2
    //   36: iload 5
    //   38: aload_1
    //   39: arraylength
    //   40: if_icmpge +204 -> 244
    //   43: aload_1
    //   44: iload 5
    //   46: aaload
    //   47: astore_2
    //   48: aload_2
    //   49: ldc_w 579
    //   52: if_acmpne +20 -> 72
    //   55: aload_3
    //   56: astore_2
    //   57: aload 4
    //   59: iload 5
    //   61: aload_3
    //   62: invokevirtual 775	java/io/ObjectInputStream:readByte	()B
    //   65: invokestatic 778	java/lang/Byte:valueOf	(B)Ljava/lang/Byte;
    //   68: aastore
    //   69: goto +229 -> 298
    //   72: aload_2
    //   73: ldc_w 570
    //   76: if_acmpne +95 -> 171
    //   79: aload_3
    //   80: astore_2
    //   81: aload 4
    //   83: iload 5
    //   85: aload_3
    //   86: invokevirtual 781	java/io/ObjectInputStream:readBoolean	()Z
    //   89: invokestatic 784	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   92: aastore
    //   93: goto +205 -> 298
    //   96: astore_2
    //   97: aload_3
    //   98: astore_1
    //   99: aload_2
    //   100: astore_3
    //   101: aload_1
    //   102: astore_2
    //   103: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +45 -> 151
    //   109: aload_1
    //   110: astore_2
    //   111: ldc_w 588
    //   114: iconst_2
    //   115: new 108	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 786
    //   125: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_0
    //   129: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc_w 592
    //   135: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_3
    //   139: invokevirtual 595	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 478	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   151: aload_1
    //   152: ifnull +7 -> 159
    //   155: aload_1
    //   156: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   159: aconst_null
    //   160: astore_0
    //   161: iconst_0
    //   162: istore 5
    //   164: iload 5
    //   166: ifeq +114 -> 280
    //   169: aload_0
    //   170: areturn
    //   171: aload_2
    //   172: ldc_w 371
    //   175: if_acmpne +31 -> 206
    //   178: aload_3
    //   179: astore_2
    //   180: aload 4
    //   182: iload 5
    //   184: aload_3
    //   185: invokevirtual 789	java/io/ObjectInputStream:readInt	()I
    //   188: invokestatic 792	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   191: aastore
    //   192: goto +106 -> 298
    //   195: astore_0
    //   196: aload_2
    //   197: ifnull +7 -> 204
    //   200: aload_2
    //   201: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: aload_2
    //   207: ldc_w 603
    //   210: if_acmpne +20 -> 230
    //   213: aload_3
    //   214: astore_2
    //   215: aload 4
    //   217: iload 5
    //   219: aload_3
    //   220: invokevirtual 795	java/io/ObjectInputStream:readLong	()J
    //   223: invokestatic 798	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   226: aastore
    //   227: goto +71 -> 298
    //   230: aload_3
    //   231: astore_2
    //   232: aload 4
    //   234: iload 5
    //   236: aload_3
    //   237: invokevirtual 208	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   240: aastore
    //   241: goto +57 -> 298
    //   244: aload_3
    //   245: ifnull +7 -> 252
    //   248: aload_3
    //   249: invokevirtual 209	java/io/ObjectInputStream:close	()V
    //   252: iconst_1
    //   253: istore 5
    //   255: aload 4
    //   257: astore_0
    //   258: goto -94 -> 164
    //   261: astore_0
    //   262: iconst_1
    //   263: istore 5
    //   265: aload 4
    //   267: astore_0
    //   268: goto -104 -> 164
    //   271: astore_0
    //   272: aconst_null
    //   273: astore_0
    //   274: iconst_0
    //   275: istore 5
    //   277: goto -113 -> 164
    //   280: aconst_null
    //   281: areturn
    //   282: astore_1
    //   283: goto -79 -> 204
    //   286: astore_0
    //   287: aconst_null
    //   288: astore_2
    //   289: goto -93 -> 196
    //   292: astore_3
    //   293: aconst_null
    //   294: astore_1
    //   295: goto -194 -> 101
    //   298: iload 5
    //   300: iconst_1
    //   301: iadd
    //   302: istore 5
    //   304: goto -270 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramString	String
    //   0	307	1	paramArrayOfClass	Class[]
    //   23	58	2	localObject1	Object
    //   96	4	2	localException1	Exception
    //   102	187	2	localObject2	Object
    //   21	228	3	localObject3	Object
    //   292	1	3	localException2	Exception
    //   29	237	4	arrayOfObject	Object[]
    //   32	271	5	j	int
    // Exception table:
    //   from	to	target	type
    //   24	31	96	java/lang/Exception
    //   36	43	96	java/lang/Exception
    //   57	69	96	java/lang/Exception
    //   81	93	96	java/lang/Exception
    //   180	192	96	java/lang/Exception
    //   215	227	96	java/lang/Exception
    //   232	241	96	java/lang/Exception
    //   24	31	195	finally
    //   36	43	195	finally
    //   57	69	195	finally
    //   81	93	195	finally
    //   103	109	195	finally
    //   111	151	195	finally
    //   180	192	195	finally
    //   215	227	195	finally
    //   232	241	195	finally
    //   248	252	261	java/io/IOException
    //   155	159	271	java/io/IOException
    //   200	204	282	java/io/IOException
    //   0	22	286	finally
    //   0	22	292	java/lang/Exception
  }
  
  /* Error */
  public static String b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aload_3
    //   7: astore_2
    //   8: aload_2
    //   9: areturn
    //   10: aload_0
    //   11: invokevirtual 99	java/io/File:exists	()Z
    //   14: ifeq +85 -> 99
    //   17: aload_0
    //   18: invokevirtual 96	java/io/File:isDirectory	()Z
    //   21: ifeq +37 -> 58
    //   24: new 132	java/io/IOException
    //   27: dup
    //   28: new 108	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 800
    //   38: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   45: ldc_w 802
    //   48: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 553	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   57: athrow
    //   58: aload_0
    //   59: invokevirtual 805	java/io/File:canRead	()Z
    //   62: ifne +71 -> 133
    //   65: new 132	java/io/IOException
    //   68: dup
    //   69: new 108	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 800
    //   79: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   86: ldc_w 807
    //   89: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokespecial 553	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   98: athrow
    //   99: new 143	java/io/FileNotFoundException
    //   102: dup
    //   103: new 108	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 800
    //   113: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   120: ldc_w 809
    //   123: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokespecial 810	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   132: athrow
    //   133: new 145	java/io/FileInputStream
    //   136: dup
    //   137: aload_0
    //   138: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   141: astore_2
    //   142: new 812	java/io/InputStreamReader
    //   145: dup
    //   146: aload_2
    //   147: ldc_w 814
    //   150: invokespecial 817	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   153: astore_1
    //   154: aload_0
    //   155: invokevirtual 271	java/io/File:length	()J
    //   158: l2i
    //   159: istore 5
    //   161: iload 5
    //   163: sipush 12288
    //   166: if_icmple +102 -> 268
    //   169: sipush 4096
    //   172: newarray <illegal type>
    //   174: astore_0
    //   175: new 108	java/lang/StringBuilder
    //   178: dup
    //   179: sipush 12288
    //   182: invokespecial 818	java/lang/StringBuilder:<init>	(I)V
    //   185: astore 4
    //   187: aload_1
    //   188: aload_0
    //   189: invokevirtual 821	java/io/InputStreamReader:read	([C)I
    //   192: istore 5
    //   194: iconst_m1
    //   195: iload 5
    //   197: if_icmpeq +42 -> 239
    //   200: aload 4
    //   202: aload_0
    //   203: iconst_0
    //   204: iload 5
    //   206: invokevirtual 824	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: goto -23 -> 187
    //   213: astore_0
    //   214: aload_1
    //   215: astore_0
    //   216: aload_2
    //   217: ifnull +7 -> 224
    //   220: aload_2
    //   221: invokevirtual 762	java/io/InputStream:close	()V
    //   224: aload_3
    //   225: astore_2
    //   226: aload_0
    //   227: ifnull -219 -> 8
    //   230: aload_0
    //   231: invokevirtual 825	java/io/InputStreamReader:close	()V
    //   234: aconst_null
    //   235: areturn
    //   236: astore_0
    //   237: aconst_null
    //   238: areturn
    //   239: aload 4
    //   241: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: astore_0
    //   245: aload_2
    //   246: ifnull +7 -> 253
    //   249: aload_2
    //   250: invokevirtual 762	java/io/InputStream:close	()V
    //   253: aload_0
    //   254: astore_2
    //   255: aload_1
    //   256: ifnull -248 -> 8
    //   259: aload_1
    //   260: invokevirtual 825	java/io/InputStreamReader:close	()V
    //   263: aload_0
    //   264: areturn
    //   265: astore_1
    //   266: aload_0
    //   267: areturn
    //   268: iload 5
    //   270: newarray <illegal type>
    //   272: astore_0
    //   273: new 241	java/lang/String
    //   276: dup
    //   277: aload_0
    //   278: iconst_0
    //   279: aload_1
    //   280: aload_0
    //   281: invokevirtual 821	java/io/InputStreamReader:read	([C)I
    //   284: invokespecial 828	java/lang/String:<init>	([CII)V
    //   287: astore_0
    //   288: goto -43 -> 245
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_2
    //   294: aconst_null
    //   295: astore_1
    //   296: aload_2
    //   297: ifnull +7 -> 304
    //   300: aload_2
    //   301: invokevirtual 762	java/io/InputStream:close	()V
    //   304: aload_1
    //   305: ifnull +7 -> 312
    //   308: aload_1
    //   309: invokevirtual 825	java/io/InputStreamReader:close	()V
    //   312: aload_0
    //   313: athrow
    //   314: astore_2
    //   315: goto -62 -> 253
    //   318: astore_1
    //   319: goto -95 -> 224
    //   322: astore_2
    //   323: goto -19 -> 304
    //   326: astore_1
    //   327: goto -15 -> 312
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_1
    //   333: goto -37 -> 296
    //   336: astore_0
    //   337: goto -41 -> 296
    //   340: astore_0
    //   341: aconst_null
    //   342: astore_0
    //   343: aconst_null
    //   344: astore_2
    //   345: goto -129 -> 216
    //   348: astore_0
    //   349: aconst_null
    //   350: astore_0
    //   351: goto -135 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramFile	File
    //   153	107	1	localInputStreamReader	java.io.InputStreamReader
    //   265	15	1	localException1	Exception
    //   295	14	1	localObject1	Object
    //   318	1	1	localException2	Exception
    //   326	1	1	localException3	Exception
    //   332	1	1	localObject2	Object
    //   7	294	2	localObject3	Object
    //   314	1	2	localException4	Exception
    //   322	1	2	localException5	Exception
    //   344	1	2	localObject4	Object
    //   1	224	3	localObject5	Object
    //   185	55	4	localStringBuilder	StringBuilder
    //   159	110	5	j	int
    // Exception table:
    //   from	to	target	type
    //   154	161	213	java/lang/Exception
    //   169	187	213	java/lang/Exception
    //   187	194	213	java/lang/Exception
    //   200	210	213	java/lang/Exception
    //   239	245	213	java/lang/Exception
    //   268	288	213	java/lang/Exception
    //   230	234	236	java/lang/Exception
    //   259	263	265	java/lang/Exception
    //   133	142	291	finally
    //   249	253	314	java/lang/Exception
    //   220	224	318	java/lang/Exception
    //   300	304	322	java/lang/Exception
    //   308	312	326	java/lang/Exception
    //   142	154	330	finally
    //   154	161	336	finally
    //   169	187	336	finally
    //   187	194	336	finally
    //   200	210	336	finally
    //   239	245	336	finally
    //   268	288	336	finally
    //   133	142	340	java/lang/Exception
    //   142	154	348	java/lang/Exception
  }
  
  public static String b(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {}
    long l;
    do
    {
      return null;
      l = localFile.length();
    } while (l == 0L);
    return a(paramString, l);
  }
  
  public static void b(String paramString)
  {
    if (!a(paramString)) {}
    try
    {
      a(paramString);
      return;
    }
    catch (IOException paramString) {}
  }
  
  public static boolean b()
  {
    return a(AppConstants.bh + "/Tencent/");
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      a(paramString1, a(paramString2));
      paramString1.delete();
      bool = true;
      return bool;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static boolean c()
  {
    return a(AppConstants.bj);
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((!paramString.startsWith(AppConstants.bh)) && (!paramString.startsWith("/data/media/")))
      {
        bool1 = bool2;
        if (!new File(paramString).exists()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new File(paramString1);
    } while (!paramString1.exists());
    return paramString1.renameTo(new File(paramString2));
  }
  
  public static boolean d()
  {
    return a(AppConstants.bj + "/" + "diskcache");
  }
  
  public static boolean d(String paramString)
  {
    boolean bool = true;
    paramString = new File(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
  }
  
  public static boolean d(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      a(paramString1, a(paramString2));
      bool = true;
      return bool;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static boolean e(String paramString)
  {
    boolean bool = false;
    paramString = a(paramString);
    if ((paramString.equals("jpg")) || (paramString.equals("gif")) || (paramString.equals("bmp")) || (paramString.equals("png"))) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public static boolean e(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 73	java/io/File
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: astore 4
    //   14: aload 4
    //   16: invokevirtual 177	java/io/File:getParentFile	()Ljava/io/File;
    //   19: invokevirtual 99	java/io/File:exists	()Z
    //   22: ifne +12 -> 34
    //   25: aload 4
    //   27: invokevirtual 177	java/io/File:getParentFile	()Ljava/io/File;
    //   30: invokevirtual 102	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: new 848	java/util/zip/ZipFile
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 849	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   42: astore 6
    //   44: new 73	java/io/File
    //   47: dup
    //   48: new 108	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   55: aload_1
    //   56: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc_w 851
    //   62: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 7
    //   73: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   76: sipush 8192
    //   79: invokevirtual 286	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   82: astore 8
    //   84: new 154	java/io/FileOutputStream
    //   87: dup
    //   88: aload 7
    //   90: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   93: astore_0
    //   94: new 455	java/io/BufferedOutputStream
    //   97: dup
    //   98: aload_0
    //   99: aload 8
    //   101: arraylength
    //   102: invokespecial 547	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   105: astore 4
    //   107: aload 6
    //   109: invokevirtual 855	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   112: astore 9
    //   114: aload_2
    //   115: astore_3
    //   116: aload 9
    //   118: invokeinterface 860 1 0
    //   123: ifeq +121 -> 244
    //   126: aload_2
    //   127: astore_3
    //   128: aload 9
    //   130: invokeinterface 863 1 0
    //   135: checkcast 511	java/util/zip/ZipEntry
    //   138: astore 5
    //   140: aload_2
    //   141: ifnull +9 -> 150
    //   144: aload_2
    //   145: astore_3
    //   146: aload_2
    //   147: invokevirtual 762	java/io/InputStream:close	()V
    //   150: aload_2
    //   151: astore_3
    //   152: aload 6
    //   154: aload 5
    //   156: invokevirtual 867	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   159: astore 5
    //   161: aload 5
    //   163: astore_3
    //   164: aload 5
    //   166: aload 8
    //   168: iconst_0
    //   169: aload 8
    //   171: arraylength
    //   172: invokevirtual 763	java/io/InputStream:read	([BII)I
    //   175: istore 10
    //   177: aload 5
    //   179: astore_2
    //   180: iload 10
    //   182: iconst_m1
    //   183: if_icmpeq -69 -> 114
    //   186: aload 5
    //   188: astore_3
    //   189: aload 4
    //   191: aload 8
    //   193: iconst_0
    //   194: iload 10
    //   196: invokevirtual 563	java/io/BufferedOutputStream:write	([BII)V
    //   199: goto -38 -> 161
    //   202: astore 5
    //   204: aload_3
    //   205: astore_2
    //   206: aload 4
    //   208: astore_3
    //   209: aload_0
    //   210: astore_1
    //   211: aload 5
    //   213: astore_0
    //   214: aload_1
    //   215: ifnull +7 -> 222
    //   218: aload_1
    //   219: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   222: aload_3
    //   223: ifnull +11 -> 234
    //   226: aload_3
    //   227: invokevirtual 564	java/io/BufferedOutputStream:flush	()V
    //   230: aload_3
    //   231: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   234: aload_2
    //   235: ifnull +7 -> 242
    //   238: aload_2
    //   239: invokevirtual 762	java/io/InputStream:close	()V
    //   242: aload_0
    //   243: athrow
    //   244: aload_2
    //   245: astore_3
    //   246: invokestatic 282	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   249: aload 8
    //   251: invokevirtual 298	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   254: aload_2
    //   255: astore_3
    //   256: aload 7
    //   258: new 73	java/io/File
    //   261: dup
    //   262: aload_1
    //   263: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;)V
    //   266: invokevirtual 675	java/io/File:renameTo	(Ljava/io/File;)Z
    //   269: istore 11
    //   271: aload_0
    //   272: ifnull +7 -> 279
    //   275: aload_0
    //   276: invokevirtual 436	java/io/FileOutputStream:close	()V
    //   279: aload 4
    //   281: ifnull +13 -> 294
    //   284: aload 4
    //   286: invokevirtual 564	java/io/BufferedOutputStream:flush	()V
    //   289: aload 4
    //   291: invokevirtual 509	java/io/BufferedOutputStream:close	()V
    //   294: aload_2
    //   295: ifnull +7 -> 302
    //   298: aload_2
    //   299: invokevirtual 762	java/io/InputStream:close	()V
    //   302: iload 11
    //   304: ireturn
    //   305: astore_3
    //   306: goto -156 -> 150
    //   309: astore_0
    //   310: goto -31 -> 279
    //   313: astore_0
    //   314: iload 11
    //   316: ireturn
    //   317: astore_1
    //   318: goto -96 -> 222
    //   321: astore_1
    //   322: goto -80 -> 242
    //   325: astore_1
    //   326: goto -92 -> 234
    //   329: astore_0
    //   330: aconst_null
    //   331: astore_1
    //   332: aconst_null
    //   333: astore_2
    //   334: goto -120 -> 214
    //   337: astore 4
    //   339: aload_0
    //   340: astore_1
    //   341: aconst_null
    //   342: astore_2
    //   343: aload 4
    //   345: astore_0
    //   346: goto -132 -> 214
    //   349: astore 5
    //   351: aload_0
    //   352: astore_1
    //   353: aconst_null
    //   354: astore_2
    //   355: aload 4
    //   357: astore_3
    //   358: aload 5
    //   360: astore_0
    //   361: goto -147 -> 214
    //   364: astore_0
    //   365: goto -71 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	368	0	paramString1	String
    //   0	368	1	paramString2	String
    //   3	352	2	localObject1	Object
    //   1	255	3	localObject2	Object
    //   305	1	3	localIOException	IOException
    //   357	1	3	localObject3	Object
    //   12	278	4	localObject4	Object
    //   337	19	4	localObject5	Object
    //   138	49	5	localObject6	Object
    //   202	10	5	localObject7	Object
    //   349	10	5	localObject8	Object
    //   42	111	6	localZipFile	java.util.zip.ZipFile
    //   71	186	7	localFile	File
    //   82	168	8	arrayOfByte	byte[]
    //   112	17	9	localEnumeration	java.util.Enumeration
    //   175	20	10	j	int
    //   269	46	11	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   116	126	202	finally
    //   128	140	202	finally
    //   146	150	202	finally
    //   152	161	202	finally
    //   164	177	202	finally
    //   189	199	202	finally
    //   246	254	202	finally
    //   256	271	202	finally
    //   146	150	305	java/io/IOException
    //   275	279	309	java/io/IOException
    //   298	302	313	java/io/IOException
    //   218	222	317	java/io/IOException
    //   238	242	321	java/io/IOException
    //   226	234	325	java/io/IOException
    //   4	34	329	finally
    //   34	94	329	finally
    //   94	107	337	finally
    //   107	114	349	finally
    //   284	294	364	java/io/IOException
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.equals("jpg")) && (!paramString.equals("gif")) && (!paramString.equals("bmp")) && (!paramString.equals("png"))) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */