import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;

public class oaq
  implements View.OnClickListener
{
  public oaq(PublicAccountChatPie paramPublicAccountChatPie)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.l = true;
    this.a.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    if (PublicAccountChatPie.a(this.a) != null) {
      PublicAccountChatPie.b(this.a).setVisibility(0);
    }
    if (this.a.e != null) {
      this.a.e.setVisibility(0);
    }
    if (this.a.f != null) {
      this.a.f.setVisibility(0);
    }
    this.a.am();
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountPublicAccountManager.b(this.a.a()) != 0) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC5", "0X8005EC5", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */