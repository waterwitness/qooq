import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class roc
  implements Runnable
{
  roc(rnz paramrnz)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    try
    {
      String str = (String)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.getText();
      if ((str == null) || (str.length() == 0)) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.clearAnimation();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.setVisibility(0);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\roc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */