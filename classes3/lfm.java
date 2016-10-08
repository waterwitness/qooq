import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lfm
  implements DialogInterface.OnCancelListener
{
  public lfm(DialogActivity paramDialogActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lfm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */