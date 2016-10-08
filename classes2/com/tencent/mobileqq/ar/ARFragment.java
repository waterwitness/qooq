package com.tencent.mobileqq.ar;

import android.graphics.PixelFormat;
import android.graphics.SurfaceTexture;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hiar.sdk.HSARToolkit;
import com.hiar.sdk.camera.CameraParameters;
import com.hiar.sdk.camera.CameraPreviewHandler;
import com.hiar.sdk.renderer.HSRenderer;
import com.hiar.sdk.utils.FilePath;
import com.hiar.sdk.utils.GlUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import qom;
import qon;
import qoo;
import qop;
import qoq;

public class ARFragment
  extends Fragment
  implements SurfaceHolder.Callback
{
  public static final String a = "ARFragment";
  public static final String b = "config_light";
  public static final String c = "config_shadow";
  public static final String d = "1";
  public static final String e = "0";
  private SurfaceTexture jdField_a_of_type_AndroidGraphicsSurfaceTexture;
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  Handler jdField_a_of_type_AndroidOsHandler;
  public FrameLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CameraPreviewHandler jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler;
  private HSRenderer jdField_a_of_type_ComHiarSdkRendererHSRenderer;
  private ARArguments jdField_a_of_type_ComTencentMobileqqArARArguments;
  public ARGLSurfaceView a;
  private ARListener jdField_a_of_type_ComTencentMobileqqArARListener;
  private ArConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
  public ConcurrentHashMap a;
  public boolean a;
  public Handler b;
  private boolean b;
  private boolean c;
  
  public ARFragment()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = new qom(this);
    this.c = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_AndroidOsHandler = new Handler();
  }
  
  public static ARFragment a(ARArguments paramARArguments, ArConfigInfo paramArConfigInfo)
  {
    ARFragment localARFragment = new ARFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("AR_ARGUMENTS", paramARArguments);
    localBundle.putSerializable("AR_CONFIG_INFO", paramArConfigInfo);
    localARFragment.setArguments(localBundle);
    return localARFragment;
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.c)
    {
      this.c = false;
      StatisticCollector.a(BaseApplication.getContext()).a(null, "CameraSupportNV21", paramBoolean, 0L, 0L, null, null);
    }
  }
  
  private void f()
  {
    int j = 0;
    try
    {
      CameraParameters.a(this.jdField_a_of_type_AndroidHardwareCamera, this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.getHeight(), this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.getWidth());
      Object localObject = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
      if (((Camera.Parameters)localObject).getPreviewFormat() != 17)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArARListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqArARListener.a(2);
        }
        a(false);
        return;
      }
      a(true);
      int i = 90;
      if (CameraCompatibleList.d(CameraCompatibleList.g)) {
        i = 270;
      }
      this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(i);
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewTexture(this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
      Camera.Size localSize = ((Camera.Parameters)localObject).getPreviewSize();
      i = ((Camera.Parameters)localObject).getPreviewFormat();
      localObject = new PixelFormat();
      PixelFormat.getPixelFormatInfo(i, (PixelFormat)localObject);
      i = localSize.width;
      int k = localSize.height * i * ((PixelFormat)localObject).bitsPerPixel / 8;
      i = j;
      while (i < 5)
      {
        this.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(new byte[k]);
        i += 1;
      }
      this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(this.jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler);
      this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      boolean bool = this.jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler.a(this.jdField_a_of_type_AndroidHardwareCamera);
      if (this.jdField_a_of_type_ComTencentMobileqqArARListener == null) {
        return;
      }
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqArARListener.a(0);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArARListener.a(2);
  }
  
  private void g()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(null);
        this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.b().post(new qoo(this));
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.a.getConfig(paramString);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.b().post(new qop(this));
  }
  
  public void a(long paramLong) {}
  
  public void a(ARArguments paramARArguments)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARFragment", 2, "updateARArgument = " + paramARArguments);
    }
    this.jdField_a_of_type_ComTencentMobileqqArARArguments = paramARArguments;
    HSARToolkit.a().a(paramARArguments);
  }
  
  public void a(ARListener paramARListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARListener = paramARListener;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.queueEvent(new qoq(this, paramString1, paramString2));
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramString2);
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArARArguments = ((ARArguments)paramBundle.getSerializable("AR_ARGUMENTS"));
      this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = ((ArConfigInfo)paramBundle.getSerializable("AR_CONFIG_INFO"));
    }
    HSARToolkit.a().a(this.jdField_a_of_type_ComTencentMobileqqArARArguments);
    FilePath.a(BaseApplicationImpl.a());
    ReportUtil.b();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout == null)
    {
      paramLayoutInflater = getActivity();
      paramViewGroup = new LinearLayout(paramLayoutInflater);
      paramViewGroup.setOrientation(1);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramLayoutInflater);
      this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(Typeface.MONOSPACE);
      paramViewGroup.addView(this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView = new ARGLSurfaceView(paramLayoutInflater);
      a("config_light", "1");
      a("config_shadow", "1");
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setEGLContextClientVersion(2);
      this.jdField_a_of_type_ComHiarSdkRendererHSRenderer = new HSRenderer(paramLayoutInflater, this, this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqArARListener);
      this.jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler = new CameraPreviewHandler(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView, this.jdField_a_of_type_ComHiarSdkRendererHSRenderer, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo, this.jdField_a_of_type_ComTencentMobileqqArARListener);
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setARRender(this.jdField_a_of_type_ComHiarSdkRendererHSRenderer);
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setRenderMode(0);
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.getHolder().addCallback(this);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramLayoutInflater);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramViewGroup);
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label282;
      }
    }
    label282:
    for (int i = ImmersiveUtils.a(paramLayoutInflater);; i = 0)
    {
      paramLayoutInflater = new FrameLayout(paramLayoutInflater);
      paramViewGroup = new FrameLayout.LayoutParams(-1, -2);
      paramViewGroup.gravity = 48;
      paramViewGroup.setMargins(0, i, 0, 0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramLayoutInflater, paramViewGroup);
      return this.jdField_a_of_type_AndroidWidgetFrameLayout;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler != null) {
      this.jdField_a_of_type_ComHiarSdkCameraCameraPreviewHandler.b();
    }
    ThreadManager.a(new qon(this), 8, null, true);
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.onPause();
    }
    a();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.onResume();
    }
    if (this.jdField_b_of_type_Boolean) {
      h();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Boolean = true;
    paramInt1 = GlUtil.a(36197);
    this.jdField_a_of_type_AndroidGraphicsSurfaceTexture = new SurfaceTexture(paramInt1);
    this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.a(paramInt1, this.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
    h();
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {}
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_b_of_type_Boolean = false;
    a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\ar\ARFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */