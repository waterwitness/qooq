package com.tencent.mobileqq.troop.logic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager.OnPlayListener;
import com.tencent.mobileqq.troop.utils.TVKTroopVideoManager.OnSeekListener;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MediaControllerX.MediaControllerListener;
import com.tencent.mobileqq.troop.widget.MessageSubtitleView;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.mobileqq.troop.widget.VideoViewX.OnPlayListener;
import com.tencent.mobileqq.troop.widget.VideoViewX.OnSeekListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import vnt;
import vnw;
import vnx;
import vny;
import vnz;
import voa;
import vob;
import voc;
import vod;
import voe;

public class VideoPlayLogic
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, Handler.Callback, View.OnClickListener, Animation.AnimationListener, TVKTroopVideoManager.OnPlayListener, TVKTroopVideoManager.OnSeekListener, MediaControllerX.MediaControllerListener, VideoViewX.OnPlayListener, VideoViewX.OnSeekListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener
{
  protected static final String a;
  static int f = 0;
  private static final int g = 0;
  private static final int h = 1;
  private static final int i = 2;
  private static final int j = 3;
  public int a;
  public Context a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new voc(this);
  public View a;
  protected Animation a;
  protected LinearLayout a;
  public RelativeLayout a;
  protected TroopMemberApiClient a;
  public SessionInfo a;
  public BaseActivity a;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new vod(this);
  public QQAppInterface a;
  public StructMsgForGeneralShare a;
  public TVKTroopVideoManager a;
  protected MediaControllerX.MediaControllerListener a;
  public MediaControllerX a;
  public MessageSubtitleView a;
  public VideoViewX a;
  public QQProgressDialog a;
  public final Runnable a;
  public List a;
  protected final MqqHandler a;
  protected boolean a;
  protected int b;
  protected Animation b;
  public RelativeLayout b;
  public String b;
  protected boolean b;
  protected int c;
  protected RelativeLayout c;
  protected String c;
  protected boolean c;
  public int d;
  protected boolean d;
  protected int e;
  protected boolean e;
  protected boolean f;
  protected boolean g;
  protected boolean h;
  public boolean i = true;
  protected boolean j;
  protected boolean k;
  public boolean l;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = VideoPlayLogic.class.getSimpleName();
  }
  
  public VideoPlayLogic(Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, TroopMemberApiClient paramTroopMemberApiClient, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new vob(this);
    this.jdField_c_of_type_JavaLangString = paramString;
    a(paramContext, paramBaseActivity, paramSessionInfo, paramRelativeLayout, paramTroopMemberApiClient);
  }
  
  public VideoPlayLogic(QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, MediaControllerX.MediaControllerListener paramMediaControllerListener)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangRunnable = new vob(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener = paramMediaControllerListener;
    a(paramContext, paramBaseActivity, paramSessionInfo, paramRelativeLayout, null);
  }
  
  private void a(Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, TroopMemberApiClient paramTroopMemberApiClient)
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = paramTroopMemberApiClient;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.i = true;
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
        this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getRequestedOrientation();
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper());
      return;
      this.i = false;
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    n();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
    }
    Object localObject = Uri.parse((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX = new MediaControllerX(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setMediaControllerListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setOnSwitchSubTitleBtnClickListener(new voe(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setonOutLinkBtnClickListener(new vnw(this));
    if (!this.i) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.a();
    }
    this.g = true;
    boolean bool;
    if (TVK_SDKMgr.isInstalled(this.jdField_a_of_type_AndroidContentContext.getApplicationContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.a(((Uri)localObject).toString(), this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.d();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnErrorListener = this;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnCompletionListener = this;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager$OnPlayListener = this;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer$OnInfoListener = this;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager$OnSeekListener = this;
      if (this.jdField_d_of_type_Int != 0) {
        break label533;
      }
      bool = true;
      label272:
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX;
      if (this.jdField_d_of_type_Int != 0) {
        break label539;
      }
    }
    label533:
    label539:
    for (int m = 4;; m = 0)
    {
      ((MediaControllerX)localObject).setProgressVisibility(m);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setLive(bool);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.jdField_a_of_type_Boolean = bool;
      }
      if ((this.jdField_d_of_type_Int != 0) && (this.h) && (this.jdField_b_of_type_Int > 0))
      {
        this.k = true;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.a(this.jdField_b_of_type_Int);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.a(this.jdField_b_of_type_Int);
        }
      }
      t();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      s();
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(128);
      if (paramBoolean)
      {
        this.f = true;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      }
      this.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getRequestedOrientation();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setMediaController(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnPlayListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnSeekListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setVideoURI((Uri)localObject);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnViewClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.d();
      break;
      bool = false;
      break label272;
    }
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX == null) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager == null))) {
      return;
    }
    if ((paramInt == 0) && ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b())))
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    int m;
    label119:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, -1, -1);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX == null) {
        break label431;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.b();
      if (paramInt != 1) {
        break label443;
      }
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839289);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
      ((Animatable)localObject2).start();
      if ((!this.i) && (((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) && (m == 0)) || (this.j) || (this.jdField_b_of_type_Int != 0)))
      {
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((TextView)localObject2).setBackgroundColor(-16777216);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      label267:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX == null) {
        break label965;
      }
    }
    label431:
    label443:
    label965:
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.f();; bool = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.f())
    {
      if ((bool) || (this.jdField_b_of_type_Boolean))
      {
        localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject1).setId(2131296443);
        ((ImageView)localObject1).setImageResource(2130839282);
        ((ImageView)localObject1).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364338));
        ((ImageView)localObject1).setOnClickListener(this);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = 10;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 10;
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, -1, -1);
      break;
      m = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.b();
      break label119;
      if (paramInt == 2)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839281);
        if ((!this.i) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) && (m == 0))
        {
          localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new RelativeLayout.LayoutParams(-1, -1);
          ((TextView)localObject1).setBackgroundColor(-16777216);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject3).setId(2131296440);
        ((TextView)localObject3).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364742));
        ((TextView)localObject3).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364744));
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setId(2131296441);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364743));
        ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428250));
        ((TextView)localObject2).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364744));
        ((TextView)localObject2).getPaint().setFlags(8);
        ((TextView)localObject2).setOnClickListener(this);
        ((RelativeLayout)localObject1).addView((View)localObject3, -2, -2);
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131296440);
        ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        break label267;
      }
      if (paramInt != 3) {
        break label267;
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130839281);
      if ((!this.i) && (((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) && (m == 0)) || (this.j)))
      {
        localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        ((TextView)localObject1).setBackgroundColor(-16777216);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
      localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject2).setId(2131296442);
      ((ImageView)localObject2).setImageResource(2130839285);
      ((ImageView)localObject2).setOnClickListener(this);
      ((ImageView)localObject2).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getString(2131364745));
      new TextView(this.jdField_a_of_type_AndroidContentContext).setId(2131296441);
      localObject3 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      new RelativeLayout.LayoutParams(-2, -2).addRule(3, 2131296442);
      break label267;
    }
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载中");
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      if (this.i)
      {
        o();
        return;
      }
    }
    catch (WindowManager.BadTokenException localBadTokenException)
    {
      localBadTokenException.printStackTrace();
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_b_of_type_JavaLangString, new voa(this));
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.a()))
    {
      if (this.i) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "play_time", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.b(), "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.a()))
    {
      if (this.i) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "play_time", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.b(), "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
  }
  
  private void o()
  {
    if (this.i)
    {
      BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
      if (localBizTroopHandler != null) {
        localBizTroopHandler.b(this.jdField_b_of_type_JavaLangString);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_b_of_type_JavaLangString);
  }
  
  private void p()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if ((this.jdField_d_of_type_Int == 0) && (this.h) && (this.jdField_b_of_type_Int > 0))
    {
      this.jdField_b_of_type_Int = 0;
      this.h = false;
      if (this.jdField_c_of_type_Int == 4)
      {
        this.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.e();
      }
    }
    t();
    if (this.i) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "suc_play", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
  }
  
  private void q()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b(0);
    }
    int m;
    if (this.i)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX == null) {
        break label126;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.a();
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "play_time", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + m, "", "");
      t();
      return;
      label126:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager != null) {
        m = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.a();
      } else {
        m = 0;
      }
    }
  }
  
  private void r()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setMediaController(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
    }
    t();
  }
  
  private void s()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131297082);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int m;
    int n;
    if (this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 2)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
      {
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
        m = localDisplayMetrics.heightPixels;
        n = m;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.d()) {
            break label263;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.f();
          n = m;
          if (this.i)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "full_screen", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
            n = m;
          }
        }
        label180:
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
          break label369;
        }
        localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = n;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.requestLayout();
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      return;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      m = 0;
      break;
      label263:
      n = m;
      if (!this.i) {
        break label180;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "full_screen", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
      n = m;
      break label180;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      n = (int)(180.0F * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density + 0.5F);
      break label180;
      label369:
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
  
  private void t()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Int += 1;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()))
      {
        a(false);
        return;
      }
      b(2);
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      b(3);
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_d_of_type_Boolean) || (this.jdField_e_of_type_Boolean))
    {
      b(1);
      return;
    }
    b(0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX$MediaControllerListener.a();
    }
    t();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 701) {
      this.jdField_e_of_type_Boolean = true;
    }
    for (;;)
    {
      t();
      return;
      if (paramInt == 702) {
        this.jdField_e_of_type_Boolean = false;
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(1024);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView != null) && (!this.l)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.setVisibility(0);
      }
      ChatFragment.a(false, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.a(paramConfiguration);
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10L);
      }
      return;
      if (paramConfiguration.orientation == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(1024);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.setVisibility(8);
        }
        ChatFragment.a(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
    }
  }
  
  public void a(MediaPlayer paramMediaPlayer)
  {
    p();
  }
  
  public void a(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    p();
  }
  
  public void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new vnz(this, paramCharSequence1, paramCharSequence2));
    }
  }
  
  public void a(String paramString)
  {
    paramString = paramString.trim();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class);
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (paramString.indexOf("?") > 0) {}
    for (paramString = "";; paramString = "?")
    {
      paramString = localStringBuilder.append(paramString).append("&from=androidqq");
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", paramString.toString().trim());
      localIntent.putExtra("uin", this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
    }
  }
  
  public void a(String paramString, StructMsgForGeneralShare paramStructMsgForGeneralShare, View paramView)
  {
    this.jdField_b_of_type_JavaLangString = MsfSdkUtils.insertMtype("Group", paramString);
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare = paramStructMsgForGeneralShare;
    this.jdField_a_of_type_AndroidViewView = paramView;
    f();
    if (this.i)
    {
      paramString = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36);
      if (paramString != null) {
        paramString.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
      }
      if ((paramString != null) && (paramString.a()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载中");
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        new vnt(this, paramString).execute(new Void[0]);
        return;
      }
    }
    if (TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364741), 1).a();
      return;
    }
    if (TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext) != 2)
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131364178), this.jdField_a_of_type_AndroidContentContext.getString(2131364325), 2131367262, 2131364326, new vnx(this), new vny(this)).show();
      return;
    }
    m();
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
      {
        if (this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation != 2) {
          break label59;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b(0);
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label59:
      e();
    }
  }
  
  public void b()
  {
    t();
  }
  
  public boolean b()
  {
    return (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0);
  }
  
  public void c()
  {
    this.j = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) || (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager != null)) {
      if (!this.h)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX == null) {
          break label85;
        }
        m = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.d();
        this.jdField_c_of_type_Int = m;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX == null) {
          break label96;
        }
      }
    }
    label85:
    label96:
    for (int m = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.b();; m = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.b())
    {
      this.jdField_b_of_type_Int = m;
      n();
      this.jdField_c_of_type_Boolean = true;
      this.h = true;
      t();
      return;
      m = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.d();
      break;
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (VersionUtils.b())
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getRotation();
      if (m != 1)
      {
        bool1 = bool2;
        if (m != 3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d()
  {
    this.j = false;
    if ((this.h) && (this.jdField_b_of_type_Int > 0) && ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) || (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager != null))) {
      a(false);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
    if ((this.jdField_b_of_type_AndroidViewAnimationAnimation.hasStarted()) && (!this.jdField_b_of_type_AndroidViewAnimationAnimation.hasEnded())) {}
    for (int m = 1;; m = 0)
    {
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (m == 0))
      {
        this.f = true;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
      return;
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "stopPlayImpl, mActivity == null");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getConfiguration().orientation == 2)
    {
      Window localWindow = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow();
      if ((localWindow.getAttributes().flags & 0x400) != 0)
      {
        localWindow.clearFlags(1024);
        ChatFragment.a(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) || (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager != null))
    {
      n();
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.g();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.a(true);
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView = null;
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(0);
    }
    s();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(this.jdField_e_of_type_Int);
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.isShown()) && (this.i)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "play_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
  }
  
  public void h()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = true;
    if (this.k) {
      this.j = true;
    }
    t();
    this.k = false;
    this.j = false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
  
  public void i()
  {
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.h = false;
    if (this.jdField_c_of_type_Int == 4)
    {
      this.jdField_c_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.e();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTVKTroopVideoManager.e();
      }
    }
    t();
  }
  
  public void j()
  {
    f();
    if (this.i)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d();
  }
  
  public void k()
  {
    h();
  }
  
  public void l()
  {
    i();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.f = false;
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation) {
      f();
    }
    while (paramAnimation != this.jdField_a_of_type_AndroidViewAnimationAnimation) {
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == 2131296442) {
      if (TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext) == 0)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131364741), 1).a();
        if (this.i) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "Clk_play", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
        }
      }
    }
    do
    {
      do
      {
        return;
        a(false);
        break;
        if (m == 2131296441)
        {
          if ((this.i) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare != null))
          {
            new StructMsgForGeneralShare.GeneralClickHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare).a(this.jdField_b_of_type_JavaLangString);
            return;
          }
          a(this.jdField_b_of_type_JavaLangString);
          return;
        }
      } while (m != 2131296443);
      this.l = false;
      e();
    } while (!this.i);
    if (this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 2)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    q();
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    q();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    r();
    return false;
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    r();
    return false;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a(paramInt1);
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    a(paramInt);
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\logic\VideoPlayLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */