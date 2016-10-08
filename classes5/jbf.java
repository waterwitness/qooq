import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class jbf
  implements Runnable
{
  jbf(jbd paramjbd, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Jbd.a.isFinishing()) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      QRUtils.a(1, 2131364462);
      return;
    }
    String str;
    if (this.jdField_a_of_type_Jbd.a.g == 2) {
      str = this.jdField_a_of_type_Jbd.a.getString(2131364429, new Object[] { this.jdField_a_of_type_Jbd.a.f, this.jdField_a_of_type_Jbd.a.h });
    }
    for (;;)
    {
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Jbd.a.app.getAccount();
      localUserInfo.b = ContactUtils.i(this.jdField_a_of_type_Jbd.a.app, this.jdField_a_of_type_Jbd.a.app.getAccount());
      QZoneHelper.a(this.jdField_a_of_type_Jbd.a, localUserInfo, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Jbd.a.getString(2131364427), str, 1);
      return;
      if (this.jdField_a_of_type_Jbd.a.g == 5) {
        str = this.jdField_a_of_type_Jbd.a.getString(2131364428, new Object[] { this.jdField_a_of_type_Jbd.a.f });
      } else {
        str = this.jdField_a_of_type_Jbd.a.getString(2131364430);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\jbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */