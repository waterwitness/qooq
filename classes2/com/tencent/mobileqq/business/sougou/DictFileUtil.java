package com.tencent.mobileqq.business.sougou;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class DictFileUtil
{
  public static final int a = 1024;
  public static final String a = ".business.sougou.UncompressFileGZIP";
  public static final int b = 30720;
  
  public DictFileUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int k = 0;
    if (paramArrayOfByte.length != 4) {
      return k;
    }
    int j = 3;
    for (;;)
    {
      k = i;
      if (j < 0) {
        break;
      }
      k = paramArrayOfByte[j];
      j -= 1;
      i = k & 0xFF | i << 8;
    }
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 33
    //   2: invokestatic 39	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_1
    //   6: new 41	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: new 46	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_0
    //   24: sipush 30720
    //   27: newarray <illegal type>
    //   29: astore_2
    //   30: aload_0
    //   31: aload_2
    //   32: invokevirtual 52	java/io/FileInputStream:read	([B)I
    //   35: istore_3
    //   36: iload_3
    //   37: ifge +27 -> 64
    //   40: aload_0
    //   41: invokevirtual 55	java/io/FileInputStream:close	()V
    //   44: aload_1
    //   45: invokevirtual 59	java/security/MessageDigest:digest	()[B
    //   48: invokestatic 64	com/tencent/qqprotect/singleupdate/MD5FileUtil:b	([B)Ljava/lang/String;
    //   51: areturn
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 67	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   57: ldc 69
    //   59: areturn
    //   60: astore_0
    //   61: ldc 69
    //   63: areturn
    //   64: aload_1
    //   65: aload_2
    //   66: iconst_0
    //   67: iload_3
    //   68: invokevirtual 73	java/security/MessageDigest:update	([BII)V
    //   71: goto -41 -> 30
    //   74: astore_1
    //   75: aload_1
    //   76: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   79: aload_0
    //   80: invokevirtual 55	java/io/FileInputStream:close	()V
    //   83: ldc 69
    //   85: areturn
    //   86: astore_0
    //   87: aload_0
    //   88: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   91: ldc 69
    //   93: areturn
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   99: goto -55 -> 44
    //   102: astore_1
    //   103: aload_0
    //   104: invokevirtual 55	java/io/FileInputStream:close	()V
    //   107: aload_1
    //   108: athrow
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 74	java/io/IOException:printStackTrace	()V
    //   114: goto -7 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   5	60	1	localMessageDigest	java.security.MessageDigest
    //   74	2	1	localIOException	java.io.IOException
    //   102	6	1	localObject	Object
    //   29	37	2	arrayOfByte	byte[]
    //   35	33	3	i	int
    // Exception table:
    //   from	to	target	type
    //   0	6	52	java/security/NoSuchAlgorithmException
    //   15	24	60	java/io/FileNotFoundException
    //   24	30	74	java/io/IOException
    //   30	36	74	java/io/IOException
    //   64	71	74	java/io/IOException
    //   79	83	86	java/io/IOException
    //   40	44	94	java/io/IOException
    //   24	30	102	finally
    //   30	36	102	finally
    //   64	71	102	finally
    //   75	79	102	finally
    //   103	107	109	java/io/IOException
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 77	com/tencent/mobileqq/business/sougou/DictFileUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4: ldc 79
    //   6: invokevirtual 85	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   9: ifne +19 -> 28
    //   12: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +11 -> 26
    //   18: ldc 10
    //   20: iconst_2
    //   21: ldc 93
    //   23: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: new 99	java/io/FileOutputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   36: astore_3
    //   37: aconst_null
    //   38: astore_2
    //   39: new 102	java/util/zip/GZIPInputStream
    //   42: dup
    //   43: new 46	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   51: invokespecial 106	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: astore_0
    //   55: aload_0
    //   56: astore_2
    //   57: sipush 1024
    //   60: newarray <illegal type>
    //   62: astore 4
    //   64: aload_0
    //   65: astore_2
    //   66: aload_0
    //   67: aload 4
    //   69: invokevirtual 107	java/util/zip/GZIPInputStream:read	([B)I
    //   72: istore 5
    //   74: iload 5
    //   76: ifle +108 -> 184
    //   79: aload_0
    //   80: astore_2
    //   81: aload_3
    //   82: aload 4
    //   84: iconst_0
    //   85: iload 5
    //   87: invokevirtual 110	java/io/FileOutputStream:write	([BII)V
    //   90: goto -26 -> 64
    //   93: astore_2
    //   94: aload_0
    //   95: astore_2
    //   96: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +30 -> 129
    //   102: aload_0
    //   103: astore_2
    //   104: ldc 10
    //   106: iconst_2
    //   107: new 112	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   114: ldc 115
    //   116: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 124	java/util/zip/GZIPInputStream:close	()V
    //   137: aload_3
    //   138: ifnull -112 -> 26
    //   141: aload_3
    //   142: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_0
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq -128 -> 26
    //   157: ldc 10
    //   159: iconst_2
    //   160: new 112	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   167: ldc 115
    //   169: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_1
    //   173: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: iconst_0
    //   183: ireturn
    //   184: aload_0
    //   185: ifnull +7 -> 192
    //   188: aload_0
    //   189: invokevirtual 124	java/util/zip/GZIPInputStream:close	()V
    //   192: aload_3
    //   193: ifnull +7 -> 200
    //   196: aload_3
    //   197: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   200: iconst_1
    //   201: ireturn
    //   202: astore_0
    //   203: aload_2
    //   204: astore_0
    //   205: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   208: ifeq +11 -> 219
    //   211: ldc 10
    //   213: iconst_2
    //   214: ldc 127
    //   216: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_0
    //   220: ifnull +7 -> 227
    //   223: aload_0
    //   224: invokevirtual 124	java/util/zip/GZIPInputStream:close	()V
    //   227: aload_3
    //   228: ifnull -202 -> 26
    //   231: aload_3
    //   232: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   235: iconst_0
    //   236: ireturn
    //   237: astore_0
    //   238: iconst_0
    //   239: ireturn
    //   240: astore_0
    //   241: aconst_null
    //   242: astore_2
    //   243: aload_2
    //   244: ifnull +7 -> 251
    //   247: aload_2
    //   248: invokevirtual 124	java/util/zip/GZIPInputStream:close	()V
    //   251: aload_3
    //   252: ifnull +7 -> 259
    //   255: aload_3
    //   256: invokevirtual 125	java/io/FileOutputStream:close	()V
    //   259: aload_0
    //   260: athrow
    //   261: astore_0
    //   262: goto -70 -> 192
    //   265: astore_0
    //   266: goto -66 -> 200
    //   269: astore_0
    //   270: goto -133 -> 137
    //   273: astore_0
    //   274: goto -47 -> 227
    //   277: astore_1
    //   278: goto -27 -> 251
    //   281: astore_1
    //   282: goto -23 -> 259
    //   285: astore_0
    //   286: goto -43 -> 243
    //   289: astore_1
    //   290: aload_0
    //   291: astore_2
    //   292: aload_1
    //   293: astore_0
    //   294: goto -51 -> 243
    //   297: astore_1
    //   298: goto -93 -> 205
    //   301: astore_0
    //   302: aconst_null
    //   303: astore_0
    //   304: goto -210 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramString1	String
    //   0	307	1	paramString2	String
    //   38	43	2	str1	String
    //   93	1	2	localFileNotFoundException	java.io.FileNotFoundException
    //   95	197	2	str2	String
    //   36	220	3	localFileOutputStream	java.io.FileOutputStream
    //   62	21	4	arrayOfByte	byte[]
    //   72	14	5	i	int
    // Exception table:
    //   from	to	target	type
    //   57	64	93	java/io/FileNotFoundException
    //   66	74	93	java/io/FileNotFoundException
    //   81	90	93	java/io/FileNotFoundException
    //   141	145	147	java/io/IOException
    //   28	37	150	java/io/FileNotFoundException
    //   39	55	202	java/io/IOException
    //   231	235	237	java/io/IOException
    //   39	55	240	finally
    //   188	192	261	java/io/IOException
    //   196	200	265	java/io/IOException
    //   133	137	269	java/io/IOException
    //   223	227	273	java/io/IOException
    //   247	251	277	java/io/IOException
    //   255	259	281	java/io/IOException
    //   57	64	285	finally
    //   66	74	285	finally
    //   81	90	285	finally
    //   96	102	285	finally
    //   104	129	285	finally
    //   205	219	289	finally
    //   57	64	297	java/io/IOException
    //   66	74	297	java/io/IOException
    //   81	90	297	java/io/IOException
    //   39	55	301	java/io/FileNotFoundException
  }
  
  public static String b(String paramString)
  {
    String str2 = "";
    int i = paramString.lastIndexOf('.');
    String str1 = str2;
    if (i > 0)
    {
      str1 = str2;
      if (i < paramString.length() - 1) {
        str1 = paramString.substring(i + 1);
      }
    }
    return str1;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\business\sougou\DictFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */