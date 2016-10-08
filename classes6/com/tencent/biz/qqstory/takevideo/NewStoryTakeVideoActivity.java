package com.tencent.biz.qqstory.takevideo;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.AddressItem;
import com.tencent.biz.qqstory.model.pendant.PendantManager;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.music.MusicComposeDialog;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.biz.qqstory.takevideo.publish.GenerateBackgroundMusicArgs;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.publish.GenerateDoodleArgs;
import com.tencent.biz.qqstory.takevideo.publish.GenerateDoodleImageSegment;
import com.tencent.biz.qqstory.takevideo.publish.GenerateThumbArgs;
import com.tencent.biz.qqstory.takevideo.publish.GenerateThumbSegment;
import com.tencent.biz.qqstory.takevideo.publish.GenerateVideoArgs;
import com.tencent.biz.qqstory.takevideo.publish.MergeThumbSegment;
import com.tencent.biz.qqstory.takevideo.publish.PublishVideoSegment;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.NeoVideoRecordButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.maxvideo.mediadevice.AVCodec;
import com.tencent.mobileqq.activity.aio.AudioPlayer;
import com.tencent.mobileqq.activity.aio.AudioPlayer.AudioPlayerListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoState;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.ForceReleaseLockOnPause;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr.ViewBitmapSource;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.intervideo.now.NowProxy;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.VideoCompoundController;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwAutoSegmentMgr;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwOutputNotify;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.SurfacePreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.TexturePreviewContext;
import com.tencent.mobileqq.shortvideo.tools.QzoneBaseThread;
import com.tencent.mobileqq.shortvideo.tools.QzoneHandlerThreadFactory;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.video.decode.ShortVideoSoLoad;
import com.tencent.widget.ActionSheet;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import iwg;
import iwh;
import iwi;
import iwj;
import iwk;
import iwl;
import iwm;
import iwn;
import iwo;
import iwp;
import iwq;
import iwr;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class NewStoryTakeVideoActivity
  extends QQStoryBaseActivity
  implements View.OnClickListener, AudioPlayer.AudioPlayerListener, RMVideoSwitchCameraPicMgr.ViewBitmapSource
{
  public static final int A = 16698675;
  static final boolean A = false;
  private static final int jdField_C_of_type_Int = 10;
  private static final boolean jdField_C_of_type_Boolean = false;
  public static final int a = 15000;
  private static final CameraProxy jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
  public static final String a = "Q.qqstory.record.NewStoryTakeVideoActivity";
  public static final int b = 30;
  public static final String b = "auto_start";
  public static final int c = 0;
  public static final String c = "start_time";
  public static final int d = 1;
  public static final String d = "start_origin";
  public static final int e = 2;
  public static final String e = "has_take_photo_ability";
  public static final int f = 3;
  protected static final String f = "camera";
  public static final int g = 4;
  public static final int h = 5;
  public static final int i = 6;
  public static final int j = 7;
  public static final int k = 8;
  public static final int l = 9;
  public static final int m = 10;
  public static final int n = 16;
  protected static final int v = 200;
  protected static final int w = 5000;
  public static final int y = 300000;
  static final int z = 8;
  int jdField_B_of_type_Int = 0;
  boolean jdField_B_of_type_Boolean = false;
  private int D = 0;
  private int E = 1;
  public long a;
  public Handler a;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  View jdField_a_of_type_AndroidViewView;
  public ImageButton a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public CameraFocusView a;
  private NewStoryCameraZoom jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraZoom;
  public NewStoryPartManager a;
  NeoVideoRecordButton jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton;
  protected AudioPlayer a;
  public RMVideoStateMgr a;
  CameraCover jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover;
  public FSurfaceViewLayout a;
  SVHwAutoSegmentMgr jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr = new SVHwAutoSegmentMgr();
  public volatile SVHwEncoder a;
  CameraExceptionHandler.Callback jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = new iwg(this);
  protected iwr a;
  Runnable jdField_a_of_type_JavaLangRunnable = new iwj(this);
  protected Timer a;
  boolean jdField_a_of_type_Boolean = false;
  View jdField_b_of_type_AndroidViewView;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public boolean b;
  View c;
  public boolean c;
  View jdField_d_of_type_AndroidViewView;
  boolean jdField_d_of_type_Boolean = false;
  boolean e;
  boolean f = false;
  public String g;
  public boolean g;
  String h;
  public boolean k = false;
  public boolean l = false;
  boolean m = true;
  public boolean n = true;
  int jdField_o_of_type_Int;
  boolean jdField_o_of_type_Boolean = false;
  public int p;
  boolean p;
  public int q;
  protected boolean q;
  int r;
  protected boolean r;
  int s;
  protected boolean s;
  public int t;
  protected boolean t;
  protected int u;
  protected boolean u;
  protected boolean v;
  public boolean w;
  public int x;
  protected boolean x;
  public boolean y;
  public boolean z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    try
    {
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "LoadExtractedShortVideoSo :soLoadStatus=" + ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS);
      int i1 = VideoEnvironment.a("AVCodec", null, true);
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "LoadExtractedShortVideoSo :code=" + i1);
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(null, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public NewStoryTakeVideoActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager = new NewStoryPartManager();
    this.jdField_p_of_type_Int = -1;
    this.jdField_q_of_type_Int = -1;
    this.jdField_r_of_type_Int = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_t_of_type_Int = 90;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_x_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private int a()
  {
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "replayVideo getFrameCount =" + i1);
    }
    return i1;
  }
  
  private void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i1 = 0;
    paramArrayOfInt = a(2131296494);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)a(paramArrayOfInt);
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    paramArrayOfInt.setLayoutParams(localLayoutParams);
    int i3 = TakeVideoUtils.b(getResources());
    int i2 = i3 - i3;
    if (paramInt2 >= i3) {
      paramInt2 = i2 - 0;
    }
    for (;;)
    {
      this.jdField_r_of_type_Int = (i1 * this.jdField_q_of_type_Int / paramInt1);
      this.jdField_s_of_type_Int = (paramInt2 * this.jdField_q_of_type_Int / paramInt1);
      a(5.0F);
      return;
      paramInt2 = i3 - paramInt2;
      if (this.n)
      {
        paramInt2 = i2 - 0;
      }
      else if (paramInt2 <= 0)
      {
        paramInt2 = i2 - 0;
      }
      else
      {
        i2 -= paramInt2;
        i1 = paramInt2;
        paramInt2 = i2;
      }
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle == null) {
      return;
    }
    HwEnvData.jdField_c_of_type_Boolean = paramBundle.getBoolean("key_video_presend_enable", false);
    HwEnvData.jdField_b_of_type_Boolean = paramBundle.getBoolean("key_video_hard_encode_enable", false);
    float f1 = paramBundle.getFloat("key_video_presend_slice_duration", 1.5F);
    if (f1 > 0.0F) {
      HwEnvData.a = (int)(f1 * 1000.0F);
    }
    if (RMVideoStateMgr.a(paramBoolean))
    {
      this.jdField_q_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(16);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(4);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Drawable localDrawable;
    switch (paramInt)
    {
    default: 
      paramTextView.setVisibility(4);
      paramTextView.clearAnimation();
      localDrawable = null;
    }
    for (;;)
    {
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
        paramTextView.setCompoundDrawables(null, localDrawable, null, null);
      }
      return;
      paramTextView.setVisibility(0);
      localDrawable = getResources().getDrawable(2130841393);
      continue;
      paramTextView.setVisibility(0);
      localDrawable = getResources().getDrawable(2130841394);
      continue;
      paramTextView.setVisibility(0);
      localDrawable = getResources().getDrawable(2130841395);
    }
  }
  
  private void a(RMVideoClipSpec paramRMVideoClipSpec, boolean paramBoolean)
  {
    int i2 = 0;
    int i3;
    if (RMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean))
    {
      i3 = 16;
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "changeVideoPreviewMapSize alignDimension clip_width=" + paramRMVideoClipSpec.c + "clip_height=" + paramRMVideoClipSpec.d + "m_dst_width=" + paramRMVideoClipSpec.e + "dst_width=" + paramRMVideoClipSpec.jdField_f_of_type_Int + "aligned_byte=" + i3 + "constScreenWidth=" + paramBoolean);
      if (!paramBoolean) {
        break label282;
      }
      if (paramRMVideoClipSpec.c % i3 == 0) {
        break label375;
      }
    }
    label282:
    label375:
    for (int i1 = i3 - paramRMVideoClipSpec.c % i3;; i1 = 0)
    {
      if (paramRMVideoClipSpec.d % i3 != 0) {
        i2 = i3 - paramRMVideoClipSpec.d % i3;
      }
      paramRMVideoClipSpec.c += i1;
      paramRMVideoClipSpec.d += i2;
      if (this.n) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(2, paramRMVideoClipSpec, this.jdField_r_of_type_Int);
      }
      for (;;)
      {
        paramRMVideoClipSpec.e = paramRMVideoClipSpec.c;
        paramRMVideoClipSpec.jdField_f_of_type_Int = paramRMVideoClipSpec.d;
        SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "changeVideoPreviewMapSize alignDimension m_clip_width=" + i1 + "m_clip_height=" + i2 + "aligned_byte=" + i3);
        return;
        i3 = 4;
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(5, paramRMVideoClipSpec, this.jdField_s_of_type_Int);
      }
      i1 = paramRMVideoClipSpec.c % i3;
      i2 = paramRMVideoClipSpec.d % i3;
      paramRMVideoClipSpec.c -= i1;
      paramRMVideoClipSpec.d -= i2;
      if (this.n) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(2, paramRMVideoClipSpec, this.jdField_r_of_type_Int);
      }
      for (;;)
      {
        paramRMVideoClipSpec.e = paramRMVideoClipSpec.c;
        paramRMVideoClipSpec.jdField_f_of_type_Int = paramRMVideoClipSpec.d;
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(5, paramRMVideoClipSpec, this.jdField_s_of_type_Int);
      }
    }
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null) || (this.jdField_a_of_type_AndroidViewView.isEnabled())) {
      return false;
    }
    return true;
  }
  
  private void e(boolean paramBoolean)
  {
    v();
    l();
    if (paramBoolean) {
      a(true);
    }
    r();
  }
  
  private void u()
  {
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "userBackPressed");
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a("Q.qqstory.record.NewStoryTakeVideoActivity");
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCoverMgr.b(this.jdField_p_of_type_Int, this.jdField_q_of_type_Int, this.n, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec);
    Object localObject = RichmediaClient.a().a().a(this.jdField_g_of_type_JavaLangString);
    if (localObject != null) {
      ((CompoundProcessor)localObject).a(103);
    }
    for (;;)
    {
      localObject = getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      setResult(1001, (Intent)localObject);
      finish();
      return;
      b();
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.a != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.a.b();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.a.d();
    }
  }
  
  private void w()
  {
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "handleQQVideo(): onSendVideoClick mHwEncoder=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    QzoneHandlerThreadFactory.a("Normal_HandlerThread", false).a(new iwq(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  private void x()
  {
    int i2 = 1;
    Object localObject1 = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    Object localObject2;
    int i1;
    if ((localObject1 != null) && (HwEnvData.b()) && (this.jdField_q_of_type_Boolean) && (VideoEnvironment.b(2)))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = new SVHwEncoder();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, ((RMVideoClipSpec)localObject2).e, ((RMVideoClipSpec)localObject2).jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(-1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Int * 1000);
      if (CodecParam.jdField_o_of_type_Int != 16) {
        break label268;
      }
      i1 = 1;
    }
    for (;;)
    {
      if (CodecParam.jdField_p_of_type_Int == 2) {
        i2 = 2;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(CodecParam.C, i1, 64000, i2);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null) {
          break label294;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        localObject2 = RichmediaClient.a().a();
        c();
        localObject1 = ((VideoCompoundController)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder, (SessionInfo)localObject1, 2);
        this.jdField_g_of_type_JavaLangString = ((CompoundProcessor)localObject1).a();
        LogTag.a(this.jdField_g_of_type_JavaLangString, "start", "[peak]");
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a((SVHwOutputNotify)localObject1, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_d_of_type_Boolean);
        return;
        label268:
        if (CodecParam.jdField_o_of_type_Int != 12) {
          break label315;
        }
        i1 = 2;
        break;
        if (CodecParam.jdField_p_of_type_Int != 3) {
          i2 = 2;
        }
      }
      label294:
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", 2, "[@] previewSizeAdjustUI: rmStateMgr.videoContext=null,do not hwencode...");
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
      return;
      label315:
      i1 = 1;
    }
  }
  
  private void y()
  {
    Object localObject1;
    label73:
    label126:
    int i1;
    label145:
    label172:
    label220:
    label247:
    label317:
    label365:
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a().jdField_c_of_type_Boolean)
    {
      if (this.y)
      {
        localObject1 = "2";
        StoryReportor.a("video_edit", "change_graffiti", 0, 0, new String[] { localObject1 });
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a().jdField_b_of_type_Boolean)
      {
        if (!this.y) {
          break label589;
        }
        localObject1 = "2";
        StoryReportor.a("video_edit", "change_color", 0, 0, new String[] { localObject1 });
      }
      if (!this.y) {
        break label596;
      }
      StoryReportor.a("video_edit", "pub_photo", 0, 0, new String[] { "", "5000" });
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant.a())) {
        break label630;
      }
      i1 = 1;
      if (i1 != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant.b();
        if (!this.y) {
          break label636;
        }
        localObject1 = "2";
        StoryReportor.a("video_edit", "pub_changeface", 0, 0, new String[] { "1", localObject2, localObject1 });
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList.a())) {
        break label643;
      }
      i1 = 1;
      if (i1 != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList.a();
        if (!this.y) {
          break label649;
        }
        localObject1 = "2";
        StoryReportor.a("video_edit", "pub_tag", 0, 0, new String[] { "1", localObject2, localObject1 });
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a().a();
      if ((localObject2 != null) && (localObject2.length == 2))
      {
        if (localObject2[0] > 0)
        {
          if (!this.y) {
            break label656;
          }
          localObject1 = "2";
          StoryReportor.a("video_edit", "pub_graffiti", 0, 0, new String[] { "1", "", localObject1 });
        }
        if (localObject2[1] > 0)
        {
          if (!this.y) {
            break label663;
          }
          localObject1 = "2";
          StoryReportor.a("video_edit", "pub_mosaics", 0, 0, new String[] { "1", "", localObject1 });
        }
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a().b();
      if ((localObject2 == null) || (localObject2.length != 2)) {
        break label893;
      }
      localObject4 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a().a();
      localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a().a();
      localObject1 = new StringBuilder();
      localObject4 = ((Map)localObject4).entrySet().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject4).hasNext()) {
        break label691;
      }
      Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
      List localList = (List)((Map.Entry)localObject5).getValue();
      if ((localList != null) && (localList.size() > 0))
      {
        ((StringBuilder)localObject1).append((String)((Map.Entry)localObject5).getKey()).append(':');
        localObject5 = localList.iterator();
        for (;;)
        {
          if (((Iterator)localObject5).hasNext())
          {
            ((StringBuilder)localObject1).append((String)((Iterator)localObject5).next()).append(',');
            continue;
            localObject1 = "1";
            break;
            label589:
            localObject1 = "1";
            break label73;
            label596:
            StoryReportor.a("video_edit", "pub_video", 0, 0, new String[] { "", String.valueOf(a()) });
            break label126;
            label630:
            i1 = 0;
            break label145;
            label636:
            localObject1 = "1";
            break label172;
            label643:
            i1 = 0;
            break label220;
            label649:
            localObject1 = "1";
            break label247;
            label656:
            localObject1 = "1";
            break label317;
            label663:
            localObject1 = "1";
            break label365;
          }
        }
        ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
        ((StringBuilder)localObject1).append(';');
      }
    }
    label691:
    SLog.a("Q.qqstory.record.NewStoryTakeVideoActivity", "faceReportString = %s", localObject1);
    Object localObject4 = new StringBuilder();
    if (((List)localObject3).size() > 0)
    {
      ((StringBuilder)localObject4).append("地点贴纸:");
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((StringBuilder)localObject4).append((String)((Iterator)localObject3).next()).append(',');
      }
      ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
      ((StringBuilder)localObject4).append(';');
    }
    SLog.a("Q.qqstory.record.NewStoryTakeVideoActivity", "poiReportString = %s", localObject4);
    if (localObject2[0] > 0)
    {
      i1 = localObject2[0];
      localObject3 = ((StringBuilder)localObject1).toString();
      if (this.y)
      {
        localObject1 = "2";
        StoryReportor.a("video_edit", "pub_face", 0, 0, new String[] { String.valueOf(i1), localObject3, localObject1 });
      }
    }
    else
    {
      if (localObject2[1] > 0) {
        StoryReportor.a("video_edit", "pub_poi", 0, 0, new String[] { String.valueOf(localObject2[1]), ((StringBuilder)localObject4).toString() });
      }
      label893:
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a().a();
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label1165;
      }
      i1 = 1;
      label917:
      if (i1 != 0)
      {
        if (!this.y) {
          break label1171;
        }
        localObject1 = "2";
        label933:
        StoryReportor.a("video_edit", "pub_text", 0, 0, new String[] { "1", localObject2, localObject1 });
      }
      switch (this.E)
      {
      default: 
        SLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", "mCurrentMusicType illegal %d", new Object[] { Integer.valueOf(this.E) });
        label1018:
        switch (this.D)
        {
        default: 
          SLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", "illegal play mode : %s", new Object[] { Integer.valueOf(this.D) });
          localObject1 = "";
          i1 = 0;
          label1105:
          if (!"".equals(localObject1)) {
            if (!this.y) {
              break label1438;
            }
          }
          break;
        }
        break;
      }
    }
    label1165:
    label1171:
    label1206:
    label1260:
    label1438:
    for (Object localObject2 = "2";; localObject2 = "1")
    {
      StoryReportor.a("video_edit", "pub_filter_menu", 0, 0, new String[] { String.valueOf(i1), localObject1, localObject2 });
      return;
      localObject1 = "1";
      break;
      i1 = 0;
      break label917;
      localObject1 = "1";
      break label933;
      StoryReportor.a("video_edit", "sound_off", 0, 0, new String[0]);
      break label1018;
      if (MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo == null)
      {
        localObject1 = "";
        if (!this.y) {
          break label1260;
        }
      }
      for (localObject2 = "2";; localObject2 = "1")
      {
        StoryReportor.a("video_edit", "pub_music", 0, 0, new String[] { String.valueOf(2), localObject1, localObject2 });
        break;
        localObject1 = MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.b;
        break label1206;
      }
      StoryReportor.a("video_edit", "sound_on", 0, 0, new String[0]);
      break label1018;
      if (MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo == null) {}
      for (localObject1 = "";; localObject1 = MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.b)
      {
        StoryReportor.a("video_edit", "pub_music", 0, 0, new String[] { String.valueOf(1), localObject1 });
        break;
      }
      localObject1 = "";
      i1 = 0;
      break label1105;
      localObject1 = "倒带";
      i1 = 3;
      break label1105;
      localObject1 = "加速";
      i1 = 1;
      break label1105;
      localObject1 = "减速";
      i1 = 2;
      break label1105;
      localObject1 = "高亮";
      i1 = 9;
      break label1105;
      localObject1 = "暖色";
      i1 = 5;
      break label1105;
      localObject1 = "冷色";
      i1 = 4;
      break label1105;
      localObject1 = "黑白";
      i1 = 6;
      break label1105;
      localObject1 = "时间";
      i1 = 7;
      break label1105;
      localObject1 = "地点";
      i1 = 8;
      break label1105;
    }
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 1: 
      return 3;
    case 3: 
      return 2;
    case 4: 
      return 4;
    case 5: 
      return 5;
    case 6: 
      return 6;
    }
    return 7;
  }
  
  public long a()
  {
    long l2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double;
    long l1;
    if ((this.D == 0) && (this.y)) {
      l1 = 5000L;
    }
    do
    {
      return l1;
      if (this.D == 2) {
        return l2 / 2L;
      }
      l1 = l2;
    } while (this.D != 3);
    return l2 * 2L;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      try
      {
        if (!this.n)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getChildAt(0);
          if (!TextureView.class.isInstance(localObject)) {
            break label110;
          }
          localObject = ((TextureView)localObject).getBitmap(paramInt1, paramInt2);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        localObject = null;
        SLog.e("Q.qqstory.record.NewStoryTakeVideoActivity", "getViewBitmap OOM" + localOutOfMemoryError1);
        return (Bitmap)localObject;
      }
      try
      {
        SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "getViewBitmap : " + localObject);
        return (Bitmap)localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        continue;
      }
      SLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", "getViewBitmap return null because of Surface View");
      return null;
      label110:
      Object localObject = null;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)a(2131297175));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131301328));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout = ((FSurfaceViewLayout)a(2131301606));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoCameraFocusView = ((CameraFocusView)a(2131302870));
    this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton = ((NeoVideoRecordButton)a(2131302942));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131302875));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131302876));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a(8, a(2131302941));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a(14, a(2131301607));
    NewStoryViewController localNewStoryViewController = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController;
    Object localObject = a(2131302779);
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    localNewStoryViewController.a(6, (View)localObject);
    localNewStoryViewController = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController;
    localObject = a(2131302777);
    this.jdField_b_of_type_AndroidViewView = ((View)localObject);
    localNewStoryViewController.a(2, (View)localObject);
    localNewStoryViewController = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController;
    localObject = a(2131302778);
    this.jdField_c_of_type_AndroidViewView = ((View)localObject);
    localNewStoryViewController.a(5, (View)localObject);
    localNewStoryViewController = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController;
    localObject = (ImageView)a(2131302939);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localObject);
    localNewStoryViewController.a(4, (View)localObject);
    localNewStoryViewController = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController;
    localObject = a(2131302940);
    this.jdField_d_of_type_AndroidViewView = ((View)localObject);
    localNewStoryViewController.a(3, (View)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a(11, a(2131302945));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a(19, a(2131302943));
    localNewStoryViewController = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController;
    localObject = (ImageButton)a(2131302944);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localObject);
    localNewStoryViewController.a(0, (View)localObject);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a(15, a(2131302781));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a(16, a(2131302877));
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a(17, a(2131302780));
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
    a(2131302780).setOnClickListener(this);
    VideoSourceHelper.nativeSetMosaic(16, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundResource(2130838381);
  }
  
  void a(float paramFloat)
  {
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "showVideoMode, dx = " + paramFloat);
    if (paramFloat > 0.0F) {
      if (!this.jdField_c_of_type_Boolean) {
        break label46;
      }
    }
    label46:
    while (paramFloat <= 0.0F) {
      do
      {
        return;
      } while (!this.jdField_c_of_type_Boolean);
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.D = paramInt;
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "play mode change to be : " + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, float paramFloat)
  {
    int i1 = UIUtils.a(this);
    getResources().getDrawable(2130841393).getMinimumWidth();
    a(this.jdField_a_of_type_AndroidWidgetTextView, paramInt1);
    a(this.jdField_b_of_type_AndroidWidgetTextView, paramInt2);
    this.jdField_a_of_type_AndroidWidgetTextView.setPadding(0, 0, (int)(i1 * 2 * paramFloat), 0);
    this.jdField_b_of_type_AndroidWidgetTextView.setPadding((int)(i1 * 2 * (1.0F - paramFloat)), 0, 0, 0);
    if ((paramInt1 == 2) || (paramInt1 == 1) || (paramInt1 == 3))
    {
      if (paramFloat == 0.0F)
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setStartOffset(1000L);
        localAlphaAnimation.setDuration(200L);
        localAlphaAnimation.setFillAfter(true);
        this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAlphaAnimation);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetTextView.clearAnimation();
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "onPreviewResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
    if (paramInt1 == 1002) {
      this.jdField_s_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.e();
    }
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    b(paramInt1, paramInt2, paramBoolean, paramArrayOfInt);
  }
  
  protected void a(Bundle paramBundle)
  {
    int i1 = 0;
    this.jdField_r_of_type_Int = 0;
    this.jdField_s_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    FlowCameraConstant.d = 2;
    FlowCameraConstant.a = 0.75F;
    if (paramBundle == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramBundle.getLong("start_time", -1L);
    this.jdField_x_of_type_Int = paramBundle.getInt("start_origin", -1);
    this.jdField_x_of_type_Boolean = paramBundle.getBoolean("has_take_photo_ability", false);
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "Get take photo ability. mTakePhotoAbility = " + this.jdField_x_of_type_Boolean);
    if (this.jdField_a_of_type_Long > 0L) {
      StoryReportor.b("take_video", "video_startup", 0, 0, new String[] { "", String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long), String.valueOf(this.jdField_x_of_type_Int) });
    }
    Object localObject = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
    if ((localObject != null) && (((ConfigurationInfo)localObject).reqGlEsVersion >= 131072)) {}
    for (boolean bool = true;; bool = false)
    {
      this.v = bool;
      this.jdField_u_of_type_Boolean = false;
      if (paramBundle.getBoolean("flow_camera_use_filter_function", false)) {
        this.jdField_u_of_type_Boolean = PtvFilterSoLoad.a(VideoEnvironment.a(), false);
      }
      a(paramBundle, false);
      this.e = paramBundle.getBoolean("flow_camera_use_surfaceview", false);
      localObject = paramBundle.getString("sv_config");
      bool = paramBundle.getBoolean("sv_whitelist");
      paramBundle = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (paramBundle != null) {
        i1 = paramBundle.a;
      }
      int i2 = NetworkUtil.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(null, 2, (String)localObject, bool, i1, i2, this.jdField_o_of_type_Int);
      CodecParam.d = 10000;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, QQStoryContext.a().a(), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryRMViewSTInterface)) {
        break;
      }
      finish();
      return;
    }
    this.jdField_u_of_type_Int = TakeVideoUtils.b(getResources());
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new iwh(this, this);
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {}
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy);
    }
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback));
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "initData(), mPtvMode:false,mCaptureMode:false, config=" + (String)localObject + ", white=" + bool);
  }
  
  void a(NewStoryPoiList.SelectLocationCallback paramSelectLocationCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiList.a(paramSelectLocationCallback);
  }
  
  public void a(AudioPlayer paramAudioPlayer) {}
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {}
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();; i1 = 0)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494) == null)
      {
        localObject1 = localObject2;
        if (paramBoolean) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
        }
      }
      if ((VersionUtils.d()) && (!this.e))
      {
        localObject2 = new CameraTextureView(this);
        if ((localObject1 != null) && ((localObject1 instanceof TexturePreviewContext)))
        {
          ((CameraTextureView)localObject2).a = ((TexturePreviewContext)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraTextureView)localObject2).a);
          localObject1 = new FrameLayout.LayoutParams(-1, TakeVideoUtils.b(getResources()));
          ((FrameLayout.LayoutParams)localObject1).gravity = 83;
          this.n = false;
          if (i1 != 0) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.setFrameIndex(i1);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(this.jdField_u_of_type_Boolean, this.v);
          SLog.a("Q.qqstory.record.NewStoryTakeVideoActivity", "isSurpportRTBeauty=%s, isSurpportFilter=%s, mHasFilterSoLib=%s, mOpenGLEsVersion2=%s", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_b_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_u_of_type_Boolean), Boolean.valueOf(this.v));
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean);
          paramBoolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(this, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraGlFilterListener, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
          SLog.b("face", "setupCameraUI needAddglview=" + paramBoolean + ", needChangeNewSurfaceView=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean + ", needOpenglView=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean + ", isSurpportFilter=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean) {
            break label560;
          }
          ((FrameLayout.LayoutParams)localObject1).height = 1;
        }
      }
      for (((FrameLayout.LayoutParams)localObject1).width = 1;; ((FrameLayout.LayoutParams)localObject1).width = TakeVideoUtils.a(getResources()))
      {
        ((FrameLayout.LayoutParams)localObject1).gravity = 81;
        if (this.n) {
          ((FrameLayout.LayoutParams)localObject1).gravity = 49;
        }
        ((View)localObject2).setId(2131296494);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject2);
        if (paramBoolean)
        {
          SLog.c("Q.qqstory.record.NewStoryTakeVideoActivity", "add gl surface view");
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
        }
        this.jdField_g_of_type_Boolean = true;
        if (!this.k) {
          break label585;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
        return;
        ((CameraTextureView)localObject2).a = new TexturePreviewContext(jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, TakeVideoUtils.a(getResources()), TakeVideoUtils.b(getResources()));
        break;
        localObject2 = new CameraPreview(this);
        if ((localObject1 != null) && ((localObject1 instanceof SurfacePreviewContext))) {}
        for (((CameraPreview)localObject2).a = ((SurfacePreviewContext)localObject1);; ((CameraPreview)localObject2).a = new SurfacePreviewContext(jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, TakeVideoUtils.a(getResources()), TakeVideoUtils.b(getResources())))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraPreview)localObject2).a);
          localObject1 = new FrameLayout.LayoutParams(-1, TakeVideoUtils.b(getResources()));
          ((FrameLayout.LayoutParams)localObject1).gravity = 51;
          this.n = true;
          break;
        }
        label560:
        ((FrameLayout.LayoutParams)localObject1).height = TakeVideoUtils.b(getResources());
      }
      label585:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    int i1 = FlowCameraConstant.d;
    if (i1 == paramInt) {
      return false;
    }
    this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.i();
    if (!this.n)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCoverMgr.a(this.jdField_p_of_type_Int, this.jdField_q_of_type_Int, false, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec);
      if (localBitmap != null)
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryRMViewSTInterface.a(104);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeViewAt(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
        SLog.b("face", "click front needChangeNewSurfaceView" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c());
        if (i1 != 1) {
          break label219;
        }
        FlowCameraConstant.d = 2;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a(false, true);
        label170:
        this.k = true;
        if (!paramBoolean) {
          break label238;
        }
        a(true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.h();
      return true;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838381);
      break;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838381);
      break;
      label219:
      FlowCameraConstant.d = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.a(true, true);
      break label170;
      label238:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean) {
        i();
      } else {
        a(false);
      }
    }
  }
  
  public boolean a(MotionEvent paramMotionEvent, int paramInt)
  {
    boolean bool = false;
    float f1 = this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.getX();
    float f2 = this.jdField_a_of_type_ComTencentBizQqstoryViewNeoVideoRecordButton.getY();
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "referX = " + f1 + ", referY = " + f2);
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "motionEvent.getX(pointIndex) = " + paramMotionEvent.getX(paramInt) + ", motionEvent.getY(pointIndex) = " + paramMotionEvent.getY(paramInt));
    if (TakeVideoUtils.a(this.jdField_a_of_type_AndroidViewView, (int)(f1 + paramMotionEvent.getX(paramInt)), (int)(f2 + paramMotionEvent.getY(paramInt))))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      a(-1, false);
      k();
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "mSwitchButton consume the touch event");
      bool = true;
    }
    return bool;
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraZoom = new NewStoryCameraZoom(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a(this);
  }
  
  int b(int paramInt)
  {
    int i1 = paramInt;
    if (RMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean))
    {
      int i2 = paramInt % 16;
      i1 = paramInt;
      if (i2 > 0) {
        i1 = paramInt + (16 - i2);
      }
    }
    return i1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a.getAndSet(null);
    }
  }
  
  void b(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "getVideoClipPreviewMapSize constScreenWidth" + paramBoolean);
    float f1 = paramInt1 / paramInt2;
    int i1 = TakeVideoUtils.a(getResources());
    int i4 = TakeVideoUtils.b(getResources());
    int i3;
    int i2;
    if (paramBoolean)
    {
      i3 = (int)(f1 * i1);
      f1 = paramInt2;
      paramInt1 = (int)(i4 * f1 / i1);
      i2 = paramInt2;
    }
    for (paramInt2 = i3;; paramInt2 = i4)
    {
      paramArrayOfInt[0] = i2;
      paramArrayOfInt[1] = paramInt1;
      paramArrayOfInt[2] = i1;
      paramArrayOfInt[3] = paramInt2;
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "preview scale width = " + paramArrayOfInt[2] + ", preview scale height = " + paramArrayOfInt[3]);
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "preview clip width = " + paramArrayOfInt[0] + ", preview clip height = " + paramArrayOfInt[1]);
      return;
      paramInt2 = (int)(i4 / f1);
      f1 = paramInt1;
      i2 = (int)(i1 * f1 / i4);
      i1 = paramInt2;
    }
  }
  
  void b(NewStoryPoiList.SelectLocationCallback paramSelectLocationCallback)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPoiSearchViewPart.a(paramSelectLocationCallback);
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  void b(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "exitVideoMode(), mPtvMode = false, clearCache = " + paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryRMViewSTInterface.a(103);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
        {
          int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getSegmentCount();
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(0, i1, true);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_b_of_type_Boolean)) {}
    }
  }
  
  public void c()
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null)
    {
      RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(0.0D, 0.0D, f1, localRMVideoClipSpec.e);
    }
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      localObject = MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(((QQStoryMusicInfo)localObject).jdField_g_of_type_JavaLangString))) {
        break;
      }
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("playBgMusic() music = ").append(localObject).append(", download_path = ");
    if (localObject == null) {}
    for (Object localObject = null;; localObject = ((QQStoryMusicInfo)localObject).jdField_g_of_type_JavaLangString)
    {
      QLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", 2, (String)localObject);
      return;
    }
    r();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(BaseApplicationImpl.getContext(), this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(3);
    }
    if (paramInt >= 0) {}
    for (boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(((QQStoryMusicInfo)localObject).jdField_g_of_type_JavaLangString, paramInt);; bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(((QQStoryMusicInfo)localObject).jdField_g_of_type_JavaLangString, ((QQStoryMusicInfo)localObject).jdField_g_of_type_Int))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", 2, "playBgMusic() seekPlay = " + bool);
      }
      if (this.y)
      {
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_Iwr = new iwr(this, (QQStoryMusicInfo)localObject);
        this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_Iwr, 5000L, 5000L);
      }
      sendBroadcast(new Intent("action_music_start"));
      return;
    }
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt) {}
  
  void c(boolean paramBoolean)
  {
    int[] arrayOfInt = new int[6];
    if ((this.jdField_p_of_type_Int == -1) || (this.jdField_q_of_type_Int == -1)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.qqstory.record.NewStoryTakeVideoActivity", 2, "[changeVideoPreviewMapSize]rmStateMgr " + null);
    return;
    RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    float f1 = this.jdField_p_of_type_Int * 1.0F / this.jdField_q_of_type_Int;
    if (TakeVideoUtils.a(getResources()) > f1) {}
    for (boolean bool = false;; bool = true)
    {
      a(this.jdField_p_of_type_Int, this.jdField_q_of_type_Int, bool, arrayOfInt);
      if (paramBoolean) {}
      try
      {
        a(arrayOfInt[2], arrayOfInt[3], arrayOfInt);
        localRMVideoClipSpec.c = arrayOfInt[0];
        localRMVideoClipSpec.d = arrayOfInt[1];
        localRMVideoClipSpec.e = this.jdField_p_of_type_Int;
        localRMVideoClipSpec.jdField_f_of_type_Int = this.jdField_q_of_type_Int;
        a(localRMVideoClipSpec, bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localRMVideoClipSpec, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean);
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;) {}
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 4) {
      if (this.y)
      {
        localObject = "2";
        StoryReportor.a("video_edit", "clk_left", 0, 0, new String[] { localObject });
        i2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.b();
        i1 = i2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList.a())) {
          i1 = i2 + 1;
        }
        i2 = i1;
        if (MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null)
        {
          i2 = i1;
          if (!TextUtils.isEmpty(MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_g_of_type_JavaLangString)) {
            i2 = i1 + 1;
          }
        }
        SLog.a("Q.qqstory.record.NewStoryTakeVideoActivity", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(i2));
        if (i2 > 3) {
          break label188;
        }
        e(true);
        if (this.k) {
          this.l = true;
        }
        SLog.b("face", "click left hasChangeCamera" + this.k);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a();
        m();
      }
    }
    label188:
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double != 0.0D) && (this.jdField_c_of_type_Boolean))
    {
      for (;;)
      {
        int i2;
        int i1;
        return;
        localObject = "1";
      }
      if (this.y) {}
      for (Object localObject = "2";; localObject = "1")
      {
        StoryReportor.a("video_edit", "clk_left_float", 0, 0, new String[] { localObject });
        localObject = ActionSheet.b(this, false);
        ((ActionSheet)localObject).a("放弃本段视频编辑？");
        ((ActionSheet)localObject).a("放弃", 3);
        ((ActionSheet)localObject).d("取消");
        ((ActionSheet)localObject).a(new iwk(this, (ActionSheet)localObject));
        ((ActionSheet)localObject).show();
        return;
      }
    }
    u();
  }
  
  public void d(int paramInt)
  {
    this.E = paramInt;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841468);
      return;
    }
    if (-1 == paramInt)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841467);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841459);
  }
  
  void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.a(paramBoolean);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "doOnActivityResult selectMusic() resultCode = " + paramInt2 + ", data = " + paramIntent);
    }
    if (MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.a.c();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.a.a();
      q();
      return;
    }
    this.z = true;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    StoryReportor.a("video_shoot", "exp_findview", 0, 0, new String[0]);
    a(getIntent().getExtras());
    if ((VersionUtils.d()) && (!this.e))
    {
      SLog.c("Q.qqstory.record.NewStoryTakeVideoActivity", "add FLAG_HARDWARE_ACCELERATED");
      getWindow().addFlags(16777216);
    }
    getWindow().addFlags(1024);
    setContentViewC(2130904479);
    a();
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new iwp(this, null));
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", TakeVideoUtils.a());
    PtvTemplateManager.a(null).d(null);
    VideoSourceHelper.nativeSetPlayMode(this.D);
    VideoSourceHelper.nativeSetPlayAFMute(false);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.b(this);
    return true;
  }
  
  public void finish()
  {
    super.finish();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoTakeVideoButtonSubPart.f();
    super.overridePendingTransition(2130968620, 2130968593);
    v();
    ((PendantManager)SuperManager.a(11)).d();
  }
  
  public void h()
  {
    this.jdField_a_of_type_Boolean = false;
    int i1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
    boolean bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.a.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
    int i2 = a();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    if (i2 < 10)
    {
      StoryReportor.a("video_edit", "clk_shoot", 0, 0, new String[] { "2" });
      if ((!this.jdField_x_of_type_Boolean) || (i1 != 0) || (i2 <= 1) || (i2 >= 10)) {
        break label265;
      }
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "replayVideo. Take photo mode.");
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "rmStateMgr.mVideoFileDir = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + " errcode=" + i1 + " hasFrame=" + i2);
      this.y = true;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController.a(1);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.a.setNeedPlayAudio(false);
      if (MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo == null) {
        d(0);
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a()) {
        break label426;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", 2, "replayVideo isCurrentPreviewState= true......");
      }
      return;
      StoryReportor.a("video_edit", "press_shoot", 0, 0, new String[] { "1" });
      break;
      label265:
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "replayVideo. Take video mode");
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "replayVideo getVFileAndAFile=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + "errcode=" + i1 + "hasFrame=" + bool);
      if ((i1 != 0) || (i2 < 10))
      {
        QQToast.a(this, "拍摄时间过短，请重新拍摄", 0).a();
        m();
        SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "replayVideo. errcode = " + i1 + " hasFrame = " + i2);
        this.jdField_d_of_type_Boolean = true;
        StoryReportor.a("video_shoot", "exp_time_float", 0, 0, new String[0]);
        return;
      }
      this.y = false;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController.a(0);
    }
    label426:
    if (this.y) {}
    for (Object localObject = "2";; localObject = "1")
    {
      StoryReportor.a("video_edit", "exp_edit", 0, 0, new String[] { localObject });
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.a.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.f();
      }
      this.jdField_s_of_type_Boolean = true;
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494);
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
        this.jdField_b_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.a(TakeVideoUtils.a(getResources()), TakeVideoUtils.b(getResources()));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
      q();
      localObject = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      ((ScaleAnimation)localObject).setDuration(200L);
      ((ScaleAnimation)localObject).setAnimationListener(new iwl(this));
      this.jdField_a_of_type_AndroidWidgetImageButton.startAnimation((Animation)localObject);
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "replay totaltime = " + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
      return;
    }
  }
  
  void i()
  {
    a(false);
  }
  
  void j()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.c();
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(false);
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", 2, "gl_root.isBufferWriteOK()");
        }
        h();
      }
    }
    else {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", 2, "gl_root.isBufferWriteOK nop");
    }
    b(2131370344);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
    e();
    h();
  }
  
  public void k()
  {
    SLog.c("Q.qqstory.record.NewStoryTakeVideoActivity", "startRecord");
    if (this.jdField_d_of_type_Boolean)
    {
      AVCodec.get().retake();
      SLog.c("Q.qqstory.record.NewStoryTakeVideoActivity", "AVCodec.get().retake() by mbRetake flag");
      this.jdField_d_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.i();
    if ((FlowCameraConstant.d == 2) && (this.f)) {
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
      VideoSourceHelper.nativeSetMosaic(16, null);
      VideoSourceHelper.nativeSetPlayAFMute(false);
      VideoSourceHelper.nativeSetPlayMode(0);
      return;
      jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.b(false);
    }
  }
  
  void l()
  {
    a(1002, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a().b();
  }
  
  public void m()
  {
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "restartRecordVideo, isSurpportFilter = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean);
    this.jdField_s_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList.a();
    MusicComposeDialog.d();
    r();
    d(1);
  }
  
  public void n()
  {
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "filterFirstFrameOK path=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStorySelectPendant.a());
  }
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryImagePlayerModule.c();
  }
  
  public void onBackPressed()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a(this)) {
      return;
    }
    SLog.a("Q.qqstory.record.NewStoryTakeVideoActivity", "onBackPressed, is video mode = %s", Boolean.valueOf(this.jdField_c_of_type_Boolean));
    if (this.jdField_c_of_type_Boolean)
    {
      d();
      return;
    }
    u();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "onClick : view = " + NewStoryViewController.a(paramView));
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "onClick : video state = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get());
    if (!this.jdField_g_of_type_Boolean) {
      return;
    }
    switch (paramView.getId())
    {
    default: 
      QQToast.a(this, "暂无此功能", 0).a();
      return;
    case 2131302778: 
      if (FlowCameraConstant.d == 2)
      {
        if (!this.f)
        {
          this.f = bool;
          if (!this.f) {
            break label206;
          }
          StoryReportor.a("video_shoot", "open_flash", 0, 0, new String[0]);
        }
        for (;;)
        {
          paramView.setSelected(this.f);
          return;
          bool = false;
          break;
          StoryReportor.a("video_shoot", "close_flash", 0, 0, new String[0]);
        }
      }
      QQToast.a(this, "当前无法使用闪关灯", 0).a();
      return;
    case 2131302780: 
      StoryReportor.a("video_shoot", "clk_now", 0, 0, new String[0]);
      paramView = new NowProxy();
      if (paramView.a())
      {
        SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "now app is installed");
        paramView.a(null);
        return;
      }
      StoryReportor.a("video_shoot", "exp_now", 0, 0, new String[0]);
      SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "now app is not installed, ask the user");
      localObject = DialogUtil.a(this, 230);
      ((QQCustomDialog)localObject).setTitle("首次开启直播需下载NOW应用");
      ((QQCustomDialog)localObject).setNegativeButton("取消", new iwm(this));
      ((QQCustomDialog)localObject).setPositiveButton("确定", new iwn(this, paramView));
      ((QQCustomDialog)localObject).getBtnight().getPaint().setFakeBoldText(true);
      ((QQCustomDialog)localObject).setCancelable(true);
      ((QQCustomDialog)localObject).getWindow().setBackgroundDrawable(new ColorDrawable(0));
      ((QQCustomDialog)localObject).show();
      return;
    case 2131302779: 
      if (CameraAbility.c())
      {
        if (FlowCameraConstant.d == 1) {
          StoryReportor.a("video_shoot", "camera_back", 0, 0, new String[0]);
        }
        for (;;)
        {
          a(-1, false);
          return;
          StoryReportor.a("video_shoot", "camera_front", 0, 0, new String[0]);
        }
      }
      QQToast.a(this, "前置摄像头暂不可用", 0).a();
      return;
    case 2131302777: 
      StoryReportor.a("video_shoot", "clk_left", 0, 0, new String[0]);
      d();
      return;
    case 2131302939: 
      label206:
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryViewController.m();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a().a();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a(this.jdField_a_of_type_AndroidWidgetImageView);
      return;
    }
    long l1 = a();
    if (this.y)
    {
      paramView = "2";
      if (FlowCameraConstant.d != 1) {
        break label626;
      }
    }
    label626:
    for (Object localObject = "1";; localObject = "2")
    {
      StoryReportor.a("video_edit", "clk_publish", 0, 0, new String[] { paramView, String.valueOf(l1), localObject });
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() != 4) {
        break label633;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCoverMgr.b(this.jdField_p_of_type_Int, this.jdField_q_of_type_Int, this.n, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec);
      p();
      return;
      paramView = "1";
      break;
    }
    label633:
    SLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", "publish button clicked but it's not preview state now, something error occur");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    BaseApplicationImpl.a().getSharedPreferences("Q.qqstory.record.NewStoryTakeVideoActivity", 4).edit().putInt("camera", FlowCameraConstant.d).commit();
    MusicComposeDialog.d();
    d(1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.g(this);
    r();
    jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(null);
  }
  
  public void onPause()
  {
    super.onPause();
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a() != 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 4) {
      v();
    }
    View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494);
    if (localView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
    }
    if ((!this.jdField_t_of_type_Boolean) && (!this.jdField_r_of_type_Boolean) && (!this.jdField_s_of_type_Boolean))
    {
      this.jdField_t_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 300000L);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.e(this);
    r();
  }
  
  public void onResume()
  {
    int i1 = 1;
    super.onResume();
    NativeVideoImage.resumeAll();
    AbstractGifImage.resumeAll();
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    }
    View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494);
    SLog.b("face", "onResume needChangeNewSurfaceView=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean + "mIsNeedSetup=" + this.m);
    if (this.m) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = true;
    }
    if ((localView == null) || (this.m) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean)) {
      Looper.myQueue().addIdleHandler(new iwi(this));
    }
    do
    {
      this.m = false;
      this.l = false;
      if ((this.jdField_t_of_type_Boolean) && (!this.jdField_r_of_type_Boolean) && (!this.jdField_s_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        this.jdField_t_of_type_Boolean = false;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.d(this);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c();
    } while (!this.w);
    this.w = false;
    if (CameraAbility.c()) {}
    for (;;)
    {
      a(i1, false);
      break;
      i1 = 2;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.c(this);
    QQPlayerService.c(BaseApplicationImpl.getContext());
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.l) {
      this.m = true;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.f(this);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!this.jdField_g_of_type_Boolean)
    {
      SLog.d("Q.qqstory.record.NewStoryTakeVideoActivity", "onTouchEvent but camera has not setup");
      return bool;
    }
    if (this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent))
    {
      SLog.a("Q.qqstory.record.NewStoryTakeVideoActivity", "mGestureDetector consume the touch event");
      return true;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryCameraZoom.a(paramMotionEvent))
    {
      SLog.a("Q.qqstory.record.NewStoryTakeVideoActivity", "mNewStoryCameraZoom consume the touch event");
      return true;
    }
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a(this, paramBoolean);
  }
  
  void p()
  {
    y();
    this.jdField_r_of_type_Boolean = true;
    CodecParam.K = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double;
    CodecParam.L = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
    CodecParam.J = 0;
    CodecParam.M = 0;
    CodecParam.R = a(this.D);
    SLog.b("Q.qqstory.record.NewStoryTakeVideoActivity", "onConfirmClick CodecParam.mRecordFrames" + CodecParam.L + " CodecParam.mRecordTime" + CodecParam.K);
    GenerateContext localGenerateContext = new GenerateContext();
    localGenerateContext.a(new GenerateDoodleArgs(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a(), NewStoryDoodle.b + "/doodle_" + System.currentTimeMillis() + ".png"));
    localGenerateContext.a(a());
    localGenerateContext.a(new GenerateVideoArgs(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.e, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex(), a(this.D)));
    localGenerateContext.a(new GenerateThumbArgs(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(), this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(), 0.0D, 0.0D));
    localGenerateContext.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a().a());
    localGenerateContext.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryLabelList.a());
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController.a();
    if (localObject != null) {
      localGenerateContext.c(AddressItem.generatePoiJson(QQStoryContext.a().a(), ((NewStoryFilterViewPagerController.POIFilterData)localObject).c, ((NewStoryFilterViewPagerController.POIFilterData)localObject).d, ((NewStoryFilterViewPagerController.POIFilterData)localObject).e, ((NewStoryFilterViewPagerController.POIFilterData)localObject).jdField_f_of_type_JavaLangString, ((NewStoryFilterViewPagerController.POIFilterData)localObject).jdField_g_of_type_JavaLangString, ((NewStoryFilterViewPagerController.POIFilterData)localObject).jdField_f_of_type_Int, ((NewStoryFilterViewPagerController.POIFilterData)localObject).jdField_g_of_type_Int, ((NewStoryFilterViewPagerController.POIFilterData)localObject).h));
    }
    localGenerateContext.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryDoodle.a());
    localGenerateContext.a(16);
    QQStoryMusicInfo localQQStoryMusicInfo = MusicComposeDialog.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
    boolean bool;
    int i1;
    if (localQQStoryMusicInfo == null)
    {
      localObject = null;
      bool = MusicComposeDialog.jdField_a_of_type_Boolean;
      if (localQQStoryMusicInfo != null) {
        break label557;
      }
      i1 = 0;
      label398:
      if (localQQStoryMusicInfo != null) {
        break label566;
      }
    }
    label557:
    label566:
    for (int i2 = 0;; i2 = localQQStoryMusicInfo.i)
    {
      localGenerateContext.a(new GenerateBackgroundMusicArgs(this, (String)localObject, bool, i1, i2));
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController.jdField_a_of_type_Boolean) {
        localGenerateContext.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryFilterViewPagerController.a());
      }
      SLog.c("Q.qqstory.record.NewStoryTakeVideoActivity", "PUBLISH start ...");
      a("请稍候", false, 500L);
      Stream.of(localGenerateContext).map(new ThreadOffFunction(2)).map(new GenerateThumbSegment()).map(new GenerateDoodleImageSegment()).map(new MergeThumbSegment()).map(new PublishVideoSegment()).map(new UIThreadOffFunction(this)).subscribe(new iwo(this, localGenerateContext));
      return;
      localObject = localQQStoryMusicInfo.jdField_g_of_type_JavaLangString;
      break;
      i1 = localQQStoryMusicInfo.jdField_g_of_type_Int;
      break label398;
    }
  }
  
  public void q()
  {
    c(-1);
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_Iwr != null)
    {
      this.jdField_a_of_type_Iwr.cancel();
      this.jdField_a_of_type_Iwr = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void s()
  {
    if (this.y) {
      r();
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a())) {
      return;
    }
    this.jdField_B_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
  }
  
  public void t()
  {
    if (this.y)
    {
      q();
      return;
    }
    c(this.jdField_B_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\NewStoryTakeVideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */