import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lwt
  implements DialogInterface.OnClickListener
{
  public lwt(NotificationActivity paramNotificationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NotificationActivity.a(this.a, NotificationActivity.b(this.a));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lwt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */