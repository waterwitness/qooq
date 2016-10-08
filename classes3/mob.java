import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class mob
  extends MessageObserver
{
  public mob(SubAccountUgActivity paramSubAccountUgActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + paramSubAccountBackProtocData.p + "  errorMsg=" + paramSubAccountBackProtocData.a + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.c + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if ((paramSubAccountBackProtocData == null) || (paramString == null) || (paramString.length() < 5)) {}
    SubAccountControll localSubAccountControll;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localSubAccountControll = (SubAccountControll)this.a.app.getManager(61);
        if (paramSubAccountBackProtocData.p != 1) {
          break;
        }
      } while ((this.a.jdField_b_of_type_JavaLangString == null) || (!this.a.jdField_b_of_type_JavaLangString.equals(paramString)));
      SubAccountUgActivity.a(this.a, localSubAccountControll, paramString);
      return;
    } while ((this.a.jdField_b_of_type_JavaLangString == null) || (!this.a.jdField_b_of_type_JavaLangString.equals(paramString)));
    localSubAccountControll.a(this.a.jdField_b_of_type_JavaLangString, 1, true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */