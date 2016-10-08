import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class qfg
  implements BusinessObserver
{
  public qfg(RecommendTroopManagerImp paramRecommendTroopManagerImp, long paramLong)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp.jdField_a_of_type_AndroidUtilSparseArray.append(2, Boolean.valueOf(false));
    if (QLog.isColorLevel()) {
      QLog.d(RecommendTroopManagerImp.jdField_a_of_type_JavaLangString, 2, "getRecommendTroopFromServer onReceive :" + paramBoolean);
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label80;
      }
      RecommendTroopManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppRecommendTroopManagerImp, 2, this.jdField_a_of_type_Long, paramBundle);
    }
    label80:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(RecommendTroopManagerImp.jdField_a_of_type_JavaLangString, 2, "getRecommendTroopFromServer success data is null");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */