import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.activity.welcomeguide.QQAVFunnyFaceInvest;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.List;

public class pnx
  extends SurfaceView
{
  int jdField_a_of_type_Int;
  Camera jdField_a_of_type_AndroidHardwareCamera;
  private SurfaceHolder jdField_a_of_type_AndroidViewSurfaceHolder;
  
  public pnx(QQAVFunnyFaceInvest paramQQAVFunnyFaceInvest, Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidHardwareCamera = null;
    b();
    if (a())
    {
      QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "CameraView");
      this.jdField_a_of_type_AndroidViewSurfaceHolder = getHolder();
      this.jdField_a_of_type_AndroidViewSurfaceHolder.addCallback(new pny(this, paramQQAVFunnyFaceInvest));
    }
  }
  
  private void d()
  {
    QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "setCameraParam");
    Camera.Parameters localParameters = this.jdField_a_of_type_AndroidHardwareCamera.getParameters();
    a(localParameters);
    this.jdField_a_of_type_AndroidHardwareCamera.setParameters(localParameters);
    this.jdField_a_of_type_AndroidHardwareCamera.startPreview();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      this.jdField_a_of_type_AndroidHardwareCamera.stopPreview();
      this.jdField_a_of_type_AndroidHardwareCamera.release();
      this.jdField_a_of_type_AndroidHardwareCamera = null;
    }
  }
  
  void a(Camera.Parameters paramParameters)
  {
    QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "setVideoSize");
    List localList = paramParameters.getSupportedPreviewSizes();
    int i;
    if (localList != null)
    {
      if (localList.size() == 0) {}
      i = 0;
      if (i >= localList.size()) {
        break label116;
      }
      Camera.Size localSize = (Camera.Size)localList.get(i);
      if (localSize.height * 4 != localSize.width * 3) {
        break label107;
      }
    }
    for (;;)
    {
      if (i != -1) {
        paramParameters.setPreviewSize(((Camera.Size)localList.get(i)).width, ((Camera.Size)localList.get(i)).height);
      }
      return;
      label107:
      i += 1;
      break;
      label116:
      i = -1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int >= 0;
  }
  
  boolean a(int paramInt)
  {
    QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "openCamera");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWelcomeguideQQAVFunnyFaceInvest.jdField_a_of_type_AndroidViewSurfaceHolder == null)
    {
      QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "openCamera mHolder");
      return false;
    }
    if (!a())
    {
      QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "openCamera IsFrontCameraCanUse");
      return false;
    }
    try
    {
      a();
      this.jdField_a_of_type_AndroidHardwareCamera = Camera.open(paramInt);
      if (Build.MODEL.toLowerCase().equals("nexus 6p")) {
        this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(270);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidHardwareCamera.setPreviewDisplay(this.jdField_a_of_type_ComTencentMobileqqActivityWelcomeguideQQAVFunnyFaceInvest.jdField_a_of_type_AndroidViewSurfaceHolder);
        d();
        QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "openCamera try end");
        return true;
        this.jdField_a_of_type_AndroidHardwareCamera.setDisplayOrientation(90);
      }
      return false;
    }
    catch (RuntimeException localRuntimeException)
    {
      return false;
    }
    catch (IOException localIOException)
    {
      if (this.jdField_a_of_type_AndroidHardwareCamera != null)
      {
        this.jdField_a_of_type_AndroidHardwareCamera.release();
        this.jdField_a_of_type_AndroidHardwareCamera = null;
      }
      localIOException.printStackTrace();
    }
  }
  
  public void b()
  {
    QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "initCameraInfo");
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int j = Camera.getNumberOfCameras();
    QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "initCameraInfo count=" + j);
    int i = 0;
    while (i < j)
    {
      Camera.getCameraInfo(i, localCameraInfo);
      QLog.i(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "initCameraInfo i=" + i + ", cameraInfo.facing=" + localCameraInfo.facing);
      if (localCameraInfo.facing == 1) {
        this.jdField_a_of_type_Int = i;
      }
      i += 1;
    }
    QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "initCameraInfo mFrontCameraIndex=" + this.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    QLog.e(QQAVFunnyFaceInvest.jdField_a_of_type_JavaLangString, 1, "startCamera");
    int i = this.jdField_a_of_type_Int;
    if (i == -1) {
      return;
    }
    a(i);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pnx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */