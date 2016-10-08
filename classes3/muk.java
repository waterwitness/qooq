import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.TroopMemberLbs.TroopMemberLbsHelper;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.TroopMemberListActivity.ListAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class muk
  implements ActionSheet.OnButtonClickListener
{
  public muk(TroopMemberListActivity paramTroopMemberListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!TroopMemberLbsHelper.a(this.a.k, this.a.app).booleanValue()) && (paramInt >= 3) && (this.a.J != 6)) {}
    for (int j = paramInt + 1;; j = paramInt)
    {
      int i = j;
      if (!TroopMemberListActivity.b(this.a)) {
        if ((j < 6) || (this.a.J == 6))
        {
          i = j;
          if (j >= 2)
          {
            i = j;
            if (this.a.J != 6) {}
          }
        }
        else
        {
          i = j + 1;
        }
      }
      j = i;
      if (!this.a.h) {
        if ((i < 8) || (this.a.J == 6))
        {
          j = i;
          if (i >= 5)
          {
            j = i;
            if (this.a.J != 6) {}
          }
        }
        else
        {
          j = i + 1;
        }
      }
      if (this.a.J == 6)
      {
        paramView = this.a.getResources().getStringArray(2131230776);
        if (this.a.J != 6) {
          break label938;
        }
        if (((this.a.W != 0) || (j != 0)) && ((this.a.W != 5) || (j != 1))) {
          switch (j)
          {
          }
        }
      }
      for (;;)
      {
        if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
          this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        }
        return;
        if (this.a.J == 9)
        {
          paramView = this.a.getResources().getStringArray(2131230779);
          break;
        }
        paramView = this.a.getResources().getStringArray(2131230775);
        break;
        this.a.W = j;
        this.a.a(this.a.jdField_a_of_type_ComTencentWidgetActionSheet, paramView);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
        this.a.h();
        if (paramInt == 0) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, 0);
        }
        while (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
          break;
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131493022));
        }
        this.a.W = 5;
        this.a.a(this.a.jdField_a_of_type_ComTencentWidgetActionSheet, paramView);
        this.a.h();
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
        }
        ReportController.b(this.a.app, "CliOper", "", "", "0X80054B5", "0X80054B5", 0, 0, "", "", "", "");
        continue;
        this.a.G = String.format(this.a.G, new Object[] { this.a.k });
        paramView = new Intent(this.a, QQBrowserActivity.class);
        paramView.putExtra("uin", this.a.app.a());
        paramView.putExtra("url", this.a.G);
        this.a.startActivity(paramView);
        continue;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isAllowCreateDiscuss()) || (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.isTroopOwner(this.a.app.a())))
        {
          TroopMemberListActivity.a(this.a);
          ReportController.b(this.a.app, "CliOper", "", "", "0X80054B2", "0X80054B2", 0, 0, "", "", "", "");
        }
        else
        {
          QQToast.a(this.a, this.a.getString(2131364737), 0).b(this.a.getTitleBarHeight());
          continue;
          this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new mul(this), 320L);
          continue;
          if (!NetworkUtil.e(BaseApplication.getContext()))
          {
            if (this.a.isResume()) {
              QQToast.a(this.a, this.a.getString(2131369008), 0).b(this.a.getTitleBarHeight());
            }
          }
          else
          {
            this.a.a(0L, true);
            TroopUtils.a(this.a, 1, this.a.k, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
            continue;
            this.a.b = true;
            this.a.I = "";
            this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
              this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
            }
            paramView = this.a.F;
            this.a.a("Clk_del", paramView, "");
            continue;
            label938:
            if (this.a.J == 9) {
              switch (j)
              {
              default: 
                break;
              case 0: 
                this.a.b = true;
                this.a.I = "";
                this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
                this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
                if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
                  this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
                }
                ReportController.b(this.a.app, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, this.a.k, this.a.F, "", "");
                break;
              }
            } else if (this.a.W != j) {
              switch (j)
              {
              default: 
                break;
              case 0: 
              case 1: 
              case 2: 
              case 3: 
              case 4: 
                this.a.W = j;
                this.a.a(this.a.jdField_a_of_type_ComTencentWidgetActionSheet, paramView);
                if ((j != 0) && (j != 3)) {
                  break label1322;
                }
                this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(8);
                this.a.a("Clk_def", this.a.F, "");
                if (j == 3) {
                  this.a.a("Clk_distance", this.a.F, "");
                }
                label1246:
                this.a.h();
                if (!this.a.m)
                {
                  this.a.m = true;
                  this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setSelectedTab(0, true);
                }
                if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
                  this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
                }
                if (paramInt != 0) {
                  break label1492;
                }
                this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, 0);
              }
            }
          }
        }
      }
      label1322:
      if (j == 1)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setText(2131367386);
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setText(2131367387);
        paramView = "Clk_lastactivetime";
      }
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.setVisibility(0);
        this.a.a(paramView, "1", this.a.F);
        break label1246;
        if (j == 2)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setText(2131367388);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setText(2131367389);
          paramView = "Clk_mberlevel";
        }
        else
        {
          if (j == 4)
          {
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(0).setText(2131367390);
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetTabBarView.a(1).setText(2131367391);
            paramView = "Clk_jointime";
            continue;
            label1492:
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, -this.a.getResources().getDimensionPixelSize(2131493022));
            break;
            this.a.l();
            break;
            this.a.G = String.format(this.a.G, new Object[] { this.a.k });
            paramView = new Intent(this.a, QQBrowserActivity.class);
            paramView.putExtra("uin", this.a.app.a());
            paramView.putExtra("url", this.a.G);
            this.a.startActivity(paramView);
            break;
            this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new mum(this), 320L);
            break;
            if (!NetworkUtil.e(BaseApplication.getContext()))
            {
              if (!this.a.isResume()) {
                break;
              }
              QQToast.a(this.a, this.a.getString(2131369008), 0).b(this.a.getTitleBarHeight());
              break;
            }
            this.a.a(1L, true);
            TroopUtils.a(this.a, 1, this.a.k, 1, this.a.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback);
            break;
            this.a.b = true;
            this.a.I = "";
            this.a.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter != null) {
              this.a.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity$ListAdapter.a();
            }
            paramView = this.a.F;
            this.a.a("Clk_del", paramView, "");
            break;
          }
          paramView = "";
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\muk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */