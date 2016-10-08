import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;

class mnl
  implements Runnable
{
  mnl(mnk parammnk, SubAccountManager paramSubAccountManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqSubaccountDatamanagerSubAccountManager.b(SubAccountMessageActivity.a(this.jdField_a_of_type_Mnk.a).subuin);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mnl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */