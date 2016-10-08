import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.TroopRewardItemBuilder;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr.OnCreateRewardListener;

public class nrx
  implements TroopRewardMgr.OnCreateRewardListener
{
  public nrx(TroopRewardItemBuilder paramTroopRewardItemBuilder, TroopRewardMgr paramTroopRewardMgr, MessageForTroopReward paramMessageForTroopReward, nse paramnse)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(MessageForTroopReward paramMessageForTroopReward)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr.a(paramMessageForTroopReward.frienduin, paramMessageForTroopReward.rewardSeq)))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardId))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardStatus = 10002;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopRewardMgr.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardStatus = 10003;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a(this.jdField_a_of_type_Nse, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nrx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */