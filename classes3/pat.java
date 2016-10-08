import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.remote.logic.RemoteHandleManager;

public class pat
  implements ActionSheet.OnButtonClickListener
{
  public pat(NewFlowCameraActivity paramNewFlowCameraActivity, Bundle paramBundle)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    NewFlowCameraActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).dismiss();
    new StringBuilder().append(NewFlowCameraActivity.c()).append("mix_").append(System.currentTimeMillis()).append(".mp4").toString();
    this.jdField_a_of_type_AndroidOsBundle.putString("param.videoPath", NewFlowCameraActivity.d());
    RemoteHandleManager.a().a("cmd.publishVideoMood", this.jdField_a_of_type_AndroidOsBundle, false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */