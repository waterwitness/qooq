import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public final class pjf
  implements DialogInterface.OnClickListener
{
  public pjf(boolean paramBoolean, Context paramContext)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pjf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */