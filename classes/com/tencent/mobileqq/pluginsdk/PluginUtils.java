package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PluginUtils
{
  public static final String CONFIG_FILE_EXTEND_NAME = ".cfg";
  private static final int a = 8192;
  private static Map b = new ConcurrentHashMap();
  private static Map c = new ConcurrentHashMap();
  private static final String d = ".tmp";
  
  private static File a(Context paramContext, String paramString)
  {
    File localFile = (File)b.get(paramString);
    Object localObject = localFile;
    if (localFile == null)
    {
      localObject = getPluginInstallDir(paramContext);
      if (localObject == null) {
        localObject = null;
      }
    }
    else
    {
      return (File)localObject;
    }
    int i = paramString.lastIndexOf('.');
    if ((i != -1) && (!paramString.substring(i).equalsIgnoreCase(".apk"))) {
      paramContext = paramString.substring(0, i) + ".apk";
    }
    for (;;)
    {
      paramString = new File((File)localObject, paramContext);
      localObject = paramString;
      if (paramString == null) {
        break;
      }
      b.put(paramContext, paramString);
      return paramString;
      paramContext = paramString;
      if (i == -1) {
        paramContext = paramString + ".apk";
      }
    }
  }
  
  /* Error */
  public static String extractLibs(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_1
    //   7: astore 5
    //   9: aload_1
    //   10: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   13: invokevirtual 94	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   16: ifne +25 -> 41
    //   19: new 65	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   26: aload_1
    //   27: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   33: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 5
    //   41: new 96	com/tencent/commonsdk/zip/QZipFile
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 99	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   49: astore 4
    //   51: aload 4
    //   53: astore_3
    //   54: aload 4
    //   56: invokevirtual 105	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   59: astore 9
    //   61: aconst_null
    //   62: astore_1
    //   63: aload 4
    //   65: astore_3
    //   66: aload 9
    //   68: invokeinterface 111 1 0
    //   73: ifeq +231 -> 304
    //   76: aload 4
    //   78: astore_3
    //   79: aload 9
    //   81: invokeinterface 115 1 0
    //   86: checkcast 117	java/util/zip/ZipEntry
    //   89: invokevirtual 120	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   92: astore_2
    //   93: aload 4
    //   95: astore_3
    //   96: aload_2
    //   97: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   100: invokevirtual 94	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   103: ifne -40 -> 63
    //   106: aload 4
    //   108: astore_3
    //   109: aload_2
    //   110: ldc 122
    //   112: invokevirtual 126	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   115: ifne -52 -> 63
    //   118: aload 4
    //   120: astore_3
    //   121: new 43	java/io/File
    //   124: dup
    //   125: new 65	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   132: aload 5
    //   134: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload_2
    //   138: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   147: astore 6
    //   149: aload_1
    //   150: astore_2
    //   151: aload 6
    //   153: ifnull +701 -> 854
    //   156: aload 4
    //   158: astore_3
    //   159: aload 6
    //   161: invokevirtual 128	java/io/File:getName	()Ljava/lang/String;
    //   164: getstatic 133	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   167: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   170: ifeq +13 -> 183
    //   173: aload 4
    //   175: astore_3
    //   176: getstatic 133	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   179: astore_2
    //   180: goto +674 -> 854
    //   183: aload 4
    //   185: astore_3
    //   186: getstatic 142	android/os/Build$VERSION:SDK_INT	I
    //   189: bipush 7
    //   191: if_icmple +36 -> 227
    //   194: aload 4
    //   196: astore_3
    //   197: aload 6
    //   199: invokevirtual 128	java/io/File:getName	()Ljava/lang/String;
    //   202: getstatic 145	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   205: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   208: ifeq +19 -> 227
    //   211: aload_1
    //   212: ifnonnull +15 -> 227
    //   215: aload 4
    //   217: astore_3
    //   218: getstatic 145	android/os/Build:CPU_ABI2	Ljava/lang/String;
    //   221: astore_2
    //   222: aload_2
    //   223: astore_1
    //   224: goto -75 -> 149
    //   227: aload 4
    //   229: astore_3
    //   230: getstatic 133	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   233: ldc -109
    //   235: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifeq +53 -> 291
    //   241: aload_1
    //   242: ifnonnull +49 -> 291
    //   245: aload 4
    //   247: astore_3
    //   248: aload 6
    //   250: invokevirtual 128	java/io/File:getName	()Ljava/lang/String;
    //   253: ldc -107
    //   255: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   258: ifne +19 -> 277
    //   261: aload 4
    //   263: astore_3
    //   264: aload 6
    //   266: invokevirtual 128	java/io/File:getName	()Ljava/lang/String;
    //   269: ldc -105
    //   271: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   274: ifeq +17 -> 291
    //   277: aload 4
    //   279: astore_3
    //   280: aload 6
    //   282: invokevirtual 128	java/io/File:getName	()Ljava/lang/String;
    //   285: astore_2
    //   286: aload_2
    //   287: astore_1
    //   288: goto -139 -> 149
    //   291: aload 4
    //   293: astore_3
    //   294: aload 6
    //   296: invokevirtual 155	java/io/File:getParentFile	()Ljava/io/File;
    //   299: astore 6
    //   301: goto -152 -> 149
    //   304: aload 4
    //   306: invokestatic 161	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   309: aconst_null
    //   310: astore_2
    //   311: aload_1
    //   312: astore 4
    //   314: aload_2
    //   315: astore_1
    //   316: aload 8
    //   318: astore_3
    //   319: aload_2
    //   320: ifnonnull +320 -> 640
    //   323: aload_2
    //   324: astore_1
    //   325: aload 8
    //   327: astore_3
    //   328: aload 4
    //   330: ifnull +310 -> 640
    //   333: new 101	java/util/zip/ZipFile
    //   336: dup
    //   337: aload_0
    //   338: invokespecial 162	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   341: astore_1
    //   342: aload_1
    //   343: astore_3
    //   344: sipush 4096
    //   347: newarray <illegal type>
    //   349: astore 9
    //   351: aload_1
    //   352: astore_3
    //   353: aload_1
    //   354: invokevirtual 105	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   357: astore 10
    //   359: aload_2
    //   360: astore_0
    //   361: aload_1
    //   362: astore_3
    //   363: aload 10
    //   365: invokeinterface 111 1 0
    //   370: ifeq +477 -> 847
    //   373: aload_1
    //   374: astore_3
    //   375: aload 10
    //   377: invokeinterface 115 1 0
    //   382: checkcast 117	java/util/zip/ZipEntry
    //   385: astore 11
    //   387: aload_1
    //   388: astore_3
    //   389: aload 11
    //   391: invokevirtual 120	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   394: astore 8
    //   396: aload_1
    //   397: astore_3
    //   398: aload 8
    //   400: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   403: invokevirtual 94	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   406: ifne -45 -> 361
    //   409: aload_1
    //   410: astore_3
    //   411: aload 8
    //   413: ldc 122
    //   415: invokevirtual 126	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   418: ifne -57 -> 361
    //   421: aload_1
    //   422: astore_3
    //   423: new 43	java/io/File
    //   426: dup
    //   427: new 65	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   434: aload 5
    //   436: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 8
    //   441: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   450: astore 6
    //   452: aload_1
    //   453: astore_3
    //   454: aload 8
    //   456: getstatic 91	java/io/File:separator	Ljava/lang/String;
    //   459: invokevirtual 165	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   462: istore 12
    //   464: aload 8
    //   466: astore_2
    //   467: iload 12
    //   469: iconst_m1
    //   470: if_icmpeq +15 -> 485
    //   473: aload_1
    //   474: astore_3
    //   475: aload 8
    //   477: iload 12
    //   479: iconst_1
    //   480: iadd
    //   481: invokevirtual 57	java/lang/String:substring	(I)Ljava/lang/String;
    //   484: astore_2
    //   485: aload_1
    //   486: astore_3
    //   487: new 43	java/io/File
    //   490: dup
    //   491: new 65	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   498: aload 5
    //   500: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_2
    //   504: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   513: astore 8
    //   515: aload 6
    //   517: astore_2
    //   518: aload_2
    //   519: ifnull +322 -> 841
    //   522: aload_1
    //   523: astore_3
    //   524: aload_2
    //   525: invokevirtual 128	java/io/File:getName	()Ljava/lang/String;
    //   528: aload 4
    //   530: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   533: ifeq +154 -> 687
    //   536: iconst_1
    //   537: istore 12
    //   539: iload 12
    //   541: ifeq +209 -> 750
    //   544: aload_1
    //   545: astore_3
    //   546: aload 8
    //   548: invokevirtual 155	java/io/File:getParentFile	()Ljava/io/File;
    //   551: invokevirtual 168	java/io/File:mkdirs	()Z
    //   554: pop
    //   555: aload_1
    //   556: aload 11
    //   558: invokevirtual 172	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   561: astore_2
    //   562: new 174	java/io/FileOutputStream
    //   565: dup
    //   566: aload 8
    //   568: invokespecial 177	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   571: astore 6
    //   573: aload_2
    //   574: aload 9
    //   576: invokevirtual 183	java/io/InputStream:read	([B)I
    //   579: istore 12
    //   581: iload 12
    //   583: ifle +114 -> 697
    //   586: aload 6
    //   588: aload 9
    //   590: iconst_0
    //   591: iload 12
    //   593: invokevirtual 187	java/io/FileOutputStream:write	([BII)V
    //   596: goto -23 -> 573
    //   599: astore_3
    //   600: aload_2
    //   601: astore_0
    //   602: aload 6
    //   604: astore_2
    //   605: aload_3
    //   606: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   609: aload_3
    //   610: invokestatic 194	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   613: astore 6
    //   615: aload_1
    //   616: astore_3
    //   617: aload_2
    //   618: invokestatic 198	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   621: aload_1
    //   622: astore_3
    //   623: aload_0
    //   624: invokestatic 198	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   627: aload 6
    //   629: astore_0
    //   630: aload_0
    //   631: astore_2
    //   632: aload_0
    //   633: ifnull +119 -> 752
    //   636: aload_1
    //   637: astore_3
    //   638: aload_0
    //   639: astore_1
    //   640: aload_3
    //   641: invokestatic 161	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   644: aload_1
    //   645: areturn
    //   646: astore_2
    //   647: aconst_null
    //   648: astore 4
    //   650: aconst_null
    //   651: astore_1
    //   652: aload 4
    //   654: astore_3
    //   655: aload_2
    //   656: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   659: aload 4
    //   661: astore_3
    //   662: aload_2
    //   663: invokestatic 194	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   666: astore_2
    //   667: aload 4
    //   669: invokestatic 161	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   672: aload_1
    //   673: astore 4
    //   675: goto -361 -> 314
    //   678: astore_0
    //   679: aconst_null
    //   680: astore_3
    //   681: aload_3
    //   682: invokestatic 161	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   685: aload_0
    //   686: athrow
    //   687: aload_1
    //   688: astore_3
    //   689: aload_2
    //   690: invokevirtual 155	java/io/File:getParentFile	()Ljava/io/File;
    //   693: astore_2
    //   694: goto -176 -> 518
    //   697: aload_1
    //   698: astore_3
    //   699: aload 6
    //   701: invokestatic 198	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   704: aload_1
    //   705: astore_3
    //   706: aload_2
    //   707: invokestatic 198	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   710: goto -80 -> 630
    //   713: aload_1
    //   714: astore_3
    //   715: aload 4
    //   717: invokestatic 198	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   720: aload_1
    //   721: astore_3
    //   722: aload_2
    //   723: invokestatic 198	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   726: aload_1
    //   727: astore_3
    //   728: aload_0
    //   729: athrow
    //   730: astore_0
    //   731: aload_1
    //   732: astore_3
    //   733: aload_0
    //   734: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   737: aload_1
    //   738: astore_3
    //   739: aload_0
    //   740: invokestatic 194	com/tencent/mobileqq/pluginsdk/PluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   743: astore_0
    //   744: aload_1
    //   745: invokestatic 161	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   748: aload_0
    //   749: areturn
    //   750: aload_0
    //   751: astore_2
    //   752: aload_2
    //   753: astore_0
    //   754: goto -393 -> 361
    //   757: astore_0
    //   758: aconst_null
    //   759: astore_3
    //   760: aload_3
    //   761: invokestatic 161	com/tencent/mobileqq/pluginsdk/IOUtil:closeZipFile	(Ljava/util/zip/ZipFile;)V
    //   764: aload_0
    //   765: athrow
    //   766: astore_0
    //   767: goto -7 -> 760
    //   770: astore_0
    //   771: aconst_null
    //   772: astore_1
    //   773: goto -42 -> 731
    //   776: astore_0
    //   777: aload 7
    //   779: astore 4
    //   781: goto -68 -> 713
    //   784: astore_0
    //   785: aload 6
    //   787: astore 4
    //   789: goto -76 -> 713
    //   792: astore 4
    //   794: aload_0
    //   795: astore_3
    //   796: aload 4
    //   798: astore_0
    //   799: aload_2
    //   800: astore 4
    //   802: aload_3
    //   803: astore_2
    //   804: goto -91 -> 713
    //   807: astore_3
    //   808: aconst_null
    //   809: astore_0
    //   810: aconst_null
    //   811: astore_2
    //   812: goto -207 -> 605
    //   815: astore_3
    //   816: aload_2
    //   817: astore_0
    //   818: aconst_null
    //   819: astore_2
    //   820: goto -215 -> 605
    //   823: astore_0
    //   824: goto -143 -> 681
    //   827: astore_2
    //   828: aconst_null
    //   829: astore_1
    //   830: goto -178 -> 652
    //   833: astore_2
    //   834: goto -182 -> 652
    //   837: astore_2
    //   838: goto -186 -> 652
    //   841: iconst_0
    //   842: istore 12
    //   844: goto -305 -> 539
    //   847: aload_1
    //   848: astore_3
    //   849: aload_0
    //   850: astore_1
    //   851: goto -211 -> 640
    //   854: aload_2
    //   855: astore_1
    //   856: goto -793 -> 63
    //   859: astore_0
    //   860: aconst_null
    //   861: astore_2
    //   862: aload 7
    //   864: astore 4
    //   866: goto -153 -> 713
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	869	0	paramString1	String
    //   0	869	1	paramString2	String
    //   92	540	2	localObject1	Object
    //   646	17	2	localIOException1	java.io.IOException
    //   666	154	2	localObject2	Object
    //   827	1	2	localIOException2	java.io.IOException
    //   833	1	2	localIOException3	java.io.IOException
    //   837	18	2	localIOException4	java.io.IOException
    //   861	1	2	localObject3	Object
    //   53	493	3	localObject4	Object
    //   599	11	3	localIOException5	java.io.IOException
    //   616	187	3	localObject5	Object
    //   807	1	3	localIOException6	java.io.IOException
    //   815	1	3	localIOException7	java.io.IOException
    //   848	1	3	str1	String
    //   49	739	4	localObject6	Object
    //   792	5	4	localObject7	Object
    //   800	65	4	localObject8	Object
    //   7	492	5	str2	String
    //   147	639	6	localObject9	Object
    //   1	862	7	localObject10	Object
    //   4	563	8	localObject11	Object
    //   59	530	9	localObject12	Object
    //   357	19	10	localEnumeration	java.util.Enumeration
    //   385	172	11	localZipEntry	java.util.zip.ZipEntry
    //   462	381	12	i	int
    // Exception table:
    //   from	to	target	type
    //   573	581	599	java/io/IOException
    //   586	596	599	java/io/IOException
    //   41	51	646	java/io/IOException
    //   41	51	678	finally
    //   344	351	730	java/io/IOException
    //   353	359	730	java/io/IOException
    //   363	373	730	java/io/IOException
    //   375	387	730	java/io/IOException
    //   389	396	730	java/io/IOException
    //   398	409	730	java/io/IOException
    //   411	421	730	java/io/IOException
    //   423	452	730	java/io/IOException
    //   454	464	730	java/io/IOException
    //   475	485	730	java/io/IOException
    //   487	515	730	java/io/IOException
    //   524	536	730	java/io/IOException
    //   546	555	730	java/io/IOException
    //   617	621	730	java/io/IOException
    //   623	627	730	java/io/IOException
    //   689	694	730	java/io/IOException
    //   699	704	730	java/io/IOException
    //   706	710	730	java/io/IOException
    //   715	720	730	java/io/IOException
    //   722	726	730	java/io/IOException
    //   728	730	730	java/io/IOException
    //   333	342	757	finally
    //   344	351	766	finally
    //   353	359	766	finally
    //   363	373	766	finally
    //   375	387	766	finally
    //   389	396	766	finally
    //   398	409	766	finally
    //   411	421	766	finally
    //   423	452	766	finally
    //   454	464	766	finally
    //   475	485	766	finally
    //   487	515	766	finally
    //   524	536	766	finally
    //   546	555	766	finally
    //   617	621	766	finally
    //   623	627	766	finally
    //   689	694	766	finally
    //   699	704	766	finally
    //   706	710	766	finally
    //   715	720	766	finally
    //   722	726	766	finally
    //   728	730	766	finally
    //   733	737	766	finally
    //   739	744	766	finally
    //   333	342	770	java/io/IOException
    //   562	573	776	finally
    //   573	581	784	finally
    //   586	596	784	finally
    //   605	615	792	finally
    //   555	562	807	java/io/IOException
    //   562	573	815	java/io/IOException
    //   54	61	823	finally
    //   66	76	823	finally
    //   79	93	823	finally
    //   96	106	823	finally
    //   109	118	823	finally
    //   121	149	823	finally
    //   159	173	823	finally
    //   176	180	823	finally
    //   186	194	823	finally
    //   197	211	823	finally
    //   218	222	823	finally
    //   230	241	823	finally
    //   248	261	823	finally
    //   264	277	823	finally
    //   280	286	823	finally
    //   294	301	823	finally
    //   655	659	823	finally
    //   662	667	823	finally
    //   54	61	827	java/io/IOException
    //   159	173	833	java/io/IOException
    //   176	180	833	java/io/IOException
    //   186	194	833	java/io/IOException
    //   197	211	833	java/io/IOException
    //   218	222	833	java/io/IOException
    //   230	241	833	java/io/IOException
    //   248	261	833	java/io/IOException
    //   264	277	833	java/io/IOException
    //   280	286	833	java/io/IOException
    //   294	301	833	java/io/IOException
    //   66	76	837	java/io/IOException
    //   79	93	837	java/io/IOException
    //   96	106	837	java/io/IOException
    //   109	118	837	java/io/IOException
    //   121	149	837	java/io/IOException
    //   555	562	859	finally
  }
  
  /* Error */
  public static String extractPluginAndGetMd5Code(Context paramContext, String paramString, File paramFile)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_2
    //   6: invokevirtual 205	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   9: astore 5
    //   11: new 65	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   18: ldc -49
    //   20: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload 5
    //   25: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 212	com/tencent/mobileqq/pluginsdk/DebugHelper:debug	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: ldc -42
    //   37: ldc -40
    //   39: invokevirtual 219	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: astore 6
    //   44: aload_2
    //   45: invokevirtual 222	java/io/File:exists	()Z
    //   48: ifeq +8 -> 56
    //   51: aload_2
    //   52: invokevirtual 225	java/io/File:delete	()Z
    //   55: pop
    //   56: new 43	java/io/File
    //   59: dup
    //   60: new 65	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   67: aload 5
    //   69: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 21
    //   74: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokespecial 127	java/io/File:<init>	(Ljava/lang/String;)V
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual 222	java/io/File:exists	()Z
    //   88: ifeq +8 -> 96
    //   91: aload_1
    //   92: invokevirtual 225	java/io/File:delete	()Z
    //   95: pop
    //   96: aload_1
    //   97: invokevirtual 228	java/io/File:createNewFile	()Z
    //   100: pop
    //   101: aload_0
    //   102: invokevirtual 234	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   105: new 65	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   112: ldc -20
    //   114: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload 6
    //   119: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokevirtual 242	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   128: astore_0
    //   129: new 174	java/io/FileOutputStream
    //   132: dup
    //   133: aload_1
    //   134: invokespecial 177	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   137: astore_3
    //   138: sipush 8192
    //   141: newarray <illegal type>
    //   143: astore 4
    //   145: aload_0
    //   146: aload 4
    //   148: invokevirtual 183	java/io/InputStream:read	([B)I
    //   151: istore 7
    //   153: iload 7
    //   155: iconst_m1
    //   156: if_icmpeq +48 -> 204
    //   159: aload_3
    //   160: aload 4
    //   162: iconst_0
    //   163: iload 7
    //   165: invokevirtual 245	java/io/OutputStream:write	([BII)V
    //   168: goto -23 -> 145
    //   171: astore_2
    //   172: aload_0
    //   173: astore_1
    //   174: aload_3
    //   175: astore_0
    //   176: new 202	java/lang/Exception
    //   179: dup
    //   180: ldc -9
    //   182: aload_2
    //   183: invokespecial 250	java/lang/Exception:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: athrow
    //   187: astore_3
    //   188: aload_0
    //   189: astore_2
    //   190: aload_1
    //   191: astore_0
    //   192: aload_3
    //   193: astore_1
    //   194: aload_0
    //   195: invokestatic 198	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   198: aload_2
    //   199: invokestatic 198	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   202: aload_1
    //   203: athrow
    //   204: aload_0
    //   205: invokestatic 198	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   208: aload_3
    //   209: invokestatic 198	com/tencent/mobileqq/pluginsdk/IOUtil:closeStream	(Ljava/io/Closeable;)V
    //   212: aload_2
    //   213: invokevirtual 222	java/io/File:exists	()Z
    //   216: ifeq +8 -> 224
    //   219: aload_2
    //   220: invokevirtual 225	java/io/File:delete	()Z
    //   223: pop
    //   224: aload_1
    //   225: aload_2
    //   226: invokevirtual 254	java/io/File:renameTo	(Ljava/io/File;)Z
    //   229: istore 8
    //   231: new 65	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   238: ldc_w 256
    //   241: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload 8
    //   246: invokevirtual 259	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   249: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 212	com/tencent/mobileqq/pluginsdk/DebugHelper:debug	(Ljava/lang/String;)V
    //   255: aload 5
    //   257: invokestatic 265	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   260: areturn
    //   261: astore_1
    //   262: aconst_null
    //   263: astore_0
    //   264: aload 4
    //   266: astore_2
    //   267: goto -73 -> 194
    //   270: astore_1
    //   271: aload 4
    //   273: astore_2
    //   274: goto -80 -> 194
    //   277: astore_1
    //   278: aload_3
    //   279: astore_2
    //   280: goto -86 -> 194
    //   283: astore_2
    //   284: aconst_null
    //   285: astore_0
    //   286: aload_3
    //   287: astore_1
    //   288: goto -112 -> 176
    //   291: astore_2
    //   292: aconst_null
    //   293: astore_3
    //   294: aload_0
    //   295: astore_1
    //   296: aload_3
    //   297: astore_0
    //   298: goto -122 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramContext	Context
    //   0	301	1	paramString	String
    //   0	301	2	paramFile	File
    //   4	171	3	localFileOutputStream	java.io.FileOutputStream
    //   187	100	3	localCloseable	java.io.Closeable
    //   293	4	3	localObject	Object
    //   1	271	4	arrayOfByte	byte[]
    //   9	247	5	str1	String
    //   42	76	6	str2	String
    //   151	13	7	i	int
    //   229	16	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   138	145	171	java/lang/Exception
    //   145	153	171	java/lang/Exception
    //   159	168	171	java/lang/Exception
    //   176	187	187	finally
    //   101	129	261	finally
    //   129	138	270	finally
    //   138	145	277	finally
    //   145	153	277	finally
    //   159	168	277	finally
    //   101	129	283	java/lang/Exception
    //   129	138	291	java/lang/Exception
  }
  
  public static String getExceptionInfo(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter, true));
    return localStringWriter.getBuffer().toString();
  }
  
  public static File getInstalledPluginPath(Context paramContext, String paramString)
  {
    Object localObject = null;
    PluginBaseInfo localPluginBaseInfo = PluginBaseInfoHelper.createFromFile(getPluginCfgFile(getPluginInstallDir(paramContext), paramString), PluginBaseInfo.class);
    if ((localPluginBaseInfo == null) || (localPluginBaseInfo.mState != 4) || (localPluginBaseInfo.mInstalledPath == null)) {
      paramContext = a(paramContext, paramString);
    }
    do
    {
      return paramContext;
      paramContext = (Context)localObject;
    } while (!PluginStatic.a(localPluginBaseInfo.mInstalledPath));
    return new File(localPluginBaseInfo.mInstalledPath);
  }
  
  public static File getOptimizedDexPath(Context paramContext)
  {
    return paramContext.getDir("odex", 0);
  }
  
  public static PackageInfo getPackageInfo(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    PackageInfo localPackageInfo = (PackageInfo)c.get(paramString);
    paramContext = localPackageInfo;
    if (localPackageInfo == null)
    {
      DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo start");
      localPackageInfo = localPackageManager.getPackageArchiveInfo(paramString, 128);
      DebugHelper.debug("PluginUtils.verifyPlugin.getPackageArchiveInfo end");
      paramContext = localPackageInfo;
      if (localPackageInfo != null)
      {
        c.put(paramString, localPackageInfo);
        paramContext = localPackageInfo;
      }
    }
    return paramContext;
  }
  
  public static File getPluginCfgFile(File paramFile, String paramString)
  {
    return new File(paramFile, paramString + ".cfg");
  }
  
  public static File getPluginInstallDir(Context paramContext)
  {
    return paramContext.getDir("installed_plugin", 0);
  }
  
  public static File getPluginLibPath(Context paramContext, String paramString)
  {
    String str = paramString;
    if (paramString.endsWith(".apk")) {
      str = paramString.substring(0, paramString.length() - ".apk".length());
    }
    return new File(paramContext.getDir("lib", 0), str);
  }
  
  static class a
    extends Exception
  {
    private static final long a = 1L;
    
    public a(String paramString)
    {
      super();
    }
    
    public a(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  static class b
    extends Exception
  {
    private static final long a = 1L;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\pluginsdk\PluginUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */