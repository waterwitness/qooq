package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.VideoDrawable;
import com.tencent.maxvideo.mediadevice.EncodeVideo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.bless.BlessBaseActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.bless.BlessPtvModule;
import com.tencent.mobileqq.activity.bless.BlessResultActivity;
import com.tencent.mobileqq.activity.bless.CountDownView;
import com.tencent.mobileqq.activity.bless.CountDownView.CountDownFinishedListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr.ViewBitmapSource;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.util.LyricParseHelper;
import com.tencent.mobileqq.lyric.widget.LyricViewController;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.shortvideo.ShortVideoEncodeHelper;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.TexturePreviewContext;
import com.tencent.mobileqq.shortvideo.mediaplay.TMMSWVideoView.OnSurfaceListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.AudioAnimationView;
import com.tencent.mobileqq.widget.CircleVideoDrawableView.VideoListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.mobileqq.widget.TransCircleMaskView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ProgressPieView;
import com.tencent.widget.ProgressPieView.OnProgressListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kqo;
import kqp;
import kqq;
import kqr;
import kqs;
import kqt;
import kqu;
import kqv;
import kqw;
import kqx;
import kqz;
import kra;
import krb;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;

public class BlessPTVActivity
  extends BlessBaseActivity
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, Handler.Callback, View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, CountDownView.CountDownFinishedListener, RMVideoSwitchCameraPicMgr.ViewBitmapSource, RMViewSTInterface, TMMSWVideoView.OnSurfaceListener, CircleVideoDrawableView.VideoListener, ProgressPieView.OnProgressListener
{
  public static final int a = -2;
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new EmptyDrawable(-10065297, jdField_m_of_type_Int, n);
  public static final String a = "BlessPTVActivity";
  public static final int b = 1001;
  public static final String b = "bless_history_thumb_path";
  public static final int c = 0;
  public static final String c = "bless_history_video_dir";
  public static final int d = 1;
  public static final String d = "bless_ptv_times";
  public static final int e = 2;
  public static final String e = "bless_ptv_frames";
  public static final int f = 3;
  public static final String f = "bless_ptv_video_mp4";
  public static final int g = 120;
  public static final String g = "bless_module_id";
  public static final int h = 15000;
  public static final String h = "bless_share_title";
  public static final int i = 30;
  public static final String i = "bless_ptv_last_click";
  public static final int j = 50;
  public static final String j = "bless_is_entered";
  public static final int k = 0;
  public static final String k = "bless_entered";
  public static final int l = 1;
  public static String l;
  static int m;
  public static String m;
  static int n;
  private int jdField_A_of_type_Int;
  private String jdField_A_of_type_JavaLangString;
  private int B;
  private int C;
  private int D;
  private int E;
  private int F;
  private int G;
  private int H;
  private int I;
  private float jdField_a_of_type_Float;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new kqp(this);
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public MediaPlayer a;
  private Handler jdField_a_of_type_AndroidOsHandler = new kqo(this);
  View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  VideoDrawable jdField_a_of_type_ComTencentImageVideoDrawable;
  private EncodeVideo jdField_a_of_type_ComTencentMaxvideoMediadeviceEncodeVideo;
  private BlessPTVActivity.MusicItemData jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData;
  public BlessPTVActivity.MusicListAdapter a;
  public CountDownView a;
  private RMVideoStateMgr jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
  private CameraCover jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover;
  CameraGLSurfaceView jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView;
  CameraTextureView jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraTextureView;
  private MessageForBlessPTV jdField_a_of_type_ComTencentMobileqqDataMessageForBlessPTV;
  private Lyric jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
  private LyricViewController jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController;
  public LyricViewDetail a;
  CameraExceptionHandler.Callback jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = new kqt(this);
  private CameraProxy jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
  public QQCustomDialog a;
  AudioAnimationView jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView;
  QQVideoView jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView;
  TransCircleMaskView jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView;
  public HorizontalListView a;
  ProgressPieView jdField_a_of_type_ComTencentWidgetProgressPieView;
  Runnable jdField_a_of_type_JavaLangRunnable = new kqu(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  boolean jdField_a_of_type_Boolean = false;
  public View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  Runnable jdField_b_of_type_JavaLangRunnable = new kqv(this);
  private ArrayList jdField_b_of_type_JavaUtilArrayList;
  public View c;
  private Button jdField_c_of_type_AndroidWidgetButton;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f = true;
  private long jdField_g_of_type_Long;
  private boolean jdField_g_of_type_Boolean;
  private boolean h;
  private boolean i;
  private boolean j = true;
  private String u;
  private String v;
  private int jdField_w_of_type_Int;
  private String jdField_w_of_type_JavaLangString;
  private int jdField_x_of_type_Int;
  private String jdField_x_of_type_JavaLangString;
  private int jdField_y_of_type_Int;
  private String jdField_y_of_type_JavaLangString;
  private int jdField_z_of_type_Int;
  private String jdField_z_of_type_JavaLangString;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    l = "";
    jdField_m_of_type_JavaLangString = "";
    Resources localResources = BaseApplicationImpl.a.getResources();
    jdField_m_of_type_Int = AIOUtils.a(160.0F, localResources);
    n = AIOUtils.a(160.0F, localResources);
  }
  
  public BlessPTVActivity()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void D()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131372393));
      if (VersionUtils.g())
      {
        this.jdField_a_of_type_AndroidWidgetButton.setBackground(getResources().getDrawable(2130837970));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130837970));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(getResources().getString(2131372394));
    if (VersionUtils.g())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackground(getResources().getDrawable(2130837969));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(getResources().getDrawable(2130837969));
  }
  
  private void E()
  {
    label236:
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)View.inflate(this, 2130903112, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = ((CameraGLSurfaceView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131296496));
      this.jdField_a_of_type_ComTencentWidgetProgressPieView = ((ProgressPieView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297181));
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(0);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail = ((LyricViewDetail)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297176));
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().setHighlightLineNumber(-2);
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessCountDownView = ((CountDownView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297179));
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessCountDownView.setListener(this);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131296826);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297177);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297178);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraTextureView != null) {
        break label509;
      }
      Object localObject = new FrameLayout.LayoutParams(1, 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraTextureView = new CameraTextureView(getApplicationContext());
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraTextureView.a = new TexturePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, this.jdField_x_of_type_Int, this.jdField_y_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraTextureView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraTextureView.setId(2131296494);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraTextureView, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraTextureView);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraTextureView.a);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVideoContext(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180).setOnClickListener(this);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int != 0)) {
        break label527;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180).setVisibility(0);
      localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180);
      if (!this.f) {
        break label520;
      }
      i1 = 2130837995;
      label357:
      ((ImageView)localObject).setImageResource(i1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297176).setVisibility(8);
      label377:
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(true);
      }
      a(this.jdField_a_of_type_AndroidWidgetImageView);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        break label545;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView(this.jdField_a_of_type_AndroidWidgetImageView, 2);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView, 3);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover);
      this.jdField_g_of_type_Boolean = true;
      if (QLog.isDevelopLevel()) {
        QLog.d("BlessPTV", 4, " setupCameraUI ");
      }
      return;
      a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover);
      break;
      label509:
      a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraTextureView);
      break label236;
      label520:
      i1 = 2130837994;
      break label357;
      label527:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180).setVisibility(8);
      break label377;
      label545:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
    }
  }
  
  private void F()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData;
    if (localObject2 == null) {
      return;
    }
    int i1 = ((BlessPTVActivity.MusicItemData)localObject2).b;
    if (i1 == 1) {}
    for (Object localObject1 = getString(2131372377);; localObject1 = getString(2131372378))
    {
      localObject1 = DialogUtil.a(this, 230, getResources().getString(2131367535), (String)localObject1, getResources().getString(2131372379), getResources().getString(2131372380), new kqz(this, i1, (BlessPTVActivity.MusicItemData)localObject2), new kra(this));
      localObject2 = ((QQCustomDialog)localObject1).getMessageTextView();
      ViewGroup.LayoutParams localLayoutParams = ((TextView)localObject2).getLayoutParams();
      localLayoutParams.width = -1;
      ((TextView)localObject2).setLayoutParams(localLayoutParams);
      ((TextView)localObject2).setGravity(17);
      ((QQCustomDialog)localObject1).setMessageCount(null);
      ((QQCustomDialog)localObject1).getTitleTextView().getPaint().setFakeBoldText(true);
      localObject2 = ((QQCustomDialog)localObject1).getWindow();
      ((Window)localObject2).getAttributes().dimAmount = 0.7F;
      ((Window)localObject2).addFlags(2);
      ((QQCustomDialog)localObject1).show();
      return;
    }
  }
  
  private void G()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      J();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int != 0)
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(8);
    r();
  }
  
  private void H()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessCountDownView.b();
    }
  }
  
  private void I()
  {
    if (this.C == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    localIntentFilter.addAction("android.intent.action.PHONE_STATE");
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    try
    {
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.C = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void J()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
  }
  
  private void K()
  {
    if (!b())
    {
      B();
      return;
    }
    if ((this.jdField_w_of_type_JavaLangString != null) && (this.jdField_w_of_type_JavaLangString.equals(this.jdField_z_of_type_JavaLangString)) && (FileUtils.b(this.jdField_z_of_type_JavaLangString)))
    {
      localObject2 = new SessionInfo();
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("uin", "0");
      ((Intent)localObject1).putExtra("uintype", ((SessionInfo)localObject2).jdField_a_of_type_Int);
      ((Intent)localObject1).putExtra("troop_uin", ((SessionInfo)localObject2).b);
      ((Intent)localObject1).putExtra("file_send_business_type", 3);
      ((Intent)localObject1).putExtra("bless_uin_list", this.jdField_a_of_type_JavaUtilArrayList);
      ((Intent)localObject1).putExtra("is_existed_bless_ptv", true);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
      if (localObject2 == null)
      {
        QQToast.a(this, "记录文件状态异常或已丢失...", 0).a();
        localObject1 = BaseApplication.getContext().getSharedPreferences("BlessPTVActivity", 0).edit();
        ((SharedPreferences.Editor)localObject1).putString(this.app.f() + "bless_history_thumb_path", "");
        ((SharedPreferences.Editor)localObject1).putString(this.app.f() + "bless_history_video_dir", "");
        ((SharedPreferences.Editor)localObject1).putInt(this.app.f() + "bless_ptv_times", 0);
        ((SharedPreferences.Editor)localObject1).putInt(this.app.f() + "bless_ptv_frames", 0);
        ((SharedPreferences.Editor)localObject1).commit();
        finish();
        return;
      }
      ((Intent)localObject1).putExtra("existed_bless_ptv_msgdata", (byte[])localObject2);
      ((Intent)localObject1).setClass(this, SendVideoActivity.class);
      startActivityForResult((Intent)localObject1, 1001);
      return;
    }
    if ((!FileUtils.b(this.jdField_z_of_type_JavaLangString)) && (!TextUtils.isEmpty(l)) && (!TextUtils.isEmpty(jdField_m_of_type_JavaLangString)) && (this.jdField_z_of_type_JavaLangString.equals(l)) && (FileUtils.b(jdField_m_of_type_JavaLangString))) {
      this.jdField_z_of_type_JavaLangString = jdField_m_of_type_JavaLangString;
    }
    Object localObject1 = new SessionInfo();
    ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = "0";
    ((SessionInfo)localObject1).jdField_a_of_type_Int = 0;
    Object localObject2 = getIntent();
    ((Intent)localObject2).putExtra("PhotoConst.SEND_SESSION_INFO", (Parcelable)localObject1);
    ((Intent)localObject2).putExtra("bless_ptv_mp4_path", this.jdField_z_of_type_JavaLangString);
    setIntent((Intent)localObject2);
    FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, 1.0F, true, 0.0D, 0.0D, null, true, 0, 0);
  }
  
  private void L()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
    }
  }
  
  private void M()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
    }
  }
  
  private void N()
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int == 0)
    {
      this.f = false;
      localImageView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180);
      if (!this.f) {
        break label96;
      }
    }
    label96:
    for (int i1 = 2130837995;; i1 = 2130837994)
    {
      localImageView.setImageResource(i1);
      if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.c();
      }
      if (this.jdField_a_of_type_ComTencentWidgetProgressPieView != null) {
        this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onPause();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
      return;
    }
  }
  
  private void O()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
  }
  
  private void P()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.pause();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVisibility(4);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
  }
  
  private void Q()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
  }
  
  private void R()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.setVideoContext(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onPause();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView = null;
    }
  }
  
  private void S()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.pause();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnTouchListener(null);
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
    }
  }
  
  private int a(int paramInt1, int paramInt2, int[] paramArrayOfInt, boolean paramBoolean)
  {
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getMeasuredHeight();
    paramArrayOfInt[0] = paramInt2;
    paramArrayOfInt[1] = paramInt2;
    paramArrayOfInt[2] = paramInt1;
    paramArrayOfInt[3] = paramInt1;
    paramArrayOfInt[4] = paramInt2;
    paramArrayOfInt[5] = paramInt2;
    return 0;
  }
  
  private void a(View paramView)
  {
    if (paramView != null)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent != null) {
        ((ViewGroup)localViewParent).removeView(paramView);
      }
    }
  }
  
  private void a(RMVideoClipSpec paramRMVideoClipSpec)
  {
    paramRMVideoClipSpec.e = 240;
    paramRMVideoClipSpec.f = 240;
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail, boolean paramBoolean)
  {
    paramString = FileUtils.a(new File(paramString));
    if (TextUtils.isEmpty(paramString)) {}
    boolean bool;
    label66:
    do
    {
      return;
      LyricViewInternal localLyricViewInternal = this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a();
      if (paramBoolean) {
        break;
      }
      bool = true;
      localLyricViewInternal.setHighlightCurrentLine(bool);
      if (!paramBoolean) {
        break label129;
      }
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().setHighlightLineNumber(-1);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = LyricParseHelper.a(paramString, true);
    } while (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric == null);
    if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController == null) {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController = new LyricViewController(paramLyricViewDetail);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric, null, null);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b(0);
      return;
      bool = false;
      break;
      label129:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().setHighlightLineNumber(-2);
      break label66;
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(paramLyricViewDetail);
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, "mixedEncode() sourceFileDir=" + paramString1 + ", sourceMusicPath=" + paramString2 + ", audioDuration=" + paramInt2);
    }
    Object localObject1 = new String[3];
    if (!a(paramString1, (String[])localObject1)) {
      QQToast.a(this, " 录制文件异常...", 0).a();
    }
    label543:
    do
    {
      for (;;)
      {
        return;
        if (this.jdField_a_of_type_ComTencentMaxvideoMediadeviceEncodeVideo == null) {
          this.jdField_a_of_type_ComTencentMaxvideoMediadeviceEncodeVideo = new EncodeVideo(this.jdField_a_of_type_AndroidOsHandler);
        }
        paramString1 = localObject1[0];
        paramString1 = localObject1[1];
        localObject1 = new ShortVideoEncodeHelper();
        int i1 = -1;
        Object localObject2;
        switch (paramInt1)
        {
        default: 
          return;
        case 0: 
          int i2 = VcSystemInfo.f();
          if ((!VcSystemInfo.e()) || (i2 <= 2)) {
            break label543;
          }
          localObject2 = getApplicationContext().getFilesDir().getParent() + "/txlib/libtraeimp-armeabi-v7a.so";
          if (QLog.isColorLevel()) {
            QLog.d("BlessPTVActivity", 2, "mixedEncode() encodeHelper.startMixWithBgAudio cpuArchitecure=" + i2 + " mixLibSoPath=" + (String)localObject2);
          }
          break;
        }
        try
        {
          if (new File((String)localObject2).exists()) {}
          for (paramInt1 = ((ShortVideoEncodeHelper)localObject1).startMixWithBgAudio(paramString1, paramString2, paramInt1, (String)localObject2, paramInt2);; paramInt1 = -1)
          {
            if (paramInt1 != 0) {
              QQToast.a(this, "音频合成异常", 0).a();
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("BlessPTVActivity", 2, "mixedEncode() AUIDO_MIX_OPTION_DEFAULT result=" + paramInt1);
            return;
            localObject2 = new File(paramString1);
            if (((File)localObject2).exists()) {
              ((File)localObject2).delete();
            }
            try
            {
              ((File)localObject2).createNewFile();
              paramInt1 = ((ShortVideoEncodeHelper)localObject1).startMixWithBgAudio(paramString1, paramString2, paramInt1, null, paramInt2);
              if (paramInt1 != 0) {
                QQToast.a(this, "音频合成异常", 0).a();
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("BlessPTVActivity", 2, "mixedEncode() AUDIO_MIX_OPTION_IGNORE_SOURCE_AF result=" + paramInt1);
              return;
            }
            catch (Throwable paramString1)
            {
              for (;;)
              {
                paramInt1 = i1;
                if (QLog.isColorLevel())
                {
                  QLog.d("BlessPTVActivity", 2, "mixedEncode() encodeHelper.startMixWithBgAudio IGNORE_SOURCE_AF ERROR exception=" + paramString1.getMessage());
                  paramInt1 = i1;
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("BlessPTVActivity", 2, "mixedEncode() mixLibSoFile =" + (String)localObject2 + " not exist");
            }
          }
        }
        catch (Throwable paramString1)
        {
          for (;;)
          {
            paramInt1 = i1;
            if (QLog.isColorLevel())
            {
              QLog.d("BlessPTVActivity", 2, "mixedEncode() encodeHelper.startMixWithBgAudio DEFAULT ERROR exception=" + paramString1.getMessage());
              paramInt1 = i1;
            }
          }
        }
      }
      QQToast.a(this, "你的手机不支持混音", 0).a();
    } while (!QLog.isColorLevel());
    QLog.d("BlessPTVActivity", 2, "mixedEncode() AUIDO_MIX_OPTION_DEFAULT ERROR not support mix audio");
  }
  
  private boolean a(String paramString, String[] paramArrayOfString)
  {
    String str1 = null;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject1 = new File(paramString);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {
      return false;
    }
    String[] arrayOfString = ((File)localObject1).list();
    if (arrayOfString == null) {
      return false;
    }
    int i2 = arrayOfString.length;
    int i1 = 0;
    Object localObject2 = null;
    localObject1 = null;
    if (i1 < i2)
    {
      String str2 = arrayOfString[i1];
      Object localObject4;
      Object localObject3;
      if (str2.endsWith(".vf"))
      {
        localObject4 = paramString + File.separator + str2;
        localObject3 = localObject2;
      }
      for (;;)
      {
        i1 += 1;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break;
        if (str2.endsWith(".af"))
        {
          localObject3 = paramString + File.separator + str2;
          localObject4 = localObject1;
        }
        else
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (str2.endsWith(".ini"))
          {
            str1 = paramString + File.separator + str2;
            localObject3 = localObject2;
            localObject4 = localObject1;
          }
        }
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
      return false;
    }
    if (paramArrayOfString != null)
    {
      paramArrayOfString[0] = localObject1;
      paramArrayOfString[1] = localObject2;
      paramArrayOfString[2] = str1;
    }
    return true;
  }
  
  private void c(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessPTVActivity", 2, "play");
      }
      J();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(new kqq(this));
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(new kqr(this));
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BlessPTVActivity", 2, "play", paramString);
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData == null) {}
    for (;;)
    {
      return false;
      try
      {
        int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.b;
        if (i1 == 2)
        {
          if (VipUtils.a(this.app)) {
            return true;
          }
        }
        else if (i1 == 1)
        {
          if (!VipUtils.a(this.app))
          {
            boolean bool = VipUtils.b(this.app);
            if (!bool) {}
          }
          else
          {
            return true;
          }
        }
        else if (i1 == 0) {
          return true;
        }
      }
      catch (Throwable localThrowable) {}
    }
    return false;
  }
  
  private void d(boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
    MessageForBlessPTV localMessageForBlessPTV = (MessageForBlessPTV)localMessageForShortVideo;
    if (localMessageForBlessPTV != null)
    {
      A();
      this.jdField_b_of_type_Boolean = true;
      this.app.a().a(this.app, localMessageForShortVideo, localMessageForBlessPTV.uinList, a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int, localMessageForShortVideo.videoFileTime));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("BlessPTVActivity", 2, "error case no ptv message in manager");
  }
  
  public void E_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BlessPTVActivity", 4, " initUI_InitState ");
    }
  }
  
  public void F_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BlessPTVActivity", 4, " initUI_RecordState ");
    }
  }
  
  public void G_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BlessPTVActivity", 4, " initUI_IdleState ");
    }
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    View localView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getChildAt(0);
    if (TextureView.class.isInstance(localView)) {
      return ((TextureView)localView).getBitmap(paramInt1, paramInt2);
    }
    return null;
  }
  
  public List a()
  {
    this.jdField_b_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.c();
    if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() == 0))
    {
      finish();
      return null;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilArrayList.size() + 2);
    Object localObject3 = BaseApplication.getContext().getSharedPreferences("BlessPTVActivity", 0);
    Object localObject2 = this.app.f();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = ((SharedPreferences)localObject3).getString((String)localObject1 + "bless_history_thumb_path", "");
    Object localObject4 = ((SharedPreferences)localObject3).getString((String)localObject1 + "bless_history_video_dir", "");
    String str1 = ((SharedPreferences)localObject3).getString((String)localObject1 + "bless_ptv_video_mp4", "");
    int i3 = ((SharedPreferences)localObject3).getInt((String)localObject1 + "bless_module_id", -1);
    String str2 = ((SharedPreferences)localObject3).getString((String)localObject1 + "bless_share_title", "");
    int i4 = ((SharedPreferences)localObject3).getInt((String)localObject1 + "bless_ptv_times", 0);
    int i5 = ((SharedPreferences)localObject3).getInt((String)localObject1 + "bless_ptv_frames", 0);
    int i2 = ((SharedPreferences)localObject3).getInt((String)localObject1 + "bless_ptv_last_click", 0);
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(str1)))
    {
      localObject1 = new File((String)localObject2);
      localObject3 = new File(str1);
      if ((!((File)localObject1).exists()) || (!((File)localObject3).exists())) {}
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_d_of_type_Boolean = true;
        this.G = i5;
        this.F = i4;
        this.u = ((String)localObject4);
        this.jdField_v_of_type_JavaLangString = ((String)localObject2);
        this.jdField_w_of_type_JavaLangString = str1;
        this.E = i3;
        this.jdField_x_of_type_JavaLangString = str2;
        localObject1 = new BlessPTVActivity.MusicItemData();
        ((BlessPTVActivity.MusicItemData)localObject1).jdField_a_of_type_Int = -1;
        ((BlessPTVActivity.MusicItemData)localObject1).jdField_a_of_type_JavaLangString = "历史记录";
        ((BlessPTVActivity.MusicItemData)localObject1).b = 0;
        i1 = DisplayUtil.a(this, 50.0F);
        localObject3 = new BitmapFactory.Options();
      }
      try
      {
        localObject4 = new FileInputStream((String)localObject2);
        ((BitmapFactory.Options)localObject3).inSampleSize = ((int)ImageUtil.a((InputStream)localObject4, i1 * 2, i1 * 2));
        ((BlessPTVActivity.MusicItemData)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getResources(), ImageUtil.a(BitmapFactory.decodeFile((String)localObject2, (BitmapFactory.Options)localObject3), i1, i1, i1));
        ((InputStream)localObject4).close();
        if (((BlessPTVActivity.MusicItemData)localObject1).jdField_a_of_type_Int == i2) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData = ((BlessPTVActivity.MusicItemData)localObject1);
        }
        localArrayList.add(localObject1);
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BlessPtvModule)((Iterator)localObject1).next();
          if (!((BlessPtvModule)localObject2).isComplete())
          {
            if (QLog.isColorLevel()) {
              QLog.e("BlessPTVActivity", 2, "module " + ((BlessPtvModule)localObject2).id + " is not complete!");
            }
            if (((BlessPtvModule)localObject2).id == "0") {
              localArrayList.add(null);
            }
          }
          else
          {
            localObject3 = new BlessPTVActivity.MusicItemData();
            ((BlessPTVActivity.MusicItemData)localObject3).jdField_a_of_type_Int = Integer.valueOf(((BlessPtvModule)localObject2).id).intValue();
            ((BlessPTVActivity.MusicItemData)localObject3).jdField_a_of_type_JavaLangString = ((BlessPtvModule)localObject2).title;
            ((BlessPTVActivity.MusicItemData)localObject3).b = Integer.valueOf(((BlessPtvModule)localObject2).vipLevel).intValue();
            ((BlessPTVActivity.MusicItemData)localObject3).jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((BlessPtvModule)localObject2).getPngDrawable(this);
            ((BlessPTVActivity.MusicItemData)localObject3).jdField_c_of_type_JavaLangString = ((BlessPtvModule)localObject2).getM4aPath();
            ((BlessPTVActivity.MusicItemData)localObject3).jdField_d_of_type_JavaLangString = ((BlessPtvModule)localObject2).getLrcPath();
            ((BlessPTVActivity.MusicItemData)localObject3).jdField_c_of_type_Int = ((BlessPtvModule)localObject2).audioLength;
            ((BlessPTVActivity.MusicItemData)localObject3).e = ((BlessPtvModule)localObject2).shareTitle;
            localArrayList.add(localObject3);
            if (((BlessPTVActivity.MusicItemData)localObject3).jdField_a_of_type_Int == i2) {
              this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData = ((BlessPTVActivity.MusicItemData)localObject3);
            }
            if (((BlessPtvModule)localObject2).id == "0") {
              localArrayList.add(null);
            }
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData = ((BlessPTVActivity.MusicItemData)localArrayList.get(0));
        }
        this.H = localArrayList.indexOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData);
        return localArrayList;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;) {}
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, "[@] previewSizeAdjustUI:width=" + paramInt1 + " height=" + paramInt2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null) {
      if (QLog.isColorLevel()) {
        QLog.i("BlessPTVActivity", 2, "[previewSizeAdjustUI]rmStateMgr " + null);
      }
    }
    RMVideoClipSpec localRMVideoClipSpec;
    CameraGLSurfaceView localCameraGLSurfaceView;
    do
    {
      int[] arrayOfInt;
      do
      {
        return;
        this.jdField_z_of_type_Int = paramInt1;
        this.A = paramInt2;
        arrayOfInt = new int[6];
        localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
        localCameraGLSurfaceView = (CameraGLSurfaceView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131296496);
      } while (localCameraGLSurfaceView == null);
      int i1 = a(paramInt1, paramInt2, arrayOfInt, true);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localCameraGLSurfaceView.getLayoutParams();
      localLayoutParams.width = arrayOfInt[2];
      localLayoutParams.height = arrayOfInt[3];
      localLayoutParams.topMargin = i1;
      localLayoutParams.gravity = 17;
      localCameraGLSurfaceView.setLayoutParams(localLayoutParams);
      localRMVideoClipSpec.jdField_c_of_type_Int = arrayOfInt[0];
      localRMVideoClipSpec.jdField_d_of_type_Int = arrayOfInt[1];
      localRMVideoClipSpec.e = paramInt1;
      localRMVideoClipSpec.f = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(5, localRMVideoClipSpec, 0);
      localRMVideoClipSpec.e = arrayOfInt[4];
      localRMVideoClipSpec.f = arrayOfInt[5];
      a(localRMVideoClipSpec);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localRMVideoClipSpec, false);
    } while (localCameraGLSurfaceView == null);
    localCameraGLSurfaceView.setPreviewSize(this.jdField_z_of_type_Int, this.A, localRMVideoClipSpec);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    J();
    if (paramInt1 == 1) {
      if (TextUtils.isEmpty(paramString))
      {
        QQToast.a(this, "视频出现异常", 0).a();
        a(0, null, 0, 0);
      }
    }
    label435:
    do
    {
      do
      {
        return;
        this.I = 1;
        if (QLog.isColorLevel()) {
          QLog.d("BlessPTVActivity", 2, " toState = " + paramInt1 + " videoPath " + paramString + " times = " + paramInt2 + " frames = " + paramInt3);
        }
        this.jdField_z_of_type_JavaLangString = paramString;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int == -1)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          paramInt3 = this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight();
          int i1 = this.jdField_a_of_type_AndroidWidgetFrameLayout.getWidth();
          paramInt2 = i1;
          paramInt1 = paramInt3;
          if (i1 != paramInt3)
          {
            paramInt2 = Math.min(i1, paramInt3);
            ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
            localLayoutParams.width = paramInt2;
            localLayoutParams.height = paramInt2;
            this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
            paramInt1 = paramInt2;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null) {
            break label435;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView = new QQVideoView(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setDimension(paramInt2, paramInt1);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnTouchListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnPreparedListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnCompletionListener(this);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setOnErrorListener(this);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVideoPath(paramString);
          a(this.jdField_b_of_type_AndroidWidgetImageView);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_b_of_type_AndroidWidgetImageView);
          a(this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView);
          a(this.jdField_a_of_type_AndroidWidgetImageButton);
          a(this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView);
          this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetImageButton);
          this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView);
          this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
          this.jdField_g_of_type_Boolean = false;
          return;
          this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
          this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
          break;
          a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView);
        }
        this.I = 0;
        P();
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        findViewById(2131297166).setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(true);
        E();
        if (this.jdField_g_of_type_Boolean)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
        }
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int == 0) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int != 0) || (!this.f)));
      c(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_JavaLangString);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int == 0);
    paramString = (LyricViewDetail)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297176);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_d_of_type_JavaLangString, paramString, true);
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
    p();
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    runOnUiThread(new kqx(this, paramString, paramInt));
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(Message paramMessage) {}
  
  public void a(boolean paramBoolean) {}
  
  public boolean a()
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList.size() == 0))
    {
      this.i = true;
      super.finish();
      return false;
    }
    if (!"mounted".equals(Environment.getExternalStorageState()))
    {
      QQToast.a(this, 2131372288, 0).a();
      this.i = true;
      finish();
      return false;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.jdField_x_of_type_Int = localDisplayMetrics.widthPixels;
    this.jdField_y_of_type_Int = localDisplayMetrics.heightPixels;
    this.jdField_a_of_type_Float = (this.jdField_y_of_type_Int / this.jdField_x_of_type_Int);
    com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.jdField_d_of_type_Int = 1;
    if (!CameraAbility.c()) {
      com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.jdField_d_of_type_Int = 2;
    }
    com.tencent.mobileqq.activity.richmedia.FlowCameraConstant.jdField_a_of_type_Float = 1.0F;
    int i1 = NetworkUtil.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.app, 0, null, true, 0, i1, 120);
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, this.app.a(), this))
    {
      o();
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(this, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback));
    return true;
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " getM4aFileRealTime... musicPath=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_JavaLangString)) {
      return -1;
    }
    l1 = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " getM4aFileRealTime... startTime == " + l1);
    }
    localObject = null;
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_JavaLangString);
      String str = localMediaMetadataRetriever.extractMetadata(9);
      localObject = str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        try
        {
          i1 = Integer.valueOf((String)localObject).intValue();
          long l2 = SystemClock.elapsedRealtime();
          if (QLog.isColorLevel()) {
            QLog.d("BlessPTVActivity", 2, " getM4aFileRealTime... endtime == " + l2 + " usedtime=" + (l2 - l1));
          }
          return i1;
          localIllegalArgumentException = localIllegalArgumentException;
          localIllegalArgumentException.printStackTrace();
        }
        catch (NumberFormatException localNumberFormatException)
        {
          i1 = -1;
          continue;
        }
        int i1 = -1;
      }
    }
    localMediaMetadataRetriever.release();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      d(true);
    }
  }
  
  protected void c(boolean paramBoolean)
  {
    MessageForShortVideo localMessageForShortVideo;
    QQAppInterface localQQAppInterface;
    int i1;
    if (paramBoolean)
    {
      setResult(-1, getIntent());
      w();
      localMessageForShortVideo = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a();
      localObject = (MessageForBlessPTV)localMessageForShortVideo;
      if (((MessageForBlessPTV)localObject).uinList != null)
      {
        localQQAppInterface = this.app;
        i1 = ((MessageForBlessPTV)localObject).uinList.size();
        if (this.s != null) {
          break label126;
        }
      }
    }
    label126:
    for (Object localObject = "";; localObject = this.s)
    {
      ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006196", "0X8006196", 0, 0, String.valueOf(2), String.valueOf(i1), (String)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int + "|" + localMessageForShortVideo.videoFileTime);
      return;
    }
  }
  
  public int c_()
  {
    return -1;
  }
  
  public void d() {}
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1001)
    {
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (!paramIntent.getBooleanExtra("is_existed_bless_ptv", false))) {}
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.e();
          this.jdField_v_of_type_JavaLangString = paramIntent.getStringExtra("thumbfile_send_path");
          this.jdField_w_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a().videoFileName;
          this.E = this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int;
          this.jdField_x_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.e;
          SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("BlessPTVActivity", 0).edit();
          String str = this.app.f();
          paramIntent = str;
          if (str == null) {
            paramIntent = "";
          }
          localEditor.putString(paramIntent + "bless_history_thumb_path", this.jdField_v_of_type_JavaLangString);
          localEditor.putString(paramIntent + "bless_history_video_dir", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
          localEditor.putInt(paramIntent + "bless_ptv_times", (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
          localEditor.putInt(paramIntent + "bless_ptv_frames", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex());
          localEditor.putString(paramIntent + "bless_ptv_video_mp4", this.jdField_w_of_type_JavaLangString);
          localEditor.putInt(paramIntent + "bless_module_id", this.E);
          localEditor.putString(paramIntent + "bless_share_title", this.jdField_x_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("BlessPTVActivity", 2, " upload ptv video mp4 path =  " + this.jdField_w_of_type_JavaLangString);
          }
          localEditor.commit();
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("BlessPTVActivity", 2, " upload ptv happen error ");
            }
            paramIntent.printStackTrace();
          }
          a(this.s);
          return;
        }
        if ((this.s == null) || (this.s.equals("")) || (this.t == null) || (this.t.equals("")))
        {
          d(false);
          return;
        }
      }
      QQToast.a(this, 2131372388, 1).a();
      return;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mNeedStatusTrans = false;
    this.jdField_v_of_type_Int = 2;
    super.doOnCreate(paramBundle);
    super.setContentView(2130903109);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131297167));
    findViewById(2131297202).setVisibility(4);
    findViewById(2131297205).setVisibility(4);
    findViewById(2131297142).setVisibility(4);
    paramBundle = BaseApplication.getContext().getSharedPreferences("BlessPTVActivity", 0);
    if (!paramBundle.getBoolean("bless_is_entered" + this.app.f(), false))
    {
      paramBundle.edit().putBoolean("bless_is_entered" + this.app.f(), true).commit();
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131297169));
      this.jdField_d_of_type_AndroidViewView = findViewById(2131297168);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      if (BlessManager.g() < DisplayUtil.a(this, 360.0F)) {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838003);
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    }
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131297164));
    this.jdField_a_of_type_AndroidWidgetButton.setOnTouchListener(this);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131297136));
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)findViewById(2131297165));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)findViewById(2131297166));
    paramBundle = new BlessPTVActivity.MusicListAdapter(this, a());
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(paramBundle);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    BlessPTVActivity.MusicListAdapter.a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData);
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicListAdapter = paramBundle;
    D();
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramBundle = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBundle);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramBundle = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView = new TransCircleMaskView(this);
    paramBundle = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView.setUITopOffset(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView.setIsUseMaskRadiusRatios(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView.setmMaskRadiusBless(AIOUtils.a(4.0F, getResources()));
    this.jdField_a_of_type_ComTencentMobileqqWidgetTransCircleMaskView.setLayoutParams(paramBundle);
    paramBundle = new ImageButton(getApplicationContext());
    paramBundle.setId(2131301597);
    paramBundle.setScaleType(ImageView.ScaleType.CENTER);
    paramBundle.setImageResource(2130837998);
    paramBundle.setBackgroundDrawable(null);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    paramBundle.setLayoutParams(localLayoutParams);
    paramBundle.setVisibility(8);
    paramBundle.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageButton = paramBundle;
    paramBundle = new AudioAnimationView(this);
    localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 81;
    localLayoutParams.bottomMargin = AIOUtils.a(10.0F, getResources());
    paramBundle.setId(2131296350);
    paramBundle.setLayoutParams(localLayoutParams);
    paramBundle.setRectCount(7);
    paramBundle.setSyle(1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView = paramBundle;
    if (!a()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy == null)
    {
      QQToast.a(this, " 摄像头初始化异常 ", 0).a();
      finish();
      this.i = true;
      return false;
    }
    E();
    I();
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.i) {
      return;
    }
    J();
    R();
    S();
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.C = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData != null) {}
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int;; i1 = 0)
    {
      int i2 = i1;
      if (i1 == -1) {
        i2 = 0;
      }
      BaseApplication.getContext().getSharedPreferences("BlessPTVActivity", 0).edit().putInt(this.app.f() + "bless_ptv_last_click", i2).commit();
      return;
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.i) {
      return;
    }
    L();
    if (this.I == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessCountDownView.b();
      N();
    }
    for (;;)
    {
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131296494);
      if ((!CameraCompatibleList.d(CameraCompatibleList.b)) || (localView == null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
      return;
      if (this.I == 1)
      {
        P();
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.I == 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131296494) == null) {
        a(0, null, 0, 0);
      }
    }
    for (;;)
    {
      if ((this.j) && (this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getVisibility() == 0))
      {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.post(new kqw(this));
        this.j = false;
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onResume();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      continue;
      if (this.I != 1) {}
    }
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("BlessPTVActivity", 4, " initRecordEngineOK ");
    }
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
      return false;
    case 1: 
      s();
      return false;
    case 2: 
      a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.pause();
    }
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
    return false;
  }
  
  public void i() {}
  
  public void j() {}
  
  public void k()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    S();
  }
  
  public void l() {}
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " notifyAvcodecOK ");
    }
  }
  
  protected void n()
  {
    K();
  }
  
  public void o()
  {
    super.o();
  }
  
  protected void onAccountChanged()
  {
    super.onAccountChanged();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      super.onClick(paramView);
      return;
      if (this.I != 1) {
        continue;
      }
      P();
      C();
      continue;
      a(0, null, 0, 0);
      try
      {
        new File(this.jdField_z_of_type_JavaLangString).delete();
        ReportController.b(this.app, "CliOper", "", "", "0X8006193", "0X8006193", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int), "", "", "");
        continue;
        Object localObject = (ImageView)paramView;
        if (!this.f) {
          bool = true;
        }
        this.f = bool;
        if (this.f) {}
        for (int i1 = 2130837995;; i1 = 2130837994)
        {
          ((ImageView)localObject).setImageResource(i1);
          if (!this.f) {
            break label243;
          }
          if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
            break label229;
          }
          this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
          break;
        }
        label229:
        c(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_JavaLangString);
        continue;
        label243:
        if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
          continue;
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        continue;
        q();
        continue;
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_d_of_type_AndroidViewView.setVisibility(8);
        continue;
        if (this.I != 1) {
          continue;
        }
        try
        {
          localObject = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Camera";
          if ((this.jdField_z_of_type_JavaLangString == null) || (!this.jdField_z_of_type_JavaLangString.contains((CharSequence)localObject))) {
            continue;
          }
          new File(this.jdField_z_of_type_JavaLangString).delete();
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.d();
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, "...onItemClick...");
    }
    paramView = ((BlessPTVActivity.MusicListAdapter)paramAdapterView.getAdapter()).a(paramInt);
    paramAdapterView = (BlessPTVActivity.MusicListAdapter)paramAdapterView.getAdapter();
    if ((paramView == null) || (paramAdapterView == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (paramView.jdField_a_of_type_Int == -1) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int == -1) {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView == null) {
          a(1, this.jdField_w_of_type_JavaLangString, 0, 0);
        }
      }
    }
    for (;;)
    {
      D();
      ReportController.b(this.app, "CliOper", "", "", "0X8006191", "0X8006191", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int), "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData = paramView;
      BlessPTVActivity.MusicListAdapter.a(paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData);
      paramAdapterView.notifyDataSetChanged();
      a(1, this.jdField_w_of_type_JavaLangString, 0, 0);
      continue;
      this.H = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int == paramView.jdField_a_of_type_Int)
      {
        if (paramView.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180).setVisibility(0);
          paramAdapterView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180);
          if (this.f) {}
          for (paramInt = 2130837995;; paramInt = 2130837994)
          {
            paramAdapterView.setImageResource(paramInt);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297176).setVisibility(8);
            if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail != null) {
              this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(8);
            }
            if (!this.f) {
              break label341;
            }
            if (this.jdField_a_of_type_AndroidMediaMediaPlayer == null) {
              break label327;
            }
            if (!this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
              break label309;
            }
            this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
            break;
          }
          label309:
          this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
          this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
          continue;
          label327:
          c(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_JavaLangString);
          continue;
          label341:
          J();
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180).setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
          if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController != null))
          {
            if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying())
            {
              this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
              this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.c();
            }
            else
            {
              this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
              this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
              this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b(0);
              this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a();
            }
          }
          else
          {
            a(paramView.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail, true);
            this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
            p();
            c(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_JavaLangString);
          }
        }
      }
      else
      {
        if (this.I != 1) {
          break;
        }
        this.H = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData = paramView;
        BlessPTVActivity.MusicListAdapter.a(paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData);
        paramAdapterView.notifyDataSetChanged();
        a(0, "", 0, 0);
        paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int;
        if (paramView.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(8);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData = paramView;
    if (paramView.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramView = (ImageView)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180);
      if (this.f)
      {
        paramInt = 2130837995;
        label647:
        paramView.setImageResource(paramInt);
        if (!this.f) {
          break label700;
        }
        c(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      BlessPTVActivity.MusicListAdapter.a(paramAdapterView, this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData);
      paramAdapterView.notifyDataSetChanged();
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int;
      break;
      paramInt = 2130837994;
      break label647;
      label700:
      J();
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180).setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(8);
      a(paramView.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail, true);
      J();
      this.jdField_b_of_type_AndroidViewView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    J();
    if (this.jdField_a_of_type_ComTencentWidgetProgressPieView != null) {
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.b();
    }
    super.onLogout(paramLogoutReason);
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.seekTo(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.start();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    paramMotionEvent.getX();
    paramMotionEvent.getY();
    switch (i1)
    {
    case 2: 
    default: 
    case 0: 
      do
      {
        return true;
      } while (Math.abs(SystemClock.elapsedRealtime() - this.jdField_g_of_type_Long) < 500L);
      this.jdField_b_of_type_AndroidViewView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (paramView == this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView)
      {
        P();
        return true;
      }
      paramView.setPressed(true);
      if (c()) {
        G();
      }
      for (;;)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8006192", "0X8006192", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int), "", "", "");
        return true;
        F();
      }
    }
    paramView.setPressed(false);
    H();
    this.jdField_a_of_type_AndroidOsHandler.post(new krb(this));
    this.jdField_g_of_type_Long = SystemClock.elapsedRealtime();
    return true;
  }
  
  public void onUserInteraction()
  {
    super.onUserInteraction();
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, "...onUserInteraction...");
    }
  }
  
  public void p()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric != null) && (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController != null))
    {
      this.D = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.d();
      if (this.jdField_c_of_type_Boolean) {
        break label56;
      }
    }
    label56:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_c_of_type_Boolean = bool;
      this.jdField_w_of_type_Int = this.D;
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.a(0);
      return;
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.resume();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQVideoView.start();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetAudioAnimationView.c();
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " startRecord...time == " + SystemClock.elapsedRealtime());
    }
    this.h = true;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int == 0) && (!this.f)) {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        J();
        i1 = this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_Int;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int != 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.findViewById(2131297180).setVisibility(8);
        }
        this.jdField_a_of_type_ComTencentWidgetProgressPieView.setVisibility(0);
        this.jdField_a_of_type_ComTencentWidgetProgressPieView.setPregressPreColor(-13704962);
        this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgressColor(-15550475);
        this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgressPreType(1);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_d_of_type_Int <= 0) {
          break label276;
        }
        this.jdField_a_of_type_ComTencentWidgetProgressPieView.setMax(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_d_of_type_Int + 50);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.c();
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.setOnProgressListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
      p();
      return;
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      try
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_JavaLangString);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      break;
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(0);
        this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      }
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        break;
      }
      c(this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_JavaLangString);
      break;
      label276:
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.setMax(i1 * 1000);
    }
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " stopRecordUI...time == " + SystemClock.elapsedRealtime());
    }
    J();
    if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail != null) {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(8);
    }
    if (!this.h) {}
    do
    {
      do
      {
        return;
      } while ((this.app == null) || (!this.app.isLogin()));
      this.h = false;
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " rmStateMgr.exitRecordMode() == " + bool + " realTime = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
    }
    if (bool)
    {
      QQToast.a(this, "录制时间过短", 0).a();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.i();
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(0);
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.b();
      this.jdField_a_of_type_ComTencentWidgetProgressPieView.setOnProgressListener(this);
      return;
    }
    J();
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentWidgetProgressPieView.a() > 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double = this.jdField_a_of_type_ComTencentWidgetProgressPieView.a();
    }
    int i3 = this.jdField_a_of_type_ComTencentWidgetProgressPieView.a();
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.setProgress(0);
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.b();
    this.jdField_a_of_type_ComTencentWidgetProgressPieView.setOnProgressListener(this);
    if (QLog.isColorLevel()) {
      QLog.d("BlessPTVActivity", 2, " stopRecordUI...rmStateMgr.mTotalTime == " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraGLSurfaceView.onPause();
    }
    this.jdField_w_of_type_Int = this.D;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_z_of_type_Int, this.A, false, true, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec);
    this.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(true);
    label405:
    int i1;
    int i2;
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      if (QLog.isColorLevel()) {
        QLog.d("BlessPTVActivity", 2, " stopRecord...mPlayCoverData == " + this.jdField_a_of_type_AndroidGraphicsBitmap + " rmStateMgr.clipSpec = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewController.b();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.i();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_a_of_type_Int != 0) {
        break label779;
      }
      if (!this.f) {
        break label578;
      }
      i1 = 1;
      i2 = 0;
    }
    for (;;)
    {
      if (i1 != 0) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_c_of_type_JavaLangString, i2, (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("BlessPTVActivity", 2, " stopRecord...exception...rmStateGr.videoContext == null");
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130838381);
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838381);
        break label405;
        label578:
        i1 = 0;
        i2 = 1;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BlessPTVActivity", 2, " stopRecord...adjust Time current=" + i3 + " maxtime=" + this.jdField_a_of_type_ComTencentWidgetProgressPieView.b() + " realTime=" + this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_d_of_type_Int);
      }
      if ((i3 == this.jdField_a_of_type_ComTencentWidgetProgressPieView.b()) && (this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_d_of_type_Int > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double = this.jdField_a_of_type_ComTencentMobileqqActivityBlessPTVActivity$MusicItemData.jdField_d_of_type_Int;
      }
      CodecParam.L = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
      CodecParam.K = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double;
      CodecParam.J = 0;
      CodecParam.M = 0;
      CodecParam.a(this.jdField_a_of_type_Long);
      CodecParam.a((short)1, (short)1);
      this.jdField_y_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString;
      BlessPTVActivity.EncodeTask localEncodeTask = new BlessPTVActivity.EncodeTask(this);
      localEncodeTask.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      localEncodeTask.execute(new Void[] { (Void)null });
      return;
      label779:
      i1 = 1;
      i2 = 1;
    }
  }
  
  public void t()
  {
    r();
  }
  
  public void u()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new kqs(this), 0L);
  }
  
  public void v() {}
  
  public void w()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessManager.a(this.jdField_a_of_type_JavaUtilArrayList);
    Intent localIntent = new Intent(this, BlessResultActivity.class);
    localIntent.putExtra("param_method", this.jdField_v_of_type_Int);
    localIntent.putExtra("param_count", this.jdField_a_of_type_JavaUtilArrayList.size());
    localIntent.putExtra("param_snap_path", this.jdField_v_of_type_JavaLangString);
    localIntent.putExtra("param_ptv_path", this.jdField_w_of_type_JavaLangString);
    localIntent.putExtra("param_ptv_id", this.E);
    if (this.jdField_x_of_type_JavaLangString != null) {
      localIntent.putExtra("param_share_title", this.jdField_x_of_type_JavaLangString);
    }
    startActivity(localIntent);
    finish();
  }
  
  public void x()
  {
    if (this.I == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessPTVActivity", 2, " onLoadSucess ");
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
  }
  
  public void y()
  {
    if (this.I == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessPTVActivity", 2, " onAudioPlayFinish ");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\BlessPTVActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */