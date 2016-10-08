import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import mqq.os.MqqHandler;

public class lwk
  implements DialogInterface.OnClickListener
{
  public lwk(NotificationActivity paramNotificationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ThreadManager.b().post(new lwl(this));
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lwk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */