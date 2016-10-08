import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class oze
  implements View.OnClickListener
{
  public oze(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.v();
    if (((!QLog.isColorLevel()) || (!FileUtils.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()))) || (FlowCameraConstant.d == 1))
    {
      FlowCameraMqqAction.b("", "0X8005F5B", "0");
      return;
    }
    FlowCameraMqqAction.b("", "0X8005F5B", "1");
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\oze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */