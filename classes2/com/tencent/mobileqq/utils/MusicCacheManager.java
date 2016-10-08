package com.tencent.mobileqq.utils;

import android.os.Environment;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MusicCacheManager
{
  private static long a = 157286400L;
  public static final String a = "MusicCacheManager";
  private static final String b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    b = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/MobileQQ/qqmusic/";
  }
  
  public static void a()
  {
    Object localObject1 = new File(b);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (((File)localObject2).isFile()) {
          ((File)localObject2).delete();
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static void a(File paramFile)
  {
    // Byte code:
    //   0: new 76	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc 78
    //   7: invokespecial 81	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: aload_1
    //   14: invokevirtual 85	java/io/RandomAccessFile:readByte	()B
    //   17: istore_3
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: lconst_0
    //   22: invokevirtual 89	java/io/RandomAccessFile:seek	(J)V
    //   25: aload_1
    //   26: astore_0
    //   27: aload_1
    //   28: iload_3
    //   29: invokevirtual 93	java/io/RandomAccessFile:write	(I)V
    //   32: aload_1
    //   33: ifnull +7 -> 40
    //   36: aload_1
    //   37: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   40: return
    //   41: astore_2
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_1
    //   45: astore_0
    //   46: aload_2
    //   47: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   50: aload_1
    //   51: ifnull -11 -> 40
    //   54: aload_1
    //   55: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   58: return
    //   59: astore_0
    //   60: return
    //   61: astore_1
    //   62: aconst_null
    //   63: astore_0
    //   64: aload_0
    //   65: ifnull +7 -> 72
    //   68: aload_0
    //   69: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   72: aload_1
    //   73: athrow
    //   74: astore_0
    //   75: return
    //   76: astore_0
    //   77: goto -5 -> 72
    //   80: astore_1
    //   81: goto -17 -> 64
    //   84: astore_2
    //   85: goto -41 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	paramFile	File
    //   10	45	1	localRandomAccessFile	java.io.RandomAccessFile
    //   61	12	1	localObject1	Object
    //   80	1	1	localObject2	Object
    //   41	6	2	localIOException1	IOException
    //   84	1	2	localIOException2	IOException
    //   17	12	3	i	int
    // Exception table:
    //   from	to	target	type
    //   0	11	41	java/io/IOException
    //   54	58	59	java/io/IOException
    //   0	11	61	finally
    //   36	40	74	java/io/IOException
    //   68	72	76	java/io/IOException
    //   13	18	80	finally
    //   20	25	80	finally
    //   27	32	80	finally
    //   46	50	80	finally
    //   13	18	84	java/io/IOException
    //   20	25	84	java/io/IOException
    //   27	32	84	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    paramString = new File(b + paramString + ".cfg");
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "delCfgFile");
    }
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    try
    {
      Object localObject = new File(b);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdir();
      }
      paramString = new File(b + paramString + ".cfg");
      if (!paramString.exists()) {
        paramString.createNewFile();
      }
      paramString = new FileOutputStream(paramString, false);
      localObject = "downloadOffset:" + paramInt1 + ":" + "fileSize:" + paramInt2;
      if (QLog.isColorLevel()) {
        QLog.d("QQPlayerService", 2, "saveCacheInfo,result:" + (String)localObject);
      }
      paramString.write(((String)localObject).getBytes());
      paramString.close();
      return;
    }
    catch (FileNotFoundException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQPlayerService", 2, "saveCacheInfo,FileNotFoundException:" + paramString.getMessage(), paramString);
      return;
    }
    catch (IOException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQPlayerService", 2, "saveCacheInfo,IOException:" + paramString.getMessage(), paramString);
    }
  }
  
  private static boolean a(File paramFile)
  {
    if (!paramFile.getName().endsWith(".cfg")) {
      new File(paramFile.getAbsolutePath() + ".cfg").delete();
    }
    return paramFile.delete();
  }
  
  public static boolean a(String paramString, int[] paramArrayOfInt)
  {
    paramString = new File(b + paramString + ".cfg");
    if (!paramString.exists()) {}
    for (;;)
    {
      return true;
      try
      {
        localFileInputStream = new FileInputStream(paramString);
        localObject = new byte['က'];
        localByteArrayOutputStream = new ByteArrayOutputStream();
        for (;;)
        {
          i = localFileInputStream.read((byte[])localObject);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write((byte[])localObject, 0, i);
        }
      }
      catch (FileNotFoundException paramString)
      {
        FileInputStream localFileInputStream;
        ByteArrayOutputStream localByteArrayOutputStream;
        int i;
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "isCacheComplete,FileNotFoundException:" + paramString.getMessage(), paramString);
        }
        return false;
        Object localObject = localByteArrayOutputStream.toString().split(":");
        localByteArrayOutputStream.close();
        localFileInputStream.close();
        if ((localObject == null) || (localObject.length < 4))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQPlayerService", 2, "isCacheComplete,getCacheInfo:read error,string.length < 4");
          }
        }
        else
        {
          i = Integer.parseInt(localObject[1]);
          int j = Integer.parseInt(localObject[3]);
          if (i == j) {
            continue;
          }
          paramArrayOfInt[0] = i;
          paramArrayOfInt[1] = j;
          return false;
        }
      }
      catch (IOException paramArrayOfInt)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQPlayerService", 2, "isCacheComplete,IOException:" + paramArrayOfInt.getMessage(), paramArrayOfInt);
        }
        paramString.delete();
        return false;
      }
    }
    paramArrayOfInt[0] = 0;
    paramArrayOfInt[1] = 0;
    return false;
  }
  
  public static void b()
  {
    Object localObject1 = new File(b);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).add(5, -15);
    ((Calendar)localObject2).set(11, 0);
    ((Calendar)localObject2).set(12, 0);
    ((Calendar)localObject2).set(13, 0);
    ((Calendar)localObject2).set(14, 0);
    long l3 = ((Calendar)localObject2).getTimeInMillis();
    if (((File)localObject1).exists())
    {
      localObject2 = ((File)localObject1).listFiles();
      if (localObject2 != null) {}
    }
    else
    {
      return;
      break label166;
    }
    label72:
    localObject1 = new TreeMap();
    int j = localObject2.length;
    long l1 = 0L;
    int i = 0;
    for (;;)
    {
      File localFile;
      long l2;
      if (i < j)
      {
        localFile = localObject2[i];
        l2 = l1;
        if (!localFile.isFile()) {}
      }
      else
      {
        try
        {
          if (localFile.lastModified() < l3)
          {
            a(localFile);
            l2 = l1;
          }
          else
          {
            ((TreeMap)localObject1).put(Long.valueOf(localFile.lastModified()), localFile);
            l2 = localFile.length();
            l2 = l1 + l2;
          }
        }
        catch (Exception localException)
        {
          label166:
          l2 = l1;
        }
        l2 = l1;
        if (l2 <= a) {
          break label72;
        }
        localObject2 = ((TreeMap)localObject1).entrySet().iterator();
        l1 = l2;
        l2 = l1;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localFile = (File)((Map.Entry)((Iterator)localObject2).next()).getValue();
        l2 = localFile.length();
        if (a(localFile)) {
          l1 -= l2;
        }
        for (;;)
        {
          break;
        }
      }
      i += 1;
      l1 = l2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\MusicCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */