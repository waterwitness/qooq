import android.os.SystemClock;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.CameraGlFilterListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.ptvfilter.FilterProcessRender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.filter.VideoFilterList;

public class peg
  implements Runnable
{
  public peg(CameraFilterGLView paramCameraFilterGLView, VideoFilterList paramVideoFilterList, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    boolean bool = false;
    long l = SystemClock.elapsedRealtime();
    CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList);
    l = (SystemClock.elapsedRealtime() - l) / 1000L;
    if (QLog.isColorLevel()) {
      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[setVideoFilter_changeFilter=" + l / 1000.0D + "ms]");
    }
    String str;
    if (this.jdField_a_of_type_ComTencentTtpicFilterVideoFilterList != null)
    {
      if (!CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a)
      {
        CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a = true;
        if (CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) != null) {
          CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).h_(CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a);
        }
      }
      str = CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView, this.jdField_a_of_type_Int);
      if (str != null) {
        break label236;
      }
    }
    for (;;)
    {
      if (CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) != null) {
        CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(bool, str);
      }
      do
      {
        return;
        CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a = false;
        if (CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) != null) {
          CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).h_(true);
        }
      } while (CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView) == null);
      CameraFilterGLView.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView).a(false, null);
      return;
      label236:
      bool = true;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\peg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */