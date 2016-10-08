import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;

public class qeq
  extends FriendListObserver
{
  public qeq(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QQAppInterface.jdField_a_of_type_JavaLangString + "_friendListObserver", 2, "onUpdateFriendInfo uin:" + paramString + ",isSuccess:" + paramBoolean);
    }
    if (this.a.jdField_a_of_type_JavaUtilSet.contains(paramString))
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b() == 1) && (paramString != null) && (paramString.equals(((QQMessageFacade.Message)this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().get(0)).frienduin)) && (this.a.isBackground_Pause) && (this.a.f()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(QQAppInterface.jdField_a_of_type_JavaLangString + "_friendListObserver", 2, "update notifcation");
        }
        QQAppInterface.a(this.a, (QQMessageFacade.Message)this.a.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().get(0), false);
      }
      this.a.jdField_a_of_type_JavaUtilSet.remove(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d(QQAppInterface.jdField_a_of_type_JavaLangString + "_friendListObserver", 2, "removeObserver");
    }
    this.a.b(this);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\qeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */