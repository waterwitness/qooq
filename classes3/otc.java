import com.tencent.mobileqq.activity.qwallet.PasswdRedBagDBManager;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagInfo;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class otc
  implements Runnable
{
  public otc(PasswdRedBagManager paramPasswdRedBagManager, PasswdRedBagInfo paramPasswdRedBagInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager).a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagInfo);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\otc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */