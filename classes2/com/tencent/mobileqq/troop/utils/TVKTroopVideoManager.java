package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MediaControllerX.MediaPlayerControlX;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import com.tencent.qqlive.mediaplayer.view.IVideoViewBase;
import java.net.URLDecoder;
import mqq.manager.TicketManager;
import von;
import voo;
import vop;
import voq;
import vor;
import vot;
import vov;
import vox;
import voz;

public class TVKTroopVideoManager
  implements MediaControllerX.MediaPlayerControlX
{
  public static final int a = -1;
  public static final String a;
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int l = 1;
  public static final int m = 2;
  Context jdField_a_of_type_AndroidContentContext;
  public AudioManager.OnAudioFocusChangeListener a;
  public View a;
  public QQAppInterface a;
  public TVKTroopVideoManager.OnPlayListener a;
  public TVKTroopVideoManager.OnSeekListener a;
  public MediaControllerX a;
  public TVK_IMediaPlayer.OnCompletionListener a;
  public TVK_IMediaPlayer.OnErrorListener a;
  public TVK_IMediaPlayer.OnInfoListener a;
  public TVK_IMediaPlayer a;
  TVK_IProxyFactory jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory = TVK_SDKMgr.getProxyFactory();
  public boolean a;
  String b;
  public boolean b;
  String c;
  public boolean c;
  public String d;
  public int h = 0;
  int i = -1;
  public int j;
  public int k = 1;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = TVKTroopVideoManager.class.getName();
  }
  
  public TVKTroopVideoManager(BaseActivity paramBaseActivity)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new vop(this);
    this.jdField_a_of_type_AndroidContentContext = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
    a();
  }
  
  protected static Bundle a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      paramString = paramString.split("&");
      int i1 = paramString.length;
      int n = 0;
      while (n < i1)
      {
        String[] arrayOfString = paramString[n].split("=");
        if (arrayOfString.length == 2) {
          localBundle.putString(URLDecoder.decode(arrayOfString[0]), URLDecoder.decode(arrayOfString[1]));
        }
        n += 1;
      }
    }
    return localBundle;
  }
  
  public static void a(Context paramContext)
  {
    TVK_SDKMgr.initSdk(paramContext.getApplicationContext(), "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
    TVK_SDKMgr.setDebugEnable(true);
    TVK_SDKMgr.setOnLogListener(new voq(null));
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setEnabled(true);
  }
  
  private boolean g()
  {
    return (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) && (this.h != -1) && (this.h != 0) && (this.h != 1);
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setMediaPlayer(this);
      if (!(this.jdField_a_of_type_AndroidViewView.getParent() instanceof View)) {
        break label66;
      }
    }
    label66:
    for (View localView = (View)this.jdField_a_of_type_AndroidViewView.getParent();; localView = this.jdField_a_of_type_AndroidViewView)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setAnchorView(localView);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setEnabled(g());
      return;
    }
  }
  
  public int a()
  {
    if (g())
    {
      if (this.i > 0) {
        return this.i;
      }
      this.i = ((int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getDuration());
      return this.i;
    }
    this.i = -1;
    return -1;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((View)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createVideoView(this.jdField_a_of_type_AndroidContentContext));
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new von(this));
      ((IVideoViewBase)this.jdField_a_of_type_AndroidViewView).addViewCallBack(new voo(this));
    }
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer == null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IProxyFactory.createMediaPlayer(this.jdField_a_of_type_AndroidContentContext, (IVideoViewBase)this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnVideoPreparedListener(new vox(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnErrorListener(new vot(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnCompletionListener(new vor(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnInfoListener(new vov(this));
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.setOnSeekCompleteListener(new voz(this));
    }
  }
  
  public void a(int paramInt)
  {
    if (g())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager$OnSeekListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager$OnSeekListener.k();
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(paramInt);
      this.j = 0;
      return;
    }
    this.j = paramInt;
  }
  
  public void a(MediaControllerX paramMediaControllerX)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX = paramMediaControllerX;
    h();
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    b();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = null;
    this.j = 0;
    paramString1 = a(paramString2);
    if (paramString1.containsKey("vid")) {}
    for (this.jdField_c_of_type_JavaLangString = paramString1.getString("vid");; this.jdField_c_of_type_JavaLangString = null)
    {
      b();
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null)
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.release();
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer = null;
      this.h = 0;
    }
    if (paramBoolean)
    {
      AudioManager localAudioManager = (AudioManager)BaseApplication.getContext().getSystemService("audio");
      if (localAudioManager != null) {
        localAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
      }
    }
  }
  
  public boolean a()
  {
    return (g()) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying());
  }
  
  public int b()
  {
    if (g()) {
      return (int)this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion();
    }
    return 0;
  }
  
  protected void b()
  {
    a(false);
    this.i = -1;
    a();
    if (this.jdField_c_of_type_JavaLangString != null)
    {
      TVK_UserInfo localTVK_UserInfo = new TVK_UserInfo();
      localTVK_UserInfo.setUin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      localStringBuilder.append("uin=").append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).append(";");
      localStringBuilder.append("skey=").append(((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()));
      localObject = new TVK_PlayerVideoInfo(2, this.jdField_c_of_type_JavaLangString, "");
      localTVK_UserInfo.setLoginCookie(localStringBuilder.toString());
      if (this.k == 2)
      {
        localTVK_UserInfo.setCdnCookie(localStringBuilder.toString());
        if (this.d != null) {
          ((TVK_PlayerVideoInfo)localObject).addExtraParamsMap("auth_ext", "rewardId=" + this.d);
        }
        ((TVK_PlayerVideoInfo)localObject).addExtraParamsMap("auth_from", "170001");
      }
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayer(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), localTVK_UserInfo, (TVK_PlayerVideoInfo)localObject, "", 0L, 0L);
    }
    for (;;)
    {
      this.h = 1;
      return;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.openMediaPlayerByUrl(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), this.jdField_b_of_type_JavaLangString, 0L, 0L);
    }
  }
  
  public boolean b()
  {
    return g();
  }
  
  public int c()
  {
    return 0;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer != null) {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.stop();
    }
  }
  
  public boolean c()
  {
    return g();
  }
  
  public int d()
  {
    return this.h;
  }
  
  public void d()
  {
    if (g())
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.h = 3;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.d();
    }
  }
  
  public boolean d()
  {
    return g();
  }
  
  public void e()
  {
    if ((g()) && (this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.isPlaying()))
    {
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.pause();
      this.h = 4;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.d();
    }
  }
  
  public boolean e()
  {
    return this.h == -1;
  }
  
  public void f()
  {
    int n = 1;
    int i1;
    if (e())
    {
      i1 = (int)(this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.getCurrentPostion() - 1L);
      if (i1 >= 1) {
        break label69;
      }
    }
    for (;;)
    {
      if (this.h == -1) {
        b();
      }
      do
      {
        return;
        d();
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.d();
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.seekTo(n);
      return;
      label69:
      n = i1;
    }
  }
  
  public boolean f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b()) {
      return true;
    }
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TVKTroopVideoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */