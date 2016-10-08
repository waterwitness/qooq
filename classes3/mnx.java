import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class mnx
  extends SubAccountBindObserver
{
  public mnx(SubAccountUgActivity paramSubAccountUgActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (this.a.jdField_b_of_type_JavaLangString != null) && (this.a.jdField_b_of_type_JavaLangString.length() >= 5))
    {
      paramSubAccountBackProtocData = paramSubAccountBackProtocData.c();
      if ((paramSubAccountBackProtocData != null) && (!paramSubAccountBackProtocData.contains(this.a.jdField_b_of_type_JavaLangString))) {}
    }
    else
    {
      return;
    }
    paramSubAccountBackProtocData = (SubAccountControll)this.a.app.getManager(61);
    SubAccountUgActivity.a(this.a, paramSubAccountBackProtocData, this.a.jdField_b_of_type_JavaLangString);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + this.a.jdField_b_of_type_JavaLangString);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
    }
    if ((paramSubAccountBackProtocData == null) || (this.a.jdField_b_of_type_JavaLangString == null) || ((this.a.jdField_b_of_type_JavaLangString != null) && (!this.a.jdField_b_of_type_JavaLangString.equals(paramSubAccountBackProtocData.c)))) {}
    do
    {
      return;
      this.a.a();
      if (this.a.jdField_b_of_type_Boolean)
      {
        this.a.jdField_b_of_type_Boolean = false;
        if (paramBoolean)
        {
          this.a.d();
          this.a.b(this.a.getString(2131370558));
          return;
        }
        this.a.a(this.a.getString(2131370529));
        return;
      }
    } while (!paramBoolean);
    paramSubAccountBackProtocData = (SubAccountControll)this.a.app.getManager(61);
    Pair localPair = paramSubAccountBackProtocData.a(this.a.jdField_b_of_type_JavaLangString, 1);
    paramSubAccountBackProtocData.a(this.a.app, this.a, localPair, new mny(this, paramSubAccountBackProtocData, localPair));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mnx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */