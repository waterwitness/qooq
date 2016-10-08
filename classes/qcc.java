import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class qcc
  implements Runnable
{
  public qcc(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
      StringBuilder localStringBuilder = new StringBuilder().append("checkListState, bindState = ").append(i);
      if (localObject == null)
      {
        localObject = ",getSelfBindInfo is null";
        QLog.d("PhoneContact.Manager", 2, (String)localObject + ", changed = " + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.g + ", firstQuery = " + this.jdField_a_of_type_Boolean);
      }
    }
    else
    {
      if ((i == 5) || (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c())) {
        break label136;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.i();
    }
    label136:
    while ((!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b()) || ((!this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.g)))
    {
      return;
      localObject = ", lastFlag = " + ((RespondQueryQQBindingStat)localObject).lastUsedFlag;
      break;
    }
    PhoneContactManagerImp.e(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */