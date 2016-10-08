package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileSizeFormat;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class FileUtil
{
  public FileUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      for (;;)
      {
        return 0L;
        try
        {
          paramString = new File(paramString);
          if ((paramString != null) && (paramString.exists()) && (paramString.length() > 0L))
          {
            long l = paramString.length();
            return l;
          }
        }
        catch (Exception paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("FileUtils", 2, FileManagerUtil.a());
    return 0L;
  }
  
  public static FileInfo a(File paramFile)
  {
    FileInfo localFileInfo = new FileInfo();
    localFileInfo.d(paramFile.getName());
    localFileInfo.a(paramFile.isDirectory());
    return localFileInfo;
  }
  
  public static String a()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {
      return Environment.getExternalStorageDirectory().getPath();
    }
    return null;
  }
  
  public static String a(long paramLong)
  {
    return FileSizeFormat.a(paramLong);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    return FileSizeFormat.a(paramLong, paramInt);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = new File(Utils.a(paramContext) + "thumbnails/");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.endsWith(".rename") == true)
    {
      String str = paramString.replace(".rename", "");
      i = str.lastIndexOf(".");
      if (i == -1) {
        return "";
      }
      if (str.substring(i).replaceAll("[0-9]*", "").replace("(", "").replace(")", "").equalsIgnoreCase(".apk") == true) {
        return ".apk.rename";
      }
    }
    int i = paramString.lastIndexOf(".");
    if (i >= 0) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
    if (paramString1.endsWith(File.separator)) {}
    for (paramString1 = "";; paramString1 = File.separator) {
      return paramString1 + paramString2;
    }
  }
  
  public static ArrayList a(String paramString, boolean paramBoolean, int paramInt)
  {
    try
    {
      paramString = new File(paramString).listFiles();
      if (paramString == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramString.length)
      {
        Object localObject = paramString[i];
        if ((!paramBoolean) && (((File)localObject).getName().startsWith("."))) {}
        for (;;)
        {
          i += 1;
          break;
          if ((((File)localObject).isDirectory()) || (((File)localObject).length() != 0L))
          {
            FileInfo localFileInfo = new FileInfo();
            localFileInfo.d(((File)localObject).getName());
            localFileInfo.a(((File)localObject).isDirectory());
            localFileInfo.e(((File)localObject).getPath());
            localFileInfo.a(((File)localObject).length());
            localFileInfo.b(((File)localObject).lastModified());
            localArrayList.add(localFileInfo);
          }
        }
      }
      if (paramInt == 0) {
        Collections.sort(localArrayList, new FileUtil.MyFileCompare());
      }
      for (;;)
      {
        return localArrayList;
        Collections.sort(localArrayList, new FileCompare());
      }
      return null;
    }
    catch (Exception paramString) {}
  }
  
  public static void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if ((paramFile != null) && (paramFile.length > 0))
      {
        int i = 0;
        while (i < paramFile.length)
        {
          a(paramFile[i]);
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public static boolean a(android.graphics.Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +7 -> 12
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: ireturn
    //   12: new 203	java/io/BufferedOutputStream
    //   15: dup
    //   16: new 205	java/io/FileOutputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 206	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   24: ldc -49
    //   26: invokespecial 210	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   29: astore_1
    //   30: aload_0
    //   31: getstatic 216	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   34: bipush 70
    //   36: aload_1
    //   37: invokevirtual 222	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   40: istore_3
    //   41: iload_3
    //   42: istore_2
    //   43: aload_1
    //   44: ifnull -34 -> 10
    //   47: aload_1
    //   48: invokevirtual 227	java/io/OutputStream:flush	()V
    //   51: aload_1
    //   52: invokevirtual 230	java/io/OutputStream:close	()V
    //   55: iload_3
    //   56: ireturn
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: ifnull +11 -> 72
    //   64: aload_1
    //   65: invokevirtual 227	java/io/OutputStream:flush	()V
    //   68: aload_1
    //   69: invokevirtual 230	java/io/OutputStream:close	()V
    //   72: aload_0
    //   73: athrow
    //   74: astore_0
    //   75: goto -15 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramBitmap	android.graphics.Bitmap
    //   0	78	1	paramString	String
    //   9	34	2	bool1	boolean
    //   40	16	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   12	30	57	finally
    //   30	41	74	finally
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          a(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  /* Error */
  @Deprecated
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: aload_0
    //   10: invokevirtual 240	java/io/File:isFile	()Z
    //   13: ifeq +84 -> 97
    //   16: aload_1
    //   17: invokevirtual 28	java/io/File:exists	()Z
    //   20: ifeq +8 -> 28
    //   23: aload_1
    //   24: invokevirtual 233	java/io/File:delete	()Z
    //   27: pop
    //   28: new 205	java/io/FileOutputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 242	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   36: astore_2
    //   37: new 244	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 245	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore_3
    //   46: sipush 4096
    //   49: newarray <illegal type>
    //   51: astore 4
    //   53: aload_3
    //   54: aload 4
    //   56: invokevirtual 249	java/io/FileInputStream:read	([B)I
    //   59: istore 7
    //   61: iload 7
    //   63: iconst_m1
    //   64: if_icmpeq +117 -> 181
    //   67: aload_2
    //   68: aload 4
    //   70: iconst_0
    //   71: iload 7
    //   73: invokevirtual 253	java/io/FileOutputStream:write	([BII)V
    //   76: goto -23 -> 53
    //   79: astore 4
    //   81: aload_2
    //   82: ifnull +7 -> 89
    //   85: aload_2
    //   86: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   89: aload_3
    //   90: ifnull +7 -> 97
    //   93: aload_3
    //   94: invokevirtual 255	java/io/FileInputStream:close	()V
    //   97: aload_0
    //   98: invokevirtual 61	java/io/File:isDirectory	()Z
    //   101: ifeq +131 -> 232
    //   104: aload_0
    //   105: invokevirtual 164	java/io/File:listFiles	()[Ljava/io/File;
    //   108: astore_0
    //   109: aload_1
    //   110: invokevirtual 258	java/io/File:mkdir	()Z
    //   113: pop
    //   114: iload 6
    //   116: aload_0
    //   117: arraylength
    //   118: if_icmpge +114 -> 232
    //   121: aload_0
    //   122: iload 6
    //   124: aaload
    //   125: invokevirtual 261	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   128: new 21	java/io/File
    //   131: dup
    //   132: new 95	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   139: aload_1
    //   140: invokevirtual 261	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   143: invokevirtual 264	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: getstatic 159	java/io/File:separator	Ljava/lang/String;
    //   149: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_0
    //   153: iload 6
    //   155: aaload
    //   156: invokevirtual 55	java/io/File:getName	()Ljava/lang/String;
    //   159: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokespecial 24	java/io/File:<init>	(Ljava/lang/String;)V
    //   168: invokestatic 266	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   171: pop
    //   172: iload 6
    //   174: iconst_1
    //   175: iadd
    //   176: istore 6
    //   178: goto -64 -> 114
    //   181: aload_2
    //   182: invokevirtual 267	java/io/FileOutputStream:flush	()V
    //   185: aload_2
    //   186: ifnull +7 -> 193
    //   189: aload_2
    //   190: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   193: aload_3
    //   194: ifnull -97 -> 97
    //   197: aload_3
    //   198: invokevirtual 255	java/io/FileInputStream:close	()V
    //   201: goto -104 -> 97
    //   204: astore_2
    //   205: goto -108 -> 97
    //   208: astore_0
    //   209: aconst_null
    //   210: astore_2
    //   211: aload 4
    //   213: astore_1
    //   214: aload_2
    //   215: ifnull +7 -> 222
    //   218: aload_2
    //   219: invokevirtual 254	java/io/FileOutputStream:close	()V
    //   222: aload_1
    //   223: ifnull +7 -> 230
    //   226: aload_1
    //   227: invokevirtual 255	java/io/FileInputStream:close	()V
    //   230: aload_0
    //   231: athrow
    //   232: iconst_1
    //   233: ireturn
    //   234: astore_2
    //   235: goto -42 -> 193
    //   238: astore_2
    //   239: goto -150 -> 89
    //   242: astore_2
    //   243: goto -146 -> 97
    //   246: astore_2
    //   247: goto -25 -> 222
    //   250: astore_1
    //   251: goto -21 -> 230
    //   254: astore_0
    //   255: aload 4
    //   257: astore_1
    //   258: goto -44 -> 214
    //   261: astore_0
    //   262: aload_3
    //   263: astore_1
    //   264: goto -50 -> 214
    //   267: astore_2
    //   268: aconst_null
    //   269: astore_2
    //   270: aload 5
    //   272: astore_3
    //   273: goto -192 -> 81
    //   276: astore_3
    //   277: aload 5
    //   279: astore_3
    //   280: goto -199 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	paramFile1	File
    //   0	283	1	paramFile2	File
    //   36	154	2	localFileOutputStream	java.io.FileOutputStream
    //   204	1	2	localIOException1	java.io.IOException
    //   210	9	2	localObject1	Object
    //   234	1	2	localIOException2	java.io.IOException
    //   238	1	2	localIOException3	java.io.IOException
    //   242	1	2	localIOException4	java.io.IOException
    //   246	1	2	localIOException5	java.io.IOException
    //   267	1	2	localIOException6	java.io.IOException
    //   269	1	2	localObject2	Object
    //   45	228	3	localObject3	Object
    //   276	1	3	localIOException7	java.io.IOException
    //   279	1	3	localObject4	Object
    //   1	68	4	arrayOfByte	byte[]
    //   79	177	4	localIOException8	java.io.IOException
    //   4	274	5	localObject5	Object
    //   7	170	6	i	int
    //   59	13	7	j	int
    // Exception table:
    //   from	to	target	type
    //   46	53	79	java/io/IOException
    //   53	61	79	java/io/IOException
    //   67	76	79	java/io/IOException
    //   181	185	79	java/io/IOException
    //   197	201	204	java/io/IOException
    //   16	28	208	finally
    //   28	37	208	finally
    //   189	193	234	java/io/IOException
    //   85	89	238	java/io/IOException
    //   93	97	242	java/io/IOException
    //   218	222	246	java/io/IOException
    //   226	230	250	java/io/IOException
    //   37	46	254	finally
    //   46	53	261	finally
    //   53	61	261	finally
    //   67	76	261	finally
    //   181	185	261	finally
    //   16	28	267	java/io/IOException
    //   28	37	267	java/io/IOException
    //   37	46	276	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() <= 0) {}
    }
    try
    {
      bool1 = new File(paramString).exists();
      return bool1;
    }
    catch (Exception paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Tools.isFileExists", 2, "" + paramString.getMessage());
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
    } while (i < 0);
    return paramString.substring(0, i + 1);
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    if (a(paramFile1, paramFile2))
    {
      a(paramFile1);
      return true;
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((paramString == null) || (!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() > 0) {
        bool2 = bool3;
      }
    }
    try
    {
      bool3 = a(new File(paramString));
      bool1 = bool3;
      if (bool3)
      {
        bool2 = bool3;
        FileManagerUtil.b(paramString);
        bool1 = bool3;
      }
    }
    catch (Exception paramString)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Tools.delete", 2, "" + paramString.getMessage());
    }
    return bool1;
    return bool2;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */