package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.vas.LooperGifImage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.Header;

public class NearbyImgDownloader
  extends AbsDownloader
{
  public static final int a = 2;
  public static final String a = NearbyImgDownloader.class.getSimpleName();
  public static final int b = 4;
  public static final String b = "gif_type";
  private static final int c = 32768;
  public static final String d = "1";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static URL a(String paramString)
  {
    paramString = new URL(paramString);
    return new URL("nearbyimage", paramString.getAuthority(), paramString.getFile());
  }
  
  public static URL a(URL paramURL)
  {
    Object localObject = paramURL;
    String str1;
    boolean bool;
    if (paramURL != null)
    {
      long l = SystemClock.elapsedRealtime();
      str1 = paramURL.getHost();
      localObject = InnerDns.a().a(str1, 1001);
      if (QLog.isColorLevel())
      {
        String str2 = a;
        StringBuilder localStringBuilder = new StringBuilder().append("convertURL urlStr: ").append(paramURL.toString()).append(" kenny convert cost: ").append(SystemClock.elapsedRealtime() - l).append(" ok: ");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label182;
        }
        bool = true;
        QLog.i(str2, 2, bool);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label410;
      }
      if (!"p.qpic.cn".equals(str1)) {
        break label188;
      }
      localObject = PicIPManager.a(2);
    }
    label123:
    label182:
    label188:
    label410:
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (;;)
      {
        localObject = new URL("http", (String)localObject, paramURL.getFile());
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, "convertURL urlStr end: " + ((URL)localObject).toString());
        }
        return (URL)localObject;
        bool = false;
        break;
        if ("p.qlogo.cn".equals(str1))
        {
          localObject = PicIPManager.a(1);
          break label123;
        }
        if ("ugc.qpic.cn".equals(str1))
        {
          localObject = PicIPManager.b(8);
          break label123;
        }
        if (b(str1))
        {
          localObject = PicIPManager.a(0);
          break label123;
        }
        if ("i.gtimg.cn".equals(str1))
        {
          localObject = PicIPManager.b();
          break label123;
        }
        if ("imgcache.qq.com".equals(str1))
        {
          localObject = PicIPManager.a();
          break label123;
        }
        if (c(str1))
        {
          localObject = PicIPManager.b(9);
          break label123;
        }
        if (d(str1))
        {
          localObject = PicIPManager.b(11);
          break label123;
        }
        if (e(str1))
        {
          localObject = PicIPManager.b(10);
          break label123;
        }
        if ("pgdt.gtimg.cn".equals(str1))
        {
          localObject = PicIPManager.a(3);
          break label123;
        }
        if ("sqimg.qq.com".equals(str1))
        {
          localObject = PicIPManager.a(4);
          break label123;
        }
        if ("download.wegame.qq.com".equals(str1))
        {
          localObject = PicIPManager.a(5);
          break label123;
        }
        if ("wfqqreader.3g.qq.com".equals(str1))
        {
          localObject = PicIPManager.a(6);
          break label123;
        }
        if (!"buluo.qq.com".equals(str1)) {
          break label410;
        }
        localObject = PicIPManager.a(7);
        break label123;
        localObject = str1;
      }
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "download img start url: " + paramString + " time: " + SystemClock.elapsedRealtime());
    }
  }
  
  private void a(String paramString, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "download img end url: " + paramString + " " + paramBoolean + " " + paramLong);
      }
      return;
    }
    QLog.w(a, 1, "download img end url: " + paramString + " " + paramBoolean + " " + paramLong);
  }
  
  /* Error */
  private boolean a(java.io.InputStream paramInputStream, long paramLong, DiskCache.Editor paramEditor, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: new 184	java/io/BufferedInputStream
    //   3: dup
    //   4: aload_1
    //   5: ldc 14
    //   7: invokespecial 187	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   10: astore 6
    //   12: ldc 14
    //   14: newarray <illegal type>
    //   16: astore 7
    //   18: new 189	java/io/FileOutputStream
    //   21: dup
    //   22: aload 4
    //   24: getfield 194	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   27: iconst_0
    //   28: invokespecial 197	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   31: astore 4
    //   33: lconst_0
    //   34: lstore 10
    //   36: aload 4
    //   38: astore_1
    //   39: aload 6
    //   41: aload 7
    //   43: invokevirtual 203	java/io/InputStream:read	([B)I
    //   46: istore 8
    //   48: iload 8
    //   50: iconst_m1
    //   51: if_icmpeq +153 -> 204
    //   54: aload 4
    //   56: astore_1
    //   57: aload 4
    //   59: aload 7
    //   61: iconst_0
    //   62: iload 8
    //   64: invokevirtual 207	java/io/FileOutputStream:write	([BII)V
    //   67: lload 10
    //   69: iload 8
    //   71: i2l
    //   72: ladd
    //   73: lstore 12
    //   75: aload 4
    //   77: astore_1
    //   78: lload 12
    //   80: l2f
    //   81: lload_2
    //   82: l2f
    //   83: fdiv
    //   84: ldc -48
    //   86: fmul
    //   87: f2i
    //   88: istore 9
    //   90: aload 4
    //   92: astore_1
    //   93: aload 5
    //   95: iload 9
    //   97: invokeinterface 214 2 0
    //   102: lload 12
    //   104: lstore 10
    //   106: aload 4
    //   108: astore_1
    //   109: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq -76 -> 36
    //   115: aload 4
    //   117: astore_1
    //   118: getstatic 33	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	Ljava/lang/String;
    //   121: iconst_2
    //   122: new 80	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   129: ldc -40
    //   131: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: iload 9
    //   136: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: ldc -35
    //   141: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: iload 8
    //   146: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: lload 12
    //   157: lstore 10
    //   159: goto -123 -> 36
    //   162: astore 5
    //   164: aload 4
    //   166: astore_1
    //   167: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +18 -> 188
    //   173: aload 4
    //   175: astore_1
    //   176: getstatic 33	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	Ljava/lang/String;
    //   179: iconst_2
    //   180: aload 5
    //   182: invokevirtual 222	java/io/IOException:toString	()Ljava/lang/String;
    //   185: invokestatic 174	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iconst_0
    //   189: istore 14
    //   191: aload 6
    //   193: invokevirtual 225	java/io/InputStream:close	()V
    //   196: aload 4
    //   198: invokevirtual 226	java/io/FileOutputStream:close	()V
    //   201: iload 14
    //   203: ireturn
    //   204: aload 4
    //   206: astore_1
    //   207: aload 4
    //   209: invokevirtual 229	java/io/FileOutputStream:flush	()V
    //   212: iconst_1
    //   213: istore 14
    //   215: aload 6
    //   217: invokevirtual 225	java/io/InputStream:close	()V
    //   220: aload 4
    //   222: invokevirtual 226	java/io/FileOutputStream:close	()V
    //   225: iconst_1
    //   226: ireturn
    //   227: astore_1
    //   228: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq -30 -> 201
    //   234: getstatic 33	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	Ljava/lang/String;
    //   237: iconst_2
    //   238: aload_1
    //   239: invokevirtual 230	java/lang/Exception:toString	()Ljava/lang/String;
    //   242: invokestatic 174	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: iconst_1
    //   246: ireturn
    //   247: astore_1
    //   248: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq -50 -> 201
    //   254: getstatic 33	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	Ljava/lang/String;
    //   257: iconst_2
    //   258: aload_1
    //   259: invokevirtual 230	java/lang/Exception:toString	()Ljava/lang/String;
    //   262: invokestatic 174	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: iconst_0
    //   266: ireturn
    //   267: astore 4
    //   269: aconst_null
    //   270: astore_1
    //   271: aload 6
    //   273: invokevirtual 225	java/io/InputStream:close	()V
    //   276: aload_1
    //   277: invokevirtual 226	java/io/FileOutputStream:close	()V
    //   280: aload 4
    //   282: athrow
    //   283: astore_1
    //   284: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq -7 -> 280
    //   290: getstatic 33	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	Ljava/lang/String;
    //   293: iconst_2
    //   294: aload_1
    //   295: invokevirtual 230	java/lang/Exception:toString	()Ljava/lang/String;
    //   298: invokestatic 174	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: goto -21 -> 280
    //   304: astore 4
    //   306: goto -35 -> 271
    //   309: astore 5
    //   311: aconst_null
    //   312: astore 4
    //   314: goto -150 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	NearbyImgDownloader
    //   0	317	1	paramInputStream	java.io.InputStream
    //   0	317	2	paramLong	long
    //   0	317	4	paramEditor	DiskCache.Editor
    //   0	317	5	paramURLDrawableHandler	URLDrawableHandler
    //   10	262	6	localBufferedInputStream	java.io.BufferedInputStream
    //   16	44	7	arrayOfByte	byte[]
    //   46	99	8	i	int
    //   88	47	9	j	int
    //   34	124	10	l1	long
    //   73	83	12	l2	long
    //   189	25	14	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   39	48	162	java/io/IOException
    //   57	67	162	java/io/IOException
    //   78	90	162	java/io/IOException
    //   93	102	162	java/io/IOException
    //   109	115	162	java/io/IOException
    //   118	155	162	java/io/IOException
    //   207	212	162	java/io/IOException
    //   215	225	227	java/lang/Exception
    //   191	201	247	java/lang/Exception
    //   12	33	267	finally
    //   271	280	283	java/lang/Exception
    //   39	48	304	finally
    //   57	67	304	finally
    //   78	90	304	finally
    //   93	102	304	finally
    //   109	115	304	finally
    //   118	155	304	finally
    //   167	173	304	finally
    //   176	188	304	finally
    //   207	212	304	finally
    //   12	33	309	java/io/IOException
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("^q\\d?.qlogo.cn$").matcher(paramString).find();
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("a[0-9].qpic.cn").matcher(paramString).find();
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile(".*qzs.qq.com").matcher(paramString).find();
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile(".*qzonestyle.gtimg.cn").matcher(paramString).find();
  }
  
  /* Error */
  public File a(DiskCache.Editor paramEditor, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   5: invokespecial 267	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;)V
    //   8: aload_3
    //   9: invokeinterface 270 1 0
    //   14: aload_2
    //   15: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   18: ldc_w 272
    //   21: invokevirtual 275	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   24: ifeq +224 -> 248
    //   27: aload_2
    //   28: aload_2
    //   29: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   32: ldc_w 272
    //   35: ldc_w 277
    //   38: invokevirtual 281	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: putfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   44: new 283	java/io/File
    //   47: dup
    //   48: aload_2
    //   49: getfield 287	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   52: invokevirtual 51	java/net/URL:getFile	()Ljava/lang/String;
    //   55: invokespecial 288	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 4
    //   60: aload 4
    //   62: invokevirtual 291	java/io/File:exists	()Z
    //   65: ifeq +162 -> 227
    //   68: aload 4
    //   70: invokevirtual 294	java/io/File:isFile	()Z
    //   73: ifeq +154 -> 227
    //   76: new 184	java/io/BufferedInputStream
    //   79: dup
    //   80: new 296	java/io/FileInputStream
    //   83: dup
    //   84: aload 4
    //   86: invokespecial 299	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: invokespecial 302	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore 5
    //   94: iconst_0
    //   95: istore 9
    //   97: aload_0
    //   98: aload 5
    //   100: aload 4
    //   102: invokevirtual 305	java/io/File:length	()J
    //   105: aload_1
    //   106: aload_3
    //   107: invokespecial 178	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/io/InputStream;JLcom/tencent/mobileqq/transfile/DiskCache$Editor;Lcom/tencent/image/URLDrawableHandler;)Z
    //   110: ifeq +30 -> 140
    //   113: aload_3
    //   114: aload 4
    //   116: invokevirtual 305	java/io/File:length	()J
    //   119: invokeinterface 309 3 0
    //   124: aload_0
    //   125: aload_2
    //   126: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   129: iconst_1
    //   130: aload 4
    //   132: invokevirtual 305	java/io/File:length	()J
    //   135: invokespecial 311	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   138: aconst_null
    //   139: areturn
    //   140: iload 9
    //   142: iconst_4
    //   143: if_icmpne +24 -> 167
    //   146: aload_3
    //   147: iconst_4
    //   148: invokeinterface 314 2 0
    //   153: aload_0
    //   154: aload_2
    //   155: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   158: iconst_0
    //   159: ldc2_w 315
    //   162: invokespecial 311	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   165: aconst_null
    //   166: areturn
    //   167: ldc2_w 317
    //   170: invokestatic 323	java/lang/Thread:sleep	(J)V
    //   173: iload 9
    //   175: iconst_1
    //   176: iadd
    //   177: istore 9
    //   179: iload 9
    //   181: iconst_4
    //   182: if_icmple +442 -> 624
    //   185: aload_3
    //   186: iconst_4
    //   187: invokeinterface 314 2 0
    //   192: aload_0
    //   193: aload_2
    //   194: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   197: iconst_0
    //   198: ldc2_w 315
    //   201: invokespecial 311	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   204: aconst_null
    //   205: areturn
    //   206: astore_1
    //   207: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   210: ifeq -25 -> 185
    //   213: getstatic 33	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	Ljava/lang/String;
    //   216: iconst_2
    //   217: aload_1
    //   218: invokevirtual 324	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   221: invokestatic 174	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: goto -39 -> 185
    //   227: aload_3
    //   228: iconst_4
    //   229: invokeinterface 314 2 0
    //   234: aload_0
    //   235: aload_2
    //   236: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   239: iconst_0
    //   240: ldc2_w 315
    //   243: invokespecial 311	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   246: aconst_null
    //   247: areturn
    //   248: new 326	java/util/ArrayList
    //   251: dup
    //   252: invokespecial 327	java/util/ArrayList:<init>	()V
    //   255: astore 7
    //   257: new 40	java/net/URL
    //   260: dup
    //   261: aload_2
    //   262: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   265: invokespecial 43	java/net/URL:<init>	(Ljava/lang/String;)V
    //   268: astore 4
    //   270: aload 4
    //   272: invokevirtual 64	java/net/URL:getHost	()Ljava/lang/String;
    //   275: astore 8
    //   277: aload 7
    //   279: new 329	org/apache/http/message/BasicHeader
    //   282: dup
    //   283: ldc_w 331
    //   286: aload 8
    //   288: invokespecial 334	org/apache/http/message/BasicHeader:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: invokeinterface 339 2 0
    //   296: pop
    //   297: aload 4
    //   299: invokestatic 341	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/net/URL;)Ljava/net/URL;
    //   302: astore 4
    //   304: aload_2
    //   305: aload 4
    //   307: invokevirtual 90	java/net/URL:toString	()Ljava/lang/String;
    //   310: putfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   313: iconst_0
    //   314: istore 9
    //   316: iload 9
    //   318: iconst_1
    //   319: iadd
    //   320: istore 10
    //   322: new 343	com/tencent/mobileqq/transfile/NearbyImgDownloader$DownloadListener
    //   325: dup
    //   326: aload_0
    //   327: aload_1
    //   328: aload_3
    //   329: invokespecial 346	com/tencent/mobileqq/transfile/NearbyImgDownloader$DownloadListener:<init>	(Lcom/tencent/mobileqq/transfile/NearbyImgDownloader;Lcom/tencent/mobileqq/transfile/DiskCache$Editor;Lcom/tencent/image/URLDrawableHandler;)V
    //   332: astore 5
    //   334: aload_2
    //   335: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   338: aload 5
    //   340: aload 7
    //   342: iconst_3
    //   343: iconst_0
    //   344: invokestatic 351	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;Lcom/tencent/mobileqq/utils/HttpDownloadUtil$DownloadInfoListener;Ljava/util/List;IZ)Lcom/tencent/mobileqq/emoticon/DownloadInfo;
    //   347: astore 5
    //   349: aload 5
    //   351: getfield 355	com/tencent/mobileqq/emoticon/DownloadInfo:b	I
    //   354: ifne +91 -> 445
    //   357: aload_3
    //   358: aload 5
    //   360: getfield 357	com/tencent/mobileqq/emoticon/DownloadInfo:e	I
    //   363: i2l
    //   364: invokeinterface 309 3 0
    //   369: aload_0
    //   370: aload_2
    //   371: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   374: iconst_1
    //   375: aload 5
    //   377: getfield 357	com/tencent/mobileqq/emoticon/DownloadInfo:e	I
    //   380: i2l
    //   381: invokespecial 311	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   384: aconst_null
    //   385: areturn
    //   386: astore_1
    //   387: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq +33 -> 423
    //   393: getstatic 33	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	Ljava/lang/String;
    //   396: iconst_2
    //   397: new 80	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   404: ldc_w 359
    //   407: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_1
    //   411: invokevirtual 362	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   414: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: aload_3
    //   424: bipush 13
    //   426: invokeinterface 314 2 0
    //   431: aload_0
    //   432: aload_2
    //   433: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   436: iconst_0
    //   437: ldc2_w 363
    //   440: invokespecial 311	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   443: aconst_null
    //   444: areturn
    //   445: iload 10
    //   447: iconst_2
    //   448: if_icmpne +31 -> 479
    //   451: aload_3
    //   452: aload 5
    //   454: getfield 355	com/tencent/mobileqq/emoticon/DownloadInfo:b	I
    //   457: invokeinterface 314 2 0
    //   462: aload_0
    //   463: aload_2
    //   464: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   467: iconst_0
    //   468: aload 5
    //   470: getfield 355	com/tencent/mobileqq/emoticon/DownloadInfo:b	I
    //   473: i2l
    //   474: invokespecial 311	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   477: aconst_null
    //   478: areturn
    //   479: aload 4
    //   481: astore 5
    //   483: iload 10
    //   485: iconst_1
    //   486: if_icmpne +46 -> 532
    //   489: invokestatic 69	com/tencent/mobileqq/transfile/dns/InnerDns:a	()Lcom/tencent/mobileqq/transfile/dns/InnerDns;
    //   492: aload 8
    //   494: aload 4
    //   496: invokevirtual 64	java/net/URL:getHost	()Ljava/lang/String;
    //   499: sipush 1001
    //   502: invokevirtual 367	com/tencent/mobileqq/transfile/dns/InnerDns:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   505: new 40	java/net/URL
    //   508: dup
    //   509: ldc 126
    //   511: aload 8
    //   513: aload 4
    //   515: invokevirtual 51	java/net/URL:getFile	()Ljava/lang/String;
    //   518: invokespecial 54	java/net/URL:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   521: astore 5
    //   523: aload_2
    //   524: aload 5
    //   526: invokevirtual 90	java/net/URL:toString	()Ljava/lang/String;
    //   529: putfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   532: iload 10
    //   534: istore 9
    //   536: aload 5
    //   538: astore 4
    //   540: iload 10
    //   542: iconst_2
    //   543: if_icmple -227 -> 316
    //   546: aload_0
    //   547: aload_2
    //   548: getfield 265	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   551: iconst_0
    //   552: ldc2_w 368
    //   555: invokespecial 311	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	(Ljava/lang/String;ZJ)V
    //   558: aconst_null
    //   559: areturn
    //   560: astore 5
    //   562: aload 5
    //   564: astore 6
    //   566: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   569: ifeq +34 -> 603
    //   572: getstatic 33	com/tencent/mobileqq/transfile/NearbyImgDownloader:a	Ljava/lang/String;
    //   575: iconst_2
    //   576: new 80	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   583: ldc_w 371
    //   586: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload 6
    //   591: invokevirtual 362	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   594: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 111	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: aload 4
    //   605: astore 5
    //   607: goto -75 -> 532
    //   610: astore 6
    //   612: goto -439 -> 173
    //   615: astore 6
    //   617: aload 5
    //   619: astore 4
    //   621: goto -55 -> 566
    //   624: goto -527 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	627	0	this	NearbyImgDownloader
    //   0	627	1	paramEditor	DiskCache.Editor
    //   0	627	2	paramDownloadParams	DownloadParams
    //   0	627	3	paramURLDrawableHandler	URLDrawableHandler
    //   58	562	4	localObject1	Object
    //   92	445	5	localObject2	Object
    //   560	3	5	localMalformedURLException1	java.net.MalformedURLException
    //   605	13	5	localObject3	Object
    //   564	26	6	localMalformedURLException2	java.net.MalformedURLException
    //   610	1	6	localInterruptedException	InterruptedException
    //   615	1	6	localMalformedURLException3	java.net.MalformedURLException
    //   255	86	7	localArrayList	java.util.ArrayList
    //   275	237	8	str	String
    //   95	440	9	i	int
    //   320	224	10	j	int
    // Exception table:
    //   from	to	target	type
    //   76	94	206	java/io/FileNotFoundException
    //   97	138	206	java/io/FileNotFoundException
    //   146	165	206	java/io/FileNotFoundException
    //   167	173	206	java/io/FileNotFoundException
    //   257	313	386	java/net/MalformedURLException
    //   505	523	560	java/net/MalformedURLException
    //   167	173	610	java/lang/InterruptedException
    //   523	532	615	java/net/MalformedURLException
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return null;
  }
  
  public boolean a()
  {
    return true;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = paramDownloadParams.getHeader("gif_type");
    if (paramURLDrawableHandler != null)
    {
      paramURLDrawableHandler = paramURLDrawableHandler.getValue();
      float f = paramDownloadParams.mGifRoundCorner;
      if ((!TextUtils.isEmpty(paramURLDrawableHandler)) && (paramURLDrawableHandler.equals("1"))) {
        return new LooperGifImage(paramFile, true, f, 1);
      }
    }
    return null;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    String str = paramDownloadParams.urlStr;
    Object localObject = a(str);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "loadImageFile file exist: " + ((File)localObject).getAbsolutePath());
      }
      return (File)localObject;
    }
    localObject = c(str);
    localObject = InitUrlDrawable.a.a((String)localObject);
    try
    {
      a((DiskCache.Editor)localObject, paramDownloadParams, paramURLDrawableHandler);
      paramDownloadParams = a(str);
      if (paramDownloadParams != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, "loadImageFile f exist:" + paramDownloadParams.getAbsolutePath());
        }
        ((DiskCache.Editor)localObject).a.delete();
        return paramDownloadParams;
      }
    }
    catch (Exception paramDownloadParams)
    {
      if (localObject != null) {
        ((DiskCache.Editor)localObject).a(false);
      }
      throw paramDownloadParams;
    }
    paramDownloadParams = ((DiskCache.Editor)localObject).a();
    return paramDownloadParams;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\NearbyImgDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */