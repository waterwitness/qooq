package com.tencent.biz.pubaccount;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ThirdVidoeManager;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import com.tencent.util.VersionUtils;
import hrl;
import hrm;
import hrp;
import hrq;
import mqq.os.MqqHandler;

public class VideoPlayActivity
  extends BaseActivity
{
  public static final String a = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  public static boolean a = false;
  public static final String b = "VIDEO_AIO_UIN_TYPE";
  public static final String c = "VIDEO_VID";
  public int a;
  public AudioManager a;
  public Handler a;
  public ViewGroup a;
  public VideoUIController a;
  public QQAppInterface a;
  public TVK_IMediaPlayer a;
  public TVK_IProxyFactory a;
  public TVK_PlayerVideoInfo a;
  public TVK_UserInfo a;
  public IVideoViewBase a;
  public int b;
  private final String d;
  
  public VideoPlayActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = ("Q.pubaccount.video." + VideoPlayActivity.class.getSimpleName());
    this.b = 1;
  }
  
  private void b()
  {
    if (Integer.valueOf(getIntent().getStringExtra("VIDEO_WIDTH")).intValue() > Integer.valueOf(getIntent().getStringExtra("VIDEO_HEIGHT")).intValue()) {}
    for (this.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_Int = 0)
    {
      setRequestedOrientation(1);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131296895);
      this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController = new VideoUIController(getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, getIntent().getExtras(), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.a();
      localViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup);
      localViewGroup = (ViewGroup)findViewById(2131298814);
      localViewGroup.setBackgroundColor(-16777216);
      localViewGroup.setOnClickListener(new hrl(this));
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)getSystemService("audio"));
      if (!jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.d, 2, "initUI() mIsSDKInited == false");
        }
        TVK_SDKMgr.initSdk(getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
        jdField_a_of_type_Boolean = true;
      }
      if (TVK_SDKMgr.isInstalled(getApplicationContext()) != true) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.d, 2, "initUI() TVK_SDKMgr.isInstalled() == true");
      }
      a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "initUI() TVK_SDKMgr.isInstalled() == false");
    }
    TVK_SDKMgr.installPlugin(getApplicationContext(), new hrm(this));
  }
  
  private void c()
  {
    View localView = findViewById(2131296895);
    if ((localView != null) && (VersionUtils.g()) && (!ShortVideoUtils.c())) {
      localView.setSystemUiVisibility(5894);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
    this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this, this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
    Object localObject1 = (ViewGroup)findViewById(2131298814);
    Object localObject2 = new FrameLayout.LayoutParams(-1, -1);
    View localView = (View)this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase;
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localView.setVisibility(0);
    ((ViewGroup)localObject1).addView(localView);
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo = new TVK_UserInfo("", "");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo = new TVK_PlayerVideoInfo(2, getIntent().getStringExtra("VIDEO_VID"), "");
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setConfigMap("keep_last_frame", "true");
    long l = getIntent().getLongExtra("VIDEO_PLAY_POSITION", 0L);
    int i = NetworkUtil.a(BaseApplication.getContext());
    if (i == 1)
    {
      localObject1 = "shd";
      this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.a(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer, this.jdField_a_of_type_ComTencentQqliveMediaplayerViewIVideoViewBase);
      localObject2 = getIntent().getStringExtra("VIDEO_THIRD_URL");
      if (2 != getIntent().getIntExtra("VIDEO_ARTICLE_BUSITYPE", 1)) {
        break label352;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break label331;
      }
      localObject1 = ThirdVidoeManager.a();
      ((ThirdVidoeManager)localObject1).a(new hrp(this));
      ((ThirdVidoeManager)localObject1).a(getIntent().getStringExtra("VIDEO_VID"));
    }
    for (;;)
    {
      localObject1 = getIntent().getExtras();
      if (localObject1 != null) {
        PublicAccountUtil.a(((Bundle)localObject1).getString("VIDEO_ARTICLE_ID"), ((Bundle)localObject1).getString("VIDEO_VID"), 0, 0);
      }
      VideoReporter.a("0X80065E6", getIntent().getExtras().getInt("VIDEO_AIO_UIN_TYPE"), this.b, getIntent().getExtras().getString("VIDEO_VID"), "");
      return;
      if ((i == 4) || (i == 3))
      {
        localObject1 = "hd";
        break;
      }
      localObject1 = "sd";
      break;
      label331:
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this, (String)localObject2, l, 0L, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo);
      continue;
      label352:
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo.setPlayMode("cache_video");
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_UserInfo, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_PlayerVideoInfo, (String)localObject1, l, 0L);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    boolean bool2 = false;
    if (paramInt1 == 21) {
      switch (paramInt2)
      {
      }
    }
    do
    {
      return;
      ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, getApplicationContext(), paramIntent, null);
      return;
      if (paramInt1 == 100)
      {
        switch (paramInt2)
        {
        default: 
          return;
        }
        if (!paramIntent.getBooleanExtra("bFailed", false)) {}
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.a(bool1, false);
          return;
          bool1 = false;
        }
      }
    } while (paramInt1 != 101);
    switch (paramInt2)
    {
    default: 
      return;
    }
    bool1 = bool2;
    if (!paramIntent.getBooleanExtra("bFailed", false)) {
      bool1 = true;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.a(bool1, true);
  }
  
  public void doOnBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.l();
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      String str = Long.toString(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion());
      VideoReporter.a("0X80065FB", getIntent().getExtras().getInt("VIDEO_AIO_UIN_TYPE"), this.b, getIntent().getExtras().getString("VIDEO_VID"), str);
    }
    super.doOnBackPressed();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    setContentView(2130903497);
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    if (!getIntent().getExtras().getBoolean("VIDEO_IS_FROM_PUBLIC_ACCOUNT"))
    {
      paramBundle = getIntent().getExtras().getString("VIDEO_THIRD_NAME");
      if (TextUtils.isEmpty(paramBundle)) {}
    }
    for (this.b = paramBundle.hashCode();; this.b = 1)
    {
      getIntent().getExtras().putInt("VIDEO_BIZ_SOURCE_DYH", this.b);
      b();
      if (QLog.isColorLevel())
      {
        paramBundle = getIntent().getExtras();
        if (paramBundle != null) {
          QLog.d(this.d, 2, "doOnCreate() bundle=" + paramBundle.toString());
        }
      }
      return true;
    }
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "doOnDestroy()");
    }
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer;
    this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
    ThreadManager.a().post(new hrq(this, localTVK_IMediaPlayer));
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.k();
      this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "doOnPause()");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.j();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
    }
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "doOnResume()");
    }
    c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountVideoUIController.i();
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 1);
    }
    super.doOnResume();
  }
  
  protected void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "doOnStop()");
    }
    super.doOnStop();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      c();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.d, 2, "onWindowFocusChanged: hasFocus: " + paramBoolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\pubaccount\VideoPlayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */