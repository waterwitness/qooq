import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pcn
  implements Runnable
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  
  public pcn(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramNewFlowCameraActivity.a.jdField_a_of_type_Int;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.y();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pcn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */