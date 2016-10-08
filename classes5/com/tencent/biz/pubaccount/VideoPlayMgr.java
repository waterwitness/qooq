package com.tencent.biz.pubaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyVideoReportData;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.VideoPlayUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover.DownLoad;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavBuilder;
import hrr;
import hrs;
import hru;
import hrw;
import hrx;
import hry;
import hrz;
import hsa;
import hsb;
import hse;
import hsf;
import hsh;
import hsi;
import hsj;
import hsk;
import hsl;
import hsn;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import mqq.os.MqqHandler;

public class VideoPlayMgr
  implements View.OnClickListener
{
  public static final long a = 104857600L;
  public static final String a = "Q.pubaccount.video.VideoPlayMgr";
  public static boolean a = false;
  public static final int b = 1;
  public static final String b = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  public static final int c = 2;
  public static final String c = "1";
  public static final int d = 3;
  public static final int e = 4;
  public int a;
  public Activity a;
  public Context a;
  public Bundle a;
  public Handler a;
  public ViewGroup a;
  public SeekBar a;
  public TextView a;
  private ThirdVidoeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager;
  private ReadinjoyVideoReportData jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
  public QQAppInterface a;
  public TVK_IMediaPlayer a;
  public TVK_IProxyFactory a;
  public TVK_PlayerVideoInfo a;
  public TVK_UserInfo a;
  public IVideoViewBase a;
  public hsn a;
  public Timer a;
  public long b;
  public TextView b;
  public Timer b;
  public boolean b;
  public boolean c;
  public String d;
  public boolean d;
  private String e;
  public boolean e;
  public int f;
  public boolean f;
  public boolean g;
  private boolean h;
  
  public VideoPlayMgr(Context paramContext, Activity paramActivity, QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 2;
    this.f = -1;
    this.jdField_d_of_type_JavaLangString = "1";
    this.h = true;
    this.jdField_a_of_type_AndroidOsHandler = new hsh(this);
    VideoVolumeControl.a().a(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903495, null));
    q();
  }
  
  private boolean a(String paramString, TVK_UserInfo paramTVK_UserInfo, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    String[] arrayOfString = new String[6];
    arrayOfString[0] = "msd";
    arrayOfString[1] = "hd";
    arrayOfString[2] = "fhd";
    arrayOfString[3] = "mp4";
    arrayOfString[4] = "shd";
    arrayOfString[5] = "sd";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      int k = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isVideoCached(this.jdField_a_of_type_AndroidContentContext, paramString, paramTVK_UserInfo, paramTVK_PlayerVideoInfo, str);
      if ((k == 2) || (k == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "checkIsVideoCached(), definition = " + str + ", cacheStatus = " + k + ", return TRUE");
        }
        return true;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "checkIsVideoCached() return FALSE");
    }
    return false;
  }
  
  private void q()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localObject = (RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298803);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
      localLayoutParams.topMargin = ImmersiveUtils.a(this.jdField_a_of_type_AndroidContentContext);
      ((RelativeLayout)localObject).setLayoutParams(localLayoutParams);
    }
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_BIZ_SOURCE_DYH");
    Object localObject = (SeekBar)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298795);
    ((SeekBar)localObject).setOnSeekBarChangeListener(new hrr(this));
    long l2 = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION");
    try
    {
      l1 = Long.valueOf(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TIME")).longValue();
      l1 *= 1000L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = 0L;
      }
    }
    if ((l2 > 0L) && (l1 > 0L) && (l2 < l1)) {
      ((SeekBar)localObject).setProgress((int)(l2 / l1 * 100.0D));
    }
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298799)).setOnClickListener(this);
    ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298800)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298805).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298806).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298807).setOnClickListener(this);
    d();
  }
  
  /* Error */
  private void r()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: getfield 86	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   9: ifnull +10 -> 19
    //   12: aload_0
    //   13: getfield 139	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   16: ifnonnull +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: getfield 86	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   24: ldc_w 267
    //   27: invokevirtual 215	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   33: ifne +280 -> 313
    //   36: aload_0
    //   37: getfield 86	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   40: ldc_w 267
    //   43: invokevirtual 215	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   46: invokestatic 278	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   49: invokevirtual 281	java/lang/Integer:intValue	()I
    //   52: istore_2
    //   53: aload_0
    //   54: getfield 86	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   57: ldc_w 283
    //   60: invokevirtual 215	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokestatic 273	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifne +20 -> 86
    //   69: aload_0
    //   70: getfield 86	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   73: ldc_w 283
    //   76: invokevirtual 215	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 278	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   82: invokevirtual 281	java/lang/Integer:intValue	()I
    //   85: istore_3
    //   86: iload_2
    //   87: ifeq +7 -> 94
    //   90: iload_3
    //   91: ifne +47 -> 138
    //   94: aload_0
    //   95: getfield 86	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   98: ldc_w 267
    //   101: aload_0
    //   102: getfield 139	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   105: invokeinterface 286 1 0
    //   110: invokestatic 289	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   113: invokevirtual 293	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield 86	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   120: ldc_w 283
    //   123: aload_0
    //   124: getfield 139	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   127: invokeinterface 296 1 0
    //   132: invokestatic 289	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   135: invokevirtual 293	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -122 -> 19
    //   144: ldc 13
    //   146: iconst_2
    //   147: new 153	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 298
    //   157: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload_0
    //   161: getfield 139	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   164: invokeinterface 286 1 0
    //   169: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: ldc_w 300
    //   175: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: getfield 139	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   182: invokeinterface 296 1 0
    //   187: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 303	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: return
    //   197: astore_1
    //   198: iload 4
    //   200: istore_2
    //   201: iload_2
    //   202: ifeq +3 -> 205
    //   205: aload_0
    //   206: getfield 86	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   209: ldc_w 267
    //   212: aload_0
    //   213: getfield 139	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   216: invokeinterface 286 1 0
    //   221: invokestatic 289	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   224: invokevirtual 293	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_0
    //   228: getfield 86	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   231: ldc_w 283
    //   234: aload_0
    //   235: getfield 139	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   238: invokeinterface 296 1 0
    //   243: invokestatic 289	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   246: invokevirtual 293	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: goto -111 -> 138
    //   252: astore_1
    //   253: iconst_0
    //   254: istore_2
    //   255: iload_2
    //   256: ifeq +3 -> 259
    //   259: aload_0
    //   260: getfield 86	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   263: ldc_w 267
    //   266: aload_0
    //   267: getfield 139	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   270: invokeinterface 286 1 0
    //   275: invokestatic 289	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   278: invokevirtual 293	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_0
    //   282: getfield 86	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_AndroidOsBundle	Landroid/os/Bundle;
    //   285: ldc_w 283
    //   288: aload_0
    //   289: getfield 139	com/tencent/biz/pubaccount/VideoPlayMgr:jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   292: invokeinterface 296 1 0
    //   297: invokestatic 289	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   300: invokevirtual 293	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: aload_1
    //   304: athrow
    //   305: astore_1
    //   306: goto -51 -> 255
    //   309: astore_1
    //   310: goto -109 -> 201
    //   313: iconst_0
    //   314: istore_2
    //   315: goto -262 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	this	VideoPlayMgr
    //   197	1	1	localException1	Exception
    //   252	52	1	localObject1	Object
    //   305	1	1	localObject2	Object
    //   309	1	1	localException2	Exception
    //   52	263	2	i	int
    //   4	87	3	j	int
    //   1	198	4	k	int
    // Exception table:
    //   from	to	target	type
    //   20	53	197	java/lang/Exception
    //   20	53	252	finally
    //   53	86	305	finally
    //   53	86	309	java/lang/Exception
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      return this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0L;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public String a()
  {
    long l1 = TrafficStats.getTotalRxBytes();
    long l2 = l1 - this.jdField_b_of_type_Long;
    String str;
    if ((l2 >= 0L) && (l2 < 104857600L)) {
      if (l2 > 1024L) {
        str = l2 / 1024L + "KB/s";
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Long = l1;
      return "加载中... " + str;
      str = l2 + "Bytes/s";
      continue;
      str = "0Bytes/s";
    }
  }
  
  public String a(long paramLong)
  {
    return String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 1000L / 60L), Long.valueOf(paramLong / 1000L % 60L) });
  }
  
  public void a()
  {
    View localView = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298797);
    if (this.jdField_e_of_type_Boolean) {
      localView.setBackgroundResource(2130838917);
    }
    for (this.jdField_e_of_type_Boolean = false;; this.jdField_e_of_type_Boolean = true)
    {
      if (this.jdField_a_of_type_Hsn != null) {
        this.jdField_a_of_type_Hsn.b();
      }
      return;
      localView.setBackgroundResource(2130838918);
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong >= 2147483647L) {}
    do
    {
      return;
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298794));
      }
    } while (this.jdField_a_of_type_AndroidWidgetTextView == null);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(paramLong));
  }
  
  public void a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "changeVideo()");
    }
    if (paramBundle != null)
    {
      this.jdField_a_of_type_AndroidOsBundle = paramBundle;
      if ((this.jdField_a_of_type_AndroidOsBundle.containsKey("isFromKandian")) && (this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromKandian"))) {
        VideoReporter.a(this.jdField_a_of_type_AndroidOsBundle.getString("innderId"), (int)this.jdField_a_of_type_AndroidOsBundle.getLong("channelID", 0L), (int)this.jdField_a_of_type_AndroidOsBundle.getLong("algorithmID", 0L), (int)this.jdField_a_of_type_AndroidOsBundle.getLong("strategyId", 0L), 1, -1);
      }
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Boolean = true;
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long > 0L)
        {
          paramBundle = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
          paramBundle.jdField_b_of_type_Long += SystemClock.uptimeMillis() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Long;
        }
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidAppActivity, ReadInJoyUtils.a(), true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.a());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = null;
      }
      m();
      n();
      j();
      paramBundle = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298807);
      Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298808);
      ((View)localObject).setBackgroundResource(2130839554);
      if (VersionUtils.e()) {
        ((View)localObject).setAlpha(1.0F);
      }
      localObject = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298809);
      ((TextView)localObject).setText("收藏");
      if (VersionUtils.e()) {
        ((TextView)localObject).setAlpha(1.0F);
      }
      paramBundle.setClickable(true);
      paramBundle.setOnClickListener(this);
    }
  }
  
  public void a(hsn paramhsn)
  {
    this.jdField_a_of_type_Hsn = paramhsn;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_Boolean = true;
    e();
    if (this.jdField_b_of_type_JavaUtilTimer != null) {
      this.jdField_b_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298791);
    if (this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298802).getVisibility() == 0) {}
    do
    {
      return;
      if (((View)localObject).getVisibility() == 0) {
        ((View)localObject).setVisibility(8);
      }
      this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298787).setVisibility(0);
      localObject = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298788);
      ((ImageView)localObject).setBackgroundResource(2130839553);
      ((ImageView)localObject).clearAnimation();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, paramString, 1).a();
      ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298789)).setText("");
    } while (this.jdField_a_of_type_Hsn == null);
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_a_of_type_Hsn.b();
    }
    this.jdField_a_of_type_Hsn.e();
    paramString = this.jdField_a_of_type_Hsn;
    if (!this.jdField_e_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      paramString.a(0, bool);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "doOnAddFavourate() result=" + paramBoolean1 + ", needShowSuccessToast=" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298807);
      Object localObject2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298808);
      ((View)localObject2).setBackgroundResource(2130838912);
      if (VersionUtils.e()) {
        ((View)localObject2).setAlpha(0.5F);
      }
      localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298809);
      ((TextView)localObject2).setText("已收藏");
      if (VersionUtils.e()) {
        ((TextView)localObject2).setAlpha(0.5F);
      }
      ((View)localObject1).setClickable(false);
      if (paramBoolean2)
      {
        localObject1 = new QQToast(this.jdField_a_of_type_AndroidContentContext);
        ((QQToast)localObject1).c(2000);
        ((QQToast)localObject1).a(QQToast.a(2));
        ((QQToast)localObject1).b(2131365895);
        ((QQToast)localObject1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908) - (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 5.0F));
      }
      return;
    }
    Object localObject1 = new QQToast(this.jdField_a_of_type_AndroidContentContext);
    ((QQToast)localObject1).c(2000);
    ((QQToast)localObject1).a(QQToast.a(1));
    ((QQToast)localObject1).b(2131365903);
    ((QQToast)localObject1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492908) - (int)DisplayUtils.a(this.jdField_a_of_type_AndroidContentContext, 5.0F));
  }
  
  public boolean a()
  {
    return this.f == 0;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.VideoPlayMgr", 2, "initSDK() ");
    }
    if (!jdField_a_of_type_Boolean)
    {
      TVK_SDKMgr.initSdk(this.jdField_a_of_type_AndroidContentContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      jdField_a_of_type_Boolean = true;
    }
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext) == true)
    {
      g();
      return;
    }
    TVK_SDKMgr.installPlugin(this.jdField_a_of_type_AndroidContentContext, new hsb(this));
    c();
  }
  
  public void b(long paramLong)
  {
    if (paramLong >= 2147483647L) {
      return;
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298796));
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(a(paramLong));
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "doOnPause() isRealPause = " + paramBoolean + ", mVideoPlayStatus = " + this.f);
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.f = 1;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
    if (paramBoolean) {
      this.g = false;
    }
    f();
    ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298793)).setBackgroundResource(2130838928);
  }
  
  public boolean b()
  {
    return this.f == 2;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.VideoPlayMgr", 2, "startShowLoading() ");
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.pubaccount.video.VideoPlayMgr", 2, "startShowLoading: mHandler == null ");
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    if (this.jdField_b_of_type_JavaUtilTimer != null) {
      this.jdField_b_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_b_of_type_JavaUtilTimer = new Timer();
    this.jdField_b_of_type_JavaUtilTimer.schedule(new hse(this), 1000L, 1000L);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.VideoPlayMgr", 2, "startShowProgress() ");
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new hsf(this), 0L, 1000L);
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.VideoPlayMgr", 2, "stopShowLoading() mIsShowingErrorView=" + this.jdField_b_of_type_Boolean + ", mIsNeedShowLoading=" + this.h);
    }
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      return;
      this.h = false;
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.pubaccount.video.VideoPlayMgr", 2, "stopShowLoading: mHandler == null ");
    return;
    if (this.jdField_b_of_type_JavaUtilTimer != null)
    {
      this.jdField_b_of_type_JavaUtilTimer.cancel();
      this.jdField_b_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.VideoPlayMgr", 2, "stopShowProgress() ");
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    if (VersionUtils.d()) {}
    for (this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView_Scroll(this.jdField_a_of_type_AndroidContentContext);; this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(VideoVolumeControl.a().a());
      ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298741)).addView((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
      i();
      ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase).setOnClickListener(new hsi(this));
      j();
      return;
    }
  }
  
  public void h()
  {
    if (this.jdField_d_of_type_Boolean) {}
    while ((this.jdField_b_of_type_Boolean) || (this.c)) {
      return;
    }
    this.jdField_d_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298791);
    TranslateAnimation localTranslateAnimation;
    if (((View)localObject).getVisibility() == 0)
    {
      localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 0.0F, 1, 1.0F);
      localTranslateAnimation.setDuration(600L);
      ((View)localObject).startAnimation(localTranslateAnimation);
      localTranslateAnimation.setAnimationListener(new hsj(this, (View)localObject));
      if (this.jdField_a_of_type_Hsn != null)
      {
        localObject = this.jdField_a_of_type_Hsn;
        if (this.jdField_e_of_type_Boolean) {
          break label136;
        }
        bool = true;
        ((hsn)localObject).a(8, bool);
      }
    }
    label136:
    do
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new hsk(this), 600L);
      return;
      bool = false;
      break;
      ((View)localObject).setVisibility(0);
      localTranslateAnimation = new TranslateAnimation(0, 0.0F, 0, 0.0F, 1, 1.0F, 1, 0.0F);
      localTranslateAnimation.setDuration(600L);
      ((View)localObject).startAnimation(localTranslateAnimation);
    } while (this.jdField_a_of_type_Hsn == null);
    localObject = this.jdField_a_of_type_Hsn;
    if (!this.jdField_e_of_type_Boolean) {}
    for (boolean bool = true;; bool = false)
    {
      ((hsn)localObject).a(0, bool);
      break;
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new hsl(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new hrs(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new hru(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new hrw(this));
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnNetVideoInfoListener(new hrx(this));
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "startVideo() mBundle=" + this.jdField_a_of_type_AndroidOsBundle.toString());
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
      return;
    }
    this.g = true;
    if (this.c) {
      m();
    }
    if (this.jdField_b_of_type_Boolean) {
      n();
    }
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_ARTICLE_BUSITYPE");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData = new ReadinjoyVideoReportData();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.f = 2;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.e = SystemClock.uptimeMillis();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.c = SystemClock.uptimeMillis();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
      i();
      if (QLog.isColorLevel()) {
        QLog.i("Q.pubaccount.video.VideoPlayMgr", 2, "startVideo(): createMediaPlayer ");
      }
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo("", "");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), "");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    Object localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_FILE_SIZE");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("filesize", (String)localObject1);
    localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_TIME");
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "";
    }
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("duration", (String)localObject1);
    localObject1 = new HashMap();
    ((Map)localObject1).put("shouq_bus_type", "bus_type_full_screen");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setReportInfoMap((Map)localObject1);
    this.jdField_e_of_type_JavaLangString = VideoPlayUtils.a();
    long l;
    if ((i == 2) || (a(null, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo)))
    {
      this.h = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new hry(this), 1000L);
      l = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION", 0L);
      if (2 != i) {
        break label564;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager = ThirdVidoeManager.a();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager.a(new hrz(this, l));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager.a(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOutputMute(VideoVolumeControl.a().a());
      PublicAccountUtil.a(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_ARTICLE_ID"), this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"), 0, 0);
      this.f = -1;
      this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298793).setBackgroundResource(2130838927);
      localObject1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298810);
      if (1 != i) {
        break label605;
      }
      ((View)localObject1).setVisibility(8);
      return;
      c();
      break;
      label564:
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setPlayMode("cache_video");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, this.jdField_e_of_type_JavaLangString, l, 0L);
    }
    label605:
    ((View)localObject1).setVisibility(0);
    localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298812);
    ((ImageView)localObject2).setBackgroundDrawable(ImageUtil.b());
    new StructMsgItemCover.DownLoad((ImageView)localObject2, this.jdField_a_of_type_AndroidAppActivity).execute(new String[] { this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ICON") });
    ((TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298813)).setText(this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_NAME"));
    ((View)localObject1).setOnClickListener(this);
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "doOnResume() mIsStartPlaying = " + this.g);
    }
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.g))
    {
      this.f = 0;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298793)).setBackgroundResource(2130838927);
    }
    d();
  }
  
  public void l()
  {
    boolean bool = true;
    e();
    Object localObject = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298791);
    View localView1 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298802);
    View localView2 = this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298787);
    ((View)localObject).setVisibility(8);
    localView2.setVisibility(8);
    localView1.setVisibility(0);
    this.c = true;
    if (this.jdField_a_of_type_Hsn != null)
    {
      this.jdField_a_of_type_Hsn.c();
      localObject = this.jdField_a_of_type_Hsn;
      if (this.jdField_e_of_type_Boolean) {
        break label100;
      }
    }
    for (;;)
    {
      ((hsn)localObject).a(0, bool);
      return;
      label100:
      bool = false;
    }
  }
  
  public void m()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298802).setVisibility(8);
    this.c = false;
    if (this.jdField_a_of_type_Hsn != null) {
      this.jdField_a_of_type_Hsn.d();
    }
  }
  
  public void n()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298787).setVisibility(8);
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "doOnDestory()");
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    ThreadManager.a().post(new hsa(this, localTVK_IMediaPlayer));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVidoeManager.a();
    }
    if (this.jdField_b_of_type_JavaUtilTimer != null)
    {
      this.jdField_b_of_type_JavaUtilTimer.cancel();
      this.jdField_b_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_Hsn = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    VideoVolumeControl.a().b(this);
  }
  
  public void onClick(View paramView)
  {
    String str;
    switch (paramView.getId())
    {
    case 2131298801: 
    case 2131298802: 
    case 2131298803: 
    case 2131298804: 
    case 2131298808: 
    case 2131298809: 
    default: 
    case 2131298810: 
      do
      {
        return;
        str = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_ACTION");
      } while (TextUtils.isEmpty(str));
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.VideoPlayMgr", 2, "onClick textview_ending_account_name url:" + str);
      }
      paramView = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_THIRD_NAME");
      if (paramView == null) {
        paramView = "";
      }
      break;
    }
    for (;;)
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PublicAccountBrowser.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      localIntent.putExtra("title", paramView);
      localIntent.putExtra("url", str);
      localIntent.putExtra("assignBackText", this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131367975));
      this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      ReportController.b(null, "CliOper", "", "", "0X8006697", "0X8006697", 0, 0, paramView.hashCode() + "", "", "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
      return;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
        break;
      }
      paramView = (Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298793);
      if (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())
      {
        this.jdField_a_of_type_AndroidAppActivity.getWindow().addFlags(128);
        paramView.setBackgroundResource(2130838927);
        this.g = true;
        k();
        return;
      }
      this.jdField_a_of_type_AndroidAppActivity.getWindow().clearFlags(128);
      paramView.setBackgroundResource(2130838928);
      this.g = false;
      this.f = 1;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      ReportController.b(null, "CliOper", "", "", "0X800675F", "0X800675F", 0, 0, "", this.jdField_d_of_type_JavaLangString, "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructReadinjoyVideoReportData;
      paramView.g += 1;
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X800709A", "0X800709A", 0, 0, "", "", "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
      return;
      a();
      ((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298791)).setVisibility(8);
      if (!this.jdField_e_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X8006769", "0X8006769", 0, 0, "", this.jdField_d_of_type_JavaLangString, "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X8006761", "0X8006761", 0, 0, "", "", this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
      return;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
        break;
      }
      this.jdField_a_of_type_AndroidOsBundle.putLong("VIDEO_PLAY_POSITION", 0L);
      j();
      if (this.jdField_a_of_type_Hsn == null) {
        break;
      }
      this.jdField_a_of_type_Hsn.a(8, true);
      return;
      if (this.jdField_a_of_type_Hsn != null) {
        this.jdField_a_of_type_Hsn.g();
      }
      if (this.jdField_e_of_type_Boolean)
      {
        ReportController.b(null, "CliOper", "", "", "0X800676A", "0X800676A", 0, 0, "", "", this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
        return;
      }
      ReportController.b(null, "CliOper", "", "", "0X800675D", "0X800675D", 0, 0, "", this.jdField_d_of_type_JavaLangString, "", this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_VID"));
      return;
      paramView = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_H5_URL");
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      QfavBuilder.a(paramView).c(str).a(this.jdField_a_of_type_AndroidAppActivity, str, 100, null);
      return;
    }
  }
  
  public void p()
  {
    if (((ViewGroup)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131298791)).getVisibility() == 0) {
      h();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\VideoPlayMgr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */