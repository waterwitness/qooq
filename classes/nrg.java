import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.Base64Util;

public class nrg
  implements View.OnClickListener
{
  private MessageForTroopGift jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift;
  private nrh jdField_a_of_type_Nrh;
  
  public nrg(TroopGiftMsgItemBuilder paramTroopGiftMsgItemBuilder, MessageForTroopGift paramMessageForTroopGift, nrh paramnrh)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift = paramMessageForTroopGift;
    this.jdField_a_of_type_Nrh = paramnrh;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    int i;
    if (paramView.getId() == 2131305149)
    {
      if (TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift))
      {
        paramView = (TroopGiftManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(112);
        if ((paramView != null) && (paramView.o == 1))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading = false;
          paramView.a(this.jdField_a_of_type_Nrh);
          paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift);
          if (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading) {
            paramView.b(this.jdField_a_of_type_Nrh);
          }
          if (paramView.a() == null)
          {
            localObject = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment();
            if ((localObject != null) && ((((ChatFragment)localObject).a() instanceof TroopChatPie))) {
              paramView.a((TroopChatPie)((ChatFragment)localObject).a());
            }
          }
          paramView.f();
        }
        return;
      }
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin;
      localObject = "https://qun.qq.com/qunpay/gifts/index.html?troopUin=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + "&uin=" + (String)localObject + "&name=" + Base64Util.encodeToString(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.subtitle.getBytes(), 2) + "&from=obj&_wv=1031&_bid=2204";
      paramView.putExtra("url", (String)localObject);
      paramView.putExtra("key_isReadModeEnabled", true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f().equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin)) {
        i = 0;
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_obj", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i + "", this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.giftPicId + "", "");
      PublicAccountUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift, paramView, (String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext.startActivity(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f().equals(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopGift.receiverUin)))
      {
        i = 1;
        continue;
        if (paramView.getId() != 2131305154) {
          break;
        }
        paramView = ((FragmentActivity)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_AndroidContentContext).getChatFragment();
        if ((paramView != null) && ((paramView.a() instanceof TroopChatPie))) {
          ((TroopChatPie)paramView.a()).j(true);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_objtail", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopGiftMsgItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
        return;
      }
      i = 2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nrg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */