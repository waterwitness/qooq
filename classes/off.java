import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VipFunCallTipsBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class off
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  public off(VipFunCallTipsBar paramVipFunCallTipsBar)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long < 200L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    paramView = new Intent(VipFunCallTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar), QQBrowserActivity.class);
    paramView.putExtra("hide_left_button", false);
    paramView.putExtra("show_right_close_button", false);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    String str = IndividuationUrlHelper.a(VipFunCallTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar), "call", "mvip.gongneng.anroid.individuation.web");
    VasWebviewUtil.openQQBrowserWithoutAD(VipFunCallTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar), str, 524288L, paramView, false, -1);
    VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "QQVIPFUNCALL", "0X8004D8C", "0X8004D8C", 4, 0, new String[0]);
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    paramView.putInt("funcall_tip_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.jdField_a_of_type_JavaLangString, 4);
    paramView.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\off.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */