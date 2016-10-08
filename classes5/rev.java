import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class rev
  implements DialogInterface.OnClickListener
{
  public rev(DatingTopListActivity paramDatingTopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!this.a.isFinishing()) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */