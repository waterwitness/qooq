import android.content.Intent;
import com.tencent.device.file.DevLittleVideoOperator;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.AioShortVideoOperator;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.qphone.base.util.QLog;

class pjc
  implements Runnable
{
  pjc(pjb parampjb)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject;
    ShortVideoUploadInfo localShortVideoUploadInfo;
    if (this.a.jdField_a_of_type_AndroidContentIntent != null)
    {
      int i = this.a.jdField_a_of_type_AndroidContentIntent.getIntExtra("file_send_business_type", 2);
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "#SendTask# run(), busiType = " + i + ",VideoFileDir = " + this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("file_video_source_dir"));
      }
      int j = this.a.jdField_a_of_type_AndroidContentIntent.getIntExtra("uintype", -1);
      if (j == 9501) {
        i = 4;
      }
      localObject = ShortVideoBusiManager.a(0, i);
      localShortVideoUploadInfo = ShortVideoBusiManager.a(this.a.jdField_a_of_type_AndroidContentIntent, (ShortVideoReq)localObject);
      ((ShortVideoReq)localObject).a(localShortVideoUploadInfo);
      if (j != 9501) {
        break label211;
      }
      localObject = new DevLittleVideoOperator(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      ((DevLittleVideoOperator)localObject).a(((DevLittleVideoOperator)localObject).a(localShortVideoUploadInfo));
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendVideoActivity", 2, "#SendTask# run(): success");
      }
      if (!this.a.jdField_a_of_type_Boolean)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      }
      return;
      label211:
      localObject = new AioShortVideoOperator(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app);
      ((AioShortVideoOperator)localObject).a(((AioShortVideoOperator)localObject).a(localShortVideoUploadInfo));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pjc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */