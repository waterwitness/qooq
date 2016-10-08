import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class kuq
  implements DialogInterface.OnCancelListener
{
  kuq(kup paramkup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.a.jdField_a_of_type_AndroidAppDialog != null) {
      this.a.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.a.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kuq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */