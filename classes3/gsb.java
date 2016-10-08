import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jumplightalk.JumpLightalkUtil;
import com.tencent.mobileqq.jumplightalk.QQCallLightalkConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

public class gsb
  implements ActionSheet.OnButtonClickListener
{
  public gsb(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, VideoActionSheet paramVideoActionSheet, int[] paramArrayOfInt, QQCallLightalkConfig paramQQCallLightalkConfig, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    switch (this.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().c, 0);
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().c, 0);
      return;
      if (JumpLightalkUtil.a((Context)this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_JavaLangRefWeakReference.get())) {
        JumpLightalkUtil.a((Context)this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().g, "10001", "com.tencent.mobileqq", "", "0", "0");
      }
      for (;;)
      {
        ReportController.b(null, "CliOper", "", "", "0X8005C87", "0X8005C87", 0, 0, "", "", "", "");
        break;
        JumpLightalkUtil.a((Context)this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentMobileqqJumplightalkQQCallLightalkConfig.h);
      }
      paramView = (Context)this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (paramView != null)
      {
        paramView.startActivity(this.jdField_a_of_type_AndroidContentIntent);
        paramView = new Intent("tencent.video.v2q.insertSystemCall");
        paramView.putExtra("phoneNumber", this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvVideoController.a().g);
        paramView.setPackage(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
        this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(paramView);
      }
      ReportController.b(null, "CliOper", "", "", "0X8005C88", "0X8005C88", 0, 0, "", "", "", "");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gsb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */