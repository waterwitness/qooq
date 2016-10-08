package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import mqq.os.MqqHandler;
import pxi;
import pxj;
import pxk;

public abstract class FaceDownloader
{
  public static final int a = 100;
  public static final String a = "actGetUserHead";
  private static boolean jdField_a_of_type_Boolean = false;
  public static final String b = "actGetGroupHead";
  public static final String c = "actGetNearbyHead";
  private static final String d = "Q.qqhead.FaceDownloader";
  private static String e;
  public static final int f = 3000;
  private static final int g = 30000;
  private static int j = 1;
  protected byte a;
  protected AppInterface a;
  private FaceDownloader.FaceDownloadThreadInfo jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo;
  public ArrayList a;
  public HashSet a;
  public LinkedList a;
  protected MqqHandler a;
  private pxk[] jdField_a_of_type_ArrayOfPxk;
  public int b;
  public ArrayList b;
  public int c;
  public int d;
  protected int e;
  private int h = 2;
  private int i = 10;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FaceDownloader(AppInterface paramAppInterface)
  {
    this.jdField_b_of_type_Int = 6;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(100);
    b();
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo.jdField_b_of_type_Int != Integer.MIN_VALUE) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo.jdField_b_of_type_Int;
    }
    String str = BaseApplicationImpl.processName;
    if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.mobileqq"))) {
      this.jdField_b_of_type_Int = 4;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.d = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ArrayOfPxk = new pxk[this.jdField_b_of_type_Int];
    int k = 0;
    while (k < this.jdField_a_of_type_ArrayOfPxk.length)
    {
      this.jdField_a_of_type_ArrayOfPxk[k] = new pxk(this, k);
      if (ThreadOptimizer.a().c()) {
        this.jdField_a_of_type_ArrayOfPxk[k].setPriority(1);
      }
      this.jdField_a_of_type_ArrayOfPxk[k].start();
      k += 1;
    }
    this.jdField_e_of_type_Int = a();
    switch (this.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler = new pxi(this, Looper.getMainLooper());
      return;
      this.jdField_a_of_type_Byte = 3;
      continue;
      this.jdField_a_of_type_Byte = 2;
      continue;
      this.jdField_a_of_type_Byte = 0;
    }
  }
  
  public static String a(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 8)) {
      return "";
    }
    String str2 = b(paramInt);
    paramInt = NetworkUtil.a(BaseApplicationImpl.a().getApplicationContext());
    String str1;
    if (paramInt == 1) {
      str1 = "WIFI";
    }
    for (;;)
    {
      return str2 + str1;
      if (paramInt == 2) {
        str1 = "2G";
      } else if (paramInt == 3) {
        str1 = "3G";
      } else if (paramInt == 4) {
        str1 = "4G";
      } else {
        str1 = "Unknown";
      }
    }
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, FaceInfo paramFaceInfo)
  {
    if ((paramHttpURLConnection == null) || (paramFaceInfo == null) || (paramFaceInfo.a == null)) {
      return;
    }
    try
    {
      QLog.i("Q.qqhead.FaceDownloader", 2, "headInfo=" + paramHttpURLConnection.getResponseCode() + "," + paramHttpURLConnection.getContentType() + "," + paramHttpURLConnection.getContentLength() + "," + paramHttpURLConnection.getHeaderField("Server") + "," + paramHttpURLConnection.getHeaderField("X-ErrNo") + "," + paramHttpURLConnection.getHeaderField("X-RtFlag") + "," + paramHttpURLConnection.getHeaderField("X-BCheck") + "," + paramHttpURLConnection.getHeaderField("X-BCheck") + "," + paramFaceInfo.a.headVerify);
      return;
    }
    catch (Throwable paramHttpURLConnection) {}
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "actGetUserHead";
    case 4: 
    case 8: 
      return "actGetGroupHead";
    case 16: 
    case 32: 
      return "actGetNearbyHead";
    }
    return "actGetUserHead";
  }
  
  private void b()
  {
    if (TextUtils.isEmpty(BaseApplicationImpl.processName)) {}
    for (;;)
    {
      return;
      if (BaseApplicationImpl.processName.equals("com.tencent.mobileqq:tool")) {}
      for (this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo = a(); QLog.isColorLevel(); this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo = new FaceDownloader.FaceDownloadThreadInfo(this))
      {
        QLog.i("Q.qqhead.FaceDownloader", 2, "initFaceDownloadThreadInfo, maxThreadCount=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo.jdField_b_of_type_Int + ",priority=" + this.jdField_a_of_type_ComTencentMobileqqAppFaceDownloader$FaceDownloadThreadInfo.c);
        return;
      }
    }
  }
  
  private void c()
  {
    ThreadManager.a(new pxj(this), 5, null, true);
  }
  
  protected int a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    int k = Math.min(localBaseApplicationImpl.getResources().getDisplayMetrics().widthPixels, localBaseApplicationImpl.getResources().getDisplayMetrics().heightPixels);
    if (k > 720) {}
    while (k >= 640) {
      return 140;
    }
    return 40;
  }
  
  public int a(byte paramByte)
  {
    byte b3 = paramByte;
    if (paramByte == 0) {
      b3 = 1;
    }
    paramByte = 1 << this.jdField_a_of_type_Byte;
    if ((paramByte & b3) == paramByte) {
      return this.jdField_e_of_type_Int;
    }
    byte b2 = 0;
    paramByte = this.jdField_a_of_type_Byte - 1;
    byte b1 = b2;
    if (paramByte >= 0)
    {
      b1 = (byte)(1 << paramByte);
      if ((b1 & b3) == b1) {
        b1 = 1;
      }
    }
    else
    {
      b2 = paramByte;
      if (b1 != 0) {
        break label168;
      }
      paramByte = this.jdField_a_of_type_Byte + 1;
      b2 = paramByte;
      if (paramByte >= 8) {
        break label168;
      }
      b2 = (byte)(1 << paramByte);
      if ((b2 & b3) != b2) {
        break label147;
      }
      b1 = 1;
    }
    for (;;)
    {
      if (b1 != 0) {}
      switch (paramByte)
      {
      case 1: 
      default: 
        return 140;
        paramByte -= 1;
        break;
        paramByte += 1;
        break;
      case 0: 
        return 40;
      case 2: 
        return 100;
      case 3: 
        return 140;
      case 4: 
        label147:
        return 640;
        label168:
        paramByte = b2;
      }
    }
  }
  
  /* Error */
  public int a(String paramString, java.io.File paramFile, FaceInfo paramFaceInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 315	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   3: astore 15
    //   5: lconst_0
    //   6: lstore 31
    //   8: aload 15
    //   10: ifnonnull +24 -> 34
    //   13: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   16: ifeq +12 -> 28
    //   19: ldc 21
    //   21: iconst_2
    //   22: ldc_w 317
    //   25: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   28: iconst_1
    //   29: istore 20
    //   31: iload 20
    //   33: ireturn
    //   34: new 319	java/net/URL
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 322	java/net/URL:<init>	(Ljava/lang/String;)V
    //   42: astore 13
    //   44: invokestatic 328	java/lang/System:currentTimeMillis	()J
    //   47: pop2
    //   48: new 4	java/lang/Object
    //   51: dup
    //   52: invokespecial 51	java/lang/Object:<init>	()V
    //   55: astore 12
    //   57: aload_2
    //   58: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   61: astore 5
    //   63: aload 5
    //   65: ifnull +17 -> 82
    //   68: aload 5
    //   70: invokevirtual 337	java/io/File:exists	()Z
    //   73: ifne +9 -> 82
    //   76: aload 5
    //   78: invokevirtual 340	java/io/File:mkdirs	()Z
    //   81: pop
    //   82: aconst_null
    //   83: astore 5
    //   85: new 342	com/tencent/mobileqq/emoticon/DownloadInfo
    //   88: dup
    //   89: aload_1
    //   90: aconst_null
    //   91: iconst_0
    //   92: invokespecial 345	com/tencent/mobileqq/emoticon/DownloadInfo:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   95: astore 16
    //   97: aload 15
    //   99: ifnonnull +40 -> 139
    //   102: ldc 21
    //   104: iconst_1
    //   105: ldc_w 347
    //   108: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload 16
    //   113: iconst_1
    //   114: putfield 348	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   117: iconst_1
    //   118: ireturn
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 351	java/net/MalformedURLException:printStackTrace	()V
    //   124: bipush 13
    //   126: ireturn
    //   127: astore_1
    //   128: ldc 21
    //   130: iconst_1
    //   131: ldc_w 353
    //   134: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: iconst_4
    //   138: ireturn
    //   139: new 357	org/apache/http/client/methods/HttpGet
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 358	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   147: pop
    //   148: new 330	java/io/File
    //   151: dup
    //   152: new 175	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   159: aload_2
    //   160: invokevirtual 361	java/io/File:getPath	()Ljava/lang/String;
    //   163: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 363
    //   169: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 364	java/io/File:<init>	(Ljava/lang/String;)V
    //   178: astore 14
    //   180: aload 14
    //   182: invokevirtual 337	java/io/File:exists	()Z
    //   185: ifeq +9 -> 194
    //   188: aload 14
    //   190: invokevirtual 367	java/io/File:delete	()Z
    //   193: pop
    //   194: aconst_null
    //   195: astore 6
    //   197: iconst_m1
    //   198: istore 25
    //   200: iconst_5
    //   201: istore 19
    //   203: aload_1
    //   204: astore 7
    //   206: aload 6
    //   208: astore_1
    //   209: iload 25
    //   211: iconst_m1
    //   212: if_icmpeq +5589 -> 5801
    //   215: aload_3
    //   216: getfield 200	com/tencent/mobileqq/util/FaceInfo:a	LAvatarInfo/QQHeadInfo;
    //   219: astore 8
    //   221: aload 8
    //   223: ifnonnull +105 -> 328
    //   226: aload 16
    //   228: iload 19
    //   230: putfield 348	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   233: iload 19
    //   235: istore 20
    //   237: iload 4
    //   239: ifeq -208 -> 31
    //   242: new 369	pxl
    //   245: dup
    //   246: aload_0
    //   247: invokespecial 370	pxl:<init>	(Lcom/tencent/mobileqq/app/FaceDownloader;)V
    //   250: astore_1
    //   251: aload_1
    //   252: aload_3
    //   253: putfield 373	pxl:jdField_a_of_type_ComTencentMobileqqUtilFaceInfo	Lcom/tencent/mobileqq/util/FaceInfo;
    //   256: iload 19
    //   258: ifeq +5045 -> 5303
    //   261: aload_3
    //   262: getstatic 376	com/tencent/mobileqq/util/FaceInfo:n	I
    //   265: invokevirtual 378	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   268: aload_1
    //   269: aconst_null
    //   270: putfield 381	pxl:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   273: aload_0
    //   274: getfield 69	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   277: aload_1
    //   278: invokevirtual 384	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   281: pop
    //   282: aload_0
    //   283: getfield 149	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   286: bipush 100
    //   288: aload_1
    //   289: invokevirtual 390	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   292: invokevirtual 395	android/os/Message:sendToTarget	()V
    //   295: iload 19
    //   297: ireturn
    //   298: astore 6
    //   300: aload_1
    //   301: invokestatic 399	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   304: astore_1
    //   305: goto -157 -> 148
    //   308: astore_1
    //   309: ldc 21
    //   311: iconst_1
    //   312: ldc_w 401
    //   315: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aload 16
    //   320: bipush 13
    //   322: putfield 348	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_b_of_type_Int	I
    //   325: bipush 13
    //   327: ireturn
    //   328: ldc_w 403
    //   331: astore 6
    //   333: aload 8
    //   335: getfield 406	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   338: bipush 32
    //   340: if_icmpne +1788 -> 2128
    //   343: aload 8
    //   345: getfield 409	AvatarInfo/QQHeadInfo:originUsrType	I
    //   348: iconst_1
    //   349: if_icmpne +1761 -> 2110
    //   352: ldc_w 403
    //   355: astore 6
    //   357: new 175	java/lang/StringBuilder
    //   360: dup
    //   361: ldc_w 411
    //   364: invokespecial 412	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   367: astore 8
    //   369: aload 8
    //   371: aload 6
    //   373: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 7
    //   379: ldc_w 414
    //   382: bipush 8
    //   384: invokevirtual 418	java/lang/String:indexOf	(Ljava/lang/String;I)I
    //   387: istore 19
    //   389: iload 19
    //   391: bipush 8
    //   393: if_icmple +5401 -> 5794
    //   396: aload 8
    //   398: aload 7
    //   400: iload 19
    //   402: invokevirtual 421	java/lang/String:substring	(I)Ljava/lang/String;
    //   405: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 8
    //   411: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: astore 6
    //   416: ldc 21
    //   418: iconst_1
    //   419: new 175	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 423
    //   429: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: iload 25
    //   434: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   437: ldc_w 425
    //   440: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 6
    //   445: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: ldc_w 427
    //   451: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_3
    //   455: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 355	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload 6
    //   466: astore 8
    //   468: iconst_5
    //   469: istore 19
    //   471: iconst_0
    //   472: istore 41
    //   474: iconst_0
    //   475: istore 42
    //   477: iconst_0
    //   478: istore 43
    //   480: iconst_0
    //   481: istore 37
    //   483: invokestatic 435	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   486: astore 17
    //   488: invokestatic 438	android/net/Proxy:getDefaultPort	()I
    //   491: istore 30
    //   493: aload 15
    //   495: ifnull +5290 -> 5785
    //   498: aload 15
    //   500: invokevirtual 443	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   503: astore 6
    //   505: aload 15
    //   507: invokevirtual 446	android/net/NetworkInfo:getType	()I
    //   510: istore 26
    //   512: aload 6
    //   514: invokestatic 450	com/tencent/mobileqq/utils/httputils/PkgTools:f	(Ljava/lang/String;)Ljava/lang/String;
    //   517: astore 18
    //   519: lload 31
    //   521: lstore 33
    //   523: iload 41
    //   525: istore 39
    //   527: aload_1
    //   528: astore 10
    //   530: iload 19
    //   532: istore 21
    //   534: lload 31
    //   536: lstore 35
    //   538: iload 42
    //   540: istore 40
    //   542: aload_1
    //   543: astore 11
    //   545: iload 19
    //   547: istore 22
    //   549: aload 5
    //   551: astore 9
    //   553: iload 43
    //   555: istore 38
    //   557: aload_1
    //   558: astore 7
    //   560: iload 19
    //   562: istore 20
    //   564: aload 18
    //   566: getstatic 452	com/tencent/mobileqq/app/FaceDownloader:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   569: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   572: ifne +164 -> 736
    //   575: iload 26
    //   577: iconst_1
    //   578: if_icmpeq +59 -> 637
    //   581: lload 31
    //   583: lstore 33
    //   585: iload 41
    //   587: istore 39
    //   589: aload_1
    //   590: astore 10
    //   592: iload 19
    //   594: istore 21
    //   596: lload 31
    //   598: lstore 35
    //   600: iload 42
    //   602: istore 40
    //   604: aload_1
    //   605: astore 11
    //   607: iload 19
    //   609: istore 22
    //   611: aload 5
    //   613: astore 9
    //   615: iload 43
    //   617: istore 38
    //   619: aload_1
    //   620: astore 7
    //   622: iload 19
    //   624: istore 20
    //   626: aload 18
    //   628: getstatic 454	com/tencent/mobileqq/utils/httputils/PkgTools:d	Ljava/lang/String;
    //   631: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   634: ifeq +1547 -> 2181
    //   637: lload 31
    //   639: lstore 33
    //   641: iload 41
    //   643: istore 39
    //   645: aload_1
    //   646: astore 10
    //   648: iload 19
    //   650: istore 21
    //   652: lload 31
    //   654: lstore 35
    //   656: iload 42
    //   658: istore 40
    //   660: aload_1
    //   661: astore 11
    //   663: iload 19
    //   665: istore 22
    //   667: aload 5
    //   669: astore 9
    //   671: iload 43
    //   673: istore 38
    //   675: aload_1
    //   676: astore 7
    //   678: iload 19
    //   680: istore 20
    //   682: iconst_0
    //   683: putstatic 456	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   686: lload 31
    //   688: lstore 33
    //   690: iload 41
    //   692: istore 39
    //   694: aload_1
    //   695: astore 10
    //   697: iload 19
    //   699: istore 21
    //   701: lload 31
    //   703: lstore 35
    //   705: iload 42
    //   707: istore 40
    //   709: aload_1
    //   710: astore 11
    //   712: iload 19
    //   714: istore 22
    //   716: aload 5
    //   718: astore 9
    //   720: iload 43
    //   722: istore 38
    //   724: aload_1
    //   725: astore 7
    //   727: iload 19
    //   729: istore 20
    //   731: aload 18
    //   733: putstatic 452	com/tencent/mobileqq/app/FaceDownloader:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   736: iload 26
    //   738: iconst_1
    //   739: if_icmpne +164 -> 903
    //   742: lload 31
    //   744: lstore 33
    //   746: iload 41
    //   748: istore 39
    //   750: aload_1
    //   751: astore 10
    //   753: iload 19
    //   755: istore 21
    //   757: lload 31
    //   759: lstore 35
    //   761: iload 42
    //   763: istore 40
    //   765: aload_1
    //   766: astore 11
    //   768: iload 19
    //   770: istore 22
    //   772: aload 5
    //   774: astore 9
    //   776: iload 43
    //   778: istore 38
    //   780: aload_1
    //   781: astore 7
    //   783: iload 19
    //   785: istore 20
    //   787: ldc_w 458
    //   790: aload 17
    //   792: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   795: ifne +59 -> 854
    //   798: lload 31
    //   800: lstore 33
    //   802: iload 41
    //   804: istore 39
    //   806: aload_1
    //   807: astore 10
    //   809: iload 19
    //   811: istore 21
    //   813: lload 31
    //   815: lstore 35
    //   817: iload 42
    //   819: istore 40
    //   821: aload_1
    //   822: astore 11
    //   824: iload 19
    //   826: istore 22
    //   828: aload 5
    //   830: astore 9
    //   832: iload 43
    //   834: istore 38
    //   836: aload_1
    //   837: astore 7
    //   839: iload 19
    //   841: istore 20
    //   843: ldc_w 460
    //   846: aload 17
    //   848: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   851: ifeq +52 -> 903
    //   854: lload 31
    //   856: lstore 33
    //   858: iload 41
    //   860: istore 39
    //   862: aload_1
    //   863: astore 10
    //   865: iload 19
    //   867: istore 21
    //   869: lload 31
    //   871: lstore 35
    //   873: iload 42
    //   875: istore 40
    //   877: aload_1
    //   878: astore 11
    //   880: iload 19
    //   882: istore 22
    //   884: aload 5
    //   886: astore 9
    //   888: iload 43
    //   890: istore 38
    //   892: aload_1
    //   893: astore 7
    //   895: iload 19
    //   897: istore 20
    //   899: iconst_1
    //   900: putstatic 456	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   903: aload 17
    //   905: ifnull +1768 -> 2673
    //   908: iload 30
    //   910: ifle +1763 -> 2673
    //   913: lload 31
    //   915: lstore 33
    //   917: iload 41
    //   919: istore 39
    //   921: aload_1
    //   922: astore 10
    //   924: iload 19
    //   926: istore 21
    //   928: lload 31
    //   930: lstore 35
    //   932: iload 42
    //   934: istore 40
    //   936: aload_1
    //   937: astore 11
    //   939: iload 19
    //   941: istore 22
    //   943: aload 5
    //   945: astore 9
    //   947: iload 43
    //   949: istore 38
    //   951: aload_1
    //   952: astore 7
    //   954: iload 19
    //   956: istore 20
    //   958: getstatic 456	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   961: istore 44
    //   963: iload 44
    //   965: ifne +1708 -> 2673
    //   968: iconst_1
    //   969: istore 38
    //   971: iconst_1
    //   972: istore 37
    //   974: aload 18
    //   976: getstatic 454	com/tencent/mobileqq/utils/httputils/PkgTools:d	Ljava/lang/String;
    //   979: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   982: ifne +25 -> 1007
    //   985: aload 18
    //   987: getstatic 462	com/tencent/mobileqq/utils/httputils/PkgTools:f	Ljava/lang/String;
    //   990: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   993: ifne +14 -> 1007
    //   996: aload 18
    //   998: getstatic 464	com/tencent/mobileqq/utils/httputils/PkgTools:h	Ljava/lang/String;
    //   1001: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1004: ifeq +1618 -> 2622
    //   1007: iload 25
    //   1009: iconst_m1
    //   1010: if_icmpne +1595 -> 2605
    //   1013: getstatic 46	com/tencent/mobileqq/app/FaceDownloader:j	I
    //   1016: iconst_1
    //   1017: if_icmpne +1588 -> 2605
    //   1020: new 319	java/net/URL
    //   1023: dup
    //   1024: aload 8
    //   1026: invokespecial 322	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1029: invokevirtual 468	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   1032: checkcast 204	java/net/HttpURLConnection
    //   1035: astore 6
    //   1037: iconst_0
    //   1038: istore 37
    //   1040: aload 6
    //   1042: astore_1
    //   1043: invokestatic 471	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1046: ifeq +4736 -> 5782
    //   1049: ldc 21
    //   1051: iconst_4
    //   1052: new 175	java/lang/StringBuilder
    //   1055: dup
    //   1056: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1059: ldc_w 473
    //   1062: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: getstatic 46	com/tencent/mobileqq/app/FaceDownloader:j	I
    //   1068: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1071: ldc_w 475
    //   1074: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: iload 25
    //   1079: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1082: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1085: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1088: lload 31
    //   1090: lstore 33
    //   1092: iload 37
    //   1094: istore 39
    //   1096: aload_1
    //   1097: astore 10
    //   1099: iload 19
    //   1101: istore 21
    //   1103: lload 31
    //   1105: lstore 35
    //   1107: iload 37
    //   1109: istore 40
    //   1111: aload_1
    //   1112: astore 11
    //   1114: iload 19
    //   1116: istore 22
    //   1118: aload 5
    //   1120: astore 9
    //   1122: iload 37
    //   1124: istore 38
    //   1126: aload_1
    //   1127: astore 7
    //   1129: iload 19
    //   1131: istore 20
    //   1133: aload_1
    //   1134: ldc_w 477
    //   1137: ldc_w 479
    //   1140: invokevirtual 483	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1143: lload 31
    //   1145: lstore 33
    //   1147: iload 37
    //   1149: istore 39
    //   1151: aload_1
    //   1152: astore 10
    //   1154: iload 19
    //   1156: istore 21
    //   1158: lload 31
    //   1160: lstore 35
    //   1162: iload 37
    //   1164: istore 40
    //   1166: aload_1
    //   1167: astore 11
    //   1169: iload 19
    //   1171: istore 22
    //   1173: aload 5
    //   1175: astore 9
    //   1177: iload 37
    //   1179: istore 38
    //   1181: aload_1
    //   1182: astore 7
    //   1184: iload 19
    //   1186: istore 20
    //   1188: aload_1
    //   1189: sipush 30000
    //   1192: invokevirtual 486	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   1195: lload 31
    //   1197: lstore 33
    //   1199: iload 37
    //   1201: istore 39
    //   1203: aload_1
    //   1204: astore 10
    //   1206: iload 19
    //   1208: istore 21
    //   1210: lload 31
    //   1212: lstore 35
    //   1214: iload 37
    //   1216: istore 40
    //   1218: aload_1
    //   1219: astore 11
    //   1221: iload 19
    //   1223: istore 22
    //   1225: aload 5
    //   1227: astore 9
    //   1229: iload 37
    //   1231: istore 38
    //   1233: aload_1
    //   1234: astore 7
    //   1236: iload 19
    //   1238: istore 20
    //   1240: aload_1
    //   1241: sipush 30000
    //   1244: invokevirtual 489	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   1247: lload 31
    //   1249: lstore 33
    //   1251: iload 37
    //   1253: istore 39
    //   1255: aload_1
    //   1256: astore 10
    //   1258: iload 19
    //   1260: istore 21
    //   1262: lload 31
    //   1264: lstore 35
    //   1266: iload 37
    //   1268: istore 40
    //   1270: aload_1
    //   1271: astore 11
    //   1273: iload 19
    //   1275: istore 22
    //   1277: aload 5
    //   1279: astore 9
    //   1281: iload 37
    //   1283: istore 38
    //   1285: aload_1
    //   1286: astore 7
    //   1288: iload 19
    //   1290: istore 20
    //   1292: aload_1
    //   1293: iconst_1
    //   1294: invokevirtual 493	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   1297: lload 31
    //   1299: lstore 33
    //   1301: iload 37
    //   1303: istore 39
    //   1305: aload_1
    //   1306: astore 10
    //   1308: iload 19
    //   1310: istore 21
    //   1312: aload 5
    //   1314: astore 9
    //   1316: iload 37
    //   1318: istore 38
    //   1320: aload_1
    //   1321: astore 7
    //   1323: iload 19
    //   1325: istore 20
    //   1327: aload_1
    //   1328: invokevirtual 496	java/net/HttpURLConnection:connect	()V
    //   1331: lload 31
    //   1333: lstore 33
    //   1335: iload 37
    //   1337: istore 39
    //   1339: aload_1
    //   1340: astore 10
    //   1342: iload 19
    //   1344: istore 21
    //   1346: aload 5
    //   1348: astore 9
    //   1350: iload 37
    //   1352: istore 38
    //   1354: aload_1
    //   1355: astore 7
    //   1357: iload 19
    //   1359: istore 20
    //   1361: aload 16
    //   1363: aload_1
    //   1364: invokevirtual 207	java/net/HttpURLConnection:getResponseCode	()I
    //   1367: putfield 497	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1370: lload 31
    //   1372: lstore 33
    //   1374: iload 37
    //   1376: istore 39
    //   1378: aload_1
    //   1379: astore 10
    //   1381: iload 19
    //   1383: istore 21
    //   1385: aload 5
    //   1387: astore 9
    //   1389: iload 37
    //   1391: istore 38
    //   1393: aload_1
    //   1394: astore 7
    //   1396: iload 19
    //   1398: istore 20
    //   1400: aload 16
    //   1402: aload_1
    //   1403: invokevirtual 218	java/net/HttpURLConnection:getContentLength	()I
    //   1406: putfield 498	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_Int	I
    //   1409: lload 31
    //   1411: lstore 33
    //   1413: iload 37
    //   1415: istore 39
    //   1417: aload_1
    //   1418: astore 10
    //   1420: iload 19
    //   1422: istore 21
    //   1424: aload 5
    //   1426: astore 9
    //   1428: iload 37
    //   1430: istore 38
    //   1432: aload_1
    //   1433: astore 7
    //   1435: iload 19
    //   1437: istore 20
    //   1439: aload 16
    //   1441: aload_1
    //   1442: invokevirtual 215	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1445: putfield 500	com/tencent/mobileqq/emoticon/DownloadInfo:i	Ljava/lang/String;
    //   1448: lload 31
    //   1450: lstore 33
    //   1452: iload 37
    //   1454: istore 39
    //   1456: aload_1
    //   1457: astore 10
    //   1459: iload 19
    //   1461: istore 21
    //   1463: aload 5
    //   1465: astore 9
    //   1467: iload 37
    //   1469: istore 38
    //   1471: aload_1
    //   1472: astore 7
    //   1474: iload 19
    //   1476: istore 20
    //   1478: aload 16
    //   1480: aload_1
    //   1481: invokevirtual 503	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   1484: putfield 505	com/tencent/mobileqq/emoticon/DownloadInfo:j	Ljava/lang/String;
    //   1487: lload 31
    //   1489: lstore 33
    //   1491: iload 37
    //   1493: istore 39
    //   1495: aload_1
    //   1496: astore 10
    //   1498: iload 19
    //   1500: istore 21
    //   1502: aload 5
    //   1504: astore 9
    //   1506: iload 37
    //   1508: istore 38
    //   1510: aload_1
    //   1511: astore 7
    //   1513: iload 19
    //   1515: istore 20
    //   1517: aload 16
    //   1519: aload_1
    //   1520: ldc -26
    //   1522: invokevirtual 224	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1525: putfield 507	com/tencent/mobileqq/emoticon/DownloadInfo:g	Ljava/lang/String;
    //   1528: lload 31
    //   1530: lstore 33
    //   1532: iload 37
    //   1534: istore 39
    //   1536: aload_1
    //   1537: astore 10
    //   1539: iload 19
    //   1541: istore 21
    //   1543: aload 5
    //   1545: astore 9
    //   1547: iload 37
    //   1549: istore 38
    //   1551: aload_1
    //   1552: astore 7
    //   1554: iload 19
    //   1556: istore 20
    //   1558: aload_1
    //   1559: ldc -30
    //   1561: invokevirtual 224	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   1564: astore 6
    //   1566: lload 31
    //   1568: lstore 33
    //   1570: iload 37
    //   1572: istore 39
    //   1574: aload_1
    //   1575: astore 10
    //   1577: iload 19
    //   1579: istore 21
    //   1581: lload 31
    //   1583: lstore 35
    //   1585: iload 37
    //   1587: istore 40
    //   1589: aload_1
    //   1590: astore 11
    //   1592: iload 19
    //   1594: istore 22
    //   1596: aload 5
    //   1598: astore 9
    //   1600: iload 37
    //   1602: istore 38
    //   1604: aload_1
    //   1605: astore 7
    //   1607: iload 19
    //   1609: istore 20
    //   1611: aload 6
    //   1613: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1616: ifne +1959 -> 3575
    //   1619: lload 31
    //   1621: lstore 33
    //   1623: iload 37
    //   1625: istore 39
    //   1627: aload_1
    //   1628: astore 10
    //   1630: iload 19
    //   1632: istore 21
    //   1634: lload 31
    //   1636: lstore 35
    //   1638: iload 37
    //   1640: istore 40
    //   1642: aload_1
    //   1643: astore 11
    //   1645: iload 19
    //   1647: istore 22
    //   1649: aload 5
    //   1651: astore 9
    //   1653: iload 37
    //   1655: istore 38
    //   1657: aload_1
    //   1658: astore 7
    //   1660: iload 19
    //   1662: istore 20
    //   1664: ldc 21
    //   1666: iconst_1
    //   1667: new 175	java/lang/StringBuilder
    //   1670: dup
    //   1671: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   1674: ldc_w 509
    //   1677: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: aload 6
    //   1682: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1688: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1691: iconst_0
    //   1692: istore 27
    //   1694: iconst_0
    //   1695: istore 23
    //   1697: iconst_0
    //   1698: istore 28
    //   1700: iconst_0
    //   1701: istore 24
    //   1703: iconst_0
    //   1704: istore 19
    //   1706: lload 31
    //   1708: lstore 33
    //   1710: iload 37
    //   1712: istore 39
    //   1714: aload_1
    //   1715: astore 10
    //   1717: iload 19
    //   1719: istore 21
    //   1721: lload 31
    //   1723: lstore 35
    //   1725: iload 37
    //   1727: istore 40
    //   1729: aload_1
    //   1730: astore 11
    //   1732: iload 27
    //   1734: istore 22
    //   1736: aload 5
    //   1738: astore 9
    //   1740: iload 37
    //   1742: istore 38
    //   1744: aload_1
    //   1745: astore 7
    //   1747: iload 28
    //   1749: istore 20
    //   1751: sipush 200
    //   1754: aload 16
    //   1756: getfield 497	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   1759: if_icmpne +3166 -> 4925
    //   1762: lload 31
    //   1764: lstore 33
    //   1766: iload 37
    //   1768: istore 39
    //   1770: aload_1
    //   1771: astore 10
    //   1773: iload 19
    //   1775: istore 21
    //   1777: lload 31
    //   1779: lstore 35
    //   1781: iload 37
    //   1783: istore 40
    //   1785: aload_1
    //   1786: astore 11
    //   1788: iload 27
    //   1790: istore 22
    //   1792: aload 5
    //   1794: astore 9
    //   1796: iload 37
    //   1798: istore 38
    //   1800: aload_1
    //   1801: astore 7
    //   1803: iload 28
    //   1805: istore 20
    //   1807: aload 16
    //   1809: getfield 498	com/tencent/mobileqq/emoticon/DownloadInfo:jdField_e_of_type_Int	I
    //   1812: istore 29
    //   1814: iload 29
    //   1816: i2l
    //   1817: lstore 31
    //   1819: iconst_0
    //   1820: istore 29
    //   1822: lload 31
    //   1824: lstore 33
    //   1826: iload 37
    //   1828: istore 39
    //   1830: aload_1
    //   1831: astore 10
    //   1833: iload 19
    //   1835: istore 21
    //   1837: lload 31
    //   1839: lstore 35
    //   1841: iload 37
    //   1843: istore 40
    //   1845: aload_1
    //   1846: astore 11
    //   1848: iload 27
    //   1850: istore 22
    //   1852: aload 5
    //   1854: astore 9
    //   1856: iload 37
    //   1858: istore 38
    //   1860: aload_1
    //   1861: astore 7
    //   1863: iload 28
    //   1865: istore 20
    //   1867: aload 14
    //   1869: invokevirtual 337	java/io/File:exists	()Z
    //   1872: ifeq +54 -> 1926
    //   1875: lload 31
    //   1877: lstore 33
    //   1879: iload 37
    //   1881: istore 39
    //   1883: aload_1
    //   1884: astore 10
    //   1886: iload 19
    //   1888: istore 21
    //   1890: lload 31
    //   1892: lstore 35
    //   1894: iload 37
    //   1896: istore 40
    //   1898: aload_1
    //   1899: astore 11
    //   1901: iload 27
    //   1903: istore 22
    //   1905: aload 5
    //   1907: astore 9
    //   1909: iload 37
    //   1911: istore 38
    //   1913: aload_1
    //   1914: astore 7
    //   1916: iload 28
    //   1918: istore 20
    //   1920: aload 14
    //   1922: invokevirtual 367	java/io/File:delete	()Z
    //   1925: pop
    //   1926: lload 31
    //   1928: lstore 33
    //   1930: iload 37
    //   1932: istore 39
    //   1934: aload_1
    //   1935: astore 10
    //   1937: iload 19
    //   1939: istore 21
    //   1941: lload 31
    //   1943: lstore 35
    //   1945: iload 37
    //   1947: istore 40
    //   1949: aload_1
    //   1950: astore 11
    //   1952: iload 27
    //   1954: istore 22
    //   1956: aload 5
    //   1958: astore 9
    //   1960: iload 37
    //   1962: istore 38
    //   1964: aload_1
    //   1965: astore 7
    //   1967: iload 28
    //   1969: istore 20
    //   1971: aload 14
    //   1973: invokevirtual 512	java/io/File:createNewFile	()Z
    //   1976: pop
    //   1977: lload 31
    //   1979: lstore 33
    //   1981: iload 37
    //   1983: istore 39
    //   1985: aload_1
    //   1986: astore 10
    //   1988: iload 19
    //   1990: istore 21
    //   1992: lload 31
    //   1994: lstore 35
    //   1996: iload 37
    //   1998: istore 40
    //   2000: aload_1
    //   2001: astore 11
    //   2003: iload 27
    //   2005: istore 22
    //   2007: aload 5
    //   2009: astore 9
    //   2011: iload 37
    //   2013: istore 38
    //   2015: aload_1
    //   2016: astore 7
    //   2018: iload 28
    //   2020: istore 20
    //   2022: new 514	java/io/BufferedOutputStream
    //   2025: dup
    //   2026: new 516	java/io/FileOutputStream
    //   2029: dup
    //   2030: aload 14
    //   2032: invokespecial 519	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   2035: invokespecial 522	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   2038: astore 6
    //   2040: aload_1
    //   2041: invokevirtual 526	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2044: astore 5
    //   2046: iload 4
    //   2048: ifeq +2746 -> 4794
    //   2051: lload 31
    //   2053: ldc2_w 527
    //   2056: lcmp
    //   2057: ifge +2737 -> 4794
    //   2060: ldc_w 529
    //   2063: newarray <illegal type>
    //   2065: astore 9
    //   2067: iconst_0
    //   2068: istore 19
    //   2070: iconst_0
    //   2071: istore 20
    //   2073: aload 5
    //   2075: aload 9
    //   2077: iload 20
    //   2079: sipush 1024
    //   2082: invokevirtual 535	java/io/InputStream:read	([BII)I
    //   2085: istore 21
    //   2087: iload 21
    //   2089: iconst_m1
    //   2090: if_icmpeq +2091 -> 4181
    //   2093: iload 20
    //   2095: iload 21
    //   2097: iadd
    //   2098: istore 20
    //   2100: iload 21
    //   2102: iload 19
    //   2104: iadd
    //   2105: istore 19
    //   2107: goto -34 -> 2073
    //   2110: aload 8
    //   2112: getfield 409	AvatarInfo/QQHeadInfo:originUsrType	I
    //   2115: bipush 32
    //   2117: if_icmpne -1760 -> 357
    //   2120: ldc_w 537
    //   2123: astore 6
    //   2125: goto -1768 -> 357
    //   2128: aload 8
    //   2130: getfield 406	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2133: bipush 16
    //   2135: if_icmpne +11 -> 2146
    //   2138: ldc_w 403
    //   2141: astore 6
    //   2143: goto -1786 -> 357
    //   2146: aload 8
    //   2148: getfield 406	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2151: iconst_4
    //   2152: if_icmpeq +13 -> 2165
    //   2155: aload 8
    //   2157: getfield 406	AvatarInfo/QQHeadInfo:dstUsrType	B
    //   2160: bipush 8
    //   2162: if_icmpne +11 -> 2173
    //   2165: ldc_w 537
    //   2168: astore 6
    //   2170: goto -1813 -> 357
    //   2173: ldc_w 403
    //   2176: astore 6
    //   2178: goto -1821 -> 357
    //   2181: lload 31
    //   2183: lstore 33
    //   2185: iload 41
    //   2187: istore 39
    //   2189: aload_1
    //   2190: astore 10
    //   2192: iload 19
    //   2194: istore 21
    //   2196: lload 31
    //   2198: lstore 35
    //   2200: iload 42
    //   2202: istore 40
    //   2204: aload_1
    //   2205: astore 11
    //   2207: iload 19
    //   2209: istore 22
    //   2211: aload 5
    //   2213: astore 9
    //   2215: iload 43
    //   2217: istore 38
    //   2219: aload_1
    //   2220: astore 7
    //   2222: iload 19
    //   2224: istore 20
    //   2226: iconst_1
    //   2227: putstatic 456	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2230: goto -1544 -> 686
    //   2233: astore 6
    //   2235: iload 39
    //   2237: istore 37
    //   2239: lload 33
    //   2241: lstore 31
    //   2243: iload 21
    //   2245: istore 19
    //   2247: aload 10
    //   2249: astore_1
    //   2250: ldc 21
    //   2252: iconst_1
    //   2253: new 175	java/lang/StringBuilder
    //   2256: dup
    //   2257: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   2260: ldc_w 539
    //   2263: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: aload 13
    //   2268: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2271: ldc_w 427
    //   2274: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: aload_3
    //   2278: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2281: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2284: aload 6
    //   2286: invokestatic 542	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2289: aload 6
    //   2291: instanceof 544
    //   2294: istore 38
    //   2296: iload 38
    //   2298: ifeq +2688 -> 4986
    //   2301: bipush 10
    //   2303: istore 19
    //   2305: aload_1
    //   2306: ifnull +7 -> 2313
    //   2309: aload_1
    //   2310: invokevirtual 547	java/net/HttpURLConnection:disconnect	()V
    //   2313: aload 5
    //   2315: ifnull +8 -> 2323
    //   2318: aload 5
    //   2320: invokevirtual 552	java/io/OutputStream:close	()V
    //   2323: iload 19
    //   2325: ifeq +92 -> 2417
    //   2328: aload 14
    //   2330: ifnull +71 -> 2401
    //   2333: aload 14
    //   2335: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   2338: astore 6
    //   2340: aload 6
    //   2342: ifnull +17 -> 2359
    //   2345: aload 6
    //   2347: invokevirtual 337	java/io/File:exists	()Z
    //   2350: ifne +9 -> 2359
    //   2353: aload 6
    //   2355: invokevirtual 340	java/io/File:mkdirs	()Z
    //   2358: pop
    //   2359: aload 14
    //   2361: invokevirtual 337	java/io/File:exists	()Z
    //   2364: ifeq +37 -> 2401
    //   2367: aload 14
    //   2369: invokevirtual 367	java/io/File:delete	()Z
    //   2372: istore 38
    //   2374: ldc 21
    //   2376: iconst_1
    //   2377: new 175	java/lang/StringBuilder
    //   2380: dup
    //   2381: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   2384: ldc_w 554
    //   2387: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2390: iload 38
    //   2392: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2395: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2398: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2401: aload_2
    //   2402: ifnull +15 -> 2417
    //   2405: aload_2
    //   2406: invokevirtual 337	java/io/File:exists	()Z
    //   2409: ifeq +8 -> 2417
    //   2412: aload_2
    //   2413: invokevirtual 367	java/io/File:delete	()Z
    //   2416: pop
    //   2417: iload 25
    //   2419: iconst_1
    //   2420: iadd
    //   2421: istore 20
    //   2423: iload 19
    //   2425: ifeq +141 -> 2566
    //   2428: ldc 21
    //   2430: iconst_1
    //   2431: new 175	java/lang/StringBuilder
    //   2434: dup
    //   2435: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   2438: ldc_w 559
    //   2441: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2444: iload 19
    //   2446: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2449: ldc_w 561
    //   2452: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2455: aload 13
    //   2457: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2460: ldc_w 475
    //   2463: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2466: iload 20
    //   2468: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2471: ldc_w 427
    //   2474: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2477: aload_3
    //   2478: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2481: ldc_w 563
    //   2484: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: iload 37
    //   2489: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2492: ldc_w 565
    //   2495: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2498: aload 17
    //   2500: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2503: ldc_w 567
    //   2506: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2509: iload 30
    //   2511: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2514: ldc_w 569
    //   2517: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2520: getstatic 456	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2523: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2526: ldc_w 571
    //   2529: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2532: iload 26
    //   2534: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2537: ldc_w 573
    //   2540: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2543: aload 18
    //   2545: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2548: ldc_w 575
    //   2551: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2554: getstatic 46	com/tencent/mobileqq/app/FaceDownloader:j	I
    //   2557: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2560: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2563: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2566: iload 19
    //   2568: ifeq +3269 -> 5837
    //   2571: iload 20
    //   2573: iconst_2
    //   2574: if_icmpge +3263 -> 5837
    //   2577: aload 12
    //   2579: monitorenter
    //   2580: aload 12
    //   2582: ldc2_w 576
    //   2585: invokevirtual 581	java/lang/Object:wait	(J)V
    //   2588: aload 12
    //   2590: monitorexit
    //   2591: iload 19
    //   2593: ifeq +9 -> 2602
    //   2596: iload 20
    //   2598: iconst_2
    //   2599: if_icmplt +3209 -> 5808
    //   2602: goto -2376 -> 226
    //   2605: aload 8
    //   2607: aload 17
    //   2609: iload 30
    //   2611: invokestatic 584	com/tencent/mobileqq/utils/httputils/PkgTools:b	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   2614: astore 6
    //   2616: aload 6
    //   2618: astore_1
    //   2619: goto -1576 -> 1043
    //   2622: aload 18
    //   2624: getstatic 586	com/tencent/mobileqq/utils/httputils/PkgTools:b	Ljava/lang/String;
    //   2627: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2630: ifeq +23 -> 2653
    //   2633: aload 8
    //   2635: aload 17
    //   2637: iload 30
    //   2639: invokestatic 588	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   2642: astore 6
    //   2644: iconst_1
    //   2645: istore 37
    //   2647: aload 6
    //   2649: astore_1
    //   2650: goto -1562 -> 1088
    //   2653: aload 8
    //   2655: aload 17
    //   2657: iload 30
    //   2659: invokestatic 588	com/tencent/mobileqq/utils/httputils/PkgTools:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/net/HttpURLConnection;
    //   2662: astore 6
    //   2664: aload 6
    //   2666: astore_1
    //   2667: iconst_1
    //   2668: istore 37
    //   2670: goto -1582 -> 1088
    //   2673: lload 31
    //   2675: lstore 33
    //   2677: iload 41
    //   2679: istore 39
    //   2681: aload_1
    //   2682: astore 10
    //   2684: iload 19
    //   2686: istore 21
    //   2688: lload 31
    //   2690: lstore 35
    //   2692: iload 42
    //   2694: istore 40
    //   2696: aload_1
    //   2697: astore 11
    //   2699: iload 19
    //   2701: istore 22
    //   2703: aload 5
    //   2705: astore 9
    //   2707: iload 43
    //   2709: istore 38
    //   2711: aload_1
    //   2712: astore 7
    //   2714: iload 19
    //   2716: istore 20
    //   2718: new 319	java/net/URL
    //   2721: dup
    //   2722: aload 8
    //   2724: invokespecial 322	java/net/URL:<init>	(Ljava/lang/String;)V
    //   2727: invokevirtual 468	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   2730: checkcast 204	java/net/HttpURLConnection
    //   2733: astore_1
    //   2734: goto -1646 -> 1088
    //   2737: astore 6
    //   2739: iload 37
    //   2741: ifeq +470 -> 3211
    //   2744: lload 31
    //   2746: lstore 33
    //   2748: iload 37
    //   2750: istore 39
    //   2752: aload_1
    //   2753: astore 10
    //   2755: iload 19
    //   2757: istore 21
    //   2759: lload 31
    //   2761: lstore 35
    //   2763: iload 37
    //   2765: istore 40
    //   2767: aload_1
    //   2768: astore 11
    //   2770: iload 19
    //   2772: istore 22
    //   2774: aload 5
    //   2776: astore 9
    //   2778: iload 37
    //   2780: istore 38
    //   2782: aload_1
    //   2783: astore 7
    //   2785: iload 19
    //   2787: istore 20
    //   2789: iconst_1
    //   2790: putstatic 456	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   2793: lload 31
    //   2795: lstore 33
    //   2797: iload 37
    //   2799: istore 39
    //   2801: aload_1
    //   2802: astore 10
    //   2804: iload 19
    //   2806: istore 21
    //   2808: lload 31
    //   2810: lstore 35
    //   2812: iload 37
    //   2814: istore 40
    //   2816: aload_1
    //   2817: astore 11
    //   2819: iload 19
    //   2821: istore 22
    //   2823: aload 5
    //   2825: astore 9
    //   2827: iload 37
    //   2829: istore 38
    //   2831: aload_1
    //   2832: astore 7
    //   2834: iload 19
    //   2836: istore 20
    //   2838: aload 6
    //   2840: athrow
    //   2841: astore 6
    //   2843: iload 22
    //   2845: istore 19
    //   2847: aload 11
    //   2849: astore_1
    //   2850: iload 40
    //   2852: istore 37
    //   2854: lload 35
    //   2856: lstore 31
    //   2858: aload 5
    //   2860: astore 9
    //   2862: iload 37
    //   2864: istore 38
    //   2866: aload_1
    //   2867: astore 7
    //   2869: iload 19
    //   2871: istore 20
    //   2873: ldc 21
    //   2875: iconst_1
    //   2876: new 175	java/lang/StringBuilder
    //   2879: dup
    //   2880: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   2883: ldc_w 590
    //   2886: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2889: aload 13
    //   2891: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2894: ldc_w 427
    //   2897: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2900: aload_3
    //   2901: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2904: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2907: aload 6
    //   2909: invokestatic 542	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2912: iconst_5
    //   2913: istore 19
    //   2915: aload_1
    //   2916: ifnull +7 -> 2923
    //   2919: aload_1
    //   2920: invokevirtual 547	java/net/HttpURLConnection:disconnect	()V
    //   2923: aload 5
    //   2925: ifnull +8 -> 2933
    //   2928: aload 5
    //   2930: invokevirtual 552	java/io/OutputStream:close	()V
    //   2933: aload 14
    //   2935: ifnull +71 -> 3006
    //   2938: aload 14
    //   2940: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   2943: astore 6
    //   2945: aload 6
    //   2947: ifnull +17 -> 2964
    //   2950: aload 6
    //   2952: invokevirtual 337	java/io/File:exists	()Z
    //   2955: ifne +9 -> 2964
    //   2958: aload 6
    //   2960: invokevirtual 340	java/io/File:mkdirs	()Z
    //   2963: pop
    //   2964: aload 14
    //   2966: invokevirtual 337	java/io/File:exists	()Z
    //   2969: ifeq +37 -> 3006
    //   2972: aload 14
    //   2974: invokevirtual 367	java/io/File:delete	()Z
    //   2977: istore 38
    //   2979: ldc 21
    //   2981: iconst_1
    //   2982: new 175	java/lang/StringBuilder
    //   2985: dup
    //   2986: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   2989: ldc_w 554
    //   2992: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2995: iload 38
    //   2997: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3000: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3003: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3006: aload_2
    //   3007: ifnull +15 -> 3022
    //   3010: aload_2
    //   3011: invokevirtual 337	java/io/File:exists	()Z
    //   3014: ifeq +8 -> 3022
    //   3017: aload_2
    //   3018: invokevirtual 367	java/io/File:delete	()Z
    //   3021: pop
    //   3022: iload 25
    //   3024: iconst_1
    //   3025: iadd
    //   3026: istore 22
    //   3028: ldc 21
    //   3030: iconst_1
    //   3031: new 175	java/lang/StringBuilder
    //   3034: dup
    //   3035: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   3038: ldc_w 559
    //   3041: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3044: iconst_5
    //   3045: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3048: ldc_w 561
    //   3051: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3054: aload 13
    //   3056: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3059: ldc_w 475
    //   3062: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3065: iload 22
    //   3067: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3070: ldc_w 427
    //   3073: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3076: aload_3
    //   3077: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3080: ldc_w 563
    //   3083: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3086: iload 37
    //   3088: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3091: ldc_w 565
    //   3094: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3097: aload 17
    //   3099: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3102: ldc_w 567
    //   3105: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3108: iload 30
    //   3110: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3113: ldc_w 569
    //   3116: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3119: getstatic 456	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   3122: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3125: ldc_w 571
    //   3128: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3131: iload 26
    //   3133: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3136: ldc_w 573
    //   3139: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3142: aload 18
    //   3144: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3147: ldc_w 575
    //   3150: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3153: getstatic 46	com/tencent/mobileqq/app/FaceDownloader:j	I
    //   3156: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3159: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3162: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3165: iload 19
    //   3167: istore 21
    //   3169: iload 22
    //   3171: istore 20
    //   3173: lload 31
    //   3175: lstore 33
    //   3177: aload 5
    //   3179: astore 7
    //   3181: aload_1
    //   3182: astore 6
    //   3184: iload 22
    //   3186: iconst_2
    //   3187: if_icmpge +2632 -> 5819
    //   3190: aload 12
    //   3192: monitorenter
    //   3193: aload 12
    //   3195: ldc2_w 576
    //   3198: invokevirtual 581	java/lang/Object:wait	(J)V
    //   3201: aload 12
    //   3203: monitorexit
    //   3204: iload 22
    //   3206: istore 20
    //   3208: goto -617 -> 2591
    //   3211: aload 17
    //   3213: ifnull -420 -> 2793
    //   3216: iload 30
    //   3218: ifle -425 -> 2793
    //   3221: lload 31
    //   3223: lstore 33
    //   3225: iload 37
    //   3227: istore 39
    //   3229: aload_1
    //   3230: astore 10
    //   3232: iload 19
    //   3234: istore 21
    //   3236: lload 31
    //   3238: lstore 35
    //   3240: iload 37
    //   3242: istore 40
    //   3244: aload_1
    //   3245: astore 11
    //   3247: iload 19
    //   3249: istore 22
    //   3251: aload 5
    //   3253: astore 9
    //   3255: iload 37
    //   3257: istore 38
    //   3259: aload_1
    //   3260: astore 7
    //   3262: iload 19
    //   3264: istore 20
    //   3266: iconst_0
    //   3267: putstatic 456	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   3270: goto -477 -> 2793
    //   3273: astore 6
    //   3275: iload 20
    //   3277: istore 19
    //   3279: aload 7
    //   3281: astore_1
    //   3282: iload 38
    //   3284: istore 37
    //   3286: aload 9
    //   3288: astore 5
    //   3290: aload_1
    //   3291: ifnull +7 -> 3298
    //   3294: aload_1
    //   3295: invokevirtual 547	java/net/HttpURLConnection:disconnect	()V
    //   3298: aload 5
    //   3300: ifnull +8 -> 3308
    //   3303: aload 5
    //   3305: invokevirtual 552	java/io/OutputStream:close	()V
    //   3308: iload 19
    //   3310: ifeq +88 -> 3398
    //   3313: aload 14
    //   3315: ifnull +67 -> 3382
    //   3318: aload 14
    //   3320: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   3323: astore_1
    //   3324: aload_1
    //   3325: ifnull +15 -> 3340
    //   3328: aload_1
    //   3329: invokevirtual 337	java/io/File:exists	()Z
    //   3332: ifne +8 -> 3340
    //   3335: aload_1
    //   3336: invokevirtual 340	java/io/File:mkdirs	()Z
    //   3339: pop
    //   3340: aload 14
    //   3342: invokevirtual 337	java/io/File:exists	()Z
    //   3345: ifeq +37 -> 3382
    //   3348: aload 14
    //   3350: invokevirtual 367	java/io/File:delete	()Z
    //   3353: istore 4
    //   3355: ldc 21
    //   3357: iconst_1
    //   3358: new 175	java/lang/StringBuilder
    //   3361: dup
    //   3362: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   3365: ldc_w 554
    //   3368: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3371: iload 4
    //   3373: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3376: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3379: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3382: aload_2
    //   3383: ifnull +15 -> 3398
    //   3386: aload_2
    //   3387: invokevirtual 337	java/io/File:exists	()Z
    //   3390: ifeq +8 -> 3398
    //   3393: aload_2
    //   3394: invokevirtual 367	java/io/File:delete	()Z
    //   3397: pop
    //   3398: iload 25
    //   3400: iconst_1
    //   3401: iadd
    //   3402: istore 20
    //   3404: iload 19
    //   3406: ifeq +141 -> 3547
    //   3409: ldc 21
    //   3411: iconst_1
    //   3412: new 175	java/lang/StringBuilder
    //   3415: dup
    //   3416: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   3419: ldc_w 559
    //   3422: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3425: iload 19
    //   3427: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3430: ldc_w 561
    //   3433: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3436: aload 13
    //   3438: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3441: ldc_w 475
    //   3444: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3447: iload 20
    //   3449: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3452: ldc_w 427
    //   3455: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3458: aload_3
    //   3459: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3462: ldc_w 563
    //   3465: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3468: iload 37
    //   3470: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3473: ldc_w 565
    //   3476: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3479: aload 17
    //   3481: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3484: ldc_w 567
    //   3487: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3490: iload 30
    //   3492: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3495: ldc_w 569
    //   3498: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3501: getstatic 456	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   3504: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3507: ldc_w 571
    //   3510: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3513: iload 26
    //   3515: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3518: ldc_w 573
    //   3521: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3524: aload 18
    //   3526: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3529: ldc_w 575
    //   3532: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3535: getstatic 46	com/tencent/mobileqq/app/FaceDownloader:j	I
    //   3538: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3541: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3544: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3547: iload 19
    //   3549: ifeq +23 -> 3572
    //   3552: iload 20
    //   3554: iconst_2
    //   3555: if_icmpge +17 -> 3572
    //   3558: aload 12
    //   3560: monitorenter
    //   3561: aload 12
    //   3563: ldc2_w 576
    //   3566: invokevirtual 581	java/lang/Object:wait	(J)V
    //   3569: aload 12
    //   3571: monitorexit
    //   3572: aload 6
    //   3574: athrow
    //   3575: iconst_0
    //   3576: istore 23
    //   3578: lload 31
    //   3580: lstore 33
    //   3582: iload 37
    //   3584: istore 39
    //   3586: aload_1
    //   3587: astore 10
    //   3589: iload 19
    //   3591: istore 21
    //   3593: lload 31
    //   3595: lstore 35
    //   3597: iload 37
    //   3599: istore 40
    //   3601: aload_1
    //   3602: astore 11
    //   3604: iload 19
    //   3606: istore 22
    //   3608: aload 5
    //   3610: astore 9
    //   3612: iload 37
    //   3614: istore 38
    //   3616: aload_1
    //   3617: astore 7
    //   3619: iload 19
    //   3621: istore 20
    //   3623: aload 16
    //   3625: getfield 507	com/tencent/mobileqq/emoticon/DownloadInfo:g	Ljava/lang/String;
    //   3628: ifnonnull +2144 -> 5772
    //   3631: lload 31
    //   3633: lstore 33
    //   3635: iload 37
    //   3637: istore 39
    //   3639: aload_1
    //   3640: astore 10
    //   3642: iload 19
    //   3644: istore 21
    //   3646: lload 31
    //   3648: lstore 35
    //   3650: iload 37
    //   3652: istore 40
    //   3654: aload_1
    //   3655: astore 11
    //   3657: iload 19
    //   3659: istore 22
    //   3661: aload 5
    //   3663: astore 9
    //   3665: iload 37
    //   3667: istore 38
    //   3669: aload_1
    //   3670: astore 7
    //   3672: iload 19
    //   3674: istore 20
    //   3676: aload 16
    //   3678: getfield 497	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   3681: istore 23
    //   3683: iload 23
    //   3685: sipush 200
    //   3688: if_icmpne +432 -> 4120
    //   3691: bipush 30
    //   3693: istore 19
    //   3695: iconst_1
    //   3696: istore 21
    //   3698: iload 19
    //   3700: istore 20
    //   3702: iload 21
    //   3704: istore 27
    //   3706: iload 20
    //   3708: istore 19
    //   3710: iload 20
    //   3712: istore 22
    //   3714: iload 20
    //   3716: istore 23
    //   3718: iload 20
    //   3720: istore 24
    //   3722: aload_3
    //   3723: getfield 200	com/tencent/mobileqq/util/FaceInfo:a	LAvatarInfo/QQHeadInfo;
    //   3726: getfield 235	AvatarInfo/QQHeadInfo:headVerify	Ljava/lang/String;
    //   3729: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3732: ifne +76 -> 3808
    //   3735: iload 21
    //   3737: istore 27
    //   3739: iload 20
    //   3741: istore 19
    //   3743: iload 20
    //   3745: istore 22
    //   3747: iload 20
    //   3749: istore 23
    //   3751: iload 20
    //   3753: istore 24
    //   3755: aload 16
    //   3757: getfield 507	com/tencent/mobileqq/emoticon/DownloadInfo:g	Ljava/lang/String;
    //   3760: ifnull +48 -> 3808
    //   3763: iload 21
    //   3765: istore 27
    //   3767: iload 20
    //   3769: istore 19
    //   3771: iload 20
    //   3773: istore 22
    //   3775: iload 20
    //   3777: istore 23
    //   3779: iload 20
    //   3781: istore 24
    //   3783: aload 16
    //   3785: getfield 507	com/tencent/mobileqq/emoticon/DownloadInfo:g	Ljava/lang/String;
    //   3788: aload_3
    //   3789: getfield 200	com/tencent/mobileqq/util/FaceInfo:a	LAvatarInfo/QQHeadInfo;
    //   3792: getfield 235	AvatarInfo/QQHeadInfo:headVerify	Ljava/lang/String;
    //   3795: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3798: ifne +10 -> 3808
    //   3801: bipush 31
    //   3803: istore 19
    //   3805: iconst_1
    //   3806: istore 27
    //   3808: iload 27
    //   3810: ifeq -2119 -> 1691
    //   3813: iload 19
    //   3815: istore 22
    //   3817: iload 19
    //   3819: istore 23
    //   3821: iload 19
    //   3823: istore 24
    //   3825: aload_0
    //   3826: aload_1
    //   3827: aload_3
    //   3828: invokespecial 592	com/tencent/mobileqq/app/FaceDownloader:a	(Ljava/net/HttpURLConnection;Lcom/tencent/mobileqq/util/FaceInfo;)V
    //   3831: aload_1
    //   3832: ifnull +7 -> 3839
    //   3835: aload_1
    //   3836: invokevirtual 547	java/net/HttpURLConnection:disconnect	()V
    //   3839: aload 5
    //   3841: ifnull +8 -> 3849
    //   3844: aload 5
    //   3846: invokevirtual 552	java/io/OutputStream:close	()V
    //   3849: iload 19
    //   3851: ifeq +92 -> 3943
    //   3854: aload 14
    //   3856: ifnull +71 -> 3927
    //   3859: aload 14
    //   3861: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   3864: astore 6
    //   3866: aload 6
    //   3868: ifnull +17 -> 3885
    //   3871: aload 6
    //   3873: invokevirtual 337	java/io/File:exists	()Z
    //   3876: ifne +9 -> 3885
    //   3879: aload 6
    //   3881: invokevirtual 340	java/io/File:mkdirs	()Z
    //   3884: pop
    //   3885: aload 14
    //   3887: invokevirtual 337	java/io/File:exists	()Z
    //   3890: ifeq +37 -> 3927
    //   3893: aload 14
    //   3895: invokevirtual 367	java/io/File:delete	()Z
    //   3898: istore 38
    //   3900: ldc 21
    //   3902: iconst_1
    //   3903: new 175	java/lang/StringBuilder
    //   3906: dup
    //   3907: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   3910: ldc_w 554
    //   3913: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3916: iload 38
    //   3918: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3921: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3924: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3927: aload_2
    //   3928: ifnull +15 -> 3943
    //   3931: aload_2
    //   3932: invokevirtual 337	java/io/File:exists	()Z
    //   3935: ifeq +8 -> 3943
    //   3938: aload_2
    //   3939: invokevirtual 367	java/io/File:delete	()Z
    //   3942: pop
    //   3943: iload 25
    //   3945: iconst_1
    //   3946: iadd
    //   3947: istore 20
    //   3949: iload 19
    //   3951: ifeq +141 -> 4092
    //   3954: ldc 21
    //   3956: iconst_1
    //   3957: new 175	java/lang/StringBuilder
    //   3960: dup
    //   3961: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   3964: ldc_w 559
    //   3967: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3970: iload 19
    //   3972: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3975: ldc_w 561
    //   3978: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3981: aload 13
    //   3983: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3986: ldc_w 475
    //   3989: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3992: iload 20
    //   3994: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3997: ldc_w 427
    //   4000: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4003: aload_3
    //   4004: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4007: ldc_w 563
    //   4010: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4013: iload 37
    //   4015: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4018: ldc_w 565
    //   4021: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4024: aload 17
    //   4026: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4029: ldc_w 567
    //   4032: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4035: iload 30
    //   4037: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4040: ldc_w 569
    //   4043: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4046: getstatic 456	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   4049: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4052: ldc_w 571
    //   4055: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4058: iload 26
    //   4060: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4063: ldc_w 573
    //   4066: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4069: aload 18
    //   4071: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4074: ldc_w 575
    //   4077: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4080: getstatic 46	com/tencent/mobileqq/app/FaceDownloader:j	I
    //   4083: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4086: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4089: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4092: iload 19
    //   4094: ifeq +1675 -> 5769
    //   4097: iload 20
    //   4099: iconst_2
    //   4100: if_icmpge +1669 -> 5769
    //   4103: aload 12
    //   4105: monitorenter
    //   4106: aload 12
    //   4108: ldc2_w 576
    //   4111: invokevirtual 581	java/lang/Object:wait	(J)V
    //   4114: aload 12
    //   4116: monitorexit
    //   4117: goto -1526 -> 2591
    //   4120: lload 31
    //   4122: lstore 33
    //   4124: iload 37
    //   4126: istore 39
    //   4128: aload_1
    //   4129: astore 10
    //   4131: iload 19
    //   4133: istore 21
    //   4135: lload 31
    //   4137: lstore 35
    //   4139: iload 37
    //   4141: istore 40
    //   4143: aload_1
    //   4144: astore 11
    //   4146: iload 19
    //   4148: istore 22
    //   4150: aload 5
    //   4152: astore 9
    //   4154: iload 37
    //   4156: istore 38
    //   4158: aload_1
    //   4159: astore 7
    //   4161: iload 19
    //   4163: istore 20
    //   4165: aload 16
    //   4167: getfield 497	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   4170: istore 19
    //   4172: goto -477 -> 3695
    //   4175: astore_1
    //   4176: aload 12
    //   4178: monitorexit
    //   4179: aload_1
    //   4180: athrow
    //   4181: aload_3
    //   4182: getstatic 376	com/tencent/mobileqq/util/FaceInfo:n	I
    //   4185: invokevirtual 378	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4188: iload 19
    //   4190: i2l
    //   4191: lload 31
    //   4193: lcmp
    //   4194: ifne +199 -> 4393
    //   4197: aload_3
    //   4198: getstatic 595	com/tencent/mobileqq/util/FaceInfo:o	I
    //   4201: invokevirtual 378	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4204: aload 9
    //   4206: iconst_0
    //   4207: iload 19
    //   4209: invokestatic 600	com/tencent/mobileqq/util/BitmapManager:a	([BII)Landroid/graphics/Bitmap;
    //   4212: astore 7
    //   4214: aload 7
    //   4216: astore 5
    //   4218: aload 7
    //   4220: ifnull +72 -> 4292
    //   4223: aload_3
    //   4224: getfield 601	com/tencent/mobileqq/util/FaceInfo:c	I
    //   4227: tableswitch	default:+1613->5840, 1:+546->4773, 2:+25->4252, 3:+553->4780
    //   4252: aload 7
    //   4254: bipush 50
    //   4256: bipush 50
    //   4258: invokestatic 606	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   4261: astore 5
    //   4263: aload_0
    //   4264: getfield 100	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   4267: sipush 215
    //   4270: invokevirtual 612	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4273: checkcast 614	com/tencent/mobileqq/util/FaceManager
    //   4276: aload_3
    //   4277: invokevirtual 616	com/tencent/mobileqq/util/FaceInfo:a	()Ljava/lang/String;
    //   4280: aload 5
    //   4282: invokevirtual 619	com/tencent/mobileqq/util/FaceManager:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   4285: aload_3
    //   4286: getstatic 622	com/tencent/mobileqq/util/FaceInfo:p	I
    //   4289: invokevirtual 378	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4292: invokestatic 249	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4295: ifeq +51 -> 4346
    //   4298: ldc 21
    //   4300: iconst_2
    //   4301: new 175	java/lang/StringBuilder
    //   4304: dup
    //   4305: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   4308: ldc_w 624
    //   4311: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4314: aload 5
    //   4316: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4319: ldc_w 561
    //   4322: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4325: aload 13
    //   4327: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4330: ldc_w 427
    //   4333: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4336: aload_3
    //   4337: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4340: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4343: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4346: new 369	pxl
    //   4349: dup
    //   4350: aload_0
    //   4351: invokespecial 370	pxl:<init>	(Lcom/tencent/mobileqq/app/FaceDownloader;)V
    //   4354: astore 7
    //   4356: aload 7
    //   4358: aload_3
    //   4359: putfield 373	pxl:jdField_a_of_type_ComTencentMobileqqUtilFaceInfo	Lcom/tencent/mobileqq/util/FaceInfo;
    //   4362: aload 7
    //   4364: aload 5
    //   4366: putfield 381	pxl:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   4369: aload_0
    //   4370: getfield 69	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   4373: aload 7
    //   4375: invokevirtual 384	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   4378: pop
    //   4379: aload_0
    //   4380: getfield 149	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   4383: bipush 100
    //   4385: aload 7
    //   4387: invokevirtual 390	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   4390: invokevirtual 395	android/os/Message:sendToTarget	()V
    //   4393: aload 6
    //   4395: aload 9
    //   4397: iconst_0
    //   4398: iload 19
    //   4400: invokevirtual 628	java/io/OutputStream:write	([BII)V
    //   4403: aload 6
    //   4405: invokevirtual 631	java/io/OutputStream:flush	()V
    //   4408: aload_2
    //   4409: invokevirtual 337	java/io/File:exists	()Z
    //   4412: ifeq +8 -> 4420
    //   4415: aload_2
    //   4416: invokevirtual 367	java/io/File:delete	()Z
    //   4419: pop
    //   4420: aload 14
    //   4422: aload_2
    //   4423: invokevirtual 635	java/io/File:renameTo	(Ljava/io/File;)Z
    //   4426: pop
    //   4427: aload_2
    //   4428: invokestatic 328	java/lang/System:currentTimeMillis	()J
    //   4431: invokevirtual 639	java/io/File:setLastModified	(J)Z
    //   4434: pop
    //   4435: iconst_0
    //   4436: istore 19
    //   4438: aload 6
    //   4440: astore 5
    //   4442: aload_1
    //   4443: ifnull +7 -> 4450
    //   4446: aload_1
    //   4447: invokevirtual 547	java/net/HttpURLConnection:disconnect	()V
    //   4450: aload 5
    //   4452: ifnull +8 -> 4460
    //   4455: aload 5
    //   4457: invokevirtual 552	java/io/OutputStream:close	()V
    //   4460: iload 19
    //   4462: ifeq +92 -> 4554
    //   4465: aload 14
    //   4467: ifnull +71 -> 4538
    //   4470: aload 14
    //   4472: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   4475: astore 6
    //   4477: aload 6
    //   4479: ifnull +17 -> 4496
    //   4482: aload 6
    //   4484: invokevirtual 337	java/io/File:exists	()Z
    //   4487: ifne +9 -> 4496
    //   4490: aload 6
    //   4492: invokevirtual 340	java/io/File:mkdirs	()Z
    //   4495: pop
    //   4496: aload 14
    //   4498: invokevirtual 337	java/io/File:exists	()Z
    //   4501: ifeq +37 -> 4538
    //   4504: aload 14
    //   4506: invokevirtual 367	java/io/File:delete	()Z
    //   4509: istore 38
    //   4511: ldc 21
    //   4513: iconst_1
    //   4514: new 175	java/lang/StringBuilder
    //   4517: dup
    //   4518: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   4521: ldc_w 554
    //   4524: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4527: iload 38
    //   4529: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4532: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4535: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4538: aload_2
    //   4539: ifnull +15 -> 4554
    //   4542: aload_2
    //   4543: invokevirtual 337	java/io/File:exists	()Z
    //   4546: ifeq +8 -> 4554
    //   4549: aload_2
    //   4550: invokevirtual 367	java/io/File:delete	()Z
    //   4553: pop
    //   4554: iload 25
    //   4556: iconst_1
    //   4557: iadd
    //   4558: istore 22
    //   4560: iload 19
    //   4562: ifeq +141 -> 4703
    //   4565: ldc 21
    //   4567: iconst_1
    //   4568: new 175	java/lang/StringBuilder
    //   4571: dup
    //   4572: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   4575: ldc_w 559
    //   4578: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4581: iload 19
    //   4583: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4586: ldc_w 561
    //   4589: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4592: aload 13
    //   4594: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4597: ldc_w 475
    //   4600: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4603: iload 22
    //   4605: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4608: ldc_w 427
    //   4611: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4614: aload_3
    //   4615: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4618: ldc_w 563
    //   4621: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4624: iload 37
    //   4626: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4629: ldc_w 565
    //   4632: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4635: aload 17
    //   4637: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4640: ldc_w 567
    //   4643: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4646: iload 30
    //   4648: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4651: ldc_w 569
    //   4654: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4657: getstatic 456	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_Boolean	Z
    //   4660: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4663: ldc_w 571
    //   4666: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4669: iload 26
    //   4671: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4674: ldc_w 573
    //   4677: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4680: aload 18
    //   4682: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4685: ldc_w 575
    //   4688: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4691: getstatic 46	com/tencent/mobileqq/app/FaceDownloader:j	I
    //   4694: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4697: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4700: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4703: iload 19
    //   4705: istore 21
    //   4707: iload 22
    //   4709: istore 20
    //   4711: lload 31
    //   4713: lstore 33
    //   4715: aload 5
    //   4717: astore 7
    //   4719: aload_1
    //   4720: astore 6
    //   4722: iload 19
    //   4724: ifeq +1095 -> 5819
    //   4727: iload 19
    //   4729: istore 21
    //   4731: iload 22
    //   4733: istore 20
    //   4735: lload 31
    //   4737: lstore 33
    //   4739: aload 5
    //   4741: astore 7
    //   4743: aload_1
    //   4744: astore 6
    //   4746: iload 22
    //   4748: iconst_2
    //   4749: if_icmpge +1070 -> 5819
    //   4752: aload 12
    //   4754: monitorenter
    //   4755: aload 12
    //   4757: ldc2_w 576
    //   4760: invokevirtual 581	java/lang/Object:wait	(J)V
    //   4763: aload 12
    //   4765: monitorexit
    //   4766: iload 22
    //   4768: istore 20
    //   4770: goto -2179 -> 2591
    //   4773: aload 7
    //   4775: astore 5
    //   4777: goto -514 -> 4263
    //   4780: aload 7
    //   4782: bipush 50
    //   4784: bipush 50
    //   4786: invokestatic 641	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   4789: astore 5
    //   4791: goto -528 -> 4263
    //   4794: sipush 1024
    //   4797: newarray <illegal type>
    //   4799: astore 7
    //   4801: iload 29
    //   4803: istore 19
    //   4805: aload 5
    //   4807: aload 7
    //   4809: invokevirtual 644	java/io/InputStream:read	([B)I
    //   4812: istore 20
    //   4814: iload 20
    //   4816: iconst_m1
    //   4817: if_icmpeq +82 -> 4899
    //   4820: iload 19
    //   4822: iload 20
    //   4824: iadd
    //   4825: istore 19
    //   4827: aload 6
    //   4829: aload 7
    //   4831: iconst_0
    //   4832: iload 20
    //   4834: invokevirtual 628	java/io/OutputStream:write	([BII)V
    //   4837: goto -32 -> 4805
    //   4840: astore 5
    //   4842: aload 6
    //   4844: astore 5
    //   4846: ldc 21
    //   4848: iconst_1
    //   4849: new 175	java/lang/StringBuilder
    //   4852: dup
    //   4853: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   4856: ldc_w 646
    //   4859: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4862: aload 14
    //   4864: invokevirtual 337	java/io/File:exists	()Z
    //   4867: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4870: ldc_w 648
    //   4873: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4876: aload 14
    //   4878: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   4881: invokevirtual 337	java/io/File:exists	()Z
    //   4884: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4887: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4890: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4893: iconst_4
    //   4894: istore 19
    //   4896: goto -454 -> 4442
    //   4899: aload_3
    //   4900: getstatic 376	com/tencent/mobileqq/util/FaceInfo:n	I
    //   4903: invokevirtual 378	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   4906: goto -503 -> 4403
    //   4909: astore 7
    //   4911: aload 6
    //   4913: astore 5
    //   4915: iconst_0
    //   4916: istore 19
    //   4918: aload 7
    //   4920: astore 6
    //   4922: goto -2672 -> 2250
    //   4925: lload 31
    //   4927: lstore 33
    //   4929: iload 37
    //   4931: istore 39
    //   4933: aload_1
    //   4934: astore 10
    //   4936: iload 19
    //   4938: istore 21
    //   4940: lload 31
    //   4942: lstore 35
    //   4944: iload 37
    //   4946: istore 40
    //   4948: aload_1
    //   4949: astore 11
    //   4951: iload 27
    //   4953: istore 22
    //   4955: aload 5
    //   4957: astore 9
    //   4959: iload 37
    //   4961: istore 38
    //   4963: aload_1
    //   4964: astore 7
    //   4966: iload 28
    //   4968: istore 20
    //   4970: aload 16
    //   4972: getfield 497	com/tencent/mobileqq/emoticon/DownloadInfo:c	I
    //   4975: istore 19
    //   4977: goto -535 -> 4442
    //   4980: astore_1
    //   4981: aload 12
    //   4983: monitorexit
    //   4984: aload_1
    //   4985: athrow
    //   4986: aload 6
    //   4988: instanceof 650
    //   4991: ifne +852 -> 5843
    //   4994: aload 6
    //   4996: instanceof 652
    //   4999: ifeq +6 -> 5005
    //   5002: goto +841 -> 5843
    //   5005: aload 6
    //   5007: instanceof 654
    //   5010: ifeq +10 -> 5020
    //   5013: bipush 11
    //   5015: istore 19
    //   5017: goto -2712 -> 2305
    //   5020: aload 6
    //   5022: instanceof 656
    //   5025: ifeq +10 -> 5035
    //   5028: bipush 8
    //   5030: istore 19
    //   5032: goto -2727 -> 2305
    //   5035: aload 6
    //   5037: instanceof 658
    //   5040: ifeq +10 -> 5050
    //   5043: bipush 17
    //   5045: istore 19
    //   5047: goto -2742 -> 2305
    //   5050: aload 6
    //   5052: instanceof 660
    //   5055: ifeq +10 -> 5065
    //   5058: bipush 18
    //   5060: istore 19
    //   5062: goto -2757 -> 2305
    //   5065: aload 6
    //   5067: instanceof 662
    //   5070: ifeq +10 -> 5080
    //   5073: bipush 19
    //   5075: istore 19
    //   5077: goto -2772 -> 2305
    //   5080: aload 6
    //   5082: invokevirtual 665	java/io/IOException:getMessage	()Ljava/lang/String;
    //   5085: astore 6
    //   5087: aload 6
    //   5089: ldc_w 667
    //   5092: invokevirtual 670	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5095: ifne +29 -> 5124
    //   5098: aload 6
    //   5100: ldc_w 672
    //   5103: invokevirtual 670	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5106: ifne +18 -> 5124
    //   5109: aload 6
    //   5111: ldc_w 674
    //   5114: invokevirtual 670	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   5117: istore 38
    //   5119: iload 38
    //   5121: ifeq +728 -> 5849
    //   5124: bipush 33
    //   5126: istore 19
    //   5128: invokestatic 678	com/tencent/mobileqq/util/SystemUtil:a	()Z
    //   5131: istore 38
    //   5133: iload 38
    //   5135: ifeq +134 -> 5269
    //   5138: invokestatic 680	com/tencent/mobileqq/util/SystemUtil:a	()J
    //   5141: lstore 33
    //   5143: new 175	java/lang/StringBuilder
    //   5146: dup
    //   5147: invokespecial 176	java/lang/StringBuilder:<init>	()V
    //   5150: ldc_w 682
    //   5153: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5156: astore 7
    //   5158: aload 14
    //   5160: invokevirtual 337	java/io/File:exists	()Z
    //   5163: ifeq +692 -> 5855
    //   5166: aload 14
    //   5168: invokevirtual 685	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5171: astore 6
    //   5173: aload 7
    //   5175: aload 6
    //   5177: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5180: ldc_w 687
    //   5183: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5186: astore 7
    //   5188: aload 14
    //   5190: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   5193: ifnull +84 -> 5277
    //   5196: aload 14
    //   5198: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   5201: invokevirtual 337	java/io/File:exists	()Z
    //   5204: ifeq +73 -> 5277
    //   5207: aload 14
    //   5209: invokevirtual 334	java/io/File:getParentFile	()Ljava/io/File;
    //   5212: invokevirtual 685	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   5215: astore 6
    //   5217: ldc 21
    //   5219: iconst_1
    //   5220: aload 7
    //   5222: aload 6
    //   5224: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5227: ldc_w 689
    //   5230: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5233: iload 19
    //   5235: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5238: ldc_w 691
    //   5241: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5244: iload 38
    //   5246: invokevirtual 557	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5249: ldc_w 693
    //   5252: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5255: lload 33
    //   5257: invokevirtual 696	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5260: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5263: invokestatic 240	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5266: goto -2961 -> 2305
    //   5269: invokestatic 698	com/tencent/mobileqq/util/SystemUtil:b	()J
    //   5272: lstore 33
    //   5274: goto -131 -> 5143
    //   5277: ldc_w 700
    //   5280: astore 6
    //   5282: goto -65 -> 5217
    //   5285: astore_1
    //   5286: aload 12
    //   5288: monitorexit
    //   5289: aload_1
    //   5290: athrow
    //   5291: astore_1
    //   5292: aload 12
    //   5294: monitorexit
    //   5295: aload_1
    //   5296: athrow
    //   5297: astore_1
    //   5298: aload 12
    //   5300: monitorexit
    //   5301: aload_1
    //   5302: athrow
    //   5303: iload 19
    //   5305: istore 20
    //   5307: lload 31
    //   5309: ldc2_w 527
    //   5312: lcmp
    //   5313: iflt -5282 -> 31
    //   5316: aload_3
    //   5317: getstatic 595	com/tencent/mobileqq/util/FaceInfo:o	I
    //   5320: invokevirtual 378	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   5323: new 702	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult
    //   5326: dup
    //   5327: invokespecial 703	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:<init>	()V
    //   5330: astore_2
    //   5331: new 705	android/graphics/BitmapFactory$Options
    //   5334: dup
    //   5335: invokespecial 706	android/graphics/BitmapFactory$Options:<init>	()V
    //   5338: astore 5
    //   5340: aload 5
    //   5342: getstatic 711	com/tencent/mobileqq/util/FaceConstant:a	Landroid/graphics/Bitmap$Config;
    //   5345: putfield 714	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   5348: aload_0
    //   5349: getfield 100	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   5352: sipush 215
    //   5355: invokevirtual 612	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5358: checkcast 614	com/tencent/mobileqq/util/FaceManager
    //   5361: astore 6
    //   5363: iconst_0
    //   5364: istore 20
    //   5366: aload 6
    //   5368: aload_3
    //   5369: invokevirtual 717	com/tencent/mobileqq/util/FaceManager:a	(Lcom/tencent/mobileqq/util/FaceInfo;)Ljava/lang/String;
    //   5372: aload 5
    //   5374: aload_2
    //   5375: invokestatic 720	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;)V
    //   5378: aload_2
    //   5379: getfield 721	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_e_of_type_Int	I
    //   5382: iconst_1
    //   5383: if_icmpne +18 -> 5401
    //   5386: aload_0
    //   5387: getfield 100	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   5390: checkcast 723	com/tencent/mobileqq/nearby/NearbyAppInterface
    //   5393: checkcast 723	com/tencent/mobileqq/nearby/NearbyAppInterface
    //   5396: astore 7
    //   5398: invokestatic 724	com/tencent/mobileqq/nearby/NearbyAppInterface:b	()V
    //   5401: iload 20
    //   5403: iconst_1
    //   5404: iadd
    //   5405: istore 20
    //   5407: iload 20
    //   5409: iconst_2
    //   5410: if_icmpge +11 -> 5421
    //   5413: aload_2
    //   5414: getfield 721	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_e_of_type_Int	I
    //   5417: iconst_1
    //   5418: if_icmpeq +348 -> 5766
    //   5421: aload_2
    //   5422: getfield 725	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5425: ifnull +63 -> 5488
    //   5428: aload_3
    //   5429: getfield 601	com/tencent/mobileqq/util/FaceInfo:c	I
    //   5432: tableswitch	default:+28->5460, 1:+43->5475, 2:+28->5460, 3:+96->5528
    //   5460: aload_2
    //   5461: aload_2
    //   5462: getfield 725	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5465: bipush 50
    //   5467: bipush 50
    //   5469: invokestatic 606	com/tencent/mobileqq/utils/ImageUtil:b	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   5472: putfield 725	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5475: aload 6
    //   5477: aload_3
    //   5478: invokevirtual 616	com/tencent/mobileqq/util/FaceInfo:a	()Ljava/lang/String;
    //   5481: aload_2
    //   5482: getfield 725	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5485: invokevirtual 619	com/tencent/mobileqq/util/FaceManager:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   5488: aload_3
    //   5489: getstatic 622	com/tencent/mobileqq/util/FaceInfo:p	I
    //   5492: invokevirtual 378	com/tencent/mobileqq/util/FaceInfo:a	(I)V
    //   5495: aload_1
    //   5496: aload_2
    //   5497: getfield 725	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5500: putfield 381	pxl:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5503: aload_0
    //   5504: getfield 69	com/tencent/mobileqq/app/FaceDownloader:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   5507: aload_1
    //   5508: invokevirtual 384	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   5511: pop
    //   5512: aload_0
    //   5513: getfield 149	com/tencent/mobileqq/app/FaceDownloader:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   5516: bipush 100
    //   5518: aload_1
    //   5519: invokevirtual 390	mqq/os/MqqHandler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   5522: invokevirtual 395	android/os/Message:sendToTarget	()V
    //   5525: iload 19
    //   5527: ireturn
    //   5528: aload_2
    //   5529: aload_2
    //   5530: getfield 725	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5533: bipush 50
    //   5535: bipush 50
    //   5537: invokestatic 641	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   5540: putfield 725	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   5543: goto -68 -> 5475
    //   5546: astore 6
    //   5548: goto -1699 -> 3849
    //   5551: astore 6
    //   5553: goto -1439 -> 4114
    //   5556: astore 6
    //   5558: goto -1098 -> 4460
    //   5561: astore 6
    //   5563: goto -800 -> 4763
    //   5566: astore 6
    //   5568: goto -3245 -> 2323
    //   5571: astore 6
    //   5573: goto -2985 -> 2588
    //   5576: astore 6
    //   5578: goto -2645 -> 2933
    //   5581: astore 6
    //   5583: goto -2382 -> 3201
    //   5586: astore_1
    //   5587: goto -2279 -> 3308
    //   5590: astore_1
    //   5591: goto -2022 -> 3569
    //   5594: astore_1
    //   5595: goto -2197 -> 3398
    //   5598: astore 7
    //   5600: aload 6
    //   5602: astore 5
    //   5604: aload 7
    //   5606: astore 6
    //   5608: iload 24
    //   5610: istore 19
    //   5612: goto -2322 -> 3290
    //   5615: astore 6
    //   5617: iload 24
    //   5619: istore 19
    //   5621: goto -2331 -> 3290
    //   5624: astore 6
    //   5626: goto -2336 -> 3290
    //   5629: astore 6
    //   5631: goto -2341 -> 3290
    //   5634: astore 6
    //   5636: iconst_1
    //   5637: istore 37
    //   5639: goto -2349 -> 3290
    //   5642: astore 6
    //   5644: goto -2354 -> 3290
    //   5647: astore 6
    //   5649: iload 22
    //   5651: istore 19
    //   5653: goto -2363 -> 3290
    //   5656: astore 6
    //   5658: goto -2636 -> 3022
    //   5661: astore 7
    //   5663: aload 6
    //   5665: astore 5
    //   5667: aload 7
    //   5669: astore 6
    //   5671: iload 23
    //   5673: istore 19
    //   5675: goto -2817 -> 2858
    //   5678: astore 6
    //   5680: iload 23
    //   5682: istore 19
    //   5684: goto -2826 -> 2858
    //   5687: astore 6
    //   5689: iconst_1
    //   5690: istore 37
    //   5692: goto -2834 -> 2858
    //   5695: astore 6
    //   5697: goto -2839 -> 2858
    //   5700: astore 6
    //   5702: iload 23
    //   5704: istore 19
    //   5706: goto -2848 -> 2858
    //   5709: astore 6
    //   5711: goto -3294 -> 2417
    //   5714: astore 6
    //   5716: iconst_0
    //   5717: istore 19
    //   5719: goto -3469 -> 2250
    //   5722: astore 6
    //   5724: iconst_5
    //   5725: istore 19
    //   5727: iload 38
    //   5729: istore 37
    //   5731: goto -3481 -> 2250
    //   5734: astore 6
    //   5736: iconst_5
    //   5737: istore 19
    //   5739: goto -3489 -> 2250
    //   5742: astore 6
    //   5744: iload 24
    //   5746: istore 19
    //   5748: goto -3498 -> 2250
    //   5751: astore 6
    //   5753: goto -1199 -> 4554
    //   5756: astore 6
    //   5758: goto -912 -> 4846
    //   5761: astore 6
    //   5763: goto -1820 -> 3943
    //   5766: goto -400 -> 5366
    //   5769: goto -3178 -> 2591
    //   5772: iconst_5
    //   5773: istore 20
    //   5775: iload 23
    //   5777: istore 21
    //   5779: goto -2077 -> 3702
    //   5782: goto -4694 -> 1088
    //   5785: iconst_m1
    //   5786: istore 26
    //   5788: aconst_null
    //   5789: astore 6
    //   5791: goto -5279 -> 512
    //   5794: aload 7
    //   5796: astore 6
    //   5798: goto -5382 -> 416
    //   5801: aload 7
    //   5803: astore 8
    //   5805: goto -5337 -> 468
    //   5808: aload 8
    //   5810: astore 7
    //   5812: iload 20
    //   5814: istore 25
    //   5816: goto -5607 -> 209
    //   5819: lload 33
    //   5821: lstore 31
    //   5823: iload 21
    //   5825: istore 19
    //   5827: aload 7
    //   5829: astore 5
    //   5831: aload 6
    //   5833: astore_1
    //   5834: goto -3243 -> 2591
    //   5837: goto -3246 -> 2591
    //   5840: goto -1588 -> 4252
    //   5843: iconst_2
    //   5844: istore 19
    //   5846: goto -3541 -> 2305
    //   5849: iconst_4
    //   5850: istore 19
    //   5852: goto -724 -> 5128
    //   5855: ldc_w 700
    //   5858: astore 6
    //   5860: goto -687 -> 5173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5863	0	this	FaceDownloader
    //   0	5863	1	paramString	String
    //   0	5863	2	paramFile	java.io.File
    //   0	5863	3	paramFaceInfo	FaceInfo
    //   0	5863	4	paramBoolean	boolean
    //   61	4745	5	localObject1	Object
    //   4840	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   4844	986	5	localObject2	Object
    //   195	12	6	localObject3	Object
    //   298	1	6	localIllegalArgumentException	IllegalArgumentException
    //   331	1846	6	localObject4	Object
    //   2233	57	6	localIOException1	java.io.IOException
    //   2338	327	6	localObject5	Object
    //   2737	102	6	localThrowable1	Throwable
    //   2841	67	6	localThrowable2	Throwable
    //   2943	240	6	localObject6	Object
    //   3273	300	6	localObject7	Object
    //   3864	1612	6	localObject8	Object
    //   5546	1	6	localIOException2	java.io.IOException
    //   5551	1	6	localInterruptedException1	InterruptedException
    //   5556	1	6	localIOException3	java.io.IOException
    //   5561	1	6	localInterruptedException2	InterruptedException
    //   5566	1	6	localIOException4	java.io.IOException
    //   5571	1	6	localInterruptedException3	InterruptedException
    //   5576	1	6	localIOException5	java.io.IOException
    //   5581	20	6	localInterruptedException4	InterruptedException
    //   5606	1	6	localObject9	Object
    //   5615	1	6	localObject10	Object
    //   5624	1	6	localObject11	Object
    //   5629	1	6	localObject12	Object
    //   5634	1	6	localObject13	Object
    //   5642	1	6	localObject14	Object
    //   5647	1	6	localObject15	Object
    //   5656	8	6	localException1	Exception
    //   5669	1	6	localObject16	Object
    //   5678	1	6	localThrowable3	Throwable
    //   5687	1	6	localThrowable4	Throwable
    //   5695	1	6	localThrowable5	Throwable
    //   5700	1	6	localThrowable6	Throwable
    //   5709	1	6	localException2	Exception
    //   5714	1	6	localIOException6	java.io.IOException
    //   5722	1	6	localIOException7	java.io.IOException
    //   5734	1	6	localIOException8	java.io.IOException
    //   5742	1	6	localIOException9	java.io.IOException
    //   5751	1	6	localException3	Exception
    //   5756	1	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   5761	1	6	localException4	Exception
    //   5789	70	6	localObject17	Object
    //   204	4626	7	localObject18	Object
    //   4909	10	7	localIOException10	java.io.IOException
    //   4964	433	7	localObject19	Object
    //   5598	7	7	localObject20	Object
    //   5661	141	7	localThrowable7	Throwable
    //   5810	18	7	localObject21	Object
    //   219	5590	8	localObject22	Object
    //   551	4407	9	localObject23	Object
    //   528	4407	10	str1	String
    //   543	4407	11	str2	String
    //   55	5244	12	localObject24	Object
    //   42	4551	13	localURL	java.net.URL
    //   178	5030	14	localFile	java.io.File
    //   3	503	15	localNetworkInfo	android.net.NetworkInfo
    //   95	4876	16	localDownloadInfo	com.tencent.mobileqq.emoticon.DownloadInfo
    //   486	4150	17	str3	String
    //   517	4164	18	str4	String
    //   201	5650	19	k	int
    //   29	5784	20	m	int
    //   532	5292	21	n	int
    //   547	5103	22	i1	int
    //   1695	4081	23	i2	int
    //   1701	4044	24	i3	int
    //   198	5617	25	i4	int
    //   510	5277	26	i5	int
    //   1692	3260	27	i6	int
    //   1698	3269	28	i7	int
    //   1812	2990	29	i8	int
    //   491	4156	30	i9	int
    //   6	5816	31	l1	long
    //   521	5299	33	l2	long
    //   536	4407	35	l3	long
    //   481	5249	37	bool1	boolean
    //   555	5173	38	bool2	boolean
    //   525	4407	39	bool3	boolean
    //   540	4407	40	bool4	boolean
    //   472	2206	41	bool5	boolean
    //   475	2218	42	bool6	boolean
    //   478	2230	43	bool7	boolean
    //   961	3	44	bool8	boolean
    // Exception table:
    //   from	to	target	type
    //   34	44	119	java/net/MalformedURLException
    //   57	63	127	java/lang/Exception
    //   68	82	127	java/lang/Exception
    //   139	148	298	java/lang/IllegalArgumentException
    //   300	305	308	java/lang/IllegalArgumentException
    //   564	575	2233	java/io/IOException
    //   626	637	2233	java/io/IOException
    //   682	686	2233	java/io/IOException
    //   731	736	2233	java/io/IOException
    //   787	798	2233	java/io/IOException
    //   843	854	2233	java/io/IOException
    //   899	903	2233	java/io/IOException
    //   958	963	2233	java/io/IOException
    //   1133	1143	2233	java/io/IOException
    //   1188	1195	2233	java/io/IOException
    //   1240	1247	2233	java/io/IOException
    //   1292	1297	2233	java/io/IOException
    //   1327	1331	2233	java/io/IOException
    //   1361	1370	2233	java/io/IOException
    //   1400	1409	2233	java/io/IOException
    //   1439	1448	2233	java/io/IOException
    //   1478	1487	2233	java/io/IOException
    //   1517	1528	2233	java/io/IOException
    //   1558	1566	2233	java/io/IOException
    //   1611	1619	2233	java/io/IOException
    //   1664	1691	2233	java/io/IOException
    //   1751	1762	2233	java/io/IOException
    //   1807	1814	2233	java/io/IOException
    //   1867	1875	2233	java/io/IOException
    //   1920	1926	2233	java/io/IOException
    //   1971	1977	2233	java/io/IOException
    //   2022	2040	2233	java/io/IOException
    //   2226	2230	2233	java/io/IOException
    //   2718	2734	2233	java/io/IOException
    //   2789	2793	2233	java/io/IOException
    //   2838	2841	2233	java/io/IOException
    //   3266	3270	2233	java/io/IOException
    //   3623	3631	2233	java/io/IOException
    //   3676	3683	2233	java/io/IOException
    //   4165	4172	2233	java/io/IOException
    //   4970	4977	2233	java/io/IOException
    //   1327	1331	2737	java/lang/Throwable
    //   1361	1370	2737	java/lang/Throwable
    //   1400	1409	2737	java/lang/Throwable
    //   1439	1448	2737	java/lang/Throwable
    //   1478	1487	2737	java/lang/Throwable
    //   1517	1528	2737	java/lang/Throwable
    //   1558	1566	2737	java/lang/Throwable
    //   564	575	2841	java/lang/Throwable
    //   626	637	2841	java/lang/Throwable
    //   682	686	2841	java/lang/Throwable
    //   731	736	2841	java/lang/Throwable
    //   787	798	2841	java/lang/Throwable
    //   843	854	2841	java/lang/Throwable
    //   899	903	2841	java/lang/Throwable
    //   958	963	2841	java/lang/Throwable
    //   1133	1143	2841	java/lang/Throwable
    //   1188	1195	2841	java/lang/Throwable
    //   1240	1247	2841	java/lang/Throwable
    //   1292	1297	2841	java/lang/Throwable
    //   1611	1619	2841	java/lang/Throwable
    //   1664	1691	2841	java/lang/Throwable
    //   1751	1762	2841	java/lang/Throwable
    //   1807	1814	2841	java/lang/Throwable
    //   1867	1875	2841	java/lang/Throwable
    //   1920	1926	2841	java/lang/Throwable
    //   1971	1977	2841	java/lang/Throwable
    //   2022	2040	2841	java/lang/Throwable
    //   2226	2230	2841	java/lang/Throwable
    //   2718	2734	2841	java/lang/Throwable
    //   2789	2793	2841	java/lang/Throwable
    //   2838	2841	2841	java/lang/Throwable
    //   3266	3270	2841	java/lang/Throwable
    //   3623	3631	2841	java/lang/Throwable
    //   3676	3683	2841	java/lang/Throwable
    //   4165	4172	2841	java/lang/Throwable
    //   4970	4977	2841	java/lang/Throwable
    //   564	575	3273	finally
    //   626	637	3273	finally
    //   682	686	3273	finally
    //   731	736	3273	finally
    //   787	798	3273	finally
    //   843	854	3273	finally
    //   899	903	3273	finally
    //   958	963	3273	finally
    //   1133	1143	3273	finally
    //   1188	1195	3273	finally
    //   1240	1247	3273	finally
    //   1292	1297	3273	finally
    //   1327	1331	3273	finally
    //   1361	1370	3273	finally
    //   1400	1409	3273	finally
    //   1439	1448	3273	finally
    //   1478	1487	3273	finally
    //   1517	1528	3273	finally
    //   1558	1566	3273	finally
    //   1611	1619	3273	finally
    //   1664	1691	3273	finally
    //   1751	1762	3273	finally
    //   1807	1814	3273	finally
    //   1867	1875	3273	finally
    //   1920	1926	3273	finally
    //   1971	1977	3273	finally
    //   2022	2040	3273	finally
    //   2226	2230	3273	finally
    //   2718	2734	3273	finally
    //   2789	2793	3273	finally
    //   2838	2841	3273	finally
    //   2873	2912	3273	finally
    //   3266	3270	3273	finally
    //   3623	3631	3273	finally
    //   3676	3683	3273	finally
    //   4165	4172	3273	finally
    //   4970	4977	3273	finally
    //   4106	4114	4175	finally
    //   4114	4117	4175	finally
    //   4176	4179	4175	finally
    //   2040	2046	4840	java/io/FileNotFoundException
    //   2060	2067	4840	java/io/FileNotFoundException
    //   2073	2087	4840	java/io/FileNotFoundException
    //   4181	4188	4840	java/io/FileNotFoundException
    //   4197	4214	4840	java/io/FileNotFoundException
    //   4223	4252	4840	java/io/FileNotFoundException
    //   4252	4263	4840	java/io/FileNotFoundException
    //   4263	4292	4840	java/io/FileNotFoundException
    //   4292	4346	4840	java/io/FileNotFoundException
    //   4346	4393	4840	java/io/FileNotFoundException
    //   4393	4403	4840	java/io/FileNotFoundException
    //   4403	4420	4840	java/io/FileNotFoundException
    //   4420	4435	4840	java/io/FileNotFoundException
    //   4780	4791	4840	java/io/FileNotFoundException
    //   4794	4801	4840	java/io/FileNotFoundException
    //   4805	4814	4840	java/io/FileNotFoundException
    //   4827	4837	4840	java/io/FileNotFoundException
    //   4899	4906	4840	java/io/FileNotFoundException
    //   2040	2046	4909	java/io/IOException
    //   2060	2067	4909	java/io/IOException
    //   2073	2087	4909	java/io/IOException
    //   4181	4188	4909	java/io/IOException
    //   4197	4214	4909	java/io/IOException
    //   4223	4252	4909	java/io/IOException
    //   4252	4263	4909	java/io/IOException
    //   4263	4292	4909	java/io/IOException
    //   4292	4346	4909	java/io/IOException
    //   4346	4393	4909	java/io/IOException
    //   4393	4403	4909	java/io/IOException
    //   4403	4420	4909	java/io/IOException
    //   4420	4435	4909	java/io/IOException
    //   4780	4791	4909	java/io/IOException
    //   4794	4801	4909	java/io/IOException
    //   4805	4814	4909	java/io/IOException
    //   4827	4837	4909	java/io/IOException
    //   4899	4906	4909	java/io/IOException
    //   4755	4763	4980	finally
    //   4763	4766	4980	finally
    //   4981	4984	4980	finally
    //   2580	2588	5285	finally
    //   2588	2591	5285	finally
    //   5286	5289	5285	finally
    //   3193	3201	5291	finally
    //   3201	3204	5291	finally
    //   5292	5295	5291	finally
    //   3561	3569	5297	finally
    //   3569	3572	5297	finally
    //   5298	5301	5297	finally
    //   3844	3849	5546	java/io/IOException
    //   4106	4114	5551	java/lang/InterruptedException
    //   4455	4460	5556	java/io/IOException
    //   4755	4763	5561	java/lang/InterruptedException
    //   2318	2323	5566	java/io/IOException
    //   2580	2588	5571	java/lang/InterruptedException
    //   2928	2933	5576	java/io/IOException
    //   3193	3201	5581	java/lang/InterruptedException
    //   3303	3308	5586	java/io/IOException
    //   3561	3569	5590	java/lang/InterruptedException
    //   3318	3324	5594	java/lang/Exception
    //   3328	3340	5594	java/lang/Exception
    //   3340	3382	5594	java/lang/Exception
    //   3386	3398	5594	java/lang/Exception
    //   2040	2046	5598	finally
    //   2060	2067	5598	finally
    //   2073	2087	5598	finally
    //   4181	4188	5598	finally
    //   4197	4214	5598	finally
    //   4223	4252	5598	finally
    //   4252	4263	5598	finally
    //   4263	4292	5598	finally
    //   4292	4346	5598	finally
    //   4346	4393	5598	finally
    //   4393	4403	5598	finally
    //   4403	4420	5598	finally
    //   4420	4435	5598	finally
    //   4780	4791	5598	finally
    //   4794	4801	5598	finally
    //   4805	4814	5598	finally
    //   4827	4837	5598	finally
    //   4899	4906	5598	finally
    //   4846	4893	5615	finally
    //   2250	2296	5624	finally
    //   4986	5002	5624	finally
    //   5005	5013	5624	finally
    //   5020	5028	5624	finally
    //   5035	5043	5624	finally
    //   5050	5058	5624	finally
    //   5065	5073	5624	finally
    //   5080	5119	5624	finally
    //   5128	5133	5629	finally
    //   5138	5143	5629	finally
    //   5143	5173	5629	finally
    //   5173	5217	5629	finally
    //   5217	5266	5629	finally
    //   5269	5274	5629	finally
    //   974	1007	5634	finally
    //   1013	1037	5634	finally
    //   2605	2616	5634	finally
    //   2622	2644	5634	finally
    //   2653	2664	5634	finally
    //   1043	1088	5642	finally
    //   3722	3735	5647	finally
    //   3755	3763	5647	finally
    //   3783	3801	5647	finally
    //   3825	3831	5647	finally
    //   2938	2945	5656	java/lang/Exception
    //   2950	2964	5656	java/lang/Exception
    //   2964	3006	5656	java/lang/Exception
    //   3010	3022	5656	java/lang/Exception
    //   2040	2046	5661	java/lang/Throwable
    //   2060	2067	5661	java/lang/Throwable
    //   2073	2087	5661	java/lang/Throwable
    //   4181	4188	5661	java/lang/Throwable
    //   4197	4214	5661	java/lang/Throwable
    //   4223	4252	5661	java/lang/Throwable
    //   4252	4263	5661	java/lang/Throwable
    //   4263	4292	5661	java/lang/Throwable
    //   4292	4346	5661	java/lang/Throwable
    //   4346	4393	5661	java/lang/Throwable
    //   4393	4403	5661	java/lang/Throwable
    //   4403	4420	5661	java/lang/Throwable
    //   4420	4435	5661	java/lang/Throwable
    //   4780	4791	5661	java/lang/Throwable
    //   4794	4801	5661	java/lang/Throwable
    //   4805	4814	5661	java/lang/Throwable
    //   4827	4837	5661	java/lang/Throwable
    //   4899	4906	5661	java/lang/Throwable
    //   4846	4893	5678	java/lang/Throwable
    //   974	1007	5687	java/lang/Throwable
    //   1013	1037	5687	java/lang/Throwable
    //   2605	2616	5687	java/lang/Throwable
    //   2622	2644	5687	java/lang/Throwable
    //   2653	2664	5687	java/lang/Throwable
    //   1043	1088	5695	java/lang/Throwable
    //   3722	3735	5700	java/lang/Throwable
    //   3755	3763	5700	java/lang/Throwable
    //   3783	3801	5700	java/lang/Throwable
    //   3825	3831	5700	java/lang/Throwable
    //   2333	2340	5709	java/lang/Exception
    //   2345	2359	5709	java/lang/Exception
    //   2359	2401	5709	java/lang/Exception
    //   2405	2417	5709	java/lang/Exception
    //   4846	4893	5714	java/io/IOException
    //   974	1007	5722	java/io/IOException
    //   1013	1037	5722	java/io/IOException
    //   2605	2616	5722	java/io/IOException
    //   2622	2644	5722	java/io/IOException
    //   2653	2664	5722	java/io/IOException
    //   1043	1088	5734	java/io/IOException
    //   3722	3735	5742	java/io/IOException
    //   3755	3763	5742	java/io/IOException
    //   3783	3801	5742	java/io/IOException
    //   3825	3831	5742	java/io/IOException
    //   4470	4477	5751	java/lang/Exception
    //   4482	4496	5751	java/lang/Exception
    //   4496	4538	5751	java/lang/Exception
    //   4542	4554	5751	java/lang/Exception
    //   1867	1875	5756	java/io/FileNotFoundException
    //   1920	1926	5756	java/io/FileNotFoundException
    //   1971	1977	5756	java/io/FileNotFoundException
    //   2022	2040	5756	java/io/FileNotFoundException
    //   3859	3866	5761	java/lang/Exception
    //   3871	3885	5761	java/lang/Exception
    //   3885	3927	5761	java/lang/Exception
    //   3931	3943	5761	java/lang/Exception
  }
  
  public FaceDownloader.FaceDownloadThreadInfo a()
  {
    FaceDownloader.FaceDownloadThreadInfo localFaceDownloadThreadInfo = new FaceDownloader.FaceDownloadThreadInfo(this);
    int k = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDownloader", 2, "processor count:" + k);
    }
    if (k >= 4) {}
    do
    {
      return localFaceDownloadThreadInfo;
      localFaceDownloadThreadInfo.jdField_b_of_type_Int = (k + 1);
    } while (k > 2);
    localFaceDownloadThreadInfo.c = 10;
    return localFaceDownloadThreadInfo;
  }
  
  public abstract String a();
  
  public String a(String paramString, byte paramByte1, byte paramByte2, int paramInt)
  {
    String str1 = "q.qlogo.cn";
    StringBuilder localStringBuilder;
    if (paramByte2 == 32) {
      if (paramInt == 1)
      {
        str1 = "q.qlogo.cn";
        String str2 = InnerDns.a().a(str1, 1003);
        if (QLog.isColorLevel()) {
          QLog.i(InnerDns.a, 2, "getQQHeandDownLoadUrl.choosedIp=" + str2);
        }
        localStringBuilder = new StringBuilder("http://");
        if (TextUtils.isEmpty(str2)) {
          break label231;
        }
        localStringBuilder.append(str2);
        label97:
        int k = paramString.indexOf("/", 8);
        str1 = paramString;
        if (k > 8)
        {
          localStringBuilder.append(paramString.substring(k));
          str1 = localStringBuilder.toString();
        }
        if (paramByte2 != 32) {
          break label249;
        }
        if (paramInt != 1) {
          break label242;
        }
        paramByte2 = a(paramByte1);
      }
    }
    for (;;)
    {
      return str1 + paramByte2;
      if (paramInt != 32) {
        break;
      }
      str1 = "p.qlogo.cn";
      break;
      if (paramByte2 == 16)
      {
        str1 = "p.qlogo.cn";
        break;
      }
      if ((paramByte2 == 4) || (paramByte2 == 8))
      {
        str1 = "p.qlogo.cn";
        break;
      }
      str1 = "q.qlogo.cn";
      break;
      label231:
      localStringBuilder.append(str1);
      break label97;
      label242:
      paramByte2 = 140;
      continue;
      label249:
      if (paramByte2 == 16) {
        paramByte2 = 224;
      } else {
        paramByte2 = a(paramByte1);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashSet != null) {
      this.jdField_a_of_type_JavaUtilHashSet.clear();
    }
    int k = 0;
    while (k < this.jdField_a_of_type_ArrayOfPxk.length)
    {
      if (this.jdField_a_of_type_ArrayOfPxk[k] != null) {
        this.jdField_a_of_type_ArrayOfPxk[k].a();
      }
      k += 1;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      synchronized (this.jdField_a_of_type_JavaUtilArrayList)
      {
        this.jdField_a_of_type_JavaUtilArrayList.clear();
        this.jdField_a_of_type_JavaUtilArrayList.notifyAll();
        return;
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == this.jdField_b_of_type_Int) && (this.d < this.jdField_b_of_type_Int) && (this.jdField_a_of_type_JavaUtilArrayList.size() >= this.c))
    {
      int k = this.d + this.jdField_a_of_type_JavaUtilArrayList.size() - this.c + 1;
      paramInt = k;
      if (k <= 0) {
        paramInt = 1;
      }
      if (paramInt < this.jdField_b_of_type_Int) {}
      for (;;)
      {
        k = 0;
        while (k < paramInt)
        {
          if (this.jdField_a_of_type_ArrayOfPxk[k] == null)
          {
            this.jdField_a_of_type_ArrayOfPxk[k] = new pxk(this, k);
            this.jdField_a_of_type_ArrayOfPxk[k].start();
            this.d += 1;
          }
          k += 1;
        }
        paramInt = this.jdField_b_of_type_Int;
      }
    }
  }
  
  public void a(FaceDownloader.FaceDownloadListener paramFaceDownloadListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "addFaceDownloadListener l=" + paramFaceDownloadListener);
      }
      this.jdField_a_of_type_JavaUtilLinkedList.add(paramFaceDownloadListener);
      return;
    }
    finally {}
  }
  
  public void a(FaceInfo paramFaceInfo)
  {
    a(this.jdField_b_of_type_Int);
    HashSet localHashSet = this.jdField_a_of_type_JavaUtilHashSet;
    if (paramFaceInfo != null) {}
    for (;;)
    {
      try
      {
        ??? = paramFaceInfo.c();
        if ((TextUtils.isEmpty((CharSequence)???)) || (this.jdField_a_of_type_JavaUtilHashSet.contains(???)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.FaceDownloader", 2, "addDownloadRequest url repeat, info=" + paramFaceInfo + ",urlUniq=" + (String)???);
          }
          return;
        }
        this.jdField_a_of_type_JavaUtilHashSet.add(???);
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramFaceInfo);
          this.jdField_a_of_type_JavaUtilArrayList.notify();
          return;
        }
        ??? = "";
      }
      finally {}
    }
  }
  
  public abstract String b();
  
  public void b(FaceDownloader.FaceDownloadListener paramFaceDownloadListener)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDownloader", 2, "removeFaceDownloadListener l=" + paramFaceDownloadListener);
      }
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramFaceDownloadListener);
      return;
    }
    finally {}
  }
  
  public abstract void b(FaceInfo paramFaceInfo);
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\FaceDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */