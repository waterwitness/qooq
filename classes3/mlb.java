import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ShortcutRouterActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class mlb
  implements DialogInterface.OnClickListener
{
  public mlb(ShortcutRouterActivity paramShortcutRouterActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\mlb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */