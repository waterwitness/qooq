import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.jsp.TroopAssistantFeedsJsHandler;

public class vnm
  implements TroopMemberApiClient.Callback
{
  public vnm(TroopAssistantFeedsJsHandler paramTroopAssistantFeedsJsHandler, String paramString1, String paramString2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.getBoolean("ret", false)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopJspTroopAssistantFeedsJsHandler.a(this.jdField_a_of_type_JavaLangString, this.b);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopJspTroopAssistantFeedsJsHandler.c(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vnm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */