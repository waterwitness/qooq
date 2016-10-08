package com.tencent.mobileqq.camera;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.ScaleGestureDetector;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.camera.adapter.CameraWrapper;
import com.tencent.mobileqq.camera.adapter.DeviceInstance;
import com.tencent.mobileqq.camera.report.QCameraRuntimeReport;
import com.tencent.mobileqq.camera.ui.CameraRootView;
import com.tencent.mobileqq.camera.ui.PreviewBackground;
import com.tencent.mobileqq.camera.ui.PreviewSurfaceView;
import com.tencent.mobileqq.camera.ui.QCameraFocusUI;
import com.tencent.mobileqq.camera.ui.QProgressZoomUI;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import qyd;
import qye;
import qyf;
import qyg;
import qyh;
import qyi;
import qyj;
import qyk;
import qyn;
import qyo;
import qyp;
import qyq;
import qyr;
import qys;
import qyt;

public class QQCameraActivity
  extends BaseActivity
  implements SurfaceHolder.Callback, CameraManager.CameraOpenErrorCallback
{
  private static final int A = 3;
  private static final int B = 4;
  private static final int C = 5;
  private static final int D = 6;
  private static final int E = 7;
  private static final int F = 8;
  private static final int G = 9;
  private static final int H = 10;
  private static final int I = 11;
  private static final int J = 12;
  private static final int K = 13;
  private static final int L = 14;
  private static final int M = 15;
  public static final int a = -1;
  private static final String jdField_a_of_type_JavaLangString = "Q.camera.CameraActivity";
  public static final int b = 0;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 3;
  public static final int f = 4;
  public static final int g = 5;
  public static final int h = 6;
  public static final int i = 7;
  private static final int w = 1;
  private static final int x = 2;
  private static final int y = 1;
  private static final int z = 2;
  private int N;
  private int O;
  private int P;
  private int Q;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Camera.Parameters jdField_a_of_type_AndroidHardwareCamera$Parameters;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private CameraHolder jdField_a_of_type_ComTencentMobileqqCameraCameraHolder;
  private CameraManager.CameraPreviewDataCallback jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraPreviewDataCallback;
  private CameraManager.CameraProxy jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
  private QCameraRuntimeReport jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport;
  private CameraRootView jdField_a_of_type_ComTencentMobileqqCameraUiCameraRootView;
  private PreviewBackground jdField_a_of_type_ComTencentMobileqqCameraUiPreviewBackground;
  private PreviewSurfaceView jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView;
  private QCameraFocusUI jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI;
  private QProgressZoomUI jdField_a_of_type_ComTencentMobileqqCameraUiQProgressZoomUI;
  private List jdField_a_of_type_JavaUtilList;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private final qyi jdField_a_of_type_Qyi;
  private final qyn jdField_a_of_type_Qyn;
  private final qyq jdField_a_of_type_Qyq;
  private final qyr jdField_a_of_type_Qyr;
  private final qyt jdField_a_of_type_Qyt;
  private boolean jdField_a_of_type_Boolean;
  private final Rect jdField_b_of_type_AndroidGraphicsRect;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private CameraManager.CameraPreviewDataCallback jdField_b_of_type_ComTencentMobileqqCameraCameraManager$CameraPreviewDataCallback;
  private String jdField_b_of_type_JavaLangString;
  private List jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private Animation jdField_c_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private Animation jdField_d_of_type_AndroidViewAnimationAnimation;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  
  public QQCameraActivity()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
    this.o = -1;
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraPreviewDataCallback = new qyj(this, null);
    this.jdField_a_of_type_Qyi = new qyi(this, null);
    this.jdField_a_of_type_Qyt = new qyt(this, null);
    this.jdField_a_of_type_Qyq = new qyq(this, null);
    this.jdField_a_of_type_Qyr = new qyr(this, null);
    this.jdField_a_of_type_Qyn = new qyn(this);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new qyf(this);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new qyg(this);
  }
  
  private int a(Context paramContext)
  {
    if (this.q == 0)
    {
      this.q = ((int)paramContext.getResources().getDimension(2131493723));
      return this.q;
    }
    return this.q;
  }
  
  private void a(int paramInt1, int paramInt2, float paramFloat, Rect paramRect)
  {
    int i1 = (int)(a(this) * paramFloat);
    paramInt1 = CameraUtils.a(paramInt1 - i1 / 2, this.jdField_b_of_type_AndroidGraphicsRect.left, this.jdField_b_of_type_AndroidGraphicsRect.right - i1);
    paramInt2 = CameraUtils.a(paramInt2 - i1 / 2, this.jdField_b_of_type_AndroidGraphicsRect.top, this.jdField_b_of_type_AndroidGraphicsRect.bottom - i1);
    RectF localRectF = new RectF(paramInt1, paramInt2, paramInt1 + i1, i1 + paramInt2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF);
    CameraUtils.a(localRectF, paramRect);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[manualFocus] + BEGIN");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraActivity", 2, "[manualFocus] return because focusing");
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy != null) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0))
      {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(10, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()).sendToTarget();
        this.jdField_j_of_type_Boolean = true;
        this.s = ((int)paramMotionEvent.getRawX());
        this.t = ((int)paramMotionEvent.getRawY());
        d();
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.camera.CameraActivity", 2, "[manualFocus] + END");
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[doSwitchFrontBackCamera] + ENTER " + paramBoolean);
    }
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(this.jdField_j_of_type_Int, localCameraInfo);
    int i3 = localCameraInfo.facing;
    int i2 = this.jdField_j_of_type_Int;
    int i1 = Camera.getNumberOfCameras() - 1;
    if (i1 >= 0)
    {
      Camera.getCameraInfo(i1, localCameraInfo);
      if ((i1 == this.jdField_j_of_type_Int) || (localCameraInfo.facing == i3)) {}
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraActivity", 2, "[doSwitchFrontBackCamera] switch from camerId:" + this.jdField_j_of_type_Int + " to=" + i1);
      }
      if (i1 == this.jdField_j_of_type_Int)
      {
        QLog.e("Q.camera.CameraActivity", 2, "[doSwitchFrontBackCamera] not founded any camera.");
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        return;
        i1 -= 1;
        break;
      }
      this.jdField_j_of_type_Int = i1;
      if (localCameraInfo.facing == 1) {}
      for (this.h = true;; this.h = false)
      {
        if (paramBoolean)
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.camera.CameraActivity", 2, "[doSwitchFrontBackCamera] + END");
        return;
      }
      i1 = i2;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[playFocusAnimationA] + ENTER");
    }
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    b(paramInt1, paramInt2, 1.0F, this.jdField_a_of_type_AndroidGraphicsRect);
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[playFocusAnimationA] to:" + this.jdField_a_of_type_AndroidGraphicsRect);
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = new AnimationSet(true);
      if (this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI != null) {
        break label324;
      }
      this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI = new QCameraFocusUI(this);
      this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI.setTag(Integer.valueOf(39321));
      this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI.setParameter(this.jdField_a_of_type_AndroidGraphicsRect, 100);
      this.jdField_a_of_type_ComTencentMobileqqCameraUiCameraRootView.addView(this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI, new FrameLayout.LayoutParams(-2, -2));
    }
    for (;;)
    {
      if (this.jdField_c_of_type_AndroidViewAnimationAnimation == null) {
        this.jdField_c_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.5F, 1.0F);
      }
      this.jdField_c_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_c_of_type_AndroidViewAnimationAnimation);
      if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null) {
        this.jdField_b_of_type_AndroidViewAnimationAnimation = new ScaleAnimation(1.3F, 1.0F, 1.3F, 1.0F, 1, 0.5F, 1, 0.5F);
      }
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.addAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(500L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setFillAfter(true);
      this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraActivity", 2, "[playFocusAnimationA] + END");
      }
      return;
      if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet.hasEnded()) {
        break;
      }
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
      break;
      label324:
      if (this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI.clearAnimation();
        if (this.jdField_a_of_type_ComTencentMobileqqCameraUiCameraRootView.findViewWithTag(Integer.valueOf(39321)) == this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI) {
          this.jdField_a_of_type_ComTencentMobileqqCameraUiCameraRootView.removeView(this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI);
        }
        this.jdField_a_of_type_ComTencentMobileqqCameraUiCameraRootView.addView(this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI, new FrameLayout.LayoutParams(-2, -2));
        this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI.setParameter(this.jdField_a_of_type_AndroidGraphicsRect, 100);
        this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI.setVisibility(0);
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, float paramFloat, Rect paramRect)
  {
    int i1 = (int)(a(this) * paramFloat);
    CameraUtils.a(this);
    int i4 = this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.getLeft();
    int i5 = this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.getRight();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.getTop();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.getBottom();
    paramInt1 = CameraUtils.a(paramInt1 - i1 / 2, i4, i5 - i1);
    paramInt2 = CameraUtils.a(paramInt2 - i1 / 2, i2, i3 - i1);
    paramRect.left = paramInt1;
    paramRect.top = paramInt2;
    paramRect.right = (paramInt1 + i1);
    paramRect.bottom = (i1 + paramInt2);
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.d(paramInt);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(1);
      this.jdField_a_of_type_JavaUtilList.add(new Camera.Area(new Rect(), 1));
    }
    a(paramInt1, paramInt2, 1.0F, ((Camera.Area)this.jdField_a_of_type_JavaUtilList.get(0)).rect);
  }
  
  private void d(int paramInt)
  {
    if (paramInt == -1) {
      paramInt = 0;
    }
    label47:
    label87:
    label226:
    label262:
    label298:
    label332:
    for (;;)
    {
      if (this.O == 0)
      {
        ReportController.b(null, "dc00898", "", "", "0X8007080", "0X8007080", 0, paramInt, "", "", "", "");
        if (!this.i) {
          break label226;
        }
        ReportController.b(null, "dc00898", "", "", "0X8007081", "0X8007081", 0, paramInt, "", "", "", "");
        if (!this.jdField_j_of_type_Boolean) {
          break label262;
        }
        ReportController.b(null, "dc00898", "", "", "0X8007083", "0X8007083", 0, paramInt, "", "", "", "");
      }
      for (;;)
      {
        this.jdField_j_of_type_Boolean = false;
        if (this.u <= 0) {
          break label298;
        }
        ReportController.b(null, "dc00898", "", "", "0X8007085", "0X8007085", 0, paramInt, "", "", "", "");
        return;
        if (paramInt != 0) {
          break label332;
        }
        paramInt = 1;
        break;
        if (this.O != 1) {
          break label47;
        }
        ReportController.b(null, "dc00898", "", "", "0X800707F", "0X800707F", 0, paramInt, "", "", "", "");
        break label47;
        ReportController.b(null, "dc00898", "", "", "0X8007082", "0X8007082", 0, paramInt, "", "", "", "");
        break label87;
        ReportController.b(null, "dc00898", "", "", "0X8007084", "0X8007084", 0, paramInt, "", "", "", "");
      }
      ReportController.b(null, "dc00898", "", "", "0X8007086", "0X8007086", 0, paramInt, "", "", "", "");
      return;
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_JavaUtilList == null)
    {
      this.jdField_b_of_type_JavaUtilList = new ArrayList(1);
      this.jdField_b_of_type_JavaUtilList.add(new Camera.Area(new Rect(), 1));
    }
    a(paramInt1, paramInt2, 1.5F, ((Camera.Area)this.jdField_b_of_type_JavaUtilList.get(0)).rect);
  }
  
  private boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[autoFocus] + ENTER cameraState=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + " uiEnabled=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy != null) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraActivity", 2, "[autoFocus] doing...");
      }
      c(2);
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.x();
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setFocusMode("auto");
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
      e(this.s, this.t);
      f(this.s, this.t);
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Qyi);
    }
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraActivity", 2, "[autoFocus] + END");
      }
      return bool;
    }
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      c(paramInt1, paramInt2);
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setFocusAreas(this.jdField_a_of_type_JavaUtilList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraActivity", 2, "[setFocusAreaIfSupported] focusRect: " + ((Camera.Area)this.jdField_a_of_type_JavaUtilList.get(0)).rect);
      }
    }
  }
  
  private boolean e()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[initCamera] + BEGIN");
    }
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.l();
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder = CameraHolder.a();
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = CameraUtils.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder, this, this.jdField_j_of_type_Int, this.jdField_a_of_type_AndroidOsHandler, this);
    QLog.i("Q.camera.CameraActivity", 1, "[initCamera] open camera cameraId=" + this.jdField_j_of_type_Int + " " + this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy);
    if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy == null)
    {
      QLog.w("Q.camera.CameraActivity", 1, "[initCamera] Failed to open camera:" + this.jdField_j_of_type_Int);
      bool = false;
    }
    do
    {
      return bool;
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.m();
      PreferenceManager.getDefaultSharedPreferences(this).edit().putInt("qcamera_latest_choice", this.jdField_j_of_type_Int).commit();
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters = this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a();
      d();
      b();
      b();
      a();
      Camera.Size localSize = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getPreviewSize();
      this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.setLayoutParams(new FrameLayout.LayoutParams(localSize.width, localSize.height));
    } while (!QLog.isColorLevel());
    QLog.d("Q.camera.CameraActivity", 2, "[initCamera] + END");
    return true;
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(11);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI != null) {
      g();
    }
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    if (this.jdField_d_of_type_Boolean)
    {
      d(paramInt1, paramInt2);
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setMeteringAreas(this.jdField_b_of_type_JavaUtilList);
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraActivity", 2, "[setMeteringAreaSupported] meteringRect: " + ((Camera.Area)this.jdField_b_of_type_JavaUtilList.get(0)).rect);
      }
    }
  }
  
  private boolean f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[startPreview] + BEGIN");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy == null)
    {
      QLog.w("Q.camera.CameraActivity", 2, "[startPreview] mPaused || mCameraDevice == null");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.n();
    q();
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.b(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraPreviewDataCallback);
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidViewSurfaceHolder);
    c(3);
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.d();
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.o();
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[startPreview] + END");
    }
    return true;
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[clearFocusUI] + ENTER");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqCameraUiCameraRootView.findViewWithTag(Integer.valueOf(39321)) == this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI) {
        this.jdField_a_of_type_ComTencentMobileqqCameraUiCameraRootView.removeView(this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[clearFocusUI] + END");
    }
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[playFocusAnimationB] + ENTER");
    }
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.cancel();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI.clearAnimation();
      if (this.jdField_d_of_type_AndroidViewAnimationAnimation == null) {
        this.jdField_d_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.5F);
      }
      this.jdField_d_of_type_AndroidViewAnimationAnimation.setDuration(1000L);
      this.jdField_d_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      this.jdField_a_of_type_ComTencentMobileqqCameraUiQCameraFocusUI.startAnimation(this.jdField_d_of_type_AndroidViewAnimationAnimation);
    } while (!QLog.isColorLevel());
    QLog.d("Q.camera.CameraActivity", 2, "[playFocusAnimationB] + END");
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[showBaseUI] + ENTER");
    }
    m();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqCameraUiQProgressZoomUI.setVisibility(8);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[showBaseUI] + END");
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[hiddenBaseUI] + ENTER");
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqCameraUiQProgressZoomUI.setVisibility(8);
    f();
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[hiddenBaseUI] + END");
    }
  }
  
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[doSwitchFlash] + ENTER current flash mode: " + this.jdField_b_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy == null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a().a(Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a()), this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a().a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a(), this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
    if ((this.jdField_b_of_type_JavaLangString == null) || (localObject == null))
    {
      this.jdField_b_of_type_JavaLangString = null;
      label117:
      localObject = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getFlashMode();
      if ((this.jdField_b_of_type_JavaLangString != null) && (!this.jdField_b_of_type_JavaLangString.equals(localObject)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
      }
      this.jdField_b_of_type_JavaLangString = ((String)localObject);
      r();
      if (!this.i) {
        break label364;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837626);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.camera.CameraActivity", 2, "[doSwitchFlash] + END switch to flash mode: " + this.jdField_b_of_type_JavaLangString);
      return;
      if ("off".equals(this.jdField_b_of_type_JavaLangString))
      {
        if (CameraUtils.a("on", (List)localObject))
        {
          this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setFlashMode("on");
          break label117;
        }
        if (!CameraUtils.a("auto", (List)localObject)) {
          break label117;
        }
        this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setFlashMode("auto");
        break label117;
      }
      if ("on".equals(this.jdField_b_of_type_JavaLangString))
      {
        if (!CameraUtils.a("off", (List)localObject)) {
          break label117;
        }
        this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setFlashMode("off");
        break label117;
      }
      if ((!"auto".equals(this.jdField_b_of_type_JavaLangString)) || (!CameraUtils.a("off", (List)localObject))) {
        break label117;
      }
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setFlashMode("off");
      break label117;
      label364:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837625);
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.t();
    if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy != null)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqCameraCameraManager$CameraPreviewDataCallback == null) {
        this.jdField_b_of_type_ComTencentMobileqqCameraCameraManager$CameraPreviewDataCallback = new qyk(this, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidOsHandler, this.jdField_b_of_type_ComTencentMobileqqCameraCameraManager$CameraPreviewDataCallback);
    }
  }
  
  private void m()
  {
    if (this.O == 1)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void n()
  {
    if ((this.jdField_b_of_type_AndroidGraphicsRect.width() != 0) && (this.jdField_b_of_type_AndroidGraphicsRect.height() != 0))
    {
      Matrix localMatrix = new Matrix();
      CameraUtils.a(localMatrix, this.h, this.m, a());
      localMatrix.invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
    }
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[cancel] + ENTER");
    }
    j();
    e();
    t();
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.A();
    finish();
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[cancel] + END");
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup2 = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup2.getChildAt(0);
      ViewGroup localViewGroup1 = localViewGroup2;
      if (localView != null)
      {
        localViewGroup1 = localViewGroup2;
        if ((localView instanceof ViewGroup)) {
          localViewGroup1 = (ViewGroup)localView;
        }
      }
      if ((localViewGroup1 instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localViewGroup1);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
    }
  }
  
  private void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[checkAndSetPreviewOrientation] + BEGIN");
    }
    int i1 = CameraUtils.a(this);
    this.m = CameraUtils.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a(), i1, this.jdField_j_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.m);
    if (QLog.isColorLevel())
    {
      QLog.i("Q.camera.CameraActivity", 2, "[checkAndSetPreviewOrientation] display nature rotation=" + i1 + " setDisplayOrientation=" + this.m);
      QLog.d("Q.camera.CameraActivity", 2, "[checkAndSetPreviewOrientation] + END");
    }
  }
  
  private void r()
  {
    String str = "";
    if (("auto".equals(this.jdField_b_of_type_JavaLangString)) || ("on".equals(this.jdField_b_of_type_JavaLangString))) {
      str = "开启";
    }
    for (this.i = true;; this.i = false)
    {
      do
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(String.format(getResources().getString(2131372698), new Object[] { str }));
        return;
      } while ((!"off".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString != null));
      str = "关闭";
    }
  }
  
  private void s()
  {
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.b() == 0) {
      str = "后";
    }
    for (this.O = 0;; this.O = 1)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(String.format(getResources().getString(2131372699), new Object[] { str }));
      return;
      str = "前";
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[closeCamera] + BEGIN");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.r();
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(null);
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(null);
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.b(null, null);
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(null, null);
      if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a();
        this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy = null;
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.s();
      c(6);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[closeCamera] + END");
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get();
  }
  
  public Rect a()
  {
    return new Rect(this.jdField_b_of_type_AndroidGraphicsRect);
  }
  
  public void a()
  {
    QLog.d("Q.camera.CameraActivity", 2, "[cancelAutoFocus] + ENTER");
    if ((this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy != null) && (a() == 2))
    {
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.f();
      c(0);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[cancelAutoFocus] + END");
    }
  }
  
  public void a(int paramInt)
  {
    QLog.w("Q.camera.CameraActivity", 1, "[onCameraDisabled] + ENTER cameraId=" + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.a(String.valueOf(paramInt));
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230, null, getString(2131372701), new qyd(this), null);
    if (localQQCustomDialog != null) {
      localQQCustomDialog.show();
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.camera.CameraActivity", 2, "[onCameraDisabled] + END");
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_b_of_type_AndroidGraphicsRect.width() != paramInt1) || (this.jdField_b_of_type_AndroidGraphicsRect.height() != paramInt2)) {
      a(new Rect(0, 0, paramInt1, paramInt2));
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqCameraUiCameraRootView = ((CameraRootView)paramActivity.findViewById(2131300765));
    this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewBackground = ((PreviewBackground)paramActivity.findViewById(2131300767));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramActivity.findViewById(2131300770));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramActivity.findViewById(2131300769));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramActivity.findViewById(2131300771));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramActivity.findViewById(2131300768));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramActivity.findViewById(2131300772));
    this.jdField_a_of_type_ComTencentMobileqqCameraUiQProgressZoomUI = ((QProgressZoomUI)paramActivity.findViewById(2131300773));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(getResources().getString(2131372696));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getResources().getString(2131372697));
    this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView = ((PreviewSurfaceView)paramActivity.findViewById(2131300766));
    this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.setFocusable(true);
    this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.setFocusableInTouchMode(true);
    this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.setClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    this.jdField_a_of_type_AndroidViewSurfaceHolder = this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.getHolder();
    this.jdField_a_of_type_AndroidViewSurfaceHolder.setType(3);
    this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(this);
  }
  
  public void a(Rect paramRect)
  {
    if (!this.jdField_b_of_type_AndroidGraphicsRect.equals(paramRect))
    {
      this.jdField_b_of_type_AndroidGraphicsRect.set(paramRect);
      n();
    }
  }
  
  public void a(CameraManager paramCameraManager)
  {
    if (QLog.isColorLevel()) {
      QLog.w("Q.camera.CameraActivity", 2, "[onReconnectionFailure] + ENTER");
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.camera.CameraActivity", 2, "[onReconnectionFailure] + END");
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[updateCameraParametersFocus] + BEGIN");
    }
    this.s = ((this.jdField_b_of_type_AndroidGraphicsRect.right - this.jdField_b_of_type_AndroidGraphicsRect.left) / 2);
    this.t = ((this.jdField_b_of_type_AndroidGraphicsRect.bottom - this.jdField_b_of_type_AndroidGraphicsRect.top) / 2);
    QLog.d("Q.camera.CameraActivity", 1, "[updateCameraParametersFocus] initialize focus area=(" + this.s + "," + this.t + ")");
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[updateCameraParametersFocus] + END");
    }
    return true;
  }
  
  public int b()
  {
    int i3 = PreferenceManager.getDefaultSharedPreferences(this).getInt("qcamera_latest_choice", 0);
    int i2 = -1;
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i1 = Camera.getNumberOfCameras() - 1;
    boolean bool;
    if (i1 >= 0)
    {
      Camera.getCameraInfo(i1, localCameraInfo);
      if (i3 == i1)
      {
        i1 = localCameraInfo.facing;
        bool = true;
      }
    }
    for (;;)
    {
      this.h = false;
      if (bool) {
        if (i1 != 1) {
          break label151;
        }
      }
      label151:
      for (this.h = true;; this.h = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.camera.CameraActivity", 2, "[getInitCameraId] cameraId=" + i3 + " foundCamera=" + bool + " facing=" + i1 + " mirror=" + this.h);
        }
        return i3;
        i1 -= 1;
        break;
      }
      bool = false;
      i1 = i2;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[updateCameraParametersInitialize] + BEGIN");
    }
    int[] arrayOfInt = CameraUtils.a(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
    if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
    }
    this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[updateCameraParametersInitialize] + END");
    }
  }
  
  public void b(int paramInt)
  {
    QLog.w("Q.camera.CameraActivity", 1, "[onDeviceOpenFailure] + ENTER cameraId=" + paramInt);
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.b(String.valueOf(paramInt));
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230, null, getString(2131372700), new qye(this), null);
    if (localQQCustomDialog != null) {
      localQQCustomDialog.show();
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.camera.CameraActivity", 2, "[onDeviceOpenFailure] + END");
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[updateCameraParametersPreference] + ENTER");
    }
    Object localObject1 = getResources().getDisplayMetrics();
    int i1 = ((DisplayMetrics)localObject1).widthPixels;
    int i2 = ((DisplayMetrics)localObject1).heightPixels;
    QLog.d("Q.camera.CameraActivity", 1, "screen size: " + i1 + "*" + i2);
    QLog.d("Q.camera.CameraActivity", 1, "surface size: " + this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.getWidth() + "*" + this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.getHeight());
    Camera.Size localSize;
    if (QLog.isColorLevel())
    {
      localObject2 = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPreviewSizes();
      if (localObject2 != null)
      {
        localObject1 = new StringBuilder("Supported preview size: ");
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localSize = (Camera.Size)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(localSize.width + "*" + localSize.height + " ");
        }
        QLog.d("Q.camera.CameraActivity", 4, ((StringBuilder)localObject1).toString());
      }
    }
    localObject1 = CameraUtils.b(this, this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy);
    Object localObject2 = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getPreviewSize();
    if (localObject1 != null)
    {
      if ((localObject2 != null) && (!((Camera.Size)localObject1).equals(localObject2))) {
        this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setPreviewSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
      }
      a(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
      QLog.d("Q.camera.CameraActivity", 1, "request preview size: " + ((Camera.Size)localObject1).width + "*" + ((Camera.Size)localObject1).height);
    }
    while (QLog.isColorLevel())
    {
      localObject2 = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedPictureSizes();
      if (localObject2 != null)
      {
        localObject1 = new StringBuilder("Supported picture size: ");
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localSize = (Camera.Size)((Iterator)localObject2).next();
            ((StringBuilder)localObject1).append(localSize.width + "*" + localSize.height + " ");
            continue;
            QLog.w("Q.camera.CameraActivity", 2, "Could not match fixed preview size!");
            break;
          }
        }
        QLog.d("Q.camera.CameraActivity", 4, ((StringBuilder)localObject1).toString());
      }
    }
    localObject1 = CameraUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy);
    localObject2 = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getPictureSize();
    if (localObject1 != null)
    {
      if ((localObject2 != null) && (!((Camera.Size)localObject2).equals(localObject1))) {
        this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setPictureSize(((Camera.Size)localObject1).width, ((Camera.Size)localObject1).height);
      }
      QLog.d("Q.camera.CameraActivity", 1, "request picture size: " + ((Camera.Size)localObject1).width + "*" + ((Camera.Size)localObject1).height);
    }
    for (;;)
    {
      i1 = CameraUtils.a(this, this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy);
      if (i1 != 256) {
        QLog.w("Q.camera.CameraActivity", 2, "Could not supported JPEG format!");
      }
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setPictureFormat(i1);
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters = this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraActivity", 2, "[updateCameraParametersPreference] + END");
      }
      return true;
      QLog.w("Q.camera.CameraActivity", 1, "Could not match fixed picture size!");
    }
  }
  
  public void c()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.jdField_d_of_type_JavaLangString = localIntent.getStringExtra("qcamera_photo_filepath");
      this.N = localIntent.getIntExtra("android.intent.extra.videoQuality", 100);
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraActivity", 2, "[parseIntent] qcamera_photo_filepath=" + this.jdField_d_of_type_JavaLangString + " quality=" + this.N);
      }
    }
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.camera.CameraActivity", 2, "[capture] + BEGIN cameraState=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        }
        CameraManager.CameraProxy localCameraProxy = this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy;
        if (localCameraProxy == null)
        {
          bool1 = bool2;
          return bool1;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0)
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("Q.camera.CameraActivity", 2, "[capture] camera state is not IDLE " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          bool1 = bool2;
          continue;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(7);
      }
      finally {}
      f();
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.y();
      this.l = CameraUtils.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder, this.jdField_j_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a().d())
      {
        this.n = CameraUtils.a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder, this.jdField_j_of_type_Int, this.o);
        QLog.i("Q.camera.CameraActivity", 1, "[capture] setRotation natureOrientation=" + this.o + " cameraOrientation=" + this.l + " jpegRotation=" + this.n);
        this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setRotation(this.n);
        this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
      }
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.b(this.h);
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.a(this.o);
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.b(this.l);
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.c(this.n);
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.e(1);
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidOsHandler, null, this.jdField_a_of_type_Qyr, this.jdField_a_of_type_Qyq, this.jdField_a_of_type_Qyn);
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraActivity", 2, "[capture] + END");
      }
      boolean bool1 = true;
    }
  }
  
  void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[initCameraCapabilities] + ENTER");
    }
    if (this.jdField_a_of_type_AndroidHardwareCamera$Parameters == null) {
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters = this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a();
    }
    this.jdField_c_of_type_Boolean = CameraUtils.a(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
    this.jdField_d_of_type_Boolean = CameraUtils.b(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
    QLog.i("Q.camera.CameraActivity", 1, "[initCameraCapabilities] FocusAreaSupported=" + this.jdField_c_of_type_Boolean);
    QLog.i("Q.camera.CameraActivity", 1, "[initCameraCapabilities] MeteringAreaSupported=" + this.jdField_d_of_type_Boolean);
    List localList = this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a().a(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
    StringBuilder localStringBuilder;
    int i1;
    if (localList != null)
    {
      localStringBuilder = new StringBuilder("Supported FocusModes: ");
      i1 = localList.size() - 1;
      while (i1 >= 0)
      {
        localStringBuilder.append((String)localList.get(i1));
        localStringBuilder.append(" | ");
        i1 -= 1;
      }
      QLog.i("Q.camera.CameraActivity", 1, "[initCameraCapabilities] " + localStringBuilder.toString());
    }
    if ((CameraUtils.a("auto", localList)) || (CameraUtils.a("macro", localList)))
    {
      this.jdField_b_of_type_Boolean = true;
      QLog.i("Q.camera.CameraActivity", 1, "[initCameraCapabilities] Auto focus: " + this.jdField_b_of_type_Boolean + ", Current FocusMode: " + this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getFocusMode());
      QLog.i("Q.camera.CameraActivity", 1, "[initCameraCapabilities] supported Scene modes: " + this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedSceneModes());
      this.jdField_c_of_type_JavaLangString = "auto";
      if (!CameraUtils.a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSupportedSceneModes())) {
        break label488;
      }
      if (!this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSceneMode().equals(this.jdField_c_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setSceneMode(this.jdField_c_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
        this.jdField_a_of_type_AndroidHardwareCamera$Parameters = this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a();
      }
    }
    for (;;)
    {
      localList = this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a().a(Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a()), this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
      if (localList == null) {
        break label805;
      }
      localStringBuilder = new StringBuilder("Supported FlashModes: ");
      i1 = localList.size() - 1;
      while (i1 >= 0)
      {
        localStringBuilder.append((String)localList.get(i1));
        localStringBuilder.append(" | ");
        i1 -= 1;
      }
      this.jdField_b_of_type_Boolean = false;
      break;
      label488:
      this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getSceneMode();
      if (this.jdField_c_of_type_JavaLangString == null) {
        this.jdField_c_of_type_JavaLangString = "auto";
      }
    }
    QLog.i("Q.camera.CameraActivity", 1, "[initCameraCapabilities] " + localStringBuilder.toString());
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130837625);
    if ("auto".equals(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = "off";
      if (!CameraUtils.b(this.jdField_b_of_type_JavaLangString, localList)) {
        break label817;
      }
      this.jdField_a_of_type_AndroidHardwareCamera$Parameters.setFlashMode(this.jdField_b_of_type_JavaLangString);
      this.e = true;
    }
    for (;;)
    {
      QLog.i("Q.camera.CameraActivity", 1, "[initCameraCapabilities] Current FlashMode: " + this.jdField_b_of_type_JavaLangString + " supportedFlash=" + this.e);
      this.f = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.isZoomSupported();
      this.u = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getZoom();
      this.v = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getMaxZoom();
      this.g = this.jdField_a_of_type_AndroidHardwareCamera$Parameters.isSmoothZoomSupported();
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraActivity", 2, "[initCameraCapabilities] ZoomSupported=" + this.f + " ZoomVal=(0, " + this.v + ") SmoothZoomSupported=" + this.g);
      }
      this.jdField_a_of_type_ComTencentMobileqqCameraUiQProgressZoomUI.setMax(this.v);
      this.jdField_a_of_type_ComTencentMobileqqCameraUiQProgressZoomUI.setProgress(0);
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.a(this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
      r();
      s();
      if (QLog.isColorLevel()) {
        QLog.i("Q.camera.CameraActivity", 2, "[initCameraCapabilities] + END");
      }
      return;
      label805:
      QLog.i("Q.camera.CameraActivity", 1, "[initCameraCapabilities] supportedFlashModes is null");
      break;
      label817:
      this.e = false;
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a().a(this.jdField_a_of_type_ComTencentMobileqqCameraCameraHolder.a(), this.jdField_a_of_type_AndroidHardwareCamera$Parameters);
      if (this.jdField_b_of_type_JavaLangString == null) {
        QLog.i("Q.camera.CameraActivity", 1, "[initCameraCapabilities] unsupported flash mode, current mode: " + this.jdField_a_of_type_AndroidHardwareCamera$Parameters.getFlashMode());
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[doOnBackPressed] + BEGIN");
    }
    super.doOnBackPressed();
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.e(3);
    ReportController.b(null, "dc00898", "", "", "0X8007122", "0X8007122", 0, 0, "", "", "", "");
    o();
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[doOnBackPressed] + END");
    }
  }
  
  public void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    super.doOnConfigurationChanged(paramConfiguration);
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[onConfigurationChanged] + BEGIN orientation=" + paramConfiguration.orientation);
    }
    if (paramConfiguration.orientation == 2) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraActivity", 2, "[onConfigurationChanged] + END");
      }
      return;
      if (paramConfiguration.orientation != 1) {}
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[onCreate] + BEGIN");
    }
    this.mNeedStatusTrans = false;
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    setTitle("");
    this.jdField_a_of_type_AndroidContentContext = this;
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport = new QCameraRuntimeReport(DeviceInstance.a().b());
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.b();
    setContentView(2130903944);
    this.jdField_a_of_type_AndroidOsHandler = new qyo(this, getMainLooper());
    this.jdField_a_of_type_AndroidViewOrientationEventListener = new qyp(this, BaseApplicationImpl.getContext());
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(BaseApplicationImpl.getContext(), new qys(this, null));
    this.h = false;
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
    this.jdField_j_of_type_Int = b();
    c();
    a(this);
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.c();
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[onCreate] + END");
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[doOnDestroy] + BEGIN");
    }
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.j();
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.k();
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[doOnDestroy] + END");
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (((paramInt == 84) || (paramInt == 82)) && (paramKeyEvent.isLongPress())) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[doOnPause] + BEGIN");
    }
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.h();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    super.doOnPause();
    this.jdField_a_of_type_AndroidViewOrientationEventListener.disable();
    f();
    this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewBackground.jdField_a_of_type_AndroidGraphicsBitmap = null;
    CameraUtils.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.i();
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[doOnPause] + END");
    }
  }
  
  protected void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[doOnResume] + BEGIN");
    }
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.d();
    this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.f();
    super.doOnResume();
    if (!CameraUtils.c())
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(BaseApplicationImpl.a(), 230, getString(2131367661), getString(2131367663), new qyh(this), null);
      QLog.w("Q.camera.CameraActivity", 1, "[doOnResume] camera id=" + this.jdField_j_of_type_Int + " does not permission");
      localQQCustomDialog.show();
    }
    do
    {
      return;
      p();
      this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
      this.jdField_a_of_type_ComTencentMobileqqCameraUiPreviewSurfaceView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.e();
    } while (!QLog.isColorLevel());
    QLog.d("Q.camera.CameraActivity", 2, "[doOnResume] + END");
  }
  
  protected void doOnStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[onStart] + BEGIN");
    }
    super.doOnStart();
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[onStart] + END");
    }
  }
  
  protected void doOnStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[doOnStop] + BEGIN");
    }
    super.doOnStop();
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[doOnStop] + END");
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[stopPreview] + BEGIN");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.camera.CameraActivity", 2, "do stopPreview");
      }
      c(1);
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.p();
      this.jdField_a_of_type_ComTencentMobileqqCameraCameraManager$CameraProxy.e();
      this.jdField_a_of_type_ComTencentMobileqqCameraReportQCameraRuntimeReport.q();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.camera.CameraActivity", 2, "[stopPreview] + END");
    }
  }
  
  protected boolean onBackEvent()
  {
    return true;
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[surfaceChanged] + BEGIN " + paramSurfaceHolder + " " + paramInt2 + " " + paramInt3);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[surfaceChanged] + END");
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[surfaceCreated] + BEGIN");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[surfaceCreated] + END");
    }
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[surfaceDestroyed] + BEGIN");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(7);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.CameraActivity", 2, "[surfaceDestroyed] + END");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\camera\QQCameraActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */