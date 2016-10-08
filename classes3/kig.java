import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kig
  implements DialogInterface.OnDismissListener
{
  public kig(AddFriendLogicActivity paramAddFriendLogicActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */