package com.tencent.bitapp.utils;

import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils
{
  public static String getMD5(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      return getMd5(localMessageDigest.digest(paramString.getBytes()));
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static String getMd5(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: ifnonnull +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual 55	java/io/File:exists	()Z
    //   12: ifeq +10 -> 22
    //   15: aload_0
    //   16: invokevirtual 58	java/io/File:isFile	()Z
    //   19: ifne +5 -> 24
    //   22: aconst_null
    //   23: areturn
    //   24: ldc 21
    //   26: invokestatic 27	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   29: astore_3
    //   30: new 60	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 63	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_2
    //   39: sipush 8192
    //   42: newarray <illegal type>
    //   44: astore_0
    //   45: aload_2
    //   46: aload_0
    //   47: invokevirtual 69	java/io/InputStream:read	([B)I
    //   50: istore 4
    //   52: iload 4
    //   54: ifgt +31 -> 85
    //   57: aload_3
    //   58: invokevirtual 71	java/security/MessageDigest:digest	()[B
    //   61: invokestatic 41	com/tencent/bitapp/utils/Md5Utils:getMd5	([B)Ljava/lang/String;
    //   64: astore_0
    //   65: aload_2
    //   66: invokevirtual 74	java/io/InputStream:close	()V
    //   69: aload_0
    //   70: areturn
    //   71: astore_0
    //   72: aload_0
    //   73: invokevirtual 44	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 75	java/io/FileNotFoundException:printStackTrace	()V
    //   83: aconst_null
    //   84: areturn
    //   85: aload_3
    //   86: aload_0
    //   87: iconst_0
    //   88: iload 4
    //   90: invokevirtual 79	java/security/MessageDigest:update	([BII)V
    //   93: goto -48 -> 45
    //   96: astore_0
    //   97: aload_0
    //   98: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   101: aload_2
    //   102: invokevirtual 74	java/io/InputStream:close	()V
    //   105: aload_1
    //   106: astore_0
    //   107: goto -38 -> 69
    //   110: astore_0
    //   111: aload_1
    //   112: astore_0
    //   113: goto -44 -> 69
    //   116: astore_0
    //   117: aload_2
    //   118: invokevirtual 74	java/io/InputStream:close	()V
    //   121: aload_0
    //   122: athrow
    //   123: astore_1
    //   124: goto -3 -> 121
    //   127: astore_1
    //   128: goto -59 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramFile	java.io.File
    //   1	111	1	localObject	Object
    //   123	1	1	localIOException1	java.io.IOException
    //   127	1	1	localIOException2	java.io.IOException
    //   38	80	2	localFileInputStream	java.io.FileInputStream
    //   29	57	3	localMessageDigest	MessageDigest
    //   50	39	4	i	int
    // Exception table:
    //   from	to	target	type
    //   24	30	71	java/security/NoSuchAlgorithmException
    //   30	39	78	java/io/FileNotFoundException
    //   45	52	96	java/io/IOException
    //   57	65	96	java/io/IOException
    //   85	93	96	java/io/IOException
    //   101	105	110	java/io/IOException
    //   45	52	116	finally
    //   57	65	116	finally
    //   85	93	116	finally
    //   97	101	116	finally
    //   117	121	123	java/io/IOException
    //   65	69	127	java/io/IOException
  }
  
  private static String getMd5(byte[] paramArrayOfByte)
  {
    return String.format("%32s", new Object[] { new BigInteger(1, paramArrayOfByte).toString(16) }).replace(' ', '0');
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\utils\Md5Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */