import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mta
  extends Handler
{
  public mta(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 2: 
    default: 
      return;
    case 1: 
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.K != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.L != 1))
      {
        paramMessage = new Intent();
        paramMessage.putExtra("finish_chat_setting", true);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.K == 8)
        {
          paramMessage.putExtra("key_troop_fee_notify_js_data_changed", true);
          paramMessage.putExtra("callback", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.z);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.setResult(-1, paramMessage);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.finish();
      return;
    case 3: 
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.c();
      return;
    case 4: 
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.d();
      return;
    case 5: 
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ArrayOfAndroidViewView[10].setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */