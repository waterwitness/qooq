import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import mqq.observer.SubAccountObserver;

public class qlz
  extends SubAccountObserver
{
  public qlz(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubAccountManager paramSubAccountManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString3 == null) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageOnLinePushMessageProcessor.a == null) || (paramString1 == null)) {}
    while (!paramString1.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppMessageOnLinePushMessageProcessor.a.getAccount())) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.a(paramString2, paramString3, true);
    SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOnLinePushMessageProcessor.a, (byte)1, paramString2);
    SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageOnLinePushMessageProcessor.a, paramString2, false);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qlz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */