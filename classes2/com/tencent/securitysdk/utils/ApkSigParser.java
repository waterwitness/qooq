package com.tencent.securitysdk.utils;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ApkSigParser
{
  private static final String a = "resources.arsc";
  private static final String b = "AndroidManifest.xml";
  
  public ApkSigParser()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static String a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 29	java/util/jar/JarFile
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 32	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   12: astore_1
    //   13: sipush 8192
    //   16: newarray <illegal type>
    //   18: astore_3
    //   19: aload_1
    //   20: invokevirtual 36	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   23: astore 4
    //   25: aload_2
    //   26: astore_0
    //   27: aload 4
    //   29: invokeinterface 42 1 0
    //   34: ifeq +285 -> 319
    //   37: aload 4
    //   39: invokeinterface 46 1 0
    //   44: checkcast 48	java/util/jar/JarEntry
    //   47: astore_2
    //   48: aload_2
    //   49: invokevirtual 51	java/util/jar/JarEntry:isDirectory	()Z
    //   52: ifne -25 -> 27
    //   55: aload_2
    //   56: invokevirtual 55	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   59: ldc 57
    //   61: invokevirtual 63	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   64: ifne -37 -> 27
    //   67: aload_2
    //   68: invokevirtual 55	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   71: astore 5
    //   73: ldc 8
    //   75: aload 5
    //   77: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifne -53 -> 27
    //   83: ldc 11
    //   85: aload 5
    //   87: invokevirtual 67	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifne -63 -> 27
    //   93: aload_2
    //   94: invokevirtual 71	java/util/jar/JarEntry:getSize	()J
    //   97: ldc2_w 72
    //   100: lcmp
    //   101: ifgt -74 -> 27
    //   104: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   107: pop2
    //   108: aload_1
    //   109: aload_2
    //   110: invokevirtual 82	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   113: astore 5
    //   115: aload 5
    //   117: aload_3
    //   118: iconst_0
    //   119: aload_3
    //   120: arraylength
    //   121: invokevirtual 88	java/io/InputStream:read	([BII)I
    //   124: iconst_m1
    //   125: if_icmpne -10 -> 115
    //   128: aload 5
    //   130: invokevirtual 91	java/io/InputStream:close	()V
    //   133: aload_2
    //   134: invokevirtual 95	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   137: astore 5
    //   139: aload 5
    //   141: ifnull +9 -> 150
    //   144: aload 5
    //   146: arraylength
    //   147: ifne +59 -> 206
    //   150: new 97	java/lang/SecurityException
    //   153: dup
    //   154: new 99	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   161: ldc 102
    //   163: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_2
    //   167: invokevirtual 55	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   170: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokespecial 112	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   179: athrow
    //   180: astore_2
    //   181: aload_1
    //   182: astore_0
    //   183: aload_2
    //   184: astore_1
    //   185: aload_1
    //   186: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   189: aload_1
    //   190: athrow
    //   191: astore_2
    //   192: aload_0
    //   193: astore_1
    //   194: aload_2
    //   195: astore_0
    //   196: aload_1
    //   197: ifnull +7 -> 204
    //   200: aload_1
    //   201: invokevirtual 116	java/util/jar/JarFile:close	()V
    //   204: aload_0
    //   205: athrow
    //   206: aload_0
    //   207: ifnonnull +56 -> 263
    //   210: aload 5
    //   212: iconst_0
    //   213: aaload
    //   214: checkcast 118	java/security/cert/X509Certificate
    //   217: astore_2
    //   218: aload_2
    //   219: astore_0
    //   220: aload_2
    //   221: ifnull +42 -> 263
    //   224: aload_2
    //   225: ifnull +48 -> 273
    //   228: new 59	java/lang/String
    //   231: dup
    //   232: aload_2
    //   233: invokevirtual 122	java/security/cert/X509Certificate:getEncoded	()[B
    //   236: invokestatic 125	com/tencent/securitysdk/utils/ApkSigParser:a	([B)[C
    //   239: invokespecial 128	java/lang/String:<init>	([C)V
    //   242: invokevirtual 131	java/lang/String:getBytes	()[B
    //   245: invokestatic 136	com/tencent/securitysdk/utils/MD5:b	([B)Ljava/lang/String;
    //   248: astore_0
    //   249: aload_0
    //   250: astore_2
    //   251: aload_1
    //   252: ifnull +9 -> 261
    //   255: aload_1
    //   256: invokevirtual 116	java/util/jar/JarFile:close	()V
    //   259: aload_0
    //   260: astore_2
    //   261: aload_2
    //   262: areturn
    //   263: goto -236 -> 27
    //   266: astore_1
    //   267: aload_1
    //   268: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   271: aload_0
    //   272: areturn
    //   273: ldc -117
    //   275: astore_2
    //   276: aload_1
    //   277: ifnull -16 -> 261
    //   280: aload_1
    //   281: invokevirtual 116	java/util/jar/JarFile:close	()V
    //   284: ldc -117
    //   286: areturn
    //   287: astore_0
    //   288: aload_0
    //   289: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   292: ldc -117
    //   294: areturn
    //   295: astore_1
    //   296: aload_1
    //   297: invokevirtual 137	java/io/IOException:printStackTrace	()V
    //   300: goto -96 -> 204
    //   303: astore_0
    //   304: aconst_null
    //   305: astore_1
    //   306: goto -110 -> 196
    //   309: astore_0
    //   310: goto -114 -> 196
    //   313: astore_1
    //   314: aload_3
    //   315: astore_0
    //   316: goto -131 -> 185
    //   319: aload_0
    //   320: astore_2
    //   321: goto -97 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramFile	java.io.File
    //   12	244	1	localObject1	Object
    //   266	15	1	localIOException1	java.io.IOException
    //   295	2	1	localIOException2	java.io.IOException
    //   305	1	1	localObject2	Object
    //   313	1	1	localException1	Exception
    //   3	164	2	localJarEntry	java.util.jar.JarEntry
    //   180	4	2	localException2	Exception
    //   191	4	2	localObject3	Object
    //   217	104	2	localObject4	Object
    //   1	314	3	arrayOfByte	byte[]
    //   23	15	4	localEnumeration	java.util.Enumeration
    //   71	140	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   13	25	180	java/lang/Exception
    //   27	115	180	java/lang/Exception
    //   115	139	180	java/lang/Exception
    //   144	150	180	java/lang/Exception
    //   150	180	180	java/lang/Exception
    //   210	218	180	java/lang/Exception
    //   228	249	180	java/lang/Exception
    //   185	191	191	finally
    //   255	259	266	java/io/IOException
    //   280	284	287	java/io/IOException
    //   200	204	295	java/io/IOException
    //   4	13	303	finally
    //   13	25	309	finally
    //   27	115	309	finally
    //   115	139	309	finally
    //   144	150	309	finally
    //   150	180	309	finally
    //   210	218	309	finally
    //   228	249	309	finally
    //   4	13	313	java/lang/Exception
  }
  
  private static char[] a(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    if (i < k)
    {
      int m = paramArrayOfByte[i];
      int j = m >> 4 & 0xF;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label46:
        arrayOfChar[(i * 2)] = ((char)j);
        j = m & 0xF;
        if (j < 10) {
          break label97;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(i * 2 + 1)] = ((char)j);
        i += 1;
        break;
        j += 48;
        break label46;
        label97:
        j += 48;
      }
    }
    return arrayOfChar;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\securitysdk\utils\ApkSigParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */