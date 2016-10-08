import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class skl
  implements DialogInterface.OnClickListener
{
  skl(ski paramski)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      this.a.a.b();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\skl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */