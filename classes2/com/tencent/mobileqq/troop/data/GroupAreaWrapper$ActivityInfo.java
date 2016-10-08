package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class GroupAreaWrapper$ActivityInfo
  extends GroupAreaWrapper.BaseInfo
{
  public GroupAreaWrapper$ActivityInfo(QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.app = paramQQAppInterface;
    this.isShowZeroDistance = false;
  }
  
  protected void initUI(View paramView)
  {
    ((NearbyTroops.ActivityAndTopicViewHolder)paramView.getTag()).a.setTextColor(paramView.getContext().getResources().getColor(2131427952));
    paramView.findViewById(2131299670).setBackgroundResource(2130839399);
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    int i = paramView.getId();
    if (i == 2131299664) {
      ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "ac", "Clk_list", 0, 0, "", "", "", "");
    }
    while (i != 2131299668) {
      return;
    }
    ReportController.b(this.app, "P_CliOper", "Grp_nearby", "", "ac", "Clk_detail", 0, 0, "", "", "", "");
  }
  
  protected void setNumberText(TextView paramTextView)
  {
    paramTextView.setText("" + this.number + "人报名");
    paramTextView.setCompoundDrawablePadding(8);
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(2130839478, 0, 0, 0);
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\data\GroupAreaWrapper$ActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */