import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.contact.newfriend.SystemRequestInfoView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class ojg
  implements DialogInterface.OnDismissListener
{
  public ojg(SystemRequestInfoView paramSystemRequestInfoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\ojg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */