package com.tencent.smtt.utils;

import java.io.InputStream;
import java.security.MessageDigest;

public class Md5Utils
{
  /* Error */
  public static String getMD5(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: ldc 19
    //   7: invokestatic 25	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   10: astore_1
    //   11: new 27	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 30	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   19: astore_0
    //   20: sipush 8192
    //   23: newarray <illegal type>
    //   25: astore_2
    //   26: aload_0
    //   27: aload_2
    //   28: invokevirtual 34	java/io/FileInputStream:read	([B)I
    //   31: istore 5
    //   33: iload 5
    //   35: iconst_m1
    //   36: if_icmpeq +41 -> 77
    //   39: aload_1
    //   40: aload_2
    //   41: iconst_0
    //   42: iload 5
    //   44: invokevirtual 38	java/security/MessageDigest:update	([BII)V
    //   47: goto -21 -> 26
    //   50: astore_1
    //   51: aload 4
    //   53: astore_2
    //   54: aload_0
    //   55: ifnull +10 -> 65
    //   58: aload_0
    //   59: invokevirtual 41	java/io/FileInputStream:close	()V
    //   62: aload 4
    //   64: astore_2
    //   65: aload_2
    //   66: areturn
    //   67: astore_1
    //   68: aload_1
    //   69: invokevirtual 44	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   72: aconst_null
    //   73: astore_1
    //   74: goto -63 -> 11
    //   77: aload_1
    //   78: invokevirtual 48	java/security/MessageDigest:digest	()[B
    //   81: invokestatic 54	com/tencent/smtt/utils/ByteUtils:byteToHexString	([B)Ljava/lang/String;
    //   84: astore_1
    //   85: aload_1
    //   86: astore_2
    //   87: aload_0
    //   88: ifnull -23 -> 65
    //   91: aload_0
    //   92: invokevirtual 41	java/io/FileInputStream:close	()V
    //   95: aload_1
    //   96: areturn
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   102: aload_1
    //   103: areturn
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_0
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 41	java/io/FileInputStream:close	()V
    //   115: aload_1
    //   116: athrow
    //   117: astore_0
    //   118: aload_3
    //   119: astore_1
    //   120: goto -22 -> 98
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_0
    //   126: aload 4
    //   128: astore_2
    //   129: aload_0
    //   130: ifnull -65 -> 65
    //   133: aload_0
    //   134: invokevirtual 41	java/io/FileInputStream:close	()V
    //   137: aconst_null
    //   138: areturn
    //   139: astore_0
    //   140: aload_3
    //   141: astore_1
    //   142: goto -44 -> 98
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 55	java/io/IOException:printStackTrace	()V
    //   150: goto -35 -> 115
    //   153: astore_1
    //   154: goto -47 -> 107
    //   157: astore_1
    //   158: goto -32 -> 126
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_0
    //   164: goto -113 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramFile	java.io.File
    //   10	30	1	localMessageDigest	MessageDigest
    //   50	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   67	2	1	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   73	30	1	str	String
    //   104	12	1	localObject1	Object
    //   119	23	1	localObject2	Object
    //   153	1	1	localObject3	Object
    //   157	1	1	localIOException	java.io.IOException
    //   25	104	2	localObject4	Object
    //   1	140	3	localObject5	Object
    //   3	124	4	localObject6	Object
    //   31	12	5	i	int
    // Exception table:
    //   from	to	target	type
    //   20	26	50	java/io/FileNotFoundException
    //   26	33	50	java/io/FileNotFoundException
    //   39	47	50	java/io/FileNotFoundException
    //   77	85	50	java/io/FileNotFoundException
    //   5	11	67	java/security/NoSuchAlgorithmException
    //   91	95	97	java/io/IOException
    //   5	11	104	finally
    //   11	20	104	finally
    //   68	72	104	finally
    //   58	62	117	java/io/IOException
    //   5	11	123	java/io/IOException
    //   11	20	123	java/io/IOException
    //   68	72	123	java/io/IOException
    //   133	137	139	java/io/IOException
    //   111	115	145	java/io/IOException
    //   20	26	153	finally
    //   26	33	153	finally
    //   39	47	153	finally
    //   77	85	153	finally
    //   20	26	157	java/io/IOException
    //   26	33	157	java/io/IOException
    //   39	47	157	java/io/IOException
    //   77	85	157	java/io/IOException
    //   5	11	161	java/io/FileNotFoundException
    //   11	20	161	java/io/FileNotFoundException
    //   68	72	161	java/io/FileNotFoundException
  }
  
  public static String getMD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString);
      paramString = ByteUtils.byteToHexString(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static byte[] getMD5(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        if (localMessageDigest != null)
        {
          byte[] arrayOfByte = new byte[' '];
          for (;;)
          {
            int i = paramInputStream.read(arrayOfByte);
            if (i == -1) {
              break;
            }
            localMessageDigest.update(arrayOfByte, 0, i);
          }
          paramInputStream = localMessageDigest.digest();
          return paramInputStream;
        }
      }
      catch (Throwable paramInputStream) {}
    }
    return null;
  }
  
  public static byte[] getMD5(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\utils\Md5Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */