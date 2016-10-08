import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class kox
  implements Runnable
{
  public kox(BaseChatPie paramBaseChatPie, boolean paramBoolean, Intent paramIntent1, Intent paramIntent2)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("forward", 1, "updateSession_forwardType, postDelayed Run! needToBottom=" + this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.f(this.jdField_a_of_type_AndroidContentIntent);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.L();
    }
    if (this.b.getBooleanExtra("isFromShare", false))
    {
      this.b.removeExtra("forward_type");
      this.b.removeExtra("isFromShare");
      String str2 = this.b.getStringExtra("leftBackText");
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131367975);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */