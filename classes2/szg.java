import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.qphone.base.util.QLog;

public class szg
  extends TroopObserver
{
  public szg(LoginWelcomeManager paramLoginWelcomeManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString)
  {
    if (paramBoolean)
    {
      paramString = this.a.jdField_a_of_type_AndroidOsBundle.getBundle("request");
      paramString.putString("uin", String.valueOf(paramLong));
      paramString.putShort("option", paramTroopInfo.cGroupOption);
      paramString.putString("name", paramTroopInfo.troopname);
      if ((paramTroopInfo.cGroupOption != 4) && (paramTroopInfo.cGroupOption != 5)) {
        break label114;
      }
      paramString.putString("answer", paramTroopInfo.joinTroopAnswer);
      paramString.putString("question", paramTroopInfo.joinTroopQuestion);
    }
    for (;;)
    {
      this.a.b();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this);
      return;
      label114:
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuide", 2, "onOIDB0X88D_1_Ret err");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\szg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */