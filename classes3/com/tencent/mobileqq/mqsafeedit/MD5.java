package com.tencent.mobileqq.mqsafeedit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  private byte[] buffer = new byte[64];
  private byte[] digest = new byte[16];
  public String digestHexStr;
  
  static {}
  
  public static long b2iu(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte & 0xFF;
    }
    return i;
  }
  
  public static String byteHEX(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    return new String(new char[] { arrayOfChar[(paramByte >>> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  public static byte[] getFileMd5(String paramString)
  {
    arrayOfByte2 = (byte[])null;
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      File localFile = new File(paramString);
      arrayOfByte1 = arrayOfByte2;
      if (localFile.exists()) {
        arrayOfByte1 = getPartfileMd5(paramString, localFile.length());
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        byte[] arrayOfByte1 = arrayOfByte2;
      }
    }
    return arrayOfByte1;
  }
  
  /* Error */
  public static byte[] getPartfileMd5(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +16 -> 17
    //   4: aload_0
    //   5: invokevirtual 58	java/lang/String:length	()I
    //   8: ifeq +9 -> 17
    //   11: lload_1
    //   12: lconst_0
    //   13: lcmp
    //   14: ifge +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: aconst_null
    //   20: checkcast 54	[B
    //   23: astore 5
    //   25: aconst_null
    //   26: astore_3
    //   27: aconst_null
    //   28: astore 6
    //   30: new 81	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   38: astore 4
    //   40: new 60	java/io/File
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   48: astore_0
    //   49: aload_0
    //   50: invokevirtual 67	java/io/File:exists	()Z
    //   53: ifeq +50 -> 103
    //   56: aload_0
    //   57: invokevirtual 70	java/io/File:length	()J
    //   60: lstore 9
    //   62: lload_1
    //   63: lconst_0
    //   64: lcmp
    //   65: ifeq +143 -> 208
    //   68: lload_1
    //   69: lstore 7
    //   71: lload 9
    //   73: lload_1
    //   74: lcmp
    //   75: ifge +6 -> 81
    //   78: goto +130 -> 208
    //   81: aload 4
    //   83: lload 7
    //   85: invokestatic 86	com/tencent/mobileqq/mqsafeedit/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   88: astore_0
    //   89: aload 4
    //   91: ifnull +95 -> 186
    //   94: aload 4
    //   96: invokevirtual 89	java/io/FileInputStream:close	()V
    //   99: aload_0
    //   100: astore_3
    //   101: aload_3
    //   102: areturn
    //   103: aload 4
    //   105: ifnull -88 -> 17
    //   108: aload 4
    //   110: invokevirtual 89	java/io/FileInputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   120: aconst_null
    //   121: areturn
    //   122: astore 4
    //   124: aload 6
    //   126: astore_0
    //   127: aload_0
    //   128: astore_3
    //   129: aload 4
    //   131: invokevirtual 77	java/lang/Exception:printStackTrace	()V
    //   134: aload 5
    //   136: astore_3
    //   137: aload_0
    //   138: ifnull -37 -> 101
    //   141: aload_0
    //   142: invokevirtual 89	java/io/FileInputStream:close	()V
    //   145: aload 5
    //   147: astore_3
    //   148: goto -47 -> 101
    //   151: astore_0
    //   152: aload_0
    //   153: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   156: aload 5
    //   158: astore_3
    //   159: goto -58 -> 101
    //   162: astore_0
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 89	java/io/FileInputStream:close	()V
    //   171: aload_0
    //   172: athrow
    //   173: astore_3
    //   174: aload_3
    //   175: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   178: goto -7 -> 171
    //   181: astore_3
    //   182: aload_3
    //   183: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   186: aload_0
    //   187: astore_3
    //   188: goto -87 -> 101
    //   191: astore_0
    //   192: aload 4
    //   194: astore_3
    //   195: goto -32 -> 163
    //   198: astore_3
    //   199: aload 4
    //   201: astore_0
    //   202: aload_3
    //   203: astore 4
    //   205: goto -78 -> 127
    //   208: lload 9
    //   210: lstore 7
    //   212: goto -131 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramString	String
    //   0	215	1	paramLong	long
    //   26	142	3	localObject1	Object
    //   173	2	3	localIOException1	IOException
    //   181	2	3	localIOException2	IOException
    //   187	8	3	localObject2	Object
    //   198	5	3	localException1	Exception
    //   38	71	4	localFileInputStream	java.io.FileInputStream
    //   122	78	4	localException2	Exception
    //   203	1	4	localException3	Exception
    //   23	134	5	arrayOfByte	byte[]
    //   28	97	6	localObject3	Object
    //   69	142	7	l1	long
    //   60	149	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   108	113	115	java/io/IOException
    //   30	40	122	java/lang/Exception
    //   141	145	151	java/io/IOException
    //   30	40	162	finally
    //   129	134	162	finally
    //   167	171	173	java/io/IOException
    //   94	99	181	java/io/IOException
    //   40	62	191	finally
    //   81	89	191	finally
    //   40	62	198	java/lang/Exception
    //   81	89	198	java/lang/Exception
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
    //   12: ldc 96
    //   14: invokestatic 102	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   17: astore_3
    //   18: ldc 112
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
    //   36: iflt +12 -> 48
    //   39: aload_0
    //   40: invokevirtual 115	java/io/InputStream:close	()V
    //   43: aload_3
    //   44: invokevirtual 109	java/security/MessageDigest:digest	()[B
    //   47: areturn
    //   48: aload 4
    //   50: arraylength
    //   51: i2l
    //   52: lload 6
    //   54: ladd
    //   55: lload_1
    //   56: lcmp
    //   57: ifle +10 -> 67
    //   60: lload_1
    //   61: lload 6
    //   63: lsub
    //   64: l2i
    //   65: istore 5
    //   67: aload_0
    //   68: aload 4
    //   70: iconst_0
    //   71: iload 5
    //   73: invokevirtual 119	java/io/InputStream:read	([BII)I
    //   76: istore 5
    //   78: iload 5
    //   80: iflt -70 -> 10
    //   83: aload_3
    //   84: aload 4
    //   86: iconst_0
    //   87: iload 5
    //   89: invokevirtual 106	java/security/MessageDigest:update	([BII)V
    //   92: lload 6
    //   94: iload 5
    //   96: i2l
    //   97: ladd
    //   98: lstore 6
    //   100: goto -68 -> 32
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 110	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 90	java/io/IOException:printStackTrace	()V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_0
    //   118: goto -75 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramInputStream	InputStream
    //   0	121	1	paramLong	long
    //   17	67	3	localMessageDigest	MessageDigest
    //   22	63	4	arrayOfByte	byte[]
    //   27	68	5	i	int
    //   30	69	6	l	long
    // Exception table:
    //   from	to	target	type
    //   12	29	103	java/security/NoSuchAlgorithmException
    //   39	43	103	java/security/NoSuchAlgorithmException
    //   43	48	103	java/security/NoSuchAlgorithmException
    //   48	60	103	java/security/NoSuchAlgorithmException
    //   67	78	103	java/security/NoSuchAlgorithmException
    //   83	92	103	java/security/NoSuchAlgorithmException
    //   12	29	110	java/io/IOException
    //   39	43	110	java/io/IOException
    //   43	48	110	java/io/IOException
    //   48	60	110	java/io/IOException
    //   67	78	110	java/io/IOException
    //   83	92	110	java/io/IOException
    //   39	43	117	java/lang/Exception
  }
  
  public static String toMD5(String paramString)
  {
    Object localObject = (byte[])null;
    if (paramString == null) {
      paramString = null;
    }
    do
    {
      return paramString;
      try
      {
        localObject = paramString.getBytes("ISO8859_1");
        paramString = (String)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          byte[] arrayOfByte;
          int i;
          paramString = paramString.getBytes();
        }
      }
      arrayOfByte = new MD5().getMD5(paramString, 0, paramString.length);
      localObject = "";
      paramString = (String)localObject;
    } while (arrayOfByte == null);
    i = 0;
    for (;;)
    {
      paramString = (String)localObject;
      if (i >= 16) {
        break;
      }
      localObject = localObject + byteHEX(arrayOfByte[i]);
      i += 1;
    }
  }
  
  public static String toMD5(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      localObject = null;
      return (String)localObject;
    }
    byte[] arrayOfByte = new MD5().getMD5(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = "";
    int i = 0;
    for (;;)
    {
      localObject = paramArrayOfByte;
      if (i >= 16) {
        break;
      }
      paramArrayOfByte = paramArrayOfByte + byteHEX(arrayOfByte[i]);
      i += 1;
    }
  }
  
  public static byte[] toMD5Byte(InputStream paramInputStream, long paramLong)
  {
    return new MD5().getMD5(paramInputStream, paramLong);
  }
  
  public static byte[] toMD5Byte(String paramString)
  {
    byte[] arrayOfByte = (byte[])null;
    if (paramString == null) {
      return null;
    }
    try
    {
      arrayOfByte = paramString.getBytes("ISO8859_1");
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
            byte[] arrayOfByte1 = (byte[])null;
            arrayOfByte1 = sysGetStremMd5(paramInputStream, l1);
            if (arrayOfByte1 == null) {
              break label120;
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
      label120:
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
    byte[] arrayOfByte = (byte[])null;
    arrayOfByte = sysGetBufferMd5(paramArrayOfByte, paramInt1, paramInt2);
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


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\mqsafeedit\MD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */