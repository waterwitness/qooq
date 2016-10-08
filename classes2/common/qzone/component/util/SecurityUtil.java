package common.qzone.component.util;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil
{
  private static final long jdField_a_of_type_Long = -7661587058870466123L;
  private static final char[] jdField_a_of_type_ArrayOfChar;
  private static long[] jdField_a_of_type_ArrayOfLong;
  private static final long b = -1L;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    jdField_a_of_type_ArrayOfLong = new long['Ā'];
    int i = 0;
    while (i < 256)
    {
      long l1 = i;
      int j = 0;
      if (j < 8)
      {
        if (((int)l1 & 0x1) != 0) {}
        for (long l2 = -7661587058870466123L;; l2 = 0L)
        {
          l1 = l1 >> 1 ^ l2;
          j += 1;
          break;
        }
      }
      jdField_a_of_type_ArrayOfLong[i] = l1;
      i += 1;
    }
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    long l = -1L;
    int i = 0;
    int j = paramArrayOfByte.length;
    while (i < j)
    {
      l = l >> 8 ^ jdField_a_of_type_ArrayOfLong[(((int)l ^ paramArrayOfByte[i]) & 0xFF)];
      i += 1;
    }
    return l;
  }
  
  public static String a(File paramFile)
  {
    return a(paramFile, "MD5");
  }
  
  /* Error */
  public static String a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_3
    //   3: astore_2
    //   4: aload_0
    //   5: ifnull +21 -> 26
    //   8: aload_3
    //   9: astore_2
    //   10: aload_0
    //   11: invokevirtual 62	java/io/File:exists	()Z
    //   14: ifeq +12 -> 26
    //   17: aload_0
    //   18: invokevirtual 65	java/io/File:isFile	()Z
    //   21: ifne +7 -> 28
    //   24: aload_3
    //   25: astore_2
    //   26: aload_2
    //   27: areturn
    //   28: aload_1
    //   29: invokestatic 71	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   32: astore_1
    //   33: new 73	java/io/FileInputStream
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore_0
    //   42: sipush 1024
    //   45: newarray <illegal type>
    //   47: astore_2
    //   48: aload_0
    //   49: aload_2
    //   50: invokevirtual 80	java/io/FileInputStream:read	([B)I
    //   53: istore 4
    //   55: iload 4
    //   57: ifle +30 -> 87
    //   60: aload_1
    //   61: aload_2
    //   62: iconst_0
    //   63: iload 4
    //   65: invokevirtual 84	java/security/MessageDigest:update	([BII)V
    //   68: goto -20 -> 48
    //   71: astore_1
    //   72: aload_3
    //   73: astore_2
    //   74: aload_0
    //   75: ifnull -49 -> 26
    //   78: aload_0
    //   79: invokevirtual 87	java/io/FileInputStream:close	()V
    //   82: aconst_null
    //   83: areturn
    //   84: astore_0
    //   85: aconst_null
    //   86: areturn
    //   87: aload_1
    //   88: invokevirtual 91	java/security/MessageDigest:digest	()[B
    //   91: invokestatic 94	common/qzone/component/util/SecurityUtil:a	([B)Ljava/lang/String;
    //   94: astore_1
    //   95: aload_1
    //   96: astore_2
    //   97: aload_0
    //   98: ifnull -72 -> 26
    //   101: aload_0
    //   102: invokevirtual 87	java/io/FileInputStream:close	()V
    //   105: aload_1
    //   106: areturn
    //   107: astore_0
    //   108: aload_1
    //   109: areturn
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_0
    //   113: aload_3
    //   114: astore_2
    //   115: aload_0
    //   116: ifnull -90 -> 26
    //   119: aload_0
    //   120: invokevirtual 87	java/io/FileInputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aconst_null
    //   127: areturn
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_0
    //   132: ifnull +7 -> 139
    //   135: aload_0
    //   136: invokevirtual 87	java/io/FileInputStream:close	()V
    //   139: aload_1
    //   140: athrow
    //   141: astore_0
    //   142: goto -3 -> 139
    //   145: astore_1
    //   146: goto -15 -> 131
    //   149: astore_1
    //   150: goto -37 -> 113
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_0
    //   156: goto -84 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramFile	File
    //   0	159	1	paramString	String
    //   3	112	2	localObject1	Object
    //   1	113	3	localObject2	Object
    //   53	11	4	i	int
    // Exception table:
    //   from	to	target	type
    //   42	48	71	java/io/IOException
    //   48	55	71	java/io/IOException
    //   60	68	71	java/io/IOException
    //   87	95	71	java/io/IOException
    //   78	82	84	java/io/IOException
    //   101	105	107	java/io/IOException
    //   28	42	110	java/security/NoSuchAlgorithmException
    //   119	123	125	java/io/IOException
    //   28	42	128	finally
    //   135	139	141	java/io/IOException
    //   42	48	145	finally
    //   48	55	145	finally
    //   60	68	145	finally
    //   87	95	145	finally
    //   42	48	149	java/security/NoSuchAlgorithmException
    //   48	55	149	java/security/NoSuchAlgorithmException
    //   60	68	149	java/security/NoSuchAlgorithmException
    //   87	95	149	java/security/NoSuchAlgorithmException
    //   28	42	153	java/io/IOException
  }
  
  public static String a(String paramString)
  {
    return a(paramString, "MD5");
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString2 = MessageDigest.getInstance(paramString2);
      paramString2.update(paramString1.getBytes());
      paramString1 = a(paramString2.digest());
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1) {}
    return null;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      arrayOfChar[(i * 2 + 1)] = jdField_a_of_type_ArrayOfChar[(j & 0xF)];
      j = (byte)(j >>> 4);
      arrayOfChar[(i * 2)] = jdField_a_of_type_ArrayOfChar[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] a(String paramString)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[paramString.length() * 2];
    paramString = paramString.toCharArray();
    int k = paramString.length;
    int j = 0;
    while (i < k)
    {
      int m = paramString[i];
      int n = j + 1;
      arrayOfByte[j] = ((byte)(m & 0xFF));
      j = n + 1;
      arrayOfByte[n] = ((byte)(m >> 8));
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\common\qzone\component\util\SecurityUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */