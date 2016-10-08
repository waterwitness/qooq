import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class oiu
  implements DialogInterface.OnDismissListener
{
  public oiu(NewFriendActivity paramNewFriendActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oiu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */