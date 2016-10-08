import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.PopupDialog;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hbj
  implements DialogInterface.OnClickListener
{
  public hbj(PopupDialog paramPopupDialog)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (PopupDialog.a.a != null) {
      PopupDialog.a.a.onClick(paramDialogInterface, paramInt);
    }
    paramDialogInterface.dismiss();
    PopupDialog.a();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\hbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */