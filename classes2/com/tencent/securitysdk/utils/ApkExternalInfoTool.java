package com.tencent.securitysdk.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Properties;
import java.util.zip.ZipException;
import xqs;

public final class ApkExternalInfoTool
{
  private static int jdField_a_of_type_Int = 0;
  private static final ZipLong jdField_a_of_type_ComTencentSecuritysdkUtilsZipLong;
  protected static final String a = "ApkExternalInfoTool";
  private static final int jdField_b_of_type_Int = 22;
  private static final ZipLong jdField_b_of_type_ComTencentSecuritysdkUtilsZipLong;
  public static final String b = "apkSecurityCode";
  private static final int jdField_c_of_type_Int = 16;
  private static final ZipLong jdField_c_of_type_ComTencentSecuritysdkUtilsZipLong;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ComTencentSecuritysdkUtilsZipLong = new ZipLong(84298576L);
    b = new ZipLong(50613072L);
    c = new ZipLong(101010256L);
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aload_1
    //   7: astore_0
    //   8: aload_0
    //   9: areturn
    //   10: new 50	java/io/RandomAccessFile
    //   13: dup
    //   14: aload_0
    //   15: ldc 52
    //   17: invokespecial 55	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_2
    //   21: aload_2
    //   22: invokestatic 58	com/tencent/securitysdk/utils/ApkExternalInfoTool:a	(Ljava/io/RandomAccessFile;)[B
    //   25: astore_0
    //   26: aload_0
    //   27: ifnonnull +15 -> 42
    //   30: aload_1
    //   31: astore_0
    //   32: aload_2
    //   33: ifnull -25 -> 8
    //   36: aload_2
    //   37: invokevirtual 61	java/io/RandomAccessFile:close	()V
    //   40: aconst_null
    //   41: areturn
    //   42: new 63	xqs
    //   45: dup
    //   46: aconst_null
    //   47: invokespecial 66	xqs:<init>	(Lxqr;)V
    //   50: astore_1
    //   51: aload_1
    //   52: aload_0
    //   53: invokevirtual 69	xqs:a	([B)V
    //   56: aload_1
    //   57: getfield 72	xqs:a	Ljava/util/Properties;
    //   60: ldc 15
    //   62: invokevirtual 78	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   65: astore_1
    //   66: aload_1
    //   67: astore_0
    //   68: aload_2
    //   69: ifnull -61 -> 8
    //   72: aload_2
    //   73: invokevirtual 61	java/io/RandomAccessFile:close	()V
    //   76: aload_1
    //   77: areturn
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 61	java/io/RandomAccessFile:close	()V
    //   89: aload_0
    //   90: athrow
    //   91: astore_0
    //   92: aload_2
    //   93: astore_1
    //   94: goto -13 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramFile	File
    //   1	93	1	localObject	Object
    //   20	73	2	localRandomAccessFile	RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   10	21	78	finally
    //   21	26	91	finally
    //   42	66	91	finally
  }
  
  public static void a(File paramFile, String paramString)
  {
    try
    {
      localRandomAccessFile = new RandomAccessFile(paramFile, "rw");
      xqs localxqs;
      int i;
      if (paramString == null) {
        break label115;
      }
    }
    finally
    {
      try
      {
        paramFile = a(a(localRandomAccessFile));
        localxqs = new xqs(null);
        localxqs.a(paramFile);
        localxqs.a.setProperty("apkSecurityCode", paramString);
        paramFile = localxqs.a();
        localRandomAccessFile.seek(jdField_a_of_type_Int);
        localRandomAccessFile.write(new ZipShort(paramFile.length).a());
        localRandomAccessFile.write(paramFile);
        i = jdField_a_of_type_Int;
        localRandomAccessFile.setLength(paramFile.length + i + 2);
        if (localRandomAccessFile != null) {
          localRandomAccessFile.close();
        }
        return;
      }
      finally
      {
        RandomAccessFile localRandomAccessFile;
        paramString = localRandomAccessFile;
      }
      paramFile = finally;
      paramString = null;
    }
    paramString.close();
    label115:
    throw paramFile;
  }
  
  public static byte[] a(RandomAccessFile paramRandomAccessFile)
  {
    int j = 1;
    long l = paramRandomAccessFile.length() - 22L;
    paramRandomAccessFile.seek(l);
    byte[] arrayOfByte = c.a();
    int i = paramRandomAccessFile.read();
    if (i != -1) {
      if ((i != arrayOfByte[0]) || (paramRandomAccessFile.read() != arrayOfByte[1]) || (paramRandomAccessFile.read() != arrayOfByte[2]) || (paramRandomAccessFile.read() != arrayOfByte[3])) {}
    }
    for (i = j;; i = 0)
    {
      if (i == 0)
      {
        throw new ZipException("archive is not a ZIP archive");
        l -= 1L;
        paramRandomAccessFile.seek(l);
        i = paramRandomAccessFile.read();
        break;
      }
      paramRandomAccessFile.seek(l + 16L + 4L);
      if (jdField_a_of_type_Int != l + 16L + 4L) {
        jdField_a_of_type_Int = (int)(l + 16L + 4L);
      }
      arrayOfByte = new byte[2];
      paramRandomAccessFile.readFully(arrayOfByte);
      i = new ZipShort(arrayOfByte).a();
      if (i == 0) {
        return null;
      }
      arrayOfByte = new byte[i];
      paramRandomAccessFile.read(arrayOfByte);
      return arrayOfByte;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      localObject = null;
    }
    byte[] arrayOfByte;
    do
    {
      do
      {
        return (byte[])localObject;
        localObject = ByteBuffer.wrap(paramArrayOfByte);
        arrayOfByte = new byte[jdField_a_of_type_ComTencentSecuritysdkUtilsZipLong.a().length];
        ((ByteBuffer)localObject).get(arrayOfByte);
        localObject = paramArrayOfByte;
      } while (jdField_a_of_type_ComTencentSecuritysdkUtilsZipLong.equals(new ZipLong(arrayOfByte)));
      localObject = paramArrayOfByte;
    } while (b.equals(new ZipLong(arrayOfByte)));
    Object localObject = new ByteArrayOutputStream();
    ((ByteArrayOutputStream)localObject).write(b.a());
    ((ByteArrayOutputStream)localObject).write(new ZipShort(paramArrayOfByte.length).a());
    ((ByteArrayOutputStream)localObject).write(paramArrayOfByte);
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\securitysdk\utils\ApkExternalInfoTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */