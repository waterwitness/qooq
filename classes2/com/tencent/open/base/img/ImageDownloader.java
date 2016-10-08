package com.tencent.open.base.img;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ImageDownloader
{
  protected static int a = 0;
  protected static String a;
  protected static int b = 1048576;
  public static final int c = 1800000;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "ImageDownloader";
    jdField_a_of_type_Int = 2048;
  }
  
  protected static long a(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Cache-Control");
    if (paramHttpURLConnection == null) {
      return 0L;
    }
    paramHttpURLConnection = TextUtils.split(paramHttpURLConnection, ",");
    int i = 0;
    if (i < paramHttpURLConnection.length) {
      if (!paramHttpURLConnection[i].contains("max-age")) {}
    }
    for (long l = Long.parseLong(paramHttpURLConnection[i].trim().replace("max-age=", ""));; l = 0L)
    {
      return l;
      i += 1;
      break;
    }
  }
  
  protected static HttpURLConnection a(ImageInfo paramImageInfo)
  {
    for (;;)
    {
      try
      {
        localObject1 = MsfSdkUtils.insertMtype("yingyongbao", paramImageInfo.jdField_b_of_type_JavaLangString);
        if (APNUtil.a(CommonDataAdapter.a().a()))
        {
          i = "http://".length();
          localObject3 = APNUtil.c(CommonDataAdapter.a().a());
          String str = APNUtil.d(CommonDataAdapter.a().a());
          j = ((String)localObject1).indexOf('/', i);
          if (j < 0)
          {
            localObject2 = ((String)localObject1).substring(i);
            localObject1 = "";
            LogUtility.c(jdField_a_of_type_JavaLangString, "http://" + (String)localObject3 + ":" + str + (String)localObject1);
            localObject3 = (HttpURLConnection)new URL("http://" + (String)localObject3 + ":" + str + (String)localObject1).openConnection();
            localObject1 = localObject3;
          }
        }
      }
      catch (Exception paramImageInfo)
      {
        int j;
        Object localObject2;
        localObject3 = null;
        LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- Exception!!!", paramImageInfo);
        a((HttpURLConnection)localObject3);
        return null;
      }
      try
      {
        ((HttpURLConnection)localObject3).setRequestProperty("X-Online-Host", (String)localObject2);
        localObject1 = localObject3;
        localObject3 = localObject1;
      }
      catch (Exception paramImageInfo)
      {
        localObject3 = localObject1;
        continue;
      }
      try
      {
        ((HttpURLConnection)localObject1).setRequestMethod("GET");
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setDoInput(true);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setAllowUserInteraction(true);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setConnectTimeout(60000);
        localObject3 = localObject1;
        ((HttpURLConnection)localObject1).setReadTimeout(120000);
        localObject3 = localObject1;
        if (paramImageInfo.jdField_c_of_type_Long > 0L)
        {
          localObject3 = localObject1;
          localObject2 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
          localObject3 = localObject1;
          ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
          localObject3 = localObject1;
          ((HttpURLConnection)localObject1).setRequestProperty("If-Modified-Since", ((SimpleDateFormat)localObject2).format(new Date(paramImageInfo.jdField_c_of_type_Long)));
        }
        localObject3 = localObject1;
        i = ((HttpURLConnection)localObject1).getResponseCode();
        localObject3 = localObject1;
        LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- reponseCode=" + i);
        if ((i == 302) || (i == 301))
        {
          localObject3 = localObject1;
          paramImageInfo = ((HttpURLConnection)localObject1).getHeaderField("Location");
          localObject3 = localObject1;
          LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- loc=" + paramImageInfo);
          localObject3 = localObject1;
          a((HttpURLConnection)localObject1);
          paramImageInfo = null;
          localObject1 = paramImageInfo;
          LogUtility.c(jdField_a_of_type_JavaLangString, "--getHttpConnection-- uc=" + paramImageInfo);
          return paramImageInfo;
          localObject2 = ((String)localObject1).substring(i, j);
          localObject1 = ((String)localObject1).substring(j);
          continue;
          localObject1 = (HttpURLConnection)new URL((String)localObject1).openConnection();
          continue;
        }
        if ((i != 200) && (i != 206)) {
          continue;
        }
        localObject3 = localObject1;
        localObject2 = ((HttpURLConnection)localObject1).getContentType();
        if (localObject2 != null) {
          continue;
        }
        localObject2 = "";
        localObject3 = localObject1;
        if (((String)localObject2).indexOf("text/vnd.wap.wml") != -1) {
          break label697;
        }
        localObject3 = localObject1;
        if (((String)localObject2).indexOf("application/vnd.wap.wmlc") != -1) {
          break label697;
        }
        localObject3 = localObject1;
        if (((String)localObject2).indexOf("text") == -1) {
          break label703;
        }
      }
      catch (Exception paramImageInfo)
      {
        continue;
        i = 1;
        continue;
        i = 0;
        continue;
      }
      localObject2 = localObject1;
      if (i != 0)
      {
        localObject3 = localObject1;
        a((HttpURLConnection)localObject1);
        localObject2 = null;
      }
      if (localObject2 != null)
      {
        localObject3 = localObject2;
        paramImageInfo.jdField_a_of_type_Long = (a((HttpURLConnection)localObject2) * 1000L);
        localObject3 = localObject2;
        if (paramImageInfo.jdField_a_of_type_Long == 0L)
        {
          localObject3 = localObject2;
          paramImageInfo.jdField_a_of_type_Long = 86400000L;
        }
      }
      localObject3 = localObject2;
      paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
      paramImageInfo = (ImageInfo)localObject2;
      continue;
      localObject3 = localObject1;
      localObject2 = ((String)localObject2).toLowerCase();
      continue;
      if (i == 304)
      {
        localObject3 = localObject1;
        LogUtility.c(jdField_a_of_type_JavaLangString, "--getimg-- " + paramImageInfo.jdField_b_of_type_JavaLangString + " not modified");
        localObject3 = localObject1;
        paramImageInfo.jdField_a_of_type_Long = (a((HttpURLConnection)localObject1) * 1000L);
        localObject3 = localObject1;
        paramImageInfo.jdField_b_of_type_Long = System.currentTimeMillis();
        localObject3 = localObject1;
        a((HttpURLConnection)localObject1);
        paramImageInfo = null;
      }
      else
      {
        localObject3 = localObject1;
        a((HttpURLConnection)localObject1);
        paramImageInfo = null;
      }
    }
  }
  
  protected static void a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {}
    try
    {
      paramHttpURLConnection.disconnect();
      return;
    }
    catch (Exception paramHttpURLConnection)
    {
      LogUtility.c("", "", paramHttpURLConnection);
    }
  }
  
  /* Error */
  public static boolean a(ImageInfo paramImageInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: iconst_0
    //   7: istore 14
    //   9: aload_0
    //   10: invokestatic 283	com/tencent/open/base/img/ImageDownloader:a	(Lcom/tencent/open/base/img/ImageInfo;)Ljava/net/HttpURLConnection;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnonnull +89 -> 104
    //   18: getstatic 23	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   21: new 125	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 285
    //   31: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: getfield 84	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   38: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 287
    //   44: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 140	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: iconst_0
    //   54: ifeq +11 -> 65
    //   57: new 289	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 290	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: iconst_0
    //   66: ifeq +11 -> 77
    //   69: new 289	java/lang/NullPointerException
    //   72: dup
    //   73: invokespecial 290	java/lang/NullPointerException:<init>	()V
    //   76: athrow
    //   77: iload 14
    //   79: istore 13
    //   81: aload_1
    //   82: ifnull +11 -> 93
    //   85: aload_1
    //   86: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   89: iload 14
    //   91: istore 13
    //   93: iload 13
    //   95: ireturn
    //   96: astore_0
    //   97: aload_0
    //   98: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   101: goto -24 -> 77
    //   104: aload_1
    //   105: invokevirtual 296	java/net/HttpURLConnection:getContentLength	()I
    //   108: i2l
    //   109: lstore 11
    //   111: invokestatic 300	com/tencent/open/appcommon/Common:a	()J
    //   114: lload 11
    //   116: lcmp
    //   117: ifge +84 -> 201
    //   120: getstatic 23	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   123: new 125	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 285
    //   133: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: getfield 84	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   140: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 302
    //   146: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 140	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: iconst_0
    //   156: ifeq +11 -> 167
    //   159: new 289	java/lang/NullPointerException
    //   162: dup
    //   163: invokespecial 290	java/lang/NullPointerException:<init>	()V
    //   166: athrow
    //   167: iconst_0
    //   168: ifeq +11 -> 179
    //   171: new 289	java/lang/NullPointerException
    //   174: dup
    //   175: invokespecial 290	java/lang/NullPointerException:<init>	()V
    //   178: athrow
    //   179: iload 14
    //   181: istore 13
    //   183: aload_1
    //   184: ifnull -91 -> 93
    //   187: aload_1
    //   188: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   191: iconst_0
    //   192: ireturn
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   198: goto -19 -> 179
    //   201: aload_1
    //   202: invokevirtual 306	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   205: astore_2
    //   206: lconst_0
    //   207: lstore 11
    //   209: getstatic 25	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_Int	I
    //   212: newarray <illegal type>
    //   214: astore_3
    //   215: new 308	java/io/ByteArrayOutputStream
    //   218: dup
    //   219: invokespecial 309	java/io/ByteArrayOutputStream:<init>	()V
    //   222: astore 7
    //   224: aload_2
    //   225: aload_3
    //   226: iconst_0
    //   227: getstatic 25	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_Int	I
    //   230: invokevirtual 315	java/io/InputStream:read	([BII)I
    //   233: istore 10
    //   235: iload 10
    //   237: ifle +79 -> 316
    //   240: getstatic 28	com/tencent/open/base/img/ImageDownloader:b	I
    //   243: istore 9
    //   245: lload 11
    //   247: iload 9
    //   249: i2l
    //   250: lcmp
    //   251: iflt +45 -> 296
    //   254: iconst_0
    //   255: ifeq +11 -> 266
    //   258: new 289	java/lang/NullPointerException
    //   261: dup
    //   262: invokespecial 290	java/lang/NullPointerException:<init>	()V
    //   265: athrow
    //   266: aload_2
    //   267: ifnull +7 -> 274
    //   270: aload_2
    //   271: invokevirtual 318	java/io/InputStream:close	()V
    //   274: iload 14
    //   276: istore 13
    //   278: aload_1
    //   279: ifnull -186 -> 93
    //   282: aload_1
    //   283: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   286: iconst_0
    //   287: ireturn
    //   288: astore_0
    //   289: aload_0
    //   290: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   293: goto -19 -> 274
    //   296: aload 7
    //   298: aload_3
    //   299: iconst_0
    //   300: iload 10
    //   302: invokevirtual 322	java/io/ByteArrayOutputStream:write	([BII)V
    //   305: lload 11
    //   307: iload 10
    //   309: i2l
    //   310: ladd
    //   311: lstore 11
    //   313: goto -89 -> 224
    //   316: new 125	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   323: invokestatic 325	com/tencent/open/appcommon/Common:f	()Ljava/lang/String;
    //   326: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: getstatic 328	com/tencent/open/base/img/ImageCache:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   332: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: getfield 330	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   339: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: getstatic 335	java/io/File:separator	Ljava/lang/String;
    //   345: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload_0
    //   349: getfield 84	com/tencent/open/base/img/ImageInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   352: invokestatic 339	com/tencent/open/base/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   355: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: astore 8
    //   363: new 332	java/io/File
    //   366: dup
    //   367: new 125	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   374: aload 8
    //   376: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: ldc_w 341
    //   382: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   391: astore 4
    //   393: aload 4
    //   395: invokevirtual 345	java/io/File:getParent	()Ljava/lang/String;
    //   398: ifnull +23 -> 421
    //   401: aload 4
    //   403: invokevirtual 349	java/io/File:getParentFile	()Ljava/io/File;
    //   406: invokevirtual 353	java/io/File:exists	()Z
    //   409: ifne +12 -> 421
    //   412: aload 4
    //   414: invokevirtual 349	java/io/File:getParentFile	()Ljava/io/File;
    //   417: invokevirtual 356	java/io/File:mkdirs	()Z
    //   420: pop
    //   421: aload 4
    //   423: invokevirtual 353	java/io/File:exists	()Z
    //   426: ifeq +9 -> 435
    //   429: aload 4
    //   431: invokevirtual 359	java/io/File:delete	()Z
    //   434: pop
    //   435: aload 4
    //   437: invokevirtual 362	java/io/File:createNewFile	()Z
    //   440: pop
    //   441: new 364	java/io/FileOutputStream
    //   444: dup
    //   445: new 125	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   452: aload 8
    //   454: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: ldc_w 341
    //   460: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokespecial 365	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   469: astore_3
    //   470: aload_3
    //   471: aload 7
    //   473: invokevirtual 369	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   476: invokevirtual 372	java/io/FileOutputStream:write	([B)V
    //   479: aload_3
    //   480: invokevirtual 375	java/io/FileOutputStream:flush	()V
    //   483: new 332	java/io/File
    //   486: dup
    //   487: aload 8
    //   489: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   492: astore 6
    //   494: aload 6
    //   496: invokevirtual 353	java/io/File:exists	()Z
    //   499: ifeq +9 -> 508
    //   502: aload 6
    //   504: invokevirtual 359	java/io/File:delete	()Z
    //   507: pop
    //   508: aload 4
    //   510: aload 6
    //   512: invokevirtual 379	java/io/File:renameTo	(Ljava/io/File;)Z
    //   515: pop
    //   516: ldc_w 381
    //   519: aload_0
    //   520: getfield 382	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   523: invokestatic 140	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: aload_0
    //   527: aload_1
    //   528: invokevirtual 385	java/net/HttpURLConnection:getLastModified	()J
    //   531: putfield 178	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_Long	J
    //   534: iconst_1
    //   535: istore 13
    //   537: aload_3
    //   538: ifnull +7 -> 545
    //   541: aload_3
    //   542: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   545: aload_2
    //   546: ifnull +7 -> 553
    //   549: aload_2
    //   550: invokevirtual 318	java/io/InputStream:close	()V
    //   553: aload_1
    //   554: ifnull -461 -> 93
    //   557: aload_1
    //   558: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   561: iconst_1
    //   562: ireturn
    //   563: astore_0
    //   564: aload_0
    //   565: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   568: goto -15 -> 553
    //   571: astore_3
    //   572: aconst_null
    //   573: astore 4
    //   575: aconst_null
    //   576: astore_0
    //   577: aconst_null
    //   578: astore_1
    //   579: aconst_null
    //   580: astore_2
    //   581: getstatic 23	com/tencent/open/base/img/ImageDownloader:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   584: ldc_w 388
    //   587: aload_3
    //   588: invokestatic 277	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   591: aload 4
    //   593: ifnull +17 -> 610
    //   596: aload 4
    //   598: invokevirtual 353	java/io/File:exists	()Z
    //   601: ifeq +9 -> 610
    //   604: aload 4
    //   606: invokevirtual 359	java/io/File:delete	()Z
    //   609: pop
    //   610: aload 5
    //   612: ifnull +17 -> 629
    //   615: aload 5
    //   617: invokevirtual 353	java/io/File:exists	()Z
    //   620: ifeq +9 -> 629
    //   623: aload 5
    //   625: invokevirtual 359	java/io/File:delete	()Z
    //   628: pop
    //   629: aload_0
    //   630: ifnull +7 -> 637
    //   633: aload_0
    //   634: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   637: aload_1
    //   638: ifnull +7 -> 645
    //   641: aload_1
    //   642: invokevirtual 318	java/io/InputStream:close	()V
    //   645: iload 14
    //   647: istore 13
    //   649: aload_2
    //   650: ifnull -557 -> 93
    //   653: aload_2
    //   654: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   657: iconst_0
    //   658: ireturn
    //   659: astore_0
    //   660: aload_0
    //   661: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   664: goto -19 -> 645
    //   667: astore_0
    //   668: aconst_null
    //   669: astore_2
    //   670: aconst_null
    //   671: astore_1
    //   672: aload 6
    //   674: astore_3
    //   675: aload_3
    //   676: ifnull +7 -> 683
    //   679: aload_3
    //   680: invokevirtual 386	java/io/FileOutputStream:close	()V
    //   683: aload_2
    //   684: ifnull +7 -> 691
    //   687: aload_2
    //   688: invokevirtual 318	java/io/InputStream:close	()V
    //   691: aload_1
    //   692: ifnull +7 -> 699
    //   695: aload_1
    //   696: invokevirtual 280	java/net/HttpURLConnection:disconnect	()V
    //   699: aload_0
    //   700: athrow
    //   701: astore_2
    //   702: aload_2
    //   703: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   706: goto -15 -> 691
    //   709: astore_0
    //   710: aconst_null
    //   711: astore_2
    //   712: aload 6
    //   714: astore_3
    //   715: goto -40 -> 675
    //   718: astore_0
    //   719: aload 6
    //   721: astore_3
    //   722: goto -47 -> 675
    //   725: astore_0
    //   726: goto -51 -> 675
    //   729: astore 5
    //   731: aload_0
    //   732: astore_3
    //   733: aload_2
    //   734: astore 4
    //   736: aload 5
    //   738: astore_0
    //   739: aload_1
    //   740: astore_2
    //   741: aload 4
    //   743: astore_1
    //   744: goto -69 -> 675
    //   747: astore_3
    //   748: aconst_null
    //   749: astore 4
    //   751: aconst_null
    //   752: astore_0
    //   753: aconst_null
    //   754: astore 6
    //   756: aload_1
    //   757: astore_2
    //   758: aload 6
    //   760: astore_1
    //   761: goto -180 -> 581
    //   764: astore_3
    //   765: aconst_null
    //   766: astore 4
    //   768: aconst_null
    //   769: astore_0
    //   770: aload_2
    //   771: astore 6
    //   773: aload_1
    //   774: astore_2
    //   775: aload 6
    //   777: astore_1
    //   778: goto -197 -> 581
    //   781: astore_3
    //   782: aload_2
    //   783: astore 6
    //   785: aconst_null
    //   786: astore_0
    //   787: aload_1
    //   788: astore_2
    //   789: aload 6
    //   791: astore_1
    //   792: goto -211 -> 581
    //   795: astore 7
    //   797: aload_3
    //   798: astore_0
    //   799: aload_2
    //   800: astore 6
    //   802: aload_1
    //   803: astore_2
    //   804: aload 7
    //   806: astore_3
    //   807: aload 6
    //   809: astore_1
    //   810: goto -229 -> 581
    //   813: astore 7
    //   815: aload 6
    //   817: astore 5
    //   819: aload_3
    //   820: astore_0
    //   821: aload_1
    //   822: astore 6
    //   824: aload 7
    //   826: astore_3
    //   827: aload_2
    //   828: astore_1
    //   829: aload 6
    //   831: astore_2
    //   832: goto -251 -> 581
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	835	0	paramImageInfo	ImageInfo
    //   13	816	1	localObject1	Object
    //   205	483	2	localInputStream	java.io.InputStream
    //   701	2	2	localException1	Exception
    //   711	121	2	localObject2	Object
    //   214	328	3	localObject3	Object
    //   571	17	3	localException2	Exception
    //   674	59	3	localObject4	Object
    //   747	1	3	localException3	Exception
    //   764	1	3	localException4	Exception
    //   781	17	3	localException5	Exception
    //   806	21	3	localObject5	Object
    //   391	376	4	localObject6	Object
    //   4	620	5	localObject7	Object
    //   729	8	5	localObject8	Object
    //   817	1	5	localObject9	Object
    //   1	829	6	localObject10	Object
    //   222	250	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   795	10	7	localException6	Exception
    //   813	12	7	localException7	Exception
    //   361	127	8	str	String
    //   243	5	9	i	int
    //   233	75	10	j	int
    //   109	203	11	l	long
    //   79	569	13	bool1	boolean
    //   7	639	14	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   57	65	96	java/lang/Exception
    //   69	77	96	java/lang/Exception
    //   159	167	193	java/lang/Exception
    //   171	179	193	java/lang/Exception
    //   258	266	288	java/lang/Exception
    //   270	274	288	java/lang/Exception
    //   541	545	563	java/lang/Exception
    //   549	553	563	java/lang/Exception
    //   9	14	571	java/lang/Exception
    //   633	637	659	java/lang/Exception
    //   641	645	659	java/lang/Exception
    //   9	14	667	finally
    //   679	683	701	java/lang/Exception
    //   687	691	701	java/lang/Exception
    //   18	53	709	finally
    //   104	155	709	finally
    //   201	206	709	finally
    //   209	224	718	finally
    //   224	235	718	finally
    //   240	245	718	finally
    //   296	305	718	finally
    //   316	393	718	finally
    //   393	421	718	finally
    //   421	435	718	finally
    //   435	470	718	finally
    //   470	494	725	finally
    //   494	508	725	finally
    //   508	534	725	finally
    //   581	591	729	finally
    //   596	610	729	finally
    //   615	629	729	finally
    //   18	53	747	java/lang/Exception
    //   104	155	747	java/lang/Exception
    //   201	206	747	java/lang/Exception
    //   209	224	764	java/lang/Exception
    //   224	235	764	java/lang/Exception
    //   240	245	764	java/lang/Exception
    //   296	305	764	java/lang/Exception
    //   316	393	764	java/lang/Exception
    //   393	421	781	java/lang/Exception
    //   421	435	781	java/lang/Exception
    //   435	470	781	java/lang/Exception
    //   470	494	795	java/lang/Exception
    //   494	508	813	java/lang/Exception
    //   508	534	813	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\open\base\img\ImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */