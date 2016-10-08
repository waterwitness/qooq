package com.tencent.biz.huangye;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class QQYPQRCodePreviewActivity$RefreshHeadRunnable
  implements Runnable
{
  protected QQYPQRCodePreviewActivity$RefreshHeadRunnable(QQYPQRCodePreviewActivity paramQQYPQRCodePreviewActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Bitmap localBitmap = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.a.c, (byte)2, true);
    if (localBitmap != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      if ((this.a.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$RefreshHeadRunnable != null) && (this.a.jdField_a_of_type_AndroidOsHandler != null)) {
        this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$RefreshHeadRunnable);
      }
    }
    while ((this.a.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$RefreshHeadRunnable == null) || (this.a.jdField_a_of_type_AndroidOsHandler == null)) {
      return;
    }
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_ComTencentBizHuangyeQQYPQRCodePreviewActivity$RefreshHeadRunnable, 1000L);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\biz\huangye\QQYPQRCodePreviewActivity$RefreshHeadRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */