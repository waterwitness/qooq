import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.MessageQueue.IdleHandler;
import android.view.View;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.FSurfaceViewLayout;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.qphone.base.util.QLog;

public class pah
  implements MessageQueue.IdleHandler
{
  public pah(NewFlowCameraActivity paramNewFlowCameraActivity, boolean paramBoolean, SharedPreferences paramSharedPreferences)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean queueIdle()
  {
    if (CameraCompatibleList.d(CameraCompatibleList.b))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.c(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewFSurfaceViewLayout.c();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.h) || (NewFlowCameraActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity))) {
        break label195;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
    }
    for (;;)
    {
      if (NewFlowCameraActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity))
      {
        NewFlowCameraActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, false);
        NewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, 1, false);
      }
      if (QLog.isColorLevel()) {
        QLog.i("PEAK_CAMERA", 2, "Added camera view.");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.h = false;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_is_cancel_from_music_key", true).commit();
      NewFlowCameraActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, false);
      return false;
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover, 2131296494);
      if (localView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraCover.removeView(localView);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.u();
      break;
      label195:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.h) && (!NewFlowCameraActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity)) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a();
      } else {
        QLog.d("PTV.NewFlowCameraActivity", 2, "onResume from select music and do nothing in 1");
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */