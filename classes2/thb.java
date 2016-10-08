import SecurityAccountServer.RespondQueryQQBindingStat;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class thb
  extends ContactBindObserver
{
  boolean jdField_a_of_type_Boolean;
  
  public thb(MyBusinessManager paramMyBusinessManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean2))
    {
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqMybusinessMyBusinessManager.a.getManager(10)).a();
      if ((localRespondQueryQQBindingStat == null) || (TextUtils.isEmpty(localRespondQueryQQBindingStat.mobileNo))) {
        break label80;
      }
      ((MyBusinessManager)this.jdField_a_of_type_ComTencentMobileqqMybusinessMyBusinessManager.a.getManager(48)).a(localRespondQueryQQBindingStat.mobileNo, localRespondQueryQQBindingStat.type, "");
      this.jdField_a_of_type_Boolean = false;
    }
    label80:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PhoneContact", 2, "mybusiness bindInfo null ");
  }
  
  protected void b(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\thb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */