import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class kkj
  extends Handler
{
  public kkj(AssistantSettingActivity paramAssistantSettingActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      if (!this.a.isFinishing())
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131368311));
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2130842940);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(false);
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      return;
    } while ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.cancel();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.a.getString(2131368310));
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.d(true);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kkj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */