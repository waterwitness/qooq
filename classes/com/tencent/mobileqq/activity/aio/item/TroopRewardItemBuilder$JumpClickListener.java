package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopRewardUtil;
import com.tencent.mobileqq.troopreward.TroopRewardDetailActivity;
import com.tencent.mobileqq.troopreward.TroopRewardInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.io.Serializable;
import nsa;
import nsb;
import nse;

public class TroopRewardItemBuilder$JumpClickListener
  implements View.OnClickListener
{
  MessageForTroopReward jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward;
  nse jdField_a_of_type_Nse;
  
  public TroopRewardItemBuilder$JumpClickListener(TroopRewardItemBuilder paramTroopRewardItemBuilder, MessageForTroopReward paramMessageForTroopReward, nse paramnse)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward = paramMessageForTroopReward;
    this.jdField_a_of_type_Nse = paramnse;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131305239)
    {
      TroopRewardMgr.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      ReportController.b(null, "dc00899", "Grp_paypic", "", "AIOchat", "Clk_pictag", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "" + TroopRewardUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.senderuin, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardType - 1), "");
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardStatus;
    } while ((i == 10000) || (i == 10001) || (i == 10003) || (i == 10003) || (i == 4) || (i == 10002));
    ReportController.b(null, "dc00899", "Grp_paypic", "", "AIOchat", "Clk_paypic", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "" + TroopRewardUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.senderuin, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "" + (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardType - 1), "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardType == 2) && (!TVK_SDKMgr.isInstalled(BaseApplicationImpl.a())))
    {
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {}
      for (i = 1; i != 0; i = 0)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365289), 0).b(BaseApplicationImpl.a().getResources().getDimensionPixelSize(2131492908));
        return;
      }
      DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_AndroidContentContext, 232, null, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_AndroidContentContext.getResources().getString(2131365287), new nsa(this), new nsb(this)).show();
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    if ((paramView != null) && (!paramView.equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.senderuin)))
    {
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_AndroidContentContext, TroopRewardDetailActivity.class);
      localObject = new TroopRewardInfo();
      ((TroopRewardInfo)localObject).troopUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      ((TroopRewardInfo)localObject).rewardId = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardId;
      ((TroopRewardInfo)localObject).ownerUin = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.senderuin;
      ((TroopRewardInfo)localObject).type = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardType;
      ((TroopRewardInfo)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardContent;
      ((TroopRewardInfo)localObject).rewardFee = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardMoney;
      ((TroopRewardInfo)localObject).videoDuration = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.videoDuration;
      paramView.putExtra("rewardInfo", (Serializable)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
    }
    paramView = "http://qun.qq.com/qunpay/reward/detail.html?_wv=16778255&_bid=2313&gc=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + "&id=" + this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopReward.rewardId;
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("isTransparentTitleAndClickable", true);
    ((Intent)localObject).putExtra("url", paramView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.troop_reward", 2, "openPayFlowPage:" + paramView);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_paypic", "", "Hostpaypic", "exp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopRewardItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "0", "");
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\item\TroopRewardItemBuilder$JumpClickListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */