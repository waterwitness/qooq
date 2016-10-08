import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.TroopRewardItemBuilder;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQToast;

public class nro
  implements View.OnClickListener
{
  public nro(TroopRewardItemBuilder paramTroopRewardItemBuilder, MessageForTroopReward paramMessageForTroopReward, nse paramnse)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardType == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.expiredTimeStamp > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.expiredTimeStamp < (int)(System.currentTimeMillis() / 1000L)))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a.getResources().getString(2131365302), 0).b(BaseApplicationImpl.a().getResources().getDimensionPixelSize(2131492908));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardStatus = 10000;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.a(this.jdField_a_of_type_Nse, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward);
    TroopRewardItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward, this.jdField_a_of_type_Nse);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */