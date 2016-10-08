package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.AfterDownloadCallback;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.Char300Info;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.DecorateInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketResInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketTemplateInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import pza;
import pzb;
import pzc;
import pzd;
import pze;

public class IndividualRedPacketManager
  implements Manager
{
  public static int a = 0;
  public static String a;
  public static int b = 0;
  public static String b;
  public static int c = 0;
  public static String c;
  public static String d;
  public static String e;
  public static String f;
  public static String g;
  public static String h;
  public static String i;
  static final int j = 150;
  public static String j;
  static final int k = 100;
  public static String k;
  static final int l = 0;
  public static String l;
  public static final int m = 1;
  public static String m;
  public static final int n = 0;
  public static String n;
  public static String o;
  public static String p;
  public static String q;
  public static int r;
  public static int s;
  private static String s;
  public static int t;
  public static int u = -1;
  float jdField_a_of_type_Float = 0.0F;
  SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  public Handler a;
  HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  ETEngine jdField_a_of_type_ComEtrumpMixlayoutETEngine;
  ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  IndividualRedPacketManager.PrecreateRunnable jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$PrecreateRunnable;
  public QQAppInterface a;
  IndividualRedPacketResDownloader.AfterDownloadCallback jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback = new pzd(this);
  IndividualRedPacketResDownloader jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader;
  Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  public Comparator a;
  public LinkedList a;
  public Map a;
  public AtomicBoolean a;
  float b;
  public AtomicBoolean b;
  AtomicBoolean c;
  public int d;
  AtomicBoolean d;
  int e;
  int f;
  int g;
  int h;
  int i;
  public int o;
  public int p;
  public int q;
  public String r;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_s_of_type_JavaLangString = "IndividualRedPacketManager";
    jdField_a_of_type_JavaLangString = AppConstants.bj + "RedPacket/";
    jdField_b_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "font/";
    jdField_c_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "specialFont/";
    jdField_d_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "templateAIO/";
    jdField_e_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "templateTENPAY/";
    jdField_f_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "templateSEND/";
    jdField_g_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "fontimgprecreate/";
    jdField_h_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "personalfontimg/";
    jdField_i_of_type_JavaLangString = jdField_a_of_type_JavaLangString + "AIOfinalimg/";
    j = jdField_a_of_type_JavaLangString + "TENPAYfinalimg/";
    k = jdField_a_of_type_JavaLangString + "SENDfinalimg/";
    l = "RedpacketPreIndex";
    m = "RedpacketPreFinish";
    n = "RedpacketPreCount";
    jdField_o_of_type_JavaLangString = "RedpacketCharId";
    jdField_p_of_type_JavaLangString = "RedpacketFontId";
    jdField_q_of_type_JavaLangString = "RedpacketMallEntranceSwitch";
    jdField_a_of_type_Int = 100;
    jdField_b_of_type_Int = 20;
    jdField_c_of_type_Int = 10029;
    jdField_s_of_type_Int = -1;
  }
  
  public IndividualRedPacketManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilComparator = new pzc(this);
    this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_o_of_type_Int = 0;
    this.jdField_p_of_type_Int = 0;
    this.jdField_q_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    SharedPreferences localSharedPreferences = a();
    a(localSharedPreferences.getInt("sp_vip_info_can_use_packet", 0), localSharedPreferences.getInt("sp_vip_info_red_packet_disable", 0), false);
    a(localSharedPreferences.getInt("sp_vip_info_red_packet_id", -1), localSharedPreferences.getString("sp_vip_info_red_packet_text", null));
    this.jdField_a_of_type_ComEtrumpMixlayoutETEngine = ETEngine.getInstanceForRedPacket();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean();
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    ThreadManager.a(new pza(this), 8, null, true);
    this.jdField_b_of_type_Float = paramQQAppInterface.a().getApplicationContext().getResources().getDisplayMetrics().density;
    this.jdField_d_of_type_Int = ((int)(138.0F * this.jdField_b_of_type_Float + 0.5D));
    this.jdField_e_of_type_Int = ((int)(115.0F * this.jdField_b_of_type_Float + 0.5D));
    this.jdField_g_of_type_Int = ((int)(this.jdField_b_of_type_Float * 280.0F + 0.5D));
    this.jdField_f_of_type_Int = ((int)(this.jdField_b_of_type_Float * 280.0F + 0.5D));
    this.jdField_i_of_type_Int = ((int)(this.jdField_b_of_type_Float * 104.0F + 0.5D));
    this.jdField_h_of_type_Int = ((int)(320.0F * this.jdField_b_of_type_Float + 0.5D));
    this.jdField_a_of_type_Float = ((int)(this.jdField_b_of_type_Float * 104.0F + 0.5D));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private Bitmap a(IndividualRedPacketManager.FontBitmap paramFontBitmap, String paramString1, String paramString2, int paramInt)
  {
    Object localObject1 = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)a().jdField_a_of_type_JavaUtilMap.get(paramString1);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_s_of_type_JavaLangString, 2, "combineFinalImage init json fail, templateId:" + paramString1);
      }
      return null;
    }
    Object localObject2;
    int i1;
    int i3;
    int i2;
    if (paramInt == 6)
    {
      localObject2 = a(paramString1, "", 2, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_Int);
      i1 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int / 2);
      i3 = this.jdField_d_of_type_Int;
      i2 = this.jdField_e_of_type_Int;
      paramString1 = new Point(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.left / 2), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.top / 2));
      localObject1 = "#ffe589";
    }
    for (;;)
    {
      Bitmap localBitmap2 = a((String)localObject2, null);
      Bitmap localBitmap3 = paramFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap;
      if (localBitmap2 == null)
      {
        return null;
        if (paramInt == 7)
        {
          localObject2 = a(paramString1, "", 3, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_Int);
          i1 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int / 2);
          i3 = this.jdField_f_of_type_Int;
          i2 = this.jdField_g_of_type_Int;
          paramString1 = new Point(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.left / 2), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.top / 2));
          localObject1 = "#d13d4b";
          continue;
        }
        if (paramInt == 15)
        {
          localObject2 = a(paramString1, "", 14, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_Int);
          i1 = DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_Int / 2);
          i3 = this.jdField_h_of_type_Int;
          i2 = this.jdField_i_of_type_Int;
          paramString1 = new Point(DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.left / 2), DisplayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo.jdField_a_of_type_AndroidGraphicsRect.top / 2));
          localObject1 = "#edd4d8";
        }
      }
      else
      {
        try
        {
          localObject2 = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
          if (localObject2 == null) {
            return (Bitmap)localObject2;
          }
        }
        catch (OutOfMemoryError paramFontBitmap)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_s_of_type_JavaLangString, 2, "combineFinalImage Bitmap.createBitmap OutOfMemoryError: " + paramFontBitmap.getMessage());
          }
        }
        catch (Exception localException)
        {
          try
          {
            for (;;)
            {
              paramFontBitmap = new HashMap();
              paramFontBitmap.put("param_FailCode", "combineFinalImage");
              StatisticCollector.a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext()).a(((QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a()).getAccount(), "RedpacketCreateBitmapError", false, 1L, 0L, paramFontBitmap, "", false);
              return null;
              localException = localException;
              if (QLog.isColorLevel()) {
                QLog.d(jdField_s_of_type_JavaLangString, 2, "combineFinalImage Bitmap.createBitmap Error: " + localException.getMessage());
              }
              localBitmap1 = null;
            }
            RectF localRectF = new RectF();
            Rect localRect = new Rect();
            Paint localPaint = new Paint();
            localPaint.setAntiAlias(true);
            localPaint.setDither(true);
            localPaint.setFilterBitmap(true);
            Canvas localCanvas = new Canvas(localBitmap1);
            localRect.set(0, 0, localBitmap2.getWidth(), localBitmap2.getHeight());
            localRectF.set(0.0F, 0.0F, i3, i2);
            localCanvas.drawBitmap(localBitmap2, localRect, localRectF, localPaint);
            if (localBitmap3 != null) {
              if ((paramInt == 7) && (!paramFontBitmap.jdField_a_of_type_Boolean))
              {
                localPaint.setColorFilter(new LightingColorFilter(0, 13712715));
                localRect.set(0, 0, localBitmap3.getWidth(), localBitmap3.getHeight());
                localRectF.set(paramString1.x, paramString1.y, paramString1.x + i1, paramString1.y + i1);
                localCanvas.drawBitmap(localBitmap3, localRect, localRectF, localPaint);
              }
            }
            for (;;)
            {
              return localBitmap1;
              if ((paramInt != 15) || (paramFontBitmap.jdField_a_of_type_Boolean)) {
                break;
              }
              localPaint.setColorFilter(new LightingColorFilter(0, 15586520));
              break;
              localPaint.setColor(Color.parseColor((String)localObject1));
              localPaint.setTextSize(i1 * 0.7F);
              paramFontBitmap = new float[1];
              localObject1 = localPaint.getFontMetricsInt();
              localPaint.getTextWidths(paramString2, paramFontBitmap);
              float f1 = paramString1.x;
              paramInt = (int)((i1 - paramFontBitmap[0]) / 2.0F + f1);
              i2 = paramString1.y;
              i3 = ((Paint.FontMetricsInt)localObject1).ascent;
              i1 = (i1 - (((Paint.FontMetricsInt)localObject1).descent - ((Paint.FontMetricsInt)localObject1).ascent)) / 2;
              localCanvas.drawText(paramString2, paramInt, i2 - i3 + i1, localPaint);
            }
          }
          catch (Exception paramFontBitmap)
          {
            for (;;) {}
          }
        }
      }
      paramString1 = null;
      localObject1 = "#ffe589";
      i1 = 0;
      i2 = 0;
      i3 = 0;
      Bitmap localBitmap1 = null;
    }
  }
  
  /* Error */
  public static Bitmap a(String paramString, android.graphics.BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_2
    //   9: aload 5
    //   11: astore_3
    //   12: getstatic 538	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   15: aload_0
    //   16: invokevirtual 541	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: ifnull +357 -> 376
    //   22: aload 4
    //   24: astore_2
    //   25: aload 5
    //   27: astore_3
    //   28: getstatic 538	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   31: aload_0
    //   32: invokevirtual 541	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   35: checkcast 398	android/graphics/Bitmap
    //   38: astore 4
    //   40: aload 4
    //   42: astore_2
    //   43: aload_2
    //   44: astore_3
    //   45: aload_2
    //   46: ifnonnull +328 -> 374
    //   49: aload_1
    //   50: astore 5
    //   52: aload_1
    //   53: ifnonnull +30 -> 83
    //   56: aload_2
    //   57: astore_3
    //   58: aload_2
    //   59: astore 4
    //   61: new 543	android/graphics/BitmapFactory$Options
    //   64: dup
    //   65: invokespecial 544	android/graphics/BitmapFactory$Options:<init>	()V
    //   68: astore 5
    //   70: aload_2
    //   71: astore_3
    //   72: aload_2
    //   73: astore 4
    //   75: aload 5
    //   77: getstatic 547	android/graphics/Bitmap$Config:ARGB_4444	Landroid/graphics/Bitmap$Config;
    //   80: putfield 550	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   83: aload_2
    //   84: astore_3
    //   85: aload_2
    //   86: astore 4
    //   88: aload_0
    //   89: aload 5
    //   91: invokestatic 555	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   94: astore 6
    //   96: aload_2
    //   97: astore_3
    //   98: aload_2
    //   99: astore 4
    //   101: aload 6
    //   103: getfield 558	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   106: astore_1
    //   107: aload_1
    //   108: astore_3
    //   109: aload_1
    //   110: astore 4
    //   112: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +49 -> 164
    //   118: aload_1
    //   119: astore_3
    //   120: aload_1
    //   121: astore 4
    //   123: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   126: iconst_2
    //   127: new 62	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 560
    //   137: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc_w 562
    //   147: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 6
    //   152: getfield 563	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_e_of_type_Int	I
    //   155: invokevirtual 566	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: aload_1
    //   165: astore_3
    //   166: aload_1
    //   167: astore 4
    //   169: aload 6
    //   171: getfield 563	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_e_of_type_Int	I
    //   174: istore 7
    //   176: aload_1
    //   177: astore_3
    //   178: iload 7
    //   180: iconst_1
    //   181: if_icmpne +193 -> 374
    //   184: iconst_2
    //   185: istore 7
    //   187: aload_1
    //   188: astore_3
    //   189: iload 7
    //   191: iconst_4
    //   192: if_icmpgt +122 -> 314
    //   195: aload_1
    //   196: astore_2
    //   197: aload_1
    //   198: astore_3
    //   199: aload 5
    //   201: iload 7
    //   203: putfield 569	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   206: aload_1
    //   207: astore_2
    //   208: aload_1
    //   209: astore_3
    //   210: aload_0
    //   211: aload 5
    //   213: invokestatic 555	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   216: astore 4
    //   218: aload_1
    //   219: astore_2
    //   220: aload_1
    //   221: astore_3
    //   222: aload 4
    //   224: getfield 558	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   227: astore_1
    //   228: aload_1
    //   229: astore_2
    //   230: aload_1
    //   231: astore_3
    //   232: aload 4
    //   234: getfield 563	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_e_of_type_Int	I
    //   237: iconst_1
    //   238: if_icmpeq +143 -> 381
    //   241: aload_1
    //   242: astore_2
    //   243: aload_1
    //   244: astore_3
    //   245: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +17 -> 265
    //   251: aload_1
    //   252: astore_2
    //   253: aload_1
    //   254: astore_3
    //   255: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   258: iconst_2
    //   259: ldc_w 571
    //   262: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload_1
    //   266: astore_2
    //   267: new 305	java/util/HashMap
    //   270: dup
    //   271: invokespecial 306	java/util/HashMap:<init>	()V
    //   274: astore_3
    //   275: aload_1
    //   276: astore_2
    //   277: getstatic 422	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   280: invokevirtual 423	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   283: invokestatic 428	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   286: getstatic 422	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   289: invokevirtual 431	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   292: checkcast 268	com/tencent/mobileqq/app/QQAppInterface
    //   295: invokevirtual 434	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   298: ldc_w 573
    //   301: iconst_0
    //   302: lconst_1
    //   303: lconst_0
    //   304: aload_3
    //   305: ldc_w 340
    //   308: iconst_0
    //   309: invokevirtual 439	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   312: aload_1
    //   313: astore_3
    //   314: aload_3
    //   315: astore_2
    //   316: new 305	java/util/HashMap
    //   319: dup
    //   320: invokespecial 306	java/util/HashMap:<init>	()V
    //   323: astore_1
    //   324: aload_3
    //   325: astore_2
    //   326: aload_1
    //   327: ldc_w 411
    //   330: ldc_w 575
    //   333: invokevirtual 417	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   336: pop
    //   337: aload_3
    //   338: astore_2
    //   339: getstatic 422	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   342: invokevirtual 423	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   345: invokestatic 428	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   348: getstatic 422	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   351: invokevirtual 431	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   354: checkcast 268	com/tencent/mobileqq/app/QQAppInterface
    //   357: invokevirtual 434	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   360: ldc_w 577
    //   363: iconst_0
    //   364: lconst_1
    //   365: lconst_0
    //   366: aload_1
    //   367: ldc_w 340
    //   370: iconst_0
    //   371: invokevirtual 439	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   374: aload_3
    //   375: areturn
    //   376: aconst_null
    //   377: astore_2
    //   378: goto -335 -> 43
    //   381: iload 7
    //   383: iconst_2
    //   384: imul
    //   385: istore 7
    //   387: goto -200 -> 187
    //   390: astore_0
    //   391: aload_3
    //   392: areturn
    //   393: astore_1
    //   394: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   397: ifeq +43 -> 440
    //   400: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   403: iconst_2
    //   404: new 62	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 560
    //   414: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_0
    //   418: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: ldc_w 579
    //   424: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 407	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   431: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   440: new 305	java/util/HashMap
    //   443: dup
    //   444: invokespecial 306	java/util/HashMap:<init>	()V
    //   447: astore_0
    //   448: aload_0
    //   449: ldc_w 411
    //   452: ldc_w 581
    //   455: invokevirtual 417	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   458: pop
    //   459: getstatic 422	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   462: invokevirtual 423	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   465: invokestatic 428	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   468: getstatic 422	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   471: invokevirtual 431	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   474: checkcast 268	com/tencent/mobileqq/app/QQAppInterface
    //   477: invokevirtual 434	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   480: ldc_w 577
    //   483: iconst_0
    //   484: lconst_1
    //   485: lconst_0
    //   486: aload_0
    //   487: ldc_w 340
    //   490: iconst_0
    //   491: invokevirtual 439	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   494: aload_2
    //   495: areturn
    //   496: astore_1
    //   497: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq +43 -> 543
    //   503: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   506: iconst_2
    //   507: new 62	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   514: ldc_w 560
    //   517: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_0
    //   521: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc_w 583
    //   527: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_1
    //   531: invokevirtual 442	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   534: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   543: new 305	java/util/HashMap
    //   546: dup
    //   547: invokespecial 306	java/util/HashMap:<init>	()V
    //   550: astore_0
    //   551: aload_0
    //   552: ldc_w 411
    //   555: ldc_w 581
    //   558: invokevirtual 417	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   561: pop
    //   562: getstatic 422	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   565: invokevirtual 423	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   568: invokestatic 428	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   571: getstatic 422	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   574: invokevirtual 431	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   577: checkcast 268	com/tencent/mobileqq/app/QQAppInterface
    //   580: invokevirtual 434	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   583: ldc_w 585
    //   586: iconst_0
    //   587: lconst_1
    //   588: lconst_0
    //   589: aload_0
    //   590: ldc_w 340
    //   593: iconst_0
    //   594: invokevirtual 439	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   597: aload_3
    //   598: areturn
    //   599: astore_0
    //   600: aload_3
    //   601: areturn
    //   602: astore_1
    //   603: goto -106 -> 497
    //   606: astore_0
    //   607: goto -113 -> 494
    //   610: astore_1
    //   611: aload 4
    //   613: astore_2
    //   614: goto -220 -> 394
    //   617: astore_2
    //   618: aload_1
    //   619: astore_3
    //   620: goto -306 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	623	0	paramString	String
    //   0	623	1	paramOptions	android.graphics.BitmapFactory.Options
    //   8	606	2	localObject1	Object
    //   617	1	2	localException	Exception
    //   11	609	3	localObject2	Object
    //   4	608	4	localObject3	Object
    //   1	211	5	localOptions	android.graphics.BitmapFactory.Options
    //   94	76	6	localBitmapDecodeResult	com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult
    //   174	212	7	i1	int
    // Exception table:
    //   from	to	target	type
    //   316	324	390	java/lang/Exception
    //   326	337	390	java/lang/Exception
    //   339	374	390	java/lang/Exception
    //   12	22	393	java/lang/OutOfMemoryError
    //   28	40	393	java/lang/OutOfMemoryError
    //   199	206	393	java/lang/OutOfMemoryError
    //   210	218	393	java/lang/OutOfMemoryError
    //   222	228	393	java/lang/OutOfMemoryError
    //   232	241	393	java/lang/OutOfMemoryError
    //   245	251	393	java/lang/OutOfMemoryError
    //   255	265	393	java/lang/OutOfMemoryError
    //   267	275	393	java/lang/OutOfMemoryError
    //   277	312	393	java/lang/OutOfMemoryError
    //   316	324	393	java/lang/OutOfMemoryError
    //   326	337	393	java/lang/OutOfMemoryError
    //   339	374	393	java/lang/OutOfMemoryError
    //   12	22	496	java/lang/Exception
    //   28	40	496	java/lang/Exception
    //   199	206	496	java/lang/Exception
    //   210	218	496	java/lang/Exception
    //   222	228	496	java/lang/Exception
    //   232	241	496	java/lang/Exception
    //   245	251	496	java/lang/Exception
    //   255	265	496	java/lang/Exception
    //   543	597	599	java/lang/Exception
    //   61	70	602	java/lang/Exception
    //   75	83	602	java/lang/Exception
    //   88	96	602	java/lang/Exception
    //   101	107	602	java/lang/Exception
    //   112	118	602	java/lang/Exception
    //   123	164	602	java/lang/Exception
    //   169	176	602	java/lang/Exception
    //   440	494	606	java/lang/Exception
    //   61	70	610	java/lang/OutOfMemoryError
    //   75	83	610	java/lang/OutOfMemoryError
    //   88	96	610	java/lang/OutOfMemoryError
    //   101	107	610	java/lang/OutOfMemoryError
    //   112	118	610	java/lang/OutOfMemoryError
    //   123	164	610	java/lang/OutOfMemoryError
    //   169	176	610	java/lang/OutOfMemoryError
    //   267	275	617	java/lang/Exception
    //   277	312	617	java/lang/Exception
  }
  
  public static String a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    if ((paramQQAppInterface == null) && ((BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a() instanceof QQAppInterface))) {}
    for (Object localObject2 = (QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a();; localObject2 = paramQQAppInterface)
    {
      if (localObject2 == null)
      {
        paramQQAppInterface = "";
        return paramQQAppInterface;
      }
      IndividualRedPacketManager localIndividualRedPacketManager;
      if (localObject2 == null)
      {
        localIndividualRedPacketManager = null;
        label48:
        if (localIndividualRedPacketManager == null) {
          break label395;
        }
        if (!localIndividualRedPacketManager.a()) {
          break label236;
        }
        paramQQAppInterface = "1";
      }
      label65:
      label236:
      label395:
      for (QQAppInterface localQQAppInterface = paramQQAppInterface;; localQQAppInterface = null)
      {
        if (1 == paramInt)
        {
          localObject1 = IndividuationUrlHelper.a(((QQAppInterface)localObject2).a().getApplicationContext(), "hongbao", "");
          paramQQAppInterface = (QQAppInterface)localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            paramQQAppInterface = ((String)localObject1).replace("[from]", "1");
          }
          localObject1 = localObject3;
          if (localIndividualRedPacketManager != null) {
            localObject1 = localIndividualRedPacketManager.a().jdField_f_of_type_JavaLangString;
          }
          ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8006134", "0X8006134", 0, 0, localQQAppInterface, "1", "", "");
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_s_of_type_JavaLangString, 2, "IndividualRedPacketManager.getMallURL=" + (String)localObject1 + ", type:" + paramInt + ", url:" + paramQQAppInterface);
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          return (String)localObject1;
          localIndividualRedPacketManager = (IndividualRedPacketManager)((QQAppInterface)localObject2).getManager(130);
          break label48;
          paramQQAppInterface = "0";
          break label65;
          if (3 == paramInt)
          {
            if ((localIndividualRedPacketManager != null) && (localIndividualRedPacketManager.b()) && (localIndividualRedPacketManager.a().jdField_b_of_type_Boolean))
            {
              if (localIndividualRedPacketManager != null) {}
              for (paramQQAppInterface = localIndividualRedPacketManager.a().jdField_g_of_type_JavaLangString;; paramQQAppInterface = null)
              {
                ReportController.b((QQAppInterface)localObject2, "CliOper", "", "", "0X8006136", "0X8006136", 0, 0, localQQAppInterface, "1", "", "");
                localObject2 = null;
                localObject1 = paramQQAppInterface;
                paramQQAppInterface = (QQAppInterface)localObject2;
                break;
              }
            }
          }
          else
          {
            paramQQAppInterface = IndividuationUrlHelper.a(((QQAppInterface)localObject2).a().getApplicationContext(), "hongbao", "");
            localObject2 = paramQQAppInterface;
            if (!TextUtils.isEmpty(paramQQAppInterface)) {
              localObject2 = paramQQAppInterface.replace("[from]", "2");
            }
            paramQQAppInterface = (QQAppInterface)localObject2;
            if (localIndividualRedPacketManager == null) {
              continue;
            }
            localObject1 = localIndividualRedPacketManager.a().jdField_e_of_type_JavaLangString;
            paramQQAppInterface = (QQAppInterface)localObject2;
            continue;
          }
          paramQQAppInterface = null;
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = "";
    if (5 == paramInt1) {
      if (TextUtils.isEmpty(paramString2)) {
        str = "";
      }
    }
    for (;;)
    {
      if ((TextUtils.isEmpty(str)) && (QLog.isColorLevel())) {
        QLog.d(jdField_s_of_type_JavaLangString, 2, "getLocalImgAddress templateId: " + paramString1 + ", name:" + paramString2 + ", type:" + paramInt1);
      }
      return str;
      str = jdField_h_of_type_JavaLangString + Integer.toHexString(paramString2.charAt(0));
      continue;
      if (4 == paramInt1)
      {
        if (TextUtils.isEmpty(paramString2)) {
          str = "";
        } else {
          str = jdField_g_of_type_JavaLangString + Integer.toHexString(paramString2.charAt(0));
        }
      }
      else if (8 == paramInt1) {
        str = jdField_b_of_type_JavaLangString + paramString1 + "_" + paramInt2;
      } else if (1 == paramInt1) {
        str = jdField_a_of_type_JavaLangString + paramString1 + "_" + paramInt2;
      } else if (9 == paramInt1)
      {
        if (TextUtils.isEmpty(paramString2)) {
          str = "";
        } else {
          str = jdField_c_of_type_JavaLangString + "aio/" + Integer.toHexString(paramString2.charAt(0));
        }
      }
      else if (10 == paramInt1)
      {
        if (TextUtils.isEmpty(paramString2)) {
          str = "";
        } else {
          str = jdField_c_of_type_JavaLangString + "tp/" + Integer.toHexString(paramString2.charAt(0));
        }
      }
      else if (16 == paramInt1)
      {
        if (TextUtils.isEmpty(paramString2)) {
          str = "";
        } else {
          str = jdField_c_of_type_JavaLangString + "send/" + Integer.toHexString(paramString2.charAt(0));
        }
      }
      else if (11 == paramInt1) {
        str = jdField_c_of_type_JavaLangString + paramString1 + "_" + paramInt2;
      } else if (6 == paramInt1)
      {
        if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int) {
          str = jdField_d_of_type_JavaLangString + paramString1 + "_" + paramInt2;
        } else if (TextUtils.isEmpty(paramString2)) {
          str = "";
        } else if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int) {
          str = jdField_i_of_type_JavaLangString + paramString1 + "_" + paramInt2 + "_" + Integer.toHexString(paramString2.charAt(0));
        }
      }
      else if (7 == paramInt1)
      {
        if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int) {
          str = jdField_e_of_type_JavaLangString + paramString1 + "_" + paramInt2;
        } else if (TextUtils.isEmpty(paramString2)) {
          str = "";
        } else if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int) {
          str = j + paramString1 + "_" + paramInt2 + "_" + Integer.toHexString(paramString2.charAt(0));
        }
      }
      else if (15 == paramInt1)
      {
        if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int) {
          str = jdField_f_of_type_JavaLangString + paramString1 + "_" + paramInt2;
        } else if (TextUtils.isEmpty(paramString2)) {
          str = "";
        } else {
          str = k + paramString1 + "_" + paramInt2 + "_" + Integer.toHexString(paramString2.charAt(0));
        }
      }
      else if (2 == paramInt1) {
        str = jdField_d_of_type_JavaLangString + paramString1 + "_" + paramInt2;
      } else if (3 == paramInt1) {
        str = jdField_e_of_type_JavaLangString + paramString1 + "_" + paramInt2;
      } else if (14 == paramInt1) {
        str = jdField_f_of_type_JavaLangString + paramString1 + "_" + paramInt2;
      } else if (12 == paramInt1)
      {
        if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int) {
          str = jdField_d_of_type_JavaLangString + paramString1 + "_" + paramInt2;
        } else if (TextUtils.isEmpty(paramString2)) {
          str = "";
        } else if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int) {
          str = jdField_i_of_type_JavaLangString + "s_" + paramString1 + "_" + paramInt2 + "_" + Integer.toHexString(paramString2.charAt(0));
        }
      }
      else if (13 == paramInt1)
      {
        if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int) {
          str = jdField_e_of_type_JavaLangString + paramString1 + "_" + paramInt2;
        } else if (TextUtils.isEmpty(paramString2)) {
          str = "";
        } else if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int) {
          str = j + "s_" + paramString1 + "_" + paramInt2 + "_" + Integer.toHexString(paramString2.charAt(0));
        }
      }
      else if (15 == paramInt1) {
        if (paramInt3 == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int) {
          str = jdField_f_of_type_JavaLangString + paramString1 + "_" + paramInt2;
        } else if (TextUtils.isEmpty(paramString2)) {
          str = "";
        } else {
          str = k + "s_" + paramString1 + "_" + paramInt2 + "_" + Integer.toHexString(paramString2.charAt(0));
        }
      }
    }
  }
  
  public static void a()
  {
    File localFile = new File(jdField_a_of_type_JavaLangString);
    if (!localFile.exists()) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_s_of_type_JavaLangString, 2, "initDir " + jdField_a_of_type_JavaLangString + " " + false);
      }
    }
    for (;;)
    {
      localFile = new File(jdField_b_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(jdField_d_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(jdField_e_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(jdField_f_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(jdField_h_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(jdField_g_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(jdField_i_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(j);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(k);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(jdField_c_of_type_JavaLangString);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return;
      if (!localFile.isDirectory())
      {
        localFile.delete();
        new File(jdField_a_of_type_JavaLangString).mkdirs();
      }
    }
  }
  
  public SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences("individRedPacket_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  public Bitmap a(IndividualRedPacketManager.FontBitmap paramFontBitmap, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo, int paramInt)
  {
    String str1;
    String str2;
    if (paramInt == 6)
    {
      str1 = "0X800612F";
      str2 = paramRedPacketInfo.jdField_b_of_type_JavaLangString;
    }
    String str3;
    long l1;
    for (;;)
    {
      str3 = "0";
      if (a()) {
        str3 = "1";
      }
      l1 = System.currentTimeMillis();
      ??? = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)a().jdField_a_of_type_JavaUtilMap.get(paramRedPacketInfo.jdField_a_of_type_JavaLangString);
      if (??? != null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_s_of_type_JavaLangString, 2, "createRedPacketImg init json fail");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
      paramFontBitmap = null;
      return paramFontBitmap;
      if (paramInt == 7)
      {
        str1 = "0X800613F";
        str2 = "";
      }
      else
      {
        str1 = "0X800613F";
        str2 = "";
      }
    }
    Object localObject1;
    if (6 == paramInt) {
      localObject1 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
    }
    while (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_s_of_type_JavaLangString, 2, "createRedPacketImg decorateInfo = null");
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
      return null;
      if (7 == paramInt) {
        localObject1 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      } else {
        localObject1 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
      }
    }
    if (!IndividualRedPacketResDownloader.a((IndividualRedPacketResDownloader.RedPacketResInfo)localObject1))
    {
      if (((IndividualRedPacketResDownloader.DecorateInfo)localObject1).j == 2) {
        paramFontBitmap = paramRedPacketInfo.jdField_c_of_type_JavaLangString;
      }
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        for (;;)
        {
          if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramFontBitmap)) {
            this.jdField_a_of_type_JavaUtilMap.put(paramFontBitmap, paramRedPacketInfo);
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_s_of_type_JavaLangString, 2, "createRedPacketImg id = " + paramRedPacketInfo.jdField_a_of_type_JavaLangString + " content = " + paramRedPacketInfo.jdField_b_of_type_JavaLangString + " not exists!");
          }
          paramRedPacketInfo = new Bundle();
          paramRedPacketInfo.putString("aio_request_key", paramFontBitmap);
          a().a((IndividualRedPacketResDownloader.RedPacketResInfo)localObject1, paramRedPacketInfo);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_s_of_type_JavaLangString, 2, "createRedPacketImg BG not found,start download url : " + ((IndividualRedPacketResDownloader.DecorateInfo)localObject1).jdField_d_of_type_JavaLangString);
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", "", str2);
          return null;
          if (((IndividualRedPacketResDownloader.DecorateInfo)localObject1).j != 3) {
            break;
          }
          paramFontBitmap = paramRedPacketInfo.jdField_c_of_type_JavaLangString + "_tp";
        }
        paramFontBitmap = paramRedPacketInfo.jdField_c_of_type_JavaLangString + "_send";
      }
    }
    label550:
    long l2;
    if (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_a_of_type_Int == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int)
    {
      localObject1 = a(paramFontBitmap, paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramRedPacketInfo.jdField_b_of_type_JavaLangString, paramInt);
      l2 = System.currentTimeMillis();
      if (localObject1 == null) {
        break label761;
      }
      if (paramInt != 6) {
        break label659;
      }
      paramRedPacketInfo.jdField_b_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject1);
      label572:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "1", String.valueOf(l2 - l1), str2);
    }
    for (;;)
    {
      paramFontBitmap = (IndividualRedPacketManager.FontBitmap)localObject1;
      if (paramInt != 6) {
        break;
      }
      CustomizeStrategyFactory.a().a(paramRedPacketInfo);
      return (Bitmap)localObject1;
      localObject1 = a(a(paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramRedPacketInfo.jdField_b_of_type_JavaLangString, paramInt, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_a_of_type_Int), null);
      break label550;
      label659:
      if (paramInt == 7)
      {
        if (paramFontBitmap.jdField_b_of_type_Boolean)
        {
          a((Bitmap)localObject1, paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramRedPacketInfo.jdField_b_of_type_JavaLangString, 13);
          break label572;
        }
        a((Bitmap)localObject1, paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramRedPacketInfo.jdField_b_of_type_JavaLangString, 7);
        break label572;
      }
      if (paramInt != 15) {
        break label572;
      }
      if (paramFontBitmap.jdField_b_of_type_Boolean)
      {
        a((Bitmap)localObject1, paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramRedPacketInfo.jdField_b_of_type_JavaLangString, 15);
        break label572;
      }
      a((Bitmap)localObject1, paramRedPacketInfo.jdField_a_of_type_JavaLangString, paramRedPacketInfo.jdField_b_of_type_JavaLangString, 15);
      break label572;
      label761:
      if (QLog.isColorLevel()) {
        QLog.d(jdField_s_of_type_JavaLangString, 2, "createRedPacketImg BG combine == null, templateinfo.type = " + ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)???).jdField_a_of_type_Int);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", str1, str1, 0, 0, str3, "0", String.valueOf(l2 - l1), str2);
    }
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        synchronized (this.jdField_a_of_type_ComEtrumpMixlayoutETEngine)
        {
          long l1;
          if (!this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
          {
            this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
            l1 = System.currentTimeMillis();
          }
          try
          {
            this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.initEngine(1, 524288);
            if (IndividualRedPacketResDownloader.a(a().jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo)) {
              this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_loadFont(a(a().jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.jdField_c_of_type_JavaLangString, "", 8, 0, 0), jdField_c_of_type_Int, true);
            }
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
            long l2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d(jdField_s_of_type_JavaLangString, 2, "RedPacket init Font Engine time = " + (l2 - l1) + "ms");
            }
          }
          catch (Throwable localThrowable)
          {
            this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
            QLog.e(jdField_s_of_type_JavaLangString, 1, "initETEngine Exception:" + localThrowable.getMessage());
            continue;
          }
          if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (TextUtils.isEmpty(paramString)))
          {
            QLog.d(jdField_s_of_type_JavaLangString, 1, "createPersonalFontImg fail EnigeReady = " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get() + " familyName = " + paramString);
            paramString = null;
            return paramString;
          }
        }
        if (IndividualRedPacketResDownloader.a(this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo)) {
          break label314;
        }
      }
      finally {}
      this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader.a(this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo, null);
      QLog.d(jdField_s_of_type_JavaLangString, 1, "createPersonalFontImg fail font not exist!");
      paramString = null;
      continue;
      label314:
      if (this.jdField_a_of_type_ComEtrumpMixlayoutETFont == null) {
        this.jdField_a_of_type_ComEtrumpMixlayoutETFont = new ETFont(jdField_c_of_type_Int, a(a().jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.jdField_c_of_type_JavaLangString, "", 8, 0, 0), this.jdField_a_of_type_Float);
      }
      this.jdField_a_of_type_ComEtrumpMixlayoutETFont.setColor(Color.parseColor("#f8d798"));
      Object localObject = a("", paramString, 5, 0, 0);
      if (paramBoolean) {
        localObject = a("", paramString, 4, 0, 0);
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e(jdField_s_of_type_JavaLangString, 1, "createPersonalFontImg fail : getLocalImgAddress = null");
        paramString = null;
        continue;
      }
      File localFile = new File((String)localObject);
      try
      {
        localObject = Bitmap.createBitmap((int)this.jdField_a_of_type_Float, (int)this.jdField_a_of_type_Float, Bitmap.Config.ARGB_8888);
        if ((!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_isPaintableChar(paramString.charAt(0), this.jdField_a_of_type_ComEtrumpMixlayoutETFont)) || (!this.jdField_a_of_type_ComEtrumpMixlayoutETEngine.native_drawText(paramString, (Bitmap)localObject, 0, 0, this.jdField_a_of_type_ComEtrumpMixlayoutETFont)))
        {
          QLog.d(jdField_s_of_type_JavaLangString, 1, "createPersonalFontImg fail font not support: " + paramString.charAt(0));
          paramString = null;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.d(jdField_s_of_type_JavaLangString, 1, "createPersonalFontImg Bitmap.createBitmap OutOfMemoryError: " + paramString.getMessage());
      }
      try
      {
        paramString = new HashMap();
        paramString.put("param_FailCode", "createPersonalFontImg");
        StatisticCollector.a(BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getApplicationContext()).a(((QQAppInterface)BaseApplicationImpl.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.a()).getAccount(), "RedpacketCreateBitmapError", false, 1L, 0L, paramString, "", false);
        paramString = null;
        continue;
        if ((paramBoolean) && (localObject != null)) {}
        try
        {
          paramString = new BufferedOutputStream(new FileOutputStream(localFile));
          ((Bitmap)localObject).compress(Bitmap.CompressFormat.PNG, 90, paramString);
          paramString.flush();
          paramString.close();
          paramString = (String)localObject;
        }
        catch (FileNotFoundException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_s_of_type_JavaLangString, 2, "createPersonalFontImg exception " + paramString.getMessage());
            }
          }
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_s_of_type_JavaLangString, 2, "createPersonalFontImg exception " + paramString.getMessage());
            }
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  public IndividualRedPacketManager.FontBitmap a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 716	java/lang/System:currentTimeMillis	()J
    //   3: lstore 9
    //   5: new 379	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap
    //   8: dup
    //   9: invokespecial 880	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:<init>	()V
    //   12: astore 7
    //   14: ldc_w 340
    //   17: aload_1
    //   18: iconst_4
    //   19: iconst_0
    //   20: iconst_0
    //   21: invokestatic 345	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   24: astore 5
    //   26: aload_0
    //   27: invokevirtual 316	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   30: getfield 883	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   33: aload_0
    //   34: getfield 210	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   37: invokevirtual 888	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   40: aload_1
    //   41: invokevirtual 891	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   44: ifeq +272 -> 316
    //   47: aload 7
    //   49: iconst_1
    //   50: putfield 482	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_Boolean	Z
    //   53: bipush 6
    //   55: iload_2
    //   56: if_icmpne +70 -> 126
    //   59: aload_0
    //   60: ldc_w 340
    //   63: aload_1
    //   64: bipush 9
    //   66: invokevirtual 894	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +89 -> 160
    //   74: aload 7
    //   76: aload_3
    //   77: aconst_null
    //   78: invokestatic 377	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   81: putfield 382	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   84: aload 7
    //   86: iconst_1
    //   87: putfield 773	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_b_of_type_Boolean	Z
    //   90: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +30 -> 123
    //   96: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   99: iconst_2
    //   100: new 62	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 896
    //   110: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_1
    //   114: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 7
    //   125: areturn
    //   126: bipush 7
    //   128: iload_2
    //   129: if_icmpne +17 -> 146
    //   132: aload_0
    //   133: ldc_w 340
    //   136: aload_1
    //   137: bipush 10
    //   139: invokevirtual 894	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   142: astore_3
    //   143: goto -73 -> 70
    //   146: aload_0
    //   147: ldc_w 340
    //   150: aload_1
    //   151: bipush 14
    //   153: invokevirtual 894	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   156: astore_3
    //   157: goto -87 -> 70
    //   160: aload_0
    //   161: invokevirtual 316	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   164: getfield 883	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   167: invokestatic 726	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;)Z
    //   170: ifeq +18 -> 188
    //   173: aload_0
    //   174: invokevirtual 316	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   177: aload_0
    //   178: invokevirtual 316	com/tencent/mobileqq/app/IndividualRedPacketManager:a	()Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader;
    //   181: getfield 883	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info	Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$Char300Info;
    //   184: aconst_null
    //   185: invokevirtual 752	com/tencent/mobileqq/vas/IndividualRedPacketResDownloader:a	(Lcom/tencent/mobileqq/vas/IndividualRedPacketResDownloader$RedPacketResInfo;Landroid/os/Bundle;)V
    //   188: aload_0
    //   189: getfield 210	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   192: invokevirtual 695	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   195: invokevirtual 698	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   198: invokevirtual 283	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   201: invokevirtual 900	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   204: astore_3
    //   205: bipush 6
    //   207: iload_2
    //   208: if_icmpne +355 -> 563
    //   211: aload_3
    //   212: new 62	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   219: ldc_w 902
    //   222: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_1
    //   226: iconst_0
    //   227: invokevirtual 647	java/lang/String:charAt	(I)C
    //   230: invokestatic 653	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   233: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokevirtual 908	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   242: astore_3
    //   243: aload 7
    //   245: aload_3
    //   246: invokestatic 914	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   249: putfield 382	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   252: aload 7
    //   254: iconst_1
    //   255: putfield 773	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_b_of_type_Boolean	Z
    //   258: aload_3
    //   259: invokevirtual 917	java/io/InputStream:close	()V
    //   262: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   265: ifeq -142 -> 123
    //   268: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   271: iconst_2
    //   272: new 62	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 896
    //   282: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_1
    //   286: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   295: aload 7
    //   297: areturn
    //   298: astore_3
    //   299: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +14 -> 316
    //   305: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   308: iconst_2
    //   309: aload_3
    //   310: invokevirtual 407	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   313: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   316: new 667	java/io/File
    //   319: dup
    //   320: aload 5
    //   322: invokespecial 670	java/io/File:<init>	(Ljava/lang/String;)V
    //   325: astore 4
    //   327: aload_0
    //   328: getfield 258	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   331: astore 8
    //   333: aload 8
    //   335: monitorenter
    //   336: aload 4
    //   338: invokevirtual 673	java/io/File:exists	()Z
    //   341: ifeq +18 -> 359
    //   344: aload 5
    //   346: astore_3
    //   347: aload_0
    //   348: getfield 258	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   351: aload 5
    //   353: invokevirtual 919	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   356: ifeq +56 -> 412
    //   359: ldc_w 340
    //   362: aload_1
    //   363: iconst_5
    //   364: iconst_0
    //   365: iconst_0
    //   366: invokestatic 345	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Ljava/lang/String;III)Ljava/lang/String;
    //   369: astore 6
    //   371: new 667	java/io/File
    //   374: dup
    //   375: aload 6
    //   377: invokespecial 670	java/io/File:<init>	(Ljava/lang/String;)V
    //   380: astore 5
    //   382: aload 5
    //   384: invokevirtual 673	java/io/File:exists	()Z
    //   387: ifeq +362 -> 749
    //   390: aload 5
    //   392: astore 4
    //   394: aload 6
    //   396: astore_3
    //   397: aload_0
    //   398: getfield 258	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   401: aload 6
    //   403: invokevirtual 919	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   406: ifeq +6 -> 412
    //   409: goto +340 -> 749
    //   412: aload 8
    //   414: monitorexit
    //   415: aload_3
    //   416: invokestatic 601	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   419: ifne +268 -> 687
    //   422: aload 4
    //   424: invokestatic 716	java/lang/System:currentTimeMillis	()J
    //   427: invokevirtual 923	java/io/File:setLastModified	(J)Z
    //   430: pop
    //   431: aload 7
    //   433: aload_3
    //   434: aconst_null
    //   435: invokestatic 377	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   438: putfield 382	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   441: invokestatic 716	java/lang/System:currentTimeMillis	()J
    //   444: lstore 11
    //   446: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +40 -> 489
    //   452: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   455: iconst_2
    //   456: new 62	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 925
    //   466: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: lload 11
    //   471: lload 9
    //   473: lsub
    //   474: invokevirtual 806	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   477: ldc_w 808
    //   480: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: aload 7
    //   491: iconst_0
    //   492: putfield 773	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_b_of_type_Boolean	Z
    //   495: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   498: ifeq -375 -> 123
    //   501: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   504: iconst_2
    //   505: new 62	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   512: ldc_w 927
    //   515: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload 7
    //   520: getfield 382	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   523: invokevirtual 930	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   526: ldc_w 932
    //   529: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 7
    //   534: getfield 482	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_Boolean	Z
    //   537: invokevirtual 680	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   540: ldc_w 934
    //   543: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 7
    //   548: getfield 773	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_b_of_type_Boolean	Z
    //   551: invokevirtual 680	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   554: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload 7
    //   562: areturn
    //   563: bipush 7
    //   565: iload_2
    //   566: if_icmpne +38 -> 604
    //   569: aload_3
    //   570: new 62	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 936
    //   580: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload_1
    //   584: iconst_0
    //   585: invokevirtual 647	java/lang/String:charAt	(I)C
    //   588: invokestatic 653	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   591: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokevirtual 908	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   600: astore_3
    //   601: goto -358 -> 243
    //   604: aload_3
    //   605: new 62	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   612: ldc_w 938
    //   615: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload_1
    //   619: iconst_0
    //   620: invokevirtual 647	java/lang/String:charAt	(I)C
    //   623: invokestatic 653	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   626: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokevirtual 908	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   635: astore_3
    //   636: goto -393 -> 243
    //   639: astore_3
    //   640: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   643: ifeq -327 -> 316
    //   646: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   649: iconst_2
    //   650: aload_3
    //   651: invokevirtual 878	java/io/IOException:getMessage	()Ljava/lang/String;
    //   654: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   657: goto -341 -> 316
    //   660: astore_3
    //   661: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   664: ifeq -348 -> 316
    //   667: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   670: iconst_2
    //   671: aload_3
    //   672: invokevirtual 442	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   675: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: goto -362 -> 316
    //   681: astore_1
    //   682: aload 8
    //   684: monitorexit
    //   685: aload_1
    //   686: athrow
    //   687: aload 7
    //   689: aload_0
    //   690: aload_1
    //   691: iconst_0
    //   692: invokevirtual 940	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(Ljava/lang/String;Z)Landroid/graphics/Bitmap;
    //   695: putfield 382	com/tencent/mobileqq/app/IndividualRedPacketManager$FontBitmap:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   698: invokestatic 716	java/lang/System:currentTimeMillis	()J
    //   701: lstore 11
    //   703: invokestatic 333	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   706: ifeq -217 -> 489
    //   709: getstatic 60	com/tencent/mobileqq/app/IndividualRedPacketManager:jdField_s_of_type_JavaLangString	Ljava/lang/String;
    //   712: iconst_2
    //   713: new 62	java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   720: ldc_w 942
    //   723: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: lload 11
    //   728: lload 9
    //   730: lsub
    //   731: invokevirtual 806	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   734: ldc_w 808
    //   737: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 409	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: goto -257 -> 489
    //   749: aconst_null
    //   750: astore_3
    //   751: aload 5
    //   753: astore 4
    //   755: goto -343 -> 412
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	758	0	this	IndividualRedPacketManager
    //   0	758	1	paramString	String
    //   0	758	2	paramInt	int
    //   69	190	3	localObject1	Object
    //   298	12	3	localOutOfMemoryError	OutOfMemoryError
    //   346	290	3	localObject2	Object
    //   639	12	3	localIOException	IOException
    //   660	12	3	localException	Exception
    //   750	1	3	localObject3	Object
    //   325	429	4	localObject4	Object
    //   24	728	5	localObject5	Object
    //   369	33	6	str	String
    //   12	676	7	localFontBitmap	IndividualRedPacketManager.FontBitmap
    //   3	726	9	l1	long
    //   444	283	11	l2	long
    // Exception table:
    //   from	to	target	type
    //   211	243	298	java/lang/OutOfMemoryError
    //   243	295	298	java/lang/OutOfMemoryError
    //   569	601	298	java/lang/OutOfMemoryError
    //   604	636	298	java/lang/OutOfMemoryError
    //   211	243	639	java/io/IOException
    //   243	295	639	java/io/IOException
    //   569	601	639	java/io/IOException
    //   604	636	639	java/io/IOException
    //   211	243	660	java/lang/Exception
    //   243	295	660	java/lang/Exception
    //   569	601	660	java/lang/Exception
    //   604	636	660	java/lang/Exception
    //   336	344	681	finally
    //   347	359	681	finally
    //   359	390	681	finally
    //   397	409	681	finally
    //   412	415	681	finally
    //   682	685	681	finally
  }
  
  public IndividualRedPacketResDownloader a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader = new IndividualRedPacketResDownloader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$AfterDownloadCallback);
    }
    return this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader;
  }
  
  public String a()
  {
    String str1 = String.valueOf(this.jdField_q_of_type_Int);
    String str2 = this.r;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_s_of_type_JavaLangString, 2, "getSendCombineImg: templateId = " + str1 + ";name = " + str2);
    }
    if (c())
    {
      Object localObject1 = a(str1, str2, 15);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_s_of_type_JavaLangString, 2, "getSendCombineImg templateId = " + str1 + "; name = " + str2 + "; combinefilename = " + (String)localObject1);
        }
        return (String)localObject1;
      }
      localObject1 = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)a().jdField_a_of_type_JavaUtilMap.get(str1);
      if (localObject1 == null)
      {
        QLog.e(jdField_s_of_type_JavaLangString, 1, "getSendCombineImg info = null ; templateId = " + str1 + "; name = " + str2);
        return null;
      }
      Object localObject2 = a(str1, "", 14, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_Int);
      Object localObject3 = new File((String)localObject2);
      if (!((File)localObject3).exists())
      {
        Object localObject4 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_c_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo;
        if (localObject4 == null)
        {
          QLog.e(jdField_s_of_type_JavaLangString, 1, "getSendCombineImg filenot exists senddecorate = null; templateId = " + str1 + ";name = " + str2);
          return null;
        }
        localObject4 = ((IndividualRedPacketResDownloader.DecorateInfo)localObject4).jdField_d_of_type_JavaLangString;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          QLog.e(jdField_s_of_type_JavaLangString, 1, "getSendCombineImg filenot exists url is empty; templateId = " + str1 + ";name = " + str2);
          return null;
        }
        int i1 = DownloaderFactory.a(new DownloadTask((String)localObject4, (File)localObject3), null);
        if (i1 != 0)
        {
          QLog.e(jdField_s_of_type_JavaLangString, 1, "getSendCombineImg filenot exists download bg faile; templateId = " + str1 + ";name = " + str2 + "; downloadresult = " + i1);
          return null;
        }
      }
      if (!((File)localObject3).exists())
      {
        QLog.e(jdField_s_of_type_JavaLangString, 1, "getSendCombineImg filenot exists file not exists 2222; templateId = " + str1 + ";name = " + str2);
        return null;
      }
      if (((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_Int == IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_c_of_type_Int) {
        return (String)localObject2;
      }
      localObject2 = a(str2, 15);
      if (localObject2 == null)
      {
        QLog.e(jdField_s_of_type_JavaLangString, 1, "getSendCombineImg fontImg = null ; templateId = " + str1 + "; name = " + str2);
        return null;
      }
      if (((IndividualRedPacketManager.FontBitmap)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_s_of_type_JavaLangString, 2, "getSendCombineImg savefontimg");
        }
        a(((IndividualRedPacketManager.FontBitmap)localObject2).jdField_a_of_type_AndroidGraphicsBitmap, str1, str2, 4);
      }
      localObject3 = a((IndividualRedPacketManager.FontBitmap)localObject2, str1, str2, 15);
      if (localObject3 != null)
      {
        if (((IndividualRedPacketManager.FontBitmap)localObject2).jdField_b_of_type_Boolean)
        {
          a((Bitmap)localObject3, str1, str2, 15);
          return a(str1, str2, 15, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_d_of_type_Int, IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int);
        }
        a((Bitmap)localObject3, str1, str2, 15);
        return a(str1, str2, 15, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_d_of_type_Int, IndividualRedPacketResDownloader.RedPacketTemplateInfo.jdField_b_of_type_Int);
      }
      return null;
    }
    QLog.e(jdField_s_of_type_JavaLangString, 1, "getSendCombineImg not allowshowredpacket templateId =" + str1 + ";name = " + str2);
    return null;
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (c()) {
      return a(paramString1, paramString2, 7);
    }
    return null;
  }
  
  public String a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject1 = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)a().jdField_a_of_type_JavaUtilMap.get(paramString1);
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_s_of_type_JavaLangString, 2, "getLocalImg fail! can't find template templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
        }
        localObject2 = null;
      }
    }
    for (;;)
    {
      return (String)localObject2;
      localObject1 = a(paramString1, paramString2, paramInt, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_d_of_type_Int, ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject1).jdField_a_of_type_Int);
      label107:
      localObject2 = this.jdField_a_of_type_JavaUtilLinkedList;
      if (localObject1 != null) {}
      try
      {
        if (this.jdField_a_of_type_JavaUtilLinkedList.contains(localObject1))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_s_of_type_JavaLangString, 2, "getLocalImg fail! file Saving! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
          }
          return null;
          localObject1 = a("", paramString2, paramInt, 0, 0);
          break label107;
        }
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          ((File)localObject2).setLastModified(NetConnInfoCenter.getServerTimeMillis());
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(jdField_s_of_type_JavaLangString, 2, "getLocalImg success! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
          return (String)localObject1;
        }
      }
      finally {}
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_s_of_type_JavaLangString, 2, "getLocalImg fail! file not exists! templateId = " + paramString1 + " name = " + paramString2 + "type = " + paramInt);
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_s_of_type_JavaLangString, 2, "IndividualRedPacketManager.setRedPacketFlags iCanUseRed:" + paramInt1 + ", iRedDisable:" + paramInt2 + ", isUpdate:" + paramBoolean + ", this.iCanUseRed:" + this.jdField_o_of_type_Int + ", this.iRedDisable:" + this.jdField_p_of_type_Int);
    }
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = this.jdField_o_of_type_Int;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = this.jdField_p_of_type_Int;
    }
    if ((this.jdField_o_of_type_Int != i1) || (this.jdField_p_of_type_Int != paramInt1))
    {
      this.jdField_o_of_type_Int = i1;
      this.jdField_p_of_type_Int = paramInt1;
      if (paramBoolean)
      {
        SharedPreferences localSharedPreferences = a();
        localSharedPreferences.edit().putInt("sp_vip_info_can_use_packet", i1);
        localSharedPreferences.edit().putInt("sp_vip_info_red_packet_disable", paramInt1);
        localSharedPreferences.edit().commit();
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_s_of_type_JavaLangString, 2, "setRedpacketInfo redpacketId = " + paramInt + "; redpacketText = " + paramString);
    }
    this.jdField_q_of_type_Int = paramInt;
    this.r = paramString;
    SharedPreferences localSharedPreferences = a();
    localSharedPreferences.edit().putInt("sp_vip_info_red_packet_id", paramInt);
    localSharedPreferences.edit().putString("sp_vip_info_red_packet_text", paramString);
    localSharedPreferences.edit().commit();
  }
  
  public void a(Bitmap arg1, String paramString1, String arg3, int paramInt)
  {
    int i2 = 0;
    a();
    Object localObject;
    if (!TextUtils.isEmpty(paramString1))
    {
      localObject = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)a().jdField_a_of_type_JavaUtilMap.get(paramString1);
      if (localObject != null) {
        i2 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject).jdField_d_of_type_Int;
      }
    }
    for (int i1 = ((IndividualRedPacketResDownloader.RedPacketTemplateInfo)localObject).jdField_a_of_type_Int;; i1 = 0)
    {
      if ((paramInt == 5) && (a().jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).contains(???))) {}
      label316:
      do
      {
        do
        {
          do
          {
            return;
            paramString1 = a(paramString1, ???, paramInt, i2, i1);
            if (TextUtils.isEmpty(paramString1)) {
              break label316;
            }
            localObject = new File(paramString1);
            if (!((File)localObject).exists()) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e(jdField_s_of_type_JavaLangString, 2, "saveBitmap exists saveAddress:" + paramString1);
          return;
        } while (??? == null);
        synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.add(paramString1);
        }
        try
        {
          ??? = new BufferedOutputStream(new FileOutputStream((File)localObject));
          ???.compress(Bitmap.CompressFormat.PNG, 90, ???);
          ???.flush();
          ???.close();
          synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
          {
            this.jdField_a_of_type_JavaUtilLinkedList.remove(paramString1);
            return;
          }
          ??? = finally;
          throw ???;
        }
        catch (FileNotFoundException ???)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_s_of_type_JavaLangString, 2, "saveBitmap exception " + ???.getMessage());
            }
          }
        }
        catch (IOException ???)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_s_of_type_JavaLangString, 2, "saveBitmap exception " + ???.getMessage());
            }
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e(jdField_s_of_type_JavaLangString, 2, "saveBitmap saveAddress == null ");
      return;
    }
  }
  
  public void a(IndividualRedPacketResDownloader.Char300Info paramChar300Info)
  {
    if ((!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) || (paramChar300Info.jdField_a_of_type_Int == 0)) {}
    do
    {
      do
      {
        return;
      } while ((TextUtils.isEmpty(paramChar300Info.jdField_a_of_type_JavaLangString)) || (!IndividualRedPacketResDownloader.a(a().jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo)));
      if (a().getInt(n, 0) >= paramChar300Info.jdField_c_of_type_Int)
      {
        QLog.d(jdField_s_of_type_JavaLangString, 1, "preCreatePersonalFontImg count >= " + paramChar300Info.jdField_c_of_type_Int);
        return;
      }
    } while ((!b()) || (!this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)));
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.a("RedPacketPrecreate", 19);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$PrecreateRunnable = new IndividualRedPacketManager.PrecreateRunnable(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChar300Info);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$PrecreateRunnable);
    this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$PrecreateRunnable.a();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_s_of_type_JavaLangString, 2, "onDoneDownloadBG id = " + paramString + ", resType:" + paramInt);
    }
    if (paramInt == 2) {
      paramInt = 6;
    }
    CustomizeStrategyFactory.RedPacketInfo localRedPacketInfo;
    IndividualRedPacketManager.FontBitmap localFontBitmap;
    Bitmap localBitmap;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        localRedPacketInfo = (CustomizeStrategyFactory.RedPacketInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if (localRedPacketInfo == null) {
          break label259;
        }
        localFontBitmap = a(localRedPacketInfo.jdField_b_of_type_JavaLangString, paramInt);
        localBitmap = a(localFontBitmap, localRedPacketInfo, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_s_of_type_JavaLangString, 2, "onDoneDownloadBG type = " + paramInt);
        }
        if ((localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localFontBitmap.jdField_a_of_type_Boolean)) {
          a(localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap, "", localRedPacketInfo.jdField_b_of_type_JavaLangString, 5);
        }
        if (paramInt != 7) {
          break label210;
        }
        return;
      }
      if (paramInt == 3)
      {
        paramInt = 7;
      }
      else
      {
        if (paramInt != 14) {
          break;
        }
        paramInt = 15;
      }
    }
    label210:
    if ((localFontBitmap.jdField_a_of_type_AndroidGraphicsBitmap != null) && (localBitmap != null))
    {
      if (localFontBitmap.jdField_b_of_type_Boolean) {
        break label262;
      }
      a(localBitmap, localRedPacketInfo.jdField_a_of_type_JavaLangString, localRedPacketInfo.jdField_b_of_type_JavaLangString, paramInt);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      label259:
      return;
      label262:
      if (paramInt == 6) {
        a(localBitmap, localRedPacketInfo.jdField_a_of_type_JavaLangString, localRedPacketInfo.jdField_b_of_type_JavaLangString, 12);
      }
    }
  }
  
  public void a(String paramString, Bundle paramBundle, MessengerService paramMessengerService)
  {
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)a().jdField_a_of_type_JavaUtilMap.get(paramString);
    int i2 = u;
    int i1 = i2;
    if (localRedPacketTemplateInfo != null)
    {
      i1 = i2;
      if (!TextUtils.isEmpty(paramString)) {
        if (new File(a(paramString, "", 2, localRedPacketTemplateInfo.jdField_d_of_type_Int, localRedPacketTemplateInfo.jdField_a_of_type_Int)).exists()) {
          i1 = t;
        }
      }
    }
    for (;;)
    {
      paramString = new Bundle();
      paramString.putInt("result", i1);
      paramBundle.putBundle("response", paramString);
      paramMessengerService.a(paramBundle);
      return;
      i1 = u;
      a().a(localRedPacketTemplateInfo.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$DecorateInfo, null);
    }
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, MessengerService paramMessengerService)
  {
    ThreadManager.a(new pze(this, paramString1, paramString2, paramBundle, paramMessengerService), 8, null, true);
  }
  
  public boolean a()
  {
    return (this.jdField_o_of_type_Int == 1) && (this.jdField_p_of_type_Int == 0);
  }
  
  public void b()
  {
    int i2 = 0;
    if (!a().getString(jdField_p_of_type_JavaLangString, "").equals(a().jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_s_of_type_JavaLangString, 2, "Clear SDCard Cache Start!");
      }
      Object localObject = new File(jdField_g_of_type_JavaLangString);
      int i1;
      File localFile;
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).listFiles();
        i1 = 0;
        while (i1 < localObject.length)
        {
          localFile = new File(localObject[i1].getParent() + File.separator + System.currentTimeMillis());
          localObject[i1].renameTo(localFile);
          localFile.delete();
          i1 += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_s_of_type_JavaLangString, 2, "Clear " + jdField_g_of_type_JavaLangString + " done!");
        }
      }
      localObject = new File(jdField_h_of_type_JavaLangString);
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).listFiles();
        i1 = 0;
        while (i1 < localObject.length)
        {
          localFile = new File(localObject[i1].getParent() + File.separator + System.currentTimeMillis());
          localObject[i1].renameTo(localFile);
          localFile.delete();
          i1 += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_s_of_type_JavaLangString, 2, "Clear " + jdField_h_of_type_JavaLangString + " done!");
        }
      }
      localObject = new File(jdField_i_of_type_JavaLangString);
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).listFiles();
        i1 = 0;
        while (i1 < localObject.length)
        {
          localFile = new File(localObject[i1].getParent() + File.separator + System.currentTimeMillis());
          localObject[i1].renameTo(localFile);
          localFile.delete();
          i1 += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_s_of_type_JavaLangString, 2, "Clear " + jdField_i_of_type_JavaLangString + " done!");
        }
      }
      localObject = new File(j);
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).listFiles();
        i1 = 0;
        while (i1 < localObject.length)
        {
          localFile = new File(localObject[i1].getParent() + File.separator + System.currentTimeMillis());
          localObject[i1].renameTo(localFile);
          localFile.delete();
          i1 += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_s_of_type_JavaLangString, 2, "Clear " + j + " done!");
        }
      }
      localObject = new File(k);
      if (((File)localObject).exists())
      {
        localObject = ((File)localObject).listFiles();
        i1 = i2;
        while (i1 < localObject.length)
        {
          localFile = new File(localObject[i1].getParent() + File.separator + System.currentTimeMillis());
          localObject[i1].renameTo(localFile);
          localFile.delete();
          i1 += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_s_of_type_JavaLangString, 2, "Clear " + k + " done!");
        }
      }
      a().edit().putString(jdField_p_of_type_JavaLangString, a().jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$RedPacketResInfo.jdField_c_of_type_JavaLangString).commit();
    }
  }
  
  public boolean b()
  {
    return this.jdField_p_of_type_Int == 0;
  }
  
  public void c()
  {
    ThreadManager.a(new pzb(this), 5, null, true);
  }
  
  public boolean c()
  {
    return (b()) && (a().jdField_a_of_type_Boolean);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread.interrupt();
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$PrecreateRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_d_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\IndividualRedPacketManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */