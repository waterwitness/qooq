import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class lvd
  implements DialogInterface.OnDismissListener
{
  lvd(lvb paramlvb)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.a.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lvd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */