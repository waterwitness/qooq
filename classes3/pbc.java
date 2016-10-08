import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.CircleProgress;
import java.util.concurrent.atomic.AtomicInteger;

public class pbc
  implements Runnable
{
  public pbc(NewFlowCameraActivity paramNewFlowCameraActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 3) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.b.get() == 4))
    {
      if (this.a.B)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(this.a.s / (this.a.D * 10));
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(this.a.s / 65);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */