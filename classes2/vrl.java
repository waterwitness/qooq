import android.os.Bundle;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr.OnPayRewardListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class vrl
  implements HttpWebCgiAsyncTask.Callback
{
  public vrl(TroopRewardMgr paramTroopRewardMgr, String paramString1, String paramString2, TroopRewardMgr.OnPayRewardListener paramOnPayRewardListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    paramJSONObject = TroopRewardMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr, paramJSONObject);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "payReward rewardId:" + this.jdField_a_of_type_JavaLangString + ",troopUin:" + this.b);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr$OnPayRewardListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr$OnPayRewardListener.a(paramJSONObject);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */