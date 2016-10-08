import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BTakePhotoActivity;

public class xze
  implements DialogInterface.OnCancelListener
{
  public xze(C2BTakePhotoActivity paramC2BTakePhotoActivity, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_CooperationC2bC2BTakePhotoActivity.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\xze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */