import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class reh
  implements DialogInterface.OnClickListener
{
  public reh(DatingTopListActivity paramDatingTopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DatingTopListActivity.a(this.a).a((byte)1);
    this.a.b("0X800527E");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\reh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */