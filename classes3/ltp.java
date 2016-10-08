import QQService.SvcDevLoginInfo;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.SubAccountObserver;
import mqq.os.MqqHandler;

class ltp
  extends SubAccountObserver
{
  ltp(lto paramlto, SvcDevLoginInfo paramSvcDevLoginInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.devlock.LoginInfoActivity", 2, "onGetKeyBack mainAccount=" + paramString1 + " subAccount=" + paramString2 + " key=" + paramString3);
    }
    if ((paramString3 == null) || (paramString3.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.LoginInfoActivity", 2, "onGetKeyBack begin to kickOutDev");
      }
      if (EquipmentLockImpl.a().a(this.jdField_a_of_type_Lto.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity.app, this.jdField_a_of_type_QQServiceSvcDevLoginInfo.iAppId, (byte)1, HexUtil.a(paramString3), this.jdField_a_of_type_Lto.jdField_a_of_type_Int))
      {
        LoginInfoActivity.a(this.jdField_a_of_type_Lto.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity, 1);
        return;
      }
      LoginInfoActivity.a(this.jdField_a_of_type_Lto.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).post(new ltq(this));
      return;
    }
    LoginInfoActivity.a(this.jdField_a_of_type_Lto.jdField_a_of_type_ComTencentMobileqqActivityLoginInfoActivity).post(new ltr(this));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\ltp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */