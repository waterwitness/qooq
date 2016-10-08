import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGiftUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;

public class msu
  implements View.OnClickListener
{
  public msu(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    int i = 1000;
    int k = 1;
    int j = 1;
    switch (((Integer)paramView.getTag()).intValue())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_btn", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "" + i, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.b(), "");
      return;
      Intent localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, SplashActivity.class), null);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v);
      localIntent.putExtra("PREVIOUS_WINDOW", TroopMemberCardActivity.class.getName());
      localIntent.putExtra("PREVIOUS_UIN", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend)
      {
        localIntent.putExtra("uintype", 0);
        label200:
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
          break label313;
        }
      }
      label313:
      for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.remark)
      {
        localObject = paramView;
        if (TextUtils.isEmpty(paramView)) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.w;
        }
        localIntent.putExtra("uinname", (String)localObject);
        localIntent.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t);
        localIntent.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.u);
        localIntent.putExtra("cSpecialFlag", 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivity(localIntent);
        i = j;
        break;
        localIntent.putExtra("uintype", 1000);
        break label200;
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.w;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
        i = 0;
      }
      for (paramView = null;; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.u)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, i, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v, (String)localObject, null, true, paramView, true, true, null, "from_internal");
        i = 0;
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.p();
      i = 2;
      continue;
      paramView = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, 1, 0);
      TroopGiftUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v, paramView, "profilecard", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t);
      if (paramView == null) {
        break;
      }
      if (paramView.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.a())) {
        i = 0;
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_flower", "", "mber_data", "Clk_send", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, i + "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_btn", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "" + 4, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.b(), "");
        i = 4;
        break;
        i = k;
        if (!paramView.isAdmin()) {
          i = 2;
        }
      }
      localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getActivity(), SplashActivity.class), null);
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t);
      if ((paramView != null) && (paramView.troopcode != null))
      {
        localIntent.putExtra("troop_uin", paramView.troopcode);
        localIntent.putExtra("uinname", paramView.troopname);
      }
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("at_member_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v);
      paramView = "";
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.card;
      }
      localObject = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.w;
      }
      localIntent.putExtra("at_member_name", (String)localObject);
      localIntent.putExtra("at_member_source", 2);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivity(localIntent);
      if (QLog.isColorLevel())
      {
        QLog.i("Q.profilecard.TroopMemberCardActivity", 2, "onClick@member:" + (String)localObject + "," + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v);
        i = 3;
      }
      else
      {
        i = 3;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */