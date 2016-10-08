package com.tencent.mobileqq.shortvideo.mediadevice;

import android.os.Handler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import uqz;
import ura;

public class CameraExceptionHandler
{
  public Handler a;
  public CameraExceptionHandler.Callback a;
  
  public CameraExceptionHandler(Handler paramHandler, CameraExceptionHandler.Callback paramCallback)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoMediadeviceCameraExceptionHandler$Callback = paramCallback;
  }
  
  public void a(Exception paramException)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ura(this, paramException));
  }
  
  public void a(RuntimeException paramRuntimeException)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new uqz(this, paramRuntimeException));
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\mediadevice\CameraExceptionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */