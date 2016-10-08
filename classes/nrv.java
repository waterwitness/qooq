import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.TroopRewardItemBuilder;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr.OnCreateRewardListener;

class nrv
  implements TroopRewardMgr.OnCreateRewardListener
{
  nrv(nru paramnru)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(MessageForTroopReward paramMessageForTroopReward)
  {
    if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardId))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
      TroopRewardItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward, this.a.jdField_a_of_type_Nse, this.a.jdField_a_of_type_JavaLangString, this.a.b);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardStatus = 10003;
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a(this.a.jdField_a_of_type_Nse, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nrv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */