package com.tencent.qqprotect.singleupdate;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5FileUtil
{
  protected static MessageDigest a;
  protected static char[] a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    try
    {
      jdField_a_of_type_JavaSecurityMessageDigest = MessageDigest.getInstance("MD5");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
  }
  
  public static String a(File paramFile)
  {
    FileInputStream localFileInputStream;
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.length() > 0L)) {
      try
      {
        localFileInputStream = new FileInputStream(paramFile);
        long l1 = paramFile.length();
        paramFile = new byte['က'];
        while (l1 > 0L)
        {
          long l3 = localFileInputStream.read(paramFile);
          if (l3 != -1L)
          {
            long l2 = l3;
            if (l3 > l1) {
              l2 = l1;
            }
            l1 -= l2;
            jdField_a_of_type_JavaSecurityMessageDigest.update(ByteBuffer.wrap(paramFile, 0, (int)l2));
            continue;
            return null;
          }
        }
      }
      catch (Throwable paramFile)
      {
        paramFile.printStackTrace();
      }
    }
    do
    {
      localFileInputStream.close();
      paramFile = jdField_a_of_type_JavaSecurityMessageDigest.digest();
    } while (paramFile == null);
    paramFile = b(paramFile);
    return paramFile;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc2_w 105
    //   3: lstore 7
    //   5: aconst_null
    //   6: astore_3
    //   7: ldc 37
    //   9: invokestatic 43	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   12: astore 4
    //   14: new 64	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 109	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload_2
    //   24: astore_1
    //   25: new 54	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: invokevirtual 62	java/io/File:length	()J
    //   36: lstore 9
    //   38: lload 9
    //   40: ldc2_w 105
    //   43: lcmp
    //   44: ifle +242 -> 286
    //   47: aload_2
    //   48: astore_1
    //   49: sipush 4096
    //   52: newarray <illegal type>
    //   54: astore_0
    //   55: lload 7
    //   57: lconst_0
    //   58: lcmp
    //   59: ifle +79 -> 138
    //   62: aload_2
    //   63: astore_1
    //   64: aload_2
    //   65: aload_0
    //   66: invokevirtual 113	java/io/InputStream:read	([B)I
    //   69: istore 6
    //   71: iload 6
    //   73: iconst_m1
    //   74: if_icmpeq +64 -> 138
    //   77: iload 6
    //   79: istore 5
    //   81: iload 6
    //   83: i2l
    //   84: lload 7
    //   86: lcmp
    //   87: ifle +8 -> 95
    //   90: lload 7
    //   92: l2i
    //   93: istore 5
    //   95: lload 7
    //   97: iload 5
    //   99: i2l
    //   100: lsub
    //   101: lstore 7
    //   103: aload_2
    //   104: astore_1
    //   105: aload 4
    //   107: aload_0
    //   108: iconst_0
    //   109: iload 5
    //   111: invokevirtual 116	java/security/MessageDigest:update	([BII)V
    //   114: goto -59 -> 55
    //   117: astore_0
    //   118: aload_2
    //   119: astore_1
    //   120: aload_0
    //   121: invokevirtual 117	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   124: aload_3
    //   125: astore_0
    //   126: aload_2
    //   127: ifnull +9 -> 136
    //   130: aload_2
    //   131: invokevirtual 118	java/io/InputStream:close	()V
    //   134: aload_3
    //   135: astore_0
    //   136: aload_0
    //   137: areturn
    //   138: aload_2
    //   139: astore_1
    //   140: aload_2
    //   141: invokevirtual 118	java/io/InputStream:close	()V
    //   144: aload_2
    //   145: astore_1
    //   146: aload 4
    //   148: invokevirtual 93	java/security/MessageDigest:digest	()[B
    //   151: invokestatic 97	com/tencent/qqprotect/singleupdate/MD5FileUtil:b	([B)Ljava/lang/String;
    //   154: astore_0
    //   155: aload_0
    //   156: astore_1
    //   157: aload_1
    //   158: astore_0
    //   159: aload_2
    //   160: ifnull -24 -> 136
    //   163: aload_2
    //   164: invokevirtual 118	java/io/InputStream:close	()V
    //   167: aload_1
    //   168: areturn
    //   169: astore_0
    //   170: aload_1
    //   171: areturn
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_2
    //   175: aload_2
    //   176: astore_1
    //   177: aload_0
    //   178: invokevirtual 119	java/io/FileNotFoundException:printStackTrace	()V
    //   181: aload_3
    //   182: astore_0
    //   183: aload_2
    //   184: ifnull -48 -> 136
    //   187: aload_2
    //   188: invokevirtual 118	java/io/InputStream:close	()V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_0
    //   194: aconst_null
    //   195: areturn
    //   196: astore_0
    //   197: aconst_null
    //   198: astore_2
    //   199: aload_2
    //   200: astore_1
    //   201: aload_0
    //   202: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   205: aload_3
    //   206: astore_0
    //   207: aload_2
    //   208: ifnull -72 -> 136
    //   211: aload_2
    //   212: invokevirtual 118	java/io/InputStream:close	()V
    //   215: aconst_null
    //   216: areturn
    //   217: astore_0
    //   218: aconst_null
    //   219: areturn
    //   220: astore_0
    //   221: aconst_null
    //   222: astore_2
    //   223: aload_2
    //   224: astore_1
    //   225: aload_0
    //   226: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   229: aload_3
    //   230: astore_0
    //   231: aload_2
    //   232: ifnull -96 -> 136
    //   235: aload_2
    //   236: invokevirtual 118	java/io/InputStream:close	()V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_0
    //   242: aconst_null
    //   243: areturn
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_1
    //   247: aload_1
    //   248: ifnull +7 -> 255
    //   251: aload_1
    //   252: invokevirtual 118	java/io/InputStream:close	()V
    //   255: aload_0
    //   256: athrow
    //   257: astore_0
    //   258: aconst_null
    //   259: areturn
    //   260: astore_1
    //   261: goto -6 -> 255
    //   264: astore_0
    //   265: goto -18 -> 247
    //   268: astore_0
    //   269: goto -46 -> 223
    //   272: astore_0
    //   273: goto -74 -> 199
    //   276: astore_0
    //   277: goto -102 -> 175
    //   280: astore_0
    //   281: aconst_null
    //   282: astore_2
    //   283: goto -165 -> 118
    //   286: lload 9
    //   288: lstore 7
    //   290: goto -243 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramString	String
    //   24	228	1	localObject1	Object
    //   260	1	1	localException	Exception
    //   22	261	2	localFileInputStream	FileInputStream
    //   6	224	3	localObject2	Object
    //   12	135	4	localMessageDigest	MessageDigest
    //   79	31	5	i	int
    //   69	13	6	j	int
    //   3	286	7	l1	long
    //   36	251	9	l2	long
    // Exception table:
    //   from	to	target	type
    //   25	38	117	java/security/NoSuchAlgorithmException
    //   49	55	117	java/security/NoSuchAlgorithmException
    //   64	71	117	java/security/NoSuchAlgorithmException
    //   105	114	117	java/security/NoSuchAlgorithmException
    //   140	144	117	java/security/NoSuchAlgorithmException
    //   146	155	117	java/security/NoSuchAlgorithmException
    //   163	167	169	java/lang/Exception
    //   7	23	172	java/io/FileNotFoundException
    //   187	191	193	java/lang/Exception
    //   7	23	196	java/io/IOException
    //   211	215	217	java/lang/Exception
    //   7	23	220	java/lang/Throwable
    //   235	239	241	java/lang/Exception
    //   7	23	244	finally
    //   130	134	257	java/lang/Exception
    //   251	255	260	java/lang/Exception
    //   25	38	264	finally
    //   49	55	264	finally
    //   64	71	264	finally
    //   105	114	264	finally
    //   120	124	264	finally
    //   140	144	264	finally
    //   146	155	264	finally
    //   177	181	264	finally
    //   201	205	264	finally
    //   225	229	264	finally
    //   25	38	268	java/lang/Throwable
    //   49	55	268	java/lang/Throwable
    //   64	71	268	java/lang/Throwable
    //   105	114	268	java/lang/Throwable
    //   140	144	268	java/lang/Throwable
    //   146	155	268	java/lang/Throwable
    //   25	38	272	java/io/IOException
    //   49	55	272	java/io/IOException
    //   64	71	272	java/io/IOException
    //   105	114	272	java/io/IOException
    //   140	144	272	java/io/IOException
    //   146	155	272	java/io/IOException
    //   25	38	276	java/io/FileNotFoundException
    //   49	55	276	java/io/FileNotFoundException
    //   64	71	276	java/io/FileNotFoundException
    //   105	114	276	java/io/FileNotFoundException
    //   140	144	276	java/io/FileNotFoundException
    //   146	155	276	java/io/FileNotFoundException
    //   7	23	280	java/security/NoSuchAlgorithmException
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    jdField_a_of_type_JavaSecurityMessageDigest.update(paramArrayOfByte);
    return b(jdField_a_of_type_JavaSecurityMessageDigest.digest());
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      a(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    char c1 = jdField_a_of_type_ArrayOfChar[((paramByte & 0xF0) >> 4)];
    char c2 = jdField_a_of_type_ArrayOfChar[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return b(paramString1).equals(paramString2);
  }
  
  public static String b(String paramString)
  {
    return a(paramString.getBytes());
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\qqprotect\singleupdate\MD5FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */