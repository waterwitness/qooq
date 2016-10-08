import com.tencent.av.VideoController.CameraDataUpdataInterface;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class had
  implements VideoController.CameraDataUpdataInterface
{
  public had(VideoLayerUI paramVideoLayerUI, int paramInt, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a != null) && (this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a.length > this.jdField_a_of_type_Int)) {
      this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI.a[this.jdField_a_of_type_Int], this.jdField_a_of_type_Boolean);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VideoLayerUI", 2, "switchCameraFristData Error : Index = " + this.jdField_a_of_type_Int);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\had.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */