package com.tencent.mobileqq.activity.richmedia;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ConfigurationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.TextureView;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoState;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.ForceReleaseLockOnPause;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr.ViewBitmapSource;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr.ThumbGenItem;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.common.GloableValue;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.ThumbnailUtils;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.VideoFrameSelectBar.OnFramesClipChangeListener;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.CameraGlFilterListener;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.richmedia.CompoundProcessor;
import com.tencent.mobileqq.richmedia.LOG;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.VideoCompoundController;
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoEncodeHelper;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwAutoSegmentMgr;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwOutputNotify;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
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
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.mobileqq.shortvideo.util.VideoAnimation;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar.DelEvent;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.text.QzoneTextBuilder;
import com.tencent.mobileqq.transfile.PtvGuideUploader;
import com.tencent.mobileqq.transfile.PtvGuideUploader.IPtvGuidUpCallback;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import com.tencent.video.decode.ShortVideoSoLoad;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.HorizontalListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.MobileQQ;
import pad;
import pae;
import paf;
import pag;
import pah;
import pai;
import paj;
import pak;
import pal;
import pam;
import pan;
import pao;
import par;
import pas;
import pat;
import pau;
import pav;
import pax;
import paz;
import pba;
import pbb;
import pbc;
import pbd;
import pbe;
import pbg;
import pbh;
import pbi;
import pbj;
import pbk;
import pbn;
import pbu;
import pbv;
import pbw;
import pbx;
import pby;
import pbz;
import pca;
import pcb;
import pcc;
import pcd;
import pce;
import pcf;
import pcg;
import pch;
import pci;
import pcj;
import pck;
import pcm;
import pcn;

public class NewFlowCameraActivity
  extends FlowActivity
  implements Handler.Callback, View.OnClickListener, FlowComponentInterface, RMVideoSwitchCameraPicMgr.ViewBitmapSource, RMViewSTInterface, VideoFrameSelectBar.OnFramesClipChangeListener, CameraFilterGLView.CameraGlFilterListener, ImageViewVideoPlayer.IMPlayerEndListener, TCProgressBar.DelEvent, PtvGuideUploader.IPtvGuidUpCallback
{
  private static String jdField_A_of_type_JavaLangString;
  private static String jdField_B_of_type_JavaLangString;
  private static String C;
  private static String jdField_D_of_type_JavaLangString;
  static final boolean jdField_D_of_type_Boolean = false;
  public static final int E = 300000;
  private static String jdField_E_of_type_JavaLangString;
  static final int jdField_F_of_type_Int = 8;
  private static final String jdField_F_of_type_JavaLangString;
  public static final int G = 2000;
  private static final String G;
  public static final int H = 16698675;
  public static final int K = 2048;
  public static final int L = 8192;
  private static final int jdField_N_of_type_Int = 1;
  private static final int jdField_O_of_type_Int = 2;
  private static final int jdField_P_of_type_Int = 1009;
  private static final int jdField_Q_of_type_Int = 1010;
  static final long jdField_a_of_type_Long = 60000L;
  private static final int jdField_aa_of_type_Int = 1000;
  private static final int jdField_ab_of_type_Int = 1000;
  private static final int jdField_ac_of_type_Int = 1001;
  private static final int jdField_ad_of_type_Int = 1100;
  private static final int jdField_ae_of_type_Int = 1101;
  private static final int jdField_af_of_type_Int = 1102;
  private static final int jdField_ag_of_type_Int = 1103;
  private static final int jdField_ah_of_type_Int = 9999;
  static final int jdField_e_of_type_Int = 1001;
  static final int jdField_f_of_type_Int = 1002;
  static final int jdField_g_of_type_Int = 1003;
  static final int jdField_h_of_type_Int = 1006;
  static final int jdField_i_of_type_Int = 1007;
  public static final int j = 15000;
  public static final int k = 30;
  public static final String k = "PTV.NewFlowCameraActivity";
  public static final int l = 80;
  public static final String l = "camera";
  public static final int m = 100;
  public static final int n = 50;
  public static String p;
  int jdField_A_of_type_Int = 0;
  public boolean A;
  int jdField_B_of_type_Int = 0;
  public boolean B;
  public int C;
  public boolean C;
  public int D;
  boolean jdField_E_of_type_Boolean = false;
  protected boolean F;
  protected boolean G;
  private String H;
  protected boolean H;
  public int I;
  private String I;
  public int J;
  private String J;
  private String K;
  private String L;
  private String M;
  private String jdField_N_of_type_JavaLangString = "";
  private boolean jdField_N_of_type_Boolean;
  private String jdField_O_of_type_JavaLangString = "";
  private boolean jdField_O_of_type_Boolean = true;
  private boolean jdField_P_of_type_Boolean;
  private boolean jdField_Q_of_type_Boolean;
  private int jdField_R_of_type_Int;
  private boolean jdField_R_of_type_Boolean;
  private int jdField_S_of_type_Int;
  private boolean jdField_S_of_type_Boolean;
  private int jdField_T_of_type_Int;
  private boolean jdField_T_of_type_Boolean;
  private int jdField_U_of_type_Int;
  private boolean jdField_U_of_type_Boolean;
  private int jdField_V_of_type_Int;
  private boolean jdField_V_of_type_Boolean = true;
  private int jdField_W_of_type_Int;
  private boolean jdField_W_of_type_Boolean;
  private int jdField_X_of_type_Int = 2;
  private boolean jdField_X_of_type_Boolean;
  private int jdField_Y_of_type_Int;
  private boolean jdField_Y_of_type_Boolean;
  private int jdField_Z_of_type_Int;
  private boolean jdField_Z_of_type_Boolean;
  public double a;
  float jdField_a_of_type_Float = 0.0F;
  public ProgressDialog a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Handler a;
  GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  public VelocityTracker a;
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new pax(this);
  public View a;
  ViewStub jdField_a_of_type_AndroidViewViewStub;
  protected InputMethodManager a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public EditText a;
  public ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  public TextView a;
  private FlowComponentInterface jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface;
  private NewFlowCameraActivity.VideoProcessListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener = new pad(this);
  public PtvTemplateAdapter a;
  public RMVideoStateMgr a;
  public FixedSizeVideoView a;
  private VideoFrameSelectBar jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
  public CameraCover a;
  public FSurfaceViewLayout a;
  SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener;
  protected SystemEmoticonPanel a;
  private SVHwAutoSegmentMgr jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr = new SVHwAutoSegmentMgr();
  private volatile SVHwEncoder jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder;
  CameraExceptionHandler.Callback jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = new pbx(this);
  CameraProxy jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
  private ImageViewVideoPlayer jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer;
  RedDotImageView jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView;
  public QQCustomDialog a;
  public CircleProgress a;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public MqqWeakReferenceHandler a;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public HorizontalListView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new pbd(this);
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public ArrayList a;
  private Formatter jdField_a_of_type_JavaUtilFormatter = new Formatter(this.jdField_a_of_type_JavaLangStringBuilder, Locale.getDefault());
  private byte[] jdField_a_of_type_ArrayOfByte;
  private boolean jdField_aa_of_type_Boolean;
  private boolean jdField_ab_of_type_Boolean;
  private boolean jdField_ac_of_type_Boolean;
  private boolean jdField_ad_of_type_Boolean;
  private boolean jdField_ae_of_type_Boolean;
  private boolean jdField_af_of_type_Boolean;
  private boolean jdField_ag_of_type_Boolean;
  private boolean jdField_ah_of_type_Boolean;
  private int jdField_ai_of_type_Int;
  private boolean jdField_ai_of_type_Boolean;
  private int jdField_aj_of_type_Int;
  private boolean jdField_aj_of_type_Boolean;
  private int jdField_ak_of_type_Int;
  private boolean jdField_ak_of_type_Boolean;
  private int jdField_al_of_type_Int;
  private volatile boolean jdField_al_of_type_Boolean;
  private int jdField_am_of_type_Int;
  private boolean jdField_am_of_type_Boolean;
  private int an;
  private int ao = 1;
  private int ap;
  private int aq = 0;
  private int ar = 1;
  private int as;
  private int at;
  private int au;
  public double b;
  float jdField_b_of_type_Float = 0.0F;
  long jdField_b_of_type_Long;
  ProgressDialog jdField_b_of_type_AndroidAppProgressDialog;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new pag(this);
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Handler jdField_b_of_type_AndroidOsHandler = new pao(this);
  View jdField_b_of_type_AndroidViewView;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  protected RelativeLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  public Runnable b;
  public boolean b;
  private byte[] jdField_b_of_type_ArrayOfByte;
  float jdField_c_of_type_Float = 0.0F;
  long jdField_c_of_type_Long;
  protected View c;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  Button jdField_c_of_type_AndroidWidgetButton;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  public TextView c;
  private ActionSheet jdField_c_of_type_ComTencentWidgetActionSheet;
  Runnable jdField_c_of_type_JavaLangRunnable = new pbb(this);
  long jdField_d_of_type_Long;
  public View d;
  Button jdField_d_of_type_AndroidWidgetButton;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private Runnable jdField_d_of_type_JavaLangRunnable;
  public boolean d;
  private long jdField_e_of_type_Long;
  protected View e;
  Button jdField_e_of_type_AndroidWidgetButton;
  public ImageView e;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = true;
  private long jdField_f_of_type_Long;
  protected View f;
  Button jdField_f_of_type_AndroidWidgetButton;
  protected ImageView f;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long;
  private View jdField_g_of_type_AndroidViewView;
  Button jdField_g_of_type_AndroidWidgetButton;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  public boolean g;
  Button jdField_h_of_type_AndroidWidgetButton;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  protected TextView h;
  public boolean h;
  Button jdField_i_of_type_AndroidWidgetButton;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  public boolean i;
  private TextView j;
  public boolean j;
  private TextView k;
  public boolean k;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  boolean jdField_l_of_type_Boolean = false;
  public String m;
  public boolean m;
  public String n;
  public boolean n;
  int jdField_o_of_type_Int;
  public String o;
  boolean jdField_o_of_type_Boolean;
  int p;
  public boolean p;
  public int q;
  public String q;
  public boolean q;
  int jdField_r_of_type_Int = 0;
  String jdField_r_of_type_JavaLangString;
  boolean jdField_r_of_type_Boolean;
  public int s;
  public String s;
  public boolean s;
  int jdField_t_of_type_Int;
  private String jdField_t_of_type_JavaLangString = "";
  boolean jdField_t_of_type_Boolean = false;
  int jdField_u_of_type_Int;
  private String jdField_u_of_type_JavaLangString;
  public boolean u;
  public int v;
  private String jdField_v_of_type_JavaLangString = a(1);
  boolean jdField_v_of_type_Boolean = false;
  public int w;
  private String jdField_w_of_type_JavaLangString = "";
  boolean jdField_w_of_type_Boolean = false;
  int jdField_x_of_type_Int = 0;
  private String jdField_x_of_type_JavaLangString = "";
  public boolean x;
  int y;
  public boolean y;
  int z;
  public boolean z;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_p_of_type_JavaLangString = Environment.getExternalStorageDirectory().toString() + File.separator + "tencent" + File.separator + "video_edit_music_download" + File.separator;
    jdField_A_of_type_JavaLangString = Environment.getExternalStorageDirectory().toString() + File.separator + "tencent" + File.separator + "video_edit_music" + File.separator;
    jdField_B_of_type_JavaLangString = jdField_A_of_type_JavaLangString + "temp.af";
    jdField_C_of_type_JavaLangString = "";
    jdField_D_of_type_JavaLangString = jdField_A_of_type_JavaLangString + "final.mp4";
    jdField_E_of_type_JavaLangString = jdField_A_of_type_JavaLangString + "no_audio.mp4";
    F = jdField_A_of_type_JavaLangString + "concat_final.m4a";
    G = jdField_A_of_type_JavaLangString + "concat_config.txt";
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "LoadExtractedShortVideoSo :soLoadStatus=" + ShortVideoSoLoad.VIDEO_SO_LOAD_STATUS);
      }
      int i1 = VideoEnvironment.a("AVCodec", null, true);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "LoadExtractedShortVideoSo :code=" + i1);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public NewFlowCameraActivity()
  {
    this.jdField_i_of_type_Boolean = true;
    this.jdField_q_of_type_Int = 1;
    this.jdField_k_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_x_of_type_Boolean = true;
    this.jdField_y_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
    this.jdField_v_of_type_Int = -1;
    this.jdField_w_of_type_Int = -1;
    this.jdField_y_of_type_Int = 0;
    this.jdField_z_of_type_Int = 0;
    this.jdField_C_of_type_Int = 90;
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.ad = true;
    this.jdField_B_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_b_of_type_JavaLangRunnable = new pai(this);
    this.jdField_C_of_type_Boolean = false;
  }
  
  private void L()
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {
      jdField_p_of_type_JavaLangString = Environment.getExternalStorageDirectory().toString() + File.separator + "tencent" + File.separator + "video_edit_music_download" + File.separator;
    }
    for (jdField_A_of_type_JavaLangString = Environment.getExternalStorageDirectory().getPath() + File.separator + "tencent" + File.separator + "video_edit_music" + File.separator;; jdField_A_of_type_JavaLangString = getFilesDir().getAbsolutePath() + File.separator + "tencent" + File.separator + "video_edit_music" + File.separator)
    {
      try
      {
        File localFile = new File(jdField_p_of_type_JavaLangString);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        localFile = new File(jdField_A_of_type_JavaLangString);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d("PTV.NewFlowCameraActivity", 2, "assertSdcardExit exception", localException);
        }
      }
      com.tencent.mobileqq.utils.FileUtils.b(jdField_A_of_type_JavaLangString + ".nomedia");
      jdField_B_of_type_JavaLangString = jdField_A_of_type_JavaLangString + "temp.af";
      jdField_D_of_type_JavaLangString = jdField_A_of_type_JavaLangString + "final.mp4";
      jdField_E_of_type_JavaLangString = jdField_A_of_type_JavaLangString + "no_audio.mp4";
      return;
      jdField_p_of_type_JavaLangString = getFilesDir().getAbsolutePath() + File.separator + "tencent" + File.separator + "video_edit_music_download" + File.separator;
    }
  }
  
  private void M()
  {
    View localView1 = a(2131301611);
    View localView2 = a(2131301621);
    GradientDrawable localGradientDrawable1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 654311424, 0 });
    GradientDrawable localGradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { 0, 1308622848 });
    localView1.setBackgroundDrawable(localGradientDrawable1);
    localView2.setBackgroundDrawable(localGradientDrawable2);
  }
  
  private void N()
  {
    LOG.a("PTV.NewFlowCameraActivity", "freezingViews");
    this.jdField_a_of_type_AndroidWidgetTextView.setText("正在下载...");
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new pae(this), 30000L);
  }
  
  private void O()
  {
    if (this.as == 1) {
      return;
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("tencent.av.v2q.StopVideoChat");
    try
    {
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      this.as = 1;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void P()
  {
    int i1 = 2;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.a().getSharedPreferences("sp_is_cancel_from_music", 4);
    boolean bool = localSharedPreferences.getBoolean("sp_is_cancel_from_music_key", true);
    if (this.jdField_u_of_type_Boolean)
    {
      if ((!this.jdField_h_of_type_Boolean) && (!this.jdField_R_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      }
    }
    else
    {
      View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494);
      if (QLog.isColorLevel()) {
        QLog.d("face", 2, "onResume needChangeNewSurfaceView=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean + "mIsNeedSetup=" + this.jdField_x_of_type_Boolean);
      }
      if (this.jdField_x_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = true;
      }
      this.jdField_x_of_type_Boolean = true;
      if ((localView != null) && (!this.jdField_x_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean)) {
        break label279;
      }
      Looper.myQueue().addIdleHandler(new pah(this, bool, localSharedPreferences));
    }
    for (;;)
    {
      this.jdField_x_of_type_Boolean = false;
      this.jdField_w_of_type_Boolean = false;
      if ((this.ab) && (!this.jdField_Z_of_type_Boolean) && (!this.aa))
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        this.ab = false;
      }
      if (this.aq == 1) {
        QzoneOnlineTimeCollectRptService.a().b(4);
      }
      return;
      if ((this.jdField_h_of_type_Boolean) && (!this.jdField_R_of_type_Boolean) && (bool))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
        break;
      }
      QLog.d("PTV.NewFlowCameraActivity", 2, "onResume from select music and do nothing in 1");
      break;
      label279:
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c();
      if (this.ag)
      {
        this.ag = false;
        if (CameraAbility.c()) {
          i1 = 1;
        }
        a(i1, false);
      }
      this.jdField_h_of_type_Boolean = false;
      localSharedPreferences.edit().putBoolean("sp_is_cancel_from_music_key", true).commit();
      this.jdField_R_of_type_Boolean = false;
    }
  }
  
  private void Q()
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null)
    {
      RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, f1, localRMVideoClipSpec.e);
    }
  }
  
  private void R()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
    }
    this.jdField_i_of_type_AndroidWidgetButton.setVisibility(0);
    label99:
    Object localObject;
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_i_of_type_AndroidWidgetButton.setBackgroundColor(0);
      this.jdField_i_of_type_AndroidWidgetButton.setText("返回");
      VideoAnimation.a(this.jdField_i_of_type_AndroidWidgetButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (!this.jdField_g_of_type_Boolean) {
        break label363;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      if (!this.jdField_g_of_type_Boolean) {
        break label407;
      }
      localObject = this.jdField_e_of_type_AndroidWidgetTextView;
      label111:
      VideoAnimation.a((View)localObject, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (!this.jdField_g_of_type_Boolean) {
        break label415;
      }
      if (this.jdField_f_of_type_AndroidWidgetButton != null) {
        this.jdField_f_of_type_AndroidWidgetButton.setVisibility(0);
      }
      VideoAnimation.a(this.jdField_f_of_type_AndroidWidgetButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(0);
      VideoAnimation.a(this.jdField_e_of_type_AndroidWidgetButton, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      label192:
      l(false);
      VideoAnimation.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      if (!this.ah)
      {
        this.jdField_d_of_type_AndroidWidgetButton.setBackgroundResource(2130842761);
        this.jdField_f_of_type_Boolean = false;
      }
      if (!this.jdField_g_of_type_Boolean) {
        break label441;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      VideoAnimation.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
      this.jdField_i_of_type_AndroidWidgetButton.setText("");
      this.jdField_i_of_type_AndroidWidgetButton.setBackgroundResource(2130841204);
      break;
      label363:
      this.jdField_e_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setBackgroundResource(2130841216);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.a(false);
      break label99;
      label407:
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView;
      break label111;
      label415:
      if (this.jdField_f_of_type_AndroidWidgetButton != null) {
        this.jdField_f_of_type_AndroidWidgetButton.setVisibility(4);
      }
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(4);
      break label192;
      label441:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    }
  }
  
  private void S()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.c())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
      m(false);
      this.P = false;
      return;
    }
    ActionSheet localActionSheet = ActionSheet.a(this);
    localActionSheet.a("是否放弃裁剪?");
    localActionSheet.a("放弃", 3);
    localActionSheet.d("取消");
    localActionSheet.a(new pav(this, localActionSheet));
    localActionSheet.show();
  }
  
  private void T()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mHwEncoder=" + this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    }
    QzoneHandlerThreadFactory.a("Normal_HandlerThread", false).a(new pcm(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
  }
  
  private void U()
  {
    VideoAnimation.a(this.jdField_d_of_type_AndroidWidgetImageView, false, 250);
    a(1002, 0, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a().b();
    if (this.jdField_i_of_type_AndroidWidgetButton != null) {
      this.jdField_i_of_type_AndroidWidgetButton.setEnabled(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setEnabled(true);
  }
  
  private void V()
  {
    int i2 = 1;
    Object localObject1 = (SessionInfo)super.getIntent().getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
    Object localObject2;
    int i1;
    if ((localObject1 != null) && (HwEnvData.b()) && (this.jdField_Y_of_type_Boolean) && (this.aq == 0) && (VideoEnvironment.b(2)))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = new SVHwEncoder();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, ((RMVideoClipSpec)localObject2).e, ((RMVideoClipSpec)localObject2).jdField_f_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(-1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Int * 1000);
      if (CodecParam.jdField_o_of_type_Int != 16) {
        break label275;
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
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(CodecParam.jdField_C_of_type_Int, i1, 64000, i2);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext == null) {
          break label301;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.mEncodeRef.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceAudioCapture.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a.getAndSet(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder);
        localObject2 = RichmediaClient.a().a();
        Q();
        localObject1 = ((VideoCompoundController)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder, (SessionInfo)localObject1, 2);
        this.jdField_q_of_type_JavaLangString = ((CompoundProcessor)localObject1).a();
        LogTag.a(this.jdField_q_of_type_JavaLangString, "start", "[peak]");
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a((SVHwOutputNotify)localObject1, null, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_d_of_type_Boolean);
        return;
        label275:
        if (CodecParam.jdField_o_of_type_Int != 12) {
          break label322;
        }
        i1 = 2;
        break;
        if (CodecParam.jdField_p_of_type_Int != 3) {
          i2 = 2;
        }
      }
      label301:
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "[@] previewSizeAdjustUI: rmStateMgr.videoContext=null,do not hwencode...");
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
      return;
      label322:
      i1 = 1;
    }
  }
  
  private void W()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new pbi(this), 1500L);
  }
  
  private void X()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void Y()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void Z()
  {
    this.jdField_x_of_type_Boolean = true;
    startActivityForResult(new Intent(this, PTVOperatingGuideActivity.class), 1);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, Matrix paramMatrix, boolean paramBoolean)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramInt1, paramInt2, paramMatrix, true);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (paramBoolean) {
        return a(paramBitmap, paramInt1, paramInt2, paramMatrix, false);
      }
    }
    return null;
  }
  
  private static Bitmap a(BitmapFactory.Options paramOptions, String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      if ((i1 > 0) && (paramOptions.inSampleSize > 7)) {
        return null;
      }
      try
      {
        Bitmap localBitmap = a(paramString, paramOptions);
        return localBitmap;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramOptions.inSampleSize += 1;
        i1 += 1;
      }
    }
  }
  
  private Bitmap a(BitmapFactory.Options paramOptions, String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = a(paramString, paramOptions);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!paramBoolean) {}
    }
    return (Bitmap)localObject;
    return a(paramOptions, paramString, false);
  }
  
  /* Error */
  private static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 1020	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 1021	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_1
    //   13: ifnull +47 -> 60
    //   16: aload_2
    //   17: astore_0
    //   18: aload_1
    //   19: getfield 1024	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   22: ifeq +38 -> 60
    //   25: aload_2
    //   26: astore_0
    //   27: new 1026	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_2
    //   32: sipush 2048
    //   35: invokespecial 1029	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   38: aconst_null
    //   39: aload_1
    //   40: invokestatic 1035	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   43: astore_1
    //   44: aload_1
    //   45: astore_0
    //   46: aload_0
    //   47: astore_3
    //   48: aload_2
    //   49: ifnull +9 -> 58
    //   52: aload_2
    //   53: invokevirtual 1040	java/io/InputStream:close	()V
    //   56: aload_0
    //   57: astore_3
    //   58: aload_3
    //   59: areturn
    //   60: aload_2
    //   61: astore_0
    //   62: new 1026	java/io/BufferedInputStream
    //   65: dup
    //   66: aload_2
    //   67: sipush 8192
    //   70: invokespecial 1029	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   73: aconst_null
    //   74: aload_1
    //   75: invokestatic 1035	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   78: astore_1
    //   79: aload_1
    //   80: astore_0
    //   81: goto -35 -> 46
    //   84: astore_3
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_1
    //   88: astore_0
    //   89: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +14 -> 106
    //   95: aload_1
    //   96: astore_0
    //   97: ldc 86
    //   99: iconst_2
    //   100: ldc -29
    //   102: aload_3
    //   103: invokestatic 1042	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload 4
    //   108: astore_3
    //   109: aload_1
    //   110: ifnull -52 -> 58
    //   113: aload_1
    //   114: invokevirtual 1040	java/io/InputStream:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: aconst_null
    //   121: areturn
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 1040	java/io/InputStream:close	()V
    //   133: aload_1
    //   134: athrow
    //   135: astore_1
    //   136: aload_0
    //   137: areturn
    //   138: astore_0
    //   139: goto -6 -> 133
    //   142: astore_1
    //   143: goto -18 -> 125
    //   146: astore_3
    //   147: aload_2
    //   148: astore_1
    //   149: goto -62 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	paramString	String
    //   0	152	1	paramOptions	BitmapFactory.Options
    //   11	137	2	localFileInputStream	java.io.FileInputStream
    //   47	12	3	str	String
    //   84	19	3	localException1	Exception
    //   108	1	3	localObject1	Object
    //   146	1	3	localException2	Exception
    //   1	106	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	12	84	java/lang/Exception
    //   113	117	119	java/io/IOException
    //   3	12	122	finally
    //   52	56	135	java/io/IOException
    //   129	133	138	java/io/IOException
    //   18	25	142	finally
    //   27	44	142	finally
    //   62	79	142	finally
    //   89	95	142	finally
    //   97	106	142	finally
    //   18	25	146	java/lang/Exception
    //   27	44	146	java/lang/Exception
    //   62	79	146	java/lang/Exception
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "公开";
    case 1: 
      return "公开";
    case 4: 
      return "好友";
    case 16: 
      return "指定人";
    case 64: 
      return "仅自己";
    }
    return "指定人";
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
      HwEnvData.jdField_a_of_type_Int = (int)(f1 * 1000.0F);
    }
    if (RMVideoStateMgr.a(paramBoolean))
    {
      this.jdField_Y_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(16);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(4);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString2, paramString3);
    localHashMap.put("reserve", paramString4);
    paramString2 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface != null) {
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a();
    }
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramString2, paramString1, true, 0L, 0L, localHashMap, null);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    QZoneClickReport.ReportInfo localReportInfo = new QZoneClickReport.ReportInfo();
    localReportInfo.c = paramString1;
    localReportInfo.d = paramString2;
    localReportInfo.e = paramString3;
    paramString1 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface != null) {
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a();
    }
    QZoneClickReport.report(paramString1, localReportInfo, paramBoolean);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 16) || (paramInt == 128);
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    int i1 = FlowCameraConstant.d;
    if (i1 == paramInt) {
      return false;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.i();
    if (!this.jdField_y_of_type_Boolean)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_v_of_type_Int, this.jdField_w_of_type_Int, this.jdField_y_of_type_Boolean, false, null);
      if (localBitmap != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        a(104);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeViewAt(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
        if (QLog.isColorLevel()) {
          QLog.d("face", 2, "click front needChangeNewSurfaceView" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c());
        }
        if (i1 != 1) {
          break label290;
        }
        FlowCameraConstant.d = 2;
        label157:
        this.jdField_v_of_type_Boolean = true;
        if (!paramBoolean) {
          break label297;
        }
        c(true);
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(0);
        VideoAnimation.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
      if (this.jdField_i_of_type_AndroidWidgetButton != null)
      {
        this.jdField_i_of_type_AndroidWidgetButton.setVisibility(0);
        VideoAnimation.a(this.jdField_i_of_type_AndroidWidgetButton, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.h();
      return true;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838381);
      break;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130838381);
      break;
      label290:
      FlowCameraConstant.d = 1;
      break label157;
      label297:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean) {
        u();
      } else {
        c(false);
      }
    }
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 199	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 456	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: new 1209	java/io/FileOutputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 1212	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   17: astore_1
    //   18: aload_0
    //   19: getstatic 1218	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   22: iload_2
    //   23: aload_1
    //   24: invokevirtual 1222	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   27: istore 4
    //   29: iload 4
    //   31: ifeq +7 -> 38
    //   34: aload_1
    //   35: invokevirtual 1225	java/io/FileOutputStream:flush	()V
    //   38: iload 4
    //   40: istore_3
    //   41: aload_1
    //   42: ifnull +10 -> 52
    //   45: aload_1
    //   46: invokevirtual 1226	java/io/FileOutputStream:close	()V
    //   49: iload 4
    //   51: istore_3
    //   52: iload_3
    //   53: ireturn
    //   54: astore_0
    //   55: aconst_null
    //   56: astore_1
    //   57: iconst_0
    //   58: istore_3
    //   59: aload_1
    //   60: ifnull -8 -> 52
    //   63: aload_1
    //   64: invokevirtual 1226	java/io/FileOutputStream:close	()V
    //   67: iconst_0
    //   68: ireturn
    //   69: astore_0
    //   70: iconst_0
    //   71: ireturn
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokevirtual 1226	java/io/FileOutputStream:close	()V
    //   83: aload_0
    //   84: athrow
    //   85: astore_0
    //   86: iload 4
    //   88: ireturn
    //   89: astore_1
    //   90: goto -7 -> 83
    //   93: astore_0
    //   94: goto -19 -> 75
    //   97: astore_0
    //   98: goto -41 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramBitmap	Bitmap
    //   0	101	1	paramString	String
    //   0	101	2	paramInt	int
    //   40	19	3	bool1	boolean
    //   27	60	4	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   9	18	54	java/lang/Exception
    //   63	67	69	java/io/IOException
    //   9	18	72	finally
    //   45	49	85	java/io/IOException
    //   79	83	89	java/io/IOException
    //   18	29	93	finally
    //   34	38	93	finally
    //   18	29	97	java/lang/Exception
    //   34	38	97	java/lang/Exception
  }
  
  private void aa()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new pbu(this);
      IntentFilter localIntentFilter = new IntentFilter("action_music_info_js_to_qzone");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void ab()
  {
    this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(new pbw(this));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.setOnFramesClipChangeListener(this);
    }
  }
  
  private void ac()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnFixVDPlayCompelteListener(new pby(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnErrorListener(new pbz(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnPreparedListener(new pca(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setOnTouchListener(new pcb(this));
  }
  
  private void ad()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.d();
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(9999);
  }
  
  private void ae()
  {
    int i2 = 0;
    int i5 = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.a();
    int i6 = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.b();
    if (!g())
    {
      Toast.makeText(MobileQQ.getContext(), "抱歉，文件不存在或存储空间不足", 1).show();
      return;
    }
    this.jdField_S_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "toPublishMood, startTime=" + i5 + ", endTime=" + i6 + ", duration=" + (i6 - i5));
    }
    String str1 = "";
    boolean bool;
    Bitmap localBitmap;
    int i1;
    if (ThumbnailUtils.a(this.jdField_J_of_type_JavaLangString, this.jdField_R_of_type_Int, this.jdField_S_of_type_Int) == 0)
    {
      bool = TrimNative.isGetFrameReady();
      if (!bool) {
        break label325;
      }
      localBitmap = ThumbnailUtils.a(i5, i5 + 1000);
      str1 = "";
      i1 = 0;
    }
    for (;;)
    {
      label158:
      label217:
      int i3;
      int i4;
      String str2;
      if (localBitmap != null)
      {
        str1 = GloableValue.jdField_a_of_type_JavaLangString + File.separator + System.currentTimeMillis() + ".jpg";
        if (cooperation.qzone.util.FileUtils.a(str1, localBitmap))
        {
          i2 = localBitmap.getWidth();
          i1 = localBitmap.getHeight();
          i3 = i1;
          i4 = i2;
          str2 = str1;
          if (!localBitmap.isRecycled())
          {
            localBitmap.recycle();
            str2 = str1;
            i4 = i2;
            i3 = i1;
          }
          label248:
          GloableValue.b();
          getIntent().getStringExtra("refer");
          if (!h()) {
            break label442;
          }
          QLog.d("PTV.NewFlowCameraActivity", 2, "recode video open video preview activity.");
        }
      }
      for (;;)
      {
        this.jdField_V_of_type_Int = i5;
        this.jdField_W_of_type_Int = i6;
        this.jdField_u_of_type_JavaLangString = str2;
        this.jdField_Z_of_type_Int = i3;
        this.jdField_Y_of_type_Int = i4;
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1103);
        return;
        bool = false;
        break;
        label325:
        QLog.w("PTV.NewFlowCameraActivity", 2, "TrimNative.isGetFrameReady return false,thumbnail pic is null.");
        if (!h()) {
          break label468;
        }
        if (i5 <= 1000) {
          str1 = this.jdField_u_of_type_JavaLangString;
        }
        i2 = this.jdField_Y_of_type_Int;
        i1 = this.jdField_Z_of_type_Int;
        localBitmap = null;
        break label158;
        str1 = "";
        QLog.e("PTV.NewFlowCameraActivity", 2, "save jpg failed");
        QzoneVideoBeaconReport.a(this.jdField_z_of_type_JavaLangString, "qzone_video_trim", "4", null);
        break label217;
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "getFrame failed");
        }
        QzoneVideoBeaconReport.a(this.jdField_z_of_type_JavaLangString, "qzone_video_trim", "5", null);
        i3 = i1;
        i4 = i2;
        str2 = str1;
        break label248;
        label442:
        if ((TextUtils.isEmpty(this.H)) || (!this.H.contains("QZoneUploadPhotoActivity"))) {}
      }
      label468:
      str1 = "";
      localBitmap = null;
      i1 = 0;
    }
  }
  
  private void af()
  {
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(9999);
    this.jdField_g_of_type_AndroidWidgetImageView.setImageBitmap(null);
    this.jdField_g_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_J_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
    this.jdField_e_of_type_Long = this.jdField_b_of_type_Long;
    long l1 = this.jdField_c_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "initData, videoPath=" + this.jdField_J_of_type_JavaLangString + ", videoSize=" + this.jdField_e_of_type_Long + ", duration:" + l1);
    }
    this.jdField_X_of_type_Int = 2;
    if (!TextUtils.isEmpty(this.jdField_J_of_type_JavaLangString))
    {
      int i1 = TrimNative.detect(this.jdField_J_of_type_JavaLangString);
      if (i1 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "format is not supported ret=" + i1);
        }
        QzoneVideoBeaconReport.a(this.jdField_z_of_type_JavaLangString, "qzone_video_trim", "10", null);
        this.jdField_J_of_type_JavaLangString = null;
        this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessage(1101);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "setVideoPath:" + this.jdField_J_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(this.jdField_J_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(9999, 10000L);
      return;
    }
    setResult(0);
    finish();
  }
  
  private void ag()
  {
    DialogUtil.a(this, 230).setMessage(2131366681).setPositiveButton(2131366638, new pce(this)).setNegativeButton(2131367074, new pcd(this)).show();
  }
  
  public static String b()
  {
    File localFile1 = null;
    String str2 = null;
    Object localObject = localFile1;
    try
    {
      File localFile2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
      String str1 = str2;
      if (localFile2 != null)
      {
        str1 = str2;
        localObject = localFile1;
        if (localFile2.exists())
        {
          localObject = localFile1;
          str2 = localFile2.getAbsolutePath() + "/Camera";
          localObject = str2;
          localFile1 = new File(str2);
          str1 = str2;
          localObject = str2;
          if (!localFile1.exists())
          {
            localObject = str2;
            localFile1.mkdir();
            str1 = str2;
          }
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      QLog.w("PTV.NewFlowCameraActivity", 2, "getCameraDirectoryPath error", localException);
    }
    return (String)localObject;
  }
  
  private static String b(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L) {
      l1 = 0L;
    }
    return String.valueOf(l1 * 1.0D / 1000.0D);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_ak_of_type_Boolean)
    {
      LOG.a("PTV.NewFlowCameraActivity", "releaseViews return");
      return;
    }
    LOG.a("PTV.NewFlowCameraActivity", "releaseViews:");
    this.jdField_ak_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.post(new paf(this, paramInt));
  }
  
  private void b(int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    label555:
    do
    {
      com.tencent.mobileqq.utils.FileUtils.d(jdField_B_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a());
      for (;;)
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null) && (!TextUtils.isEmpty(paramString)))
        {
          ShortVideoEncodeHelper localShortVideoEncodeHelper = new ShortVideoEncodeHelper();
          int i1 = -1;
          Object localObject;
          switch (paramInt)
          {
          default: 
            return;
          case 0: 
            int i2 = VcSystemInfo.f();
            if ((!VcSystemInfo.e()) || (i2 <= 2)) {
              break label555;
            }
            localObject = getApplicationContext().getFilesDir().getParent() + "/txlib/libtraeimp-armeabi-v7a.so";
            if (QLog.isColorLevel()) {
              QLog.d("PTV.NewFlowCameraActivity", 2, "mixMusicInAudio() encodeHelper.startMixWithBgAudio cpuArchitecure=" + i2 + " mixLibSoPath=" + (String)localObject);
            }
            break;
          }
          try
          {
            if (new File((String)localObject).exists()) {}
            for (paramInt = localShortVideoEncodeHelper.startMixWithBgAudio(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(), paramString, paramInt, (String)localObject, (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);; paramInt = -1)
            {
              if (paramInt != 0) {
                QQToast.a(this, "音频合成异常：" + paramInt, 0).a();
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("PTV.NewFlowCameraActivity", 2, "mixMusicInAudio() AUIDO_MIX_OPTION_DEFAULT result=" + paramInt);
              return;
              try
              {
                localObject = new File(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a());
                if (((File)localObject).exists()) {
                  ((File)localObject).delete();
                }
                ((File)localObject).createNewFile();
                paramInt = localShortVideoEncodeHelper.startMixWithBgAudioWithStereo(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(), paramString, paramInt, null, (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
              }
              catch (Throwable paramString)
              {
                for (;;)
                {
                  paramInt = i1;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("PTV.NewFlowCameraActivity", 2, "mixMusicInAudio() encodeHelper.startMixWithBgAudio IGNORE_SOURCE_AF ERROR exception=" + paramString.getMessage());
                    paramInt = i1;
                  }
                }
              }
              if (paramInt != 0)
              {
                a("608", "8", "1", true);
                QQToast.a(this, "音频合成异常：" + paramInt, 0).a();
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              a("608", "8", "0", true);
              QLog.d("PTV.NewFlowCameraActivity", 2, "mixMusicInAudio() AUDIO_MIX_OPTION_IGNORE_SOURCE_AF result=" + paramInt);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("PTV.NewFlowCameraActivity", 2, "mixMusicInAudio() mixLibSoFile =" + (String)localObject + " not exist");
              }
            }
          }
          catch (Throwable paramString)
          {
            for (;;)
            {
              paramInt = i1;
              if (QLog.isColorLevel())
              {
                QLog.d("PTV.NewFlowCameraActivity", 2, "mixMusicInAudio() encodeHelper.startMixWithBgAudio DEFAULT ERROR exception=" + paramString.getMessage());
                paramInt = i1;
              }
            }
          }
        }
      }
      QQToast.a(this, "你的手机不支持混音", 0).a();
    } while (!QLog.isColorLevel());
    QLog.d("PTV.NewFlowCameraActivity", 2, "mixMusicInAudio() AUIDO_MIX_OPTION_DEFAULT ERROR not support mix audio");
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_ai_of_type_Boolean = paramBundle.getBoolean("enable_local_video", false);
    this.jdField_g_of_type_Boolean = paramBundle.getBoolean("enable_edit_video", false);
    this.ah = paramBundle.getBoolean("is_qzone_vip", false);
    this.jdField_aj_of_type_Boolean = paramBundle.getBoolean("enable_front", false);
    this.ap = paramBundle.getInt("set_sdcard_min_size", 0);
    this.aq = paramBundle.getInt("from_type", 0);
    this.ar = paramBundle.getInt("clip_strategy", 1);
    FlowCameraMqqAction.jdField_a_of_type_Int = this.aq;
    if ((this.ap >= 57671680L) && (this.ap <= 314572800L)) {
      com.tencent.mobileqq.shortvideo.util.storage.StorageManager.jdField_c_of_type_Long = this.ap;
    }
    this.H = paramBundle.getString("short_video_refer");
    paramBundle = paramBundle.getString("set_user_callback");
    if (paramBundle == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramBundle = Class.forName(paramBundle).newInstance();
          if ((paramBundle instanceof FlowComponentInterface))
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = ((FlowComponentInterface)paramBundle);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(this.H);
            return;
          }
        }
        catch (Throwable paramBundle)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface = null;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PTV.NewFlowCameraActivity", 2, "initComponentParamData:exp =" + paramBundle);
  }
  
  private void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "printFrameNumberLog: totalFilerFrame=" + paramInt);
    }
    paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "printFrameNumberLog: frameNumOne=" + paramInt + "  frameNumTwo=" + i1);
    }
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    float f1 = ((RMVideoClipSpec)localObject).jdField_f_of_type_Int * 1.0F / ((RMVideoClipSpec)localObject).e;
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "updateVideoDrawablePlayerUI width" + paramInt1 + "heightRatio=" + f1 + "dst_height" + ((RMVideoClipSpec)localObject).jdField_f_of_type_Int + "dst_width=" + ((RMVideoClipSpec)localObject).e);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(paramInt1, paramInt2, f1, false, ScreenUtil.a(5.0F));
    localObject = this.jdField_d_of_type_AndroidWidgetImageView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramInt1;
    ((ViewGroup.LayoutParams)localObject).height = paramInt2;
    this.jdField_d_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void c(Bundle paramBundle)
  {
    if (this.jdField_c_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_c_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
      this.jdField_c_of_type_ComTencentWidgetActionSheet.a("音乐合成中，发表视频无音乐");
      this.jdField_c_of_type_ComTencentWidgetActionSheet.a("确定", 0);
      this.jdField_c_of_type_ComTencentWidgetActionSheet.d("取消");
      this.jdField_c_of_type_ComTencentWidgetActionSheet.a(new pat(this, paramBundle));
      this.jdField_c_of_type_ComTencentWidgetActionSheet.a(new pau(this));
      this.jdField_c_of_type_ComTencentWidgetActionSheet.show();
    }
    while (this.jdField_c_of_type_ComTencentWidgetActionSheet.isShowing()) {
      return;
    }
    this.jdField_c_of_type_ComTencentWidgetActionSheet.show();
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVisibility(paramInt);
    }
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(paramInt);
    }
    if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(paramInt);
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    QzoneHandlerThreadFactory.a("RealTime_HandlerThread").a(new pcc(this, paramInt1, paramInt2));
  }
  
  private void d(String paramString)
  {
    this.jdField_V_of_type_Boolean = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QzoneHandlerThreadFactory.a("Normal_HandlerThread").a(new pbn(this, paramString));
  }
  
  private void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "jumpToH5Activity = " + paramString);
    }
    if (this.jdField_s_of_type_JavaLangString != null)
    {
      paramString = new Intent();
      paramString.setAction("com.tencent.mobileqq.shortVideoJsApiPulgin");
      paramString.putExtra("uuid", this.jdField_L_of_type_JavaLangString);
      paramString.putExtra("md5", this.K);
      paramString.putExtra("callback", this.jdField_s_of_type_JavaLangString);
      finish();
      sendBroadcast(paramString);
      return;
    }
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.jdField_z_of_type_JavaLangString);
    localIntent.putExtra("isFullScreen", true);
    localIntent.putExtra("flow_key_from_guide", true);
    startActivity(localIntent.putExtra("url", paramString));
  }
  
  private boolean e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a())) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    }
    while ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder == null) || (this.jdField_b_of_type_AndroidWidgetButton.isEnabled())) {
      return false;
    }
    return true;
  }
  
  private void f(String paramString)
  {
    String str = getResources().getString(2131367110);
    QZoneHelper.a(this, QZoneHelper.UserInfo.a(), paramString, Long.parseLong(this.jdField_z_of_type_JavaLangString), "", 1010, str, false);
  }
  
  private boolean f()
  {
    Object localObject = getIntent();
    if ((localObject != null) && (!TextUtils.isEmpty(((Intent)localObject).getStringExtra("file_send_path")))) {}
    do
    {
      return false;
      localObject = a();
    } while ((TextUtils.isEmpty((CharSequence)localObject)) || ((!((String)localObject).contains("QZonePublishMoodActivity")) && (!((String)localObject).contains("QZoneUploadPhotoActivity"))));
    return true;
  }
  
  private boolean g()
  {
    if (!CacheManager.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("PTV.NewFlowCameraActivity", 2, "isEnoughStorage() sdcard not mounted");
      }
      QzoneVideoBeaconReport.a(this.jdField_z_of_type_JavaLangString, "qzone_video_trim", "6", null);
    }
    long l1 = cooperation.qzone.util.FileUtils.a(this.jdField_J_of_type_JavaLangString);
    if (l1 <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "no file size");
      }
      QzoneVideoBeaconReport.a(this.jdField_z_of_type_JavaLangString, "qzone_video_trim", "7", null);
      return false;
    }
    if (l1 / this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.getDuration() * (this.jdField_W_of_type_Int - this.jdField_V_of_type_Int) > CacheManager.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "there is not enough space on sdcard");
      }
      QzoneVideoBeaconReport.a(this.jdField_z_of_type_JavaLangString, "qzone_video_trim", "8", null);
      return false;
    }
    return true;
  }
  
  private boolean h()
  {
    return "cover_mall_record_video".equals(a());
  }
  
  private void j(boolean paramBoolean)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
  }
  
  private void k(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_JavaLangRunnable != null) {
      QzoneHandlerThreadFactory.a("Normal_HandlerThread").b(this.jdField_d_of_type_JavaLangRunnable);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(jdField_C_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_V_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
      this.jdField_m_of_type_JavaLangString = jdField_C_of_type_JavaLangString;
      return;
    }
    QQToast.a(this, "音乐合成中，请稍候", 0).a();
    this.an = ((this.jdField_W_of_type_Int - this.jdField_V_of_type_Int) / 1000);
    if (!TextUtils.isEmpty(this.jdField_O_of_type_JavaLangString)) {}
    for (;;)
    {
      try
      {
        Object localObject = this.jdField_O_of_type_JavaLangString.split(":");
        String str = localObject[0];
        localObject = localObject[1];
        this.jdField_am_of_type_Int = (Integer.parseInt(str) * 60 + Integer.parseInt((String)localObject));
        QLog.d("ffmpeg_concat", 2, "mSongInterval:" + this.jdField_O_of_type_JavaLangString + " - " + this.jdField_am_of_type_Int + " [split]min:" + str + " sec:" + (String)localObject);
      }
      catch (Exception localException)
      {
        QLog.d("ffmpeg_concat", 2, "mSongInterval split exception");
        continue;
      }
      this.jdField_d_of_type_JavaLangRunnable = new pbk(this);
      QzoneHandlerThreadFactory.a("Normal_HandlerThread").a(this.jdField_d_of_type_JavaLangRunnable);
      return;
      QLog.d("ffmpeg_concat", 2, "mSongInterval is Empty ");
    }
  }
  
  private void l(boolean paramBoolean)
  {
    int i2 = 0;
    Object localObject;
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_d_of_type_AndroidWidgetButton != null) && (this.jdField_d_of_type_AndroidWidgetTextView != null))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (!paramBoolean) {
        break label74;
      }
      i1 = 0;
      ((LinearLayout)localObject).setVisibility(i1);
      localObject = this.jdField_d_of_type_AndroidWidgetButton;
      if (!paramBoolean) {
        break label80;
      }
      i1 = 0;
      label51:
      ((Button)localObject).setVisibility(i1);
      localObject = this.jdField_d_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label86;
      }
    }
    label74:
    label80:
    label86:
    for (int i1 = i2;; i1 = 8)
    {
      ((TextView)localObject).setVisibility(i1);
      return;
      i1 = 8;
      break;
      i1 = 8;
      break label51;
    }
  }
  
  private void m(boolean paramBoolean)
  {
    int i2 = 0;
    this.Q = paramBoolean;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar;
    if (paramBoolean)
    {
      i1 = 0;
      ((VideoFrameSelectBar)localObject).setVisibility(i1);
      localObject = this.jdField_d_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label176;
      }
      i1 = 0;
      label35:
      ((RelativeLayout)localObject).setVisibility(i1);
      localObject = this.jdField_h_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label182;
      }
      i1 = 0;
      label51:
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.jdField_g_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label188;
      }
      i1 = 0;
      label67:
      ((ImageView)localObject).setVisibility(i1);
      localObject = this.jdField_b_of_type_AndroidViewViewGroup;
      if (!paramBoolean) {
        break label194;
      }
      i1 = 8;
      label84:
      ((ViewGroup)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (!paramBoolean) {
        break label199;
      }
      i1 = 8;
      label101:
      ((RelativeLayout)localObject).setVisibility(i1);
      localObject = this.jdField_a_of_type_AndroidWidgetEditText;
      if (!paramBoolean) {
        break label217;
      }
      i1 = 8;
      label118:
      ((EditText)localObject).setVisibility(i1);
      localObject = this.jdField_g_of_type_AndroidWidgetButton;
      if (!paramBoolean) {
        break label222;
      }
    }
    label176:
    label182:
    label188:
    label194:
    label199:
    label217:
    label222:
    for (int i1 = 8;; i1 = 0)
    {
      ((Button)localObject).setVisibility(i1);
      localObject = this.jdField_b_of_type_AndroidViewView;
      i1 = i2;
      if (paramBoolean) {
        i1 = 8;
      }
      ((View)localObject).setVisibility(i1);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      return;
      i1 = 8;
      break;
      i1 = 8;
      break label35;
      i1 = 8;
      break label51;
      i1 = 8;
      break label67;
      i1 = 0;
      break label84;
      if (this.jdField_g_of_type_Boolean)
      {
        i1 = 0;
        break label101;
      }
      i1 = 8;
      break label101;
      i1 = 0;
      break label118;
    }
  }
  
  void A()
  {
    B();
    e(this.jdField_M_of_type_JavaLangString);
  }
  
  void B()
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "cancelProgressDialog");
    }
    try
    {
      if (this.jdField_a_of_type_AndroidAppProgressDialog != null) {
        this.jdField_a_of_type_AndroidAppProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void B_()
  {
    U();
    c(true);
  }
  
  void C()
  {
    int i1 = (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double;
    this.jdField_aj_of_type_Int = i1;
    CodecParam.K = i1;
    i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
    if (i1 <= 0) {}
    for (CodecParam.L = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();; CodecParam.L = i1)
    {
      CodecParam.jdField_J_of_type_Int = 0;
      CodecParam.M = 0;
      if (QLog.isColorLevel()) {
        QLog.e("PTV.NewFlowCameraActivity", 2, "onShareClick " + this.jdField_J_of_type_JavaLangString + " CodecParam.mRecordFrames" + CodecParam.L + " CodecParam.mRecordTime" + CodecParam.K);
      }
      new NewFlowCameraActivity.EncodeTask(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$VideoProcessListener, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString).execute(new Void[] { (Void)null });
      c("视频合成中...");
      return;
    }
  }
  
  public void C_() {}
  
  public void D()
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "onShareClick " + this.jdField_J_of_type_JavaLangString + " mthumbPath" + this.jdField_I_of_type_JavaLangString);
    }
    if ((StringUtil.b(this.jdField_J_of_type_JavaLangString)) || (StringUtil.b(this.jdField_I_of_type_JavaLangString)))
    {
      i(true);
      return;
    }
    if ((this.jdField_I_of_type_JavaLangString == null) || (this.jdField_J_of_type_JavaLangString == null))
    {
      QQToast.a(this, 2131369851, 0).a();
      B();
      return;
    }
    File localFile1 = new File(this.jdField_I_of_type_JavaLangString);
    File localFile2 = new File(this.jdField_J_of_type_JavaLangString);
    if ((!localFile1.exists()) || (!localFile2.exists()))
    {
      QQToast.a(this, 2131369851, 0).a();
      B();
      return;
    }
    if ((!localFile1.isFile()) || (!localFile2.isFile()))
    {
      QQToast.a(this, 2131369852, 0).a();
      B();
      return;
    }
    new PtvGuideUploader(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface, this, this.jdField_J_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_I_of_type_JavaLangString, this.jdField_b_of_type_ArrayOfByte, this.jdField_ak_of_type_Int, this.jdField_al_of_type_Int, this.jdField_aj_of_type_Int).a();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(1003, 60000L);
  }
  
  public void D_()
  {
    Bitmap localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsBitmap;
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
    }
    if (localBitmap1 != null) {
      this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(0.2F);
  }
  
  protected final void E() {}
  
  public void E_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(0);
    localStringBuilder.append("秒");
    this.jdField_f_of_type_AndroidWidgetTextView.setText(localStringBuilder);
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  protected void F()
  {
    Object localObject = b();
    if ((localObject instanceof RelativeLayout))
    {
      localObject = (RelativeLayout)localObject;
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams1.addRule(12);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
      this.jdField_d_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904798, null);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams2.addRule(10);
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_AndroidViewView, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, 2);
      localLayoutParams2.addRule(3, this.jdField_d_of_type_AndroidViewView.getId());
      this.jdField_e_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2130904695, null);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_e_of_type_AndroidViewView, localLayoutParams2);
      localLayoutParams2 = new RelativeLayout.LayoutParams(-1, (int)(getApplication().getResources().getDisplayMetrics().density * 150.0F));
      localLayoutParams2.addRule(3, this.jdField_e_of_type_AndroidViewView.getId());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel, localLayoutParams2);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setBackgroundColor(getResources().getColor(2131428053));
      ((RelativeLayout)localObject).addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, localLayoutParams1);
      this.au = ((RelativeLayout)localObject).getHeight();
      ((RelativeLayout)localObject).getViewTreeObserver().addOnGlobalLayoutListener(new pbv(this, (RelativeLayout)localObject));
      QLog.d("mango", 2, "mango test111");
    }
  }
  
  public void F_()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "initUI_RecordState mIsVideoMode=" + this.jdField_n_of_type_Boolean);
    }
    if (this.jdField_n_of_type_Boolean)
    {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getVisibility() == 0) {
        VideoAnimation.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      if ((this.jdField_i_of_type_AndroidWidgetButton != null) && (this.jdField_i_of_type_AndroidWidgetButton.getVisibility() == 0)) {
        VideoAnimation.a(this.jdField_i_of_type_AndroidWidgetButton, 0.0F, 8.0F, 0.0F, 0.0F, 300, 1.0F, 0.0F);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Int = 0;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double <= 0.0D) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_f_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_e_of_type_Boolean = true;
      }
      if (this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      }
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((this.jdField_ai_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetButton.isEnabled()))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
  }
  
  public void G()
  {
    this.jdField_v_of_type_JavaLangString = a(this.jdField_q_of_type_Int);
    this.jdField_g_of_type_AndroidWidgetButton.setText(this.jdField_v_of_type_JavaLangString);
  }
  
  public void G_()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState mIsVideoMode=" + this.jdField_n_of_type_Boolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "initUI_IdleState");
    }
    if (this.jdField_n_of_type_Boolean)
    {
      if ((QLog.isColorLevel()) && (this.jdField_i_of_type_AndroidWidgetButton != null))
      {
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mSendButton.getVisibility=" + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getVisibility());
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mLeftButton.getVisibility=" + this.jdField_i_of_type_AndroidWidgetButton.getVisibility());
      }
      if ((QLog.isColorLevel()) && (this.jdField_i_of_type_AndroidWidgetButton != null))
      {
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mSendButton.isEnabled=" + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.isEnabled());
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mLeftButton.isEnabled=" + this.jdField_i_of_type_AndroidWidgetButton.isEnabled());
        QLog.i("PTV.NewFlowCameraActivity", 2, "initUI_IdleState:mCameraCapture.isEnabled=" + this.jdField_a_of_type_AndroidWidgetImageView.isEnabled());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setNeedWrite(false);
      this.jdField_p_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.getVisibility() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(0);
        VideoAnimation.a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView, 8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
      }
      if (this.jdField_i_of_type_AndroidWidgetButton != null)
      {
        if (this.jdField_i_of_type_AndroidWidgetButton.getVisibility() == 4)
        {
          this.jdField_i_of_type_AndroidWidgetButton.setVisibility(0);
          VideoAnimation.a(this.jdField_i_of_type_AndroidWidgetButton, -8.0F, 0.0F, 0.0F, 0.0F, 300, 0.0F, 1.0F);
        }
        this.jdField_i_of_type_AndroidWidgetButton.setEnabled(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setEnabled(true);
      g(false);
      float f1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_e_of_type_Boolean)
      {
        f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
        int i1 = 320;
        if (RMVideoStateMgr.jdField_a_of_type_Boolean) {
          i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec.e;
        }
        int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, f1, i1, i2);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_e_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = null;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) && (!bool))
      {
        f1 = (float)(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() * 1000.0F / this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.a(f1, -1);
      }
    }
  }
  
  void H()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(8);
    }
    R();
    long l1 = QzoneConfig.a().a("MiniVideo", "VideoDurationThreshold", 60000);
    if (this.jdField_c_of_type_Long > l1)
    {
      this.jdField_N_of_type_Boolean = false;
      if (this.jdField_f_of_type_AndroidWidgetButton != null) {
        ViewUtils.a(this.jdField_f_of_type_AndroidWidgetButton, getResources().getDrawable(2130841232));
      }
      l1 = QzoneConfig.a().a("VideoEdit", "SupportMixMusicMaxSize", 524288000L);
      if (this.jdField_b_of_type_Long <= l1) {
        break label212;
      }
      this.jdField_O_of_type_Boolean = false;
      if (this.jdField_e_of_type_AndroidWidgetButton != null) {
        ViewUtils.a(this.jdField_e_of_type_AndroidWidgetButton, getResources().getDrawable(2130841238));
      }
      label138:
      if (this.jdField_g_of_type_Boolean)
      {
        l1 = QzoneConfig.a().a("VideoEdit", "VipQualityLimitSize", 209715200L);
        if (this.jdField_b_of_type_Long >= l1) {
          break label244;
        }
      }
    }
    for (;;)
    {
      l(bool);
      I();
      return;
      this.jdField_N_of_type_Boolean = true;
      if (this.jdField_f_of_type_AndroidWidgetButton == null) {
        break;
      }
      ViewUtils.a(this.jdField_f_of_type_AndroidWidgetButton, getResources().getDrawable(2130841231));
      break;
      label212:
      this.jdField_O_of_type_Boolean = true;
      if (this.jdField_e_of_type_AndroidWidgetButton == null) {
        break label138;
      }
      ViewUtils.a(this.jdField_e_of_type_AndroidWidgetButton, getResources().getDrawable(2130841237));
      break label138;
      label244:
      bool = false;
    }
  }
  
  void I()
  {
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewViewStub == null)
    {
      this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)findViewById(2131301610));
      this.jdField_a_of_type_AndroidViewViewStub.inflate();
    }
    try
    {
      Object localObject1 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext());
      GlobalInit.loadLibraryWithFullPath((String)localObject1 + ShortVideoSoLoad.getLibActualName("AVCodec"));
      if (!GloableValue.a(Long.parseLong(this.jdField_z_of_type_JavaLangString)))
      {
        QQToast.a(this, "对不起，初始化裁减引擎失败", 0).a();
        QLog.e("PTV.NewFlowCameraActivity", 2, "init trim failed");
        a("play_local_video", "play_local_video_success", "3", Build.MODEL);
        finish();
      }
      try
      {
        localObject1 = (ActivityManager)getSystemService("activity");
        localObject2 = new ActivityManager.MemoryInfo();
        ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
        int i1 = QzoneConfig.a().a("TrimVideo", "MinAvailableRam", 209715200);
        if (((ActivityManager.MemoryInfo)localObject2).availMem < i1) {
          QQToast.a(this, "可用内存过少，可能影响裁剪操作", 0).a();
        }
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "availMem=" + ((ActivityManager.MemoryInfo)localObject2).availMem + ", threshold=" + ((ActivityManager.MemoryInfo)localObject2).threshold + ", lowMem=" + ((ActivityManager.MemoryInfo)localObject2).lowMemory + ", minRam=" + i1);
        }
        GloableValue.a();
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          Object localObject2;
          FrameLayout.LayoutParams localLayoutParams1;
          FrameLayout.LayoutParams localLayoutParams2;
          QLog.w("PTV.NewFlowCameraActivity", 2, "", localThrowable2);
          continue;
          localThrowable2.bottomMargin = 0;
          ((FrameLayout.LayoutParams)localObject2).gravity = 1;
          localLayoutParams1.gravity = 1;
          localLayoutParams2.height = this.jdField_p_of_type_Int;
        }
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131297886));
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131301634));
      this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)a(2131301636));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar = ((VideoFrameSelectBar)a(2131301638));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView = ((FixedSizeVideoView)a(2131301635));
      this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)a(2131301637));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131301639));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)a(2131301640));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)a(2131301641));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)a(2131301642));
      this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(this);
      if ((this.jdField_o_of_type_Int != 0) && (this.jdField_p_of_type_Int != 0))
      {
        localObject1 = (RelativeLayout.LayoutParams)a(this.jdField_c_of_type_AndroidViewViewGroup);
        localObject2 = (FrameLayout.LayoutParams)a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView);
        localLayoutParams1 = (FrameLayout.LayoutParams)a(this.jdField_g_of_type_AndroidWidgetImageView);
        localLayoutParams2 = (FrameLayout.LayoutParams)a(this.jdField_h_of_type_AndroidWidgetImageView);
        if (this.jdField_o_of_type_Int / this.jdField_p_of_type_Int >= 1.0F)
        {
          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((RelativeLayout.LayoutParams)a(this.jdField_b_of_type_AndroidViewViewGroup)).height;
          ((FrameLayout.LayoutParams)localObject2).gravity = 17;
          localLayoutParams1.gravity = 17;
          localLayoutParams2.height = -1;
          this.jdField_c_of_type_AndroidViewViewGroup.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_g_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams1);
          this.jdField_h_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
        }
      }
      else
      {
        ab();
        ac();
        if (!TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
          af();
        }
        d(0);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
          this.jdField_p_of_type_Boolean = false;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.setVideoPath(this.jdField_m_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
        jdField_C_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
        return;
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QLog.e("PTV.NewFlowCameraActivity", 2, "loadLibrary Exception", localThrowable1);
        a("play_local_video", "play_local_video_success", "2", Build.MODEL);
        QQToast.a(this, "对不起，初始化裁剪引擎失败", 0).a();
        finish();
      }
    }
  }
  
  public int a()
  {
    return this.jdField_C_of_type_Int;
  }
  
  int a(int paramInt)
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
  
  public long a(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l1 = paramString.getAvailableBlocks();
      int i1 = paramString.getBlockSize();
      return l1 * i1;
    }
    catch (Exception paramString)
    {
      QLog.w("PTV.NewFlowCameraActivity", 2, "getFreeSpace error", paramString);
    }
    return 0L;
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    for (Object localObject1 = null;; localObject1 = null)
    {
      try
      {
        if (this.jdField_y_of_type_Boolean) {
          continue;
        }
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.getChildAt(0);
        if (!TextureView.class.isInstance(localObject2)) {
          continue;
        }
        localObject2 = ((TextureView)localObject2).getBitmap(paramInt1, paramInt2);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("PTV.NewFlowCameraActivity", 2, "getViewBitmap oom" + localOutOfMemoryError);
        return null;
      }
      return (Bitmap)localObject1;
    }
  }
  
  public Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("PTV.NewFlowCameraActivity", 2, "getBitmapWithSize but fileName is empty");
      paramString = null;
      return paramString;
    }
    if (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    a(paramString, localOptions);
    localOptions.inJustDecodeBounds = false;
    int i1 = localOptions.outWidth;
    int i2 = localOptions.outHeight;
    i2 = Math.min(i1 / paramInt1, i2 / paramInt2);
    i1 = i2;
    if (i2 < 1) {
      i1 = 1;
    }
    localOptions.inSampleSize = i1;
    Bitmap localBitmap2 = a(localOptions, paramString, true);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localOptions.inSampleSize += 1;
      localBitmap1 = a(localOptions, paramString);
    }
    if (localBitmap1 == null) {
      return null;
    }
    i1 = localBitmap1.getWidth();
    i2 = localBitmap1.getHeight();
    float f1 = paramInt1 / i1;
    float f2 = paramInt2 / i2;
    if ((f1 > 1.0F) && (f2 > 1.0F)) {
      return localBitmap1;
    }
    paramString = new Matrix();
    if (paramBoolean) {
      if (f1 > f2)
      {
        f1 = f2;
        label229:
        paramString.postScale(f1, f1);
      }
    }
    for (;;)
    {
      localBitmap2 = a(localBitmap1, i1, i2, paramString, true);
      paramString = localBitmap2;
      if (localBitmap2 == localBitmap1) {
        break;
      }
      localBitmap1.recycle();
      return localBitmap2;
      break label229;
      paramString.postScale(f1, f2);
    }
  }
  
  protected FlowPanel a()
  {
    return null;
  }
  
  public String a()
  {
    return this.H;
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 1139	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 2418	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: astore_2
    //   7: aload_2
    //   8: new 188	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 2420
    //   18: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 2426	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   31: aconst_null
    //   32: ldc_w 2428
    //   35: iconst_1
    //   36: anewarray 446	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload_1
    //   42: aastore
    //   43: aconst_null
    //   44: invokevirtual 2434	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +212 -> 261
    //   52: aload_1
    //   53: invokeinterface 2439 1 0
    //   58: ifeq +203 -> 261
    //   61: aload_1
    //   62: aload_1
    //   63: ldc_w 2441
    //   66: invokeinterface 2444 2 0
    //   71: invokeinterface 2445 2 0
    //   76: astore_2
    //   77: aload_2
    //   78: invokestatic 1411	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifne +174 -> 255
    //   84: new 446	java/lang/String
    //   87: dup
    //   88: aload_2
    //   89: invokevirtual 2449	java/lang/String:getBytes	()[B
    //   92: ldc_w 2451
    //   95: invokespecial 2454	java/lang/String:<init>	([BLjava/lang/String;)V
    //   98: invokestatic 2458	com/tencent/mobileqq/utils/SecurityUtile:a	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +29 -> 134
    //   108: ldc 86
    //   110: iconst_2
    //   111: new 188	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 2460
    //   121: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_2
    //   125: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 1706	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_2
    //   135: astore_3
    //   136: aload_1
    //   137: ifnull +11 -> 148
    //   140: aload_1
    //   141: invokeinterface 2461 1 0
    //   146: aload_2
    //   147: astore_3
    //   148: aload_3
    //   149: areturn
    //   150: astore_3
    //   151: aconst_null
    //   152: astore_2
    //   153: ldc -29
    //   155: astore_1
    //   156: invokestatic 251	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +32 -> 191
    //   162: ldc 86
    //   164: iconst_2
    //   165: new 188	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 2463
    //   175: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_3
    //   179: invokestatic 2467	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 1390	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_1
    //   192: astore_3
    //   193: aload_2
    //   194: ifnull -46 -> 148
    //   197: aload_2
    //   198: invokeinterface 2461 1 0
    //   203: aload_1
    //   204: areturn
    //   205: astore_2
    //   206: aconst_null
    //   207: astore_1
    //   208: aload_1
    //   209: ifnull +9 -> 218
    //   212: aload_1
    //   213: invokeinterface 2461 1 0
    //   218: aload_2
    //   219: athrow
    //   220: astore_2
    //   221: goto -13 -> 208
    //   224: astore_3
    //   225: aload_2
    //   226: astore_1
    //   227: aload_3
    //   228: astore_2
    //   229: goto -21 -> 208
    //   232: astore_3
    //   233: aload_1
    //   234: astore_2
    //   235: ldc -29
    //   237: astore_1
    //   238: goto -82 -> 156
    //   241: astore 4
    //   243: aload_2
    //   244: astore_3
    //   245: aload_1
    //   246: astore_2
    //   247: aload_3
    //   248: astore_1
    //   249: aload 4
    //   251: astore_3
    //   252: goto -96 -> 156
    //   255: ldc -29
    //   257: astore_2
    //   258: goto -156 -> 102
    //   261: ldc -29
    //   263: astore_2
    //   264: goto -130 -> 134
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	NewFlowCameraActivity
    //   0	267	1	paramString	String
    //   6	192	2	localObject1	Object
    //   205	14	2	localObject2	Object
    //   220	6	2	localObject3	Object
    //   228	36	2	localObject4	Object
    //   135	14	3	localObject5	Object
    //   150	29	3	localException1	Exception
    //   192	1	3	str	String
    //   224	4	3	localObject6	Object
    //   232	1	3	localException2	Exception
    //   244	8	3	localObject7	Object
    //   241	9	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   7	48	150	java/lang/Exception
    //   7	48	205	finally
    //   52	102	220	finally
    //   102	134	220	finally
    //   156	191	224	finally
    //   52	102	232	java/lang/Exception
    //   102	134	241	java/lang/Exception
  }
  
  String a(String paramString1, String paramString2)
  {
    return "http://sqimg.qq.com/qq_product_operations/preguide/index.html?_wv=1024&adtag=main&uuid=" + paramString1 + "&md5=" + paramString2;
  }
  
  public void a() {}
  
  public void a(float paramFloat)
  {
    runOnUiThread(new pci(this, paramFloat));
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_j_of_type_Boolean) {}
    RMVideoClipSpec localRMVideoClipSpec;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "[@] previewSizeAdjustUI:width=" + paramInt1 + " height=" + paramInt2);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PTV.NewFlowCameraActivity", 2, "[previewSizeAdjustUI]rmStateMgr " + null);
      return;
      this.jdField_v_of_type_Int = paramInt1;
      this.jdField_w_of_type_Int = paramInt2;
      this.jdField_X_of_type_Boolean = true;
      f(true);
      localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setPreviewSize(paramInt1, paramInt2, localRMVideoClipSpec);
      if ((VersionUtils.c()) && (!this.jdField_b_of_type_AndroidWidgetButton.isEnabled())) {
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (this.jdField_s_of_type_Int < CodecParam.d) {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
    } while (!QLog.isColorLevel());
    QLog.i("PTV.NewFlowCameraActivity", 2, "previewSizeAdjustUI spec: " + localRMVideoClipSpec.toString());
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onPreviewResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
    }
    if (paramInt1 == 1002)
    {
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      this.aa = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.e();
    }
  }
  
  void a(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    b(paramInt1, paramInt2, paramBoolean, paramArrayOfInt);
  }
  
  void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i1 = 0;
    paramArrayOfInt = a(2131296494);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)a(paramArrayOfInt);
    if (!this.jdField_z_of_type_Boolean)
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      paramArrayOfInt.setLayoutParams(localLayoutParams);
    }
    int i2 = (int)this.jdField_b_of_type_Float;
    i2 = (int)this.jdField_b_of_type_Float - i2;
    if (paramInt2 >= this.jdField_b_of_type_Float) {
      paramInt2 = i2 - 0;
    }
    for (;;)
    {
      this.jdField_x_of_type_Int = i1;
      this.jdField_z_of_type_Int = paramInt2;
      this.jdField_A_of_type_Int = (i1 * this.jdField_w_of_type_Int / paramInt1);
      this.jdField_B_of_type_Int = (paramInt2 * this.jdField_w_of_type_Int / paramInt1);
      if (this.jdField_s_of_type_Boolean) {
        b(5.0F);
      }
      return;
      paramInt2 = (int)this.jdField_b_of_type_Float - paramInt2;
      if (this.jdField_y_of_type_Boolean)
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
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "OnUploadVideoListener onUploadFail!");
    }
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1003)) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1003);
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1003);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    runOnUiThread(new pbe(this, paramString, paramInt));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_n_of_type_Boolean)
    {
      this.jdField_s_of_type_Int = paramInt;
      RMVideoStateMgr localRMVideoStateMgr = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      localRMVideoStateMgr.jdField_a_of_type_Int += 1;
      if (!paramBoolean) {
        break label53;
      }
      h(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.post(new pbc(this));
      return;
      label53:
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwAutoSegmentMgr.a(paramInt, i1);
      h(this.jdField_E_of_type_Boolean);
      if (this.jdField_E_of_type_Boolean) {
        this.jdField_E_of_type_Boolean = false;
      } else {
        this.jdField_E_of_type_Boolean = true;
      }
    }
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Activity paramActivity, Intent paramIntent) {}
  
  public void a(Context paramContext, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog");
    }
    try
    {
      if (this.jdField_b_of_type_AndroidAppProgressDialog != null) {
        t();
      }
      for (;;)
      {
        this.jdField_g_of_type_AndroidWidgetTextView.setText(paramInt);
        if (this.jdField_b_of_type_AndroidAppProgressDialog.isShowing()) {
          break;
        }
        this.jdField_b_of_type_AndroidAppProgressDialog.show();
        return;
        this.jdField_b_of_type_AndroidAppProgressDialog = new ProgressDialog(paramContext, 2131558973);
        this.jdField_b_of_type_AndroidAppProgressDialog.setCancelable(true);
        this.jdField_b_of_type_AndroidAppProgressDialog.show();
        this.jdField_b_of_type_AndroidAppProgressDialog.setContentView(2130903453);
        this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidAppProgressDialog.findViewById(2131298665));
      }
      return;
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog", paramContext);
      }
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_x_of_type_Int = 0;
    this.jdField_y_of_type_Int = 0;
    this.jdField_z_of_type_Int = 0;
    this.jdField_A_of_type_Int = 0;
    this.jdField_B_of_type_Int = 0;
    this.jdField_d_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.ab = false;
    this.jdField_Z_of_type_Boolean = false;
    this.aa = false;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder = null;
    this.jdField_W_of_type_Boolean = false;
    this.jdField_X_of_type_Boolean = false;
    FlowCameraConstant.d = 2;
    if (CameraAbility.c()) {
      FlowCameraConstant.d = 1;
    }
    FlowCameraConstant.jdField_a_of_type_Float = 0.75F;
    if (paramBundle == null) {
      return;
    }
    this.ae = false;
    Object localObject = ((ActivityManager)super.getSystemService("activity")).getDeviceConfigurationInfo();
    boolean bool;
    SessionInfo localSessionInfo;
    if ((localObject != null) && (((ConfigurationInfo)localObject).reqGlEsVersion >= 131072))
    {
      bool = true;
      this.ae = bool;
      this.ac = false;
      this.ad = true;
      if (paramBundle.getBoolean("flow_camera_use_filter_function", false))
      {
        this.ac = PtvFilterSoLoad.a(VideoEnvironment.a(), false);
        this.ad = PtvFilterSoLoad.a();
        localObject = PtvFilterSoLoad.a(VideoEnvironment.a());
        if (localObject != null)
        {
          FaceOffUtil.setNoEyeGrayImagePath(localObject[0]);
          FaceOffUtil.setNoMouthGrayImagePath(localObject[1]);
        }
      }
      b(paramBundle);
      a(paramBundle, false);
      this.jdField_o_of_type_Boolean = paramBundle.getBoolean("flow_camera_use_surfaceview", false);
      this.jdField_s_of_type_Boolean = paramBundle.getBoolean("flow_camera_video_mode", false);
      localObject = paramBundle.getString("sv_config");
      bool = paramBundle.getBoolean("sv_whitelist");
      this.jdField_A_of_type_Boolean = paramBundle.getBoolean("flow_camera_show_redDot", false);
      if (!this.jdField_A_of_type_Boolean) {
        BaseApplicationImpl.a().getSharedPreferences("faceu_reddot_click_sp", 4).edit().putBoolean("faceu_reddot_click_sp", true).commit();
      }
      this.jdField_s_of_type_JavaLangString = paramBundle.getString("callback");
      FlowCameraConstant.d = BaseApplicationImpl.a().getSharedPreferences("PTV.NewFlowCameraActivity", 4).getInt("camera", FlowCameraConstant.d);
      if (QLog.isColorLevel()) {
        QLog.d("PTV.faceGuide", 2, "initdata isShowRed =" + this.jdField_A_of_type_Boolean + "mHasFilterSoLib=" + this.ac);
      }
      paramBundle = super.getIntent();
      localSessionInfo = (SessionInfo)paramBundle.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      if (localSessionInfo == null) {
        break label746;
      }
    }
    label540:
    label746:
    for (int i1 = localSessionInfo.jdField_a_of_type_Int;; i1 = 0)
    {
      int i2 = NetworkUtil.a(this);
      this.jdField_B_of_type_Boolean = paramBundle.getBooleanExtra("ignore_dpc_duration", false);
      if (this.jdField_B_of_type_Boolean)
      {
        this.jdField_D_of_type_Int = paramBundle.getIntExtra("video_duration", 20);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), 3, (String)localObject, bool, i1, i2, this.jdField_D_of_type_Int);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this, FlowCameraMqqAction.a(this), this)) {
          break label540;
        }
        super.finish();
        return;
        bool = false;
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)getAppRuntime(), 2, (String)localObject, bool, i1, i2, this.jdField_u_of_type_Int);
      }
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new pck(this, this));
      paramBundle = getResources().getDisplayMetrics();
      this.jdField_a_of_type_Float = paramBundle.widthPixels;
      this.jdField_b_of_type_Float = paramBundle.heightPixels;
      this.jdField_c_of_type_Float = (this.jdField_b_of_type_Float / this.jdField_a_of_type_Float);
      this.t_ = ((int)this.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new pcj(this, this);
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation()) {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(this, this.jdField_a_of_type_AndroidOsHandler);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PTV.NewFlowCameraActivity", 2, "initData(), mPtvMode:false,mCaptureMode:false, config=" + (String)localObject + ", white=" + bool);
      return;
    }
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (!(paramMessage.obj instanceof MotionEvent));
    ((MotionEvent)paramMessage.obj).recycle();
  }
  
  protected void a(ViewGroup paramViewGroup)
  {
    getLayoutInflater().inflate(2130904157, paramViewGroup);
    this.jdField_f_of_type_AndroidViewView = a(2131301605);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover = ((CameraCover)a(2131297175));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)a(2131301331));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131301332));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131301627));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131301633));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131301632));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = a(2131301607);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2131301609));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)a(2131301596));
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)a(2131300768));
    this.jdField_e_of_type_AndroidWidgetButton = ((Button)a(2131301624));
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)a(2131301618));
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QzoneTextBuilder.b);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)a(2131301617));
    this.jdField_g_of_type_AndroidWidgetButton = ((Button)a(2131301619));
    this.jdField_b_of_type_AndroidViewView = a(2131301620);
    this.jdField_f_of_type_AndroidWidgetButton = ((Button)a(2131301626));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131301614));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)a(2131301615));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2131301616));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)a(2131301631));
    M();
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)a(2131301329));
    this.jdField_h_of_type_AndroidWidgetButton = ((Button)a(2131300775));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView = ((RedDotImageView)a(2131301630));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)a(2131301328));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131301598));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer = ((ImageViewVideoPlayer)a(2131301548));
    this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setIMPlayerEndListener(this);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)a(2131301604));
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)a(2131299470));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)a(2131301622));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)a(2131301628));
    c((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    this.jdField_g_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_e_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout = ((FSurfaceViewLayout)a(2131301606));
    this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)a(2131301629));
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setBackgroundResource(2130838381);
    if (!CameraAbility.c())
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.jdField_e_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(64);
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(false);
    if (paramViewGroup != null)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramViewGroup);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!this.jdField_ai_of_type_Boolean) {
        break label980;
      }
      this.jdField_i_of_type_AndroidWidgetButton = this.jdField_a_of_type_AndroidWidgetButton;
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.jdField_h_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetButton.setEnabled(false);
    }
    for (this.jdField_r_of_type_Int = 2130842772;; this.jdField_r_of_type_Int = 0)
    {
      paramViewGroup = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getLayoutParams();
      if (paramViewGroup != null)
      {
        paramViewGroup.leftMargin = ((int)(getResources().getDisplayMetrics().widthPixels / 4.5F));
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setLayoutParams(paramViewGroup);
      }
      paramViewGroup = (RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
      if (paramViewGroup != null)
      {
        paramViewGroup.leftMargin = ((int)(getResources().getDisplayMetrics().widthPixels / 4.5F));
        this.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(paramViewGroup);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(100, getResources().getColor(2131427407), 100, getResources().getColor(2131427713));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(6.0F);
      if (!StringUtil.b(this.jdField_s_of_type_JavaLangString))
      {
        s();
        this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
        BaseApplicationImpl.a().getSharedPreferences(ShortVideoGuideUtil.jdField_a_of_type_JavaLangString, 4).edit().putBoolean("is_showed_ptv_guide", true).commit();
      }
      E();
      return;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(new ColorDrawable(-16777216));
      break;
      label980:
      this.jdField_i_of_type_AndroidWidgetButton = this.jdField_h_of_type_AndroidWidgetButton;
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_h_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    }
  }
  
  public void a(String paramString)
  {
    this.H = paramString;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.runOnUiThread(new pbj(this, paramBoolean, paramString));
  }
  
  protected boolean a()
  {
    return false;
  }
  
  int[] a()
  {
    return new int[] { (int)this.jdField_a_of_type_Float, (int)(this.jdField_a_of_type_Float * 3.0F / 4.0F) };
  }
  
  protected View b()
  {
    return this.jdField_f_of_type_AndroidViewView;
  }
  
  public String b(int paramInt)
  {
    int i2 = (int)Math.round(paramInt * 1.0D / 1000.0D);
    paramInt = i2 % 60;
    int i1 = i2 / 60 % 60;
    i2 /= 3600;
    this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
    if (i2 > 0) {
      return this.jdField_a_of_type_JavaUtilFormatter.format("%d:%02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1), Integer.valueOf(paramInt) }).toString();
    }
    return this.jdField_a_of_type_JavaUtilFormatter.format("%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt) }).toString();
  }
  
  public void b()
  {
    z();
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat > 0.0F)
    {
      if (!this.jdField_n_of_type_Boolean) {}
    }
    else {
      while (!this.jdField_n_of_type_Boolean) {
        return;
      }
    }
    Object localObject = getResources();
    if (paramFloat > 0.0F) {}
    while (paramFloat > 0.0F)
    {
      this.jdField_n_of_type_Boolean = true;
      int i1 = ScreenUtil.a(50.0F);
      localObject = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = i1;
      ((ViewGroup.LayoutParams)localObject).width = i1;
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("录制短视频，按钮，长按录制短视频");
      return;
      ((Resources)localObject).getDimensionPixelSize(2131493555);
    }
    d(false);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onFramesClipChanged, startTime=" + paramInt1 + ", endTime=" + paramInt2);
    }
    runOnUiThread(new pcf(this));
    if (this.jdField_h_of_type_AndroidWidgetImageView.getVisibility() != 0) {
      runOnUiThread(new pcg(this));
    }
    QzoneHandlerThreadFactory.a("Normal_HandlerThread").a(new pch(this, paramInt1, paramInt2));
    this.T = paramInt1;
  }
  
  void b(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfInt)
  {
    int i3 = (int)this.jdField_b_of_type_Float;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "getVideoClipPreviewMapSize constScreenWidth" + paramBoolean);
    }
    int i1;
    if (paramBoolean)
    {
      i1 = (int)this.jdField_a_of_type_Float;
      paramInt1 = (int)(paramInt1 * this.jdField_a_of_type_Float / paramInt2);
      paramArrayOfInt[0] = paramInt2;
      paramArrayOfInt[1] = ((int)(i3 * paramInt2 / this.jdField_a_of_type_Float));
    }
    for (paramInt2 = i1;; paramInt2 = i1)
    {
      paramArrayOfInt[1] = a(paramArrayOfInt[1]);
      paramArrayOfInt[2] = paramInt2;
      paramArrayOfInt[3] = paramInt1;
      return;
      i1 = (int)(paramInt2 * this.jdField_b_of_type_Float / paramInt1);
      int i2 = (int)this.jdField_b_of_type_Float;
      paramArrayOfInt[0] = ((int)(this.jdField_a_of_type_Float * paramInt2 / i1));
      paramArrayOfInt[1] = ((int)(i3 * paramInt1 / this.jdField_b_of_type_Float));
      paramInt1 = i2;
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_L_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "OnUploadVideoListener onUploadSuccess! " + this.jdField_L_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.hasMessages(1003)) {
      this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.removeMessages(1003);
    }
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(1001);
  }
  
  public void b(boolean paramBoolean)
  {
    p();
    U();
    if (paramBoolean) {
      c(true);
    }
  }
  
  boolean b()
  {
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "filterAllMemoryBufferIsFree isCanPreview=" + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean) {
      runOnUiThread(new pbg(this));
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog " + paramString);
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidAppProgressDialog == null) {
          continue;
        }
        B();
        localTextView = (TextView)this.jdField_a_of_type_AndroidAppProgressDialog.findViewById(2131298665);
        if (!StringUtil.b(paramString)) {
          continue;
        }
        localTextView.setText(2131368571);
      }
      catch (Throwable paramString)
      {
        TextView localTextView;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("PTV.NewFlowCameraActivity", 2, "showProgressDialog", paramString);
        return;
        localTextView.setText(paramString);
        continue;
      }
      if (this.jdField_a_of_type_AndroidAppProgressDialog.isShowing()) {
        return;
      }
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      return;
      this.jdField_a_of_type_AndroidAppProgressDialog = new ProgressDialog(this, 2131558973);
      this.jdField_a_of_type_AndroidAppProgressDialog.setCancelable(false);
      this.jdField_a_of_type_AndroidAppProgressDialog.show();
      this.jdField_a_of_type_AndroidAppProgressDialog.setContentView(2130903453);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i2 = 4;
    Object localObject3 = getResources().getDisplayMetrics();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494) == null)
    {
      localObject1 = localObject2;
      if (paramBoolean) {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext;
      }
    }
    int i1;
    if ((VersionUtils.d()) && (!this.jdField_o_of_type_Boolean))
    {
      localObject2 = new CameraTextureView(this);
      if ((localObject1 != null) && ((localObject1 instanceof TexturePreviewContext)))
      {
        ((CameraTextureView)localObject2).a = ((TexturePreviewContext)localObject1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraTextureView)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 83;
        this.jdField_y_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(this.ac, this.ae);
        paramBoolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a(this, this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
        if (QLog.isColorLevel()) {
          QLog.d("face", 2, "setupCameraUI needAddglview" + paramBoolean + "needChangeNewSurfaceView" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean + "needOpenglView=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean + "isSurpportFilter=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean) {
          break label714;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) {
          break label695;
        }
        if (QLog.isColorLevel()) {
          QLog.d("face", 2, "setupCameraUI isTemplateMode" + this.jdField_d_of_type_Boolean);
        }
        if (this.jdField_d_of_type_Boolean) {
          break label676;
        }
        if (!this.jdField_g_of_type_Boolean) {
          break label657;
        }
        if (this.jdField_i_of_type_AndroidWidgetButton != null)
        {
          localObject3 = this.jdField_e_of_type_AndroidWidgetTextView;
          if (!TextUtils.isEmpty(this.jdField_i_of_type_AndroidWidgetButton.getText().toString())) {
            break label651;
          }
          i1 = 4;
          label338:
          ((TextView)localObject3).setVisibility(i1);
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView;
          i1 = i2;
          if (TextUtils.isEmpty(this.jdField_i_of_type_AndroidWidgetButton.getText().toString())) {
            i1 = 0;
          }
          ((RedDotImageView)localObject3).setVisibility(i1);
        }
        label383:
        if (this.jdField_A_of_type_Boolean)
        {
          if (Build.MODEL.toUpperCase().contains("NEXUS 6P")) {
            this.jdField_l_of_type_AndroidWidgetTextView.setTextSize(11.0F);
          }
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.a(true);
        }
        label431:
        this.jdField_z_of_type_Boolean = true;
        ((FrameLayout.LayoutParams)localObject1).height = 1;
      }
    }
    for (((FrameLayout.LayoutParams)localObject1).width = 1;; ((FrameLayout.LayoutParams)localObject1).width = ((DisplayMetrics)localObject3).widthPixels)
    {
      ((FrameLayout.LayoutParams)localObject1).gravity = 81;
      if (this.jdField_y_of_type_Boolean) {
        ((FrameLayout.LayoutParams)localObject1).gravity = 49;
      }
      ((View)localObject2).setId(2131296494);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.addView((View)localObject2, 0, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.setCameraView((View)localObject2);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
      }
      this.jdField_u_of_type_Boolean = true;
      if (!this.jdField_v_of_type_Boolean) {
        break label756;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
      return;
      ((CameraTextureView)localObject2).a = new TexturePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels);
      break;
      localObject2 = new CameraPreview(this);
      if ((localObject1 != null) && ((localObject1 instanceof SurfacePreviewContext))) {}
      for (((CameraPreview)localObject2).a = ((SurfacePreviewContext)localObject1);; ((CameraPreview)localObject2).a = new SurfacePreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, ((DisplayMetrics)localObject3).widthPixels, ((DisplayMetrics)localObject3).heightPixels))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(((CameraPreview)localObject2).a);
        localObject1 = new FrameLayout.LayoutParams(-1, ((DisplayMetrics)localObject3).heightPixels);
        ((FrameLayout.LayoutParams)localObject1).gravity = 51;
        this.jdField_y_of_type_Boolean = true;
        break;
      }
      label651:
      i1 = 0;
      break label338;
      label657:
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(0);
      break label383;
      label676:
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      break label431;
      label695:
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      break label431;
      label714:
      this.jdField_z_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      ((FrameLayout.LayoutParams)localObject1).height = ((DisplayMetrics)localObject3).heightPixels;
    }
    label756:
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = false;
  }
  
  public boolean c()
  {
    if (!this.jdField_d_of_type_Boolean) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.d))) {
      return false;
    }
    return true;
  }
  
  public int c_()
  {
    return 0;
  }
  
  public void d()
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_AndroidWidgetImageView.isEnabled()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    }
    int i3 = this.jdField_s_of_type_Int;
    int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
    int i1 = i2;
    if (i2 <= 0) {
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getRemainedRecordFrames(0);
    }
    if (i1 > 0) {
      this.at = i1;
    }
    if (this.jdField_k_of_type_Boolean)
    {
      if (!this.jdField_l_of_type_Boolean) {
        break label226;
      }
      b(1, null, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(CodecParam.d, i3, this.at, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.setCyclePlay(true);
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
      BitmapFactory.Options localOptions;
      if ((localObject2 != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).c != null) && (((RMVideoThumbGenMgr.ThumbGenItem)localObject2).a.get() == 3) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable == null))
      {
        localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = 2;
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      }
      try
      {
        localObject2 = BitmapFactory.decodeFile(((RMVideoThumbGenMgr.ThumbGenItem)localObject2).c, localOptions);
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;) {}
      }
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(super.getResources(), (Bitmap)localObject1);
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a();
      return;
      label226:
      b(1, this.jdField_x_of_type_JavaLangString, false);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "ptvRevert(): sendVideo:" + paramBoolean + ",mIsVideoMode: " + this.jdField_n_of_type_Boolean + ", mPtvMode: " + false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.i();
      if (this.jdField_n_of_type_Boolean) {}
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMViewSTInterface.j();
    if (paramBoolean)
    {
      if (RichmediaClient.a().a().a(this.jdField_q_of_type_JavaLangString) != null) {
        break label273;
      }
      LogTag.a(this.jdField_q_of_type_JavaLangString, "sendShortVideo", "[peak] old procedure");
      getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
      float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      c(i2);
      int i1 = i2;
      if (i2 <= 0) {
        i1 = this.at;
      }
      FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, this.jdField_a_of_type_Double, this.jdField_b_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface, false, i3, i1, this.jdField_w_of_type_JavaLangString, this.jdField_q_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_g_of_type_Boolean);
      if (VideoEnvironment.e())
      {
        View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494);
        if (localView != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
        }
      }
    }
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      e(paramBoolean);
      this.jdField_n_of_type_Boolean = false;
      return;
      label273:
      if (VideoEnvironment.e())
      {
        setResult(1001);
        finish();
      }
      LogTag.a(this.jdField_q_of_type_JavaLangString, "sendShortVideo", "[peak] preupload procedure");
      break;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    }
    this.jdField_W_of_type_Boolean = true;
    boolean bool1 = CameraCompatibleList.a(CameraCompatibleList.jdField_q_of_type_JavaLangString);
    boolean bool2 = CameraCompatibleList.e(CameraCompatibleList.jdField_A_of_type_JavaLangString);
    if ((!this.jdField_m_of_type_Boolean) && ((bool1) || (bool2)) && (!this.jdField_al_of_type_Boolean))
    {
      this.jdField_al_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  void e(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "exitVideoMode(), mPtvMode = false, clearCache = " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      if (paramBoolean)
      {
        a(103);
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
  
  public void f() {}
  
  void f(boolean paramBoolean)
  {
    int i2 = 0;
    int[] arrayOfInt = new int[6];
    if ((this.jdField_v_of_type_Int == -1) || (this.jdField_w_of_type_Int == -1)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("PTV.NewFlowCameraActivity", 2, "[changeVideoPreviewMapSize]rmStateMgr " + null);
    return;
    RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    float f1 = this.jdField_v_of_type_Int * 1.0F / this.jdField_w_of_type_Int;
    if (this.jdField_c_of_type_Float > f1) {}
    for (boolean bool = false;; bool = true)
    {
      if (paramBoolean) {
        a(this.jdField_v_of_type_Int, this.jdField_w_of_type_Int, bool, arrayOfInt);
      }
      try
      {
        a(arrayOfInt[2], arrayOfInt[3], arrayOfInt);
        if (!paramBoolean) {
          a(this.jdField_v_of_type_Int, this.jdField_w_of_type_Int, bool, arrayOfInt);
        }
        localRMVideoClipSpec.c = arrayOfInt[0];
        localRMVideoClipSpec.d = arrayOfInt[1];
        localRMVideoClipSpec.e = this.jdField_v_of_type_Int;
        localRMVideoClipSpec.jdField_f_of_type_Int = this.jdField_w_of_type_Int;
        int i3;
        if (RMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean))
        {
          i3 = 16;
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "changeVideoPreviewMapSizeclip_width=" + localRMVideoClipSpec.c + "clip_height=" + localRMVideoClipSpec.d + "m_dst_width=" + localRMVideoClipSpec.e + "dst_width=" + localRMVideoClipSpec.jdField_f_of_type_Int + "aligned_byte=" + i3 + "constScreenWidth=" + bool);
          }
          if (!bool) {
            break label515;
          }
          if (localRMVideoClipSpec.c % i3 == 0) {
            break label627;
          }
          i1 = i3 - localRMVideoClipSpec.c % i3;
          if (localRMVideoClipSpec.d % i3 != 0) {
            i2 = i3 - localRMVideoClipSpec.d % i3;
          }
          localRMVideoClipSpec.c += i1;
          localRMVideoClipSpec.d += i2;
          if (!this.jdField_y_of_type_Boolean) {
            break label498;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(2, localRMVideoClipSpec, this.jdField_A_of_type_Int);
        }
        for (;;)
        {
          localRMVideoClipSpec.e = localRMVideoClipSpec.c;
          localRMVideoClipSpec.jdField_f_of_type_Int = localRMVideoClipSpec.d;
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "changeVideoPreviewMapSizem_clip_width=" + i1 + "m_clip_height=" + i2 + "aligned_byte=" + i3);
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localRMVideoClipSpec, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_d_of_type_Boolean);
          return;
          i3 = 4;
          break;
          label498:
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(5, localRMVideoClipSpec, this.jdField_B_of_type_Int);
        }
        label515:
        i1 = localRMVideoClipSpec.c % i3;
        i2 = localRMVideoClipSpec.d % i3;
        localRMVideoClipSpec.c -= i1;
        localRMVideoClipSpec.d -= i2;
        if (this.jdField_y_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(2, localRMVideoClipSpec, this.jdField_A_of_type_Int);
        }
        for (;;)
        {
          localRMVideoClipSpec.e = localRMVideoClipSpec.c;
          localRMVideoClipSpec.jdField_f_of_type_Int = localRMVideoClipSpec.d;
          break;
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(5, localRMVideoClipSpec, this.jdField_B_of_type_Int);
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        for (;;)
        {
          continue;
          label627:
          int i1 = 0;
        }
      }
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.aq == 1) && (this.jdField_Z_of_type_Boolean)) {
      overridePendingTransition(0, 2130968591);
    }
  }
  
  public void g()
  {
    QzoneHandlerThreadFactory.a("Normal_HandlerThread", false).a(new pcm(this, this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder));
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "recordVideoFinish");
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.a())
    {
      r();
      return;
    }
    a(this, 2131370344);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.lockFrameSync();
    t();
    r();
  }
  
  public void g(boolean paramBoolean) {}
  
  public void h() {}
  
  void h(boolean paramBoolean)
  {
    runOnUiThread(new pcn(this, paramBoolean));
  }
  
  public void h_(boolean paramBoolean)
  {
    super.runOnUiThread(new pbh(this, paramBoolean));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "handleMessage,msg.what = " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    case 1002: 
    case 1004: 
    case 1005: 
    default: 
      return false;
    case 1003: 
      B();
      QQToast.a(this, 1, 2131369518, 0).a();
      i(true);
      return true;
    case 1001: 
      this.af = true;
      this.jdField_M_of_type_JavaLangString = a(this.jdField_L_of_type_JavaLangString, this.K);
      A();
      i(false);
      return true;
    case 1006: 
      a("608", "3", "1", true);
      d((String)paramMessage.obj);
      return true;
    }
    a("608", "3", "2", true);
    if (this.jdField_j_of_type_Boolean) {
      k(true);
    }
    for (;;)
    {
      return true;
      j(true);
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "enterViewVideoMode");
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    if (!this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    }
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  public void i(boolean paramBoolean)
  {
    setResult(1001);
    finish();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PTV.NewFlowCameraActivity", 2, "exitViewVideoMode");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    if (!this.jdField_b_of_type_AndroidWidgetButton.isEnabled()) {
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
    }
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    }
  }
  
  public void k()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetImageView.setAlpha(255);
    }
    if (this.jdField_d_of_type_AndroidWidgetImageView.getVisibility() == 0)
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetImageView.setAlpha(255);
    }
    if (QLog.isColorLevel()) {
      QLog.d("face", 4, "getFirstFrame gl_root.getVisibility()=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.getVisibility());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(0);
    this.jdField_m_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
  }
  
  public void l()
  {
    super.finish();
  }
  
  public void m() {}
  
  public void n()
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
  
  public void o()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_v_of_type_Int, this.jdField_w_of_type_Int, this.jdField_y_of_type_Boolean, false, null);
    Object localObject = RichmediaClient.a().a().a(this.jdField_q_of_type_JavaLangString);
    if (localObject != null) {
      ((CompoundProcessor)localObject).a(103);
    }
    for (;;)
    {
      localObject = getIntent();
      ((Intent)localObject).putExtra("flow_back", 0);
      setResult(1001, (Intent)localObject);
      super.onBackPressed();
      return;
      n();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      this.ag = true;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(this, paramInt1, paramInt2, paramIntent);
      }
      return;
      Object localObject1;
      Object localObject2;
      if (paramInt1 == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "onActivityResult:requestCode=" + paramInt1 + "  resultCode=" + paramInt2);
        }
        if (paramIntent != null)
        {
          localObject1 = paramIntent.getExtras();
          if (((Bundle)localObject1).containsKey("permission_code")) {
            this.jdField_q_of_type_Int = ((Bundle)localObject1).getInt("permission_code");
          }
          if (((Bundle)localObject1).containsKey("uin_list"))
          {
            if (this.jdField_a_of_type_JavaUtilArrayList == null) {
              this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            }
            this.jdField_a_of_type_JavaUtilArrayList.clear();
            localObject2 = ((Bundle)localObject1).getStringArrayList("uin_list");
            if (localObject2 != null) {
              this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject2);
            }
          }
          if (a(this.jdField_q_of_type_Int))
          {
            this.jdField_o_of_type_JavaLangString = ((Bundle)localObject1).getString("key_setting_raw_json");
            this.jdField_n_of_type_JavaLangString = ((Bundle)localObject1).getString("key_selected_tag");
          }
          G();
        }
      }
      else if (paramInt1 == 1009)
      {
        this.jdField_am_of_type_Boolean = false;
        this.jdField_c_of_type_Boolean = false;
        if (this.jdField_g_of_type_AndroidViewView != null) {
          this.jdField_g_of_type_AndroidViewView.setVisibility(8);
        }
        if (paramIntent != null)
        {
          Bundle localBundle = paramIntent.getExtras();
          if (localBundle.containsKey("extra_key_bundle_priv_key"))
          {
            localObject1 = localBundle.getBundle("extra_key_bundle_priv_key");
            if (localObject1 != null)
            {
              this.jdField_q_of_type_Int = ((Bundle)localObject1).getInt("permission_code");
              if (this.jdField_a_of_type_JavaUtilArrayList == null) {
                this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
              }
              this.jdField_a_of_type_JavaUtilArrayList.clear();
              localObject2 = ((Bundle)localObject1).getStringArrayList("uin_list");
              if (localObject2 != null) {
                this.jdField_a_of_type_JavaUtilArrayList.addAll((Collection)localObject2);
              }
              if (a(this.jdField_q_of_type_Int))
              {
                this.jdField_o_of_type_JavaLangString = ((Bundle)localObject1).getString("key_setting_raw_json");
                this.jdField_n_of_type_JavaLangString = ((Bundle)localObject1).getString("key_selected_tag");
              }
              G();
            }
          }
          if (localBundle.containsKey("contentIntentKey"))
          {
            localObject2 = localBundle.getString("contentIntentKey");
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            this.jdField_w_of_type_JavaLangString = ((String)localObject1);
          }
          if (localBundle.containsKey("contentIntentKeyForVideoEditWithEmo"))
          {
            localObject1 = localBundle.getString("contentIntentKeyForVideoEditWithEmo");
            this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject1);
          }
        }
      }
      else if ((paramInt1 == 1010) && (paramInt2 == -1))
      {
        ToastUtil.a().a("开通成功");
        this.ah = true;
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.jdField_n_of_type_Boolean)
    {
      q();
      return;
    }
    o();
  }
  
  public void onClick(View paramView)
  {
    if (!this.jdField_u_of_type_Boolean) {}
    long l1;
    Object localObject1;
    label825:
    label834:
    do
    {
      do
      {
        return;
        i1 = paramView.getId();
        if (i1 != 2131301332) {
          break;
        }
      } while ((!Utils.b()) || (this.jdField_n_of_type_Boolean) || (!QLog.isColorLevel()));
      QLog.i("PTV.NewFlowCameraActivity", 2, "Press the capture button.");
      return;
      if (i1 == 2131300775)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get());
        }
        if ((this.jdField_A_of_type_Boolean) && (this.jdField_s_of_type_JavaLangString == null))
        {
          if (Build.MODEL.toUpperCase().contains("NEXUS 6P")) {
            this.jdField_l_of_type_AndroidWidgetTextView.setTextSize(11.0F);
          }
          this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 4)
        {
          if (c()) {
            FlowCameraMqqAction.b("", "0X8006A17");
          }
          for (;;)
          {
            b(true);
            if (this.jdField_v_of_type_Boolean) {
              this.jdField_w_of_type_Boolean = true;
            }
            if (QLog.isColorLevel()) {
              QLog.d("face", 2, "click left hasChangeCamera" + this.jdField_v_of_type_Boolean);
            }
            x();
            return;
            FlowCameraMqqAction.b("", "0X8006A1B");
          }
        }
        FlowCameraMqqAction.b("", "0X8006A12");
        o();
        return;
      }
      if (i1 == 2131300768)
      {
        FlowCameraMqqAction.b("", "0X8006A12");
        o();
        return;
      }
      if ((i1 != 2131301630) && (i1 != 2131301631)) {
        break label1655;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "click right state is =" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get());
      }
      if (!this.jdField_j_of_type_Boolean) {
        break label882;
      }
      paramView = new Bundle();
      paramView.putString("param.content", this.jdField_w_of_type_JavaLangString);
      paramView.putInt("param.priv", this.jdField_q_of_type_Int);
      paramView.putStringArrayList("param.privList", this.jdField_a_of_type_JavaUtilArrayList);
      paramView.putString("param.videoPath", this.jdField_m_of_type_JavaLangString);
      paramView.putLong("param.videoSize", this.jdField_b_of_type_Long);
      paramView.putInt("param.videoType", 1);
      paramView.putString("param.thumbnailPath", this.jdField_u_of_type_JavaLangString);
      paramView.putInt("param.thumbnailHeight", this.jdField_Z_of_type_Int);
      paramView.putInt("param.thumbnailWidth", this.jdField_Y_of_type_Int);
      if (this.P)
      {
        l1 = this.jdField_V_of_type_Int;
        paramView.putLong("param.startTime", l1);
        if (!this.P) {
          break label825;
        }
      }
      for (l1 = this.jdField_W_of_type_Int - this.jdField_V_of_type_Int;; l1 = this.jdField_c_of_type_Long)
      {
        paramView.putLong("param.duration", l1);
        paramView.putLong("param.totalDuration", this.jdField_c_of_type_Long);
        paramView.putBoolean("param.needProcess", this.jdField_S_of_type_Boolean);
        paramView.putBoolean("param.isUploadOrigin", this.jdField_U_of_type_Boolean);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("sv_encode_max_bitrate", CodecParam.jdField_D_of_type_Int);
        ((Bundle)localObject1).putInt("sv_encode_min_bitrate", CodecParam.E);
        ((Bundle)localObject1).putInt("sv_encode_qmax", CodecParam.F);
        ((Bundle)localObject1).putInt("sv_encode_qmin", CodecParam.G);
        ((Bundle)localObject1).putInt("sv_encode_qmaxdiff", CodecParam.H);
        ((Bundle)localObject1).putInt("sv_encode_ref_frame", CodecParam.jdField_I_of_type_Int);
        ((Bundle)localObject1).putInt("sv_encode_smooth", CodecParam.jdField_J_of_type_Int);
        ((Bundle)localObject1).putInt("sv_total_frame_count", this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex());
        ((Bundle)localObject1).putInt("sv_total_record_time", (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
        paramView.putBundle("param.extras", (Bundle)localObject1);
        a("608", "1", "0", true);
        l1 = QzoneConfig.a().a("VideoEdit", "UploadMaxSizeTipWithNoWifi", 20971520L);
        if ((NetworkUtil.b(BaseApplication.getContext()) == 1) || (this.jdField_b_of_type_Long <= l1)) {
          break label852;
        }
        if (this.jdField_b_of_type_ComTencentWidgetActionSheet != null) {
          break label834;
        }
        localObject1 = "当前视频超过" + l1 / 1024L / 1024L + "M，将会消耗你的手机流量";
        this.jdField_b_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this);
        this.jdField_b_of_type_ComTencentWidgetActionSheet.a((CharSequence)localObject1);
        this.jdField_b_of_type_ComTencentWidgetActionSheet.a("立即上传", 0);
        this.jdField_b_of_type_ComTencentWidgetActionSheet.d("取消");
        this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new pam(this, paramView));
        this.jdField_b_of_type_ComTencentWidgetActionSheet.a(new pan(this));
        this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
        return;
        l1 = 0L;
        break;
      }
    } while (this.jdField_b_of_type_ComTencentWidgetActionSheet.isShowing());
    this.jdField_b_of_type_ComTencentWidgetActionSheet.show();
    return;
    label852:
    if (!this.jdField_V_of_type_Boolean)
    {
      c(paramView);
      return;
    }
    RemoteHandleManager.a().a("cmd.publishVideoMood", paramView, false);
    finish();
    return;
    label882:
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PTV.NewFlowCameraActivity", 2, "click right totalTime=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
      }
      if ((this.jdField_C_of_type_Int != 90) && (this.jdField_C_of_type_Int != 270)) {
        break label3086;
      }
    }
    label1055:
    label1521:
    label1655:
    label1989:
    label3074:
    label3086:
    for (int i1 = 1;; i1 = 0)
    {
      if (FlowCameraConstant.d == 1) {}
      for (int i2 = 1;; i2 = 0)
      {
        a("608", "1", "0", true);
        boolean bool = c();
        if (!bool)
        {
          FlowCameraMqqAction.a("", "0X8006A16", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, "");
          paramView = "";
        }
        for (;;)
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("param_duration", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double));
          ((HashMap)localObject1).put("param_orientation", String.valueOf(i1));
          if (!TextUtils.isEmpty(paramView)) {
            ((HashMap)localObject1).put("param_template", paramView);
          }
          Object localObject2;
          Object localObject3;
          if (this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface != null)
          {
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a();
            localObject3 = StatisticCollector.a(BaseApplicationImpl.getContext());
            if (!bool) {
              break label1521;
            }
          }
          for (paramView = "actPtvUseTemplate";; paramView = "actPtvNotUseTemplate")
          {
            ((StatisticCollector)localObject3).a((String)localObject2, paramView, true, 0L, 0L, (HashMap)localObject1, "");
            if ((this.jdField_A_of_type_Boolean) && (this.jdField_s_of_type_JavaLangString == null))
            {
              if (Build.MODEL.toUpperCase().contains("NEXUS 6P")) {
                this.jdField_l_of_type_AndroidWidgetTextView.setTextSize(11.0F);
              }
              this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
            }
            new DCShortVideo(BaseApplication.getContext());
            this.jdField_Z_of_type_Boolean = true;
            T();
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.i();
            a(102);
            LogTag.a(this.jdField_q_of_type_JavaLangString, "SendBtn Click ", ",(int)rmStateMgr.mTotalTime = " + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double + ",frames = " + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex() + " VideoABTest:" + SystemClock.uptimeMillis());
            paramView = RichmediaClient.a().a().a(this.jdField_q_of_type_JavaLangString);
            if (paramView != null) {
              paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString, (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getFrameIndex(), this.jdField_f_of_type_Long, this.jdField_ai_of_type_Int);
            }
            d(true);
            this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.jdField_v_of_type_Int, this.jdField_w_of_type_Int, this.jdField_y_of_type_Boolean, false, null);
            if (VideoEnvironment.e()) {
              break;
            }
            setResult(1001);
            finish();
            return;
            FlowCameraMqqAction.a("", "0X8006A19", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double), "" + i1, "" + i2, "");
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) {
              break label3074;
            }
            i2 = this.jdField_a_of_type_ComTencentWidgetHorizontalListView.getFirstVisiblePosition() + 1;
            if (i2 >= this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            paramView = ((PtvTemplateManager.PtvTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.jdField_a_of_type_JavaUtilArrayList.get(i2)).name;
            break label1055;
          }
          if (QLog.isColorLevel()) {
            QLog.d("PTV.NewFlowCameraActivity", 2, "click right invisible enable=" + paramView.isEnabled());
          }
          if (this.jdField_A_of_type_Boolean)
          {
            BaseApplicationImpl.a().getSharedPreferences("faceu_reddot_click_sp", 4).edit().putBoolean("faceu_reddot_click_sp", true).commit();
            this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.a(false);
            this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_A_of_type_Boolean = false;
            if (QLog.isColorLevel()) {
              QLog.d("faceGuide", 2, "click guide red  ======");
            }
            Z();
          }
          s();
          FlowCameraMqqAction.b("", "0X8006A14");
          return;
          if (i1 == 2131301596)
          {
            a(-1, false);
            FlowCameraMqqAction.b("", "0X8006A15");
            return;
          }
          if (i1 == 2131301598)
          {
            if (QLog.isColorLevel()) {
              QLog.i("PTV.NewFlowCameraActivity", 2, "Press the cancel button state=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get());
            }
            if (this.jdField_a_of_type_AndroidWidgetProgressBar != null)
            {
              this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress(0);
              this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 4) || (this.jdField_j_of_type_Boolean))
            {
              this.jdField_k_of_type_Boolean = false;
              if (this.jdField_j_of_type_Boolean)
              {
                a("608", "2", "0", true);
                this.jdField_V_of_type_Int = 0;
                this.jdField_W_of_type_Int = 0;
                this.T = 0;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout != null)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c();
                  this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVisibility(0);
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView != null) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.stopPlayback();
                }
                if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar != null) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetVideoFrameSelectBar.c();
                }
                if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
                  this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
                }
                d(8);
                this.jdField_j_of_type_Boolean = false;
                if (!c()) {
                  break label1989;
                }
                FlowCameraMqqAction.b("", "0X8006A17");
              }
              for (;;)
              {
                b(true);
                if (this.jdField_v_of_type_Boolean) {
                  this.jdField_w_of_type_Boolean = true;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("face", 2, "click left hasChangeCamera" + this.jdField_v_of_type_Boolean);
                }
                x();
                return;
                a("608", "2", "0", true);
                break;
                FlowCameraMqqAction.b("", "0X8006A1B");
              }
            }
            if (QLog.isColorLevel()) {
              QLog.e("PTV.NewFlowCameraActivity", 2, "flow_camera_btn_video_local");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowComponentInterface.a(this);
            }
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new par(this), 1000L);
            return;
          }
          if (i1 == 2131301624)
          {
            if (this.jdField_O_of_type_Boolean)
            {
              this.jdField_h_of_type_Boolean = true;
              this.jdField_k_of_type_Boolean = false;
              localObject1 = QzoneConfig.a().a("VideoEdit", "VideoBgMusicSelectUrl", "http://y.qq.com/m/qzone_video/index.html?_wv=1");
              paramView = (View)localObject1;
              if (!TextUtils.isEmpty(this.jdField_t_of_type_JavaLangString)) {
                paramView = (String)localObject1 + "&songid=" + this.jdField_t_of_type_JavaLangString;
              }
              localObject1 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
              ((Intent)localObject1).putExtra("url", paramView);
              ((Intent)localObject1).putExtra("fromQZone", true);
              ((Intent)localObject1).putExtra("injectrecommend", true);
              ((Intent)localObject1).putExtra("source_name", BaseApplicationImpl.getContext().getString(2131367184));
              ((Intent)localObject1).setData(Uri.parse(paramView));
              startActivity((Intent)localObject1);
              return;
            }
            Toast.makeText(getApplicationContext(), "视频过大，暂不支持添加背景音乐", 1).show();
            return;
          }
          if (i1 == 2131301626)
          {
            if (this.jdField_j_of_type_Boolean)
            {
              if (this.jdField_N_of_type_Boolean)
              {
                QLog.e("PTV.NewFlowCameraActivity", 2, "click clip ");
                paramView = a(this.jdField_u_of_type_JavaLangString, this.jdField_Y_of_type_Int, this.jdField_Z_of_type_Int, false);
                if (paramView != null) {
                  this.jdField_g_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
                }
                for (;;)
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.T);
                  this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
                  this.Q = true;
                  m(true);
                  return;
                  QLog.e("PTV.NewFlowCameraActivity", 2, "click clip but coverview find bitmap is null");
                }
              }
              l1 = QzoneConfig.a().a("MiniVideo", "VideoDurationThreshold", 60000);
              Toast.makeText(getApplicationContext(), "视频长度超过" + l1 / 1000L + "秒，暂不支持裁剪", 1).show();
              return;
            }
            Toast.makeText(getApplicationContext(), "录制视频暂不支持裁剪", 1).show();
            return;
          }
          if (i1 == 2131301619)
          {
            localObject1 = QzoneConfig.a().a("H5Url", "UgcPermitSetting", "http://h5.qzone.qq.com/ugc/setting?_wv=3&type=mood&uin={uin}&qua={qua}");
            paramView = "";
            if (this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface != null) {
              paramView = this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface.a();
            }
            paramView = ((String)localObject1).replace("{uin}", paramView).replace("{qua}", QUA.a());
            a("608", "6", "0", true);
            localObject1 = new Bundle();
            ((Bundle)localObject1).putInt("permission_code", this.jdField_q_of_type_Int);
            if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
            {
              ((Bundle)localObject1).putStringArrayList("uin_list", this.jdField_a_of_type_JavaUtilArrayList);
              localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
              localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              while (((Iterator)localObject3).hasNext()) {
                ((ArrayList)localObject2).add(a((String)((Iterator)localObject3).next()));
              }
              ((Bundle)localObject1).putStringArrayList("key_nicknames", (ArrayList)localObject2);
            }
            if ((a(this.jdField_q_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))) {
              ((Bundle)localObject1).putString("key_setting_raw_json", this.jdField_o_of_type_JavaLangString);
            }
            QZoneHelper.a(this, paramView, 2, (Bundle)localObject1, "");
            return;
          }
          if ((i1 == 2131301614) || (i1 == 2131301615))
          {
            if (!this.ah)
            {
              ag();
              return;
            }
            if (this.jdField_f_of_type_Boolean)
            {
              ToastUtil.a().a("不使用原画");
              this.jdField_f_of_type_Boolean = false;
              this.jdField_d_of_type_AndroidWidgetButton.setBackgroundResource(2130842761);
              this.jdField_U_of_type_Boolean = false;
              return;
            }
            ToastUtil.a().a("使用原画");
            a("608", "7", "1", true);
            this.jdField_f_of_type_Boolean = true;
            this.jdField_d_of_type_AndroidWidgetButton.setBackgroundResource(2130842760);
            this.jdField_U_of_type_Boolean = true;
            return;
          }
          if (i1 == 2131301642)
          {
            a("608", "4", "1", true);
            QzoneHandlerThreadFactory.a("RealTime_HandlerThread").a(new pas(this));
            return;
          }
          if (i1 == 2131301640)
          {
            S();
            return;
          }
          if (i1 != 2131301618) {
            break;
          }
          this.jdField_am_of_type_Boolean = true;
          this.jdField_R_of_type_Boolean = true;
          this.jdField_c_of_type_Boolean = true;
          a("608", "5", "0", true);
          paramView = QZoneHelper.UserInfo.a();
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("permission_code", this.jdField_q_of_type_Int);
          if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
          {
            ((Bundle)localObject1).putStringArrayList("uin_list", this.jdField_a_of_type_JavaUtilArrayList);
            localObject2 = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList.size());
            localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            while (((Iterator)localObject3).hasNext()) {
              ((ArrayList)localObject2).add(a((String)((Iterator)localObject3).next()));
            }
            ((Bundle)localObject1).putStringArrayList("key_nicknames", (ArrayList)localObject2);
          }
          if ((a(this.jdField_q_of_type_Int)) && (!TextUtils.isEmpty(this.jdField_o_of_type_JavaLangString))) {
            ((Bundle)localObject1).putString("key_setting_raw_json", this.jdField_o_of_type_JavaLangString);
          }
          if (this.jdField_g_of_type_AndroidViewView == null)
          {
            this.jdField_g_of_type_AndroidViewView = new View(this);
            this.jdField_g_of_type_AndroidViewView.setBackgroundColor(Color.argb(128, 0, 0, 0));
            this.jdField_g_of_type_AndroidViewView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            ((RelativeLayout)this.jdField_f_of_type_AndroidViewView).addView(this.jdField_g_of_type_AndroidViewView);
          }
          this.jdField_g_of_type_AndroidViewView.setVisibility(0);
          QZoneHelper.a(this, paramView, 1009, "", this.jdField_w_of_type_JavaLangString, "", "", 0, 1, 1, 0, 0, 0, "", 10000, (Bundle)localObject1);
          return;
          paramView = "";
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.getWindow().addFlags(128);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("DeviceInfo:");
      localStringBuilder.append("PRODUCT=").append(Build.PRODUCT).append("|");
      localStringBuilder.append("MODEL=").append(Build.MODEL).append("|");
      localStringBuilder.append("BOARD=").append(Build.BOARD).append("|");
      localStringBuilder.append("BOOTLOADER=").append(Build.BOOTLOADER).append("|");
      localStringBuilder.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
      localStringBuilder.append("CPU_ABI2=").append(Build.CPU_ABI2).append("|");
      localStringBuilder.append("DEVICE=").append(Build.DEVICE).append("|");
      localStringBuilder.append("DISPLAY=").append(Build.DISPLAY).append("|");
      localStringBuilder.append("FLNGERPRINT=").append(Build.FINGERPRINT).append("|");
      localStringBuilder.append("HARDWARE=").append(Build.HARDWARE).append("|");
      localStringBuilder.append("ID=").append(Build.ID).append("|");
      localStringBuilder.append("SERIAL=").append(Build.SERIAL).append("|");
      localStringBuilder.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      localStringBuilder.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i("PTV.NewFlowCameraActivity", 2, localStringBuilder.toString());
    }
    L();
    this.jdField_L_of_type_Boolean = true;
    this.jdField_M_of_type_Boolean = b();
    PerfTracer.a("Video_component_onCreate");
    super.onCreate(paramBundle);
    PerfTracer.b("Video_component_onCreate");
    this.jdField_f_of_type_Long = 0L;
    this.jdField_ai_of_type_Int = 0;
    PtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface).d(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface);
    paramBundle = ViewConfiguration.get(this);
    this.jdField_I_of_type_Int = paramBundle.getScaledMinimumFlingVelocity();
    this.jdField_J_of_type_Int = paramBundle.getScaledMaximumFlingVelocity();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(this);
    aa();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (this.jdField_d_of_type_JavaLangRunnable != null) {
      QzoneHandlerThreadFactory.a("Normal_HandlerThread").b(this.jdField_d_of_type_JavaLangRunnable);
    }
    BaseApplicationImpl.a().getSharedPreferences("PTV.NewFlowCameraActivity", 4).edit().putInt("camera", FlowCameraConstant.d).commit();
    try
    {
      if (this.as == 1)
      {
        unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
        this.as = 0;
      }
      if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
        unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, " already unregisterReceiver" + localIllegalArgumentException);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.d();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
    if (this.jdField_a_of_type_AndroidViewOrientationEventListener != null) {
      this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (!this.ad) {
      ThreadManager.a(new pak(this), 8, null, true);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    this.jdField_m_of_type_JavaLangString = paramIntent.getStringExtra("file_send_path");
    this.jdField_b_of_type_Long = paramIntent.getLongExtra("PhotoConst.VIDEO_SIZE", 0L);
    this.jdField_c_of_type_Long = paramIntent.getLongExtra("file_send_duration", 0L);
    this.jdField_o_of_type_Int = paramIntent.getIntExtra("file_width", 0);
    this.jdField_p_of_type_Int = paramIntent.getIntExtra("file_height", 0);
    QLog.i("PTV.NewFlowCameraActivity", 2, "localVideoWidth: " + this.jdField_o_of_type_Int + " ,    localVideoHeight: " + this.jdField_p_of_type_Int);
    this.jdField_j_of_type_Boolean = true;
    H();
    super.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_am_of_type_Boolean) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!this.jdField_j_of_type_Boolean) {
            break;
          }
        } while (TextUtils.isEmpty(this.jdField_J_of_type_JavaLangString));
        if (!this.Q)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
          return;
        }
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.isPlaying());
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.b();
      this.jdField_m_of_type_Boolean = false;
      if (this.aq == 1) {
        QzoneOnlineTimeCollectRptService.a().a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 4) {
        p();
      }
      View localView = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494);
      if (localView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
      }
    } while ((this.ab) || (this.jdField_Z_of_type_Boolean) || (this.aa));
    this.ab = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 300000L);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_am_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      return;
    }
    if (this.jdField_j_of_type_Boolean)
    {
      if (!this.Q)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.jdField_V_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.start();
        this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        return;
        Bitmap localBitmap = a(this.jdField_u_of_type_JavaLangString, this.jdField_Y_of_type_Int, this.jdField_Z_of_type_Int, false);
        if (localBitmap != null) {
          this.jdField_g_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        }
        m(true);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.seekTo(this.T);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFixedSizeVideoView.pause();
      }
    }
    P();
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_j_of_type_Boolean) {
      return;
    }
    O();
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_b_of_type_Double = 0.0D;
    this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new paj(this, 1, true, true, 0L, false, false, "NewFlowCameraActivity");
    SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_w_of_type_Boolean) {
      this.jdField_x_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener != null)
    {
      SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
      this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = null;
      this.jdField_a_of_type_Double = 0.0D;
      this.jdField_b_of_type_Double = 0.0D;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!this.jdField_u_of_type_Boolean) {}
    while ((this.jdField_r_of_type_Boolean) || (!this.jdField_a_of_type_AndroidWidgetImageView.isClickable())) {
      return bool;
    }
    this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.b();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.d();
    }
  }
  
  void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double == 0.0D)
    {
      o();
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.b(this, false);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("放弃录制，当前视频将会被删除");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a("放弃", 3);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.d("取消");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new pal(this));
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void r()
  {
    this.jdField_j_of_type_Boolean = false;
    this.jdField_O_of_type_Boolean = true;
    if (this.jdField_f_of_type_AndroidWidgetButton != null) {
      ViewUtils.a(this.jdField_f_of_type_AndroidWidgetButton, getResources().getDrawable(2130841232));
    }
    if (this.jdField_e_of_type_AndroidWidgetButton != null) {
      ViewUtils.a(this.jdField_e_of_type_AndroidWidgetButton, getResources().getDrawable(2130841237));
    }
    l(false);
    if (this.jdField_c_of_type_AndroidWidgetButton != null) {
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    }
    this.jdField_b_of_type_Boolean = false;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr);
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "replayVideo getVFileAndAFile=" + this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_JavaLangString + "errcode=" + i1 + "hasFrame=" + bool);
    }
    if ((i1 != 0) || (!bool)) {
      x();
    }
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("PTV.NewFlowCameraActivity", 2, "replayVideo isCurrentPreviewState= true......");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.jdField_a_of_type_Boolean = true;
        R();
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoHwcodecSVHwEncoder.f();
        }
        this.aa = true;
        Object localObject = a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494);
        if (localObject != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView((View)localObject);
          this.jdField_m_of_type_Boolean = false;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
        float f1 = ((RMVideoClipSpec)localObject).jdField_f_of_type_Int * 1.0F / ((RMVideoClipSpec)localObject).e;
        if (QLog.isColorLevel()) {
          QLog.i("PTV.NewFlowCameraActivity", 2, "heightRatio=" + f1 + "clipspec.dst_height=" + ((RMVideoClipSpec)localObject).jdField_f_of_type_Int + "clipspec.dst_width=" + ((RMVideoClipSpec)localObject).e);
        }
        c((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
        com.tencent.mobileqq.utils.FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqShortvideoWidgetImageViewVideoPlayer.a(), jdField_B_of_type_JavaLangString);
        if (!c()) {
          FlowCameraMqqAction.a("", "0X8006A13", "" + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("PTV.NewFlowCameraActivity", 2, "replay totaltime = " + (int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
          return;
          FlowCameraMqqAction.a("", "0X8006A18", String.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double));
        }
      }
    }
  }
  
  void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
    this.jdField_e_of_type_AndroidWidgetTextView.clearAnimation();
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(80.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(80.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(50.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(50.0F, getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843537);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    String str;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setStayDisplayOffsetZero(true);
      new ArrayList();
      localObject = PtvTemplateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface).a(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter = new PtvTemplateAdapter(this.jdField_a_of_type_ComTencentMobileqqAppPeakAppInterface, this, (ArrayList)localObject, this.jdField_a_of_type_ComTencentWidgetHorizontalListView, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout);
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter);
      if (QLog.isColorLevel())
      {
        str = PtvTemplateManager.jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("setadapter list size: ");
        if (localObject != null) {
          break label305;
        }
      }
    }
    label305:
    for (int i1 = 0;; i1 = ((ArrayList)localObject).size())
    {
      QLog.d(str, 2, i1);
      return;
    }
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.e("PTV.NewFlowCameraActivity", 2, "cancleProgressDailog");
    }
    try
    {
      if (this.jdField_b_of_type_AndroidAppProgressDialog != null) {
        this.jdField_b_of_type_AndroidAppProgressDialog.cancel();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void u()
  {
    c(false);
  }
  
  public void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "enterVideoMode(), mPtvMode = false");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
    this.jdField_p_of_type_Boolean = true;
  }
  
  public void w()
  {
    int i1 = AIOUtils.a(50.0F, getResources());
    int i2 = AIOUtils.a(80.0F, getResources());
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 1.25F });
    localValueAnimator.setDuration(400L);
    localValueAnimator.addUpdateListener(new paz(this, i1, i2));
    localValueAnimator.addListener(new pba(this));
    localValueAnimator.start();
  }
  
  public void x()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null)
    {
      if (this.jdField_i_of_type_AndroidWidgetButton != null)
      {
        this.jdField_i_of_type_AndroidWidgetButton.clearAnimation();
        this.jdField_i_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_i_of_type_AndroidWidgetButton.setBackgroundResource(this.jdField_r_of_type_Int);
        this.jdField_i_of_type_AndroidWidgetButton.setText("");
      }
      this.jdField_e_of_type_AndroidWidgetTextView.clearAnimation();
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_c_of_type_Boolean) {
        break label490;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(0);
      if (this.jdField_A_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setBackgroundResource(2130841215);
      this.jdField_e_of_type_AndroidWidgetButton.clearAnimation();
      this.jdField_e_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetButton.clearAnimation();
      this.jdField_f_of_type_AndroidWidgetButton.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
      l(false);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
      this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
      if (this.jdField_e_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(80.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(80.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(50.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(50.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.a(50.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.a(50.0F, getResources());
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!this.jdField_d_of_type_Boolean) {
        break label508;
      }
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843537);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(0);
      ((StringBuilder)localObject).append("秒");
      this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
      }
      return;
      label490:
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.clearAnimation();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotImageView.setVisibility(4);
      break;
      label508:
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void y()
  {
    int i3 = this.jdField_s_of_type_Int;
    int i2 = i3 / 1000;
    int i4 = i3 % 1000;
    int i1 = i2;
    if (i4 >= 500) {
      i1 = i2 + 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "[@] adjustRecordTime: time= " + i3 + ",seconds = " + i1 + ", ms=" + i4);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i1);
    localStringBuilder.append("秒");
    this.jdField_f_of_type_AndroidWidgetTextView.setText(localStringBuilder);
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter == null) {}
    for (String str1 = "";; str1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaPtvTemplateAdapter.d)
    {
      String str2 = str1;
      if (str1 == null) {
        str2 = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d("face", 2, "filterFirstFrameOK path=" + str2);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.setVideoFilter(str2);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\richmedia\NewFlowCameraActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */