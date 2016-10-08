package com.tencent.mobileqq.activity.richmedia;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.graphics.Color;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.util.HashMap;
import mqq.os.MqqHandler;
import pcr;
import pcs;
import pct;
import pcv;
import pcx;
import pcy;
import pcz;

public class PTVOperatingGuideActivity
  extends FlowActivity
  implements View.OnClickListener, FileTransferManager.Callback, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnVideoPreparingListener
{
  public static final String a = "PTVOperatingGuide";
  public static final String b = "ptvTeachClick";
  public static final String c = "PTVOperatingGuide";
  private static final String jdField_d_of_type_JavaLangString = "state_play_position";
  private long jdField_a_of_type_Long;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private TVK_IMediaPlayer jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
  private TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory;
  public final MqqHandler a;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  public boolean b;
  boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  boolean jdField_e_of_type_Boolean;
  private boolean f;
  private boolean g;
  
  public PTVOperatingGuideActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_b_of_type_Boolean = false;
    this.d = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new pcr(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new pcs(this);
  }
  
  private void a(Dialog paramDialog)
  {
    if (!isFinishing()) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog) {}
  }
  
  private void i()
  {
    File localFile = new File(this.jdField_e_of_type_JavaLangString);
    if (localFile.exists())
    {
      long l = localFile.length();
      if (QLog.isColorLevel()) {
        QLog.d("PTVOperatingGuide", 2, "onCreateVideoSdkView(), #PLAY_CALLER_SHORT_VIDEO#, have video size=" + l);
      }
    }
    for (;;)
    {
      a(this.jdField_b_of_type_Long);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PTVOperatingGuide", 2, "initData, #PLAY_CALLER_SHORT_VIDEO#, not exist");
      }
    }
  }
  
  public void a()
  {
    if (!this.f)
    {
      TVK_SDKMgr.initSdk(getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
      this.f = true;
    }
    if (TVK_SDKMgr.isInstalled(getApplicationContext()))
    {
      b();
      return;
    }
    TVK_SDKMgr.installPlugin(getApplicationContext(), new pct(this));
  }
  
  void a(long paramLong)
  {
    int i = 0;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTVOperatingGuide", 2, "#play#, msec=" + paramLong);
      }
      this.jdField_a_of_type_Long = paramLong;
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
      {
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(getApplicationContext(), (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(this);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparingListener(this);
        i = 1;
      }
      if (this.g) {
        i = 1;
      }
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTVOperatingGuide", 2, "#play#, videoPath=" + this.jdField_e_of_type_JavaLangString);
        }
        TVK_PlayerVideoInfo localTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo();
        localTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
        localTVK_PlayerVideoInfo.setPlayType(4);
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(getApplicationContext(), this.jdField_e_of_type_JavaLangString, 0L, 0L, localTVK_PlayerVideoInfo);
      }
      for (;;)
      {
        this.g = false;
        return;
        if ((this.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) && (!this.g))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
        }
        this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)paramLong);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("PTVOperatingGuide", 1, "#play#, msec=" + paramLong, localException);
      f();
      g();
    }
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2) {}
  
  protected void a(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2130904161, paramViewGroup);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new pcv(this, paramString));
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory != null)
      {
        this.jdField_a_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this));
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#ffeceef2"));
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, 0);
        i();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTVOperatingGuide", 2, "userBackPressed");
    }
    finish();
    overridePendingTransition(2130968620, 2130968621);
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
    }
    if (QLog.isColorLevel()) {
      QLog.d("PTVOperatingGuide", 2, "#pause# , mCurrentPosition = " + this.jdField_b_of_type_Long);
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    }
  }
  
  void f() {}
  
  void g()
  {
    a(DialogUtil.a(this, 232, null, getString(2131371524), new pcx(this), null));
    if (QLog.isColorLevel()) {
      QLog.d("PTVOperatingGuide", 2, "handleError");
    }
  }
  
  public void h()
  {
    this.g = true;
    if (QLog.isColorLevel()) {
      QLog.d("PTVOperatingGuide", 2, "[MediaPlayer] onCompletion()");
    }
    finish();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    finish();
    paramView = new HashMap();
    paramView.put("ptvTeachClick", "1");
    StatisticCollector.a(BaseApplication.getContext()).a(null, "ptvTeachGuideReportTag", true, 0L, 0L, paramView, "");
    FlowCameraMqqAction.a("", "0X8006DDA", "1");
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    runOnUiThread(new pcy(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.L = false;
    super.onCreate(paramBundle);
    this.jdField_e_of_type_JavaLangString = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface).b();
    if (QLog.isColorLevel()) {
      QLog.d("face", 2, "path = " + this.jdField_e_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131301646));
    findViewById(2131301648).setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131301647);
    if (paramBundle != null)
    {
      this.jdField_b_of_type_Long = paramBundle.getInt("state_play_position");
      if (QLog.isColorLevel()) {
        QLog.d("PTVOperatingGuide", 2, "onCreate(), savedInstanceState != null, mCurrentPosition : " + this.jdField_b_of_type_Long);
      }
    }
    a();
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a(PTVOperatingGuideActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (QLog.isDevelopLevel()) {
      QLog.d("PTVOperatingGuide", 4, "PTVOperatingGuideActivity.onDestroy()");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    e();
    TVK_SDKMgr.setOnLogListener(null);
    try
    {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView = null;
    }
    catch (RuntimeException localRuntimeException)
    {
      try
      {
        do
        {
          unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
          this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a(PTVOperatingGuideActivity.class);
          System.gc();
          return;
          localRuntimeException = localRuntimeException;
        } while (!QLog.isColorLevel());
        QLog.e("PTVOperatingGuide", 2, localRuntimeException, new Object[0]);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;) {}
      }
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    return false;
  }
  
  protected void onPause()
  {
    this.d = true;
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()) {
        this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      }
      if (!this.g) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTVOperatingGuide", 2, "pause mCurrentPosition:" + this.jdField_b_of_type_Long);
      }
    }
    super.onPause();
  }
  
  protected void onResume()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PTVOperatingGuide", 4, "PTVOperatingGuideActivity.onResume()");
    }
    super.onResume();
    this.d = false;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (!this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying())) {
        a(this.jdField_b_of_type_Long);
      }
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.d = true;
    if ((this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_b_of_type_Long = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
      this.jdField_b_of_type_Boolean = true;
    }
    paramBundle.putLong("state_play_position", this.jdField_b_of_type_Long);
    if (QLog.isColorLevel()) {
      QLog.d("PTVOperatingGuide", 2, "onSaveInstanceState: mCurrentPosition: " + this.jdField_b_of_type_Long);
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
  }
  
  protected void onStart()
  {
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
    super.onStart();
  }
  
  protected void onStop()
  {
    this.d = true;
    if (VersionUtils.b()) {
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    }
    super.onStop();
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.jdField_e_of_type_Boolean = true;
    if (this.d)
    {
      this.d = false;
      this.jdField_b_of_type_Boolean = true;
    }
    do
    {
      return;
      runOnUiThread(new pcz(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
    } while (this.jdField_a_of_type_Long <= 0L);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo((int)this.jdField_a_of_type_Long);
  }
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer) {}
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\PTVOperatingGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */