package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;

public abstract class AbstractImageDownloader
  extends AbsDownloader
{
  private static final String S = "big_img_decode_slice";
  public static int a = 0;
  public static final String a = "c2c_file";
  public static int b = 0;
  public static final String b = "group_file";
  private static int c = 1048576;
  private static int d = c * 2;
  public static final String d = "discuss_file";
  private static final String f = "big_img_decode";
  private static final int h = 88000;
  private static final int i = 0;
  private static final int j = -1;
  private static final int jdField_k_of_type_Int = 1;
  private static final String jdField_k_of_type_JavaLangString = "big_img_decode_long";
  private static final int l = 2;
  private static final int m = 3;
  private static final int n = 4;
  private static final int o = 5;
  private static final int p = 6;
  protected BaseApplicationImpl a;
  protected String e;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AbstractImageDownloader(String paramString, BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
  }
  
  public static int a(Application paramApplication, int paramInt)
  {
    float f1 = 1.0F;
    if (paramInt > 150) {
      f1 = paramInt / 100;
    }
    float f2 = paramApplication.getResources().getDisplayMetrics().density;
    if (f2 <= 1.5D) {
      return (int)(f1 * 9.0F);
    }
    if (f2 <= 2.0D) {
      return (int)(f1 * 9.0F);
    }
    return (int)(f1 * 4.0F);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    return Utils.calculateInSampleSize(paramOptions, paramInt1, paramInt2);
  }
  
  private RoundRectBitmap a(Bitmap paramBitmap, DownloadParams paramDownloadParams)
  {
    for (;;)
    {
      float f3;
      int i2;
      int i5;
      int i3;
      int i6;
      try
      {
        f3 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().density;
        int i4 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().densityDpi;
        boolean bool = PeakUtils.a(paramDownloadParams.mImgType);
        i2 = URLDrawableHelper.b(bool);
        i1 = URLDrawableHelper.a(bool);
        i5 = paramBitmap.getWidth();
        i3 = paramBitmap.getHeight();
        paramDownloadParams = new Paint(1);
        paramDownloadParams.setColor(-16777216);
        i6 = URLDrawableHelper.c(bool);
        int i7 = URLDrawableHelper.d(bool);
        if ((i5 >= i7) && (i3 >= i7)) {
          break label355;
        }
        if (i5 < i3)
        {
          i3 = (int)(i2 / i5 * i3 + 0.5F);
          if (i3 <= i1) {
            break label326;
          }
          Bitmap localBitmap = Bitmap.createBitmap(i2, i1, URLDrawableHelper.b);
          localBitmap.setDensity(i4);
          new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, i2, i1), paramDownloadParams);
          return new RoundRectBitmap(localBitmap, 12.0F * f3);
        }
        i3 = (int)(i2 / i3 * i5 + 0.5F);
        if (i3 <= i1) {
          break label348;
        }
      }
      catch (OutOfMemoryError paramDownloadParams)
      {
        float f1;
        float f2;
        return new RoundRectBitmap(paramBitmap, 12.0F);
      }
      if (i5 > i3)
      {
        f1 = i1 / i5;
        if (i5 > i3)
        {
          f2 = i2 / i3;
          f1 = Math.max(f1, f2);
          i2 = (int)(i5 * f1 + 0.5F);
          i1 = (int)(f1 * i3 + 0.5F);
        }
      }
      else
      {
        f1 = i1 / i3;
        continue;
      }
      f2 = i2 / i5;
      continue;
      label326:
      int i1 = i3;
      continue;
      for (;;)
      {
        i3 = i1;
        i1 = i2;
        i2 = i3;
        break;
        label348:
        i1 = i3;
      }
      label355:
      if ((i5 < i6) && (i3 < i6))
      {
        i2 = (int)(i5 * f3 + 0.5F);
        i1 = (int)(i3 * f3 + 0.5F);
      }
    }
  }
  
  public static String a(Exception paramException)
  {
    int i1 = 8;
    if (paramException == null) {
      return "Exception e is null,holy shit";
    }
    Object localObject = paramException.getMessage();
    StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      localObject = new StringBuilder(":");
      int i2 = arrayOfStackTraceElement.length;
      if (i2 > 8) {}
      for (;;)
      {
        ((StringBuilder)localObject).append("\n");
        i2 = 0;
        while (i2 < i1)
        {
          ((StringBuilder)localObject).append(arrayOfStackTraceElement[i2].toString()).append("\n");
          i2 += 1;
        }
        i1 = i2;
      }
      return paramException.toString() + ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  private void a(Application paramApplication, String paramString1, int paramInt1, String paramString2, int paramInt2)
  {
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        paramApplication = ((QQAppInterface)((BaseApplicationImpl)paramApplication).getAppRuntime(paramString2)).a();
      }
      catch (AccountNotMatchException paramApplication)
      {
        return;
      }
      paramString2 = new HashMap();
      paramString2.put("param_FailCode", Integer.toString(paramInt2 * 7 + paramInt1 + 88000));
      StatisticCollector.a(BaseApplication.getContext()).a(paramApplication, paramString1, bool, 0L, 0L, paramString2, "");
      return;
      boolean bool = false;
      continue;
      paramApplication = paramString2;
      if (paramInt2 == 0) {
        bool = true;
      }
    }
  }
  
  private void a(Application paramApplication, String paramString, int paramInt, boolean paramBoolean)
  {
    int i1 = 0;
    paramInt *= 4;
    try
    {
      if (paramInt < c)
      {
        paramInt = i1;
        if (!paramBoolean) {
          break label185;
        }
        paramInt = 1;
      }
      for (;;)
      {
        paramApplication = (QQAppInterface)((BaseApplicationImpl)paramApplication).getAppRuntime(paramString);
        paramString = new HashMap();
        paramString.put("param_FailCode", Integer.toString(paramInt + 88050));
        StatisticCollector.a(BaseApplication.getContext()).a(paramApplication.a(), "report_aio_photo_size", false, 0L, 0L, paramString, "");
        return;
        paramInt /= d;
        if (paramInt >= 10)
        {
          if (paramBoolean) {}
          for (paramInt = 17;; paramInt = 16) {
            break;
          }
        }
        if (paramInt >= 8)
        {
          if (paramBoolean) {}
          for (paramInt = 15;; paramInt = 14) {
            break;
          }
        }
        if (paramInt >= 6)
        {
          if (paramBoolean) {}
          for (paramInt = 13;; paramInt = 12) {
            break;
          }
        }
        if (paramBoolean) {}
        for (paramInt = paramInt * 2 + 3;; paramInt = paramInt * 2 + 2) {
          break;
        }
      }
    }
    catch (AccountNotMatchException paramApplication) {}
  }
  
  private void a(DownloadParams paramDownloadParams)
  {
    MessageForPic localMessageForPic;
    Object localObject;
    if ((paramDownloadParams.tag != null) && ((paramDownloadParams.tag instanceof MessageForPic)))
    {
      localMessageForPic = (MessageForPic)paramDownloadParams.tag;
      localObject = localMessageForPic.selfuin;
    }
    try
    {
      localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getAppRuntime((String)localObject);
      ((QQAppInterface)localObject).a().a.b(localMessageForPic, localMessageForPic.size);
      ((QQAppInterface)localObject).a().f();
      return;
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      a(paramDownloadParams, "payPicFlow", "FAIL,exceptionmsg:" + localAccountNotMatchException);
    }
  }
  
  private void a(DownloadParams paramDownloadParams, File paramFile, String paramString1, BitmapFactory.Options paramOptions, int paramInt, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean) {
      if (QLog.isColorLevel()) {
        a(paramDownloadParams, "DecodeFile", "DecodeFile SUCCESS,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    a(paramDownloadParams, "DecodeFile", "DecodeFile FAIL,retryCount=" + paramInt + ",options.inSampleSize=" + paramOptions.inSampleSize + ",cacheFile=" + paramFile.getAbsolutePath() + ",url=" + paramString1 + ",extraMsg=" + paramString2);
  }
  
  public static void a(AbstractImageDownloader.ReportData paramReportData, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, FileMsg.StepBaseInfo paramStepBaseInfo1, FileMsg.StepBaseInfo paramStepBaseInfo2, FileMsg.StepTransInfo paramStepTransInfo)
  {
    System.currentTimeMillis();
    long l1;
    if (paramStepTransInfo != null)
    {
      l1 = paramStepTransInfo.jdField_e_of_type_Long;
      if (paramStepTransInfo == null) {
        break label42;
      }
    }
    label42:
    for (long l2 = paramStepTransInfo.f;; l2 = 0L)
    {
      if (!RichMediaStrategy.c(paramInt2)) {
        break label48;
      }
      return;
      l1 = 0L;
      break;
    }
    label48:
    HashMap localHashMap = new HashMap();
    String str2;
    String str1;
    if (!BaseTransProcessor.a(paramInt2, localHashMap))
    {
      localHashMap.put("param_FailCode", Integer.toString(paramInt2));
      if ((paramInt2 == 56009) || (paramInt2 == 9311) || (paramInt2 == 9044) || (paramInt2 == 9350) || (paramInt2 == 9351))
      {
        localHashMap.put(BaseTransProcessor.be, paramString);
        str2 = "";
        if ((!paramBoolean) || (paramStepBaseInfo1 != null) || (paramStepBaseInfo2 != null) || (paramStepTransInfo != null)) {
          break label472;
        }
        str1 = "1_-1_0_0_0;2_-1_0_0_0;3_-1_0_0_0";
        label152:
        if (QLog.isColorLevel()) {
          QLog.d("reportResult", 2, "parmStep: " + str1);
        }
        localHashMap.put("param_step", str1);
        localHashMap.put("param_uuid", paramReportData.f);
        localHashMap.put("flow", String.valueOf(l1));
        localHashMap.put("msgTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramReportData.jdField_a_of_type_Long * 1000L)));
        localHashMap.put("client_exist", String.valueOf(paramReportData.jdField_a_of_type_Boolean));
        if (paramStepBaseInfo2 != null) {
          localHashMap.put("param_RequestUrl", paramStepBaseInfo2.b());
        }
        if (paramStepTransInfo != null) {
          localHashMap.put("param_HttpTran", paramStepTransInfo.b());
        }
        if (paramStepTransInfo != null)
        {
          localHashMap.put("param_retry", String.valueOf(paramStepTransInfo.b));
          if (!paramStepTransInfo.jdField_a_of_type_Boolean) {
            break label553;
          }
          localHashMap.put("serverip", paramStepTransInfo.c);
          localHashMap.put("param_Server", paramStepTransInfo.c);
        }
        label373:
        if (!paramBoolean) {
          break label621;
        }
        if ((!paramReportData.c.equals("actC2CPicDownloadV1")) && (!paramReportData.c.equals("actC2CPicSmallDownV1"))) {
          break label605;
        }
        localHashMap.put("param_toUin", paramReportData.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, paramReportData.c, true, paramInt1, l1, localHashMap, "");
      return;
      localHashMap.put("param_errorDesc", paramString);
      break;
      paramInt2 = 56009;
      localHashMap.put("param_errorDesc", paramString);
      break;
      label472:
      str1 = str2;
      if (paramStepBaseInfo1 == null) {
        break label152;
      }
      str1 = str2;
      if (paramStepBaseInfo2 == null) {
        break label152;
      }
      str1 = str2;
      if (paramStepTransInfo == null) {
        break label152;
      }
      str1 = paramStepBaseInfo1.a(1) + ";" + paramStepBaseInfo2.a(2) + ";" + paramStepTransInfo.a(3);
      break label152;
      label553:
      localHashMap.put("serverip", paramStepTransInfo.d);
      localHashMap.put("param_Server", paramStepTransInfo.d);
      if (paramInt2 != 56009) {
        break label373;
      }
      localHashMap.put("param_rspHeader", paramStepTransInfo.jdField_e_of_type_JavaLangString);
      break label373;
      label605:
      localHashMap.put("param_grpUin", paramReportData.jdField_a_of_type_JavaLangString);
    }
    label621:
    if (paramInt2 == 9301) {
      localHashMap.put("param_connecttrycount", paramString);
    }
    if ((paramReportData.g != null) && (!paramReportData.g.equals(""))) {
      localHashMap.put("param_MsgTime", paramReportData.g);
    }
    long l3 = paramInt1;
    if ((paramReportData.c.equals("actC2CPicDownloadV1")) || (paramReportData.c.equals("actC2CPicSmallDownV1")))
    {
      localHashMap.put("param_toUin", paramReportData.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramReportData.jdField_e_of_type_JavaLangString);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
    for (;;)
    {
      StatisticCollector.a(BaseApplication.getContext()).a(null, paramReportData.c, false, 0L, 0L, localHashMap, "");
      return;
      localHashMap.put("param_grpUin", paramReportData.jdField_a_of_type_JavaLangString);
      localHashMap.put("param_url", paramReportData.jdField_e_of_type_JavaLangString);
      localHashMap.put("param_fsized", l1 + "");
      localHashMap.put("param_fsizeo", l2 + "");
    }
  }
  
  /* Error */
  protected static void a(java.io.OutputStream paramOutputStream, File paramFile, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 483	java/io/File:length	()J
    //   4: lstore 7
    //   6: new 485	java/io/FileInputStream
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 488	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore_1
    //   15: lconst_0
    //   16: lstore 5
    //   18: sipush 8192
    //   21: newarray <illegal type>
    //   23: astore_3
    //   24: aload_1
    //   25: aload_3
    //   26: invokevirtual 492	java/io/FileInputStream:read	([B)I
    //   29: istore 4
    //   31: iload 4
    //   33: iconst_m1
    //   34: if_icmpeq +78 -> 112
    //   37: aload_0
    //   38: aload_3
    //   39: iconst_0
    //   40: iload 4
    //   42: invokevirtual 498	java/io/OutputStream:write	([BII)V
    //   45: aload_0
    //   46: invokevirtual 501	java/io/OutputStream:flush	()V
    //   49: lload 5
    //   51: iload 4
    //   53: i2l
    //   54: ladd
    //   55: lstore 5
    //   57: aload_2
    //   58: lload 5
    //   60: l2f
    //   61: lload 7
    //   63: l2f
    //   64: fdiv
    //   65: ldc_w 502
    //   68: fmul
    //   69: f2i
    //   70: invokeinterface 507 2 0
    //   75: goto -51 -> 24
    //   78: astore_0
    //   79: aload_0
    //   80: invokevirtual 508	java/io/IOException:getMessage	()Ljava/lang/String;
    //   83: ldc_w 510
    //   86: invokevirtual 514	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: ifeq +28 -> 117
    //   92: new 516	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   95: dup
    //   96: sipush 9040
    //   99: ldc2_w 517
    //   102: aload_0
    //   103: invokevirtual 508	java/io/IOException:getMessage	()Ljava/lang/String;
    //   106: iconst_0
    //   107: iconst_0
    //   108: invokespecial 521	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   111: athrow
    //   112: aload_1
    //   113: invokevirtual 524	java/io/FileInputStream:close	()V
    //   116: return
    //   117: new 516	com/tencent/mobileqq/transfile/FileDownloadFailedException
    //   120: dup
    //   121: sipush 9301
    //   124: ldc2_w 525
    //   127: aload_0
    //   128: invokevirtual 508	java/io/IOException:getMessage	()Ljava/lang/String;
    //   131: iconst_0
    //   132: iconst_0
    //   133: invokespecial 521	com/tencent/mobileqq/transfile/FileDownloadFailedException:<init>	(IJLjava/lang/String;ZZ)V
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramOutputStream	java.io.OutputStream
    //   0	137	1	paramFile	File
    //   0	137	2	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   23	16	3	arrayOfByte	byte[]
    //   29	23	4	i1	int
    //   16	43	5	l1	long
    //   4	58	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   0	15	78	java/io/IOException
    //   18	24	78	java/io/IOException
    //   24	31	78	java/io/IOException
    //   37	49	78	java/io/IOException
    //   57	75	78	java/io/IOException
    //   112	116	78	java/io/IOException
  }
  
  private void a(Object paramObject, String paramString1, String paramString2)
  {
    if ((paramObject instanceof DownloadParams))
    {
      localObject = (DownloadParams)paramObject;
      if ((((DownloadParams)localObject).tag instanceof PicUiInterface))
      {
        paramObject = (PicUiInterface)((DownloadParams)localObject).tag;
        localObject = ((DownloadParams)localObject).url.getProtocol();
        if (((PicUiInterface)paramObject).isSendFromLocal())
        {
          i1 = RichMediaUtil.a(URLDrawableHelper.a((String)localObject, false));
          paramObject = ((PicUiInterface)paramObject).getPicUploadInfo();
          RichMediaUtil.a(((PicUploadInfo)paramObject).b, false, i1, String.valueOf(((PicUploadInfo)paramObject).jdField_a_of_type_Long), paramString1, paramString2);
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      int i1;
      return;
      paramObject = ((PicUiInterface)paramObject).getPicDownloadInfo();
      if (((PicDownloadInfo)paramObject).f == 1) {}
      for (boolean bool = true;; bool = false)
      {
        i1 = RichMediaUtil.a(URLDrawableHelper.a((String)localObject, bool));
        RichMediaUtil.a(((PicDownloadInfo)paramObject).b, false, i1, String.valueOf(((PicDownloadInfo)paramObject).jdField_a_of_type_Long), paramString1, paramString2);
        return;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("obj").append(paramObject);
    ((StringBuilder)localObject).append(" \tstep:").append(paramString1);
    ((StringBuilder)localObject).append(" \tcontent:").append(paramString2);
    QLog.d("Q.richmedia.", 2, ((StringBuilder)localObject).toString());
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt1, int paramInt2, String paramString, boolean paramBoolean5)
  {
    if (paramInt2 == 3)
    {
      paramInt2 = paramInt1 - 1;
      if (paramInt1 != 1) {
        break label49;
      }
      a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 0, paramString, paramInt2);
      a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 0, paramString, paramInt2);
    }
    label49:
    label152:
    label168:
    do
    {
      for (;;)
      {
        return;
        if (!paramBoolean5) {
          break;
        }
        if (!paramBoolean1) {
          if (paramBoolean3)
          {
            a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", -1, paramString, paramInt2);
            if (!paramBoolean2) {
              break label152;
            }
            a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 3, paramString, paramInt2);
          }
        }
        for (;;)
        {
          if (!paramBoolean2) {
            break label168;
          }
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_slice", 0, paramString, paramInt2);
          return;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 2, paramString, paramInt2);
          break;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 1, paramString, paramInt2);
          break;
          a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 4, paramString, paramInt2);
        }
      }
      if (paramBoolean1) {
        a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode", 5, paramString, paramInt2);
      }
      if (paramBoolean2) {
        a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_long", 6, paramString, paramInt2);
      }
    } while (!paramBoolean4);
    a(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl, "big_img_decode_slice", 6, paramString, paramInt2);
  }
  
  static boolean c()
  {
    boolean bool = Build.MODEL.toLowerCase().contains("vivo");
    if (QLog.isColorLevel()) {
      QLog.d("AbstractImageDownloader", 2, "isVIVO result  = " + bool);
    }
    return bool;
  }
  
  /* Error */
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, com.tencent.image.URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: aload_0
    //   7: aload_2
    //   8: ldc_w 309
    //   11: new 197	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 601
    //   21: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_2
    //   25: getfield 266	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   28: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokespecial 300	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_2
    //   38: getfield 604	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   41: astore 5
    //   43: aload_2
    //   44: getfield 532	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   47: astore 4
    //   49: aload 4
    //   51: invokevirtual 537	java/net/URL:getProtocol	()Ljava/lang/String;
    //   54: astore_3
    //   55: ldc_w 606
    //   58: aload_3
    //   59: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   62: ifne +1870 -> 1932
    //   65: ldc_w 608
    //   68: aload_3
    //   69: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   72: ifeq +168 -> 240
    //   75: goto +1857 -> 1932
    //   78: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +45 -> 126
    //   84: aload_0
    //   85: aload_2
    //   86: ldc_w 309
    //   89: new 197	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 610
    //   99: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_1
    //   103: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   106: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc_w 330
    //   112: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 5
    //   117: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokespecial 300	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   126: new 318	android/graphics/BitmapFactory$Options
    //   129: dup
    //   130: invokespecial 611	android/graphics/BitmapFactory$Options:<init>	()V
    //   133: astore 6
    //   135: aload 6
    //   137: getstatic 613	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_AndroidGraphicsBitmap$Config	Landroid/graphics/Bitmap$Config;
    //   140: putfield 616	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   143: aload 6
    //   145: sipush 160
    //   148: putfield 619	android/graphics/BitmapFactory$Options:inDensity	I
    //   151: aload 6
    //   153: sipush 160
    //   156: putfield 622	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   159: aload 6
    //   161: sipush 160
    //   164: putfield 625	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   167: aload 6
    //   169: iconst_1
    //   170: putfield 628	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   173: aload_1
    //   174: invokestatic 634	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   177: ifeq +69 -> 246
    //   180: iload 7
    //   182: ifne +64 -> 246
    //   185: aload_0
    //   186: aload_2
    //   187: invokespecial 636	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;)V
    //   190: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +45 -> 238
    //   196: aload_0
    //   197: aload_2
    //   198: ldc_w 309
    //   201: new 197	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   208: ldc_w 638
    //   211: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload_1
    //   215: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   218: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 330
    //   224: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload 5
    //   229: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokespecial 300	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   238: aconst_null
    //   239: areturn
    //   240: iconst_0
    //   241: istore 7
    //   243: goto -165 -> 78
    //   246: iload 7
    //   248: ifeq +787 -> 1035
    //   251: aload 6
    //   253: getstatic 149	com/tencent/mobileqq/transfile/URLDrawableHelper:b	Landroid/graphics/Bitmap$Config;
    //   256: putfield 616	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   259: aload 6
    //   261: iconst_0
    //   262: putfield 628	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   265: aload_1
    //   266: invokevirtual 641	java/io/File:getName	()Ljava/lang/String;
    //   269: astore_3
    //   270: aload_3
    //   271: ldc_w 643
    //   274: invokevirtual 647	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   277: ifne +242 -> 519
    //   280: new 197	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   287: aload_3
    //   288: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc_w 643
    //   294: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore_3
    //   301: new 325	java/io/File
    //   304: dup
    //   305: getstatic 650	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   308: aload_3
    //   309: invokespecial 653	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   312: astore 4
    //   314: aload_1
    //   315: astore_3
    //   316: aload 4
    //   318: invokevirtual 656	java/io/File:exists	()Z
    //   321: ifeq +113 -> 434
    //   324: invokestatic 658	com/tencent/mobileqq/transfile/AbstractImageDownloader:c	()Z
    //   327: ifne +55 -> 382
    //   330: aload_1
    //   331: invokestatic 662	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   334: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   337: ifeq +45 -> 382
    //   340: aload_0
    //   341: aload_2
    //   342: ldc_w 309
    //   345: new 197	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 664
    //   355: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_1
    //   359: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   362: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc_w 666
    //   368: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: aload 5
    //   373: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokespecial 300	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   382: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +46 -> 431
    //   388: aload_0
    //   389: aload_2
    //   390: ldc_w 309
    //   393: new 197	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 668
    //   403: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload 4
    //   408: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   411: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc_w 666
    //   417: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: aload 5
    //   422: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokespecial 300	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   431: aload 4
    //   433: astore_3
    //   434: aload_3
    //   435: astore_1
    //   436: aload_1
    //   437: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   440: aload 6
    //   442: invokestatic 673	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   445: astore 4
    //   447: aload 4
    //   449: astore_3
    //   450: aload 4
    //   452: ifnull +26 -> 478
    //   455: aload 4
    //   457: astore_3
    //   458: aload_2
    //   459: getfield 677	com/tencent/image/DownloadParams:mDecodeHandler	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   462: ifnull +16 -> 478
    //   465: aload_2
    //   466: getfield 677	com/tencent/image/DownloadParams:mDecodeHandler	Lcom/tencent/image/DownloadParams$DecodeHandler;
    //   469: aload_2
    //   470: aload 4
    //   472: invokeinterface 683 3 0
    //   477: astore_3
    //   478: aload_3
    //   479: ifnull +264 -> 743
    //   482: aload_2
    //   483: getfield 266	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   486: ifnull +133 -> 619
    //   489: aload_2
    //   490: getfield 266	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   493: instanceof 268
    //   496: ifeq +123 -> 619
    //   499: aload_2
    //   500: getfield 266	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   503: checkcast 268	com/tencent/mobileqq/data/MessageForPic
    //   506: getfield 686	com/tencent/mobileqq/data/MessageForPic:subMsgType	I
    //   509: istore 7
    //   511: iload 7
    //   513: iconst_2
    //   514: if_icmpne +105 -> 619
    //   517: aload_3
    //   518: areturn
    //   519: aload_3
    //   520: invokevirtual 688	java/lang/String:length	()I
    //   523: iconst_3
    //   524: if_icmple +92 -> 616
    //   527: aload_3
    //   528: iconst_0
    //   529: aload_3
    //   530: invokevirtual 688	java/lang/String:length	()I
    //   533: iconst_3
    //   534: isub
    //   535: invokevirtual 692	java/lang/String:substring	(II)Ljava/lang/String;
    //   538: astore_3
    //   539: new 325	java/io/File
    //   542: dup
    //   543: getstatic 650	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   546: aload_3
    //   547: invokespecial 653	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   550: astore_3
    //   551: aload_3
    //   552: invokevirtual 656	java/io/File:exists	()Z
    //   555: ifeq +61 -> 616
    //   558: invokestatic 658	com/tencent/mobileqq/transfile/AbstractImageDownloader:c	()Z
    //   561: ifne +55 -> 616
    //   564: aload_3
    //   565: invokestatic 662	com/dataline/util/file/FileUtil:a	(Ljava/io/File;)V
    //   568: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   571: ifeq +45 -> 616
    //   574: aload_0
    //   575: aload_2
    //   576: ldc_w 309
    //   579: new 197	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   586: ldc_w 694
    //   589: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload_1
    //   593: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   596: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: ldc_w 666
    //   602: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload 5
    //   607: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokespecial 300	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   616: goto -180 -> 436
    //   619: aload_0
    //   620: aload_3
    //   621: aload_2
    //   622: invokespecial 696	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/graphics/Bitmap;Lcom/tencent/image/DownloadParams;)Lcom/tencent/image/RoundRectBitmap;
    //   625: astore 4
    //   627: aload_3
    //   628: aload 4
    //   630: getfield 700	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   633: invokevirtual 703	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   636: ifne +7 -> 643
    //   639: aload_3
    //   640: invokevirtual 706	android/graphics/Bitmap:recycle	()V
    //   643: new 172	com/tencent/image/RoundRectBitmap
    //   646: dup
    //   647: new 708	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator
    //   650: dup
    //   651: aload_1
    //   652: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   655: invokespecial 709	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:<init>	(Ljava/lang/String;)V
    //   658: aload 4
    //   660: getfield 700	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   663: invokevirtual 712	com/tencent/mobileqq/transfile/bitmapcreator/ExifBitmapCreator:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   666: aload 4
    //   668: getfield 715	com/tencent/image/RoundRectBitmap:mCornerRadius	F
    //   671: aload 4
    //   673: getfield 718	com/tencent/image/RoundRectBitmap:mBoardColor	I
    //   676: aload 4
    //   678: getfield 721	com/tencent/image/RoundRectBitmap:mBorderWidth	F
    //   681: invokespecial 724	com/tencent/image/RoundRectBitmap:<init>	(Landroid/graphics/Bitmap;FIF)V
    //   684: astore_3
    //   685: aload_0
    //   686: getfield 66	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   689: ifnull +37 -> 726
    //   692: aload_3
    //   693: aload_0
    //   694: getfield 66	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   697: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   700: invokevirtual 79	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   703: getfield 727	android/util/DisplayMetrics:widthPixels	I
    //   706: putfield 730	com/tencent/image/RoundRectBitmap:mDisplayWidth	I
    //   709: aload_3
    //   710: aload_0
    //   711: getfield 66	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   714: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   717: invokevirtual 79	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   720: getfield 733	android/util/DisplayMetrics:heightPixels	I
    //   723: putfield 736	com/tencent/image/RoundRectBitmap:mDisplayHeight	I
    //   726: aload_0
    //   727: aload_2
    //   728: aload_1
    //   729: aload 5
    //   731: aload 6
    //   733: iconst_1
    //   734: iconst_1
    //   735: ldc_w 738
    //   738: invokespecial 740	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   741: aload_3
    //   742: areturn
    //   743: aload_2
    //   744: getfield 266	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   747: checkcast 528	com/tencent/mobileqq/pic/PicUiInterface
    //   750: invokeinterface 540 1 0
    //   755: ifne +99 -> 854
    //   758: aload_1
    //   759: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   762: invokestatic 745	com/tencent/open/base/MD5Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   765: astore_3
    //   766: aload_2
    //   767: getfield 266	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   770: checkcast 528	com/tencent/mobileqq/pic/PicUiInterface
    //   773: invokeinterface 563 1 0
    //   778: astore 4
    //   780: new 197	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 577
    //   790: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload 4
    //   795: getfield 568	com/tencent/mobileqq/pic/PicDownloadInfo:b	I
    //   798: invokestatic 747	com/tencent/mobileqq/transfile/RichMediaUtil:b	(I)Ljava/lang/String;
    //   801: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: ldc_w 749
    //   807: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: iconst_1
    //   814: new 197	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   821: ldc_w 751
    //   824: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: aload 4
    //   829: getfield 569	com/tencent/mobileqq/pic/PicDownloadInfo:jdField_a_of_type_Long	J
    //   832: invokestatic 384	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   835: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: ldc_w 753
    //   841: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: aload_3
    //   845: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   851: invokestatic 755	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   854: aload_1
    //   855: invokevirtual 758	java/io/File:delete	()Z
    //   858: pop
    //   859: aload_0
    //   860: aload_2
    //   861: aload_1
    //   862: aload 5
    //   864: aload 6
    //   866: iconst_1
    //   867: iconst_0
    //   868: ldc_w 760
    //   871: invokespecial 740	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   874: new 480	java/io/IOException
    //   877: dup
    //   878: ldc_w 760
    //   881: invokespecial 761	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   884: athrow
    //   885: astore_3
    //   886: aload_0
    //   887: aload_2
    //   888: aload_1
    //   889: aload 5
    //   891: aload 6
    //   893: iconst_1
    //   894: iconst_0
    //   895: new 197	java/lang/StringBuilder
    //   898: dup
    //   899: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   902: ldc_w 763
    //   905: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: aload_3
    //   909: invokevirtual 764	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   912: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   918: invokespecial 740	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   921: aload_3
    //   922: athrow
    //   923: astore 4
    //   925: aload 4
    //   927: invokestatic 766	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   930: astore_3
    //   931: aload_3
    //   932: ifnull +12 -> 944
    //   935: aload_3
    //   936: astore_1
    //   937: aload_3
    //   938: invokevirtual 688	java/lang/String:length	()I
    //   941: ifne +9 -> 950
    //   944: aload 4
    //   946: invokevirtual 215	java/lang/Exception:toString	()Ljava/lang/String;
    //   949: astore_1
    //   950: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   953: ifeq +40 -> 993
    //   956: aload_0
    //   957: getfield 64	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   960: iconst_2
    //   961: aload_1
    //   962: invokestatic 768	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   965: aload_0
    //   966: aload_2
    //   967: ldc_w 309
    //   970: new 197	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   977: ldc_w 770
    //   980: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: aload_1
    //   984: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   990: invokespecial 300	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   993: new 229	java/util/HashMap
    //   996: dup
    //   997: invokespecial 230	java/util/HashMap:<init>	()V
    //   1000: astore_2
    //   1001: aload_2
    //   1002: ldc_w 772
    //   1005: aload_1
    //   1006: invokevirtual 241	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1009: pop
    //   1010: invokestatic 247	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1013: invokestatic 252	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   1016: aconst_null
    //   1017: ldc_w 774
    //   1020: iconst_0
    //   1021: ldc2_w 775
    //   1024: lconst_0
    //   1025: aload_2
    //   1026: ldc -2
    //   1028: iconst_1
    //   1029: invokevirtual 779	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   1032: aload 4
    //   1034: athrow
    //   1035: aload_0
    //   1036: aload_2
    //   1037: invokespecial 636	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;)V
    //   1040: aload 6
    //   1042: iconst_1
    //   1043: putfield 628	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1046: aload_1
    //   1047: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1050: aload 6
    //   1052: invokestatic 673	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1055: pop
    //   1056: aload 6
    //   1058: getfield 782	android/graphics/BitmapFactory$Options:outHeight	I
    //   1061: ifeq +11 -> 1072
    //   1064: aload 6
    //   1066: getfield 785	android/graphics/BitmapFactory$Options:outWidth	I
    //   1069: ifne +34 -> 1103
    //   1072: aload_1
    //   1073: invokevirtual 758	java/io/File:delete	()Z
    //   1076: pop
    //   1077: aload_0
    //   1078: aload_2
    //   1079: aload_1
    //   1080: aload 5
    //   1082: aload 6
    //   1084: iconst_1
    //   1085: iconst_0
    //   1086: ldc_w 787
    //   1089: invokespecial 740	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1092: new 480	java/io/IOException
    //   1095: dup
    //   1096: ldc_w 787
    //   1099: invokespecial 761	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1102: athrow
    //   1103: aload 6
    //   1105: aload 6
    //   1107: aload_2
    //   1108: getfield 790	com/tencent/image/DownloadParams:reqWidth	I
    //   1111: aload_2
    //   1112: getfield 793	com/tencent/image/DownloadParams:reqHeight	I
    //   1115: invokestatic 795	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   1118: putfield 321	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1121: aload 6
    //   1123: getfield 785	android/graphics/BitmapFactory$Options:outWidth	I
    //   1126: istore 9
    //   1128: aload 6
    //   1130: getfield 782	android/graphics/BitmapFactory$Options:outHeight	I
    //   1133: istore 10
    //   1135: aload 6
    //   1137: iconst_0
    //   1138: putfield 628	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1141: iconst_0
    //   1142: istore 12
    //   1144: aconst_null
    //   1145: astore_3
    //   1146: iconst_1
    //   1147: istore 8
    //   1149: aload 4
    //   1151: invokevirtual 537	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1154: ldc_w 797
    //   1157: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1160: ifne +63 -> 1223
    //   1163: aload 4
    //   1165: invokevirtual 537	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1168: ldc_w 799
    //   1171: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1174: ifne +49 -> 1223
    //   1177: aload 4
    //   1179: invokevirtual 537	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1182: ldc_w 801
    //   1185: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1188: ifne +35 -> 1223
    //   1191: aload 4
    //   1193: invokevirtual 537	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1196: ldc_w 803
    //   1199: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1202: ifne +21 -> 1223
    //   1205: aload 4
    //   1207: invokevirtual 537	java/net/URL:getProtocol	()Ljava/lang/String;
    //   1210: ldc_w 805
    //   1213: invokevirtual 440	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1216: istore 13
    //   1218: iload 13
    //   1220: ifeq +706 -> 1926
    //   1223: iconst_3
    //   1224: istore 7
    //   1226: iload 8
    //   1228: iload 7
    //   1230: if_icmpgt +691 -> 1921
    //   1233: aload_1
    //   1234: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1237: aload 6
    //   1239: invokestatic 673	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1242: astore 4
    //   1244: aload 4
    //   1246: astore_3
    //   1247: aload_3
    //   1248: ifnonnull +258 -> 1506
    //   1251: iload 12
    //   1253: istore 13
    //   1255: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1258: ifeq +60 -> 1318
    //   1261: iload 12
    //   1263: istore 13
    //   1265: aload_0
    //   1266: aload_2
    //   1267: ldc_w 309
    //   1270: new 197	java/lang/StringBuilder
    //   1273: dup
    //   1274: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   1277: ldc_w 807
    //   1280: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1283: aload 5
    //   1285: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1288: ldc_w 809
    //   1291: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1294: iload 8
    //   1296: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1299: ldc_w 811
    //   1302: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: aload_1
    //   1306: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1309: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1312: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1315: invokespecial 300	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1318: iload 12
    //   1320: istore 13
    //   1322: new 100	java/lang/OutOfMemoryError
    //   1325: dup
    //   1326: new 197	java/lang/StringBuilder
    //   1329: dup
    //   1330: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   1333: ldc_w 807
    //   1336: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: aload 5
    //   1341: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1344: ldc_w 809
    //   1347: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: iload 8
    //   1352: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1355: ldc_w 811
    //   1358: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: aload_1
    //   1362: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1365: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1371: invokespecial 812	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   1374: athrow
    //   1375: astore 4
    //   1377: iload 13
    //   1379: istore 12
    //   1381: aload_3
    //   1382: ifnull +7 -> 1389
    //   1385: aload_3
    //   1386: invokevirtual 706	android/graphics/Bitmap:recycle	()V
    //   1389: aload 4
    //   1391: ifnull +455 -> 1846
    //   1394: aload 4
    //   1396: invokevirtual 764	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   1399: astore 4
    //   1401: invokestatic 307	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1404: ifeq +81 -> 1485
    //   1407: aload_0
    //   1408: aload_2
    //   1409: ldc_w 309
    //   1412: new 197	java/lang/StringBuilder
    //   1415: dup
    //   1416: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   1419: ldc_w 814
    //   1422: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: iload 8
    //   1427: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1430: ldc_w 316
    //   1433: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: aload 6
    //   1438: getfield 321	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1441: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1444: ldc_w 323
    //   1447: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1450: aload_1
    //   1451: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1454: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: ldc_w 330
    //   1460: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: aload 5
    //   1465: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1468: ldc_w 816
    //   1471: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1474: aload 4
    //   1476: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1479: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1482: invokespecial 300	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1485: iload 8
    //   1487: iconst_1
    //   1488: iadd
    //   1489: istore 8
    //   1491: aload 6
    //   1493: aload 6
    //   1495: getfield 321	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1498: iconst_2
    //   1499: imul
    //   1500: putfield 321	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1503: goto -277 -> 1226
    //   1506: iload 12
    //   1508: istore 13
    //   1510: getstatic 821	android/os/Build$VERSION:SDK_INT	I
    //   1513: bipush 11
    //   1515: if_icmplt +328 -> 1843
    //   1518: iload 12
    //   1520: istore 13
    //   1522: aload_3
    //   1523: invokestatic 827	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   1526: istore 14
    //   1528: iload 14
    //   1530: ifeq +313 -> 1843
    //   1533: iload 12
    //   1535: istore 13
    //   1537: new 823	com/tencent/image/SliceBitmap
    //   1540: dup
    //   1541: aload_3
    //   1542: invokespecial 828	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   1545: astore 4
    //   1547: iconst_1
    //   1548: istore 12
    //   1550: aload_3
    //   1551: invokevirtual 706	android/graphics/Bitmap:recycle	()V
    //   1554: aload_0
    //   1555: aload_2
    //   1556: aload_1
    //   1557: aload 5
    //   1559: aload 6
    //   1561: iload 8
    //   1563: iconst_1
    //   1564: ldc_w 830
    //   1567: invokespecial 740	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1570: aload 4
    //   1572: astore_3
    //   1573: iconst_1
    //   1574: istore 12
    //   1576: aload_3
    //   1577: ifnull +275 -> 1852
    //   1580: iconst_1
    //   1581: istore 13
    //   1583: aload_0
    //   1584: aload_2
    //   1585: aload_1
    //   1586: aload 5
    //   1588: aload 6
    //   1590: iload 8
    //   1592: iload 13
    //   1594: ldc -2
    //   1596: invokespecial 740	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Lcom/tencent/image/DownloadParams;Ljava/io/File;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;IZLjava/lang/String;)V
    //   1599: aload_2
    //   1600: getfield 266	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1603: ifnull +172 -> 1775
    //   1606: aload_2
    //   1607: getfield 266	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1610: instanceof 268
    //   1613: ifeq +162 -> 1775
    //   1616: aload_2
    //   1617: getfield 266	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   1620: checkcast 268	com/tencent/mobileqq/data/MessageForPic
    //   1623: astore_1
    //   1624: aload_1
    //   1625: getfield 271	com/tencent/mobileqq/data/MessageForPic:selfuin	Ljava/lang/String;
    //   1628: astore 4
    //   1630: aload_1
    //   1631: invokevirtual 831	com/tencent/mobileqq/data/MessageForPic:isSendFromLocal	()Z
    //   1634: istore 17
    //   1636: aload_3
    //   1637: ifnull +221 -> 1858
    //   1640: iconst_1
    //   1641: istore 13
    //   1643: iload 9
    //   1645: iload 10
    //   1647: imul
    //   1648: istore 11
    //   1650: iload 11
    //   1652: getstatic 833	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_Int	I
    //   1655: if_icmple +209 -> 1864
    //   1658: iconst_1
    //   1659: istore 14
    //   1661: goto +277 -> 1938
    //   1664: getstatic 834	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1667: ifeq +9 -> 1676
    //   1670: getstatic 835	com/tencent/mobileqq/transfile/AbstractImageDownloader:b	I
    //   1673: ifne +35 -> 1708
    //   1676: aload_0
    //   1677: getfield 66	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1680: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1683: invokevirtual 79	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1686: getfield 727	android/util/DisplayMetrics:widthPixels	I
    //   1689: putstatic 834	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1692: aload_0
    //   1693: getfield 66	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1696: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   1699: invokevirtual 79	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1702: getfield 733	android/util/DisplayMetrics:heightPixels	I
    //   1705: putstatic 835	com/tencent/mobileqq/transfile/AbstractImageDownloader:b	I
    //   1708: getstatic 834	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1711: getstatic 835	com/tencent/mobileqq/transfile/AbstractImageDownloader:b	I
    //   1714: if_icmple +162 -> 1876
    //   1717: getstatic 834	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_Int	I
    //   1720: istore 9
    //   1722: iload 11
    //   1724: getstatic 836	com/tencent/mobileqq/transfile/URLDrawableHelper:jdField_a_of_type_Int	I
    //   1727: if_icmpgt +157 -> 1884
    //   1730: iload 9
    //   1732: sipush 1000
    //   1735: if_icmple +149 -> 1884
    //   1738: iconst_1
    //   1739: istore 16
    //   1741: aload_0
    //   1742: iload 14
    //   1744: iload 15
    //   1746: iload 16
    //   1748: iload 12
    //   1750: iload 8
    //   1752: iload 7
    //   1754: aload 4
    //   1756: iload 13
    //   1758: invokespecial 838	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(ZZZZIILjava/lang/String;Z)V
    //   1761: aload_0
    //   1762: aload_0
    //   1763: getfield 66	com/tencent/mobileqq/transfile/AbstractImageDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   1766: aload 4
    //   1768: iload 11
    //   1770: iload 17
    //   1772: invokespecial 840	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Landroid/app/Application;Ljava/lang/String;IZ)V
    //   1775: aload_3
    //   1776: ifnonnull +114 -> 1890
    //   1779: new 480	java/io/IOException
    //   1782: dup
    //   1783: ldc_w 842
    //   1786: invokespecial 761	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1789: athrow
    //   1790: astore 4
    //   1792: iload 12
    //   1794: istore 13
    //   1796: aload_0
    //   1797: aload_2
    //   1798: ldc_w 309
    //   1801: new 197	java/lang/StringBuilder
    //   1804: dup
    //   1805: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   1808: ldc_w 844
    //   1811: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1814: aload 4
    //   1816: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1819: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1822: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1825: invokespecial 300	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   1828: iload 12
    //   1830: istore 13
    //   1832: new 100	java/lang/OutOfMemoryError
    //   1835: dup
    //   1836: ldc_w 846
    //   1839: invokespecial 812	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   1842: athrow
    //   1843: goto -267 -> 1576
    //   1846: aconst_null
    //   1847: astore 4
    //   1849: goto -448 -> 1401
    //   1852: iconst_0
    //   1853: istore 13
    //   1855: goto -272 -> 1583
    //   1858: iconst_0
    //   1859: istore 13
    //   1861: goto -218 -> 1643
    //   1864: iconst_0
    //   1865: istore 14
    //   1867: goto +71 -> 1938
    //   1870: iconst_0
    //   1871: istore 15
    //   1873: goto -209 -> 1664
    //   1876: getstatic 835	com/tencent/mobileqq/transfile/AbstractImageDownloader:b	I
    //   1879: istore 9
    //   1881: goto -159 -> 1722
    //   1884: iconst_0
    //   1885: istore 16
    //   1887: goto -146 -> 1741
    //   1890: aload_3
    //   1891: areturn
    //   1892: astore 4
    //   1894: goto -513 -> 1381
    //   1897: astore 4
    //   1899: goto -518 -> 1381
    //   1902: astore 4
    //   1904: iconst_1
    //   1905: istore 12
    //   1907: goto -115 -> 1792
    //   1910: astore_3
    //   1911: goto -1025 -> 886
    //   1914: astore_3
    //   1915: aload 4
    //   1917: astore_1
    //   1918: goto -1032 -> 886
    //   1921: aconst_null
    //   1922: astore_3
    //   1923: goto -347 -> 1576
    //   1926: iconst_1
    //   1927: istore 7
    //   1929: goto -703 -> 1226
    //   1932: iconst_1
    //   1933: istore 7
    //   1935: goto -1857 -> 78
    //   1938: iload 9
    //   1940: sipush 2048
    //   1943: if_icmpgt +11 -> 1954
    //   1946: iload 10
    //   1948: sipush 2048
    //   1951: if_icmple -81 -> 1870
    //   1954: iconst_1
    //   1955: istore 15
    //   1957: goto -293 -> 1664
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1960	0	this	AbstractImageDownloader
    //   0	1960	1	paramFile	File
    //   0	1960	2	paramDownloadParams	DownloadParams
    //   0	1960	3	paramURLDrawableHandler	com.tencent.image.URLDrawableHandler
    //   47	781	4	localObject1	Object
    //   923	283	4	localException1	Exception
    //   1242	3	4	localBitmap	Bitmap
    //   1375	20	4	localOutOfMemoryError1	OutOfMemoryError
    //   1399	368	4	localObject2	Object
    //   1790	25	4	localException2	Exception
    //   1847	1	4	localObject3	Object
    //   1892	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   1897	1	4	localOutOfMemoryError3	OutOfMemoryError
    //   1902	14	4	localException3	Exception
    //   41	1546	5	str	String
    //   133	1456	6	localOptions	BitmapFactory.Options
    //   180	1754	7	i1	int
    //   1147	604	8	i2	int
    //   1126	818	9	i3	int
    //   1133	819	10	i4	int
    //   1648	121	11	i5	int
    //   1142	764	12	bool1	boolean
    //   1216	644	13	bool2	boolean
    //   1526	340	14	bool3	boolean
    //   1744	212	15	bool4	boolean
    //   1739	147	16	bool5	boolean
    //   1634	137	17	bool6	boolean
    // Exception table:
    //   from	to	target	type
    //   436	447	885	java/lang/OutOfMemoryError
    //   458	478	885	java/lang/OutOfMemoryError
    //   482	511	885	java/lang/OutOfMemoryError
    //   619	643	885	java/lang/OutOfMemoryError
    //   643	726	885	java/lang/OutOfMemoryError
    //   726	741	885	java/lang/OutOfMemoryError
    //   743	854	885	java/lang/OutOfMemoryError
    //   854	885	885	java/lang/OutOfMemoryError
    //   37	75	923	java/lang/Exception
    //   78	126	923	java/lang/Exception
    //   126	180	923	java/lang/Exception
    //   185	238	923	java/lang/Exception
    //   251	314	923	java/lang/Exception
    //   316	382	923	java/lang/Exception
    //   382	431	923	java/lang/Exception
    //   436	447	923	java/lang/Exception
    //   458	478	923	java/lang/Exception
    //   482	511	923	java/lang/Exception
    //   519	616	923	java/lang/Exception
    //   619	643	923	java/lang/Exception
    //   643	726	923	java/lang/Exception
    //   726	741	923	java/lang/Exception
    //   743	854	923	java/lang/Exception
    //   854	885	923	java/lang/Exception
    //   886	923	923	java/lang/Exception
    //   1035	1072	923	java/lang/Exception
    //   1072	1103	923	java/lang/Exception
    //   1103	1141	923	java/lang/Exception
    //   1149	1218	923	java/lang/Exception
    //   1233	1244	923	java/lang/Exception
    //   1255	1261	923	java/lang/Exception
    //   1265	1318	923	java/lang/Exception
    //   1322	1375	923	java/lang/Exception
    //   1385	1389	923	java/lang/Exception
    //   1394	1401	923	java/lang/Exception
    //   1401	1485	923	java/lang/Exception
    //   1491	1503	923	java/lang/Exception
    //   1510	1518	923	java/lang/Exception
    //   1522	1528	923	java/lang/Exception
    //   1583	1636	923	java/lang/Exception
    //   1650	1658	923	java/lang/Exception
    //   1664	1676	923	java/lang/Exception
    //   1676	1708	923	java/lang/Exception
    //   1708	1722	923	java/lang/Exception
    //   1722	1730	923	java/lang/Exception
    //   1741	1775	923	java/lang/Exception
    //   1779	1790	923	java/lang/Exception
    //   1796	1828	923	java/lang/Exception
    //   1832	1843	923	java/lang/Exception
    //   1876	1881	923	java/lang/Exception
    //   1255	1261	1375	java/lang/OutOfMemoryError
    //   1265	1318	1375	java/lang/OutOfMemoryError
    //   1322	1375	1375	java/lang/OutOfMemoryError
    //   1510	1518	1375	java/lang/OutOfMemoryError
    //   1522	1528	1375	java/lang/OutOfMemoryError
    //   1537	1547	1375	java/lang/OutOfMemoryError
    //   1796	1828	1375	java/lang/OutOfMemoryError
    //   1832	1843	1375	java/lang/OutOfMemoryError
    //   1537	1547	1790	java/lang/Exception
    //   1550	1570	1892	java/lang/OutOfMemoryError
    //   1233	1244	1897	java/lang/OutOfMemoryError
    //   1550	1570	1902	java/lang/Exception
    //   251	314	1910	java/lang/OutOfMemoryError
    //   316	382	1910	java/lang/OutOfMemoryError
    //   519	616	1910	java/lang/OutOfMemoryError
    //   382	431	1914	java/lang/OutOfMemoryError
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\transfile\AbstractImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */