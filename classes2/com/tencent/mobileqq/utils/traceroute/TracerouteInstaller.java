package com.tencent.mobileqq.utils.traceroute;

import android.content.Context;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.IOException;

public class TracerouteInstaller
{
  private static String a = "TraceRoute";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_0
    //   14: invokevirtual 35	android/content/Context:getFilesDir	()Ljava/io/File;
    //   17: invokevirtual 41	java/io/File:getPath	()Ljava/lang/String;
    //   20: astore 7
    //   22: aload_0
    //   23: invokevirtual 45	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   26: ldc 47
    //   28: invokevirtual 53	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 59	java/io/InputStream:available	()I
    //   36: istore 9
    //   38: iload 9
    //   40: newarray <illegal type>
    //   42: astore 8
    //   44: aload_0
    //   45: aload 8
    //   47: invokevirtual 63	java/io/InputStream:read	([B)I
    //   50: pop
    //   51: new 65	java/io/FileOutputStream
    //   54: dup
    //   55: new 37	java/io/File
    //   58: dup
    //   59: new 67	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   66: aload 7
    //   68: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 74
    //   73: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: astore_1
    //   86: aload_2
    //   87: astore_3
    //   88: aload_1
    //   89: astore 5
    //   91: aload_0
    //   92: astore 4
    //   94: aload_1
    //   95: aload 8
    //   97: iconst_0
    //   98: iload 9
    //   100: invokevirtual 87	java/io/FileOutputStream:write	([BII)V
    //   103: aload_2
    //   104: astore_3
    //   105: aload_1
    //   106: astore 5
    //   108: aload_0
    //   109: astore 4
    //   111: aload_0
    //   112: invokevirtual 90	java/io/InputStream:close	()V
    //   115: aload_2
    //   116: astore_3
    //   117: aload_1
    //   118: astore 5
    //   120: aload_0
    //   121: astore 4
    //   123: aload_1
    //   124: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   127: aload_2
    //   128: astore_3
    //   129: aload_1
    //   130: astore 5
    //   132: aload_0
    //   133: astore 4
    //   135: invokestatic 97	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   138: new 67	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   145: ldc 99
    //   147: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 7
    //   152: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc 74
    //   157: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokevirtual 103	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   166: astore_2
    //   167: aload_2
    //   168: astore_3
    //   169: aload_3
    //   170: invokevirtual 108	java/lang/Process:waitFor	()I
    //   173: pop
    //   174: aload_3
    //   175: invokevirtual 111	java/lang/Process:destroy	()V
    //   178: iconst_1
    //   179: istore 10
    //   181: aload_0
    //   182: ifnull +7 -> 189
    //   185: aload_0
    //   186: invokevirtual 90	java/io/InputStream:close	()V
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   197: iconst_0
    //   198: ifeq +11 -> 209
    //   201: new 113	java/lang/NullPointerException
    //   204: dup
    //   205: invokespecial 114	java/lang/NullPointerException:<init>	()V
    //   208: athrow
    //   209: iload 10
    //   211: ireturn
    //   212: astore_2
    //   213: aconst_null
    //   214: astore_0
    //   215: aconst_null
    //   216: astore_1
    //   217: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +32 -> 252
    //   223: getstatic 18	com/tencent/mobileqq/utils/traceroute/TracerouteInstaller:a	Ljava/lang/String;
    //   226: iconst_2
    //   227: new 67	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   234: ldc 122
    //   236: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 125	java/io/IOException:getMessage	()Ljava/lang/String;
    //   243: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 90	java/io/InputStream:close	()V
    //   260: aload_3
    //   261: ifnull +7 -> 268
    //   264: aload_3
    //   265: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   268: aload_0
    //   269: ifnull -60 -> 209
    //   272: aload_0
    //   273: invokevirtual 111	java/lang/Process:destroy	()V
    //   276: iconst_0
    //   277: ireturn
    //   278: astore_0
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_2
    //   282: aconst_null
    //   283: astore_1
    //   284: aconst_null
    //   285: astore_0
    //   286: aload 6
    //   288: astore_3
    //   289: aload_1
    //   290: astore 5
    //   292: aload_0
    //   293: astore 4
    //   295: invokestatic 120	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   298: ifeq +41 -> 339
    //   301: aload 6
    //   303: astore_3
    //   304: aload_1
    //   305: astore 5
    //   307: aload_0
    //   308: astore 4
    //   310: getstatic 18	com/tencent/mobileqq/utils/traceroute/TracerouteInstaller:a	Ljava/lang/String;
    //   313: iconst_2
    //   314: new 67	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   321: ldc -125
    //   323: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload_2
    //   327: invokevirtual 132	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   330: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   339: aload_0
    //   340: ifnull +7 -> 347
    //   343: aload_0
    //   344: invokevirtual 90	java/io/InputStream:close	()V
    //   347: aload_1
    //   348: ifnull +7 -> 355
    //   351: aload_1
    //   352: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   355: aload 6
    //   357: ifnull -148 -> 209
    //   360: aload 6
    //   362: invokevirtual 111	java/lang/Process:destroy	()V
    //   365: iconst_0
    //   366: ireturn
    //   367: astore_0
    //   368: iconst_0
    //   369: ireturn
    //   370: astore_2
    //   371: aconst_null
    //   372: astore_1
    //   373: aconst_null
    //   374: astore_0
    //   375: aload 4
    //   377: astore_3
    //   378: aload_0
    //   379: ifnull +7 -> 386
    //   382: aload_0
    //   383: invokevirtual 90	java/io/InputStream:close	()V
    //   386: aload_1
    //   387: ifnull +7 -> 394
    //   390: aload_1
    //   391: invokevirtual 91	java/io/FileOutputStream:close	()V
    //   394: aload_3
    //   395: ifnull +7 -> 402
    //   398: aload_3
    //   399: invokevirtual 111	java/lang/Process:destroy	()V
    //   402: aload_2
    //   403: athrow
    //   404: astore_0
    //   405: goto -216 -> 189
    //   408: astore_0
    //   409: goto -212 -> 197
    //   412: astore_0
    //   413: iconst_1
    //   414: ireturn
    //   415: astore_1
    //   416: goto -156 -> 260
    //   419: astore_1
    //   420: goto -152 -> 268
    //   423: astore_0
    //   424: goto -77 -> 347
    //   427: astore_0
    //   428: goto -73 -> 355
    //   431: astore_0
    //   432: goto -46 -> 386
    //   435: astore_0
    //   436: goto -42 -> 394
    //   439: astore_0
    //   440: goto -38 -> 402
    //   443: astore_2
    //   444: aconst_null
    //   445: astore_1
    //   446: aload 4
    //   448: astore_3
    //   449: goto -71 -> 378
    //   452: astore_2
    //   453: aload 5
    //   455: astore_1
    //   456: aload 4
    //   458: astore_0
    //   459: goto -81 -> 378
    //   462: astore_2
    //   463: goto -85 -> 378
    //   466: astore_2
    //   467: aload_1
    //   468: astore 4
    //   470: aload_3
    //   471: astore_1
    //   472: aload_0
    //   473: astore_3
    //   474: aload 4
    //   476: astore_0
    //   477: goto -99 -> 378
    //   480: astore_2
    //   481: aconst_null
    //   482: astore_1
    //   483: goto -197 -> 286
    //   486: astore_2
    //   487: goto -201 -> 286
    //   490: astore_2
    //   491: aload_3
    //   492: astore 6
    //   494: goto -208 -> 286
    //   497: astore_2
    //   498: aconst_null
    //   499: astore 4
    //   501: aload_0
    //   502: astore_1
    //   503: aload 4
    //   505: astore_0
    //   506: goto -289 -> 217
    //   509: astore_2
    //   510: aconst_null
    //   511: astore 4
    //   513: aload_1
    //   514: astore_3
    //   515: aload_0
    //   516: astore_1
    //   517: aload 4
    //   519: astore_0
    //   520: goto -303 -> 217
    //   523: astore_2
    //   524: aload_1
    //   525: astore 4
    //   527: aload_0
    //   528: astore_1
    //   529: aload_3
    //   530: astore_0
    //   531: aload 4
    //   533: astore_3
    //   534: goto -317 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	537	0	paramContext	Context
    //   85	306	1	localFileOutputStream1	java.io.FileOutputStream
    //   415	1	1	localException1	Exception
    //   419	1	1	localException2	Exception
    //   445	84	1	localObject1	Object
    //   10	158	2	localProcess	Process
    //   212	28	2	localIOException1	IOException
    //   281	46	2	localInterruptedException1	InterruptedException
    //   370	33	2	localObject2	Object
    //   443	1	2	localObject3	Object
    //   452	1	2	localObject4	Object
    //   462	1	2	localObject5	Object
    //   466	1	2	localObject6	Object
    //   480	1	2	localInterruptedException2	InterruptedException
    //   486	1	2	localInterruptedException3	InterruptedException
    //   490	1	2	localInterruptedException4	InterruptedException
    //   497	1	2	localIOException2	IOException
    //   509	1	2	localIOException3	IOException
    //   523	1	2	localIOException4	IOException
    //   12	522	3	localObject7	Object
    //   7	525	4	localObject8	Object
    //   89	365	5	localFileOutputStream2	java.io.FileOutputStream
    //   4	489	6	localObject9	Object
    //   20	131	7	str	String
    //   42	54	8	arrayOfByte	byte[]
    //   36	63	9	i	int
    //   1	209	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   22	32	212	java/io/IOException
    //   272	276	278	java/lang/Exception
    //   22	32	281	java/lang/InterruptedException
    //   360	365	367	java/lang/Exception
    //   22	32	370	finally
    //   185	189	404	java/lang/Exception
    //   193	197	408	java/lang/Exception
    //   201	209	412	java/lang/Exception
    //   256	260	415	java/lang/Exception
    //   264	268	419	java/lang/Exception
    //   343	347	423	java/lang/Exception
    //   351	355	427	java/lang/Exception
    //   382	386	431	java/lang/Exception
    //   390	394	435	java/lang/Exception
    //   398	402	439	java/lang/Exception
    //   32	86	443	finally
    //   94	103	452	finally
    //   111	115	452	finally
    //   123	127	452	finally
    //   135	167	452	finally
    //   295	301	452	finally
    //   310	339	452	finally
    //   169	178	462	finally
    //   217	252	466	finally
    //   32	86	480	java/lang/InterruptedException
    //   94	103	486	java/lang/InterruptedException
    //   111	115	486	java/lang/InterruptedException
    //   123	127	486	java/lang/InterruptedException
    //   135	167	486	java/lang/InterruptedException
    //   169	178	490	java/lang/InterruptedException
    //   32	86	497	java/io/IOException
    //   94	103	509	java/io/IOException
    //   111	115	509	java/io/IOException
    //   123	127	509	java/io/IOException
    //   135	167	509	java/io/IOException
    //   169	178	523	java/io/IOException
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext = Runtime.getRuntime().exec(paramContext.getFilesDir().getPath() + "/traceroute");
      paramContext.waitFor();
      paramContext.destroy();
      return true;
    }
    catch (InterruptedException paramContext)
    {
      return false;
    }
    catch (IOException paramContext) {}
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\utils\traceroute\TracerouteInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */