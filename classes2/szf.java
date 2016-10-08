import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.nearby.business.NearbyCardObserver;
import com.tencent.qphone.base.util.QLog;

public class szf
  extends NearbyCardObserver
{
  public szf(LoginWelcomeManager paramLoginWelcomeManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, NearbyPeopleCard paramNearbyPeopleCard, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramNearbyPeopleCard != null))
    {
      byte[] arrayOfByte = paramNearbyPeopleCard.vTempChatSig;
      String str = paramNearbyPeopleCard.nickname;
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuide", 2, "onNearbyCardDownload " + paramNearbyPeopleCard.uin + " " + str);
      }
      Bundle localBundle = this.a.jdField_a_of_type_AndroidOsBundle.getBundle("request");
      localBundle.putString("uin", paramNearbyPeopleCard.uin);
      localBundle.putByteArray("sig", arrayOfByte);
      localBundle.putString("nick", str);
      localBundle.putString("tinyId", String.valueOf(paramNearbyPeopleCard.tinyId));
    }
    for (;;)
    {
      this.a.b();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NewerGuide", 2, "onNearbyCardDownload err" + paramBoolean1 + " " + paramNearbyPeopleCard);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\szf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */