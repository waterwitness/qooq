import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView;
import com.tencent.mobileqq.filemanager.activity.VerifyPwdView.VerifyPswEvent;
import com.tencent.mobileqq.filemanager.widget.QfileEditBottomBar;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rni
  implements VerifyPwdView.VerifyPswEvent
{
  public rni(FMActivity paramFMActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.c()) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetSendBottomBar.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.b.removeAllViews();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.b.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileEditBottomBar.setTabType(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(16, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131362917));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(15, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131362918));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(17, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131362921));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(18, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131362920));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.a(19, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.getString(2131362922));
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.h) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_Int == 2) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.d >= 15) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.d <= 19)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.d);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView.a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityVerifyPwdView = null;
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetQfileTabBarView.setSelectedTab(16);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */