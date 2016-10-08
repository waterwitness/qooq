import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.PatternLockUtils;

public class luw
  implements View.OnClickListener
{
  public luw(MainFragment paramMainFragment, Dialog paramDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    QLog.flushLog();
    boolean bool = ((CheckBox)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131298193)).isChecked();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.d = bool;
    SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity(), MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).a(), this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getString(2131369617), "qqsetting_receivemsg_whenexit_key", bool);
    int i = MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).a().e();
    int j = MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).a().a();
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity().getSharedPreferences("unreadcount", 4).edit();
    paramView.putInt("unread", i + j);
    paramView.commit();
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.f();
    MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).a = this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.d;
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.c = true;
    if (QQPlayerService.a())
    {
      paramView = new Intent();
      paramView.setAction("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity().sendBroadcast(paramView);
    }
    PatternLockUtils.d(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity(), MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment).a(), true);
    this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment.getActivity().finish();
    ReportController.b(MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMainFragment), "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "0", "", "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\luw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */