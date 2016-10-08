import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.phone.DialogBaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oph
  implements DialogInterface.OnClickListener
{
  public oph(DialogBaseActivity paramDialogBaseActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\oph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */