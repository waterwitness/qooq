import android.os.Handler;
import com.tencent.mobileqq.activity.aio.item.TroopRewardItemBuilder;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopRewardUtil.OnUploadImageListener;
import com.tencent.qphone.base.util.QLog;

class nrs
  implements TroopRewardUtil.OnUploadImageListener
{
  nrs(nrr paramnrr)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "rewardMsg Upload Picture Finish,result:" + paramString);
    }
    if (!TroopRewardItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder, paramString, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardStatus = 10003;
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a(this.a.jdField_a_of_type_Nse, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.b.post(new nrt(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */