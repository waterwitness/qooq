import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class wnx
  implements DialogInterface.OnKeyListener
{
  public wnx(QQProgressDialog paramQQProgressDialog, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 84) || (paramInt == 4)) {
      return this.jdField_a_of_type_Boolean;
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\wnx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */