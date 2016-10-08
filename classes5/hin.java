import android.os.Bundle;
import com.tencent.biz.helper.TroopInfoActivityHelper;
import com.tencent.biz.helper.TroopInfoActivityHelper.IGetSameCityCheckTypeInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public final class hin
  implements BusinessObserver
{
  public hin(QQAppInterface paramQQAppInterface, TroopInfoActivityHelper.IGetSameCityCheckTypeInfo paramIGetSameCityCheckTypeInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        TroopInfoActivityHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle, this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$IGetSameCityCheckTypeInfo);
      }
    }
    else
    {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("SplashActivity", 2, "getSameCityCheckTypeInfo success but data is null");
    }
    this.jdField_a_of_type_ComTencentBizHelperTroopInfoActivityHelper$IGetSameCityCheckTypeInfo.a();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */