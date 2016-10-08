import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class vza
  implements Runnable
{
  vza(vyz paramvyz, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_Vyz.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        localIntent.putExtra("BSafeReportPost", true);
        if (this.jdField_a_of_type_JavaLangString != null) {
          continue;
        }
        arrayOfByte = null;
        localIntent.putExtra("SafeReportData", arrayOfByte);
        localIntent.putExtra("hide_more_button", true);
        localIntent.putExtra("ishiderefresh", true);
        localIntent.putExtra("ishidebackforward", true);
        this.jdField_a_of_type_Vyz.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(localIntent.putExtra("url", "http://jubao.qq.com/uniform_impeach/impeach_entry"));
      }
      catch (Exception localException)
      {
        byte[] arrayOfByte;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.FrdProfileCard", 2, "safetyReport exception" + localException.getMessage());
        continue;
      }
      this.jdField_a_of_type_Vyz.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      return;
      arrayOfByte = this.jdField_a_of_type_JavaLangString.getBytes("utf-8");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */