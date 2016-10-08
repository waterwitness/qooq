package com.tencent.qphone.base.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  static final char[] Digit = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private byte[] buffer = new byte[64];
  private byte[] digest = new byte[16];
  public String digestHexStr;
  
  static
  {
    CodecWarpper.loadSo();
  }
  
  public static long b2iu(byte paramByte)
  {
    if (paramByte < 0) {
      return paramByte & 0xFF;
    }
    return paramByte;
  }
  
  public static String byteHEX(byte paramByte)
  {
    return new String(new char[] { Digit[(paramByte >>> 4 & 0xF)], Digit[(paramByte & 0xF)] });
  }
  
  public static byte[] getFileMd5(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return null;
      try
      {
        File localFile = new File(paramString);
        if (localFile.exists())
        {
          paramString = getPartfileMd5(paramString, localFile.length());
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  /* Error */
  public static byte[] getPartfileMd5(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload 7
    //   8: astore_3
    //   9: aload_0
    //   10: ifnull +22 -> 32
    //   13: aload 7
    //   15: astore_3
    //   16: aload_0
    //   17: invokevirtual 61	java/lang/String:length	()I
    //   20: ifeq +12 -> 32
    //   23: lload_1
    //   24: lconst_0
    //   25: lcmp
    //   26: ifge +8 -> 34
    //   29: aload 7
    //   31: astore_3
    //   32: aload_3
    //   33: areturn
    //   34: new 84	java/io/FileInputStream
    //   37: dup
    //   38: aload_0
    //   39: invokespecial 85	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   42: astore 4
    //   44: aload 4
    //   46: astore_3
    //   47: new 63	java/io/File
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_0
    //   56: aload 4
    //   58: astore_3
    //   59: aload_0
    //   60: invokevirtual 70	java/io/File:exists	()Z
    //   63: ifeq +115 -> 178
    //   66: aload 4
    //   68: astore_3
    //   69: aload_0
    //   70: invokevirtual 73	java/io/File:length	()J
    //   73: lstore 10
    //   75: lload_1
    //   76: lconst_0
    //   77: lcmp
    //   78: ifeq +134 -> 212
    //   81: lload_1
    //   82: lstore 8
    //   84: lload 10
    //   86: lload_1
    //   87: lcmp
    //   88: ifge +6 -> 94
    //   91: goto +121 -> 212
    //   94: aload 4
    //   96: astore_3
    //   97: aload 4
    //   99: lload 8
    //   101: invokestatic 89	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   104: astore_0
    //   105: aload_0
    //   106: astore_3
    //   107: aload 4
    //   109: ifnull -77 -> 32
    //   112: aload 4
    //   114: invokevirtual 92	java/io/FileInputStream:close	()V
    //   117: aload_0
    //   118: areturn
    //   119: astore_3
    //   120: aload_3
    //   121: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   124: aload_0
    //   125: areturn
    //   126: astore 5
    //   128: aconst_null
    //   129: astore_0
    //   130: aload_0
    //   131: astore_3
    //   132: aload 5
    //   134: invokevirtual 80	java/lang/Exception:printStackTrace	()V
    //   137: aload 7
    //   139: astore_3
    //   140: aload_0
    //   141: ifnull -109 -> 32
    //   144: aload_0
    //   145: invokevirtual 92	java/io/FileInputStream:close	()V
    //   148: aconst_null
    //   149: areturn
    //   150: astore_3
    //   151: aload 6
    //   153: astore_0
    //   154: goto -34 -> 120
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_3
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 92	java/io/FileInputStream:close	()V
    //   168: aload_0
    //   169: athrow
    //   170: astore_3
    //   171: aload_3
    //   172: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   175: goto -7 -> 168
    //   178: aload 7
    //   180: astore_3
    //   181: aload 4
    //   183: ifnull -151 -> 32
    //   186: aload 4
    //   188: invokevirtual 92	java/io/FileInputStream:close	()V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_3
    //   194: aload 6
    //   196: astore_0
    //   197: goto -77 -> 120
    //   200: astore_0
    //   201: goto -41 -> 160
    //   204: astore 5
    //   206: aload 4
    //   208: astore_0
    //   209: goto -79 -> 130
    //   212: lload 10
    //   214: lstore 8
    //   216: goto -122 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramString	String
    //   0	219	1	paramLong	long
    //   8	99	3	localObject1	Object
    //   119	2	3	localIOException1	IOException
    //   131	9	3	localObject2	Object
    //   150	1	3	localIOException2	IOException
    //   159	6	3	localObject3	Object
    //   170	2	3	localIOException3	IOException
    //   180	1	3	localObject4	Object
    //   193	1	3	localIOException4	IOException
    //   42	165	4	localFileInputStream	java.io.FileInputStream
    //   126	7	5	localException1	Exception
    //   204	1	5	localException2	Exception
    //   1	194	6	localObject5	Object
    //   4	175	7	localObject6	Object
    //   82	133	8	l1	long
    //   73	140	10	l2	long
    // Exception table:
    //   from	to	target	type
    //   112	117	119	java/io/IOException
    //   34	44	126	java/lang/Exception
    //   144	148	150	java/io/IOException
    //   34	44	157	finally
    //   164	168	170	java/io/IOException
    //   186	191	193	java/io/IOException
    //   47	56	200	finally
    //   59	66	200	finally
    //   69	75	200	finally
    //   97	105	200	finally
    //   132	137	200	finally
    //   47	56	204	java/lang/Exception
    //   59	66	204	java/lang/Exception
    //   69	75	204	java/lang/Exception
    //   97	105	204	java/lang/Exception
  }
  
  public static byte[] sysGetBufferMd5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0)) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static byte[] sysGetStremMd5(InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +9 -> 10
    //   4: lload_1
    //   5: lconst_0
    //   6: lcmp
    //   7: ifne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: ldc 99
    //   14: invokestatic 105	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   17: astore_3
    //   18: ldc 115
    //   20: newarray <illegal type>
    //   22: astore 4
    //   24: aload 4
    //   26: arraylength
    //   27: istore 5
    //   29: lconst_0
    //   30: lstore 6
    //   32: lload 6
    //   34: lload_1
    //   35: lcmp
    //   36: ifge +58 -> 94
    //   39: aload 4
    //   41: arraylength
    //   42: i2l
    //   43: lload 6
    //   45: ladd
    //   46: lload_1
    //   47: lcmp
    //   48: ifle +10 -> 58
    //   51: lload_1
    //   52: lload 6
    //   54: lsub
    //   55: l2i
    //   56: istore 5
    //   58: aload_0
    //   59: aload 4
    //   61: iconst_0
    //   62: iload 5
    //   64: invokevirtual 121	java/io/InputStream:read	([BII)I
    //   67: istore 5
    //   69: iload 5
    //   71: iflt -61 -> 10
    //   74: aload_3
    //   75: aload 4
    //   77: iconst_0
    //   78: iload 5
    //   80: invokevirtual 109	java/security/MessageDigest:update	([BII)V
    //   83: lload 6
    //   85: iload 5
    //   87: i2l
    //   88: ladd
    //   89: lstore 6
    //   91: goto -59 -> 32
    //   94: aload_0
    //   95: invokevirtual 122	java/io/InputStream:close	()V
    //   98: aload_3
    //   99: invokevirtual 112	java/security/MessageDigest:digest	()[B
    //   102: astore_0
    //   103: aload_0
    //   104: areturn
    //   105: astore_0
    //   106: aload_0
    //   107: invokevirtual 113	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_0
    //   113: aload_0
    //   114: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: goto -22 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramInputStream	InputStream
    //   0	123	1	paramLong	long
    //   17	82	3	localMessageDigest	MessageDigest
    //   22	54	4	arrayOfByte	byte[]
    //   27	59	5	i	int
    //   30	60	6	l	long
    // Exception table:
    //   from	to	target	type
    //   12	29	105	java/security/NoSuchAlgorithmException
    //   39	51	105	java/security/NoSuchAlgorithmException
    //   58	69	105	java/security/NoSuchAlgorithmException
    //   74	83	105	java/security/NoSuchAlgorithmException
    //   94	98	105	java/security/NoSuchAlgorithmException
    //   98	103	105	java/security/NoSuchAlgorithmException
    //   12	29	112	java/io/IOException
    //   39	51	112	java/io/IOException
    //   58	69	112	java/io/IOException
    //   74	83	112	java/io/IOException
    //   94	98	112	java/io/IOException
    //   98	103	112	java/io/IOException
    //   94	98	119	java/lang/Exception
  }
  
  public static String toMD5(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      localObject = paramString.getBytes("ISO8859_1");
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject;
        paramString = paramString.getBytes();
      }
      int i = 0;
      while (i < 16)
      {
        localUnsupportedEncodingException.append(Digit[(paramString[i] >>> 4 & 0xF)]);
        localUnsupportedEncodingException.append(Digit[(paramString[i] & 0xF)]);
        i += 1;
      }
      return localUnsupportedEncodingException.toString();
    }
    paramString = new MD5().getMD5(paramString, 0, paramString.length);
    localObject = new StringBuilder(32);
    if (paramString == null) {
      return "";
    }
  }
  
  public static String toMD5(byte[] paramArrayOfByte)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    paramArrayOfByte = new MD5().getMD5(paramArrayOfByte, 0, paramArrayOfByte.length);
    StringBuilder localStringBuilder = new StringBuilder(32);
    while (i < 16)
    {
      localStringBuilder.append(Digit[(paramArrayOfByte[i] >>> 4 & 0xF)]);
      localStringBuilder.append(Digit[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] toMD5Byte(InputStream paramInputStream, long paramLong)
  {
    return new MD5().getMD5(paramInputStream, paramLong);
  }
  
  public static byte[] toMD5Byte(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
    }
    return new MD5().getMD5(paramString, 0, paramString.length);
  }
  
  public static byte[] toMD5Byte(byte[] paramArrayOfByte)
  {
    return toMD5Byte(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] toMD5Byte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new MD5().getMD5(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  native byte[] getBufferMd5(byte[] paramArrayOfByte);
  
  public byte[] getMD5(InputStream paramInputStream, long paramLong)
  {
    if ((paramInputStream == null) || (paramLong < 0L)) {}
    long l1;
    do
    {
      for (;;)
      {
        return null;
        try
        {
          long l2 = paramInputStream.available();
          if (paramLong != 0L)
          {
            l1 = paramLong;
            if (l2 != 0L)
            {
              l1 = paramLong;
              if (paramInputStream.available() >= paramLong) {}
            }
          }
          else
          {
            int i = paramInputStream.available();
            l1 = i;
          }
          if (l1 != 0L)
          {
            byte[] arrayOfByte1 = sysGetStremMd5(paramInputStream, l1);
            if (arrayOfByte1 == null) {
              break label114;
            }
            this.digest = arrayOfByte1;
            return this.digest;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    } while (paramInputStream == null);
    try
    {
      paramInputStream.close();
      return null;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    try
    {
      label114:
      byte[] arrayOfByte2 = getStremMd5(paramInputStream, l1);
      localObject = arrayOfByte2;
      paramInputStream.close();
      localObject = arrayOfByte2;
    }
    catch (Exception paramInputStream)
    {
      for (;;)
      {
        Object localObject;
        paramInputStream.printStackTrace();
      }
    }
    if (localObject != null)
    {
      this.digest = ((byte[])localObject);
      return this.digest;
    }
    return this.digest;
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0) || (paramInt1 < 0)) {
      return null;
    }
    byte[] arrayOfByte = sysGetBufferMd5(paramArrayOfByte, paramInt1, paramInt2);
    if (arrayOfByte != null)
    {
      this.digest = arrayOfByte;
      return this.digest;
    }
    try
    {
      paramArrayOfByte = getBufferMd5(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        this.digest = paramArrayOfByte;
        return this.digest;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = arrayOfByte;
      }
    }
    return this.digest;
  }
  
  native byte[] getStremMd5(InputStream paramInputStream, long paramLong);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\qphone\base\util\MD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */