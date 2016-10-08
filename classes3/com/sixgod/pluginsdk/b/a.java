package com.sixgod.pluginsdk.b;

import android.util.Log;
import java.io.File;

public final class a
{
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: new 12	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 16	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: iconst_4
    //   12: newarray <illegal type>
    //   14: astore_2
    //   15: aload_1
    //   16: astore_0
    //   17: aload_1
    //   18: aload_2
    //   19: iconst_0
    //   20: aload_2
    //   21: arraylength
    //   22: invokevirtual 20	java/io/FileInputStream:read	([BII)I
    //   25: pop
    //   26: aload_1
    //   27: astore_0
    //   28: aload_2
    //   29: invokestatic 23	com/sixgod/pluginsdk/b/a:a	([B)Ljava/lang/String;
    //   32: astore_2
    //   33: aload_2
    //   34: astore_0
    //   35: aload_1
    //   36: invokevirtual 27	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: astore_2
    //   41: aload_2
    //   42: areturn
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   48: aload_0
    //   49: areturn
    //   50: astore_2
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: aload_2
    //   56: invokevirtual 31	java/lang/Exception:printStackTrace	()V
    //   59: aload_1
    //   60: astore_0
    //   61: new 33	java/lang/StringBuilder
    //   64: dup
    //   65: ldc 35
    //   67: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: aload_2
    //   71: invokevirtual 42	java/lang/Object:getClass	()Ljava/lang/Class;
    //   74: invokevirtual 48	java/lang/Class:getName	()Ljava/lang/String;
    //   77: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore_2
    //   84: aload_2
    //   85: astore_0
    //   86: aload_0
    //   87: astore_2
    //   88: aload_1
    //   89: ifnull -48 -> 41
    //   92: aload_1
    //   93: invokevirtual 27	java/io/FileInputStream:close	()V
    //   96: aload_0
    //   97: areturn
    //   98: astore_1
    //   99: aload_1
    //   100: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   103: aload_0
    //   104: areturn
    //   105: astore_1
    //   106: aconst_null
    //   107: astore_0
    //   108: aload_0
    //   109: ifnull +7 -> 116
    //   112: aload_0
    //   113: invokevirtual 27	java/io/FileInputStream:close	()V
    //   116: aload_1
    //   117: athrow
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore_1
    //   127: goto -19 -> 108
    //   130: astore_2
    //   131: goto -78 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramFile	File
    //   8	28	1	localFileInputStream	java.io.FileInputStream
    //   43	2	1	localIOException1	java.io.IOException
    //   52	41	1	localObject1	Object
    //   98	2	1	localIOException2	java.io.IOException
    //   105	12	1	localObject2	Object
    //   126	1	1	localObject3	Object
    //   14	28	2	localObject4	Object
    //   50	21	2	localException1	Exception
    //   83	5	2	localObject5	Object
    //   130	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   35	39	43	java/io/IOException
    //   0	9	50	java/lang/Exception
    //   92	96	98	java/io/IOException
    //   0	9	105	finally
    //   112	116	118	java/io/IOException
    //   11	15	126	finally
    //   17	26	126	finally
    //   28	33	126	finally
    //   55	59	126	finally
    //   61	84	126	finally
    //   11	15	130	java/lang/Exception
    //   17	26	130	java/lang/Exception
    //   28	33	130	java/lang/Exception
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 76
    //   3: invokevirtual 80	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   6: ifeq +276 -> 282
    //   9: aload_1
    //   10: astore 5
    //   12: sipush 1024
    //   15: newarray <illegal type>
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 7
    //   22: aconst_null
    //   23: astore 8
    //   25: aconst_null
    //   26: astore 6
    //   28: aload 7
    //   30: astore_1
    //   31: aload 8
    //   33: astore 4
    //   35: new 82	java/util/zip/ZipFile
    //   38: dup
    //   39: new 84	java/io/File
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: invokespecial 86	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   50: astore 10
    //   52: aload 7
    //   54: astore_1
    //   55: aload 8
    //   57: astore 4
    //   59: aload 10
    //   61: invokevirtual 90	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   64: astore 7
    //   66: aload 6
    //   68: astore_0
    //   69: aload_0
    //   70: astore_1
    //   71: aload_0
    //   72: astore 4
    //   74: aload 7
    //   76: invokeinterface 96 1 0
    //   81: ifeq +232 -> 313
    //   84: aload_0
    //   85: astore_1
    //   86: aload_0
    //   87: astore 4
    //   89: aload 7
    //   91: invokeinterface 100 1 0
    //   96: checkcast 102	java/util/zip/ZipEntry
    //   99: astore 6
    //   101: aload_2
    //   102: ifnull +20 -> 122
    //   105: aload_0
    //   106: astore_1
    //   107: aload_0
    //   108: astore 4
    //   110: aload 6
    //   112: invokevirtual 103	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   115: aload_2
    //   116: invokevirtual 106	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   119: ifeq -50 -> 69
    //   122: aload_3
    //   123: ifnull +20 -> 143
    //   126: aload_0
    //   127: astore_1
    //   128: aload_0
    //   129: astore 4
    //   131: aload 6
    //   133: invokevirtual 103	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   136: aload_3
    //   137: invokevirtual 80	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   140: ifeq -71 -> 69
    //   143: aload_0
    //   144: astore_1
    //   145: aload_0
    //   146: astore 4
    //   148: new 84	java/io/File
    //   151: dup
    //   152: new 33	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   159: aload 5
    //   161: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 6
    //   166: invokevirtual 103	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   169: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore 8
    //   180: aload_0
    //   181: astore_1
    //   182: aload_0
    //   183: astore 4
    //   185: aload 8
    //   187: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   190: invokevirtual 113	java/io/File:exists	()Z
    //   193: ifne +17 -> 210
    //   196: aload_0
    //   197: astore_1
    //   198: aload_0
    //   199: astore 4
    //   201: aload 8
    //   203: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   206: invokevirtual 116	java/io/File:mkdirs	()Z
    //   209: pop
    //   210: aload_0
    //   211: astore_1
    //   212: aload_0
    //   213: astore 4
    //   215: new 118	java/io/FileOutputStream
    //   218: dup
    //   219: aload 8
    //   221: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   224: astore_0
    //   225: aload 10
    //   227: aload 6
    //   229: invokevirtual 123	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   232: astore_1
    //   233: aload_1
    //   234: aload 9
    //   236: invokevirtual 128	java/io/InputStream:read	([B)I
    //   239: istore 11
    //   241: iload 11
    //   243: ifle +63 -> 306
    //   246: aload_0
    //   247: aload 9
    //   249: iconst_0
    //   250: iload 11
    //   252: invokevirtual 134	java/io/OutputStream:write	([BII)V
    //   255: goto -22 -> 233
    //   258: astore_1
    //   259: aload_0
    //   260: astore 4
    //   262: aload_1
    //   263: astore_0
    //   264: aload 4
    //   266: astore_1
    //   267: aload_0
    //   268: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   271: aload 4
    //   273: ifnull +8 -> 281
    //   276: aload 4
    //   278: invokevirtual 135	java/io/OutputStream:close	()V
    //   281: return
    //   282: new 33	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   289: aload_1
    //   290: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc 76
    //   295: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: astore 5
    //   303: goto -291 -> 12
    //   306: aload_0
    //   307: invokevirtual 138	java/io/OutputStream:flush	()V
    //   310: goto -241 -> 69
    //   313: aload_0
    //   314: ifnull -33 -> 281
    //   317: aload_0
    //   318: invokevirtual 135	java/io/OutputStream:close	()V
    //   321: return
    //   322: astore_0
    //   323: aload_0
    //   324: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   327: return
    //   328: astore_0
    //   329: aload_0
    //   330: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   333: return
    //   334: astore_0
    //   335: aload_1
    //   336: ifnull +7 -> 343
    //   339: aload_1
    //   340: invokevirtual 135	java/io/OutputStream:close	()V
    //   343: aload_0
    //   344: athrow
    //   345: astore_1
    //   346: aload_1
    //   347: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   350: goto -7 -> 343
    //   353: astore_2
    //   354: aload_0
    //   355: astore_1
    //   356: aload_2
    //   357: astore_0
    //   358: goto -23 -> 335
    //   361: astore_0
    //   362: goto -98 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramString1	String
    //   0	365	1	paramString2	String
    //   0	365	2	paramString3	String
    //   0	365	3	paramString4	String
    //   33	244	4	localObject	Object
    //   10	292	5	str	String
    //   26	202	6	localZipEntry	java.util.zip.ZipEntry
    //   20	70	7	localEnumeration	java.util.Enumeration
    //   23	197	8	localFile	File
    //   17	231	9	arrayOfByte	byte[]
    //   50	176	10	localZipFile	java.util.zip.ZipFile
    //   239	12	11	i	int
    // Exception table:
    //   from	to	target	type
    //   225	233	258	java/io/IOException
    //   233	241	258	java/io/IOException
    //   246	255	258	java/io/IOException
    //   306	310	258	java/io/IOException
    //   317	321	322	java/io/IOException
    //   276	281	328	java/io/IOException
    //   35	52	334	finally
    //   59	66	334	finally
    //   74	84	334	finally
    //   89	101	334	finally
    //   110	122	334	finally
    //   131	143	334	finally
    //   148	180	334	finally
    //   185	196	334	finally
    //   201	210	334	finally
    //   215	225	334	finally
    //   267	271	334	finally
    //   339	343	345	java/io/IOException
    //   225	233	353	finally
    //   233	241	353	finally
    //   246	255	353	finally
    //   306	310	353	finally
    //   35	52	361	java/io/IOException
    //   59	66	361	java/io/IOException
    //   74	84	361	java/io/IOException
    //   89	101	361	java/io/IOException
    //   110	122	361	java/io/IOException
    //   131	143	361	java/io/IOException
    //   148	180	361	java/io/IOException
    //   185	196	361	java/io/IOException
    //   201	210	361	java/io/IOException
    //   215	225	361	java/io/IOException
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = paramString;
    if (!paramString.endsWith(File.separator)) {
      localObject = paramString + File.separator;
    }
    paramString = new File((String)localObject);
    if (paramString.isFile())
    {
      localObject = new File(paramString.getAbsolutePath() + System.currentTimeMillis());
      paramString.renameTo((File)localObject);
      ((File)localObject).delete();
    }
    for (;;)
    {
      return true;
      String[] arrayOfString = paramString.list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          a((String)localObject + str);
          i += 1;
        }
      }
      localObject = new File(paramString.getAbsolutePath() + System.currentTimeMillis());
      paramString.renameTo((File)localObject);
      ((File)localObject).delete();
    }
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    File localFile = new File(paramString1);
    if (!localFile.exists())
    {
      Log.d("SixGod_PluginSdk", "sourceDir: " + paramString1 + " does not exit！");
      return false;
    }
    if (!localFile.isDirectory())
    {
      Log.d("SixGod_PluginSdk", paramString1 + " is not a directory！");
      return false;
    }
    String str = paramString2;
    if (!paramString2.endsWith(File.separator)) {
      str = paramString2 + File.separator;
    }
    paramString2 = new File(str);
    if (!paramString2.exists()) {
      paramString2.mkdirs();
    }
    paramString2 = localFile.listFiles();
    int i = 0;
    boolean bool2 = true;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString2.length)
      {
        if (!paramString2[i].isFile()) {
          break label258;
        }
        bool1 = b(paramString2[i].getAbsolutePath(), str + paramString2[i].getName(), paramBoolean);
        bool2 = bool1;
        if (bool1) {
          break label314;
        }
      }
      label258:
      do
      {
        if (bool1) {
          break label323;
        }
        Log.d("SixGod_PluginSdk", "dir:" + paramString1 + " moved to " + str + " failed！");
        return false;
        if (!paramString2[i].isDirectory()) {
          break;
        }
        bool2 = a(paramString2[i].getAbsolutePath(), str + paramString2[i].getName(), paramBoolean);
        bool1 = bool2;
      } while (!bool2);
      label314:
      i += 1;
    }
    label323:
    a(paramString1);
    Log.d("SixGod_PluginSdk", "dir: " + paramString1 + " moved to" + str + " success！");
    return true;
  }
  
  /* Error */
  public static String b(File paramFile)
  {
    // Byte code:
    //   0: ldc -42
    //   2: invokestatic 220	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_1
    //   6: new 12	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 16	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_2
    //   15: new 222	java/security/DigestInputStream
    //   18: dup
    //   19: aload_2
    //   20: aload_1
    //   21: invokespecial 225	java/security/DigestInputStream:<init>	(Ljava/io/InputStream;Ljava/security/MessageDigest;)V
    //   24: astore_1
    //   25: ldc -30
    //   27: newarray <illegal type>
    //   29: astore_0
    //   30: aload_1
    //   31: aload_0
    //   32: invokevirtual 227	java/security/DigestInputStream:read	([B)I
    //   35: ifgt -5 -> 30
    //   38: aload_1
    //   39: invokevirtual 231	java/security/DigestInputStream:getMessageDigest	()Ljava/security/MessageDigest;
    //   42: invokevirtual 235	java/security/MessageDigest:digest	()[B
    //   45: invokestatic 23	com/sixgod/pluginsdk/b/a:a	([B)Ljava/lang/String;
    //   48: astore_0
    //   49: aload_1
    //   50: invokevirtual 236	java/security/DigestInputStream:close	()V
    //   53: aload_2
    //   54: invokevirtual 27	java/io/FileInputStream:close	()V
    //   57: aload_0
    //   58: areturn
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_2
    //   64: aload_0
    //   65: invokevirtual 236	java/security/DigestInputStream:close	()V
    //   68: aload_2
    //   69: invokevirtual 27	java/io/FileInputStream:close	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_2
    //   80: aconst_null
    //   81: astore_1
    //   82: aload_1
    //   83: invokevirtual 236	java/security/DigestInputStream:close	()V
    //   86: aload_2
    //   87: invokevirtual 27	java/io/FileInputStream:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: astore_1
    //   93: goto -40 -> 53
    //   96: astore_1
    //   97: aload_0
    //   98: areturn
    //   99: astore_0
    //   100: goto -32 -> 68
    //   103: astore_1
    //   104: goto -18 -> 86
    //   107: astore_1
    //   108: goto -18 -> 90
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_1
    //   114: goto -32 -> 82
    //   117: astore_0
    //   118: goto -36 -> 82
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_0
    //   124: goto -60 -> 64
    //   127: astore_0
    //   128: aload_1
    //   129: astore_0
    //   130: goto -66 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramFile	File
    //   5	78	1	localObject1	Object
    //   92	1	1	localException1	Exception
    //   96	1	1	localException2	Exception
    //   103	1	1	localException3	Exception
    //   107	1	1	localException4	Exception
    //   113	16	1	localObject2	Object
    //   14	73	2	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   0	15	59	java/security/NoSuchAlgorithmException
    //   68	72	74	java/lang/Exception
    //   0	15	77	finally
    //   49	53	92	java/lang/Exception
    //   53	57	96	java/lang/Exception
    //   64	68	99	java/lang/Exception
    //   82	86	103	java/lang/Exception
    //   86	90	107	java/lang/Exception
    //   15	25	111	finally
    //   25	30	117	finally
    //   30	49	117	finally
    //   15	25	121	java/security/NoSuchAlgorithmException
    //   25	30	127	java/security/NoSuchAlgorithmException
    //   30	49	127	java/security/NoSuchAlgorithmException
  }
  
  private static boolean b(String paramString)
  {
    boolean bool2 = false;
    paramString = new File(paramString);
    boolean bool1 = bool2;
    if (paramString.isFile())
    {
      bool1 = bool2;
      if (!paramString.exists()) {}
    }
    try
    {
      paramString.delete();
      bool1 = true;
      return bool1;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  /* Error */
  private static boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 33	java/lang/StringBuilder
    //   6: dup
    //   7: ldc -16
    //   9: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: ldc -14
    //   18: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 246	com/sixgod/pluginsdk/log/a:a	(Ljava/lang/String;)V
    //   31: new 84	java/io/File
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   39: astore_3
    //   40: aload_3
    //   41: invokevirtual 113	java/io/File:exists	()Z
    //   44: ifne +10 -> 54
    //   47: ldc -8
    //   49: invokestatic 246	com/sixgod/pluginsdk/log/a:a	(Ljava/lang/String;)V
    //   52: iconst_0
    //   53: ireturn
    //   54: aload_3
    //   55: invokevirtual 145	java/io/File:isFile	()Z
    //   58: ifne +10 -> 68
    //   61: ldc -6
    //   63: invokestatic 246	com/sixgod/pluginsdk/log/a:a	(Ljava/lang/String;)V
    //   66: iconst_0
    //   67: ireturn
    //   68: new 84	java/io/File
    //   71: dup
    //   72: aload_1
    //   73: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore 5
    //   78: aload 5
    //   80: invokevirtual 113	java/io/File:exists	()Z
    //   83: ifeq +204 -> 287
    //   86: iload_2
    //   87: ifeq +172 -> 259
    //   90: ldc -4
    //   92: invokestatic 246	com/sixgod/pluginsdk/log/a:a	(Ljava/lang/String;)V
    //   95: aload_1
    //   96: invokestatic 170	com/sixgod/pluginsdk/b/a:a	(Ljava/lang/String;)Z
    //   99: pop
    //   100: new 12	java/io/FileInputStream
    //   103: dup
    //   104: aload_3
    //   105: invokespecial 16	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   108: astore_3
    //   109: new 118	java/io/FileOutputStream
    //   112: dup
    //   113: aload 5
    //   115: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   118: astore 5
    //   120: aload 5
    //   122: astore 7
    //   124: aload_3
    //   125: astore 6
    //   127: sipush 1024
    //   130: newarray <illegal type>
    //   132: astore 4
    //   134: aload 5
    //   136: astore 7
    //   138: aload_3
    //   139: astore 6
    //   141: aload_3
    //   142: aload 4
    //   144: invokevirtual 253	java/io/FileInputStream:read	([B)I
    //   147: istore 9
    //   149: iload 9
    //   151: iconst_m1
    //   152: if_icmpeq +171 -> 323
    //   155: aload 5
    //   157: astore 7
    //   159: aload_3
    //   160: astore 6
    //   162: aload 5
    //   164: aload 4
    //   166: iconst_0
    //   167: iload 9
    //   169: invokevirtual 254	java/io/FileOutputStream:write	([BII)V
    //   172: goto -38 -> 134
    //   175: astore 6
    //   177: aload_3
    //   178: astore 4
    //   180: aload 5
    //   182: astore_3
    //   183: aload 6
    //   185: astore 5
    //   187: aload 5
    //   189: invokevirtual 255	java/io/FileNotFoundException:printStackTrace	()V
    //   192: aload 4
    //   194: ifnull +8 -> 202
    //   197: aload 4
    //   199: invokevirtual 27	java/io/FileInputStream:close	()V
    //   202: aload_3
    //   203: ifnull +11 -> 214
    //   206: aload_3
    //   207: invokevirtual 256	java/io/FileOutputStream:flush	()V
    //   210: aload_3
    //   211: invokevirtual 257	java/io/FileOutputStream:close	()V
    //   214: aload_0
    //   215: invokestatic 259	com/sixgod/pluginsdk/b/a:b	(Ljava/lang/String;)Z
    //   218: pop
    //   219: ldc -83
    //   221: new 33	java/lang/StringBuilder
    //   224: dup
    //   225: ldc_w 261
    //   228: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   231: aload_0
    //   232: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: ldc_w 263
    //   238: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: aload_1
    //   242: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: ldc -54
    //   247: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 183	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   256: pop
    //   257: iconst_0
    //   258: ireturn
    //   259: new 33	java/lang/StringBuilder
    //   262: dup
    //   263: ldc_w 265
    //   266: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   269: aload_1
    //   270: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc_w 267
    //   276: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 246	com/sixgod/pluginsdk/log/a:a	(Ljava/lang/String;)V
    //   285: iconst_0
    //   286: ireturn
    //   287: aload 5
    //   289: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   292: invokevirtual 113	java/io/File:exists	()Z
    //   295: ifne -195 -> 100
    //   298: ldc_w 269
    //   301: invokestatic 246	com/sixgod/pluginsdk/log/a:a	(Ljava/lang/String;)V
    //   304: aload 5
    //   306: invokevirtual 110	java/io/File:getParentFile	()Ljava/io/File;
    //   309: invokevirtual 116	java/io/File:mkdirs	()Z
    //   312: ifne -212 -> 100
    //   315: ldc_w 271
    //   318: invokestatic 246	com/sixgod/pluginsdk/log/a:a	(Ljava/lang/String;)V
    //   321: iconst_0
    //   322: ireturn
    //   323: aload 5
    //   325: astore 7
    //   327: aload_3
    //   328: astore 6
    //   330: new 33	java/lang/StringBuilder
    //   333: dup
    //   334: ldc_w 273
    //   337: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: aload_0
    //   341: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: ldc -56
    //   346: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_1
    //   350: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: ldc -46
    //   355: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 246	com/sixgod/pluginsdk/log/a:a	(Ljava/lang/String;)V
    //   364: aload_3
    //   365: invokevirtual 27	java/io/FileInputStream:close	()V
    //   368: aload 5
    //   370: invokevirtual 256	java/io/FileOutputStream:flush	()V
    //   373: aload 5
    //   375: invokevirtual 257	java/io/FileOutputStream:close	()V
    //   378: aload_0
    //   379: invokestatic 259	com/sixgod/pluginsdk/b/a:b	(Ljava/lang/String;)Z
    //   382: pop
    //   383: iconst_1
    //   384: ireturn
    //   385: astore_1
    //   386: aload_1
    //   387: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   390: goto -22 -> 368
    //   393: astore_1
    //   394: aload_1
    //   395: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   398: goto -20 -> 378
    //   401: astore 4
    //   403: aload 4
    //   405: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   408: goto -206 -> 202
    //   411: astore_3
    //   412: aload_3
    //   413: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   416: goto -202 -> 214
    //   419: astore 8
    //   421: aconst_null
    //   422: astore 4
    //   424: aconst_null
    //   425: astore_3
    //   426: aload 4
    //   428: astore 7
    //   430: aload_3
    //   431: astore 6
    //   433: aload 8
    //   435: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   438: aload_3
    //   439: ifnull +7 -> 446
    //   442: aload_3
    //   443: invokevirtual 27	java/io/FileInputStream:close	()V
    //   446: aload 4
    //   448: ifnull +13 -> 461
    //   451: aload 4
    //   453: invokevirtual 256	java/io/FileOutputStream:flush	()V
    //   456: aload 4
    //   458: invokevirtual 257	java/io/FileOutputStream:close	()V
    //   461: aload_0
    //   462: invokestatic 259	com/sixgod/pluginsdk/b/a:b	(Ljava/lang/String;)Z
    //   465: pop
    //   466: goto -247 -> 219
    //   469: astore_3
    //   470: aload_3
    //   471: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   474: goto -28 -> 446
    //   477: astore_3
    //   478: aload_3
    //   479: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   482: goto -21 -> 461
    //   485: astore_1
    //   486: aconst_null
    //   487: astore 4
    //   489: aconst_null
    //   490: astore_3
    //   491: aload_3
    //   492: ifnull +7 -> 499
    //   495: aload_3
    //   496: invokevirtual 27	java/io/FileInputStream:close	()V
    //   499: aload 4
    //   501: ifnull +13 -> 514
    //   504: aload 4
    //   506: invokevirtual 256	java/io/FileOutputStream:flush	()V
    //   509: aload 4
    //   511: invokevirtual 257	java/io/FileOutputStream:close	()V
    //   514: aload_0
    //   515: invokestatic 259	com/sixgod/pluginsdk/b/a:b	(Ljava/lang/String;)Z
    //   518: pop
    //   519: aload_1
    //   520: athrow
    //   521: astore_3
    //   522: aload_3
    //   523: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   526: goto -27 -> 499
    //   529: astore_3
    //   530: aload_3
    //   531: invokevirtual 30	java/io/IOException:printStackTrace	()V
    //   534: goto -20 -> 514
    //   537: astore_1
    //   538: aconst_null
    //   539: astore 4
    //   541: goto -50 -> 491
    //   544: astore_1
    //   545: aload 7
    //   547: astore 4
    //   549: aload 6
    //   551: astore_3
    //   552: goto -61 -> 491
    //   555: astore_1
    //   556: aload 4
    //   558: astore 5
    //   560: aload_3
    //   561: astore 4
    //   563: aload 5
    //   565: astore_3
    //   566: goto -75 -> 491
    //   569: astore 8
    //   571: aconst_null
    //   572: astore 4
    //   574: goto -148 -> 426
    //   577: astore 8
    //   579: aload 5
    //   581: astore 4
    //   583: goto -157 -> 426
    //   586: astore 5
    //   588: aconst_null
    //   589: astore_3
    //   590: goto -403 -> 187
    //   593: astore 5
    //   595: aconst_null
    //   596: astore 6
    //   598: aload_3
    //   599: astore 4
    //   601: aload 6
    //   603: astore_3
    //   604: goto -417 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	607	0	paramString1	String
    //   0	607	1	paramString2	String
    //   0	607	2	paramBoolean	boolean
    //   39	326	3	localObject1	Object
    //   411	2	3	localIOException1	java.io.IOException
    //   425	18	3	localObject2	Object
    //   469	2	3	localIOException2	java.io.IOException
    //   477	2	3	localIOException3	java.io.IOException
    //   490	6	3	localObject3	Object
    //   521	2	3	localIOException4	java.io.IOException
    //   529	2	3	localIOException5	java.io.IOException
    //   551	53	3	localObject4	Object
    //   1	197	4	localObject5	Object
    //   401	3	4	localIOException6	java.io.IOException
    //   422	178	4	localObject6	Object
    //   76	504	5	localObject7	Object
    //   586	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   593	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   125	36	6	localObject8	Object
    //   175	9	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   328	274	6	localObject9	Object
    //   122	424	7	localObject10	Object
    //   419	15	8	localIOException7	java.io.IOException
    //   569	1	8	localIOException8	java.io.IOException
    //   577	1	8	localIOException9	java.io.IOException
    //   147	21	9	i	int
    // Exception table:
    //   from	to	target	type
    //   127	134	175	java/io/FileNotFoundException
    //   141	149	175	java/io/FileNotFoundException
    //   162	172	175	java/io/FileNotFoundException
    //   330	364	175	java/io/FileNotFoundException
    //   364	368	385	java/io/IOException
    //   368	378	393	java/io/IOException
    //   197	202	401	java/io/IOException
    //   206	214	411	java/io/IOException
    //   100	109	419	java/io/IOException
    //   442	446	469	java/io/IOException
    //   451	461	477	java/io/IOException
    //   100	109	485	finally
    //   495	499	521	java/io/IOException
    //   504	514	529	java/io/IOException
    //   109	120	537	finally
    //   127	134	544	finally
    //   141	149	544	finally
    //   162	172	544	finally
    //   330	364	544	finally
    //   433	438	544	finally
    //   187	192	555	finally
    //   109	120	569	java/io/IOException
    //   127	134	577	java/io/IOException
    //   141	149	577	java/io/IOException
    //   162	172	577	java/io/IOException
    //   330	364	577	java/io/IOException
    //   100	109	586	java/io/FileNotFoundException
    //   109	120	593	java/io/FileNotFoundException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\sixgod\pluginsdk\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */