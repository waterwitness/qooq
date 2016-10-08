import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class pch
  implements Runnable
{
  public pch(NewFlowCameraActivity paramNewFlowCameraActivity, int paramInt1, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.isPlaying()) && (NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.pause();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a.setPlayDuration(this.jdField_a_of_type_Int, this.b - this.jdField_a_of_type_Int);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.w("PTV.NewFlowCameraActivity", 2, "Illegal state: onFramesClipChanged");
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */