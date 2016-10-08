import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicTorchManager;

public class kqe
  implements Runnable
{
  public kqe(BaseChatPie paramBaseChatPie, OlympicManager paramOlympicManager, String paramString, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    OlympicTorchManager localOlympicTorchManager = this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicManager.a();
    if (localOlympicTorchManager != null) {
      localOlympicTorchManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqOlympicOlympicTorchManager$TorchUpdateListener, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */