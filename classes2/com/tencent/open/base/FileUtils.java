package com.tencent.open.base;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.Common;
import java.io.File;

public class FileUtils
{
  protected static final String a = FileUtils.class.getName();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    int i = paramString.lastIndexOf(".");
    if (i >= 0) {}
    int j;
    for (String str = paramString.substring(i);; str = ".png")
    {
      j = 5381;
      i = 0;
      int k = paramString.length();
      while (i < k)
      {
        j += (j << 5) + paramString.charAt(i);
        i += 1;
      }
    }
    return String.valueOf(j & 0x7FFFFFFF) + str;
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 11
    //   9: invokestatic 73	com/tencent/open/appcommon/Common:a	()Z
    //   12: ifne +11 -> 23
    //   15: ldc 75
    //   17: ldc 77
    //   19: invokestatic 83	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: return
    //   23: aload_0
    //   24: invokevirtual 89	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   27: invokevirtual 95	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   30: aload_1
    //   31: invokevirtual 101	android/content/res/AssetManager:list	(Ljava/lang/String;)[Ljava/lang/String;
    //   34: astore 8
    //   36: new 103	java/io/File
    //   39: dup
    //   40: aload_2
    //   41: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 7
    //   46: iload 11
    //   48: istore 10
    //   50: aload 7
    //   52: invokevirtual 109	java/io/File:exists	()Z
    //   55: ifne +15 -> 70
    //   58: iload 11
    //   60: istore 10
    //   62: aload 7
    //   64: invokevirtual 112	java/io/File:mkdirs	()Z
    //   67: ifne +3 -> 70
    //   70: iload 10
    //   72: aload 8
    //   74: arraylength
    //   75: if_icmpge -53 -> 22
    //   78: aload 8
    //   80: iload 10
    //   82: aaload
    //   83: astore_3
    //   84: aload_3
    //   85: ldc 29
    //   87: invokevirtual 116	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: ifne +194 -> 284
    //   93: aload_1
    //   94: invokevirtual 43	java/lang/String:length	()I
    //   97: ifne +81 -> 178
    //   100: aload_0
    //   101: aload_3
    //   102: new 51	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   109: aload_2
    //   110: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   116: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_3
    //   120: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   126: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 121	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   135: iconst_0
    //   136: ifeq +11 -> 147
    //   139: new 123	java/lang/NullPointerException
    //   142: dup
    //   143: invokespecial 124	java/lang/NullPointerException:<init>	()V
    //   146: athrow
    //   147: iconst_0
    //   148: ifeq +11 -> 159
    //   151: new 123	java/lang/NullPointerException
    //   154: dup
    //   155: invokespecial 124	java/lang/NullPointerException:<init>	()V
    //   158: athrow
    //   159: iload 10
    //   161: iconst_1
    //   162: iadd
    //   163: istore 10
    //   165: goto -95 -> 70
    //   168: astore_0
    //   169: ldc 126
    //   171: ldc -128
    //   173: aload_0
    //   174: invokestatic 132	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: return
    //   178: aload_0
    //   179: new 51	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   186: aload_1
    //   187: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   193: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: aload_3
    //   197: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: new 51	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   210: aload_2
    //   211: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   217: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_3
    //   221: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: getstatic 119	java/io/File:separator	Ljava/lang/String;
    //   227: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 121	com/tencent/open/base/FileUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   236: goto -101 -> 135
    //   239: astore_2
    //   240: aconst_null
    //   241: astore_0
    //   242: aload 6
    //   244: astore_1
    //   245: ldc 126
    //   247: ldc -122
    //   249: aload_2
    //   250: invokestatic 132	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload_1
    //   254: ifnull +7 -> 261
    //   257: aload_1
    //   258: invokevirtual 139	java/io/InputStream:close	()V
    //   261: aload_0
    //   262: ifnull -240 -> 22
    //   265: aload_0
    //   266: invokevirtual 142	java/io/OutputStream:close	()V
    //   269: return
    //   270: astore_0
    //   271: aload_0
    //   272: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   275: return
    //   276: astore_3
    //   277: aload_3
    //   278: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   281: goto -122 -> 159
    //   284: new 103	java/io/File
    //   287: dup
    //   288: aload 7
    //   290: aload_3
    //   291: invokespecial 148	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   294: astore 4
    //   296: aload 4
    //   298: invokevirtual 109	java/io/File:exists	()Z
    //   301: ifeq +9 -> 310
    //   304: aload 4
    //   306: invokevirtual 151	java/io/File:delete	()Z
    //   309: pop
    //   310: aload_1
    //   311: invokevirtual 43	java/lang/String:length	()I
    //   314: ifeq +87 -> 401
    //   317: aload_0
    //   318: invokevirtual 152	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   321: new 51	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   328: aload_1
    //   329: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc -102
    //   334: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload_3
    //   338: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokevirtual 158	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   347: astore_3
    //   348: new 160	java/io/FileOutputStream
    //   351: dup
    //   352: aload 4
    //   354: invokespecial 163	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   357: astore 4
    //   359: sipush 1024
    //   362: newarray <illegal type>
    //   364: astore 9
    //   366: aload_3
    //   367: aload 9
    //   369: invokevirtual 167	java/io/InputStream:read	([B)I
    //   372: istore 11
    //   374: iload 11
    //   376: ifle +37 -> 413
    //   379: aload 4
    //   381: aload 9
    //   383: iconst_0
    //   384: iload 11
    //   386: invokevirtual 171	java/io/OutputStream:write	([BII)V
    //   389: goto -23 -> 366
    //   392: astore_2
    //   393: aload_3
    //   394: astore_1
    //   395: aload 4
    //   397: astore_0
    //   398: goto -153 -> 245
    //   401: aload_0
    //   402: invokevirtual 152	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   405: aload_3
    //   406: invokevirtual 158	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   409: astore_3
    //   410: goto -62 -> 348
    //   413: aload_3
    //   414: ifnull +7 -> 421
    //   417: aload_3
    //   418: invokevirtual 139	java/io/InputStream:close	()V
    //   421: aload 4
    //   423: ifnull -264 -> 159
    //   426: aload 4
    //   428: invokevirtual 142	java/io/OutputStream:close	()V
    //   431: goto -272 -> 159
    //   434: astore_3
    //   435: aload_3
    //   436: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   439: goto -280 -> 159
    //   442: astore_0
    //   443: aconst_null
    //   444: astore_3
    //   445: aload 5
    //   447: astore_1
    //   448: aload_3
    //   449: ifnull +7 -> 456
    //   452: aload_3
    //   453: invokevirtual 139	java/io/InputStream:close	()V
    //   456: aload_1
    //   457: ifnull +7 -> 464
    //   460: aload_1
    //   461: invokevirtual 142	java/io/OutputStream:close	()V
    //   464: aload_0
    //   465: athrow
    //   466: astore_1
    //   467: aload_1
    //   468: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   471: goto -7 -> 464
    //   474: astore_0
    //   475: aload 5
    //   477: astore_1
    //   478: goto -30 -> 448
    //   481: astore_0
    //   482: aload 4
    //   484: astore_1
    //   485: goto -37 -> 448
    //   488: astore_2
    //   489: aload_1
    //   490: astore_3
    //   491: aload_0
    //   492: astore_1
    //   493: aload_2
    //   494: astore_0
    //   495: goto -47 -> 448
    //   498: astore_2
    //   499: aconst_null
    //   500: astore_0
    //   501: aload_3
    //   502: astore_1
    //   503: goto -258 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	paramContext	Context
    //   0	506	1	paramString1	String
    //   0	506	2	paramString2	String
    //   83	138	3	str1	String
    //   276	62	3	localIOException1	java.io.IOException
    //   347	71	3	localInputStream	java.io.InputStream
    //   434	2	3	localIOException2	java.io.IOException
    //   444	58	3	str2	String
    //   294	189	4	localObject1	Object
    //   1	475	5	localObject2	Object
    //   4	239	6	localObject3	Object
    //   44	245	7	localFile	File
    //   34	45	8	arrayOfString	String[]
    //   364	18	9	arrayOfByte	byte[]
    //   48	116	10	i	int
    //   7	378	11	j	int
    // Exception table:
    //   from	to	target	type
    //   23	36	168	java/io/IOException
    //   84	135	239	java/lang/Exception
    //   178	236	239	java/lang/Exception
    //   284	310	239	java/lang/Exception
    //   310	348	239	java/lang/Exception
    //   401	410	239	java/lang/Exception
    //   257	261	270	java/io/IOException
    //   265	269	270	java/io/IOException
    //   139	147	276	java/io/IOException
    //   151	159	276	java/io/IOException
    //   359	366	392	java/lang/Exception
    //   366	374	392	java/lang/Exception
    //   379	389	392	java/lang/Exception
    //   417	421	434	java/io/IOException
    //   426	431	434	java/io/IOException
    //   84	135	442	finally
    //   178	236	442	finally
    //   284	310	442	finally
    //   310	348	442	finally
    //   401	410	442	finally
    //   452	456	466	java/io/IOException
    //   460	464	466	java/io/IOException
    //   348	359	474	finally
    //   359	366	481	finally
    //   366	374	481	finally
    //   379	389	481	finally
    //   245	253	488	finally
    //   348	359	498	java/lang/Exception
  }
  
  public static void a(String paramString1, String paramString2)
  {
    Object localObject = CommonDataAdapter.a().a();
    if (localObject != null)
    {
      a((Context)localObject, paramString1, paramString2);
      label208:
      label217:
      do
      {
        try
        {
          ZipUtils.a(paramString2, Common.m());
          if (new File(Common.m()).exists())
          {
            paramString1 = MD5Utils.a(Common.m());
            if (!TextUtils.isEmpty(paramString1))
            {
              paramString2 = new File(paramString2);
              localObject = new File(Common.e() + File.separator + paramString1);
              if (paramString2.exists())
              {
                if (!((File)localObject).exists()) {
                  continue;
                }
                if (!((File)localObject).renameTo(new File(Common.k() + SystemClock.currentThreadTimeMillis()))) {
                  break label217;
                }
                LogUtility.b(a, "<zipAssets> md5Dir exists, rename md5Dir to systemOldFile successful");
                if (!paramString2.renameTo((File)localObject)) {
                  break label208;
                }
                Common.d(paramString1);
                LogUtility.b(a, "<zipAssets> md5Dir exists, rename tmpDir to md5Dir successful");
              }
            }
          }
          return;
        }
        catch (Exception paramString1)
        {
          for (;;)
          {
            LogUtility.e(a, "zipAssets error : " + paramString1.toString());
          }
          LogUtility.c(a, "<zipAssets> md5Dir exists, rename tmpDir to md5Dir failed");
          return;
        }
        LogUtility.b(a, "<zipAssets> md5Dir exists, rename md5Dir to systemOldFile failed");
        return;
      } while (!paramString2.renameTo((File)localObject));
      LogUtility.b(a, "<zipAssets> md5Dir not exists, rename tmpDir to md5Dir successful");
      Common.d(paramString1);
      return;
    }
    LogUtility.e(a, "plugin context is null !!!");
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          if (!a(arrayOfFile[i])) {
            return false;
          }
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */