import android.os.Bundle;
import com.tencent.biz.helper.TroopInfoActivityHelper;
import com.tencent.biz.helper.TroopInfoActivityHelper.ISetSameCityCheckTypeInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class hio
  implements BusinessObserver
{
  public hio(QQAppInterface paramQQAppInterface, TroopInfoActivityHelper.ISetSameCityCheckTypeInfo paramISetSameCityCheckTypeInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        TroopInfoActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$ISetSameCityCheckTypeInfo);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("SplashActivity", 2, "getSameCityCheckTypeInfo success but data is null");
      }
      this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$ISetSameCityCheckTypeInfo.b();
      return;
    }
    this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$ISetSameCityCheckTypeInfo.b();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hio.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */