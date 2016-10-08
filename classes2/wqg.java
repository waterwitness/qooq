import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.open.agent.AuthorityActivity;

public class wqg
  implements DialogInterface.OnClickListener
{
  public wqg(AuthorityActivity paramAuthorityActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wqg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */