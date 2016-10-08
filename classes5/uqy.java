import android.hardware.Camera;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover.PictureCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;

public class uqy
  extends AsyncTask
{
  uqx jdField_a_of_type_Uqx;
  
  public uqy(CameraControl paramCameraControl, uqx paramuqx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Uqx = paramuqx;
    LogTag.a();
  }
  
  private void a(File paramFile, byte[] paramArrayOfByte)
  {
    try
    {
      paramFile = new FileOutputStream(paramFile);
      paramFile.write(paramArrayOfByte);
      paramFile.flush();
      paramFile.close();
      return;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  protected String a(Void... paramVarArgs)
  {
    int j = 0;
    paramVarArgs = this.jdField_a_of_type_Uqx.jdField_a_of_type_ArrayOfByte;
    Object localObject = this.jdField_a_of_type_Uqx.jdField_a_of_type_AndroidGraphicsRect;
    localObject = this.jdField_a_of_type_Uqx.jdField_a_of_type_JavaIoFile;
    if (QLog.isColorLevel()) {
      QLog.i(CameraControl.b, 2, "Do not clip photo");
    }
    LogTag.a();
    a((File)localObject, paramVarArgs);
    if (CameraCompatibleList.d(CameraCompatibleList.j)) {
      ImageUtil.a(((File)localObject).getAbsolutePath(), "Orientation", String.valueOf(6));
    }
    while (!CameraCompatibleList.d(CameraCompatibleList.k))
    {
      LogTag.a(CameraControl.b, "TakePictureTask_writePhotoFile");
      if (!((File)localObject).exists()) {
        break;
      }
      return ((File)localObject).getAbsolutePath();
    }
    int i = j;
    switch (this.jdField_a_of_type_Uqx.jdField_a_of_type_Int % 360)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      ImageUtil.a(((File)localObject).getAbsolutePath(), "Orientation", String.valueOf(i));
      break;
      i = 6;
      continue;
      i = 3;
      continue;
      i = 8;
    }
    return null;
  }
  
  protected void a(String paramString)
  {
    
    if (this.jdField_a_of_type_Uqx.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback != null)
    {
      this.jdField_a_of_type_Uqx.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover$PictureCallback.a(paramString);
      if ((paramString == null) && (QLog.isColorLevel())) {
        QLog.i(CameraControl.b, 2, "Picture bitmap data error or output file not exist");
      }
    }
    LogTag.a(CameraControl.b, "TakePictureTask_onPictureTokenCb");
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl.jdField_a_of_type_AndroidHardwareCamera != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl.jdField_a_of_type_AndroidHardwareCamera.startPreview();
      this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraControl.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      LogTag.a(CameraControl.b, "TakePictureTask");
      return;
      if (QLog.isColorLevel()) {
        QLog.i(CameraControl.b, 2, "[onPostExecute]mCamera is " + null);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\uqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */