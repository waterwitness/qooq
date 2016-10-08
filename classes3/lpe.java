import android.os.Message;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.vas.IndividuationManager;
import mqq.os.MqqHandler;

public class lpe
  implements Runnable
{
  public lpe(IndividuationSetActivity paramIndividuationSetActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = 1;
    Message localMessage;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.jdField_a_of_type_VipRecommendMQQCommPayInfo == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.jdField_a_of_type_VipRecommendMQQCommPayInfo = this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.a();
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(2);
        this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.jdField_a_of_type_ComTencentMobileqqVasIndividuationManager.a(this.jdField_a_of_type_Boolean);
      localMessage = this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
      localMessage.obj = localObject;
      if (!this.jdField_a_of_type_Boolean) {
        break label120;
      }
    }
    for (;;)
    {
      localMessage.arg1 = i;
      this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
      label120:
      i = 0;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */