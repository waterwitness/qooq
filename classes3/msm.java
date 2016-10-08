import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.TroopDisbandActivity;
import com.tencent.mobileqq.activity.TroopMemberCardActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.troop.TroopMemberCardProxyActivity;

public class msm
  implements ActionSheet.OnButtonClickListener
{
  public msm(TroopMemberCardActivity paramTroopMemberCardActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.d()) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
    }
    label84:
    Object localObject;
    label1286:
    label1395:
    label1465:
    label1473:
    label1475:
    do
    {
      return;
      break label84;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.aj == 1) {
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
          return;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v), 0);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isConcerned)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_unblock", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "", "", "");
            continue;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.mIsShield) {
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_unfocus", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "", "", "");
          continue;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v), 1);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_sf", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "", "", "");
          continue;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t), Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v), 2);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_block", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "", "", "");
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.aj == 2)
          {
            if (paramInt == 0) {
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t();
            }
            if (paramInt != 1) {
              continue;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M == 3)
            {
              paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, TroopDisbandActivity.class);
              paramView.putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t);
              paramView.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.s);
              paramView.putExtra("troop_code", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.u);
              paramView.putExtra("leftViewText", 2131369488);
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivityForResult(paramView, 4);
              continue;
            }
            localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131368719);
            if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.s == null) {}
            for (paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t;; paramView = (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.s + "(" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t + ")").replace("\n", ""))
            {
              paramView = String.format(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131368712), new Object[] { paramView });
              paramView = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, 230).setTitle((String)localObject).setMessage(paramView);
              paramView.setPositiveButton(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131367774), new msn(this, paramView));
              paramView.setPositiveButtonContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131362031));
              paramView.setNegativeButton(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131367262), new mso(this, paramView));
              paramView.setNegativeButtonContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.getString(2131362032));
              paramView.show();
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_quitgrp", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "", "", "");
              break;
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.aj == 3) {
            switch (paramInt)
            {
            default: 
              break;
            case 0: 
              paramView = (TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.getManager(47);
              if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e)
              {
                paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v, 0L);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_manage", "", "silent_card", "Clk_un", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t), "", "");
                continue;
              }
              localObject = new Intent();
              ((Intent)localObject).putExtra("param_key_troopUin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t);
              ((Intent)localObject).putExtra("param_key_memberUin", this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v);
              TroopMemberCardProxyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, (Intent)localObject, "com.tencent.mobileqq.memcard.plugin.TroopMemberGagActivity", 0);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_manage", "", "silent_card", "Clk_set", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t), "", "");
              break;
            case 1: 
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.a(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_report", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "", "", "");
              break;
            case 2: 
              if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M == 3)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.k();
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t();
              break;
            case 3: 
              if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M == 3)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t();
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.u();
              break;
            case 4: 
              if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M == 3)
              {
                this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.u();
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.j();
              break;
            case 5: 
              this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.j();
              break;
            }
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.aj == 4)
          {
            if (paramInt != 0) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.a(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_report", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "", "", "");
            continue;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.aj != 5) {
            break label1475;
          }
          if (paramInt == 0)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M != 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M != 2)) {
              break label1395;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t();
          }
          if (paramInt == 1)
          {
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M != 3) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.M != 2)) {
              break label1465;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.a(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_report", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "", "", "");
          }
        }
        for (;;)
        {
          if (paramInt != 2) {
            break label1473;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.u();
          break label84;
          break;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app.a(), this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_mber", "", "mber_card", "Clk_report", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "", "", "");
          break label1286;
          this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.u();
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.aj != 6);
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, "P_CliOper", "Grp_work", "", "function", "Clk_phone", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.t, "" + paramInt, "", "");
      break;
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.w;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.jdField_a_of_type_ComTencentMobileqqDataTroopMemberCard.isFriend) {
        paramInt = 0;
      }
      for (paramView = null;; paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.u)
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity, paramInt, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.v, (String)localObject, null, true, paramView, true, true, null, "from_internal");
        paramInt = 0;
        break;
        paramInt = 1000;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.p);
      paramInt = 1;
      continue;
      paramView = new Intent("android.intent.action.SENDTO");
      paramView.setData(Uri.parse("smsto:" + this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.p));
      paramView.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberCardActivity.startActivity(paramView);
      paramInt = 2;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\msm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */