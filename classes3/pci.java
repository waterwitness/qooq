import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pci
  implements Runnable
{
  public pci(NewFlowCameraActivity paramNewFlowCameraActivity, float paramFloat)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity) != null) {
      NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity).setText(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.b((int)this.jdField_a_of_type_Float));
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */