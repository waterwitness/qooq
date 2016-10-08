import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Handler;
import com.tencent.mobileqq.camera.CameraManager.CameraPreviewDataCallback;
import com.tencent.mobileqq.camera.CameraManager.CameraProxy;
import com.tencent.mobileqq.camera.QQCameraActivity;
import com.tencent.mobileqq.camera.report.QCameraRuntimeReport;
import com.tencent.mobileqq.camera.ui.PreviewBackground;
import com.tencent.mobileqq.camera.ui.PreviewSurfaceView;
import com.tencent.mobileqq.camera.ui.Rotate3dAnimation;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;

public final class qyk
  implements CameraManager.CameraPreviewDataCallback
{
  String jdField_a_of_type_JavaLangString;
  
  private qyk(QQCameraActivity paramQQCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = "Q.camera.CameraPreviewOneShotDataCallback";
  }
  
  public void a(byte[] paramArrayOfByte, CameraManager.CameraProxy paramCameraProxy, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder().append("[onPreviewFrame] + ENTER data=");
      if (paramArrayOfByte == null) {
        break label75;
      }
    }
    label75:
    for (paramInt = paramArrayOfByte.length;; paramInt = 0)
    {
      QLog.d((String)localObject1, 2, paramInt);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
        break;
      }
      QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).sendEmptyMessage(4);
      return;
    }
    QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).v();
    paramCameraProxy = paramCameraProxy.a().getPreviewSize();
    paramInt = paramCameraProxy.width;
    int i = paramCameraProxy.height;
    Rect localRect = new Rect(QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).getLeft(), QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).getTop(), QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).getRight(), QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).getBottom());
    if (QLog.isColorLevel())
    {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "[onPreviewFrame] Mirror=" + QQCameraActivity.g(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity) + " previewSize=" + paramCameraProxy.width + "," + paramCameraProxy.height + " surfaceViewSize=" + localRect + " takeTimes:" + (System.currentTimeMillis() - l));
      l = System.currentTimeMillis();
    }
    for (;;)
    {
      paramArrayOfByte = new YuvImage(paramArrayOfByte, 17, paramInt, i, null);
      paramCameraProxy = new ByteArrayOutputStream();
      paramArrayOfByte.compressToJpeg(new Rect(0, 0, paramInt, i), 100, paramCameraProxy);
      byte[] arrayOfByte = paramCameraProxy.toByteArray();
      Object localObject3 = null;
      Object localObject4 = null;
      localObject2 = null;
      paramCameraProxy = (CameraManager.CameraProxy)localObject2;
      localObject1 = localObject3;
      paramArrayOfByte = (byte[])localObject4;
      for (;;)
      {
        try
        {
          QQCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, CameraUtils.a(QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity), QQCameraActivity.d(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity), QQCameraActivity.e(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity)));
          paramCameraProxy = (CameraManager.CameraProxy)localObject2;
          localObject1 = localObject3;
          paramArrayOfByte = (byte[])localObject4;
          localObject2 = CameraUtils.a(arrayOfByte, QQCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity), 8, QQCameraActivity.g(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity));
          if (localObject2 != null)
          {
            paramCameraProxy = (CameraManager.CameraProxy)localObject2;
            localObject1 = localObject2;
            paramArrayOfByte = (byte[])localObject2;
            QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, CameraUtils.a(localRect.right - localRect.left, localRect.bottom - localRect.top, (Bitmap)localObject2));
            paramCameraProxy = (CameraManager.CameraProxy)localObject2;
            localObject1 = localObject2;
            paramArrayOfByte = (byte[])localObject2;
            if (QLog.isColorLevel())
            {
              paramCameraProxy = (CameraManager.CameraProxy)localObject2;
              localObject1 = localObject2;
              paramArrayOfByte = (byte[])localObject2;
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[onPrevFrame] blurBitmap isMutable1: " + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).isMutable());
            }
            paramCameraProxy = (CameraManager.CameraProxy)localObject2;
            localObject1 = localObject2;
            paramArrayOfByte = (byte[])localObject2;
            StackBlur.a(QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity), 16);
            paramCameraProxy = (CameraManager.CameraProxy)localObject2;
            localObject1 = localObject2;
            paramArrayOfByte = (byte[])localObject2;
            if (QLog.isColorLevel())
            {
              paramCameraProxy = (CameraManager.CameraProxy)localObject2;
              localObject1 = localObject2;
              paramArrayOfByte = (byte[])localObject2;
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[onPrevFrame] blurBitmap isMutable2: " + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).isMutable());
            }
            paramCameraProxy = (CameraManager.CameraProxy)localObject2;
            localObject1 = localObject2;
            paramArrayOfByte = (byte[])localObject2;
            QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity, CameraUtils.a(QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity), QQCameraActivity.g(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity)));
            paramCameraProxy = (CameraManager.CameraProxy)localObject2;
            localObject1 = localObject2;
            paramArrayOfByte = (byte[])localObject2;
            if (QLog.isColorLevel())
            {
              paramCameraProxy = (CameraManager.CameraProxy)localObject2;
              localObject1 = localObject2;
              paramArrayOfByte = (byte[])localObject2;
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[onPrevFrame] blurBitmap isMutable3: " + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).isMutable());
              paramCameraProxy = (CameraManager.CameraProxy)localObject2;
              localObject1 = localObject2;
              paramArrayOfByte = (byte[])localObject2;
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[onPreviewFrame] generate blurBitmap:" + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity) + " isMutable:" + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).isMutable() + " scaledBitmap:" + localObject2 + " (" + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).getWidth() + "," + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).getHeight() + ")");
            }
          }
          CameraUtils.a((Bitmap)localObject2);
          if (QLog.isColorLevel())
          {
            QLog.i(this.jdField_a_of_type_JavaLangString, 2, "[onPreviewFrame] createBitmap jpegRotation=" + QQCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity) + " blur=" + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).getWidth() + "," + QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).getHeight() + " takeTimes:" + (System.currentTimeMillis() - l));
            l = System.currentTimeMillis();
            QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).w();
            QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity);
            QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).a = QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity);
            paramArrayOfByte = new Rotate3dAnimation(0.0F, 90.0F, QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).getWidth() / 2, QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).getHeight() / 2, 300.0F, 1);
            paramArrayOfByte.a(new qyl(this));
            paramArrayOfByte.setDuration(800L);
            paramArrayOfByte.setFillAfter(true);
            paramArrayOfByte.setAnimationListener(new qym(this));
            QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).startAnimation(paramArrayOfByte);
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "[onPreviewFrame] + END takeTimes:" + (System.currentTimeMillis() - l));
            return;
          }
        }
        catch (Exception localException)
        {
          paramArrayOfByte = paramCameraProxy;
          localException.printStackTrace();
          paramArrayOfByte = paramCameraProxy;
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "[onPreviewFrame] createBitmap " + localException.getMessage(), localException);
          paramArrayOfByte = paramCameraProxy;
          CameraUtils.a(QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity));
          paramArrayOfByte = paramCameraProxy;
          QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).sendEmptyMessage(4);
          return;
        }
        catch (OutOfMemoryError paramCameraProxy)
        {
          paramArrayOfByte = localException;
          paramCameraProxy.printStackTrace();
          paramArrayOfByte = localException;
          QLog.e(this.jdField_a_of_type_JavaLangString, 2, "[onPreviewFrame] createBitmap failed. " + paramCameraProxy.getMessage(), paramCameraProxy);
          paramArrayOfByte = localException;
          CameraUtils.a(QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity));
          paramArrayOfByte = localException;
          QQCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqCameraQQCameraActivity).sendEmptyMessage(4);
          return;
        }
        finally
        {
          CameraUtils.a(paramArrayOfByte);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\qyk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */