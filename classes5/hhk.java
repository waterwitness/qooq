import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.biz.common.util.FileChooserHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hhk
  implements DialogInterface.OnCancelListener
{
  public hhk(FileChooserHelper paramFileChooserHelper)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FileChooserHelper.a(this.a);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hhk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */