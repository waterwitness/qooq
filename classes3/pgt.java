import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.RenMaiQuanTeamListInnerFrame;
import com.tencent.mobileqq.data.CircleGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

class pgt
  implements View.OnClickListener
{
  pgt(pgs parampgs, CircleGroup paramCircleGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putInt("group_uin", this.jdField_a_of_type_ComTencentMobileqqDataCircleGroup.groupId);
    paramView.putString("group_name", this.jdField_a_of_type_ComTencentMobileqqDataCircleGroup.groupName);
    this.jdField_a_of_type_Pgs.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, paramView);
    ReportController.b(this.jdField_a_of_type_Pgs.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Network_circle", "Mutichat_circle_grp", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCircleGroup.groupId), "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pgt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */