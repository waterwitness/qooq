import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

public class muc
  implements View.OnClickListener
{
  public muc(TroopMemberListActivity paramTroopMemberListActivity, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.c) && (!TroopMemberListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity)))
    {
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 11) && (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.o > 0)) || (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 3))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.getIntent();
        paramView.putExtra("member_uin", "0");
        paramView.putExtra("member_display_name", this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.setResult(-1, paramView);
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.finish();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.J == 11) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.app, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
        }
        return;
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, "该多人聊天@全体成员次数今天已达上限，请改日重试", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a.getHeight());
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.p))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.p, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a.getHeight());
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity, "现在无法发送@All消息", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityTroopMemberListActivity.a.getHeight());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\muc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */