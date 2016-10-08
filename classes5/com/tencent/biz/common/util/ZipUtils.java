package com.tencent.biz.common.util;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipUtils
{
  protected static final int a = 1048576;
  private static final String a = "ZipUtils";
  
  public ZipUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 36	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3: ifeq +40 -> 43
    //   6: ldc 38
    //   8: iconst_4
    //   9: new 40	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   16: ldc 43
    //   18: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 53	java/lang/String:toString	()Ljava/lang/String;
    //   25: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 55
    //   30: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: new 62	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual 68	java/io/File:exists	()Z
    //   56: ifne +8 -> 64
    //   59: aload_2
    //   60: invokevirtual 71	java/io/File:mkdirs	()Z
    //   63: pop
    //   64: new 62	java/io/File
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   72: astore_0
    //   73: new 73	java/util/zip/ZipFile
    //   76: dup
    //   77: aload_0
    //   78: invokespecial 76	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   81: astore_0
    //   82: sipush 8192
    //   85: newarray <illegal type>
    //   87: astore_2
    //   88: new 40	java/lang/StringBuilder
    //   91: dup
    //   92: sipush 512
    //   95: invokespecial 79	java/lang/StringBuilder:<init>	(I)V
    //   98: astore_3
    //   99: aload_0
    //   100: invokevirtual 83	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   103: astore 4
    //   105: aload 4
    //   107: invokeinterface 88 1 0
    //   112: ifeq +435 -> 547
    //   115: aload 4
    //   117: invokeinterface 92 1 0
    //   122: checkcast 94	java/util/zip/ZipEntry
    //   125: astore 5
    //   127: aload 5
    //   129: invokevirtual 97	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   132: astore 6
    //   134: aload 6
    //   136: ldc 99
    //   138: invokevirtual 103	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   141: ifne -36 -> 105
    //   144: aload_3
    //   145: iconst_0
    //   146: aload_3
    //   147: invokevirtual 107	java/lang/StringBuilder:length	()I
    //   150: invokevirtual 111	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_3
    //   155: aload_1
    //   156: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: getstatic 114	java/io/File:separator	Ljava/lang/String;
    //   162: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload 6
    //   167: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 5
    //   173: invokevirtual 117	java/util/zip/ZipEntry:isDirectory	()Z
    //   176: ifeq +111 -> 287
    //   179: new 62	java/io/File
    //   182: dup
    //   183: aload_3
    //   184: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   190: astore 5
    //   192: aload 5
    //   194: invokevirtual 68	java/io/File:exists	()Z
    //   197: ifne -92 -> 105
    //   200: aload 5
    //   202: invokevirtual 71	java/io/File:mkdirs	()Z
    //   205: pop
    //   206: goto -101 -> 105
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 120	java/io/FileNotFoundException:printStackTrace	()V
    //   214: iconst_5
    //   215: istore 10
    //   217: aload_0
    //   218: invokevirtual 123	java/util/zip/ZipFile:close	()V
    //   221: iload 10
    //   223: ireturn
    //   224: astore_0
    //   225: aload_0
    //   226: invokevirtual 124	java/util/zip/ZipException:printStackTrace	()V
    //   229: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +11 -> 243
    //   235: ldc 38
    //   237: iconst_2
    //   238: ldc -127
    //   240: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: iconst_1
    //   244: ireturn
    //   245: astore_0
    //   246: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +11 -> 260
    //   252: ldc 38
    //   254: iconst_2
    //   255: ldc -125
    //   257: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload_0
    //   261: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   264: iconst_2
    //   265: ireturn
    //   266: astore_0
    //   267: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +11 -> 281
    //   273: ldc 38
    //   275: iconst_2
    //   276: ldc -122
    //   278: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aload_0
    //   282: invokevirtual 135	java/lang/Exception:printStackTrace	()V
    //   285: iconst_3
    //   286: ireturn
    //   287: aload_0
    //   288: aload 5
    //   290: invokevirtual 139	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   293: astore 6
    //   295: new 141	java/util/zip/CheckedInputStream
    //   298: dup
    //   299: aload 6
    //   301: new 143	java/util/zip/CRC32
    //   304: dup
    //   305: invokespecial 144	java/util/zip/CRC32:<init>	()V
    //   308: invokespecial 147	java/util/zip/CheckedInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Checksum;)V
    //   311: astore 7
    //   313: new 62	java/io/File
    //   316: dup
    //   317: new 49	java/lang/String
    //   320: dup
    //   321: aload_3
    //   322: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: ldc -107
    //   327: invokevirtual 153	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   330: ldc -101
    //   332: invokespecial 158	java/lang/String:<init>	([BLjava/lang/String;)V
    //   335: invokespecial 65	java/io/File:<init>	(Ljava/lang/String;)V
    //   338: astore 8
    //   340: aload 8
    //   342: invokevirtual 68	java/io/File:exists	()Z
    //   345: ifne +24 -> 369
    //   348: aload 8
    //   350: invokevirtual 162	java/io/File:getParentFile	()Ljava/io/File;
    //   353: astore 9
    //   355: aload 9
    //   357: invokevirtual 68	java/io/File:exists	()Z
    //   360: ifne +9 -> 369
    //   363: aload 9
    //   365: invokevirtual 71	java/io/File:mkdirs	()Z
    //   368: pop
    //   369: new 164	java/io/FileOutputStream
    //   372: dup
    //   373: aload 8
    //   375: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   378: astore 8
    //   380: aload 5
    //   382: invokevirtual 169	java/util/zip/ZipEntry:getSize	()J
    //   385: lstore 11
    //   387: lload 11
    //   389: lconst_0
    //   390: lcmp
    //   391: ifle +35 -> 426
    //   394: aload 7
    //   396: aload_2
    //   397: iconst_0
    //   398: sipush 8192
    //   401: invokevirtual 173	java/util/zip/CheckedInputStream:read	([BII)I
    //   404: istore 10
    //   406: aload 8
    //   408: aload_2
    //   409: iconst_0
    //   410: iload 10
    //   412: invokevirtual 179	java/io/OutputStream:write	([BII)V
    //   415: lload 11
    //   417: iload 10
    //   419: i2l
    //   420: lsub
    //   421: lstore 11
    //   423: goto -36 -> 387
    //   426: aload 5
    //   428: invokevirtual 182	java/util/zip/ZipEntry:getCrc	()J
    //   431: aload 7
    //   433: invokevirtual 186	java/util/zip/CheckedInputStream:getChecksum	()Ljava/util/zip/Checksum;
    //   436: invokeinterface 191 1 0
    //   441: lcmp
    //   442: ifeq +54 -> 496
    //   445: aload 6
    //   447: invokevirtual 194	java/io/InputStream:close	()V
    //   450: aload 8
    //   452: invokevirtual 195	java/io/OutputStream:close	()V
    //   455: invokestatic 127	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +83 -> 541
    //   461: ldc 38
    //   463: iconst_2
    //   464: new 40	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   471: ldc -59
    //   473: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload 5
    //   478: invokevirtual 182	java/util/zip/ZipEntry:getCrc	()J
    //   481: invokevirtual 200	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   484: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 60	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: iconst_4
    //   491: istore 10
    //   493: goto -276 -> 217
    //   496: aload 6
    //   498: invokevirtual 194	java/io/InputStream:close	()V
    //   501: aload 8
    //   503: invokevirtual 195	java/io/OutputStream:close	()V
    //   506: goto -401 -> 105
    //   509: astore_1
    //   510: aload_1
    //   511: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   514: bipush 6
    //   516: istore 10
    //   518: goto -301 -> 217
    //   521: astore_1
    //   522: aload_1
    //   523: invokevirtual 135	java/lang/Exception:printStackTrace	()V
    //   526: bipush 7
    //   528: istore 10
    //   530: goto -313 -> 217
    //   533: astore_0
    //   534: aload_0
    //   535: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   538: bipush 8
    //   540: ireturn
    //   541: iconst_4
    //   542: istore 10
    //   544: goto -327 -> 217
    //   547: iconst_0
    //   548: istore 10
    //   550: goto -333 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	553	0	paramString1	String
    //   0	553	1	paramString2	String
    //   51	358	2	localObject1	Object
    //   98	224	3	localStringBuilder	StringBuilder
    //   103	13	4	localEnumeration	Enumeration
    //   125	352	5	localObject2	Object
    //   132	365	6	localObject3	Object
    //   311	121	7	localCheckedInputStream	java.util.zip.CheckedInputStream
    //   338	164	8	localObject4	Object
    //   353	11	9	localFile	File
    //   215	334	10	i	int
    //   385	37	11	l	long
    // Exception table:
    //   from	to	target	type
    //   82	105	209	java/io/FileNotFoundException
    //   105	206	209	java/io/FileNotFoundException
    //   287	369	209	java/io/FileNotFoundException
    //   369	387	209	java/io/FileNotFoundException
    //   394	415	209	java/io/FileNotFoundException
    //   426	490	209	java/io/FileNotFoundException
    //   496	506	209	java/io/FileNotFoundException
    //   73	82	224	java/util/zip/ZipException
    //   73	82	245	java/io/IOException
    //   73	82	266	java/lang/Exception
    //   82	105	509	java/io/IOException
    //   105	206	509	java/io/IOException
    //   287	369	509	java/io/IOException
    //   369	387	509	java/io/IOException
    //   394	415	509	java/io/IOException
    //   426	490	509	java/io/IOException
    //   496	506	509	java/io/IOException
    //   82	105	521	java/lang/Exception
    //   105	206	521	java/lang/Exception
    //   287	369	521	java/lang/Exception
    //   369	387	521	java/lang/Exception
    //   394	415	521	java/lang/Exception
    //   426	490	521	java/lang/Exception
    //   496	506	521	java/lang/Exception
    //   217	221	533	java/io/IOException
  }
  
  public static String a(ZipEntry paramZipEntry)
  {
    return new String(paramZipEntry.getComment().getBytes("GB2312"), "8859_1");
  }
  
  public static ArrayList a(File paramFile)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile = a(paramFile);
    while (paramFile.hasMoreElements()) {
      localArrayList.add(new String(b((ZipEntry)paramFile.nextElement()).getBytes("GB2312"), "8859_1"));
    }
    return localArrayList;
  }
  
  public static ArrayList a(File paramFile, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new File(paramString1);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdir();
    }
    paramFile = new ZipFile(paramFile);
    localObject1 = paramFile.entries();
    while (((Enumeration)localObject1).hasMoreElements())
    {
      Object localObject2 = (ZipEntry)((Enumeration)localObject1).nextElement();
      if ((!((ZipEntry)localObject2).getName().contains("..")) && (((ZipEntry)localObject2).getName().contains(paramString2)))
      {
        InputStream localInputStream = paramFile.getInputStream((ZipEntry)localObject2);
        localObject2 = new File(new String((paramString1 + File.separator + ((ZipEntry)localObject2).getName()).getBytes("8859_1"), "GB2312"));
        if (!((File)localObject2).exists())
        {
          localObject3 = ((File)localObject2).getParentFile();
          if (!((File)localObject3).exists()) {
            ((File)localObject3).mkdirs();
          }
        }
        Object localObject3 = new FileOutputStream((File)localObject2);
        byte[] arrayOfByte = new byte[1048576];
        for (;;)
        {
          int i = localInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          ((OutputStream)localObject3).write(arrayOfByte, 0, i);
        }
        localInputStream.close();
        ((OutputStream)localObject3).close();
        localArrayList.add(localObject2);
      }
    }
    return localArrayList;
  }
  
  public static Enumeration a(File paramFile)
  {
    return new ZipFile(paramFile).entries();
  }
  
  public static void a(File paramFile, String paramString)
  {
    paramFile = new ZipFile(paramFile);
    Enumeration localEnumeration = paramFile.entries();
    byte[] arrayOfByte = new byte[' '];
    while (localEnumeration.hasMoreElements())
    {
      Object localObject1 = (ZipEntry)localEnumeration.nextElement();
      if (!((ZipEntry)localObject1).getName().contains("..")) {
        if (((ZipEntry)localObject1).isDirectory())
        {
          if (QLog.isDevelopLevel()) {
            QLog.d("upZipFile", 4, "ze.getName() = " + ((ZipEntry)localObject1).getName());
          }
          localObject1 = new String((paramString + ((ZipEntry)localObject1).getName()).getBytes("8859_1"), "GB2312");
          if (QLog.isColorLevel()) {
            QLog.d("upZipFile", 2, "str = " + (String)localObject1);
          }
          new File((String)localObject1).mkdir();
        }
        else
        {
          Object localObject2 = new File(paramString + ((ZipEntry)localObject1).getName());
          ((File)localObject2).getParentFile().mkdirs();
          localObject2 = new BufferedOutputStream(new FileOutputStream((File)localObject2));
          localObject1 = paramFile.getInputStream((ZipEntry)localObject1);
          for (;;)
          {
            int i = ((InputStream)localObject1).read(arrayOfByte, 0, 8192);
            if (i == -1) {
              break;
            }
            ((OutputStream)localObject2).write(arrayOfByte, 0, i);
          }
          ((InputStream)localObject1).close();
          ((OutputStream)localObject2).close();
        }
      }
    }
    paramFile.close();
  }
  
  public static int b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ZipUtils", 2, "unZipFile2 参数错误：zipFilePath:" + paramString1 + ",folderPath:" + paramString2);
      }
      return -1;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("ZipUtils", 4, "unZipFile2 new file:" + paramString1 + ", folderPath:" + paramString2);
    }
    paramString1 = new File(paramString1);
    if (!paramString1.exists())
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ZipUtils", 4, "unZipFile2  zipFilePath doesn't exist");
      }
      return -2;
    }
    Object localObject1 = new File(paramString2);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new byte[' '];
    int i;
    try
    {
      paramString1 = new ZipInputStream(new BufferedInputStream(new FileInputStream(paramString1)));
    }
    catch (Throwable paramString1)
    {
      try
      {
        localStringBuilder = new StringBuilder(512);
        for (;;)
        {
          localObject2 = paramString1.getNextEntry();
          if (localObject2 == null) {
            break label524;
          }
          localStringBuilder.delete(0, localStringBuilder.length());
          localObject3 = ((ZipEntry)localObject2).getName();
          if (QLog.isDevelopLevel()) {
            QLog.d("ZipUtils", 4, "unZipFile2 folderPath:" + paramString2 + ",ZipEntry name: " + (String)localObject3);
          }
          localStringBuilder.append(paramString2).append(File.separator).append((String)localObject3);
          if (!((ZipEntry)localObject2).isDirectory()) {
            break;
          }
          localObject2 = new File(localStringBuilder.toString());
          if (!((File)localObject2).exists()) {
            ((File)localObject2).mkdirs();
          }
        }
      }
      catch (FileNotFoundException paramString2)
      {
        StringBuilder localStringBuilder;
        Object localObject3;
        for (;;)
        {
          i = -3;
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
          }
          if (paramString1 == null) {
            break label584;
          }
          try
          {
            paramString1.close();
            return -3;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -3;
          }
          paramString1 = paramString1;
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, " unZipFile2  解压错误：", paramString1);
          }
          paramString1 = null;
        }
        localObject2 = new File(localStringBuilder.toString());
        if (!((File)localObject2).exists())
        {
          localObject3 = ((File)localObject2).getParentFile();
          if (!((File)localObject3).exists()) {
            ((File)localObject3).mkdirs();
          }
        }
        localObject2 = new FileOutputStream((File)localObject2);
        for (;;)
        {
          i = paramString1.read((byte[])localObject1, 0, localObject1.length);
          if (i == -1) {
            break;
          }
          ((OutputStream)localObject2).write((byte[])localObject1, 0, i);
        }
      }
      catch (IOException paramString2)
      {
        for (;;)
        {
          Object localObject2;
          i = -4;
          if (QLog.isColorLevel()) {
            QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
          }
          if (paramString1 == null) {
            break label584;
          }
          try
          {
            paramString1.close();
            return -4;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return -4;
          }
          ((OutputStream)localObject2).close();
        }
      }
      catch (Exception paramString2)
      {
        i = -5;
        if (QLog.isColorLevel()) {
          QLog.e("ZipUtils", 2, "unZipFile2 解压错误", paramString2);
        }
        if (paramString1 != null)
        {
          try
          {
            paramString1.close();
            return -5;
          }
          catch (IOException paramString1)
          {
            label524:
            paramString1.printStackTrace();
            return -5;
          }
          if (paramString1 == null) {
            break label587;
          }
          try
          {
            paramString1.close();
            return 0;
          }
          catch (IOException paramString1)
          {
            paramString1.printStackTrace();
            return 0;
          }
        }
      }
      finally
      {
        if (paramString1 != null) {}
        try
        {
          paramString1.close();
          throw paramString2;
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
    }
    label584:
    return i;
    label587:
    return 0;
  }
  
  public static String b(ZipEntry paramZipEntry)
  {
    return new String(paramZipEntry.getName().getBytes("GB2312"), "8859_1");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\common\util\ZipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */