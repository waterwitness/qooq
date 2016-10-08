import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.TroopFeeMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class nqw
  implements View.OnClickListener
{
  public nqw(TroopFeeMsgItemBuilder paramTroopFeeMsgItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    nqx localnqx = (nqx)AIOUtils.a(paramView);
    MessageForTroopFee localMessageForTroopFee = (MessageForTroopFee)localnqx.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", localMessageForTroopFee.actionUrl);
    paramView.getContext().startActivity(localIntent);
    paramView = ((TroopManager)this.a.a.getManager(51)).a(localnqx.jdField_a_of_type_JavaLangString);
    int i;
    if (paramView != null)
    {
      if (!paramView.isTroopOwner(this.a.a.a())) {
        break label150;
      }
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.a.a, "P_CliOper", "Grp_pay", "", "grp_aio", "Clk_payobj", 0, 0, localnqx.jdField_a_of_type_JavaLangString, i + "", "", "");
      return;
      label150:
      if (paramView.isAdmin()) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nqw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */