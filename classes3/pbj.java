import android.widget.TextView;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pbj
  implements Runnable
{
  public pbj(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean, String paramString)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.c.setText(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.c.setVisibility(0);
        NewFlowCameraActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.c.setText("");
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.c.setVisibility(8);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */