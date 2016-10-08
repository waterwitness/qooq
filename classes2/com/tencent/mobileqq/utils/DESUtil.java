package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;

public class DESUtil
{
  private static final String a = "DESUtil";
  private static final String b = "ENCRYPT:";
  
  public DESUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static void a(File paramFile1, File paramFile2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 29	javax/crypto/spec/SecretKeySpec
    //   8: dup
    //   9: aload_2
    //   10: invokestatic 32	com/tencent/mobileqq/utils/DESUtil:a	([B)[B
    //   13: ldc 34
    //   15: invokespecial 37	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   18: astore 5
    //   20: ldc 34
    //   22: invokestatic 43	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   25: astore_2
    //   26: aload_2
    //   27: iconst_1
    //   28: aload 5
    //   30: invokevirtual 47	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   33: new 49	java/io/FileInputStream
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 52	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   41: astore 5
    //   43: new 54	java/io/FileOutputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   51: astore_0
    //   52: new 57	javax/crypto/CipherInputStream
    //   55: dup
    //   56: aload 5
    //   58: aload_2
    //   59: invokespecial 60	javax/crypto/CipherInputStream:<init>	(Ljava/io/InputStream;Ljavax/crypto/Cipher;)V
    //   62: astore_1
    //   63: sipush 1024
    //   66: newarray <illegal type>
    //   68: astore_2
    //   69: aload_0
    //   70: ldc 11
    //   72: ldc 62
    //   74: invokevirtual 68	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   77: invokevirtual 74	java/io/OutputStream:write	([B)V
    //   80: aload_1
    //   81: aload_2
    //   82: invokevirtual 78	javax/crypto/CipherInputStream:read	([B)I
    //   85: istore 6
    //   87: iload 6
    //   89: iconst_m1
    //   90: if_icmpeq +70 -> 160
    //   93: aload_0
    //   94: aload_2
    //   95: iconst_0
    //   96: iload 6
    //   98: invokevirtual 81	java/io/OutputStream:write	([BII)V
    //   101: goto -21 -> 80
    //   104: astore_3
    //   105: aload_0
    //   106: astore_2
    //   107: aload_3
    //   108: astore_0
    //   109: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +31 -> 143
    //   115: ldc 8
    //   117: iconst_2
    //   118: new 89	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   125: ldc 92
    //   127: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   134: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_1
    //   144: ifnull +7 -> 151
    //   147: aload_1
    //   148: invokevirtual 110	javax/crypto/CipherInputStream:close	()V
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 111	java/io/OutputStream:close	()V
    //   159: return
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 110	javax/crypto/CipherInputStream:close	()V
    //   168: aload_0
    //   169: ifnull -10 -> 159
    //   172: aload_0
    //   173: invokevirtual 111	java/io/OutputStream:close	()V
    //   176: return
    //   177: astore_0
    //   178: aload_0
    //   179: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   182: return
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   188: return
    //   189: astore_0
    //   190: aconst_null
    //   191: astore_1
    //   192: aload 4
    //   194: astore_2
    //   195: aload_1
    //   196: ifnull +7 -> 203
    //   199: aload_1
    //   200: invokevirtual 110	javax/crypto/CipherInputStream:close	()V
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 111	java/io/OutputStream:close	()V
    //   211: aload_0
    //   212: athrow
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   218: goto -7 -> 211
    //   221: astore_3
    //   222: aconst_null
    //   223: astore_1
    //   224: aload_0
    //   225: astore_2
    //   226: aload_3
    //   227: astore_0
    //   228: goto -33 -> 195
    //   231: astore_3
    //   232: aload_0
    //   233: astore_2
    //   234: aload_3
    //   235: astore_0
    //   236: goto -41 -> 195
    //   239: astore_0
    //   240: goto -45 -> 195
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_1
    //   246: aload_3
    //   247: astore_2
    //   248: goto -139 -> 109
    //   251: astore_3
    //   252: aconst_null
    //   253: astore_1
    //   254: aload_0
    //   255: astore_2
    //   256: aload_3
    //   257: astore_0
    //   258: goto -149 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramFile1	File
    //   0	261	1	paramFile2	File
    //   0	261	2	paramArrayOfByte	byte[]
    //   4	1	3	localObject1	Object
    //   104	4	3	localException1	Exception
    //   221	6	3	localObject2	Object
    //   231	16	3	localObject3	Object
    //   251	6	3	localException2	Exception
    //   1	192	4	localObject4	Object
    //   18	39	5	localObject5	Object
    //   85	12	6	i	int
    // Exception table:
    //   from	to	target	type
    //   63	80	104	java/lang/Exception
    //   80	87	104	java/lang/Exception
    //   93	101	104	java/lang/Exception
    //   164	168	177	java/io/IOException
    //   172	176	177	java/io/IOException
    //   147	151	183	java/io/IOException
    //   155	159	183	java/io/IOException
    //   5	52	189	finally
    //   199	203	213	java/io/IOException
    //   207	211	213	java/io/IOException
    //   52	63	221	finally
    //   63	80	231	finally
    //   80	87	231	finally
    //   93	101	231	finally
    //   109	143	239	finally
    //   5	52	243	java/lang/Exception
    //   52	63	251	java/lang/Exception
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      if (a(paramString1))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DESUtil", 2, "encrypt had encrypt,file:" + paramString1);
        }
      }
      else
      {
        long l1 = System.currentTimeMillis();
        Object localObject = paramString1 + ".tmp";
        File localFile = new File(paramString1);
        long l2 = localFile.length() / 1024L;
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        a(localFile, (File)localObject, paramString2.getBytes("UTF-8"));
        FileUtils.a((File)localObject, localFile);
        ((File)localObject).delete();
        if (QLog.isDevelopLevel())
        {
          QLog.d("DESUtil", 4, "DES Encrypt filePath:" + paramString1 + ",key:" + paramString2 + ",costTime:" + (System.currentTimeMillis() - l1) + ",fileSize:" + l2 + "KB");
          return;
        }
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (a(paramString1))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DESUtil", 2, "encrypt had encrypt,file:" + paramString1);
        }
      }
      else
      {
        long l1 = System.currentTimeMillis();
        File localFile = new File(paramString1);
        long l2 = localFile.length() / 1024L;
        paramString2 = new File(paramString2);
        if (paramString2.exists()) {
          paramString2.delete();
        }
        a(localFile, paramString2, paramString3.getBytes("UTF-8"));
        localFile.delete();
        if (QLog.isDevelopLevel())
        {
          QLog.d("DESUtil", 4, "DES Encrypt filePath:" + paramString1 + ",key:" + paramString3 + ",costTime:" + (System.currentTimeMillis() - l1) + ",fileSize:" + l2 + "KB");
          return;
        }
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  /* Error */
  public static boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: new 49	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 172	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: astore_0
    //   14: ldc 11
    //   16: ldc 62
    //   18: invokevirtual 68	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   21: astore_2
    //   22: iconst_0
    //   23: istore_3
    //   24: aload_1
    //   25: astore_0
    //   26: iload_3
    //   27: aload_2
    //   28: arraylength
    //   29: if_icmpge +39 -> 68
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 177	java/io/InputStream:read	()I
    //   38: istore 4
    //   40: iload 4
    //   42: iconst_m1
    //   43: if_icmpeq +15 -> 58
    //   46: aload_2
    //   47: iload_3
    //   48: baload
    //   49: istore 5
    //   51: iload 4
    //   53: iload 5
    //   55: if_icmpeq +6 -> 61
    //   58: iconst_0
    //   59: istore 6
    //   61: iload_3
    //   62: iconst_1
    //   63: iadd
    //   64: istore_3
    //   65: goto -41 -> 24
    //   68: aload_1
    //   69: invokevirtual 178	java/io/InputStream:close	()V
    //   72: iload 6
    //   74: ireturn
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   80: iload 6
    //   82: ireturn
    //   83: astore_2
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: astore_0
    //   88: invokestatic 123	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   91: ifeq +33 -> 124
    //   94: aload_1
    //   95: astore_0
    //   96: ldc 8
    //   98: iconst_2
    //   99: new 89	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   106: ldc -76
    //   108: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_2
    //   112: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   115: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aload_1
    //   125: invokevirtual 178	java/io/InputStream:close	()V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   135: iconst_0
    //   136: ireturn
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 178	java/io/InputStream:close	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_0
    //   147: aload_0
    //   148: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   151: goto -7 -> 144
    //   154: astore_1
    //   155: goto -15 -> 140
    //   158: astore_2
    //   159: goto -73 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   11	114	1	localFileInputStream	java.io.FileInputStream
    //   137	8	1	localObject1	Object
    //   154	1	1	localObject2	Object
    //   21	26	2	arrayOfByte	byte[]
    //   83	29	2	localException1	Exception
    //   158	1	2	localException2	Exception
    //   23	42	3	i	int
    //   38	18	4	j	int
    //   49	7	5	k	int
    //   1	80	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   68	72	75	java/io/IOException
    //   3	12	83	java/lang/Exception
    //   124	128	130	java/io/IOException
    //   3	12	137	finally
    //   140	144	146	java/io/IOException
    //   14	22	154	finally
    //   26	32	154	finally
    //   34	40	154	finally
    //   88	94	154	finally
    //   96	124	154	finally
    //   14	22	158	java/lang/Exception
    //   26	32	158	java/lang/Exception
    //   34	40	158	java/lang/Exception
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[8];
    if (arrayOfByte.length > paramArrayOfByte.length)
    {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      return arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  /* Error */
  public static void b(File paramFile1, File paramFile2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 29	javax/crypto/spec/SecretKeySpec
    //   8: dup
    //   9: aload_2
    //   10: invokestatic 32	com/tencent/mobileqq/utils/DESUtil:a	([B)[B
    //   13: ldc 34
    //   15: invokespecial 37	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   18: astore_2
    //   19: ldc 34
    //   21: invokestatic 43	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   24: astore 5
    //   26: aload 5
    //   28: iconst_2
    //   29: aload_2
    //   30: invokevirtual 47	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   33: new 186	java/io/RandomAccessFile
    //   36: dup
    //   37: aload_0
    //   38: ldc -68
    //   40: invokespecial 191	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: astore_2
    //   44: aload_2
    //   45: ldc 11
    //   47: ldc 62
    //   49: invokevirtual 68	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   52: arraylength
    //   53: i2l
    //   54: invokevirtual 195	java/io/RandomAccessFile:seek	(J)V
    //   57: new 197	javax/crypto/CipherOutputStream
    //   60: dup
    //   61: new 54	java/io/FileOutputStream
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   69: aload 5
    //   71: invokespecial 200	javax/crypto/CipherOutputStream:<init>	(Ljava/io/OutputStream;Ljavax/crypto/Cipher;)V
    //   74: astore_0
    //   75: sipush 1024
    //   78: newarray <illegal type>
    //   80: astore_1
    //   81: aload_2
    //   82: aload_1
    //   83: invokevirtual 201	java/io/RandomAccessFile:read	([B)I
    //   86: istore 6
    //   88: iload 6
    //   90: iconst_m1
    //   91: if_icmpeq +70 -> 161
    //   94: aload_0
    //   95: aload_1
    //   96: iconst_0
    //   97: iload 6
    //   99: invokevirtual 202	javax/crypto/CipherOutputStream:write	([BII)V
    //   102: goto -21 -> 81
    //   105: astore_3
    //   106: aload_2
    //   107: astore_1
    //   108: aload_3
    //   109: astore_2
    //   110: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   113: ifeq +31 -> 144
    //   116: ldc 8
    //   118: iconst_2
    //   119: new 89	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   126: ldc -52
    //   128: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_2
    //   132: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_0
    //   145: ifnull +7 -> 152
    //   148: aload_0
    //   149: invokevirtual 205	javax/crypto/CipherOutputStream:close	()V
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 206	java/io/RandomAccessFile:close	()V
    //   160: return
    //   161: aload_0
    //   162: ifnull +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 205	javax/crypto/CipherOutputStream:close	()V
    //   169: aload_2
    //   170: ifnull -10 -> 160
    //   173: aload_2
    //   174: invokevirtual 206	java/io/RandomAccessFile:close	()V
    //   177: return
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   183: return
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   189: return
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_2
    //   193: aload_3
    //   194: astore_1
    //   195: aload_1
    //   196: ifnull +7 -> 203
    //   199: aload_1
    //   200: invokevirtual 205	javax/crypto/CipherOutputStream:close	()V
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 206	java/io/RandomAccessFile:close	()V
    //   211: aload_0
    //   212: athrow
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   218: goto -7 -> 211
    //   221: astore_0
    //   222: aload_3
    //   223: astore_1
    //   224: goto -29 -> 195
    //   227: astore_3
    //   228: aload_0
    //   229: astore_1
    //   230: aload_3
    //   231: astore_0
    //   232: goto -37 -> 195
    //   235: astore_3
    //   236: aload_1
    //   237: astore_2
    //   238: aload_0
    //   239: astore_1
    //   240: aload_3
    //   241: astore_0
    //   242: goto -47 -> 195
    //   245: astore_2
    //   246: aconst_null
    //   247: astore_0
    //   248: aload 4
    //   250: astore_1
    //   251: goto -141 -> 110
    //   254: astore_3
    //   255: aconst_null
    //   256: astore_0
    //   257: aload_2
    //   258: astore_1
    //   259: aload_3
    //   260: astore_2
    //   261: goto -151 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramFile1	File
    //   0	264	1	paramFile2	File
    //   0	264	2	paramArrayOfByte	byte[]
    //   1	1	3	localObject1	Object
    //   105	118	3	localException1	Exception
    //   227	4	3	localObject2	Object
    //   235	6	3	localObject3	Object
    //   254	6	3	localException2	Exception
    //   3	246	4	localObject4	Object
    //   24	46	5	localCipher	javax.crypto.Cipher
    //   86	12	6	i	int
    // Exception table:
    //   from	to	target	type
    //   75	81	105	java/lang/Exception
    //   81	88	105	java/lang/Exception
    //   94	102	105	java/lang/Exception
    //   165	169	178	java/io/IOException
    //   173	177	178	java/io/IOException
    //   148	152	184	java/io/IOException
    //   156	160	184	java/io/IOException
    //   5	44	190	finally
    //   199	203	213	java/io/IOException
    //   207	211	213	java/io/IOException
    //   44	75	221	finally
    //   75	81	227	finally
    //   81	88	227	finally
    //   94	102	227	finally
    //   110	144	235	finally
    //   5	44	245	java/lang/Exception
    //   44	75	254	java/lang/Exception
  }
  
  public static void b(String paramString1, String paramString2)
  {
    try
    {
      if (!a(paramString1))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DESUtil", 2, "decrypt had no encrypt,file:" + paramString1);
        }
      }
      else
      {
        long l1 = System.currentTimeMillis();
        Object localObject = paramString1 + ".tmp";
        File localFile = new File(paramString1);
        long l2 = localFile.length() / 1024L;
        localObject = new File((String)localObject);
        if (((File)localObject).exists()) {
          ((File)localObject).delete();
        }
        b(localFile, (File)localObject, paramString2.getBytes("UTF-8"));
        FileUtils.a((File)localObject, localFile);
        ((File)localObject).delete();
        if (QLog.isDevelopLevel())
        {
          QLog.d("DESUtil", 4, "DES Decrypt filePath:" + paramString1 + ",key:" + paramString2 + ",costTime:" + (System.currentTimeMillis() - l1) + ",fileSize:" + l2 + "KB");
          return;
        }
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\DESUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */