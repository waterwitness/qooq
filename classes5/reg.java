import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.dating.DatingHandler;
import com.tencent.mobileqq.dating.DatingTopListActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class reg
  implements DialogInterface.OnClickListener
{
  public reg(DatingTopListActivity paramDatingTopListActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DatingTopListActivity.a(this.a).a((byte)0);
    this.a.b("0X800527D");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\reg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */