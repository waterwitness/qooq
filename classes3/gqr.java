import android.content.res.Resources;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.av.utils.PSTNNotification;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class gqr
  implements Runnable
{
  public gqr(CallbackWaitingActivityExt paramCallbackWaitingActivityExt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    this.a.c.setText(this.a.getResources().getString(2131364009));
    this.a.a.a(1);
    this.a.a(this.a.b, false, 2130839044);
    this.a.b.setClickable(true);
    if (CallbackWaitingActivityExt.a(this.a) != null)
    {
      CallbackWaitingActivityExt.a(this.a).a().a().b = 2;
      CallbackWaitingActivityExt.a(this.a).a().e(true);
      CallbackWaitingActivityExt.a(this.a).a().c(true);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gqr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */