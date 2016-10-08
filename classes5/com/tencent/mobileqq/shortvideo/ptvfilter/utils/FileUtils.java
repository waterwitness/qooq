package com.tencent.mobileqq.shortvideo.ptvfilter.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.util.IOUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import ush;
import usi;

public class FileUtils
{
  private static final String a = ".jpg";
  private static final String b = ".png";
  private static final String c = ".webp";
  
  public FileUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return ThumbnailUtils.extractThumbnail(ThumbnailUtils.createVideoThumbnail(paramString, paramInt3), paramInt1, paramInt2, 2);
  }
  
  /* Error */
  public static String a(Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnull +7 -> 10
    //   6: aload_1
    //   7: ifnonnull +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 45	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: aload_1
    //   17: iconst_1
    //   18: anewarray 47	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc 49
    //   25: aastore
    //   26: aconst_null
    //   27: aconst_null
    //   28: aconst_null
    //   29: invokevirtual 55	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnonnull +17 -> 51
    //   37: aconst_null
    //   38: astore_0
    //   39: aload_1
    //   40: ifnull +9 -> 49
    //   43: aload_1
    //   44: invokeinterface 60 1 0
    //   49: aload_0
    //   50: areturn
    //   51: aload_1
    //   52: ldc 49
    //   54: invokeinterface 64 2 0
    //   59: istore_3
    //   60: aload_1
    //   61: invokeinterface 68 1 0
    //   66: ifeq +54 -> 120
    //   69: aload_1
    //   70: iload_3
    //   71: invokeinterface 72 2 0
    //   76: astore_0
    //   77: goto -38 -> 39
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_0
    //   83: aload_0
    //   84: ifnull -74 -> 10
    //   87: aload_0
    //   88: invokeinterface 60 1 0
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aload_2
    //   97: astore_1
    //   98: aload_1
    //   99: ifnull +9 -> 108
    //   102: aload_1
    //   103: invokeinterface 60 1 0
    //   108: aload_0
    //   109: athrow
    //   110: astore_0
    //   111: goto -13 -> 98
    //   114: astore_0
    //   115: aload_1
    //   116: astore_0
    //   117: goto -34 -> 83
    //   120: aconst_null
    //   121: astore_0
    //   122: goto -83 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramContext	Context
    //   0	125	1	paramUri	android.net.Uri
    //   1	96	2	localObject	Object
    //   59	12	3	i	int
    // Exception table:
    //   from	to	target	type
    //   12	33	80	java/lang/Exception
    //   12	33	95	finally
    //   51	77	110	finally
    //   51	77	114	java/lang/Exception
  }
  
  public static String a(Context paramContext, String paramString)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      paramContext = new BufferedReader(new InputStreamReader(paramContext.getAssets().open(paramString), "UTF-8"));
      for (;;)
      {
        paramString = paramContext.readLine();
        if (paramString == null) {
          break;
        }
        localStringBuilder.append(paramString);
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
    catch (IOException paramContext)
    {
      paramContext = paramContext;
      paramContext.printStackTrace();
      return localStringBuilder.toString();
      paramContext.close();
      return localStringBuilder.toString();
    }
    finally {}
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: new 122	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_0
    //   10: invokevirtual 131	java/io/File:length	()J
    //   13: l2i
    //   14: newarray <illegal type>
    //   16: astore_0
    //   17: aload_1
    //   18: aload_0
    //   19: invokevirtual 137	java/io/InputStream:read	([B)I
    //   22: pop
    //   23: new 47	java/lang/String
    //   26: dup
    //   27: aload_0
    //   28: ldc 94
    //   30: invokespecial 140	java/lang/String:<init>	([BLjava/lang/String;)V
    //   33: astore_0
    //   34: aload_1
    //   35: invokestatic 146	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: aconst_null
    //   42: astore_0
    //   43: aload_0
    //   44: invokestatic 146	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   47: aconst_null
    //   48: areturn
    //   49: astore_0
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: invokestatic 146	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   56: goto -9 -> 47
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: aload_1
    //   63: invokestatic 146	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   66: aload_0
    //   67: athrow
    //   68: astore_0
    //   69: goto -7 -> 62
    //   72: astore_0
    //   73: goto -21 -> 52
    //   76: astore_0
    //   77: aload_1
    //   78: astore_0
    //   79: goto -36 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramFile	File
    //   8	70	1	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   0	9	40	java/io/FileNotFoundException
    //   0	9	49	java/lang/Exception
    //   0	9	59	finally
    //   9	34	68	finally
    //   9	34	72	java/lang/Exception
    //   9	34	76	java/io/FileNotFoundException
  }
  
  public static String a(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString)) {
      str1 = null;
    }
    String str2;
    do
    {
      do
      {
        do
        {
          return str1;
          str1 = paramString;
        } while (new File(paramString).exists());
        str1 = paramString;
      } while (paramString.substring(paramString.lastIndexOf("/")).lastIndexOf(".") != -1);
      str1 = paramString + ".jpg";
      if (new File(str1).exists()) {
        return str1;
      }
      str2 = paramString + ".png";
      str1 = paramString;
    } while (!new File(str2).exists());
    return str2;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    if (paramString1.startsWith("assets://")) {
      return a(VideoEnvironment.a(), Utils.a(paramString1) + File.separator + paramString2);
    }
    return a(new File(paramString1 + File.separator + paramString2));
  }
  
  public static void a(Context paramContext, File paramFile)
  {
    new usi(paramContext.getApplicationContext(), paramFile).a();
  }
  
  public static void a(File paramFile)
  {
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    while (!paramFile.isDirectory()) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((arrayOfFile == null) || (arrayOfFile.length == 0))
    {
      paramFile.delete();
      return;
    }
    int i = 0;
    while (i < arrayOfFile.length)
    {
      a(arrayOfFile[i]);
      i += 1;
    }
    paramFile.delete();
  }
  
  /* Error */
  public static void a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 222	java/io/FileOutputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 223	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   12: astore_0
    //   13: new 225	java/io/BufferedWriter
    //   16: dup
    //   17: new 227	java/io/OutputStreamWriter
    //   20: dup
    //   21: aload_0
    //   22: ldc 94
    //   24: invokespecial 230	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   27: invokespecial 233	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   30: astore_2
    //   31: aload_2
    //   32: aload_1
    //   33: invokevirtual 236	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: invokestatic 239	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   40: aload_2
    //   41: invokestatic 241	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   44: return
    //   45: astore_0
    //   46: aconst_null
    //   47: astore_0
    //   48: aload_2
    //   49: astore_1
    //   50: aload_1
    //   51: invokestatic 239	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   54: aload_0
    //   55: invokestatic 241	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   58: return
    //   59: astore_1
    //   60: aconst_null
    //   61: astore_0
    //   62: aload_3
    //   63: astore_2
    //   64: aload_0
    //   65: invokestatic 239	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   68: aload_2
    //   69: invokestatic 241	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/Writer;)V
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: aload_3
    //   76: astore_2
    //   77: goto -13 -> 64
    //   80: astore_1
    //   81: goto -17 -> 64
    //   84: astore_1
    //   85: aconst_null
    //   86: astore_2
    //   87: aload_0
    //   88: astore_1
    //   89: aload_2
    //   90: astore_0
    //   91: goto -41 -> 50
    //   94: astore_1
    //   95: aload_0
    //   96: astore_1
    //   97: aload_2
    //   98: astore_0
    //   99: goto -49 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	102	0	paramFile	File
    //   0	102	1	paramString	String
    //   3	95	2	localObject1	Object
    //   1	75	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	13	45	java/lang/Exception
    //   4	13	59	finally
    //   13	31	74	finally
    //   31	36	80	finally
    //   13	31	84	java/lang/Exception
    //   31	36	94	java/lang/Exception
  }
  
  public static void a(InputStream paramInputStream, String paramString, FileUtils.OnFileCopyListener paramOnFileCopyListener)
  {
    paramInputStream = new ush(paramInputStream, paramString);
    paramInputStream.a(paramOnFileCopyListener);
    paramInputStream.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new String[0]);
  }
  
  public static boolean a(File paramFile, String paramString)
  {
    return paramFile.renameTo(new File(new File(paramString), paramFile.getName()));
  }
  
  public static boolean a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if ((paramInputStream == null) || (paramOutputStream == null)) {
      return false;
    }
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      paramOutputStream.flush();
    }
    catch (Exception paramInputStream) {}
    return true;
  }
  
  /* Error */
  public static boolean a(InputStream paramInputStream, String paramString)
  {
    // Byte code:
    //   0: new 222	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: sipush 1024
    //   12: newarray <illegal type>
    //   14: astore_2
    //   15: aload_0
    //   16: aload_2
    //   17: invokevirtual 137	java/io/InputStream:read	([B)I
    //   20: istore_3
    //   21: iload_3
    //   22: ifle +24 -> 46
    //   25: aload_1
    //   26: aload_2
    //   27: iconst_0
    //   28: iload_3
    //   29: invokevirtual 274	java/io/OutputStream:write	([BII)V
    //   32: goto -17 -> 15
    //   35: astore_2
    //   36: aload_0
    //   37: invokestatic 146	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   40: aload_1
    //   41: invokestatic 239	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_0
    //   47: invokestatic 146	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   50: aload_1
    //   51: invokestatic 239	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   54: iconst_1
    //   55: ireturn
    //   56: astore_2
    //   57: aconst_null
    //   58: astore_1
    //   59: aload_0
    //   60: invokestatic 146	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   63: aload_1
    //   64: invokestatic 239	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   67: aload_2
    //   68: athrow
    //   69: astore_2
    //   70: goto -11 -> 59
    //   73: astore_1
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -40 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramInputStream	InputStream
    //   0	79	1	paramString	String
    //   14	13	2	arrayOfByte	byte[]
    //   35	1	2	localException	Exception
    //   56	12	2	localObject1	Object
    //   69	1	2	localObject2	Object
    //   20	9	3	i	int
    // Exception table:
    //   from	to	target	type
    //   9	15	35	java/lang/Exception
    //   15	21	35	java/lang/Exception
    //   25	32	35	java/lang/Exception
    //   0	9	56	finally
    //   9	15	69	finally
    //   15	21	69	finally
    //   25	32	69	finally
    //   0	9	73	java/lang/Exception
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.indexOf("assets") < 0) && (!new File(paramString).exists())) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 127	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   12: invokevirtual 159	java/io/File:exists	()Z
    //   15: istore 5
    //   17: iload 5
    //   19: ifne +13 -> 32
    //   22: aconst_null
    //   23: invokestatic 146	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   26: aconst_null
    //   27: invokestatic 239	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   30: iconst_0
    //   31: ireturn
    //   32: new 122	java/io/FileInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 286	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   40: astore_0
    //   41: new 222	java/io/FileOutputStream
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   49: astore_2
    //   50: sipush 1024
    //   53: newarray <illegal type>
    //   55: astore_1
    //   56: aload_0
    //   57: aload_1
    //   58: invokevirtual 137	java/io/InputStream:read	([B)I
    //   61: istore 4
    //   63: iload 4
    //   65: ifle +29 -> 94
    //   68: aload_2
    //   69: aload_1
    //   70: iconst_0
    //   71: iload 4
    //   73: invokevirtual 274	java/io/OutputStream:write	([BII)V
    //   76: goto -20 -> 56
    //   79: astore_1
    //   80: aload_0
    //   81: astore_1
    //   82: aload_2
    //   83: astore_0
    //   84: aload_1
    //   85: invokestatic 146	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   88: aload_0
    //   89: invokestatic 239	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   92: iconst_0
    //   93: ireturn
    //   94: aload_0
    //   95: invokestatic 146	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   98: aload_2
    //   99: invokestatic 239	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   102: iconst_1
    //   103: ireturn
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_0
    //   107: aload_3
    //   108: astore_2
    //   109: aload_0
    //   110: invokestatic 146	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   113: aload_2
    //   114: invokestatic 239	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: aload_3
    //   121: astore_2
    //   122: goto -13 -> 109
    //   125: astore_1
    //   126: goto -17 -> 109
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_2
    //   133: astore_1
    //   134: goto -50 -> 84
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_2
    //   140: aload_0
    //   141: astore_1
    //   142: aload_2
    //   143: astore_0
    //   144: goto -60 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString1	String
    //   0	147	1	paramString2	String
    //   3	140	2	localObject1	Object
    //   1	120	3	localObject2	Object
    //   61	11	4	i	int
    //   15	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   50	56	79	java/lang/Exception
    //   56	63	79	java/lang/Exception
    //   68	76	79	java/lang/Exception
    //   4	17	104	finally
    //   32	41	104	finally
    //   41	50	119	finally
    //   50	56	125	finally
    //   56	63	125	finally
    //   68	76	125	finally
    //   4	17	129	java/lang/Exception
    //   32	41	129	java/lang/Exception
    //   41	50	137	java/lang/Exception
  }
  
  public static String b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramContext = paramContext.getAssets();
    try
    {
      InputStream localInputStream1 = paramContext.open(paramString);
      IOUtils.closeQuietly(localInputStream1);
      return paramString;
    }
    catch (IOException localIOException1)
    {
      localIOException1 = localIOException1;
      IOUtils.closeQuietly(null);
      if (paramString.lastIndexOf(".") != -1) {
        paramString = paramString.substring(0, paramString.lastIndexOf('.') + 1) + "webp";
      }
    }
    finally
    {
      try
      {
        paramContext = paramContext.open(paramString);
        IOUtils.closeQuietly(paramContext);
        return paramString;
      }
      catch (IOException paramContext)
      {
        paramContext = paramContext;
        IOUtils.closeQuietly(null);
        return null;
      }
      finally
      {
        paramContext = finally;
        IOUtils.closeQuietly(null);
        throw paramContext;
      }
      paramContext = finally;
      IOUtils.closeQuietly(null);
      throw paramContext;
    }
    String str1 = paramString + ".jpg";
    try
    {
      localInputStream2 = paramContext.open(str1);
      IOUtils.closeQuietly(localInputStream2);
      return str1;
    }
    catch (IOException localIOException2)
    {
      localIOException2 = localIOException2;
      IOUtils.closeQuietly(null);
      str2 = paramString + ".webp";
    }
    finally
    {
      try
      {
        String str2;
        InputStream localInputStream2 = paramContext.open(str2);
        IOUtils.closeQuietly(localInputStream2);
        return str2;
      }
      catch (IOException localIOException3)
      {
        localIOException3 = localIOException3;
        IOUtils.closeQuietly(null);
        paramString = paramString + ".png";
      }
      finally
      {
        try
        {
          paramContext = paramContext.open(paramString);
          IOUtils.closeQuietly(paramContext);
          return paramString;
        }
        catch (IOException paramContext)
        {
          paramContext = paramContext;
          IOUtils.closeQuietly(null);
          return null;
        }
        finally
        {
          paramContext = finally;
          IOUtils.closeQuietly(null);
          throw paramContext;
        }
        paramContext = finally;
        IOUtils.closeQuietly(null);
        throw paramContext;
      }
      paramContext = finally;
      IOUtils.closeQuietly(null);
      throw paramContext;
    }
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
      j = paramString.lastIndexOf("?");
    } while ((i == -1) || (i == paramString.length() - 1));
    if (j > i) {
      return paramString.substring(i + 1, j);
    }
    return paramString.substring(i + 1);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (new File(paramString1).exists()) {}
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        paramString1 = new FileInputStream(paramString1);
        byte[] arrayOfByte = new byte['Ѐ'];
        i = paramString1.read(arrayOfByte);
        if (i != -1)
        {
          ((MessageDigest)localObject).update(arrayOfByte, 0, i);
          continue;
        }
        ((MessageDigest)localObject).update(paramString2.getBytes());
        paramString1.close();
        paramString2 = new StringBuilder();
        localObject = ((MessageDigest)localObject).digest();
        j = localObject.length;
        i = 0;
      }
      catch (Exception paramString1) {}
      paramString2.append(paramString1);
      int k;
      paramString2.append(Integer.toHexString(k).toLowerCase());
      i += 1;
      break label133;
      paramString1 = paramString2.toString();
      return paramString1;
      return null;
      label133:
      if (i < j)
      {
        k = localObject[i] & 0xFF;
        if (k < 16) {
          paramString1 = "0";
        } else {
          paramString1 = "";
        }
      }
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new URL(paramString1);
      paramString1.openConnection().connect();
      paramString1 = new BufferedInputStream(paramString1.openStream());
      paramString2 = new FileOutputStream(paramString2);
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramString1.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramString2.write(arrayOfByte, 0, i);
      }
      paramString2.flush();
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return false;
    }
    paramString2.close();
    paramString1.close();
    return true;
  }
  
  public static String c(String paramString)
  {
    if (paramString == null) {}
    int i;
    int j;
    do
    {
      return null;
      i = paramString.lastIndexOf(".");
      j = paramString.lastIndexOf("?");
    } while ((i == -1) || (i == paramString.length() - 1));
    if (j > i) {
      return paramString.substring(i + 1, j);
    }
    return paramString.substring(i + 1);
  }
  
  public static String d(String paramString)
  {
    if (new File(paramString).exists()) {}
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      int i;
      int j;
      try
      {
        localObject2 = MessageDigest.getInstance("SHA-1");
        paramString = new FileInputStream(paramString);
        localObject1 = new byte['Ѐ'];
        i = paramString.read((byte[])localObject1);
        if (i != -1)
        {
          ((MessageDigest)localObject2).update((byte[])localObject1, 0, i);
          continue;
        }
        paramString.close();
        localObject1 = new StringBuilder();
        localObject2 = ((MessageDigest)localObject2).digest();
        j = localObject2.length;
        i = 0;
      }
      catch (Exception paramString) {}
      ((StringBuilder)localObject1).append(paramString);
      int k;
      ((StringBuilder)localObject1).append(Integer.toHexString(k).toLowerCase());
      i += 1;
      break label119;
      paramString = ((StringBuilder)localObject1).toString();
      return paramString;
      return null;
      label119:
      if (i < j)
      {
        k = localObject2[i] & 0xFF;
        if (k < 16) {
          paramString = "0";
        } else {
          paramString = "";
        }
      }
    }
  }
  
  public static String e(String paramString)
  {
    try
    {
      paramString = new FileInputStream(new File(paramString));
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Object localObject = new Base64OutputStream(localByteArrayOutputStream, 2);
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i < 0) {
          break;
        }
        ((Base64OutputStream)localObject).write(arrayOfByte, 0, i);
      }
      ((Base64OutputStream)localObject).flush();
      ((Base64OutputStream)localObject).close();
      localObject = new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
      try
      {
        localByteArrayOutputStream.close();
        paramString.close();
        return (String)localObject;
      }
      catch (Exception paramString)
      {
        return (String)localObject;
      }
      return null;
    }
    catch (Exception paramString) {}
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ptvfilter\utils\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */