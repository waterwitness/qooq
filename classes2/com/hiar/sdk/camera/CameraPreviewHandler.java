package com.hiar.sdk.camera;

import ahd;
import ahe;
import ahf;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.opengl.Matrix;
import android.os.Handler;
import com.hiar.sdk.HSARToolkit;
import com.hiar.sdk.core.HiarqCameraCalib;
import com.hiar.sdk.core.HiarqImageSize;
import com.hiar.sdk.core.HiarqLog;
import com.hiar.sdk.core.HiarqOptions;
import com.hiar.sdk.core.HiarqVersion;
import com.hiar.sdk.core.NativeInterface;
import com.hiar.sdk.renderer.HSRenderer;
import com.hiar.sdk.utils.FilePath;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARDeviceController;
import com.tencent.mobileqq.ar.ARGLSurfaceView;
import com.tencent.mobileqq.ar.ARListener;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.ReportUtil;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.model.ArResourceInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class CameraPreviewHandler
  implements Camera.PreviewCallback
{
  private int jdField_a_of_type_Int;
  public long a;
  private ahf jdField_a_of_type_Ahf;
  private Camera jdField_a_of_type_AndroidHardwareCamera;
  private Handler jdField_a_of_type_AndroidOsHandler;
  HiarqLog jdField_a_of_type_ComHiarSdkCoreHiarqLog;
  private HiarqOptions jdField_a_of_type_ComHiarSdkCoreHiarqOptions;
  private HSRenderer jdField_a_of_type_ComHiarSdkRendererHSRenderer;
  private ARGLSurfaceView jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView;
  private FramePerformanceMonitor jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor;
  private ArConfigInfo jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo;
  public Object a;
  public WeakReference a;
  private Map jdField_a_of_type_JavaUtilMap;
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  public long b;
  private Object jdField_b_of_type_JavaLangObject;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public CameraPreviewHandler(ARGLSurfaceView paramARGLSurfaceView, HSRenderer paramHSRenderer, Handler paramHandler, ArConfigInfo paramArConfigInfo, ARListener paramARListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 240;
    this.jdField_b_of_type_Int = 160;
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo = paramArConfigInfo;
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView = paramARGLSurfaceView;
    this.jdField_a_of_type_ComHiarSdkRendererHSRenderer = paramHSRenderer;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramARListener);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor = new FramePerformanceMonitor();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Ahf == null) {
      this.jdField_a_of_type_Ahf = new ahf(this);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ahf != null)
    {
      this.jdField_a_of_type_Ahf.a();
      this.jdField_a_of_type_Ahf.interrupt();
      this.jdField_a_of_type_Ahf = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor != null) {
      this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.c();
    }
    HSARToolkit.a().a();
    this.jdField_a_of_type_AndroidHardwareCamera = null;
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.b();
  }
  
  boolean a()
  {
    int i;
    int j;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions != null) && (this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.viewFinderRect != null) && (this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.viewFinderRect.length == 4))
    {
      i = this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.viewFinderRect[2];
      j = this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.viewFinderRect[3];
      if ((this.jdField_a_of_type_Int == i) && (this.jdField_b_of_type_Int == j)) {
        return this.c;
      }
    }
    Object localObject7;
    label802:
    Object localObject3;
    try
    {
      if (this.jdField_a_of_type_Long != -1L) {}
      long l1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        NativeInterface.hiarqUnrealizeGallery(this.jdField_b_of_type_Long);
        NativeInterface.hiarqRemoveAllMarkers(this.jdField_b_of_type_Long);
        NativeInterface.hiarqDestroy(this.jdField_a_of_type_Long);
        this.jdField_b_of_type_Boolean = true;
        this.c = false;
        l1 = System.currentTimeMillis();
        if (NativeInterface.loadNativeLibrary())
        {
          boolean bool = ARNativeBridge.loadNativeLibrary();
          if (!bool) {}
        }
      }
      long l2;
      Integer localInteger;
      localObject3 = ((File)localObject3).list();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.jdField_a_of_type_ComHiarSdkCoreHiarqLog = new HiarqLog();
          try
          {
            NativeInterface.hiarqRegisterLogCallback(this.jdField_a_of_type_ComHiarSdkCoreHiarqLog);
            this.jdField_a_of_type_Long = NativeInterface.hiarqCreate();
            l2 = this.jdField_a_of_type_Long;
            if (l2 != 0L) {
              break;
            }
            return false;
            localObject4 = finally;
            throw ((Throwable)localObject4);
            localException1 = localException1;
            localException1.printStackTrace();
            this.c = false;
            return this.c;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            continue;
          }
          l2 = System.currentTimeMillis();
        }
        catch (Exception localException3)
        {
          localException3.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.i("HIAR", 2, "initAlgorithm cost : " + (l2 - l1));
        }
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        localUnsatisfiedLinkError.printStackTrace();
        this.c = false;
      }
      i = ARDeviceController.a().a();
      if (ARDeviceController.a().d())
      {
        this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a(new ahd(this));
        this.jdField_a_of_type_ComTencentMobileqqArFramePerformanceMonitor.a();
        this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions = new HiarqOptions();
        this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.trackingQuality = i;
        this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.recogQuality = i;
        HSARToolkit.a().jdField_b_of_type_Int = this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.trackingQuality;
        this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.filterEnable = false;
        this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.viewFinderEnable = true;
        this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.viewFinderRect = new int[4];
        this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.viewFinderRect[0] = 0;
        this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.viewFinderRect[1] = 0;
        this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.viewFinderRect[2] = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions.viewFinderRect[3] = this.jdField_b_of_type_Int;
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          NativeInterface.hiarqSetOptions(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComHiarSdkCoreHiarqOptions);
          this.jdField_b_of_type_Long = NativeInterface.hiarqGetGallery(this.jdField_a_of_type_Long);
          NativeInterface.hiarqGetAlgorithmVersion(new HiarqVersion[] { new HiarqVersion() });
          ??? = new HiarqCameraCalib();
          ((HiarqCameraCalib)???).mat = new float[9];
          localObject7 = new HiarqImageSize[1];
          localObject7[0] = new HiarqImageSize();
          localObject7[0].width = this.jdField_a_of_type_Int;
          localObject7[0].height = this.jdField_b_of_type_Int;
          localInteger = Integer.valueOf(0);
          NativeInterface.hiarqGetPreferredCameraInfo((HiarqImageSize[])localObject7, localInteger, (HiarqCameraCalib)???);
        }
      }
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          NativeInterface.hiarqSetCameraInfo(this.jdField_a_of_type_Long, localObject7[localInteger.intValue()], (HiarqCameraCalib)???);
          ??? = new float[16];
          NativeInterface.hiarqGetGLProjectMatrix((HiarqCameraCalib)???, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 100.0F, 8000.0F, (float[])???);
          ???[0] *= HSRenderer.jdField_a_of_type_Float;
          ???[8] *= HSRenderer.jdField_a_of_type_Float;
          HSRenderer.jdField_a_of_type_ArrayOfFloat = (float[])???;
          ??? = new float[16];
          if (CameraCompatibleList.d(CameraCompatibleList.g))
          {
            Matrix.setRotateM((float[])???, 0, 90.0F, 0.0F, 0.0F, 1.0F);
            Matrix.multiplyMM(HSRenderer.jdField_a_of_type_ArrayOfFloat, 0, (float[])???, 0, HSRenderer.jdField_a_of_type_ArrayOfFloat, 0);
            if (ScanTorchActivity.jdField_b_of_type_Boolean) {
              break label802;
            }
            if ((this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.featureResources == null)) {
              break label1003;
            }
            i = 0;
            if (i >= this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.featureResources.size()) {
              break label1003;
            }
            ??? = (ArResourceInfo)this.jdField_a_of_type_ComTencentMobileqqArAidlArConfigInfo.featureResources.get(i);
            NativeInterface.hiarqAddMarker(this.jdField_b_of_type_Long, ((ArResourceInfo)???).e, ((ArResourceInfo)???).n);
            this.jdField_a_of_type_JavaUtilMap.put(((ArResourceInfo)???).e, ???);
            i += 1;
            continue;
            ReportUtil.a("recog_track_quality", i);
            break;
            localObject6 = finally;
            throw ((Throwable)localObject6);
          }
        }
        Matrix.setRotateM(arrayOfFloat, 0, 270.0F, 0.0F, 0.0F, 1.0F);
      }
      localObject3 = new File(FilePath.a());
      if (!((File)localObject3).isDirectory()) {
        break label1003;
      }
    }
    if (localObject3 != null)
    {
      j = localObject3.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        String str = localObject3[i];
        if (str.endsWith(".db"))
        {
          localObject7 = new ArResourceInfo();
          ((ArResourceInfo)localObject7).e = str;
          ((ArResourceInfo)localObject7).n = (FilePath.a() + str);
          ((ArResourceInfo)localObject7).jdField_c_of_type_Int = 1;
          ((ArResourceInfo)localObject7).jdField_c_of_type_JavaLangString = "1020101";
          ((ArResourceInfo)localObject7).j = "endLine1";
          ((ArResourceInfo)localObject7).k = "endLine2";
          ((ArResourceInfo)localObject7).l = "endLine3";
          ((ArResourceInfo)localObject7).m = "endLine3Url";
          ((ArResourceInfo)localObject7).g = FilePath.d;
          ((ArResourceInfo)localObject7).f = (((ArResourceInfo)localObject7).g + "clipfile.xml");
          NativeInterface.hiarqAddMarker(this.jdField_b_of_type_Long, ((ArResourceInfo)localObject7).e, ((ArResourceInfo)localObject7).n);
          this.jdField_a_of_type_JavaUtilMap.put(((ArResourceInfo)localObject7).e, localObject7);
        }
      }
      else
      {
        label1003:
        i = NativeInterface.hiarqRealizeGallery(this.jdField_b_of_type_Long);
        if (QLog.isColorLevel()) {
          QLog.i("HIAR", 2, "result" + i);
        }
        this.c = true;
        break;
      }
      i += 1;
    }
  }
  
  public boolean a(Camera paramCamera)
  {
    this.jdField_a_of_type_AndroidHardwareCamera = paramCamera;
    Camera.Size localSize = paramCamera.getParameters().getPreviewSize();
    this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.setCamera(paramCamera);
    this.jdField_a_of_type_Int = localSize.width;
    this.jdField_b_of_type_Int = localSize.height;
    this.jdField_a_of_type_ComHiarSdkRendererHSRenderer.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    boolean bool = a();
    if (bool) {
      c();
    }
    return bool;
  }
  
  public void b()
  {
    a();
    ThreadManager.b().post(new ahe(this));
    this.jdField_b_of_type_Boolean = false;
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_Ahf != null) {
          this.jdField_a_of_type_Ahf.a(paramArrayOfByte);
        }
        if (HSARToolkit.a().jdField_c_of_type_Int == 2)
        {
          HSARToolkit.a().jdField_c_of_type_Long = HSARToolkit.a().jdField_a_of_type_Long;
          this.jdField_a_of_type_ComTencentMobileqqArARGLSurfaceView.requestRender();
        }
        paramCamera.addCallbackBuffer(paramArrayOfByte);
      }
      finally {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\hiar\sdk\camera\CameraPreviewHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */