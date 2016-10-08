import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gwi
  implements Runnable
{
  public gwi(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.jdField_d_of_type_JavaLangString = "QQ电话";
    if (this.a.jdField_d_of_type_Int == 2) {
      if ("CREATE_FROM_CALL".equals(this.a.jdField_a_of_type_ComTencentAvVideoController.a().v))
      {
        this.a.jdField_d_of_type_JavaLangString = "多人电话";
        this.a.jdField_d_of_type_JavaLangString = this.a.a(this.a.jdField_d_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.a.jdField_a_of_type_Long)), this.a.jdField_d_of_type_AndroidWidgetTextView);
      }
    }
    for (;;)
    {
      this.a.jdField_d_of_type_AndroidWidgetTextView.setText(this.a.jdField_d_of_type_JavaLangString);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_d_of_type_JavaLangString);
      MultiVideoCtrlLayerUIBase localMultiVideoCtrlLayerUIBase = this.a;
      localMultiVideoCtrlLayerUIBase.jdField_g_of_type_Int += 1;
      if (this.a.jdField_g_of_type_JavaLangRunnable != null)
      {
        if (this.a.jdField_g_of_type_Int >= 3) {
          break label270;
        }
        this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_g_of_type_JavaLangRunnable, 1000L);
      }
      return;
      this.a.jdField_d_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(3000, String.valueOf(this.a.jdField_a_of_type_Long), null);
      break;
      if (this.a.jdField_d_of_type_Int == 1) {
        this.a.jdField_d_of_type_JavaLangString = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(1, String.valueOf(this.a.jdField_a_of_type_Long), null);
      }
    }
    label270:
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_g_of_type_JavaLangRunnable);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */