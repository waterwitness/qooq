import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class gwu
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public gwu(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoEnterPage", 2, "DialogInterfaceOnClickListener-->Wrong type.mode=" + this.jdField_a_of_type_Int);
      }
      paramDialogInterface.dismiss();
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
      paramDialogInterface.dismiss();
      if (this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.n()) {
        this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.g(true);
      }
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a().F, this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a().e, 0, new int[] { this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.jdField_a_of_type_ComTencentAvVideoController.a().D });
      this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.d(this.jdField_a_of_type_ComTencentAvUiMultiVideoEnterPageActivity.f);
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gwu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */