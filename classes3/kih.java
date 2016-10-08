import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class kih
  implements DialogInterface.OnClickListener
{
  public kih(AddFriendLogicActivity paramAddFriendLogicActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1) {
      AddFriendLogicActivity.a(this.a);
    }
    while (paramInt != 0) {
      return;
    }
    this.a.setResult(0);
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */