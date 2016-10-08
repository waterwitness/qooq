package com.tencent.mobileqq.avatar.dynamicavatar.videodrawable;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class VideoDrawableHandler$DecodeFrameTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  
  public VideoDrawableHandler$DecodeFrameTask(VideoDrawableHandler paramVideoDrawableHandler, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.a(this.jdField_a_of_type_Int);
    int i;
    if (localBitmap == null)
    {
      localBitmap = VideoDrawableHandler.a(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler);
      if (localBitmap == null) {
        i = 2;
      }
    }
    for (;;)
    {
      if ((localBitmap != null) && (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidGraphicsBitmap != localBitmap)) {}
      for (;;)
      {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.b = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidGraphicsBitmap;
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
          this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 0, 0).sendToTarget();
          if (this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler$OnGetFrameListener != null) {
            this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler$OnGetFrameListener.a(this.jdField_a_of_type_Int, i);
          }
          if (QLog.isColorLevel()) {
            QLog.i(VideoDrawableHandler.jdField_a_of_type_JavaLangString, 2, "task run at:" + this.jdField_a_of_type_Int + " bmp:" + this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidGraphicsBitmap);
          }
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarVideodrawableVideoDrawableHandler.jdField_a_of_type_AndroidOsHandler.obtainMessage(0, 1, 0).sendToTarget();
      }
      i = 1;
      continue;
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\avatar\dynamicavatar\videodrawable\VideoDrawableHandler$DecodeFrameTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */