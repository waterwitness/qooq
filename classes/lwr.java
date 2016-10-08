import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class lwr
  implements DialogInterface.OnClickListener
{
  public lwr(NotificationActivity paramNotificationActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = "http://aq.qq.com/007?from=andapp&account=" + NotificationActivity.b(this.a);
    Intent localIntent = new Intent(this.a.getActivity(), QQBrowserActivity.class);
    this.a.startActivity(localIntent.putExtra("url", paramDialogInterface));
    this.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\lwr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */