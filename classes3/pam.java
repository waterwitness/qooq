import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.remote.logic.RemoteHandleManager;

public class pam
  implements ActionSheet.OnButtonClickListener
{
  public pam(NewFlowCameraActivity paramNewFlowCameraActivity, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = new StringBuilder();
    paramView.append("[Actvity]").append(getClass().getSimpleName()).append(" QQCustomDialog click :").append("立即上传");
    RDMEtraMsgCollector.a().c(paramView.toString());
    NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).dismiss();
    RemoteHandleManager.a().a("cmd.publishVideoMood", this.jdField_a_of_type_AndroidOsBundle, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */