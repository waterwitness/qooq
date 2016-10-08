import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.widgets.ShareResultDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class jjq
  implements View.OnClickListener
{
  public jjq(ShareResultDialog paramShareResultDialog, DialogInterface.OnClickListener paramOnClickListener)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog, -1);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsShareResultDialog.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\jjq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */