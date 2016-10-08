package com.tencent.mobileqq.filemanager.util;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import mqq.os.MqqHandler;
import sjo;

public class UniformDownloadUtil
{
  private static final String a = "UniformDownloadUtil";
  
  public UniformDownloadUtil()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString)
  {
    if (a(paramString) == null)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] installAPK failed.  is not apk file. PH:" + paramString);
      return -1;
    }
    try
    {
      if (!new File(paramString).exists())
      {
        QLog.e("UniformDownloadUtil", 1, "[UniformDL] installAPK. file is not exsited. PH:" + paramString);
        return -2;
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setFlags(268435456);
      localIntent.setDataAndType(Uri.fromFile(new File(paramString)), "application/vnd.android.package-archive");
      BaseApplication.getContext().startActivity(localIntent);
      return 0;
    }
    catch (Exception paramString)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] installAPK. Exception 2");
      paramString.printStackTrace();
    }
    return -3;
  }
  
  public static Bitmap a(String paramString)
  {
    if (paramString == null)
    {
      QLog.i("UniformDownloadUtil", 1, "[UniformDL] getApkIcon failed.url = null");
      return null;
    }
    try
    {
      Object localObject1 = Class.forName("android.content.pm.PackageParser");
      Object localObject2 = ((Class)localObject1).getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString });
      Object localObject3 = new DisplayMetrics();
      ((DisplayMetrics)localObject3).setToDefaults();
      localObject1 = ((Class)localObject1).getDeclaredMethod("parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE }).invoke(localObject2, new Object[] { new File(paramString), paramString, localObject3, Integer.valueOf(0) });
      localObject1 = (ApplicationInfo)localObject1.getClass().getDeclaredField("applicationInfo").get(localObject1);
      localObject3 = Class.forName("android.content.res.AssetManager");
      localObject2 = ((Class)localObject3).newInstance();
      ((Class)localObject3).getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localObject2, new Object[] { paramString });
      paramString = BaseApplication.getContext().getResources();
      paramString = (Resources)Resources.class.getConstructor(new Class[] { localObject2.getClass(), paramString.getDisplayMetrics().getClass(), paramString.getConfiguration().getClass() }).newInstance(new Object[] { localObject2, paramString.getDisplayMetrics(), paramString.getConfiguration() });
      if ((localObject1 != null) && (((ApplicationInfo)localObject1).icon != 0))
      {
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        BitmapFactory.decodeResource(paramString, ((ApplicationInfo)localObject1).icon, (BitmapFactory.Options)localObject2);
        ((BitmapFactory.Options)localObject2).inSampleSize = 1;
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        paramString = BitmapFactory.decodeResource(paramString, ((ApplicationInfo)localObject1).icon, (BitmapFactory.Options)localObject2);
        return paramString;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static UniformDownloadUtil.FileInfo a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc -42
    //   4: astore 7
    //   6: aload_0
    //   7: ifnull +11 -> 18
    //   10: aload_0
    //   11: invokevirtual 218	java/lang/String:length	()I
    //   14: iconst_1
    //   15: if_icmpge +13 -> 28
    //   18: new 220	com/tencent/mobileqq/filemanager/util/UniformDownloadUtil$FileInfo
    //   21: dup
    //   22: aconst_null
    //   23: lconst_0
    //   24: invokespecial 223	com/tencent/mobileqq/filemanager/util/UniformDownloadUtil$FileInfo:<init>	(Ljava/lang/String;J)V
    //   27: areturn
    //   28: new 225	java/net/URL
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 226	java/net/URL:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 230	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   39: checkcast 232	java/net/HttpURLConnection
    //   42: astore_1
    //   43: aload_1
    //   44: ldc -22
    //   46: ldc -20
    //   48: invokevirtual 240	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload_1
    //   52: ldc -14
    //   54: ldc -20
    //   56: invokevirtual 240	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_1
    //   60: invokevirtual 245	java/net/HttpURLConnection:connect	()V
    //   63: aload_1
    //   64: invokevirtual 248	java/net/HttpURLConnection:getResponseCode	()I
    //   67: pop
    //   68: aload_1
    //   69: invokevirtual 252	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   72: astore 8
    //   74: ldc -2
    //   76: iconst_1
    //   77: new 27	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 256
    //   87: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 8
    //   92: invokevirtual 259	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 44	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: aload_1
    //   102: invokevirtual 262	java/net/HttpURLConnection:getContentLength	()I
    //   105: istore 10
    //   107: iload 10
    //   109: i2l
    //   110: lstore 12
    //   112: aload 7
    //   114: astore 4
    //   116: aload 7
    //   118: astore 5
    //   120: aload 7
    //   122: astore 6
    //   124: aload_1
    //   125: ldc_w 264
    //   128: invokevirtual 267	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_3
    //   132: aload 7
    //   134: astore_2
    //   135: aload_3
    //   136: ifnull +316 -> 452
    //   139: aload 7
    //   141: astore 4
    //   143: aload 7
    //   145: astore 5
    //   147: aload 7
    //   149: astore 6
    //   151: new 110	java/lang/String
    //   154: dup
    //   155: aload_3
    //   156: ldc_w 269
    //   159: invokevirtual 273	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   162: ldc -20
    //   164: invokespecial 276	java/lang/String:<init>	([BLjava/lang/String;)V
    //   167: ldc -20
    //   169: invokestatic 282	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: astore 9
    //   174: aload 7
    //   176: astore_2
    //   177: aload 9
    //   179: ifnull +273 -> 452
    //   182: aload 7
    //   184: astore 4
    //   186: aload 7
    //   188: astore 5
    //   190: aload 7
    //   192: astore 6
    //   194: aload 9
    //   196: ldc_w 284
    //   199: invokevirtual 287	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   202: istore 11
    //   204: iload 11
    //   206: istore 10
    //   208: iconst_m1
    //   209: iload 11
    //   211: if_icmpne +25 -> 236
    //   214: aload 7
    //   216: astore 4
    //   218: aload 7
    //   220: astore 5
    //   222: aload 7
    //   224: astore 6
    //   226: aload 9
    //   228: ldc_w 289
    //   231: invokevirtual 287	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   234: istore 10
    //   236: aload 7
    //   238: astore_3
    //   239: iconst_m1
    //   240: iload 10
    //   242: if_icmpeq +91 -> 333
    //   245: aload 7
    //   247: astore 4
    //   249: aload 7
    //   251: astore 5
    //   253: aload 7
    //   255: astore 6
    //   257: aload 9
    //   259: iload 10
    //   261: ldc_w 284
    //   264: invokevirtual 218	java/lang/String:length	()I
    //   267: iadd
    //   268: aload 9
    //   270: invokevirtual 218	java/lang/String:length	()I
    //   273: invokevirtual 293	java/lang/String:substring	(II)Ljava/lang/String;
    //   276: astore_2
    //   277: aload 7
    //   279: astore_3
    //   280: aload_2
    //   281: ifnull +52 -> 333
    //   284: aload 7
    //   286: astore 4
    //   288: aload 7
    //   290: astore 5
    //   292: aload 7
    //   294: astore 6
    //   296: aload_2
    //   297: ldc_w 295
    //   300: invokevirtual 287	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   303: istore 10
    //   305: iconst_m1
    //   306: iload 10
    //   308: if_icmpeq +324 -> 632
    //   311: aload 7
    //   313: astore 4
    //   315: aload 7
    //   317: astore 5
    //   319: aload 7
    //   321: astore 6
    //   323: aload_2
    //   324: iconst_0
    //   325: iload 10
    //   327: iconst_1
    //   328: isub
    //   329: invokevirtual 293	java/lang/String:substring	(II)Ljava/lang/String;
    //   332: astore_3
    //   333: aload_3
    //   334: astore_2
    //   335: aload_3
    //   336: astore 4
    //   338: aload_3
    //   339: astore 5
    //   341: aload_3
    //   342: astore 6
    //   344: aload_3
    //   345: invokestatic 301	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifne +104 -> 452
    //   351: aload_3
    //   352: astore 4
    //   354: aload_3
    //   355: astore 5
    //   357: aload_3
    //   358: astore 6
    //   360: aload_3
    //   361: ldc_w 303
    //   364: invokevirtual 287	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   367: istore 10
    //   369: aload_3
    //   370: astore 4
    //   372: aload_3
    //   373: astore 5
    //   375: aload_3
    //   376: astore 6
    //   378: aload_3
    //   379: ldc_w 303
    //   382: invokevirtual 306	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   385: istore 11
    //   387: aload_3
    //   388: astore_2
    //   389: iload 10
    //   391: ifne +61 -> 452
    //   394: aload_3
    //   395: astore_2
    //   396: aload_3
    //   397: astore 4
    //   399: aload_3
    //   400: astore 5
    //   402: aload_3
    //   403: astore 6
    //   405: iload 11
    //   407: iconst_1
    //   408: iadd
    //   409: aload_3
    //   410: invokevirtual 218	java/lang/String:length	()I
    //   413: if_icmpne +39 -> 452
    //   416: aload_3
    //   417: astore 4
    //   419: aload_3
    //   420: astore 5
    //   422: aload_3
    //   423: astore 6
    //   425: aload_3
    //   426: iconst_1
    //   427: invokevirtual 309	java/lang/String:substring	(I)Ljava/lang/String;
    //   430: astore_2
    //   431: aload_2
    //   432: astore 4
    //   434: aload_2
    //   435: astore 5
    //   437: aload_2
    //   438: astore 6
    //   440: aload_2
    //   441: iconst_0
    //   442: aload_2
    //   443: invokevirtual 218	java/lang/String:length	()I
    //   446: iconst_1
    //   447: isub
    //   448: invokevirtual 293	java/lang/String:substring	(II)Ljava/lang/String;
    //   451: astore_2
    //   452: aload_2
    //   453: astore_3
    //   454: aload_2
    //   455: astore 4
    //   457: aload_2
    //   458: astore 5
    //   460: aload_2
    //   461: astore 6
    //   463: aload_2
    //   464: invokestatic 301	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   467: ifeq +25 -> 492
    //   470: aload_2
    //   471: astore_3
    //   472: aload 8
    //   474: ifnull +18 -> 492
    //   477: aload_2
    //   478: astore 4
    //   480: aload_2
    //   481: astore 5
    //   483: aload_2
    //   484: astore 6
    //   486: aload 8
    //   488: invokevirtual 312	java/net/URL:getFile	()Ljava/lang/String;
    //   491: astore_3
    //   492: aload_3
    //   493: ifnull +388 -> 881
    //   496: aload_3
    //   497: astore 4
    //   499: aload_3
    //   500: astore 5
    //   502: aload_3
    //   503: astore 6
    //   505: aload_3
    //   506: ldc_w 314
    //   509: invokevirtual 317	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   512: ifne +26 -> 538
    //   515: aload_3
    //   516: astore 4
    //   518: aload_3
    //   519: astore 5
    //   521: aload_3
    //   522: astore 6
    //   524: aload_3
    //   525: ldc_w 319
    //   528: invokevirtual 317	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   531: istore 16
    //   533: iload 16
    //   535: ifeq +346 -> 881
    //   538: aconst_null
    //   539: astore_2
    //   540: aload_1
    //   541: ifnull +335 -> 876
    //   544: aload_1
    //   545: invokevirtual 322	java/net/HttpURLConnection:disconnect	()V
    //   548: aload_2
    //   549: astore_1
    //   550: ldc -42
    //   552: astore_3
    //   553: aload_3
    //   554: astore_2
    //   555: aload_0
    //   556: invokestatic 326	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   559: astore 4
    //   561: aload_3
    //   562: astore_0
    //   563: aload 4
    //   565: ifnull +49 -> 614
    //   568: aload_3
    //   569: astore_2
    //   570: aload 4
    //   572: invokevirtual 329	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   575: astore_3
    //   576: aload_3
    //   577: astore_0
    //   578: aload_3
    //   579: ifnull +35 -> 614
    //   582: aload_3
    //   583: astore_2
    //   584: aload_3
    //   585: ldc_w 314
    //   588: invokevirtual 317	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   591: ifne +21 -> 612
    //   594: aload_3
    //   595: astore_2
    //   596: aload_3
    //   597: ldc_w 319
    //   600: invokevirtual 317	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   603: istore 16
    //   605: aload_3
    //   606: astore_0
    //   607: iload 16
    //   609: ifeq +5 -> 614
    //   612: aconst_null
    //   613: astore_0
    //   614: aload_1
    //   615: invokestatic 301	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   618: ifne +162 -> 780
    //   621: new 220	com/tencent/mobileqq/filemanager/util/UniformDownloadUtil$FileInfo
    //   624: dup
    //   625: aload_1
    //   626: lload 12
    //   628: invokespecial 223	com/tencent/mobileqq/filemanager/util/UniformDownloadUtil$FileInfo:<init>	(Ljava/lang/String;J)V
    //   631: areturn
    //   632: aload_2
    //   633: astore_3
    //   634: goto -301 -> 333
    //   637: astore 4
    //   639: lconst_0
    //   640: lstore 14
    //   642: ldc -42
    //   644: astore_2
    //   645: aconst_null
    //   646: astore_3
    //   647: aload_3
    //   648: astore_1
    //   649: aload 4
    //   651: invokevirtual 330	java/net/MalformedURLException:printStackTrace	()V
    //   654: lload 14
    //   656: lstore 12
    //   658: aload_2
    //   659: astore_1
    //   660: aload_3
    //   661: ifnull -111 -> 550
    //   664: aload_3
    //   665: invokevirtual 322	java/net/HttpURLConnection:disconnect	()V
    //   668: lload 14
    //   670: lstore 12
    //   672: aload_2
    //   673: astore_1
    //   674: goto -124 -> 550
    //   677: astore 4
    //   679: lconst_0
    //   680: lstore 14
    //   682: ldc -42
    //   684: astore_2
    //   685: aconst_null
    //   686: astore_3
    //   687: aload_3
    //   688: astore_1
    //   689: aload 4
    //   691: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   694: lload 14
    //   696: lstore 12
    //   698: aload_2
    //   699: astore_1
    //   700: aload_3
    //   701: ifnull -151 -> 550
    //   704: aload_3
    //   705: invokevirtual 322	java/net/HttpURLConnection:disconnect	()V
    //   708: lload 14
    //   710: lstore 12
    //   712: aload_2
    //   713: astore_1
    //   714: goto -164 -> 550
    //   717: astore 4
    //   719: lconst_0
    //   720: lstore 14
    //   722: ldc -42
    //   724: astore_2
    //   725: aconst_null
    //   726: astore_3
    //   727: aload_3
    //   728: astore_1
    //   729: aload 4
    //   731: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   734: lload 14
    //   736: lstore 12
    //   738: aload_2
    //   739: astore_1
    //   740: aload_3
    //   741: ifnull -191 -> 550
    //   744: aload_3
    //   745: invokevirtual 322	java/net/HttpURLConnection:disconnect	()V
    //   748: lload 14
    //   750: lstore 12
    //   752: aload_2
    //   753: astore_1
    //   754: goto -204 -> 550
    //   757: astore_0
    //   758: aload_2
    //   759: astore_1
    //   760: aload_1
    //   761: ifnull +7 -> 768
    //   764: aload_1
    //   765: invokevirtual 322	java/net/HttpURLConnection:disconnect	()V
    //   768: aload_0
    //   769: athrow
    //   770: astore_0
    //   771: aload_0
    //   772: invokevirtual 92	java/lang/Exception:printStackTrace	()V
    //   775: aload_2
    //   776: astore_0
    //   777: goto -163 -> 614
    //   780: aload_0
    //   781: astore_1
    //   782: goto -161 -> 621
    //   785: astore_0
    //   786: goto -26 -> 760
    //   789: astore_0
    //   790: goto -30 -> 760
    //   793: astore 4
    //   795: lconst_0
    //   796: lstore 14
    //   798: ldc -42
    //   800: astore_2
    //   801: aload_1
    //   802: astore_3
    //   803: goto -76 -> 727
    //   806: astore_3
    //   807: aload 4
    //   809: astore_2
    //   810: lload 12
    //   812: lstore 14
    //   814: aload_3
    //   815: astore 4
    //   817: aload_1
    //   818: astore_3
    //   819: goto -92 -> 727
    //   822: astore 4
    //   824: lconst_0
    //   825: lstore 14
    //   827: ldc -42
    //   829: astore_2
    //   830: aload_1
    //   831: astore_3
    //   832: goto -145 -> 687
    //   835: astore 4
    //   837: aload 5
    //   839: astore_2
    //   840: lload 12
    //   842: lstore 14
    //   844: aload_1
    //   845: astore_3
    //   846: goto -159 -> 687
    //   849: astore 4
    //   851: lconst_0
    //   852: lstore 14
    //   854: ldc -42
    //   856: astore_2
    //   857: aload_1
    //   858: astore_3
    //   859: goto -212 -> 647
    //   862: astore 4
    //   864: aload 6
    //   866: astore_2
    //   867: lload 12
    //   869: lstore 14
    //   871: aload_1
    //   872: astore_3
    //   873: goto -226 -> 647
    //   876: aload_2
    //   877: astore_1
    //   878: goto -328 -> 550
    //   881: aload_3
    //   882: astore_2
    //   883: goto -343 -> 540
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	886	0	paramString	String
    //   42	836	1	localObject1	Object
    //   1	882	2	localObject2	Object
    //   131	672	3	localObject3	Object
    //   806	9	3	localException1	Exception
    //   818	64	3	localObject4	Object
    //   114	457	4	localObject5	Object
    //   637	13	4	localMalformedURLException1	java.net.MalformedURLException
    //   677	13	4	localIOException1	java.io.IOException
    //   717	13	4	localException2	Exception
    //   793	15	4	localException3	Exception
    //   815	1	4	localObject6	Object
    //   822	1	4	localIOException2	java.io.IOException
    //   835	1	4	localIOException3	java.io.IOException
    //   849	1	4	localMalformedURLException2	java.net.MalformedURLException
    //   862	1	4	localMalformedURLException3	java.net.MalformedURLException
    //   118	720	5	localObject7	Object
    //   122	743	6	localObject8	Object
    //   4	316	7	str1	String
    //   72	415	8	localURL	java.net.URL
    //   172	97	9	str2	String
    //   105	285	10	i	int
    //   202	207	11	j	int
    //   110	758	12	l1	long
    //   640	230	14	l2	long
    //   531	77	16	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   28	43	637	java/net/MalformedURLException
    //   28	43	677	java/io/IOException
    //   28	43	717	java/lang/Exception
    //   28	43	757	finally
    //   555	561	770	java/lang/Exception
    //   570	576	770	java/lang/Exception
    //   584	594	770	java/lang/Exception
    //   596	605	770	java/lang/Exception
    //   43	107	785	finally
    //   124	132	785	finally
    //   151	174	785	finally
    //   194	204	785	finally
    //   226	236	785	finally
    //   257	277	785	finally
    //   296	305	785	finally
    //   323	333	785	finally
    //   344	351	785	finally
    //   360	369	785	finally
    //   378	387	785	finally
    //   405	416	785	finally
    //   425	431	785	finally
    //   440	452	785	finally
    //   463	470	785	finally
    //   486	492	785	finally
    //   505	515	785	finally
    //   524	533	785	finally
    //   649	654	789	finally
    //   689	694	789	finally
    //   729	734	789	finally
    //   43	107	793	java/lang/Exception
    //   124	132	806	java/lang/Exception
    //   151	174	806	java/lang/Exception
    //   194	204	806	java/lang/Exception
    //   226	236	806	java/lang/Exception
    //   257	277	806	java/lang/Exception
    //   296	305	806	java/lang/Exception
    //   323	333	806	java/lang/Exception
    //   344	351	806	java/lang/Exception
    //   360	369	806	java/lang/Exception
    //   378	387	806	java/lang/Exception
    //   405	416	806	java/lang/Exception
    //   425	431	806	java/lang/Exception
    //   440	452	806	java/lang/Exception
    //   463	470	806	java/lang/Exception
    //   486	492	806	java/lang/Exception
    //   505	515	806	java/lang/Exception
    //   524	533	806	java/lang/Exception
    //   43	107	822	java/io/IOException
    //   124	132	835	java/io/IOException
    //   151	174	835	java/io/IOException
    //   194	204	835	java/io/IOException
    //   226	236	835	java/io/IOException
    //   257	277	835	java/io/IOException
    //   296	305	835	java/io/IOException
    //   323	333	835	java/io/IOException
    //   344	351	835	java/io/IOException
    //   360	369	835	java/io/IOException
    //   378	387	835	java/io/IOException
    //   405	416	835	java/io/IOException
    //   425	431	835	java/io/IOException
    //   440	452	835	java/io/IOException
    //   463	470	835	java/io/IOException
    //   486	492	835	java/io/IOException
    //   505	515	835	java/io/IOException
    //   524	533	835	java/io/IOException
    //   43	107	849	java/net/MalformedURLException
    //   124	132	862	java/net/MalformedURLException
    //   151	174	862	java/net/MalformedURLException
    //   194	204	862	java/net/MalformedURLException
    //   226	236	862	java/net/MalformedURLException
    //   257	277	862	java/net/MalformedURLException
    //   296	305	862	java/net/MalformedURLException
    //   323	333	862	java/net/MalformedURLException
    //   344	351	862	java/net/MalformedURLException
    //   360	369	862	java/net/MalformedURLException
    //   378	387	862	java/net/MalformedURLException
    //   405	416	862	java/net/MalformedURLException
    //   425	431	862	java/net/MalformedURLException
    //   440	452	862	java/net/MalformedURLException
    //   463	470	862	java/net/MalformedURLException
    //   486	492	862	java/net/MalformedURLException
    //   505	515	862	java/net/MalformedURLException
    //   524	533	862	java/net/MalformedURLException
  }
  
  public static String a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. path = null");
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = BaseApplication.getContext().getPackageManager().getPackageArchiveInfo(paramString, 1);
        if (localObject == null) {
          break label89;
        }
        localObject = ((PackageInfo)localObject).applicationInfo.packageName;
        if (localObject != null) {
          return (String)localObject;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. Exception 1");
        paramString.printStackTrace();
        return null;
      }
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] isApk. get package failed.  PH:" + paramString);
      return null;
      label89:
      Object localObject = null;
    }
  }
  
  public static void a(String paramString)
  {
    QLog.i("UniformDownloadUtil", 1, "[UniformDL] >>>openFileWithOtherApp. localPath:" + paramString);
    if ((paramString == null) || (!FileUtil.a(paramString)))
    {
      QLog.e("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. file is not existed. localPath:" + paramString);
      return;
    }
    BaseApplication localBaseApplication = BaseApplication.getContext();
    String str = MimeTypesTools.a(localBaseApplication, paramString);
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), str);
    try
    {
      localBaseApplication.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      QLog.w("UniformDownloadUtil", 1, "[UniformDL] openFileWithOtherApp. no useful app. localPath:" + paramString);
    }
  }
  
  public static void a(String paramString, UniformDownloadUtil.GetFileInfoCallBack paramGetFileInfoCallBack)
  {
    ThreadManager.b().post(new sjo(paramString, paramGetFileInfoCallBack));
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (FileUtil.a(paramString).equalsIgnoreCase(".apk"));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\filemanager\util\UniformDownloadUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */