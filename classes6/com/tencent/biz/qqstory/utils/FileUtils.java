package com.tencent.biz.qqstory.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore.Video.Media;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class FileUtils
{
  protected static final long a = 52428800L;
  protected static final String a = "Q.qqstory:Utils";
  public static final long b = 10002432L;
  private static String b;
  
  public FileUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    do
    {
      return 0;
      paramString = paramString.listFiles();
    } while (paramString == null);
    return paramString.length;
  }
  
  public static long a()
  {
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  public static long a(String paramString)
  {
    try
    {
      long l = new File(paramString).length();
      return l;
    }
    catch (Exception paramString)
    {
      SLog.c("Q.qqstory:Utils", paramString, "", new Object[0]);
    }
    return -1L;
  }
  
  public static ContentValues a(Context paramContext, File paramFile)
  {
    paramContext = new ContentValues();
    paramContext.put("title", paramFile.getName());
    paramContext.put("_display_name", paramFile.getName());
    paramContext.put("mime_type", "video/mp4");
    paramContext.put("datetaken", Long.valueOf(paramFile.lastModified()));
    paramContext.put("date_modified", Long.valueOf(paramFile.lastModified()));
    paramContext.put("date_added", Long.valueOf(paramFile.lastModified()));
    paramContext.put("_data", paramFile.getAbsolutePath());
    paramContext.put("_size", Long.valueOf(paramFile.length()));
    return paramContext;
  }
  
  public static String a()
  {
    if (b != null) {
      return b;
    }
    b = Environment.getExternalStorageDirectory().getAbsolutePath();
    return b;
  }
  
  public static String a(String paramString)
  {
    return new File(paramString).getName();
  }
  
  public static URL a(String paramString)
  {
    paramString = new URL(paramString);
    String str1 = paramString.getHost();
    int i = str1.indexOf(':');
    if (i >= 0)
    {
      String str2 = str1.substring(0, i);
      i = Integer.parseInt(str1.substring(i + 1));
      return new URL(paramString.getProtocol(), str2, i, paramString.getFile());
    }
    return paramString;
  }
  
  public static void a(Context paramContext, File paramFile)
  {
    Object localObject = paramContext.getContentResolver();
    ContentValues localContentValues = a(paramContext, paramFile);
    ((ContentResolver)localObject).insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, localContentValues);
    localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    ((Intent)localObject).setData(Uri.fromFile(paramFile));
    paramContext.sendBroadcast((Intent)localObject);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null)) {
      throw new IllegalArgumentException("param should not be null");
    }
    paramString2 = new FileOutputStream(paramString2);
    paramContext = paramContext.getAssets().open(paramString1);
    paramString1 = new byte['Ѐ'];
    for (int i = paramContext.read(paramString1); i > 0; i = paramContext.read(paramString1)) {
      paramString2.write(paramString1, 0, i);
    }
    paramString2.flush();
    paramContext.close();
    paramString2.close();
  }
  
  public static boolean a()
  {
    long l = b();
    SLog.b("Q.qqstory:Utils", "free spac:" + l / 1024L / 1024L + "MB--" + l);
    return l < 52428800L;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return false;
    }
    paramString2 = new File(paramString2);
    a(paramString1, paramString2);
    a(paramContext, paramString2);
    return true;
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 268	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 271	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_0
    //   13: new 273	java/io/BufferedOutputStream
    //   16: dup
    //   17: new 205	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 274	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: invokespecial 277	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_2
    //   29: sipush 4096
    //   32: newarray <illegal type>
    //   34: astore_1
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 278	java/io/FileInputStream:read	([B)I
    //   40: istore 4
    //   42: iconst_m1
    //   43: iload 4
    //   45: if_icmpeq +31 -> 76
    //   48: aload_2
    //   49: aload_1
    //   50: iconst_0
    //   51: iload 4
    //   53: invokevirtual 279	java/io/BufferedOutputStream:write	([BII)V
    //   56: goto -21 -> 35
    //   59: astore_1
    //   60: aload_0
    //   61: astore_1
    //   62: aload_2
    //   63: astore_0
    //   64: aload_0
    //   65: invokestatic 284	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   68: pop
    //   69: aload_1
    //   70: invokestatic 284	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: iconst_0
    //   75: ireturn
    //   76: aload_2
    //   77: invokevirtual 285	java/io/BufferedOutputStream:flush	()V
    //   80: aload_2
    //   81: invokestatic 284	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   84: pop
    //   85: aload_0
    //   86: invokestatic 284	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: iconst_1
    //   91: ireturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_3
    //   96: astore_2
    //   97: aload_2
    //   98: invokestatic 284	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   101: pop
    //   102: aload_0
    //   103: invokestatic 284	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   106: pop
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload_3
    //   111: astore_2
    //   112: goto -15 -> 97
    //   115: astore_1
    //   116: goto -19 -> 97
    //   119: astore_0
    //   120: aconst_null
    //   121: astore_0
    //   122: aload_2
    //   123: astore_1
    //   124: goto -60 -> 64
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_0
    //   131: astore_1
    //   132: aload_2
    //   133: astore_0
    //   134: goto -70 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramFile1	File
    //   0	137	1	paramFile2	File
    //   3	130	2	localObject1	Object
    //   1	110	3	localObject2	Object
    //   40	12	4	i	int
    // Exception table:
    //   from	to	target	type
    //   29	35	59	java/io/IOException
    //   35	42	59	java/io/IOException
    //   48	56	59	java/io/IOException
    //   76	80	59	java/io/IOException
    //   4	13	92	finally
    //   13	29	109	finally
    //   29	35	115	finally
    //   35	42	115	finally
    //   48	56	115	finally
    //   76	80	115	finally
    //   4	13	119	java/io/IOException
    //   13	29	127	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    File localFile = new File(paramString);
    if ((!localFile.exists()) && (!localFile.mkdirs()))
    {
      SLog.d("Q.qqstory:Utils", "mkdirs failed, path:%s", new Object[] { paramString });
      return false;
    }
    return true;
  }
  
  public static byte[] a(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new RuntimeException(paramFile + ": file not found");
    }
    if (!paramFile.isFile()) {
      throw new RuntimeException(paramFile + ": not a file");
    }
    if (!paramFile.canRead()) {
      throw new RuntimeException(paramFile + ": file not readable");
    }
    long l = paramFile.length();
    int i = (int)l;
    if (i != l) {
      throw new RuntimeException(paramFile + ": file too long");
    }
    byte[] arrayOfByte = new byte[i];
    FileInputStream localFileInputStream;
    for (;;)
    {
      int j;
      int k;
      try
      {
        localFileInputStream = new FileInputStream(paramFile);
        j = 0;
        if (i <= 0) {
          break;
        }
        k = localFileInputStream.read(arrayOfByte, j, i);
        if (k == -1) {
          throw new RuntimeException(paramFile + ": unexpected EOF");
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(paramFile + ": trouble reading", localIOException);
      }
      j += k;
      i -= k;
    }
    localFileInputStream.close();
    return localIOException;
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 334	java/io/BufferedInputStream
    //   5: dup
    //   6: new 268	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 335	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 338	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 10240
    //   21: newarray <illegal type>
    //   23: astore_3
    //   24: ldc_w 340
    //   27: invokestatic 346	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   30: astore_1
    //   31: aload_0
    //   32: aload_3
    //   33: invokevirtual 222	java/io/InputStream:read	([B)I
    //   36: istore 4
    //   38: iload 4
    //   40: ifle +39 -> 79
    //   43: aload_1
    //   44: aload_3
    //   45: iconst_0
    //   46: iload 4
    //   48: invokevirtual 349	java/security/MessageDigest:update	([BII)V
    //   51: goto -20 -> 31
    //   54: astore_1
    //   55: aload_2
    //   56: astore_1
    //   57: aload_0
    //   58: ifnull +9 -> 67
    //   61: aload_0
    //   62: invokevirtual 234	java/io/InputStream:close	()V
    //   65: aload_2
    //   66: astore_1
    //   67: aload_1
    //   68: areturn
    //   69: astore_1
    //   70: aload_1
    //   71: invokevirtual 352	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -45 -> 31
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 234	java/io/InputStream:close	()V
    //   87: aload_1
    //   88: ifnull +25 -> 113
    //   91: aload_1
    //   92: invokevirtual 356	java/security/MessageDigest:digest	()[B
    //   95: astore_1
    //   96: aload_1
    //   97: astore_2
    //   98: aload_2
    //   99: astore_1
    //   100: aload_0
    //   101: ifnull -34 -> 67
    //   104: aload_0
    //   105: invokevirtual 234	java/io/InputStream:close	()V
    //   108: aload_2
    //   109: areturn
    //   110: astore_0
    //   111: aload_2
    //   112: areturn
    //   113: aload_2
    //   114: astore_1
    //   115: aload_0
    //   116: ifnull -49 -> 67
    //   119: aload_0
    //   120: invokevirtual 234	java/io/InputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_2
    //   132: astore_1
    //   133: aload_0
    //   134: ifnull -67 -> 67
    //   137: aload_0
    //   138: invokevirtual 234	java/io/InputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aconst_null
    //   145: areturn
    //   146: astore_1
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 234	java/io/InputStream:close	()V
    //   157: aload_1
    //   158: athrow
    //   159: astore_3
    //   160: goto -73 -> 87
    //   163: astore_0
    //   164: aconst_null
    //   165: areturn
    //   166: astore_0
    //   167: goto -10 -> 157
    //   170: astore_1
    //   171: goto -22 -> 149
    //   174: astore_1
    //   175: goto -44 -> 131
    //   178: astore_0
    //   179: aconst_null
    //   180: astore_0
    //   181: goto -126 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString	String
    //   30	14	1	localMessageDigest	java.security.MessageDigest
    //   54	1	1	localFileNotFoundException	FileNotFoundException
    //   56	12	1	localObject1	Object
    //   69	2	1	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   75	58	1	localObject2	Object
    //   146	12	1	localObject3	Object
    //   170	1	1	localObject4	Object
    //   174	1	1	localIOException1	IOException
    //   1	131	2	localObject5	Object
    //   23	22	3	arrayOfByte	byte[]
    //   159	1	3	localIOException2	IOException
    //   36	11	4	i	int
    // Exception table:
    //   from	to	target	type
    //   18	24	54	java/io/FileNotFoundException
    //   24	31	54	java/io/FileNotFoundException
    //   31	38	54	java/io/FileNotFoundException
    //   43	51	54	java/io/FileNotFoundException
    //   70	74	54	java/io/FileNotFoundException
    //   83	87	54	java/io/FileNotFoundException
    //   91	96	54	java/io/FileNotFoundException
    //   24	31	69	java/security/NoSuchAlgorithmException
    //   104	108	110	java/io/IOException
    //   119	123	125	java/io/IOException
    //   2	18	128	java/io/IOException
    //   137	141	143	java/io/IOException
    //   2	18	146	finally
    //   83	87	159	java/io/IOException
    //   61	65	163	java/io/IOException
    //   153	157	166	java/io/IOException
    //   18	24	170	finally
    //   24	31	170	finally
    //   31	38	170	finally
    //   43	51	170	finally
    //   70	74	170	finally
    //   83	87	170	finally
    //   91	96	170	finally
    //   18	24	174	java/io/IOException
    //   24	31	174	java/io/IOException
    //   31	38	174	java/io/IOException
    //   43	51	174	java/io/IOException
    //   70	74	174	java/io/IOException
    //   91	96	174	java/io/IOException
    //   2	18	178	java/io/FileNotFoundException
  }
  
  /* Error */
  public static byte[] a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 268	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 335	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: lload_1
    //   14: ldc2_w 13
    //   17: lcmp
    //   18: ifge +28 -> 46
    //   21: aload 4
    //   23: astore_3
    //   24: aload_0
    //   25: lload_1
    //   26: invokestatic 362	com/tencent/qphone/base/util/MD5:getPartfileMd5	(Ljava/lang/String;J)[B
    //   29: astore_0
    //   30: aload_0
    //   31: astore_3
    //   32: aload 4
    //   34: ifnull +10 -> 44
    //   37: aload 4
    //   39: invokevirtual 327	java/io/FileInputStream:close	()V
    //   42: aload_0
    //   43: astore_3
    //   44: aload_3
    //   45: areturn
    //   46: ldc2_w 13
    //   49: lstore_1
    //   50: goto -29 -> 21
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   58: ldc 11
    //   60: ldc_w 365
    //   63: aload_3
    //   64: invokestatic 368	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   67: aload_0
    //   68: areturn
    //   69: astore 5
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: astore_3
    //   75: ldc 11
    //   77: ldc_w 370
    //   80: aload 5
    //   82: invokestatic 368	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   85: aload 6
    //   87: astore_3
    //   88: aload_0
    //   89: ifnull -45 -> 44
    //   92: aload_0
    //   93: invokevirtual 327	java/io/FileInputStream:close	()V
    //   96: aconst_null
    //   97: areturn
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   103: ldc 11
    //   105: ldc_w 365
    //   108: aload_0
    //   109: invokestatic 368	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_3
    //   117: aload_3
    //   118: ifnull +7 -> 125
    //   121: aload_3
    //   122: invokevirtual 327	java/io/FileInputStream:close	()V
    //   125: aload_0
    //   126: athrow
    //   127: astore_3
    //   128: aload_3
    //   129: invokevirtual 363	java/io/IOException:printStackTrace	()V
    //   132: ldc 11
    //   134: ldc_w 365
    //   137: aload_3
    //   138: invokestatic 368	com/tencent/biz/qqstory/support/logging/SLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   141: goto -16 -> 125
    //   144: astore_0
    //   145: goto -28 -> 117
    //   148: astore 5
    //   150: aload 4
    //   152: astore_0
    //   153: goto -80 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString	String
    //   0	156	1	paramLong	long
    //   23	22	3	localObject1	Object
    //   53	11	3	localIOException1	IOException
    //   74	48	3	localObject2	Object
    //   127	11	3	localIOException2	IOException
    //   11	140	4	localFileInputStream	FileInputStream
    //   69	12	5	localIOException3	IOException
    //   148	1	5	localIOException4	IOException
    //   1	85	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	53	java/io/IOException
    //   3	13	69	java/io/IOException
    //   92	96	98	java/io/IOException
    //   3	13	114	finally
    //   121	125	127	java/io/IOException
    //   24	30	144	finally
    //   75	85	144	finally
    //   24	30	148	java/io/IOException
  }
  
  public static long b()
  {
    if (!b()) {
      return -1L;
    }
    StatFs localStatFs = new StatFs(a());
    return localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
  }
  
  public static boolean b()
  {
    String str = Environment.getExternalStorageState();
    return ("mounted".equals(str)) || ("mounted_ro".equals(str));
  }
  
  public static boolean b(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static byte[] b(String paramString)
  {
    return a(paramString, a(paramString));
  }
  
  public static boolean c(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static byte[] c(String paramString)
  {
    return a(new File(paramString));
  }
  
  public static boolean d(String paramString)
  {
    for (;;)
    {
      File localFile1;
      int i;
      try
      {
        localFile1 = new File(paramString);
        if (!localFile1.isDirectory())
        {
          localFile1.delete();
          break label175;
        }
        if (!localFile1.isDirectory()) {
          break label175;
        }
        String str = paramString;
        if (!paramString.endsWith(File.separator)) {
          str = paramString + File.separator;
        }
        paramString = localFile1.list();
        i = 0;
        if (i < paramString.length)
        {
          File localFile2 = new File(str + paramString[i]);
          if (!localFile2.isDirectory()) {
            localFile2.delete();
          } else if (localFile2.isDirectory()) {
            d(str + paramString[i]);
          }
        }
      }
      catch (FileNotFoundException paramString)
      {
        SLog.c("Q.qqstory:Utils", "removeAllFiles() Exception:", paramString);
        return false;
      }
      localFile1.delete();
      label175:
      return true;
      i += 1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */