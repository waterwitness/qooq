package com.tencent.mobileqq.video;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.TicketManager;
import wfs;
import wft;
import wfu;

public class VipVideoPlayActivity
  extends IphoneTitleBarActivity
{
  public static final byte a = 100;
  public static final int a = 0;
  public static final String a = "VipVideoPlayActivity";
  public static final int b = 1;
  public static final String b = "vid";
  public static final int c = 2;
  public static final String c = "video_url";
  public static final int d = 3;
  public static final String d = "video_url_cookies";
  public static final int e = 4;
  public static final String e = "vtype";
  public static final String f = "videoFormat";
  public static final String g = "screenOrientation";
  public static final String h = "sensor_auto";
  public static final String i = "portrait";
  public static final String j = "landscape";
  public static final String k = "play_open";
  public static final String l = "play_initfail";
  public static final String m = "play_start";
  public static final String n = "play_success";
  public static final String o = "play_error";
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  private long b;
  private int f;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  
  public VipVideoPlayActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.b = SystemClock.elapsedRealtime();
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "video play initviews");
    }
    try
    {
      if (!TextUtils.equals(this.t, "sensor_auto")) {
        if (!TextUtils.equals(this.t, "portrait")) {
          break label381;
        }
      }
      label381:
      for (int i1 = 1;; i1 = 0)
      {
        setRequestedOrientation(i1);
        setContentViewNoTitle(2130904637);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory == null) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131303410));
        this.jdField_a_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(getApplication()));
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
        Object localObject = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView);
        long l1 = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getApplication(), (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
        long l2 = System.currentTimeMillis();
        if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.attachDanmuView();
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnControllerClickListener(new wfs(this));
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new wfu(this));
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new wft(this));
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.attachControllerView();
        long l3 = System.currentTimeMillis();
        localObject = null;
        if (!TextUtils.isEmpty(this.r))
        {
          localObject = new HashMap();
          ((Map)localObject).put("cookies", this.r);
        }
        a(this.p, (Map)localObject, this.q, this.s, this.f);
        long l4 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("VipVideoPlayActivity", 2, "initView time1 = " + (l2 - l1) + ", time2 = " + (l3 - l2) + ", time3 = " + (l4 - l3));
        }
        return 0;
      }
      return 2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("VipVideoPlayActivity", 2, "video play initviews exception=" + localException.getMessage());
      }
    }
    return 3;
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1 + "|");
      localStringBuilder.append(this.p + "|");
      localStringBuilder.append(this.q + "|");
      localStringBuilder.append(this.s + "|");
      localStringBuilder.append(this.f + "|");
      localStringBuilder.append(paramInt1 + "|");
      localStringBuilder.append(paramInt2 + "|");
      localStringBuilder.append(paramLong + "|");
      localStringBuilder.append(paramString2);
      DcReportUtil.a(null, "b_sng_qqvip_videosdk|mediaplay", localStringBuilder.toString(), true);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(String paramString1, Map paramMap, String paramString2, String paramString3, int paramInt)
  {
    TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo();
    Object localObject = new StringBuilder();
    TicketManager localTicketManager = (TicketManager)this.app.getManager(2);
    ((StringBuilder)localObject).append("luin=o0").append(this.app.a()).append(";");
    ((StringBuilder)localObject).append("uin=o0").append(this.app.a()).append(";");
    ((StringBuilder)localObject).append("skey=").append(localTicketManager.getSkey(this.app.a()));
    localTVK_UserInfo.setLoginCookie(((StringBuilder)localObject).toString());
    localTVK_UserInfo.setUin(this.app.a());
    this.b = SystemClock.elapsedRealtime();
    a("play_start", 0, 0, this.b - this.jdField_a_of_type_Long, "");
    localObject = new TVK_PlayerVideoInfo(paramInt, paramString1, "");
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(getApplication(), localTVK_UserInfo, (TVK_PlayerVideoInfo)localObject, paramString3, 0L, 0L);
    }
    while (TextUtils.isEmpty(paramString2)) {
      return;
    }
    ((TVK_PlayerVideoInfo)localObject).setPlayMode("yunbo");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getApplication(), paramString2, 0L, 0L, paramMap, localTVK_UserInfo, (TVK_PlayerVideoInfo)localObject);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    getWindow().setFlags(1024, 1024);
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    this.p = paramBundle.getStringExtra("vid");
    this.q = paramBundle.getStringExtra("video_url");
    this.r = paramBundle.getStringExtra("video_url_cookies");
    this.s = paramBundle.getStringExtra("videoFormat");
    this.t = paramBundle.getStringExtra("screenOrientation");
    this.f = paramBundle.getIntExtra("vtype", 0);
    a("play_open", 0, 0, 0L, "");
    if (((TextUtils.isEmpty(this.p)) && (TextUtils.isEmpty(this.q))) || ((!TextUtils.isEmpty(this.p)) && (TextUtils.isEmpty(this.s))) || (this.f <= 0))
    {
      a("play_initfail", 4, -1, 0L, "");
      setResult(4);
      finish();
    }
    if (VipVideoManager.a(getApplication()))
    {
      int i1 = a();
      if (i1 != 0)
      {
        a("play_initfail", i1, -1, 0L, "");
        setResult(i1);
        finish();
        return false;
      }
      return true;
    }
    a("play_initfail", 1, -1, 0L, "");
    setResult(1);
    finish();
    return false;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "doOnDestroy()");
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected boolean onBackEvent()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipVideoPlayActivity", 2, "onBackEvent++++++++++++++++++++++");
    }
    if (getRequestedOrientation() == 0)
    {
      setRequestedOrientation(1);
      return true;
    }
    return super.onBackEvent();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\video\VipVideoPlayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */