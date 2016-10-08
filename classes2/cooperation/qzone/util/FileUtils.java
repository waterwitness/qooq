package cooperation.qzone.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtils
{
  public static final int a = 4096;
  public static final String a = ".zip";
  public static final int b = 4096;
  
  public FileUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return 0L;
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          long l = paramString.length();
          return l;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 0L;
  }
  
  /* Error */
  public static java.util.List a(File paramFile1, File paramFile2, java.util.Set paramSet)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ifnull +19 -> 26
    //   10: aload_0
    //   11: invokevirtual 44	java/io/File:length	()J
    //   14: lconst_1
    //   15: lcmp
    //   16: iflt +10 -> 26
    //   19: aload_0
    //   20: invokevirtual 53	java/io/File:canRead	()Z
    //   23: ifne +5 -> 28
    //   26: aconst_null
    //   27: areturn
    //   28: new 55	java/util/ArrayList
    //   31: dup
    //   32: invokespecial 56	java/util/ArrayList:<init>	()V
    //   35: astore 6
    //   37: aload_1
    //   38: invokevirtual 40	java/io/File:exists	()Z
    //   41: ifne +8 -> 49
    //   44: aload_1
    //   45: invokevirtual 59	java/io/File:mkdirs	()Z
    //   48: pop
    //   49: sipush 8192
    //   52: newarray <illegal type>
    //   54: astore 7
    //   56: new 61	java/util/zip/ZipInputStream
    //   59: dup
    //   60: new 63	java/io/FileInputStream
    //   63: dup
    //   64: aload_0
    //   65: invokespecial 66	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   68: invokespecial 69	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore_3
    //   72: aload 5
    //   74: astore_0
    //   75: aload_3
    //   76: invokevirtual 73	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   79: astore 4
    //   81: aload 4
    //   83: ifnull +182 -> 265
    //   86: aload 4
    //   88: invokevirtual 79	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   91: astore 5
    //   93: aload_2
    //   94: aload 5
    //   96: invokeinterface 85 2 0
    //   101: ifeq -26 -> 75
    //   104: aload 5
    //   106: ldc 87
    //   108: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   111: ifne -36 -> 75
    //   114: aload 4
    //   116: invokevirtual 94	java/util/zip/ZipEntry:isDirectory	()Z
    //   119: ifeq +50 -> 169
    //   122: new 33	java/io/File
    //   125: dup
    //   126: aload_1
    //   127: aload 5
    //   129: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   132: astore 4
    //   134: aload 4
    //   136: invokevirtual 59	java/io/File:mkdirs	()Z
    //   139: pop
    //   140: aload 6
    //   142: aload 4
    //   144: invokeinterface 102 2 0
    //   149: pop
    //   150: goto -75 -> 75
    //   153: astore_1
    //   154: aload_3
    //   155: astore_1
    //   156: aload_0
    //   157: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   160: pop
    //   161: aload_1
    //   162: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   165: pop
    //   166: aload 6
    //   168: areturn
    //   169: new 33	java/io/File
    //   172: dup
    //   173: aload_1
    //   174: aload 5
    //   176: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   179: astore 5
    //   181: aload 5
    //   183: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   186: invokevirtual 59	java/io/File:mkdirs	()Z
    //   189: pop
    //   190: new 112	java/io/BufferedOutputStream
    //   193: dup
    //   194: new 114	java/io/FileOutputStream
    //   197: dup
    //   198: aload 5
    //   200: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   203: invokespecial 118	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   206: astore 4
    //   208: aload_3
    //   209: aload 7
    //   211: iconst_0
    //   212: aload 7
    //   214: arraylength
    //   215: invokevirtual 122	java/util/zip/ZipInputStream:read	([BII)I
    //   218: istore 8
    //   220: iconst_m1
    //   221: iload 8
    //   223: if_icmpeq +16 -> 239
    //   226: aload 4
    //   228: aload 7
    //   230: iconst_0
    //   231: iload 8
    //   233: invokevirtual 126	java/io/BufferedOutputStream:write	([BII)V
    //   236: goto -28 -> 208
    //   239: aload 4
    //   241: invokevirtual 129	java/io/BufferedOutputStream:flush	()V
    //   244: aload 4
    //   246: invokevirtual 132	java/io/BufferedOutputStream:close	()V
    //   249: aload 6
    //   251: aload 5
    //   253: invokeinterface 102 2 0
    //   258: pop
    //   259: aload 4
    //   261: astore_0
    //   262: goto -187 -> 75
    //   265: aload_3
    //   266: invokevirtual 135	java/util/zip/ZipInputStream:closeEntry	()V
    //   269: aload_3
    //   270: invokevirtual 136	java/util/zip/ZipInputStream:close	()V
    //   273: aload_0
    //   274: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   277: pop
    //   278: aload_3
    //   279: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   282: pop
    //   283: goto -117 -> 166
    //   286: astore_0
    //   287: aconst_null
    //   288: astore_3
    //   289: aconst_null
    //   290: astore 4
    //   292: aload 4
    //   294: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   297: pop
    //   298: aload_3
    //   299: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   302: pop
    //   303: aload_0
    //   304: athrow
    //   305: astore_0
    //   306: goto -14 -> 292
    //   309: astore_1
    //   310: aload_0
    //   311: astore 4
    //   313: aload_1
    //   314: astore_0
    //   315: goto -23 -> 292
    //   318: astore_0
    //   319: aconst_null
    //   320: astore_1
    //   321: aload 4
    //   323: astore_0
    //   324: goto -168 -> 156
    //   327: astore_0
    //   328: aload 4
    //   330: astore_0
    //   331: aload_3
    //   332: astore_1
    //   333: goto -177 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	paramFile1	File
    //   0	336	1	paramFile2	File
    //   0	336	2	paramSet	java.util.Set
    //   71	261	3	localZipInputStream	java.util.zip.ZipInputStream
    //   1	328	4	localObject1	Object
    //   4	248	5	localObject2	Object
    //   35	215	6	localArrayList	java.util.ArrayList
    //   54	175	7	arrayOfByte	byte[]
    //   218	14	8	i	int
    // Exception table:
    //   from	to	target	type
    //   75	81	153	java/io/IOException
    //   86	150	153	java/io/IOException
    //   169	208	153	java/io/IOException
    //   265	273	153	java/io/IOException
    //   56	72	286	finally
    //   208	220	305	finally
    //   226	236	305	finally
    //   239	259	305	finally
    //   75	81	309	finally
    //   86	150	309	finally
    //   169	208	309	finally
    //   265	273	309	finally
    //   56	72	318	java/io/IOException
    //   208	220	327	java/io/IOException
    //   226	236	327	java/io/IOException
    //   239	259	327	java/io/IOException
  }
  
  public static void a(ZipOutputStream paramZipOutputStream, File paramFile, String paramString, byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramZipOutputStream == null) || (paramFile == null)) {
      throw new IOException("I/O Object got NullPointerException");
    }
    if (!paramFile.exists()) {
      throw new FileNotFoundException("Target File is missing");
    }
    if (a(paramString)) {
      paramString = paramFile.getName();
    }
    while (paramFile.isFile())
    {
      try
      {
        paramFile = new BufferedInputStream(new FileInputStream(paramFile));
        try
        {
          paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
          for (;;)
          {
            i = paramFile.read(paramArrayOfByte, 0, paramArrayOfByte.length);
            if (-1 == i) {
              break;
            }
            paramZipOutputStream.write(paramArrayOfByte, 0, i);
          }
          DataUtils.a(paramFile);
        }
        catch (IOException paramZipOutputStream) {}
      }
      catch (IOException paramZipOutputStream)
      {
        for (;;)
        {
          paramFile = null;
        }
      }
      throw paramZipOutputStream;
      paramString = paramString + File.separator + paramFile.getName();
      continue;
      DataUtils.a(paramFile);
    }
    for (;;)
    {
      return;
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        int j = paramFile.length;
        while (i < j)
        {
          a(paramZipOutputStream, paramFile[i], paramString, paramArrayOfByte);
          i += 1;
        }
      }
    }
  }
  
  public static boolean a(File paramFile)
  {
    int i = 0;
    if (paramFile != null)
    {
      if (!paramFile.isFile()) {
        break label28;
      }
      if (paramFile.delete()) {
        break label26;
      }
      paramFile.deleteOnExit();
    }
    label26:
    label28:
    while (!paramFile.isDirectory())
    {
      return false;
      return true;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      while (i < j)
      {
        a(arrayOfFile[i]);
        i += 1;
      }
    }
    return paramFile.delete();
  }
  
  /* Error */
  public static boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 63	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 66	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_0
    //   13: new 112	java/io/BufferedOutputStream
    //   16: dup
    //   17: new 114	java/io/FileOutputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   25: invokespecial 118	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   28: astore_2
    //   29: sipush 4096
    //   32: newarray <illegal type>
    //   34: astore_1
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 197	java/io/FileInputStream:read	([B)I
    //   40: istore 4
    //   42: iconst_m1
    //   43: iload 4
    //   45: if_icmpeq +31 -> 76
    //   48: aload_2
    //   49: aload_1
    //   50: iconst_0
    //   51: iload 4
    //   53: invokevirtual 126	java/io/BufferedOutputStream:write	([BII)V
    //   56: goto -21 -> 35
    //   59: astore_1
    //   60: aload_0
    //   61: astore_1
    //   62: aload_2
    //   63: astore_0
    //   64: aload_0
    //   65: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   68: pop
    //   69: aload_1
    //   70: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   73: pop
    //   74: iconst_0
    //   75: ireturn
    //   76: aload_2
    //   77: invokevirtual 129	java/io/BufferedOutputStream:flush	()V
    //   80: aload_2
    //   81: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   84: pop
    //   85: aload_0
    //   86: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: iconst_1
    //   91: ireturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_3
    //   96: astore_2
    //   97: aload_2
    //   98: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   101: pop
    //   102: aload_0
    //   103: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
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
    return (paramString == null) || (paramString.length() < 1);
  }
  
  public static boolean a(String paramString, Bitmap paramBitmap)
  {
    try
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString = new FileOutputStream(paramString);
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 90, paramString);
      paramString.flush();
      paramString.close();
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  public static boolean a(File[] paramArrayOfFile, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnull +13 -> 16
    //   6: aload_0
    //   7: arraylength
    //   8: iconst_1
    //   9: if_icmplt +7 -> 16
    //   12: aload_1
    //   13: ifnonnull +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: sipush 4096
    //   21: newarray <illegal type>
    //   23: astore_3
    //   24: new 158	java/util/zip/ZipOutputStream
    //   27: dup
    //   28: new 112	java/io/BufferedOutputStream
    //   31: dup
    //   32: new 114	java/io/FileOutputStream
    //   35: dup
    //   36: aload_1
    //   37: iconst_0
    //   38: invokespecial 219	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   41: invokespecial 118	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   44: invokespecial 220	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   47: astore_1
    //   48: aload_0
    //   49: arraylength
    //   50: istore 5
    //   52: iconst_0
    //   53: istore 4
    //   55: iload 4
    //   57: iload 5
    //   59: if_icmpge +22 -> 81
    //   62: aload_1
    //   63: aload_0
    //   64: iload 4
    //   66: aaload
    //   67: aconst_null
    //   68: aload_3
    //   69: invokestatic 184	cooperation/qzone/util/FileUtils:a	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   72: iload 4
    //   74: iconst_1
    //   75: iadd
    //   76: istore 4
    //   78: goto -23 -> 55
    //   81: aload_1
    //   82: invokevirtual 221	java/util/zip/ZipOutputStream:flush	()V
    //   85: aload_1
    //   86: invokevirtual 222	java/util/zip/ZipOutputStream:closeEntry	()V
    //   89: aload_1
    //   90: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   93: pop
    //   94: iconst_1
    //   95: ireturn
    //   96: astore_0
    //   97: aconst_null
    //   98: astore_0
    //   99: aload_0
    //   100: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   103: pop
    //   104: iconst_0
    //   105: ireturn
    //   106: astore_0
    //   107: aload_2
    //   108: astore_1
    //   109: aload_1
    //   110: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: aload_0
    //   115: athrow
    //   116: astore_0
    //   117: goto -8 -> 109
    //   120: astore_0
    //   121: aload_1
    //   122: astore_0
    //   123: goto -24 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramArrayOfFile	File[]
    //   0	126	1	paramFile	File
    //   1	107	2	localObject	Object
    //   23	46	3	arrayOfByte	byte[]
    //   53	24	4	i	int
    //   50	10	5	j	int
    // Exception table:
    //   from	to	target	type
    //   18	48	96	java/io/IOException
    //   18	48	106	finally
    //   48	52	116	finally
    //   62	72	116	finally
    //   81	89	116	finally
    //   48	52	120	java/io/IOException
    //   62	72	120	java/io/IOException
    //   81	89	120	java/io/IOException
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    return a(new File[] { paramFile1 }, paramFile2);
  }
  
  /* Error */
  public static boolean c(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: invokevirtual 44	java/io/File:length	()J
    //   13: lconst_1
    //   14: lcmp
    //   15: iflt +10 -> 25
    //   18: aload_0
    //   19: invokevirtual 53	java/io/File:canRead	()Z
    //   22: ifne +5 -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: aload_1
    //   28: invokevirtual 40	java/io/File:exists	()Z
    //   31: ifne +8 -> 39
    //   34: aload_1
    //   35: invokevirtual 59	java/io/File:mkdirs	()Z
    //   38: pop
    //   39: sipush 8192
    //   42: newarray <illegal type>
    //   44: astore 5
    //   46: new 61	java/util/zip/ZipInputStream
    //   49: dup
    //   50: new 63	java/io/FileInputStream
    //   53: dup
    //   54: aload_0
    //   55: invokespecial 66	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   58: invokespecial 69	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_2
    //   62: aload 4
    //   64: astore_0
    //   65: aload_2
    //   66: invokevirtual 73	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +136 -> 207
    //   74: aload_3
    //   75: invokevirtual 79	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   78: astore 4
    //   80: aload 4
    //   82: ldc 87
    //   84: invokevirtual 91	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   87: ifne -22 -> 65
    //   90: aload_3
    //   91: invokevirtual 94	java/util/zip/ZipEntry:isDirectory	()Z
    //   94: ifeq +35 -> 129
    //   97: new 33	java/io/File
    //   100: dup
    //   101: aload_1
    //   102: aload 4
    //   104: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   107: invokevirtual 59	java/io/File:mkdirs	()Z
    //   110: pop
    //   111: goto -46 -> 65
    //   114: astore_1
    //   115: aload_2
    //   116: astore_1
    //   117: aload_0
    //   118: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_1
    //   123: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   126: pop
    //   127: iconst_0
    //   128: ireturn
    //   129: new 33	java/io/File
    //   132: dup
    //   133: aload_1
    //   134: aload 4
    //   136: invokespecial 97	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   139: astore_3
    //   140: aload_3
    //   141: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   144: invokevirtual 59	java/io/File:mkdirs	()Z
    //   147: pop
    //   148: new 112	java/io/BufferedOutputStream
    //   151: dup
    //   152: new 114	java/io/FileOutputStream
    //   155: dup
    //   156: aload_3
    //   157: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   160: invokespecial 118	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   163: astore_3
    //   164: aload_2
    //   165: aload 5
    //   167: iconst_0
    //   168: aload 5
    //   170: arraylength
    //   171: invokevirtual 122	java/util/zip/ZipInputStream:read	([BII)I
    //   174: istore 6
    //   176: iconst_m1
    //   177: iload 6
    //   179: if_icmpeq +15 -> 194
    //   182: aload_3
    //   183: aload 5
    //   185: iconst_0
    //   186: iload 6
    //   188: invokevirtual 126	java/io/BufferedOutputStream:write	([BII)V
    //   191: goto -27 -> 164
    //   194: aload_3
    //   195: invokevirtual 129	java/io/BufferedOutputStream:flush	()V
    //   198: aload_3
    //   199: invokevirtual 132	java/io/BufferedOutputStream:close	()V
    //   202: aload_3
    //   203: astore_0
    //   204: goto -139 -> 65
    //   207: aload_2
    //   208: invokevirtual 135	java/util/zip/ZipInputStream:closeEntry	()V
    //   211: aload_2
    //   212: invokevirtual 136	java/util/zip/ZipInputStream:close	()V
    //   215: aload_0
    //   216: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   219: pop
    //   220: aload_2
    //   221: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   224: pop
    //   225: iconst_1
    //   226: ireturn
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_2
    //   230: aconst_null
    //   231: astore_3
    //   232: aload_3
    //   233: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   236: pop
    //   237: aload_2
    //   238: invokestatic 106	cooperation/qzone/util/DataUtils:a	(Ljava/lang/Object;)Z
    //   241: pop
    //   242: aload_0
    //   243: athrow
    //   244: astore_0
    //   245: goto -13 -> 232
    //   248: astore_1
    //   249: aload_0
    //   250: astore_3
    //   251: aload_1
    //   252: astore_0
    //   253: goto -21 -> 232
    //   256: astore_0
    //   257: aconst_null
    //   258: astore_1
    //   259: aload_3
    //   260: astore_0
    //   261: goto -144 -> 117
    //   264: astore_0
    //   265: aload_3
    //   266: astore_0
    //   267: aload_2
    //   268: astore_1
    //   269: goto -152 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	272	0	paramFile1	File
    //   0	272	1	paramFile2	File
    //   61	207	2	localZipInputStream	java.util.zip.ZipInputStream
    //   1	265	3	localObject	Object
    //   3	132	4	str	String
    //   44	140	5	arrayOfByte	byte[]
    //   174	13	6	i	int
    // Exception table:
    //   from	to	target	type
    //   65	70	114	java/io/IOException
    //   74	111	114	java/io/IOException
    //   129	164	114	java/io/IOException
    //   207	215	114	java/io/IOException
    //   46	62	227	finally
    //   164	176	244	finally
    //   182	191	244	finally
    //   194	202	244	finally
    //   65	70	248	finally
    //   74	111	248	finally
    //   129	164	248	finally
    //   207	215	248	finally
    //   46	62	256	java/io/IOException
    //   164	176	264	java/io/IOException
    //   182	191	264	java/io/IOException
    //   194	202	264	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\util\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */