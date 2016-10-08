package com.tencent.open.base;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils
{
  protected static final int a = 1024;
  protected static final String a = "";
  protected static final String b = File.separator;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static void a(File paramFile1, File paramFile2)
  {
    paramFile2 = new ZipOutputStream(new CheckedOutputStream(new FileOutputStream(paramFile2), new CRC32()));
    paramFile2.setLevel(0);
    a(paramFile1, paramFile2, "", false);
    paramFile2.flush();
    paramFile2.close();
  }
  
  public static void a(File paramFile, String paramString)
  {
    a(paramFile, new File(paramString));
  }
  
  /* Error */
  protected static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 73	java/util/zip/ZipEntry
    //   5: dup
    //   6: new 75	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   13: aload_2
    //   14: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 84	java/io/File:getName	()Ljava/lang/String;
    //   21: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokespecial 88	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   30: astore_2
    //   31: aload_2
    //   32: lconst_0
    //   33: invokevirtual 92	java/util/zip/ZipEntry:setTime	(J)V
    //   36: aload_1
    //   37: aload_2
    //   38: invokevirtual 96	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   41: new 98	java/io/BufferedInputStream
    //   44: dup
    //   45: new 100	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: invokespecial 104	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore_2
    //   57: aload_2
    //   58: astore_0
    //   59: sipush 1024
    //   62: newarray <illegal type>
    //   64: astore_3
    //   65: aload_2
    //   66: astore_0
    //   67: aload_2
    //   68: aload_3
    //   69: iconst_0
    //   70: sipush 1024
    //   73: invokevirtual 108	java/io/BufferedInputStream:read	([BII)I
    //   76: istore 4
    //   78: iload 4
    //   80: iconst_m1
    //   81: if_icmpeq +43 -> 124
    //   84: aload_2
    //   85: astore_0
    //   86: aload_1
    //   87: aload_3
    //   88: iconst_0
    //   89: iload 4
    //   91: invokevirtual 112	java/util/zip/ZipOutputStream:write	([BII)V
    //   94: goto -29 -> 65
    //   97: astore_1
    //   98: aload_2
    //   99: astore_0
    //   100: new 71	java/lang/Exception
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 115	java/lang/Exception:<init>	(Ljava/lang/Throwable;)V
    //   108: athrow
    //   109: astore_2
    //   110: aload_0
    //   111: astore_1
    //   112: aload_2
    //   113: astore_0
    //   114: aload_1
    //   115: ifnull +7 -> 122
    //   118: aload_1
    //   119: invokevirtual 116	java/io/BufferedInputStream:close	()V
    //   122: aload_0
    //   123: athrow
    //   124: aload_2
    //   125: astore_0
    //   126: aload_1
    //   127: invokevirtual 119	java/util/zip/ZipOutputStream:closeEntry	()V
    //   130: aload_2
    //   131: ifnull +7 -> 138
    //   134: aload_2
    //   135: invokevirtual 116	java/io/BufferedInputStream:close	()V
    //   138: return
    //   139: astore_0
    //   140: aload_3
    //   141: astore_1
    //   142: goto -28 -> 114
    //   145: astore_1
    //   146: aconst_null
    //   147: astore_0
    //   148: goto -48 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramFile	File
    //   0	151	1	paramZipOutputStream	ZipOutputStream
    //   0	151	2	paramString	String
    //   1	140	3	arrayOfByte	byte[]
    //   76	14	4	i	int
    // Exception table:
    //   from	to	target	type
    //   59	65	97	java/lang/Exception
    //   67	78	97	java/lang/Exception
    //   86	94	97	java/lang/Exception
    //   126	130	97	java/lang/Exception
    //   59	65	109	finally
    //   67	78	109	finally
    //   86	94	109	finally
    //   100	109	109	finally
    //   126	130	109	finally
    //   2	57	139	finally
    //   2	57	145	java/lang/Exception
  }
  
  protected static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString, boolean paramBoolean)
  {
    if (paramFile.isDirectory())
    {
      b(paramFile, paramZipOutputStream, paramString, paramBoolean);
      return;
    }
    a(paramFile, paramZipOutputStream, paramString);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(new File(paramString1), paramString2);
  }
  
  protected static void b(File paramFile, ZipOutputStream paramZipOutputStream, String paramString, boolean paramBoolean)
  {
    File[] arrayOfFile = paramFile.listFiles();
    Arrays.sort(arrayOfFile);
    int i;
    label85:
    File localFile;
    if (arrayOfFile.length == 0)
    {
      if (paramBoolean)
      {
        localObject = paramString + paramFile.getName() + b;
        localObject = new ZipEntry((String)localObject);
        ((ZipEntry)localObject).setTime(0L);
        paramZipOutputStream.putNextEntry((ZipEntry)localObject);
        paramZipOutputStream.closeEntry();
      }
    }
    else
    {
      int j = arrayOfFile.length;
      i = 0;
      if (i >= j) {
        return;
      }
      localFile = arrayOfFile[i];
      if (!paramBoolean) {
        break label156;
      }
    }
    label156:
    for (Object localObject = paramString + paramFile.getName() + b;; localObject = paramString)
    {
      a(localFile, paramZipOutputStream, (String)localObject, true);
      i += 1;
      break label85;
      localObject = paramString;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\ZipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */