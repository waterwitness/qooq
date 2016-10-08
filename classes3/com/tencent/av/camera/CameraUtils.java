package com.tencent.av.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import ggn;
import ggo;
import ggp;
import ggq;
import ggr;
import ggs;
import ggt;
import ggu;
import java.util.Observer;

public class CameraUtils
{
  static volatile CameraUtils jdField_a_of_type_ComTencentAvCameraCameraUtils;
  static final String jdField_a_of_type_JavaLangString = "CameraUtils";
  public static final int b = 1;
  static final String b = "cameracfg";
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  public GLSurfaceView a;
  SurfaceHolder.Callback jdField_a_of_type_AndroidViewSurfaceHolder$Callback;
  public SurfaceView a;
  public View a;
  public VideoController a;
  AndroidCamera.CameraPreviewCallback jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback;
  QavSurfaceTextureListener jdField_a_of_type_ComTencentAvCameraQavSurfaceTextureListener;
  public VcCamera a;
  private ggq jdField_a_of_type_Ggq;
  ggr jdField_a_of_type_Ggr;
  ggs jdField_a_of_type_Ggs;
  public ggt a;
  ggu jdField_a_of_type_Ggu;
  public boolean a;
  public boolean b;
  
  private CameraUtils(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_ComTencentAvCameraVcCamera = null;
    this.jdField_a_of_type_AndroidViewSurfaceView = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback = new ggn(this);
    this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback = new ggo(this);
    this.jdField_a_of_type_Ggt = new ggt(this);
    this.jdField_a_of_type_Ggr = new ggr(this);
    this.jdField_a_of_type_Ggu = new ggu(this);
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_Ggs = new ggs(this);
    this.jdField_a_of_type_ComTencentAvCameraQavSurfaceTextureListener = new ggp(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_ComTencentAvCameraVcCamera = new VcCamera(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvCameraVcCamera.i();
    if (this.jdField_a_of_type_Int > 0)
    {
      paramContext = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("cameracfg", 0);
      int i = paramContext.getInt("frontCameraRotation", 0);
      int j = paramContext.getInt("backCameraRotation", 0);
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(true, i);
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(false, j);
    }
    f();
  }
  
  private View a()
  {
    if (d()) {
      return this.jdField_a_of_type_AndroidViewView;
    }
    return this.jdField_a_of_type_AndroidViewSurfaceView;
  }
  
  public static CameraUtils a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentAvCameraCameraUtils == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvCameraCameraUtils == null) {
        jdField_a_of_type_ComTencentAvCameraCameraUtils = new CameraUtils(paramContext);
      }
      return jdField_a_of_type_ComTencentAvCameraCameraUtils;
    }
    finally {}
  }
  
  private ggq a()
  {
    if (this.jdField_a_of_type_Ggq == null) {
      this.jdField_a_of_type_Ggq = new ggq(this);
    }
    return this.jdField_a_of_type_Ggq;
  }
  
  private boolean d()
  {
    if ((Build.VERSION.SDK_INT >= 14) && (SmallScreenUtils.d(this.jdField_a_of_type_AndroidContentContext))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraUtils", 2, "WL_DEBUG isTextureView result = " + bool);
      }
      return bool;
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "WL_DEBUG createCameraView");
    }
    WindowManager localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.width = 1;
    localLayoutParams.height = 1;
    localLayoutParams.flags = 776;
    if (d()) {
      localLayoutParams.flags |= 0x1000000;
    }
    localLayoutParams.format = -3;
    localLayoutParams.windowAnimations = 0;
    localLayoutParams.type = 2005;
    localLayoutParams.gravity = 51;
    try
    {
      if (d())
      {
        this.jdField_a_of_type_AndroidViewView = new QavTextureView(this.jdField_a_of_type_AndroidContentContext);
        localObject = (QavTextureView)this.jdField_a_of_type_AndroidViewView;
        ((QavTextureView)localObject).setQavSurfaceTextureListener(this.jdField_a_of_type_ComTencentAvCameraQavSurfaceTextureListener);
        localWindowManager.addView((View)localObject, localLayoutParams);
        return;
      }
      this.jdField_a_of_type_AndroidViewSurfaceView = new SurfaceView(this.jdField_a_of_type_AndroidContentContext);
      Object localObject = this.jdField_a_of_type_AndroidViewSurfaceView.getHolder();
      ((SurfaceHolder)localObject).addCallback(this.jdField_a_of_type_AndroidViewSurfaceHolder$Callback);
      ((SurfaceHolder)localObject).setType(3);
      this.jdField_a_of_type_AndroidViewSurfaceView.setZOrderMediaOverlay(true);
      localWindowManager.addView(this.jdField_a_of_type_AndroidViewSurfaceView, localLayoutParams);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localWindowManager.updateViewLayout(a(), localLayoutParams);
      if (QLog.isColorLevel())
      {
        QLog.d("CameraUtils", 2, "add camera surface view fail: IllegalStateException." + localIllegalStateException);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraUtils", 2, "add camera surface view fail." + localException);
      }
    }
  }
  
  private void g()
  {
    WindowManager localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    try
    {
      if (d())
      {
        localWindowManager.removeView(this.jdField_a_of_type_AndroidViewView);
        this.jdField_a_of_type_AndroidViewView = null;
        return;
      }
      localWindowManager.removeView(this.jdField_a_of_type_AndroidViewSurfaceView);
      this.jdField_a_of_type_AndroidViewSurfaceView = null;
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CameraUtils", 2, "remove camera view fail.", localException);
      }
    }
  }
  
  private void h()
  {
    View localView = a();
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)localView.getLayoutParams();
    localLayoutParams.x = -30;
    localView.setLayoutParams(localLayoutParams);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) && (this.jdField_a_of_type_Int > 0))
    {
      if ((this.jdField_a_of_type_Int == 1) || (!this.jdField_a_of_type_ComTencentAvCameraVcCamera.e()))
      {
        i = this.jdField_a_of_type_ComTencentAvCameraVcCamera.c(false) + 90;
        j = i % 360 / 90;
        this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(false, i);
      }
    }
    else {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAvCameraVcCamera.c(true) + 90;
    int j = i % 360 / 90;
    this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(true, i);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "setRotation rotation: " + paramInt);
    }
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.a(paramInt);
    }
  }
  
  public void a(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "WL_DEBUG startNoPreviewRunnable function = " + paramString);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a().a().removeCallbacks(this.jdField_a_of_type_Ggs);
    this.jdField_a_of_type_ComTencentAvVideoController.a().a().postDelayed(this.jdField_a_of_type_Ggs, 5000L);
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null) {
      a().addObserver(paramObserver);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("CameraUtils", 2, "closeCamera isCameraOpened : " + this.jdField_a_of_type_ComTencentAvCameraVcCamera.g());
    }
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera.g())
    {
      this.jdField_a_of_type_Ggr.a(paramBoolean);
      ThreadManager.a(this.jdField_a_of_type_Ggr, 8, null, false);
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "isFrontCamera");
    }
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      return this.jdField_a_of_type_ComTencentAvCameraVcCamera.e();
    }
    return false;
  }
  
  public void b()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("cameracfg", 0).edit();
    int i = this.jdField_a_of_type_ComTencentAvCameraVcCamera.c(true);
    int j = this.jdField_a_of_type_ComTencentAvCameraVcCamera.c(false);
    localEditor.putInt("frontCameraRotation", i);
    localEditor.putInt("backCameraRotation", j);
    localEditor.commit();
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {}
    this.jdField_a_of_type_ComTencentAvVideoController.a().a().removeCallbacks(this.jdField_a_of_type_Ggs);
  }
  
  public void b(Observer paramObserver)
  {
    a().deleteObserver(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.e = paramBoolean;
    }
  }
  
  public boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "isCameraOpening");
    }
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      return this.jdField_a_of_type_ComTencentAvCameraVcCamera.f();
    }
    return false;
  }
  
  public void c()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CameraUtils", 2, "mSurfaceholder == null");
      }
      this.b = true;
      return;
    }
    this.b = false;
    if (QLog.isColorLevel()) {
      QLog.e("CameraUtils", 2, "openCamera");
    }
    ThreadManager.a(this.jdField_a_of_type_Ggt, 8, null, false);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvCameraVcCamera.b(paramBoolean);
  }
  
  public boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "isCameraOpened" + this.jdField_a_of_type_ComTencentAvCameraVcCamera.g());
    }
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null) {
      return this.jdField_a_of_type_ComTencentAvCameraVcCamera.g();
    }
    return false;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera != null)
    {
      if (!d()) {
        break label52;
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = (QavTextureView)this.jdField_a_of_type_AndroidViewView;
        if (Build.VERSION.SDK_INT < 14) {
          break label68;
        }
      }
    }
    label52:
    label68:
    for (Object localObject = ((QavTextureView)localObject).getSurfaceTexture();; localObject = null)
    {
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.c((SurfaceTexture)localObject);
      return;
      this.jdField_a_of_type_ComTencentAvCameraVcCamera.c(this.jdField_a_of_type_AndroidViewSurfaceView.getHolder());
      return;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentAvCameraVcCamera.g()) {
      ThreadManager.a(this.jdField_a_of_type_Ggu, 8, null, false);
    }
  }
  
  protected void finalize()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
      b("finalize");
    }
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    g();
    super.finalize();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\camera\CameraUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */