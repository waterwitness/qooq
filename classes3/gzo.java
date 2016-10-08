import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gzo
  implements DialogInterface.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public gzo(VideoInviteActivity paramVideoInviteActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a == null) {
      return;
    }
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 0: 
      paramDialogInterface.dismiss();
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a != null) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.y();
      }
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.n()) {
        this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a.g(false);
      }
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.d = true;
      paramDialogInterface = this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a;
      if (this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.b) {}
      paramDialogInterface.b(1, false, true);
      this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.f();
      return;
    }
    paramDialogInterface.dismiss();
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.a(true);
    this.jdField_a_of_type_ComTencentAvUiVideoInviteActivity.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */