package com.tencent.upload.common;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class b
{
  private static final String a = b.class.getSimpleName();
  
  public static int a()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      return (int)(1.0D * j * i / 1024.0D / 1024.0D);
    }
    catch (Throwable localThrowable)
    {
      com.tencent.upload.a.b.e(a, localThrowable.toString());
    }
    return 0;
  }
  
  private static File a(Context paramContext)
  {
    File localFile = Environment.getExternalStorageDirectory();
    if ((localFile == null) || (!localFile.exists()) || (paramContext == null)) {}
    do
    {
      return null;
      StringBuilder localStringBuilder = new StringBuilder(11);
      localStringBuilder.append(localFile.getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("Android");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("data");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("files");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("uploader");
      paramContext = new File(localStringBuilder.toString());
    } while ((!paramContext.isDirectory()) && (!paramContext.mkdirs()));
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    do
    {
      do
      {
        do
        {
          return null;
          String str = paramString2;
          if (paramString2 == null) {
            str = "";
          }
          int i = str.hashCode();
          int j = paramString1.hashCode();
          paramString1 = 3 + i + "_" + j;
          if (("mounted".equals(Environment.getExternalStorageState())) && (a() > 5))
          {
            paramString2 = a(paramContext);
            if (paramString2 != null)
            {
              paramString2 = a(paramString2, paramString1);
              if (paramString2 != null) {
                return paramString2;
              }
            }
          }
        } while (b() <= 5);
        paramContext = paramContext.getDir("uploader", 0);
      } while (paramContext == null);
      paramContext = a(paramContext, paramString1);
    } while (paramContext == null);
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return null;
        String str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        i = str.hashCode();
        j = paramString1.hashCode();
        if (("mounted".equals(Environment.getExternalStorageState())) && (a() > 5))
        {
          paramString1 = a(paramContext);
          if (paramString1 != null) {
            return a(paramString1.getAbsolutePath(), i, j, paramInt);
          }
        }
      } while (b() <= 5);
      paramContext = paramContext.getDir("uploader", 0);
    } while (paramContext == null);
    return a(paramContext.getAbsolutePath(), i, j, paramInt);
  }
  
  public static String a(File paramFile)
  {
    return c(paramFile, "MD5");
  }
  
  private static final String a(File paramFile, String paramString)
  {
    if ((paramFile == null) || (!paramFile.isDirectory())) {}
    for (;;)
    {
      return null;
      String[] arrayOfString = paramFile.list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if ((str != null) && (str.startsWith(paramString)) && (str.endsWith(".qtmp")))
          {
            File localFile = new File(paramFile, str);
            if ((localFile.length() != 0L) && (localFile.isFile())) {
              return 3 + paramFile.getAbsolutePath() + File.separator + str;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return 8 + paramString + File.separator + paramInt1 + "_" + paramInt2 + "_" + paramInt3 + ".qtmp";
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, "MD5");
  }
  
  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      paramString.reset();
      paramString.update(paramArrayOfByte);
      paramArrayOfByte = d.a(paramString.digest());
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return "";
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2)
  {
    File localFile = a(paramContext);
    if ((localFile != null) && (d(localFile) >= paramLong1)) {
      e(localFile);
    }
    paramContext = paramContext.getDir("uploader", 0);
    if ((paramContext != null) && (d(paramContext) >= paramLong2)) {
      e(paramContext);
    }
  }
  
  public static final boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 11
    //   3: iconst_1
    //   4: istore 12
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_0
    //   10: ifnull +14 -> 24
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +6 -> 24
    //   21: iload 12
    //   23: ireturn
    //   24: new 216	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 217	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   32: astore_0
    //   33: new 219	java/io/FileOutputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 220	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   41: astore 5
    //   43: aload 5
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: sipush 10240
    //   51: newarray <illegal type>
    //   53: astore 4
    //   55: iconst_0
    //   56: istore 7
    //   58: aload 5
    //   60: astore_3
    //   61: aload_0
    //   62: astore_2
    //   63: aload_0
    //   64: aload 4
    //   66: invokevirtual 224	java/io/FileInputStream:read	([B)I
    //   69: istore 8
    //   71: iload 8
    //   73: iconst_m1
    //   74: if_icmpeq +28 -> 102
    //   77: aload 5
    //   79: astore_3
    //   80: aload_0
    //   81: astore_2
    //   82: aload 5
    //   84: aload 4
    //   86: iconst_0
    //   87: iload 8
    //   89: invokevirtual 228	java/io/FileOutputStream:write	([BII)V
    //   92: iload 7
    //   94: iload 8
    //   96: iadd
    //   97: istore 7
    //   99: goto -41 -> 58
    //   102: aload 5
    //   104: astore_3
    //   105: aload_0
    //   106: astore_2
    //   107: aload 5
    //   109: invokevirtual 231	java/io/FileOutputStream:flush	()V
    //   112: aload_0
    //   113: invokevirtual 234	java/io/FileInputStream:close	()V
    //   116: aload 5
    //   118: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   121: new 33	java/io/File
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 61	java/io/File:exists	()Z
    //   134: ifeq +20 -> 154
    //   137: aload_0
    //   138: invokevirtual 163	java/io/File:length	()J
    //   141: lstore 9
    //   143: aload_0
    //   144: astore_1
    //   145: lload 9
    //   147: iload 7
    //   149: i2l
    //   150: lcmp
    //   151: ifeq +8 -> 159
    //   154: iconst_0
    //   155: istore 11
    //   157: aload_0
    //   158: astore_1
    //   159: iload 11
    //   161: istore 12
    //   163: iload 11
    //   165: ifne -144 -> 21
    //   168: iload 11
    //   170: istore 12
    //   172: aload_1
    //   173: ifnull -152 -> 21
    //   176: aload_1
    //   177: invokevirtual 238	java/io/File:delete	()Z
    //   180: pop
    //   181: iload 11
    //   183: ireturn
    //   184: astore_0
    //   185: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   188: ldc -16
    //   190: aload_0
    //   191: invokestatic 243	com/tencent/upload/a/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   194: goto -73 -> 121
    //   197: astore 4
    //   199: aconst_null
    //   200: astore 5
    //   202: aconst_null
    //   203: astore_0
    //   204: iconst_0
    //   205: istore 7
    //   207: aload 5
    //   209: astore_3
    //   210: aload_0
    //   211: astore_2
    //   212: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   215: ldc -16
    //   217: aload 4
    //   219: invokestatic 243	com/tencent/upload/a/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload_0
    //   223: ifnull +7 -> 230
    //   226: aload_0
    //   227: invokevirtual 234	java/io/FileInputStream:close	()V
    //   230: aload 5
    //   232: ifnull +8 -> 240
    //   235: aload 5
    //   237: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   240: iconst_0
    //   241: istore 11
    //   243: goto -122 -> 121
    //   246: astore_0
    //   247: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   250: ldc -16
    //   252: aload_0
    //   253: invokestatic 243	com/tencent/upload/a/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: iconst_0
    //   257: istore 11
    //   259: goto -138 -> 121
    //   262: astore 4
    //   264: aconst_null
    //   265: astore 5
    //   267: aconst_null
    //   268: astore_0
    //   269: iconst_0
    //   270: istore 7
    //   272: aload 5
    //   274: astore_3
    //   275: aload_0
    //   276: astore_2
    //   277: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   280: ldc -16
    //   282: aload 4
    //   284: invokestatic 243	com/tencent/upload/a/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   287: aload_0
    //   288: ifnull +7 -> 295
    //   291: aload_0
    //   292: invokevirtual 234	java/io/FileInputStream:close	()V
    //   295: aload 5
    //   297: ifnull +8 -> 305
    //   300: aload 5
    //   302: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   305: iconst_0
    //   306: istore 11
    //   308: goto -187 -> 121
    //   311: astore_0
    //   312: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   315: ldc -16
    //   317: aload_0
    //   318: invokestatic 243	com/tencent/upload/a/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   321: iconst_0
    //   322: istore 11
    //   324: goto -203 -> 121
    //   327: astore_1
    //   328: aconst_null
    //   329: astore_3
    //   330: aconst_null
    //   331: astore_0
    //   332: aload_0
    //   333: ifnull +7 -> 340
    //   336: aload_0
    //   337: invokevirtual 234	java/io/FileInputStream:close	()V
    //   340: aload_3
    //   341: ifnull +7 -> 348
    //   344: aload_3
    //   345: invokevirtual 235	java/io/FileOutputStream:close	()V
    //   348: aload_1
    //   349: athrow
    //   350: astore_0
    //   351: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   354: ldc -16
    //   356: aload_0
    //   357: invokestatic 243	com/tencent/upload/a/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: goto -12 -> 348
    //   363: astore_0
    //   364: aload 6
    //   366: astore_0
    //   367: aload_0
    //   368: astore_1
    //   369: goto -210 -> 159
    //   372: astore_1
    //   373: goto -6 -> 367
    //   376: astore_1
    //   377: aconst_null
    //   378: astore_3
    //   379: goto -47 -> 332
    //   382: astore_1
    //   383: aload_2
    //   384: astore_0
    //   385: goto -53 -> 332
    //   388: astore 4
    //   390: aconst_null
    //   391: astore 5
    //   393: iconst_0
    //   394: istore 7
    //   396: goto -124 -> 272
    //   399: astore 4
    //   401: iconst_0
    //   402: istore 7
    //   404: goto -132 -> 272
    //   407: astore 4
    //   409: goto -137 -> 272
    //   412: astore 4
    //   414: aconst_null
    //   415: astore 5
    //   417: iconst_0
    //   418: istore 7
    //   420: goto -213 -> 207
    //   423: astore 4
    //   425: iconst_0
    //   426: istore 7
    //   428: goto -221 -> 207
    //   431: astore 4
    //   433: goto -226 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	paramString1	String
    //   0	436	1	paramString2	String
    //   47	337	2	str	String
    //   45	334	3	localFileOutputStream1	java.io.FileOutputStream
    //   53	32	4	arrayOfByte	byte[]
    //   197	21	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   262	21	4	localIOException1	java.io.IOException
    //   388	1	4	localIOException2	java.io.IOException
    //   399	1	4	localIOException3	java.io.IOException
    //   407	1	4	localIOException4	java.io.IOException
    //   412	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   423	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   431	1	4	localFileNotFoundException4	java.io.FileNotFoundException
    //   41	375	5	localFileOutputStream2	java.io.FileOutputStream
    //   7	358	6	localObject	Object
    //   56	371	7	i	int
    //   69	28	8	j	int
    //   141	5	9	l	long
    //   1	322	11	bool1	boolean
    //   4	167	12	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   112	121	184	java/io/IOException
    //   24	33	197	java/io/FileNotFoundException
    //   226	230	246	java/io/IOException
    //   235	240	246	java/io/IOException
    //   24	33	262	java/io/IOException
    //   291	295	311	java/io/IOException
    //   300	305	311	java/io/IOException
    //   24	33	327	finally
    //   336	340	350	java/io/IOException
    //   344	348	350	java/io/IOException
    //   121	130	363	java/lang/IllegalArgumentException
    //   130	143	372	java/lang/IllegalArgumentException
    //   33	43	376	finally
    //   48	55	382	finally
    //   63	71	382	finally
    //   82	92	382	finally
    //   107	112	382	finally
    //   212	222	382	finally
    //   277	287	382	finally
    //   33	43	388	java/io/IOException
    //   48	55	399	java/io/IOException
    //   63	71	407	java/io/IOException
    //   82	92	407	java/io/IOException
    //   107	112	407	java/io/IOException
    //   33	43	412	java/io/FileNotFoundException
    //   48	55	423	java/io/FileNotFoundException
    //   63	71	431	java/io/FileNotFoundException
    //   82	92	431	java/io/FileNotFoundException
    //   107	112	431	java/io/FileNotFoundException
  }
  
  private static int b()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      return (int)(1.0D * j * i / 1024.0D / 1024.0D);
    }
    catch (Throwable localThrowable)
    {
      com.tencent.upload.a.b.e(a, localThrowable.toString());
    }
    return 0;
  }
  
  public static a b(File paramFile)
  {
    return new a(0, b(paramFile, "MD5"));
  }
  
  /* Error */
  private static String b(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 61	java/io/File:exists	()Z
    //   8: ifne +6 -> 14
    //   11: ldc 100
    //   13: areturn
    //   14: aload_0
    //   15: invokevirtual 163	java/io/File:length	()J
    //   18: lstore 4
    //   20: lload 4
    //   22: ldc2_w 255
    //   25: lcmp
    //   26: ifle +129 -> 155
    //   29: lload 4
    //   31: ldc2_w 257
    //   34: ldiv
    //   35: lstore 4
    //   37: bipush 32
    //   39: newarray <illegal type>
    //   41: astore_2
    //   42: aconst_null
    //   43: astore_1
    //   44: new 216	java/io/FileInputStream
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: astore_0
    //   53: aload_0
    //   54: lload 4
    //   56: invokevirtual 264	java/io/FileInputStream:skip	(J)J
    //   59: pop2
    //   60: iconst_0
    //   61: istore_3
    //   62: iload_3
    //   63: iconst_4
    //   64: if_icmpge +32 -> 96
    //   67: aload_0
    //   68: aload_2
    //   69: iload_3
    //   70: iconst_3
    //   71: ishl
    //   72: bipush 8
    //   74: invokevirtual 267	java/io/FileInputStream:read	([BII)I
    //   77: pop
    //   78: aload_0
    //   79: lload 4
    //   81: ldc2_w 268
    //   84: lsub
    //   85: invokevirtual 264	java/io/FileInputStream:skip	(J)J
    //   88: pop2
    //   89: iload_3
    //   90: iconst_1
    //   91: iadd
    //   92: istore_3
    //   93: goto -31 -> 62
    //   96: aload_2
    //   97: invokestatic 193	com/tencent/upload/common/d:a	([B)Ljava/lang/String;
    //   100: astore_1
    //   101: aload_0
    //   102: invokevirtual 234	java/io/FileInputStream:close	()V
    //   105: aload_1
    //   106: areturn
    //   107: astore_0
    //   108: aload_1
    //   109: areturn
    //   110: astore_0
    //   111: aload_1
    //   112: astore_0
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 234	java/io/FileInputStream:close	()V
    //   121: ldc 100
    //   123: areturn
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_0
    //   127: aload_0
    //   128: ifnull -7 -> 121
    //   131: aload_0
    //   132: invokevirtual 234	java/io/FileInputStream:close	()V
    //   135: goto -14 -> 121
    //   138: astore_0
    //   139: goto -18 -> 121
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_0
    //   145: aload_0
    //   146: ifnull +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 234	java/io/FileInputStream:close	()V
    //   153: aload_1
    //   154: athrow
    //   155: aload_0
    //   156: aload_1
    //   157: invokestatic 143	com/tencent/upload/common/b:c	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   160: areturn
    //   161: astore_0
    //   162: goto -41 -> 121
    //   165: astore_0
    //   166: goto -13 -> 153
    //   169: astore_1
    //   170: goto -25 -> 145
    //   173: astore_1
    //   174: goto -47 -> 127
    //   177: astore_1
    //   178: goto -65 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramFile	File
    //   0	181	1	paramString	String
    //   41	56	2	arrayOfByte	byte[]
    //   61	32	3	i	int
    //   18	62	4	l	long
    // Exception table:
    //   from	to	target	type
    //   101	105	107	java/io/IOException
    //   44	53	110	java/io/FileNotFoundException
    //   44	53	124	java/io/IOException
    //   131	135	138	java/io/IOException
    //   44	53	142	finally
    //   117	121	161	java/io/IOException
    //   149	153	165	java/io/IOException
    //   53	60	169	finally
    //   67	89	169	finally
    //   96	101	169	finally
    //   53	60	173	java/io/IOException
    //   67	89	173	java/io/IOException
    //   96	101	173	java/io/IOException
    //   53	60	177	java/io/FileNotFoundException
    //   67	89	177	java/io/FileNotFoundException
    //   96	101	177	java/io/FileNotFoundException
  }
  
  public static final boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new File(paramString).length() > 0L);
  }
  
  public static String c(File paramFile)
  {
    return c(paramFile, "SHA-1");
  }
  
  /* Error */
  private static String c(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 61	java/io/File:exists	()Z
    //   8: ifne +6 -> 14
    //   11: ldc 100
    //   13: areturn
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 6
    //   23: aconst_null
    //   24: astore_3
    //   25: aload 6
    //   27: astore_2
    //   28: aload_1
    //   29: invokestatic 178	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   32: astore 7
    //   34: aload 6
    //   36: astore_2
    //   37: aload 7
    //   39: invokevirtual 181	java/security/MessageDigest:reset	()V
    //   42: aload 6
    //   44: astore_2
    //   45: new 275	java/io/BufferedInputStream
    //   48: dup
    //   49: new 216	java/io/FileInputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 260	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: sipush 8192
    //   60: invokespecial 278	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   63: astore_0
    //   64: aload_0
    //   65: astore_1
    //   66: sipush 8192
    //   69: newarray <illegal type>
    //   71: astore_2
    //   72: aload_0
    //   73: astore_1
    //   74: aload_0
    //   75: aload_2
    //   76: invokevirtual 279	java/io/BufferedInputStream:read	([B)I
    //   79: istore 8
    //   81: iload 8
    //   83: ifle +41 -> 124
    //   86: aload_0
    //   87: astore_1
    //   88: aload 7
    //   90: aload_2
    //   91: iconst_0
    //   92: iload 8
    //   94: invokevirtual 281	java/security/MessageDigest:update	([BII)V
    //   97: goto -25 -> 72
    //   100: astore_2
    //   101: aload_0
    //   102: astore_1
    //   103: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   106: aload_2
    //   107: invokevirtual 282	java/security/NoSuchAlgorithmException:toString	()Ljava/lang/String;
    //   110: invokestatic 56	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   121: ldc 100
    //   123: areturn
    //   124: aload_0
    //   125: astore_1
    //   126: aload 7
    //   128: invokevirtual 189	java/security/MessageDigest:digest	()[B
    //   131: invokestatic 193	com/tencent/upload/common/d:a	([B)Ljava/lang/String;
    //   134: astore_2
    //   135: aload_0
    //   136: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   139: aload_2
    //   140: areturn
    //   141: astore_0
    //   142: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   145: aload_0
    //   146: invokevirtual 284	java/io/IOException:toString	()Ljava/lang/String;
    //   149: invokestatic 56	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_2
    //   153: areturn
    //   154: astore_0
    //   155: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   158: aload_0
    //   159: invokevirtual 284	java/io/IOException:toString	()Ljava/lang/String;
    //   162: invokestatic 56	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: goto -44 -> 121
    //   168: astore_1
    //   169: aload_3
    //   170: astore_0
    //   171: aload_0
    //   172: astore_2
    //   173: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   176: aload_1
    //   177: invokevirtual 285	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   180: invokestatic 56	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload_0
    //   184: ifnull -63 -> 121
    //   187: aload_0
    //   188: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   191: goto -70 -> 121
    //   194: astore_0
    //   195: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   198: aload_0
    //   199: invokevirtual 284	java/io/IOException:toString	()Ljava/lang/String;
    //   202: invokestatic 56	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: goto -84 -> 121
    //   208: astore_1
    //   209: aload 4
    //   211: astore_0
    //   212: aload_0
    //   213: astore_2
    //   214: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   217: aload_1
    //   218: invokevirtual 286	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   221: invokestatic 56	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload_0
    //   225: ifnull -104 -> 121
    //   228: aload_0
    //   229: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   232: goto -111 -> 121
    //   235: astore_0
    //   236: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   239: aload_0
    //   240: invokevirtual 284	java/io/IOException:toString	()Ljava/lang/String;
    //   243: invokestatic 56	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: goto -125 -> 121
    //   249: astore_1
    //   250: aload 5
    //   252: astore_0
    //   253: aload_0
    //   254: astore_2
    //   255: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   258: aload_1
    //   259: invokevirtual 284	java/io/IOException:toString	()Ljava/lang/String;
    //   262: invokestatic 56	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload_0
    //   266: ifnull -145 -> 121
    //   269: aload_0
    //   270: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   273: goto -152 -> 121
    //   276: astore_0
    //   277: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   280: aload_0
    //   281: invokevirtual 284	java/io/IOException:toString	()Ljava/lang/String;
    //   284: invokestatic 56	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   287: goto -166 -> 121
    //   290: astore_0
    //   291: aload_2
    //   292: ifnull +7 -> 299
    //   295: aload_2
    //   296: invokevirtual 283	java/io/BufferedInputStream:close	()V
    //   299: aload_0
    //   300: athrow
    //   301: astore_1
    //   302: getstatic 16	com/tencent/upload/common/b:a	Ljava/lang/String;
    //   305: aload_1
    //   306: invokevirtual 284	java/io/IOException:toString	()Ljava/lang/String;
    //   309: invokestatic 56	com/tencent/upload/a/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: goto -13 -> 299
    //   315: astore_0
    //   316: aload_1
    //   317: astore_2
    //   318: goto -27 -> 291
    //   321: astore_1
    //   322: goto -69 -> 253
    //   325: astore_1
    //   326: goto -114 -> 212
    //   329: astore_1
    //   330: goto -159 -> 171
    //   333: astore_2
    //   334: aconst_null
    //   335: astore_0
    //   336: goto -235 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramFile	File
    //   0	339	1	paramString	String
    //   27	64	2	localObject1	Object
    //   100	7	2	localNoSuchAlgorithmException1	NoSuchAlgorithmException
    //   134	184	2	localObject2	Object
    //   333	1	2	localNoSuchAlgorithmException2	NoSuchAlgorithmException
    //   24	146	3	localObject3	Object
    //   15	195	4	localObject4	Object
    //   18	233	5	localObject5	Object
    //   21	22	6	localObject6	Object
    //   32	95	7	localMessageDigest	MessageDigest
    //   79	14	8	i	int
    // Exception table:
    //   from	to	target	type
    //   66	72	100	java/security/NoSuchAlgorithmException
    //   74	81	100	java/security/NoSuchAlgorithmException
    //   88	97	100	java/security/NoSuchAlgorithmException
    //   126	135	100	java/security/NoSuchAlgorithmException
    //   135	139	141	java/io/IOException
    //   117	121	154	java/io/IOException
    //   28	34	168	java/io/FileNotFoundException
    //   37	42	168	java/io/FileNotFoundException
    //   45	64	168	java/io/FileNotFoundException
    //   187	191	194	java/io/IOException
    //   28	34	208	java/lang/OutOfMemoryError
    //   37	42	208	java/lang/OutOfMemoryError
    //   45	64	208	java/lang/OutOfMemoryError
    //   228	232	235	java/io/IOException
    //   28	34	249	java/io/IOException
    //   37	42	249	java/io/IOException
    //   45	64	249	java/io/IOException
    //   269	273	276	java/io/IOException
    //   28	34	290	finally
    //   37	42	290	finally
    //   45	64	290	finally
    //   173	183	290	finally
    //   214	224	290	finally
    //   255	265	290	finally
    //   295	299	301	java/io/IOException
    //   66	72	315	finally
    //   74	81	315	finally
    //   88	97	315	finally
    //   103	113	315	finally
    //   126	135	315	finally
    //   66	72	321	java/io/IOException
    //   74	81	321	java/io/IOException
    //   88	97	321	java/io/IOException
    //   126	135	321	java/io/IOException
    //   66	72	325	java/lang/OutOfMemoryError
    //   74	81	325	java/lang/OutOfMemoryError
    //   88	97	325	java/lang/OutOfMemoryError
    //   126	135	325	java/lang/OutOfMemoryError
    //   66	72	329	java/io/FileNotFoundException
    //   74	81	329	java/io/FileNotFoundException
    //   88	97	329	java/io/FileNotFoundException
    //   126	135	329	java/io/FileNotFoundException
    //   28	34	333	java/security/NoSuchAlgorithmException
    //   37	42	333	java/security/NoSuchAlgorithmException
    //   45	64	333	java/security/NoSuchAlgorithmException
  }
  
  public static final void c(String paramString)
  {
    if ((paramString == null) || (!paramString.endsWith(".qtmp"))) {
      return;
    }
    new File(paramString).delete();
    com.tencent.upload.a.b.b(a, "deleteTempFile: " + paramString);
  }
  
  private static long d(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.isDirectory())) {}
    String[] arrayOfString;
    do
    {
      return 0L;
      arrayOfString = paramFile.list();
    } while (arrayOfString == null);
    int m = arrayOfString.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      String str = arrayOfString[i];
      k = j;
      if (str != null) {
        k = (int)(j + new File(paramFile, str).length());
      }
      i += 1;
    }
    return j;
  }
  
  private static void e(File paramFile)
  {
    String[] arrayOfString;
    if ((paramFile != null) && (paramFile.isDirectory()))
    {
      arrayOfString = paramFile.list();
      if (arrayOfString != null) {
        break label21;
      }
    }
    for (;;)
    {
      return;
      label21:
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          new File(paramFile, str).delete();
        }
        i += 1;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\upload\common\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */