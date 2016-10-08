import android.os.Bundle;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr.OnCreateRewardListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class vrn
  implements HttpWebCgiAsyncTask.Callback
{
  public vrn(TroopRewardMgr paramTroopRewardMgr, MessageForTroopReward paramMessageForTroopReward, TroopRewardMgr.OnCreateRewardListener paramOnCreateRewardListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "createReward result:" + paramJSONObject);
    }
    TroopRewardMgr.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr, paramJSONObject, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr$OnCreateRewardListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr$OnCreateRewardListener.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vrn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */