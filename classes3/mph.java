import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mph
  implements Runnable
{
  public mph(TroopAssistantActivity paramTroopAssistantActivity, QQMessageFacade paramQQMessageFacade)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.e();
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.runOnUiThread(new mpi(this, i));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */