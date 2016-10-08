package com.tencent.mobileqq.unifiedebug;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class UnifiedFileUtil
{
  private static final String a = "UnifiedFileUtil";
  
  private UnifiedFileUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(File paramFile, List paramList)
  {
    try
    {
      paramFile = new BufferedWriter(new FileWriter(paramFile));
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          paramFile.write(str + "\n");
        }
        if (paramList == null) {
          break label81;
        }
      }
      finally
      {
        paramList = paramFile;
        paramFile = (File)localObject;
      }
    }
    finally
    {
      for (;;)
      {
        label81:
        paramList = null;
      }
    }
    paramList.close();
    throw paramFile;
    paramFile.flush();
    if (paramFile != null) {
      paramFile.close();
    }
  }
  
  /* Error */
  public static void a(File paramFile, List paramList, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: iconst_0
    //   6: istore 7
    //   8: iconst_0
    //   9: istore 6
    //   11: aload_0
    //   12: ifnull +16 -> 28
    //   15: aload_1
    //   16: ifnull +12 -> 28
    //   19: aload_1
    //   20: invokeinterface 77 1 0
    //   25: ifeq +4 -> 29
    //   28: return
    //   29: new 79	java/io/FileOutputStream
    //   32: dup
    //   33: new 81	java/io/File
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   44: astore_2
    //   45: new 86	java/util/zip/ZipOutputStream
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 89	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   53: astore_3
    //   54: aload_1
    //   55: invokeinterface 36 1 0
    //   60: astore_1
    //   61: aload_1
    //   62: invokeinterface 42 1 0
    //   67: ifeq +104 -> 171
    //   70: aload_3
    //   71: new 81	java/io/File
    //   74: dup
    //   75: aload_0
    //   76: aload_1
    //   77: invokeinterface 46 1 0
    //   82: checkcast 48	java/lang/String
    //   85: invokespecial 92	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   88: aload_0
    //   89: invokevirtual 95	java/io/File:getPath	()Ljava/lang/String;
    //   92: invokevirtual 99	java/lang/String:length	()I
    //   95: iconst_1
    //   96: iadd
    //   97: invokestatic 102	com/tencent/mobileqq/unifiedebug/UnifiedFileUtil:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;I)V
    //   100: goto -39 -> 61
    //   103: astore_0
    //   104: aload_3
    //   105: astore_1
    //   106: ldc 8
    //   108: iconst_1
    //   109: new 50	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   116: ldc 104
    //   118: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_0
    //   122: invokevirtual 107	java/io/IOException:getMessage	()Ljava/lang/String;
    //   125: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_0
    //   135: invokevirtual 117	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   138: astore_0
    //   139: iconst_0
    //   140: istore 5
    //   142: iload 5
    //   144: aload_0
    //   145: arraylength
    //   146: if_icmpge +108 -> 254
    //   149: ldc 8
    //   151: iconst_1
    //   152: aload_0
    //   153: iload 5
    //   155: aaload
    //   156: invokevirtual 120	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   159: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: iload 5
    //   164: iconst_1
    //   165: iadd
    //   166: istore 5
    //   168: goto -26 -> 142
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 121	java/util/zip/ZipOutputStream:close	()V
    //   179: aload_2
    //   180: ifnull -152 -> 28
    //   183: aload_2
    //   184: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   187: return
    //   188: astore_0
    //   189: ldc 8
    //   191: iconst_1
    //   192: new 50	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   199: ldc 104
    //   201: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload_0
    //   205: invokevirtual 107	java/io/IOException:getMessage	()Ljava/lang/String;
    //   208: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: invokevirtual 117	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   221: astore_0
    //   222: iconst_0
    //   223: istore 5
    //   225: iload 5
    //   227: aload_0
    //   228: arraylength
    //   229: if_icmpge -201 -> 28
    //   232: ldc 8
    //   234: iconst_1
    //   235: aload_0
    //   236: iload 5
    //   238: aaload
    //   239: invokevirtual 120	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   242: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: iload 5
    //   247: iconst_1
    //   248: iadd
    //   249: istore 5
    //   251: goto -26 -> 225
    //   254: aload_1
    //   255: ifnull +7 -> 262
    //   258: aload_1
    //   259: invokevirtual 121	java/util/zip/ZipOutputStream:close	()V
    //   262: aload_2
    //   263: ifnull -235 -> 28
    //   266: aload_2
    //   267: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   270: return
    //   271: astore_0
    //   272: ldc 8
    //   274: iconst_1
    //   275: new 50	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   282: ldc 104
    //   284: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_0
    //   288: invokevirtual 107	java/io/IOException:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: aload_0
    //   301: invokevirtual 117	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   304: astore_0
    //   305: iload 6
    //   307: istore 5
    //   309: iload 5
    //   311: aload_0
    //   312: arraylength
    //   313: if_icmpge -285 -> 28
    //   316: ldc 8
    //   318: iconst_1
    //   319: aload_0
    //   320: iload 5
    //   322: aaload
    //   323: invokevirtual 120	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   326: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: iload 5
    //   331: iconst_1
    //   332: iadd
    //   333: istore 5
    //   335: goto -26 -> 309
    //   338: astore_0
    //   339: aconst_null
    //   340: astore_1
    //   341: aload 4
    //   343: astore_2
    //   344: aload_1
    //   345: ifnull +7 -> 352
    //   348: aload_1
    //   349: invokevirtual 121	java/util/zip/ZipOutputStream:close	()V
    //   352: aload_2
    //   353: ifnull +7 -> 360
    //   356: aload_2
    //   357: invokevirtual 122	java/io/FileOutputStream:close	()V
    //   360: aload_0
    //   361: athrow
    //   362: astore_1
    //   363: ldc 8
    //   365: iconst_1
    //   366: new 50	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   373: ldc 104
    //   375: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_1
    //   379: invokevirtual 107	java/io/IOException:getMessage	()Ljava/lang/String;
    //   382: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: aload_1
    //   392: invokevirtual 117	java/io/IOException:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   395: astore_1
    //   396: iload 7
    //   398: istore 5
    //   400: iload 5
    //   402: aload_1
    //   403: arraylength
    //   404: if_icmpge -44 -> 360
    //   407: ldc 8
    //   409: iconst_1
    //   410: aload_1
    //   411: iload 5
    //   413: aaload
    //   414: invokevirtual 120	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   417: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   420: iload 5
    //   422: iconst_1
    //   423: iadd
    //   424: istore 5
    //   426: goto -26 -> 400
    //   429: astore_0
    //   430: aconst_null
    //   431: astore_1
    //   432: goto -88 -> 344
    //   435: astore_0
    //   436: aload_3
    //   437: astore_1
    //   438: goto -94 -> 344
    //   441: astore_0
    //   442: goto -98 -> 344
    //   445: astore_0
    //   446: aconst_null
    //   447: astore_1
    //   448: aload_3
    //   449: astore_2
    //   450: goto -344 -> 106
    //   453: astore_0
    //   454: aconst_null
    //   455: astore_1
    //   456: goto -350 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	paramFile	File
    //   0	459	1	paramList	List
    //   0	459	2	paramString	String
    //   4	445	3	localZipOutputStream	ZipOutputStream
    //   1	341	4	localObject	Object
    //   140	285	5	i	int
    //   9	297	6	j	int
    //   6	391	7	k	int
    // Exception table:
    //   from	to	target	type
    //   54	61	103	java/io/IOException
    //   61	100	103	java/io/IOException
    //   175	179	188	java/io/IOException
    //   183	187	188	java/io/IOException
    //   258	262	271	java/io/IOException
    //   266	270	271	java/io/IOException
    //   29	45	338	finally
    //   348	352	362	java/io/IOException
    //   356	360	362	java/io/IOException
    //   45	54	429	finally
    //   54	61	435	finally
    //   61	100	435	finally
    //   106	139	441	finally
    //   142	162	441	finally
    //   29	45	445	java/io/IOException
    //   45	54	453	java/io/IOException
  }
  
  public static void a(File paramFile, byte[] paramArrayOfByte)
  {
    try
    {
      localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile));
      if (paramArrayOfByte == null) {
        break label45;
      }
    }
    finally
    {
      try
      {
        localBufferedOutputStream.write(paramArrayOfByte);
        localBufferedOutputStream.flush();
        if (localBufferedOutputStream != null) {
          localBufferedOutputStream.close();
        }
        return;
      }
      finally
      {
        BufferedOutputStream localBufferedOutputStream;
        paramArrayOfByte = localBufferedOutputStream;
      }
      paramFile = finally;
      paramArrayOfByte = null;
    }
    paramArrayOfByte.close();
    label45:
    throw paramFile;
  }
  
  public static void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        File localFile = new File((String)paramList.next());
        if ((localFile.exists()) && (localFile.isFile())) {
          localFile.delete();
        }
      }
    }
  }
  
  public static void a(List paramList, String paramString)
  {
    if (paramList == null) {
      return;
    }
    label399:
    for (;;)
    {
      try
      {
        paramString = new FileOutputStream(new File(paramString));
        localZipOutputStream = new ZipOutputStream(paramString);
        i = 0;
      }
      catch (IOException paramList)
      {
        try
        {
          Iterator localIterator = paramList.iterator();
          if (localIterator.hasNext())
          {
            File localFile = new File((String)localIterator.next());
            if (!localFile.exists()) {
              break label399;
            }
            localZipOutputStream.putNextEntry(new ZipEntry(localFile.getName()));
            localZipOutputStream.setLevel(9);
            long l3 = localFile.length();
            paramList = new FileInputStream(localFile);
            try
            {
              byte[] arrayOfByte = new byte['倀'];
              long l1 = 0L;
              int k = paramList.read(arrayOfByte, 0, 20480);
              if (k != -1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("UnifiedFileUtil", 2, "read " + k + " from " + localFile.getName());
                }
                localZipOutputStream.write(arrayOfByte, 0, k);
                int j = 1;
                i = 1;
                long l2 = l1 + k;
                l1 = l2;
                if (l2 < l3) {
                  continue;
                }
                i = j;
              }
            }
            finally
            {
              paramList.close();
              localZipOutputStream.flush();
              localZipOutputStream.closeEntry();
            }
          }
        }
        catch (IOException paramList)
        {
          ZipOutputStream localZipOutputStream;
          int i;
          paramList.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.i("UnifiedFileUtil", 2, " zip file error " + paramList, paramList);
          }
          paramString.close();
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedFileUtil", 2, " file out stream close.");
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("UnifiedFileUtil", 2, "zip file finish");
          return;
          if (i != 0) {
            localZipOutputStream.close();
          }
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedFileUtil", 2, " zip stream close.");
          }
          paramString.close();
          if (QLog.isColorLevel())
          {
            QLog.d("UnifiedFileUtil", 2, " file out stream close.");
            continue;
            paramList = paramList;
            paramList.printStackTrace();
          }
        }
        finally
        {
          paramString.close();
          if (QLog.isColorLevel()) {
            QLog.d("UnifiedFileUtil", 2, " file out stream close.");
          }
        }
      }
    }
  }
  
  private static void a(ZipOutputStream paramZipOutputStream, File paramFile, int paramInt)
  {
    int j = 0;
    try
    {
      if (paramFile.exists()) {
        if (paramFile.isFile())
        {
          paramZipOutputStream.putNextEntry(new ZipEntry(paramFile.getPath().substring(paramInt)));
          paramZipOutputStream.setLevel(9);
          long l3 = paramFile.length();
          FileInputStream localFileInputStream = new FileInputStream(paramFile);
          try
          {
            byte[] arrayOfByte = new byte['倀'];
            long l1 = 0L;
            long l2;
            do
            {
              paramInt = localFileInputStream.read(arrayOfByte, 0, 20480);
              if (paramInt == -1) {
                break;
              }
              if (QLog.isColorLevel()) {
                QLog.d("UnifiedFileUtil", 2, "read " + paramInt + " from " + paramFile.getName());
              }
              paramZipOutputStream.write(arrayOfByte, 0, paramInt);
              l2 = l1 + paramInt;
              l1 = l2;
            } while (l2 < l3);
            return;
          }
          finally
          {
            localFileInputStream.close();
            paramZipOutputStream.closeEntry();
          }
        }
      }
      int k;
      int i;
      return;
    }
    catch (IOException paramZipOutputStream)
    {
      QLog.e("UnifiedFileUtil", 1, "zipFile errror: " + paramZipOutputStream.getMessage());
      paramZipOutputStream = paramZipOutputStream.getStackTrace();
      paramInt = j;
      while (paramInt < paramZipOutputStream.length)
      {
        QLog.e("UnifiedFileUtil", 1, paramZipOutputStream[paramInt].toString());
        paramInt += 1;
      }
      paramZipOutputStream.putNextEntry(new ZipEntry(paramFile.getPath().substring(paramInt) + "/"));
      paramFile = paramFile.listFiles();
      if ((paramFile != null) && (paramFile.length > 0))
      {
        k = paramFile.length;
        i = 0;
        while (i < k)
        {
          a(paramZipOutputStream, paramFile[i], paramInt);
          i += 1;
        }
      }
      paramZipOutputStream.closeEntry();
    }
  }
  
  public static boolean a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return false;
    }
    if (paramFile.isDirectory())
    {
      String[] arrayOfString = paramFile.list();
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label59;
        }
        if (!a(new File(paramFile, arrayOfString[i]))) {
          break;
        }
        i += 1;
      }
    }
    label59:
    return paramFile.delete();
  }
  
  public static String[] a(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.isDirectory())) {
      return paramString.list();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\unifiedebug\UnifiedFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */