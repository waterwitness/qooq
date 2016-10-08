package cooperation.qzone.video.interact;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.activity.richmedia.FlowComponentInterface;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoClipSpec;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr.ForceReleaseLockOnPause;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoThumbGenMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMViewSTInterface;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraAbility;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.Callback;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import yqb;
import yqc;
import yqd;
import yqe;
import yqf;
import yqg;
import yqh;
import yqi;
import yqj;
import yqk;
import yql;
import yqm;
import yqn;
import yqo;
import yqp;
import yqq;
import yqr;

public class RecordSVInteractActivity
  extends BaseActivity2
  implements View.OnLongClickListener, FlowComponentInterface, RMViewSTInterface
{
  private static final double jdField_a_of_type_Double = 1.3333333333333333D;
  public static final int e = 2;
  public static final int f = 10004;
  public static final int g = ScreenUtil.a(100.0F);
  public static final int h = ScreenUtil.a(25.0F);
  public static final int i = ScreenUtil.a(70.0F);
  public static final int j = 2000;
  public static final String k = "RecordSVInteractActivity";
  public static final String l = "8";
  public static final String m = "67";
  public static final String n = "68";
  public static final String o = "69";
  public static final String p = "81";
  public static final String q = "maxvideo.aniendx";
  public static final String r = "maxvideo.aniendy";
  public static final String s = "maxvideo.aniendw";
  public static final String t = "maxvideo.report.dc";
  public static final String u = "com.qzone.live.RECORD_ANI_START";
  public static final String v = "com.qzone.live.RECORD_ANI_END";
  public static final String w = "com.qzone.live.RECORD_CLOSE";
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new yqd(this);
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RMVideoStateMgr jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr = RMVideoStateMgr.a();
  CameraExceptionHandler.Callback jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = new yql(this);
  private CameraProxy jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy;
  private CircleProgressBar jdField_a_of_type_CooperationQzoneVideoInteractCircleProgressBar;
  private CircularCameraSurfaceView jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView;
  private ParaMoveImageView jdField_a_of_type_CooperationQzoneVideoInteractParaMoveImageView;
  Runnable jdField_a_of_type_JavaLangRunnable = new yqj(this);
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private volatile boolean f;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static int a(int paramInt, double paramDouble)
  {
    return (int)(paramInt * paramDouble);
  }
  
  private FrameLayout.LayoutParams a(double paramDouble)
  {
    double d1 = paramDouble;
    if (paramDouble <= 0.0D) {
      d1 = 1.3333333333333333D;
    }
    int i1 = a(this.p, d1);
    if (QLog.isColorLevel()) {
      QLog.d("RecordSVInteractActivity", 2, String.format("getParams scale:%f w:%d h:%d", new Object[] { Double.valueOf(d1), Integer.valueOf(this.p), Integer.valueOf(i1) }));
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.p, i1);
    localLayoutParams.gravity = 1;
    return localLayoutParams;
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (paramInt > 0) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new yqn(this, paramInt), paramLong);
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecordSVInteractActivity", 2, "onTouchRecordBtn: on=" + paramBoolean1 + ", up=" + paramBoolean2);
    }
    if (paramBoolean2) {
      if (this.e) {
        if (QLog.isColorLevel()) {
          QLog.d("RecordSVInteractActivity", 2, "onTouchCaptureBtn: 发送已录制的");
        }
      }
    }
    label103:
    while (this.e == paramBoolean1)
    {
      break label103;
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double >= CodecParam.e)) {
        b(this.e);
      }
      for (;;)
      {
        this.e = false;
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("RecordSVInteractActivity", 2, "onTouchCaptureBtn: 删除已录制的");
        break;
        if (QLog.isColorLevel()) {
          QLog.e("RecordSVInteractActivity", 2, "onTouchRecordBtn: rmStateMgr.exitRecordMode() true, 段无效。");
        }
        b(false);
      }
    }
    this.e = paramBoolean1;
    if (this.e)
    {
      this.jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView.setBackgroundResource(2130843537);
      b(2131367221);
      return;
    }
    this.jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView.setBackgroundResource(2130843565);
    b(2131367222);
  }
  
  private void b(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    int i2 = ScreenUtil.a(15.0F);
    int i1;
    if (paramInt > 0) {
      switch (paramInt)
      {
      default: 
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        c(i1);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        return;
        i2 = (this.p - ScreenUtil.a(15.0F)) / 2;
        i1 = 0;
        break;
        int i3 = this.p - ScreenUtil.a(15.0F) - this.jdField_a_of_type_AndroidWidgetTextView.getHeight();
        i2 = i3;
        if (!getResources().getText(2131367222).equals(this.jdField_a_of_type_AndroidWidgetTextView.getText())) {
          break label257;
        }
        i1 = i3 - localLayoutParams.topMargin;
        i2 = i3;
        break;
        i3 = ScreenUtil.a(15.0F);
        i2 = i3;
        if (!getResources().getText(2131367221).equals(this.jdField_a_of_type_AndroidWidgetTextView.getText())) {
          break label257;
        }
        i1 = i3 - localLayoutParams.topMargin;
        i2 = i3;
        break;
        localLayoutParams.topMargin = i2;
        this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      return;
      label257:
      i1 = 0;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    RMVideoClipSpec localRMVideoClipSpec = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    int i1 = (int)(paramInt2 * FlowCameraConstant.a);
    localRMVideoClipSpec.c = paramInt2;
    localRMVideoClipSpec.d = i1;
    localRMVideoClipSpec.e = paramInt1;
    localRMVideoClipSpec.f = paramInt2;
    if (FlowCameraConstant.d == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(5, localRMVideoClipSpec, 0);
    }
    for (;;)
    {
      localRMVideoClipSpec.e = 240;
      localRMVideoClipSpec.f = 240;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(localRMVideoClipSpec, false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(1, localRMVideoClipSpec, 0);
    }
  }
  
  private void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    Bitmap localBitmap = ImageUtil.a(paramIntent.getStringExtra("thumbfile_send_path"), paramIntent.getIntExtra("thumbfile_send_width", -1), paramIntent.getIntExtra("thumbfile_send_height", -1));
    if (localBitmap == null)
    {
      paramIntent.setAction("com.qzone.live.RECORD_ANI_END");
      sendBroadcast(paramIntent);
      return;
    }
    int i1 = this.n / 2;
    int i2 = ParaMoveImageView.a / 2;
    int i3 = this.o;
    int i4 = ScreenUtil.a(85.0F);
    int i5 = ParaMoveImageView.a;
    localBitmap = ImageUtil.a(localBitmap, localBitmap.getWidth(), localBitmap.getWidth(), localBitmap.getHeight());
    if (localBitmap == null)
    {
      paramIntent.setAction("com.qzone.live.RECORD_ANI_END");
      sendBroadcast(paramIntent);
      return;
    }
    this.jdField_a_of_type_CooperationQzoneVideoInteractParaMoveImageView.a(new yqe(this, paramIntent));
    this.jdField_a_of_type_CooperationQzoneVideoInteractParaMoveImageView.a(i1 - i2, i3 - i4 - i5, this.k, this.l, this.m / 2, 300L, localBitmap);
    this.jdField_a_of_type_CooperationQzoneVideoInteractParaMoveImageView.a();
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecordSVInteractActivity", 2, "endRecord(), sendVideo:" + paramBoolean);
    }
    if (this.f)
    {
      QLog.i("RecordSVInteractActivity", 1, "endRecord(), isRecordEnded");
      return;
    }
    this.f = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.i();
    if (paramBoolean)
    {
      getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
      float f1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      FlowCameraMqqAction.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr, f1, false, 0.0D, 0.0D, this, 0);
      return;
    }
    a(this.e, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_Double);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext != null)
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext.getSegmentCount();
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(0, i1, true);
    }
    c(false);
  }
  
  private boolean b()
  {
    if (!"mounted".equals(Environment.getExternalStorageState()))
    {
      QQToast.a(this, 2131372288, 0).a();
      finish();
    }
    for (;;)
    {
      return false;
      Object localObject = getResources().getDisplayMetrics();
      this.n = ((DisplayMetrics)localObject).widthPixels;
      this.o = ((DisplayMetrics)localObject).heightPixels;
      FlowCameraConstant.d = 1;
      if (!CameraAbility.c()) {
        FlowCameraConstant.d = 2;
      }
      FlowCameraConstant.a = 1.0F;
      int i1 = NetworkUtil.a(this);
      int i2 = QzoneConfig.a().a("MiniVideo", "videoSVInteractMaxRecordTime", 6);
      localObject = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("peak");
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a((AppInterface)localObject, 0, null, true, 0, i1, i2);
      RMVideoStateMgr localRMVideoStateMgr = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
      if (localObject != null) {}
      for (localObject = ((AppInterface)localObject).getAccount(); localRMVideoStateMgr.a(this, (String)localObject, this); localObject = "-1")
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy = new CameraProxy(this, this.jdField_a_of_type_AndroidOsHandler);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a(new CameraExceptionHandler(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback));
        return true;
      }
    }
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, paramInt);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(400L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(new yqf(this, paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.d();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoThumbGenMgr.a();
    }
    RMVideoStateMgr localRMVideoStateMgr = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localRMVideoStateMgr.b(paramBoolean);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr$ForceReleaseLockOnPause.b)) {}
      return;
    }
  }
  
  private void q()
  {
    getWindow().setFlags(1024, 1024);
    setContentView(2130904824);
    this.p = ((int)getResources().getDimension(2131494629));
    this.q = ((int)getResources().getDimension(2131494628));
    this.r = ((int)getResources().getDimension(2131494627));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131304369));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)findViewById(2131304370));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131304371));
    this.jdField_a_of_type_CooperationQzoneVideoInteractParaMoveImageView = ((ParaMoveImageView)findViewById(2131304374));
    this.jdField_a_of_type_CooperationQzoneVideoInteractCircleProgressBar = ((CircleProgressBar)findViewById(2131304372));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131304373));
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnLongClickListener(this);
    s();
    a(2, "8", "81", "");
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView != null) {
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView);
    }
    this.jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView = new CircularCameraSurfaceView(this);
    this.jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView.setId(2131296496);
    this.jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext = new PreviewContext(this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy, this.n, this.o);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(this.jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView.jdField_a_of_type_ComTencentMobileqqShortvideoMediadevicePreviewContext);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy.a = 3;
    FrameLayout.LayoutParams localLayoutParams = a(0.0D);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView, 0, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.scrollTo(0, localLayoutParams.width - localLayoutParams.height);
    if (QLog.isColorLevel()) {
      QLog.i("RecordSVInteractActivity", 2, "setupCameraUI setLayoutParams mCameraPreview w=" + localLayoutParams.width + " h=" + localLayoutParams.height);
    }
    if ((CameraAbility.c()) && (CameraAbility.b())) {
      this.jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView.setOnTouchListener(new yqk(this));
    }
  }
  
  private void s()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new yqm(this));
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecordSVInteractActivity", 2, "startRecord()");
    }
    this.f = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.e();
  }
  
  private void u()
  {
    if (FlowCameraConstant.d == 1)
    {
      FlowCameraConstant.d = 2;
      if (CameraAbility.a()) {
        break label25;
      }
    }
    label25:
    while ((!CameraAbility.c()) || (!CameraAbility.b()))
    {
      return;
      FlowCameraConstant.d = 1;
      break;
    }
    a(2131367220, 0L);
    r();
    a(2, "8", "67", "");
  }
  
  private void v()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setLongClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842046);
    this.jdField_a_of_type_CooperationQzoneVideoInteractCircularCameraSurfaceView.setBackgroundResource(2130843537);
    this.jdField_a_of_type_CooperationQzoneVideoInteractCircleProgressBar.setProgress(0);
    this.jdField_a_of_type_CooperationQzoneVideoInteractCircleProgressBar.a();
  }
  
  private void w()
  {
    int i1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    Object localObject = ValueAnimator.ofInt(new int[] { i1 - this.jdField_a_of_type_AndroidWidgetFrameLayout.getHeight(), i1 });
    ((ValueAnimator)localObject).addUpdateListener(new yqg(this));
    ((ValueAnimator)localObject).addListener(new yqh(this));
    ((ValueAnimator)localObject).start();
    localObject = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidWidgetImageView.getHeight() + ScreenUtil.a(15.0F));
    ((TranslateAnimation)localObject).setDuration(200L);
    ((TranslateAnimation)localObject).setFillAfter(true);
    ((TranslateAnimation)localObject).setAnimationListener(new yqi(this));
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject);
  }
  
  public void E_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecordSVInteractActivity", 4, " initUI_InitState ");
    }
  }
  
  public void F_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecordSVInteractActivity", 4, " initUI_RecordState ");
    }
  }
  
  public void G_()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecordSVInteractActivity", 4, " initUI_IdleState ");
    }
  }
  
  public String a()
  {
    return "RecordSVInteractActivity";
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecordSVInteractActivity", 2, "[@] previewSizeAdjustUI:width=" + paramInt1 + " height=" + paramInt2);
    }
    b(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildCount() > 0)
    {
      View localView = this.jdField_a_of_type_AndroidWidgetFrameLayout.getChildAt(0);
      if (QLog.isColorLevel()) {
        QLog.d("RecordSVInteractActivity", 2, "previewSizeAdjustUI(), (" + localView.getWidth() + "," + localView.getHeight() + ")");
      }
      if (localView.getHeight() != a(this.p, paramInt1 / paramInt2))
      {
        FrameLayout.LayoutParams localLayoutParams = a(paramInt1 / paramInt2);
        localView.setLayoutParams(localLayoutParams);
        if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getScrollY() != localLayoutParams.width - localLayoutParams.height) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.scrollTo(0, localLayoutParams.width - localLayoutParams.height);
        }
        if (QLog.isColorLevel()) {
          QLog.i("RecordSVInteractActivity", 2, "previewSizeAdjustUI(), setLayoutParams mCameraPreview w=" + localLayoutParams.width + " h=" + localLayoutParams.height);
        }
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    localBundle.putString("actionType", paramString1);
    localBundle.putString("subActionType", paramString2);
    localBundle.putString("reserves", paramString3);
    this.jdField_a_of_type_JavaUtilArrayList.add(localBundle);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    b(paramInt, paramString, paramBoolean);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (paramInt = 100;; paramInt = paramInt * 100 / CodecParam.d)
    {
      this.jdField_a_of_type_CooperationQzoneVideoInteractCircleProgressBar.setProgress(paramInt);
      return;
    }
  }
  
  public void a(Activity paramActivity) {}
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Activity paramActivity, Intent paramIntent)
  {
    b(paramIntent);
    c(true);
  }
  
  protected void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.k = paramIntent.getIntExtra("maxvideo.aniendx", 0);
    this.l = paramIntent.getIntExtra("maxvideo.aniendy", 0);
    this.m = paramIntent.getIntExtra("maxvideo.aniendw", 0);
  }
  
  public void a(Message paramMessage) {}
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean) {}
  
  void a(boolean paramBoolean, double paramDouble)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { this.r, 0 });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new yqr(this));
    localValueAnimator.addListener(new yqc(this, paramBoolean, paramDouble));
    localValueAnimator.start();
    a(2, "8", "69", "");
  }
  
  public final void b(int paramInt, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new yqo(this, paramString, paramInt));
  }
  
  public int c_()
  {
    return -1;
  }
  
  public void d() {}
  
  protected boolean d()
  {
    if (this.d) {
      return true;
    }
    this.d = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a(4);
    w();
    return true;
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("RecordSVInteractActivity", 4, " initRecordEngineOK ");
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(true);
    }
    boolean bool = CameraCompatibleList.a(CameraCompatibleList.q);
    if ((!this.jdField_a_of_type_Boolean) && (bool)) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 2000L);
    }
  }
  
  public void f() {}
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecordSVInteractActivity", 2, "recordVideoFinish(): mOnRecordBtn = " + this.e);
    }
    if (this.e) {
      b(true);
    }
  }
  
  protected String getModuleId()
  {
    return "peak";
  }
  
  public void h() {}
  
  public void i()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    b(2131367221);
    this.jdField_a_of_type_CooperationQzoneVideoInteractCircleProgressBar.setVisibility(0);
  }
  
  public void j()
  {
    v();
  }
  
  public void k()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void l()
  {
    finish();
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecordSVInteractActivity", 2, " notifyAvcodecOK ");
    }
  }
  
  public void n()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new yqb(this);
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.qzone.live.RECORD_CLOSE");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder("DeviceInfo:");
      paramBundle.append("PRODUCT=").append(Build.PRODUCT).append("|");
      paramBundle.append("MODEL=").append(Build.MODEL).append("|");
      paramBundle.append("BOARD=").append(Build.BOARD).append("|");
      paramBundle.append("BOOTLOADER=").append(Build.BOOTLOADER).append("|");
      paramBundle.append("CPU_ABI=").append(Build.CPU_ABI).append("|");
      paramBundle.append("CPU_ABI2=").append(Build.CPU_ABI2).append("|");
      paramBundle.append("DEVICE=").append(Build.DEVICE).append("|");
      paramBundle.append("DISPLAY=").append(Build.DISPLAY).append("|");
      paramBundle.append("FLNGERPRINT=").append(Build.FINGERPRINT).append("|");
      paramBundle.append("HARDWARE=").append(Build.HARDWARE).append("|");
      paramBundle.append("ID=").append(Build.ID).append("|");
      paramBundle.append("SERIAL=").append(Build.SERIAL).append("|");
      paramBundle.append("MANUFACTURER=").append(Build.MANUFACTURER).append("|");
      paramBundle.append("SDK_INT=").append(Build.VERSION.SDK_INT).append("|");
      QLog.i("RecordSVInteractActivity", 2, paramBundle.toString());
    }
    this.L = true;
    this.M = false;
    a(getIntent());
    q();
    if (!b())
    {
      finish();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraProxy == null)
    {
      QQToast.a(this, " 摄像头初始化异常 ", 0).a();
      finish();
      return;
    }
    r();
    n();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.c();
    o();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == 2131304373)
    {
      paramView = ValueAnimator.ofInt(new int[] { 0, this.r });
      paramView.setDuration(200L);
      paramView.addUpdateListener(new yqp(this));
      paramView.addListener(new yqq(this));
      paramView.start();
      a(2, "8", "68", "");
      return true;
    }
    return false;
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() != 0) {
      return super.onTouchEvent(paramMotionEvent);
    }
    CircleProgressBar localCircleProgressBar = this.jdField_a_of_type_CooperationQzoneVideoInteractCircleProgressBar;
    if (localCircleProgressBar == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    Rect localRect = null;
    int[] arrayOfInt = new int[2];
    localCircleProgressBar.getLocationInWindow(arrayOfInt);
    if (arrayOfInt != null)
    {
      float f1 = arrayOfInt[0];
      float f2 = localCircleProgressBar.getWidth();
      float f3 = arrayOfInt[1];
      float f4 = localCircleProgressBar.getHeight();
      localRect = new Rect((int)f1, (int)f3, (int)(f1 + f2), (int)(f3 + f4));
    }
    if ((localRect != null) && (!localRect.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) {
      d();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void p()
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("maxvideo.report.dc", this.jdField_a_of_type_JavaUtilArrayList);
    if (this.b) {
      setResult(-1, localIntent);
    }
    for (;;)
    {
      finish();
      return;
      setResult(0, localIntent);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\video\interact\RecordSVInteractActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */