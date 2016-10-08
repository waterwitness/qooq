import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.downloadnew.MyAppDialog;

public class wxl
  implements View.OnClickListener
{
  public wxl(MyAppDialog paramMyAppDialog, DialogInterface.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wxl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */