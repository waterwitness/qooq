package com.tencent.ttpic.util;

import android.graphics.PointF;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VideoUtil
{
  public static final String RES_PREFIX_ASSETS = "assets://";
  public static final String RES_PREFIX_HTTP = "http://";
  public static final String RES_PREFIX_HTTPS = "https://";
  public static final String RES_PREFIX_STORAGE = "/";
  private static final String TAG = VideoUtil.class.getSimpleName();
  public static final String THREAD_NAME_MEM = "mMemThread";
  
  public static List<Integer> arrayToList(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (isEmpty(paramArrayOfInt)) {}
    for (;;)
    {
      return localArrayList;
      int j = paramArrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
        i += 1;
      }
    }
  }
  
  public static float getFaceAngle(List<PointF> paramList)
  {
    if (isEmpty(paramList))
    {
      f1 = 0.0F;
      return f1;
    }
    PointF localPointF = (PointF)paramList.get(0);
    paramList = (PointF)paramList.get(18);
    float f1 = paramList.x - localPointF.x;
    float f2 = paramList.x - localPointF.x;
    float f3 = paramList.y - localPointF.y;
    f2 = (f1 * f2 + 0.0F * f3) / ((float)Math.sqrt(f1 * f1 + 0.0F * 0.0F) * (float)Math.sqrt(f2 * f2 + f3 * f3));
    if ((f2 < -1.0F) && (f2 > -2.0F)) {
      f1 = -1.0F;
    }
    for (;;)
    {
      f2 = (float)Math.acos(f1);
      f1 = f2;
      if (localPointF.y >= paramList.y) {
        break;
      }
      return -f2;
      f1 = f2;
      if (f2 > 1.0F)
      {
        f1 = f2;
        if (f2 < 2.0F) {
          f1 = 1.0F;
        }
      }
    }
  }
  
  public static String getRealPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("assets://")) {
      return paramString;
    }
    return paramString.substring("assets://".length());
  }
  
  public static boolean hasHoneycomb()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean hasJellyBeanMR1()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean hasJellyBeanMR2()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static boolean hasKitKat()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  public static boolean indexOutOfBounds(Collection paramCollection, int paramInt)
  {
    return (paramCollection == null) || (paramInt < 0) || (paramInt >= paramCollection.size());
  }
  
  public static boolean isEmpty(@Nullable Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  private static boolean isEmpty(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt == null) || (paramArrayOfInt.length == 0);
  }
  
  public static void printLength(BaseFilter paramBaseFilter)
  {
    int i = 0;
    while (paramBaseFilter != null)
    {
      i += 1;
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
    Log.d(TAG, "[Length] filter : " + i);
  }
  
  public static void printLength(Frame paramFrame)
  {
    int i = 0;
    while ((paramFrame != null) && (paramFrame.getTextureId() != 0))
    {
      i += 1;
      paramFrame = paramFrame.nextFrame;
    }
    Log.d(TAG, "[Length] frame : " + i);
  }
  
  /* Error */
  public static String unZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore 10
    //   9: iload 10
    //   11: ifeq +10 -> 21
    //   14: aconst_null
    //   15: astore_1
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: new 178	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 184	java/io/File:exists	()Z
    //   34: ifne +8 -> 42
    //   37: aconst_null
    //   38: astore_1
    //   39: goto -23 -> 16
    //   42: new 178	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_2
    //   51: aload_2
    //   52: invokevirtual 184	java/io/File:exists	()Z
    //   55: ifne +8 -> 63
    //   58: aload_2
    //   59: invokevirtual 187	java/io/File:mkdirs	()Z
    //   62: pop
    //   63: aconst_null
    //   64: astore 5
    //   66: aconst_null
    //   67: astore 6
    //   69: aconst_null
    //   70: astore_3
    //   71: aconst_null
    //   72: astore 7
    //   74: aconst_null
    //   75: astore 4
    //   77: aconst_null
    //   78: astore_2
    //   79: new 189	java/io/FileInputStream
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 192	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   87: astore_0
    //   88: new 194	java/util/zip/ZipInputStream
    //   91: dup
    //   92: new 196	java/io/BufferedInputStream
    //   95: dup
    //   96: aload_0
    //   97: invokespecial 199	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: invokespecial 200	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   103: astore_3
    //   104: aconst_null
    //   105: astore_2
    //   106: aconst_null
    //   107: astore 4
    //   109: aload 6
    //   111: astore 5
    //   113: aload_3
    //   114: invokevirtual 204	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   117: astore 7
    //   119: aload 7
    //   121: ifnull +366 -> 487
    //   124: aload 7
    //   126: invokevirtual 209	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   129: astore 8
    //   131: aload 5
    //   133: astore 6
    //   135: aload 8
    //   137: ldc -45
    //   139: invokevirtual 214	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   142: ifne -33 -> 109
    //   145: aload 7
    //   147: invokevirtual 217	java/util/zip/ZipEntry:isDirectory	()Z
    //   150: ifeq +73 -> 223
    //   153: new 178	java/io/File
    //   156: dup
    //   157: new 141	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   164: aload_1
    //   165: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: getstatic 220	java/io/File:separator	Ljava/lang/String;
    //   171: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload 8
    //   176: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   185: astore 7
    //   187: aload 7
    //   189: invokevirtual 184	java/io/File:exists	()Z
    //   192: ifne +9 -> 201
    //   195: aload 7
    //   197: invokevirtual 187	java/io/File:mkdirs	()Z
    //   200: pop
    //   201: aload 5
    //   203: astore 6
    //   205: aload 5
    //   207: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   210: ifeq -101 -> 109
    //   213: aload 7
    //   215: invokevirtual 223	java/io/File:getPath	()Ljava/lang/String;
    //   218: astore 6
    //   220: goto -111 -> 109
    //   223: sipush 4096
    //   226: newarray <illegal type>
    //   228: astore 7
    //   230: new 178	java/io/File
    //   233: dup
    //   234: new 141	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   241: aload_1
    //   242: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: getstatic 220	java/io/File:separator	Ljava/lang/String;
    //   248: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload 8
    //   253: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;)V
    //   262: astore 6
    //   264: new 225	java/io/FileOutputStream
    //   267: dup
    //   268: aload 6
    //   270: invokespecial 226	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   273: astore 6
    //   275: new 228	java/io/BufferedOutputStream
    //   278: dup
    //   279: aload 6
    //   281: sipush 4096
    //   284: invokespecial 231	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   287: astore 4
    //   289: aload_3
    //   290: aload 7
    //   292: invokevirtual 235	java/util/zip/ZipInputStream:read	([B)I
    //   295: istore 9
    //   297: iload 9
    //   299: iconst_m1
    //   300: if_icmpeq +66 -> 366
    //   303: aload 4
    //   305: aload 7
    //   307: iconst_0
    //   308: iload 9
    //   310: invokevirtual 239	java/io/BufferedOutputStream:write	([BII)V
    //   313: goto -24 -> 289
    //   316: astore_2
    //   317: aload 4
    //   319: astore_2
    //   320: aload_2
    //   321: ifnull +7 -> 328
    //   324: aload_2
    //   325: invokevirtual 242	java/io/BufferedOutputStream:close	()V
    //   328: aload_2
    //   329: astore 8
    //   331: aload 6
    //   333: astore 7
    //   335: aload 6
    //   337: ifnull +15 -> 352
    //   340: aload 6
    //   342: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   345: aload 6
    //   347: astore 7
    //   349: aload_2
    //   350: astore 8
    //   352: aload 8
    //   354: astore_2
    //   355: aload 7
    //   357: astore 4
    //   359: aload 5
    //   361: astore 6
    //   363: goto -254 -> 109
    //   366: aload 4
    //   368: invokevirtual 246	java/io/BufferedOutputStream:flush	()V
    //   371: aload 4
    //   373: ifnull +8 -> 381
    //   376: aload 4
    //   378: invokevirtual 242	java/io/BufferedOutputStream:close	()V
    //   381: aload 4
    //   383: astore 8
    //   385: aload 6
    //   387: astore 7
    //   389: aload 6
    //   391: ifnull -39 -> 352
    //   394: aload 6
    //   396: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   399: aload 4
    //   401: astore 8
    //   403: aload 6
    //   405: astore 7
    //   407: goto -55 -> 352
    //   410: astore_2
    //   411: aload 4
    //   413: astore 8
    //   415: aload 6
    //   417: astore 7
    //   419: goto -67 -> 352
    //   422: astore_1
    //   423: aload 4
    //   425: astore 6
    //   427: aload_2
    //   428: astore 4
    //   430: aload 4
    //   432: ifnull +8 -> 440
    //   435: aload 4
    //   437: invokevirtual 242	java/io/BufferedOutputStream:close	()V
    //   440: aload 6
    //   442: ifnull +8 -> 450
    //   445: aload 6
    //   447: invokevirtual 243	java/io/FileOutputStream:close	()V
    //   450: aload_1
    //   451: athrow
    //   452: astore_1
    //   453: aload_3
    //   454: astore_1
    //   455: aload_1
    //   456: ifnull +7 -> 463
    //   459: aload_1
    //   460: invokevirtual 247	java/util/zip/ZipInputStream:close	()V
    //   463: aload 5
    //   465: astore_1
    //   466: aload_0
    //   467: ifnull -451 -> 16
    //   470: aload_0
    //   471: invokevirtual 248	java/io/FileInputStream:close	()V
    //   474: aload 5
    //   476: astore_1
    //   477: goto -461 -> 16
    //   480: astore_0
    //   481: aload 5
    //   483: astore_1
    //   484: goto -468 -> 16
    //   487: aload_3
    //   488: ifnull +7 -> 495
    //   491: aload_3
    //   492: invokevirtual 247	java/util/zip/ZipInputStream:close	()V
    //   495: aload_0
    //   496: ifnull +7 -> 503
    //   499: aload_0
    //   500: invokevirtual 248	java/io/FileInputStream:close	()V
    //   503: aload 5
    //   505: astore_1
    //   506: goto -490 -> 16
    //   509: astore_0
    //   510: aload 5
    //   512: astore_1
    //   513: goto -497 -> 16
    //   516: astore_1
    //   517: aload 4
    //   519: astore_2
    //   520: aload_3
    //   521: astore_0
    //   522: aload_2
    //   523: ifnull +7 -> 530
    //   526: aload_2
    //   527: invokevirtual 247	java/util/zip/ZipInputStream:close	()V
    //   530: aload_0
    //   531: ifnull +7 -> 538
    //   534: aload_0
    //   535: invokevirtual 248	java/io/FileInputStream:close	()V
    //   538: aload_1
    //   539: athrow
    //   540: astore_0
    //   541: ldc 2
    //   543: monitorexit
    //   544: aload_0
    //   545: athrow
    //   546: astore_0
    //   547: goto -9 -> 538
    //   550: astore_1
    //   551: aload 4
    //   553: astore_2
    //   554: goto -32 -> 522
    //   557: astore_1
    //   558: aload_3
    //   559: astore_2
    //   560: goto -38 -> 522
    //   563: astore_1
    //   564: aload_3
    //   565: astore_2
    //   566: goto -44 -> 522
    //   569: astore_0
    //   570: aload 7
    //   572: astore_0
    //   573: aload_2
    //   574: astore_1
    //   575: goto -120 -> 455
    //   578: astore_1
    //   579: aload_2
    //   580: astore_1
    //   581: goto -126 -> 455
    //   584: astore_1
    //   585: aload_3
    //   586: astore_1
    //   587: goto -132 -> 455
    //   590: astore_2
    //   591: goto -141 -> 450
    //   594: astore_1
    //   595: aload_2
    //   596: astore 4
    //   598: goto -168 -> 430
    //   601: astore_1
    //   602: goto -172 -> 430
    //   605: astore 4
    //   607: aload_2
    //   608: astore 8
    //   610: aload 6
    //   612: astore 7
    //   614: goto -262 -> 352
    //   617: astore 6
    //   619: aload 4
    //   621: astore 6
    //   623: goto -303 -> 320
    //   626: astore 4
    //   628: goto -308 -> 320
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	paramString1	String
    //   0	631	1	paramString2	String
    //   50	56	2	localFile	java.io.File
    //   316	1	2	localIOException1	java.io.IOException
    //   319	36	2	localObject1	Object
    //   410	18	2	localIOException2	java.io.IOException
    //   519	61	2	localObject2	Object
    //   590	18	2	localIOException3	java.io.IOException
    //   70	516	3	localZipInputStream	java.util.zip.ZipInputStream
    //   75	522	4	localObject3	Object
    //   605	15	4	localIOException4	java.io.IOException
    //   626	1	4	localIOException5	java.io.IOException
    //   64	447	5	localObject4	Object
    //   67	544	6	localObject5	Object
    //   617	1	6	localIOException6	java.io.IOException
    //   621	1	6	localObject6	Object
    //   72	541	7	localObject7	Object
    //   129	480	8	localObject8	Object
    //   295	14	9	i	int
    //   7	3	10	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   289	297	316	java/io/IOException
    //   303	313	316	java/io/IOException
    //   366	371	316	java/io/IOException
    //   376	381	410	java/io/IOException
    //   394	399	410	java/io/IOException
    //   264	275	422	finally
    //   450	452	452	java/io/IOException
    //   459	463	480	java/io/IOException
    //   470	474	480	java/io/IOException
    //   491	495	509	java/io/IOException
    //   499	503	509	java/io/IOException
    //   79	88	516	finally
    //   3	9	540	finally
    //   21	37	540	finally
    //   42	63	540	finally
    //   459	463	540	finally
    //   470	474	540	finally
    //   491	495	540	finally
    //   499	503	540	finally
    //   526	530	540	finally
    //   534	538	540	finally
    //   538	540	540	finally
    //   526	530	546	java/io/IOException
    //   534	538	546	java/io/IOException
    //   88	104	550	finally
    //   113	119	557	finally
    //   124	131	557	finally
    //   135	201	557	finally
    //   205	220	557	finally
    //   223	264	557	finally
    //   324	328	563	finally
    //   340	345	563	finally
    //   376	381	563	finally
    //   394	399	563	finally
    //   435	440	563	finally
    //   445	450	563	finally
    //   450	452	563	finally
    //   79	88	569	java/io/IOException
    //   88	104	578	java/io/IOException
    //   113	119	584	java/io/IOException
    //   124	131	584	java/io/IOException
    //   135	201	584	java/io/IOException
    //   205	220	584	java/io/IOException
    //   223	264	584	java/io/IOException
    //   435	440	590	java/io/IOException
    //   445	450	590	java/io/IOException
    //   275	289	594	finally
    //   289	297	601	finally
    //   303	313	601	finally
    //   366	371	601	finally
    //   324	328	605	java/io/IOException
    //   340	345	605	java/io/IOException
    //   264	275	617	java/io/IOException
    //   275	289	626	java/io/IOException
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\VideoUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */