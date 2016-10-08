import com.tencent.mobileqq.activity.aio.item.TroopRewardItemBuilder;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil.OnUploadVideoListener;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.qphone.base.util.QLog;

public class nrw
  implements TroopBarShortVideoUploadUtil.OnUploadVideoListener
{
  public nrw(TroopRewardItemBuilder paramTroopRewardItemBuilder, MessageForTroopReward paramMessageForTroopReward, nse paramnse)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "rewardMsg Upload Video Success");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardStatus = 10002;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "rewardMsg Upload Video Fail");
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardStatus = 10003;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a(this.jdField_a_of_type_Nse, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "rewardMsg Upload Video Start");
    }
  }
  
  public void b(long paramLong) {}
  
  public void c(long paramLong) {}
  
  public void d(long paramLong) {}
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nrw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */